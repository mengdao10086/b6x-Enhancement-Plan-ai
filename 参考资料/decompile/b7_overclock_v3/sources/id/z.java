package id;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import g.p0;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public interface z {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @p0
        public final Handler f32307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public final z f32308b;

        public a(@p0 Handler handler, @p0 z zVar) {
            this.f32307a = zVar != null ? (Handler) hd.a.g(handler) : null;
            this.f32308b = zVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(String str, long j10, long j11) {
            ((z) u0.k(this.f32308b)).l(str, j10, j11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(String str) {
            ((z) u0.k(this.f32308b)).j(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(eb.d dVar) {
            dVar.c();
            ((z) u0.k(this.f32308b)).O(dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(int i10, long j10) {
            ((z) u0.k(this.f32308b)).z(i10, j10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(eb.d dVar) {
            ((z) u0.k(this.f32308b)).F(dVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(Format format, eb.e eVar) {
            ((z) u0.k(this.f32308b)).G(format, eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v(Surface surface) {
            ((z) u0.k(this.f32308b)).s(surface);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w(long j10, int i10) {
            ((z) u0.k(this.f32308b)).X(j10, i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x(int i10, int i11, int i12, float f10) {
            ((z) u0.k(this.f32308b)).c(i10, i11, i12, f10);
        }

        public void A(final int i10, final int i11, final int i12, final float f10) {
            Handler handler = this.f32307a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: id.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f32281a.x(i10, i11, i12, f10);
                    }
                });
            }
        }

        public void j(final String str, final long j10, final long j11) {
            Handler handler = this.f32307a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: id.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f32303a.p(str, j10, j11);
                    }
                });
            }
        }

        public void k(final String str) {
            Handler handler = this.f32307a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: id.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f32301a.q(str);
                    }
                });
            }
        }

        public void l(final eb.d dVar) {
            dVar.c();
            Handler handler = this.f32307a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: id.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f32297a.r(dVar);
                    }
                });
            }
        }

        public void m(final int i10, final long j10) {
            Handler handler = this.f32307a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: id.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f32286a.s(i10, j10);
                    }
                });
            }
        }

        public void n(final eb.d dVar) {
            Handler handler = this.f32307a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: id.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f32299a.t(dVar);
                    }
                });
            }
        }

        public void o(final Format format, @p0 final eb.e eVar) {
            Handler handler = this.f32307a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: id.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f32294a.u(format, eVar);
                    }
                });
            }
        }

        public void y(@p0 final Surface surface) {
            Handler handler = this.f32307a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: id.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f32292a.v(surface);
                    }
                });
            }
        }

        public void z(final long j10, final int i10) {
            Handler handler = this.f32307a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: id.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f32289a.w(j10, i10);
                    }
                });
            }
        }
    }

    void F(eb.d dVar);

    void G(Format format, @p0 eb.e eVar);

    @Deprecated
    void K(Format format);

    void O(eb.d dVar);

    void X(long j10, int i10);

    void c(int i10, int i11, int i12, float f10);

    void j(String str);

    void l(String str, long j10, long j11);

    void s(@p0 Surface surface);

    void z(int i10, long j10);
}
