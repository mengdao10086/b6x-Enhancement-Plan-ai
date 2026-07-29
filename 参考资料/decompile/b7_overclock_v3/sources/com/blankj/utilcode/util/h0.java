package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.blankj.utilcode.util.j1;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f11792a = "KEY_LOCALE";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f11793b = "VALUE_FOLLOW_SYSTEM";

    public static class a implements j1.b<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f11794a;

        public a(boolean z10) {
            this.f11794a = z10;
        }

        @Override // com.blankj.utilcode.util.j1.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Boolean bool) {
            if (bool.booleanValue()) {
                h0.t(this.f11794a);
            } else {
                l1.P0();
            }
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Locale f11795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f11796b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j1.b f11797c;

        public b(Locale locale, int i10, j1.b bVar) {
            this.f11795a = locale;
            this.f11796b = i10;
            this.f11797c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            h0.s(this.f11795a, this.f11796b + 1, this.f11797c);
        }
    }

    public h0() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void b(Activity activity) {
        String strQ = l1.d0().q(f11792a);
        if (TextUtils.isEmpty(strQ)) {
            return;
        }
        Locale localeL = f11793b.equals(strQ) ? l(Resources.getSystem().getConfiguration()) : v(strQ);
        if (localeL == null) {
            return;
        }
        y(activity, localeL);
        y(j1.a(), localeL);
    }

    public static void c(@g.n0 Locale locale) {
        Objects.requireNonNull(locale, "Argument 'locale' of type Locale (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        d(locale, false);
    }

    public static void d(@g.n0 Locale locale, boolean z10) {
        Objects.requireNonNull(locale, "Argument 'locale' of type Locale (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        e(locale, z10);
    }

    public static void e(Locale locale, boolean z10) {
        if (locale == null) {
            l1.d0().C(f11792a, f11793b, true);
        } else {
            l1.d0().C(f11792a, r(locale), true);
        }
        if (locale == null) {
            locale = l(Resources.getSystem().getConfiguration());
        }
        x(locale, new a(z10));
    }

    public static void f() {
        g(false);
    }

    public static void g(boolean z10) {
        e(null, z10);
    }

    public static Context h(Context context) {
        Locale localeV;
        String strQ = l1.d0().q(f11792a);
        if (TextUtils.isEmpty(strQ) || f11793b.equals(strQ) || (localeV = v(strQ)) == null) {
            return context;
        }
        Configuration configuration = context.getResources().getConfiguration();
        u(configuration, localeV);
        return context.createConfigurationContext(configuration);
    }

    public static Locale i() {
        return k(j1.a());
    }

    public static Locale j() {
        String strQ = l1.d0().q(f11792a);
        if (TextUtils.isEmpty(strQ) || f11793b.equals(strQ)) {
            return null;
        }
        return v(strQ);
    }

    public static Locale k(Context context) {
        return l(context.getResources().getConfiguration());
    }

    public static Locale l(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? configuration.getLocales().get(0) : configuration.locale;
    }

    public static Locale m() {
        return l(Resources.getSystem().getConfiguration());
    }

    public static boolean n() {
        return j() != null;
    }

    public static boolean o(@g.n0 Locale locale) {
        Objects.requireNonNull(locale, "Argument 'locale' of type Locale (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Locale localeJ = j();
        if (localeJ == null) {
            return false;
        }
        return q(locale, localeJ);
    }

    public static boolean p(String str) {
        int i10 = 0;
        for (char c10 : str.toCharArray()) {
            if (c10 == '$') {
                if (i10 >= 1) {
                    return false;
                }
                i10++;
            }
        }
        return i10 == 1;
    }

    public static boolean q(Locale locale, Locale locale2) {
        return l1.A(locale2.getLanguage(), locale.getLanguage()) && l1.A(locale2.getCountry(), locale.getCountry());
    }

    public static String r(Locale locale) {
        return locale.getLanguage() + "$" + locale.getCountry();
    }

    public static void s(Locale locale, int i10, j1.b<Boolean> bVar) {
        Resources resources = j1.a().getResources();
        Configuration configuration = resources.getConfiguration();
        Locale localeL = l(configuration);
        u(configuration, locale);
        j1.a().getResources().updateConfiguration(configuration, resources.getDisplayMetrics());
        if (bVar == null) {
            return;
        }
        if (q(localeL, locale)) {
            bVar.accept(Boolean.TRUE);
        } else if (i10 < 20) {
            l1.V0(new b(locale, i10, bVar), 16L);
        } else {
            bVar.accept(Boolean.FALSE);
        }
    }

    public static void t(boolean z10) {
        if (z10) {
            l1.P0();
            return;
        }
        Iterator<Activity> it2 = l1.J().iterator();
        while (it2.hasNext()) {
            it2.next().recreate();
        }
    }

    public static void u(Configuration configuration, Locale locale) {
        configuration.setLocale(locale);
    }

    public static Locale v(String str) {
        Locale localeW = w(str);
        if (localeW == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("The string of ");
            sb2.append(str);
            sb2.append(" is not in the correct format.");
            l1.d0().H(f11792a);
        }
        return localeW;
    }

    public static Locale w(String str) {
        if (!p(str)) {
            return null;
        }
        try {
            int iIndexOf = str.indexOf("$");
            return new Locale(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
        } catch (Exception unused) {
            return null;
        }
    }

    public static void x(@g.n0 Locale locale, @g.p0 j1.b<Boolean> bVar) {
        Objects.requireNonNull(locale, "Argument 'destLocale' of type Locale (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        s(locale, 0, bVar);
    }

    public static void y(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        u(configuration, locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}
