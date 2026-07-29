package fp;

/* JADX INFO: loaded from: classes5.dex */
public class g extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f28640c = 20;

    @Override // fp.f, org.bouncycastle.crypto.j
    public byte[] a() {
        int i10 = this.f44688b;
        byte[] bArr = new byte[i10];
        int i11 = 0;
        while (true) {
            this.f44687a.nextBytes(bArr);
            np.k.c(bArr);
            i11++;
            if (i11 >= 20 || (!np.l.g(bArr, 0, i10) && np.l.f(bArr, 0))) {
                break;
            }
        }
        if (np.l.g(bArr, 0, i10) || !np.l.f(bArr, 0)) {
            throw new IllegalStateException("Unable to generate DES-EDE key");
        }
        return bArr;
    }

    @Override // fp.f, org.bouncycastle.crypto.j
    public void b(org.bouncycastle.crypto.y yVar) {
        this.f44687a = yVar.a();
        int iB = (yVar.b() + 7) / 8;
        this.f44688b = iB;
        if (iB == 0 || iB == 21) {
            this.f44688b = 24;
        } else if (iB == 14) {
            this.f44688b = 16;
        } else if (iB != 24 && iB != 16) {
            throw new IllegalArgumentException("DESede key must be 192 or 128 bits long.");
        }
    }
}
