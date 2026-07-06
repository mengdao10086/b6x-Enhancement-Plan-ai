package a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class p5 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public m8 f2392a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final View f2394a;
    public m8 b;
    public m8 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7085a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final v5 f2393a = v5.b();

    public p5(View view) {
        this.f2394a = view;
    }

    public final boolean a(Drawable drawable) {
        if (this.c == null) {
            this.c = new m8();
        }
        m8 m8Var = this.c;
        m8Var.a();
        ColorStateList colorStateListP = eh.p(this.f2394a);
        if (colorStateListP != null) {
            m8Var.b = true;
            m8Var.f6781a = colorStateListP;
        }
        PorterDuff.Mode modeQ = eh.q(this.f2394a);
        if (modeQ != null) {
            m8Var.f1905a = true;
            m8Var.f1904a = modeQ;
        }
        if (!m8Var.b && !m8Var.f1905a) {
            return false;
        }
        v5.i(drawable, m8Var, this.f2394a.getDrawableState());
        return true;
    }

    public void b() {
        Drawable background = this.f2394a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            m8 m8Var = this.b;
            if (m8Var != null) {
                v5.i(background, m8Var, this.f2394a.getDrawableState());
                return;
            }
            m8 m8Var2 = this.f2392a;
            if (m8Var2 != null) {
                v5.i(background, m8Var2, this.f2394a.getDrawableState());
            }
        }
    }

    public ColorStateList c() {
        m8 m8Var = this.b;
        if (m8Var != null) {
            return m8Var.f6781a;
        }
        return null;
    }

    public PorterDuff.Mode d() {
        m8 m8Var = this.b;
        if (m8Var != null) {
            return m8Var.f1904a;
        }
        return null;
    }

    public void e(AttributeSet attributeSet, int i) {
        o8 o8VarV = o8.v(this.f2394a.getContext(), attributeSet, c0.ViewBackgroundHelper, i, 0);
        View view = this.f2394a;
        eh.i0(view, view.getContext(), c0.ViewBackgroundHelper, attributeSet, o8VarV.r(), i, 0);
        try {
            if (o8VarV.s(c0.ViewBackgroundHelper_android_background)) {
                this.f7085a = o8VarV.n(c0.ViewBackgroundHelper_android_background, -1);
                ColorStateList colorStateListF = this.f2393a.f(this.f2394a.getContext(), this.f7085a);
                if (colorStateListF != null) {
                    h(colorStateListF);
                }
            }
            if (o8VarV.s(c0.ViewBackgroundHelper_backgroundTint)) {
                eh.n0(this.f2394a, o8VarV.c(c0.ViewBackgroundHelper_backgroundTint));
            }
            if (o8VarV.s(c0.ViewBackgroundHelper_backgroundTintMode)) {
                eh.o0(this.f2394a, e7.d(o8VarV.k(c0.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            o8VarV.w();
        }
    }

    public void f(Drawable drawable) {
        this.f7085a = -1;
        h(null);
        b();
    }

    public void g(int i) {
        this.f7085a = i;
        v5 v5Var = this.f2393a;
        h(v5Var != null ? v5Var.f(this.f2394a.getContext(), i) : null);
        b();
    }

    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f2392a == null) {
                this.f2392a = new m8();
            }
            m8 m8Var = this.f2392a;
            m8Var.f6781a = colorStateList;
            m8Var.b = true;
        } else {
            this.f2392a = null;
        }
        b();
    }

    public void i(ColorStateList colorStateList) {
        if (this.b == null) {
            this.b = new m8();
        }
        m8 m8Var = this.b;
        m8Var.f6781a = colorStateList;
        m8Var.b = true;
        b();
    }

    public void j(PorterDuff.Mode mode) {
        if (this.b == null) {
            this.b = new m8();
        }
        m8 m8Var = this.b;
        m8Var.f1904a = mode;
        m8Var.f1905a = true;
        b();
    }

    public final boolean k() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f2392a != null : i == 21;
    }
}
