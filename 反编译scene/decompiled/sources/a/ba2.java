package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ba2 implements Iterable<Integer>, s92 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final aa2 f5689a = new aa2(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f251a;
    public final int b;
    public final int c;

    public ba2(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f251a = i;
        this.b = h72.b(i, i2, i3);
        this.c = i3;
    }

    public final int a() {
        return this.f251a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public q52 iterator() {
        return new ca2(this.f251a, this.b, this.c);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ba2) {
            if (!isEmpty() || !((ba2) obj).isEmpty()) {
                ba2 ba2Var = (ba2) obj;
                if (this.f251a != ba2Var.f251a || this.b != ba2Var.b || this.c != ba2Var.c) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f251a * 31) + this.b) * 31) + this.c;
    }

    public boolean isEmpty() {
        if (this.c > 0) {
            if (this.f251a > this.b) {
                return true;
            }
        } else if (this.f251a < this.b) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        int i;
        if (this.c > 0) {
            sb = new StringBuilder();
            sb.append(this.f251a);
            sb.append("..");
            sb.append(this.b);
            sb.append(" step ");
            i = this.c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f251a);
            sb.append(" downTo ");
            sb.append(this.b);
            sb.append(" step ");
            i = -this.c;
        }
        sb.append(i);
        return sb.toString();
    }
}
