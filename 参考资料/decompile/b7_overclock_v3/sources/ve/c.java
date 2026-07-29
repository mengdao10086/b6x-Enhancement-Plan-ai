package ve;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f53125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f53126b;

    public c(int i10, int i11) {
        if (i10 < 0 || i11 < 0) {
            throw new IllegalArgumentException();
        }
        this.f53125a = i10;
        this.f53126b = i11;
    }

    public int a() {
        return this.f53126b;
    }

    public int b() {
        return this.f53125a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f53125a == cVar.f53125a && this.f53126b == cVar.f53126b;
    }

    public int hashCode() {
        return (this.f53125a * 32713) + this.f53126b;
    }

    public String toString() {
        return this.f53125a + "x" + this.f53126b;
    }
}
