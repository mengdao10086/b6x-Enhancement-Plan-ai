package a;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class kh2<T> extends hi2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f6608a = AtomicReferenceFieldUpdater.newUpdater(kh2.class, Object.class, "_consensus");
    public volatile Object _consensus = jh2.f6511a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.hi2
    public kh2<?> a() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.hi2
    public final Object c(Object obj) {
        Object objE = this._consensus;
        if (objE == jh2.f6511a) {
            objE = e(g(obj));
        }
        d(obj, objE);
        return objE;
    }

    public abstract void d(T t, Object obj);

    public final Object e(Object obj) {
        if (be2.a()) {
            if (!(obj != jh2.f6511a)) {
                throw new AssertionError();
            }
        }
        Object obj2 = this._consensus;
        return obj2 != jh2.f6511a ? obj2 : f6608a.compareAndSet(this, jh2.f6511a, obj) ? obj : this._consensus;
    }

    public long f() {
        return 0L;
    }

    public abstract Object g(T t);
}
