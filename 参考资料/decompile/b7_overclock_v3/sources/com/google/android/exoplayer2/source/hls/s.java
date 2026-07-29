package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.f;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.j;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import g.p0;
import hb.a0;
import hb.d0;
import hd.c0;
import hd.u0;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import ya.s0;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements Loader.b<gc.e>, Loader.f, com.google.android.exoplayer2.source.s, hb.m, r.b {
    public static final String O7 = "HlsSampleStreamWrapper";
    public static final int P7 = -1;
    public static final int Q7 = -2;
    public static final int R7 = -3;
    public static final Set<Integer> S7 = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 5)));
    public int A;
    public boolean B;
    public boolean C;
    public Set<TrackGroup> C1;
    public boolean C2;
    public int D;
    public boolean[] E7;
    public long F7;
    public long G7;
    public boolean H7;
    public boolean I7;
    public boolean J7;

    @p0
    public Format K0;
    public int[] K1;
    public boolean[] K2;
    public boolean K7;
    public long L7;

    @p0
    public DrmInitData M7;

    @p0
    public j N7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f18069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f18070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ed.b f18071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public final Format f18072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f18073f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b.a f18074g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.j f18075h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final m.a f18077j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f18078k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public Format f18079k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public boolean f18080k1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList<j> f18082m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<j> f18083n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Runnable f18084o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Runnable f18085p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Handler f18086q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ArrayList<n> f18087r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Map<String, DrmInitData> f18088s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @p0
    public gc.e f18089t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public d[] f18090u;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public TrackGroupArray f18092v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public int f18093v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Set<Integer> f18094w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public SparseIntArray f18095x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public d0 f18096y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f18097z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Loader f18076i = new Loader("Loader:HlsSampleStreamWrapper");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final f.b f18081l = new f.b();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int[] f18091v = new int[0];

    public interface b extends s.a<s> {
        void a();

        void k(Uri uri);
    }

    public static class c implements d0 {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final String f18098j = "EmsgUnwrappingTrackOutput";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final Format f18099k = new Format.b().e0(hd.w.f31193k0).E();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final Format f18100l = new Format.b().e0(hd.w.f31219x0).E();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final wb.a f18101d = new wb.a();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final d0 f18102e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Format f18103f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Format f18104g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public byte[] f18105h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f18106i;

        public c(d0 d0Var, int i10) {
            this.f18102e = d0Var;
            if (i10 == 1) {
                this.f18103f = f18099k;
            } else {
                if (i10 != 3) {
                    throw new IllegalArgumentException("Unknown metadataType: " + i10);
                }
                this.f18103f = f18100l;
            }
            this.f18105h = new byte[0];
            this.f18106i = 0;
        }

        @Override // hb.d0
        public void a(long j10, int i10, int i11, int i12, @p0 d0.a aVar) {
            hd.a.g(this.f18104g);
            c0 c0VarI = i(i11, i12);
            if (!u0.c(this.f18104g.f16699l, this.f18103f.f16699l)) {
                if (!hd.w.f31219x0.equals(this.f18104g.f16699l)) {
                    hd.t.n(f18098j, "Ignoring sample for unsupported format: " + this.f18104g.f16699l);
                    return;
                }
                EventMessage eventMessageC = this.f18101d.c(c0VarI);
                if (!g(eventMessageC)) {
                    hd.t.n(f18098j, String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", this.f18103f.f16699l, eventMessageC.n()));
                    return;
                }
                c0VarI = new c0((byte[]) hd.a.g(eventMessageC.O()));
            }
            int iA = c0VarI.a();
            this.f18102e.d(c0VarI, iA);
            this.f18102e.a(j10, i10, iA, i12, aVar);
        }

        @Override // hb.d0
        public int b(ed.h hVar, int i10, boolean z10, int i11) throws IOException {
            h(this.f18106i + i10);
            int i12 = hVar.read(this.f18105h, this.f18106i, i10);
            if (i12 != -1) {
                this.f18106i += i12;
                return i12;
            }
            if (z10) {
                return -1;
            }
            throw new EOFException();
        }

        @Override // hb.d0
        public void c(c0 c0Var, int i10, int i11) {
            h(this.f18106i + i10);
            c0Var.k(this.f18105h, this.f18106i, i10);
            this.f18106i += i10;
        }

        @Override // hb.d0
        public /* synthetic */ void d(c0 c0Var, int i10) {
            hb.c0.b(this, c0Var, i10);
        }

        @Override // hb.d0
        public /* synthetic */ int e(ed.h hVar, int i10, boolean z10) {
            return hb.c0.a(this, hVar, i10, z10);
        }

        @Override // hb.d0
        public void f(Format format) {
            this.f18104g = format;
            this.f18102e.f(this.f18103f);
        }

        public final boolean g(EventMessage eventMessage) {
            Format formatN = eventMessage.n();
            return formatN != null && u0.c(this.f18103f.f16699l, formatN.f16699l);
        }

        public final void h(int i10) {
            byte[] bArr = this.f18105h;
            if (bArr.length < i10) {
                this.f18105h = Arrays.copyOf(bArr, i10 + (i10 / 2));
            }
        }

        public final c0 i(int i10, int i11) {
            int i12 = this.f18106i - i11;
            c0 c0Var = new c0(Arrays.copyOfRange(this.f18105h, i12 - i10, i12));
            byte[] bArr = this.f18105h;
            System.arraycopy(bArr, i12, bArr, 0, i11);
            this.f18106i = i11;
            return c0Var;
        }
    }

    public static final class d extends r {
        public final Map<String, DrmInitData> O;

        @p0
        public DrmInitData P;

        @Override // com.google.android.exoplayer2.source.r, hb.d0
        public void a(long j10, int i10, int i11, int i12, @p0 d0.a aVar) {
            super.a(j10, i10, i11, i12, aVar);
        }

        @p0
        public final Metadata h0(@p0 Metadata metadata) {
            if (metadata == null) {
                return null;
            }
            int iG = metadata.g();
            int i10 = 0;
            int i11 = 0;
            while (true) {
                if (i11 >= iG) {
                    i11 = -1;
                    break;
                }
                Metadata.Entry entryE = metadata.e(i11);
                if ((entryE instanceof PrivFrame) && j.L.equals(((PrivFrame) entryE).f17316b)) {
                    break;
                }
                i11++;
            }
            if (i11 == -1) {
                return metadata;
            }
            if (iG == 1) {
                return null;
            }
            Metadata.Entry[] entryArr = new Metadata.Entry[iG - 1];
            while (i10 < iG) {
                if (i10 != i11) {
                    entryArr[i10 < i11 ? i10 : i10 - 1] = metadata.e(i10);
                }
                i10++;
            }
            return new Metadata(entryArr);
        }

        public void i0(@p0 DrmInitData drmInitData) {
            this.P = drmInitData;
            I();
        }

        public void j0(j jVar) {
            f0(jVar.f17869k);
        }

        @Override // com.google.android.exoplayer2.source.r
        public Format w(Format format) {
            DrmInitData drmInitData;
            DrmInitData drmInitData2 = this.P;
            if (drmInitData2 == null) {
                drmInitData2 = format.f16702o;
            }
            if (drmInitData2 != null && (drmInitData = this.O.get(drmInitData2.f17033c)) != null) {
                drmInitData2 = drmInitData;
            }
            Metadata metadataH0 = h0(format.f16696j);
            if (drmInitData2 != format.f16702o || metadataH0 != format.f16696j) {
                format = format.a().L(drmInitData2).X(metadataH0).E();
            }
            return super.w(format);
        }

        public d(ed.b bVar, Looper looper, com.google.android.exoplayer2.drm.c cVar, b.a aVar, Map<String, DrmInitData> map) {
            super(bVar, looper, cVar, aVar);
            this.O = map;
        }
    }

    public s(int i10, b bVar, f fVar, Map<String, DrmInitData> map, ed.b bVar2, long j10, @p0 Format format, com.google.android.exoplayer2.drm.c cVar, b.a aVar, com.google.android.exoplayer2.upstream.j jVar, m.a aVar2, int i11) {
        this.f18068a = i10;
        this.f18069b = bVar;
        this.f18070c = fVar;
        this.f18088s = map;
        this.f18071d = bVar2;
        this.f18072e = format;
        this.f18073f = cVar;
        this.f18074g = aVar;
        this.f18075h = jVar;
        this.f18077j = aVar2;
        this.f18078k = i11;
        Set<Integer> set = S7;
        this.f18094w = new HashSet(set.size());
        this.f18095x = new SparseIntArray(set.size());
        this.f18090u = new d[0];
        this.E7 = new boolean[0];
        this.K2 = new boolean[0];
        ArrayList<j> arrayList = new ArrayList<>();
        this.f18082m = arrayList;
        this.f18083n = Collections.unmodifiableList(arrayList);
        this.f18087r = new ArrayList<>();
        this.f18084o = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.q
            @Override // java.lang.Runnable
            public final void run() {
                this.f18067a.T();
            }
        };
        this.f18085p = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f17913a.c0();
            }
        };
        this.f18086q = u0.z();
        this.F7 = j10;
        this.G7 = j10;
    }

    public static hb.j C(int i10, int i11) {
        hd.t.n(O7, "Unmapped track with id " + i10 + " of type " + i11);
        return new hb.j();
    }

    public static Format F(@p0 Format format, Format format2, boolean z10) {
        String strD;
        String strG;
        if (format == null) {
            return format2;
        }
        int iL = hd.w.l(format2.f16699l);
        if (u0.R(format.f16695i, iL) == 1) {
            strD = u0.S(format.f16695i, iL);
            strG = hd.w.g(strD);
        } else {
            strD = hd.w.d(format.f16695i, format2.f16699l);
            strG = format2.f16699l;
        }
        Format.b bVarQ = format2.a().S(format.f16687a).U(format.f16688b).V(format.f16689c).g0(format.f16690d).c0(format.f16691e).G(z10 ? format.f16692f : -1).Z(z10 ? format.f16693g : -1).I(strD).j0(format.f16704q).Q(format.f16705r);
        if (strG != null) {
            bVarQ.e0(strG);
        }
        int i10 = format.f16712y;
        if (i10 != -1) {
            bVarQ.H(i10);
        }
        Metadata metadataB = format.f16696j;
        if (metadataB != null) {
            Metadata metadata = format2.f16696j;
            if (metadata != null) {
                metadataB = metadata.b(metadataB);
            }
            bVarQ.X(metadataB);
        }
        return bVarQ.E();
    }

    public static boolean J(Format format, Format format2) {
        String str = format.f16699l;
        String str2 = format2.f16699l;
        int iL = hd.w.l(str);
        if (iL != 3) {
            return iL == hd.w.l(str2);
        }
        if (u0.c(str, str2)) {
            return !(hd.w.f31195l0.equals(str) || hd.w.f31197m0.equals(str)) || format.D == format2.D;
        }
        return false;
    }

    public static int N(int i10) {
        if (i10 == 1) {
            return 2;
        }
        if (i10 != 2) {
            return i10 != 3 ? 0 : 1;
        }
        return 3;
    }

    public static boolean P(gc.e eVar) {
        return eVar instanceof j;
    }

    public final boolean A(int i10) {
        for (int i11 = i10; i11 < this.f18082m.size(); i11++) {
            if (this.f18082m.get(i11).f17872n) {
                return false;
            }
        }
        j jVar = this.f18082m.get(i10);
        for (int i12 = 0; i12 < this.f18090u.length; i12++) {
            if (this.f18090u[i12].C() > jVar.m(i12)) {
                return false;
            }
        }
        return true;
    }

    public void B() {
        if (this.C) {
            return;
        }
        e(this.F7);
    }

    public final r D(int i10, int i11) {
        int length = this.f18090u.length;
        boolean z10 = true;
        if (i11 != 1 && i11 != 2) {
            z10 = false;
        }
        d dVar = new d(this.f18071d, this.f18086q.getLooper(), this.f18073f, this.f18074g, this.f18088s);
        dVar.b0(this.F7);
        if (z10) {
            dVar.i0(this.M7);
        }
        dVar.a0(this.L7);
        j jVar = this.N7;
        if (jVar != null) {
            dVar.j0(jVar);
        }
        dVar.d0(this);
        int i12 = length + 1;
        int[] iArrCopyOf = Arrays.copyOf(this.f18091v, i12);
        this.f18091v = iArrCopyOf;
        iArrCopyOf[length] = i10;
        this.f18090u = (d[]) u0.T0(this.f18090u, dVar);
        boolean[] zArrCopyOf = Arrays.copyOf(this.E7, i12);
        this.E7 = zArrCopyOf;
        zArrCopyOf[length] = z10;
        this.C2 = zArrCopyOf[length] | this.C2;
        this.f18094w.add(Integer.valueOf(i11));
        this.f18095x.append(i11, length);
        if (N(i11) > N(this.f18097z)) {
            this.A = length;
            this.f18097z = i11;
        }
        this.K2 = Arrays.copyOf(this.K2, i12);
        return dVar;
    }

    public final TrackGroupArray E(TrackGroup[] trackGroupArr) {
        for (int i10 = 0; i10 < trackGroupArr.length; i10++) {
            TrackGroup trackGroup = trackGroupArr[i10];
            Format[] formatArr = new Format[trackGroup.f17498a];
            for (int i11 = 0; i11 < trackGroup.f17498a; i11++) {
                Format formatA = trackGroup.a(i11);
                formatArr[i11] = formatA.g(this.f18073f.b(formatA));
            }
            trackGroupArr[i10] = new TrackGroup(formatArr);
        }
        return new TrackGroupArray(trackGroupArr);
    }

    public final void G(int i10) {
        hd.a.i(!this.f18076i.k());
        while (true) {
            if (i10 >= this.f18082m.size()) {
                i10 = -1;
                break;
            } else if (A(i10)) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 == -1) {
            return;
        }
        long j10 = K().f29170h;
        j jVarH = H(i10);
        if (this.f18082m.isEmpty()) {
            this.G7 = this.F7;
        } else {
            ((j) Iterables.getLast(this.f18082m)).o();
        }
        this.J7 = false;
        this.f18077j.D(this.f18097z, jVarH.f29169g, j10);
    }

    public final j H(int i10) {
        j jVar = this.f18082m.get(i10);
        ArrayList<j> arrayList = this.f18082m;
        u0.f1(arrayList, i10, arrayList.size());
        for (int i11 = 0; i11 < this.f18090u.length; i11++) {
            this.f18090u[i11].u(jVar.m(i11));
        }
        return jVar;
    }

    public final boolean I(j jVar) {
        int i10 = jVar.f17869k;
        int length = this.f18090u.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (this.K2[i11] && this.f18090u[i11].Q() == i10) {
                return false;
            }
        }
        return true;
    }

    public final j K() {
        return this.f18082m.get(r0.size() - 1);
    }

    @p0
    public final d0 L(int i10, int i11) {
        hd.a.a(S7.contains(Integer.valueOf(i11)));
        int i12 = this.f18095x.get(i11, -1);
        if (i12 == -1) {
            return null;
        }
        if (this.f18094w.add(Integer.valueOf(i11))) {
            this.f18091v[i12] = i10;
        }
        return this.f18091v[i12] == i10 ? this.f18090u[i12] : C(i10, i11);
    }

    public int M() {
        return this.f18093v2;
    }

    public final void O(j jVar) {
        this.N7 = jVar;
        this.f18079k0 = jVar.f29166d;
        this.G7 = ya.g.f56663b;
        this.f18082m.add(jVar);
        ImmutableList.Builder builder = ImmutableList.builder();
        for (d dVar : this.f18090u) {
            builder.add(Integer.valueOf(dVar.G()));
        }
        jVar.n(this, builder.build());
        for (d dVar2 : this.f18090u) {
            dVar2.j0(jVar);
            if (jVar.f17872n) {
                dVar2.g0();
            }
        }
    }

    public final boolean Q() {
        return this.G7 != ya.g.f56663b;
    }

    public boolean R(int i10) {
        return !Q() && this.f18090u[i10].K(this.J7);
    }

    @EnsuresNonNull({"trackGroupToSampleQueueIndex"})
    @RequiresNonNull({"trackGroups"})
    public final void S() {
        int i10 = this.f18092v1.f17502a;
        int[] iArr = new int[i10];
        this.K1 = iArr;
        Arrays.fill(iArr, -1);
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = 0;
            while (true) {
                d[] dVarArr = this.f18090u;
                if (i12 >= dVarArr.length) {
                    break;
                }
                if (J((Format) hd.a.k(dVarArr[i12].F()), this.f18092v1.a(i11).a(0))) {
                    this.K1[i11] = i12;
                    break;
                }
                i12++;
            }
        }
        Iterator<n> it2 = this.f18087r.iterator();
        while (it2.hasNext()) {
            it2.next().b();
        }
    }

    public final void T() {
        if (!this.f18080k1 && this.K1 == null && this.B) {
            for (d dVar : this.f18090u) {
                if (dVar.F() == null) {
                    return;
                }
            }
            if (this.f18092v1 != null) {
                S();
                return;
            }
            z();
            l0();
            this.f18069b.a();
        }
    }

    public void U() throws IOException {
        this.f18076i.a();
        this.f18070c.m();
    }

    public void V(int i10) throws IOException {
        U();
        this.f18090u[i10].M();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public void i(gc.e eVar, long j10, long j11, boolean z10) {
        this.f18089t = null;
        ec.j jVar = new ec.j(eVar.f29163a, eVar.f29164b, eVar.f(), eVar.e(), j10, j11, eVar.a());
        this.f18075h.d(eVar.f29163a);
        this.f18077j.r(jVar, eVar.f29165c, this.f18068a, eVar.f29166d, eVar.f29167e, eVar.f29168f, eVar.f29169g, eVar.f29170h);
        if (z10) {
            return;
        }
        if (Q() || this.D == 0) {
            g0();
        }
        if (this.D > 0) {
            this.f18069b.i(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public void l(gc.e eVar, long j10, long j11) {
        this.f18089t = null;
        this.f18070c.n(eVar);
        ec.j jVar = new ec.j(eVar.f29163a, eVar.f29164b, eVar.f(), eVar.e(), j10, j11, eVar.a());
        this.f18075h.d(eVar.f29163a);
        this.f18077j.u(jVar, eVar.f29165c, this.f18068a, eVar.f29166d, eVar.f29167e, eVar.f29168f, eVar.f29169g, eVar.f29170h);
        if (this.C) {
            this.f18069b.i(this);
        } else {
            e(this.F7);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public Loader.c t(gc.e eVar, long j10, long j11, IOException iOException, int i10) {
        Loader.c cVarI;
        int i11;
        boolean zP = P(eVar);
        if (zP && !((j) eVar).q() && (iOException instanceof HttpDataSource.InvalidResponseCodeException) && ((i11 = ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode) == 410 || i11 == 404)) {
            return Loader.f19039h;
        }
        long jA = eVar.a();
        ec.j jVar = new ec.j(eVar.f29163a, eVar.f29164b, eVar.f(), eVar.e(), j10, j11, jA);
        j.a aVar = new j.a(jVar, new ec.k(eVar.f29165c, this.f18068a, eVar.f29166d, eVar.f29167e, eVar.f29168f, ya.g.d(eVar.f29169g), ya.g.d(eVar.f29170h)), iOException, i10);
        long jE = this.f18075h.e(aVar);
        boolean zL = jE != ya.g.f56663b ? this.f18070c.l(eVar, jE) : false;
        if (zL) {
            if (zP && jA == 0) {
                ArrayList<j> arrayList = this.f18082m;
                hd.a.i(arrayList.remove(arrayList.size() - 1) == eVar);
                if (this.f18082m.isEmpty()) {
                    this.G7 = this.F7;
                } else {
                    ((j) Iterables.getLast(this.f18082m)).o();
                }
            }
            cVarI = Loader.f19041j;
        } else {
            long jA2 = this.f18075h.a(aVar);
            cVarI = jA2 != ya.g.f56663b ? Loader.i(false, jA2) : Loader.f19042k;
        }
        Loader.c cVar = cVarI;
        boolean z10 = !cVar.c();
        this.f18077j.w(jVar, eVar.f29165c, this.f18068a, eVar.f29166d, eVar.f29167e, eVar.f29168f, eVar.f29169g, eVar.f29170h, iOException, z10);
        if (z10) {
            this.f18089t = null;
            this.f18075h.d(eVar.f29163a);
        }
        if (zL) {
            if (this.C) {
                this.f18069b.i(this);
            } else {
                e(this.F7);
            }
        }
        return cVar;
    }

    public void Z() {
        this.f18094w.clear();
    }

    @Override // com.google.android.exoplayer2.source.r.b
    public void a(Format format) {
        this.f18086q.post(this.f18084o);
    }

    public boolean a0(Uri uri, long j10) {
        return this.f18070c.o(uri, j10);
    }

    @Override // com.google.android.exoplayer2.source.s
    public long b() {
        if (Q()) {
            return this.G7;
        }
        if (this.J7) {
            return Long.MIN_VALUE;
        }
        return K().f29170h;
    }

    public void b0() {
        if (this.f18082m.isEmpty()) {
            return;
        }
        j jVar = (j) Iterables.getLast(this.f18082m);
        int iB = this.f18070c.b(jVar);
        if (iB == 1) {
            jVar.v();
        } else if (iB == 2 && !this.J7 && this.f18076i.k()) {
            this.f18076i.g();
        }
    }

    public final void c0() {
        this.B = true;
        T();
    }

    @Override // hb.m
    public d0 d(int i10, int i11) {
        d0 d0VarD;
        if (!S7.contains(Integer.valueOf(i11))) {
            int i12 = 0;
            while (true) {
                d0[] d0VarArr = this.f18090u;
                if (i12 >= d0VarArr.length) {
                    d0VarD = null;
                    break;
                }
                if (this.f18091v[i12] == i10) {
                    d0VarD = d0VarArr[i12];
                    break;
                }
                i12++;
            }
        } else {
            d0VarD = L(i10, i11);
        }
        if (d0VarD == null) {
            if (this.K7) {
                return C(i10, i11);
            }
            d0VarD = D(i10, i11);
        }
        if (i11 != 5) {
            return d0VarD;
        }
        if (this.f18096y == null) {
            this.f18096y = new c(d0VarD, this.f18078k);
        }
        return this.f18096y;
    }

    public void d0(TrackGroup[] trackGroupArr, int i10, int... iArr) {
        this.f18092v1 = E(trackGroupArr);
        this.C1 = new HashSet();
        for (int i11 : iArr) {
            this.C1.add(this.f18092v1.a(i11));
        }
        this.f18093v2 = i10;
        Handler handler = this.f18086q;
        final b bVar = this.f18069b;
        Objects.requireNonNull(bVar);
        handler.post(new Runnable() { // from class: com.google.android.exoplayer2.source.hls.o
            @Override // java.lang.Runnable
            public final void run() {
                bVar.a();
            }
        });
        l0();
    }

    @Override // com.google.android.exoplayer2.source.s
    public boolean e(long j10) {
        List<j> listEmptyList;
        long jMax;
        if (this.J7 || this.f18076i.k() || this.f18076i.j()) {
            return false;
        }
        if (Q()) {
            listEmptyList = Collections.emptyList();
            jMax = this.G7;
            for (d dVar : this.f18090u) {
                dVar.b0(this.G7);
            }
        } else {
            listEmptyList = this.f18083n;
            j jVarK = K();
            jMax = jVarK.h() ? jVarK.f29170h : Math.max(this.F7, jVarK.f29169g);
        }
        List<j> list = listEmptyList;
        this.f18070c.d(j10, jMax, list, this.C || !list.isEmpty(), this.f18081l);
        f.b bVar = this.f18081l;
        boolean z10 = bVar.f17856b;
        gc.e eVar = bVar.f17855a;
        Uri uri = bVar.f17857c;
        bVar.a();
        if (z10) {
            this.G7 = ya.g.f56663b;
            this.J7 = true;
            return true;
        }
        if (eVar == null) {
            if (uri != null) {
                this.f18069b.k(uri);
            }
            return false;
        }
        if (P(eVar)) {
            O((j) eVar);
        }
        this.f18089t = eVar;
        this.f18077j.A(new ec.j(eVar.f29163a, eVar.f29164b, this.f18076i.n(eVar, this, this.f18075h.f(eVar.f29165c))), eVar.f29165c, this.f18068a, eVar.f29166d, eVar.f29167e, eVar.f29168f, eVar.f29169g, eVar.f29170h);
        return true;
    }

    public int e0(int i10, s0 s0Var, DecoderInputBuffer decoderInputBuffer, boolean z10) {
        if (Q()) {
            return -3;
        }
        int i11 = 0;
        if (!this.f18082m.isEmpty()) {
            int i12 = 0;
            while (i12 < this.f18082m.size() - 1 && I(this.f18082m.get(i12))) {
                i12++;
            }
            u0.f1(this.f18082m, 0, i12);
            j jVar = this.f18082m.get(0);
            Format format = jVar.f29166d;
            if (!format.equals(this.K0)) {
                this.f18077j.i(this.f18068a, format, jVar.f29167e, jVar.f29168f, jVar.f29169g);
            }
            this.K0 = format;
        }
        if (!this.f18082m.isEmpty() && !this.f18082m.get(0).q()) {
            return -3;
        }
        int iS = this.f18090u[i10].S(s0Var, decoderInputBuffer, z10, this.J7);
        if (iS == -5) {
            Format formatM0 = (Format) hd.a.g(s0Var.f57068b);
            if (i10 == this.A) {
                int iQ = this.f18090u[i10].Q();
                while (i11 < this.f18082m.size() && this.f18082m.get(i11).f17869k != iQ) {
                    i11++;
                }
                formatM0 = formatM0.m0(i11 < this.f18082m.size() ? this.f18082m.get(i11).f29166d : (Format) hd.a.g(this.f18079k0));
            }
            s0Var.f57068b = formatM0;
        }
        return iS;
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:506)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:509)
        */
    @Override // com.google.android.exoplayer2.source.s
    public long f() {
        /*
            r7 = this;
            boolean r0 = r7.J7
            if (r0 == 0) goto L7
            r0 = -9223372036854775808
            return r0
        L7:
            boolean r0 = r7.Q()
            if (r0 == 0) goto L10
            long r0 = r7.G7
            return r0
        L10:
            long r0 = r7.F7
            com.google.android.exoplayer2.source.hls.j r2 = r7.K()
            boolean r3 = r2.h()
            if (r3 == 0) goto L1d
            goto L36
        L1d:
            java.util.ArrayList<com.google.android.exoplayer2.source.hls.j> r2 = r7.f18082m
            int r2 = r2.size()
            r3 = 1
            if (r2 <= r3) goto L35
            java.util.ArrayList<com.google.android.exoplayer2.source.hls.j> r2 = r7.f18082m
            int r3 = r2.size()
            int r3 = r3 + (-2)
            java.lang.Object r2 = r2.get(r3)
            com.google.android.exoplayer2.source.hls.j r2 = (com.google.android.exoplayer2.source.hls.j) r2
            goto L36
        L35:
            r2 = 0
        L36:
            if (r2 == 0) goto L3e
            long r2 = r2.f29170h
            long r0 = java.lang.Math.max(r0, r2)
        L3e:
            boolean r2 = r7.B
            if (r2 == 0) goto L55
            com.google.android.exoplayer2.source.hls.s$d[] r2 = r7.f18090u
            int r3 = r2.length
            r4 = 0
        L46:
            if (r4 >= r3) goto L55
            r5 = r2[r4]
            long r5 = r5.z()
            long r0 = java.lang.Math.max(r0, r5)
            int r4 = r4 + 1
            goto L46
        L55:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.s.f():long");
    }

    public void f0() {
        if (this.C) {
            for (d dVar : this.f18090u) {
                dVar.R();
            }
        }
        this.f18076i.m(this);
        this.f18086q.removeCallbacksAndMessages(null);
        this.f18080k1 = true;
        this.f18087r.clear();
    }

    @Override // com.google.android.exoplayer2.source.s
    public void g(long j10) {
        if (this.f18076i.j() || Q()) {
            return;
        }
        if (this.f18076i.k()) {
            hd.a.g(this.f18089t);
            if (this.f18070c.t(j10, this.f18089t, this.f18083n)) {
                this.f18076i.g();
                return;
            }
            return;
        }
        int size = this.f18083n.size();
        while (size > 0 && this.f18070c.b(this.f18083n.get(size - 1)) == 2) {
            size--;
        }
        if (size < this.f18083n.size()) {
            G(size);
        }
        int iG = this.f18070c.g(j10, this.f18083n);
        if (iG < this.f18082m.size()) {
            G(iG);
        }
    }

    public final void g0() {
        for (d dVar : this.f18090u) {
            dVar.W(this.H7);
        }
        this.H7 = false;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.f
    public void h() {
        for (d dVar : this.f18090u) {
            dVar.T();
        }
    }

    public final boolean h0(long j10) {
        int length = this.f18090u.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (!this.f18090u[i10].Z(j10, false) && (this.E7[i10] || !this.C2)) {
                return false;
            }
        }
        return true;
    }

    public boolean i0(long j10, boolean z10) {
        this.F7 = j10;
        if (Q()) {
            this.G7 = j10;
            return true;
        }
        if (this.B && !z10 && h0(j10)) {
            return false;
        }
        this.G7 = j10;
        this.J7 = false;
        this.f18082m.clear();
        if (this.f18076i.k()) {
            if (this.B) {
                for (d dVar : this.f18090u) {
                    dVar.q();
                }
            }
            this.f18076i.g();
        } else {
            this.f18076i.h();
            g0();
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.source.s
    public boolean isLoading() {
        return this.f18076i.k();
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean j0(com.google.android.exoplayer2.trackselection.b[] r20, boolean[] r21, ec.d0[] r22, boolean[] r23, long r24, boolean r26) {
        /*
            Method dump skipped, instruction units count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.s.j0(com.google.android.exoplayer2.trackselection.b[], boolean[], ec.d0[], boolean[], long, boolean):boolean");
    }

    @Override // hb.m
    public void k() {
        this.K7 = true;
        this.f18086q.post(this.f18085p);
    }

    public void k0(@p0 DrmInitData drmInitData) {
        if (u0.c(this.M7, drmInitData)) {
            return;
        }
        this.M7 = drmInitData;
        int i10 = 0;
        while (true) {
            d[] dVarArr = this.f18090u;
            if (i10 >= dVarArr.length) {
                return;
            }
            if (this.E7[i10]) {
                dVarArr[i10].i0(drmInitData);
            }
            i10++;
        }
    }

    @RequiresNonNull({"trackGroups", "optionalTrackGroups"})
    public final void l0() {
        this.C = true;
    }

    public void m() throws IOException {
        U();
        if (this.J7 && !this.C) {
            throw new ParserException("Loading finished before preparation is complete.");
        }
    }

    public void m0(boolean z10) {
        this.f18070c.r(z10);
    }

    public void n0(long j10) {
        if (this.L7 != j10) {
            this.L7 = j10;
            for (d dVar : this.f18090u) {
                dVar.a0(j10);
            }
        }
    }

    @Override // hb.m
    public void o(a0 a0Var) {
    }

    public int o0(int i10, long j10) {
        int i11 = 0;
        if (Q()) {
            return 0;
        }
        d dVar = this.f18090u[i10];
        int iE = dVar.E(j10, this.J7);
        int iC = dVar.C();
        while (true) {
            if (i11 >= this.f18082m.size()) {
                break;
            }
            j jVar = this.f18082m.get(i11);
            int iM = this.f18082m.get(i11).m(i10);
            if (iC + iE <= iM) {
                break;
            }
            if (!jVar.q()) {
                iE = iM - iC;
                break;
            }
            i11++;
        }
        dVar.e0(iE);
        return iE;
    }

    public void p0(int i10) {
        x();
        hd.a.g(this.K1);
        int i11 = this.K1[i10];
        hd.a.i(this.K2[i11]);
        this.K2[i11] = false;
    }

    public final void q0(ec.d0[] d0VarArr) {
        this.f18087r.clear();
        for (ec.d0 d0Var : d0VarArr) {
            if (d0Var != null) {
                this.f18087r.add((n) d0Var);
            }
        }
    }

    public TrackGroupArray r() {
        x();
        return this.f18092v1;
    }

    public void u(long j10, boolean z10) {
        if (!this.B || Q()) {
            return;
        }
        int length = this.f18090u.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f18090u[i10].p(j10, z10, this.K2[i10]);
        }
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups"})
    public final void x() {
        hd.a.i(this.C);
        hd.a.g(this.f18092v1);
        hd.a.g(this.C1);
    }

    public int y(int i10) {
        x();
        hd.a.g(this.K1);
        int i11 = this.K1[i10];
        if (i11 == -1) {
            return this.C1.contains(this.f18092v1.a(i10)) ? -3 : -2;
        }
        boolean[] zArr = this.K2;
        if (zArr[i11]) {
            return -2;
        }
        zArr[i11] = true;
        return i11;
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups", "trackGroupToSampleQueueIndex"})
    public final void z() {
        int length = this.f18090u.length;
        int i10 = 0;
        int i11 = 7;
        int i12 = -1;
        while (true) {
            if (i10 >= length) {
                break;
            }
            String str = ((Format) hd.a.k(this.f18090u[i10].F())).f16699l;
            int i13 = hd.w.s(str) ? 2 : hd.w.p(str) ? 1 : hd.w.r(str) ? 3 : 7;
            if (N(i13) > N(i11)) {
                i12 = i10;
                i11 = i13;
            } else if (i13 == i11 && i12 != -1) {
                i12 = -1;
            }
            i10++;
        }
        TrackGroup trackGroupI = this.f18070c.i();
        int i14 = trackGroupI.f17498a;
        this.f18093v2 = -1;
        this.K1 = new int[length];
        for (int i15 = 0; i15 < length; i15++) {
            this.K1[i15] = i15;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        for (int i16 = 0; i16 < length; i16++) {
            Format format = (Format) hd.a.k(this.f18090u[i16].F());
            if (i16 == i12) {
                Format[] formatArr = new Format[i14];
                if (i14 == 1) {
                    formatArr[0] = format.m0(trackGroupI.a(0));
                } else {
                    for (int i17 = 0; i17 < i14; i17++) {
                        formatArr[i17] = F(trackGroupI.a(i17), format, true);
                    }
                }
                trackGroupArr[i16] = new TrackGroup(formatArr);
                this.f18093v2 = i16;
            } else {
                trackGroupArr[i16] = new TrackGroup(F((i11 == 2 && hd.w.p(format.f16699l)) ? this.f18072e : null, format, false));
            }
        }
        this.f18092v1 = E(trackGroupArr);
        hd.a.i(this.C1 == null);
        this.C1 = Collections.emptySet();
    }
}
