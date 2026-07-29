package com.flydigi.action;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LogAction implements Serializable, Parcelable {
    public String action;
    public String connectMode;
    public String connectStatus;
    public String connectType;
    public String deviceMac;
    public String deviceName;
    public String driverVersion;
    public String firmwareVersion;
    public String phoneBrand;
    public String phoneId;
    public String phoneModel;
    public long timestamp;

    public LogAction() {
        this.timestamp = System.currentTimeMillis();
    }

    public void A0(final long timestamp) {
        this.timestamp = timestamp;
    }

    public String C() {
        return this.connectType;
    }

    public String M() {
        return this.deviceMac;
    }

    public String T() {
        return this.deviceName;
    }

    public String U() {
        return this.driverVersion;
    }

    public String W() {
        return this.firmwareVersion;
    }

    public String X() {
        return this.phoneBrand;
    }

    public String Z() {
        return this.phoneId;
    }

    public String a() {
        return this.action;
    }

    public String b() {
        return this.connectMode;
    }

    public String b0() {
        return this.phoneModel;
    }

    public int describeContents() {
        return 0;
    }

    public long l0() {
        return this.timestamp;
    }

    public void m0(final String action) {
        this.action = action;
    }

    public void o0(final String connectMode) {
        this.connectMode = connectMode;
    }

    public void p0(final String connectStatus) {
        this.connectStatus = connectStatus;
    }

    public void q0(final String connectType) {
        this.connectType = connectType;
    }

    public void r0(final String deviceMac) {
        this.deviceMac = deviceMac;
    }

    public void t0(final String deviceName) {
        this.deviceName = deviceName;
    }

    public String toString() {
        return "LogAction{deviceMac='" + this.deviceMac + "', phoneId='" + this.phoneId + "', deviceName='" + this.deviceName + "', connectType='" + this.connectType + "', connectMode='" + this.connectMode + "', connectStatus='" + this.connectStatus + "', firmwareVersion='" + this.firmwareVersion + "', driverVersion='" + this.driverVersion + "', phoneBrand='" + this.phoneBrand + "', phoneModel='" + this.phoneModel + "', timestamp=" + this.timestamp + ", action='" + this.action + "'}";
    }

    public void u0(final String driverVersion) {
        this.driverVersion = driverVersion;
    }

    public void v0(final String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public void w0(final String phoneBrand) {
        this.phoneBrand = phoneBrand;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.deviceMac);
        dest.writeString(this.phoneId);
        dest.writeString(this.deviceName);
        dest.writeString(this.connectType);
        dest.writeString(this.connectMode);
        dest.writeString(this.connectStatus);
        dest.writeString(this.firmwareVersion);
        dest.writeString(this.driverVersion);
        dest.writeString(this.phoneBrand);
        dest.writeString(this.phoneModel);
        dest.writeLong(this.timestamp);
        dest.writeString(this.action);
    }

    public void x0(final String phoneId) {
        this.phoneId = phoneId;
    }

    public void y0(final String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public String z() {
        return this.connectStatus;
    }

    public LogAction(Parcel in2) {
        this.deviceMac = in2.readString();
        this.phoneId = in2.readString();
        this.deviceName = in2.readString();
        this.connectType = in2.readString();
        this.connectMode = in2.readString();
        this.connectStatus = in2.readString();
        this.firmwareVersion = in2.readString();
        this.driverVersion = in2.readString();
        this.phoneBrand = in2.readString();
        this.phoneModel = in2.readString();
        this.timestamp = in2.readLong();
        this.action = in2.readString();
    }
}
