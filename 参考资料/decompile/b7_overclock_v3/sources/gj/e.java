package gj;

/* JADX INFO: loaded from: classes5.dex */
public final class e<T> extends c<T> {
    @Override // xi.g0
    public void onError(Throwable th2) {
        this.f29565a = null;
        this.f29566b = th2;
        countDown();
    }

    @Override // xi.g0
    public void onNext(T t10) {
        this.f29565a = t10;
    }
}
