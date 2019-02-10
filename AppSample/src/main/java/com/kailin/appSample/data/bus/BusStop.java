package com.kailin.appSample.data.bus;


/**
 * BusStop {
 * StopUID (string): 站牌唯一識別代碼，規則為 {業管機關簡碼} + {StopID}，其中 {業管機關簡碼} 可於Authority API中的AuthorityCode欄位查詢 ,
 * StopID (string): 地區既用中之站牌代碼(為原資料內碼) ,
 * AuthorityID (string): 業管機關代碼 ,
 * StopName (NameType): 站牌名稱 ,
 * StopPosition (PointType): 站牌位置 ,
 * StopAddress (string, optional): 站牌地址 ,
 * Bearing (string, optional): 方位角，E:東行;W:西行;S:南行;N:北行;SE:東南行;NE:東北行;SW:西南行;NW:西北行 ,
 * StationID (string, optional): 站牌所屬的站位ID ,
 * StopDescription (string, optional): 站牌詳細說明描述 ,
 * City (string, optional): 站牌權管所屬縣市(相當於市區公車API的City參數)[若為公路/國道客運路線則為空值] ,
 * CityCode (string, optional): 站牌權管所屬縣市之代碼(國際ISO 3166-2 三碼城市代碼)[若為公路/國道客運路線則為空值] ,
 * LocationCityCode (string, optional): 站牌位置縣市之代碼(國際ISO 3166-2 三碼城市代碼)[若為公路/國道客運路線則為空值] ,
 * UpdateTime (DateTime): 資料更新日期時間(ISO8601格式:yyyy-MM-ddTHH:mm:sszzz) ,
 * VersionID (integer): 資料版本編號
 * }
 * NameType {
 * Zh_tw (string, optional): 中文繁體名稱 ,
 * En (string, optional): 英文名稱
 * }
 * PointType {
 * PositionLat (number, optional): 位置緯度(WGS84) ,
 * PositionLon (number, optional): 位置經度(WGS84)
 * }
 */
public final class BusStop {

    private NameType StopName;

    private String CityCode;

    private String VersionID;

    private String StopID;

    private PointType StopPosition;

    private String AuthorityID;

    private String StopUID;

    private String City;

    private String StationID;

    private String Bearing;

    private String LocationCityCode;

    private String UpdateTime;

    private String StopAddress;

    public NameType getStopName() {
        return StopName;
    }

    public void setStopName(NameType StopName) {
        this.StopName = StopName;
    }

    public String getCityCode() {
        return CityCode;
    }

    public void setCityCode(String CityCode) {
        this.CityCode = CityCode;
    }

    public String getVersionID() {
        return VersionID;
    }

    public void setVersionID(String VersionID) {
        this.VersionID = VersionID;
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

    public String getAuthorityID() {
        return AuthorityID;
    }

    public void setAuthorityID(String AuthorityID) {
        this.AuthorityID = AuthorityID;
    }

    public String getStopUID() {
        return StopUID;
    }

    public void setStopUID(String StopUID) {
        this.StopUID = StopUID;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getStationID() {
        return StationID;
    }

    public void setStationID(String StationID) {
        this.StationID = StationID;
    }

    public String getBearing() {
        return Bearing;
    }

    public void setBearing(String Bearing) {
        this.Bearing = Bearing;
    }

    public String getLocationCityCode() {
        return LocationCityCode;
    }

    public void setLocationCityCode(String LocationCityCode) {
        this.LocationCityCode = LocationCityCode;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String UpdateTime) {
        this.UpdateTime = UpdateTime;
    }

    public String getStopAddress() {
        return StopAddress;
    }

    public void setStopAddress(String StopAddress) {
        this.StopAddress = StopAddress;
    }

    @Override
    public String toString() {
        return "BusStop{" +
                "StopName=" + StopName +
                ", CityCode='" + CityCode + '\'' +
                ", VersionID='" + VersionID + '\'' +
                ", StopID='" + StopID + '\'' +
                ", StopPosition=" + StopPosition +
                ", AuthorityID='" + AuthorityID + '\'' +
                ", StopUID='" + StopUID + '\'' +
                ", City='" + City + '\'' +
                ", StationID='" + StationID + '\'' +
                ", Bearing='" + Bearing + '\'' +
                ", LocationCityCode='" + LocationCityCode + '\'' +
                ", UpdateTime='" + UpdateTime + '\'' +
                ", StopAddress='" + StopAddress + '\'' +
                '}';
    }
}
