package a;

import android.util.Base64;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class be {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5697a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f263a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<List<byte[]>> f264a;
    public final String b;
    public final String c;
    public final String d;

    public be(String str, String str2, String str3, List<List<byte[]>> list) {
        pf.b(str);
        this.f263a = str;
        pf.b(str2);
        this.b = str2;
        pf.b(str3);
        this.c = str3;
        pf.b(list);
        this.f264a = list;
        this.f5697a = 0;
        this.d = a(str, str2, str3);
    }

    public final String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List<List<byte[]>> b() {
        return this.f264a;
    }

    public int c() {
        return this.f5697a;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.f263a;
    }

    public String f() {
        return this.b;
    }

    public String g() {
        return this.c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f263a + ", mProviderPackage: " + this.b + ", mQuery: " + this.c + ", mCertificates:");
        for (int i = 0; i < this.f264a.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.f264a.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f5697a);
        return sb.toString();
    }
}
