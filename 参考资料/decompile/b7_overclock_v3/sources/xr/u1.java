package xr;

import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class u1 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f56057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e2 f56058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w1 f56059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t1 f56060d;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c0 f56061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e2 f56062b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public w1 f56063c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public t1 f56064d;

        public a() {
        }

        public u1 a() {
            return new u1(this.f56061a, this.f56062b, this.f56063c, this.f56064d);
        }

        public a b(c0 c0Var) {
            this.f56061a = c0Var;
            return this;
        }

        public a c(t1 t1Var) {
            this.f56064d = t1Var;
            return this;
        }

        public a d(w1 w1Var) {
            this.f56063c = w1Var;
            return this;
        }

        public a e(e2 e2Var) {
            this.f56062b = e2Var;
            return this;
        }
    }

    public u1(c0 c0Var, e2 e2Var, w1 w1Var, t1 t1Var) {
        this.f56057a = c0Var;
        this.f56058b = e2Var;
        this.f56059c = w1Var;
        this.f56060d = t1Var;
    }

    public static u1 z(Object obj) {
        if (obj instanceof u1) {
            return (u1) obj;
        }
        Iterator<gm.h> it2 = gm.f0.J(obj).iterator();
        return new u1(c0.x(it2.next()), e2.y(it2.next()), w1.z(it2.next()), t1.z(it2.next()));
    }

    public t1 A() {
        return this.f56060d;
    }

    public w1 B() {
        return this.f56059c;
    }

    public e2 C() {
        return this.f56058b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return i2.e(this.f56057a, this.f56058b, this.f56059c, this.f56060d);
    }

    public a x() {
        return new a();
    }

    public c0 y() {
        return this.f56057a;
    }
}
