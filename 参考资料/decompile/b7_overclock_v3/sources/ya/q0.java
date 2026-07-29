package ya;

import ad.j;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.l;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import ya.d1;
import ya.l;
import ya.l1;
import ya.o1;
import ya.v0;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class q0 implements Handler.Callback, k.a, j.a, d1.d, l.a, l1.a {
    public static final String G7 = "ExoPlayerImplInternal";
    public static final int H7 = 0;
    public static final int I7 = 1;
    public static final int J7 = 2;
    public static final int K7 = 3;
    public static final int L7 = 4;
    public static final int M7 = 5;
    public static final int N7 = 6;
    public static final int O7 = 7;
    public static final int P7 = 8;
    public static final int Q7 = 9;
    public static final int R7 = 10;
    public static final int S7 = 11;
    public static final int T7 = 12;
    public static final int U7 = 13;
    public static final int V7 = 14;
    public static final int W7 = 15;
    public static final int X7 = 16;
    public static final int Y7 = 17;
    public static final int Z7 = 18;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public static final int f56979a8 = 19;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public static final int f56980b8 = 20;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public static final int f56981c8 = 21;

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public static final int f56982d8 = 22;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public static final int f56983e8 = 23;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public static final int f56984f8 = 24;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public static final int f56985g8 = 25;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public static final int f56986h8 = 10;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public static final int f56987i8 = 1000;

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    public static final long f56988j8 = 2000;
    public boolean A;
    public boolean B;
    public boolean C;
    public int C1;
    public int C2;
    public int D;

    @g.p0
    public ExoPlaybackException E7;
    public long F7;
    public boolean K0;

    @g.p0
    public h K1;
    public boolean K2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o1[] f56989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q1[] f56990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ad.j f56991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ad.k f56992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u0 f56993e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ed.d f56994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final hd.n f56995g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HandlerThread f56996h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Looper f56997i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final x1.c f56998j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final x1.b f56999k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f57000k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public boolean f57001k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f57002l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f57003m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final l f57004n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList<d> f57005o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final hd.c f57006p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final f f57007q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final a1 f57008r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final d1 f57009s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final t0 f57010t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f57011u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public t1 f57012v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public boolean f57013v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public long f57014v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public g1 f57015w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public e f57016x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f57017y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f57018z;

    public class a implements o1.c {
        public a() {
        }

        @Override // ya.o1.c
        public void a() {
            q0.this.f56995g.g(2);
        }

        @Override // ya.o1.c
        public void b(long j10) {
            if (j10 >= 2000) {
                q0.this.f57001k1 = true;
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<d1.c> f57020a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.google.android.exoplayer2.source.t f57021b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f57022c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f57023d;

        public /* synthetic */ b(List list, com.google.android.exoplayer2.source.t tVar, int i10, long j10, a aVar) {
            this(list, tVar, i10, j10);
        }

        public b(List<d1.c> list, com.google.android.exoplayer2.source.t tVar, int i10, long j10) {
            this.f57020a = list;
            this.f57021b = tVar;
            this.f57022c = i10;
            this.f57023d = j10;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f57024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f57025b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f57026c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.google.android.exoplayer2.source.t f57027d;

        public c(int i10, int i11, int i12, com.google.android.exoplayer2.source.t tVar) {
            this.f57024a = i10;
            this.f57025b = i11;
            this.f57026c = i12;
            this.f57027d = tVar;
        }
    }

    public static final class d implements Comparable<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l1 f57028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f57029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f57030c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @g.p0
        public Object f57031d;

        public d(l1 l1Var) {
            this.f57028a = l1Var;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(d dVar) {
            Object obj = this.f57031d;
            if ((obj == null) != (dVar.f57031d == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i10 = this.f57029b - dVar.f57029b;
            return i10 != 0 ? i10 : hd.u0.r(this.f57030c, dVar.f57030c);
        }

        public void d(int i10, long j10, Object obj) {
            this.f57029b = i10;
            this.f57030c = j10;
            this.f57031d = obj;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f57032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g1 f57033b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f57034c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f57035d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f57036e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f57037f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f57038g;

        public e(g1 g1Var) {
            this.f57033b = g1Var;
        }

        public void b(int i10) {
            this.f57032a |= i10 > 0;
            this.f57034c += i10;
        }

        public void c(int i10) {
            this.f57032a = true;
            this.f57037f = true;
            this.f57038g = i10;
        }

        public void d(g1 g1Var) {
            this.f57032a |= this.f57033b != g1Var;
            this.f57033b = g1Var;
        }

        public void e(int i10) {
            if (this.f57035d && this.f57036e != 4) {
                hd.a.a(i10 == 4);
                return;
            }
            this.f57032a = true;
            this.f57035d = true;
            this.f57036e = i10;
        }
    }

    public interface f {
        void a(e eVar);
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l.a f57039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f57040b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f57041c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f57042d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f57043e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f57044f;

        public g(l.a aVar, long j10, long j11, boolean z10, boolean z11, boolean z12) {
            this.f57039a = aVar;
            this.f57040b = j10;
            this.f57041c = j11;
            this.f57042d = z10;
            this.f57043e = z11;
            this.f57044f = z12;
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x1 f57045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f57046b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f57047c;

        public h(x1 x1Var, int i10, long j10) {
            this.f57045a = x1Var;
            this.f57046b = i10;
            this.f57047c = j10;
        }
    }

    public q0(o1[] o1VarArr, ad.j jVar, ad.k kVar, u0 u0Var, ed.d dVar, int i10, boolean z10, @g.p0 za.f1 f1Var, t1 t1Var, t0 t0Var, long j10, boolean z11, Looper looper, hd.c cVar, f fVar) {
        this.f57007q = fVar;
        this.f56989a = o1VarArr;
        this.f56991c = jVar;
        this.f56992d = kVar;
        this.f56993e = u0Var;
        this.f56994f = dVar;
        this.D = i10;
        this.f57000k0 = z10;
        this.f57012v = t1Var;
        this.f57010t = t0Var;
        this.f57011u = j10;
        this.F7 = j10;
        this.f57018z = z11;
        this.f57006p = cVar;
        this.f57002l = u0Var.d();
        this.f57003m = u0Var.c();
        g1 g1VarK = g1.k(kVar);
        this.f57015w = g1VarK;
        this.f57016x = new e(g1VarK);
        this.f56990b = new q1[o1VarArr.length];
        for (int i11 = 0; i11 < o1VarArr.length; i11++) {
            o1VarArr[i11].f(i11);
            this.f56990b[i11] = o1VarArr[i11].m();
        }
        this.f57004n = new l(this, cVar);
        this.f57005o = new ArrayList<>();
        this.f56998j = new x1.c();
        this.f56999k = new x1.b();
        jVar.b(this, dVar);
        this.K2 = true;
        Handler handler = new Handler(looper);
        this.f57008r = new a1(f1Var, handler);
        this.f57009s = new d1(this, f1Var, handler);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.f56996h = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.f56997i = looper2;
        this.f56995g = cVar.c(looper2, this);
    }

    public static Format[] A(com.google.android.exoplayer2.trackselection.b bVar) {
        int length = bVar != null ? bVar.length() : 0;
        Format[] formatArr = new Format[length];
        for (int i10 = 0; i10 < length; i10++) {
            formatArr[i10] = bVar.b(i10);
        }
        return formatArr;
    }

    public static boolean Q(o1 o1Var) {
        return o1Var.getState() != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean S() {
        return Boolean.valueOf(this.f57017y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(l1 l1Var) {
        try {
            p(l1Var);
        } catch (ExoPlaybackException e10) {
            hd.t.e(G7, "Unexpected error delivering message on external thread.", e10);
            throw new RuntimeException(e10);
        }
    }

    public static boolean k1(g1 g1Var, x1.b bVar, x1.c cVar) {
        l.a aVar = g1Var.f56766b;
        x1 x1Var = g1Var.f56765a;
        return aVar.b() || x1Var.r() || x1Var.n(x1Var.h(aVar.f26856a, bVar).f57234c, cVar).f57251l;
    }

    public static void u0(x1 x1Var, d dVar, x1.c cVar, x1.b bVar) {
        int i10 = x1Var.n(x1Var.h(dVar.f57031d, bVar).f57234c, cVar).f57253n;
        Object obj = x1Var.g(i10, bVar, true).f57233b;
        long j10 = bVar.f57235d;
        dVar.d(i10, j10 != ya.g.f56663b ? j10 - 1 : Long.MAX_VALUE, obj);
    }

    public static boolean v0(d dVar, x1 x1Var, x1 x1Var2, int i10, boolean z10, x1.c cVar, x1.b bVar) {
        Object obj = dVar.f57031d;
        if (obj == null) {
            Pair<Object, Long> pairY0 = y0(x1Var, new h(dVar.f57028a.i(), dVar.f57028a.k(), dVar.f57028a.g() == Long.MIN_VALUE ? ya.g.f56663b : ya.g.c(dVar.f57028a.g())), false, i10, z10, cVar, bVar);
            if (pairY0 == null) {
                return false;
            }
            dVar.d(x1Var.b(pairY0.first), ((Long) pairY0.second).longValue(), pairY0.first);
            if (dVar.f57028a.g() == Long.MIN_VALUE) {
                u0(x1Var, dVar, cVar, bVar);
            }
            return true;
        }
        int iB = x1Var.b(obj);
        if (iB == -1) {
            return false;
        }
        if (dVar.f57028a.g() == Long.MIN_VALUE) {
            u0(x1Var, dVar, cVar, bVar);
            return true;
        }
        dVar.f57029b = iB;
        x1Var2.h(dVar.f57031d, bVar);
        if (x1Var2.n(bVar.f57234c, cVar).f57251l) {
            Pair<Object, Long> pairJ = x1Var.j(cVar, bVar, x1Var.h(dVar.f57031d, bVar).f57234c, dVar.f57030c + bVar.n());
            dVar.d(x1Var.b(pairJ.first), ((Long) pairJ.second).longValue(), pairJ.first);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x015e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ya.q0.g x0(ya.x1 r21, ya.g1 r22, @g.p0 ya.q0.h r23, ya.a1 r24, int r25, boolean r26, ya.x1.c r27, ya.x1.b r28) {
        /*
            Method dump skipped, instruction units count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ya.q0.x0(ya.x1, ya.g1, ya.q0$h, ya.a1, int, boolean, ya.x1$c, ya.x1$b):ya.q0$g");
    }

    @g.p0
    public static Pair<Object, Long> y0(x1 x1Var, h hVar, boolean z10, int i10, boolean z11, x1.c cVar, x1.b bVar) {
        Pair<Object, Long> pairJ;
        Object objZ0;
        x1 x1Var2 = hVar.f57045a;
        if (x1Var.r()) {
            return null;
        }
        x1 x1Var3 = x1Var2.r() ? x1Var : x1Var2;
        try {
            pairJ = x1Var3.j(cVar, bVar, hVar.f57046b, hVar.f57047c);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (x1Var.equals(x1Var3)) {
            return pairJ;
        }
        if (x1Var.b(pairJ.first) != -1) {
            x1Var3.h(pairJ.first, bVar);
            return x1Var3.n(bVar.f57234c, cVar).f57251l ? x1Var.j(cVar, bVar, x1Var.h(pairJ.first, bVar).f57234c, hVar.f57047c) : pairJ;
        }
        if (z10 && (objZ0 = z0(cVar, bVar, i10, z11, pairJ.first, x1Var3, x1Var)) != null) {
            return x1Var.j(cVar, bVar, x1Var.h(objZ0, bVar).f57234c, ya.g.f56663b);
        }
        return null;
    }

    @g.p0
    public static Object z0(x1.c cVar, x1.b bVar, int i10, boolean z10, Object obj, x1 x1Var, x1 x1Var2) {
        int iB = x1Var.b(obj);
        int i11 = x1Var.i();
        int iD = iB;
        int iB2 = -1;
        for (int i12 = 0; i12 < i11 && iB2 == -1; i12++) {
            iD = x1Var.d(iD, bVar, cVar, i10, z10);
            if (iD == -1) {
                break;
            }
            iB2 = x1Var2.b(x1Var.m(iD));
        }
        if (iB2 == -1) {
            return null;
        }
        return x1Var2.m(iB2);
    }

    public final void A0(long j10, long j11) {
        this.f56995g.j(2);
        this.f56995g.i(2, j10 + j11);
    }

    public final long B(x1 x1Var, Object obj, long j10) {
        x1Var.n(x1Var.h(obj, this.f56999k).f57234c, this.f56998j);
        x1.c cVar = this.f56998j;
        if (cVar.f57245f != ya.g.f56663b && cVar.h()) {
            x1.c cVar2 = this.f56998j;
            if (cVar2.f57248i) {
                return ya.g.c(cVar2.a() - this.f56998j.f57245f) - (j10 + this.f56999k.n());
            }
        }
        return ya.g.f56663b;
    }

    public void B0(x1 x1Var, int i10, long j10) {
        this.f56995g.k(3, new h(x1Var, i10, j10)).sendToTarget();
    }

    public final long C() {
        x0 x0VarP = this.f57008r.p();
        if (x0VarP == null) {
            return 0L;
        }
        long jL = x0VarP.l();
        if (!x0VarP.f57219d) {
            return jL;
        }
        int i10 = 0;
        while (true) {
            o1[] o1VarArr = this.f56989a;
            if (i10 >= o1VarArr.length) {
                return jL;
            }
            if (Q(o1VarArr[i10]) && this.f56989a[i10].s() == x0VarP.f57218c[i10]) {
                long jU = this.f56989a[i10].u();
                if (jU == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                jL = Math.max(jU, jL);
            }
            i10++;
        }
    }

    public final void C0(boolean z10) throws ExoPlaybackException {
        l.a aVar = this.f57008r.o().f57221f.f57258a;
        long jF0 = F0(aVar, this.f57015w.f56782r, true, false);
        if (jF0 != this.f57015w.f56782r) {
            this.f57015w = N(aVar, jF0, this.f57015w.f56767c);
            if (z10) {
                this.f57016x.e(4);
            }
        }
    }

    public final Pair<l.a, Long> D(x1 x1Var) {
        if (x1Var.r()) {
            return Pair.create(g1.l(), 0L);
        }
        Pair<Object, Long> pairJ = x1Var.j(this.f56998j, this.f56999k, x1Var.a(this.f57000k0), ya.g.f56663b);
        l.a aVarZ = this.f57008r.z(x1Var, pairJ.first, 0L);
        long jLongValue = ((Long) pairJ.second).longValue();
        if (aVarZ.b()) {
            x1Var.h(aVarZ.f26856a, this.f56999k);
            jLongValue = aVarZ.f26858c == this.f56999k.k(aVarZ.f26857b) ? this.f56999k.g() : 0L;
        }
        return Pair.create(aVarZ, Long.valueOf(jLongValue));
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D0(ya.q0.h r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ya.q0.D0(ya.q0$h):void");
    }

    public Looper E() {
        return this.f56997i;
    }

    public final long E0(l.a aVar, long j10, boolean z10) throws ExoPlaybackException {
        return F0(aVar, j10, this.f57008r.o() != this.f57008r.p(), z10);
    }

    public final long F() {
        return G(this.f57015w.f56780p);
    }

    public final long F0(l.a aVar, long j10, boolean z10, boolean z11) throws ExoPlaybackException {
        o1();
        this.B = false;
        if (z11 || this.f57015w.f56768d == 3) {
            e1(2);
        }
        x0 x0VarO = this.f57008r.o();
        x0 x0VarJ = x0VarO;
        while (x0VarJ != null && !aVar.equals(x0VarJ.f57221f.f57258a)) {
            x0VarJ = x0VarJ.j();
        }
        if (z10 || x0VarO != x0VarJ || (x0VarJ != null && x0VarJ.z(j10) < 0)) {
            for (o1 o1Var : this.f56989a) {
                q(o1Var);
            }
            if (x0VarJ != null) {
                while (this.f57008r.o() != x0VarJ) {
                    this.f57008r.b();
                }
                this.f57008r.y(x0VarJ);
                x0VarJ.x(0L);
                t();
            }
        }
        if (x0VarJ != null) {
            this.f57008r.y(x0VarJ);
            if (x0VarJ.f57219d) {
                long j11 = x0VarJ.f57221f.f57262e;
                if (j11 != ya.g.f56663b && j10 >= j11) {
                    j10 = Math.max(0L, j11 - 1);
                }
                if (x0VarJ.f57220e) {
                    long jN = x0VarJ.f57216a.n(j10);
                    x0VarJ.f57216a.u(jN - this.f57002l, this.f57003m);
                    j10 = jN;
                }
            } else {
                x0VarJ.f57221f = x0VarJ.f57221f.b(j10);
            }
            t0(j10);
            U();
        } else {
            this.f57008r.f();
            t0(j10);
        }
        I(false);
        this.f56995g.g(2);
        return j10;
    }

    public final long G(long j10) {
        x0 x0VarJ = this.f57008r.j();
        if (x0VarJ == null) {
            return 0L;
        }
        return Math.max(0L, j10 - x0VarJ.y(this.f57014v2));
    }

    public final void G0(l1 l1Var) throws ExoPlaybackException {
        if (l1Var.g() == ya.g.f56663b) {
            H0(l1Var);
            return;
        }
        if (this.f57015w.f56765a.r()) {
            this.f57005o.add(new d(l1Var));
            return;
        }
        d dVar = new d(l1Var);
        x1 x1Var = this.f57015w.f56765a;
        if (!v0(dVar, x1Var, x1Var, this.D, this.f57000k0, this.f56998j, this.f56999k)) {
            l1Var.m(false);
        } else {
            this.f57005o.add(dVar);
            Collections.sort(this.f57005o);
        }
    }

    public final void H(com.google.android.exoplayer2.source.k kVar) {
        if (this.f57008r.u(kVar)) {
            this.f57008r.x(this.f57014v2);
            U();
        }
    }

    public final void H0(l1 l1Var) throws ExoPlaybackException {
        if (l1Var.e() != this.f56997i) {
            this.f56995g.k(15, l1Var).sendToTarget();
            return;
        }
        p(l1Var);
        int i10 = this.f57015w.f56768d;
        if (i10 == 3 || i10 == 2) {
            this.f56995g.g(2);
        }
    }

    public final void I(boolean z10) {
        x0 x0VarJ = this.f57008r.j();
        l.a aVar = x0VarJ == null ? this.f57015w.f56766b : x0VarJ.f57221f.f57258a;
        boolean z11 = !this.f57015w.f56774j.equals(aVar);
        if (z11) {
            this.f57015w = this.f57015w.b(aVar);
        }
        g1 g1Var = this.f57015w;
        g1Var.f56780p = x0VarJ == null ? g1Var.f56782r : x0VarJ.i();
        this.f57015w.f56781q = F();
        if ((z11 || z10) && x0VarJ != null && x0VarJ.f57219d) {
            r1(x0VarJ.n(), x0VarJ.o());
        }
    }

    public final void I0(final l1 l1Var) {
        Looper looperE = l1Var.e();
        if (looperE.getThread().isAlive()) {
            this.f57006p.c(looperE, null).c(new Runnable() { // from class: ya.p0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f56976a.T(l1Var);
                }
            });
        } else {
            hd.t.n("TAG", "Trying to send message on a dead thread.");
            l1Var.m(false);
        }
    }

    public final void J(x1 x1Var) throws Throwable {
        h hVar;
        g gVarX0 = x0(x1Var, this.f57015w, this.K1, this.f57008r, this.D, this.f57000k0, this.f56998j, this.f56999k);
        l.a aVar = gVarX0.f57039a;
        long j10 = gVarX0.f57041c;
        boolean z10 = gVarX0.f57042d;
        long jE0 = gVarX0.f57040b;
        boolean z11 = (this.f57015w.f56766b.equals(aVar) && jE0 == this.f57015w.f56782r) ? false : true;
        long j11 = ya.g.f56663b;
        try {
            if (gVarX0.f57043e) {
                if (this.f57015w.f56768d != 1) {
                    e1(4);
                }
                r0(false, false, false, true);
            }
            try {
                if (z11) {
                    if (!x1Var.r()) {
                        for (x0 x0VarO = this.f57008r.o(); x0VarO != null; x0VarO = x0VarO.j()) {
                            if (x0VarO.f57221f.f57258a.equals(aVar)) {
                                x0VarO.f57221f = this.f57008r.q(x1Var, x0VarO.f57221f);
                            }
                        }
                        jE0 = E0(aVar, jE0, z10);
                    }
                } else if (!this.f57008r.E(x1Var, this.f57014v2, C())) {
                    C0(false);
                }
                g1 g1Var = this.f57015w;
                x1 x1Var2 = g1Var.f56765a;
                l.a aVar2 = g1Var.f56766b;
                if (gVarX0.f57044f) {
                    j11 = jE0;
                }
                q1(x1Var, aVar, x1Var2, aVar2, j11);
                if (z11 || j10 != this.f57015w.f56767c) {
                    this.f57015w = N(aVar, jE0, j10);
                }
                s0();
                w0(x1Var, this.f57015w.f56765a);
                this.f57015w = this.f57015w.j(x1Var);
                if (!x1Var.r()) {
                    this.K1 = null;
                }
                I(false);
            } catch (Throwable th2) {
                th = th2;
                hVar = null;
                g1 g1Var2 = this.f57015w;
                x1 x1Var3 = g1Var2.f56765a;
                l.a aVar3 = g1Var2.f56766b;
                if (gVarX0.f57044f) {
                    j11 = jE0;
                }
                h hVar2 = hVar;
                q1(x1Var, aVar, x1Var3, aVar3, j11);
                if (z11 || j10 != this.f57015w.f56767c) {
                    this.f57015w = N(aVar, jE0, j10);
                }
                s0();
                w0(x1Var, this.f57015w.f56765a);
                this.f57015w = this.f57015w.j(x1Var);
                if (!x1Var.r()) {
                    this.K1 = hVar2;
                }
                I(false);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            hVar = null;
        }
    }

    public final void J0(long j10) {
        for (o1 o1Var : this.f56989a) {
            if (o1Var.s() != null) {
                K0(o1Var, j10);
            }
        }
    }

    public final void K(com.google.android.exoplayer2.source.k kVar) throws ExoPlaybackException {
        if (this.f57008r.u(kVar)) {
            x0 x0VarJ = this.f57008r.j();
            x0VarJ.p(this.f57004n.e().f56785a, this.f57015w.f56765a);
            r1(x0VarJ.n(), x0VarJ.o());
            if (x0VarJ == this.f57008r.o()) {
                t0(x0VarJ.f57221f.f57259b);
                t();
                g1 g1Var = this.f57015w;
                this.f57015w = N(g1Var.f56766b, x0VarJ.f57221f.f57259b, g1Var.f56767c);
            }
            U();
        }
    }

    public final void K0(o1 o1Var, long j10) {
        o1Var.j();
        if (o1Var instanceof qc.l) {
            ((qc.l) o1Var).X(j10);
        }
    }

    public final void L(h1 h1Var, float f10, boolean z10, boolean z11) throws ExoPlaybackException {
        if (z10) {
            if (z11) {
                this.f57016x.b(1);
            }
            this.f57015w = this.f57015w.g(h1Var);
        }
        u1(h1Var.f56785a);
        for (o1 o1Var : this.f56989a) {
            if (o1Var != null) {
                o1Var.o(f10, h1Var.f56785a);
            }
        }
    }

    public synchronized boolean L0(boolean z10) {
        if (!this.f57017y && this.f56996h.isAlive()) {
            if (z10) {
                this.f56995g.a(13, 1, 0).sendToTarget();
                return true;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.f56995g.h(13, 0, 0, atomicBoolean).sendToTarget();
            v1(new Supplier() { // from class: ya.n0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return Boolean.valueOf(atomicBoolean.get());
                }
            }, this.F7);
            return atomicBoolean.get();
        }
        return true;
    }

    public final void M(h1 h1Var, boolean z10) throws ExoPlaybackException {
        L(h1Var, h1Var.f56785a, true, z10);
    }

    public final void M0(boolean z10, @g.p0 AtomicBoolean atomicBoolean) {
        if (this.K0 != z10) {
            this.K0 = z10;
            if (!z10) {
                for (o1 o1Var : this.f56989a) {
                    if (!Q(o1Var)) {
                        o1Var.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    @g.j
    public final g1 N(l.a aVar, long j10, long j11) {
        List<Metadata> listOf;
        TrackGroupArray trackGroupArray;
        ad.k kVar;
        this.K2 = (!this.K2 && j10 == this.f57015w.f56782r && aVar.equals(this.f57015w.f56766b)) ? false : true;
        s0();
        g1 g1Var = this.f57015w;
        TrackGroupArray trackGroupArray2 = g1Var.f56771g;
        ad.k kVar2 = g1Var.f56772h;
        List<Metadata> list = g1Var.f56773i;
        if (this.f57009s.t()) {
            x0 x0VarO = this.f57008r.o();
            TrackGroupArray trackGroupArrayN = x0VarO == null ? TrackGroupArray.f17501d : x0VarO.n();
            ad.k kVarO = x0VarO == null ? this.f56992d : x0VarO.o();
            ImmutableList<Metadata> immutableListY = y(kVarO.f573c);
            if (x0VarO != null) {
                y0 y0Var = x0VarO.f57221f;
                if (y0Var.f57260c != j11) {
                    x0VarO.f57221f = y0Var.a(j11);
                }
            }
            trackGroupArray = trackGroupArrayN;
            kVar = kVarO;
            listOf = immutableListY;
        } else if (aVar.equals(this.f57015w.f56766b)) {
            listOf = list;
            trackGroupArray = trackGroupArray2;
            kVar = kVar2;
        } else {
            trackGroupArray = TrackGroupArray.f17501d;
            kVar = this.f56992d;
            listOf = ImmutableList.of();
        }
        return this.f57015w.c(aVar, j10, j11, F(), trackGroupArray, kVar, listOf);
    }

    public final void N0(b bVar) throws Throwable {
        this.f57016x.b(1);
        if (bVar.f57022c != -1) {
            this.K1 = new h(new m1(bVar.f57020a, bVar.f57021b), bVar.f57022c, bVar.f57023d);
        }
        J(this.f57009s.E(bVar.f57020a, bVar.f57021b));
    }

    public final boolean O() {
        x0 x0VarP = this.f57008r.p();
        if (!x0VarP.f57219d) {
            return false;
        }
        int i10 = 0;
        while (true) {
            o1[] o1VarArr = this.f56989a;
            if (i10 >= o1VarArr.length) {
                return true;
            }
            o1 o1Var = o1VarArr[i10];
            ec.d0 d0Var = x0VarP.f57218c[i10];
            if (o1Var.s() != d0Var || (d0Var != null && !o1Var.i())) {
                break;
            }
            i10++;
        }
        return false;
    }

    public void O0(List<d1.c> list, int i10, long j10, com.google.android.exoplayer2.source.t tVar) {
        this.f56995g.k(17, new b(list, tVar, i10, j10, null)).sendToTarget();
    }

    public final boolean P() {
        x0 x0VarJ = this.f57008r.j();
        return (x0VarJ == null || x0VarJ.k() == Long.MIN_VALUE) ? false : true;
    }

    public final void P0(boolean z10) {
        if (z10 == this.f57013v1) {
            return;
        }
        this.f57013v1 = z10;
        g1 g1Var = this.f57015w;
        int i10 = g1Var.f56768d;
        if (z10 || i10 == 4 || i10 == 1) {
            this.f57015w = g1Var.d(z10);
        } else {
            this.f56995g.g(2);
        }
    }

    public void Q0(boolean z10) {
        this.f56995g.a(23, z10 ? 1 : 0, 0).sendToTarget();
    }

    public final boolean R() {
        x0 x0VarO = this.f57008r.o();
        long j10 = x0VarO.f57221f.f57262e;
        return x0VarO.f57219d && (j10 == ya.g.f56663b || this.f57015w.f56782r < j10 || !h1());
    }

    public final void R0(boolean z10) throws ExoPlaybackException {
        this.f57018z = z10;
        s0();
        if (!this.A || this.f57008r.p() == this.f57008r.o()) {
            return;
        }
        C0(true);
        I(false);
    }

    public void S0(boolean z10, int i10) {
        this.f56995g.a(1, z10 ? 1 : 0, i10).sendToTarget();
    }

    public final void T0(boolean z10, int i10, boolean z11, int i11) throws ExoPlaybackException {
        this.f57016x.b(z11 ? 1 : 0);
        this.f57016x.c(i11);
        this.f57015w = this.f57015w.e(z10, i10);
        this.B = false;
        g0(z10);
        if (!h1()) {
            o1();
            t1();
            return;
        }
        int i12 = this.f57015w.f56768d;
        if (i12 == 3) {
            l1();
            this.f56995g.g(2);
        } else if (i12 == 2) {
            this.f56995g.g(2);
        }
    }

    public final void U() {
        boolean zG1 = g1();
        this.C = zG1;
        if (zG1) {
            this.f57008r.j().d(this.f57014v2);
        }
        p1();
    }

    public void U0(h1 h1Var) {
        this.f56995g.k(4, h1Var).sendToTarget();
    }

    public final void V() {
        this.f57016x.d(this.f57015w);
        if (this.f57016x.f57032a) {
            this.f57007q.a(this.f57016x);
            this.f57016x = new e(this.f57015w);
        }
    }

    public final void V0(h1 h1Var) throws ExoPlaybackException {
        this.f57004n.c(h1Var);
        M(this.f57004n.e(), true);
    }

    public final boolean W(long j10, long j11) {
        if (this.f57013v1 && this.f57001k1) {
            return false;
        }
        A0(j10, j11);
        return true;
    }

    public void W0(int i10) {
        this.f56995g.a(11, i10, 0).sendToTarget();
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0045, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0074, code lost:
    
        r3 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void X(long r8, long r10) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ya.q0.X(long, long):void");
    }

    public final void X0(int i10) throws ExoPlaybackException {
        this.D = i10;
        if (!this.f57008r.F(this.f57015w.f56765a, i10)) {
            C0(true);
        }
        I(false);
    }

    public final void Y() throws ExoPlaybackException {
        y0 y0VarN;
        this.f57008r.x(this.f57014v2);
        if (this.f57008r.C() && (y0VarN = this.f57008r.n(this.f57014v2, this.f57015w)) != null) {
            x0 x0VarG = this.f57008r.g(this.f56990b, this.f56991c, this.f56993e.h(), this.f57009s, y0VarN, this.f56992d);
            x0VarG.f57216a.q(this, y0VarN.f57259b);
            if (this.f57008r.o() == x0VarG) {
                t0(x0VarG.m());
            }
            I(false);
        }
        if (!this.C) {
            U();
        } else {
            this.C = P();
            p1();
        }
    }

    public void Y0(t1 t1Var) {
        this.f56995g.k(5, t1Var).sendToTarget();
    }

    public final void Z() throws ExoPlaybackException {
        boolean z10 = false;
        while (f1()) {
            if (z10) {
                V();
            }
            x0 x0VarO = this.f57008r.o();
            x0 x0VarB = this.f57008r.b();
            y0 y0Var = x0VarB.f57221f;
            this.f57015w = N(y0Var.f57258a, y0Var.f57259b, y0Var.f57260c);
            this.f57016x.e(x0VarO.f57221f.f57263f ? 0 : 3);
            x1 x1Var = this.f57015w.f56765a;
            q1(x1Var, x0VarB.f57221f.f57258a, x1Var, x0VarO.f57221f.f57258a, ya.g.f56663b);
            s0();
            t1();
            z10 = true;
        }
    }

    public final void Z0(t1 t1Var) {
        this.f57012v = t1Var;
    }

    public final void a0() {
        x0 x0VarP = this.f57008r.p();
        if (x0VarP == null) {
            return;
        }
        int i10 = 0;
        if (x0VarP.j() != null && !this.A) {
            if (O()) {
                if (x0VarP.j().f57219d || this.f57014v2 >= x0VarP.j().m()) {
                    ad.k kVarO = x0VarP.o();
                    x0 x0VarC = this.f57008r.c();
                    ad.k kVarO2 = x0VarC.o();
                    if (x0VarC.f57219d && x0VarC.f57216a.p() != ya.g.f56663b) {
                        J0(x0VarC.m());
                        return;
                    }
                    for (int i11 = 0; i11 < this.f56989a.length; i11++) {
                        boolean zC = kVarO.c(i11);
                        boolean zC2 = kVarO2.c(i11);
                        if (zC && !this.f56989a[i11].w()) {
                            boolean z10 = this.f56990b[i11].h() == 7;
                            r1 r1Var = kVarO.f572b[i11];
                            r1 r1Var2 = kVarO2.f572b[i11];
                            if (!zC2 || !r1Var2.equals(r1Var) || z10) {
                                K0(this.f56989a[i11], x0VarC.m());
                            }
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (!x0VarP.f57221f.f57265h && !this.A) {
            return;
        }
        while (true) {
            o1[] o1VarArr = this.f56989a;
            if (i10 >= o1VarArr.length) {
                return;
            }
            o1 o1Var = o1VarArr[i10];
            ec.d0 d0Var = x0VarP.f57218c[i10];
            if (d0Var != null && o1Var.s() == d0Var && o1Var.i()) {
                long j10 = x0VarP.f57221f.f57262e;
                K0(o1Var, (j10 == ya.g.f56663b || j10 == Long.MIN_VALUE) ? -9223372036854775807L : x0VarP.l() + x0VarP.f57221f.f57262e);
            }
            i10++;
        }
    }

    public void a1(boolean z10) {
        this.f56995g.a(12, z10 ? 1 : 0, 0).sendToTarget();
    }

    @Override // ya.l.a
    public void b(h1 h1Var) {
        this.f56995g.k(16, h1Var).sendToTarget();
    }

    public final void b0() throws ExoPlaybackException {
        x0 x0VarP = this.f57008r.p();
        if (x0VarP == null || this.f57008r.o() == x0VarP || x0VarP.f57222g || !p0()) {
            return;
        }
        t();
    }

    public final void b1(boolean z10) throws ExoPlaybackException {
        this.f57000k0 = z10;
        if (!this.f57008r.G(this.f57015w.f56765a, z10)) {
            C0(true);
        }
        I(false);
    }

    @Override // ya.l1.a
    public synchronized void c(l1 l1Var) {
        if (!this.f57017y && this.f56996h.isAlive()) {
            this.f56995g.k(14, l1Var).sendToTarget();
            return;
        }
        hd.t.n(G7, "Ignoring messages sent after release.");
        l1Var.m(false);
    }

    public final void c0() throws Throwable {
        J(this.f57009s.j());
    }

    public void c1(com.google.android.exoplayer2.source.t tVar) {
        this.f56995g.k(21, tVar).sendToTarget();
    }

    @Override // ad.j.a
    public void d() {
        this.f56995g.g(10);
    }

    public final void d0(c cVar) throws Throwable {
        this.f57016x.b(1);
        J(this.f57009s.x(cVar.f57024a, cVar.f57025b, cVar.f57026c, cVar.f57027d));
    }

    public final void d1(com.google.android.exoplayer2.source.t tVar) throws Throwable {
        this.f57016x.b(1);
        J(this.f57009s.F(tVar));
    }

    @Override // ya.d1.d
    public void e() {
        this.f56995g.g(22);
    }

    public void e0(int i10, int i11, int i12, com.google.android.exoplayer2.source.t tVar) {
        this.f56995g.k(19, new c(i10, i11, i12, tVar)).sendToTarget();
    }

    public final void e1(int i10) {
        g1 g1Var = this.f57015w;
        if (g1Var.f56768d != i10) {
            this.f57015w = g1Var.h(i10);
        }
    }

    public final void f0() {
        for (x0 x0VarO = this.f57008r.o(); x0VarO != null; x0VarO = x0VarO.j()) {
            for (com.google.android.exoplayer2.trackselection.b bVar : x0VarO.o().f573c) {
                if (bVar != null) {
                    bVar.t();
                }
            }
        }
    }

    public final boolean f1() {
        x0 x0VarO;
        x0 x0VarJ;
        return h1() && !this.A && (x0VarO = this.f57008r.o()) != null && (x0VarJ = x0VarO.j()) != null && this.f57014v2 >= x0VarJ.m() && x0VarJ.f57222g;
    }

    public final void g0(boolean z10) {
        for (x0 x0VarO = this.f57008r.o(); x0VarO != null; x0VarO = x0VarO.j()) {
            for (com.google.android.exoplayer2.trackselection.b bVar : x0VarO.o().f573c) {
                if (bVar != null) {
                    bVar.k(z10);
                }
            }
        }
    }

    public final boolean g1() {
        if (!P()) {
            return false;
        }
        x0 x0VarJ = this.f57008r.j();
        return this.f56993e.g(x0VarJ == this.f57008r.o() ? x0VarJ.y(this.f57014v2) : x0VarJ.y(this.f57014v2) - x0VarJ.f57221f.f57259b, G(x0VarJ.k()), this.f57004n.e().f56785a);
    }

    public final void h0() {
        for (x0 x0VarO = this.f57008r.o(); x0VarO != null; x0VarO = x0VarO.j()) {
            for (com.google.android.exoplayer2.trackselection.b bVar : x0VarO.o().f573c) {
                if (bVar != null) {
                    bVar.u();
                }
            }
        }
    }

    public final boolean h1() {
        g1 g1Var = this.f57015w;
        return g1Var.f56775k && g1Var.f56776l == 0;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        x0 x0VarP;
        try {
            switch (message.what) {
                case 0:
                    k0();
                    break;
                case 1:
                    T0(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    r();
                    break;
                case 3:
                    D0((h) message.obj);
                    break;
                case 4:
                    V0((h1) message.obj);
                    break;
                case 5:
                    Z0((t1) message.obj);
                    break;
                case 6:
                    n1(false, true);
                    break;
                case 7:
                    m0();
                    return true;
                case 8:
                    K((com.google.android.exoplayer2.source.k) message.obj);
                    break;
                case 9:
                    H((com.google.android.exoplayer2.source.k) message.obj);
                    break;
                case 10:
                    q0();
                    break;
                case 11:
                    X0(message.arg1);
                    break;
                case 12:
                    b1(message.arg1 != 0);
                    break;
                case 13:
                    M0(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    G0((l1) message.obj);
                    break;
                case 15:
                    I0((l1) message.obj);
                    break;
                case 16:
                    M((h1) message.obj, false);
                    break;
                case 17:
                    N0((b) message.obj);
                    break;
                case 18:
                    m((b) message.obj, message.arg1);
                    break;
                case 19:
                    d0((c) message.obj);
                    break;
                case 20:
                    n0(message.arg1, message.arg2, (com.google.android.exoplayer2.source.t) message.obj);
                    break;
                case 21:
                    d1((com.google.android.exoplayer2.source.t) message.obj);
                    break;
                case 22:
                    c0();
                    break;
                case 23:
                    R0(message.arg1 != 0);
                    break;
                case 24:
                    P0(message.arg1 == 1);
                    break;
                case 25:
                    o((ExoPlaybackException) message.obj);
                    break;
                default:
                    return false;
            }
            V();
        } catch (ExoPlaybackException e10) {
            e = e10;
            if (e.type == 1 && (x0VarP = this.f57008r.p()) != null) {
                e = e.a(x0VarP.f57221f.f57258a);
            }
            if (e.isRecoverable && this.E7 == null) {
                hd.t.o(G7, "Recoverable playback error", e);
                this.E7 = e;
                Message messageK = this.f56995g.k(25, e);
                messageK.getTarget().sendMessageAtFrontOfQueue(messageK);
            } else {
                ExoPlaybackException exoPlaybackException = this.E7;
                if (exoPlaybackException != null) {
                    e.addSuppressed(exoPlaybackException);
                    this.E7 = null;
                }
                hd.t.e(G7, "Playback error", e);
                n1(true, false);
                this.f57015w = this.f57015w.f(e);
            }
            V();
        } catch (IOException e11) {
            ExoPlaybackException exoPlaybackExceptionH = ExoPlaybackException.h(e11);
            x0 x0VarO = this.f57008r.o();
            if (x0VarO != null) {
                exoPlaybackExceptionH = exoPlaybackExceptionH.a(x0VarO.f57221f.f57258a);
            }
            hd.t.e(G7, "Playback error", exoPlaybackExceptionH);
            n1(false, false);
            this.f57015w = this.f57015w.f(exoPlaybackExceptionH);
            V();
        } catch (RuntimeException e12) {
            ExoPlaybackException exoPlaybackExceptionI = ExoPlaybackException.i(e12);
            hd.t.e(G7, "Playback error", exoPlaybackExceptionI);
            n1(true, false);
            this.f57015w = this.f57015w.f(exoPlaybackExceptionI);
            V();
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.source.s.a
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void i(com.google.android.exoplayer2.source.k kVar) {
        this.f56995g.k(9, kVar).sendToTarget();
    }

    public final boolean i1(boolean z10) {
        if (this.C1 == 0) {
            return R();
        }
        if (!z10) {
            return false;
        }
        g1 g1Var = this.f57015w;
        if (!g1Var.f56770f) {
            return true;
        }
        long jC = j1(g1Var.f56765a, this.f57008r.o().f57221f.f57258a) ? this.f57010t.c() : ya.g.f56663b;
        x0 x0VarJ = this.f57008r.j();
        return (x0VarJ.q() && x0VarJ.f57221f.f57265h) || (x0VarJ.f57221f.f57258a.b() && !x0VarJ.f57219d) || this.f56993e.f(F(), this.f57004n.e().f56785a, this.B, jC);
    }

    public void j0() {
        this.f56995g.d(0).sendToTarget();
    }

    public final boolean j1(x1 x1Var, l.a aVar) {
        if (aVar.b() || x1Var.r()) {
            return false;
        }
        x1Var.n(x1Var.h(aVar.f26856a, this.f56999k).f57234c, this.f56998j);
        if (!this.f56998j.h()) {
            return false;
        }
        x1.c cVar = this.f56998j;
        return cVar.f57248i && cVar.f57245f != ya.g.f56663b;
    }

    public final void k0() {
        this.f57016x.b(1);
        r0(false, false, false, true);
        this.f56993e.a();
        e1(this.f57015w.f56765a.r() ? 4 : 2);
        this.f57009s.y(this.f56994f.d());
        this.f56995g.g(2);
    }

    @Override // com.google.android.exoplayer2.source.k.a
    public void l(com.google.android.exoplayer2.source.k kVar) {
        this.f56995g.k(8, kVar).sendToTarget();
    }

    public synchronized boolean l0() {
        if (!this.f57017y && this.f56996h.isAlive()) {
            this.f56995g.g(7);
            v1(new Supplier() { // from class: ya.o0
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return this.f56974a.S();
                }
            }, this.f57011u);
            return this.f57017y;
        }
        return true;
    }

    public final void l1() throws ExoPlaybackException {
        this.B = false;
        this.f57004n.g();
        for (o1 o1Var : this.f56989a) {
            if (Q(o1Var)) {
                o1Var.start();
            }
        }
    }

    public final void m(b bVar, int i10) throws Throwable {
        this.f57016x.b(1);
        d1 d1Var = this.f57009s;
        if (i10 == -1) {
            i10 = d1Var.r();
        }
        J(d1Var.f(i10, bVar.f57020a, bVar.f57021b));
    }

    public final void m0() {
        r0(true, false, true, false);
        this.f56993e.e();
        e1(1);
        this.f56996h.quit();
        synchronized (this) {
            this.f57017y = true;
            notifyAll();
        }
    }

    public void m1() {
        this.f56995g.d(6).sendToTarget();
    }

    public void n(int i10, List<d1.c> list, com.google.android.exoplayer2.source.t tVar) {
        this.f56995g.h(18, i10, 0, new b(list, tVar, -1, ya.g.f56663b, null)).sendToTarget();
    }

    public final void n0(int i10, int i11, com.google.android.exoplayer2.source.t tVar) throws Throwable {
        this.f57016x.b(1);
        J(this.f57009s.C(i10, i11, tVar));
    }

    public final void n1(boolean z10, boolean z11) {
        r0(z10 || !this.K0, false, true, false);
        this.f57016x.b(z11 ? 1 : 0);
        this.f56993e.i();
        e1(1);
    }

    public final void o(ExoPlaybackException exoPlaybackException) throws ExoPlaybackException {
        hd.a.a(exoPlaybackException.isRecoverable && exoPlaybackException.type == 1);
        try {
            C0(true);
        } catch (Exception e10) {
            exoPlaybackException.addSuppressed(e10);
            throw exoPlaybackException;
        }
    }

    public void o0(int i10, int i11, com.google.android.exoplayer2.source.t tVar) {
        this.f56995g.h(20, i10, i11, tVar).sendToTarget();
    }

    public final void o1() throws ExoPlaybackException {
        this.f57004n.h();
        for (o1 o1Var : this.f56989a) {
            if (Q(o1Var)) {
                v(o1Var);
            }
        }
    }

    public final void p(l1 l1Var) throws ExoPlaybackException {
        if (l1Var.l()) {
            return;
        }
        try {
            l1Var.h().r(l1Var.j(), l1Var.f());
        } finally {
            l1Var.m(true);
        }
    }

    public final boolean p0() throws ExoPlaybackException {
        x0 x0VarP = this.f57008r.p();
        ad.k kVarO = x0VarP.o();
        int i10 = 0;
        boolean z10 = false;
        while (true) {
            o1[] o1VarArr = this.f56989a;
            if (i10 >= o1VarArr.length) {
                return !z10;
            }
            o1 o1Var = o1VarArr[i10];
            if (Q(o1Var)) {
                boolean z11 = o1Var.s() != x0VarP.f57218c[i10];
                if (!kVarO.c(i10) || z11) {
                    if (!o1Var.w()) {
                        o1Var.l(A(kVarO.f573c[i10]), x0VarP.f57218c[i10], x0VarP.m(), x0VarP.l());
                    } else if (o1Var.b()) {
                        q(o1Var);
                    } else {
                        z10 = true;
                    }
                }
            }
            i10++;
        }
    }

    public final void p1() {
        x0 x0VarJ = this.f57008r.j();
        boolean z10 = this.C || (x0VarJ != null && x0VarJ.f57216a.isLoading());
        g1 g1Var = this.f57015w;
        if (z10 != g1Var.f56770f) {
            this.f57015w = g1Var.a(z10);
        }
    }

    public final void q(o1 o1Var) throws ExoPlaybackException {
        if (Q(o1Var)) {
            this.f57004n.a(o1Var);
            v(o1Var);
            o1Var.g();
            this.C1--;
        }
    }

    public final void q0() throws ExoPlaybackException {
        float f10 = this.f57004n.e().f56785a;
        x0 x0VarP = this.f57008r.p();
        boolean z10 = true;
        for (x0 x0VarO = this.f57008r.o(); x0VarO != null && x0VarO.f57219d; x0VarO = x0VarO.j()) {
            ad.k kVarV = x0VarO.v(f10, this.f57015w.f56765a);
            int i10 = 0;
            if (!kVarV.a(x0VarO.o())) {
                if (z10) {
                    x0 x0VarO2 = this.f57008r.o();
                    boolean zY = this.f57008r.y(x0VarO2);
                    boolean[] zArr = new boolean[this.f56989a.length];
                    long jB = x0VarO2.b(kVarV, this.f57015w.f56782r, zY, zArr);
                    g1 g1Var = this.f57015w;
                    g1 g1VarN = N(g1Var.f56766b, jB, g1Var.f56767c);
                    this.f57015w = g1VarN;
                    if (g1VarN.f56768d != 4 && jB != g1VarN.f56782r) {
                        this.f57016x.e(4);
                        t0(jB);
                    }
                    boolean[] zArr2 = new boolean[this.f56989a.length];
                    while (true) {
                        o1[] o1VarArr = this.f56989a;
                        if (i10 >= o1VarArr.length) {
                            break;
                        }
                        o1 o1Var = o1VarArr[i10];
                        zArr2[i10] = Q(o1Var);
                        ec.d0 d0Var = x0VarO2.f57218c[i10];
                        if (zArr2[i10]) {
                            if (d0Var != o1Var.s()) {
                                q(o1Var);
                            } else if (zArr[i10]) {
                                o1Var.v(this.f57014v2);
                            }
                        }
                        i10++;
                    }
                    u(zArr2);
                } else {
                    this.f57008r.y(x0VarO);
                    if (x0VarO.f57219d) {
                        x0VarO.a(kVarV, Math.max(x0VarO.f57221f.f57259b, x0VarO.y(this.f57014v2)), false);
                    }
                }
                I(true);
                if (this.f57015w.f56768d != 4) {
                    U();
                    t1();
                    this.f56995g.g(2);
                    return;
                }
                return;
            }
            if (x0VarO == x0VarP) {
                z10 = false;
            }
        }
    }

    public final void q1(x1 x1Var, l.a aVar, x1 x1Var2, l.a aVar2, long j10) {
        if (x1Var.r() || !j1(x1Var, aVar)) {
            float f10 = this.f57004n.e().f56785a;
            h1 h1Var = this.f57015w.f56777m;
            if (f10 != h1Var.f56785a) {
                this.f57004n.c(h1Var);
                return;
            }
            return;
        }
        x1Var.n(x1Var.h(aVar.f26856a, this.f56999k).f57234c, this.f56998j);
        this.f57010t.a((v0.f) hd.u0.k(this.f56998j.f57250k));
        if (j10 != ya.g.f56663b) {
            this.f57010t.e(B(x1Var, aVar.f26856a, j10));
            return;
        }
        if (hd.u0.c(x1Var2.r() ? null : x1Var2.n(x1Var2.h(aVar2.f26856a, this.f56999k).f57234c, this.f56998j).f57240a, this.f56998j.f57240a)) {
            return;
        }
        this.f57010t.e(ya.g.f56663b);
    }

    public final void r() throws ExoPlaybackException, IOException {
        boolean z10;
        boolean z11;
        int i10;
        boolean z12;
        long jB = this.f57006p.b();
        s1();
        int i11 = this.f57015w.f56768d;
        if (i11 == 1 || i11 == 4) {
            this.f56995g.j(2);
            return;
        }
        x0 x0VarO = this.f57008r.o();
        if (x0VarO == null) {
            A0(jB, 10L);
            return;
        }
        hd.q0.a("doSomeWork");
        t1();
        if (x0VarO.f57219d) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            x0VarO.f57216a.u(this.f57015w.f56782r - this.f57002l, this.f57003m);
            int i12 = 0;
            z10 = true;
            z11 = true;
            while (true) {
                o1[] o1VarArr = this.f56989a;
                if (i12 >= o1VarArr.length) {
                    break;
                }
                o1 o1Var = o1VarArr[i12];
                if (Q(o1Var)) {
                    o1Var.q(this.f57014v2, jElapsedRealtime);
                    z10 = z10 && o1Var.b();
                    boolean z13 = x0VarO.f57218c[i12] != o1Var.s();
                    boolean z14 = z13 || (!z13 && o1Var.i()) || o1Var.d() || o1Var.b();
                    z11 = z11 && z14;
                    if (!z14) {
                        o1Var.t();
                    }
                }
                i12++;
            }
        } else {
            x0VarO.f57216a.m();
            z10 = true;
            z11 = true;
        }
        long j10 = x0VarO.f57221f.f57262e;
        boolean z15 = z10 && x0VarO.f57219d && (j10 == ya.g.f56663b || j10 <= this.f57015w.f56782r);
        if (z15 && this.A) {
            this.A = false;
            T0(false, this.f57015w.f56776l, false, 5);
        }
        if (z15 && x0VarO.f57221f.f57265h) {
            e1(4);
            o1();
        } else if (this.f57015w.f56768d == 2 && i1(z11)) {
            e1(3);
            this.E7 = null;
            if (h1()) {
                l1();
            }
        } else if (this.f57015w.f56768d == 3 && (this.C1 != 0 ? !z11 : !R())) {
            this.B = h1();
            e1(2);
            if (this.B) {
                h0();
                this.f57010t.d();
            }
            o1();
        }
        if (this.f57015w.f56768d == 2) {
            int i13 = 0;
            while (true) {
                o1[] o1VarArr2 = this.f56989a;
                if (i13 >= o1VarArr2.length) {
                    break;
                }
                if (Q(o1VarArr2[i13]) && this.f56989a[i13].s() == x0VarO.f57218c[i13]) {
                    this.f56989a[i13].t();
                }
                i13++;
            }
            g1 g1Var = this.f57015w;
            if (!g1Var.f56770f && g1Var.f56781q < 500000 && P()) {
                throw new IllegalStateException("Playback stuck buffering and not loading");
            }
        }
        boolean z16 = this.f57013v1;
        g1 g1Var2 = this.f57015w;
        if (z16 != g1Var2.f56778n) {
            this.f57015w = g1Var2.d(z16);
        }
        if ((h1() && this.f57015w.f56768d == 3) || (i10 = this.f57015w.f56768d) == 2) {
            z12 = !W(jB, 10L);
        } else {
            if (this.C1 == 0 || i10 == 4) {
                this.f56995g.j(2);
            } else {
                A0(jB, 1000L);
            }
            z12 = false;
        }
        g1 g1Var3 = this.f57015w;
        if (g1Var3.f56779o != z12) {
            this.f57015w = g1Var3.i(z12);
        }
        this.f57001k1 = false;
        hd.q0.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r0(boolean r33, boolean r34, boolean r35, boolean r36) {
        /*
            Method dump skipped, instruction units count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ya.q0.r0(boolean, boolean, boolean, boolean):void");
    }

    public final void r1(TrackGroupArray trackGroupArray, ad.k kVar) {
        this.f56993e.b(this.f56989a, trackGroupArray, kVar.f573c);
    }

    public final void s(int i10, boolean z10) throws ExoPlaybackException {
        o1 o1Var = this.f56989a[i10];
        if (Q(o1Var)) {
            return;
        }
        x0 x0VarP = this.f57008r.p();
        boolean z11 = x0VarP == this.f57008r.o();
        ad.k kVarO = x0VarP.o();
        r1 r1Var = kVarO.f572b[i10];
        Format[] formatArrA = A(kVarO.f573c[i10]);
        boolean z12 = h1() && this.f57015w.f56768d == 3;
        boolean z13 = !z10 && z12;
        this.C1++;
        o1Var.k(r1Var, formatArrA, x0VarP.f57218c[i10], this.f57014v2, z13, z11, x0VarP.m(), x0VarP.l());
        o1Var.r(103, new a());
        this.f57004n.b(o1Var);
        if (z12) {
            o1Var.start();
        }
    }

    public final void s0() {
        x0 x0VarO = this.f57008r.o();
        this.A = x0VarO != null && x0VarO.f57221f.f57264g && this.f57018z;
    }

    public final void s1() throws ExoPlaybackException, IOException {
        if (this.f57015w.f56765a.r() || !this.f57009s.t()) {
            return;
        }
        Y();
        a0();
        b0();
        Z();
    }

    public final void t() throws ExoPlaybackException {
        u(new boolean[this.f56989a.length]);
    }

    public final void t0(long j10) throws ExoPlaybackException {
        x0 x0VarO = this.f57008r.o();
        if (x0VarO != null) {
            j10 = x0VarO.z(j10);
        }
        this.f57014v2 = j10;
        this.f57004n.d(j10);
        for (o1 o1Var : this.f56989a) {
            if (Q(o1Var)) {
                o1Var.v(this.f57014v2);
            }
        }
        f0();
    }

    public final void t1() throws ExoPlaybackException {
        x0 x0VarO = this.f57008r.o();
        if (x0VarO == null) {
            return;
        }
        long jP = x0VarO.f57219d ? x0VarO.f57216a.p() : -9223372036854775807L;
        if (jP != ya.g.f56663b) {
            t0(jP);
            if (jP != this.f57015w.f56782r) {
                g1 g1Var = this.f57015w;
                this.f57015w = N(g1Var.f56766b, jP, g1Var.f56767c);
                this.f57016x.e(4);
            }
        } else {
            long jI = this.f57004n.i(x0VarO != this.f57008r.p());
            this.f57014v2 = jI;
            long jY = x0VarO.y(jI);
            X(this.f57015w.f56782r, jY);
            this.f57015w.f56782r = jY;
        }
        this.f57015w.f56780p = this.f57008r.j().i();
        this.f57015w.f56781q = F();
        g1 g1Var2 = this.f57015w;
        if (g1Var2.f56775k && g1Var2.f56768d == 3 && j1(g1Var2.f56765a, g1Var2.f56766b) && this.f57015w.f56777m.f56785a == 1.0f) {
            float fB = this.f57010t.b(z(), F());
            if (this.f57004n.e().f56785a != fB) {
                this.f57004n.c(this.f57015w.f56777m.b(fB));
                L(this.f57015w.f56777m, this.f57004n.e().f56785a, false, false);
            }
        }
    }

    public final void u(boolean[] zArr) throws ExoPlaybackException {
        x0 x0VarP = this.f57008r.p();
        ad.k kVarO = x0VarP.o();
        for (int i10 = 0; i10 < this.f56989a.length; i10++) {
            if (!kVarO.c(i10)) {
                this.f56989a[i10].reset();
            }
        }
        for (int i11 = 0; i11 < this.f56989a.length; i11++) {
            if (kVarO.c(i11)) {
                s(i11, zArr[i11]);
            }
        }
        x0VarP.f57222g = true;
    }

    public final void u1(float f10) {
        for (x0 x0VarO = this.f57008r.o(); x0VarO != null; x0VarO = x0VarO.j()) {
            for (com.google.android.exoplayer2.trackselection.b bVar : x0VarO.o().f573c) {
                if (bVar != null) {
                    bVar.r(f10);
                }
            }
        }
    }

    public final void v(o1 o1Var) throws ExoPlaybackException {
        if (o1Var.getState() == 2) {
            o1Var.stop();
        }
    }

    public final synchronized void v1(Supplier<Boolean> supplier, long j10) {
        long jE = this.f57006p.e() + j10;
        boolean z10 = false;
        while (!supplier.get().booleanValue() && j10 > 0) {
            try {
                wait(j10);
            } catch (InterruptedException unused) {
                z10 = true;
            }
            j10 = jE - this.f57006p.e();
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    public void w(long j10) {
        this.F7 = j10;
    }

    public final void w0(x1 x1Var, x1 x1Var2) {
        if (x1Var.r() && x1Var2.r()) {
            return;
        }
        for (int size = this.f57005o.size() - 1; size >= 0; size--) {
            if (!v0(this.f57005o.get(size), x1Var, x1Var2, this.D, this.f57000k0, this.f56998j, this.f56999k)) {
                this.f57005o.get(size).f57028a.m(false);
                this.f57005o.remove(size);
            }
        }
        Collections.sort(this.f57005o);
    }

    public void x(boolean z10) {
        this.f56995g.a(24, z10 ? 1 : 0, 0).sendToTarget();
    }

    public final ImmutableList<Metadata> y(com.google.android.exoplayer2.trackselection.b[] bVarArr) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        boolean z10 = false;
        for (com.google.android.exoplayer2.trackselection.b bVar : bVarArr) {
            if (bVar != null) {
                Metadata metadata = bVar.b(0).f16696j;
                if (metadata == null) {
                    builder.add(new Metadata(new Metadata.Entry[0]));
                } else {
                    builder.add(metadata);
                    z10 = true;
                }
            }
        }
        return z10 ? builder.build() : ImmutableList.of();
    }

    public final long z() {
        g1 g1Var = this.f57015w;
        return B(g1Var.f56765a, g1Var.f56766b.f26856a, g1Var.f56782r);
    }
}
