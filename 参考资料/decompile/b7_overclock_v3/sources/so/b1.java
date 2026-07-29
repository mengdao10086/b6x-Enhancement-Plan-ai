package so;

import java.io.IOException;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class b1 extends x1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public mm.a0 f50073h;

    public b1(mm.a0 a0Var, zn.b bVar, i0 i0Var, a aVar) {
        super(a0Var.B(), bVar, i0Var, aVar);
        this.f50073h = a0Var;
        this.f50340a = new z0(a0Var.A().A().J());
    }

    @Override // so.x1
    public z1 k(u1 u1Var) throws CMSException, IOException {
        return ((y0) u1Var).a(this.f50341b, this.f50342c, this.f50073h.x().J());
    }
}
