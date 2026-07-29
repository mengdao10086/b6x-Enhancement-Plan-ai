package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import g.p0;
import hd.u0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class PictureFrame implements Metadata.Entry {
    public static final Parcelable.Creator<PictureFrame> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17251d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17252e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f17253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f17254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f17255h;

    public class a implements Parcelable.Creator<PictureFrame> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PictureFrame createFromParcel(Parcel parcel) {
            return new PictureFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public PictureFrame[] newArray(int i10) {
            return new PictureFrame[i10];
        }
    }

    public PictureFrame(int i10, String str, String str2, int i11, int i12, int i13, int i14, byte[] bArr) {
        this.f17248a = i10;
        this.f17249b = str;
        this.f17250c = str2;
        this.f17251d = i11;
        this.f17252e = i12;
        this.f17253f = i13;
        this.f17254g = i14;
        this.f17255h = bArr;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] O() {
        return ub.a.a(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PictureFrame.class != obj.getClass()) {
            return false;
        }
        PictureFrame pictureFrame = (PictureFrame) obj;
        return this.f17248a == pictureFrame.f17248a && this.f17249b.equals(pictureFrame.f17249b) && this.f17250c.equals(pictureFrame.f17250c) && this.f17251d == pictureFrame.f17251d && this.f17252e == pictureFrame.f17252e && this.f17253f == pictureFrame.f17253f && this.f17254g == pictureFrame.f17254g && Arrays.equals(this.f17255h, pictureFrame.f17255h);
    }

    public int hashCode() {
        return ((((((((((((((527 + this.f17248a) * 31) + this.f17249b.hashCode()) * 31) + this.f17250c.hashCode()) * 31) + this.f17251d) * 31) + this.f17252e) * 31) + this.f17253f) * 31) + this.f17254g) * 31) + Arrays.hashCode(this.f17255h);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ Format n() {
        return ub.a.b(this);
    }

    public String toString() {
        return "Picture: mimeType=" + this.f17249b + ", description=" + this.f17250c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f17248a);
        parcel.writeString(this.f17249b);
        parcel.writeString(this.f17250c);
        parcel.writeInt(this.f17251d);
        parcel.writeInt(this.f17252e);
        parcel.writeInt(this.f17253f);
        parcel.writeInt(this.f17254g);
        parcel.writeByteArray(this.f17255h);
    }

    public PictureFrame(Parcel parcel) {
        this.f17248a = parcel.readInt();
        this.f17249b = (String) u0.k(parcel.readString());
        this.f17250c = (String) u0.k(parcel.readString());
        this.f17251d = parcel.readInt();
        this.f17252e = parcel.readInt();
        this.f17253f = parcel.readInt();
        this.f17254g = parcel.readInt();
        this.f17255h = (byte[]) u0.k(parcel.createByteArray());
    }
}
