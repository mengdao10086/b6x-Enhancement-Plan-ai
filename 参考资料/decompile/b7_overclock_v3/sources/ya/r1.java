package ya;

/* JADX INFO: loaded from: classes3.dex */
public final class r1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r1 f57064b = new r1(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f57065a;

    public r1(boolean z10) {
        this.f57065a = z10;
    }

    public boolean equals(@g.p0 Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && r1.class == obj.getClass() && this.f57065a == ((r1) obj).f57065a;
    }

    public int hashCode() {
        return !this.f57065a ? 1 : 0;
    }
}
