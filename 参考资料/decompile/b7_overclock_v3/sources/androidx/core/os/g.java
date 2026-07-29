package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    @v0(24)
    public static class a {
        @g.u
        public static LocaleList a(Configuration configuration) {
            return configuration.getLocales();
        }
    }

    @n0
    public static l a(@n0 Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? l.o(a.a(configuration)) : l.a(configuration.locale);
    }
}
