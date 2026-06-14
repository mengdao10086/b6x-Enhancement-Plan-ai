package a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class b10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b10 f5662a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a10 f192a;
    public a10 b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f194a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f193a = new Handler(Looper.getMainLooper(), new y00(this));

    public static b10 c() {
        if (f5662a == null) {
            f5662a = new b10();
        }
        return f5662a;
    }

    public final boolean a(a10 a10Var, int i) {
        z00 z00Var = a10Var.f7a.get();
        if (z00Var == null) {
            return false;
        }
        this.f193a.removeCallbacksAndMessages(a10Var);
        z00Var.a(i);
        return true;
    }

    public void b(z00 z00Var, int i) {
        a10 a10Var;
        synchronized (this.f194a) {
            if (f(z00Var)) {
                a10Var = this.f192a;
            } else if (g(z00Var)) {
                a10Var = this.b;
            }
            a(a10Var, i);
        }
    }

    public void d(a10 a10Var) {
        synchronized (this.f194a) {
            if (this.f192a == a10Var || this.b == a10Var) {
                a(a10Var, 2);
            }
        }
    }

    public boolean e(z00 z00Var) {
        boolean z;
        synchronized (this.f194a) {
            z = f(z00Var) || g(z00Var);
        }
        return z;
    }

    public final boolean f(z00 z00Var) {
        a10 a10Var = this.f192a;
        return a10Var != null && a10Var.a(z00Var);
    }

    public final boolean g(z00 z00Var) {
        a10 a10Var = this.b;
        return a10Var != null && a10Var.a(z00Var);
    }

    public void h(z00 z00Var) {
        synchronized (this.f194a) {
            if (f(z00Var)) {
                this.f192a = null;
                if (this.b != null) {
                    n();
                }
            }
        }
    }

    public void i(z00 z00Var) {
        synchronized (this.f194a) {
            if (f(z00Var)) {
                l(this.f192a);
            }
        }
    }

    public void j(z00 z00Var) {
        synchronized (this.f194a) {
            if (f(z00Var) && !this.f192a.f8a) {
                this.f192a.f8a = true;
                this.f193a.removeCallbacksAndMessages(this.f192a);
            }
        }
    }

    public void k(z00 z00Var) {
        synchronized (this.f194a) {
            if (f(z00Var) && this.f192a.f8a) {
                this.f192a.f8a = false;
                l(this.f192a);
            }
        }
    }

    public final void l(a10 a10Var) {
        int i = a10Var.f5557a;
        if (i == -2) {
            return;
        }
        if (i <= 0) {
            i = i == -1 ? 1500 : 2750;
        }
        this.f193a.removeCallbacksAndMessages(a10Var);
        Handler handler = this.f193a;
        handler.sendMessageDelayed(Message.obtain(handler, 0, a10Var), i);
    }

    public void m(int i, z00 z00Var) {
        synchronized (this.f194a) {
            if (f(z00Var)) {
                this.f192a.f5557a = i;
                this.f193a.removeCallbacksAndMessages(this.f192a);
                l(this.f192a);
                return;
            }
            if (g(z00Var)) {
                this.b.f5557a = i;
            } else {
                this.b = new a10(i, z00Var);
            }
            if (this.f192a == null || !a(this.f192a, 4)) {
                this.f192a = null;
                n();
            }
        }
    }

    public final void n() {
        a10 a10Var = this.b;
        if (a10Var != null) {
            this.f192a = a10Var;
            this.b = null;
            z00 z00Var = a10Var.f7a.get();
            if (z00Var != null) {
                z00Var.c();
            } else {
                this.f192a = null;
            }
        }
    }
}
