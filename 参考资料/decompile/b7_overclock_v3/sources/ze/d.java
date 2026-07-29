package ze;

import com.google.zxing.client.result.ParsedResultType;

/* JADX INFO: loaded from: classes7.dex */
public final class d extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f58449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f58450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f58451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f58452e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String[] f58453f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String[] f58454g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String[] f58455h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f58456i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f58457j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String[] f58458k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String[] f58459l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f58460m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f58461n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f58462o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String[] f58463p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String[] f58464q;

    public d(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String[] strArr7) {
        this(strArr, null, null, strArr2, strArr3, strArr4, strArr5, null, null, strArr6, strArr7, null, null, null, null, null);
    }

    @Override // ze.q
    public String a() {
        StringBuilder sb2 = new StringBuilder(100);
        q.d(this.f58449b, sb2);
        q.d(this.f58450c, sb2);
        q.c(this.f58451d, sb2);
        q.c(this.f58462o, sb2);
        q.c(this.f58460m, sb2);
        q.d(this.f58458k, sb2);
        q.d(this.f58452e, sb2);
        q.d(this.f58454g, sb2);
        q.c(this.f58456i, sb2);
        q.d(this.f58463p, sb2);
        q.c(this.f58461n, sb2);
        q.d(this.f58464q, sb2);
        q.c(this.f58457j, sb2);
        return sb2.toString();
    }

    public String[] e() {
        return this.f58459l;
    }

    public String[] f() {
        return this.f58458k;
    }

    public String g() {
        return this.f58461n;
    }

    public String[] h() {
        return this.f58455h;
    }

    public String[] i() {
        return this.f58454g;
    }

    public String[] j() {
        return this.f58464q;
    }

    public String k() {
        return this.f58456i;
    }

    public String[] l() {
        return this.f58449b;
    }

    public String[] m() {
        return this.f58450c;
    }

    public String n() {
        return this.f58457j;
    }

    public String o() {
        return this.f58460m;
    }

    public String[] p() {
        return this.f58452e;
    }

    public String[] q() {
        return this.f58453f;
    }

    public String r() {
        return this.f58451d;
    }

    public String s() {
        return this.f58462o;
    }

    public String[] t() {
        return this.f58463p;
    }

    public d(String[] strArr, String[] strArr2, String str, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String str2, String str3, String[] strArr7, String[] strArr8, String str4, String str5, String str6, String[] strArr9, String[] strArr10) {
        super(ParsedResultType.ADDRESSBOOK);
        if (strArr3 != null && strArr4 != null && strArr3.length != strArr4.length) {
            throw new IllegalArgumentException("Phone numbers and types lengths differ");
        }
        if (strArr5 != null && strArr6 != null && strArr5.length != strArr6.length) {
            throw new IllegalArgumentException("Emails and types lengths differ");
        }
        if (strArr7 != null && strArr8 != null && strArr7.length != strArr8.length) {
            throw new IllegalArgumentException("Addresses and types lengths differ");
        }
        this.f58449b = strArr;
        this.f58450c = strArr2;
        this.f58451d = str;
        this.f58452e = strArr3;
        this.f58453f = strArr4;
        this.f58454g = strArr5;
        this.f58455h = strArr6;
        this.f58456i = str2;
        this.f58457j = str3;
        this.f58458k = strArr7;
        this.f58459l = strArr8;
        this.f58460m = str4;
        this.f58461n = str5;
        this.f58462o = str6;
        this.f58463p = strArr9;
        this.f58464q = strArr10;
    }
}
