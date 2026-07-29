package ms;

import java.security.SecureRandom;
import np.w1;
import org.bouncycastle.crypto.InvalidCipherTextException;
import zo.c0;

/* JADX INFO: loaded from: classes6.dex */
public class j implements js.e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f41627h = "1.3.6.1.4.1.8301.3.1.3.4.2.1";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f41628i = "SHA1PRNG";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.s f41629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SecureRandom f41630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f41631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f41632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f41633e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f41634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f41635g;

    @Override // js.e
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        this.f41635g = z10;
        if (!z10) {
            g gVar = (g) kVar;
            this.f41634f = gVar;
            e(gVar);
        } else {
            if (!(kVar instanceof w1)) {
                this.f41630b = org.bouncycastle.crypto.n.f();
                h hVar = (h) kVar;
                this.f41634f = hVar;
                f(hVar);
                return;
            }
            w1 w1Var = (w1) kVar;
            this.f41630b = w1Var.b();
            h hVar2 = (h) w1Var.a();
            this.f41634f = hVar2;
            f(hVar2);
        }
    }

    @Override // js.e
    public byte[] b(byte[] bArr) throws InvalidCipherTextException {
        if (this.f41635g) {
            throw new IllegalStateException("cipher initialised for decryption");
        }
        int i10 = (this.f41631c + 7) >> 3;
        int length = bArr.length - i10;
        byte[][] bArrK = ft.c.k(bArr, i10);
        byte[] bArr2 = bArrK[0];
        byte[] bArr3 = bArrK[1];
        ft.g[] gVarArrA = f.a((g) this.f41634f, ft.g.f(this.f41631c, bArr2));
        byte[] bArrB = gVarArrA[0].b();
        ft.g gVar = gVarArrA[1];
        pp.c cVar = new pp.c(new c0());
        cVar.c(bArrB);
        byte[] bArr4 = new byte[length];
        cVar.d(bArr4);
        for (int i11 = 0; i11 < length; i11++) {
            bArr4[i11] = (byte) (bArr4[i11] ^ bArr3[i11]);
        }
        byte[] bArrB2 = ft.c.b(bArrB, bArr4);
        byte[] bArr5 = new byte[this.f41629a.h()];
        this.f41629a.update(bArrB2, 0, bArrB2.length);
        this.f41629a.c(bArr5, 0);
        if (a.b(this.f41631c, this.f41633e, bArr5).equals(gVar)) {
            return bArr4;
        }
        throw new InvalidCipherTextException("Bad Padding: invalid ciphertext");
    }

    @Override // js.e
    public byte[] c(byte[] bArr) {
        if (!this.f41635g) {
            throw new IllegalStateException("cipher initialised for decryption");
        }
        ft.g gVar = new ft.g(this.f41632d, this.f41630b);
        byte[] bArrB = gVar.b();
        byte[] bArrB2 = ft.c.b(bArrB, bArr);
        this.f41629a.update(bArrB2, 0, bArrB2.length);
        byte[] bArr2 = new byte[this.f41629a.h()];
        this.f41629a.c(bArr2, 0);
        byte[] bArrB3 = f.b((h) this.f41634f, gVar, a.b(this.f41631c, this.f41633e, bArr2)).b();
        pp.c cVar = new pp.c(new c0());
        cVar.c(bArrB);
        byte[] bArr3 = new byte[bArr.length];
        cVar.d(bArr3);
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr3[i10] = (byte) (bArr3[i10] ^ bArr[i10]);
        }
        return ft.c.b(bArrB3, bArr3);
    }

    public int d(d dVar) throws IllegalArgumentException {
        if (dVar instanceof h) {
            return ((h) dVar).g();
        }
        if (dVar instanceof g) {
            return ((g) dVar).i();
        }
        throw new IllegalArgumentException("unsupported type");
    }

    public final void e(g gVar) {
        this.f41629a = s.a(gVar.d());
        this.f41631c = gVar.i();
        this.f41633e = gVar.l();
    }

    public final void f(h hVar) {
        this.f41629a = s.a(hVar.d());
        this.f41631c = hVar.g();
        this.f41632d = hVar.f();
        this.f41633e = hVar.h();
    }
}
