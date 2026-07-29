package hj;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import xi.o;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c<T> extends CountDownLatch implements o<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f31307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Throwable f31308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public bu.e f31309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f31310d;

    public c() {
        super(1);
    }

    public final T a() {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.c.b();
                await();
            } catch (InterruptedException e10) {
                bu.e eVar = this.f31309c;
                this.f31309c = SubscriptionHelper.CANCELLED;
                if (eVar != null) {
                    eVar.cancel();
                }
                throw ExceptionHelper.f(e10);
            }
        }
        Throwable th2 = this.f31308b;
        if (th2 == null) {
            return this.f31307a;
        }
        throw ExceptionHelper.f(th2);
    }

    @Override // bu.d
    public final void onComplete() {
        countDown();
    }

    @Override // xi.o, bu.d
    public final void onSubscribe(bu.e eVar) {
        if (SubscriptionHelper.validate(this.f31309c, eVar)) {
            this.f31309c = eVar;
            if (this.f31310d) {
                return;
            }
            eVar.request(Long.MAX_VALUE);
            if (this.f31310d) {
                this.f31309c = SubscriptionHelper.CANCELLED;
                eVar.cancel();
            }
        }
    }
}
