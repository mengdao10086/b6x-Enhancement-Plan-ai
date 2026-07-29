package com.flydigi.action;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class CyberFoxConnectActionLog extends LogAction {
    public static final Parcelable.Creator<CyberFoxConnectActionLog> CREATOR = new a();

    @SerializedName("earphoneMac")
    private String deviceMac;

    public class a implements Parcelable.Creator<CyberFoxConnectActionLog> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CyberFoxConnectActionLog createFromParcel(Parcel source) {
            return new CyberFoxConnectActionLog(source);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CyberFoxConnectActionLog[] newArray(int size) {
            return new CyberFoxConnectActionLog[size];
        }
    }

    public CyberFoxConnectActionLog() {
    }

    @Override // com.flydigi.action.LogAction
    public String M() {
        return this.deviceMac;
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
    }

    public CyberFoxConnectActionLog(Parcel in2) {
        super(in2);
        this.deviceMac = in2.readString();
    }
}
