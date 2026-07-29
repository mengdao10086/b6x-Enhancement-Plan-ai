package qk;

/* JADX INFO: loaded from: classes5.dex */
public final class q implements s<Double> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f47425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f47426b;

    public q(double d10, double d11) {
        this.f47425a = d10;
        this.f47426b = d11;
    }

    public boolean b(double d10) {
        return d10 >= this.f47425a && d10 < this.f47426b;
    }

    @Override // qk.s
    @yt.k
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Double d() {
        return Double.valueOf(this.f47426b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // qk.s
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return b(((Number) comparable).doubleValue());
    }

    @Override // qk.s
    @yt.k
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Double a() {
        return Double.valueOf(this.f47425a);
    }

    public boolean equals(@yt.l Object obj) {
        if (obj instanceof q) {
            if (isEmpty() && ((q) obj).isEmpty()) {
                return true;
            }
            q qVar = (q) obj;
            if (this.f47425a == qVar.f47425a) {
                if (this.f47426b == qVar.f47426b) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean f(double d10, double d11) {
        return d10 <= d11;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (d.a(this.f47425a) * 31) + d.a(this.f47426b);
    }

    @Override // qk.s
    public boolean isEmpty() {
        return this.f47425a >= this.f47426b;
    }

    @yt.k
    public String toString() {
        return this.f47425a + "..<" + this.f47426b;
    }
}
