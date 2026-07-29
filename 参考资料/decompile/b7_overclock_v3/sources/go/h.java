package go;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.crmf.CRMFException;
import org.bouncycastle.util.Strings;
import pn.u;

/* JADX INFO: loaded from: classes5.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public om.m f29866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f29867b;

    public h(om.m mVar) {
        this.f29866a = mVar;
    }

    public h(om.m mVar, g gVar) {
        this.f29866a = mVar;
        this.f29867b = gVar;
    }

    public final byte[] a(q qVar) throws CRMFException {
        if (this.f29866a.E() != null) {
            throw new UnsupportedOperationException();
        }
        try {
            byte[] bArrE = kt.c.e(qVar.a(this.f29866a.C(), this.f29866a.D(), this.f29866a.y().H()).b(new ByteArrayInputStream(this.f29866a.z().H())));
            g gVar = this.f29867b;
            return gVar != null ? gVar.b(bArrE) : bArrE;
        } catch (IOException e10) {
            throw new CRMFException("Cannot parse decrypted data: " + e10.getMessage(), e10);
        }
    }

    public zn.b b() {
        return this.f29866a.B();
    }

    public X509CertificateHolder c(q qVar) throws CRMFException {
        return new X509CertificateHolder(zn.o.z(a(qVar)));
    }

    public char[] d(q qVar) throws CRMFException {
        return Strings.d(a(qVar)).toCharArray();
    }

    public u e(q qVar) throws CRMFException {
        return u.z(a(qVar));
    }
}
