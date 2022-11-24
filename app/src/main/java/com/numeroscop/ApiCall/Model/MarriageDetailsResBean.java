package com.numeroscop.ApiCall.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MarriageDetailsResBean {

    @SerializedName("status")
    private Boolean status;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataDTO data;
    @SerializedName("male_data")
    private MaleDataDTO maleData;
    @SerializedName("female_data")
    private FemaleDataDTO femaleData;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public MaleDataDTO getMaleData() {
        return maleData;
    }

    public void setMaleData(MaleDataDTO maleData) {
        this.maleData = maleData;
    }

    public FemaleDataDTO getFemaleData() {
        return femaleData;
    }

    public void setFemaleData(FemaleDataDTO femaleData) {
        this.femaleData = femaleData;
    }

    public static class DataDTO {
        @SerializedName("D_to_D")
        private String dToD;
        @SerializedName("C_to_C")
        private String cToC;
        @SerializedName("K_to_K")
        private String kToK;
        @SerializedName("gifted_count")
        private Integer giftedCount;
        @SerializedName("marrige_compatibility")
        private Integer marrigeCompatibility;
        @SerializedName("total_compatibility")
        private Integer totalCompatibility;

        public String getDToD() {
            return dToD;
        }

        public void setDToD(String dToD) {
            this.dToD = dToD;
        }

        public String getCToC() {
            return cToC;
        }

        public void setCToC(String cToC) {
            this.cToC = cToC;
        }

        public String getKToK() {
            return kToK;
        }

        public void setKToK(String kToK) {
            this.kToK = kToK;
        }

        public Integer getGiftedCount() {
            return giftedCount;
        }

        public void setGiftedCount(Integer giftedCount) {
            this.giftedCount = giftedCount;
        }

        public Integer getMarrigeCompatibility() {
            return marrigeCompatibility;
        }

        public void setMarrigeCompatibility(Integer marrigeCompatibility) {
            this.marrigeCompatibility = marrigeCompatibility;
        }

        public Integer getTotalCompatibility() {
            return totalCompatibility;
        }

        public void setTotalCompatibility(Integer totalCompatibility) {
            this.totalCompatibility = totalCompatibility;
        }
    }

    public static class MaleDataDTO {
        @SerializedName("driver")
        private Integer driver;
        @SerializedName("conductor")
        private Integer conductor;
        @SerializedName("kuwa_no")
        private Integer kuwaNo;
        @SerializedName("male_conductor_enemy")
        private String maleConductorEnemy;
        @SerializedName("male_driver_enemy")
        private String maleDriverEnemy;
        @SerializedName("male_kuwa_enemy")
        private String maleKuwaEnemy;
        @SerializedName("present")
        private List<Integer> present;
        @SerializedName("missing")
        private List<Integer> missing;
        @SerializedName("calculation")
        private List<Integer> calculation;

        public Integer getDriver() {
            return driver;
        }

        public void setDriver(Integer driver) {
            this.driver = driver;
        }

        public Integer getConductor() {
            return conductor;
        }

        public void setConductor(Integer conductor) {
            this.conductor = conductor;
        }

        public Integer getKuwaNo() {
            return kuwaNo;
        }

        public void setKuwaNo(Integer kuwaNo) {
            this.kuwaNo = kuwaNo;
        }

        public String getMaleConductorEnemy() {
            return maleConductorEnemy;
        }

        public void setMaleConductorEnemy(String maleConductorEnemy) {
            this.maleConductorEnemy = maleConductorEnemy;
        }

        public String getMaleDriverEnemy() {
            return maleDriverEnemy;
        }

        public void setMaleDriverEnemy(String maleDriverEnemy) {
            this.maleDriverEnemy = maleDriverEnemy;
        }

        public String getMaleKuwaEnemy() {
            return maleKuwaEnemy;
        }

        public void setMaleKuwaEnemy(String maleKuwaEnemy) {
            this.maleKuwaEnemy = maleKuwaEnemy;
        }

        public List<Integer> getPresent() {
            return present;
        }

        public void setPresent(List<Integer> present) {
            this.present = present;
        }

        public List<Integer> getMissing() {
            return missing;
        }

        public void setMissing(List<Integer> missing) {
            this.missing = missing;
        }

        public List<Integer> getCalculation() {
            return calculation;
        }

        public void setCalculation(List<Integer> calculation) {
            this.calculation = calculation;
        }
    }

    public static class FemaleDataDTO {
        @SerializedName("driver")
        private Integer driver;
        @SerializedName("conductor")
        private Integer conductor;
        @SerializedName("kuwa_no")
        private Integer kuwaNo;
        @SerializedName("female_conductor_enemy")
        private String femaleConductorEnemy;
        @SerializedName("female_driver_enemy")
        private String femaleDriverEnemy;
        @SerializedName("female_kuwa_enemy")
        private String femaleKuwaEnemy;
        @SerializedName("present")
        private List<Integer> present;
        @SerializedName("missing")
        private List<Integer> missing;
        @SerializedName("calculation")
        private List<Integer> calculation;

        public Integer getDriver() {
            return driver;
        }

        public void setDriver(Integer driver) {
            this.driver = driver;
        }

        public Integer getConductor() {
            return conductor;
        }

        public void setConductor(Integer conductor) {
            this.conductor = conductor;
        }

        public Integer getKuwaNo() {
            return kuwaNo;
        }

        public void setKuwaNo(Integer kuwaNo) {
            this.kuwaNo = kuwaNo;
        }

        public String getFemaleConductorEnemy() {
            return femaleConductorEnemy;
        }

        public void setFemaleConductorEnemy(String femaleConductorEnemy) {
            this.femaleConductorEnemy = femaleConductorEnemy;
        }

        public String getFemaleDriverEnemy() {
            return femaleDriverEnemy;
        }

        public void setFemaleDriverEnemy(String femaleDriverEnemy) {
            this.femaleDriverEnemy = femaleDriverEnemy;
        }

        public String getFemaleKuwaEnemy() {
            return femaleKuwaEnemy;
        }

        public void setFemaleKuwaEnemy(String femaleKuwaEnemy) {
            this.femaleKuwaEnemy = femaleKuwaEnemy;
        }

        public List<Integer> getPresent() {
            return present;
        }

        public void setPresent(List<Integer> present) {
            this.present = present;
        }

        public List<Integer> getMissing() {
            return missing;
        }

        public void setMissing(List<Integer> missing) {
            this.missing = missing;
        }

        public List<Integer> getCalculation() {
            return calculation;
        }

        public void setCalculation(List<Integer> calculation) {
            this.calculation = calculation;
        }
    }
}
