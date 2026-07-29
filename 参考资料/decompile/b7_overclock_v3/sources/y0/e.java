package y0;

import android.annotation.SuppressLint;
import android.icu.util.ULocale;
import android.os.Build;
import g.n0;
import g.p0;
import g.u;
import g.v0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f56183a = "ICUCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f56184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f56185c;

    @v0(21)
    public static class a {
        @u
        public static String a(Locale locale) {
            return locale.getScript();
        }
    }

    @v0(24)
    public static class b {
        @u
        public static ULocale a(Object obj) {
            return ULocale.addLikelySubtags((ULocale) obj);
        }

        @u
        public static ULocale b(Locale locale) {
            return ULocale.forLocale(locale);
        }

        @u
        public static String c(Object obj) {
            return ((ULocale) obj).getScript();
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 24) {
            try {
                f56185c = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            } catch (Exception e10) {
                throw new IllegalStateException(e10);
            }
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static String a(Locale locale) {
        String string = locale.toString();
        try {
            Method method = f56185c;
            if (method != null) {
                return (String) method.invoke(null, string);
            }
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        return string;
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static String b(String str) {
        try {
            Method method = f56184b;
            if (method != null) {
                return (String) method.invoke(null, str);
            }
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        return null;
    }

    @p0
    public static String c(@n0 Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return b.c(b.a(b.b(locale)));
        }
        try {
            return a.a((Locale) f56185c.invoke(null, locale));
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return a.a(locale);
        }
    }
}
