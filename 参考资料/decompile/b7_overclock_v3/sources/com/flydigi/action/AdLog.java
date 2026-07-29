package com.flydigi.action;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class AdLog extends LogAction {
    public static final Parcelable.Creator<AdLog> CREATOR = new a();

    @SerializedName("clickAd")
    private int hasClick;

    @SerializedName("skipAd")
    private int hasSkip;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f13282id;

    public class a implements Parcelable.Creator<AdLog> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdLog createFromParcel(Parcel source) {
            return new AdLog(source);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AdLog[] newArray(int size) {
            return new AdLog[size];
        }
    }

    public AdLog() {
    }

    public void B0(int hasClick) {
        this.hasClick = hasClick;
    }

    public void D0(int hasSkip) {
        this.hasSkip = hasSkip;
    }

    public void E0(final long id2) {
        this.f13282id = id2;
    }

    @Override // com.flydigi.action.LogAction, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.flydigi.action.LogAction, android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeLong(this.f13282id);
        dest.writeInt(this.hasClick);
        dest.writeInt(this.hasSkip);
    }

    public AdLog(Parcel in2) {
        super(in2);
        this.f13282id = in2.readLong();
        this.hasClick = in2.readInt();
        this.hasSkip = in2.readInt();
    }
}
