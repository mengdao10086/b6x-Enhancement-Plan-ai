package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.l;
import g.p0;
import hd.u0;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public interface m {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public final l.a f18152b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CopyOnWriteArrayList<C0190a> f18153c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f18154d;

        /* JADX INFO: renamed from: com.google.android.exoplayer2.source.m$a$a, reason: collision with other inner class name */
        public static final class C0190a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Handler f18155a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public m f18156b;

            public C0190a(Handler handler, m mVar) {
                this.f18155a = handler;
                this.f18156b = mVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null, 0L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(m mVar, ec.k kVar) {
            mVar.I(this.f18151a, this.f18152b, kVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(m mVar, ec.j jVar, ec.k kVar) {
            mVar.U(this.f18151a, this.f18152b, jVar, kVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(m mVar, ec.j jVar, ec.k kVar) {
            mVar.u(this.f18151a, this.f18152b, jVar, kVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(m mVar, ec.j jVar, ec.k kVar, IOException iOException, boolean z10) {
            mVar.E(this.f18151a, this.f18152b, jVar, kVar, iOException, z10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(m mVar, ec.j jVar, ec.k kVar) {
            mVar.J(this.f18151a, this.f18152b, jVar, kVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(m mVar, l.a aVar, ec.k kVar) {
            mVar.N(this.f18151a, aVar, kVar);
        }

        public void A(ec.j jVar, int i10, int i11, @p0 Format format, int i12, @p0 Object obj, long j10, long j11) {
            B(jVar, new ec.k(i10, i11, format, i12, obj, h(j10), h(j11)));
        }

        public void B(final ec.j jVar, final ec.k kVar) {
            for (C0190a c0190a : this.f18153c) {
                final m mVar = c0190a.f18156b;
                u0.a1(c0190a.f18155a, new Runnable() { // from class: ec.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f26869a.o(mVar, jVar, kVar);
                    }
                });
            }
        }

        public void C(m mVar) {
            for (C0190a c0190a : this.f18153c) {
                if (c0190a.f18156b == mVar) {
                    this.f18153c.remove(c0190a);
                }
            }
        }

        public void D(int i10, long j10, long j11) {
            E(new ec.k(1, i10, null, 3, null, h(j10), h(j11)));
        }

        public void E(final ec.k kVar) {
            final l.a aVar = (l.a) hd.a.g(this.f18152b);
            for (C0190a c0190a : this.f18153c) {
                final m mVar = c0190a.f18156b;
                u0.a1(c0190a.f18155a, new Runnable() { // from class: ec.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f26861a.p(mVar, aVar, kVar);
                    }
                });
            }
        }

        @g.j
        public a F(int i10, @p0 l.a aVar, long j10) {
            return new a(this.f18153c, i10, aVar, j10);
        }

        public void g(Handler handler, m mVar) {
            hd.a.g(handler);
            hd.a.g(mVar);
            this.f18153c.add(new C0190a(handler, mVar));
        }

        public final long h(long j10) {
            long jD = ya.g.d(j10);
            return jD == ya.g.f56663b ? ya.g.f56663b : this.f18154d + jD;
        }

        public void i(int i10, @p0 Format format, int i11, @p0 Object obj, long j10) {
            j(new ec.k(1, i10, format, i11, obj, h(j10), ya.g.f56663b));
        }

        public void j(final ec.k kVar) {
            for (C0190a c0190a : this.f18153c) {
                final m mVar = c0190a.f18156b;
                u0.a1(c0190a.f18155a, new Runnable() { // from class: ec.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f26883a.k(mVar, kVar);
                    }
                });
            }
        }

        public void q(ec.j jVar, int i10) {
            r(jVar, i10, -1, null, 0, null, ya.g.f56663b, ya.g.f56663b);
        }

        public void r(ec.j jVar, int i10, int i11, @p0 Format format, int i12, @p0 Object obj, long j10, long j11) {
            s(jVar, new ec.k(i10, i11, format, i12, obj, h(j10), h(j11)));
        }

        public void s(final ec.j jVar, final ec.k kVar) {
            for (C0190a c0190a : this.f18153c) {
                final m mVar = c0190a.f18156b;
                u0.a1(c0190a.f18155a, new Runnable() { // from class: ec.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f26873a.l(mVar, jVar, kVar);
                    }
                });
            }
        }

        public void t(ec.j jVar, int i10) {
            u(jVar, i10, -1, null, 0, null, ya.g.f56663b, ya.g.f56663b);
        }

        public void u(ec.j jVar, int i10, int i11, @p0 Format format, int i12, @p0 Object obj, long j10, long j11) {
            v(jVar, new ec.k(i10, i11, format, i12, obj, h(j10), h(j11)));
        }

        public void v(final ec.j jVar, final ec.k kVar) {
            for (C0190a c0190a : this.f18153c) {
                final m mVar = c0190a.f18156b;
                u0.a1(c0190a.f18155a, new Runnable() { // from class: ec.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f26865a.m(mVar, jVar, kVar);
                    }
                });
            }
        }

        public void w(ec.j jVar, int i10, int i11, @p0 Format format, int i12, @p0 Object obj, long j10, long j11, IOException iOException, boolean z10) {
            y(jVar, new ec.k(i10, i11, format, i12, obj, h(j10), h(j11)), iOException, z10);
        }

        public void x(ec.j jVar, int i10, IOException iOException, boolean z10) {
            w(jVar, i10, -1, null, 0, null, ya.g.f56663b, ya.g.f56663b, iOException, z10);
        }

        public void y(final ec.j jVar, final ec.k kVar, final IOException iOException, final boolean z10) {
            for (C0190a c0190a : this.f18153c) {
                final m mVar = c0190a.f18156b;
                u0.a1(c0190a.f18155a, new Runnable() { // from class: ec.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f26877a.n(mVar, jVar, kVar, iOException, z10);
                    }
                });
            }
        }

        public void z(ec.j jVar, int i10) {
            A(jVar, i10, -1, null, 0, null, ya.g.f56663b, ya.g.f56663b);
        }

        public a(CopyOnWriteArrayList<C0190a> copyOnWriteArrayList, int i10, @p0 l.a aVar, long j10) {
            this.f18153c = copyOnWriteArrayList;
            this.f18151a = i10;
            this.f18152b = aVar;
            this.f18154d = j10;
        }
    }

    void E(int i10, @p0 l.a aVar, ec.j jVar, ec.k kVar, IOException iOException, boolean z10);

    void I(int i10, @p0 l.a aVar, ec.k kVar);

    void J(int i10, @p0 l.a aVar, ec.j jVar, ec.k kVar);

    void N(int i10, l.a aVar, ec.k kVar);

    void U(int i10, @p0 l.a aVar, ec.j jVar, ec.k kVar);

    void u(int i10, @p0 l.a aVar, ec.j jVar, ec.k kVar);
}
