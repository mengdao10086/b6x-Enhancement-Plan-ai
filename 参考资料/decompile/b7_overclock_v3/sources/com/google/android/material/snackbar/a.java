package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import g.n0;
import g.p0;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f20754e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f20755f = 1500;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f20756g = 2750;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static a f20757h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final Object f20758a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final Handler f20759b = new Handler(Looper.getMainLooper(), new C0210a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public c f20760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public c f20761d;

    /* JADX INFO: renamed from: com.google.android.material.snackbar.a$a, reason: collision with other inner class name */
    public class C0210a implements Handler.Callback {
        public C0210a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@n0 Message message) {
            if (message.what != 0) {
                return false;
            }
            a.this.d((c) message.obj);
            return true;
        }
    }

    public interface b {
        void a();

        void b(int i10);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public final WeakReference<b> f20763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f20764b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f20765c;

        public c(int i10, b bVar) {
            this.f20763a = new WeakReference<>(bVar);
            this.f20764b = i10;
        }

        public boolean a(@p0 b bVar) {
            return bVar != null && this.f20763a.get() == bVar;
        }
    }

    public static a c() {
        if (f20757h == null) {
            f20757h = new a();
        }
        return f20757h;
    }

    public final boolean a(@n0 c cVar, int i10) {
        b bVar = cVar.f20763a.get();
        if (bVar == null) {
            return false;
        }
        this.f20759b.removeCallbacksAndMessages(cVar);
        bVar.b(i10);
        return true;
    }

    public void b(b bVar, int i10) {
        synchronized (this.f20758a) {
            if (g(bVar)) {
                a(this.f20760c, i10);
            } else if (h(bVar)) {
                a(this.f20761d, i10);
            }
        }
    }

    public void d(@n0 c cVar) {
        synchronized (this.f20758a) {
            if (this.f20760c == cVar || this.f20761d == cVar) {
                a(cVar, 2);
            }
        }
    }

    public boolean e(b bVar) {
        boolean zG;
        synchronized (this.f20758a) {
            zG = g(bVar);
        }
        return zG;
    }

    public boolean f(b bVar) {
        boolean z10;
        synchronized (this.f20758a) {
            z10 = g(bVar) || h(bVar);
        }
        return z10;
    }

    public final boolean g(b bVar) {
        c cVar = this.f20760c;
        return cVar != null && cVar.a(bVar);
    }

    public final boolean h(b bVar) {
        c cVar = this.f20761d;
        return cVar != null && cVar.a(bVar);
    }

    public void i(b bVar) {
        synchronized (this.f20758a) {
            if (g(bVar)) {
                this.f20760c = null;
                if (this.f20761d != null) {
                    o();
                }
            }
        }
    }

    public void j(b bVar) {
        synchronized (this.f20758a) {
            if (g(bVar)) {
                m(this.f20760c);
            }
        }
    }

    public void k(b bVar) {
        synchronized (this.f20758a) {
            if (g(bVar)) {
                c cVar = this.f20760c;
                if (!cVar.f20765c) {
                    cVar.f20765c = true;
                    this.f20759b.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    public void l(b bVar) {
        synchronized (this.f20758a) {
            if (g(bVar)) {
                c cVar = this.f20760c;
                if (cVar.f20765c) {
                    cVar.f20765c = false;
                    m(cVar);
                }
            }
        }
    }

    public final void m(@n0 c cVar) {
        int i10 = cVar.f20764b;
        if (i10 == -2) {
            return;
        }
        if (i10 <= 0) {
            i10 = i10 == -1 ? 1500 : f20756g;
        }
        this.f20759b.removeCallbacksAndMessages(cVar);
        Handler handler = this.f20759b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i10);
    }

    public void n(int i10, b bVar) {
        synchronized (this.f20758a) {
            if (g(bVar)) {
                c cVar = this.f20760c;
                cVar.f20764b = i10;
                this.f20759b.removeCallbacksAndMessages(cVar);
                m(this.f20760c);
                return;
            }
            if (h(bVar)) {
                this.f20761d.f20764b = i10;
            } else {
                this.f20761d = new c(i10, bVar);
            }
            c cVar2 = this.f20760c;
            if (cVar2 == null || !a(cVar2, 4)) {
                this.f20760c = null;
                o();
            }
        }
    }

    public final void o() {
        c cVar = this.f20761d;
        if (cVar != null) {
            this.f20760c = cVar;
            this.f20761d = null;
            b bVar = cVar.f20763a.get();
            if (bVar != null) {
                bVar.a();
            } else {
                this.f20760c = null;
            }
        }
    }
}
