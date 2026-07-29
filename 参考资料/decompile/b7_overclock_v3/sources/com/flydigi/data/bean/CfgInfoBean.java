package com.flydigi.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import db.d;

/* JADX INFO: loaded from: classes7.dex */
public class CfgInfoBean implements Parcelable {
    public static final Parcelable.Creator<CfgInfoBean> CREATOR = new Parcelable.Creator<CfgInfoBean>() { // from class: com.flydigi.data.bean.CfgInfoBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CfgInfoBean createFromParcel(Parcel source) {
            return new CfgInfoBean(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CfgInfoBean[] newArray(int size) {
            return new CfgInfoBean[size];
        }
    };
    public static final int TYPE_GAME_PAD = 1;
    public static final int TYPE_GAME_PAD_HALF = 3;
    public static final int TYPE_KEYBOARD = 2;

    @SerializedName("down_url")
    private String downUrl;

    @SerializedName("downnum")
    private int downnum;

    @SerializedName("game_name")
    private String gameName;

    @SerializedName("gamepad")
    private String gamepad;

    @SerializedName("gamepad_type")
    private int gamepadType;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private int f14324id;

    @SerializedName(Constants.PARAM_MODEL_NAME)
    private String modelName;

    /* JADX INFO: renamed from: os, reason: collision with root package name */
    @SerializedName("os")
    private String f14325os;

    @SerializedName("pkgname")
    private String pkgname;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String url;

    @SerializedName(d.f26139i)
    private int version;

    public CfgInfoBean() {
    }

    public static int convertLocalDeviceTypeToNet(int type) {
        if (type == 0) {
            return 1;
        }
        if (type == 1) {
            return 2;
        }
        return type == 2 ? 3 : 1;
    }

    public static int convertNetDeviceTypeToLocal(int type) {
        if (type == 1) {
            return 0;
        }
        if (type == 2) {
            return 1;
        }
        return type == 3 ? 2 : 0;
    }

    public int convertNetDeviceTypeToLocal() {
        int i10 = this.version;
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        return i10 == 3 ? 2 : 0;
    }

    public int convertVersionToCloudLocal() {
        int i10 = this.version;
        if (i10 == 1) {
            return 1;
        }
        if (i10 == 2) {
            return 2;
        }
        return i10 == 3 ? 3 : 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getConfigDeviceType() {
        int i10 = this.version;
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 3) {
            return 2;
        }
        return i10 == 2 ? 1 : 0;
    }

    public String getDownUrl() {
        return this.downUrl;
    }

    public int getDownnum() {
        return this.downnum;
    }

    public String getGameName() {
        return this.gameName;
    }

    public String getGamepad() {
        return this.gamepad;
    }

    public int getGamepadType() {
        return this.gamepadType;
    }

    public int getId() {
        return this.f14324id;
    }

    public String getModelName() {
        return this.modelName;
    }

    public String getOs() {
        return this.f14325os;
    }

    public String getPkgname() {
        return this.pkgname;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public int getVersion() {
        return this.version;
    }

    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl;
    }

    public void setDownnum(int downnum) {
        this.downnum = downnum;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setGamepad(String gamepad) {
        this.gamepad = gamepad;
    }

    public void setGamepadType(int gamepadType) {
        this.gamepadType = gamepadType;
    }

    public void setId(int id2) {
        this.f14324id = id2;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setOs(String os2) {
        this.f14325os = os2;
    }

    public void setPkgname(String pkgname) {
        this.pkgname = pkgname;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.f14324id);
        dest.writeString(this.title);
        dest.writeInt(this.downnum);
        dest.writeString(this.url);
        dest.writeString(this.f14325os);
        dest.writeString(this.gameName);
        dest.writeString(this.gamepad);
        dest.writeInt(this.gamepadType);
        dest.writeString(this.pkgname);
        dest.writeInt(this.version);
        dest.writeString(this.modelName);
        dest.writeString(this.downUrl);
    }

    public CfgInfoBean(Parcel in2) {
        this.f14324id = in2.readInt();
        this.title = in2.readString();
        this.downnum = in2.readInt();
        this.url = in2.readString();
        this.f14325os = in2.readString();
        this.gameName = in2.readString();
        this.gamepad = in2.readString();
        this.gamepadType = in2.readInt();
        this.pkgname = in2.readString();
        this.version = in2.readInt();
        this.modelName = in2.readString();
        this.downUrl = in2.readString();
    }
}
