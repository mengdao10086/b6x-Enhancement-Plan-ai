package a;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<java.lang.Integer>] */
/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ea2 extends ba2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final da2 f5984a = new da2(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ea2 f714a = new ea2(1, 0);

    public ea2(int i, int i2) {
        super(i, i2, 1);
    }

    @Override // a.ba2
    public boolean equals(Object obj) {
        if (obj instanceof ea2) {
            if (!isEmpty() || !((ea2) obj).isEmpty()) {
                ea2 ea2Var = (ea2) obj;
                if (a() != ea2Var.a() || b() != ea2Var.b()) {
                }
            }
            return true;
        }
        return false;
    }

    public Integer f() {
        return Integer.valueOf(b());
    }

    public Integer g() {
        return Integer.valueOf(a());
    }

    @Override // a.ba2
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // a.ba2
    public boolean isEmpty() {
        return a() > b();
    }

    @Override // a.ba2
    public String toString() {
        return a() + ".." + b();
    }
}
