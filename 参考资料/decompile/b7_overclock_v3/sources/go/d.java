package go;

import gm.d2;
import gm.j2;
import gm.n2;
import gm.t;
import gm.u;
import gm.y;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import om.r;
import om.w;
import org.bouncycastle.cert.CertIOException;
import org.bouncycastle.cert.crmf.CRMFException;
import zn.a0;
import zn.b0;
import zn.c1;
import zn.j1;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BigInteger f29851a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public cs.f f29855e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k f29856f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public char[] f29857g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b0 f29858h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public r f29860j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public u f29861k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public om.q f29862l;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f29859i = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a0 f29852b = new a0();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public om.h f29853c = new om.h();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f29854d = new ArrayList();

    public d(BigInteger bigInteger) {
        this.f29851a = bigInteger;
    }

    public d a(e eVar) {
        this.f29854d.add(eVar);
        return this;
    }

    public d b(y yVar, boolean z10, gm.h hVar) throws CertIOException {
        b.a(this.f29852b, yVar, z10, hVar);
        return this;
    }

    public d c(y yVar, boolean z10, byte[] bArr) {
        this.f29852b.b(yVar, z10, bArr);
        return this;
    }

    public c d() throws CRMFException {
        om.u uVar;
        om.u uVar2;
        gm.i iVar = new gm.i();
        iVar.a(new t(this.f29851a));
        if (!this.f29852b.h()) {
            this.f29853c.c(this.f29852b.e());
        }
        iVar.a(this.f29853c.b());
        if (!this.f29854d.isEmpty()) {
            gm.i iVar2 = new gm.i();
            for (e eVar : this.f29854d) {
                iVar2.a(new om.a(eVar.getType(), eVar.getValue()));
            }
            iVar.a(new j2(iVar2));
        }
        om.f fVarA = om.f.A(new j2(iVar));
        gm.i iVar3 = new gm.i();
        iVar3.a(fVarA);
        if (this.f29855e == null) {
            r rVar = this.f29860j;
            if (rVar != null) {
                uVar2 = new om.u(this.f29859i, rVar);
            } else {
                om.q qVar = this.f29862l;
                if (qVar == null) {
                    if (this.f29861k != null) {
                        uVar = new om.u();
                    }
                    return new c(om.e.A(new j2(iVar3)));
                }
                uVar2 = new om.u(3, r.y(new n2(false, 3, (gm.h) qVar)));
            }
            iVar3.a(uVar2);
            return new c(om.e.A(new j2(iVar3)));
        }
        om.g gVarY = fVarA.y();
        if (gVarY.E() == null || gVarY.B() == null) {
            o oVar = new o(fVarA.y().B());
            b0 b0Var = this.f29858h;
            if (b0Var != null) {
                oVar.c(b0Var);
            } else {
                oVar.b(new l(this.f29856f), this.f29857g);
            }
            uVar = new om.u(oVar.a(this.f29855e));
        } else {
            uVar = new om.u(new o(fVarA).a(this.f29855e));
        }
        iVar3.a(uVar);
        return new c(om.e.A(new j2(iVar3)));
    }

    public final j1 e(Date date) {
        if (date != null) {
            return new j1(date);
        }
        return null;
    }

    public d f(k kVar, char[] cArr) {
        this.f29856f = kVar;
        this.f29857g = cArr;
        return this;
    }

    public d g(xn.d dVar) {
        return h(new b0(dVar));
    }

    public d h(b0 b0Var) {
        this.f29858h = b0Var;
        return this;
    }

    public d i(xn.d dVar) {
        if (dVar != null) {
            this.f29853c.e(dVar);
        }
        return this;
    }

    public d j(om.q qVar) {
        if (this.f29855e != null || this.f29861k != null || this.f29860j != null) {
            throw new IllegalStateException("only one proof of possession allowed");
        }
        this.f29862l = qVar;
        return this;
    }

    public d k() {
        if (this.f29855e != null || this.f29860j != null) {
            throw new IllegalStateException("only one proof of possession allowed");
        }
        this.f29861k = d2.f29657b;
        return this;
    }

    public d l(cs.f fVar) {
        if (this.f29860j != null || this.f29861k != null || this.f29862l != null) {
            throw new IllegalStateException("only one proof of possession allowed");
        }
        this.f29855e = fVar;
        return this;
    }

    public d m(int i10, w wVar) {
        if (this.f29855e != null || this.f29861k != null || this.f29862l != null) {
            throw new IllegalStateException("only one proof of possession allowed");
        }
        if (i10 != 2 && i10 != 3) {
            throw new IllegalArgumentException("type must be ProofOfPossession.TYPE_KEY_ENCIPHERMENT || ProofOfPossession.TYPE_KEY_AGREEMENT");
        }
        this.f29859i = i10;
        this.f29860j = new r(wVar);
        return this;
    }

    public d n(w wVar) {
        if (this.f29855e != null || this.f29861k != null || this.f29862l != null) {
            throw new IllegalStateException("only one proof of possession allowed");
        }
        this.f29859i = 2;
        this.f29860j = new r(wVar);
        return this;
    }

    public d o(c1 c1Var) {
        if (c1Var != null) {
            this.f29853c.g(c1Var);
        }
        return this;
    }

    public d p(BigInteger bigInteger) {
        if (bigInteger != null) {
            this.f29853c.h(new t(bigInteger));
        }
        return this;
    }

    public d q(xn.d dVar) {
        if (dVar != null) {
            this.f29853c.j(dVar);
        }
        return this;
    }

    public d r(Date date, Date date2) {
        this.f29853c.l(new om.n(e(date), e(date2)));
        return this;
    }
}
