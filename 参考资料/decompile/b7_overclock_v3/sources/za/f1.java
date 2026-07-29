package za;

import android.os.Looper;
import android.util.SparseArray;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.l;
import com.google.common.base.Objects;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import ed.d;
import hd.s;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import ya.j1;
import ya.x1;
import za.h1;

/* JADX INFO: loaded from: classes3.dex */
public class f1 implements j1.f, com.google.android.exoplayer2.audio.a, id.z, com.google.android.exoplayer2.source.m, d.a, com.google.android.exoplayer2.drm.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hd.c f58051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x1.b f58052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x1.c f58053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f58054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SparseArray<h1.b> f58055e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public hd.s<h1, h1.c> f58056f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ya.j1 f58057g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f58058h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x1.b f58059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ImmutableList<l.a> f58060b = ImmutableList.of();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ImmutableMap<l.a, x1> f58061c = ImmutableMap.of();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @g.p0
        public l.a f58062d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public l.a f58063e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public l.a f58064f;

        public a(x1.b bVar) {
            this.f58059a = bVar;
        }

        @g.p0
        public static l.a c(ya.j1 j1Var, ImmutableList<l.a> immutableList, @g.p0 l.a aVar, x1.b bVar) {
            x1 x1VarN1 = j1Var.n1();
            int iU = j1Var.U();
            Object objM = x1VarN1.r() ? null : x1VarN1.m(iU);
            int iD = (j1Var.r() || x1VarN1.r()) ? -1 : x1VarN1.f(iU, bVar).d(ya.g.c(j1Var.H1()) - bVar.n());
            for (int i10 = 0; i10 < immutableList.size(); i10++) {
                l.a aVar2 = immutableList.get(i10);
                if (i(aVar2, objM, j1Var.r(), j1Var.T0(), j1Var.f0(), iD)) {
                    return aVar2;
                }
            }
            if (immutableList.isEmpty() && aVar != null) {
                if (i(aVar, objM, j1Var.r(), j1Var.T0(), j1Var.f0(), iD)) {
                    return aVar;
                }
            }
            return null;
        }

        public static boolean i(l.a aVar, @g.p0 Object obj, boolean z10, int i10, int i11, int i12) {
            if (aVar.f26856a.equals(obj)) {
                return (z10 && aVar.f26857b == i10 && aVar.f26858c == i11) || (!z10 && aVar.f26857b == -1 && aVar.f26860e == i12);
            }
            return false;
        }

        public final void b(ImmutableMap.Builder<l.a, x1> builder, @g.p0 l.a aVar, x1 x1Var) {
            if (aVar == null) {
                return;
            }
            if (x1Var.b(aVar.f26856a) != -1) {
                builder.put(aVar, x1Var);
                return;
            }
            x1 x1Var2 = this.f58061c.get(aVar);
            if (x1Var2 != null) {
                builder.put(aVar, x1Var2);
            }
        }

        @g.p0
        public l.a d() {
            return this.f58062d;
        }

        @g.p0
        public l.a e() {
            if (this.f58060b.isEmpty()) {
                return null;
            }
            return (l.a) Iterables.getLast(this.f58060b);
        }

        @g.p0
        public x1 f(l.a aVar) {
            return this.f58061c.get(aVar);
        }

        @g.p0
        public l.a g() {
            return this.f58063e;
        }

        @g.p0
        public l.a h() {
            return this.f58064f;
        }

        public void j(ya.j1 j1Var) {
            this.f58062d = c(j1Var, this.f58060b, this.f58063e, this.f58059a);
        }

        public void k(List<l.a> list, @g.p0 l.a aVar, ya.j1 j1Var) {
            this.f58060b = ImmutableList.copyOf((Collection) list);
            if (!list.isEmpty()) {
                this.f58063e = list.get(0);
                this.f58064f = (l.a) hd.a.g(aVar);
            }
            if (this.f58062d == null) {
                this.f58062d = c(j1Var, this.f58060b, this.f58063e, this.f58059a);
            }
            m(j1Var.n1());
        }

        public void l(ya.j1 j1Var) {
            this.f58062d = c(j1Var, this.f58060b, this.f58063e, this.f58059a);
            m(j1Var.n1());
        }

        public final void m(x1 x1Var) {
            ImmutableMap.Builder<l.a, x1> builder = ImmutableMap.builder();
            if (this.f58060b.isEmpty()) {
                b(builder, this.f58063e, x1Var);
                if (!Objects.equal(this.f58064f, this.f58063e)) {
                    b(builder, this.f58064f, x1Var);
                }
                if (!Objects.equal(this.f58062d, this.f58063e) && !Objects.equal(this.f58062d, this.f58064f)) {
                    b(builder, this.f58062d, x1Var);
                }
            } else {
                for (int i10 = 0; i10 < this.f58060b.size(); i10++) {
                    b(builder, this.f58060b.get(i10), x1Var);
                }
                if (!this.f58060b.contains(this.f58062d)) {
                    b(builder, this.f58062d, x1Var);
                }
            }
            this.f58061c = builder.build();
        }
    }

    public f1(hd.c cVar) {
        this.f58051a = (hd.c) hd.a.g(cVar);
        this.f58056f = new hd.s<>(hd.u0.X(), cVar, new Supplier() { // from class: za.a
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return new h1.c();
            }
        }, new s.b() { // from class: za.z0
            @Override // hd.s.b
            public final void a(Object obj, hd.x xVar) {
                f1.o1((h1) obj, (h1.c) xVar);
            }
        });
        x1.b bVar = new x1.b();
        this.f58052b = bVar;
        this.f58053c = new x1.c();
        this.f58054d = new a(bVar);
        this.f58055e = new SparseArray<>();
    }

    public static /* synthetic */ void i2(h1.b bVar, String str, long j10, h1 h1Var) {
        h1Var.F(bVar, str, j10);
        h1Var.I(bVar, 2, str, j10);
    }

    public static /* synthetic */ void k2(h1.b bVar, eb.d dVar, h1 h1Var) {
        h1Var.Y(bVar, dVar);
        h1Var.G(bVar, 2, dVar);
    }

    public static /* synthetic */ void l2(h1.b bVar, eb.d dVar, h1 h1Var) {
        h1Var.f0(bVar, dVar);
        h1Var.P(bVar, 2, dVar);
    }

    public static /* synthetic */ void n2(h1.b bVar, Format format, eb.e eVar, h1 h1Var) {
        h1Var.j0(bVar, format, eVar);
        h1Var.R(bVar, 2, format);
    }

    public static /* synthetic */ void o1(h1 h1Var, h1.c cVar) {
    }

    public static /* synthetic */ void r1(h1.b bVar, String str, long j10, h1 h1Var) {
        h1Var.y(bVar, str, j10);
        h1Var.I(bVar, 1, str, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r2(ya.j1 j1Var, h1 h1Var, h1.c cVar) {
        cVar.h(this.f58055e);
        h1Var.i0(j1Var, cVar);
    }

    public static /* synthetic */ void t1(h1.b bVar, eb.d dVar, h1 h1Var) {
        h1Var.L(bVar, dVar);
        h1Var.G(bVar, 1, dVar);
    }

    public static /* synthetic */ void u1(h1.b bVar, eb.d dVar, h1 h1Var) {
        h1Var.O(bVar, dVar);
        h1Var.P(bVar, 1, dVar);
    }

    public static /* synthetic */ void v1(h1.b bVar, Format format, eb.e eVar, h1 h1Var) {
        h1Var.l0(bVar, format, eVar);
        h1Var.R(bVar, 1, format);
    }

    @Override // com.google.android.exoplayer2.audio.a
    public final void A(final eb.d dVar) {
        final h1.b bVarN1 = n1();
        B2(bVarN1, 1008, new s.a() { // from class: za.y
            @Override // hd.s.a
            public final void i(Object obj) {
                f1.u1(bVarN1, dVar, (h1) obj);
            }
        });
    }

    public final void A2() {
    }

    @Override // ya.j1.f
    public /* synthetic */ void B(boolean z10) {
        ya.k1.c(this, z10);
    }

    public final void B2(h1.b bVar, int i10, s.a<h1> aVar) {
        this.f58055e.put(i10, bVar);
        this.f58056f.l(i10, aVar);
    }

    @Override // com.google.android.exoplayer2.drm.b
    public final void C(int i10, @g.p0 l.a aVar) {
        final h1.b bVarL1 = l1(i10, aVar);
        B2(bVarL1, h1.W, new s.a() { // from class: za.a1
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).h0(bVarL1);
            }
        });
    }

    @g.i
    public void C2(final ya.j1 j1Var, Looper looper) {
        hd.a.i(this.f58057g == null || this.f58054d.f58060b.isEmpty());
        this.f58057g = (ya.j1) hd.a.g(j1Var);
        this.f58056f = this.f58056f.d(looper, new s.b() { // from class: za.y0
            @Override // hd.s.b
            public final void a(Object obj, hd.x xVar) {
                this.f58289a.r2(j1Var, (h1) obj, (h1.c) xVar);
            }
        });
    }

    @Override // ya.j1.f
    public final void D(final boolean z10, final int i10) {
        final h1.b bVarH1 = h1();
        B2(bVarH1, -1, new s.a() { // from class: za.w0
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).j(bVarH1, z10, i10);
            }
        });
    }

    public final void D2(List<l.a> list, @g.p0 l.a aVar) {
        this.f58054d.k(list, aVar, (ya.j1) hd.a.g(this.f58057g));
    }

    @Override // com.google.android.exoplayer2.source.m
    public final void E(int i10, @g.p0 l.a aVar, final ec.j jVar, final ec.k kVar, final IOException iOException, final boolean z10) {
        final h1.b bVarL1 = l1(i10, aVar);
        B2(bVarL1, 1003, new s.a() { // from class: za.e0
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).e(bVarL1, jVar, kVar, iOException, z10);
            }
        });
    }

    @Override // id.z
    public final void F(final eb.d dVar) {
        final h1.b bVarN1 = n1();
        B2(bVarN1, 1020, new s.a() { // from class: za.a0
            @Override // hd.s.a
            public final void i(Object obj) {
                f1.l2(bVarN1, dVar, (h1) obj);
            }
        });
    }

    @Override // id.z
    public final void G(final Format format, @g.p0 final eb.e eVar) {
        final h1.b bVarN1 = n1();
        B2(bVarN1, h1.K, new s.a() { // from class: za.s
            @Override // hd.s.a
            public final void i(Object obj) {
                f1.n2(bVarN1, format, eVar, (h1) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.b
    public final void H(int i10, @g.p0 l.a aVar) {
        final h1.b bVarL1 = l1(i10, aVar);
        B2(bVarL1, 1030, new s.a() { // from class: za.s0
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).Z(bVarL1);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.m
    public final void I(int i10, @g.p0 l.a aVar, final ec.k kVar) {
        final h1.b bVarL1 = l1(i10, aVar);
        B2(bVarL1, 1004, new s.a() { // from class: za.f0
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).C(bVarL1, kVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.m
    public final void J(int i10, @g.p0 l.a aVar, final ec.j jVar, final ec.k kVar) {
        final h1.b bVarL1 = l1(i10, aVar);
        B2(bVarL1, 1000, new s.a() { // from class: za.d0
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).c0(bVarL1, jVar, kVar);
            }
        });
    }

    @Override // id.z
    public /* synthetic */ void K(Format format) {
        id.p.h(this, format);
    }

    @Override // com.google.android.exoplayer2.audio.a
    public final void L(final long j10) {
        final h1.b bVarN1 = n1();
        B2(bVarN1, 1011, new s.a() { // from class: za.n
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).o(bVarN1, j10);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.b
    public final void M(int i10, @g.p0 l.a aVar) {
        final h1.b bVarL1 = l1(i10, aVar);
        B2(bVarL1, 1031, new s.a() { // from class: za.h0
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).u(bVarL1);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.m
    public final void N(int i10, @g.p0 l.a aVar, final ec.k kVar) {
        final h1.b bVarL1 = l1(i10, aVar);
        B2(bVarL1, 1005, new s.a() { // from class: za.g0
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).n0(bVarL1, kVar);
            }
        });
    }

    @Override // id.z
    public final void O(final eb.d dVar) {
        final h1.b bVarM1 = m1();
        B2(bVarM1, 1025, new s.a() { // from class: za.x
            @Override // hd.s.a
            public final void i(Object obj) {
                f1.k2(bVarM1, dVar, (h1) obj);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.a
    public /* synthetic */ void P(Format format) {
        ab.i.e(this, format);
    }

    @Override // com.google.android.exoplayer2.audio.a
    public final void Q(final Format format, @g.p0 final eb.e eVar) {
        final h1.b bVarN1 = n1();
        B2(bVarN1, 1010, new s.a() { // from class: za.t
            @Override // hd.s.a
            public final void i(Object obj) {
                f1.v1(bVarN1, format, eVar, (h1) obj);
            }
        });
    }

    @Override // ya.j1.f
    public final void R(final boolean z10, final int i10) {
        final h1.b bVarH1 = h1();
        B2(bVarH1, 6, new s.a() { // from class: za.x0
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).x(bVarH1, z10, i10);
            }
        });
    }

    @Override // ya.j1.f
    public final void S(x1 x1Var, final int i10) {
        this.f58054d.l((ya.j1) hd.a.g(this.f58057g));
        final h1.b bVarH1 = h1();
        B2(bVarH1, 0, new s.a() { // from class: za.c
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).k0(bVarH1, i10);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.b
    public final void T(int i10, @g.p0 l.a aVar) {
        final h1.b bVarL1 = l1(i10, aVar);
        B2(bVarL1, h1.X, new s.a() { // from class: za.c1
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).K(bVarL1);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.m
    public final void U(int i10, @g.p0 l.a aVar, final ec.j jVar, final ec.k kVar) {
        final h1.b bVarL1 = l1(i10, aVar);
        B2(bVarL1, 1002, new s.a() { // from class: za.c0
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).M(bVarL1, jVar, kVar);
            }
        });
    }

    @Override // ya.j1.f
    public /* synthetic */ void V(boolean z10) {
        ya.k1.b(this, z10);
    }

    @Override // com.google.android.exoplayer2.audio.a
    public final void W(final int i10, final long j10, final long j11) {
        final h1.b bVarN1 = n1();
        B2(bVarN1, 1012, new s.a() { // from class: za.m
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).S(bVarN1, i10, j10, j11);
            }
        });
    }

    @Override // id.z
    public final void X(final long j10, final int i10) {
        final h1.b bVarM1 = m1();
        B2(bVarM1, 1026, new s.a() { // from class: za.o
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).T(bVarM1, j10, i10);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.a
    public final void Y(final eb.d dVar) {
        final h1.b bVarM1 = m1();
        B2(bVarM1, 1014, new s.a() { // from class: za.z
            @Override // hd.s.a
            public final void i(Object obj) {
                f1.t1(bVarM1, dVar, (h1) obj);
            }
        });
    }

    @Override // ya.j1.f
    public final void Z(@g.p0 final ya.v0 v0Var, final int i10) {
        final h1.b bVarH1 = h1();
        B2(bVarH1, 1, new s.a() { // from class: za.p0
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).g(bVarH1, v0Var, i10);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.a
    public final void a(final boolean z10) {
        final h1.b bVarN1 = n1();
        B2(bVarN1, 1017, new s.a() { // from class: za.u0
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).d(bVarN1, z10);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.b
    public final void a0(int i10, @g.p0 l.a aVar) {
        final h1.b bVarL1 = l1(i10, aVar);
        B2(bVarL1, h1.V, new s.a() { // from class: za.l
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).E(bVarL1);
            }
        });
    }

    @Override // ya.j1.f
    public final void b(final ya.h1 h1Var) {
        final h1.b bVarH1 = h1();
        B2(bVarH1, 13, new s.a() { // from class: za.q0
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).n(bVarH1, h1Var);
            }
        });
    }

    @Override // ya.j1.f
    public void b0(final boolean z10) {
        final h1.b bVarH1 = h1();
        B2(bVarH1, 8, new s.a() { // from class: za.v0
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).a(bVarH1, z10);
            }
        });
    }

    @Override // id.z
    public final void c(final int i10, final int i11, final int i12, final float f10) {
        final h1.b bVarN1 = n1();
        B2(bVarN1, 1028, new s.a() { // from class: za.i
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).h(bVarN1, i10, i11, i12, f10);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.a
    public final void d(final Exception exc) {
        final h1.b bVarN1 = n1();
        B2(bVarN1, 1018, new s.a() { // from class: za.i0
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).f(bVarN1, exc);
            }
        });
    }

    @Override // ya.j1.f
    public final void e(final int i10) {
        final h1.b bVarH1 = h1();
        B2(bVarH1, 7, new s.a() { // from class: za.b
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).B(bVarH1, i10);
            }
        });
    }

    @Override // ya.j1.f
    public /* synthetic */ void f(x1 x1Var, Object obj, int i10) {
        ya.k1.t(this, x1Var, obj, i10);
    }

    @Override // ya.j1.f
    public /* synthetic */ void g(boolean z10) {
        ya.k1.f(this, z10);
    }

    @g.i
    public void g1(h1 h1Var) {
        hd.a.g(h1Var);
        this.f58056f.c(h1Var);
    }

    @Override // ya.j1.f
    public final void h(final TrackGroupArray trackGroupArray, final ad.i iVar) {
        final h1.b bVarH1 = h1();
        B2(bVarH1, 2, new s.a() { // from class: za.v
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).Q(bVarH1, trackGroupArray, iVar);
            }
        });
    }

    public final h1.b h1() {
        return i1(this.f58054d.d());
    }

    @Override // ya.j1.f
    public final void i(final int i10) {
        if (i10 == 1) {
            this.f58058h = false;
        }
        this.f58054d.j((ya.j1) hd.a.g(this.f58057g));
        final h1.b bVarH1 = h1();
        B2(bVarH1, 12, new s.a() { // from class: za.f
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).w(bVarH1, i10);
            }
        });
    }

    public final h1.b i1(@g.p0 l.a aVar) {
        hd.a.g(this.f58057g);
        x1 x1VarF = aVar == null ? null : this.f58054d.f(aVar);
        if (aVar != null && x1VarF != null) {
            return j1(x1VarF, x1VarF.h(aVar.f26856a, this.f58052b).f57234c, aVar);
        }
        int iR0 = this.f58057g.r0();
        x1 x1VarN1 = this.f58057g.n1();
        if (!(iR0 < x1VarN1.q())) {
            x1VarN1 = x1.f57231a;
        }
        return j1(x1VarN1, iR0, null);
    }

    @Override // id.z
    public final void j(final String str) {
        final h1.b bVarN1 = n1();
        B2(bVarN1, 1024, new s.a() { // from class: za.l0
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).D(bVarN1, str);
            }
        });
    }

    @RequiresNonNull({"player"})
    public final h1.b j1(x1 x1Var, int i10, @g.p0 l.a aVar) {
        long jC0;
        l.a aVar2 = x1Var.r() ? null : aVar;
        long jE = this.f58051a.e();
        boolean z10 = x1Var.equals(this.f58057g.n1()) && i10 == this.f58057g.r0();
        long jB = 0;
        if (aVar2 != null && aVar2.b()) {
            if (z10 && this.f58057g.T0() == aVar2.f26857b && this.f58057g.f0() == aVar2.f26858c) {
                jB = this.f58057g.H1();
            }
        } else {
            if (z10) {
                jC0 = this.f58057g.C0();
                return new h1.b(jE, x1Var, i10, aVar2, jC0, this.f58057g.n1(), this.f58057g.r0(), this.f58054d.d(), this.f58057g.H1(), this.f58057g.A());
            }
            if (!x1Var.r()) {
                jB = x1Var.n(i10, this.f58053c).b();
            }
        }
        jC0 = jB;
        return new h1.b(jE, x1Var, i10, aVar2, jC0, this.f58057g.n1(), this.f58057g.r0(), this.f58054d.d(), this.f58057g.H1(), this.f58057g.A());
    }

    @Override // ya.j1.f
    public final void k(final List<Metadata> list) {
        final h1.b bVarH1 = h1();
        B2(bVarH1, 3, new s.a() { // from class: za.o0
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).e0(bVarH1, list);
            }
        });
    }

    public final h1.b k1() {
        return i1(this.f58054d.e());
    }

    @Override // id.z
    public final void l(final String str, long j10, final long j11) {
        final h1.b bVarN1 = n1();
        B2(bVarN1, 1021, new s.a() { // from class: za.m0
            @Override // hd.s.a
            public final void i(Object obj) {
                f1.i2(bVarN1, str, j11, (h1) obj);
            }
        });
    }

    public final h1.b l1(int i10, @g.p0 l.a aVar) {
        hd.a.g(this.f58057g);
        if (aVar != null) {
            return this.f58054d.f(aVar) != null ? i1(aVar) : j1(x1.f57231a, i10, aVar);
        }
        x1 x1VarN1 = this.f58057g.n1();
        if (!(i10 < x1VarN1.q())) {
            x1VarN1 = x1.f57231a;
        }
        return j1(x1VarN1, i10, null);
    }

    @Override // ya.j1.f
    public final void m(final ExoPlaybackException exoPlaybackException) {
        ec.n nVar = exoPlaybackException.mediaPeriodId;
        final h1.b bVarI1 = nVar != null ? i1(new l.a(nVar)) : h1();
        B2(bVarI1, 11, new s.a() { // from class: za.r
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).N(bVarI1, exoPlaybackException);
            }
        });
    }

    public final h1.b m1() {
        return i1(this.f58054d.g());
    }

    @Override // ya.j1.f
    public final void n(final boolean z10) {
        final h1.b bVarH1 = h1();
        B2(bVarH1, 4, new s.a() { // from class: za.r0
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).r(bVarH1, z10);
            }
        });
    }

    public final h1.b n1() {
        return i1(this.f58054d.h());
    }

    @Override // ya.j1.f
    public final void o() {
        final h1.b bVarH1 = h1();
        B2(bVarH1, -1, new s.a() { // from class: za.b1
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).J(bVarH1);
            }
        });
    }

    @Override // ya.j1.f
    public /* synthetic */ void p(ya.j1 j1Var, j1.g gVar) {
        ya.k1.a(this, j1Var, gVar);
    }

    @Override // com.google.android.exoplayer2.drm.b
    public final void q(int i10, @g.p0 l.a aVar, final Exception exc) {
        final h1.b bVarL1 = l1(i10, aVar);
        B2(bVarL1, h1.U, new s.a() { // from class: za.j0
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).z(bVarL1, exc);
            }
        });
    }

    @Override // ya.j1.f
    public final void r(final int i10) {
        final h1.b bVarH1 = h1();
        B2(bVarH1, 5, new s.a() { // from class: za.d
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).l(bVarH1, i10);
            }
        });
    }

    @Override // id.z
    public final void s(@g.p0 final Surface surface) {
        final h1.b bVarN1 = n1();
        B2(bVarN1, 1027, new s.a() { // from class: za.q
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).H(bVarN1, surface);
            }
        });
    }

    public final void s2() {
        if (this.f58058h) {
            return;
        }
        final h1.b bVarH1 = h1();
        this.f58058h = true;
        B2(bVarH1, -1, new s.a() { // from class: za.d1
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).U(bVarH1);
            }
        });
    }

    @Override // ed.d.a
    public final void t(final int i10, final long j10, final long j11) {
        final h1.b bVarK1 = k1();
        B2(bVarK1, 1006, new s.a() { // from class: za.k
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).t(bVarK1, i10, j10, j11);
            }
        });
    }

    public final void t2(final ab.d dVar) {
        final h1.b bVarN1 = n1();
        B2(bVarN1, 1016, new s.a() { // from class: za.p
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).m(bVarN1, dVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.m
    public final void u(int i10, @g.p0 l.a aVar, final ec.j jVar, final ec.k kVar) {
        final h1.b bVarL1 = l1(i10, aVar);
        B2(bVarL1, 1001, new s.a() { // from class: za.b0
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).V(bVarL1, jVar, kVar);
            }
        });
    }

    public final void u2(final int i10) {
        final h1.b bVarN1 = n1();
        B2(bVarN1, 1015, new s.a() { // from class: za.g
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).X(bVarN1, i10);
            }
        });
    }

    @Override // ya.j1.f
    public final void v(final int i10) {
        final h1.b bVarH1 = h1();
        B2(bVarH1, 9, new s.a() { // from class: za.e
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).g0(bVarH1, i10);
            }
        });
    }

    public final void v2(final Metadata metadata) {
        final h1.b bVarH1 = h1();
        B2(bVarH1, 1007, new s.a() { // from class: za.u
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).v(bVarH1, metadata);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.a
    public final void w(final String str) {
        final h1.b bVarN1 = n1();
        B2(bVarN1, 1013, new s.a() { // from class: za.k0
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).i(bVarN1, str);
            }
        });
    }

    public void w2(final int i10, final int i11) {
        final h1.b bVarN1 = n1();
        B2(bVarN1, 1029, new s.a() { // from class: za.h
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).m0(bVarN1, i10, i11);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.a
    public final void x(final String str, long j10, final long j11) {
        final h1.b bVarN1 = n1();
        B2(bVarN1, 1009, new s.a() { // from class: za.n0
            @Override // hd.s.a
            public final void i(Object obj) {
                f1.r1(bVarN1, str, j11, (h1) obj);
            }
        });
    }

    public final void x2(final float f10) {
        final h1.b bVarN1 = n1();
        B2(bVarN1, 1019, new s.a() { // from class: za.e1
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).b0(bVarN1, f10);
            }
        });
    }

    @Override // ya.j1.f
    public final void y(final boolean z10) {
        final h1.b bVarH1 = h1();
        B2(bVarH1, 10, new s.a() { // from class: za.t0
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).b(bVarH1, z10);
            }
        });
    }

    @g.i
    public void y2() {
        final h1.b bVarH1 = h1();
        this.f58055e.put(h1.Y, bVarH1);
        this.f58056f.h(h1.Y, new s.a() { // from class: za.w
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).a0(bVarH1);
            }
        });
    }

    @Override // id.z
    public final void z(final int i10, final long j10) {
        final h1.b bVarM1 = m1();
        B2(bVarM1, 1023, new s.a() { // from class: za.j
            @Override // hd.s.a
            public final void i(Object obj) {
                ((h1) obj).s(bVarM1, i10, j10);
            }
        });
    }

    @g.i
    public void z2(h1 h1Var) {
        this.f58056f.k(h1Var);
    }
}
