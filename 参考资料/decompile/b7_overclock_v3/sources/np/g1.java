package np;

/* JADX INFO: loaded from: classes5.dex */
public class g1 implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f42413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f42414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f42415c;

    public g1(byte[] bArr, byte[] bArr2, int i10) {
        this.f42413a = org.bouncycastle.util.a.p(bArr);
        this.f42414b = org.bouncycastle.util.a.p(bArr2);
        this.f42415c = i10;
    }

    public byte[] a() {
        return org.bouncycastle.util.a.p(this.f42413a);
    }

    public byte[] b() {
        return org.bouncycastle.util.a.p(this.f42414b);
    }

    public int c() {
        return this.f42415c;
    }
}
