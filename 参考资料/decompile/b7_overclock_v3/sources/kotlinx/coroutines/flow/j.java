package kotlinx.coroutines.flow;

/* JADX INFO: loaded from: classes5.dex */
public interface j<T> extends u<T>, i<T> {
    boolean compareAndSet(T t10, T t11);

    @Override // kotlinx.coroutines.flow.u
    T getValue();

    void setValue(T t10);
}
