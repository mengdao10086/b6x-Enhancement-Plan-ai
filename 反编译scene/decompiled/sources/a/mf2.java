package a;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class mf2 extends sf2<qf2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f6804a = AtomicIntegerFieldUpdater.newUpdater(mf2.class, "_invoked");
    public volatile int _invoked;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final g82<Throwable, m42> f1928a;

    /* JADX WARN: Multi-variable type inference failed */
    public mf2(qf2 qf2Var, g82<? super Throwable, m42> g82Var) {
        super(qf2Var);
        this.f1928a = g82Var;
        this._invoked = 0;
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(Throwable th) {
        v(th);
        return m42.f6769a;
    }

    @Override // a.zh2
    public String toString() {
        return "InvokeOnCancelling[" + ce2.a(this) + '@' + ce2.b(this) + ']';
    }

    @Override // a.id2
    public void v(Throwable th) {
        if (f6804a.compareAndSet(this, 0, 1)) {
            this.f1928a.f(th);
        }
    }
}
