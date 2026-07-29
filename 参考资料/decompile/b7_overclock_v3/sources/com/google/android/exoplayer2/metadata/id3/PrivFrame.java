package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import g.p0;
import hd.u0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class PrivFrame extends Id3Frame {
    public static final Parcelable.Creator<PrivFrame> CREATOR = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f17315d = "PRIV";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f17317c;

    public class a implements Parcelable.Creator<PrivFrame> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PrivFrame createFromParcel(Parcel parcel) {
            return new PrivFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public PrivFrame[] newArray(int i10) {
            return new PrivFrame[i10];
        }
    }

    public PrivFrame(String str, byte[] bArr) {
        super(f17315d);
        this.f17316b = str;
        this.f17317c = bArr;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PrivFrame.class != obj.getClass()) {
            return false;
        }
        PrivFrame privFrame = (PrivFrame) obj;
        return u0.c(this.f17316b, privFrame.f17316b) && Arrays.equals(this.f17317c, privFrame.f17317c);
    }

    public int hashCode() {
        String str = this.f17316b;
        return ((527 + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.f17317c);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public String toString() {
        return this.f17304a + ": owner=" + this.f17316b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17316b);
        parcel.writeByteArray(this.f17317c);
    }

    public PrivFrame(Parcel parcel) {
        super(f17315d);
        this.f17316b = (String) u0.k(parcel.readString());
        this.f17317c = (byte[]) u0.k(parcel.createByteArray());
    }
}
