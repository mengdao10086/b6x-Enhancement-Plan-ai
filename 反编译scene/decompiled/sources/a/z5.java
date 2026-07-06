package a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class z5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m8 f8037a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImageView f3797a;
    public m8 b;
    public m8 c;

    public z5(ImageView imageView) {
        this.f3797a = imageView;
    }

    public final boolean a(Drawable drawable) {
        if (this.c == null) {
            this.c = new m8();
        }
        m8 m8Var = this.c;
        m8Var.a();
        ColorStateList colorStateListA = ij.a(this.f3797a);
        if (colorStateListA != null) {
            m8Var.b = true;
            m8Var.f6781a = colorStateListA;
        }
        PorterDuff.Mode modeB = ij.b(this.f3797a);
        if (modeB != null) {
            m8Var.f1905a = true;
            m8Var.f1904a = modeB;
        }
        if (!m8Var.b && !m8Var.f1905a) {
            return false;
        }
        v5.i(drawable, m8Var, this.f3797a.getDrawableState());
        return true;
    }

    public void b() {
        Drawable drawable = this.f3797a.getDrawable();
        if (drawable != null) {
            e7.b(drawable);
        }
        if (drawable != null) {
            if (j() && a(drawable)) {
                return;
            }
            m8 m8Var = this.b;
            if (m8Var != null) {
                v5.i(drawable, m8Var, this.f3797a.getDrawableState());
                return;
            }
            m8 m8Var2 = this.f8037a;
            if (m8Var2 != null) {
                v5.i(drawable, m8Var2, this.f3797a.getDrawableState());
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

    public boolean e() {
        return Build.VERSION.SDK_INT < 21 || !(this.f3797a.getBackground() instanceof RippleDrawable);
    }

    public void f(AttributeSet attributeSet, int i) {
        int iN;
        o8 o8VarV = o8.v(this.f3797a.getContext(), attributeSet, c0.AppCompatImageView, i, 0);
        ImageView imageView = this.f3797a;
        eh.i0(imageView, imageView.getContext(), c0.AppCompatImageView, attributeSet, o8VarV.r(), i, 0);
        try {
            Drawable drawable = this.f3797a.getDrawable();
            if (drawable == null && (iN = o8VarV.n(c0.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = r2.d(this.f3797a.getContext(), iN)) != null) {
                this.f3797a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                e7.b(drawable);
            }
            if (o8VarV.s(c0.AppCompatImageView_tint)) {
                ij.c(this.f3797a, o8VarV.c(c0.AppCompatImageView_tint));
            }
            if (o8VarV.s(c0.AppCompatImageView_tintMode)) {
                ij.d(this.f3797a, e7.d(o8VarV.k(c0.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            o8VarV.w();
        }
    }

    public void g(int i) {
        if (i != 0) {
            Drawable drawableD = r2.d(this.f3797a.getContext(), i);
            if (drawableD != null) {
                e7.b(drawableD);
            }
            this.f3797a.setImageDrawable(drawableD);
        } else {
            this.f3797a.setImageDrawable(null);
        }
        b();
    }

    public void h(ColorStateList colorStateList) {
        if (this.b == null) {
            this.b = new m8();
        }
        m8 m8Var = this.b;
        m8Var.f6781a = colorStateList;
        m8Var.b = true;
        b();
    }

    public void i(PorterDuff.Mode mode) {
        if (this.b == null) {
            this.b = new m8();
        }
        m8 m8Var = this.b;
        m8Var.f1904a = mode;
        m8Var.f1905a = true;
        b();
    }

    public final boolean j() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f8037a != null : i == 21;
    }
}
