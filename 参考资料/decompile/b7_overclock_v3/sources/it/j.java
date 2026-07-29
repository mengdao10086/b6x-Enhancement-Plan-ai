package it;

import java.io.IOException;
import java.util.Date;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.tsp.TSPException;
import org.bouncycastle.tsp.ers.ERSException;
import so.f2;

/* JADX INFO: loaded from: classes6.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final un.g f35857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cs.p f35858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f35859c;

    public j(un.g gVar, cs.p pVar) throws ERSException, TSPException {
        this.f35857a = gVar;
        this.f35858b = pVar;
        this.f35859c = new c(gVar.y().y()[r3.length - 1].y()[r3.length - 1], pVar);
    }

    public j(byte[] bArr, cs.p pVar) throws ERSException, TSPException {
        this(un.g.B(bArr), pVar);
    }

    public byte[] a() throws IOException {
        return this.f35857a.getEncoded();
    }

    public c b() {
        return this.f35859c;
    }

    public X509CertificateHolder c() {
        return this.f35859c.g();
    }

    public void d(f2 f2Var) throws TSPException {
        this.f35859c.j(f2Var);
    }

    public void e(g gVar, Date date) throws ERSException, OperatorCreationException {
        this.f35859c.k(gVar, date);
    }

    public void f(byte[] bArr, Date date) throws ERSException, OperatorCreationException {
        this.f35859c.l(bArr, date);
    }
}
