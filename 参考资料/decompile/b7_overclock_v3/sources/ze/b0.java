package ze;

import com.google.zxing.client.result.ParsedResultType;
import com.just.agentweb.DefaultWebClient;

/* JADX INFO: loaded from: classes7.dex */
public final class b0 extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f58443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f58444c;

    public b0(String str, String str2) {
        super(ParsedResultType.URI);
        this.f58443b = i(str);
        this.f58444c = str2;
    }

    public static boolean g(String str, int i10) {
        int i11 = i10 + 1;
        int iIndexOf = str.indexOf(47, i11);
        if (iIndexOf < 0) {
            iIndexOf = str.length();
        }
        return t.e(str, i11, iIndexOf - i11);
    }

    public static String i(String str) {
        String strTrim = str.trim();
        int iIndexOf = strTrim.indexOf(58);
        if (iIndexOf >= 0 && !g(strTrim, iIndexOf)) {
            return strTrim;
        }
        return DefaultWebClient.f21814v + strTrim;
    }

    @Override // ze.q
    public String a() {
        StringBuilder sb2 = new StringBuilder(30);
        q.c(this.f58444c, sb2);
        q.c(this.f58443b, sb2);
        return sb2.toString();
    }

    public String e() {
        return this.f58444c;
    }

    public String f() {
        return this.f58443b;
    }

    @Deprecated
    public boolean h() {
        return c0.r(this.f58443b);
    }
}
