package io.reactivex.internal.operators.mixed;

import bu.d;
import bu.e;
import dj.o;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import xi.j;
import xi.t;
import xi.w;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableSwitchMapMaybe<T, R> extends j<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j<T> f34054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o<? super T, ? extends w<? extends R>> f34055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f34056d;

    public static final class SwitchMapMaybeSubscriber<T, R> extends AtomicInteger implements xi.o<T>, e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SwitchMapMaybeObserver<Object> f34057a = new SwitchMapMaybeObserver<>(null);
        private static final long serialVersionUID = -5402190102429853762L;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final d<? super R> downstream;
        public long emitted;
        public final o<? super T, ? extends w<? extends R>> mapper;
        public e upstream;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicLong requested = new AtomicLong();
        public final AtomicReference<SwitchMapMaybeObserver<R>> inner = new AtomicReference<>();

        public static final class SwitchMapMaybeObserver<R> extends AtomicReference<io.reactivex.disposables.b> implements t<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            public volatile R item;
            public final SwitchMapMaybeSubscriber<?, R> parent;

            public SwitchMapMaybeObserver(SwitchMapMaybeSubscriber<?, R> switchMapMaybeSubscriber) {
                this.parent = switchMapMaybeSubscriber;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            @Override // xi.t
            public void onComplete() {
                this.parent.c(this);
            }

            @Override // xi.t
            public void onError(Throwable th2) {
                this.parent.d(this, th2);
            }

            @Override // xi.t
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // xi.t
            public void onSuccess(R r10) {
                this.item = r10;
                this.parent.b();
            }
        }

        public SwitchMapMaybeSubscriber(d<? super R> dVar, o<? super T, ? extends w<? extends R>> oVar, boolean z10) {
            this.downstream = dVar;
            this.mapper = oVar;
            this.delayErrors = z10;
        }

        public void a() {
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.inner;
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver = f34057a;
            SwitchMapMaybeObserver<R> andSet = atomicReference.getAndSet((SwitchMapMaybeObserver<R>) switchMapMaybeObserver);
            if (andSet == null || andSet == switchMapMaybeObserver) {
                return;
            }
            andSet.a();
        }

        public void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            d<? super R> dVar = this.downstream;
            AtomicThrowable atomicThrowable = this.errors;
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.inner;
            AtomicLong atomicLong = this.requested;
            long j10 = this.emitted;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (atomicThrowable.get() != null && !this.delayErrors) {
                    dVar.onError(atomicThrowable.c());
                    return;
                }
                boolean z10 = this.done;
                SwitchMapMaybeObserver<R> switchMapMaybeObserver = atomicReference.get();
                boolean z11 = switchMapMaybeObserver == null;
                if (z10 && z11) {
                    Throwable thC = atomicThrowable.c();
                    if (thC != null) {
                        dVar.onError(thC);
                        return;
                    } else {
                        dVar.onComplete();
                        return;
                    }
                }
                if (z11 || switchMapMaybeObserver.item == null || j10 == atomicLong.get()) {
                    this.emitted = j10;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    atomicReference.compareAndSet(switchMapMaybeObserver, null);
                    dVar.onNext(switchMapMaybeObserver.item);
                    j10++;
                }
            }
        }

        public void c(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
            if (this.inner.compareAndSet(switchMapMaybeObserver, null)) {
                b();
            }
        }

        @Override // bu.e
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            a();
        }

        public void d(SwitchMapMaybeObserver<R> switchMapMaybeObserver, Throwable th2) {
            if (!this.inner.compareAndSet(switchMapMaybeObserver, null) || !this.errors.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            if (!this.delayErrors) {
                this.upstream.cancel();
                a();
            }
            b();
        }

        @Override // bu.d
        public void onComplete() {
            this.done = true;
            b();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            if (!this.delayErrors) {
                a();
            }
            this.done = true;
            b();
        }

        @Override // bu.d
        public void onNext(T t10) {
            SwitchMapMaybeObserver<R> switchMapMaybeObserver;
            SwitchMapMaybeObserver<R> switchMapMaybeObserver2 = this.inner.get();
            if (switchMapMaybeObserver2 != null) {
                switchMapMaybeObserver2.a();
            }
            try {
                w wVar = (w) io.reactivex.internal.functions.a.g(this.mapper.apply(t10), "The mapper returned a null MaybeSource");
                SwitchMapMaybeObserver<R> switchMapMaybeObserver3 = new SwitchMapMaybeObserver<>(this);
                do {
                    switchMapMaybeObserver = this.inner.get();
                    if (switchMapMaybeObserver == f34057a) {
                        return;
                    }
                } while (!this.inner.compareAndSet(switchMapMaybeObserver, switchMapMaybeObserver3));
                wVar.a(switchMapMaybeObserver3);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.upstream.cancel();
                this.inner.getAndSet((SwitchMapMaybeObserver<R>) f34057a);
                onError(th2);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            io.reactivex.internal.util.b.a(this.requested, j10);
            b();
        }
    }

    public FlowableSwitchMapMaybe(j<T> jVar, o<? super T, ? extends w<? extends R>> oVar, boolean z10) {
        this.f34054b = jVar;
        this.f34055c = oVar;
        this.f34056d = z10;
    }

    @Override // xi.j
    public void k6(d<? super R> dVar) {
        this.f34054b.j6(new SwitchMapMaybeSubscriber(dVar, this.f34055c, this.f34056d));
    }
}
