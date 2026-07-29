package kotlin;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public final class Pair<A, B> implements Serializable {
    private final A first;
    private final B second;

    public Pair(A a10, B b10) {
        this.first = a10;
        this.second = b10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Pair d(Pair pair, Object obj, Object obj2, int i10, Object obj3) {
        if ((i10 & 1) != 0) {
            obj = pair.first;
        }
        if ((i10 & 2) != 0) {
            obj2 = pair.second;
        }
        return pair.c(obj, obj2);
    }

    public final A a() {
        return this.first;
    }

    public final B b() {
        return this.second;
    }

    @yt.k
    public final Pair<A, B> c(A a10, B b10) {
        return new Pair<>(a10, b10);
    }

    public boolean equals(@yt.l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return kotlin.jvm.internal.f0.g(this.first, pair.first) && kotlin.jvm.internal.f0.g(this.second, pair.second);
    }

    public final A f() {
        return this.first;
    }

    public final B h() {
        return this.second;
    }

    public int hashCode() {
        A a10 = this.first;
        int iHashCode = (a10 == null ? 0 : a10.hashCode()) * 31;
        B b10 = this.second;
        return iHashCode + (b10 != null ? b10.hashCode() : 0);
    }

    @yt.k
    public String toString() {
        return '(' + this.first + ", " + this.second + ')';
    }
}
