package np;

/* JADX INFO: loaded from: classes5.dex */
public class v1 implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f42556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public org.bouncycastle.crypto.k f42557b;

    public v1(org.bouncycastle.crypto.k kVar, byte[] bArr) {
        this(kVar, bArr, 0, bArr.length);
    }

    public v1(org.bouncycastle.crypto.k kVar, byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        this.f42556a = bArr2;
        this.f42557b = kVar;
        System.arraycopy(bArr, i10, bArr2, 0, i11);
    }

    public byte[] a() {
        return this.f42556a;
    }

    public org.bouncycastle.crypto.k b() {
        return this.f42557b;
    }
}
