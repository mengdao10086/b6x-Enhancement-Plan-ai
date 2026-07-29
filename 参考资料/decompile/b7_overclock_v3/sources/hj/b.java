package hj;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import xi.o;

/* JADX INFO: loaded from: classes5.dex */
public abstract class b<T, R> implements o<T>, fj.l<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bu.d<? super R> f31302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public bu.e f31303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public fj.l<T> f31304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f31305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f31306e;

    public b(bu.d<? super R> dVar) {
        this.f31302a = dVar;
    }

    public void a() {
    }

    public boolean b() {
        return true;
    }

    public final void c(Throwable th2) {
        io.reactivex.exceptions.a.b(th2);
        this.f31303b.cancel();
        onError(th2);
    }

    @Override // bu.e
    public void cancel() {
        this.f31303b.cancel();
    }

    @Override // fj.o
    public void clear() {
        this.f31304c.clear();
    }

    public final int d(int i10) {
        fj.l<T> lVar = this.f31304c;
        if (lVar == null || (i10 & 4) != 0) {
            return 0;
        }
        int iRequestFusion = lVar.requestFusion(i10);
        if (iRequestFusion != 0) {
            this.f31306e = iRequestFusion;
        }
        return iRequestFusion;
    }

    @Override // fj.o
    public boolean isEmpty() {
        return this.f31304c.isEmpty();
    }

    @Override // fj.o
    public final boolean offer(R r10) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // bu.d
    public void onComplete() {
        if (this.f31305d) {
            return;
        }
        this.f31305d = true;
        this.f31302a.onComplete();
    }

    @Override // bu.d
    public void onError(Throwable th2) {
        if (this.f31305d) {
            kj.a.Y(th2);
        } else {
            this.f31305d = true;
            this.f31302a.onError(th2);
        }
    }

    @Override // xi.o, bu.d
    public final void onSubscribe(bu.e eVar) {
        if (SubscriptionHelper.validate(this.f31303b, eVar)) {
            this.f31303b = eVar;
            if (eVar instanceof fj.l) {
                this.f31304c = (fj.l) eVar;
            }
            if (b()) {
                this.f31302a.onSubscribe(this);
                a();
            }
        }
    }

    @Override // bu.e
    public void request(long j10) {
        this.f31303b.request(j10);
    }

    @Override // fj.o
    public final boolean offer(R r10, R r11) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
