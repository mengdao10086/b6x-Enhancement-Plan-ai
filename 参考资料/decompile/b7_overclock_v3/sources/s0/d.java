package s0;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import g.n0;
import g.p0;
import g.v0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f49328a = "mockLocation";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f49329b = "verticalAccuracy";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f49330c = "speedAccuracy";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f49331d = "bearingAccuracy";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f49332e = "androidx.core.location.extra.MSL_ALTITUDE";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f49333f = "androidx.core.location.extra.MSL_ALTITUDE_ACCURACY";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public static Method f49334g;

    @v0(17)
    public static class a {
        @g.u
        public static long a(Location location) {
            return location.getElapsedRealtimeNanos();
        }
    }

    @v0(18)
    public static class b {
        @g.u
        public static boolean a(Location location) {
            return location.isFromMockProvider();
        }
    }

    @v0(26)
    public static class c {
        @g.u
        public static float a(Location location) {
            return location.getBearingAccuracyDegrees();
        }

        @g.u
        public static float b(Location location) {
            return location.getSpeedAccuracyMetersPerSecond();
        }

        @g.u
        public static float c(Location location) {
            return location.getVerticalAccuracyMeters();
        }

        @g.u
        public static boolean d(Location location) {
            return location.hasBearingAccuracy();
        }

        @g.u
        public static boolean e(Location location) {
            return location.hasSpeedAccuracy();
        }

        @g.u
        public static boolean f(Location location) {
            return location.hasVerticalAccuracy();
        }

        @g.u
        public static void g(Location location, float f10) {
            location.setBearingAccuracyDegrees(f10);
        }

        @g.u
        public static void h(Location location, float f10) {
            location.setSpeedAccuracyMetersPerSecond(f10);
        }

        @g.u
        public static void i(Location location, float f10) {
            location.setVerticalAccuracyMeters(f10);
        }
    }

    public static boolean a(@n0 Location location, String str) {
        Bundle extras = location.getExtras();
        return extras != null && extras.containsKey(str);
    }

    public static float b(@n0 Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return c.a(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(f49331d, 0.0f);
    }

    public static long c(@n0 Location location) {
        return TimeUnit.NANOSECONDS.toMillis(a.a(location));
    }

    public static long d(@n0 Location location) {
        return a.a(location);
    }

    @g.x(from = 0.0d)
    public static float e(@n0 Location location) {
        androidx.core.util.o.o(m(location), "The Mean Sea Level altitude accuracy of the location is not set.");
        return g(location).getFloat(f49333f);
    }

    public static double f(@n0 Location location) {
        androidx.core.util.o.o(l(location), "The Mean Sea Level altitude of the location is not set.");
        return g(location).getDouble(f49332e);
    }

    public static Bundle g(@n0 Location location) {
        Bundle extras = location.getExtras();
        if (extras != null) {
            return extras;
        }
        location.setExtras(new Bundle());
        return location.getExtras();
    }

    public static Method h() throws NoSuchMethodException {
        if (f49334g == null) {
            Method declaredMethod = Location.class.getDeclaredMethod("setIsFromMockProvider", Boolean.TYPE);
            f49334g = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        return f49334g;
    }

    public static float i(@n0 Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return c.b(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(f49330c, 0.0f);
    }

    public static float j(@n0 Location location) {
        if (Build.VERSION.SDK_INT >= 26) {
            return c.c(location);
        }
        Bundle extras = location.getExtras();
        if (extras == null) {
            return 0.0f;
        }
        return extras.getFloat(f49329b, 0.0f);
    }

    public static boolean k(@n0 Location location) {
        return Build.VERSION.SDK_INT >= 26 ? c.d(location) : a(location, f49331d);
    }

    public static boolean l(@n0 Location location) {
        return a(location, f49332e);
    }

    public static boolean m(@n0 Location location) {
        return a(location, f49333f);
    }

    public static boolean n(@n0 Location location) {
        return Build.VERSION.SDK_INT >= 26 ? c.e(location) : a(location, f49330c);
    }

    public static boolean o(@n0 Location location) {
        return Build.VERSION.SDK_INT >= 26 ? c.f(location) : a(location, f49329b);
    }

    public static boolean p(@n0 Location location) {
        return b.a(location);
    }

    public static void q(@n0 Location location, String str) {
        Bundle extras = location.getExtras();
        if (extras != null) {
            extras.remove(str);
            if (extras.isEmpty()) {
                location.setExtras(null);
            }
        }
    }

    public static void r(@n0 Location location) {
        q(location, f49332e);
    }

    public static void s(@n0 Location location) {
        q(location, f49333f);
    }

    public static void t(@n0 Location location, float f10) {
        if (Build.VERSION.SDK_INT >= 26) {
            c.g(location, f10);
        } else {
            g(location).putFloat(f49331d, f10);
        }
    }

    public static void u(@n0 Location location, boolean z10) {
        try {
            h().invoke(location, Boolean.valueOf(z10));
        } catch (IllegalAccessException e10) {
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause(e10);
            throw illegalAccessError;
        } catch (NoSuchMethodException e11) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            noSuchMethodError.initCause(e11);
            throw noSuchMethodError;
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(e12);
        }
    }

    public static void v(@n0 Location location, @g.x(from = 0.0d) float f10) {
        g(location).putFloat(f49333f, f10);
    }

    public static void w(@n0 Location location, double d10) {
        g(location).putDouble(f49332e, d10);
    }

    public static void x(@n0 Location location, float f10) {
        if (Build.VERSION.SDK_INT >= 26) {
            c.h(location, f10);
        } else {
            g(location).putFloat(f49330c, f10);
        }
    }

    public static void y(@n0 Location location, float f10) {
        if (Build.VERSION.SDK_INT >= 26) {
            c.i(location, f10);
        } else {
            g(location).putFloat(f49329b, f10);
        }
    }
}
