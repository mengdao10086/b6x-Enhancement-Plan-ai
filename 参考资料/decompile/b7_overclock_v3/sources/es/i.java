package es;

import cs.d0;
import gm.f2;
import gm.l2;
import gm.y;
import java.io.IOException;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import pn.b0;
import pn.s;
import pn.u;
import zn.o;
import zn.p;

/* JADX INFO: loaded from: classes6.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f27124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f27125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.i f27126c;

    public i(X509CRLHolder x509CRLHolder) throws IOException {
        this(x509CRLHolder.t());
    }

    public i(X509CertificateHolder x509CertificateHolder) throws IOException {
        this(x509CertificateHolder.y());
    }

    public i(u uVar) {
        this.f27126c = new gm.i();
        this.f27124a = s.f46793b6;
        this.f27125b = uVar;
    }

    public i(u uVar, d0 d0Var) {
        this.f27126c = new gm.i();
        this.f27124a = s.f46796c6;
        this.f27125b = new l(uVar).a(d0Var).f();
    }

    public i(o oVar) throws IOException {
        this.f27126c = new gm.i();
        this.f27124a = s.f46799d6;
        this.f27125b = new pn.d(s.N4, new f2(oVar.getEncoded()));
    }

    public i(p pVar) throws IOException {
        this.f27126c = new gm.i();
        this.f27124a = s.f46802e6;
        this.f27125b = new pn.d(s.Q4, new f2(pVar.getEncoded()));
    }

    public i a(y yVar, gm.h hVar) {
        this.f27126c.a(new pn.a(yVar, new l2(hVar)));
        return this;
    }

    public h b() {
        return new h(new b0(this.f27124a, this.f27125b, new l2(this.f27126c)));
    }
}
