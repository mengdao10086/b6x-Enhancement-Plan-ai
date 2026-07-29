package np;

/* JADX INFO: loaded from: classes5.dex */
public class o1 implements org.bouncycastle.crypto.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f42496a;

    public o1(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public o1(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        this.f42496a = bArr2;
        System.arraycopy(bArr, i10, bArr2, 0, i11);
    }

    public byte[] a() {
        return this.f42496a;
    }
}
