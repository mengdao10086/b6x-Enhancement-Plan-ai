package zf;

/* JADX INFO: loaded from: classes7.dex */
public final class e<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f58575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f58576b;

    public e(A a10, B b10) {
        this.f58575a = a10;
        this.f58576b = b10;
    }

    public static <A, B> e<A, B> c(A a10, B b10) {
        return new e<>(a10, b10);
    }

    public A a() {
        return this.f58575a;
    }

    public B b() {
        return this.f58576b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        A a10 = this.f58575a;
        if (a10 == null) {
            if (eVar.f58575a != null) {
                return false;
            }
        } else if (!a10.equals(eVar.f58575a)) {
            return false;
        }
        B b10 = this.f58576b;
        if (b10 == null) {
            if (eVar.f58576b != null) {
                return false;
            }
        } else if (!b10.equals(eVar.f58576b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a10 = this.f58575a;
        int iHashCode = ((a10 == null ? 0 : a10.hashCode()) + 31) * 31;
        B b10 = this.f58576b;
        return iHashCode + (b10 != null ? b10.hashCode() : 0);
    }
}
