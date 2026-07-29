package ze;

import com.google.zxing.client.result.ParsedResultType;

/* JADX INFO: loaded from: classes7.dex */
public final class i0 extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f58506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f58507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f58508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f58509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f58510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f58511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f58512h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f58513i;

    public i0(String str, String str2, String str3) {
        this(str, str2, str3, false);
    }

    @Override // ze.q
    public String a() {
        StringBuilder sb2 = new StringBuilder(80);
        q.c(this.f58506b, sb2);
        q.c(this.f58507c, sb2);
        q.c(this.f58508d, sb2);
        q.c(Boolean.toString(this.f58509e), sb2);
        return sb2.toString();
    }

    public String e() {
        return this.f58511g;
    }

    public String f() {
        return this.f58512h;
    }

    public String g() {
        return this.f58510f;
    }

    public String h() {
        return this.f58507c;
    }

    public String i() {
        return this.f58508d;
    }

    public String j() {
        return this.f58513i;
    }

    public String k() {
        return this.f58506b;
    }

    public boolean l() {
        return this.f58509e;
    }

    public i0(String str, String str2, String str3, boolean z10) {
        this(str, str2, str3, z10, null, null, null, null);
    }

    public i0(String str, String str2, String str3, boolean z10, String str4, String str5, String str6, String str7) {
        super(ParsedResultType.WIFI);
        this.f58506b = str2;
        this.f58507c = str;
        this.f58508d = str3;
        this.f58509e = z10;
        this.f58510f = str4;
        this.f58511g = str5;
        this.f58512h = str6;
        this.f58513i = str7;
    }
}
