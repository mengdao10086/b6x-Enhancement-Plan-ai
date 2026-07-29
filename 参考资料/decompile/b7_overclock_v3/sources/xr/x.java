package xr;

import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class x extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g0 f56094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.z f56095b;

    public x(g0 g0Var, gm.z zVar) {
        this.f56094a = g0Var;
        this.f56095b = zVar;
    }

    public static x z(Object obj) {
        if (obj instanceof x) {
            return (x) obj;
        }
        Iterator<gm.h> it2 = gm.f0.J(obj).iterator();
        g0 g0VarV = g0.V(it2.next());
        return it2.hasNext() ? new x(g0VarV, gm.z.I(it2.next())) : new x(g0VarV, null);
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return i2.e(this.f56094a, this.f56095b);
    }

    public g0 x() {
        return this.f56094a;
    }

    public gm.z y() {
        return this.f56095b;
    }
}
