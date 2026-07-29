package so;

import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.OperatorCreationException;

/* JADX INFO: loaded from: classes5.dex */
public class c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cs.n f50120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public cs.p f50121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f50122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f50123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f50124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public k0 f50125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public zn.b f50126g;

    public c2(cs.p pVar) {
        this(pVar, new w0());
    }

    public c2(cs.p pVar, k0 k0Var) {
        this.f50120a = new cs.j();
        this.f50121b = pVar;
        this.f50125f = k0Var;
    }

    public b2 a(cs.f fVar, X509CertificateHolder x509CertificateHolder) throws OperatorCreationException {
        b2 b2VarC = c(fVar, new mm.u0(new mm.y(x509CertificateHolder.y())));
        b2VarC.m(x509CertificateHolder);
        return b2VarC;
    }

    public b2 b(cs.f fVar, byte[] bArr) throws OperatorCreationException {
        return c(fVar, new mm.u0((gm.z) new gm.f2(bArr)));
    }

    public final b2 c(cs.f fVar, mm.u0 u0Var) throws OperatorCreationException {
        zn.b bVar = this.f50126g;
        cs.o oVarA = bVar != null ? this.f50121b.a(bVar) : this.f50121b.a(this.f50120a.c(fVar.a()));
        if (this.f50122c) {
            return new b2(u0Var, fVar, oVarA.a(), this.f50125f);
        }
        d dVar = this.f50123d;
        if (dVar == null && this.f50124e == null) {
            return new b2(u0Var, fVar, oVarA, this.f50125f, new x0(), null);
        }
        if (dVar == null) {
            this.f50123d = new x0();
        }
        return new b2(u0Var, fVar, oVarA, this.f50125f, this.f50123d, this.f50124e);
    }

    public c2 d(zn.b bVar) {
        this.f50126g = bVar;
        return this;
    }

    public c2 e(boolean z10) {
        this.f50122c = z10;
        return this;
    }

    public c2 f(d dVar) {
        this.f50123d = dVar;
        return this;
    }

    public c2 g(d dVar) {
        this.f50124e = dVar;
        return this;
    }
}
