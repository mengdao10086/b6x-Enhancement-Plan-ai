package io.reactivex.internal.schedulers;

/* JADX INFO: loaded from: classes5.dex */
public final class ScheduledDirectPeriodicTask extends AbstractDirectTask implements Runnable {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectPeriodicTask(Runnable runnable) {
        super(runnable);
    }

    @Override // io.reactivex.internal.schedulers.AbstractDirectTask, lj.a
    public /* bridge */ /* synthetic */ Runnable a() {
        return super.a();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
            this.runner = null;
        } catch (Throwable th2) {
            this.runner = null;
            lazySet(AbstractDirectTask.f35106a);
            kj.a.Y(th2);
        }
    }
}
