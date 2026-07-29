package c4;

import g.n0;
import g.p0;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.collection.a<d<?>, Object> f9752c = new v4.b();

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void f(@n0 d<T> dVar, @n0 Object obj, @n0 MessageDigest messageDigest) {
        dVar.h(obj, messageDigest);
    }

    @Override // c4.b
    public void a(@n0 MessageDigest messageDigest) {
        for (int i10 = 0; i10 < this.f9752c.size(); i10++) {
            f(this.f9752c.k(i10), this.f9752c.o(i10), messageDigest);
        }
    }

    @p0
    public <T> T c(@n0 d<T> dVar) {
        return this.f9752c.containsKey(dVar) ? (T) this.f9752c.get(dVar) : dVar.d();
    }

    public void d(@n0 e eVar) {
        this.f9752c.l(eVar.f9752c);
    }

    @n0
    public <T> e e(@n0 d<T> dVar, @n0 T t10) {
        this.f9752c.put(dVar, t10);
        return this;
    }

    @Override // c4.b
    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f9752c.equals(((e) obj).f9752c);
        }
        return false;
    }

    @Override // c4.b
    public int hashCode() {
        return this.f9752c.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f9752c + '}';
    }
}
