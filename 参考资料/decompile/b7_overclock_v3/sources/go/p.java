package go;

import gm.p2;
import gm.r0;
import gm.y;

/* JADX INFO: loaded from: classes5.dex */
public class p implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y f29893b = om.b.f44265d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r0 f29894a;

    public p(r0 r0Var) {
        this.f29894a = r0Var;
    }

    public p(String str) {
        this.f29894a = new p2(str);
    }

    @Override // go.e
    public y getType() {
        return f29893b;
    }

    @Override // go.e
    public gm.h getValue() {
        return this.f29894a;
    }
}
