package ze;

import com.google.zxing.client.result.ParsedResultType;
import com.just.agentweb.DefaultWebClient;

/* JADX INFO: loaded from: classes7.dex */
public final class v extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f58547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f58548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f58549d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f58550e;

    public v(String str, String str2, String str3, String str4) {
        super(ParsedResultType.SMS);
        this.f58547b = new String[]{str};
        this.f58548c = new String[]{str2};
        this.f58549d = str3;
        this.f58550e = str4;
    }

    @Override // ze.q
    public String a() {
        StringBuilder sb2 = new StringBuilder(100);
        q.d(this.f58547b, sb2);
        q.c(this.f58549d, sb2);
        q.c(this.f58550e, sb2);
        return sb2.toString();
    }

    public String e() {
        return this.f58550e;
    }

    public String[] f() {
        return this.f58547b;
    }

    public String g() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(DefaultWebClient.C);
        boolean z10 = true;
        for (int i10 = 0; i10 < this.f58547b.length; i10++) {
            if (z10) {
                z10 = false;
            } else {
                sb2.append(',');
            }
            sb2.append(this.f58547b[i10]);
            String[] strArr = this.f58548c;
            if (strArr != null && strArr[i10] != null) {
                sb2.append(";via=");
                sb2.append(this.f58548c[i10]);
            }
        }
        boolean z11 = this.f58550e != null;
        boolean z12 = this.f58549d != null;
        if (z11 || z12) {
            sb2.append('?');
            if (z11) {
                sb2.append("body=");
                sb2.append(this.f58550e);
            }
            if (z12) {
                if (z11) {
                    sb2.append('&');
                }
                sb2.append("subject=");
                sb2.append(this.f58549d);
            }
        }
        return sb2.toString();
    }

    public String h() {
        return this.f58549d;
    }

    public String[] i() {
        return this.f58548c;
    }

    public v(String[] strArr, String[] strArr2, String str, String str2) {
        super(ParsedResultType.SMS);
        this.f58547b = strArr;
        this.f58548c = strArr2;
        this.f58549d = str;
        this.f58550e = str2;
    }
}
