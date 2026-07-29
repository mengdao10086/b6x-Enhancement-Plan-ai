package lo;

import gm.f0;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Set;
import nn.p;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.ocsp.OCSPException;
import zn.y;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class a implements org.bouncycastle.util.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public nn.a f40057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public nn.l f40058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z f40059c;

    public a(nn.a aVar) {
        this.f40057a = aVar;
        this.f40058b = aVar.C();
        this.f40059c = z.G(aVar.C().B());
    }

    public X509CertificateHolder[] a() {
        f0 f0VarX;
        if (this.f40057a.x() != null && (f0VarX = this.f40057a.x()) != null) {
            int size = f0VarX.size();
            X509CertificateHolder[] x509CertificateHolderArr = new X509CertificateHolder[size];
            for (int i10 = 0; i10 != size; i10++) {
                x509CertificateHolderArr[i10] = new X509CertificateHolder(zn.o.z(f0VarX.K(i10)));
            }
            return x509CertificateHolderArr;
        }
        return i.f40094a;
    }

    public Set b() {
        return i.b(this.f40059c);
    }

    public y c(gm.y yVar) {
        z zVar = this.f40059c;
        if (zVar != null) {
            return zVar.z(yVar);
        }
        return null;
    }

    public List d() {
        return i.c(this.f40059c);
    }

    public Set e() {
        return i.d(this.f40059c);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            return this.f40057a.equals(((a) obj).f40057a);
        }
        return false;
    }

    public Date f() {
        return i.a(this.f40058b.z());
    }

    public l g() {
        return new l(this.f40058b.A());
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return this.f40057a.getEncoded();
    }

    public n[] h() {
        f0 f0VarC = this.f40058b.C();
        int size = f0VarC.size();
        n[] nVarArr = new n[size];
        for (int i10 = 0; i10 != size; i10++) {
            nVarArr[i10] = new n(p.A(f0VarC.K(i10)));
        }
        return nVarArr;
    }

    public int hashCode() {
        return this.f40057a.hashCode();
    }

    public byte[] i() {
        return this.f40057a.A().L();
    }

    public gm.y j() {
        return this.f40057a.B().x();
    }

    public zn.b k() {
        return this.f40057a.B();
    }

    public byte[] l() {
        try {
            return this.f40057a.C().v(gm.j.f29713a);
        } catch (IOException unused) {
            return null;
        }
    }

    public int m() {
        return this.f40058b.D().Q() + 1;
    }

    public boolean n() {
        return this.f40059c != null;
    }

    public boolean o(cs.h hVar) throws OCSPException {
        try {
            cs.g gVarA = hVar.a(this.f40057a.B());
            OutputStream outputStreamB = gVarA.b();
            outputStreamB.write(this.f40057a.C().v(gm.j.f29713a));
            outputStreamB.close();
            return gVarA.verify(i());
        } catch (Exception e10) {
            throw new OCSPException("exception processing sig: " + e10, e10);
        }
    }
}
