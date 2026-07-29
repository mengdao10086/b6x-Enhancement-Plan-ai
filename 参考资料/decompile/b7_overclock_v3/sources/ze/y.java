package ze;

import com.google.zxing.client.result.ParsedResultType;

/* JADX INFO: loaded from: classes7.dex */
public final class y extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f58551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f58552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f58553d;

    public y(String str, String str2, String str3) {
        super(ParsedResultType.TEL);
        this.f58551b = str;
        this.f58552c = str2;
        this.f58553d = str3;
    }

    @Override // ze.q
    public String a() {
        StringBuilder sb2 = new StringBuilder(20);
        q.c(this.f58551b, sb2);
        q.c(this.f58553d, sb2);
        return sb2.toString();
    }

    public String e() {
        return this.f58551b;
    }

    public String f() {
        return this.f58552c;
    }

    public String g() {
        return this.f58553d;
    }
}
