package gj;

import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import xi.g0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c<T> extends CountDownLatch implements g0<T>, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f29565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Throwable f29566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public io.reactivex.disposables.b f29567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f29568d;

    public c() {
        super(1);
    }

    public final T a() {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.c.b();
                await();
            } catch (InterruptedException e10) {
                dispose();
                throw ExceptionHelper.f(e10);
            }
        }
        Throwable th2 = this.f29566b;
        if (th2 == null) {
            return this.f29565a;
        }
        throw ExceptionHelper.f(th2);
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        this.f29568d = true;
        io.reactivex.disposables.b bVar = this.f29567c;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        return this.f29568d;
    }

    @Override // xi.g0
    public final void onComplete() {
        countDown();
    }

    @Override // xi.g0
    public final void onSubscribe(io.reactivex.disposables.b bVar) {
        this.f29567c = bVar;
        if (this.f29568d) {
            bVar.dispose();
        }
    }
}
