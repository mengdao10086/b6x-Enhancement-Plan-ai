package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final View f2414a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public w0 f2417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public w0 f2418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public w0 f2419f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2416c = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f2415b = i.b();

    public e(@g.n0 View view) {
        this.f2414a = view;
    }

    public final boolean a(@g.n0 Drawable drawable) {
        if (this.f2419f == null) {
            this.f2419f = new w0();
        }
        w0 w0Var = this.f2419f;
        w0Var.a();
        ColorStateList colorStateListN = androidx.core.view.u0.N(this.f2414a);
        if (colorStateListN != null) {
            w0Var.f2729d = true;
            w0Var.f2726a = colorStateListN;
        }
        PorterDuff.Mode modeO = androidx.core.view.u0.O(this.f2414a);
        if (modeO != null) {
            w0Var.f2728c = true;
            w0Var.f2727b = modeO;
        }
        if (!w0Var.f2729d && !w0Var.f2728c) {
            return false;
        }
        i.j(drawable, w0Var, this.f2414a.getDrawableState());
        return true;
    }

    public void b() {
        Drawable background = this.f2414a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            w0 w0Var = this.f2418e;
            if (w0Var != null) {
                i.j(background, w0Var, this.f2414a.getDrawableState());
                return;
            }
            w0 w0Var2 = this.f2417d;
            if (w0Var2 != null) {
                i.j(background, w0Var2, this.f2414a.getDrawableState());
            }
        }
    }

    public ColorStateList c() {
        w0 w0Var = this.f2418e;
        if (w0Var != null) {
            return w0Var.f2726a;
        }
        return null;
    }

    public PorterDuff.Mode d() {
        w0 w0Var = this.f2418e;
        if (w0Var != null) {
            return w0Var.f2727b;
        }
        return null;
    }

    public void e(@g.p0 AttributeSet attributeSet, int i10) {
        Context context = this.f2414a.getContext();
        int[] iArr = R.styleable.ViewBackgroundHelper;
        y0 y0VarG = y0.G(context, attributeSet, iArr, i10, 0);
        View view = this.f2414a;
        androidx.core.view.u0.z1(view, view.getContext(), iArr, attributeSet, y0VarG.B(), i10, 0);
        try {
            int i11 = R.styleable.ViewBackgroundHelper_android_background;
            if (y0VarG.C(i11)) {
                this.f2416c = y0VarG.u(i11, -1);
                ColorStateList colorStateListF = this.f2415b.f(this.f2414a.getContext(), this.f2416c);
                if (colorStateListF != null) {
                    h(colorStateListF);
                }
            }
            int i12 = R.styleable.ViewBackgroundHelper_backgroundTint;
            if (y0VarG.C(i12)) {
                androidx.core.view.u0.J1(this.f2414a, y0VarG.d(i12));
            }
            int i13 = R.styleable.ViewBackgroundHelper_backgroundTintMode;
            if (y0VarG.C(i13)) {
                androidx.core.view.u0.K1(this.f2414a, d0.e(y0VarG.o(i13, -1), null));
            }
        } finally {
            y0VarG.I();
        }
    }

    public void f(Drawable drawable) {
        this.f2416c = -1;
        h(null);
        b();
    }

    public void g(int i10) {
        this.f2416c = i10;
        i iVar = this.f2415b;
        h(iVar != null ? iVar.f(this.f2414a.getContext(), i10) : null);
        b();
    }

    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f2417d == null) {
                this.f2417d = new w0();
            }
            w0 w0Var = this.f2417d;
            w0Var.f2726a = colorStateList;
            w0Var.f2729d = true;
        } else {
            this.f2417d = null;
        }
        b();
    }

    public void i(ColorStateList colorStateList) {
        if (this.f2418e == null) {
            this.f2418e = new w0();
        }
        w0 w0Var = this.f2418e;
        w0Var.f2726a = colorStateList;
        w0Var.f2729d = true;
        b();
    }

    public void j(PorterDuff.Mode mode) {
        if (this.f2418e == null) {
            this.f2418e = new w0();
        }
        w0 w0Var = this.f2418e;
        w0Var.f2727b = mode;
        w0Var.f2728c = true;
        b();
    }

    public final boolean k() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 > 21 ? this.f2417d != null : i10 == 21;
    }
}
