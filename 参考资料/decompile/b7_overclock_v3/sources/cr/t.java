package cr;

import java.security.spec.KeySpec;

/* JADX INFO: loaded from: classes5.dex */
public class t implements KeySpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char[] f25850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f25851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f25852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f25853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f25854e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f25855f;

    public t(char[] cArr, byte[] bArr, int i10, int i11, int i12, int i13) {
        this.f25850a = cArr;
        this.f25851b = org.bouncycastle.util.a.p(bArr);
        this.f25852c = i10;
        this.f25853d = i11;
        this.f25854e = i12;
        this.f25855f = i13;
    }

    public int a() {
        return this.f25853d;
    }

    public int b() {
        return this.f25852c;
    }

    public int c() {
        return this.f25855f;
    }

    public int d() {
        return this.f25854e;
    }

    public char[] e() {
        return this.f25850a;
    }

    public byte[] f() {
        return org.bouncycastle.util.a.p(this.f25851b);
    }
}
