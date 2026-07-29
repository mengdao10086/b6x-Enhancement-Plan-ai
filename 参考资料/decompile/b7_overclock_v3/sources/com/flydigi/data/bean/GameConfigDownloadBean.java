package com.flydigi.data.bean;

import androidx.constraintlayout.widget.d;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class GameConfigDownloadBean {

    @SerializedName("update_time")
    public long data;

    @SerializedName("pkgname")
    public String pkgName;

    @SerializedName(d.U1)
    public String ratio;
    public String url;

    public String toString() {
        return "GameConfigDownloadBean{data=" + this.data + ", url='" + this.url + "', ratio='" + this.ratio + "', pkgName='" + this.pkgName + "'}";
    }
}
