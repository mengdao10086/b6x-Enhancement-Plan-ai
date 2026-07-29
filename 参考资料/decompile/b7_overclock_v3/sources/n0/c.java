package n0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import g.n0;
import g.p0;
import g.u;
import g.v0;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41715a = "DrawableCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f41716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f41717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f41718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f41719e;

    @v0(19)
    public static class a {
        @u
        public static int a(Drawable drawable) {
            return drawable.getAlpha();
        }

        @u
        public static Drawable b(DrawableContainer.DrawableContainerState drawableContainerState, int i10) {
            return drawableContainerState.getChild(i10);
        }

        @u
        public static Drawable c(InsetDrawable insetDrawable) {
            return insetDrawable.getDrawable();
        }

        @u
        public static boolean d(Drawable drawable) {
            return drawable.isAutoMirrored();
        }

        @u
        public static void e(Drawable drawable, boolean z10) {
            drawable.setAutoMirrored(z10);
        }
    }

    @v0(21)
    public static class b {
        @u
        public static void a(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        @u
        public static boolean b(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        @u
        public static ColorFilter c(Drawable drawable) {
            return drawable.getColorFilter();
        }

        @u
        public static void d(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        @u
        public static void e(Drawable drawable, float f10, float f11) {
            drawable.setHotspot(f10, f11);
        }

        @u
        public static void f(Drawable drawable, int i10, int i11, int i12, int i13) {
            drawable.setHotspotBounds(i10, i11, i12, i13);
        }

        @u
        public static void g(Drawable drawable, int i10) {
            drawable.setTint(i10);
        }

        @u
        public static void h(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        @u
        public static void i(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }
    }

    /* JADX INFO: renamed from: n0.c$c, reason: collision with other inner class name */
    @v0(23)
    public static class C0460c {
        @u
        public static int a(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        @u
        public static boolean b(Drawable drawable, int i10) {
            return drawable.setLayoutDirection(i10);
        }
    }

    public static void a(@n0 Drawable drawable, @n0 Resources.Theme theme) {
        b.a(drawable, theme);
    }

    public static boolean b(@n0 Drawable drawable) {
        return b.b(drawable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(@n0 Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        if (Build.VERSION.SDK_INT >= 23) {
            drawable.clearColorFilter();
            return;
        }
        drawable.clearColorFilter();
        if (drawable instanceof InsetDrawable) {
            c(a.c((InsetDrawable) drawable));
            return;
        }
        if (drawable instanceof j) {
            c(((j) drawable).b());
            return;
        }
        if (!(drawable instanceof DrawableContainer) || (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) == null) {
            return;
        }
        int childCount = drawableContainerState.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            Drawable drawableB = a.b(drawableContainerState, i10);
            if (drawableB != null) {
                c(drawableB);
            }
        }
    }

    public static int d(@n0 Drawable drawable) {
        return a.a(drawable);
    }

    @p0
    public static ColorFilter e(@n0 Drawable drawable) {
        return b.c(drawable);
    }

    public static int f(@n0 Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return C0460c.a(drawable);
        }
        if (!f41719e) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f41718d = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f41719e = true;
        }
        Method method = f41718d;
        if (method != null) {
            try {
                return ((Integer) method.invoke(drawable, new Object[0])).intValue();
            } catch (Exception unused2) {
                f41718d = null;
            }
        }
        return 0;
    }

    public static void g(@n0 Drawable drawable, @n0 Resources resources, @n0 XmlPullParser xmlPullParser, @n0 AttributeSet attributeSet, @p0 Resources.Theme theme) throws XmlPullParserException, IOException {
        b.d(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static boolean h(@n0 Drawable drawable) {
        return a.d(drawable);
    }

    @Deprecated
    public static void i(@n0 Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void j(@n0 Drawable drawable, boolean z10) {
        a.e(drawable, z10);
    }

    public static void k(@n0 Drawable drawable, float f10, float f11) {
        b.e(drawable, f10, f11);
    }

    public static void l(@n0 Drawable drawable, int i10, int i11, int i12, int i13) {
        b.f(drawable, i10, i11, i12, i13);
    }

    public static boolean m(@n0 Drawable drawable, int i10) {
        if (Build.VERSION.SDK_INT >= 23) {
            return C0460c.b(drawable, i10);
        }
        if (!f41717c) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                f41716b = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f41717c = true;
        }
        Method method = f41716b;
        if (method != null) {
            try {
                method.invoke(drawable, Integer.valueOf(i10));
                return true;
            } catch (Exception unused2) {
                f41716b = null;
            }
        }
        return false;
    }

    public static void n(@n0 Drawable drawable, @g.l int i10) {
        b.g(drawable, i10);
    }

    public static void o(@n0 Drawable drawable, @p0 ColorStateList colorStateList) {
        b.h(drawable, colorStateList);
    }

    public static void p(@n0 Drawable drawable, @p0 PorterDuff.Mode mode) {
        b.i(drawable, mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T q(@n0 Drawable drawable) {
        return drawable instanceof j ? (T) ((j) drawable).b() : drawable;
    }

    @n0
    public static Drawable r(@n0 Drawable drawable) {
        return (Build.VERSION.SDK_INT < 23 && !(drawable instanceof i)) ? new l(drawable) : drawable;
    }
}
