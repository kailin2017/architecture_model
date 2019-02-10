package com.kailin.appSample.data.bus;

import java.util.Arrays;

/**
 * BusSubRoute {
 * SubRouteUID (string): 附屬路線唯一識別代碼，規則為 {業管機關簡碼} + {SubRouteID}，其中 {業管機關簡碼} 可於Authority API中的AuthorityCode欄位查詢 ,
 * SubRouteID (string): 地區既用中之附屬路線代碼(為原資料內碼) ,
 * OperatorIDs (Array[string]): 營運業者代碼 ,
 * SubRouteName (NameType): 附屬路線名稱 ,
 * Headsign (string, optional): 車頭描述 ,
 * Direction (string): 去返程 = ['0: 去程', '1: 返程', '2: 迴圈', '255: 未知']
 * string
 * Enum:	"0: 去程", "1: 返程", "2: 迴圈", "255: 未知"
 * ,
 * FirstBusTime (string, optional): 平日第一班發車時間 ,
 * LastBusTime (string, optional): 平日返程第一班發車時間 ,
 * HolidayFirstBusTime (string, optional): 假日去程第一班發車時間 ,
 * HolidayLastBusTime (string, optional): 假日返程第一班發車時間
 * }
 */

public final class BusSubRoute {

    private String SubRouteUID;

    private String FirstBusTime;

    private String HolidayFirstBusTime;

    private String LastBusTime;

    private String SubRouteID;

    private NameType SubRouteName;

    private String Direction;

    private String[] OperatorIDs;

    public String getSubRouteUID() {
        return SubRouteUID;
    }

    public void setSubRouteUID(String SubRouteUID) {
        this.SubRouteUID = SubRouteUID;
    }

    public String getFirstBusTime() {
        return FirstBusTime;
    }

    public void setFirstBusTime(String FirstBusTime) {
        this.FirstBusTime = FirstBusTime;
    }

    public String getHolidayFirstBusTime() {
        return HolidayFirstBusTime;
    }

    public void setHolidayFirstBusTime(String HolidayFirstBusTime) {
        this.HolidayFirstBusTime = HolidayFirstBusTime;
    }

    public String getLastBusTime() {
        return LastBusTime;
    }

    public void setLastBusTime(String LastBusTime) {
        this.LastBusTime = LastBusTime;
    }

    public String getSubRouteID() {
        return SubRouteID;
    }

    public void setSubRouteID(String SubRouteID) {
        this.SubRouteID = SubRouteID;
    }

    public NameType getSubRouteName() {
        return SubRouteName;
    }

    public void setSubRouteName(NameType SubRouteName) {
        this.SubRouteName = SubRouteName;
    }

    public String getDirection() {
        return Direction;
    }

    public void setDirection(String Direction) {
        this.Direction = Direction;
    }

    public String[] getOperatorIDs() {
        return OperatorIDs;
    }

    public void setOperatorIDs(String[] OperatorIDs) {
        this.OperatorIDs = OperatorIDs;
    }

    @Override
    public String toString() {
        return "BusSubRoute{" +
                "SubRouteUID='" + SubRouteUID + '\'' +
                ", FirstBusTime='" + FirstBusTime + '\'' +
                ", HolidayFirstBusTime='" + HolidayFirstBusTime + '\'' +
                ", LastBusTime='" + LastBusTime + '\'' +
                ", SubRouteID='" + SubRouteID + '\'' +
                ", SubRouteName=" + SubRouteName +
                ", Direction='" + Direction + '\'' +
                ", OperatorIDs=" + Arrays.toString(OperatorIDs) +
                '}';
    }
}
