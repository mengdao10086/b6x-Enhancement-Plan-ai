package f0;

import android.app.LocaleManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import androidx.core.os.a;
import g.i1;
import g.n0;
import g.r0;
import g.v0;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    @v0(21)
    public static class a {
        @g.u
        public static String a(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    @v0(24)
    public static class b {
        @g.u
        public static androidx.core.os.l a(Configuration configuration) {
            return androidx.core.os.l.c(configuration.getLocales().toLanguageTags());
        }
    }

    @v0(33)
    public static class c {
        @g.u
        public static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getSystemLocales();
        }
    }

    @i1
    public static androidx.core.os.l a(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? b.a(configuration) : androidx.core.os.l.c(a.a(configuration.locale));
    }

    @v0(33)
    public static Object b(Context context) {
        return context.getSystemService("locale");
    }

    @g.d
    @n0
    @r0(markerClass = {a.b.class})
    public static androidx.core.os.l c(@n0 Context context) {
        androidx.core.os.l lVarG = androidx.core.os.l.g();
        if (!androidx.core.os.a.k()) {
            return a(context.getApplicationContext().getResources().getConfiguration());
        }
        Object objB = b(context);
        return objB != null ? androidx.core.os.l.o(c.a(objB)) : lVarG;
    }
}
