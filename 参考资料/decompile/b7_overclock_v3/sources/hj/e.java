package hj;

/* JADX INFO: loaded from: classes5.dex */
public final class e<T> extends c<T> {
    @Override // bu.d
    public void onError(Throwable th2) {
        this.f31307a = null;
        this.f31308b = th2;
        countDown();
    }

    @Override // bu.d
    public void onNext(T t10) {
        this.f31307a = t10;
    }
}
