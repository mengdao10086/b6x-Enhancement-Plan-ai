package ze;

import com.google.zxing.client.result.ParsedResultType;

/* JADX INFO: loaded from: classes7.dex */
public final class g0 extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f58489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f58490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f58491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f58492e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f58493f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f58494g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f58495h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final char f58496i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f58497j;

    public g0(String str, String str2, String str3, String str4, String str5, String str6, int i10, char c10, String str7) {
        super(ParsedResultType.VIN);
        this.f58489b = str;
        this.f58490c = str2;
        this.f58491d = str3;
        this.f58492e = str4;
        this.f58493f = str5;
        this.f58494g = str6;
        this.f58495h = i10;
        this.f58496i = c10;
        this.f58497j = str7;
    }

    @Override // ze.q
    public String a() {
        StringBuilder sb2 = new StringBuilder(50);
        sb2.append(this.f58490c);
        sb2.append(zc.f.f58383m);
        sb2.append(this.f58491d);
        sb2.append(zc.f.f58383m);
        sb2.append(this.f58492e);
        sb2.append('\n');
        String str = this.f58493f;
        if (str != null) {
            sb2.append(str);
            sb2.append(zc.f.f58383m);
        }
        sb2.append(this.f58495h);
        sb2.append(zc.f.f58383m);
        sb2.append(this.f58496i);
        sb2.append(zc.f.f58383m);
        sb2.append(this.f58497j);
        sb2.append('\n');
        return sb2.toString();
    }

    public String e() {
        return this.f58493f;
    }

    public int f() {
        return this.f58495h;
    }

    public char g() {
        return this.f58496i;
    }

    public String h() {
        return this.f58497j;
    }

    public String i() {
        return this.f58489b;
    }

    public String j() {
        return this.f58494g;
    }

    public String k() {
        return this.f58491d;
    }

    public String l() {
        return this.f58492e;
    }

    public String m() {
        return this.f58490c;
    }
}
