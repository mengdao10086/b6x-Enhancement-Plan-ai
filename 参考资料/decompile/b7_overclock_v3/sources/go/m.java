package go;

import cs.y;
import java.io.IOException;
import java.io.OutputStream;
import lm.r;
import org.bouncycastle.cert.crmf.CRMFException;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f29888a;

    public m(k kVar) {
        this.f29888a = kVar;
    }

    public boolean a(om.q qVar, char[] cArr, c1 c1Var) throws CRMFException {
        this.f29888a.f(r.x(qVar.x().A()));
        y yVarB = this.f29888a.b(cArr);
        OutputStream outputStreamB = yVarB.b();
        try {
            outputStreamB.write(c1Var.v(gm.j.f29713a));
            outputStreamB.close();
            return org.bouncycastle.util.a.I(yVarB.d(), qVar.A().H());
        } catch (IOException e10) {
            throw new CRMFException("exception encoding mac input: " + e10.getMessage(), e10);
        }
    }
}
