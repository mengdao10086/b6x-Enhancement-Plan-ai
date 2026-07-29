package com.google.android.exoplayer2.audio;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import g.p0;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public interface a {

    /* JADX INFO: renamed from: com.google.android.exoplayer2.audio.a$a, reason: collision with other inner class name */
    public static final class C0175a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @p0
        public final Handler f16834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public final a f16835b;

        public C0175a(@p0 Handler handler, @p0 a aVar) {
            this.f16834a = aVar != null ? (Handler) hd.a.g(handler) : null;
            this.f16835b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(Exception exc) {
            ((a) u0.k(this.f16835b)).d(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(String str, long j10, long j11) {
            ((a) u0.k(this.f16835b)).x(str, j10, j11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(String str) {
            ((a) u0.k(this.f16835b)).w(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(eb.d dVar) {
            dVar.c();
            ((a) u0.k(this.f16835b)).Y(dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(eb.d dVar) {
            ((a) u0.k(this.f16835b)).A(dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(Format format, eb.e eVar) {
            ((a) u0.k(this.f16835b)).Q(format, eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v(long j10) {
            ((a) u0.k(this.f16835b)).L(j10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w(boolean z10) {
            ((a) u0.k(this.f16835b)).a(z10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x(int i10, long j10, long j11) {
            ((a) u0.k(this.f16835b)).W(i10, j10, j11);
        }

        public void A(final int i10, final long j10, final long j11) {
            Handler handler = this.f16834a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ab.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f444a.x(i10, j10, j11);
                    }
                });
            }
        }

        public void j(final Exception exc) {
            Handler handler = this.f16834a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ab.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f457a.p(exc);
                    }
                });
            }
        }

        public void k(final String str, final long j10, final long j11) {
            Handler handler = this.f16834a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ab.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f461a.q(str, j10, j11);
                    }
                });
            }
        }

        public void l(final String str) {
            Handler handler = this.f16834a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ab.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f459a.r(str);
                    }
                });
            }
        }

        public void m(final eb.d dVar) {
            dVar.c();
            Handler handler = this.f16834a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ab.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f453a.s(dVar);
                    }
                });
            }
        }

        public void n(final eb.d dVar) {
            Handler handler = this.f16834a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ab.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f455a.t(dVar);
                    }
                });
            }
        }

        public void o(final Format format, @p0 final eb.e eVar) {
            Handler handler = this.f16834a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ab.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f450a.u(format, eVar);
                    }
                });
            }
        }

        public void y(final long j10) {
            Handler handler = this.f16834a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ab.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f448a.v(j10);
                    }
                });
            }
        }

        public void z(final boolean z10) {
            Handler handler = this.f16834a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: ab.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f465a.w(z10);
                    }
                });
            }
        }
    }

    void A(eb.d dVar);

    void L(long j10);

    @Deprecated
    void P(Format format);

    void Q(Format format, @p0 eb.e eVar);

    void W(int i10, long j10, long j11);

    void Y(eb.d dVar);

    void a(boolean z10);

    void d(Exception exc);

    void w(String str);

    void x(String str, long j10, long j11);
}
