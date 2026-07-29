package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
public abstract class i2 extends e0 implements g1, w1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JobSupport f38755d;

    @yt.k
    public final JobSupport S() {
        JobSupport jobSupport = this.f38755d;
        if (jobSupport != null) {
            return jobSupport;
        }
        kotlin.jvm.internal.f0.S("job");
        return null;
    }

    public final void T(@yt.k JobSupport jobSupport) {
        this.f38755d = jobSupport;
    }

    @Override // kotlinx.coroutines.w1
    @yt.l
    public n2 b() {
        return null;
    }

    @Override // kotlinx.coroutines.g1
    public void dispose() {
        S().o1(this);
    }

    @Override // kotlinx.coroutines.w1
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    @yt.k
    public String toString() {
        return r0.a(this) + '@' + r0.b(this) + "[job@" + r0.b(S()) + ']';
    }
}
