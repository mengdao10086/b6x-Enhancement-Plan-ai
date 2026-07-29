package gj;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import xi.g0;

/* JADX INFO: loaded from: classes5.dex */
public final class h<T> extends CountDownLatch implements g0<T>, Future<T>, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f29577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Throwable f29578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<io.reactivex.disposables.b> f29579c;

    public h() {
        super(1);
        this.f29579c = new AtomicReference<>();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        io.reactivex.disposables.b bVar;
        DisposableHelper disposableHelper;
        do {
            bVar = this.f29579c.get();
            if (bVar == this || bVar == (disposableHelper = DisposableHelper.DISPOSED)) {
                return false;
            }
        } while (!this.f29579c.compareAndSet(bVar, disposableHelper));
        if (bVar != null) {
            bVar.dispose();
        }
        countDown();
        return true;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
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
        Throwable th2 = this.f29578b;
        if (th2 == null) {
            return this.f29577a;
        }
        throw new ExecutionException(th2);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return DisposableHelper.isDisposed(this.f29579c.get());
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // xi.g0
    public void onComplete() {
        io.reactivex.disposables.b bVar;
        if (this.f29577a == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            bVar = this.f29579c.get();
            if (bVar == this || bVar == DisposableHelper.DISPOSED) {
                return;
            }
        } while (!this.f29579c.compareAndSet(bVar, this));
        countDown();
    }

    @Override // xi.g0
    public void onError(Throwable th2) {
        io.reactivex.disposables.b bVar;
        if (this.f29578b != null) {
            kj.a.Y(th2);
            return;
        }
        this.f29578b = th2;
        do {
            bVar = this.f29579c.get();
            if (bVar == this || bVar == DisposableHelper.DISPOSED) {
                kj.a.Y(th2);
                return;
            }
        } while (!this.f29579c.compareAndSet(bVar, this));
        countDown();
    }

    @Override // xi.g0
    public void onNext(T t10) {
        if (this.f29577a == null) {
            this.f29577a = t10;
        } else {
            this.f29579c.get().dispose();
            onError(new IndexOutOfBoundsException("More than one element received"));
        }
    }

    @Override // xi.g0
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        DisposableHelper.setOnce(this.f29579c, bVar);
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
            Throwable th2 = this.f29578b;
            if (th2 == null) {
                return this.f29577a;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }
}
