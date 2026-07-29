package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.l;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import ed.z;
import g.p0;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import ya.v0;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class MergingMediaSource extends c<Integer> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f17482u = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final v0 f17483v = new v0.c().z("MergingMediaSource").a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f17484j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f17485k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final l[] f17486l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final x1[] f17487m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList<l> f17488n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ec.d f17489o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<Object, Long> f17490p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Multimap<Object, b> f17491q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f17492r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long[][] f17493s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @p0
    public IllegalMergeException f17494t;

    public static final class IllegalMergeException extends IOException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f17495a = 0;
        public final int reason;

        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface a {
        }

        public IllegalMergeException(int i10) {
            this.reason = i10;
        }
    }

    public static final class a extends ec.i {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long[] f17496c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long[] f17497d;

        public a(x1 x1Var, Map<Object, Long> map) {
            super(x1Var);
            int iQ = x1Var.q();
            this.f17497d = new long[x1Var.q()];
            x1.c cVar = new x1.c();
            for (int i10 = 0; i10 < iQ; i10++) {
                this.f17497d[i10] = x1Var.n(i10, cVar).f57255p;
            }
            int i11 = x1Var.i();
            this.f17496c = new long[i11];
            x1.b bVar = new x1.b();
            for (int i12 = 0; i12 < i11; i12++) {
                x1Var.g(i12, bVar, true);
                long jLongValue = ((Long) hd.a.g(map.get(bVar.f57233b))).longValue();
                long[] jArr = this.f17496c;
                jArr[i12] = jLongValue == Long.MIN_VALUE ? bVar.f57235d : jLongValue;
                long j10 = bVar.f57235d;
                if (j10 != ya.g.f56663b) {
                    long[] jArr2 = this.f17497d;
                    int i13 = bVar.f57234c;
                    jArr2[i13] = jArr2[i13] - (j10 - jArr[i12]);
                }
            }
        }

        @Override // ec.i, ya.x1
        public x1.b g(int i10, x1.b bVar, boolean z10) {
            super.g(i10, bVar, z10);
            bVar.f57235d = this.f17496c[i10];
            return bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
        @Override // ec.i, ya.x1
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ya.x1.c o(int r5, ya.x1.c r6, long r7) {
            /*
                r4 = this;
                super.o(r5, r6, r7)
                long[] r7 = r4.f17497d
                r0 = r7[r5]
                r6.f57255p = r0
                r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                int r5 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
                if (r5 == 0) goto L1e
                long r2 = r6.f57254o
                int r5 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
                if (r5 != 0) goto L19
                goto L1e
            L19:
                long r7 = java.lang.Math.min(r2, r0)
                goto L20
            L1e:
                long r7 = r6.f57254o
            L20:
                r6.f57254o = r7
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.MergingMediaSource.a.o(int, ya.x1$c, long):ya.x1$c");
        }
    }

    public MergingMediaSource(l... lVarArr) {
        this(false, lVarArr);
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void C(@p0 z zVar) {
        super.C(zVar);
        for (int i10 = 0; i10 < this.f17486l.length; i10++) {
            N(Integer.valueOf(i10), this.f17486l[i10]);
        }
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.a
    public void E() {
        super.E();
        Arrays.fill(this.f17487m, (Object) null);
        this.f17492r = -1;
        this.f17494t = null;
        this.f17488n.clear();
        Collections.addAll(this.f17488n, this.f17486l);
    }

    public final void P() {
        x1.b bVar = new x1.b();
        for (int i10 = 0; i10 < this.f17492r; i10++) {
            long j10 = -this.f17487m[0].f(i10, bVar).n();
            int i11 = 1;
            while (true) {
                x1[] x1VarArr = this.f17487m;
                if (i11 < x1VarArr.length) {
                    this.f17493s[i10][i11] = j10 - (-x1VarArr[i11].f(i10, bVar).n());
                    i11++;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.c
    @p0
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public l.a I(Integer num, l.a aVar) {
        if (num.intValue() == 0) {
            return aVar;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.source.c
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public void L(Integer num, l lVar, x1 x1Var) {
        if (this.f17494t != null) {
            return;
        }
        if (this.f17492r == -1) {
            this.f17492r = x1Var.i();
        } else if (x1Var.i() != this.f17492r) {
            this.f17494t = new IllegalMergeException(0);
            return;
        }
        if (this.f17493s.length == 0) {
            this.f17493s = (long[][]) Array.newInstance((Class<?>) long.class, this.f17492r, this.f17487m.length);
        }
        this.f17488n.remove(lVar);
        this.f17487m[num.intValue()] = x1Var;
        if (this.f17488n.isEmpty()) {
            if (this.f17484j) {
                P();
            }
            x1 aVar = this.f17487m[0];
            if (this.f17485k) {
                S();
                aVar = new a(aVar, this.f17490p);
            }
            D(aVar);
        }
    }

    public final void S() {
        x1[] x1VarArr;
        x1.b bVar = new x1.b();
        for (int i10 = 0; i10 < this.f17492r; i10++) {
            long j10 = Long.MIN_VALUE;
            int i11 = 0;
            while (true) {
                x1VarArr = this.f17487m;
                if (i11 >= x1VarArr.length) {
                    break;
                }
                long j11 = x1VarArr[i11].f(i10, bVar).j();
                if (j11 != ya.g.f56663b) {
                    long j12 = j11 + this.f17493s[i10][i11];
                    if (j10 == Long.MIN_VALUE || j12 < j10) {
                        j10 = j12;
                    }
                }
                i11++;
            }
            Object objM = x1VarArr[0].m(i10);
            this.f17490p.put(objM, Long.valueOf(j10));
            Iterator<b> it2 = this.f17491q.get(objM).iterator();
            while (it2.hasNext()) {
                it2.next().v(0L, j10);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.a aVar, ed.b bVar, long j10) {
        int length = this.f17486l.length;
        k[] kVarArr = new k[length];
        int iB = this.f17487m[0].b(aVar.f26856a);
        for (int i10 = 0; i10 < length; i10++) {
            kVarArr[i10] = this.f17486l[i10].a(aVar.a(this.f17487m[i10].m(iB)), bVar, j10 - this.f17493s[iB][i10]);
        }
        n nVar = new n(this.f17489o, this.f17493s[iB], kVarArr);
        if (!this.f17485k) {
            return nVar;
        }
        b bVar2 = new b(nVar, true, 0L, ((Long) hd.a.g(this.f17490p.get(aVar.f26856a))).longValue());
        this.f17491q.put(aVar.f26856a, bVar2);
        return bVar2;
    }

    @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.source.l
    @p0
    @Deprecated
    public Object h() {
        l[] lVarArr = this.f17486l;
        if (lVarArr.length > 0) {
            return lVarArr[0].h();
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.source.l
    public v0 j() {
        l[] lVarArr = this.f17486l;
        return lVarArr.length > 0 ? lVarArr[0].j() : f17483v;
    }

    @Override // com.google.android.exoplayer2.source.c, com.google.android.exoplayer2.source.l
    public void n() throws IOException {
        IllegalMergeException illegalMergeException = this.f17494t;
        if (illegalMergeException != null) {
            throw illegalMergeException;
        }
        super.n();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void p(k kVar) {
        if (this.f17485k) {
            b bVar = (b) kVar;
            Iterator<Map.Entry<Object, b>> it2 = this.f17491q.entries().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry<Object, b> next = it2.next();
                if (next.getValue().equals(bVar)) {
                    this.f17491q.remove(next.getKey(), next.getValue());
                    break;
                }
            }
            kVar = bVar.f17562a;
        }
        n nVar = (n) kVar;
        int i10 = 0;
        while (true) {
            l[] lVarArr = this.f17486l;
            if (i10 >= lVarArr.length) {
                return;
            }
            lVarArr[i10].p(nVar.d(i10));
            i10++;
        }
    }

    public MergingMediaSource(boolean z10, l... lVarArr) {
        this(z10, false, lVarArr);
    }

    public MergingMediaSource(boolean z10, boolean z11, l... lVarArr) {
        this(z10, z11, new ec.f(), lVarArr);
    }

    public MergingMediaSource(boolean z10, boolean z11, ec.d dVar, l... lVarArr) {
        this.f17484j = z10;
        this.f17485k = z11;
        this.f17486l = lVarArr;
        this.f17489o = dVar;
        this.f17488n = new ArrayList<>(Arrays.asList(lVarArr));
        this.f17492r = -1;
        this.f17487m = new x1[lVarArr.length];
        this.f17493s = new long[0][];
        this.f17490p = new HashMap();
        this.f17491q = MultimapBuilder.hashKeys().arrayListValues().build();
    }
}
