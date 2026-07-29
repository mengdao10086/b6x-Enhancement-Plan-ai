package com.flydigi.action;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class FloatViewKeyPropertyStatisticsLog extends LogAction {
    public static final Parcelable.Creator<FloatViewKeyPropertyStatisticsLog> CREATOR = new a();
    private int deviceMode;
    private String gamePkgName;
    private int propertyId;
    private String propertyName;

    public class a implements Parcelable.Creator<FloatViewKeyPropertyStatisticsLog> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FloatViewKeyPropertyStatisticsLog createFromParcel(Parcel source) {
            return new FloatViewKeyPropertyStatisticsLog(source);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FloatViewKeyPropertyStatisticsLog[] newArray(int size) {
            return new FloatViewKeyPropertyStatisticsLog[size];
        }
    }

    public FloatViewKeyPropertyStatisticsLog() {
    }

    public void B0(int deviceMode) {
        this.deviceMode = deviceMode;
    }

    public void D0(String gamePkgName) {
        this.gamePkgName = gamePkgName;
    }

    public void E0(int propertyId) {
        this.propertyId = propertyId;
    }

    public void F0(String propertyName) {
        this.propertyName = propertyName;
    }

    @Override // com.flydigi.action.LogAction, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.flydigi.action.LogAction, android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.gamePkgName);
        dest.writeString(this.propertyName);
        dest.writeInt(this.deviceMode);
        dest.writeInt(this.propertyId);
    }

    public FloatViewKeyPropertyStatisticsLog(Parcel in2) {
        super(in2);
        this.gamePkgName = in2.readString();
        this.propertyName = in2.readString();
        this.deviceMode = in2.readInt();
        this.propertyId = in2.readInt();
    }
}
