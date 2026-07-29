package zg;

import io.reactivex.BackpressureStrategy;
import javax.annotation.ParametersAreNonnullByDefault;
import xi.e0;
import xi.f0;
import xi.g;
import xi.h;
import xi.i0;
import xi.j;
import xi.o0;
import xi.p;
import xi.p0;
import xi.q;
import xi.w;
import xi.x;
import xi.z;

/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
public final class c<T> implements f0<T, T>, p<T, T>, p0<T, T>, x<T, T>, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z<?> f58580a;

    public c(z<?> zVar) {
        dh.a.a(zVar, "observable == null");
        this.f58580a = zVar;
    }

    @Override // xi.p
    public bu.c<T> a(j<T> jVar) {
        return jVar.Q6(this.f58580a.W6(BackpressureStrategy.LATEST));
    }

    @Override // xi.x
    public w<T> b(q<T> qVar) {
        return qVar.w1(this.f58580a.j2());
    }

    @Override // xi.f0
    public e0<T> c(z<T> zVar) {
        return zVar.n6(this.f58580a);
    }

    @Override // xi.h
    public g d(xi.a aVar) {
        return xi.a.f(aVar, this.f58580a.x2(a.f58579c));
    }

    @Override // xi.p0
    public o0<T> e(i0<T> i0Var) {
        return i0Var.g1(this.f58580a.k2());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return this.f58580a.equals(((c) obj).f58580a);
    }

    public int hashCode() {
        return this.f58580a.hashCode();
    }

    public String toString() {
        return "LifecycleTransformer{observable=" + this.f58580a + '}';
    }
}
