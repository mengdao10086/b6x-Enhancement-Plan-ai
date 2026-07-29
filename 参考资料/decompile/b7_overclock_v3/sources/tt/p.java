package tt;

/* JADX INFO: loaded from: classes6.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f51720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f51721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f51722c = true;

    public p(Object obj, n nVar) {
        this.f51720a = obj;
        this.f51721b = nVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f51720a == pVar.f51720a && this.f51721b.equals(pVar.f51721b);
    }

    public int hashCode() {
        return this.f51720a.hashCode() + this.f51721b.f51702f.hashCode();
    }
}
