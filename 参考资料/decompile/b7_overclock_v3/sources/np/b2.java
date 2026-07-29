package np;

/* JADX INFO: loaded from: classes5.dex */
public class b2 implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f42366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f42367b;

    public b2(byte[] bArr, int i10) {
        if (bArr.length > 255) {
            throw new IllegalArgumentException("RC5 key length can be no greater than 255");
        }
        byte[] bArr2 = new byte[bArr.length];
        this.f42366a = bArr2;
        this.f42367b = i10;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
    }

    public byte[] a() {
        return this.f42366a;
    }

    public int b() {
        return this.f42367b;
    }
}
