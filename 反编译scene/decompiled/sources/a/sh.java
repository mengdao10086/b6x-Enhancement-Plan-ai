package a;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class sh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sh f7396a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ci f2893a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final wh f7397a;

        public a() {
            int i = Build.VERSION.SDK_INT;
            this.f7397a = i >= 30 ? new vh() : i >= 29 ? new uh() : i >= 20 ? new th() : new wh();
        }

        public a(sh shVar) {
            int i = Build.VERSION.SDK_INT;
            this.f7397a = i >= 30 ? new vh(shVar) : i >= 29 ? new uh(shVar) : i >= 20 ? new th(shVar) : new wh(shVar);
        }

        public sh a() {
            return this.f7397a.b();
        }

        @Deprecated
        public a b(uc ucVar) {
            this.f7397a.d(ucVar);
            return this;
        }

        @Deprecated
        public a c(uc ucVar) {
            this.f7397a.f(ucVar);
            return this;
        }
    }

    static {
        f7396a = Build.VERSION.SDK_INT >= 30 ? bi.d : ci.b;
    }

    public sh(sh shVar) {
        if (shVar == null) {
            this.f2893a = new ci(this);
            return;
        }
        ci ciVar = shVar.f2893a;
        this.f2893a = (Build.VERSION.SDK_INT < 30 || !(ciVar instanceof bi)) ? (Build.VERSION.SDK_INT < 29 || !(ciVar instanceof ai)) ? (Build.VERSION.SDK_INT < 28 || !(ciVar instanceof zh)) ? (Build.VERSION.SDK_INT < 21 || !(ciVar instanceof yh)) ? (Build.VERSION.SDK_INT < 20 || !(ciVar instanceof xh)) ? new ci(this) : new xh(this, (xh) ciVar) : new yh(this, (yh) ciVar) : new zh(this, (zh) ciVar) : new ai(this, (ai) ciVar) : new bi(this, (bi) ciVar);
        ciVar.e(this);
    }

    public sh(WindowInsets windowInsets) {
        ci xhVar;
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            xhVar = new bi(this, windowInsets);
        } else if (i >= 29) {
            xhVar = new ai(this, windowInsets);
        } else if (i >= 28) {
            xhVar = new zh(this, windowInsets);
        } else if (i >= 21) {
            xhVar = new yh(this, windowInsets);
        } else {
            if (i < 20) {
                this.f2893a = new ci(this);
                return;
            }
            xhVar = new xh(this, windowInsets);
        }
        this.f2893a = xhVar;
    }

    public static uc k(uc ucVar, int i, int i2, int i3, int i4) {
        int iMax = Math.max(0, ucVar.f3164a - i);
        int iMax2 = Math.max(0, ucVar.b - i2);
        int iMax3 = Math.max(0, ucVar.c - i3);
        int iMax4 = Math.max(0, ucVar.d - i4);
        return (iMax == i && iMax2 == i2 && iMax3 == i3 && iMax4 == i4) ? ucVar : uc.b(iMax, iMax2, iMax3, iMax4);
    }

    public static sh s(WindowInsets windowInsets) {
        return t(windowInsets, null);
    }

    public static sh t(WindowInsets windowInsets, View view) {
        pf.b(windowInsets);
        sh shVar = new sh(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            shVar.p(eh.F(view));
            shVar.d(view.getRootView());
        }
        return shVar;
    }

    @Deprecated
    public sh a() {
        return this.f2893a.a();
    }

    @Deprecated
    public sh b() {
        return this.f2893a.b();
    }

    @Deprecated
    public sh c() {
        return this.f2893a.c();
    }

    public void d(View view) {
        this.f2893a.d(view);
    }

    @Deprecated
    public uc e() {
        return this.f2893a.g();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof sh) {
            return kf.a(this.f2893a, ((sh) obj).f2893a);
        }
        return false;
    }

    @Deprecated
    public int f() {
        return this.f2893a.i().d;
    }

    @Deprecated
    public int g() {
        return this.f2893a.i().f3164a;
    }

    @Deprecated
    public int h() {
        return this.f2893a.i().c;
    }

    public int hashCode() {
        ci ciVar = this.f2893a;
        if (ciVar == null) {
            return 0;
        }
        return ciVar.hashCode();
    }

    @Deprecated
    public int i() {
        return this.f2893a.i().b;
    }

    public sh j(int i, int i2, int i3, int i4) {
        return this.f2893a.j(i, i2, i3, i4);
    }

    public boolean l() {
        return this.f2893a.k();
    }

    @Deprecated
    public sh m(int i, int i2, int i3, int i4) {
        a aVar = new a(this);
        aVar.c(uc.b(i, i2, i3, i4));
        return aVar.a();
    }

    public void n(uc[] ucVarArr) {
        this.f2893a.m(ucVarArr);
    }

    public void o(uc ucVar) {
        this.f2893a.n(ucVar);
    }

    public void p(sh shVar) {
        this.f2893a.o(shVar);
    }

    public void q(uc ucVar) {
        this.f2893a.p(ucVar);
    }

    public WindowInsets r() {
        ci ciVar = this.f2893a;
        if (ciVar instanceof xh) {
            return ((xh) ciVar).f3589a;
        }
        return null;
    }
}
