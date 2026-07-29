package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class b extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ActionBarContainer f2364a;

    @g.v0(21)
    public static class a {
        public static void a(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }

    public b(ActionBarContainer actionBarContainer) {
        this.f2364a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f2364a;
        if (actionBarContainer.f2013h) {
            Drawable drawable = actionBarContainer.f2012g;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f2010e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f2364a;
        Drawable drawable3 = actionBarContainer2.f2011f;
        if (drawable3 == null || !actionBarContainer2.f2014i) {
            return;
        }
        drawable3.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    @g.v0(21)
    public void getOutline(@g.n0 Outline outline) {
        ActionBarContainer actionBarContainer = this.f2364a;
        if (actionBarContainer.f2013h) {
            if (actionBarContainer.f2012g != null) {
                a.a(actionBarContainer.f2010e, outline);
            }
        } else {
            Drawable drawable = actionBarContainer.f2010e;
            if (drawable != null) {
                a.a(drawable, outline);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
