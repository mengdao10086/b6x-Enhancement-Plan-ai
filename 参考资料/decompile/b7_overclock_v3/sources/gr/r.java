package gr;

import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public class r implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f29971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f29972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f29973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f29974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f29975e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f29976f;

    public r(byte[] bArr, byte[] bArr2, int i10) {
        this(bArr, bArr2, i10, -1, null, false);
    }

    public r(byte[] bArr, byte[] bArr2, int i10, int i11, byte[] bArr3) {
        this(bArr, bArr2, i10, i11, bArr3, false);
    }

    public r(byte[] bArr, byte[] bArr2, int i10, int i11, byte[] bArr3, boolean z10) {
        if (bArr != null) {
            byte[] bArr4 = new byte[bArr.length];
            this.f29971a = bArr4;
            System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
        } else {
            this.f29971a = null;
        }
        if (bArr2 != null) {
            byte[] bArr5 = new byte[bArr2.length];
            this.f29972b = bArr5;
            System.arraycopy(bArr2, 0, bArr5, 0, bArr2.length);
        } else {
            this.f29972b = null;
        }
        this.f29973c = i10;
        this.f29974d = i11;
        this.f29975e = org.bouncycastle.util.a.p(bArr3);
        this.f29976f = z10;
    }

    public int a() {
        return this.f29974d;
    }

    public byte[] b() {
        return org.bouncycastle.util.a.p(this.f29971a);
    }

    public byte[] c() {
        return org.bouncycastle.util.a.p(this.f29972b);
    }

    public int d() {
        return this.f29973c;
    }

    public byte[] e() {
        return org.bouncycastle.util.a.p(this.f29975e);
    }

    public boolean f() {
        return this.f29976f;
    }

    public void g(boolean z10) {
        this.f29976f = z10;
    }
}
