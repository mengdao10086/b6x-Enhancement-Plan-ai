package so;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class u extends v {
    public final t b(r0 r0Var, cs.d0 d0Var) throws CMSException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            OutputStream outputStreamB = d0Var.b(byteArrayOutputStream);
            r0Var.d(outputStreamB);
            outputStreamB.close();
            mm.q qVar = new mm.q(r0Var.a(), d0Var.a(), new gm.e1(byteArrayOutputStream.toByteArray()));
            d dVar = this.f50324a;
            return new t(new mm.n(mm.k.O2, new mm.s(qVar, dVar != null ? new gm.l1(dVar.a(Collections.EMPTY_MAP).h()) : null)));
        } catch (IOException unused) {
            throw new CMSException("");
        }
    }

    public t c(r0 r0Var, cs.d0 d0Var) throws CMSException {
        return b(r0Var, d0Var);
    }
}
