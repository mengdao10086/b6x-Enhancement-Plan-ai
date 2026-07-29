package cr;

import java.security.spec.KeySpec;

/* JADX INFO: loaded from: classes5.dex */
public class v implements KeySpec {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f25866e = "master secret";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f25867f = "key expansion";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f25868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f25869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f25870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f25871d;

    public v(byte[] bArr, String str, int i10, byte[]... bArr2) {
        this.f25868a = org.bouncycastle.util.a.p(bArr);
        this.f25869b = str;
        this.f25870c = i10;
        this.f25871d = org.bouncycastle.util.a.E(bArr2);
    }

    public String a() {
        return this.f25869b;
    }

    public int b() {
        return this.f25870c;
    }

    public byte[] c() {
        return org.bouncycastle.util.a.p(this.f25868a);
    }

    public byte[] d() {
        return org.bouncycastle.util.a.p(this.f25871d);
    }
}
