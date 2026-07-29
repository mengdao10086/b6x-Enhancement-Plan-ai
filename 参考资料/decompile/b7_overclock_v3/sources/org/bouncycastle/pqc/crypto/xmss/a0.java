package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.bouncycastle.pqc.crypto.xmss.g;
import org.bouncycastle.pqc.crypto.xmss.g0;
import org.bouncycastle.pqc.crypto.xmss.z;

/* JADX INFO: loaded from: classes6.dex */
public class a0 implements js.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x f45817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y f45818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w f45819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d0 f45820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h f45821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f45822f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f45823g;

    @Override // js.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        w wVarE;
        if (z10) {
            this.f45823g = true;
            this.f45822f = false;
            x xVar = (x) kVar;
            this.f45817a = xVar;
            wVarE = xVar.i();
        } else {
            this.f45823g = false;
            y yVar = (y) kVar;
            this.f45818b = yVar;
            wVarE = yVar.e();
        }
        this.f45819c = wVarE;
        this.f45820d = wVarE.j();
        this.f45821e = this.f45819c.h();
    }

    @Override // js.f
    public byte[] b(byte[] bArr) {
        byte[] byteArray;
        Objects.requireNonNull(bArr, "message == null");
        if (!this.f45823g) {
            throw new IllegalStateException("signer not initialized for signature generation");
        }
        x xVar = this.f45817a;
        if (xVar == null) {
            throw new IllegalStateException("signing key no longer usable");
        }
        synchronized (xVar) {
            if (this.f45817a.V() <= 0) {
                throw new IllegalStateException("no usages of private key remaining");
            }
            if (this.f45817a.f().c()) {
                throw new IllegalStateException("not initialized");
            }
            try {
                BDSStateMap bDSStateMapF = this.f45817a.f();
                long jG = this.f45817a.g();
                this.f45819c.a();
                int iB = this.f45820d.b();
                if (this.f45817a.V() <= 0) {
                    throw new IllegalStateException("index out of bounds");
                }
                byte[] bArrD = this.f45821e.d().d(this.f45817a.l(), k0.t(jG, 32));
                byte[] bArrC = this.f45821e.d().c(org.bouncycastle.util.a.C(bArrD, this.f45817a.k(), k0.t(jG, this.f45819c.g())), bArr);
                this.f45822f = true;
                z zVarF = new z.b(this.f45819c).g(jG).h(bArrD).f();
                long jL = k0.l(jG, iB);
                int iK = k0.k(jG, iB);
                this.f45821e.l(new byte[this.f45819c.g()], this.f45817a.j());
                g gVar = (g) new g.b().i(jL).p(iK).e();
                if (bDSStateMapF.a(0) == null || iK == 0) {
                    bDSStateMapF.d(0, new BDS(this.f45820d, this.f45817a.j(), this.f45817a.m(), gVar));
                }
                zVarF.c().add(new g0.a(this.f45820d).h(f(bArrC, gVar)).f(bDSStateMapF.a(0).a()).e());
                for (int i10 = 1; i10 < this.f45819c.b(); i10++) {
                    XMSSNode xMSSNodeH = bDSStateMapF.a(i10 - 1).h();
                    int iK2 = k0.k(jL, iB);
                    jL = k0.l(jL, iB);
                    g gVar2 = (g) new g.b().h(i10).i(jL).p(iK2).e();
                    m mVarF = f(xMSSNodeH.b(), gVar2);
                    if (bDSStateMapF.a(i10) == null || k0.p(jG, iB, i10)) {
                        bDSStateMapF.d(i10, new BDS(this.f45820d, this.f45817a.j(), this.f45817a.m(), gVar2));
                    }
                    zVarF.c().add(new g0.a(this.f45820d).h(mVarF).f(bDSStateMapF.a(i10).a()).e());
                }
                byteArray = zVarF.toByteArray();
            } finally {
                this.f45817a.n();
            }
        }
        return byteArray;
    }

    @Override // js.g
    public np.c c() {
        if (this.f45822f) {
            x xVar = this.f45817a;
            this.f45817a = null;
            return xVar;
        }
        x xVar2 = this.f45817a;
        if (xVar2 != null) {
            this.f45817a = xVar2.h();
        }
        return xVar2;
    }

    @Override // js.f
    public boolean d(byte[] bArr, byte[] bArr2) {
        Objects.requireNonNull(bArr, "message == null");
        Objects.requireNonNull(bArr2, "signature == null");
        Objects.requireNonNull(this.f45818b, "publicKey == null");
        z zVarF = new z.b(this.f45819c).j(bArr2).f();
        byte[] bArrC = this.f45821e.d().c(org.bouncycastle.util.a.C(zVarF.b(), this.f45818b.g(), k0.t(zVarF.a(), this.f45819c.g())), bArr);
        long jA = zVarF.a();
        int iB = this.f45820d.b();
        long jL = k0.l(jA, iB);
        int iK = k0.k(jA, iB);
        this.f45821e.l(new byte[this.f45819c.g()], this.f45818b.f());
        g gVar = (g) new g.b().i(jL).p(iK).e();
        XMSSNode xMSSNodeA = l0.a(this.f45821e, iB, bArrC, zVarF.c().get(0), gVar, iK);
        int i10 = 1;
        while (i10 < this.f45819c.b()) {
            g0 g0Var = zVarF.c().get(i10);
            int iK2 = k0.k(jL, iB);
            long jL2 = k0.l(jL, iB);
            xMSSNodeA = l0.a(this.f45821e, iB, xMSSNodeA.b(), g0Var, (g) new g.b().h(i10).i(jL2).p(iK2).e(), iK2);
            i10++;
            jL = jL2;
        }
        return org.bouncycastle.util.a.I(xMSSNodeA.b(), this.f45818b.g());
    }

    public long e() {
        return this.f45817a.V();
    }

    public final m f(byte[] bArr, g gVar) {
        if (bArr.length != this.f45819c.g()) {
            throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
        }
        Objects.requireNonNull(gVar, "otsHashAddress == null");
        h hVar = this.f45821e;
        hVar.l(hVar.k(this.f45817a.m(), gVar), this.f45817a.j());
        return this.f45821e.m(bArr, gVar);
    }
}
