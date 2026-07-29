package kotlinx.coroutines.internal;

/* JADX INFO: loaded from: classes5.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    @yt.k
    public final LockFreeLinkedListNode f38802a;

    public i0(@yt.k LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.f38802a = lockFreeLinkedListNode;
    }

    @yt.k
    public String toString() {
        return "Removed[" + this.f38802a + ']';
    }
}
