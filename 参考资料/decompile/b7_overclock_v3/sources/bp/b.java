package bp;

import java.security.SecureRandom;
import np.w1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.k;
import org.bouncycastle.crypto.n;
import org.bouncycastle.crypto.s;
import org.bouncycastle.crypto.util.f;
import org.bouncycastle.util.o;

/* JADX INFO: loaded from: classes5.dex */
public class b implements org.bouncycastle.crypto.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f9526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s f9527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public org.bouncycastle.crypto.b f9528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SecureRandom f9529d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f9530e;

    public b(org.bouncycastle.crypto.b bVar) {
        this(bVar, f.c(), null);
    }

    public b(org.bouncycastle.crypto.b bVar, s sVar) {
        this(bVar, sVar, null);
    }

    public b(org.bouncycastle.crypto.b bVar, s sVar, s sVar2, byte[] bArr) {
        this.f9528c = bVar;
        this.f9527b = sVar2;
        this.f9526a = new byte[sVar.h()];
        sVar.reset();
        if (bArr != null) {
            sVar.update(bArr, 0, bArr.length);
        }
        sVar.c(this.f9526a, 0);
    }

    public b(org.bouncycastle.crypto.b bVar, s sVar, byte[] bArr) {
        this(bVar, sVar, sVar, bArr);
    }

    @Override // org.bouncycastle.crypto.b
    public void a(boolean z10, k kVar) {
        this.f9529d = kVar instanceof w1 ? ((w1) kVar).b() : n.f();
        this.f9528c.a(z10, kVar);
        this.f9530e = z10;
    }

    @Override // org.bouncycastle.crypto.b
    public int b() {
        int iB = this.f9528c.b();
        return this.f9530e ? (iB - 1) - (this.f9526a.length * 2) : iB;
    }

    @Override // org.bouncycastle.crypto.b
    public byte[] c(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        return this.f9530e ? f(bArr, i10, i11) : e(bArr, i10, i11);
    }

    @Override // org.bouncycastle.crypto.b
    public int d() {
        int iD = this.f9528c.d();
        return this.f9530e ? iD : (iD - 1) - (this.f9526a.length * 2);
    }

    public byte[] e(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArrC = this.f9528c.c(bArr, i10, i11);
        int iD = this.f9528c.d();
        byte[] bArr4 = new byte[iD];
        boolean z10 = iD < (this.f9526a.length * 2) + 1;
        if (bArrC.length <= iD) {
            System.arraycopy(bArrC, 0, bArr4, iD - bArrC.length, bArrC.length);
        } else {
            System.arraycopy(bArrC, 0, bArr4, 0, iD);
            z10 = true;
        }
        byte[] bArr5 = this.f9526a;
        byte[] bArrH = h(bArr4, bArr5.length, iD - bArr5.length, bArr5.length);
        int i12 = 0;
        while (true) {
            bArr2 = this.f9526a;
            if (i12 == bArr2.length) {
                break;
            }
            bArr4[i12] = (byte) (bArr4[i12] ^ bArrH[i12]);
            i12++;
        }
        byte[] bArrH2 = h(bArr4, 0, bArr2.length, iD - bArr2.length);
        for (int length = this.f9526a.length; length != iD; length++) {
            bArr4[length] = (byte) (bArr4[length] ^ bArrH2[length - this.f9526a.length]);
        }
        int i13 = 0;
        boolean z11 = false;
        while (true) {
            bArr3 = this.f9526a;
            if (i13 == bArr3.length) {
                break;
            }
            if (bArr3[i13] != bArr4[bArr3.length + i13]) {
                z11 = true;
            }
            i13++;
        }
        int i14 = iD;
        for (int length2 = bArr3.length * 2; length2 != iD; length2++) {
            if ((bArr4[length2] != 0) & (i14 == iD)) {
                i14 = length2;
            }
        }
        boolean z12 = i14 > iD + (-1);
        boolean z13 = bArr4[i14] != 1;
        int i15 = i14 + 1;
        if ((z12 | z13) || (z10 | z11)) {
            org.bouncycastle.util.a.d0(bArr4, (byte) 0);
            throw new InvalidCipherTextException("data wrong");
        }
        int i16 = iD - i15;
        byte[] bArr6 = new byte[i16];
        System.arraycopy(bArr4, i15, bArr6, 0, i16);
        org.bouncycastle.util.a.d0(bArr4, (byte) 0);
        return bArr6;
    }

    public byte[] f(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        if (i11 > b()) {
            throw new DataLengthException("input data too long");
        }
        int iB = b() + 1 + (this.f9526a.length * 2);
        byte[] bArr2 = new byte[iB];
        int i12 = iB - i11;
        System.arraycopy(bArr, i10, bArr2, i12, i11);
        bArr2[i12 - 1] = 1;
        byte[] bArr3 = this.f9526a;
        System.arraycopy(bArr3, 0, bArr2, bArr3.length, bArr3.length);
        int length = this.f9526a.length;
        byte[] bArr4 = new byte[length];
        this.f9529d.nextBytes(bArr4);
        byte[] bArrH = h(bArr4, 0, length, iB - this.f9526a.length);
        for (int length2 = this.f9526a.length; length2 != iB; length2++) {
            bArr2[length2] = (byte) (bArr2[length2] ^ bArrH[length2 - this.f9526a.length]);
        }
        System.arraycopy(bArr4, 0, bArr2, 0, this.f9526a.length);
        byte[] bArr5 = this.f9526a;
        byte[] bArrH2 = h(bArr2, bArr5.length, iB - bArr5.length, bArr5.length);
        for (int i13 = 0; i13 != this.f9526a.length; i13++) {
            bArr2[i13] = (byte) (bArr2[i13] ^ bArrH2[i13]);
        }
        return this.f9528c.c(bArr2, 0, iB);
    }

    public org.bouncycastle.crypto.b g() {
        return this.f9528c;
    }

    public final byte[] h(byte[] bArr, int i10, int i11, int i12) {
        byte[] bArr2 = new byte[i12];
        int iH = this.f9527b.h();
        byte[] bArr3 = new byte[iH];
        byte[] bArr4 = new byte[4];
        this.f9527b.reset();
        int i13 = 0;
        while (i13 < i12 / iH) {
            o.h(i13, bArr4, 0);
            this.f9527b.update(bArr, i10, i11);
            this.f9527b.update(bArr4, 0, 4);
            this.f9527b.c(bArr3, 0);
            System.arraycopy(bArr3, 0, bArr2, i13 * iH, iH);
            i13++;
        }
        int i14 = iH * i13;
        if (i14 < i12) {
            o.h(i13, bArr4, 0);
            this.f9527b.update(bArr, i10, i11);
            this.f9527b.update(bArr4, 0, 4);
            this.f9527b.c(bArr3, 0);
            System.arraycopy(bArr3, 0, bArr2, i14, i12 - i14);
        }
        return bArr2;
    }
}
