package com.flydigi.action;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class KeyUseStatisticsActionLog extends LogAction {
    public static final Parcelable.Creator<KeyUseStatisticsActionLog> CREATOR = new a();
    private int angle;
    private int isUseAssistShoot;
    private int isUseMotionView;
    private String pkgName;
    private int range;

    public class a implements Parcelable.Creator<KeyUseStatisticsActionLog> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public KeyUseStatisticsActionLog createFromParcel(Parcel source) {
            return new KeyUseStatisticsActionLog(source);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public KeyUseStatisticsActionLog[] newArray(int size) {
            return new KeyUseStatisticsActionLog[size];
        }
    }

    public KeyUseStatisticsActionLog() {
    }

    public void B0(int angle) {
        this.angle = angle;
    }

    public void D0(int isUseAssistShoot) {
        this.isUseAssistShoot = isUseAssistShoot;
    }

    public void E0(int isUseMotionView) {
        this.isUseMotionView = isUseMotionView;
    }

    public void F0(String pkgName) {
        this.pkgName = pkgName;
    }

    public void G0(int range) {
        this.range = range;
    }

    @Override // com.flydigi.action.LogAction, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.flydigi.action.LogAction, android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.pkgName);
        dest.writeInt(this.isUseAssistShoot);
        dest.writeInt(this.angle);
        dest.writeInt(this.range);
        dest.writeInt(this.isUseMotionView);
    }

    public KeyUseStatisticsActionLog(Parcel in2) {
        super(in2);
        this.pkgName = in2.readString();
        this.isUseAssistShoot = in2.readInt();
        this.angle = in2.readInt();
        this.range = in2.readInt();
        this.isUseMotionView = in2.readInt();
    }
}
