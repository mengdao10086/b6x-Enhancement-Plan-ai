package go;

import gm.p2;
import gm.r0;
import gm.y;

/* JADX INFO: loaded from: classes5.dex */
public class a implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y f29843b = om.b.f44266e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r0 f29844a;

    public a(r0 r0Var) {
        this.f29844a = r0Var;
    }

    public a(String str) {
        this.f29844a = new p2(str);
    }

    @Override // go.e
    public y getType() {
        return f29843b;
    }

    @Override // go.e
    public gm.h getValue() {
        return this.f29844a;
    }
}
