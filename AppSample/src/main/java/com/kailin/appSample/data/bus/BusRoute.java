package com.kailin.appSample.data.bus;


import java.util.ArrayList;

/**
 * BusRoute {
 * RouteUID (string): 路線唯一識別代碼，規則為 {業管機關簡碼} + {RouteID}，其中 {業管機關簡碼} 可於Authority API中的AuthorityCode欄位查詢 ,
 * RouteID (string): 地區既用中之路線代碼(為原資料內碼) ,
 * HasSubRoutes (boolean): 實際上是否有多條附屬路線。(此欄位值與SubRoutes結構並無強烈的絕對關聯。詳細說明請參閱swagger上方的【資料服務使用注意事項】) ,
 * RouteOperator (Array[RouteOperator]): 營運業者 ,
 * AuthorityID (string): 業管機關代碼 ,
 * ProviderID (string): 資料提供平台代碼 ,
 * BusSubRoute (Array[BusSubRoute], optional): 附屬路線資料(如果原始資料並無提供附屬路線ID，而本平台基於跨來源資料之一致性，會以SubRouteID=RouteID產製一份相對應的附屬路線資料(若有去返程，則會有兩筆)) ,
 * BusRouteType (string): 公車路線類別 = ['11: 市區公車', '12: 公路客運', '13: 國道客運', '14: 接駁車'],
 * RouteName (NameType): 路線名稱 ,
 * DepartureStopNameZh (string, optional): 起站中文名稱 ,
 * DepartureStopNameEn (string, optional): 起站英文名稱 ,
 * DestinationStopNameZh (string, optional): 終點站中文名稱 ,
 * DestinationStopNameEn (string, optional): 終點站英文名稱 ,
 * TicketPriceDescriptionZh (string, optional): 票價中文敘述 ,
 * TicketPriceDescriptionEn (string, optional): 票價英文敘述 ,
 * FareBufferZoneDescriptionZh (string, optional): 收費緩衝區中文敘述 ,
 * FareBufferZoneDescriptionEn (string, optional): 收費緩衝區英文敘述 ,
 * RouteMapImageUrl (string, optional): 路線簡圖網址 ,
 * City (string, optional): 路線權管所屬縣市(相當於市區公車API的City參數)[若為公路/國道客運路線則為空值] ,
 * CityCode (string, optional): 路線權管所屬縣市之代碼(國際ISO 3166-2 三碼城市代碼)[若為公路/國道客運路線則為空值] ,
 * UpdateTime (DateTime): 資料更新日期時間(ISO8601格式:yyyy-MM-ddTHH:mm:sszzz) ,
 * VersionID (integer): 資料版本編號
 * }
 * RouteOperator {
 * OperatorID (string): 營運業者代碼 ,
 * NameType (NameType): 營運業者名稱 ,
 * OperatorCode (string): 營運業者簡碼 ,
 * OperatorNo (string): 營運業者編號[交通部票證資料系統定義]
 * }
 * BusSubRoute {
 * SubRouteUID (string): 附屬路線唯一識別代碼，規則為 {業管機關簡碼} + {SubRouteID}，其中 {業管機關簡碼} 可於Authority API中的AuthorityCode欄位查詢 ,
 * SubRouteID (string): 地區既用中之附屬路線代碼(為原資料內碼) ,
 * OperatorIDs (Array[string]): 營運業者代碼 ,
 * SubRouteName (NameType): 附屬路線名稱 ,
 * Headsign (string, optional): 車頭描述 ,
 * Direction (string): 去返程 = ['0: 去程', '1: 返程', '2: 迴圈', '255: 未知'],
 * FirstBusTime (string, optional): 平日第一班發車時間 ,
 * LastBusTime (string, optional): 平日返程第一班發車時間 ,
 * HolidayFirstBusTime (string, optional): 假日去程第一班發車時間 ,
 * HolidayLastBusTime (string, optional): 假日返程第一班發車時間
 * }
 * NameType {
 * Zh_tw (string, optional): 中文繁體名稱 ,
 * En (string, optional): 英文名稱
 * }
 */
public final class BusRoute {

    private String ProviderID;

    private String CityCode;

    private String VersionID;

    private String FareBufferZoneDescriptionEn;

    private ArrayList<RouteOperator> Operators;

    private String BusRouteType;

    private String AuthorityID;

    private String HasSubRoutes;

    private String DepartureStopNameZh;

    private String RouteUID;

    private String RouteID;

    private String City;

    private String DepartureStopNameEn;

    private String TicketPriceDescriptionZh;

    private String DestinationStopNameEn;

    private String TicketPriceDescriptionEn;

    private ArrayList<NameType> SubRoutes;

    private String UpdateTime;

    private NameType RouteName;

    private String FareBufferZoneDescriptionZh;

    private String DestinationStopNameZh;

    public String getProviderID() {
        return ProviderID;
    }

    public void setProviderID(String ProviderID) {
        this.ProviderID = ProviderID;
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

    public String getFareBufferZoneDescriptionEn() {
        return FareBufferZoneDescriptionEn;
    }

    public void setFareBufferZoneDescriptionEn(String FareBufferZoneDescriptionEn) {
        this.FareBufferZoneDescriptionEn = FareBufferZoneDescriptionEn;
    }

    public ArrayList<RouteOperator> getOperators() {
        return Operators;
    }

    public void setOperators(ArrayList<RouteOperator> Operators) {
        this.Operators = Operators;
    }

    public String getBusRouteType() {
        return BusRouteType;
    }

    public void setBusRouteType(String BusRouteType) {
        this.BusRouteType = BusRouteType;
    }

    public String getAuthorityID() {
        return AuthorityID;
    }

    public void setAuthorityID(String AuthorityID) {
        this.AuthorityID = AuthorityID;
    }

    public String getHasSubRoutes() {
        return HasSubRoutes;
    }

    public void setHasSubRoutes(String HasSubRoutes) {
        this.HasSubRoutes = HasSubRoutes;
    }

    public String getDepartureStopNameZh() {
        return DepartureStopNameZh;
    }

    public void setDepartureStopNameZh(String DepartureStopNameZh) {
        this.DepartureStopNameZh = DepartureStopNameZh;
    }

    public String getRouteUID() {
        return RouteUID;
    }

    public void setRouteUID(String RouteUID) {
        this.RouteUID = RouteUID;
    }

    public String getRouteID() {
        return RouteID;
    }

    public void setRouteID(String RouteID) {
        this.RouteID = RouteID;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getDepartureStopNameEn() {
        return DepartureStopNameEn;
    }

    public void setDepartureStopNameEn(String DepartureStopNameEn) {
        this.DepartureStopNameEn = DepartureStopNameEn;
    }

    public String getTicketPriceDescriptionZh() {
        return TicketPriceDescriptionZh;
    }

    public void setTicketPriceDescriptionZh(String TicketPriceDescriptionZh) {
        this.TicketPriceDescriptionZh = TicketPriceDescriptionZh;
    }

    public String getDestinationStopNameEn() {
        return DestinationStopNameEn;
    }

    public void setDestinationStopNameEn(String DestinationStopNameEn) {
        this.DestinationStopNameEn = DestinationStopNameEn;
    }

    public String getTicketPriceDescriptionEn() {
        return TicketPriceDescriptionEn;
    }

    public void setTicketPriceDescriptionEn(String TicketPriceDescriptionEn) {
        this.TicketPriceDescriptionEn = TicketPriceDescriptionEn;
    }

    public ArrayList<NameType> getSubRoutes() {
        return SubRoutes;
    }

    public void setSubRoutes(ArrayList<NameType> SubRoutes) {
        this.SubRoutes = SubRoutes;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String UpdateTime) {
        this.UpdateTime = UpdateTime;
    }

    public NameType getRouteName() {
        return RouteName;
    }

    public void setRouteName(NameType RouteName) {
        this.RouteName = RouteName;
    }

    public String getFareBufferZoneDescriptionZh() {
        return FareBufferZoneDescriptionZh;
    }

    public void setFareBufferZoneDescriptionZh(String FareBufferZoneDescriptionZh) {
        this.FareBufferZoneDescriptionZh = FareBufferZoneDescriptionZh;
    }

    public String getDestinationStopNameZh() {
        return DestinationStopNameZh;
    }

    public void setDestinationStopNameZh(String DestinationStopNameZh) {
        this.DestinationStopNameZh = DestinationStopNameZh;
    }

    @Override
    public String toString() {
        return "BusRoute{" +
                "ProviderID='" + ProviderID + '\'' +
                ", CityCode='" + CityCode + '\'' +
                ", VersionID='" + VersionID + '\'' +
                ", FareBufferZoneDescriptionEn='" + FareBufferZoneDescriptionEn + '\'' +
                ", RouteOperator=" + Operators +
                ", BusRouteType='" + BusRouteType + '\'' +
                ", AuthorityID='" + AuthorityID + '\'' +
                ", HasSubRoutes='" + HasSubRoutes + '\'' +
                ", DepartureStopNameZh='" + DepartureStopNameZh + '\'' +
                ", RouteUID='" + RouteUID + '\'' +
                ", RouteID='" + RouteID + '\'' +
                ", City='" + City + '\'' +
                ", DepartureStopNameEn='" + DepartureStopNameEn + '\'' +
                ", TicketPriceDescriptionZh='" + TicketPriceDescriptionZh + '\'' +
                ", DestinationStopNameEn='" + DestinationStopNameEn + '\'' +
                ", TicketPriceDescriptionEn='" + TicketPriceDescriptionEn + '\'' +
                ", BusSubRoute=" + SubRoutes +
                ", UpdateTime='" + UpdateTime + '\'' +
                ", RouteName=" + RouteName +
                ", FareBufferZoneDescriptionZh='" + FareBufferZoneDescriptionZh + '\'' +
                ", DestinationStopNameZh='" + DestinationStopNameZh + '\'' +
                '}';
    }
}
