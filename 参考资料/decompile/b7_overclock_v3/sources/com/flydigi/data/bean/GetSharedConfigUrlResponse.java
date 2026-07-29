package com.flydigi.data.bean;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class GetSharedConfigUrlResponse {

    @SerializedName("pkgname")
    private String packageName;
    private String url;

    public String getPackageName() {
        return this.packageName;
    }

    public String getUrl() {
        return this.url;
    }
}
