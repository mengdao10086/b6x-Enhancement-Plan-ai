package ds;

import java.io.IOException;
import org.bouncycastle.crypto.e0;
import org.bouncycastle.operator.OperatorCreationException;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class o extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f26502b = new byte[0];

    @Override // ds.g
    public e0 e(zn.b bVar) throws OperatorCreationException {
        return bVar.x().C(tm.a.f51341e) ? new rp.m(f26502b) : new rp.j();
    }

    @Override // ds.g
    public np.c f(c1 c1Var) throws IOException {
        return org.bouncycastle.crypto.util.n.c(c1Var);
    }
}
