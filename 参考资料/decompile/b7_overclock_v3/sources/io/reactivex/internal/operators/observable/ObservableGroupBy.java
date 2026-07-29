package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableGroupBy<T, K, V> extends io.reactivex.internal.operators.observable.a<T, ij.b<K, V>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends K> f34184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super T, ? extends V> f34185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f34186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f34187e;

    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Object f34188a = new Object();
        private static final long serialVersionUID = -3688291656102519502L;
        public final int bufferSize;
        public final boolean delayError;
        public final xi.g0<? super ij.b<K, V>> downstream;
        public final dj.o<? super T, ? extends K> keySelector;
        public io.reactivex.disposables.b upstream;
        public final dj.o<? super T, ? extends V> valueSelector;
        public final AtomicBoolean cancelled = new AtomicBoolean();
        public final Map<Object, a<K, V>> groups = new ConcurrentHashMap();

        public GroupByObserver(xi.g0<? super ij.b<K, V>> g0Var, dj.o<? super T, ? extends K> oVar, dj.o<? super T, ? extends V> oVar2, int i10, boolean z10) {
            this.downstream = g0Var;
            this.keySelector = oVar;
            this.valueSelector = oVar2;
            this.bufferSize = i10;
            this.delayError = z10;
            lazySet(1);
        }

        public void a(K k10) {
            if (k10 == null) {
                k10 = (K) f34188a;
            }
            this.groups.remove(k10);
            if (decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled.get();
        }

        @Override // xi.g0
        public void onComplete() {
            ArrayList arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((a) it2.next()).onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            ArrayList arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((a) it2.next()).onError(th2);
            }
            this.downstream.onError(th2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // xi.g0
        public void onNext(T t10) {
            try {
                K kApply = this.keySelector.apply(t10);
                Object obj = kApply != null ? kApply : f34188a;
                a<K, V> aVar = this.groups.get(obj);
                a aVar2 = aVar;
                if (aVar == false) {
                    if (this.cancelled.get()) {
                        return;
                    }
                    a<K, V> aVarJ8 = a.j8(kApply, this.bufferSize, this, this.delayError);
                    this.groups.put(obj, aVarJ8);
                    getAndIncrement();
                    this.downstream.onNext(aVarJ8);
                    aVar2 = aVarJ8;
                }
                try {
                    aVar2.onNext(io.reactivex.internal.functions.a.g(this.valueSelector.apply(t10), "The value supplied is null"));
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.upstream.dispose();
                    onError(th2);
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.upstream.dispose();
                onError(th3);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public static final class State<T, K> extends AtomicInteger implements io.reactivex.disposables.b, xi.e0<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public final K key;
        public final GroupByObserver<?, K, T> parent;
        public final io.reactivex.internal.queue.a<T> queue;
        public final AtomicBoolean cancelled = new AtomicBoolean();
        public final AtomicBoolean once = new AtomicBoolean();
        public final AtomicReference<xi.g0<? super T>> actual = new AtomicReference<>();

        public State(int i10, GroupByObserver<?, K, T> groupByObserver, K k10, boolean z10) {
            this.queue = new io.reactivex.internal.queue.a<>(i10);
            this.parent = groupByObserver;
            this.key = k10;
            this.delayError = z10;
        }

        public boolean a(boolean z10, boolean z11, xi.g0<? super T> g0Var, boolean z12) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.a(this.key);
                this.actual.lazySet(null);
                return true;
            }
            if (!z10) {
                return false;
            }
            if (z12) {
                if (!z11) {
                    return false;
                }
                Throwable th2 = this.error;
                this.actual.lazySet(null);
                if (th2 != null) {
                    g0Var.onError(th2);
                } else {
                    g0Var.onComplete();
                }
                return true;
            }
            Throwable th3 = this.error;
            if (th3 != null) {
                this.queue.clear();
                this.actual.lazySet(null);
                g0Var.onError(th3);
                return true;
            }
            if (!z11) {
                return false;
            }
            this.actual.lazySet(null);
            g0Var.onComplete();
            return true;
        }

        public void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.internal.queue.a<T> aVar = this.queue;
            boolean z10 = this.delayError;
            xi.g0<? super T> g0Var = this.actual.get();
            int iAddAndGet = 1;
            while (true) {
                if (g0Var != null) {
                    while (true) {
                        boolean z11 = this.done;
                        T tPoll = aVar.poll();
                        boolean z12 = tPoll == null;
                        if (a(z11, z12, g0Var, z10)) {
                            return;
                        }
                        if (z12) {
                            break;
                        } else {
                            g0Var.onNext(tPoll);
                        }
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (g0Var == null) {
                    g0Var = this.actual.get();
                }
            }
        }

        @Override // xi.e0
        public void c(xi.g0<? super T> g0Var) {
            if (!this.once.compareAndSet(false, true)) {
                EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), g0Var);
                return;
            }
            g0Var.onSubscribe(this);
            this.actual.lazySet(g0Var);
            if (this.cancelled.get()) {
                this.actual.lazySet(null);
            } else {
                b();
            }
        }

        public void d() {
            this.done = true;
            b();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.actual.lazySet(null);
                this.parent.a(this.key);
            }
        }

        public void f(Throwable th2) {
            this.error = th2;
            this.done = true;
            b();
        }

        public void h(T t10) {
            this.queue.offer(t10);
            b();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled.get();
        }
    }

    public static final class a<K, T> extends ij.b<K, T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final State<T, K> f34189b;

        public a(K k10, State<T, K> state) {
            super(k10);
            this.f34189b = state;
        }

        public static <T, K> a<K, T> j8(K k10, int i10, GroupByObserver<?, K, T> groupByObserver, boolean z10) {
            return new a<>(k10, new State(i10, groupByObserver, k10, z10));
        }

        @Override // xi.z
        public void I5(xi.g0<? super T> g0Var) {
            this.f34189b.c(g0Var);
        }

        public void onComplete() {
            this.f34189b.d();
        }

        public void onError(Throwable th2) {
            this.f34189b.f(th2);
        }

        public void onNext(T t10) {
            this.f34189b.h(t10);
        }
    }

    public ObservableGroupBy(xi.e0<T> e0Var, dj.o<? super T, ? extends K> oVar, dj.o<? super T, ? extends V> oVar2, int i10, boolean z10) {
        super(e0Var);
        this.f34184b = oVar;
        this.f34185c = oVar2;
        this.f34186d = i10;
        this.f34187e = z10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super ij.b<K, V>> g0Var) {
        this.f34421a.c(new GroupByObserver(g0Var, this.f34184b, this.f34185c, this.f34186d, this.f34187e));
    }
}
