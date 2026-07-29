package kotlin;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public final class UnsafeLazyImpl<T> implements z<T>, Serializable {

    @yt.l
    private Object _value;

    @yt.l
    private ik.a<? extends T> initializer;

    public UnsafeLazyImpl(@yt.k ik.a<? extends T> initializer) {
        kotlin.jvm.internal.f0.p(initializer, "initializer");
        this.initializer = initializer;
        this._value = t1.f38139a;
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
        if (this._value == t1.f38139a) {
            ik.a<? extends T> aVar = this.initializer;
            kotlin.jvm.internal.f0.m(aVar);
            this._value = aVar.o();
            this.initializer = null;
        }
        return (T) this._value;
    }

    @yt.k
    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
