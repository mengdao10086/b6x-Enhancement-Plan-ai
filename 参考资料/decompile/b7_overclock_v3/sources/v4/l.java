package v4;

import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Class<?> f52693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class<?> f52694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Class<?> f52695c;

    public l() {
    }

    public void a(@n0 Class<?> cls, @n0 Class<?> cls2) {
        b(cls, cls2, null);
    }

    public void b(@n0 Class<?> cls, @n0 Class<?> cls2, @p0 Class<?> cls3) {
        this.f52693a = cls;
        this.f52694b = cls2;
        this.f52695c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.f52693a.equals(lVar.f52693a) && this.f52694b.equals(lVar.f52694b) && o.d(this.f52695c, lVar.f52695c);
    }

    public int hashCode() {
        int iHashCode = ((this.f52693a.hashCode() * 31) + this.f52694b.hashCode()) * 31;
        Class<?> cls = this.f52695c;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f52693a + ", second=" + this.f52694b + '}';
    }

    public l(@n0 Class<?> cls, @n0 Class<?> cls2) {
        a(cls, cls2);
    }

    public l(@n0 Class<?> cls, @n0 Class<?> cls2, @p0 Class<?> cls3) {
        b(cls, cls2, cls3);
    }
}
