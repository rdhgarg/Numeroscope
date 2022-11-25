package com.numeroscop.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.app.Dialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.numeroscop.Adapter.ActionAdapter;
import com.numeroscop.Adapter.AvoidProfessionAdapter;
import com.numeroscop.Adapter.ConductorAdapter;
import com.numeroscop.Adapter.DriverAdapter;
import com.numeroscop.Adapter.EmotionalAdapter;
import com.numeroscop.Adapter.GenerateNumberAdapter;
import com.numeroscop.Adapter.IntellectualAdapter;
import com.numeroscop.Adapter.LuckyProfessionAdapter;
import com.numeroscop.Adapter.MentalAdapter;
import com.numeroscop.Adapter.MissingNumberReportAdapter;
import com.numeroscop.Adapter.NeutralProfessionAdapter;
import com.numeroscop.Adapter.PersonalYearAdapter;
import com.numeroscop.Adapter.PlaneGraphAdapter;
import com.numeroscop.Adapter.PracticalAdapter;
import com.numeroscop.Adapter.RemediesAdapter;
import com.numeroscop.Adapter.RepeatNoAdapter;
import com.numeroscop.Adapter.SingleRepeatAdapter;
import com.numeroscop.Adapter.SpiritualAdapter;
import com.numeroscop.Adapter.ThoughtAdapter;
import com.numeroscop.Adapter.WillAdapter;
import com.numeroscop.ApiCall.Model.GetNumberResBean;
import com.numeroscop.ApiCall.Model.GetReportResBean;
import com.numeroscop.ApiCall.Model.SaveSolutionResBean;
import com.numeroscop.ApiCall.Presenter.GetReportPresenter;
import com.numeroscop.ApiCall.Presenter.SolutionPresenPresenter;
import com.numeroscop.ApiCall.View.IGetReportView;
import com.numeroscop.ApiCall.View.IGetSolutionView;
import com.numeroscop.Model.NumberModel;
import com.numeroscop.R;

import com.numeroscop.Utils.NetworkCheck;
import com.numeroscop.Utils.SharedPreferenceData;
import com.numeroscop.databinding.ActivityGenerateReportBinding;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class GenerateReportActivity extends BaseActivity implements View.OnClickListener, IGetReportView , IGetSolutionView {
    ActivityGenerateReportBinding binding;
    SharedPreferenceData ProfileData;
    String  strBirth="",strApiBirth="",strName = "",strphone="",strGender = "",strReportID ="";
    GetReportPresenter getReportPresenter;
    SolutionPresenPresenter solutionPresenPresenter;
    GenerateNumberAdapter numberAdapter;
    LuckyProfessionAdapter luckyProfessionAdapter;
    NeutralProfessionAdapter neutralProfessionAdapter;
    AvoidProfessionAdapter avoidProfessionAdapter;
    RemediesAdapter remediesAdapter;
    MissingNumberReportAdapter customAdapter;
    PersonalYearAdapter personalYearAdapter;
    PlaneGraphAdapter planeGraphAdapter;
    RepeatNoAdapter repeatNoAdapter;
    SingleRepeatAdapter singleRepeatAdapter;
    IntellectualAdapter intellectualAdapter;
    SpiritualAdapter spiritualAdapter;
    ThoughtAdapter thoughtAdapter;
    WillAdapter willAdapter;
    ActionAdapter actionAdapter;
    MentalAdapter mentalAdapter;
    EmotionalAdapter emotionalAdapter;
    PracticalAdapter practicalAdapter;
    DriverAdapter driverAdapter;
    ConductorAdapter conductorAdapter;
    ArrayList<String> thoughtList = new ArrayList<>();
    ArrayList<String> willList = new ArrayList<>();
    ArrayList<String> actionList = new ArrayList<>();
    ArrayList<String> mentalList = new ArrayList<>();
    ArrayList<String> emotionalList = new ArrayList<>();
    ArrayList<String> practicalList = new ArrayList<>();
    ArrayList<String> goldenlist = new ArrayList<>();
    ArrayList<String> silverlist = new ArrayList<>();
    ArrayList<NumberModel> list = new ArrayList<>();
    ArrayList<NumberModel> personalgraphlist = new ArrayList<>();
    ArrayList<NumberModel> mainNumberlist = new ArrayList<>();
    ArrayList<GetReportResBean.MissigNoReportDTO> missingNumberlist = new ArrayList<>();
    ArrayList<GetReportResBean.LuckyProffessionDTO> luckyProfessionlist = new ArrayList<>();
    ArrayList<GetReportResBean.NaturalProffessionDTO> neutralProfessionlist = new ArrayList<>();
    ArrayList<GetReportResBean.AvoidProffessionDTO> avoidProfessionlist = new ArrayList<>();
    ArrayList<GetReportResBean.RemediesDTO> remediesList = new ArrayList<>();
    ArrayList<GetReportResBean.PersonalyearReportDTO> personalYearlist = new ArrayList<>();
    ArrayList<GetReportResBean.RepeatNoDTO> repeatNumberlist = new ArrayList<>();
    ArrayList<GetReportResBean.SingleNoReportDTO> singleNumberlist = new ArrayList<>();
    GetNumberResBean.Data numberResBean;
    public static final int REQUEST_CODE = 199;
    ArrayAdapter adapter;
    String lng ="English";
    private static final String[] PERMISSIONS = {android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private String filepath ="";
    String strEngpdf ="";
    String strHindipdf ="";
    private boolean isNeedToOpenPDF = false;


    private static boolean hasPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_generate_report);
        if (getIntent().getSerializableExtra("tabelData")!=null) {
            numberResBean = (GetNumberResBean.Data) getIntent().getSerializableExtra("tabelData");
        }
        getReportPresenter = new GetReportPresenter();
        solutionPresenPresenter = new SolutionPresenPresenter();
        getReportPresenter.setView(this);
        solutionPresenPresenter.setView(this);
        binding.layout.setVisibility(View.GONE);

        ActivityCompat.requestPermissions(GenerateReportActivity.this, PERMISSIONS, 112);
        Bundle extras = getIntent().getExtras();




        /*binding.cvShowReportHindi.setOnClickListener(this);
        binding.cvShowReportEnglish.setOnClickListener(this);*/



        binding.cvDropUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScrollUp();
            }
        });


        binding.cvGenerateReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                solutionPopUp();

            }
        });

        strBirth = extras.getString("showbirth");
        strApiBirth = extras.getString("apibirth");
        strName = extras.getString("name");
        strphone  = extras.getString("phone");
        strGender = extras.getString("gender");
        strReportID = extras.getString("report_id");

        binding.txtName.setText(strName);
        binding.txtMale.setText(strGender);
        binding.textdob.setText(strBirth);


        list.add(new NumberModel("4"));
        list.add(new NumberModel("9"));
        list.add(new NumberModel("2"));
        list.add(new NumberModel("3"));
        list.add(new NumberModel("5"));
        list.add(new NumberModel("7"));
        list.add(new NumberModel("8"));
        list.add(new NumberModel("1"));
        list.add(new NumberModel("6"));

        mainNumberlist.add(new NumberModel("4"));
        mainNumberlist.add(new NumberModel("9"));
        mainNumberlist.add(new NumberModel("2"));
        mainNumberlist.add(new NumberModel("3"));
        mainNumberlist.add(new NumberModel("5"));
        mainNumberlist.add(new NumberModel("7"));
        mainNumberlist.add(new NumberModel("8"));
        mainNumberlist.add(new NumberModel("1"));
        mainNumberlist.add(new NumberModel("6"));

        if (numberResBean!=null) {
            numberAdapter = new GenerateNumberAdapter(list, numberResBean, this);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, RecyclerView.VERTICAL, false);
            binding.rvNumber.setLayoutManager(gridLayoutManager);
            binding.rvNumber.setAdapter(numberAdapter);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); //
        binding.recycleMissingReport.setLayoutManager(linearLayoutManager);

        customAdapter = new MissingNumberReportAdapter(GenerateReportActivity.this, missingNumberlist);
        binding.recycleMissingReport.setAdapter(customAdapter); // set the Adapter to RecyclerView



        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager2.setOrientation(LinearLayoutManager.VERTICAL); //
        binding.recycleLuckyProfession.setLayoutManager(linearLayoutManager2);

        luckyProfessionAdapter = new LuckyProfessionAdapter(GenerateReportActivity.this, luckyProfessionlist);
        binding.recycleLuckyProfession.setAdapter(luckyProfessionAdapter); // set the Adapter to RecyclerView

        LinearLayoutManager managerNeutralProf = new LinearLayoutManager(getApplicationContext());
        managerNeutralProf.setOrientation(LinearLayoutManager.VERTICAL); //
        binding.recycleNeutralProfession.setLayoutManager(managerNeutralProf);

        neutralProfessionAdapter = new NeutralProfessionAdapter(GenerateReportActivity.this, neutralProfessionlist);
        binding.recycleNeutralProfession.setAdapter(neutralProfessionAdapter);


        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager3.setOrientation(LinearLayoutManager.VERTICAL); //
        binding.recycleAvoidProfession.setLayoutManager(linearLayoutManager3);

        avoidProfessionAdapter = new AvoidProfessionAdapter(GenerateReportActivity.this, avoidProfessionlist);
        binding.recycleAvoidProfession.setAdapter(avoidProfessionAdapter); // set the Adapter to RecyclerView


        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager4.setOrientation(LinearLayoutManager.VERTICAL); //
        binding.recyclePersonalYear.setLayoutManager(linearLayoutManager4);

        personalYearAdapter = new PersonalYearAdapter(GenerateReportActivity.this, personalYearlist);
        binding.recyclePersonalYear.setAdapter(personalYearAdapter); // set the Adapter to RecyclerView

        personalgraphlist.add(new NumberModel("4"));
        personalgraphlist.add(new NumberModel("9"));
        personalgraphlist.add(new NumberModel("2"));
        personalgraphlist.add(new NumberModel("3"));
        personalgraphlist.add(new NumberModel("5"));
        personalgraphlist.add(new NumberModel("7"));
        personalgraphlist.add(new NumberModel("8"));
        personalgraphlist.add(new NumberModel("1"));
        personalgraphlist.add(new NumberModel("6"));

        planeGraphAdapter = new PlaneGraphAdapter(GenerateReportActivity.this, personalgraphlist);
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(this,3, RecyclerView.VERTICAL,false);
        binding.rvPlane.setLayoutManager(gridLayoutManager1);
        binding.rvPlane.setAdapter(planeGraphAdapter);

        LinearLayoutManager linearLayoutManager5 = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager5.setOrientation(LinearLayoutManager.VERTICAL); //
        binding.rvRepeatNo.setLayoutManager(linearLayoutManager5);

        repeatNoAdapter = new RepeatNoAdapter(GenerateReportActivity.this, repeatNumberlist,lng);
        binding.rvRepeatNo.setAdapter(repeatNoAdapter); // set the Adapter to RecyclerView

        LinearLayoutManager linearLayoutManager6 = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager6.setOrientation(LinearLayoutManager.VERTICAL); //
        binding.rvSingleRepeatNumber.setLayoutManager(linearLayoutManager6);

        singleRepeatAdapter = new SingleRepeatAdapter(GenerateReportActivity.this, singleNumberlist,lng);
        binding.rvSingleRepeatNumber.setAdapter(singleRepeatAdapter); // set the Adapter to RecyclerView

        ProfileData = new SharedPreferenceData(this);

        if(NetworkCheck.isConnected(this)) {
            getReportPresenter.GetReportCall(this,ProfileData.getACCESS_TOKEN(),strName,
                    strphone,strApiBirth,strGender,strReportID, "0");
        }

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  finish();
              }
        });

        binding.cvSelectPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GenerateReportActivity.this,PlanListActivity.class);
                startActivityForResult(intent , REQUEST_CODE);
            }
        });

        setRemediesAdapter(false);
    }

    private void setRemediesAdapter(boolean isHindi){
        LinearLayoutManager linearLayoutManager7 = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager7.setOrientation(LinearLayoutManager.VERTICAL); //
        binding.recyRemedies.setLayoutManager(linearLayoutManager7);

        remediesAdapter = new RemediesAdapter(GenerateReportActivity.this, remediesList, isHindi);
        binding.recyRemedies.setAdapter(remediesAdapter);
    }



    @Override
    public void onGetReportSuccess(GetReportResBean item) {
        if(item.getStatus()){
            binding.layout.setVisibility(View.VISIBLE);
            strEngpdf = item.getPdfPath();
            strHindipdf = item.getPdfPathHindi();

            if (isNeedToOpenPDF){
                isNeedToOpenPDF = false;
                if (lng.equalsIgnoreCase("English")) {
                    Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(strEngpdf));
                    startActivity(intent1);
                }else {
                    Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(strHindipdf));
                    startActivity(intent1);
                }
            }else {
                if(item.getIsReports()== 1){
                    binding.layout.setVisibility(View.VISIBLE);
                    binding.layoutPurchaseButton.setVisibility(View.GONE);
                }else{
                    binding.layout.setVisibility(View.GONE);
                    binding.layoutPurchaseButton.setVisibility(View.VISIBLE);
                }

                if(item.getMissigNoReport()!=null){
                    missingNumberlist.addAll(item.getMissigNoReport());
                    customAdapter.notifyDataSetChanged();
                }


                if(item.getLuckyProffession()!=null){
                    luckyProfessionlist.addAll(item.getLuckyProffession());
                    luckyProfessionAdapter.notifyDataSetChanged();
                }

                if (item.getNaturalProffession()!=null){
                    neutralProfessionlist.addAll(item.getNaturalProffession());
                    neutralProfessionAdapter.notifyDataSetChanged();
                }


                if(item.getAvoidProffession()!=null){
                    avoidProfessionlist.addAll(item.getAvoidProffession());
                    avoidProfessionAdapter.notifyDataSetChanged();
                }

                if (item.getRemedies()!=null){
                    remediesList.addAll(item.getRemedies());
                    remediesAdapter.notifyDataSetChanged();
                }


                if(item.getPersonalyearReport()!= null){
                    personalYearlist.addAll(item.getPersonalyearReport());
                    personalYearAdapter.notifyDataSetChanged();
                }


                if(item.getRepeatNo()!= null){
                    repeatNumberlist.addAll(item.getRepeatNo());
                    repeatNoAdapter.notifyDataSetChanged();
                }

                if(item.getSingleNoReport()!= null){
                    singleNumberlist.addAll(item.getSingleNoReport());
                    singleRepeatAdapter.notifyDataSetChanged();
                }


                if(item.getThoughtarray()!= null){
                    thoughtList.addAll(item.getThoughtarray());
                    //Thought Adapter
                    thoughtAdapter = new ThoughtAdapter(GenerateReportActivity.this, mainNumberlist,thoughtList);
                    GridLayoutManager gridLayoutManager4 = new GridLayoutManager(this,3, RecyclerView.VERTICAL,false);
                    binding.rvThought.setLayoutManager(gridLayoutManager4);
                    binding.rvThought.setAdapter(thoughtAdapter);

                }


                if(item.getWillarray()!= null){
                    willList.addAll(item.getWillarray());
                    //Will Adapter
                    willAdapter = new WillAdapter(GenerateReportActivity.this, mainNumberlist,willList);
                    GridLayoutManager gridLayoutManager4 = new GridLayoutManager(this,3, RecyclerView.VERTICAL,false);
                    binding.rvWill.setLayoutManager(gridLayoutManager4);
                    binding.rvWill.setAdapter(willAdapter);
                }

//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                binding.textNameRemedyDetails.setText(Html.fromHtml(beforeHtml+item.getData().getNameNo()+afterHtml,Html.FROM_HTML_MODE_LEGACY));
//            }
//            else
//            {
//                binding.textNameRemedyDetails.setText(Html.fromHtml(beforeHtml+item.getData().getNameNo()+afterHtml));
//            }


                String text = String.format(getResources().getString(R.string.namely), item.getData().getNameNo().toString());
                binding.textNameRemedyDetails.setText(text);



                if(item.getActionarray()!= null){
                    actionList.addAll(item.getActionarray());
                    //Will Adapter
                    actionAdapter = new ActionAdapter(GenerateReportActivity.this, mainNumberlist,actionList);
                    GridLayoutManager gridLayoutManager4 = new GridLayoutManager(this,3, RecyclerView.VERTICAL,false);
                    binding.rvAction.setLayoutManager(gridLayoutManager4);
                    binding.rvAction.setAdapter(actionAdapter);
                }



                if(item.getMentalarray()!= null){
                    mentalList.addAll(item.getMentalarray());
                    //Mental Adapter
                    mentalAdapter = new MentalAdapter(GenerateReportActivity.this, mainNumberlist,mentalList);
                    GridLayoutManager gridLayoutManager4 = new GridLayoutManager(this,3, RecyclerView.VERTICAL,false);
                    binding.rvMental.setLayoutManager(gridLayoutManager4);
                    binding.rvMental.setAdapter(mentalAdapter);
                }


                if(item.getEmotionalarray()!= null){
                    emotionalList.addAll(item.getEmotionalarray());
                    //Mental Adapter
                    emotionalAdapter = new EmotionalAdapter(GenerateReportActivity.this, mainNumberlist,emotionalList);
                    GridLayoutManager gridLayoutManager4 = new GridLayoutManager(this,3, RecyclerView.VERTICAL,false);
                    binding.rvEmotional.setLayoutManager(gridLayoutManager4);
                    binding.rvEmotional.setAdapter(emotionalAdapter);
                }



                if(item.getPracticalarray()!= null){
                    practicalList.addAll(item.getPracticalarray());
                    //practical Adapter
                    practicalAdapter = new PracticalAdapter(GenerateReportActivity.this, mainNumberlist,practicalList);
                    GridLayoutManager gridLayoutManager4 = new GridLayoutManager(this,3, RecyclerView.VERTICAL,false);
                    binding.rvPractical.setLayoutManager(gridLayoutManager4);
                    binding.rvPractical.setAdapter(practicalAdapter);
                }


                if(!TextUtils.isEmpty(item.getDriverReport().getDriverNo().toString())){

                    //driver Adapter
                    driverAdapter = new DriverAdapter(GenerateReportActivity.this, mainNumberlist,item.getDriverReport().getDriverNo().toString());
                    GridLayoutManager gridLayoutManagerDriver = new GridLayoutManager(this,3, RecyclerView.VERTICAL,false);
                    binding.rvDriver.setLayoutManager(gridLayoutManagerDriver);
                    binding.rvDriver.setAdapter(driverAdapter);
                }


                if(!TextUtils.isEmpty(item.getConductorReport().getConductorNo().toString())){

                    //conductor Adapter
                    conductorAdapter = new ConductorAdapter(GenerateReportActivity.this, mainNumberlist,item.getConductorReport().getConductorNo().toString());
                    GridLayoutManager gridLayoutManagerCond = new GridLayoutManager(this,3, RecyclerView.VERTICAL,false);
                    binding.rvConductor.setLayoutManager(gridLayoutManagerCond);
                    binding.rvConductor.setAdapter(conductorAdapter);
                }


                if(item.getSuccess1array()!= null){
                    goldenlist.addAll(item.getSuccess1array());
                    //Intellectual Recycle
                    intellectualAdapter = new IntellectualAdapter(GenerateReportActivity.this,mainNumberlist, goldenlist);
                    GridLayoutManager gridLayoutManager2 = new GridLayoutManager(this,3, RecyclerView.VERTICAL,false);
                    binding.rvIntellectual.setLayoutManager(gridLayoutManager2);
                    binding.rvIntellectual.setAdapter(intellectualAdapter);
                }


                if(item.getSuccess2array()!= null){

                    silverlist.addAll(item.getSuccess2array());

                    //Spiritual Recycle
                    spiritualAdapter = new SpiritualAdapter(GenerateReportActivity.this,mainNumberlist ,silverlist);
                    GridLayoutManager gridLayoutManager3 = new GridLayoutManager(this,3, RecyclerView.VERTICAL,false);
                    binding.rvSpiritual.setLayoutManager(gridLayoutManager3);
                    binding.rvSpiritual.setAdapter(spiritualAdapter);
                }


                binding.textIntellectualValue.setText(""+item.getPlane().getSuccess1()+"%");
                binding.textSpiritual.setText(""+item.getPlane().getSuccess2()+"%");
                binding.textAction.setText(""+item.getPlane().getAction()+"%");
                binding.textEmotional.setText(""+item.getPlane().getEmotional()+"%");
                binding.textMental.setText(""+item.getPlane().getMental()+"%");
                binding.textPractical.setText(""+item.getPlane().getPractical()+"%");
                binding.textWill.setText(""+item.getPlane().getWill()+"%");
                binding.textThoughtValue.setText(""+item.getPlane().getThought()+"%");
                binding.textDriverNo.setText(getResources().getString(R.string.your_driver_is)+item.getDriverReport().getDriverNo());

                if (item.getPlane().getSuccess1()==0){
                    binding.layGoldenPlan.setVisibility(View.GONE);
                }
                if (item.getPlane().getSuccess2()==0){
                    binding.layPropertyPlan.setVisibility(View.GONE);
                }
                if (item.getPlane().getThought()==0){
                    binding.layThoughtPlan.setVisibility(View.GONE);
                }
                if (item.getPlane().getWill()==0){
                    binding.layWillPlan.setVisibility(View.GONE);
                }
                if (item.getPlane().getAction()==0){
                    binding.layActionPlan.setVisibility(View.GONE);
                }
                if (item.getPlane().getMental()==0){
                    binding.layMentalPlan.setVisibility(View.GONE);
                }
                if (item.getPlane().getEmotional()==0){
                    binding.layEmotionalPlan.setVisibility(View.GONE);
                }
                if (item.getPlane().getPractical()==0){
                    binding.layPracticalPlan.setVisibility(View.GONE);
                }

                binding.textConductorNo.setText(getResources().getString(R.string.your_conductor_is)+item.getConductorReport().getConductorNo().toString());




                binding.textDriverValue.setText(""+item.getDriverReport().getDriverNo());
                binding.txtConductor.setText(""+item.getConductorReport().getConductorNo());
                //   binding.textLuckFactor.setText(""+item.getDriverReport().getDriverNo());
                binding.textKuaNumber.setText(""+item.getData().getKuwaNo());
                binding.textNameNumber.setText(""+item.getData().getNameNo());






                String strColor = "";
                for (int i = 0 ;i<item.getLuckyColors().size();i++){
                    if (i==0) {
                        strColor = item.getLuckyColors().get(i).toString();
                    }
                    else {
                        strColor = item.getLuckyColors().get(i)+"\n"+strColor;
                    }
                }

                binding.textLuckyColor.setText(strColor);
                binding.textNeutralColor.setText(item.getNaturalColors().replace(", ","\n" ));

                String strAvoidColor = item.getAvoidColors();
                binding.textAvoidColor.setText(strAvoidColor.replace(", ","\n" ));

                binding.textLuckyDays.setText(item.getLuckyDays().replace(", ","\n" ));
                binding.textNeutralDays.setText(item.getNaturalDays().replace(", ","\n" ));
                binding.textAvoidDays.setText(item.getAvoidDays().replace(", ","\n" ));
                binding.textAMobileReport.setText(""+item.getMobileReport().getA());
                //  binding.textAMobileReport.setText(Html.fromHtml(""+item.getMobileReport().getA()));
                binding.textBMobileReport.setText(item.getMobileReport().getB());
                binding.textCMobileReport.setText(item.getMobileReport().getC());
                binding.textDMobileReport.setText(item.getMobileReport().getD());
                binding.textEMobileReport.setText(item.getMobileReport().getE());
                binding.textFMobileReport.setText(item.getMobileReport().getF());
                binding.textGMobileReport.setText(item.getMobileReport().getG());
                binding.textHMobileReport.setText(item.getMobileReport().getH());

                binding.textAName.setText(""+item.getNameReport().getA());
                binding.textBName.setText(item.getNameReport().getB());
                binding.textCName.setText(item.getNameReport().getC());
                binding.textDName.setText(item.getNameReport().getD());
                binding.textEName.setText(item.getNameReport().getE());
                binding.textFName.setText(item.getNameReport().getF());
                binding.textGName.setText(item.getNameReport().getG());
                binding.textHName.setText(item.getNameReport().getH());


                binding.textIntellectual.setText(item.getPlanreport().getSuccess1());
                binding.SpiritualPlane.setText(item.getPlanreport().getSuccess2());
                binding.ThoughtPlane.setText(item.getPlanreport().getThought());
                binding.willPlane.setText(item.getPlanreport().getWill());
                binding.actionPlane.setText(item.getPlanreport().getAction());
                binding.mentalPlane.setText(item.getPlanreport().getMental());
                binding.emotionalPlane.setText(item.getPlanreport().getEmotional());
                binding.practicalPlane.setText(item.getPlanreport().getPractical());
           /* binding.ThoughtPlaneDescription.setText(Html.fromHtml(item.getPlanreport().getThoughtDescription()));
            binding.willPlaneDescription.setText(Html.fromHtml(item.getPlanreport().getWillDescription()));
            binding.actionPlaneDescription.setText(Html.fromHtml(item.getPlanreport().getActionDescription()));
            binding.mentalPlaneDescription.setText(Html.fromHtml(item.getPlanreport().getMentalDescription()));
            binding.emotionalPlaneDescription.setText(Html.fromHtml(item.getPlanreport().getEmotionalDescription()));
            binding.practicalPlaneDescription.setText(Html.fromHtml(item.getPlanreport().getPracticalDescription()));
            binding.textIntellectualDescription.setText(Html.fromHtml(item.getPlanreport().getSuccess1Description()));
            binding.SpiritualPlaneDescription.setText(Html.fromHtml(item.getPlanreport().getSuccess2Description()));*/
                binding.ThoughtPlaneDescription.setVisibility(View.GONE);
                binding.willPlaneDescription.setVisibility(View.GONE);
                binding.actionPlaneDescription.setVisibility(View.GONE);
                binding.mentalPlaneDescription.setVisibility(View.GONE);
                binding.emotionalPlaneDescription.setVisibility(View.GONE);
                binding.practicalPlaneDescription.setVisibility(View.GONE);
                binding.textIntellectualDescription.setVisibility(View.GONE);
                binding.SpiritualPlaneDescription.setVisibility(View.GONE);
            }
        }else{
            binding.layout.setVisibility(View.GONE);
            Toast.makeText(this, item.getMessage(), Toast.LENGTH_SHORT).show();
        }


        ArrayList<String>spinnerArray = new ArrayList<>();
        spinnerArray.add("English");
        spinnerArray.add("Hindi");


        adapter = new ArrayAdapter(this,R.layout.layout_spinner_textview,spinnerArray){
            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view =  super.getDropDownView(position, convertView, parent);

                TextView text = (TextView)view.findViewById(R.id.txtLang);
                return view;
            }
        };


        binding.SpinnerLang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 lng = spinnerArray.get(i);
                Log.e("LNG",lng);

                if(lng.equalsIgnoreCase("English")){
                    setDataEng(item);
                }else{
                    setDataHindi(item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.SpinnerLang.setAdapter(adapter);
    }

    private void setDataHindi(GetReportResBean item){


        if(item.getDriverReport().getDescriptionHindi() !=null){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                binding.textDriverDesc.setText(Html.fromHtml(item.getDriverReport().getDescriptionHindi(), Html.FROM_HTML_MODE_LEGACY));
            } else {
                binding.textDriverDesc.setText(Html.fromHtml(item.getDriverReport().getDescriptionHindi()));
            }
        }


        if(item.getConductorReport().getDescriptionHindi()!=null){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                binding.textConductorDesc.setText(Html.fromHtml(item.getConductorReport().getDescriptionHindi(), Html.FROM_HTML_MODE_LEGACY));
            } else {
                binding.textConductorDesc.setText(Html.fromHtml(item.getConductorReport().getDescriptionHindi()));
            }

        }


        if (item.getKarmicNo()!= null && item.getKarmicNo().getDetailHindi()!=null){
            binding.textKarmic.setVisibility(View.VISIBLE);
            binding.textkarmicValue.setVisibility(View.VISIBLE);
            binding.textkarmicValue.setText(Html.fromHtml(""+item.getKarmicNo().getDetailHindi()));
        }else {
            binding.textKarmic.setVisibility(View.GONE);
            binding.textkarmicValue.setVisibility(View.GONE);
        }


        if (item.getPunchLine() != null && item.getPunchLine().getLineHindi()!=null ){

            binding.textPunchLine.setVisibility(View.VISIBLE);
            binding.textPunchLineValue.setVisibility(View.VISIBLE);
            binding.textPunchLineValue.setText(""+item.getPunchLine().getLineHindi());
        }else {
            binding.textPunchLine.setVisibility(View.GONE);
            binding.textPunchLineValue.setVisibility(View.GONE);
        }

        setRemediesAdapter(true);
    }


    private void setDataEng(GetReportResBean item){


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            binding.textDriverDesc.setText(Html.fromHtml(item.getDriverReport().getDescriptionEnglish(), Html.FROM_HTML_MODE_LEGACY));
        } else {
            binding.textDriverDesc.setText(Html.fromHtml(item.getDriverReport().getDescriptionEnglish()));
        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            binding.textConductorDesc.setText(Html.fromHtml(item.getConductorReport().getDescriptionEnglish(), Html.FROM_HTML_MODE_LEGACY));
        } else {
            binding.textConductorDesc.setText(Html.fromHtml(item.getConductorReport().getDescriptionEnglish()));
        }


        if (item.getKarmicNo()!= null && item.getKarmicNo().getDetail()!=null){
            binding.textKarmic.setVisibility(View.VISIBLE);
            binding.textkarmicValue.setVisibility(View.VISIBLE);
            binding.textkarmicValue.setText(Html.fromHtml(""+item.getKarmicNo().getDetail()));
        }else {
            binding.textKarmic.setVisibility(View.GONE);
            binding.textkarmicValue.setVisibility(View.GONE);
        }


        if (item.getPunchLine() != null && item.getPunchLine().getLine()!=null ){
            binding.textPunchLine.setVisibility(View.VISIBLE);
            binding.textPunchLineValue.setVisibility(View.VISIBLE);
            binding.textPunchLineValue.setText(""+item.getPunchLine().getLine());
        }else {
            binding.textPunchLine.setVisibility(View.GONE);
            binding.textPunchLineValue.setVisibility(View.GONE);
        }



        strEngpdf = item.getPdfPath();
        strHindipdf = item.getPdfPathHindi();

        setRemediesAdapter(false);
    }



    private void ScrollUp(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                binding.scroll.fullScroll(ScrollView.FOCUS_UP);
            }
        };
        binding.scroll.post(runnable);

    }

    @Override
    public Context getContext() {
        return this;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == REQUEST_CODE  && resultCode  == 199) {

                if(NetworkCheck.isConnected(this))
                {
                    getReportPresenter.GetReportCall(this,ProfileData.getACCESS_TOKEN(),strName,
                            strphone,strApiBirth,strGender,strReportID, "1");
                }

                String requiredValue = data.getStringExtra("key");


            }
        } catch (Exception ex) {
            Toast.makeText(GenerateReportActivity.this, ex.toString(),
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        /*if(binding.cvShowReportHindi == view){
            Intent intent1 = new Intent(Intent.ACTION_VIEW,Uri.parse(strHindipdf));
            startActivity(intent1);


        }else if(binding.cvShowReportEnglish == view){
            Intent intent1 = new Intent(Intent.ACTION_VIEW,Uri.parse(strEngpdf));
            startActivity(intent1);
        }*/
    }




    private  void PdfpopUp(String strEdf ,String strHdf){

        TextView txtEng,txtHindi;
        ImageView imgCross;


        Dialog   dialog = new Dialog(this);
        dialog.setContentView(R.layout.layout_pdf_download_popup);
        dialog.setCancelable(false);
        txtEng = dialog.findViewById(R.id.txtEng);
        txtHindi = dialog.findViewById(R.id.txtHindi);
        imgCross = dialog.findViewById(R.id.imgCross);


        Window window = dialog.getWindow();
        window.setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT);
        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        txtHindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                filepath = strHdf;
                downloadPDF(filepath);

            }
        });

        txtEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                filepath = strEdf;
                downloadPDF(filepath);

            }
        });


        imgCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }




    private void downloadPDF(String filepath1){
         URL url = null;
         String filename;

        try {
            url = new URL(filepath1);

        }catch (MalformedURLException e){
            e.printStackTrace();
        }




//        //                // Download pdf
//                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url + ""));
//                request.setTitle(filename);
//                request.setMimeType("application/pdf");
//                request.allowScanningByMediaScanner();
//                request.setAllowedOverMetered(true);
//                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
//                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,filename);
//                DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
//                dm.enqueue(request);
//
//
//                // Show pdf
//
//                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/"+filename);
//                Uri uri = FileProvider.getUriForFile(GenerateReportActivity.this,"com.numeroscop"+".provider",file);
//                Intent intent =new Intent(Intent.ACTION_VIEW);
//                intent.setDataAndType(uri,"application/pdf");
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_GRANT_READ_URI_PERMISSION);
//                startActivity(intent);

                //Show pdf

    }


    private void solutionPopUp() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dailog_solution);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        ImageView imgCross = dialog.findViewById(R.id.imgCross);
        TextView txtSkip = dialog.findViewById(R.id.txtSkip);
        EditText editSolution = dialog.findViewById(R.id.editSolution);
        CardView cvGenerateReport = dialog.findViewById(R.id.cvGenerateReport);


        imgCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        txtSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                if (lng.equalsIgnoreCase("English")) {
                    Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(strEngpdf));
                    startActivity(intent1);
                }else {
                    Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(strHindipdf));
                    startActivity(intent1);
                }
            }
        });


        cvGenerateReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

                String Strsolution = editSolution.getText().toString().trim();

                if(TextUtils.isEmpty(Strsolution)){
                    Toast.makeText(GenerateReportActivity.this, "PLease Fill Solution", Toast.LENGTH_SHORT).show();

                }else {
                    if(NetworkCheck.isConnected(getContext()))
                    {
                        solutionPresenPresenter.SaveSolutionCall(GenerateReportActivity.this,ProfileData.getACCESS_TOKEN(),Strsolution, strReportID);
                    }

                }

            }
        });

        dialog.show();
    }


    @Override
    public void onGetSolutionSuccess(SaveSolutionResBean item) {
        if(item.getStatus()){
            //Toast.makeText(this, item.getMessage(), Toast.LENGTH_SHORT).show();
            isNeedToOpenPDF = true;
            if(NetworkCheck.isConnected(this)) {
                getReportPresenter.GetReportCall(this,ProfileData.getACCESS_TOKEN(),strName,
                        strphone,strApiBirth,strGender,strReportID, "1");
            }
        }else{
            Toast.makeText(this, item.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}