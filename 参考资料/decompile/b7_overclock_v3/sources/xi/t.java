package xi;

/* JADX INFO: loaded from: classes5.dex */
public interface t<T> {
    void onComplete();

    void onError(@bj.e Throwable th2);

    void onSubscribe(@bj.e io.reactivex.disposables.b bVar);

    void onSuccess(@bj.e T t10);
}
