package kotlin.collections;

/* JADX INFO: loaded from: classes5.dex */
public final class h0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f37716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f37717b;

    public h0(int i10, T t10) {
        this.f37716a = i10;
        this.f37717b = t10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ h0 d(h0 h0Var, int i10, Object obj, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            i10 = h0Var.f37716a;
        }
        if ((i11 & 2) != 0) {
            obj = h0Var.f37717b;
        }
        return h0Var.c(i10, obj);
    }

    public final int a() {
        return this.f37716a;
    }

    public final T b() {
        return this.f37717b;
    }

    @yt.k
    public final h0<T> c(int i10, T t10) {
        return new h0<>(i10, t10);
    }

    public final int e() {
        return this.f37716a;
    }

    public boolean equals(@yt.l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return this.f37716a == h0Var.f37716a && kotlin.jvm.internal.f0.g(this.f37717b, h0Var.f37717b);
    }

    public final T f() {
        return this.f37717b;
    }

    public int hashCode() {
        int i10 = this.f37716a * 31;
        T t10 = this.f37717b;
        return i10 + (t10 == null ? 0 : t10.hashCode());
    }

    @yt.k
    public String toString() {
        return "IndexedValue(index=" + this.f37716a + ", value=" + this.f37717b + ')';
    }
}
