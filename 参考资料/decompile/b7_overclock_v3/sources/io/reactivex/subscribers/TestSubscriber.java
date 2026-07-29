package io.reactivex.subscribers;

import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import dj.g;
import fj.l;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.BaseTestConsumer;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import xi.o;

/* JADX INFO: loaded from: classes5.dex */
public class TestSubscriber<T> extends BaseTestConsumer<T, TestSubscriber<T>> implements o<T>, bu.e, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final bu.d<? super T> f35445k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f35446l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AtomicReference<bu.e> f35447m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicLong f35448n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public l<T> f35449o;

    public enum EmptySubscriber implements o<Object> {
        INSTANCE;

        @Override // bu.d
        public void onComplete() {
        }

        @Override // bu.d
        public void onError(Throwable th2) {
        }

        @Override // bu.d
        public void onNext(Object obj) {
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
        }
    }

    public TestSubscriber() {
        this(EmptySubscriber.INSTANCE, Long.MAX_VALUE);
    }

    public static <T> TestSubscriber<T> i0() {
        return new TestSubscriber<>();
    }

    public static <T> TestSubscriber<T> j0(long j10) {
        return new TestSubscriber<>(j10);
    }

    public static <T> TestSubscriber<T> k0(bu.d<? super T> dVar) {
        return new TestSubscriber<>(dVar);
    }

    public static String l0(int i10) {
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

    public final TestSubscriber<T> c0() {
        if (this.f35449o != null) {
            return this;
        }
        throw new AssertionError("Upstream is not fuseable.");
    }

    @Override // bu.e
    public final void cancel() {
        if (this.f35446l) {
            return;
        }
        this.f35446l = true;
        SubscriptionHelper.cancel(this.f35447m);
    }

    public final TestSubscriber<T> d0(int i10) {
        int i11 = this.f35279h;
        if (i11 == i10) {
            return this;
        }
        if (this.f35449o == null) {
            throw T("Upstream is not fuseable");
        }
        throw new AssertionError("Fusion mode different. Expected: " + l0(i10) + ", actual: " + l0(i11));
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        cancel();
    }

    public final TestSubscriber<T> e0() {
        if (this.f35449o == null) {
            return this;
        }
        throw new AssertionError("Upstream is fuseable.");
    }

    @Override // io.reactivex.observers.BaseTestConsumer
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public final TestSubscriber<T> q() {
        if (this.f35447m.get() != null) {
            throw T("Subscribed!");
        }
        if (this.f35274c.isEmpty()) {
            return this;
        }
        throw T("Not subscribed but errors found");
    }

    public final TestSubscriber<T> g0(g<? super TestSubscriber<T>> gVar) {
        try {
            gVar.accept(this);
            return this;
        } catch (Throwable th2) {
            throw ExceptionHelper.f(th2);
        }
    }

    @Override // io.reactivex.observers.BaseTestConsumer
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public final TestSubscriber<T> t() {
        if (this.f35447m.get() != null) {
            return this;
        }
        throw T("Not subscribed!");
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        return this.f35446l;
    }

    public final boolean m0() {
        return this.f35447m.get() != null;
    }

    public final boolean n0() {
        return this.f35446l;
    }

    public void o0() {
    }

    @Override // bu.d
    public void onComplete() {
        if (!this.f35277f) {
            this.f35277f = true;
            if (this.f35447m.get() == null) {
                this.f35274c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f35276e = Thread.currentThread();
            this.f35275d++;
            this.f35445k.onComplete();
        } finally {
            this.f35272a.countDown();
        }
    }

    @Override // bu.d
    public void onError(Throwable th2) {
        if (!this.f35277f) {
            this.f35277f = true;
            if (this.f35447m.get() == null) {
                this.f35274c.add(new NullPointerException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f35276e = Thread.currentThread();
            this.f35274c.add(th2);
            if (th2 == null) {
                this.f35274c.add(new IllegalStateException("onError received a null Throwable"));
            }
            this.f35445k.onError(th2);
        } finally {
            this.f35272a.countDown();
        }
    }

    @Override // bu.d
    public void onNext(T t10) {
        if (!this.f35277f) {
            this.f35277f = true;
            if (this.f35447m.get() == null) {
                this.f35274c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f35276e = Thread.currentThread();
        if (this.f35279h != 2) {
            this.f35273b.add(t10);
            if (t10 == null) {
                this.f35274c.add(new NullPointerException("onNext received a null value"));
            }
            this.f35445k.onNext(t10);
            return;
        }
        while (true) {
            try {
                T tPoll = this.f35449o.poll();
                if (tPoll == null) {
                    return;
                } else {
                    this.f35273b.add(tPoll);
                }
            } catch (Throwable th2) {
                this.f35274c.add(th2);
                this.f35449o.cancel();
                return;
            }
        }
    }

    @Override // xi.o, bu.d
    public void onSubscribe(bu.e eVar) {
        this.f35276e = Thread.currentThread();
        if (eVar == null) {
            this.f35274c.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        if (!this.f35447m.compareAndSet(null, eVar)) {
            eVar.cancel();
            if (this.f35447m.get() != SubscriptionHelper.CANCELLED) {
                this.f35274c.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + eVar));
                return;
            }
            return;
        }
        int i10 = this.f35278g;
        if (i10 != 0 && (eVar instanceof l)) {
            l<T> lVar = (l) eVar;
            this.f35449o = lVar;
            int iRequestFusion = lVar.requestFusion(i10);
            this.f35279h = iRequestFusion;
            if (iRequestFusion == 1) {
                this.f35277f = true;
                this.f35276e = Thread.currentThread();
                while (true) {
                    try {
                        T tPoll = this.f35449o.poll();
                        if (tPoll == null) {
                            this.f35275d++;
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
        this.f35445k.onSubscribe(eVar);
        long andSet = this.f35448n.getAndSet(0L);
        if (andSet != 0) {
            eVar.request(andSet);
        }
        o0();
    }

    public final TestSubscriber<T> p0(long j10) {
        request(j10);
        return this;
    }

    public final TestSubscriber<T> q0(int i10) {
        this.f35278g = i10;
        return this;
    }

    @Override // bu.e
    public final void request(long j10) {
        SubscriptionHelper.deferredRequest(this.f35447m, this.f35448n, j10);
    }

    public TestSubscriber(long j10) {
        this(EmptySubscriber.INSTANCE, j10);
    }

    public TestSubscriber(bu.d<? super T> dVar) {
        this(dVar, Long.MAX_VALUE);
    }

    public TestSubscriber(bu.d<? super T> dVar, long j10) {
        if (j10 >= 0) {
            this.f35445k = dVar;
            this.f35447m = new AtomicReference<>();
            this.f35448n = new AtomicLong(j10);
            return;
        }
        throw new IllegalArgumentException("Negative initial request not allowed");
    }
}
