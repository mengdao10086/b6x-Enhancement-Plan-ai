package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.c;
import com.google.android.exoplayer2.upstream.b;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.primitives.Ints;
import ed.z;
import g.i1;
import g.p0;
import hd.s0;
import hd.u0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class f {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f17832s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f17833t = 1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f17834u = 2;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f17835v = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f17836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f17837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f17838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v f17839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Uri[] f17840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Format[] f17841f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HlsPlaylistTracker f17842g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TrackGroup f17843h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public final List<Format> f17844i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f17846k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public IOException f17848m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @p0
    public Uri f17849n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f17850o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.google.android.exoplayer2.trackselection.b f17851p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f17853r;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FullSegmentEncryptionKeyCache f17845j = new FullSegmentEncryptionKeyCache(4);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte[] f17847l = u0.f31159f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f17852q = ya.g.f56663b;

    public static final class a extends gc.k {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public byte[] f17854m;

        public a(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, Format format, int i10, @p0 Object obj, byte[] bArr) {
            super(aVar, bVar, 3, format, i10, obj, bArr);
        }

        @Override // gc.k
        public void g(byte[] bArr, int i10) {
            this.f17854m = Arrays.copyOf(bArr, i10);
        }

        @p0
        public byte[] j() {
            return this.f17854m;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @p0
        public gc.e f17855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f17856b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public Uri f17857c;

        public b() {
            a();
        }

        public void a() {
            this.f17855a = null;
            this.f17856b = false;
            this.f17857c = null;
        }
    }

    @i1
    public static final class c extends gc.b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<c.f> f17858e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f17859f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f17860g;

        public c(String str, long j10, List<c.f> list) {
            super(0L, list.size() - 1);
            this.f17860g = str;
            this.f17859f = j10;
            this.f17858e = list;
        }

        @Override // gc.n
        public long a() {
            e();
            return this.f17859f + this.f17858e.get((int) f()).f18055e;
        }

        @Override // gc.n
        public com.google.android.exoplayer2.upstream.b c() {
            e();
            c.f fVar = this.f17858e.get((int) f());
            return new com.google.android.exoplayer2.upstream.b(s0.e(this.f17860g, fVar.f18051a), fVar.f18059i, fVar.f18060j);
        }

        @Override // gc.n
        public long d() {
            e();
            c.f fVar = this.f17858e.get((int) f());
            return this.f17859f + fVar.f18055e + fVar.f18053c;
        }
    }

    public static final class d extends ad.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f17861g;

        public d(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
            this.f17861g = d(trackGroup.a(iArr[0]));
        }

        @Override // com.google.android.exoplayer2.trackselection.b
        public int i() {
            return this.f17861g;
        }

        @Override // com.google.android.exoplayer2.trackselection.b
        public void m(long j10, long j11, long j12, List<? extends gc.m> list, gc.n[] nVarArr) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (v(this.f17861g, jElapsedRealtime)) {
                for (int i10 = this.f556b - 1; i10 >= 0; i10--) {
                    if (!v(i10, jElapsedRealtime)) {
                        this.f17861g = i10;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        @Override // com.google.android.exoplayer2.trackselection.b
        public int q() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.trackselection.b
        @p0
        public Object s() {
            return null;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c.f f17862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f17863b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f17864c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f17865d;

        public e(c.f fVar, long j10, int i10) {
            this.f17862a = fVar;
            this.f17863b = j10;
            this.f17864c = i10;
            this.f17865d = (fVar instanceof c.b) && ((c.b) fVar).f18045m;
        }
    }

    public f(h hVar, HlsPlaylistTracker hlsPlaylistTracker, Uri[] uriArr, Format[] formatArr, g gVar, @p0 z zVar, v vVar, @p0 List<Format> list) {
        this.f17836a = hVar;
        this.f17842g = hlsPlaylistTracker;
        this.f17840e = uriArr;
        this.f17841f = formatArr;
        this.f17839d = vVar;
        this.f17844i = list;
        com.google.android.exoplayer2.upstream.a aVarA = gVar.a(1);
        this.f17837b = aVarA;
        if (zVar != null) {
            aVarA.d(zVar);
        }
        this.f17838c = gVar.a(3);
        this.f17843h = new TrackGroup(formatArr);
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < uriArr.length; i10++) {
            if ((formatArr[i10].f16691e & 16384) == 0) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        this.f17851p = new d(this.f17843h, Ints.toArray(arrayList));
    }

    @p0
    public static Uri c(com.google.android.exoplayer2.source.hls.playlist.c cVar, @p0 c.f fVar) {
        String str;
        if (fVar == null || (str = fVar.f18057g) == null) {
            return null;
        }
        return s0.e(cVar.f39566a, str);
    }

    @p0
    public static e f(com.google.android.exoplayer2.source.hls.playlist.c cVar, long j10, int i10) {
        int i11 = (int) (j10 - cVar.f18032i);
        if (i11 == cVar.f18039p.size()) {
            if (i10 == -1) {
                i10 = 0;
            }
            if (i10 < cVar.f18040q.size()) {
                return new e(cVar.f18040q.get(i10), j10, i10);
            }
            return null;
        }
        c.e eVar = cVar.f18039p.get(i11);
        if (i10 == -1) {
            return new e(eVar, j10, -1);
        }
        if (i10 < eVar.f18050m.size()) {
            return new e(eVar.f18050m.get(i10), j10, i10);
        }
        int i12 = i11 + 1;
        if (i12 < cVar.f18039p.size()) {
            return new e(cVar.f18039p.get(i12), j10 + 1, -1);
        }
        if (cVar.f18040q.isEmpty()) {
            return null;
        }
        return new e(cVar.f18040q.get(0), j10 + 1, 0);
    }

    @i1
    public static List<c.f> h(com.google.android.exoplayer2.source.hls.playlist.c cVar, long j10, int i10) {
        int i11 = (int) (j10 - cVar.f18032i);
        if (i11 < 0 || cVar.f18039p.size() < i11) {
            return ImmutableList.of();
        }
        ArrayList arrayList = new ArrayList();
        if (i11 < cVar.f18039p.size()) {
            if (i10 != -1) {
                c.e eVar = cVar.f18039p.get(i11);
                if (i10 == 0) {
                    arrayList.add(eVar);
                } else if (i10 < eVar.f18050m.size()) {
                    List<c.b> list = eVar.f18050m;
                    arrayList.addAll(list.subList(i10, list.size()));
                }
                i11++;
            }
            List<c.e> list2 = cVar.f18039p;
            arrayList.addAll(list2.subList(i11, list2.size()));
            i10 = 0;
        }
        if (cVar.f18035l != ya.g.f56663b) {
            int i12 = i10 != -1 ? i10 : 0;
            if (i12 < cVar.f18040q.size()) {
                List<c.b> list3 = cVar.f18040q;
                arrayList.addAll(list3.subList(i12, list3.size()));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public gc.n[] a(@p0 j jVar, long j10) {
        int i10;
        int iB = jVar == null ? -1 : this.f17843h.b(jVar.f29166d);
        int length = this.f17851p.length();
        gc.n[] nVarArr = new gc.n[length];
        boolean z10 = false;
        int i11 = 0;
        while (i11 < length) {
            int iC = this.f17851p.c(i11);
            Uri uri = this.f17840e[iC];
            if (this.f17842g.a(uri)) {
                com.google.android.exoplayer2.source.hls.playlist.c cVarK = this.f17842g.k(uri, z10);
                hd.a.g(cVarK);
                long jD = cVarK.f18029f - this.f17842g.d();
                i10 = i11;
                Pair<Long, Integer> pairE = e(jVar, iC != iB, cVarK, jD, j10);
                nVarArr[i10] = new c(cVarK.f39566a, jD, h(cVarK, ((Long) pairE.first).longValue(), ((Integer) pairE.second).intValue()));
            } else {
                nVarArr[i11] = gc.n.f29217a;
                i10 = i11;
            }
            i11 = i10 + 1;
            z10 = false;
        }
        return nVarArr;
    }

    public int b(j jVar) {
        if (jVar.f17873o == -1) {
            return 1;
        }
        com.google.android.exoplayer2.source.hls.playlist.c cVar = (com.google.android.exoplayer2.source.hls.playlist.c) hd.a.g(this.f17842g.k(this.f17840e[this.f17843h.b(jVar.f29166d)], false));
        int i10 = (int) (jVar.f29216j - cVar.f18032i);
        if (i10 < 0) {
            return 1;
        }
        List<c.b> list = i10 < cVar.f18039p.size() ? cVar.f18039p.get(i10).f18050m : cVar.f18040q;
        if (jVar.f17873o >= list.size()) {
            return 2;
        }
        c.b bVar = list.get(jVar.f17873o);
        if (bVar.f18045m) {
            return 0;
        }
        return u0.c(Uri.parse(s0.d(cVar.f39566a, bVar.f18051a)), jVar.f29164b.f19092a) ? 1 : 2;
    }

    public void d(long j10, long j11, List<j> list, boolean z10, b bVar) {
        long jD;
        Uri uri;
        j jVar = list.isEmpty() ? null : (j) Iterables.getLast(list);
        int iB = jVar == null ? -1 : this.f17843h.b(jVar.f29166d);
        long jMax = j11 - j10;
        long jQ = q(j10);
        if (jVar != null && !this.f17850o) {
            long jD2 = jVar.d();
            jMax = Math.max(0L, jMax - jD2);
            if (jQ != ya.g.f56663b) {
                jQ = Math.max(0L, jQ - jD2);
            }
        }
        this.f17851p.m(j10, jMax, jQ, list, a(jVar, j11));
        int iO = this.f17851p.o();
        boolean z11 = iB != iO;
        Uri uri2 = this.f17840e[iO];
        if (!this.f17842g.a(uri2)) {
            bVar.f17857c = uri2;
            this.f17853r &= uri2.equals(this.f17849n);
            this.f17849n = uri2;
            return;
        }
        com.google.android.exoplayer2.source.hls.playlist.c cVarK = this.f17842g.k(uri2, true);
        hd.a.g(cVarK);
        this.f17850o = cVarK.f39568c;
        u(cVarK);
        long jD3 = cVarK.f18029f - this.f17842g.d();
        Pair<Long, Integer> pairE = e(jVar, z11, cVarK, jD3, j11);
        long jLongValue = ((Long) pairE.first).longValue();
        int iIntValue = ((Integer) pairE.second).intValue();
        if (jLongValue >= cVarK.f18032i || jVar == null || !z11) {
            jD = jD3;
            uri = uri2;
            iB = iO;
        } else {
            Uri uri3 = this.f17840e[iB];
            com.google.android.exoplayer2.source.hls.playlist.c cVarK2 = this.f17842g.k(uri3, true);
            hd.a.g(cVarK2);
            jD = cVarK2.f18029f - this.f17842g.d();
            Pair<Long, Integer> pairE2 = e(jVar, false, cVarK2, jD, j11);
            jLongValue = ((Long) pairE2.first).longValue();
            iIntValue = ((Integer) pairE2.second).intValue();
            uri = uri3;
            cVarK = cVarK2;
        }
        if (jLongValue < cVarK.f18032i) {
            this.f17848m = new BehindLiveWindowException();
            return;
        }
        e eVarF = f(cVarK, jLongValue, iIntValue);
        if (eVarF == null) {
            if (!cVarK.f18036m) {
                bVar.f17857c = uri;
                this.f17853r &= uri.equals(this.f17849n);
                this.f17849n = uri;
                return;
            } else {
                if (z10 || cVarK.f18039p.isEmpty()) {
                    bVar.f17856b = true;
                    return;
                }
                eVarF = new e((c.f) Iterables.getLast(cVarK.f18039p), (cVarK.f18032i + ((long) cVarK.f18039p.size())) - 1, -1);
            }
        }
        this.f17853r = false;
        this.f17849n = null;
        Uri uriC = c(cVarK, eVarF.f17862a.f18052b);
        gc.e eVarK = k(uriC, iB);
        bVar.f17855a = eVarK;
        if (eVarK != null) {
            return;
        }
        Uri uriC2 = c(cVarK, eVarF.f17862a);
        gc.e eVarK2 = k(uriC2, iB);
        bVar.f17855a = eVarK2;
        if (eVarK2 != null) {
            return;
        }
        bVar.f17855a = j.j(this.f17836a, this.f17837b, this.f17841f[iB], jD, cVarK, eVarF, uri, this.f17844i, this.f17851p.q(), this.f17851p.s(), this.f17846k, this.f17839d, jVar, this.f17845j.b(uriC2), this.f17845j.b(uriC));
    }

    public final Pair<Long, Integer> e(@p0 j jVar, boolean z10, com.google.android.exoplayer2.source.hls.playlist.c cVar, long j10, long j11) {
        if (jVar != null && !z10) {
            if (!jVar.h()) {
                return new Pair<>(Long.valueOf(jVar.f29216j), Integer.valueOf(jVar.f17873o));
            }
            Long lValueOf = Long.valueOf(jVar.f17873o == -1 ? jVar.g() : jVar.f29216j);
            int i10 = jVar.f17873o;
            return new Pair<>(lValueOf, Integer.valueOf(i10 != -1 ? i10 + 1 : -1));
        }
        long j12 = cVar.f18042s + j10;
        if (jVar != null && !this.f17850o) {
            j11 = jVar.f29169g;
        }
        if (!cVar.f18036m && j11 >= j12) {
            return new Pair<>(Long.valueOf(cVar.f18032i + ((long) cVar.f18039p.size())), -1);
        }
        long j13 = j11 - j10;
        int i11 = 0;
        int iH = u0.h(cVar.f18039p, Long.valueOf(j13), true, !this.f17842g.isLive() || jVar == null);
        long j14 = ((long) iH) + cVar.f18032i;
        if (iH >= 0) {
            c.e eVar = cVar.f18039p.get(iH);
            List<c.b> list = j13 < eVar.f18055e + eVar.f18053c ? eVar.f18050m : cVar.f18040q;
            while (true) {
                if (i11 >= list.size()) {
                    break;
                }
                c.b bVar = list.get(i11);
                if (j13 >= bVar.f18055e + bVar.f18053c) {
                    i11++;
                } else if (bVar.f18044l) {
                    j14 += list == cVar.f18040q ? 1L : 0L;
                    i = i11;
                }
            }
        }
        return new Pair<>(Long.valueOf(j14), Integer.valueOf(i));
    }

    public int g(long j10, List<? extends gc.m> list) {
        return (this.f17848m != null || this.f17851p.length() < 2) ? list.size() : this.f17851p.n(j10, list);
    }

    public TrackGroup i() {
        return this.f17843h;
    }

    public com.google.android.exoplayer2.trackselection.b j() {
        return this.f17851p;
    }

    @p0
    public final gc.e k(@p0 Uri uri, int i10) {
        if (uri == null) {
            return null;
        }
        byte[] bArrD = this.f17845j.d(uri);
        if (bArrD != null) {
            this.f17845j.c(uri, bArrD);
            return null;
        }
        return new a(this.f17838c, new b.C0198b().j(uri).c(1).a(), this.f17841f[i10], this.f17851p.q(), this.f17851p.s(), this.f17847l);
    }

    public boolean l(gc.e eVar, long j10) {
        com.google.android.exoplayer2.trackselection.b bVar = this.f17851p;
        return bVar.j(bVar.e(this.f17843h.b(eVar.f29166d)), j10);
    }

    public void m() throws IOException {
        IOException iOException = this.f17848m;
        if (iOException != null) {
            throw iOException;
        }
        Uri uri = this.f17849n;
        if (uri == null || !this.f17853r) {
            return;
        }
        this.f17842g.c(uri);
    }

    public void n(gc.e eVar) {
        if (eVar instanceof a) {
            a aVar = (a) eVar;
            this.f17847l = aVar.h();
            this.f17845j.c(aVar.f29164b.f19092a, (byte[]) hd.a.g(aVar.j()));
        }
    }

    public boolean o(Uri uri, long j10) {
        int iE;
        int i10 = 0;
        while (true) {
            Uri[] uriArr = this.f17840e;
            if (i10 >= uriArr.length) {
                i10 = -1;
                break;
            }
            if (uriArr[i10].equals(uri)) {
                break;
            }
            i10++;
        }
        if (i10 == -1 || (iE = this.f17851p.e(i10)) == -1) {
            return true;
        }
        this.f17853r = uri.equals(this.f17849n) | this.f17853r;
        return j10 == ya.g.f56663b || this.f17851p.j(iE, j10);
    }

    public void p() {
        this.f17848m = null;
    }

    public final long q(long j10) {
        long j11 = this.f17852q;
        return (j11 > ya.g.f56663b ? 1 : (j11 == ya.g.f56663b ? 0 : -1)) != 0 ? j11 - j10 : ya.g.f56663b;
    }

    public void r(boolean z10) {
        this.f17846k = z10;
    }

    public void s(com.google.android.exoplayer2.trackselection.b bVar) {
        this.f17851p = bVar;
    }

    public boolean t(long j10, gc.e eVar, List<? extends gc.m> list) {
        if (this.f17848m != null) {
            return false;
        }
        return this.f17851p.h(j10, eVar, list);
    }

    public final void u(com.google.android.exoplayer2.source.hls.playlist.c cVar) {
        this.f17852q = cVar.f18036m ? ya.g.f56663b : cVar.e() - this.f17842g.d();
    }
}
