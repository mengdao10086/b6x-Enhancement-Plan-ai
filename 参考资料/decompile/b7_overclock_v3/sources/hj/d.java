package hj;

/* JADX INFO: loaded from: classes5.dex */
public final class d<T> extends c<T> {
    @Override // bu.d
    public void onError(Throwable th2) {
        if (this.f31307a == null) {
            this.f31308b = th2;
        } else {
            kj.a.Y(th2);
        }
        countDown();
    }

    @Override // bu.d
    public void onNext(T t10) {
        if (this.f31307a == null) {
            this.f31307a = t10;
            this.f31309c.cancel();
            countDown();
        }
    }
}
