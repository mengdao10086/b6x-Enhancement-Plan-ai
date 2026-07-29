package io.reactivex.observers;

import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.g0;
import xi.l0;
import xi.t;

/* JADX INFO: loaded from: classes5.dex */
public class TestObserver<T> extends BaseTestConsumer<T, TestObserver<T>> implements g0<T>, io.reactivex.disposables.b, t<T>, l0<T>, xi.d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final g0<? super T> f35282k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicReference<io.reactivex.disposables.b> f35283l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public fj.j<T> f35284m;

    public enum EmptyObserver implements g0<Object> {
        INSTANCE;

        @Override // xi.g0
        public void onComplete() {
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
        }

        @Override // xi.g0
        public void onNext(Object obj) {
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
        }
    }

    public TestObserver() {
        this(EmptyObserver.INSTANCE);
    }

    public static <T> TestObserver<T> i0() {
        return new TestObserver<>();
    }

    public static <T> TestObserver<T> j0(g0<? super T> g0Var) {
        return new TestObserver<>(g0Var);
    }

    public static String k0(int i10) {
        if (i10 == 0) {
            return HlsPlaylistParser.M;
        }
        if (i10 == 1) {
            return "SYNC";
        }
        if (i10 == 2) {
            return "ASYNC";
        }
        return "Unknown(" + i10 + ee.a.f26979d;
    }

    public final TestObserver<T> c0() {
        if (this.f35284m != null) {
            return this;
        }
        throw new AssertionError("Upstream is not fuseable.");
    }

    public final void cancel() {
        dispose();
    }

    public final TestObserver<T> d0(int i10) {
        int i11 = this.f35279h;
        if (i11 == i10) {
            return this;
        }
        if (this.f35284m == null) {
            throw T("Upstream is not fuseable");
        }
        throw new AssertionError("Fusion mode different. Expected: " + k0(i10) + ", actual: " + k0(i11));
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        DisposableHelper.dispose(this.f35283l);
    }

    public final TestObserver<T> e0() {
        if (this.f35284m == null) {
            return this;
        }
        throw new AssertionError("Upstream is fuseable.");
    }

    @Override // io.reactivex.observers.BaseTestConsumer
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public final TestObserver<T> q() {
        if (this.f35283l.get() != null) {
            throw T("Subscribed!");
        }
        if (this.f35274c.isEmpty()) {
            return this;
        }
        throw T("Not subscribed but errors found");
    }

    public final TestObserver<T> g0(dj.g<? super TestObserver<T>> gVar) {
        try {
            gVar.accept(this);
            return this;
        } catch (Throwable th2) {
            throw ExceptionHelper.f(th2);
        }
    }

    @Override // io.reactivex.observers.BaseTestConsumer
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public final TestObserver<T> t() {
        if (this.f35283l.get() != null) {
            return this;
        }
        throw T("Not subscribed!");
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f35283l.get());
    }

    public final boolean l0() {
        return this.f35283l.get() != null;
    }

    public final boolean m0() {
        return isDisposed();
    }

    public final TestObserver<T> n0(int i10) {
        this.f35278g = i10;
        return this;
    }

    @Override // xi.g0
    public void onComplete() {
        if (!this.f35277f) {
            this.f35277f = true;
            if (this.f35283l.get() == null) {
                this.f35274c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f35276e = Thread.currentThread();
            this.f35275d++;
            this.f35282k.onComplete();
        } finally {
            this.f35272a.countDown();
        }
    }

    @Override // xi.g0
    public void onError(Throwable th2) {
        if (!this.f35277f) {
            this.f35277f = true;
            if (this.f35283l.get() == null) {
                this.f35274c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f35276e = Thread.currentThread();
            if (th2 == null) {
                this.f35274c.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.f35274c.add(th2);
            }
            this.f35282k.onError(th2);
        } finally {
            this.f35272a.countDown();
        }
    }

    @Override // xi.g0
    public void onNext(T t10) {
        if (!this.f35277f) {
            this.f35277f = true;
            if (this.f35283l.get() == null) {
                this.f35274c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f35276e = Thread.currentThread();
        if (this.f35279h != 2) {
            this.f35273b.add(t10);
            if (t10 == null) {
                this.f35274c.add(new NullPointerException("onNext received a null value"));
            }
            this.f35282k.onNext(t10);
            return;
        }
        while (true) {
            try {
                T tPoll = this.f35284m.poll();
                if (tPoll == null) {
                    return;
                } else {
                    this.f35273b.add(tPoll);
                }
            } catch (Throwable th2) {
                this.f35274c.add(th2);
                this.f35284m.dispose();
                return;
            }
        }
    }

    @Override // xi.g0
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        this.f35276e = Thread.currentThread();
        if (bVar == null) {
            this.f35274c.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        if (!this.f35283l.compareAndSet(null, bVar)) {
            bVar.dispose();
            if (this.f35283l.get() != DisposableHelper.DISPOSED) {
                this.f35274c.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + bVar));
                return;
            }
            return;
        }
        int i10 = this.f35278g;
        if (i10 != 0 && (bVar instanceof fj.j)) {
            fj.j<T> jVar = (fj.j) bVar;
            this.f35284m = jVar;
            int iRequestFusion = jVar.requestFusion(i10);
            this.f35279h = iRequestFusion;
            if (iRequestFusion == 1) {
                this.f35277f = true;
                this.f35276e = Thread.currentThread();
                while (true) {
                    try {
                        T tPoll = this.f35284m.poll();
                        if (tPoll == null) {
                            this.f35275d++;
                            this.f35283l.lazySet(DisposableHelper.DISPOSED);
                            return;
                        }
                        this.f35273b.add(tPoll);
                    } catch (Throwable th2) {
                        this.f35274c.add(th2);
                        return;
                    }
                }
            }
        }
        this.f35282k.onSubscribe(bVar);
    }

    @Override // xi.t
    public void onSuccess(T t10) {
        onNext(t10);
        onComplete();
    }

    public TestObserver(g0<? super T> g0Var) {
        this.f35283l = new AtomicReference<>();
        this.f35282k = g0Var;
    }
}
