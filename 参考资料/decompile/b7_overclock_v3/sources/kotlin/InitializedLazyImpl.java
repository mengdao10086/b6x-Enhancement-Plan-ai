package kotlin;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public final class InitializedLazyImpl<T> implements z<T>, Serializable {
    private final T value;

    public InitializedLazyImpl(T t10) {
        this.value = t10;
    }

    @Override // kotlin.z
    public boolean a() {
        return true;
    }

    @Override // kotlin.z
    public T getValue() {
        return this.value;
    }

    @yt.k
    public String toString() {
        return String.valueOf(getValue());
    }
}
