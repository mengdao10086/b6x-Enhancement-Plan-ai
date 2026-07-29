package es;

import gm.h0;
import gm.y;
import gm.z;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import pn.b0;
import pn.s;
import pn.u;
import zn.o;
import zn.p;

/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y f27121b = s.J4;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y f27122c = s.K4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b0 f27123a;

    public h(b0 b0Var) {
        this.f27123a = b0Var;
    }

    public pn.a[] a() {
        h0 h0VarX = this.f27123a.x();
        if (h0VarX == null) {
            return null;
        }
        pn.a[] aVarArr = new pn.a[h0VarX.size()];
        for (int i10 = 0; i10 != h0VarX.size(); i10++) {
            aVarArr[i10] = pn.a.A(h0VarX.J(i10));
        }
        return aVarArr;
    }

    public Object b() {
        return c().C(s.f46796c6) ? new k(pn.j.z(this.f27123a.z())) : c().C(s.f46799d6) ? new X509CertificateHolder(o.z(z.I(pn.d.z(this.f27123a.z()).y()).J())) : c().C(s.f46793b6) ? u.z(this.f27123a.z()) : c().C(s.f46802e6) ? new X509CRLHolder(p.y(z.I(pn.c.z(this.f27123a.z()).y()).J())) : this.f27123a.z();
    }

    public y c() {
        return this.f27123a.y();
    }

    public b0 d() {
        return this.f27123a;
    }
}
