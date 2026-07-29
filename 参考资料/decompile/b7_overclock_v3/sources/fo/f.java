package fo;

import gm.j;
import gm.j2;
import go.k;
import java.io.IOException;
import java.io.OutputStream;
import lm.r;
import lm.s;
import lm.w;
import lm.y;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.cmp.CMPException;

/* JADX INFO: loaded from: classes5.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f28537a;

    public f(e eVar) {
        if (!eVar.c()) {
            throw new IllegalArgumentException("PKIMessage not protected");
        }
        this.f28537a = eVar.e();
    }

    public f(y yVar) {
        if (yVar.A().C() == null) {
            throw new IllegalArgumentException("PKIMessage not protected");
        }
        this.f28537a = yVar;
    }

    public s a() {
        return this.f28537a.y();
    }

    public X509CertificateHolder[] b() {
        lm.b[] bVarArrZ = this.f28537a.z();
        if (bVarArrZ == null) {
            return new X509CertificateHolder[0];
        }
        X509CertificateHolder[] x509CertificateHolderArr = new X509CertificateHolder[bVarArrZ.length];
        for (int i10 = 0; i10 != bVarArrZ.length; i10++) {
            x509CertificateHolderArr[i10] = new X509CertificateHolder(bVarArrZ[i10].B());
        }
        return x509CertificateHolderArr;
    }

    public w c() {
        return this.f28537a.A();
    }

    public boolean d() {
        return this.f28537a.A().C().x().C(lm.c.f39859a);
    }

    public y e() {
        return this.f28537a;
    }

    public boolean f(cs.h hVar) throws CMPException {
        try {
            return h(this.f28537a.C().H(), hVar.a(this.f28537a.A().C()));
        } catch (Exception e10) {
            throw new CMPException("unable to verify signature: " + e10.getMessage(), e10);
        }
    }

    public boolean g(k kVar, char[] cArr) throws CMPException {
        if (!lm.c.f39859a.C(this.f28537a.A().C().x())) {
            throw new CMPException("protection algorithm not mac based");
        }
        try {
            kVar.f(r.x(this.f28537a.A().C().A()));
            cs.y yVarB = kVar.b(cArr);
            OutputStream outputStreamB = yVarB.b();
            gm.i iVar = new gm.i();
            iVar.a(this.f28537a.A());
            iVar.a(this.f28537a.y());
            outputStreamB.write(new j2(iVar).v(j.f29713a));
            outputStreamB.close();
            return org.bouncycastle.util.a.g(yVarB.d(), this.f28537a.C().H());
        } catch (Exception e10) {
            throw new CMPException("unable to verify MAC: " + e10.getMessage(), e10);
        }
    }

    public final boolean h(byte[] bArr, cs.g gVar) throws IOException {
        gm.i iVar = new gm.i();
        iVar.a(this.f28537a.A());
        iVar.a(this.f28537a.y());
        OutputStream outputStreamB = gVar.b();
        outputStreamB.write(new j2(iVar).v(j.f29713a));
        outputStreamB.close();
        return gVar.verify(bArr);
    }
}
