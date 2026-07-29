package gj;

import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import xi.l0;
import xi.t;

/* JADX INFO: loaded from: classes5.dex */
public final class f<T> extends CountDownLatch implements l0<T>, xi.d, t<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f29569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Throwable f29570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public io.reactivex.disposables.b f29571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f29572d;

    public f() {
        super(1);
    }

    public boolean a(long j10, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.c.b();
                if (!await(j10, timeUnit)) {
                    f();
                    return false;
                }
            } catch (InterruptedException e10) {
                f();
                throw ExceptionHelper.f(e10);
            }
        }
        Throwable th2 = this.f29570b;
        if (th2 == null) {
            return true;
        }
        throw ExceptionHelper.f(th2);
    }

    public T b() {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.c.b();
                await();
            } catch (InterruptedException e10) {
                f();
                throw ExceptionHelper.f(e10);
            }
        }
        Throwable th2 = this.f29570b;
        if (th2 == null) {
            return this.f29569a;
        }
        throw ExceptionHelper.f(th2);
    }

    public T c(T t10) {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.c.b();
                await();
            } catch (InterruptedException e10) {
                f();
                throw ExceptionHelper.f(e10);
            }
        }
        Throwable th2 = this.f29570b;
        if (th2 != null) {
            throw ExceptionHelper.f(th2);
        }
        T t11 = this.f29569a;
        return t11 != null ? t11 : t10;
    }

    public Throwable d() {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.c.b();
                await();
            } catch (InterruptedException e10) {
                f();
                return e10;
            }
        }
        return this.f29570b;
    }

    public Throwable e(long j10, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.c.b();
                if (!await(j10, timeUnit)) {
                    f();
                    throw ExceptionHelper.f(new TimeoutException(ExceptionHelper.e(j10, timeUnit)));
                }
            } catch (InterruptedException e10) {
                f();
                throw ExceptionHelper.f(e10);
            }
        }
        return this.f29570b;
    }

    public void f() {
        this.f29572d = true;
        io.reactivex.disposables.b bVar = this.f29571c;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    @Override // xi.d, xi.t
    public void onComplete() {
        countDown();
    }

    @Override // xi.l0
    public void onError(Throwable th2) {
        this.f29570b = th2;
        countDown();
    }

    @Override // xi.l0
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        this.f29571c = bVar;
        if (this.f29572d) {
            bVar.dispose();
        }
    }

    @Override // xi.l0
    public void onSuccess(T t10) {
        this.f29569a = t10;
        countDown();
    }
}
