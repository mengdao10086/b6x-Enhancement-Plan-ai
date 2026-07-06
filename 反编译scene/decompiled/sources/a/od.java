package a;

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
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class od extends nd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f7007a;

    public od(pd pdVar, Resources resources) {
        super(pdVar, resources);
        g();
    }

    public od(Drawable drawable) {
        super(drawable);
        g();
    }

    @Override // a.nd
    public boolean c() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = ((nd) this).f2077a;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    public final void g() {
        if (f7007a == null) {
            try {
                f7007a = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return ((nd) this).f2077a.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        ((nd) this).f2077a.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Method method;
        Drawable drawable = ((nd) this).f2077a;
        if (drawable != null && (method = f7007a) != null) {
            try {
                return ((Boolean) method.invoke(drawable, new Object[0])).booleanValue();
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Error calling Drawable#isProjected() method", e);
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        ((nd) this).f2077a.setHotspot(f, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        ((nd) this).f2077a.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // a.nd, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // a.nd, android.graphics.drawable.Drawable, a.ld
    public void setTint(int i) {
        if (c()) {
            super.setTint(i);
        } else {
            ((nd) this).f2077a.setTint(i);
        }
    }

    @Override // a.nd, android.graphics.drawable.Drawable, a.ld
    public void setTintList(ColorStateList colorStateList) {
        if (c()) {
            super.setTintList(colorStateList);
        } else {
            ((nd) this).f2077a.setTintList(colorStateList);
        }
    }

    @Override // a.nd, android.graphics.drawable.Drawable, a.ld
    public void setTintMode(PorterDuff.Mode mode) {
        if (c()) {
            super.setTintMode(mode);
        } else {
            ((nd) this).f2077a.setTintMode(mode);
        }
    }
}
