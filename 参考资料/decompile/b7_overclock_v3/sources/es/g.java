package es;

import cs.d0;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.z2;
import java.io.IOException;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.pkcs.PKCSException;
import org.bouncycastle.pkcs.PKCSIOException;
import pn.s;
import pn.t;
import so.e0;
import so.u;

/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.i f27120a = new gm.i();

    public g a(h hVar) throws IOException {
        this.f27120a.a(new pn.g(s.f46830o4, new f2(new z2(hVar.d()).getEncoded())));
        return this;
    }

    public g b(d0 d0Var, h hVar) throws IOException {
        return c(d0Var, new j2(hVar.d()));
    }

    public final g c(d0 d0Var, f0 f0Var) throws IOException {
        try {
            this.f27120a.a(new u().c(new e0(f0Var.getEncoded()), d0Var).c());
            return this;
        } catch (CMSException e10) {
            throw new PKCSIOException(e10.getMessage(), e10.getCause());
        }
    }

    public g d(d0 d0Var, h[] hVarArr) throws IOException {
        gm.i iVar = new gm.i();
        for (int i10 = 0; i10 != hVarArr.length; i10++) {
            iVar.a(hVarArr[i10].d());
        }
        return c(d0Var, new z2(iVar));
    }

    public f e(d dVar, char[] cArr) throws PKCSException {
        try {
            byte[] encoded = pn.b.z(new z2(this.f27120a)).getEncoded();
            return new f(new t(new pn.g(s.f46830o4, new f2(encoded)), dVar != null ? new a(dVar).a(cArr, encoded) : null));
        } catch (IOException e10) {
            throw new PKCSException("unable to encode AuthenticatedSafe: " + e10.getMessage(), e10);
        }
    }
}
