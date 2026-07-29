package u0;

import android.net.Uri;
import androidx.core.net.ParseException;
import androidx.core.util.o;
import g.n0;
import g.p0;
import hb.u;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f51788b = "mailto:";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f51789c = "mailto";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f51790d = "to";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f51791e = "body";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f51792f = "cc";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f51793g = "bcc";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f51794h = "subject";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<String, String> f51795a = new HashMap<>();

    public static boolean g(@p0 Uri uri) {
        return uri != null && f51789c.equals(uri.getScheme());
    }

    public static boolean h(@p0 String str) {
        return str != null && str.startsWith(f51788b);
    }

    @n0
    public static c i(@n0 Uri uri) throws ParseException {
        return j(uri.toString());
    }

    @n0
    public static c j(@n0 String str) throws ParseException {
        String strDecode;
        String strSubstring;
        o.l(str);
        if (!h(str)) {
            throw new ParseException("Not a mailto scheme");
        }
        int iIndexOf = str.indexOf(35);
        if (iIndexOf != -1) {
            str = str.substring(0, iIndexOf);
        }
        int iIndexOf2 = str.indexOf(63);
        if (iIndexOf2 == -1) {
            strDecode = Uri.decode(str.substring(7));
            strSubstring = null;
        } else {
            strDecode = Uri.decode(str.substring(7, iIndexOf2));
            strSubstring = str.substring(iIndexOf2 + 1);
        }
        c cVar = new c();
        if (strSubstring != null) {
            for (String str2 : strSubstring.split("&")) {
                String[] strArrSplit = str2.split(u.f30904o, 2);
                if (strArrSplit.length != 0) {
                    cVar.f51795a.put(Uri.decode(strArrSplit[0]).toLowerCase(Locale.ROOT), strArrSplit.length > 1 ? Uri.decode(strArrSplit[1]) : null);
                }
            }
        }
        String strF = cVar.f();
        if (strF != null) {
            strDecode = strDecode + ", " + strF;
        }
        cVar.f51795a.put("to", strDecode);
        return cVar;
    }

    @p0
    public String a() {
        return this.f51795a.get(f51793g);
    }

    @p0
    public String b() {
        return this.f51795a.get("body");
    }

    @p0
    public String c() {
        return this.f51795a.get(f51792f);
    }

    @p0
    public Map<String, String> d() {
        return this.f51795a;
    }

    @p0
    public String e() {
        return this.f51795a.get(f51794h);
    }

    @p0
    public String f() {
        return this.f51795a.get("to");
    }

    @n0
    public String toString() {
        StringBuilder sb2 = new StringBuilder(f51788b);
        sb2.append('?');
        for (Map.Entry<String, String> entry : this.f51795a.entrySet()) {
            sb2.append(Uri.encode(entry.getKey()));
            sb2.append('=');
            sb2.append(Uri.encode(entry.getValue()));
            sb2.append('&');
        }
        return sb2.toString();
    }
}
