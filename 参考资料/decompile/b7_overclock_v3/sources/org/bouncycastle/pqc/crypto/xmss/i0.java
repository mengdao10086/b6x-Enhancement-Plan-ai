package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.bouncycastle.pqc.crypto.ExhaustedPrivateKeyException;
import org.bouncycastle.pqc.crypto.xmss.g;
import org.bouncycastle.pqc.crypto.xmss.h0;

/* JADX INFO: loaded from: classes6.dex */
public class i0 implements js.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e0 f45903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f45904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d0 f45905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f45906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f45907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f45908f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f45909g;

    @Override // js.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        d0 d0VarE;
        if (z10) {
            this.f45908f = true;
            this.f45909g = false;
            e0 e0Var = (e0) kVar;
            this.f45903a = e0Var;
            d0VarE = e0Var.i();
        } else {
            this.f45908f = false;
            f0 f0Var = (f0) kVar;
            this.f45904b = f0Var;
            d0VarE = f0Var.e();
        }
        this.f45905c = d0VarE;
        h hVarI = this.f45905c.i();
        this.f45906d = hVarI;
        this.f45907e = hVarI.d();
    }

    @Override // js.f
    public byte[] b(byte[] bArr) {
        byte[] byteArray;
        Objects.requireNonNull(bArr, "message == null");
        if (!this.f45908f) {
            throw new IllegalStateException("signer not initialized for signature generation");
        }
        e0 e0Var = this.f45903a;
        if (e0Var == null) {
            throw new IllegalStateException("signing key no longer usable");
        }
        synchronized (e0Var) {
            if (this.f45903a.V() <= 0) {
                throw new ExhaustedPrivateKeyException("no usages of private key remaining");
            }
            if (this.f45903a.f().a().isEmpty()) {
                throw new IllegalStateException("not initialized");
            }
            try {
                int iG = this.f45903a.g();
                this.f45909g = true;
                long j10 = iG;
                byte[] bArrD = this.f45907e.d(this.f45903a.l(), k0.t(j10, 32));
                byteArray = new h0.b(this.f45905c).l(iG).m(bArrD).h(f(this.f45907e.c(org.bouncycastle.util.a.C(bArrD, this.f45903a.k(), k0.t(j10, this.f45905c.h())), bArr), (g) new g.b().p(iG).e())).f(this.f45903a.f().a()).e().toByteArray();
            } finally {
                this.f45903a.f().m();
                this.f45903a.n();
            }
        }
        return byteArray;
    }

    @Override // js.g
    public np.c c() {
        synchronized (this.f45903a) {
            if (this.f45909g) {
                e0 e0Var = this.f45903a;
                this.f45903a = null;
                return e0Var;
            }
            e0 e0Var2 = this.f45903a;
            if (e0Var2 != null) {
                this.f45903a = e0Var2.h();
            }
            return e0Var2;
        }
    }

    @Override // js.f
    public boolean d(byte[] bArr, byte[] bArr2) {
        h0 h0VarE = new h0.b(this.f45905c).n(bArr2).e();
        int iD = h0VarE.d();
        this.f45906d.l(new byte[this.f45905c.h()], this.f45904b.f());
        long j10 = iD;
        byte[] bArrC = this.f45907e.c(org.bouncycastle.util.a.C(h0VarE.e(), this.f45904b.g(), k0.t(j10, this.f45905c.h())), bArr);
        int iB = this.f45905c.b();
        return org.bouncycastle.util.a.I(l0.a(this.f45906d, iB, bArrC, h0VarE, (g) new g.b().p(iD).e(), k0.k(j10, iB)).b(), this.f45904b.g());
    }

    public long e() {
        return this.f45903a.V();
    }

    public final m f(byte[] bArr, g gVar) {
        if (bArr.length != this.f45905c.h()) {
            throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
        }
        Objects.requireNonNull(gVar, "otsHashAddress == null");
        h hVar = this.f45906d;
        hVar.l(hVar.k(this.f45903a.m(), gVar), this.f45903a.j());
        return this.f45906d.m(bArr, gVar);
    }
}
