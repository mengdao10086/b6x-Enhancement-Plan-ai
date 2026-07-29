package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.k;
import ec.d0;
import g.p0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import ya.s0;
import ya.t1;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements k, k.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k[] f18157a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ec.d f18159c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public k.a f18161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public TrackGroupArray f18162f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public s f18164h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<k> f18160d = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IdentityHashMap<d0, Integer> f18158b = new IdentityHashMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public k[] f18163g = new k[0];

    public static final class a implements k, k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k f18165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f18166b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public k.a f18167c;

        public a(k kVar, long j10) {
            this.f18165a = kVar;
            this.f18166b = j10;
        }

        @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
        public long b() {
            long jB = this.f18165a.b();
            if (jB == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.f18166b + jB;
        }

        @Override // com.google.android.exoplayer2.source.k
        public long c(long j10, t1 t1Var) {
            return this.f18165a.c(j10 - this.f18166b, t1Var) + this.f18166b;
        }

        @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
        public boolean e(long j10) {
            return this.f18165a.e(j10 - this.f18166b);
        }

        @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
        public long f() {
            long jF = this.f18165a.f();
            if (jF == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.f18166b + jF;
        }

        @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
        public void g(long j10) {
            this.f18165a.g(j10 - this.f18166b);
        }

        @Override // com.google.android.exoplayer2.source.s.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void i(k kVar) {
            ((k.a) hd.a.g(this.f18167c)).i(this);
        }

        @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
        public boolean isLoading() {
            return this.f18165a.isLoading();
        }

        @Override // com.google.android.exoplayer2.source.k
        public List<StreamKey> j(List<com.google.android.exoplayer2.trackselection.b> list) {
            return this.f18165a.j(list);
        }

        @Override // com.google.android.exoplayer2.source.k.a
        public void l(k kVar) {
            ((k.a) hd.a.g(this.f18167c)).l(this);
        }

        @Override // com.google.android.exoplayer2.source.k
        public void m() throws IOException {
            this.f18165a.m();
        }

        @Override // com.google.android.exoplayer2.source.k
        public long n(long j10) {
            return this.f18165a.n(j10 - this.f18166b) + this.f18166b;
        }

        @Override // com.google.android.exoplayer2.source.k
        public long p() {
            long jP = this.f18165a.p();
            return jP == ya.g.f56663b ? ya.g.f56663b : this.f18166b + jP;
        }

        @Override // com.google.android.exoplayer2.source.k
        public void q(k.a aVar, long j10) {
            this.f18167c = aVar;
            this.f18165a.q(this, j10 - this.f18166b);
        }

        @Override // com.google.android.exoplayer2.source.k
        public TrackGroupArray r() {
            return this.f18165a.r();
        }

        @Override // com.google.android.exoplayer2.source.k
        public long s(com.google.android.exoplayer2.trackselection.b[] bVarArr, boolean[] zArr, d0[] d0VarArr, boolean[] zArr2, long j10) {
            d0[] d0VarArr2 = new d0[d0VarArr.length];
            int i10 = 0;
            while (true) {
                d0 d0VarB = null;
                if (i10 >= d0VarArr.length) {
                    break;
                }
                b bVar = (b) d0VarArr[i10];
                if (bVar != null) {
                    d0VarB = bVar.b();
                }
                d0VarArr2[i10] = d0VarB;
                i10++;
            }
            long jS = this.f18165a.s(bVarArr, zArr, d0VarArr2, zArr2, j10 - this.f18166b);
            for (int i11 = 0; i11 < d0VarArr.length; i11++) {
                d0 d0Var = d0VarArr2[i11];
                if (d0Var == null) {
                    d0VarArr[i11] = null;
                } else if (d0VarArr[i11] == null || ((b) d0VarArr[i11]).b() != d0Var) {
                    d0VarArr[i11] = new b(d0Var, this.f18166b);
                }
            }
            return jS + this.f18166b;
        }

        @Override // com.google.android.exoplayer2.source.k
        public void u(long j10, boolean z10) {
            this.f18165a.u(j10 - this.f18166b, z10);
        }
    }

    public static final class b implements d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d0 f18168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f18169b;

        public b(d0 d0Var, long j10) {
            this.f18168a = d0Var;
            this.f18169b = j10;
        }

        @Override // ec.d0
        public void a() throws IOException {
            this.f18168a.a();
        }

        public d0 b() {
            return this.f18168a;
        }

        @Override // ec.d0
        public boolean d() {
            return this.f18168a.d();
        }

        @Override // ec.d0
        public int k(s0 s0Var, DecoderInputBuffer decoderInputBuffer, boolean z10) {
            int iK = this.f18168a.k(s0Var, decoderInputBuffer, z10);
            if (iK == -4) {
                decoderInputBuffer.f16962e = Math.max(0L, decoderInputBuffer.f16962e + this.f18169b);
            }
            return iK;
        }

        @Override // ec.d0
        public int o(long j10) {
            return this.f18168a.o(j10 - this.f18169b);
        }
    }

    public n(ec.d dVar, long[] jArr, k... kVarArr) {
        this.f18159c = dVar;
        this.f18157a = kVarArr;
        this.f18164h = dVar.a(new s[0]);
        for (int i10 = 0; i10 < kVarArr.length; i10++) {
            if (jArr[i10] != 0) {
                this.f18157a[i10] = new a(kVarArr[i10], jArr[i10]);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public long b() {
        return this.f18164h.b();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long c(long j10, t1 t1Var) {
        k[] kVarArr = this.f18163g;
        return (kVarArr.length > 0 ? kVarArr[0] : this.f18157a[0]).c(j10, t1Var);
    }

    public k d(int i10) {
        k[] kVarArr = this.f18157a;
        return kVarArr[i10] instanceof a ? ((a) kVarArr[i10]).f18165a : kVarArr[i10];
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public boolean e(long j10) {
        if (this.f18160d.isEmpty()) {
            return this.f18164h.e(j10);
        }
        int size = this.f18160d.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f18160d.get(i10).e(j10);
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public long f() {
        return this.f18164h.f();
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public void g(long j10) {
        this.f18164h.g(j10);
    }

    @Override // com.google.android.exoplayer2.source.s.a
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void i(k kVar) {
        ((k.a) hd.a.g(this.f18161e)).i(this);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.s
    public boolean isLoading() {
        return this.f18164h.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.k
    public /* synthetic */ List j(List list) {
        return ec.m.a(this, list);
    }

    @Override // com.google.android.exoplayer2.source.k.a
    public void l(k kVar) {
        this.f18160d.remove(kVar);
        if (this.f18160d.isEmpty()) {
            int i10 = 0;
            for (k kVar2 : this.f18157a) {
                i10 += kVar2.r().f17502a;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i10];
            int i11 = 0;
            for (k kVar3 : this.f18157a) {
                TrackGroupArray trackGroupArrayR = kVar3.r();
                int i12 = trackGroupArrayR.f17502a;
                int i13 = 0;
                while (i13 < i12) {
                    trackGroupArr[i11] = trackGroupArrayR.a(i13);
                    i13++;
                    i11++;
                }
            }
            this.f18162f = new TrackGroupArray(trackGroupArr);
            ((k.a) hd.a.g(this.f18161e)).l(this);
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void m() throws IOException {
        for (k kVar : this.f18157a) {
            kVar.m();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public long n(long j10) {
        long jN = this.f18163g[0].n(j10);
        int i10 = 1;
        while (true) {
            k[] kVarArr = this.f18163g;
            if (i10 >= kVarArr.length) {
                return jN;
            }
            if (kVarArr[i10].n(jN) != jN) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i10++;
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public long p() {
        long j10 = -9223372036854775807L;
        for (k kVar : this.f18163g) {
            long jP = kVar.p();
            if (jP == ya.g.f56663b) {
                if (j10 != ya.g.f56663b && kVar.n(j10) != j10) {
                    throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            } else if (j10 == ya.g.f56663b) {
                for (k kVar2 : this.f18163g) {
                    if (kVar2 == kVar) {
                        break;
                    }
                    if (kVar2.n(jP) != jP) {
                        throw new IllegalStateException("Unexpected child seekToUs result.");
                    }
                }
                j10 = jP;
            } else if (jP != j10) {
                throw new IllegalStateException("Conflicting discontinuities.");
            }
        }
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void q(k.a aVar, long j10) {
        this.f18161e = aVar;
        Collections.addAll(this.f18160d, this.f18157a);
        for (k kVar : this.f18157a) {
            kVar.q(this, j10);
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public TrackGroupArray r() {
        return (TrackGroupArray) hd.a.g(this.f18162f);
    }

    @Override // com.google.android.exoplayer2.source.k
    public long s(com.google.android.exoplayer2.trackselection.b[] bVarArr, boolean[] zArr, d0[] d0VarArr, boolean[] zArr2, long j10) {
        int[] iArr = new int[bVarArr.length];
        int[] iArr2 = new int[bVarArr.length];
        for (int i10 = 0; i10 < bVarArr.length; i10++) {
            Integer num = d0VarArr[i10] == null ? null : this.f18158b.get(d0VarArr[i10]);
            iArr[i10] = num == null ? -1 : num.intValue();
            iArr2[i10] = -1;
            if (bVarArr[i10] != null) {
                TrackGroup trackGroupA = bVarArr[i10].a();
                int i11 = 0;
                while (true) {
                    k[] kVarArr = this.f18157a;
                    if (i11 >= kVarArr.length) {
                        break;
                    }
                    if (kVarArr[i11].r().b(trackGroupA) != -1) {
                        iArr2[i10] = i11;
                        break;
                    }
                    i11++;
                }
            }
        }
        this.f18158b.clear();
        int length = bVarArr.length;
        d0[] d0VarArr2 = new d0[length];
        d0[] d0VarArr3 = new d0[bVarArr.length];
        com.google.android.exoplayer2.trackselection.b[] bVarArr2 = new com.google.android.exoplayer2.trackselection.b[bVarArr.length];
        ArrayList arrayList = new ArrayList(this.f18157a.length);
        long j11 = j10;
        int i12 = 0;
        while (i12 < this.f18157a.length) {
            for (int i13 = 0; i13 < bVarArr.length; i13++) {
                d0VarArr3[i13] = iArr[i13] == i12 ? d0VarArr[i13] : null;
                bVarArr2[i13] = iArr2[i13] == i12 ? bVarArr[i13] : null;
            }
            int i14 = i12;
            ArrayList arrayList2 = arrayList;
            com.google.android.exoplayer2.trackselection.b[] bVarArr3 = bVarArr2;
            long jS = this.f18157a[i12].s(bVarArr2, zArr, d0VarArr3, zArr2, j11);
            if (i14 == 0) {
                j11 = jS;
            } else if (jS != j11) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z10 = false;
            for (int i15 = 0; i15 < bVarArr.length; i15++) {
                if (iArr2[i15] == i14) {
                    d0 d0Var = (d0) hd.a.g(d0VarArr3[i15]);
                    d0VarArr2[i15] = d0VarArr3[i15];
                    this.f18158b.put(d0Var, Integer.valueOf(i14));
                    z10 = true;
                } else if (iArr[i15] == i14) {
                    hd.a.i(d0VarArr3[i15] == null);
                }
            }
            if (z10) {
                arrayList2.add(this.f18157a[i14]);
            }
            i12 = i14 + 1;
            arrayList = arrayList2;
            bVarArr2 = bVarArr3;
        }
        System.arraycopy(d0VarArr2, 0, d0VarArr, 0, length);
        k[] kVarArr2 = (k[]) arrayList.toArray(new k[0]);
        this.f18163g = kVarArr2;
        this.f18164h = this.f18159c.a(kVarArr2);
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void u(long j10, boolean z10) {
        for (k kVar : this.f18163g) {
            kVar.u(j10, z10);
        }
    }
}
