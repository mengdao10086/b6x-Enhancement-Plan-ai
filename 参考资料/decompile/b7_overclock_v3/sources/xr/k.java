package xr;

import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class k extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h2 f55945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u1 f55946b;

    public k(h2 h2Var, u1 u1Var) {
        this.f55945a = h2Var;
        this.f55946b = u1Var;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return i2.e(this.f55945a, this.f55946b);
    }

    public k x(Object obj) {
        if (obj instanceof k) {
            return (k) obj;
        }
        Iterator<gm.h> it2 = gm.f0.J(obj).iterator();
        return new k(h2.x(it2.next()), u1.z(it2.next()));
    }

    public h2 y() {
        return this.f55945a;
    }

    public u1 z() {
        return this.f55946b;
    }
}
