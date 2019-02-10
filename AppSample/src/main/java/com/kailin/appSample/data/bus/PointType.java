package com.kailin.appSample.data.bus;

/**
 * PointType {
 * PositionLat (number, optional): 位置緯度(WGS84) ,
 * PositionLon (number, optional): 位置經度(WGS84)
 * }
 */
public final class PointType {

    private String PositionLon;

    private String PositionLat;

    public String getPositionLon() {
        return PositionLon;
    }

    public void setPositionLon(String PositionLon) {
        this.PositionLon = PositionLon;
    }

    public String getPositionLat() {
        return PositionLat;
    }

    public void setPositionLat(String PositionLat) {
        this.PositionLat = PositionLat;
    }

    @Override
    public String toString() {
        return "PointType{" +
                "PositionLon='" + PositionLon + '\'' +
                ", PositionLat='" + PositionLat + '\'' +
                '}';
    }
}
