package ze;

import com.google.zxing.client.result.ParsedResultType;

/* JADX INFO: loaded from: classes7.dex */
public final class r extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f58539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f58540c;

    public r(String str) {
        this(str, str);
    }

    @Override // ze.q
    public String a() {
        return this.f58539b;
    }

    public String e() {
        return this.f58540c;
    }

    public String f() {
        return this.f58539b;
    }

    public r(String str, String str2) {
        super(ParsedResultType.PRODUCT);
        this.f58539b = str;
        this.f58540c = str2;
    }
}
