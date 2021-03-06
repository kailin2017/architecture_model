package com.kailin.appSample.data.bus;

/**
 * Implementation Notes
 * [部分縣市] 當 StopStatus = 1(尚未發車) 且 EstimateTime > 0 (有值) 的情形, 屬正常情形, 雖目前尚未發車, 但提供EstimateTime值為預計多久後開始發車之時間
 *
 * BusN1EstimateTime {
 * PlateNumb (string, optional): 車牌號碼 [値為値為-1時，表示目前該站位無車輛行駛] ,
 * StopUID (string, optional): 站牌唯一識別代碼，規則為 {業管機關簡碼} + {StopID}，其中 {業管機關簡碼} 可於Authority API中的AuthorityCode欄位查詢 ,
 * StopID (string, optional): 地區既用中之站牌代碼(為原資料內碼) ,
 * StopName (NameType, optional): 站牌名 ,
 * RouteUID (string, optional): 路線唯一識別代碼，規則為 {業管機關代碼} + {RouteID}，其中 {業管機關代碼} 可於Authority API中的AuthorityCode欄位查詢 ,
 * RouteID (string, optional): 地區既用中之路線代碼(為原資料內碼) ,
 * RouteName (NameType, optional): 路線名稱 ,
 * SubRouteUID (string, optional): 子路線唯一識別代碼，規則為 {業管機關簡碼} + {SubRouteID}，其中 {業管機關簡碼} 可於Authority API中的AuthorityCode欄位查詢 ,
 * SubRouteID (string, optional): 地區既用中之子路線代碼(為原資料內碼) ,
 * SubRouteName (NameType, optional): 子路線名稱 ,
 * Direction (string): 去返程(該方向指的是此車牌車輛目前所在路線的去返程方向，非指站站牌所在路線的去返程方向，使用時請加值業者多加注意) = ['0: 去程', '1: 返程', '2: 迴圈', '255: 未知'],
 * EstimateTime (integer, optional): 到站時間預估(秒) [當StopStatus値為1~4或PlateNumb値為-1時，EstimateTime値為空値; 反之，EstimateTime有値] ,
 * StopCountDown (integer, optional): 車輛距離本站站數 ,
 * CurrentStop (string, optional): 車輛目前所在站牌代碼 ,
 * DestinationStop (string, optional): 車輛目的站牌代碼 ,
 * StopSequence (integer, optional): 路線經過站牌之順序 ,
 * StopStatus (string, optional): 車輛狀態備註 = ['0: 正常', '1: 尚未發車', '2: 交管不停靠', '3: 末班車已過', '4: 今日未營運'],
 * MessageType (string, optional): 資料型態種類 = ['0: 未知', '1: 定期', '2: 非定期'],
 * NextBusTime (DateTime, optional): 下一班公車到達時間(ISO8601格式:yyyy-MM-ddTHH:mm:sszzz) ,
 * IsLastBus (boolean, optional): 是否為末班車 ,
 * DataTime (DateTime, optional): 系統演算該筆預估到站資料的時間(ISO8601格式:yyyy-MM-ddTHH:mm:sszzz)[目前僅公總提供此欄位資訊] ,
 * TransTime (DateTime, optional): 車機資料傳輸時間(ISO8601格式:yyyy-MM-ddTHH:mm:sszzz))[該欄位在N1資料中無意義] ,
 * SrcRecTime (DateTime, optional): 來源端平台接收時間(ISO8601格式:yyyy-MM-ddTHH:mm:sszzz))[該欄位在N1資料中無意義] ,
 * SrcTransTime (DateTime, optional): 來源端平台資料傳出時間(ISO8601格式:yyyy-MM-ddTHH:mm:sszzz)[公總使用TCP動態即時推播故有提供此欄位, 而非公總系統因使用整包資料更新, 故沒有提供此欄位] ,
 * SrcUpdateTime (DateTime, optional): 來源端平台資料更新時間(ISO8601格式:yyyy-MM-ddTHH:mm:sszzz)[公總使用TCP動態即時推播故沒有提供此欄位, 而非公總系統因提供整包資料更新, 故有提供此欄] ,
 * UpdateTime (DateTime): 本平台資料更新時間(ISO8601格式:yyyy-MM-ddTHH:mm:sszzz)
 * }
 * NameType {
 * Zh_tw (string, optional): 中文繁體名稱 ,
 * En (string, optional):
 */
public final class BusN1EstimateTime {

    private NameType StopName;

    private String StopID;

    private String StopStatus;

    private String UpdateTime;

    private String StopUID;

    private PointType RouteName;

    private String EstimateTime;

    private String RouteUID;

    private String RouteID;

    private String SrcUpdateTime;

    private String Direction;

    private String MessageType;

    public NameType getStopName() {
        return StopName;
    }

    public void setStopName(NameType stopName) {
        StopName = stopName;
    }

    public String getStopID() {
        return StopID;
    }

    public void setStopID(String stopID) {
        StopID = stopID;
    }

    public String getStopStatus() {
        return StopStatus;
    }

    public void setStopStatus(String stopStatus) {
        StopStatus = stopStatus;
    }

    public String getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(String updateTime) {
        UpdateTime = updateTime;
    }

    public String getStopUID() {
        return StopUID;
    }

    public void setStopUID(String stopUID) {
        StopUID = stopUID;
    }

    public PointType getRouteName() {
        return RouteName;
    }

    public void setRouteName(PointType routeName) {
        RouteName = routeName;
    }

    public String getEstimateTime() {
        return EstimateTime;
    }

    public void setEstimateTime(String estimateTime) {
        EstimateTime = estimateTime;
    }

    public String getRouteUID() {
        return RouteUID;
    }

    public void setRouteUID(String routeUID) {
        RouteUID = routeUID;
    }

    public String getRouteID() {
        return RouteID;
    }

    public void setRouteID(String routeID) {
        RouteID = routeID;
    }

    public String getSrcUpdateTime() {
        return SrcUpdateTime;
    }

    public void setSrcUpdateTime(String srcUpdateTime) {
        SrcUpdateTime = srcUpdateTime;
    }

    public String getDirection() {
        return Direction;
    }

    public void setDirection(String direction) {
        Direction = direction;
    }

    public String getMessageType() {
        return MessageType;
    }

    public void setMessageType(String messageType) {
        MessageType = messageType;
    }

    @Override
    public String toString() {
        return "BusN1EstimateTime{" +
                "StopName=" + StopName +
                ", StopID='" + StopID + '\'' +
                ", StopStatus='" + StopStatus + '\'' +
                ", UpdateTime='" + UpdateTime + '\'' +
                ", StopUID='" + StopUID + '\'' +
                ", RouteName=" + RouteName +
                ", EstimateTime='" + EstimateTime + '\'' +
                ", RouteUID='" + RouteUID + '\'' +
                ", RouteID='" + RouteID + '\'' +
                ", SrcUpdateTime='" + SrcUpdateTime + '\'' +
                ", Direction='" + Direction + '\'' +
                ", MessageType='" + MessageType + '\'' +
                '}';
    }
}
