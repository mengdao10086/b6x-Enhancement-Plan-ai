package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import g.p0;
import hd.u0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class ColorInfo implements Parcelable {
    public static final Parcelable.Creator<ColorInfo> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f19301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public final byte[] f19302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f19303e;

    public class a implements Parcelable.Creator<ColorInfo> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ColorInfo createFromParcel(Parcel parcel) {
            return new ColorInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ColorInfo[] newArray(int i10) {
            return new ColorInfo[i10];
        }
    }

    public ColorInfo(int i10, int i11, int i12, @p0 byte[] bArr) {
        this.f19299a = i10;
        this.f19300b = i11;
        this.f19301c = i12;
        this.f19302d = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ColorInfo.class != obj.getClass()) {
            return false;
        }
        ColorInfo colorInfo = (ColorInfo) obj;
        return this.f19299a == colorInfo.f19299a && this.f19300b == colorInfo.f19300b && this.f19301c == colorInfo.f19301c && Arrays.equals(this.f19302d, colorInfo.f19302d);
    }

    public int hashCode() {
        if (this.f19303e == 0) {
            this.f19303e = ((((((527 + this.f19299a) * 31) + this.f19300b) * 31) + this.f19301c) * 31) + Arrays.hashCode(this.f19302d);
        }
        return this.f19303e;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ColorInfo(");
        sb2.append(this.f19299a);
        sb2.append(", ");
        sb2.append(this.f19300b);
        sb2.append(", ");
        sb2.append(this.f19301c);
        sb2.append(", ");
        sb2.append(this.f19302d != null);
        sb2.append(ee.a.f26979d);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f19299a);
        parcel.writeInt(this.f19300b);
        parcel.writeInt(this.f19301c);
        u0.B1(parcel, this.f19302d != null);
        byte[] bArr = this.f19302d;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }

    public ColorInfo(Parcel parcel) {
        this.f19299a = parcel.readInt();
        this.f19300b = parcel.readInt();
        this.f19301c = parcel.readInt();
        this.f19302d = u0.b1(parcel) ? parcel.createByteArray() : null;
    }
}
