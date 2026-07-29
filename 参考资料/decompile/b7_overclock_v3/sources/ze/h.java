package ze;

import com.google.zxing.client.result.ParsedResultType;

/* JADX INFO: loaded from: classes7.dex */
public final class h extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f58498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f58499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String[] f58500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f58501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f58502f;

    public h(String str) {
        this(new String[]{str}, null, null, null, null);
    }

    @Override // ze.q
    public String a() {
        StringBuilder sb2 = new StringBuilder(30);
        q.d(this.f58498b, sb2);
        q.d(this.f58499c, sb2);
        q.d(this.f58500d, sb2);
        q.c(this.f58501e, sb2);
        q.c(this.f58502f, sb2);
        return sb2.toString();
    }

    public String[] e() {
        return this.f58500d;
    }

    public String f() {
        return this.f58502f;
    }

    public String[] g() {
        return this.f58499c;
    }

    @Deprecated
    public String h() {
        String[] strArr = this.f58498b;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        return strArr[0];
    }

    @Deprecated
    public String i() {
        return u0.c.f51788b;
    }

    public String j() {
        return this.f58501e;
    }

    public String[] k() {
        return this.f58498b;
    }

    public h(String[] strArr, String[] strArr2, String[] strArr3, String str, String str2) {
        super(ParsedResultType.EMAIL_ADDRESS);
        this.f58498b = strArr;
        this.f58499c = strArr2;
        this.f58500d = strArr3;
        this.f58501e = str;
        this.f58502f = str2;
    }
}
