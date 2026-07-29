package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import g.p0;
import hd.u0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator<GeobFrame> CREATOR = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f17299f = "GEOB";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f17303e;

    public class a implements Parcelable.Creator<GeobFrame> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GeobFrame createFromParcel(Parcel parcel) {
            return new GeobFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public GeobFrame[] newArray(int i10) {
            return new GeobFrame[i10];
        }
    }

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super(f17299f);
        this.f17300b = str;
        this.f17301c = str2;
        this.f17302d = str3;
        this.f17303e = bArr;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GeobFrame.class != obj.getClass()) {
            return false;
        }
        GeobFrame geobFrame = (GeobFrame) obj;
        return u0.c(this.f17300b, geobFrame.f17300b) && u0.c(this.f17301c, geobFrame.f17301c) && u0.c(this.f17302d, geobFrame.f17302d) && Arrays.equals(this.f17303e, geobFrame.f17303e);
    }

    public int hashCode() {
        String str = this.f17300b;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f17301c;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f17302d;
        return ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Arrays.hashCode(this.f17303e);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        return this.f17304a + ": mimeType=" + this.f17300b + ", filename=" + this.f17301c + ", description=" + this.f17302d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17300b);
        parcel.writeString(this.f17301c);
        parcel.writeString(this.f17302d);
        parcel.writeByteArray(this.f17303e);
    }

    public GeobFrame(Parcel parcel) {
        super(f17299f);
        this.f17300b = (String) u0.k(parcel.readString());
        this.f17301c = (String) u0.k(parcel.readString());
        this.f17302d = (String) u0.k(parcel.readString());
        this.f17303e = (byte[]) u0.k(parcel.createByteArray());
    }
}
