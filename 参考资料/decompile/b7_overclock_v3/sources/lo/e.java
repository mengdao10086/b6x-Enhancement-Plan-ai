package lo;

import gm.f0;
import gm.s;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Exception;
import org.bouncycastle.cert.CertIOException;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.ocsp.OCSPException;
import zn.b0;
import zn.y;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final X509CertificateHolder[] f40072c = new X509CertificateHolder[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public nn.f f40073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f40074b;

    public e(s sVar) throws IOException {
        try {
            nn.f fVarY = nn.f.y(sVar.n());
            this.f40073a = fVarY;
            if (fVarY == null) {
                throw new CertIOException("malformed request: no request data found");
            }
            this.f40074b = fVarY.A().z();
        } catch (ClassCastException e10) {
            throw new CertIOException("malformed request: " + e10.getMessage(), e10);
        } catch (IllegalArgumentException e11) {
            throw new CertIOException("malformed request: " + e11.getMessage(), e11);
        } catch (ASN1Exception e12) {
            throw new CertIOException("malformed request: " + e12.getMessage(), e12);
        }
    }

    public e(nn.f fVar) {
        this.f40073a = fVar;
        this.f40074b = fVar.A().z();
    }

    public e(byte[] bArr) throws IOException {
        this(new s(bArr));
    }

    public X509CertificateHolder[] a() {
        f0 f0VarX;
        if (this.f40073a.z() != null && (f0VarX = this.f40073a.z().x()) != null) {
            int size = f0VarX.size();
            X509CertificateHolder[] x509CertificateHolderArr = new X509CertificateHolder[size];
            for (int i10 = 0; i10 != size; i10++) {
                x509CertificateHolderArr[i10] = new X509CertificateHolder(zn.o.z(f0VarX.K(i10)));
            }
            return x509CertificateHolderArr;
        }
        return f40072c;
    }

    public Set b() {
        return i.b(this.f40074b);
    }

    public byte[] c() throws IOException {
        return this.f40073a.getEncoded();
    }

    public y d(gm.y yVar) {
        z zVar = this.f40074b;
        if (zVar != null) {
            return zVar.z(yVar);
        }
        return null;
    }

    public List e() {
        return i.c(this.f40074b);
    }

    public Set f() {
        return i.d(this.f40074b);
    }

    public j[] g() {
        f0 f0VarA = this.f40073a.A().A();
        int size = f0VarA.size();
        j[] jVarArr = new j[size];
        for (int i10 = 0; i10 != size; i10++) {
            jVarArr[i10] = new j(nn.i.y(f0VarA.K(i10)));
        }
        return jVarArr;
    }

    public b0 h() {
        return b0.z(this.f40073a.A().B());
    }

    public byte[] i() {
        if (n()) {
            return this.f40073a.z().A().L();
        }
        return null;
    }

    public gm.y j() {
        if (n()) {
            return this.f40073a.z().B().x();
        }
        return null;
    }

    public int k() {
        return this.f40073a.A().C().Q() + 1;
    }

    public boolean l() {
        return this.f40074b != null;
    }

    public boolean m(cs.h hVar) throws OCSPException {
        if (!n()) {
            throw new OCSPException("attempt to verify signature on unsigned object");
        }
        try {
            cs.g gVarA = hVar.a(this.f40073a.z().B());
            gVarA.b().write(this.f40073a.A().v(gm.j.f29713a));
            return gVarA.verify(i());
        } catch (Exception e10) {
            throw new OCSPException("exception processing signature: " + e10, e10);
        }
    }

    public boolean n() {
        return this.f40073a.z() != null;
    }
}
