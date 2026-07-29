package com.flydigi.action;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class CommonLog extends LogAction {
    public static final Parcelable.Creator<CommonLog> CREATOR = new a();

    public class a implements Parcelable.Creator<CommonLog> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CommonLog createFromParcel(Parcel source) {
            return new CommonLog(source);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CommonLog[] newArray(int size) {
            return new CommonLog[size];
        }
    }

    public CommonLog() {
    }

    @Override // com.flydigi.action.LogAction, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.flydigi.action.LogAction
    public String toString() {
        return "CommonLog{deviceMac='" + this.deviceMac + "', deviceName='" + this.deviceName + "', connectType='" + this.connectType + "', connectMode='" + this.connectMode + "', connectStatus='" + this.connectStatus + "', firmwareVersion='" + this.firmwareVersion + "', driverVersion='" + this.driverVersion + "', timestamp=" + this.timestamp + ", action='" + this.action + "'}";
    }

    @Override // com.flydigi.action.LogAction, android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }

    public CommonLog(Parcel in2) {
        super(in2);
    }
}
