package com.flydigi.data.event;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes7.dex */
public class APKInstallEvent implements Parcelable {
    public static final Parcelable.Creator<APKInstallEvent> CREATOR = new Parcelable.Creator<APKInstallEvent>() { // from class: com.flydigi.data.event.APKInstallEvent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public APKInstallEvent createFromParcel(Parcel source) {
            return new APKInstallEvent(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public APKInstallEvent[] newArray(int size) {
            return new APKInstallEvent[size];
        }
    };
    public boolean install;
    public String packageName;

    public APKInstallEvent(String packageName, boolean install) {
        this.packageName = packageName;
        this.install = install;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.packageName);
        parcel.writeByte(this.install ? (byte) 1 : (byte) 0);
    }

    public APKInstallEvent(Parcel in2) {
        this.packageName = in2.readString();
        this.install = in2.readByte() != 0;
    }
}
