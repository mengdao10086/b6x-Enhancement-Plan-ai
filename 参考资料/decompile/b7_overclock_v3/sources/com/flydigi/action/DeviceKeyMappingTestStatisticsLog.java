package com.flydigi.action;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceKeyMappingTestStatisticsLog extends LogAction {
    public static final Parcelable.Creator<DeviceKeyMappingTestStatisticsLog> CREATOR = new a();

    public class a implements Parcelable.Creator<DeviceKeyMappingTestStatisticsLog> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DeviceKeyMappingTestStatisticsLog createFromParcel(Parcel source) {
            return new DeviceKeyMappingTestStatisticsLog(source);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DeviceKeyMappingTestStatisticsLog[] newArray(int size) {
            return new DeviceKeyMappingTestStatisticsLog[size];
        }
    }

    public DeviceKeyMappingTestStatisticsLog() {
    }

    @Override // com.flydigi.action.LogAction, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.flydigi.action.LogAction, android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }

    public DeviceKeyMappingTestStatisticsLog(Parcel in2) {
        super(in2);
    }
}
