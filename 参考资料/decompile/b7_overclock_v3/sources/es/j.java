package es;

import cs.t;
import gm.f0;
import gm.z;
import mm.n;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.pkcs.PKCSException;
import pn.b0;
import pn.s;

/* JADX INFO: loaded from: classes6.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f27127a;

    public j(pn.g gVar) {
        if (gVar.y().C(s.f46845t4)) {
            throw new IllegalArgumentException("encryptedData requires constructor with decryptor.");
        }
        this.f27127a = f0.J(z.I(gVar.x()).J());
    }

    public j(pn.g gVar, t tVar) throws PKCSException {
        if (!gVar.y().C(s.f46845t4)) {
            throw new IllegalArgumentException("encryptedData requires constructor with decryptor.");
        }
        try {
            this.f27127a = f0.J(new so.t(n.A(gVar)).a(tVar));
        } catch (CMSException e10) {
            throw new PKCSException("unable to extract data: " + e10.getMessage(), e10);
        }
    }

    public h[] a() {
        h[] hVarArr = new h[this.f27127a.size()];
        for (int i10 = 0; i10 != this.f27127a.size(); i10++) {
            hVarArr[i10] = new h(b0.A(this.f27127a.K(i10)));
        }
        return hVarArr;
    }
}
