package y0;

import android.text.TextUtils;
import g.n0;
import g.p0;
import g.u;
import g.v0;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Locale f56219a = new Locale("", "");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f56220b = "Arab";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f56221c = "Hebr";

    @v0(17)
    public static class a {
        @u
        public static int a(Locale locale) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
    }

    public static int a(@n0 Locale locale) {
        byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        return (directionality == 1 || directionality == 2) ? 1 : 0;
    }

    public static int b(@p0 Locale locale) {
        return a.a(locale);
    }

    @n0
    public static String c(@n0 String str) {
        return TextUtils.htmlEncode(str);
    }
}
