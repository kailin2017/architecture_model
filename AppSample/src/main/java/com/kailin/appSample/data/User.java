package com.kailin.appSample.data;

import android.content.Context;

import com.kailin.architecture_model.util.CheckEmulatorUtil;
import com.kailin.architecture_model.util.CheckProxyUtil;
import com.kailin.architecture_model.util.CheckRootUtil;
import com.kailin.architecture_model.util.LoggerUtil;
import com.kailin.architecture_model.util.NetworkInfoUtil;
import com.kailin.architecture_model.util.UUIDUtil;

public final class User {

    private final String name;
    private final boolean isEmulator;
    private final boolean isProxy;
    private final boolean isRoot;
    private final String IPAddress;
    private final String MacAddress;
    private final String UUid;

    public User(String name, Context context) {
        this.name = name;
        this.isEmulator = CheckEmulatorUtil.getInstance().isEmulator();
        this.isProxy = CheckProxyUtil.getInstance().isProxy();
        this.isRoot = CheckRootUtil.getInstance().isRooted();
        NetworkInfoUtil networkInfoUtil = NetworkInfoUtil.getInstance();
        this.IPAddress = networkInfoUtil.getIPAddress(context);
        this.MacAddress = networkInfoUtil.getMacAddress();
        this.UUid = UUIDUtil.getInstance(context).getUUID();
        LoggerUtil.getInstance().d(toString());
    }

    public String getName() {
        return name;
    }

    public boolean isEmulator() {
        return isEmulator;
    }

    public boolean isProxy() {
        return isProxy;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public String getMacAddress() {
        return MacAddress;
    }

    public String getUUid() {
        return UUid;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", isEmulator=" + isEmulator +
                ", isProxy=" + isProxy +
                ", isRoot=" + isRoot +
                ", IPAddress='" + IPAddress + '\'' +
                ", MacAddress='" + MacAddress + '\'' +
                ", UUid='" + UUid + '\'' +
                '}';
    }
}
