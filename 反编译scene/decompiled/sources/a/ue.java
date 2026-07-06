package a;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f7588a;
    public static Method b;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            if (i < 24) {
                try {
                    b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
                    return;
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }
            return;
        }
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f7588a = cls.getMethod("getScript", String.class);
                b = cls.getMethod("addLikelySubtags", String.class);
            }
        } catch (Exception e2) {
            f7588a = null;
            b = null;
            Log.w("ICUCompat", e2);
        }
    }

    public static String a(Locale locale) {
        String string = locale.toString();
        try {
            if (b != null) {
                return (String) b.invoke(null, string);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            Log.w("ICUCompat", e);
        }
        return string;
    }

    public static String b(String str) {
        try {
            if (f7588a != null) {
                return (String) f7588a.invoke(null, str);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            Log.w("ICUCompat", e);
        }
        return null;
    }

    public static String c(Locale locale) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
        }
        if (i >= 21) {
            try {
                return ((Locale) b.invoke(null, locale)).getScript();
            } catch (IllegalAccessException | InvocationTargetException e) {
                Log.w("ICUCompat", e);
                return locale.getScript();
            }
        }
        String strA = a(locale);
        if (strA != null) {
            return b(strA);
        }
        return null;
    }
}
