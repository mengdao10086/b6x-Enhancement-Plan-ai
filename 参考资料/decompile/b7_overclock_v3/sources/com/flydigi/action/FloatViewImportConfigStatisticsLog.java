package com.flydigi.action;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class FloatViewImportConfigStatisticsLog extends LogAction {
    public static final Parcelable.Creator<FloatViewImportConfigStatisticsLog> CREATOR = new a();
    private String configName;
    private int deviceMode;
    private String gamePkgName;

    public class a implements Parcelable.Creator<FloatViewImportConfigStatisticsLog> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FloatViewImportConfigStatisticsLog createFromParcel(Parcel source) {
            return new FloatViewImportConfigStatisticsLog(source);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FloatViewImportConfigStatisticsLog[] newArray(int size) {
            return new FloatViewImportConfigStatisticsLog[size];
        }
    }

    public FloatViewImportConfigStatisticsLog() {
    }

    public void B0(String configName) {
        this.configName = configName;
    }

    public void D0(int deviceMode) {
        this.deviceMode = deviceMode;
    }

    public void E0(String gamePkgName) {
        this.gamePkgName = gamePkgName;
    }

    @Override // com.flydigi.action.LogAction, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.flydigi.action.LogAction, android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.gamePkgName);
        dest.writeString(this.configName);
        dest.writeInt(this.deviceMode);
    }

    public FloatViewImportConfigStatisticsLog(Parcel in2) {
        super(in2);
        this.gamePkgName = in2.readString();
        this.configName = in2.readString();
        this.deviceMode = in2.readInt();
    }
}
