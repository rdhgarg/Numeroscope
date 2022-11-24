package com.numeroscop.ApiCall.Model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetReportResBean {
    @SerializedName("status")
    private Boolean status;
    @SerializedName("message")
    private String message;
    @SerializedName("is_reports")
    private Integer isReports;
    @SerializedName("data")
    private DataDTO data;
    @SerializedName("plane")
    private PlaneDTO plane;
    @SerializedName("planreport")
    private PlanreportDTO planreport;
    @SerializedName("driver_report")
    private DriverReportDTO driverReport;
    @SerializedName("conductor_report")
    private ConductorReportDTO conductorReport;
    @SerializedName("repeat_no")
    private List<RepeatNoDTO> repeatNo;
    @SerializedName("single_no_report")
    private List<SingleNoReportDTO> singleNoReport;
    @SerializedName("punch_line")
    private PunchLineDTO punchLine;
    @SerializedName("karmic_no")
    private KarmicNoDTO karmicNo;
    @SerializedName("missig_no_report")
    private List<MissigNoReportDTO> missigNoReport;
    @SerializedName("mobile_report")
    private MobileReportDTO mobileReport;
    @SerializedName("lucky_colors")
    private List<String> luckyColors;
    @SerializedName("natural_colors")
    private String naturalColors;
    @SerializedName("avoid_colors")
    private String avoidColors;
    @SerializedName("lucky_proffession")
    private List<LuckyProffessionDTO> luckyProffession;
    @SerializedName("natural_proffession")
    private List<NaturalProffessionDTO> naturalProffession;
    @SerializedName("avoid_proffession")
    private List<AvoidProffessionDTO> avoidProffession;
    @SerializedName("remedies")
    private List<RemediesDTO> remedies;
    @SerializedName("personalyear_report")
    private List<PersonalyearReportDTO> personalyearReport;
    @SerializedName("nextpersonalmonth")
    private List<NextpersonalmonthDTO> nextpersonalmonth;
    @SerializedName("lucky_days")
    private String luckyDays;
    @SerializedName("natural_days")
    private String naturalDays;
    @SerializedName("avoid_days")
    private String avoidDays;
    @SerializedName("name_report")
    private NameReportDTO nameReport;
    @SerializedName("thoughtarray")
    private List<String> thoughtarray;
    @SerializedName("willarray")
    private List<String> willarray;
    @SerializedName("actionarray")
    private List<String> actionarray;
    @SerializedName("mentalarray")
    private List<String> mentalarray;
    @SerializedName("emotionalarray")
    private List<String> emotionalarray;
    @SerializedName("practicalarray")
    private List<String> practicalarray;
    @SerializedName("success1array")
    private List<String> success1array;
    @SerializedName("success2array")
    private List<String> success2array;
    @SerializedName("pdf_path")
    private String pdfPath;
    @SerializedName("pdf_path_hindi")
    private String pdfPathHindi;

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

    public Integer getIsReports() {
        return isReports;
    }

    public void setIsReports(Integer isReports) {
        this.isReports = isReports;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public PlaneDTO getPlane() {
        return plane;
    }

    public void setPlane(PlaneDTO plane) {
        this.plane = plane;
    }

    public PlanreportDTO getPlanreport() {
        return planreport;
    }

    public void setPlanreport(PlanreportDTO planreport) {
        this.planreport = planreport;
    }

    public DriverReportDTO getDriverReport() {
        return driverReport;
    }

    public void setDriverReport(DriverReportDTO driverReport) {
        this.driverReport = driverReport;
    }

    public ConductorReportDTO getConductorReport() {
        return conductorReport;
    }

    public void setConductorReport(ConductorReportDTO conductorReport) {
        this.conductorReport = conductorReport;
    }

    public List<RepeatNoDTO> getRepeatNo() {
        return repeatNo;
    }

    public void setRepeatNo(List<RepeatNoDTO> repeatNo) {
        this.repeatNo = repeatNo;
    }

    public List<SingleNoReportDTO> getSingleNoReport() {
        return singleNoReport;
    }

    public void setSingleNoReport(List<SingleNoReportDTO> singleNoReport) {
        this.singleNoReport = singleNoReport;
    }

    public PunchLineDTO getPunchLine() {
        return punchLine;
    }

    public void setPunchLine(PunchLineDTO punchLine) {
        this.punchLine = punchLine;
    }

    public KarmicNoDTO getKarmicNo() {
        return karmicNo;
    }

    public void setKarmicNo(KarmicNoDTO karmicNo) {
        this.karmicNo = karmicNo;
    }

    public List<MissigNoReportDTO> getMissigNoReport() {
        return missigNoReport;
    }

    public void setMissigNoReport(List<MissigNoReportDTO> missigNoReport) {
        this.missigNoReport = missigNoReport;
    }

    public MobileReportDTO getMobileReport() {
        return mobileReport;
    }

    public void setMobileReport(MobileReportDTO mobileReport) {
        this.mobileReport = mobileReport;
    }

    public List<String> getLuckyColors() {
        return luckyColors;
    }

    public void setLuckyColors(List<String> luckyColors) {
        this.luckyColors = luckyColors;
    }

    public String getNaturalColors(){
        return naturalColors;
    }

    public void setNaturalColors(String naturalColors){
        this.naturalColors = naturalColors;
    }

    public String getAvoidColors() {
        return avoidColors;
    }

    public void setAvoidColors(String avoidColors) {
        this.avoidColors = avoidColors;
    }

    public List<LuckyProffessionDTO> getLuckyProffession() {
        return luckyProffession;
    }

    public void setLuckyProffession(List<LuckyProffessionDTO> luckyProffession) {
        this.luckyProffession = luckyProffession;
    }

    public List<NaturalProffessionDTO> getNaturalProffession() {
        return naturalProffession;
    }

    public void setNaturalProffession(List<NaturalProffessionDTO> naturalProffession) {
        this.naturalProffession = naturalProffession;
    }

    public List<AvoidProffessionDTO> getAvoidProffession() {
        return avoidProffession;
    }

    public void setAvoidProffession(List<AvoidProffessionDTO> avoidProffession) {
        this.avoidProffession = avoidProffession;
    }

    public List<RemediesDTO> getRemedies(){
        return remedies;
    }

    public void setRemedies(List<RemediesDTO> remedies){
        this.remedies = remedies;
    }

    public List<PersonalyearReportDTO> getPersonalyearReport() {
        return personalyearReport;
    }

    public void setPersonalyearReport(List<PersonalyearReportDTO> personalyearReport) {
        this.personalyearReport = personalyearReport;
    }

    public List<NextpersonalmonthDTO> getNextpersonalmonth() {
        return nextpersonalmonth;
    }

    public void setNextpersonalmonth(List<NextpersonalmonthDTO> nextpersonalmonth) {
        this.nextpersonalmonth = nextpersonalmonth;
    }

    public String getLuckyDays() {
        return luckyDays;
    }

    public void setLuckyDays(String luckyDays) {
        this.luckyDays = luckyDays;
    }

    public String getNaturalDays(){
        return naturalDays;
    }

    public void setNaturalDays(String naturalDays){
        this.naturalDays = naturalDays;
    }

    public String getAvoidDays() {
        return avoidDays;
    }

    public void setAvoidDays(String avoidDays) {
        this.avoidDays = avoidDays;
    }

    public NameReportDTO getNameReport() {
        return nameReport;
    }

    public void setNameReport(NameReportDTO nameReport) {
        this.nameReport = nameReport;
    }

    public List<String> getThoughtarray() {
        return thoughtarray;
    }

    public void setThoughtarray(List<String> thoughtarray) {
        this.thoughtarray = thoughtarray;
    }

    public List<String> getWillarray() {
        return willarray;
    }

    public void setWillarray(List<String> willarray) {
        this.willarray = willarray;
    }

    public List<String> getActionarray() {
        return actionarray;
    }

    public void setActionarray(List<String> actionarray) {
        this.actionarray = actionarray;
    }

    public List<String> getMentalarray() {
        return mentalarray;
    }

    public void setMentalarray(List<String> mentalarray) {
        this.mentalarray = mentalarray;
    }

    public List<String> getEmotionalarray() {
        return emotionalarray;
    }

    public void setEmotionalarray(List<String> emotionalarray) {
        this.emotionalarray = emotionalarray;
    }

    public List<String> getPracticalarray() {
        return practicalarray;
    }

    public void setPracticalarray(List<String> practicalarray) {
        this.practicalarray = practicalarray;
    }

    public List<String> getSuccess1array() {
        return success1array;
    }

    public void setSuccess1array(List<String> success1array) {
        this.success1array = success1array;
    }

    public List<String> getSuccess2array() {
        return success2array;
    }

    public void setSuccess2array(List<String> success2array) {
        this.success2array = success2array;
    }

    public String getPdfPath() {
        return pdfPath;
    }

    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
    }

    public String getPdfPathHindi() {
        return pdfPathHindi;
    }

    public void setPdfPathHindi(String pdfPathHindi) {
        this.pdfPathHindi = pdfPathHindi;
    }

    public static class DataDTO {
        @SerializedName("name_total")
        private Integer nameTotal;
        @SerializedName("name_no")
        private Integer nameNo;
        @SerializedName("best_name_no")
        private Integer bestNameNo;
        @SerializedName("driver")
        private Integer driver;
        @SerializedName("conductor")
        private Integer conductor;
        @SerializedName("kuwa_no")
        private Integer kuwaNo;
        @SerializedName("mobile_total")
        private Integer mobileTotal;
        @SerializedName("mobile")
        private Integer mobile;
        @SerializedName("personalyear")
        private Integer personalyear;
        @SerializedName("personalmonth")
        private Integer personalmonth;
        @SerializedName("personal_date")
        private Integer personalDate;
        @SerializedName("avoid_no")
        private String avoidNo;
        @SerializedName("lucky_no")
        private String luckyNo;
        @SerializedName("friend_no")
        private String friendNo;
        @SerializedName("present")
        private List<Integer> present;
        @SerializedName("missing")
        private List<Integer> missing;
        @SerializedName("name")
        private String name;
        @SerializedName("calculation")
        private List<Integer> calculation;

        public Integer getNameTotal() {
            return nameTotal;
        }

        public void setNameTotal(Integer nameTotal) {
            this.nameTotal = nameTotal;
        }

        public Integer getNameNo() {
            return nameNo;
        }

        public void setNameNo(Integer nameNo) {
            this.nameNo = nameNo;
        }

        public Integer getBestNameNo() {
            return bestNameNo;
        }

        public void setBestNameNo(Integer bestNameNo) {
            this.bestNameNo = bestNameNo;
        }

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

        public Integer getMobileTotal() {
            return mobileTotal;
        }

        public void setMobileTotal(Integer mobileTotal) {
            this.mobileTotal = mobileTotal;
        }

        public Integer getMobile() {
            return mobile;
        }

        public void setMobile(Integer mobile) {
            this.mobile = mobile;
        }

        public Integer getPersonalyear() {
            return personalyear;
        }

        public void setPersonalyear(Integer personalyear) {
            this.personalyear = personalyear;
        }

        public Integer getPersonalmonth() {
            return personalmonth;
        }

        public void setPersonalmonth(Integer personalmonth) {
            this.personalmonth = personalmonth;
        }

        public Integer getPersonalDate() {
            return personalDate;
        }

        public void setPersonalDate(Integer personalDate) {
            this.personalDate = personalDate;
        }

        public String getAvoidNo() {
            return avoidNo;
        }

        public void setAvoidNo(String avoidNo) {
            this.avoidNo = avoidNo;
        }

        public String getLuckyNo() {
            return luckyNo;
        }

        public void setLuckyNo(String luckyNo) {
            this.luckyNo = luckyNo;
        }

        public String getFriendNo() {
            return friendNo;
        }

        public void setFriendNo(String friendNo) {
            this.friendNo = friendNo;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Integer> getCalculation() {
            return calculation;
        }

        public void setCalculation(List<Integer> calculation) {
            this.calculation = calculation;
        }
    }

    public static class PlaneDTO {
        @SerializedName("thought")
        private Integer thought;
        @SerializedName("will")
        private Integer will;
        @SerializedName("action")
        private Integer action;
        @SerializedName("mental")
        private Integer mental;
        @SerializedName("emotional")
        private Integer emotional;
        @SerializedName("practical")
        private Integer practical;
        @SerializedName("success1")
        private Integer success1;
        @SerializedName("success2")
        private Integer success2;

        public Integer getThought() {
            return thought;
        }

        public void setThought(Integer thought) {
            this.thought = thought;
        }

        public Integer getWill() {
            return will;
        }

        public void setWill(Integer will) {
            this.will = will;
        }

        public Integer getAction() {
            return action;
        }

        public void setAction(Integer action) {
            this.action = action;
        }

        public Integer getMental() {
            return mental;
        }

        public void setMental(Integer mental) {
            this.mental = mental;
        }

        public Integer getEmotional() {
            return emotional;
        }

        public void setEmotional(Integer emotional) {
            this.emotional = emotional;
        }

        public Integer getPractical() {
            return practical;
        }

        public void setPractical(Integer practical) {
            this.practical = practical;
        }

        public Integer getSuccess1() {
            return success1;
        }

        public void setSuccess1(Integer success1) {
            this.success1 = success1;
        }

        public Integer getSuccess2() {
            return success2;
        }

        public void setSuccess2(Integer success2) {
            this.success2 = success2;
        }
    }

    public static class PlanreportDTO {
        @SerializedName("thought")
        private String thought;
        @SerializedName("will")
        private String will;
        @SerializedName("action")
        private String action;
        @SerializedName("mental")
        private String mental;
        @SerializedName("emotional")
        private String emotional;
        @SerializedName("practical")
        private String practical;
        @SerializedName("success1")
        private String success1;
        @SerializedName("success2")
        private String success2;
        @SerializedName("thought_description")
        private String thoughtDescription;
        @SerializedName("will_description")
        private String willDescription;
        @SerializedName("action_description")
        private String actionDescription;
        @SerializedName("mental_description")
        private String mentalDescription;
        @SerializedName("emotional_description")
        private String emotionalDescription;
        @SerializedName("practical_description")
        private String practicalDescription;
        @SerializedName("success1_description")
        private String success1Description;
        @SerializedName("success2_description")
        private String success2Description;

        public String getThought() {
            return thought;
        }

        public void setThought(String thought) {
            this.thought = thought;
        }

        public String getWill() {
            return will;
        }

        public void setWill(String will) {
            this.will = will;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getMental() {
            return mental;
        }

        public void setMental(String mental) {
            this.mental = mental;
        }

        public String getEmotional() {
            return emotional;
        }

        public void setEmotional(String emotional) {
            this.emotional = emotional;
        }

        public String getPractical() {
            return practical;
        }

        public void setPractical(String practical) {
            this.practical = practical;
        }

        public String getSuccess1() {
            return success1;
        }

        public void setSuccess1(String success1) {
            this.success1 = success1;
        }

        public String getSuccess2() {
            return success2;
        }

        public void setSuccess2(String success2) {
            this.success2 = success2;
        }

        public String getThoughtDescription() {
            return thoughtDescription;
        }

        public void setThoughtDescription(String thoughtDescription) {
            this.thoughtDescription = thoughtDescription;
        }

        public String getWillDescription() {
            return willDescription;
        }

        public void setWillDescription(String willDescription) {
            this.willDescription = willDescription;
        }

        public String getActionDescription() {
            return actionDescription;
        }

        public void setActionDescription(String actionDescription) {
            this.actionDescription = actionDescription;
        }

        public String getMentalDescription() {
            return mentalDescription;
        }

        public void setMentalDescription(String mentalDescription) {
            this.mentalDescription = mentalDescription;
        }

        public String getEmotionalDescription() {
            return emotionalDescription;
        }

        public void setEmotionalDescription(String emotionalDescription) {
            this.emotionalDescription = emotionalDescription;
        }

        public String getPracticalDescription() {
            return practicalDescription;
        }

        public void setPracticalDescription(String practicalDescription) {
            this.practicalDescription = practicalDescription;
        }

        public String getSuccess1Description() {
            return success1Description;
        }

        public void setSuccess1Description(String success1Description) {
            this.success1Description = success1Description;
        }

        public String getSuccess2Description() {
            return success2Description;
        }

        public void setSuccess2Description(String success2Description) {
            this.success2Description = success2Description;
        }
    }

    public static class DriverReportDTO {
        @SerializedName("id")
        private Integer id;
        @SerializedName("driver_no")
        private Integer driverNo;
        @SerializedName("description_english")
        private String descriptionEnglish;
        @SerializedName("description_hindi")
        private String descriptionHindi;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getDriverNo() {
            return driverNo;
        }

        public void setDriverNo(Integer driverNo) {
            this.driverNo = driverNo;
        }

        public String getDescriptionEnglish() {
            return descriptionEnglish;
        }

        public void setDescriptionEnglish(String descriptionEnglish) {
            this.descriptionEnglish = descriptionEnglish;
        }

        public String getDescriptionHindi() {
            return descriptionHindi;
        }

        public void setDescriptionHindi(String descriptionHindi) {
            this.descriptionHindi = descriptionHindi;
        }
    }

    public static class ConductorReportDTO {
        @SerializedName("id")
        private Integer id;
        @SerializedName("conductor_no")
        private Integer conductorNo;
        @SerializedName("description_english")
        private String descriptionEnglish;
        @SerializedName("description_hindi")
        private String descriptionHindi;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getConductorNo() {
            return conductorNo;
        }

        public void setConductorNo(Integer conductorNo) {
            this.conductorNo = conductorNo;
        }

        public String getDescriptionEnglish() {
            return descriptionEnglish;
        }

        public void setDescriptionEnglish(String descriptionEnglish) {
            this.descriptionEnglish = descriptionEnglish;
        }

        public String getDescriptionHindi() {
            return descriptionHindi;
        }

        public void setDescriptionHindi(String descriptionHindi) {
            this.descriptionHindi = descriptionHindi;
        }
    }

    public static class PunchLineDTO {
        @SerializedName("id")
        private Integer id;
        @SerializedName("driver")
        private Integer driver;
        @SerializedName("conductor")
        private String conductor;
        @SerializedName("line")
        private String line;
        @SerializedName("line_hindi")
        private Object lineHindi;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getDriver() {
            return driver;
        }

        public void setDriver(Integer driver) {
            this.driver = driver;
        }

        public String getConductor() {
            return conductor;
        }

        public void setConductor(String conductor) {
            this.conductor = conductor;
        }

        public String getLine() {
            return line;
        }

        public void setLine(String line) {
            this.line = line;
        }

        public Object getLineHindi() {
            return lineHindi;
        }

        public void setLineHindi(Object lineHindi) {
            this.lineHindi = lineHindi;
        }
    }

    public static class KarmicNoDTO {
        @SerializedName("id")
        private Integer id;
        @SerializedName("number")
        private Integer number;
        @SerializedName("detail")
        private String detail;
        @SerializedName("detail_hindi")
        private Object detailHindi;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public Object getDetailHindi() {
            return detailHindi;
        }

        public void setDetailHindi(Object detailHindi) {
            this.detailHindi = detailHindi;
        }
    }

    public static class MobileReportDTO {
        @SerializedName("A")
        private String a;
        @SerializedName("B")
        private String b;
        @SerializedName("c")
        private String c;
        @SerializedName("d")
        private String d;
        @SerializedName("e")
        private String e;
        @SerializedName("f")
        private String f;
        @SerializedName("g")
        private String g;
        @SerializedName("h")
        private String h;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        public String getC() {
            return c;
        }

        public void setC(String c) {
            this.c = c;
        }

        public String getD() {
            return d;
        }

        public void setD(String d) {
            this.d = d;
        }

        public String getE() {
            return e;
        }

        public void setE(String e) {
            this.e = e;
        }

        public String getF() {
            return f;
        }

        public void setF(String f) {
            this.f = f;
        }

        public String getG() {
            return g;
        }

        public void setG(String g) {
            this.g = g;
        }

        public String getH() {
            return h;
        }

        public void setH(String h) {
            this.h = h;
        }
    }

    public static class NameReportDTO {
        @SerializedName("A")
        private String a;
        @SerializedName("B")
        private String b;
        @SerializedName("c")
        private String c;
        @SerializedName("d")
        private String d;
        @SerializedName("e")
        private String e;
        @SerializedName("f")
        private String f;
        @SerializedName("g")
        private String g;
        @SerializedName("h")
        private String h;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }

        public String getC() {
            return c;
        }

        public void setC(String c) {
            this.c = c;
        }

        public String getD() {
            return d;
        }

        public void setD(String d) {
            this.d = d;
        }

        public String getE() {
            return e;
        }

        public void setE(String e) {
            this.e = e;
        }

        public String getF() {
            return f;
        }

        public void setF(String f) {
            this.f = f;
        }

        public String getG() {
            return g;
        }

        public void setG(String g) {
            this.g = g;
        }

        public String getH() {
            return h;
        }

        public void setH(String h) {
            this.h = h;
        }
    }

    public static class RepeatNoDTO {
        @SerializedName("id")
        private Integer id;
        @SerializedName("counts")
        private String counts;
        @SerializedName("number")
        private String number;
        @SerializedName("detail")
        private String detail;
        @SerializedName("detail_hindi")
        private String detailHindi;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCounts() {
            return counts;
        }

        public void setCounts(String counts) {
            this.counts = counts;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getDetailHindi() {
            return detailHindi;
        }

        public void setDetailHindi(String detailHindi) {
            this.detailHindi = detailHindi;
        }
    }

    public static class SingleNoReportDTO {
        @SerializedName("id")
        private Integer id;
        @SerializedName("counts")
        private String counts;
        @SerializedName("number")
        private String number;
        @SerializedName("detail")
        private String detail;
        @SerializedName("detail_hindi")
        private String detailHindi;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCounts() {
            return counts;
        }

        public void setCounts(String counts) {
            this.counts = counts;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getDetailHindi() {
            return detailHindi;
        }

        public void setDetailHindi(String detailHindi) {
            this.detailHindi = detailHindi;
        }
    }

    public static class MissigNoReportDTO {
        @SerializedName("id")
        private Integer id;
        @SerializedName("number")
        private Integer number;
        @SerializedName("detail")
        private String detail;
        @SerializedName("detail_hindi")
        private String detailHindi;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getDetailHindi() {
            return detailHindi;
        }

        public void setDetailHindi(String detailHindi) {
            this.detailHindi = detailHindi;
        }
    }

    public static class LuckyProffessionDTO {
        @SerializedName("id")
        private Integer id;
        @SerializedName("number")
        private Integer number;
        @SerializedName("english_detail")
        private String englishDetail;
        @SerializedName("detail_hindi")
        private String detailHindi;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public String getEnglishDetail() {
            return englishDetail;
        }

        public void setEnglishDetail(String englishDetail) {
            this.englishDetail = englishDetail;
        }

        public String getDetailHindi() {
            return detailHindi;
        }

        public void setDetailHindi(String detailHindi) {
            this.detailHindi = detailHindi;
        }
    }

    public static class NaturalProffessionDTO {
        @SerializedName("id")
        private Integer id;
        @SerializedName("number")
        private Integer number;
        @SerializedName("english_detail")
        private String englishDetail;
        @SerializedName("detail_hindi")
        private String detailHindi;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public String getEnglishDetail() {
            return englishDetail;
        }

        public void setEnglishDetail(String englishDetail) {
            this.englishDetail = englishDetail;
        }

        public String getDetailHindi() {
            return detailHindi;
        }

        public void setDetailHindi(String detailHindi) {
            this.detailHindi = detailHindi;
        }
    }

    public static class AvoidProffessionDTO {
        @SerializedName("id")
        private Integer id;
        @SerializedName("number")
        private Integer number;
        @SerializedName("english_detail")
        private String englishDetail;
        @SerializedName("detail_hindi")
        private String detailHindi;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public String getEnglishDetail() {
            return englishDetail;
        }

        public void setEnglishDetail(String englishDetail) {
            this.englishDetail = englishDetail;
        }

        public String getDetailHindi() {
            return detailHindi;
        }

        public void setDetailHindi(String detailHindi) {
            this.detailHindi = detailHindi;
        }
    }

    public static class RemediesDTO {
        @SerializedName("id")
        private String id;
        @SerializedName("avoid")
        private String avoid;
        @SerializedName("english_remedie")
        private String englishRemedie;
        @SerializedName("hindi_remedie")
        private String hindiRemedie;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAvoid() {
            return avoid;
        }

        public void setAvoid(String avoid) {
            this.avoid = avoid;
        }

        public String getEnglishRemedie() {
            return englishRemedie;
        }

        public void setEnglishRemedie(String englishRemedie) {
            this.englishRemedie = englishRemedie;
        }

        public String getHindiRemedie() {
            return hindiRemedie;
        }

        public void setHindiRemedie(String hindiRemedie) {
            this.hindiRemedie = hindiRemedie;
        }
    }

    public static class PersonalyearReportDTO {
        @SerializedName("id")
        private Integer id;
        @SerializedName("number")
        private Integer number;
        @SerializedName("description_english")
        private String descriptionEnglish;
        @SerializedName("description_hindi")
        private String descriptionHindi;
        @SerializedName("year")
        private String year;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public String getDescriptionEnglish() {
            return descriptionEnglish;
        }

        public void setDescriptionEnglish(String descriptionEnglish) {
            this.descriptionEnglish = descriptionEnglish;
        }

        public String getDescriptionHindi() {
            return descriptionHindi;
        }

        public void setDescriptionHindi(String descriptionHindi) {
            this.descriptionHindi = descriptionHindi;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }
    }

    public static class NextpersonalmonthDTO {
        @SerializedName("month_no")
        private Integer monthNo;
        @SerializedName("month")
        private String month;

        public Integer getMonthNo() {
            return monthNo;
        }

        public void setMonthNo(Integer monthNo) {
            this.monthNo = monthNo;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }
    }
    // Full Data Date of birth 13031956



}