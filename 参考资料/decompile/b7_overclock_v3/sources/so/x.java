package so;

import gm.l2;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class x extends a0 {
    public final w d(r0 r0Var, cs.d0 d0Var) throws CMSException {
        gm.i iVar = new gm.i();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            OutputStream outputStreamB = d0Var.b(byteArrayOutputStream);
            r0Var.d(outputStreamB);
            outputStreamB.close();
            if (d0Var instanceof cs.b0) {
                byte[] bArrD = ((cs.b0) d0Var).d();
                byteArrayOutputStream.write(bArrD, 0, bArrD.length);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            zn.b bVarA = d0Var.a();
            gm.e1 e1Var = new gm.e1(byteArray);
            cs.q key = d0Var.getKey();
            Iterator it2 = this.f50056a.iterator();
            while (it2.hasNext()) {
                iVar.a(((w1) it2.next()).a(key));
            }
            mm.q qVar = new mm.q(r0Var.a(), bVarA, e1Var);
            d dVar = this.f50057b;
            return new w(new mm.n(mm.k.L2, new mm.t(this.f50058c, new l2(iVar), qVar, dVar != null ? new gm.l1(dVar.a(Collections.EMPTY_MAP).h()) : null)));
        } catch (IOException unused) {
            throw new CMSException("");
        }
    }

    public w e(r0 r0Var, cs.d0 d0Var) throws CMSException {
        return d(r0Var, d0Var);
    }
}
