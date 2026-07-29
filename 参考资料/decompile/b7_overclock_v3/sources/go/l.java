package go;

import cs.y;
import gm.u1;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.cert.crmf.CRMFException;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f29887a;

    public l(k kVar) {
        this.f29887a = kVar;
    }

    public om.q a(char[] cArr, c1 c1Var) throws CRMFException {
        y yVarB = this.f29887a.b(cArr);
        OutputStream outputStreamB = yVarB.b();
        try {
            outputStreamB.write(c1Var.v(gm.j.f29713a));
            outputStreamB.close();
            return new om.q(yVarB.a(), new u1(yVarB.d()));
        } catch (IOException e10) {
            throw new CRMFException("exception encoding mac input: " + e10.getMessage(), e10);
        }
    }
}
