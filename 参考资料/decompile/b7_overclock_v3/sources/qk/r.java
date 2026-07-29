package qk;

/* JADX INFO: loaded from: classes5.dex */
public final class r implements s<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f47427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f47428b;

    public r(float f10, float f11) {
        this.f47427a = f10;
        this.f47428b = f11;
    }

    public boolean b(float f10) {
        return f10 >= this.f47427a && f10 < this.f47428b;
    }

    @Override // qk.s
    @yt.k
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Float d() {
        return Float.valueOf(this.f47428b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // qk.s
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return b(((Number) comparable).floatValue());
    }

    @Override // qk.s
    @yt.k
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Float a() {
        return Float.valueOf(this.f47427a);
    }

    public boolean equals(@yt.l Object obj) {
        if (obj instanceof r) {
            if (isEmpty() && ((r) obj).isEmpty()) {
                return true;
            }
            r rVar = (r) obj;
            if (this.f47427a == rVar.f47427a) {
                if (this.f47428b == rVar.f47428b) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean f(float f10, float f11) {
        return f10 <= f11;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.floatToIntBits(this.f47427a) * 31) + Float.floatToIntBits(this.f47428b);
    }

    @Override // qk.s
    public boolean isEmpty() {
        return this.f47427a >= this.f47428b;
    }

    @yt.k
    public String toString() {
        return this.f47427a + "..<" + this.f47428b;
    }
}
