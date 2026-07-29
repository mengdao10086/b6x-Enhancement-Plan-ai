package cr;

import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public class a extends IvParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f25797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f25798b;

    public a(byte[] bArr, int i10) {
        this(bArr, i10, null);
    }

    public a(byte[] bArr, int i10, byte[] bArr2) {
        super(bArr);
        this.f25798b = i10;
        this.f25797a = org.bouncycastle.util.a.p(bArr2);
    }

    public byte[] a() {
        return org.bouncycastle.util.a.p(this.f25797a);
    }

    public int b() {
        return this.f25798b;
    }

    public byte[] c() {
        return getIV();
    }
}
