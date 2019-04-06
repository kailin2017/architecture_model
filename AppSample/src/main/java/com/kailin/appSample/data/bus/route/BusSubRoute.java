package com.kailin.appSample.data.bus.route;

import com.kailin.appSample.data.bus.Direction;
import com.kailin.appSample.data.bus.NameType;

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

    private String SubRouteID;

    private String[] OperatorIDs;

    private NameType SubRouteName;

    private Direction Direction;

    private String FirstBusTime;

    private String LastBusTime;

    private String HolidayFirstBusTime;

    public String getSubRouteUID() {
        return SubRouteUID;
    }

    public void setSubRouteUID(String subRouteUID) {
        SubRouteUID = subRouteUID;
    }

    public String getSubRouteID() {
        return SubRouteID;
    }

    public void setSubRouteID(String subRouteID) {
        SubRouteID = subRouteID;
    }

    public String[] getOperatorIDs() {
        return OperatorIDs;
    }

    public void setOperatorIDs(String[] operatorIDs) {
        OperatorIDs = operatorIDs;
    }

    public NameType getSubRouteName() {
        return SubRouteName;
    }

    public void setSubRouteName(NameType subRouteName) {
        SubRouteName = subRouteName;
    }

    public com.kailin.appSample.data.bus.Direction getDirection() {
        return Direction;
    }

    public void setDirection(com.kailin.appSample.data.bus.Direction direction) {
        Direction = direction;
    }

    public String getFirstBusTime() {
        return FirstBusTime;
    }

    public void setFirstBusTime(String firstBusTime) {
        FirstBusTime = firstBusTime;
    }

    public String getLastBusTime() {
        return LastBusTime;
    }

    public void setLastBusTime(String lastBusTime) {
        LastBusTime = lastBusTime;
    }

    public String getHolidayFirstBusTime() {
        return HolidayFirstBusTime;
    }

    public void setHolidayFirstBusTime(String holidayFirstBusTime) {
        HolidayFirstBusTime = holidayFirstBusTime;
    }

    @Override
    public String toString() {
        return "BusSubRoute{" +
                "SubRouteUID='" + SubRouteUID + '\'' +
                ", SubRouteID='" + SubRouteID + '\'' +
                ", OperatorIDs=" + Arrays.toString(OperatorIDs) +
                ", SubRouteName=" + SubRouteName +
                ", Direction=" + Direction +
                ", FirstBusTime='" + FirstBusTime + '\'' +
                ", LastBusTime='" + LastBusTime + '\'' +
                ", HolidayFirstBusTime='" + HolidayFirstBusTime + '\'' +
                '}';
    }
}
