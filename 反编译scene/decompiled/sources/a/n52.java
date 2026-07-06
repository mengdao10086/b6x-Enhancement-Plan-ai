package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class n52<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6878a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final T f2024a;

    public n52(int i, T t) {
        this.f6878a = i;
        this.f2024a = t;
    }

    public final int a() {
        return this.f6878a;
    }

    public final T b() {
        return this.f2024a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n52)) {
            return false;
        }
        n52 n52Var = (n52) obj;
        return this.f6878a == n52Var.f6878a && f92.a(this.f2024a, n52Var.f2024a);
    }

    public int hashCode() {
        int i = this.f6878a * 31;
        T t = this.f2024a;
        return i + (t != null ? t.hashCode() : 0);
    }

    public String toString() {
        return "IndexedValue(index=" + this.f6878a + ", value=" + this.f2024a + ")";
    }
}
