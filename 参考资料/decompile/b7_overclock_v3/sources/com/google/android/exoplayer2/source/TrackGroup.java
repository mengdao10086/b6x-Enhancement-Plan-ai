package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import g.p0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class TrackGroup implements Parcelable {
    public static final Parcelable.Creator<TrackGroup> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Format[] f17499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17500c;

    public class a implements Parcelable.Creator<TrackGroup> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TrackGroup createFromParcel(Parcel parcel) {
            return new TrackGroup(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TrackGroup[] newArray(int i10) {
            return new TrackGroup[i10];
        }
    }

    public TrackGroup(Format... formatArr) {
        hd.a.i(formatArr.length > 0);
        this.f17499b = formatArr;
        this.f17498a = formatArr.length;
    }

    public Format a(int i10) {
        return this.f17499b[i10];
    }

    public int b(Format format) {
        int i10 = 0;
        while (true) {
            Format[] formatArr = this.f17499b;
            if (i10 >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[i10]) {
                return i10;
            }
            i10++;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroup.class != obj.getClass()) {
            return false;
        }
        TrackGroup trackGroup = (TrackGroup) obj;
        return this.f17498a == trackGroup.f17498a && Arrays.equals(this.f17499b, trackGroup.f17499b);
    }

    public int hashCode() {
        if (this.f17500c == 0) {
            this.f17500c = 527 + Arrays.hashCode(this.f17499b);
        }
        return this.f17500c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f17498a);
        for (int i11 = 0; i11 < this.f17498a; i11++) {
            parcel.writeParcelable(this.f17499b[i11], 0);
        }
    }

    public TrackGroup(Parcel parcel) {
        int i10 = parcel.readInt();
        this.f17498a = i10;
        this.f17499b = new Format[i10];
        for (int i11 = 0; i11 < this.f17498a; i11++) {
            this.f17499b[i11] = (Format) parcel.readParcelable(Format.class.getClassLoader());
        }
    }
}
