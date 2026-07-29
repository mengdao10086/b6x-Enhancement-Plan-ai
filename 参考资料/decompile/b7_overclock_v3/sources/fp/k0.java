package fp;

/* JADX INFO: loaded from: classes5.dex */
public class k0 extends org.bouncycastle.crypto.j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte f28660c = -4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte f28661d = 15;

    public static void c(byte[] bArr) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
        }
        d(bArr[3], (byte) 15);
        d(bArr[7], (byte) 15);
        d(bArr[11], (byte) 15);
        d(bArr[15], (byte) 15);
        d(bArr[4], (byte) -4);
        d(bArr[8], (byte) -4);
        d(bArr[12], (byte) -4);
    }

    public static void d(byte b10, byte b11) {
        if ((b10 & (~b11)) != 0) {
            throw new IllegalArgumentException("Invalid format for r portion of Poly1305 key.");
        }
    }

    public static void e(byte[] bArr) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
        }
        bArr[3] = (byte) (bArr[3] & 15);
        bArr[7] = (byte) (bArr[7] & 15);
        bArr[11] = (byte) (bArr[11] & 15);
        bArr[15] = (byte) (bArr[15] & 15);
        bArr[4] = (byte) (bArr[4] & (-4));
        bArr[8] = (byte) (bArr[8] & (-4));
        bArr[12] = (byte) (bArr[12] & (-4));
    }

    @Override // org.bouncycastle.crypto.j
    public byte[] a() {
        byte[] bArrA = super.a();
        e(bArrA);
        return bArrA;
    }

    @Override // org.bouncycastle.crypto.j
    public void b(org.bouncycastle.crypto.y yVar) {
        super.b(new org.bouncycastle.crypto.y(yVar.a(), 256));
    }
}
