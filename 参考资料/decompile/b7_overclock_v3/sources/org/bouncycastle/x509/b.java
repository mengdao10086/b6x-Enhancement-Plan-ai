package org.bouncycastle.x509;

import gm.j2;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.CertSelector;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import javax.security.auth.x500.X500Principal;
import zn.b0;
import zn.c0;
import zn.n1;

/* JADX INFO: loaded from: classes6.dex */
public class b implements CertSelector, org.bouncycastle.util.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.h f46075a;

    public b(X500Principal x500Principal) throws IOException {
        this(new org.bouncycastle.jce.j(x500Principal.getEncoded()));
    }

    public b(org.bouncycastle.jce.j jVar) {
        this.f46075a = new n1(c0.A(new j2(new b0(jVar))));
    }

    public b(zn.c cVar) {
        this.f46075a = cVar.z();
    }

    @Override // org.bouncycastle.util.q
    public boolean M(Object obj) {
        if (obj instanceof X509Certificate) {
            return match((Certificate) obj);
        }
        return false;
    }

    public final Object[] a() {
        gm.h hVar = this.f46075a;
        b0[] b0VarArrB = (hVar instanceof n1 ? ((n1) hVar).A() : (c0) hVar).B();
        ArrayList arrayList = new ArrayList(b0VarArrB.length);
        for (int i10 = 0; i10 != b0VarArrB.length; i10++) {
            if (b0VarArrB[i10].q() == 4) {
                try {
                    arrayList.add(new X500Principal(b0VarArrB[i10].A().b().getEncoded()));
                } catch (IOException unused) {
                    throw new RuntimeException("badly formed Name object");
                }
            }
        }
        return arrayList.toArray(new Object[arrayList.size()]);
    }

    public Principal[] b() {
        Object[] objArrA = a();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 != objArrA.length; i10++) {
            if (objArrA[i10] instanceof Principal) {
                arrayList.add(objArrA[i10]);
            }
        }
        return (Principal[]) arrayList.toArray(new Principal[arrayList.size()]);
    }

    public final boolean c(X500Principal x500Principal, c0 c0Var) {
        b0[] b0VarArrB = c0Var.B();
        for (int i10 = 0; i10 != b0VarArrB.length; i10++) {
            b0 b0Var = b0VarArrB[i10];
            if (b0Var.q() == 4) {
                try {
                    if (new X500Principal(b0Var.A().b().getEncoded()).equals(x500Principal)) {
                        return true;
                    }
                } catch (IOException unused) {
                    continue;
                }
            }
        }
        return false;
    }

    @Override // java.security.cert.CertSelector, org.bouncycastle.util.q
    public Object clone() {
        return new b(zn.c.y(this.f46075a));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            return this.f46075a.equals(((b) obj).f46075a);
        }
        return false;
    }

    public int hashCode() {
        return this.f46075a.hashCode();
    }

    @Override // java.security.cert.CertSelector
    public boolean match(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            return false;
        }
        X509Certificate x509Certificate = (X509Certificate) certificate;
        gm.h hVar = this.f46075a;
        if (hVar instanceof n1) {
            n1 n1Var = (n1) hVar;
            if (n1Var.x() != null) {
                return n1Var.x().B().N(x509Certificate.getSerialNumber()) && c(x509Certificate.getIssuerX500Principal(), n1Var.x().z());
            }
            if (c(x509Certificate.getSubjectX500Principal(), n1Var.A())) {
                return true;
            }
        } else {
            if (c(x509Certificate.getSubjectX500Principal(), (c0) hVar)) {
                return true;
            }
        }
        return false;
    }
}
