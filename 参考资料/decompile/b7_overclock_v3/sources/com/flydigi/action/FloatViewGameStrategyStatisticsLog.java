package com.flydigi.action;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class FloatViewGameStrategyStatisticsLog extends LogAction {
    public static final Parcelable.Creator<FloatViewGameStrategyStatisticsLog> CREATOR = new a();
    private String gamePkgName;

    public class a implements Parcelable.Creator<FloatViewGameStrategyStatisticsLog> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FloatViewGameStrategyStatisticsLog createFromParcel(Parcel source) {
            return new FloatViewGameStrategyStatisticsLog(source);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FloatViewGameStrategyStatisticsLog[] newArray(int size) {
            return new FloatViewGameStrategyStatisticsLog[size];
        }
    }

    public FloatViewGameStrategyStatisticsLog() {
    }

    public void B0(String gamePkgName) {
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
    }

    public FloatViewGameStrategyStatisticsLog(Parcel in2) {
        super(in2);
        this.gamePkgName = in2.readString();
    }
}
