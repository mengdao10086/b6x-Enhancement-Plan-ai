package ze;

import com.google.zxing.client.result.ParsedResultType;

/* JADX INFO: loaded from: classes7.dex */
public final class a0 extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f58441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f58442c;

    public a0(String str, String str2) {
        super(ParsedResultType.TEXT);
        this.f58441b = str;
        this.f58442c = str2;
    }

    @Override // ze.q
    public String a() {
        return this.f58441b;
    }

    public String e() {
        return this.f58442c;
    }

    public String f() {
        return this.f58441b;
    }
}
