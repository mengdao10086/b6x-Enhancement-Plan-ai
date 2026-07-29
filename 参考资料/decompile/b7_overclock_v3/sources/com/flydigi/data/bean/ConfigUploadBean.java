package com.flydigi.data.bean;

/* JADX INFO: loaded from: classes7.dex */
public class ConfigUploadBean {
    public int fid;
    private String gamepad;
    public String title;
    public String url;
    public int version;

    public String getGamepad() {
        return this.gamepad;
    }

    public void setGamepad(String gamepad) {
        this.gamepad = gamepad;
    }

    public String toString() {
        return "ConfigUploadBean{fid=" + this.fid + ", title='" + this.title + "', url='" + this.url + "', version=" + this.version + ", gamepad='" + this.gamepad + "'}";
    }
}
