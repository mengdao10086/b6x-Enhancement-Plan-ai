package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import g.p0;
import hd.u0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class BinaryFrame extends Id3Frame {
    public static final Parcelable.Creator<BinaryFrame> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f17281b;

    public class a implements Parcelable.Creator<BinaryFrame> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BinaryFrame createFromParcel(Parcel parcel) {
            return new BinaryFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BinaryFrame[] newArray(int i10) {
            return new BinaryFrame[i10];
        }
    }

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.f17281b = bArr;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BinaryFrame.class != obj.getClass()) {
            return false;
        }
        BinaryFrame binaryFrame = (BinaryFrame) obj;
        return this.f17304a.equals(binaryFrame.f17304a) && Arrays.equals(this.f17281b, binaryFrame.f17281b);
    }

    public int hashCode() {
        return ((527 + this.f17304a.hashCode()) * 31) + Arrays.hashCode(this.f17281b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17304a);
        parcel.writeByteArray(this.f17281b);
    }

    public BinaryFrame(Parcel parcel) {
        super((String) u0.k(parcel.readString()));
        this.f17281b = (byte[]) u0.k(parcel.createByteArray());
    }
}
