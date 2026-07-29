package com.flydigi.data.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class GameStrategyBean implements Serializable {
    public List<CategoryBean> config;

    @SerializedName("pkgname")
    public String pkgName;
    public String title;

    @SerializedName("update_time")
    public long updateTime;
    public long version;

    public static class CategoryBean {
        public String button;
        public String url;

        public String toString() {
            return "CategoryBean{url='" + this.url + "', button='" + this.button + "'}";
        }
    }

    public String toString() {
        return "GameStrategyBean{title='" + this.title + "', pkgName='" + this.pkgName + "', updateTime=" + this.updateTime + ", version=" + this.version + ", config=" + this.config + '}';
    }
}
