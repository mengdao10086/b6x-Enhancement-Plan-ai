package com.google.android.exoplayer2.trackselection;

import ad.f;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.trackselection.b;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import g.i;
import g.p0;
import gc.m;
import gc.n;
import hd.u0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import ya.g;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public class a extends ad.b {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f18596t = 10000;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f18597u = 25000;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f18598v = 25000;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final float f18599w = 0.7f;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final float f18600x = 0.75f;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final long f18601y = 1000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ed.d f18602g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f18603h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f18604i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f18605j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f18606k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f18607l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImmutableList<C0193a> f18608m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final hd.c f18609n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f18610o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f18611p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f18612q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f18613r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @p0
    public m f18614s;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.trackselection.a$a, reason: collision with other inner class name */
    public static final class C0193a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f18615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f18616b;

        public C0193a(long j10, long j11) {
            this.f18615a = j10;
            this.f18616b = j11;
        }

        public boolean equals(@p0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0193a)) {
                return false;
            }
            C0193a c0193a = (C0193a) obj;
            return this.f18615a == c0193a.f18615a && this.f18616b == c0193a.f18616b;
        }

        public int hashCode() {
            return (((int) this.f18615a) * 31) + ((int) this.f18616b);
        }
    }

    public static class b implements b.InterfaceC0194b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f18618b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f18619c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f18620d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f18621e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final hd.c f18622f;

        public b() {
            this(10000, 25000, 25000, 0.7f, 0.75f, hd.c.f30965a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.exoplayer2.trackselection.b.InterfaceC0194b
        public final com.google.android.exoplayer2.trackselection.b[] a(b.a[] aVarArr, ed.d dVar, l.a aVar, x1 x1Var) {
            ImmutableList immutableListB = a.B(aVarArr);
            com.google.android.exoplayer2.trackselection.b[] bVarArr = new com.google.android.exoplayer2.trackselection.b[aVarArr.length];
            for (int i10 = 0; i10 < aVarArr.length; i10++) {
                b.a aVar2 = aVarArr[i10];
                if (aVar2 != null) {
                    int[] iArr = aVar2.f18624b;
                    if (iArr.length != 0) {
                        bVarArr[i10] = iArr.length == 1 ? new f(aVar2.f18623a, iArr[0], aVar2.f18625c, aVar2.f18626d) : b(aVar2.f18623a, dVar, iArr, (ImmutableList) immutableListB.get(i10));
                    }
                }
            }
            return bVarArr;
        }

        public a b(TrackGroup trackGroup, ed.d dVar, int[] iArr, ImmutableList<C0193a> immutableList) {
            return new a(trackGroup, iArr, dVar, this.f18617a, this.f18618b, this.f18619c, this.f18620d, this.f18621e, immutableList, this.f18622f);
        }

        public b(int i10, int i11, int i12, float f10) {
            this(i10, i11, i12, f10, 0.75f, hd.c.f30965a);
        }

        public b(int i10, int i11, int i12, float f10, float f11, hd.c cVar) {
            this.f18617a = i10;
            this.f18618b = i11;
            this.f18619c = i12;
            this.f18620d = f10;
            this.f18621e = f11;
            this.f18622f = cVar;
        }
    }

    public a(TrackGroup trackGroup, int[] iArr, ed.d dVar) {
        this(trackGroup, iArr, dVar, 10000L, 25000L, 25000L, 0.7f, 0.75f, ImmutableList.of(), hd.c.f30965a);
    }

    public static ImmutableList<ImmutableList<C0193a>> B(b.a[] aVarArr) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < aVarArr.length; i10++) {
            if (aVarArr[i10] == null || aVarArr[i10].f18624b.length <= 1) {
                arrayList.add(null);
            } else {
                ImmutableList.Builder builder = ImmutableList.builder();
                builder.add(new C0193a(0L, 0L));
                arrayList.add(builder);
            }
        }
        long[][] jArrE = E(aVarArr);
        int[] iArr = new int[jArrE.length];
        long[] jArr = new long[jArrE.length];
        for (int i11 = 0; i11 < jArrE.length; i11++) {
            jArr[i11] = jArrE[i11].length == 0 ? 0L : jArrE[i11][0];
        }
        y(arrayList, jArr);
        ImmutableList<Integer> immutableListF = F(jArrE);
        for (int i12 = 0; i12 < immutableListF.size(); i12++) {
            int iIntValue = immutableListF.get(i12).intValue();
            int i13 = iArr[iIntValue] + 1;
            iArr[iIntValue] = i13;
            jArr[iIntValue] = jArrE[iIntValue][i13];
            y(arrayList, jArr);
        }
        for (int i14 = 0; i14 < aVarArr.length; i14++) {
            if (arrayList.get(i14) != null) {
                jArr[i14] = jArr[i14] * 2;
            }
        }
        y(arrayList, jArr);
        ImmutableList.Builder builder2 = ImmutableList.builder();
        for (int i15 = 0; i15 < arrayList.size(); i15++) {
            ImmutableList.Builder builder3 = (ImmutableList.Builder) arrayList.get(i15);
            builder2.add(builder3 == null ? ImmutableList.of() : builder3.build());
        }
        return builder2.build();
    }

    public static long[][] E(b.a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        for (int i10 = 0; i10 < aVarArr.length; i10++) {
            b.a aVar = aVarArr[i10];
            if (aVar == null) {
                jArr[i10] = new long[0];
            } else {
                jArr[i10] = new long[aVar.f18624b.length];
                int i11 = 0;
                while (true) {
                    if (i11 >= aVar.f18624b.length) {
                        break;
                    }
                    jArr[i10][i11] = aVar.f18623a.a(r5[i11]).f16694h;
                    i11++;
                }
                Arrays.sort(jArr[i10]);
            }
        }
        return jArr;
    }

    public static ImmutableList<Integer> F(long[][] jArr) {
        Multimap multimapBuild = MultimapBuilder.treeKeys().arrayListValues().build();
        for (int i10 = 0; i10 < jArr.length; i10++) {
            if (jArr[i10].length > 1) {
                int length = jArr[i10].length;
                double[] dArr = new double[length];
                int i11 = 0;
                while (true) {
                    double dLog = 0.0d;
                    if (i11 >= jArr[i10].length) {
                        break;
                    }
                    if (jArr[i10][i11] != -1) {
                        dLog = Math.log(jArr[i10][i11]);
                    }
                    dArr[i11] = dLog;
                    i11++;
                }
                int i12 = length - 1;
                double d10 = dArr[i12] - dArr[0];
                int i13 = 0;
                while (i13 < i12) {
                    double d11 = dArr[i13];
                    i13++;
                    multimapBuild.put(Double.valueOf(d10 == 0.0d ? 1.0d : (((d11 + dArr[i13]) * 0.5d) - dArr[0]) / d10), Integer.valueOf(i10));
                }
            }
        }
        return ImmutableList.copyOf(multimapBuild.values());
    }

    public static void y(List<ImmutableList.Builder<C0193a>> list, long[] jArr) {
        long j10 = 0;
        for (long j11 : jArr) {
            j10 += j11;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            ImmutableList.Builder<C0193a> builder = list.get(i10);
            if (builder != null) {
                builder.add(new C0193a(j10, jArr[i10]));
            }
        }
    }

    public final int A(long j10) {
        long jC = C();
        int i10 = 0;
        for (int i11 = 0; i11 < this.f556b; i11++) {
            if (j10 == Long.MIN_VALUE || !v(i11, j10)) {
                Format formatB = b(i11);
                if (z(formatB, formatB.f16694h, this.f18610o, jC)) {
                    return i11;
                }
                i10 = i11;
            }
        }
        return i10;
    }

    public final long C() {
        long jE = (long) (this.f18602g.e() * this.f18606k);
        if (this.f18608m.isEmpty()) {
            return jE;
        }
        int i10 = 1;
        while (i10 < this.f18608m.size() - 1 && this.f18608m.get(i10).f18615a < jE) {
            i10++;
        }
        C0193a c0193a = this.f18608m.get(i10 - 1);
        C0193a c0193a2 = this.f18608m.get(i10);
        long j10 = c0193a.f18615a;
        float f10 = (jE - j10) / (c0193a2.f18615a - j10);
        return c0193a.f18616b + ((long) (f10 * (c0193a2.f18616b - r1)));
    }

    public long D() {
        return this.f18605j;
    }

    public final long G(long j10) {
        return (j10 > g.f56663b ? 1 : (j10 == g.f56663b ? 0 : -1)) != 0 && (j10 > this.f18603h ? 1 : (j10 == this.f18603h ? 0 : -1)) <= 0 ? (long) (j10 * this.f18607l) : this.f18603h;
    }

    public boolean H(long j10, List<? extends m> list) {
        long j11 = this.f18613r;
        return j11 == g.f56663b || j10 - j11 >= 1000 || !(list.isEmpty() || ((m) Iterables.getLast(list)).equals(this.f18614s));
    }

    @Override // ad.b, com.google.android.exoplayer2.trackselection.b
    @i
    public void g() {
        this.f18614s = null;
    }

    @Override // com.google.android.exoplayer2.trackselection.b
    public int i() {
        return this.f18611p;
    }

    @Override // ad.b, com.google.android.exoplayer2.trackselection.b
    @i
    public void l() {
        this.f18613r = g.f56663b;
        this.f18614s = null;
    }

    @Override // com.google.android.exoplayer2.trackselection.b
    public void m(long j10, long j11, long j12, List<? extends m> list, n[] nVarArr) {
        long jE = this.f18609n.e();
        int i10 = this.f18612q;
        if (i10 == 0) {
            this.f18612q = 1;
            this.f18611p = A(jE);
            return;
        }
        int i11 = this.f18611p;
        int iD = list.isEmpty() ? -1 : d(((m) Iterables.getLast(list)).f29166d);
        if (iD != -1) {
            i10 = ((m) Iterables.getLast(list)).f29167e;
            i11 = iD;
        }
        int iA = A(jE);
        if (!v(i11, jE)) {
            Format formatB = b(i11);
            Format formatB2 = b(iA);
            if ((formatB2.f16694h > formatB.f16694h && j11 < G(j12)) || (formatB2.f16694h < formatB.f16694h && j11 >= this.f18604i)) {
                iA = i11;
            }
        }
        if (iA != i11) {
            i10 = 3;
        }
        this.f18612q = i10;
        this.f18611p = iA;
    }

    @Override // ad.b, com.google.android.exoplayer2.trackselection.b
    public int n(long j10, List<? extends m> list) {
        int i10;
        int i11;
        long jE = this.f18609n.e();
        if (!H(jE, list)) {
            return list.size();
        }
        this.f18613r = jE;
        this.f18614s = list.isEmpty() ? null : (m) Iterables.getLast(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long jN0 = u0.n0(list.get(size - 1).f29169g - j10, this.f18610o);
        long jD = D();
        if (jN0 < jD) {
            return size;
        }
        Format formatB = b(A(jE));
        for (int i12 = 0; i12 < size; i12++) {
            m mVar = list.get(i12);
            Format format = mVar.f29166d;
            if (u0.n0(mVar.f29169g - j10, this.f18610o) >= jD && format.f16694h < formatB.f16694h && (i10 = format.f16705r) != -1 && i10 < 720 && (i11 = format.f16704q) != -1 && i11 < 1280 && i10 < formatB.f16705r) {
                return i12;
            }
        }
        return size;
    }

    @Override // com.google.android.exoplayer2.trackselection.b
    public int q() {
        return this.f18612q;
    }

    @Override // ad.b, com.google.android.exoplayer2.trackselection.b
    public void r(float f10) {
        this.f18610o = f10;
    }

    @Override // com.google.android.exoplayer2.trackselection.b
    @p0
    public Object s() {
        return null;
    }

    public boolean z(Format format, int i10, float f10, long j10) {
        return ((long) Math.round(((float) i10) * f10)) <= j10;
    }

    public a(TrackGroup trackGroup, int[] iArr, ed.d dVar, long j10, long j11, long j12, float f10, float f11, List<C0193a> list, hd.c cVar) {
        super(trackGroup, iArr);
        this.f18602g = dVar;
        this.f18603h = j10 * 1000;
        this.f18604i = j11 * 1000;
        this.f18605j = j12 * 1000;
        this.f18606k = f10;
        this.f18607l = f11;
        this.f18608m = ImmutableList.copyOf((Collection) list);
        this.f18609n = cVar;
        this.f18610o = 1.0f;
        this.f18612q = 0;
        this.f18613r = g.f56663b;
    }
}
