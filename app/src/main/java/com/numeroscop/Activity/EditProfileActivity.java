package com.numeroscop.Activity;

import androidx.core.content.FileProvider;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;

import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.numeroscop.ApiCall.Model.OtpResBean;
import com.numeroscop.ApiCall.Presenter.UpdateProfilePresenter;
import com.numeroscop.ApiCall.View.IUpdateProfileView;
import com.numeroscop.R;
import com.numeroscop.Utils.BuildConfig;
import com.numeroscop.Utils.FileUtils;
import com.numeroscop.Utils.NetworkCheck;
import com.numeroscop.Utils.PermissionCaller;
import com.numeroscop.Utils.SharedPreferenceData;
import com.numeroscop.databinding.ActivityEditProfileBinding;
import com.numeroscop.databinding.ActivityLoshoGridBinding;

import java.io.File;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class EditProfileActivity extends BaseActivity implements IUpdateProfileView, View.OnClickListener {
    ActivityEditProfileBinding binding;
    private boolean isimageFromGallery = false;
    public Uri uriProfile = null;
    public static final int REQUEST_CAPTURE = 1001;
    public static final int REQUEST_GALLERY = 1002;
    public Uri captureMediaFile = null;
    private SharedPreferenceData sharedPreferenceData;
    UpdateProfilePresenter updateProfilePresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_profile);

        updateProfilePresenter = new UpdateProfilePresenter();
        updateProfilePresenter.setView(this);

        sharedPreferenceData = new SharedPreferenceData(this);


        init();
    }


    private void init() {

        binding.imgEditProfile.setOnClickListener(this);
        binding.txtUpdate.setOnClickListener(this);
        binding.imgBack.setOnClickListener(this);

        binding.edtUserName.setText(sharedPreferenceData.getUser_name());
        binding.edtEmail.setText(sharedPreferenceData.getEmail());
        binding.edtMobile.setText(sharedPreferenceData.getMobile_no());
        binding.edtAddress.setText(sharedPreferenceData.getADDRESS());
        binding.edtBusiness.setText(sharedPreferenceData.getBUSINESS_NAME());
       // binding.edtReferal.setText(sharedPreferenceData.getREFERAL_CODE());

      String full_url=  "https://androidhiker.com/numerology/public";
        if (!TextUtils.isEmpty(sharedPreferenceData.getBUSINESS_LOGO())) {
            Glide.with(this)
                    .load(full_url+sharedPreferenceData.getBUSINESS_LOGO())
                    .placeholder(R.drawable.profile)
                    .error(R.drawable.profile)
                    .into(binding.imgProfile);

        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBack:
                finish();
                break;
            case R.id.txtUpdate:
                if (binding.edtUserName.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Please enter user name", Toast.LENGTH_SHORT).show();
                } else if (binding.edtMobile.getText().toString().isEmpty() && binding.edtMobile.getText().length() != 10) {
                    Toast.makeText(this, "Please enter mobile number", Toast.LENGTH_SHORT).show();
                } else if (binding.edtEmail.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Please enter email ", Toast.LENGTH_SHORT).show();
                } else if (binding.edtAddress.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Please enter address", Toast.LENGTH_SHORT).show();
                } else if (binding.edtBusiness.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Please enter your business name", Toast.LENGTH_SHORT).show();
                } else if (NetworkCheck.isConnected(this)) {
                    MultipartBody.Part user_image = null;
                    if (uriProfile != null) {
                        if (isimageFromGallery) {
                            String selectedPath = FileUtils.getPath(this, uriProfile);
                            File file = new File(selectedPath);
                            RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), file);
                            user_image = MultipartBody.Part.createFormData("business_logo", file.getName(), requestFile);
                        } else {
                            String fileName = new File(uriProfile.getPath()).getName();
                            File actualFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), new File(uriProfile.getPath()).getName());
                            if (actualFile != null) {
                                user_image = MultipartBody.Part.createFormData("business_logo", fileName, RequestBody.create(MediaType.parse("multipart/form-data"), actualFile));
                            } else {
                                user_image = MultipartBody.Part.createFormData("business_logo", "", RequestBody.create(MediaType.parse("multipart/form-data"), ""));
                            }
                        }
                    }

                    if (NetworkCheck.isConnected(this)) {
                        updateProfilePresenter.GetUpdateProfileCall(this, new SharedPreferenceData(this).getACCESS_TOKEN(), binding.edtUserName.getText().toString().trim(),
                                binding.edtMobile.getText().toString().trim(), binding.edtEmail.getText().toString().trim(), binding.edtAddress.getText().toString().trim(),
                                binding.edtBusiness.getText().toString().trim(),"", user_image);
                    }
                } else {
                    Toast.makeText(this, getResources().getString(R.string.please_check_your_internet_connection), Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.imgEditProfile:
                getImage();
                break;
            default:
                break;
        }
    }


    public void getImage() {
        final BottomSheetDialog dialog = new BottomSheetDialog(this);
        dialog.setCancelable(true);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.choose_photo_dialog);

        TextView textCamera = dialog.findViewById(R.id.textCamera);
        TextView textGallery = dialog.findViewById(R.id.textGallery);

        WindowManager.LayoutParams windowManager = new WindowManager.LayoutParams();
        windowManager.copyFrom(dialog.getWindow().getAttributes());
        windowManager.height = WindowManager.LayoutParams.WRAP_CONTENT;
        windowManager.width = WindowManager.LayoutParams.MATCH_PARENT;
        windowManager.gravity = Gravity.CENTER_HORIZONTAL;
        dialog.getWindow().setAttributes(windowManager);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        textGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImageFromGallery(EditProfileActivity.this);
                dialog.dismiss();
            }
        });

        textCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImageFromCamera(EditProfileActivity.this);
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

            @Override
            public void onCancel(DialogInterface dialog) {
                dialog.dismiss();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CAPTURE:
                    if (captureMediaFile != null) {
                        isimageFromGallery = false;
                        uriProfile = captureMediaFile;
                        binding.imgProfile.setImageURI(null);
                        binding.imgProfile.setImageURI(uriProfile);
                    }
                    break;
                case REQUEST_GALLERY:
                    if (data != null) {
                        isimageFromGallery = true;
                        uriProfile = data.getData();
                        binding.imgProfile.setImageURI(null);
                        binding.imgProfile.setImageURI(uriProfile);
                    }
                    break;
                default:
                    break;

            }
        }
    }

    public void pickImageFromGallery(Activity activity) {
        if (!PermissionCaller.getInstance(activity).isListOfPermission(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA}, REQUEST_GALLERY))
            return;
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, getString(R.string.select_image)), REQUEST_GALLERY);
    }

    public void pickImageFromCamera(Activity activity) {
        if (!PermissionCaller.getInstance(activity).isListOfPermission(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA}, REQUEST_CAPTURE))
            return;

        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);


        try {
            int random = (int) (Math.random() * (1000 - 0 + 1) + 0);
            File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            path.mkdir();
            String photoFilePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/images" + random + ".jpg";
            File imageFile = new File(photoFilePath);

            captureMediaFile = FileProvider.getUriForFile(activity, BuildConfig.APPLICATION_ID + ".provider", imageFile);


            intent.putExtra(MediaStore.EXTRA_OUTPUT, captureMediaFile);

            List<ResolveInfo> resInfoList = activity.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
            for (ResolveInfo resolveInfo : resInfoList) {
                String packageName = resolveInfo.activityInfo.packageName;
                activity.grantUriPermission(packageName, captureMediaFile, Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        startActivityForResult(intent, REQUEST_CAPTURE);
    }


    @Override
    public Context getContext() {
        return this;
    }


    @Override
    public void onUpdateProfileSuccess(OtpResBean item) {
        if (item.isStatus()) {
            Toast.makeText(this, item.getMessage(), Toast.LENGTH_SHORT).show();
            item.setAccessToken(sharedPreferenceData.getACCESS_TOKEN());
            new SharedPreferenceData(this).SavedLoginData(item);
            finish();
        } else {
            Toast.makeText(this, item.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}