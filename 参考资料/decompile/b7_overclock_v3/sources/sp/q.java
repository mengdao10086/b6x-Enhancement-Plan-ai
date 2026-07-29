package sp;

import java.io.IOException;
import java.util.Date;
import org.bouncycastle.dvcs.DVCSException;
import so.l0;

/* JADX INFO: loaded from: classes5.dex */
public class q extends g {
    public q() {
        super(new rm.h(rm.m.f48904c));
    }

    public f i(l0 l0Var) throws DVCSException {
        try {
            return b(new rm.k(l0Var.getEncoded()));
        } catch (IOException e10) {
            throw new DVCSException("Failed to encode CMS signed data", e10);
        }
    }

    public void j(Date date) {
        this.f50372c.i(new rm.j(date));
    }
}
