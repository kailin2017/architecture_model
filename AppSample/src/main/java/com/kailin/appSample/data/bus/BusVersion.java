package com.kailin.appSample.data.bus;

import java.util.Date;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

/**
 * BusVersion {
 * VersionID (integer): 資料版本編號 ,
 * UpdateTime (DateTime): 資料更新日期時間(ISO8601格式:yyyy-MM-ddTHH:mm:sszzz) ,
 * UpdateCheckTime (DateTime): 資料最後檢核更新之日期時間(ISO8601格式:yyyy-MM-ddTHH:mm:sszzz)
 * }
 */
@Entity(tableName = BusVersion.ROOM_TABLE_NAME)
public final class BusVersion {

    public final static String ROOM_TABLE_NAME = "BusVersion";

    @PrimaryKey
    @NonNull
    private String BusCity;

    private int VersionID;

    @TypeConverters(DateTypeConverters.class)
    private Date UpdateTime;

    @TypeConverters(DateTypeConverters.class)
    private Date UpdateCheckTime;

    public String getBusCity() {
        return BusCity;
    }

    public void setBusCity(String busCity) {
        BusCity = busCity;
    }

    public int getVersionID() {
        return VersionID;
    }

    public void setVersionID(int versionID) {
        VersionID = versionID;
    }

    public Date getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(Date updateTime) {
        UpdateTime = updateTime;
    }

    public Date getUpdateCheckTime() {
        return UpdateCheckTime;
    }

    public void setUpdateCheckTime(Date updateCheckTime) {
        UpdateCheckTime = updateCheckTime;
    }

    @Override
    public String toString() {
        return "BusVersion{" +
                "BusCity='" + BusCity + '\'' +
                ", VersionID=" + VersionID +
                ", UpdateTime=" + UpdateTime +
                ", UpdateCheckTime=" + UpdateCheckTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusVersion that = (BusVersion) o;
        return VersionID == that.VersionID &&
                Objects.equals(BusCity, that.BusCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(BusCity, VersionID);
    }
}
