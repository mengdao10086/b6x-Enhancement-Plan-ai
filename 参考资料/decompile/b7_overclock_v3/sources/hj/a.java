package hj;

import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a<T, R> implements fj.a<T>, fj.l<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fj.a<? super R> f31297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public bu.e f31298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public fj.l<T> f31299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f31300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f31301e;

    public a(fj.a<? super R> aVar) {
        this.f31297a = aVar;
    }

    public void a() {
    }

    public boolean b() {
        return true;
    }

    public final void c(Throwable th2) {
        io.reactivex.exceptions.a.b(th2);
        this.f31298b.cancel();
        onError(th2);
    }

    @Override // bu.e
    public void cancel() {
        this.f31298b.cancel();
    }

    @Override // fj.o
    public void clear() {
        this.f31299c.clear();
    }

    public final int d(int i10) {
        fj.l<T> lVar = this.f31299c;
        if (lVar == null || (i10 & 4) != 0) {
            return 0;
        }
        int iRequestFusion = lVar.requestFusion(i10);
        if (iRequestFusion != 0) {
            this.f31301e = iRequestFusion;
        }
        return iRequestFusion;
    }

    @Override // fj.o
    public boolean isEmpty() {
        return this.f31299c.isEmpty();
    }

    @Override // fj.o
    public final boolean offer(R r10) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // bu.d
    public void onComplete() {
        if (this.f31300d) {
            return;
        }
        this.f31300d = true;
        this.f31297a.onComplete();
    }

    @Override // bu.d
    public void onError(Throwable th2) {
        if (this.f31300d) {
            kj.a.Y(th2);
        } else {
            this.f31300d = true;
            this.f31297a.onError(th2);
        }
    }

    @Override // xi.o, bu.d
    public final void onSubscribe(bu.e eVar) {
        if (SubscriptionHelper.validate(this.f31298b, eVar)) {
            this.f31298b = eVar;
            if (eVar instanceof fj.l) {
                this.f31299c = (fj.l) eVar;
            }
            if (b()) {
                this.f31297a.onSubscribe(this);
                a();
            }
        }
    }

    @Override // bu.e
    public void request(long j10) {
        this.f31298b.request(j10);
    }

    @Override // fj.o
    public final boolean offer(R r10, R r11) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
