package go;

import cs.d0;
import cs.x;
import gm.u1;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.crmf.CRMFException;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.util.Strings;
import pn.u;

/* JADX INFO: loaded from: classes5.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x f29863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d0 f29864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f29865c;

    public f(x xVar, d0 d0Var) {
        this(xVar, d0Var, null);
    }

    public f(x xVar, d0 d0Var, g gVar) {
        this.f29863a = xVar;
        this.f29864b = d0Var;
        this.f29865c = gVar;
    }

    public om.m a(X509CertificateHolder x509CertificateHolder) throws CRMFException {
        try {
            return d(e(x509CertificateHolder.getEncoded()));
        } catch (IOException e10) {
            throw new CRMFException("cannot encode certificate: " + e10.getMessage(), e10);
        }
    }

    public om.m b(u uVar) throws CRMFException {
        try {
            return new om.m(uVar.B(), this.f29864b.a(), new u1(this.f29863a.b(this.f29864b.getKey())), this.f29863a.a(), null, new u1(new es.l(uVar).a(this.f29864b).c()));
        } catch (IllegalStateException e10) {
            throw new CRMFException("cannot encode key: " + e10.getMessage(), e10);
        } catch (OperatorException e11) {
            throw new CRMFException("cannot wrap key: " + e11.getMessage(), e11);
        }
    }

    public om.m c(char[] cArr) throws CRMFException {
        return d(e(Strings.n(cArr)));
    }

    public final om.m d(byte[] bArr) throws CRMFException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStream outputStreamB = this.f29864b.b(byteArrayOutputStream);
        try {
            outputStreamB.write(bArr);
            outputStreamB.close();
            zn.b bVarA = this.f29864b.a();
            try {
                this.f29863a.b(this.f29864b.getKey());
                return new om.m(null, bVarA, new u1(this.f29863a.b(this.f29864b.getKey())), this.f29863a.a(), null, new u1(byteArrayOutputStream.toByteArray()));
            } catch (OperatorException e10) {
                throw new CRMFException("cannot wrap key: " + e10.getMessage(), e10);
            }
        } catch (IOException e11) {
            throw new CRMFException("cannot process data: " + e11.getMessage(), e11);
        }
    }

    public final byte[] e(byte[] bArr) {
        g gVar = this.f29865c;
        return gVar != null ? gVar.a(bArr) : bArr;
    }
}
