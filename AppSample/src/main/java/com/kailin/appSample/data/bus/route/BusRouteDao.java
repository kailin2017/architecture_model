package com.kailin.appSample.data.bus.route;

import com.kailin.appSample.data.bus.BusCity;
import com.kailin.appSample.data.bus.BusCityConverters;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.TypeConverters;
import androidx.room.Update;
import io.reactivex.Observable;

@Dao
public interface BusRouteDao {


    @Query("SELECT count(*) FROM BusRoute")
    int getBusRouteCount();

    @Query("SELECT count(*) FROM BusRoute WHERE VersionID < :versionId")
    int getOldBusRoute(int versionId);

    @Query("SELECT * FROM BusRoute")
    Observable<List<BusRoute>> getBusRoutes();

    @Query("SELECT * FROM BusRoute WHERE RouteName LIKE '%' || :routeName || '%' LIMIT 50")
    Observable<List<BusRoute>> getBusRoutes(String routeName);

    @Query("SELECT * FROM BusRoute WHERE City IN (:busCities) AND RouteName LIKE '%' || :routeName || '%' LIMIT 50")
    Observable<List<BusRoute>> getBusRoutes(String routeName, @TypeConverters(BusCityConverters.class) BusCity... busCities);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insert(List<BusRoute> busRoutes);

    @Update
    int update(BusRoute... busRoutes);

    @Delete
    int delete(BusRoute... busRoutes);
}
