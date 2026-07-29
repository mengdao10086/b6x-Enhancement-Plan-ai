package com.flydigi.action;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class CyberFoxSettingActionLog extends LogAction {
    public static final Parcelable.Creator<CyberFoxSettingActionLog> CREATOR = new a();

    @SerializedName("earphoneMac")
    private String deviceMac;
    private int isSetLatency;
    private int isSetLed;
    private int latencyMode;
    private int latencySetNum;
    private int ledMode;
    private int ledSetNum;

    public class a implements Parcelable.Creator<CyberFoxSettingActionLog> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CyberFoxSettingActionLog createFromParcel(Parcel source) {
            return new CyberFoxSettingActionLog(source);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CyberFoxSettingActionLog[] newArray(int size) {
            return new CyberFoxSettingActionLog[size];
        }
    }

    public CyberFoxSettingActionLog() {
    }

    public int B0() {
        return this.isSetLatency;
    }

    public int D0() {
        return this.isSetLed;
    }

    public int E0() {
        return this.latencyMode;
    }

    public int F0() {
        return this.latencySetNum;
    }

    public int G0() {
        return this.ledMode;
    }

    public int K0() {
        return this.ledSetNum;
    }

    @Override // com.flydigi.action.LogAction
    public String M() {
        return this.deviceMac;
    }

    public void M0(int isSetLatency) {
        this.isSetLatency = isSetLatency;
    }

    public void N0(int isSetLed) {
        this.isSetLed = isSetLed;
    }

    public void O0(int latencyMode) {
        this.latencyMode = latencyMode;
    }

    public void P0(int latencySetNum) {
        this.latencySetNum = latencySetNum;
    }

    public void Q0(int ledMode) {
        this.ledMode = ledMode;
    }

    public void R0(int ledSetNum) {
        this.ledSetNum = ledSetNum;
    }

    @Override // com.flydigi.action.LogAction, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.flydigi.action.LogAction
    public void r0(String deviceMac) {
        this.deviceMac = deviceMac;
    }

    @Override // com.flydigi.action.LogAction, android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.deviceMac);
        dest.writeInt(this.isSetLatency);
        dest.writeInt(this.latencyMode);
        dest.writeInt(this.latencySetNum);
        dest.writeInt(this.isSetLed);
        dest.writeInt(this.ledMode);
        dest.writeInt(this.ledSetNum);
    }

    public CyberFoxSettingActionLog(Parcel in2) {
        super(in2);
        this.deviceMac = in2.readString();
        this.isSetLatency = in2.readInt();
        this.latencyMode = in2.readInt();
        this.latencySetNum = in2.readInt();
        this.isSetLed = in2.readInt();
        this.ledMode = in2.readInt();
        this.ledSetNum = in2.readInt();
    }
}
