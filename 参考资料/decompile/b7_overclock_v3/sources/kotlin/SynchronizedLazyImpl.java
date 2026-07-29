package kotlin;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
final class SynchronizedLazyImpl<T> implements z<T>, Serializable {

    @yt.l
    private volatile Object _value;

    @yt.l
    private ik.a<? extends T> initializer;

    @yt.k
    private final Object lock;

    public SynchronizedLazyImpl(@yt.k ik.a<? extends T> initializer, @yt.l Object obj) {
        kotlin.jvm.internal.f0.p(initializer, "initializer");
        this.initializer = initializer;
        this._value = t1.f38139a;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.z
    public boolean a() {
        return this._value != t1.f38139a;
    }

    @Override // kotlin.z
    public T getValue() {
        T tO;
        T t10 = (T) this._value;
        t1 t1Var = t1.f38139a;
        if (t10 != t1Var) {
            return t10;
        }
        synchronized (this.lock) {
            tO = (T) this._value;
            if (tO == t1Var) {
                ik.a<? extends T> aVar = this.initializer;
                kotlin.jvm.internal.f0.m(aVar);
                tO = aVar.o();
                this._value = tO;
                this.initializer = null;
            }
        }
        return tO;
    }

    @yt.k
    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ SynchronizedLazyImpl(ik.a aVar, Object obj, int i10, kotlin.jvm.internal.u uVar) {
        this(aVar, (i10 & 2) != 0 ? null : obj);
    }
}
