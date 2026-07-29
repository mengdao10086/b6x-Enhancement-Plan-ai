package np;

/* JADX INFO: loaded from: classes5.dex */
public class y1 implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f42577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public org.bouncycastle.crypto.k f42578b;

    public y1(org.bouncycastle.crypto.k kVar, byte[] bArr) {
        this(kVar, bArr, 0, bArr.length);
    }

    public y1(org.bouncycastle.crypto.k kVar, byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        this.f42577a = bArr2;
        this.f42578b = kVar;
        System.arraycopy(bArr, i10, bArr2, 0, i11);
    }

    public org.bouncycastle.crypto.k a() {
        return this.f42578b;
    }

    public byte[] b() {
        return this.f42577a;
    }
}
