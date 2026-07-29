package ze;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes7.dex */
public final class c0 extends t {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f58445g = Pattern.compile("[-._~:/?#\\[\\]@!$&'()*+,;=%A-Za-z0-9]+");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Pattern f58446h = Pattern.compile(":/*([^/@]+)@[^/]+");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Pattern f58447i = Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+:");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f58448j = Pattern.compile("([a-zA-Z0-9\\-]+\\.){1,6}[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");

    public static boolean q(String str) {
        if (str.contains(com.blankj.utilcode.util.i0.f11861z)) {
            return false;
        }
        Matcher matcher = f58447i.matcher(str);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        Matcher matcher2 = f58448j.matcher(str);
        return matcher2.find() && matcher2.start() == 0;
    }

    public static boolean r(String str) {
        return !f58445g.matcher(str).matches() || f58446h.matcher(str).find();
    }

    @Override // ze.t
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public b0 k(ve.k kVar) {
        String strC = t.c(kVar);
        if (strC.startsWith("URL:") || strC.startsWith("URI:")) {
            return new b0(strC.substring(4).trim(), null);
        }
        String strTrim = strC.trim();
        if (!q(strTrim) || r(strTrim)) {
            return null;
        }
        return new b0(strTrim, null);
    }
}
