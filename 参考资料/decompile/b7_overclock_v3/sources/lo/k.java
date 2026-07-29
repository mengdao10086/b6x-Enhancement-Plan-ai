package lo;

import gm.f0;
import java.util.Date;
import nn.p;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public nn.l f40098a;

    public k(nn.l lVar) {
        this.f40098a = lVar;
    }

    public Date a() {
        return i.a(this.f40098a.z());
    }

    public l b() {
        return new l(this.f40098a.A());
    }

    public z c() {
        return this.f40098a.B();
    }

    public n[] d() {
        f0 f0VarC = this.f40098a.C();
        int size = f0VarC.size();
        n[] nVarArr = new n[size];
        for (int i10 = 0; i10 != size; i10++) {
            nVarArr[i10] = new n(p.A(f0VarC.K(i10)));
        }
        return nVarArr;
    }

    public int e() {
        return this.f40098a.D().Q() + 1;
    }
}
