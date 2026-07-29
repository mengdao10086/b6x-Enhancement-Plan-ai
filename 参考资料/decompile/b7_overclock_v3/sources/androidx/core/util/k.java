package androidx.core.util;

import com.blankj.utilcode.util.i0;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public class k<F, S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F f4741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final S f4742b;

    public k(F f10, S s10) {
        this.f4741a = f10;
        this.f4742b = s10;
    }

    @n0
    public static <A, B> k<A, B> a(A a10, B b10) {
        return new k<>(a10, b10);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return j.a(kVar.f4741a, this.f4741a) && j.a(kVar.f4742b, this.f4742b);
    }

    public int hashCode() {
        F f10 = this.f4741a;
        int iHashCode = f10 == null ? 0 : f10.hashCode();
        S s10 = this.f4742b;
        return iHashCode ^ (s10 != null ? s10.hashCode() : 0);
    }

    @n0
    public String toString() {
        return "Pair{" + this.f4741a + i0.f11861z + this.f4742b + zc.a.f58317e;
    }
}
