package ze;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes7.dex */
public final class j extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f58514g = Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");

    public static boolean s(String str) {
        return str != null && f58514g.matcher(str).matches() && str.indexOf(64) >= 0;
    }

    @Override // ze.t
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public h k(ve.k kVar) {
        String[] strArrQ;
        String strC = t.c(kVar);
        if (!strC.startsWith("MATMSG:") || (strArrQ = a.q("TO:", strC)) == null) {
            return null;
        }
        for (String str : strArrQ) {
            if (!s(str)) {
                return null;
            }
        }
        return new h(strArrQ, null, null, a.r("SUB:", strC, false), a.r("BODY:", strC, false));
    }
}
