package go;

import cs.d0;
import java.io.IOException;
import mm.t;
import org.bouncycastle.cms.CMSException;
import pn.u;
import so.e0;
import so.w1;
import so.x;
import zn.b0;

/* JADX INFO: loaded from: classes5.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x f29873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e0 f29874b;

    public j(u uVar, b0 b0Var) {
        try {
            this.f29874b = new e0(om.b.f44269h, new om.k(uVar, b0Var).getEncoded());
            this.f29873a = new x();
        } catch (IOException unused) {
            throw new IllegalStateException("unable to encode key and general name info");
        }
    }

    public j a(w1 w1Var) {
        this.f29873a.a(w1Var);
        return this;
    }

    public i b(d0 d0Var) throws CMSException {
        return new i(new om.o(new om.l(t.A(this.f29873a.e(this.f29874b, d0Var).h().x()))));
    }
}
