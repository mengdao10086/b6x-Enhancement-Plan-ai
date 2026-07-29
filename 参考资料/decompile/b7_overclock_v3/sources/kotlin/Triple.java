package kotlin;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public final class Triple<A, B, C> implements Serializable {
    private final A first;
    private final B second;
    private final C third;

    public Triple(A a10, B b10, C c10) {
        this.first = a10;
        this.second = b10;
        this.third = c10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Triple f(Triple triple, Object obj, Object obj2, Object obj3, int i10, Object obj4) {
        if ((i10 & 1) != 0) {
            obj = triple.first;
        }
        if ((i10 & 2) != 0) {
            obj2 = triple.second;
        }
        if ((i10 & 4) != 0) {
            obj3 = triple.third;
        }
        return triple.d(obj, obj2, obj3);
    }

    public final A a() {
        return this.first;
    }

    public final B b() {
        return this.second;
    }

    public final C c() {
        return this.third;
    }

    @yt.k
    public final Triple<A, B, C> d(A a10, B b10, C c10) {
        return new Triple<>(a10, b10, c10);
    }

    public boolean equals(@yt.l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) obj;
        return kotlin.jvm.internal.f0.g(this.first, triple.first) && kotlin.jvm.internal.f0.g(this.second, triple.second) && kotlin.jvm.internal.f0.g(this.third, triple.third);
    }

    public final A h() {
        return this.first;
    }

    public int hashCode() {
        A a10 = this.first;
        int iHashCode = (a10 == null ? 0 : a10.hashCode()) * 31;
        B b10 = this.second;
        int iHashCode2 = (iHashCode + (b10 == null ? 0 : b10.hashCode())) * 31;
        C c10 = this.third;
        return iHashCode2 + (c10 != null ? c10.hashCode() : 0);
    }

    public final B i() {
        return this.second;
    }

    public final C k() {
        return this.third;
    }

    @yt.k
    public String toString() {
        return '(' + this.first + ", " + this.second + ", " + this.third + ')';
    }
}
