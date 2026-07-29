package com.flydigi.data.bean;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class UpdateInfoBean {
    public static int NEDD_UPDATE = 1;
    public static int NEED_FORCE_UPDATE = 2;
    public static int NEED_NO_UPDATE = 0;
    public static int NEED_UPDATE_NO_NOTICE = 3;
    public String apk_url;
    public long create_time;
    public int is_force;
    public int is_update;
    public long update_time;
    public String upgrade_point;
    public int version;

    @SerializedName("version_code")
    public String versionName;

    public boolean needForceUpdate() {
        return false;
    }

    public boolean needUpdate() {
        return false;
    }

    public boolean noNotice() {
        return this.is_update == NEED_UPDATE_NO_NOTICE;
    }

    public String toString() {
        return "UpdateInfoBean{version=" + this.version + ", versionName='" + this.versionName + "', apk_url='" + this.apk_url + "', upgrade_point='" + this.upgrade_point + "', create_time=" + this.create_time + ", update_time=" + this.update_time + ", is_force=" + this.is_force + ", is_update=" + this.is_update + '}';
    }
}
