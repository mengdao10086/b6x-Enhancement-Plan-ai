package mr;

import ir.j;
import ir.t;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f41578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f41579b;

    public e(ir.e eVar, f fVar) {
        this.f41578a = fVar;
        this.f41579b = new t(eVar.n(fVar.a()));
    }

    @Override // mr.a
    public j a() {
        return this.f41579b;
    }

    @Override // mr.a
    public boolean b() {
        return true;
    }

    @Override // mr.d
    public BigInteger[] c(BigInteger bigInteger) {
        return c.b(this.f41578a.c(), bigInteger);
    }
}
