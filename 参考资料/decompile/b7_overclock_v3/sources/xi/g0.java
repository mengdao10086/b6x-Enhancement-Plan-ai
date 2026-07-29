package xi;

/* JADX INFO: loaded from: classes5.dex */
public interface g0<T> {
    void onComplete();

    void onError(@bj.e Throwable th2);

    void onNext(@bj.e T t10);

    void onSubscribe(@bj.e io.reactivex.disposables.b bVar);
}
