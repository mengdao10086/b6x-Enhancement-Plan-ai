package a;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xc2 extends gd2 {
    public static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(xc2.class, "_resumed");
    public volatile int _resumed;

    public xc2(b62<?> b62Var, Throwable th, boolean z) {
        if (th == null) {
            th = new CancellationException("Continuation " + b62Var + " was cancelled normally");
        }
        super(th, z);
        this._resumed = 0;
    }

    public final boolean c() {
        return b.compareAndSet(this, 0, 1);
    }
}
