package com.kailin.appSample.data.bus;

import com.kailin.appSample.data.bus.version.BusVersion;
import com.kailin.appSample.data.bus.version.BusVersionDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;
import java.util.Date;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

@RunWith(AndroidJUnit4.class)
public class BusVersionDaoTest {

    private BusVersionDao busVersionDao;
    private BusDatabase busDatabase;
    private final BusVersion busVersion = new BusVersion();
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void before() {
        busDatabase = Room
                .inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), BusDatabase.class)
                .allowMainThreadQueries()
                .build();
        busVersionDao = busDatabase.busVersionDao();
        Date date = Calendar.getInstance().getTime();
        busVersion.setBusCity("Taipei");
        busVersion.setVersionID(10);
        busVersion.setUpdateCheckTime(date);
        busVersion.setUpdateTime(date);
    }

    @After
    public void after() {
        busDatabase.close();
        busVersionDao = null;
    }

    @Test
    public void insert() {
        busVersionDao.insert(busVersion);
        busVersionDao.getBusVersion(busVersion.getBusCity()).test().assertValue(busVersion1 -> busVersion1.equals(this.busVersion));
    }

    @Test
    public void update() {
        busVersion.setVersionID(99);
        busVersionDao.update(busVersion);
    }

    @Test
    public void delete() {
        busVersionDao.delete(busVersion);
    }
}