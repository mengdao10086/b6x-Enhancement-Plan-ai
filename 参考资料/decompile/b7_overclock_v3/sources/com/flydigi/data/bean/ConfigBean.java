package com.flydigi.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.flydigi.sdk.gamepad.extension.config.data.CFGEntity;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public class ConfigBean implements Parcelable {
    public static final Parcelable.Creator<ConfigBean> CREATOR = new Parcelable.Creator<ConfigBean>() { // from class: com.flydigi.data.bean.ConfigBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConfigBean createFromParcel(Parcel in2) {
            return new ConfigBean(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConfigBean[] newArray(int size) {
            return new ConfigBean[size];
        }
    };

    @p0
    private CFGEntity cfgEntity;
    private String deviceCode;
    private String deviceName;
    private int deviceType;
    private String gameName;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f14327id;
    private String manufacturer;
    private String model;
    private String packageName;
    private String title;

    public ConfigBean(Parcel in2) {
        this.f14327id = in2.readInt();
        this.title = in2.readString();
        this.packageName = in2.readString();
        this.gameName = in2.readString();
        this.deviceName = in2.readString();
        this.deviceCode = in2.readString();
        this.deviceType = in2.readInt();
        this.manufacturer = in2.readString();
        this.model = in2.readString();
        this.cfgEntity = (CFGEntity) in2.readParcelable(CFGEntity.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CFGEntity getCfgEntity() {
        return this.cfgEntity;
    }

    public String getDeviceCode() {
        return this.deviceCode;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public String getGameName() {
        return this.gameName;
    }

    public int getId() {
        return this.f14327id;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCfgEntity(CFGEntity cfgEntity) {
        this.cfgEntity = cfgEntity;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setId(int id2) {
        this.f14327id = id2;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString() {
        return "ConfigBean{id=" + this.f14327id + ", title='" + this.title + "', packageName='" + this.packageName + "', gameName='" + this.gameName + "', deviceName='" + this.deviceName + "', deviceCode='" + this.deviceCode + "', deviceType=" + this.deviceType + ", manufacturer='" + this.manufacturer + "', model='" + this.model + "', cfgEntity=" + this.cfgEntity + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.f14327id);
        dest.writeString(this.title);
        dest.writeString(this.packageName);
        dest.writeString(this.gameName);
        dest.writeString(this.deviceName);
        dest.writeString(this.deviceCode);
        dest.writeInt(this.deviceType);
        dest.writeString(this.manufacturer);
        dest.writeString(this.model);
        dest.writeParcelable(this.cfgEntity, flags);
    }

    public ConfigBean() {
    }
}
