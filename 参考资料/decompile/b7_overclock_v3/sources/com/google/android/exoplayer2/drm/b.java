package com.google.android.exoplayer2.drm;

import android.os.Handler;
import com.google.android.exoplayer2.source.l;
import g.p0;
import hd.u0;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public interface b {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public final l.a f17053b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CopyOnWriteArrayList<C0176a> f17054c;

        /* JADX INFO: renamed from: com.google.android.exoplayer2.drm.b$a$a, reason: collision with other inner class name */
        public static final class C0176a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Handler f17055a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public b f17056b;

            public C0176a(Handler handler, b bVar) {
                this.f17055a = handler;
                this.f17056b = bVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(b bVar) {
            bVar.M(this.f17052a, this.f17053b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(b bVar) {
            bVar.C(this.f17052a, this.f17053b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(b bVar) {
            bVar.a0(this.f17052a, this.f17053b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(b bVar) {
            bVar.H(this.f17052a, this.f17053b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(b bVar, Exception exc) {
            bVar.q(this.f17052a, this.f17053b, exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(b bVar) {
            bVar.T(this.f17052a, this.f17053b);
        }

        public void g(Handler handler, b bVar) {
            hd.a.g(handler);
            hd.a.g(bVar);
            this.f17054c.add(new C0176a(handler, bVar));
        }

        public void h() {
            for (C0176a c0176a : this.f17054c) {
                final b bVar = c0176a.f17056b;
                u0.a1(c0176a.f17055a, new Runnable() { // from class: gb.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f29116a.n(bVar);
                    }
                });
            }
        }

        public void i() {
            for (C0176a c0176a : this.f17054c) {
                final b bVar = c0176a.f17056b;
                u0.a1(c0176a.f17055a, new Runnable() { // from class: gb.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f29114a.o(bVar);
                    }
                });
            }
        }

        public void j() {
            for (C0176a c0176a : this.f17054c) {
                final b bVar = c0176a.f17056b;
                u0.a1(c0176a.f17055a, new Runnable() { // from class: gb.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f29118a.p(bVar);
                    }
                });
            }
        }

        public void k() {
            for (C0176a c0176a : this.f17054c) {
                final b bVar = c0176a.f17056b;
                u0.a1(c0176a.f17055a, new Runnable() { // from class: gb.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f29110a.q(bVar);
                    }
                });
            }
        }

        public void l(final Exception exc) {
            for (C0176a c0176a : this.f17054c) {
                final b bVar = c0176a.f17056b;
                u0.a1(c0176a.f17055a, new Runnable() { // from class: gb.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f29120a.r(bVar, exc);
                    }
                });
            }
        }

        public void m() {
            for (C0176a c0176a : this.f17054c) {
                final b bVar = c0176a.f17056b;
                u0.a1(c0176a.f17055a, new Runnable() { // from class: gb.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f29112a.s(bVar);
                    }
                });
            }
        }

        public void t(b bVar) {
            for (C0176a c0176a : this.f17054c) {
                if (c0176a.f17056b == bVar) {
                    this.f17054c.remove(c0176a);
                }
            }
        }

        @g.j
        public a u(int i10, @p0 l.a aVar) {
            return new a(this.f17054c, i10, aVar);
        }

        public a(CopyOnWriteArrayList<C0176a> copyOnWriteArrayList, int i10, @p0 l.a aVar) {
            this.f17054c = copyOnWriteArrayList;
            this.f17052a = i10;
            this.f17053b = aVar;
        }
    }

    void C(int i10, @p0 l.a aVar);

    void H(int i10, @p0 l.a aVar);

    void M(int i10, @p0 l.a aVar);

    void T(int i10, @p0 l.a aVar);

    void a0(int i10, @p0 l.a aVar);

    void q(int i10, @p0 l.a aVar, Exception exc);
}
