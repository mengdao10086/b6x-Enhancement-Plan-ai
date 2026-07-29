package gj;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import xi.l0;

/* JADX INFO: loaded from: classes5.dex */
public final class i<T> extends CountDownLatch implements l0<T>, Future<T>, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f29580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Throwable f29581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<io.reactivex.disposables.b> f29582c;

    public i() {
        super(1);
        this.f29582c = new AtomicReference<>();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        io.reactivex.disposables.b bVar;
        DisposableHelper disposableHelper;
        do {
            bVar = this.f29582c.get();
            if (bVar == this || bVar == (disposableHelper = DisposableHelper.DISPOSED)) {
                return false;
            }
        } while (!this.f29582c.compareAndSet(bVar, disposableHelper));
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
        Throwable th2 = this.f29581b;
        if (th2 == null) {
            return this.f29580a;
        }
        throw new ExecutionException(th2);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return DisposableHelper.isDisposed(this.f29582c.get());
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // xi.l0
    public void onError(Throwable th2) {
        io.reactivex.disposables.b bVar;
        do {
            bVar = this.f29582c.get();
            if (bVar == DisposableHelper.DISPOSED) {
                kj.a.Y(th2);
                return;
            }
            this.f29581b = th2;
        } while (!this.f29582c.compareAndSet(bVar, this));
        countDown();
    }

    @Override // xi.l0
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        DisposableHelper.setOnce(this.f29582c, bVar);
    }

    @Override // xi.l0
    public void onSuccess(T t10) {
        io.reactivex.disposables.b bVar = this.f29582c.get();
        if (bVar == DisposableHelper.DISPOSED) {
            return;
        }
        this.f29580a = t10;
        this.f29582c.compareAndSet(bVar, this);
        countDown();
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
            Throwable th2 = this.f29581b;
            if (th2 == null) {
                return this.f29580a;
            }
            throw new ExecutionException(th2);
        }
        throw new CancellationException();
    }
}
