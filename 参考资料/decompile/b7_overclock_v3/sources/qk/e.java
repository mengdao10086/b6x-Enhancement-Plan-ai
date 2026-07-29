package qk;

/* JADX INFO: loaded from: classes5.dex */
public final class e implements g<Double> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f47397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f47398b;

    public e(double d10, double d11) {
        this.f47397a = d10;
        this.f47398b = d11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // qk.g
    public /* bridge */ /* synthetic */ boolean b(Comparable comparable, Comparable comparable2) {
        return g(((Number) comparable).doubleValue(), ((Number) comparable2).doubleValue());
    }

    public boolean c(double d10) {
        return d10 >= this.f47397a && d10 <= this.f47398b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // qk.g, qk.h
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return c(((Number) comparable).doubleValue());
    }

    @Override // qk.h
    @yt.k
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Double e() {
        return Double.valueOf(this.f47398b);
    }

    public boolean equals(@yt.l Object obj) {
        if (obj instanceof e) {
            if (isEmpty() && ((e) obj).isEmpty()) {
                return true;
            }
            e eVar = (e) obj;
            if (this.f47397a == eVar.f47397a) {
                if (this.f47398b == eVar.f47398b) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // qk.h
    @yt.k
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Double a() {
        return Double.valueOf(this.f47397a);
    }

    public boolean g(double d10, double d11) {
        return d10 <= d11;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (d.a(this.f47397a) * 31) + d.a(this.f47398b);
    }

    @Override // qk.g, qk.h
    public boolean isEmpty() {
        return this.f47397a > this.f47398b;
    }

    @yt.k
    public String toString() {
        return this.f47397a + ".." + this.f47398b;
    }
}
