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
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableSwitchMapSingle<T, R> extends j<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j<T> f34058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o<? super T, ? extends o0<? extends R>> f34059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f34060d;

    public static final class SwitchMapSingleSubscriber<T, R> extends AtomicInteger implements xi.o<T>, e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SwitchMapSingleObserver<Object> f34061a = new SwitchMapSingleObserver<>(null);
        private static final long serialVersionUID = -5402190102429853762L;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final d<? super R> downstream;
        public long emitted;
        public final o<? super T, ? extends o0<? extends R>> mapper;
        public e upstream;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicLong requested = new AtomicLong();
        public final AtomicReference<SwitchMapSingleObserver<R>> inner = new AtomicReference<>();

        public static final class SwitchMapSingleObserver<R> extends AtomicReference<io.reactivex.disposables.b> implements l0<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            public volatile R item;
            public final SwitchMapSingleSubscriber<?, R> parent;

            public SwitchMapSingleObserver(SwitchMapSingleSubscriber<?, R> switchMapSingleSubscriber) {
                this.parent = switchMapSingleSubscriber;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            @Override // xi.l0
            public void onError(Throwable th2) {
                this.parent.c(this, th2);
            }

            @Override // xi.l0
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // xi.l0
            public void onSuccess(R r10) {
                this.item = r10;
                this.parent.b();
            }
        }

        public SwitchMapSingleSubscriber(d<? super R> dVar, o<? super T, ? extends o0<? extends R>> oVar, boolean z10) {
            this.downstream = dVar;
            this.mapper = oVar;
            this.delayErrors = z10;
        }

        public void a() {
            AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.inner;
            SwitchMapSingleObserver<Object> switchMapSingleObserver = f34061a;
            SwitchMapSingleObserver<R> andSet = atomicReference.getAndSet((SwitchMapSingleObserver<R>) switchMapSingleObserver);
            if (andSet == null || andSet == switchMapSingleObserver) {
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
            AtomicReference<SwitchMapSingleObserver<R>> atomicReference = this.inner;
            AtomicLong atomicLong = this.requested;
            long j10 = this.emitted;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (atomicThrowable.get() != null && !this.delayErrors) {
                    dVar.onError(atomicThrowable.c());
                    return;
                }
                boolean z10 = this.done;
                SwitchMapSingleObserver<R> switchMapSingleObserver = atomicReference.get();
                boolean z11 = switchMapSingleObserver == null;
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
                if (z11 || switchMapSingleObserver.item == null || j10 == atomicLong.get()) {
                    this.emitted = j10;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    atomicReference.compareAndSet(switchMapSingleObserver, null);
                    dVar.onNext(switchMapSingleObserver.item);
                    j10++;
                }
            }
        }

        public void c(SwitchMapSingleObserver<R> switchMapSingleObserver, Throwable th2) {
            if (!this.inner.compareAndSet(switchMapSingleObserver, null) || !this.errors.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            if (!this.delayErrors) {
                this.upstream.cancel();
                a();
            }
            b();
        }

        @Override // bu.e
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            a();
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
            SwitchMapSingleObserver<R> switchMapSingleObserver;
            SwitchMapSingleObserver<R> switchMapSingleObserver2 = this.inner.get();
            if (switchMapSingleObserver2 != null) {
                switchMapSingleObserver2.a();
            }
            try {
                o0 o0Var = (o0) io.reactivex.internal.functions.a.g(this.mapper.apply(t10), "The mapper returned a null SingleSource");
                SwitchMapSingleObserver<R> switchMapSingleObserver3 = new SwitchMapSingleObserver<>(this);
                do {
                    switchMapSingleObserver = this.inner.get();
                    if (switchMapSingleObserver == f34061a) {
                        return;
                    }
                } while (!this.inner.compareAndSet(switchMapSingleObserver, switchMapSingleObserver3));
                o0Var.a(switchMapSingleObserver3);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.upstream.cancel();
                this.inner.getAndSet((SwitchMapSingleObserver<R>) f34061a);
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

    public FlowableSwitchMapSingle(j<T> jVar, o<? super T, ? extends o0<? extends R>> oVar, boolean z10) {
        this.f34058b = jVar;
        this.f34059c = oVar;
        this.f34060d = z10;
    }

    @Override // xi.j
    public void k6(d<? super R> dVar) {
        this.f34058b.j6(new SwitchMapSingleSubscriber(dVar, this.f34059c, this.f34060d));
    }
}
