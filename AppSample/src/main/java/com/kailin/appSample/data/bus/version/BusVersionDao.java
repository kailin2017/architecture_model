package com.kailin.appSample.data.bus.version;

import com.kailin.appSample.data.bus.DateTypeConverters;

import java.util.Date;
import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.TypeConverters;
import androidx.room.Update;
import io.reactivex.Flowable;

@Dao
public interface BusVersionDao {

    @Query("SELECT * FROM BUSVERSION WHERE BusCity = :BusCity AND UpdateTime < :UpdateTime")
    BusVersion getBusVersion(String BusCity, @TypeConverters(DateTypeConverters.class) Date UpdateTime);

    @Query("SELECT * FROM BUSVERSION WHERE BusCity = :BusCity")
    BusVersion getBusVersion(String BusCity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insert(BusVersion... busVersions);

    @Update
    int update(BusVersion... busVersions);

    @Delete
    int delete(BusVersion... busVersions);
}
