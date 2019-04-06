package com.kailin.appSample.data.bus;

import com.google.gson.annotations.SerializedName;

/**
 *  Enum:	"0: 去程", "1: 返程", "2: 迴圈", "255: 未知"
 */
public enum Direction {

    @SerializedName("0")
    GOING,

    @SerializedName("1")
    RETURN,

    @SerializedName("2")
    CYCLE,

    @SerializedName("255")
    UNKNOWN
}
