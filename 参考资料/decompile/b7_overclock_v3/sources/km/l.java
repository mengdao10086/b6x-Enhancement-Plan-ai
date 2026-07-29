package km;

import gm.j2;
import gm.p2;
import gm.r0;

/* JADX INFO: loaded from: classes5.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f37529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.f0 f37530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r0 f37531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public z f37532d;

    public l(h hVar, a aVar) {
        this.f37529a = hVar;
        this.f37530b = new j2(aVar);
    }

    public l(h hVar, a[] aVarArr) {
        this.f37529a = hVar;
        this.f37530b = new j2(aVarArr);
    }

    public k a() {
        return new k(this.f37529a, this.f37530b, this.f37531c, this.f37532d);
    }

    public l b(e eVar) {
        this.f37532d = new z(eVar);
        return this;
    }

    public l c(r rVar) {
        this.f37532d = new z(rVar);
        return this;
    }

    public l d(c0 c0Var) {
        this.f37532d = new z(c0Var);
        return this;
    }

    public l e(String str) {
        this.f37531c = new p2(str);
        return this;
    }
}
