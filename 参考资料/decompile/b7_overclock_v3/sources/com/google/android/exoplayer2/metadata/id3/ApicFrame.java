package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import g.p0;
import hd.u0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator<ApicFrame> CREATOR = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f17276f = "APIC";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final String f17278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f17280e;

    public class a implements Parcelable.Creator<ApicFrame> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ApicFrame createFromParcel(Parcel parcel) {
            return new ApicFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ApicFrame[] newArray(int i10) {
            return new ApicFrame[i10];
        }
    }

    public ApicFrame(String str, @p0 String str2, int i10, byte[] bArr) {
        super(f17276f);
        this.f17277b = str;
        this.f17278c = str2;
        this.f17279d = i10;
        this.f17280e = bArr;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ApicFrame.class != obj.getClass()) {
            return false;
        }
        ApicFrame apicFrame = (ApicFrame) obj;
        return this.f17279d == apicFrame.f17279d && u0.c(this.f17277b, apicFrame.f17277b) && u0.c(this.f17278c, apicFrame.f17278c) && Arrays.equals(this.f17280e, apicFrame.f17280e);
    }

    public int hashCode() {
        int i10 = (527 + this.f17279d) * 31;
        String str = this.f17277b;
        int iHashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f17278c;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.f17280e);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        return this.f17304a + ": mimeType=" + this.f17277b + ", description=" + this.f17278c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17277b);
        parcel.writeString(this.f17278c);
        parcel.writeInt(this.f17279d);
        parcel.writeByteArray(this.f17280e);
    }

    public ApicFrame(Parcel parcel) {
        super(f17276f);
        this.f17277b = (String) u0.k(parcel.readString());
        this.f17278c = parcel.readString();
        this.f17279d = parcel.readInt();
        this.f17280e = (byte[]) u0.k(parcel.createByteArray());
    }
}
