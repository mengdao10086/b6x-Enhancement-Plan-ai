package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import g.p0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class TrackGroupArray implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TrackGroup[] f17503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TrackGroupArray f17501d = new TrackGroupArray(new TrackGroup[0]);
    public static final Parcelable.Creator<TrackGroupArray> CREATOR = new a();

    public class a implements Parcelable.Creator<TrackGroupArray> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TrackGroupArray createFromParcel(Parcel parcel) {
            return new TrackGroupArray(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TrackGroupArray[] newArray(int i10) {
            return new TrackGroupArray[i10];
        }
    }

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.f17503b = trackGroupArr;
        this.f17502a = trackGroupArr.length;
    }

    public TrackGroup a(int i10) {
        return this.f17503b[i10];
    }

    public int b(TrackGroup trackGroup) {
        for (int i10 = 0; i10 < this.f17502a; i10++) {
            if (this.f17503b[i10] == trackGroup) {
                return i10;
            }
        }
        return -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.f17502a == 0;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroupArray.class != obj.getClass()) {
            return false;
        }
        TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
        return this.f17502a == trackGroupArray.f17502a && Arrays.equals(this.f17503b, trackGroupArray.f17503b);
    }

    public int hashCode() {
        if (this.f17504c == 0) {
            this.f17504c = Arrays.hashCode(this.f17503b);
        }
        return this.f17504c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f17502a);
        for (int i11 = 0; i11 < this.f17502a; i11++) {
            parcel.writeParcelable(this.f17503b[i11], 0);
        }
    }

    public TrackGroupArray(Parcel parcel) {
        int i10 = parcel.readInt();
        this.f17502a = i10;
        this.f17503b = new TrackGroup[i10];
        for (int i11 = 0; i11 < this.f17502a; i11++) {
            this.f17503b[i11] = (TrackGroup) parcel.readParcelable(TrackGroup.class.getClassLoader());
        }
    }
}
