package ms;

import ft.u;
import java.security.SecureRandom;
import np.w1;
import org.bouncycastle.crypto.InvalidCipherTextException;
import zo.c0;

/* JADX INFO: loaded from: classes6.dex */
public class n implements js.e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f41646h = "1.3.6.1.4.1.8301.3.1.3.4.2.3";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f41647i = "SHA1PRNG";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final byte[] f41648j = "a predetermined public constant".getBytes();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.s f41649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SecureRandom f41650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f41651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f41652d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f41653e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f41654f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f41655g;

    @Override // js.e
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        this.f41655g = z10;
        if (!z10) {
            g gVar = (g) kVar;
            this.f41651c = gVar;
            e(gVar);
        } else {
            if (!(kVar instanceof w1)) {
                this.f41650b = org.bouncycastle.crypto.n.f();
                h hVar = (h) kVar;
                this.f41651c = hVar;
                f(hVar);
                return;
            }
            w1 w1Var = (w1) kVar;
            this.f41650b = w1Var.b();
            h hVar2 = (h) w1Var.a();
            this.f41651c = hVar2;
            f(hVar2);
        }
    }

    @Override // js.e
    public byte[] b(byte[] bArr) throws InvalidCipherTextException {
        byte[] bArr2;
        if (this.f41655g) {
            throw new IllegalStateException("cipher initialised for decryption");
        }
        int i10 = this.f41652d >> 3;
        if (bArr.length < i10) {
            throw new InvalidCipherTextException("Bad Padding: Ciphertext too short.");
        }
        int iH = this.f41649a.h();
        int i11 = this.f41653e >> 3;
        int iBitLength = (u.a(this.f41652d, this.f41654f).bitLength() - 1) >> 3;
        int length = bArr.length - i10;
        if (length > 0) {
            byte[][] bArrK = ft.c.k(bArr, length);
            bArr2 = bArrK[0];
            bArr = bArrK[1];
        } else {
            bArr2 = new byte[0];
        }
        ft.g[] gVarArrA = f.a((g) this.f41651c, ft.g.f(this.f41652d, bArr));
        byte[] bArrB = gVarArrA[0].b();
        ft.g gVar = gVarArrA[1];
        if (bArrB.length > i11) {
            bArrB = ft.c.m(bArrB, 0, i11);
        }
        byte[] bArrA = a.a(this.f41652d, this.f41654f, gVar);
        if (bArrA.length < iBitLength) {
            byte[] bArr3 = new byte[iBitLength];
            System.arraycopy(bArrA, 0, bArr3, iBitLength - bArrA.length, bArrA.length);
            bArrA = bArr3;
        }
        byte[] bArrB2 = ft.c.b(ft.c.b(bArr2, bArrA), bArrB);
        int length2 = bArrB2.length - iH;
        byte[][] bArrK2 = ft.c.k(bArrB2, iH);
        byte[] bArr4 = bArrK2[0];
        byte[] bArr5 = bArrK2[1];
        byte[] bArr6 = new byte[this.f41649a.h()];
        this.f41649a.update(bArr5, 0, bArr5.length);
        this.f41649a.c(bArr6, 0);
        for (int i12 = iH - 1; i12 >= 0; i12--) {
            bArr6[i12] = (byte) (bArr6[i12] ^ bArr4[i12]);
        }
        pp.c cVar = new pp.c(new c0());
        cVar.c(bArr6);
        byte[] bArr7 = new byte[length2];
        cVar.d(bArr7);
        for (int i13 = length2 - 1; i13 >= 0; i13--) {
            bArr7[i13] = (byte) (bArr7[i13] ^ bArr5[i13]);
        }
        byte[] bArr8 = f41648j;
        byte[][] bArrK3 = ft.c.k(bArr7, length2 - bArr8.length);
        byte[] bArr9 = bArrK3[0];
        if (ft.c.g(bArrK3[1], bArr8)) {
            return bArr9;
        }
        throw new InvalidCipherTextException("Bad Padding: invalid ciphertext");
    }

    @Override // js.e
    public byte[] c(byte[] bArr) {
        if (!this.f41655g) {
            throw new IllegalStateException("cipher initialised for decryption");
        }
        int iH = this.f41649a.h();
        int i10 = this.f41653e >> 3;
        int iBitLength = (u.a(this.f41652d, this.f41654f).bitLength() - 1) >> 3;
        byte[] bArr2 = f41648j;
        int length = ((i10 + iBitLength) - iH) - bArr2.length;
        if (bArr.length > length) {
            length = bArr.length;
        }
        int length2 = bArr2.length + length;
        int i11 = ((length2 + iH) - i10) - iBitLength;
        byte[] bArr3 = new byte[length2];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, length, bArr2.length);
        byte[] bArr4 = new byte[iH];
        this.f41650b.nextBytes(bArr4);
        pp.c cVar = new pp.c(new c0());
        cVar.c(bArr4);
        byte[] bArr5 = new byte[length2];
        cVar.d(bArr5);
        for (int i12 = length2 - 1; i12 >= 0; i12--) {
            bArr5[i12] = (byte) (bArr5[i12] ^ bArr3[i12]);
        }
        byte[] bArr6 = new byte[this.f41649a.h()];
        this.f41649a.update(bArr5, 0, length2);
        this.f41649a.c(bArr6, 0);
        for (int i13 = iH - 1; i13 >= 0; i13--) {
            bArr6[i13] = (byte) (bArr6[i13] ^ bArr4[i13]);
        }
        byte[] bArrB = ft.c.b(bArr6, bArr5);
        byte[] bArr7 = new byte[0];
        if (i11 > 0) {
            bArr7 = new byte[i11];
            System.arraycopy(bArrB, 0, bArr7, 0, i11);
        }
        byte[] bArr8 = new byte[iBitLength];
        System.arraycopy(bArrB, i11, bArr8, 0, iBitLength);
        byte[] bArr9 = new byte[i10];
        System.arraycopy(bArrB, iBitLength + i11, bArr9, 0, i10);
        byte[] bArrB2 = f.b((h) this.f41651c, ft.g.f(this.f41653e, bArr9), a.b(this.f41652d, this.f41654f, bArr8)).b();
        return i11 > 0 ? ft.c.b(bArr7, bArrB2) : bArrB2;
    }

    public int d(d dVar) {
        if (dVar instanceof h) {
            return ((h) dVar).g();
        }
        if (dVar instanceof g) {
            return ((g) dVar).i();
        }
        throw new IllegalArgumentException("unsupported type");
    }

    public final void e(g gVar) {
        this.f41649a = s.a(gVar.d());
        this.f41652d = gVar.i();
        this.f41653e = gVar.h();
        this.f41654f = gVar.l();
    }

    public final void f(h hVar) {
        this.f41649a = s.a(hVar.d());
        this.f41652d = hVar.g();
        this.f41653e = hVar.f();
        this.f41654f = hVar.h();
    }
}
