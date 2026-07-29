package p000do;

import cs.o;
import gm.z;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import org.bouncycastle.cert.CertRuntimeException;
import org.bouncycastle.cert.X509CertificateHolder;
import zn.b0;
import zn.b1;
import zn.c0;
import zn.c1;
import zn.i;
import zn.y;

/* JADX INFO: loaded from: classes5.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f26435a;

    public f(o oVar) {
        this.f26435a = oVar;
    }

    public final byte[] a(c1 c1Var) {
        byte[] bArrH = c1Var.C().H();
        OutputStream outputStreamB = this.f26435a.b();
        try {
            outputStreamB.write(bArrH);
            outputStreamB.close();
            return this.f26435a.c();
        } catch (IOException e10) {
            throw new CertRuntimeException("unable to calculate identifier: " + e10.getMessage(), e10);
        }
    }

    public i b(X509CertificateHolder x509CertificateHolder) {
        return new i(g(x509CertificateHolder), new c0(new b0(x509CertificateHolder.f())), x509CertificateHolder.l());
    }

    public i c(c1 c1Var) {
        return new i(a(c1Var));
    }

    public i d(c1 c1Var, c0 c0Var, BigInteger bigInteger) {
        return new i(a(c1Var), c0Var, bigInteger);
    }

    public b1 e(c1 c1Var) {
        return new b1(a(c1Var));
    }

    public b1 f(c1 c1Var) {
        byte[] bArrA = a(c1Var);
        byte[] bArr = new byte[8];
        System.arraycopy(bArrA, bArrA.length - 8, bArr, 0, 8);
        bArr[0] = (byte) (bArr[0] & 15);
        bArr[0] = (byte) (bArr[0] | 64);
        return new b1(bArr);
    }

    public final byte[] g(X509CertificateHolder x509CertificateHolder) {
        y yVarB;
        if (x509CertificateHolder.r() == 3 && (yVarB = x509CertificateHolder.b(y.f59058e)) != null) {
            return z.I(yVarB.C()).J();
        }
        return a(x509CertificateHolder.p());
    }
}
