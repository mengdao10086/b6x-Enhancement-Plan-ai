package p000do;

import gm.h;
import java.util.ArrayList;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.util.q;
import xn.d;
import zn.b0;
import zn.c;
import zn.c0;
import zn.n1;

/* JADX INFO: loaded from: classes5.dex */
public class b implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f26430a;

    public b(d dVar) {
        this.f26430a = new n1(new c0(new b0(dVar)));
    }

    public b(c cVar) {
        this.f26430a = cVar.z();
    }

    @Override // org.bouncycastle.util.q
    public boolean M(Object obj) {
        if (!(obj instanceof X509CertificateHolder)) {
            return false;
        }
        X509CertificateHolder x509CertificateHolder = (X509CertificateHolder) obj;
        h hVar = this.f26430a;
        if (hVar instanceof n1) {
            n1 n1Var = (n1) hVar;
            if (n1Var.x() != null) {
                return n1Var.x().B().N(x509CertificateHolder.l()) && b(x509CertificateHolder.f(), n1Var.x().z());
            }
            if (b(x509CertificateHolder.o(), n1Var.A())) {
                return true;
            }
        } else {
            if (b(x509CertificateHolder.o(), (c0) hVar)) {
                return true;
            }
        }
        return false;
    }

    public d[] a() {
        h hVar = this.f26430a;
        b0[] b0VarArrB = (hVar instanceof n1 ? ((n1) hVar).A() : (c0) hVar).B();
        ArrayList arrayList = new ArrayList(b0VarArrB.length);
        for (int i10 = 0; i10 != b0VarArrB.length; i10++) {
            if (b0VarArrB[i10].q() == 4) {
                arrayList.add(d.A(b0VarArrB[i10].A()));
            }
        }
        return (d[]) arrayList.toArray(new d[arrayList.size()]);
    }

    public final boolean b(d dVar, c0 c0Var) {
        b0[] b0VarArrB = c0Var.B();
        for (int i10 = 0; i10 != b0VarArrB.length; i10++) {
            b0 b0Var = b0VarArrB[i10];
            if (b0Var.q() == 4 && d.A(b0Var.A()).equals(dVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.bouncycastle.util.q
    public Object clone() {
        return new b(c.y(this.f26430a));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            return this.f26430a.equals(((b) obj).f26430a);
        }
        return false;
    }

    public int hashCode() {
        return this.f26430a.hashCode();
    }
}
