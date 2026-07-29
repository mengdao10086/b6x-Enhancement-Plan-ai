package com.flydigi.data.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class KeyPropertyData implements Serializable {
    public HashMap<String, KeyPropertySubPkg> game;

    @SerializedName("update_time")
    public long updateTime;

    public String toString() {
        return "KeyPropertyData{game=" + this.game + ", updateTime=" + this.updateTime + '}';
    }
}
