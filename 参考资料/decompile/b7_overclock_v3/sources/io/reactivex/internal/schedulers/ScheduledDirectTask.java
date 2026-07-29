package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class ScheduledDirectTask extends AbstractDirectTask implements Callable<Void> {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectTask(Runnable runnable) {
        super(runnable);
    }

    @Override // io.reactivex.internal.schedulers.AbstractDirectTask, lj.a
    public /* bridge */ /* synthetic */ Runnable a() {
        return super.a();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Void call() throws Exception {
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
            return null;
        } finally {
            lazySet(AbstractDirectTask.f35106a);
            this.runner = null;
        }
    }
}
