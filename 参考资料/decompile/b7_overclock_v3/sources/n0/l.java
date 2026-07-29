package n0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import g.n0;
import g.v0;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@v0(21)
public class l extends k {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f41742h = "WrappedDrawableApi21";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Method f41743i;

    public l(Drawable drawable) {
        super(drawable);
        g();
    }

    @Override // n0.k
    public boolean c() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f41741f;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    public final void g() {
        if (f41743i == null) {
            try {
                f41743i = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    @n0
    public Rect getDirtyBounds() {
        return this.f41741f.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(@n0 Outline outline) {
        this.f41741f.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        Drawable drawable = this.f41741f;
        if (drawable != null && (method = f41743i) != null) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f10, float f11) {
        this.f41741f.setHotspot(f10, f11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i10, int i11, int i12, int i13) {
        this.f41741f.setHotspotBounds(i10, i11, i12, i13);
    }

    @Override // n0.k, android.graphics.drawable.Drawable
    public boolean setState(@n0 int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // n0.k, android.graphics.drawable.Drawable, n0.i
    public void setTint(int i10) {
        if (c()) {
            super.setTint(i10);
        } else {
            this.f41741f.setTint(i10);
        }
    }

    @Override // n0.k, android.graphics.drawable.Drawable, n0.i
    public void setTintList(ColorStateList colorStateList) {
        if (c()) {
            super.setTintList(colorStateList);
        } else {
            this.f41741f.setTintList(colorStateList);
        }
    }

    @Override // n0.k, android.graphics.drawable.Drawable, n0.i
    public void setTintMode(@n0 PorterDuff.Mode mode) {
        if (c()) {
            super.setTintMode(mode);
        } else {
            this.f41741f.setTintMode(mode);
        }
    }

    public l(m mVar, Resources resources) {
        super(mVar, resources);
        g();
    }
}
