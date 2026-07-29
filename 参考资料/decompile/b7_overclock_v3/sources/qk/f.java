package qk;

/* JADX INFO: loaded from: classes5.dex */
public final class f implements g<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f47399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f47400b;

    public f(float f10, float f11) {
        this.f47399a = f10;
        this.f47400b = f11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // qk.g
    public /* bridge */ /* synthetic */ boolean b(Comparable comparable, Comparable comparable2) {
        return g(((Number) comparable).floatValue(), ((Number) comparable2).floatValue());
    }

    public boolean c(float f10) {
        return f10 >= this.f47399a && f10 <= this.f47400b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // qk.g, qk.h
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return c(((Number) comparable).floatValue());
    }

    @Override // qk.h
    @yt.k
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Float e() {
        return Float.valueOf(this.f47400b);
    }

    public boolean equals(@yt.l Object obj) {
        if (obj instanceof f) {
            if (isEmpty() && ((f) obj).isEmpty()) {
                return true;
            }
            f fVar = (f) obj;
            if (this.f47399a == fVar.f47399a) {
                if (this.f47400b == fVar.f47400b) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // qk.h
    @yt.k
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Float a() {
        return Float.valueOf(this.f47399a);
    }

    public boolean g(float f10, float f11) {
        return f10 <= f11;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.floatToIntBits(this.f47399a) * 31) + Float.floatToIntBits(this.f47400b);
    }

    @Override // qk.g, qk.h
    public boolean isEmpty() {
        return this.f47399a > this.f47400b;
    }

    @yt.k
    public String toString() {
        return this.f47399a + ".." + this.f47400b;
    }
}
