package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import androidx.core.os.a;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import g.a1;
import g.f0;
import g.n0;
import g.p0;
import g.r0;
import g.v0;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f4661b = a(new Locale[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f4662a;

    @v0(21)
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Locale[] f4663a = {new Locale(SocializeProtocolConstants.PROTOCOL_KEY_EN, "XA"), new Locale("ar", "XB")};

        @g.u
        public static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }

        public static boolean b(Locale locale) {
            for (Locale locale2 : f4663a) {
                if (locale2.equals(locale)) {
                    return true;
                }
            }
            return false;
        }

        @g.u
        public static boolean c(@n0 Locale locale, @n0 Locale locale2) {
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage()) || b(locale) || b(locale2)) {
                return false;
            }
            String strC = y0.e.c(locale);
            if (!strC.isEmpty()) {
                return strC.equals(y0.e.c(locale2));
            }
            String country = locale.getCountry();
            return country.isEmpty() || country.equals(locale2.getCountry());
        }
    }

    @v0(24)
    public static class b {
        @g.u
        public static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        @g.u
        public static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        @g.u
        public static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    public l(n nVar) {
        this.f4662a = nVar;
    }

    @n0
    public static l a(@n0 Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? o(b.a(localeArr)) : new l(new m(localeArr));
    }

    public static Locale b(String str) {
        if (str.contains("-")) {
            String[] strArrSplit = str.split("-", -1);
            if (strArrSplit.length > 2) {
                return new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
            }
            if (strArrSplit.length > 1) {
                return new Locale(strArrSplit[0], strArrSplit[1]);
            }
            if (strArrSplit.length == 1) {
                return new Locale(strArrSplit[0]);
            }
        } else {
            if (!str.contains("_")) {
                return new Locale(str);
            }
            String[] strArrSplit2 = str.split("_", -1);
            if (strArrSplit2.length > 2) {
                return new Locale(strArrSplit2[0], strArrSplit2[1], strArrSplit2[2]);
            }
            if (strArrSplit2.length > 1) {
                return new Locale(strArrSplit2[0], strArrSplit2[1]);
            }
            if (strArrSplit2.length == 1) {
                return new Locale(strArrSplit2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    @n0
    public static l c(@p0 String str) {
        if (str == null || str.isEmpty()) {
            return g();
        }
        String[] strArrSplit = str.split(ag.c.f654g, -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i10 = 0; i10 < length; i10++) {
            localeArr[i10] = a.a(strArrSplit[i10]);
        }
        return a(localeArr);
    }

    @a1(min = 1)
    @n0
    public static l e() {
        return Build.VERSION.SDK_INT >= 24 ? o(b.b()) : a(Locale.getDefault());
    }

    @a1(min = 1)
    @n0
    public static l f() {
        return Build.VERSION.SDK_INT >= 24 ? o(b.c()) : a(Locale.getDefault());
    }

    @n0
    public static l g() {
        return f4661b;
    }

    @r0(markerClass = {a.b.class})
    @v0(21)
    public static boolean k(@n0 Locale locale, @n0 Locale locale2) {
        return androidx.core.os.a.k() ? LocaleList.matchesLanguageAndScript(locale, locale2) : a.c(locale, locale2);
    }

    @n0
    @v0(24)
    public static l o(@n0 LocaleList localeList) {
        return new l(new o(localeList));
    }

    @v0(24)
    @Deprecated
    public static l p(Object obj) {
        return o((LocaleList) obj);
    }

    @p0
    public Locale d(int i10) {
        return this.f4662a.get(i10);
    }

    public boolean equals(Object obj) {
        return (obj instanceof l) && this.f4662a.equals(((l) obj).f4662a);
    }

    @p0
    public Locale h(@n0 String[] strArr) {
        return this.f4662a.d(strArr);
    }

    public int hashCode() {
        return this.f4662a.hashCode();
    }

    @f0(from = -1)
    public int i(@p0 Locale locale) {
        return this.f4662a.a(locale);
    }

    public boolean j() {
        return this.f4662a.isEmpty();
    }

    @f0(from = 0)
    public int l() {
        return this.f4662a.size();
    }

    @n0
    public String m() {
        return this.f4662a.b();
    }

    @p0
    public Object n() {
        return this.f4662a.c();
    }

    @n0
    public String toString() {
        return this.f4662a.toString();
    }
}
