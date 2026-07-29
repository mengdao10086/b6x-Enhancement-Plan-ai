package androidx.core.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5137a = "ViewConfigCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f5138b;

    @g.v0(26)
    public static class a {
        @g.u
        public static float a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }

        @g.u
        public static float b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
    }

    @g.v0(28)
    public static class b {
        @g.u
        public static int a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHoverSlop();
        }

        @g.u
        public static boolean b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    static {
        if (Build.VERSION.SDK_INT == 25) {
            try {
                f5138b = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
            } catch (Exception unused) {
            }
        }
    }

    public static float a(ViewConfiguration viewConfiguration, Context context) {
        Method method;
        if (Build.VERSION.SDK_INT >= 25 && (method = f5138b) != null) {
            try {
                return ((Integer) method.invoke(viewConfiguration, new Object[0])).intValue();
            } catch (Exception unused) {
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static float b(@g.n0 ViewConfiguration viewConfiguration, @g.n0 Context context) {
        return Build.VERSION.SDK_INT >= 26 ? a.a(viewConfiguration) : a(viewConfiguration, context);
    }

    public static int c(@g.n0 ViewConfiguration viewConfiguration) {
        return Build.VERSION.SDK_INT >= 28 ? b.a(viewConfiguration) : viewConfiguration.getScaledTouchSlop() / 2;
    }

    @Deprecated
    public static int d(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledPagingTouchSlop();
    }

    public static float e(@g.n0 ViewConfiguration viewConfiguration, @g.n0 Context context) {
        return Build.VERSION.SDK_INT >= 26 ? a.b(viewConfiguration) : a(viewConfiguration, context);
    }

    @Deprecated
    public static boolean f(ViewConfiguration viewConfiguration) {
        return viewConfiguration.hasPermanentMenuKey();
    }

    public static boolean g(@g.n0 ViewConfiguration viewConfiguration, @g.n0 Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return b.b(viewConfiguration);
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", l4.f.f39447b);
        return identifier != 0 && resources.getBoolean(identifier);
    }
}
