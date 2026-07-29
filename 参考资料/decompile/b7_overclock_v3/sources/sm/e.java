package sm;

import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f49896d = "ISO-8859-1";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f49897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f49898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f49899c;

    public e(String str, String str2, String str3) {
        this.f49897a = str;
        this.f49898b = str2;
        this.f49899c = str3;
    }

    public e(byte[] bArr) {
        try {
            String str = new String(bArr, "ISO-8859-1");
            this.f49897a = str.substring(0, 2);
            this.f49898b = str.substring(2, str.length() - 5);
            this.f49899c = str.substring(str.length() - 5);
        } catch (UnsupportedEncodingException e10) {
            throw new IllegalStateException(e10.toString());
        }
    }

    public String a() {
        return this.f49897a;
    }

    public byte[] b() {
        try {
            return (this.f49897a + this.f49898b + this.f49899c).getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e10) {
            throw new IllegalStateException(e10.toString());
        }
    }

    public String c() {
        return this.f49898b;
    }

    public String d() {
        return this.f49899c;
    }
}
