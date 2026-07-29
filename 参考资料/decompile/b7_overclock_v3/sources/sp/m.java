package sp;

import java.io.IOException;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.dvcs.DVCSException;
import so.e0;
import so.l0;
import so.m0;

/* JADX INFO: loaded from: classes5.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0 f50378a;

    public m(m0 m0Var) {
        this.f50378a = m0Var;
    }

    public l0 a(e eVar) throws DVCSException {
        try {
            return this.f50378a.n(new e0(eVar.b(), eVar.a().b().v(gm.j.f29713a)), true);
        } catch (IOException e10) {
            throw new DVCSException("Could not encode DVCS request", e10);
        } catch (CMSException e11) {
            throw new DVCSException("Could not sign DVCS request", e11);
        }
    }
}
