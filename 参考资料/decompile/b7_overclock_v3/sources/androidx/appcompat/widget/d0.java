package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f2404a = {R.attr.state_checked};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f2405b = new int[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Rect f2406c = new Rect();

    @g.v0(18)
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final boolean f2407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Method f2408b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Field f2409c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Field f2410d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Field f2411e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Field f2412f;

        /* JADX WARN: Removed duplicated region for block: B:25:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0058  */
        static {
            /*
                r0 = 1
                r1 = 0
                r2 = 0
                java.lang.String r3 = "android.graphics.Insets"
                java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.NoSuchFieldException -> L3b java.lang.ClassNotFoundException -> L3f java.lang.NoSuchMethodException -> L43
                java.lang.Class<android.graphics.drawable.Drawable> r4 = android.graphics.drawable.Drawable.class
                java.lang.String r5 = "getOpticalInsets"
                java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch: java.lang.NoSuchFieldException -> L3b java.lang.ClassNotFoundException -> L3f java.lang.NoSuchMethodException -> L43
                java.lang.reflect.Method r4 = r4.getMethod(r5, r6)     // Catch: java.lang.NoSuchFieldException -> L3b java.lang.ClassNotFoundException -> L3f java.lang.NoSuchMethodException -> L43
                java.lang.String r5 = "left"
                java.lang.reflect.Field r5 = r3.getField(r5)     // Catch: java.lang.NoSuchFieldException -> L35 java.lang.ClassNotFoundException -> L37 java.lang.NoSuchMethodException -> L39
                java.lang.String r6 = "top"
                java.lang.reflect.Field r6 = r3.getField(r6)     // Catch: java.lang.NoSuchFieldException -> L2f java.lang.ClassNotFoundException -> L31 java.lang.NoSuchMethodException -> L33
                java.lang.String r7 = "right"
                java.lang.reflect.Field r7 = r3.getField(r7)     // Catch: java.lang.Throwable -> L2d
                java.lang.String r8 = "bottom"
                java.lang.reflect.Field r3 = r3.getField(r8)     // Catch: java.lang.Throwable -> L47
                r8 = 1
                goto L49
            L2d:
                r7 = r2
                goto L47
            L2f:
                r6 = r2
                goto L46
            L31:
                r6 = r2
                goto L46
            L33:
                r6 = r2
                goto L46
            L35:
                r5 = r2
                goto L3d
            L37:
                r5 = r2
                goto L41
            L39:
                r5 = r2
                goto L45
            L3b:
                r4 = r2
                r5 = r4
            L3d:
                r6 = r5
                goto L46
            L3f:
                r4 = r2
                r5 = r4
            L41:
                r6 = r5
                goto L46
            L43:
                r4 = r2
                r5 = r4
            L45:
                r6 = r5
            L46:
                r7 = r6
            L47:
                r3 = r2
                r8 = 0
            L49:
                if (r8 == 0) goto L58
                androidx.appcompat.widget.d0.a.f2408b = r4
                androidx.appcompat.widget.d0.a.f2409c = r5
                androidx.appcompat.widget.d0.a.f2410d = r6
                androidx.appcompat.widget.d0.a.f2411e = r7
                androidx.appcompat.widget.d0.a.f2412f = r3
                androidx.appcompat.widget.d0.a.f2407a = r0
                goto L64
            L58:
                androidx.appcompat.widget.d0.a.f2408b = r2
                androidx.appcompat.widget.d0.a.f2409c = r2
                androidx.appcompat.widget.d0.a.f2410d = r2
                androidx.appcompat.widget.d0.a.f2411e = r2
                androidx.appcompat.widget.d0.a.f2412f = r2
                androidx.appcompat.widget.d0.a.f2407a = r1
            L64:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.d0.a.<clinit>():void");
        }

        @g.n0
        public static Rect a(@g.n0 Drawable drawable) {
            if (Build.VERSION.SDK_INT < 29 && f2407a) {
                try {
                    Object objInvoke = f2408b.invoke(drawable, new Object[0]);
                    if (objInvoke != null) {
                        return new Rect(f2409c.getInt(objInvoke), f2410d.getInt(objInvoke), f2411e.getInt(objInvoke), f2412f.getInt(objInvoke));
                    }
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
            return d0.f2406c;
        }
    }

    @g.v0(29)
    public static class b {
        @g.u
        public static Insets a(Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }

    public static boolean a(@g.n0 Drawable drawable) {
        return true;
    }

    public static void b(@g.n0 Drawable drawable) {
        String name = drawable.getClass().getName();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 == 21 && n0.f2603l.equals(name)) {
            c(drawable);
        } else {
            if (i10 < 29 || i10 >= 31 || !"android.graphics.drawable.ColorStateListDrawable".equals(name)) {
                return;
            }
            c(drawable);
        }
    }

    public static void c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f2404a);
        } else {
            drawable.setState(f2405b);
        }
        drawable.setState(state);
    }

    @g.n0
    public static Rect d(@g.n0 Drawable drawable) {
        if (Build.VERSION.SDK_INT < 29) {
            return a.a(n0.c.q(drawable));
        }
        Insets insetsA = b.a(drawable);
        return new Rect(insetsA.left, insetsA.top, insetsA.right, insetsA.bottom);
    }

    public static PorterDuff.Mode e(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
