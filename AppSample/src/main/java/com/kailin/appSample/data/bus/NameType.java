package com.kailin.appSample.data.bus;

/**
 * NameType {
 * Zh_tw (string, optional): 中文繁體名稱 ,
 * En (string, optional): 英文名稱
 * }
 */

public final class NameType {

    private String Zh_tw;

    private String En;

    public String getZh_tw() {
        return Zh_tw;
    }

    public void setZh_tw(String Zh_tw) {
        this.Zh_tw = Zh_tw;
    }

    public String getEn() {
        return En;
    }

    public void setEn(String En) {
        this.En = En;
    }

    @Override
    public String toString() {
        return "NameType{" +
                "Zh_tw='" + Zh_tw + '\'' +
                ", En='" + En + '\'' +
                '}';
    }
}
