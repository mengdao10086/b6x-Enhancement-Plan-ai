package ss;

import java.security.SecureRandom;
import np.w1;

/* JADX INFO: loaded from: classes6.dex */
public class r implements js.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f50503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q f50504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecureRandom f50505c;

    @Override // js.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (!z10) {
            this.f50504b = (q) kVar;
        } else {
            if (!(kVar instanceof w1)) {
                this.f50503a = (p) kVar;
                return;
            }
            w1 w1Var = (w1) kVar;
            this.f50503a = (p) w1Var.a();
            this.f50505c = w1Var.b();
        }
    }

    @Override // js.f
    public byte[] b(byte[] bArr) {
        k kVarA = this.f50503a.d().a();
        byte[] bArr2 = new byte[kVarA.f50451b];
        SecureRandom secureRandom = this.f50505c;
        if (secureRandom != null) {
            secureRandom.nextBytes(bArr2);
        }
        b bVar = new b(kVarA);
        byte[] bArrE = kVarA.e(this.f50503a.f50500c.f50449b, bArr2, bArr);
        f fVar = this.f50503a.f50501d;
        d dVarC = kVarA.c(bArrE, fVar.f50439a, fVar.f50440b, bArr);
        byte[] bArr3 = dVarC.f50436c;
        long j10 = dVarC.f50434a;
        int i10 = dVarC.f50435b;
        a aVar = new a();
        aVar.n(3);
        aVar.k(j10);
        aVar.i(i10);
        p pVar = this.f50503a;
        h[] hVarArrD = bVar.d(bArr3, pVar.f50500c.f50448a, pVar.f50501d.f50439a, aVar);
        byte[] bArrB = bVar.b(hVarArrD, bArr3, this.f50503a.f50501d.f50439a, aVar);
        new a().n(2);
        byte[] bArrA = new c(kVarA, this.f50503a.h(), this.f50503a.g()).a(bArrB, j10, i10);
        int length = hVarArrD.length + 2;
        byte[][] bArr4 = new byte[length][];
        int i11 = 0;
        bArr4[0] = bArrE;
        while (i11 != hVarArrD.length) {
            int i12 = i11 + 1;
            bArr4[i12] = org.bouncycastle.util.a.B(hVarArrD[i11].f50445b, org.bouncycastle.util.a.E(hVarArrD[i11].f50444a));
            i11 = i12;
        }
        bArr4[length - 1] = bArrA;
        return org.bouncycastle.util.a.E(bArr4);
    }

    @Override // js.f
    public boolean d(byte[] bArr, byte[] bArr2) {
        k kVarA = this.f50504b.d().a();
        a aVar = new a();
        g gVar = new g(kVarA.f50451b, kVarA.f50459j, kVarA.f50458i, kVarA.f50457h, kVarA.f50461l, kVarA.f50454e, bArr2);
        byte[] bArrA = gVar.a();
        h[] hVarArrB = gVar.b();
        i[] iVarArrC = gVar.c();
        d dVarC = kVarA.c(bArrA, this.f50504b.f(), this.f50504b.e(), bArr);
        byte[] bArr3 = dVarC.f50436c;
        long j10 = dVarC.f50434a;
        int i10 = dVarC.f50435b;
        aVar.j(0);
        aVar.k(j10);
        aVar.n(3);
        aVar.i(i10);
        byte[] bArrB = new b(kVarA).b(hVarArrB, bArr3, this.f50504b.f(), aVar);
        aVar.n(2);
        return new c(kVarA, null, this.f50504b.f()).c(bArrB, iVarArrC, this.f50504b.f(), j10, i10, this.f50504b.e());
    }
}
