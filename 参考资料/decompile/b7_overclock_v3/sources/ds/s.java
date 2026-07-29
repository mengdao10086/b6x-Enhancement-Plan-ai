package ds;

import java.io.IOException;
import org.bouncycastle.crypto.e0;
import org.bouncycastle.operator.OperatorCreationException;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class s extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public cs.n f26503b;

    public s(cs.n nVar) {
        this.f26503b = nVar;
    }

    @Override // ds.g
    public e0 e(zn.b bVar) throws OperatorCreationException {
        return new rp.w(this.f26482a.a(this.f26503b.c(bVar)));
    }

    @Override // ds.g
    public np.c f(c1 c1Var) throws IOException {
        return org.bouncycastle.crypto.util.n.c(c1Var);
    }
}
