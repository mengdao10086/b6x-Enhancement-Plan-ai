package it;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.tsp.TSPException;
import org.bouncycastle.tsp.ers.ArchiveTimeStampValidationException;
import org.bouncycastle.tsp.ers.ERSException;
import org.bouncycastle.util.s;
import so.f2;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final un.b f35847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cs.o f35848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gt.h f35849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n f35850d;

    public c(un.b bVar, cs.o oVar, n nVar) throws ERSException, TSPException {
        this.f35850d = new a();
        try {
            this.f35847a = bVar;
            this.f35849c = new gt.h(bVar.B());
            this.f35848b = oVar;
            this.f35850d = nVar;
        } catch (IOException e10) {
            throw new ERSException(e10.getMessage(), e10);
        }
    }

    public c(un.b bVar, cs.p pVar) throws ERSException, TSPException {
        this.f35850d = new a();
        try {
            this.f35847a = bVar;
            this.f35849c = new gt.h(bVar.B());
            this.f35848b = pVar.a(bVar.y());
        } catch (IOException e10) {
            throw new ERSException(e10.getMessage(), e10);
        } catch (OperatorCreationException e11) {
            throw new ERSException(e11.getMessage(), e11);
        }
    }

    public c(byte[] bArr, cs.p pVar) throws ERSException, TSPException {
        this(un.b.z(bArr), pVar);
    }

    public void a(byte[] bArr, cs.o oVar) throws ArchiveTimeStampValidationException {
        un.i[] iVarArrA = this.f35847a.A();
        if (iVarArrA == null) {
            if (!org.bouncycastle.util.a.g(bArr, this.f35849c.i().h())) {
                throw new ArchiveTimeStampValidationException("object hash not found in wrapped timestamp");
            }
            return;
        }
        for (int i10 = 0; i10 != iVarArrA.length; i10++) {
            un.i iVar = iVarArrA[i10];
            if (iVar.x(bArr)) {
                return;
            }
            if (iVar.z() > 1 && org.bouncycastle.util.a.g(bArr, o.d(oVar, iVar.A()))) {
                return;
            }
        }
        throw new ArchiveTimeStampValidationException("object hash not found");
    }

    public void b(gt.h hVar, byte[] bArr) throws ArchiveTimeStampValidationException {
        if (bArr != null && !org.bouncycastle.util.a.g(bArr, hVar.i().h())) {
            throw new ArchiveTimeStampValidationException("timestamp hash does not match root");
        }
    }

    public zn.b c() {
        return this.f35847a.y();
    }

    public byte[] d() throws IOException {
        return this.f35847a.getEncoded();
    }

    public Date e() {
        X509CertificateHolder x509CertificateHolderG = g();
        if (x509CertificateHolderG != null) {
            return x509CertificateHolderG.i();
        }
        return null;
    }

    public Date f() {
        return this.f35849c.i().d();
    }

    public X509CertificateHolder g() {
        s<X509CertificateHolder> sVarC = this.f35849c.c();
        if (sVarC == null) {
            return null;
        }
        Collection<X509CertificateHolder> collectionA = sVarC.a(this.f35849c.f());
        if (collectionA.isEmpty()) {
            return null;
        }
        return collectionA.iterator().next();
    }

    public gt.h h() {
        return this.f35849c;
    }

    public un.b i() {
        return this.f35847a;
    }

    public void j(f2 f2Var) throws TSPException {
        this.f35849c.m(f2Var);
    }

    public void k(g gVar, Date date) throws ERSException, OperatorCreationException {
        l(gVar.a(this.f35848b), date);
    }

    public void l(byte[] bArr, Date date) throws ERSException, OperatorCreationException {
        if (this.f35849c.i().d().after(date)) {
            throw new ArchiveTimeStampValidationException("timestamp generation time is in the future");
        }
        a(bArr, this.f35848b);
        if (this.f35847a.A() != null) {
            bArr = this.f35850d.a(this.f35848b, this.f35847a.A());
        }
        b(this.f35849c, bArr);
    }
}
