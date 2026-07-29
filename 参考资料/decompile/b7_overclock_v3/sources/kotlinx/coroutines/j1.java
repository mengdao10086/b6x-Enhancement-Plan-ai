package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
public final class j1 implements w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f38875a;

    public j1(boolean z10) {
        this.f38875a = z10;
    }

    @Override // kotlinx.coroutines.w1
    @yt.l
    public n2 b() {
        return null;
    }

    @Override // kotlinx.coroutines.w1
    public boolean isActive() {
        return this.f38875a;
    }

    @yt.k
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Empty{");
        sb2.append(isActive() ? "Active" : "New");
        sb2.append('}');
        return sb2.toString();
    }
}
