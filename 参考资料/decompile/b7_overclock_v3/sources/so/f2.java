package so;

import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.OperatorCreationException;

/* JADX INFO: loaded from: classes5.dex */
public class f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public cs.h f50170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public cs.p f50171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public cs.g0 f50172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j0 f50173d;

    public f2(j0 j0Var, cs.g0 g0Var, cs.h hVar, cs.p pVar) {
        this.f50173d = j0Var;
        this.f50172c = g0Var;
        this.f50170a = hVar;
        this.f50171b = pVar;
    }

    public X509CertificateHolder a() {
        return this.f50170a.c();
    }

    public cs.g b(zn.b bVar, zn.b bVar2) throws OperatorCreationException {
        return this.f50170a.a(new zn.b(this.f50172c.a(this.f50173d.a(bVar2, bVar)).x(), bVar.A()));
    }

    public cs.o c(zn.b bVar) throws OperatorCreationException {
        return this.f50171b.a(bVar);
    }

    public boolean d() {
        return this.f50170a.d();
    }
}
