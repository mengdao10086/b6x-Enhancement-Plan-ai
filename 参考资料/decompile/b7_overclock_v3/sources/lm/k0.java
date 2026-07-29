package lm;

import gm.j2;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.i f39922a = new gm.i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.i f39923b = new gm.i();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.i f39924c = new gm.i();

    public k0 a(b0 b0Var) {
        this.f39922a.a(b0Var);
        return this;
    }

    public k0 b(b0 b0Var, om.c cVar) {
        if (this.f39922a.i() != this.f39923b.i()) {
            throw new IllegalStateException("status and revCerts sequence must be in common order");
        }
        this.f39922a.a(b0Var);
        this.f39923b.a(cVar);
        return this;
    }

    public k0 c(zn.p pVar) {
        this.f39924c.a(pVar);
        return this;
    }

    public j0 d() {
        gm.i iVar = new gm.i(3);
        iVar.a(new j2(this.f39922a));
        if (this.f39923b.i() != 0) {
            iVar.a(new n2(true, 0, (gm.h) new j2(this.f39923b)));
        }
        if (this.f39924c.i() != 0) {
            iVar.a(new n2(true, 1, (gm.h) new j2(this.f39924c)));
        }
        return j0.z(new j2(iVar));
    }
}
