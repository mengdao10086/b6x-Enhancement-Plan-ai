package so;

import java.util.ArrayList;
import java.util.Enumeration;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;

/* JADX INFO: loaded from: classes5.dex */
public class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public mm.g0 f50243a;

    public n1(mm.g0 g0Var) {
        this.f50243a = g0Var;
    }

    public org.bouncycastle.util.s a() {
        gm.h0 h0VarX = this.f50243a.x();
        if (h0VarX == null) {
            return new org.bouncycastle.util.e(new ArrayList());
        }
        ArrayList arrayList = new ArrayList(h0VarX.size());
        Enumeration enumerationK = h0VarX.K();
        while (enumerationK.hasMoreElements()) {
            gm.c0 c0VarB = ((gm.h) enumerationK.nextElement()).b();
            if (c0VarB instanceof gm.f0) {
                arrayList.add(new X509CRLHolder(zn.p.y(c0VarB)));
            }
        }
        return new org.bouncycastle.util.e(arrayList);
    }

    public org.bouncycastle.util.s b() {
        gm.h0 h0VarY = this.f50243a.y();
        if (h0VarY == null) {
            return new org.bouncycastle.util.e(new ArrayList());
        }
        ArrayList arrayList = new ArrayList(h0VarY.size());
        Enumeration enumerationK = h0VarY.K();
        while (enumerationK.hasMoreElements()) {
            gm.c0 c0VarB = ((gm.h) enumerationK.nextElement()).b();
            if (c0VarB instanceof gm.f0) {
                arrayList.add(new X509CertificateHolder(zn.o.z(c0VarB)));
            }
        }
        return new org.bouncycastle.util.e(arrayList);
    }

    public mm.g0 c() {
        return this.f50243a;
    }
}
