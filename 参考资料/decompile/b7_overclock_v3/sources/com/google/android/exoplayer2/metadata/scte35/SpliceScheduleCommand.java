package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import hd.c0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ya.g;

/* JADX INFO: loaded from: classes3.dex */
public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f17358a;

    public class a implements Parcelable.Creator<SpliceScheduleCommand> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SpliceScheduleCommand[] newArray(int i10) {
            return new SpliceScheduleCommand[i10];
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f17360b;

        public /* synthetic */ b(int i10, long j10, a aVar) {
            this(i10, j10);
        }

        public static b c(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong());
        }

        public final void d(Parcel parcel) {
            parcel.writeInt(this.f17359a);
            parcel.writeLong(this.f17360b);
        }

        public b(int i10, long j10) {
            this.f17359a = i10;
            this.f17360b = j10;
        }
    }

    public /* synthetic */ SpliceScheduleCommand(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static SpliceScheduleCommand a(c0 c0Var) {
        int iG = c0Var.G();
        ArrayList arrayList = new ArrayList(iG);
        for (int i10 = 0; i10 < iG; i10++) {
            arrayList.add(c.e(c0Var));
        }
        return new SpliceScheduleCommand(arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int size = this.f17358a.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            this.f17358a.get(i11).f(parcel);
        }
    }

    public SpliceScheduleCommand(List<c> list) {
        this.f17358a = Collections.unmodifiableList(list);
    }

    public SpliceScheduleCommand(Parcel parcel) {
        int i10 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add(c.d(parcel));
        }
        this.f17358a = Collections.unmodifiableList(arrayList);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f17361a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f17362b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f17363c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f17364d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f17365e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<b> f17366f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f17367g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f17368h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f17369i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f17370j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f17371k;

        public c(long j10, boolean z10, boolean z11, boolean z12, List<b> list, long j11, boolean z13, long j12, int i10, int i11, int i12) {
            this.f17361a = j10;
            this.f17362b = z10;
            this.f17363c = z11;
            this.f17364d = z12;
            this.f17366f = Collections.unmodifiableList(list);
            this.f17365e = j11;
            this.f17367g = z13;
            this.f17368h = j12;
            this.f17369i = i10;
            this.f17370j = i11;
            this.f17371k = i12;
        }

        public static c d(Parcel parcel) {
            return new c(parcel);
        }

        public static c e(c0 c0Var) {
            ArrayList arrayList;
            boolean z10;
            long j10;
            boolean z11;
            long j11;
            int i10;
            int i11;
            int iG;
            boolean z12;
            boolean z13;
            long jI;
            long jI2 = c0Var.I();
            boolean z14 = (c0Var.G() & 128) != 0;
            ArrayList arrayList2 = new ArrayList();
            if (z14) {
                arrayList = arrayList2;
                z10 = false;
                j10 = g.f56663b;
                z11 = false;
                j11 = g.f56663b;
                i10 = 0;
                i11 = 0;
                iG = 0;
                z12 = false;
            } else {
                int iG2 = c0Var.G();
                boolean z15 = (iG2 & 128) != 0;
                boolean z16 = (iG2 & 64) != 0;
                boolean z17 = (iG2 & 32) != 0;
                long jI3 = z16 ? c0Var.I() : g.f56663b;
                if (!z16) {
                    int iG3 = c0Var.G();
                    ArrayList arrayList3 = new ArrayList(iG3);
                    for (int i12 = 0; i12 < iG3; i12++) {
                        arrayList3.add(new b(c0Var.G(), c0Var.I(), null));
                    }
                    arrayList2 = arrayList3;
                }
                if (z17) {
                    long jG = c0Var.G();
                    boolean z18 = (128 & jG) != 0;
                    jI = ((((jG & 1) << 32) | c0Var.I()) * 1000) / 90;
                    z13 = z18;
                } else {
                    z13 = false;
                    jI = g.f56663b;
                }
                int iM = c0Var.M();
                int iG4 = c0Var.G();
                z12 = z16;
                iG = c0Var.G();
                j11 = jI;
                arrayList = arrayList2;
                long j12 = jI3;
                i10 = iM;
                i11 = iG4;
                j10 = j12;
                boolean z19 = z15;
                z11 = z13;
                z10 = z19;
            }
            return new c(jI2, z14, z10, z12, arrayList, j10, z11, j11, i10, i11, iG);
        }

        public final void f(Parcel parcel) {
            parcel.writeLong(this.f17361a);
            parcel.writeByte(this.f17362b ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f17363c ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f17364d ? (byte) 1 : (byte) 0);
            int size = this.f17366f.size();
            parcel.writeInt(size);
            for (int i10 = 0; i10 < size; i10++) {
                this.f17366f.get(i10).d(parcel);
            }
            parcel.writeLong(this.f17365e);
            parcel.writeByte(this.f17367g ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f17368h);
            parcel.writeInt(this.f17369i);
            parcel.writeInt(this.f17370j);
            parcel.writeInt(this.f17371k);
        }

        public c(Parcel parcel) {
            this.f17361a = parcel.readLong();
            this.f17362b = parcel.readByte() == 1;
            this.f17363c = parcel.readByte() == 1;
            this.f17364d = parcel.readByte() == 1;
            int i10 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                arrayList.add(b.c(parcel));
            }
            this.f17366f = Collections.unmodifiableList(arrayList);
            this.f17365e = parcel.readLong();
            this.f17367g = parcel.readByte() == 1;
            this.f17368h = parcel.readLong();
            this.f17369i = parcel.readInt();
            this.f17370j = parcel.readInt();
            this.f17371k = parcel.readInt();
        }
    }
}
