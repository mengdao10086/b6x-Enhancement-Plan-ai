package sp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.dvcs.DVCSException;
import zn.y;

/* JADX INFO: loaded from: classes5.dex */
public class o extends g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f50380d;

    public o() {
        super(new rm.h(rm.m.f48905d));
        this.f50380d = new ArrayList();
    }

    public void i(X509CertificateHolder x509CertificateHolder) {
        this.f50380d.add(new rm.n(new rm.a(0, x509CertificateHolder.y())));
    }

    public void j(n nVar) {
        this.f50380d.add(nVar.a());
    }

    public void k(y yVar) {
        this.f50380d.add(new rm.n(new rm.a(yVar)));
    }

    public f l() throws DVCSException {
        List list = this.f50380d;
        return b(new rm.k((rm.n[]) list.toArray(new rm.n[list.size()])));
    }

    public void m(Date date) {
        this.f50372c.i(new rm.j(date));
    }
}
