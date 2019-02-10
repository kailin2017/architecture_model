package com.kailin.appSample.data.bus;

/**
 * Stop {
 * StopUID (string): 站牌唯一識別代碼，規則為 {業管機關簡碼} + {StopID}，其中 {業管機關簡碼} 可於Authority API中的AuthorityCode欄位查詢 ,
 * StopID (string): 地區既用中之站牌代碼(為原資料內碼) ,
 * StopName (NameType): 站牌名稱 ,
 * StationNameID (string): 站名碼 ,
 * StopBoarding (string, optional): 上下車站別 = ['0: 可上下車', '1: 可上車', '-1: 可下車'],
 * StopSequence (integer): 路線經過站牌之順序 ,
 * StopPosition (PointType): 站牌位置 ,
 * StationID (string, optional): 站牌所屬的站位ID ,
 * LocationCityCode (string, optional): 站牌位置縣市之代碼(國際ISO 3166-2 三碼城市代碼)[若為公路/國道客運路線則為空值]
 * }
 */
public final class Stop {

    private NameType StopName;

    private String StopBoarding;

    private String StopID;

    private PointType StopPosition;

    private String StopUID;

    private String StationID;

    private String StopSequence;

    public NameType getStopName() {
        return StopName;
    }

    public void setStopName(NameType StopName) {
        this.StopName = StopName;
    }

    public String getStopBoarding() {
        return StopBoarding;
    }

    public void setStopBoarding(String StopBoarding) {
        this.StopBoarding = StopBoarding;
    }

    public String getStopID() {
        return StopID;
    }

    public void setStopID(String StopID) {
        this.StopID = StopID;
    }

    public PointType getStopPosition() {
        return StopPosition;
    }

    public void setStopPosition(PointType StopPosition) {
        this.StopPosition = StopPosition;
    }

    public String getStopUID() {
        return StopUID;
    }

    public void setStopUID(String StopUID) {
        this.StopUID = StopUID;
    }

    public String getStationID() {
        return StationID;
    }

    public void setStationID(String StationID) {
        this.StationID = StationID;
    }

    public String getStopSequence() {
        return StopSequence;
    }

    public void setStopSequence(String StopSequence) {
        this.StopSequence = StopSequence;
    }

    @Override
    public String toString() {
        return "Stop{" +
                "StopName=" + StopName +
                ", StopBoarding='" + StopBoarding + '\'' +
                ", StopID='" + StopID + '\'' +
                ", StopPosition=" + StopPosition +
                ", StopUID='" + StopUID + '\'' +
                ", StationID='" + StationID + '\'' +
                ", StopSequence='" + StopSequence + '\'' +
                '}';
    }
}
