package ip;

import np.n1;
import org.bouncycastle.crypto.a0;

/* JADX INFO: loaded from: classes5.dex */
public class p implements a0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f35552e = 64;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte f35553f = 54;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte f35554g = 92;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.s f35555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f35556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f35557c = new byte[64];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f35558d = new byte[64];

    public p(org.bouncycastle.crypto.s sVar) {
        this.f35555a = sVar;
        this.f35556b = sVar.h();
    }

    @Override // org.bouncycastle.crypto.a0
    public void a(org.bouncycastle.crypto.k kVar) {
        this.f35555a.reset();
        byte[] bArrA = ((n1) kVar).a();
        if (bArrA.length <= 64) {
            System.arraycopy(bArrA, 0, this.f35557c, 0, bArrA.length);
            int length = bArrA.length;
            while (true) {
                byte[] bArr = this.f35557c;
                if (length >= bArr.length) {
                    break;
                }
                bArr[length] = 0;
                length++;
            }
        } else {
            this.f35555a.update(bArrA, 0, bArrA.length);
            this.f35555a.c(this.f35557c, 0);
            int i10 = this.f35556b;
            while (true) {
                byte[] bArr2 = this.f35557c;
                if (i10 >= bArr2.length) {
                    break;
                }
                bArr2[i10] = 0;
                i10++;
            }
        }
        byte[] bArr3 = this.f35557c;
        byte[] bArr4 = new byte[bArr3.length];
        this.f35558d = bArr4;
        System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
        int i11 = 0;
        while (true) {
            byte[] bArr5 = this.f35557c;
            if (i11 >= bArr5.length) {
                break;
            }
            bArr5[i11] = (byte) (bArr5[i11] ^ 54);
            i11++;
        }
        int i12 = 0;
        while (true) {
            byte[] bArr6 = this.f35558d;
            if (i12 >= bArr6.length) {
                org.bouncycastle.crypto.s sVar = this.f35555a;
                byte[] bArr7 = this.f35557c;
                sVar.update(bArr7, 0, bArr7.length);
                return;
            }
            bArr6[i12] = (byte) (bArr6[i12] ^ 92);
            i12++;
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public String b() {
        return this.f35555a.b() + "/HMAC";
    }

    @Override // org.bouncycastle.crypto.a0
    public int c(byte[] bArr, int i10) {
        int i11 = this.f35556b;
        byte[] bArr2 = new byte[i11];
        this.f35555a.c(bArr2, 0);
        org.bouncycastle.crypto.s sVar = this.f35555a;
        byte[] bArr3 = this.f35558d;
        sVar.update(bArr3, 0, bArr3.length);
        this.f35555a.update(bArr2, 0, i11);
        int iC = this.f35555a.c(bArr, i10);
        reset();
        return iC;
    }

    @Override // org.bouncycastle.crypto.a0
    public int d() {
        return this.f35556b;
    }

    public org.bouncycastle.crypto.s e() {
        return this.f35555a;
    }

    @Override // org.bouncycastle.crypto.a0
    public void reset() {
        this.f35555a.reset();
        org.bouncycastle.crypto.s sVar = this.f35555a;
        byte[] bArr = this.f35557c;
        sVar.update(bArr, 0, bArr.length);
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte b10) {
        this.f35555a.update(b10);
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte[] bArr, int i10, int i11) {
        this.f35555a.update(bArr, i10, i11);
    }
}
