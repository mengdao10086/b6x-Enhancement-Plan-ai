package fp;

/* JADX INFO: loaded from: classes5.dex */
public class f extends org.bouncycastle.crypto.j {
    @Override // org.bouncycastle.crypto.j
    public byte[] a() {
        byte[] bArr = new byte[8];
        do {
            this.f44687a.nextBytes(bArr);
            np.k.c(bArr);
        } while (np.k.b(bArr, 0));
        return bArr;
    }

    @Override // org.bouncycastle.crypto.j
    public void b(org.bouncycastle.crypto.y yVar) {
        super.b(yVar);
        int i10 = this.f44688b;
        if (i10 == 0 || i10 == 7) {
            this.f44688b = 8;
        } else if (i10 != 8) {
            throw new IllegalArgumentException("DES key must be 64 bits long.");
        }
    }
}
