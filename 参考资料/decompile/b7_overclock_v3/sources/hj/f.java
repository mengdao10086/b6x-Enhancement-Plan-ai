package hj;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import xi.o;

/* JADX INFO: loaded from: classes5.dex */
public final class f<T> extends CountDownLatch implements o<T>, Future<T>, bu.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f31311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Throwable f31312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<bu.e> f31313c;

    public f() {
        super(1);
        this.f31313c = new AtomicReference<>();
    }

    @Override // bu.e
    public void cancel() {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        bu.e eVar;
        SubscriptionHelper subscriptionHelper;
        do {
            eVar = this.f31313c.get();
            if (eVar == this || eVar == (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
                return false;
            }
        } while (!this.f31313c.compareAndSet(eVar, subscriptionHelper));
        if (eVar != null) {
            eVar.cancel();
        }
        countDown();
        return true;
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        if (getCount() != 0) {
            io.reactivex.internal.util.c.b();
            await();
        }
        if (isCancelled()) {
            throw new CancellationException();
        }
        Throwable th2 = this.f31312b;
        if (th2 == null) {
            return this.f31311a;
        }
        throw new ExecutionException(th2);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f31313c.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // bu.d
    public void onComplete() {
        bu.e eVar;
        if (this.f31311a == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            eVar = this.f31313c.get();
            if (eVar == this || eVar == SubscriptionHelper.CANCELLED) {
                return;
            }
        } while (!this.f31313c.compareAndSet(eVar, this));
        countDown();
    }

    @Override // bu.d
    public void onError(Throwable th2) {
        bu.e eVar;
        do {
            eVar = this.f31313c.get();
            if (eVar == this || eVar == SubscriptionHelper.CANCELLED) {
                kj.a.Y(th2);
                return;
            }
            this.f31312b = th2;
        } while (!this.f31313c.compareAndSet(eVar, this));
        countDown();
    }

    @Override // bu.d
    public void onNext(T t10) {
        if (this.f31311a == null) {
            this.f31311a = t10;
        } else {
            this.f31313c.get().cancel();
            onError(new IndexOutOfBoundsException("More than one element received"));
        }
    }

    @Override // xi.o, bu.d
    public void onSubscribe(bu.e eVar) {
        SubscriptionHelper.setOnce(this.f31313c, eVar, Long.MAX_VALUE);
    }

    @Override // bu.e
    public void request(long j10) {
    }

    @Override // java.util.concurrent.Future
    public T get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (getCount() != 0) {
            io.reactivex.internal.util.c.b();
            if (!await(j10, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.e(j10, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th2 = this.f31312b;
            if (th2 == null) {
                return this.f31311a;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }
}
