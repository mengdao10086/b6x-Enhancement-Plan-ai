package com.google.android.exoplayer2.offline;

import android.os.Parcel;
import android.os.Parcelable;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class StreamKey implements Comparable<StreamKey>, Parcelable {
    public static final Parcelable.Creator<StreamKey> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17423c;

    public class a implements Parcelable.Creator<StreamKey> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StreamKey createFromParcel(Parcel parcel) {
            return new StreamKey(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public StreamKey[] newArray(int i10) {
            return new StreamKey[i10];
        }
    }

    public StreamKey(int i10, int i11) {
        this(0, i10, i11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compareTo(StreamKey streamKey) {
        int i10 = this.f17421a - streamKey.f17421a;
        if (i10 != 0) {
            return i10;
        }
        int i11 = this.f17422b - streamKey.f17422b;
        return i11 == 0 ? this.f17423c - streamKey.f17423c : i11;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || StreamKey.class != obj.getClass()) {
            return false;
        }
        StreamKey streamKey = (StreamKey) obj;
        return this.f17421a == streamKey.f17421a && this.f17422b == streamKey.f17422b && this.f17423c == streamKey.f17423c;
    }

    public int hashCode() {
        return (((this.f17421a * 31) + this.f17422b) * 31) + this.f17423c;
    }

    public String toString() {
        return this.f17421a + j3.b.f36044h + this.f17422b + j3.b.f36044h + this.f17423c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f17421a);
        parcel.writeInt(this.f17422b);
        parcel.writeInt(this.f17423c);
    }

    public StreamKey(int i10, int i11, int i12) {
        this.f17421a = i10;
        this.f17422b = i11;
        this.f17423c = i12;
    }

    public StreamKey(Parcel parcel) {
        this.f17421a = parcel.readInt();
        this.f17422b = parcel.readInt();
        this.f17423c = parcel.readInt();
    }
}
