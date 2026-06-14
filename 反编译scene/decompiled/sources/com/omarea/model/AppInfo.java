package com.omarea.model;

import a.d70;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class AppInfo extends d70.a {
    public AppType appType;
    public CharSequence desc;
    public Boolean enabled;
    public int minSdkVersion;
    public Boolean suspended;
    public int targetSdkVersion;
    public Boolean updated;
    public int versionCode;
    public String versionName;
    public CharSequence stateTags = "";
    public CharSequence path = "";
    public CharSequence dir = "";

    public enum AppType {
        UNKNOW,
        USER,
        SYSTEM,
        BACKUPFILE
    }

    public AppInfo() {
        Boolean bool = Boolean.FALSE;
        this.enabled = bool;
        this.suspended = bool;
        this.updated = bool;
        this.versionName = "";
        this.versionCode = 0;
        this.appType = AppType.UNKNOW;
    }

    public static AppInfo getItem() {
        return new AppInfo();
    }
}
