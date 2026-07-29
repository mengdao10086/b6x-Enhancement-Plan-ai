package so;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.operator.OperatorCreationException;
import so.b0;

/* JADX INFO: loaded from: classes5.dex */
public class h implements org.bouncycastle.util.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y1 f50178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public mm.n f50179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zn.b f50180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.h0 f50181d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public gm.h0 f50182e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f50183f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public n1 f50184g;

    public class a implements so.a {
        public a() {
        }

        @Override // so.a
        public boolean a() {
            return false;
        }

        @Override // so.a
        public gm.h0 b() {
            return h.this.f50181d;
        }
    }

    public h(InputStream inputStream) throws CMSException {
        this(t0.u(inputStream));
    }

    public h(InputStream inputStream, cs.p pVar) throws CMSException {
        this(t0.u(inputStream), pVar);
    }

    public h(mm.n nVar) throws CMSException {
        this(nVar, (cs.p) null);
    }

    public h(mm.n nVar, cs.p pVar) throws CMSException {
        this.f50179b = nVar;
        mm.f fVarC = mm.f.C(nVar.x());
        if (fVarC.F() != null) {
            this.f50184g = new n1(fVarC.F());
        }
        gm.h0 h0VarG = fVarC.G();
        this.f50180c = fVarC.E();
        this.f50181d = fVarC.y();
        this.f50183f = fVarC.D().J();
        this.f50182e = fVarC.H();
        mm.n nVarA = fVarC.A();
        e0 e0Var = new e0(nVarA.y(), gm.z.I(nVarA.x()).J());
        gm.h0 h0Var = this.f50181d;
        if (h0Var == null) {
            this.f50178a = b0.a(h0VarG, this.f50180c, new b0.a(this.f50180c, nVarA.y(), e0Var));
            return;
        }
        if (pVar == null) {
            throw new CMSException("a digest calculator provider is required if authenticated attributes are present");
        }
        gm.i iVarE = new mm.b(h0Var).e(mm.j.f41344g);
        if (iVarE.i() > 1) {
            throw new CMSException("Only one instance of a cmsAlgorithmProtect attribute can be present");
        }
        if (iVarE.i() > 0) {
            mm.a aVarA = mm.a.A(iVarE.g(0));
            if (aVarA.y().size() != 1) {
                throw new CMSException("A cmsAlgorithmProtect attribute MUST contain exactly one value");
            }
            mm.i iVarY = mm.i.y(aVarA.z()[0]);
            if (!t0.p(iVarY.x(), fVarC.z())) {
                throw new CMSException("CMS Algorithm Identifier Protection check failed for digestAlgorithm");
            }
            if (!t0.p(iVarY.z(), this.f50180c)) {
                throw new CMSException("CMS Algorithm Identifier Protection check failed for macAlgorithm");
            }
        }
        try {
            this.f50178a = b0.b(h0VarG, this.f50180c, new b0.b(pVar.a(fVarC.z()), nVarA.y(), e0Var), new a());
        } catch (OperatorCreationException e10) {
            throw new CMSException("unable to create digest calculator: " + e10.getMessage(), e10);
        }
    }

    public h(byte[] bArr) throws CMSException {
        this(t0.v(bArr));
    }

    public h(byte[] bArr, cs.p pVar) throws CMSException {
        this(t0.v(bArr), pVar);
    }

    public final byte[] b(gm.h hVar) throws IOException {
        if (hVar != null) {
            return hVar.b().getEncoded();
        }
        return null;
    }

    public mm.b c() {
        gm.h0 h0Var = this.f50181d;
        if (h0Var == null) {
            return null;
        }
        return new mm.b(h0Var);
    }

    public byte[] d() {
        if (this.f50181d != null) {
            return gm.z.I(c().d(mm.j.f41339b).y().J(0)).J();
        }
        return null;
    }

    public mm.n e() {
        return this.f50179b;
    }

    public byte[] f() {
        return org.bouncycastle.util.a.p(this.f50183f);
    }

    public String g() {
        return this.f50180c.x().L();
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return this.f50179b.getEncoded();
    }

    public byte[] h() {
        try {
            return b(this.f50180c.A());
        } catch (Exception e10) {
            throw new RuntimeException("exception getting encryption parameters " + e10);
        }
    }

    public zn.b i() {
        return this.f50180c;
    }

    public n1 j() {
        return this.f50184g;
    }

    public y1 k() {
        return this.f50178a;
    }

    public mm.b l() {
        gm.h0 h0Var = this.f50182e;
        if (h0Var == null) {
            return null;
        }
        return new mm.b(h0Var);
    }

    public mm.n m() {
        return this.f50179b;
    }
}
