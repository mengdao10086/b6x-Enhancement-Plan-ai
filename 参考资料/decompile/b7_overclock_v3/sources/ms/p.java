package ms;

import java.security.SecureRandom;
import np.w1;
import org.bouncycastle.crypto.InvalidCipherTextException;
import zo.c0;

/* JADX INFO: loaded from: classes6.dex */
public class p implements js.e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f41663h = "1.3.6.1.4.1.8301.3.1.3.4.2.2";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.s f41664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SecureRandom f41665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f41666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f41667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f41668e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f41669f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f41670g;

    @Override // js.e
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        this.f41670g = z10;
        if (!z10) {
            g gVar = (g) kVar;
            this.f41669f = gVar;
            g(gVar);
        } else {
            if (!(kVar instanceof w1)) {
                this.f41665b = org.bouncycastle.crypto.n.f();
                h hVar = (h) kVar;
                this.f41669f = hVar;
                h(hVar);
                return;
            }
            w1 w1Var = (w1) kVar;
            this.f41665b = w1Var.b();
            h hVar2 = (h) w1Var.a();
            this.f41669f = hVar2;
            h(hVar2);
        }
    }

    @Override // js.e
    public byte[] b(byte[] bArr) throws InvalidCipherTextException {
        if (this.f41670g) {
            throw new IllegalStateException("cipher initialised for decryption");
        }
        int i10 = (this.f41666c + 7) >> 3;
        int length = bArr.length - i10;
        byte[][] bArrK = ft.c.k(bArr, i10);
        byte[] bArr2 = bArrK[0];
        byte[] bArr3 = bArrK[1];
        ft.g[] gVarArrA = f.a((g) this.f41669f, ft.g.f(this.f41666c, bArr2));
        byte[] bArrB = gVarArrA[0].b();
        ft.g gVar = gVarArrA[1];
        pp.c cVar = new pp.c(new c0());
        cVar.c(bArrB);
        byte[] bArr4 = new byte[length];
        cVar.d(bArr4);
        for (int i11 = 0; i11 < length; i11++) {
            bArr4[i11] = (byte) (bArr4[i11] ^ bArr3[i11]);
        }
        this.f41664a.update(bArr4, 0, length);
        byte[] bArr5 = new byte[this.f41664a.h()];
        this.f41664a.c(bArr5, 0);
        if (a.b(this.f41666c, this.f41668e, bArr5).equals(gVar)) {
            return ft.c.k(bArr4, length - (this.f41667d >> 3))[0];
        }
        throw new InvalidCipherTextException("Bad Padding: Invalid ciphertext.");
    }

    @Override // js.e
    public byte[] c(byte[] bArr) {
        if (!this.f41670g) {
            throw new IllegalStateException("cipher initialised for decryption");
        }
        int i10 = this.f41667d >> 3;
        byte[] bArr2 = new byte[i10];
        this.f41665b.nextBytes(bArr2);
        ft.g gVar = new ft.g(this.f41667d, this.f41665b);
        byte[] bArrB = gVar.b();
        byte[] bArrB2 = ft.c.b(bArr, bArr2);
        this.f41664a.update(bArrB2, 0, bArrB2.length);
        byte[] bArr3 = new byte[this.f41664a.h()];
        this.f41664a.c(bArr3, 0);
        byte[] bArrB3 = f.b((h) this.f41669f, gVar, a.b(this.f41666c, this.f41668e, bArr3)).b();
        pp.c cVar = new pp.c(new c0());
        cVar.c(bArrB);
        byte[] bArr4 = new byte[bArr.length + i10];
        cVar.d(bArr4);
        for (int i11 = 0; i11 < bArr.length; i11++) {
            bArr4[i11] = (byte) (bArr4[i11] ^ bArr[i11]);
        }
        for (int i12 = 0; i12 < i10; i12++) {
            int length = bArr.length + i12;
            bArr4[length] = (byte) (bArr4[length] ^ bArr2[i12]);
        }
        return ft.c.b(bArrB3, bArr4);
    }

    public int d(int i10) {
        return 0;
    }

    public int e(int i10) {
        return 0;
    }

    public int f(d dVar) throws IllegalArgumentException {
        if (dVar instanceof h) {
            return ((h) dVar).g();
        }
        if (dVar instanceof g) {
            return ((g) dVar).i();
        }
        throw new IllegalArgumentException("unsupported type");
    }

    public final void g(g gVar) {
        this.f41664a = s.a(gVar.d());
        this.f41666c = gVar.i();
        this.f41667d = gVar.h();
        this.f41668e = gVar.l();
    }

    public final void h(h hVar) {
        this.f41664a = s.a(hVar.d());
        this.f41666c = hVar.g();
        this.f41667d = hVar.f();
        this.f41668e = hVar.h();
    }
}
