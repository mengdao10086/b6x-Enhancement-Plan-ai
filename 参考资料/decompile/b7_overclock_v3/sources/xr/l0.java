package xr;

import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class l0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h2 f55969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k0 f55970b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h2 f55971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public k0 f55972b;

        public l0 a() {
            return new l0(this.f55971a, this.f55972b);
        }

        public a b(k0 k0Var) {
            this.f55972b = k0Var;
            return this;
        }

        public a c(h2 h2Var) {
            this.f55971a = h2Var;
            return this;
        }
    }

    public l0(h2 h2Var, k0 k0Var) {
        this.f55969a = h2Var;
        this.f55970b = k0Var;
    }

    public static a x() {
        return new a();
    }

    public static l0 z(Object obj) {
        if (obj instanceof l0) {
            return (l0) obj;
        }
        Iterator<gm.h> it2 = gm.f0.J(obj).iterator();
        return new l0(h2.x(it2.next()), k0.z(it2.next()));
    }

    public h2 A() {
        return this.f55969a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return i2.e(this.f55969a, this.f55970b);
    }

    public k0 y() {
        return this.f55970b;
    }
}
