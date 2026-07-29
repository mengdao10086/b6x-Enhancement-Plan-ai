package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import hd.c0;
import hd.p0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ya.g;

/* JADX INFO: loaded from: classes3.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f17342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f17343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f17345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f17346e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f17347f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f17348g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<b> f17349h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f17350i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f17351j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f17352k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f17353l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f17354m;

    public class a implements Parcelable.Creator<SpliceInsertCommand> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SpliceInsertCommand createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SpliceInsertCommand[] newArray(int i10) {
            return new SpliceInsertCommand[i10];
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17355a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f17356b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f17357c;

        public /* synthetic */ b(int i10, long j10, long j11, a aVar) {
            this(i10, j10, j11);
        }

        public static b a(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void b(Parcel parcel) {
            parcel.writeInt(this.f17355a);
            parcel.writeLong(this.f17356b);
            parcel.writeLong(this.f17357c);
        }

        public b(int i10, long j10, long j11) {
            this.f17355a = i10;
            this.f17356b = j10;
            this.f17357c = j11;
        }
    }

    public /* synthetic */ SpliceInsertCommand(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static SpliceInsertCommand a(c0 c0Var, long j10, p0 p0Var) {
        List list;
        boolean z10;
        boolean z11;
        long j11;
        boolean z12;
        long j12;
        int iM;
        int iG;
        int iG2;
        boolean z13;
        boolean z14;
        long jI;
        long jI2 = c0Var.I();
        boolean z15 = (c0Var.G() & 128) != 0;
        List listEmptyList = Collections.emptyList();
        if (z15) {
            list = listEmptyList;
            z10 = false;
            z11 = false;
            j11 = g.f56663b;
            z12 = false;
            j12 = g.f56663b;
            iM = 0;
            iG = 0;
            iG2 = 0;
            z13 = false;
        } else {
            int iG3 = c0Var.G();
            boolean z16 = (iG3 & 128) != 0;
            boolean z17 = (iG3 & 64) != 0;
            boolean z18 = (iG3 & 32) != 0;
            boolean z19 = (iG3 & 16) != 0;
            long jB = (!z17 || z19) ? g.f56663b : TimeSignalCommand.b(c0Var, j10);
            if (!z17) {
                int iG4 = c0Var.G();
                ArrayList arrayList = new ArrayList(iG4);
                for (int i10 = 0; i10 < iG4; i10++) {
                    int iG5 = c0Var.G();
                    long jB2 = !z19 ? TimeSignalCommand.b(c0Var, j10) : g.f56663b;
                    arrayList.add(new b(iG5, jB2, p0Var.b(jB2), null));
                }
                listEmptyList = arrayList;
            }
            if (z18) {
                long jG = c0Var.G();
                boolean z20 = (128 & jG) != 0;
                jI = ((((jG & 1) << 32) | c0Var.I()) * 1000) / 90;
                z14 = z20;
            } else {
                z14 = false;
                jI = g.f56663b;
            }
            iM = c0Var.M();
            z13 = z17;
            iG = c0Var.G();
            iG2 = c0Var.G();
            list = listEmptyList;
            long j13 = jB;
            z12 = z14;
            j12 = jI;
            z11 = z19;
            z10 = z16;
            j11 = j13;
        }
        return new SpliceInsertCommand(jI2, z15, z10, z13, z11, j11, p0Var.b(j11), list, z12, j12, iM, iG, iG2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f17342a);
        parcel.writeByte(this.f17343b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f17344c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f17345d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f17346e ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f17347f);
        parcel.writeLong(this.f17348g);
        int size = this.f17349h.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f17349h.get(i11).b(parcel);
        }
        parcel.writeByte(this.f17350i ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f17351j);
        parcel.writeInt(this.f17352k);
        parcel.writeInt(this.f17353l);
        parcel.writeInt(this.f17354m);
    }

    public SpliceInsertCommand(long j10, boolean z10, boolean z11, boolean z12, boolean z13, long j11, long j12, List<b> list, boolean z14, long j13, int i10, int i11, int i12) {
        this.f17342a = j10;
        this.f17343b = z10;
        this.f17344c = z11;
        this.f17345d = z12;
        this.f17346e = z13;
        this.f17347f = j11;
        this.f17348g = j12;
        this.f17349h = Collections.unmodifiableList(list);
        this.f17350i = z14;
        this.f17351j = j13;
        this.f17352k = i10;
        this.f17353l = i11;
        this.f17354m = i12;
    }

    public SpliceInsertCommand(Parcel parcel) {
        this.f17342a = parcel.readLong();
        this.f17343b = parcel.readByte() == 1;
        this.f17344c = parcel.readByte() == 1;
        this.f17345d = parcel.readByte() == 1;
        this.f17346e = parcel.readByte() == 1;
        this.f17347f = parcel.readLong();
        this.f17348g = parcel.readLong();
        int i10 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add(b.a(parcel));
        }
        this.f17349h = Collections.unmodifiableList(arrayList);
        this.f17350i = parcel.readByte() == 1;
        this.f17351j = parcel.readLong();
        this.f17352k = parcel.readInt();
        this.f17353l = parcel.readInt();
        this.f17354m = parcel.readInt();
    }
}
