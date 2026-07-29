package ze;

import com.google.zxing.client.result.ParsedResultType;

/* JADX INFO: loaded from: classes7.dex */
public final class o extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f58537b;

    public o(String str) {
        super(ParsedResultType.ISBN);
        this.f58537b = str;
    }

    @Override // ze.q
    public String a() {
        return this.f58537b;
    }

    public String e() {
        return this.f58537b;
    }
}
