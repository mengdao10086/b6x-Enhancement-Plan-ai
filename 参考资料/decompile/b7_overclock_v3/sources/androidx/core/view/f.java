package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f4867a = 3840;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f4868b = 2160;

    @g.v0(17)
    public static class a {
        public static void a(Display display, Point point) {
            display.getRealSize(point);
        }
    }

    @g.v0(23)
    public static class b {
        @g.n0
        public static c a(@g.n0 Context context, @g.n0 Display display) {
            Display.Mode mode = display.getMode();
            Point pointA = f.a(context, display);
            return (pointA == null || d(mode, pointA)) ? new c(mode, true) : new c(mode, pointA);
        }

        @SuppressLint({"ArrayReturn"})
        @g.n0
        public static c[] b(@g.n0 Context context, @g.n0 Display display) {
            Display.Mode[] supportedModes = display.getSupportedModes();
            c[] cVarArr = new c[supportedModes.length];
            Display.Mode mode = display.getMode();
            Point pointA = f.a(context, display);
            if (pointA == null || d(mode, pointA)) {
                for (int i10 = 0; i10 < supportedModes.length; i10++) {
                    cVarArr[i10] = new c(supportedModes[i10], e(supportedModes[i10], mode));
                }
            } else {
                for (int i11 = 0; i11 < supportedModes.length; i11++) {
                    cVarArr[i11] = e(supportedModes[i11], mode) ? new c(supportedModes[i11], pointA) : new c(supportedModes[i11], false);
                }
            }
            return cVarArr;
        }

        public static boolean c(@g.n0 Display display) {
            Display.Mode mode = display.getMode();
            for (Display.Mode mode2 : display.getSupportedModes()) {
                if (mode.getPhysicalHeight() < mode2.getPhysicalHeight() || mode.getPhysicalWidth() < mode2.getPhysicalWidth()) {
                    return false;
                }
            }
            return true;
        }

        public static boolean d(Display.Mode mode, Point point) {
            return (mode.getPhysicalWidth() == point.x && mode.getPhysicalHeight() == point.y) || (mode.getPhysicalWidth() == point.y && mode.getPhysicalHeight() == point.x);
        }

        public static boolean e(Display.Mode mode, Display.Mode mode2) {
            return mode.getPhysicalWidth() == mode2.getPhysicalWidth() && mode.getPhysicalHeight() == mode2.getPhysicalHeight();
        }
    }

    public static Point a(@g.n0 Context context, @g.n0 Display display) {
        Point pointJ = Build.VERSION.SDK_INT < 28 ? j("sys.display-size", display) : j("vendor.display-size", display);
        if (pointJ != null) {
            return pointJ;
        }
        if (g(context) && f(display)) {
            return new Point(3840, f4868b);
        }
        return null;
    }

    @g.n0
    public static Point b(@g.n0 Context context, @g.n0 Display display) {
        Point pointA = a(context, display);
        if (pointA != null) {
            return pointA;
        }
        Point point = new Point();
        a.a(display, point);
        return point;
    }

    @g.n0
    public static c c(@g.n0 Context context, @g.n0 Display display) {
        return Build.VERSION.SDK_INT >= 23 ? b.a(context, display) : new c(b(context, display));
    }

    @SuppressLint({"ArrayReturn"})
    @g.n0
    public static c[] d(@g.n0 Context context, @g.n0 Display display) {
        return Build.VERSION.SDK_INT >= 23 ? b.b(context, display) : new c[]{c(context, display)};
    }

    @g.p0
    public static String e(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean f(@g.n0 Display display) {
        if (Build.VERSION.SDK_INT >= 23) {
            return b.c(display);
        }
        return true;
    }

    public static boolean g(@g.n0 Context context) {
        return h(context) && "Sony".equals(Build.MANUFACTURER) && Build.MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd");
    }

    public static boolean h(@g.n0 Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static Point i(@g.n0 String str) throws NumberFormatException {
        String[] strArrSplit = str.trim().split("x", -1);
        if (strArrSplit.length == 2) {
            int i10 = Integer.parseInt(strArrSplit[0]);
            int i11 = Integer.parseInt(strArrSplit[1]);
            if (i10 > 0 && i11 > 0) {
                return new Point(i10, i11);
            }
        }
        throw new NumberFormatException();
    }

    @g.p0
    public static Point j(@g.n0 String str, @g.n0 Display display) {
        if (display.getDisplayId() != 0) {
            return null;
        }
        String strE = e(str);
        if (!TextUtils.isEmpty(strE) && strE != null) {
            try {
                return i(strE);
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Display.Mode f4869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Point f4870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f4871c;

        @g.v0(23)
        public static class a {
            @g.u
            public static int a(Display.Mode mode) {
                return mode.getPhysicalHeight();
            }

            @g.u
            public static int b(Display.Mode mode) {
                return mode.getPhysicalWidth();
            }
        }

        public c(@g.n0 Point point) {
            androidx.core.util.o.m(point, "physicalSize == null");
            this.f4870b = point;
            this.f4869a = null;
            this.f4871c = true;
        }

        public int a() {
            return this.f4870b.y;
        }

        public int b() {
            return this.f4870b.x;
        }

        @Deprecated
        public boolean c() {
            return this.f4871c;
        }

        @g.p0
        @g.v0(23)
        public Display.Mode d() {
            return this.f4869a;
        }

        @g.v0(23)
        public c(@g.n0 Display.Mode mode, boolean z10) {
            androidx.core.util.o.m(mode, "mode == null, can't wrap a null reference");
            this.f4870b = new Point(a.b(mode), a.a(mode));
            this.f4869a = mode;
            this.f4871c = z10;
        }

        @g.v0(23)
        public c(@g.n0 Display.Mode mode, @g.n0 Point point) {
            androidx.core.util.o.m(mode, "mode == null, can't wrap a null reference");
            androidx.core.util.o.m(point, "physicalSize == null");
            this.f4870b = point;
            this.f4869a = mode;
            this.f4871c = true;
        }
    }
}
