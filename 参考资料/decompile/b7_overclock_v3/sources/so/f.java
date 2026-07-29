package so;

import gm.b3;
import gm.l2;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class f extends g {
    public final e f(r0 r0Var, cs.b0 b0Var) throws CMSException {
        l2 l2Var;
        gm.i iVar = new gm.i();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            OutputStream outputStreamB = b0Var.b(byteArrayOutputStream);
            r0Var.d(outputStreamB);
            d dVar = this.f50175z;
            if (dVar != null) {
                l2Var = new l2(dVar.a(Collections.EMPTY_MAP).h());
                b0Var.c().write(l2Var.v(gm.j.f29713a));
            } else {
                l2Var = null;
            }
            outputStreamB.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byte[] bArrD = b0Var.d();
            zn.b bVarA = b0Var.a();
            gm.e1 e1Var = new gm.e1(byteArray);
            cs.q key = b0Var.getKey();
            Iterator it2 = this.f50174y.iterator();
            while (it2.hasNext()) {
                iVar.a(((w1) it2.next()).a(key));
            }
            mm.q qVar = new mm.q(r0Var.a(), bVarA, e1Var);
            d dVar2 = this.A;
            return new e(new mm.n(mm.k.R2, new mm.d(this.B, new l2(iVar), qVar, l2Var, new gm.f2(bArrD), dVar2 != null ? new b3(dVar2.a(Collections.EMPTY_MAP).h()) : null)));
        } catch (IOException e10) {
            throw new CMSException("unable to process authenticated content: " + e10.getMessage(), e10);
        }
    }

    public e g(r0 r0Var, cs.b0 b0Var) throws CMSException {
        return f(r0Var, b0Var);
    }
}
