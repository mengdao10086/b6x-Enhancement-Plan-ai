package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import g.p0;
import hd.u0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class MlltFrame extends Id3Frame {
    public static final Parcelable.Creator<MlltFrame> CREATOR = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f17309g = "MLLT";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f17313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f17314f;

    public class a implements Parcelable.Creator<MlltFrame> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MlltFrame createFromParcel(Parcel parcel) {
            return new MlltFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MlltFrame[] newArray(int i10) {
            return new MlltFrame[i10];
        }
    }

    public MlltFrame(int i10, int i11, int i12, int[] iArr, int[] iArr2) {
        super(f17309g);
        this.f17310b = i10;
        this.f17311c = i11;
        this.f17312d = i12;
        this.f17313e = iArr;
        this.f17314f = iArr2;
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MlltFrame.class != obj.getClass()) {
            return false;
        }
        MlltFrame mlltFrame = (MlltFrame) obj;
        return this.f17310b == mlltFrame.f17310b && this.f17311c == mlltFrame.f17311c && this.f17312d == mlltFrame.f17312d && Arrays.equals(this.f17313e, mlltFrame.f17313e) && Arrays.equals(this.f17314f, mlltFrame.f17314f);
    }

    public int hashCode() {
        return ((((((((527 + this.f17310b) * 31) + this.f17311c) * 31) + this.f17312d) * 31) + Arrays.hashCode(this.f17313e)) * 31) + Arrays.hashCode(this.f17314f);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f17310b);
        parcel.writeInt(this.f17311c);
        parcel.writeInt(this.f17312d);
        parcel.writeIntArray(this.f17313e);
        parcel.writeIntArray(this.f17314f);
    }

    public MlltFrame(Parcel parcel) {
        super(f17309g);
        this.f17310b = parcel.readInt();
        this.f17311c = parcel.readInt();
        this.f17312d = parcel.readInt();
        this.f17313e = (int[]) u0.k(parcel.createIntArray());
        this.f17314f = (int[]) u0.k(parcel.createIntArray());
    }
}
