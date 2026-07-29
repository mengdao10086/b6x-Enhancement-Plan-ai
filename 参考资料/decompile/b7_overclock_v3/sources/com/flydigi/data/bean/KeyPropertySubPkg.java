package com.flydigi.data.bean;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class KeyPropertySubPkg {
    public HashMap<String, KeyPropertySubPkgConfig> config;

    @SerializedName("pkgname")
    public String pkgName;
    public String title;

    @SerializedName("update_time")
    public long updateTime;

    public String toString() {
        return "KeyPropertySubPkg{title='" + this.title + "', pkgName='" + this.pkgName + "', config=" + this.config + ", updateTime=" + this.updateTime + '}';
    }
}
