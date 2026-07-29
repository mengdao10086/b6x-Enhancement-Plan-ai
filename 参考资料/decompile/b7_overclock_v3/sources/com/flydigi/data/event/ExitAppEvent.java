package com.flydigi.data.event;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes7.dex */
public class ExitAppEvent implements Parcelable {
    public static final Parcelable.Creator<ExitAppEvent> CREATOR = new Parcelable.Creator<ExitAppEvent>() { // from class: com.flydigi.data.event.ExitAppEvent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ExitAppEvent createFromParcel(Parcel source) {
            return new ExitAppEvent(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ExitAppEvent[] newArray(int size) {
            return new ExitAppEvent[size];
        }
    };
    public boolean mKillDriverPID;

    public ExitAppEvent(boolean killDriverPID) {
        this.mKillDriverPID = killDriverPID;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeByte(this.mKillDriverPID ? (byte) 1 : (byte) 0);
    }

    public ExitAppEvent(Parcel in2) {
        this.mKillDriverPID = in2.readByte() != 0;
    }
}
