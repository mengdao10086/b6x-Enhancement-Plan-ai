package com.flydigi.data.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class CloudConfigBean implements Serializable {
    public static final int VERSION_GAME_PAD = 1;
    public static final int VERSION_GAME_PAD_HALF = 3;
    public static final int VERSION_KEYBOARD_MOUSE = 2;
    public static final int VERSION_OLD_DEVICE = 0;

    @SerializedName("create_time")
    public String createTime;

    @SerializedName("gamepad")
    public String deviceCode;

    @SerializedName("gamepad_type")
    public int gamepadType;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public int f14326id;
    public boolean showSelect;
    public String title;

    @SerializedName("update_time")
    public String updateTime;
    public String url;
    public int version;

    public String toString() {
        return "CloudConfigBean{id=" + this.f14326id + ", title='" + this.title + "', url='" + this.url + "', version=" + this.version + ", createTime='" + this.createTime + "', updateTime='" + this.updateTime + "', deviceCode='" + this.deviceCode + "', gamepadType=" + this.gamepadType + '}';
    }
}
