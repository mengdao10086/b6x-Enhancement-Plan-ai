package np;

/* JADX INFO: loaded from: classes5.dex */
public class z1 implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f42584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public org.bouncycastle.crypto.k f42585b;

    public z1(org.bouncycastle.crypto.k kVar, byte[] bArr) {
        this(kVar, bArr, 0, bArr.length);
    }

    public z1(org.bouncycastle.crypto.k kVar, byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        this.f42584a = bArr2;
        this.f42585b = kVar;
        System.arraycopy(bArr, i10, bArr2, 0, i11);
    }

    public org.bouncycastle.crypto.k a() {
        return this.f42585b;
    }

    public byte[] b() {
        return this.f42584a;
    }
}
