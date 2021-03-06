package com.kailin.appSample.data.bus.route;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.kailin.appSample.data.bus.BusCity;
import com.kailin.appSample.data.bus.BusCityConverters;
import com.kailin.appSample.data.bus.DateTypeConverters;
import com.kailin.appSample.data.bus.NameType;
import com.kailin.appSample.data.bus.NameTypeConverters;
import com.kailin.appSample.data.bus.RouteOperator;
import com.kailin.appSample.data.bus.RouteOperatorConverters;

import java.util.ArrayList;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

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
@Entity(tableName = BusRoute.ROOM_TABLE_NAME)
public final class BusRoute {

    public final static String ROOM_TABLE_NAME = "BusRoute";

    @PrimaryKey
    @NonNull
    @SerializedName("RouteUID")
    private String RouteUID;

    private String RouteID;

    private boolean HasSubRoutes;

    @TypeConverters(RouteOperatorConverters.class)
    private ArrayList<RouteOperator> Operators;

    private String AuthorityID;

    private String ProviderID;

    @TypeConverters(BusSubRouteConverters.class)
    private ArrayList<BusSubRoute> SubRoutes;

    @TypeConverters(BusRouteTypeConverters.class)
    private BusRouteType BusRouteType;

    @TypeConverters(NameTypeConverters.class)
    private NameType RouteName;

    private String DepartureStopNameZh;

    private String DepartureStopNameEn;

    private String DestinationStopNameZh;

    private String DestinationStopNameEn;

    private String TicketPriceDescriptionZh;

    private String TicketPriceDescriptionEn;

    private String FareBufferZoneDescriptionZh;

    private String FareBufferZoneDescriptionEn;

    private String RouteMapImageUrl;

    @TypeConverters(BusCityConverters.class)
    private BusCity City;

    private String CityCode;

    @TypeConverters(DateTypeConverters.class)
    private Date UpdateTime;

    private int VersionID;

    public BusRoute() {
    }

    @NonNull
    public String getRouteUID() {
        return RouteUID;
    }

    public void setRouteUID(@NonNull String routeUID) {
        RouteUID = routeUID;
    }

    public String getRouteID() {
        return RouteID;
    }

    public void setRouteID(String routeID) {
        RouteID = routeID;
    }

    public boolean isHasSubRoutes() {
        return HasSubRoutes;
    }

    public void setHasSubRoutes(boolean hasSubRoutes) {
        HasSubRoutes = hasSubRoutes;
    }

    public ArrayList<RouteOperator> getOperators() {
        return Operators;
    }

    public void setOperators(ArrayList<RouteOperator> operators) {
        Operators = operators;
    }

    public String getAuthorityID() {
        return AuthorityID;
    }

    public void setAuthorityID(String authorityID) {
        AuthorityID = authorityID;
    }

    public String getProviderID() {
        return ProviderID;
    }

    public void setProviderID(String providerID) {
        ProviderID = providerID;
    }

    public ArrayList<BusSubRoute> getSubRoutes() {
        return SubRoutes;
    }

    public void setSubRoutes(ArrayList<BusSubRoute> subRoutes) {
        SubRoutes = subRoutes;
    }

    public com.kailin.appSample.data.bus.route.BusRouteType getBusRouteType() {
        return BusRouteType;
    }

    public void setBusRouteType(com.kailin.appSample.data.bus.route.BusRouteType busRouteType) {
        BusRouteType = busRouteType;
    }

    public NameType getRouteName() {
        return RouteName;
    }

    public void setRouteName(NameType routeName) {
        RouteName = routeName;
    }

    public String getDepartureStopNameZh() {
        return DepartureStopNameZh;
    }

    public void setDepartureStopNameZh(String departureStopNameZh) {
        DepartureStopNameZh = departureStopNameZh;
    }

    public String getDepartureStopNameEn() {
        return DepartureStopNameEn;
    }

    public void setDepartureStopNameEn(String departureStopNameEn) {
        DepartureStopNameEn = departureStopNameEn;
    }

    public String getDestinationStopNameZh() {
        return DestinationStopNameZh;
    }

    public void setDestinationStopNameZh(String destinationStopNameZh) {
        DestinationStopNameZh = destinationStopNameZh;
    }

    public String getDestinationStopNameEn() {
        return DestinationStopNameEn;
    }

    public void setDestinationStopNameEn(String destinationStopNameEn) {
        DestinationStopNameEn = destinationStopNameEn;
    }

    public String getTicketPriceDescriptionZh() {
        return TicketPriceDescriptionZh;
    }

    public void setTicketPriceDescriptionZh(String ticketPriceDescriptionZh) {
        TicketPriceDescriptionZh = ticketPriceDescriptionZh;
    }

    public String getTicketPriceDescriptionEn() {
        return TicketPriceDescriptionEn;
    }

    public void setTicketPriceDescriptionEn(String ticketPriceDescriptionEn) {
        TicketPriceDescriptionEn = ticketPriceDescriptionEn;
    }

    public String getFareBufferZoneDescriptionZh() {
        return FareBufferZoneDescriptionZh;
    }

    public void setFareBufferZoneDescriptionZh(String fareBufferZoneDescriptionZh) {
        FareBufferZoneDescriptionZh = fareBufferZoneDescriptionZh;
    }

    public String getFareBufferZoneDescriptionEn() {
        return FareBufferZoneDescriptionEn;
    }

    public void setFareBufferZoneDescriptionEn(String fareBufferZoneDescriptionEn) {
        FareBufferZoneDescriptionEn = fareBufferZoneDescriptionEn;
    }

    public String getRouteMapImageUrl() {
        return RouteMapImageUrl;
    }

    public void setRouteMapImageUrl(String routeMapImageUrl) {
        RouteMapImageUrl = routeMapImageUrl;
    }

    public BusCity getCity() {
        return City;
    }

    public void setCity(BusCity city) {
        City = city;
    }

    public String getCityCode() {
        return CityCode;
    }

    public void setCityCode(String cityCode) {
        CityCode = cityCode;
    }

    public Date getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(Date updateTime) {
        UpdateTime = updateTime;
    }

    public int getVersionID() {
        return VersionID;
    }

    public void setVersionID(int versionID) {
        VersionID = versionID;
    }

    @Override
    public String toString() {
        return "BusRoute{" +
                "RouteUID='" + RouteUID + '\'' +
                ", RouteID='" + RouteID + '\'' +
                ", HasSubRoutes=" + HasSubRoutes +
                ", Operators=" + Operators +
                ", AuthorityID='" + AuthorityID + '\'' +
                ", ProviderID='" + ProviderID + '\'' +
                ", SubRoutes=" + SubRoutes +
                ", BusRouteType=" + BusRouteType +
                ", RouteName=" + RouteName +
                ", DepartureStopNameZh='" + DepartureStopNameZh + '\'' +
                ", DepartureStopNameEn='" + DepartureStopNameEn + '\'' +
                ", DestinationStopNameZh='" + DestinationStopNameZh + '\'' +
                ", DestinationStopNameEn='" + DestinationStopNameEn + '\'' +
                ", TicketPriceDescriptionZh='" + TicketPriceDescriptionZh + '\'' +
                ", TicketPriceDescriptionEn='" + TicketPriceDescriptionEn + '\'' +
                ", FareBufferZoneDescriptionZh='" + FareBufferZoneDescriptionZh + '\'' +
                ", FareBufferZoneDescriptionEn='" + FareBufferZoneDescriptionEn + '\'' +
                ", RouteMapImageUrl='" + RouteMapImageUrl + '\'' +
                ", City=" + City +
                ", CityCode='" + CityCode + '\'' +
                ", UpdateTime=" + UpdateTime +
                ", VersionID=" + VersionID +
                '}';
    }
}
