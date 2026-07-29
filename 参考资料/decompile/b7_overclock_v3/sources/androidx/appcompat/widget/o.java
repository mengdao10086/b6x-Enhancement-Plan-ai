package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final ImageView f2613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w0 f2614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w0 f2615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public w0 f2616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2617e = 0;

    public o(@g.n0 ImageView imageView) {
        this.f2613a = imageView;
    }

    public final boolean a(@g.n0 Drawable drawable) {
        if (this.f2616d == null) {
            this.f2616d = new w0();
        }
        w0 w0Var = this.f2616d;
        w0Var.a();
        ColorStateList colorStateListA = androidx.core.widget.k.a(this.f2613a);
        if (colorStateListA != null) {
            w0Var.f2729d = true;
            w0Var.f2726a = colorStateListA;
        }
        PorterDuff.Mode modeB = androidx.core.widget.k.b(this.f2613a);
        if (modeB != null) {
            w0Var.f2728c = true;
            w0Var.f2727b = modeB;
        }
        if (!w0Var.f2729d && !w0Var.f2728c) {
            return false;
        }
        i.j(drawable, w0Var, this.f2613a.getDrawableState());
        return true;
    }

    public void b() {
        if (this.f2613a.getDrawable() != null) {
            this.f2613a.getDrawable().setLevel(this.f2617e);
        }
    }

    public void c() {
        Drawable drawable = this.f2613a.getDrawable();
        if (drawable != null) {
            d0.b(drawable);
        }
        if (drawable != null) {
            if (m() && a(drawable)) {
                return;
            }
            w0 w0Var = this.f2615c;
            if (w0Var != null) {
                i.j(drawable, w0Var, this.f2613a.getDrawableState());
                return;
            }
            w0 w0Var2 = this.f2614b;
            if (w0Var2 != null) {
                i.j(drawable, w0Var2, this.f2613a.getDrawableState());
            }
        }
    }

    public ColorStateList d() {
        w0 w0Var = this.f2615c;
        if (w0Var != null) {
            return w0Var.f2726a;
        }
        return null;
    }

    public PorterDuff.Mode e() {
        w0 w0Var = this.f2615c;
        if (w0Var != null) {
            return w0Var.f2727b;
        }
        return null;
    }

    public boolean f() {
        return !(this.f2613a.getBackground() instanceof RippleDrawable);
    }

    public void g(AttributeSet attributeSet, int i10) {
        int iU;
        Context context = this.f2613a.getContext();
        int[] iArr = R.styleable.AppCompatImageView;
        y0 y0VarG = y0.G(context, attributeSet, iArr, i10, 0);
        ImageView imageView = this.f2613a;
        androidx.core.view.u0.z1(imageView, imageView.getContext(), iArr, attributeSet, y0VarG.B(), i10, 0);
        try {
            Drawable drawable = this.f2613a.getDrawable();
            if (drawable == null && (iU = y0VarG.u(R.styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = i.a.b(this.f2613a.getContext(), iU)) != null) {
                this.f2613a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                d0.b(drawable);
            }
            int i11 = R.styleable.AppCompatImageView_tint;
            if (y0VarG.C(i11)) {
                androidx.core.widget.k.c(this.f2613a, y0VarG.d(i11));
            }
            int i12 = R.styleable.AppCompatImageView_tintMode;
            if (y0VarG.C(i12)) {
                androidx.core.widget.k.d(this.f2613a, d0.e(y0VarG.o(i12, -1), null));
            }
        } finally {
            y0VarG.I();
        }
    }

    public void h(@g.n0 Drawable drawable) {
        this.f2617e = drawable.getLevel();
    }

    public void i(int i10) {
        if (i10 != 0) {
            Drawable drawableB = i.a.b(this.f2613a.getContext(), i10);
            if (drawableB != null) {
                d0.b(drawableB);
            }
            this.f2613a.setImageDrawable(drawableB);
        } else {
            this.f2613a.setImageDrawable(null);
        }
        c();
    }

    public void j(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f2614b == null) {
                this.f2614b = new w0();
            }
            w0 w0Var = this.f2614b;
            w0Var.f2726a = colorStateList;
            w0Var.f2729d = true;
        } else {
            this.f2614b = null;
        }
        c();
    }

    public void k(ColorStateList colorStateList) {
        if (this.f2615c == null) {
            this.f2615c = new w0();
        }
        w0 w0Var = this.f2615c;
        w0Var.f2726a = colorStateList;
        w0Var.f2729d = true;
        c();
    }

    public void l(PorterDuff.Mode mode) {
        if (this.f2615c == null) {
            this.f2615c = new w0();
        }
        w0 w0Var = this.f2615c;
        w0Var.f2727b = mode;
        w0Var.f2728c = true;
        c();
    }

    public final boolean m() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 > 21 ? this.f2614b != null : i10 == 21;
    }
}
