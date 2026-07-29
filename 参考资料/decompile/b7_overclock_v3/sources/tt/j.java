package tt;

/* JADX INFO: loaded from: classes6.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f51691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f51692b;

    public synchronized void a(i iVar) {
        try {
            if (iVar == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            i iVar2 = this.f51692b;
            if (iVar2 != null) {
                iVar2.f51690c = iVar;
                this.f51692b = iVar;
            } else {
                if (this.f51691a != null) {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.f51692b = iVar;
                this.f51691a = iVar;
            }
            notifyAll();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized i b() {
        i iVar;
        iVar = this.f51691a;
        if (iVar != null) {
            i iVar2 = iVar.f51690c;
            this.f51691a = iVar2;
            if (iVar2 == null) {
                this.f51692b = null;
            }
        }
        return iVar;
    }

    public synchronized i c(int i10) throws InterruptedException {
        if (this.f51691a == null) {
            wait(i10);
        }
        return b();
    }
}
