package com.flydigi.sdk.waspwing;

import android.os.Parcel;
import android.os.Parcelable;
import cl.d;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@d
public final class LedData implements Parcelable {

    @k
    public static final Parcelable.Creator<LedData> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f16354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte f16355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public ArrayList<Integer> f16356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte f16357d;

    public static final class a implements Parcelable.Creator<LedData> {
        @Override // android.os.Parcelable.Creator
        @k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final LedData createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            byte b10 = parcel.readByte();
            byte b11 = parcel.readByte();
            int i10 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i10);
            for (int i11 = 0; i11 != i10; i11++) {
                arrayList.add(Integer.valueOf(parcel.readInt()));
            }
            return new LedData(b10, b11, arrayList, parcel.readByte());
        }

        @Override // android.os.Parcelable.Creator
        @k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final LedData[] newArray(int i10) {
            return new LedData[i10];
        }
    }

    public LedData(byte b10, byte b11, @k ArrayList<Integer> colors, byte b12) {
        f0.p(colors, "colors");
        this.f16354a = b10;
        this.f16355b = b11;
        this.f16356c = colors;
        this.f16357d = b12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LedData s(LedData ledData, byte b10, byte b11, ArrayList arrayList, byte b12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            b10 = ledData.f16354a;
        }
        if ((i10 & 2) != 0) {
            b11 = ledData.f16355b;
        }
        if ((i10 & 4) != 0) {
            arrayList = ledData.f16356c;
        }
        if ((i10 & 8) != 0) {
            b12 = ledData.f16357d;
        }
        return ledData.j(b10, b11, arrayList, b12);
    }

    public final byte C() {
        return this.f16354a;
    }

    public final byte F() {
        return this.f16357d;
    }

    public final byte M() {
        return this.f16355b;
    }

    public final void S(@k ArrayList<Integer> arrayList) {
        f0.p(arrayList, "<set-?>");
        this.f16356c = arrayList;
    }

    public final void T(byte b10) {
        this.f16354a = b10;
    }

    public final void U(byte b10) {
        this.f16357d = b10;
    }

    public final void V(byte b10) {
        this.f16355b = b10;
    }

    public final byte a() {
        return this.f16354a;
    }

    public final byte b() {
        return this.f16355b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @k
    public final ArrayList<Integer> e() {
        return this.f16356c;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!f0.g(LedData.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        f0.n(obj, "null cannot be cast to non-null type com.flydigi.sdk.waspwing.LedData");
        LedData ledData = (LedData) obj;
        return this.f16354a == ledData.f16354a && this.f16355b == ledData.f16355b && this.f16357d == ledData.f16357d && f0.g(this.f16356c, ledData.f16356c) && this.f16357d == ledData.f16357d;
    }

    public final byte g() {
        return this.f16357d;
    }

    public int hashCode() {
        return (((((this.f16354a * 31) + this.f16355b) * 31) + this.f16356c.hashCode()) * 31) + this.f16357d;
    }

    @k
    public final LedData j(byte b10, byte b11, @k ArrayList<Integer> colors, byte b12) {
        f0.p(colors, "colors");
        return new LedData(b10, b11, colors, b12);
    }

    @k
    public String toString() {
        byte b10 = this.f16354a;
        byte b11 = this.f16355b;
        return "LedData(ledType=" + ((int) b10) + ", period=" + ((int) b11) + ", colors=" + this.f16356c + ", light=" + ((int) this.f16357d) + ee.a.f26979d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeByte(this.f16354a);
        out.writeByte(this.f16355b);
        ArrayList<Integer> arrayList = this.f16356c;
        out.writeInt(arrayList.size());
        Iterator<Integer> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            out.writeInt(it2.next().intValue());
        }
        out.writeByte(this.f16357d);
    }

    @k
    public final ArrayList<Integer> z() {
        return this.f16356c;
    }

    public /* synthetic */ LedData(byte b10, byte b11, ArrayList arrayList, byte b12, int i10, u uVar) {
        this(b10, b11, (i10 & 4) != 0 ? new ArrayList() : arrayList, b12);
    }
}
