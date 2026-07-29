package km;

import gm.j2;
import gm.p2;
import gm.r0;
import km.i;

/* JADX INFO: loaded from: classes5.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f37516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.f0 f37517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r0 f37518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i.a f37519d;

    public j(h hVar, a aVar) {
        this.f37516a = hVar;
        this.f37517b = new j2(aVar);
    }

    public j(h hVar, a[] aVarArr) {
        this.f37516a = hVar;
        this.f37517b = new j2(aVarArr);
    }

    public i a() {
        return new i(this.f37516a, this.f37517b, this.f37518c, this.f37519d);
    }

    public j b(e eVar) {
        this.f37519d = new i.a(eVar);
        return this;
    }

    public j c(c0 c0Var) {
        this.f37519d = new i.a(c0Var);
        return this;
    }

    public j d(String str) {
        this.f37518c = new p2(str);
        return this;
    }
}
