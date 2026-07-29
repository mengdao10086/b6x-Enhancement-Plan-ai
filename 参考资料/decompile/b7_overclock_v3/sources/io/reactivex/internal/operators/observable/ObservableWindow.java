package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableWindow<T> extends a<T, xi.z<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f34390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f34391d;

    public static final class WindowExactObserver<T> extends AtomicInteger implements xi.g0<T>, io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = -7481782523886138128L;
        public volatile boolean cancelled;
        public final int capacityHint;
        public final long count;
        public final xi.g0<? super xi.z<T>> downstream;
        public long size;
        public io.reactivex.disposables.b upstream;
        public UnicastSubject<T> window;

        public WindowExactObserver(xi.g0<? super xi.z<T>> g0Var, long j10, int i10) {
            this.downstream = g0Var;
            this.count = j10;
            this.capacityHint = i10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // xi.g0
        public void onComplete() {
            UnicastSubject<T> unicastSubject = this.window;
            if (unicastSubject != null) {
                this.window = null;
                unicastSubject.onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            UnicastSubject<T> unicastSubject = this.window;
            if (unicastSubject != null) {
                this.window = null;
                unicastSubject.onError(th2);
            }
            this.downstream.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            UnicastSubject<T> unicastSubjectP8 = this.window;
            if (unicastSubjectP8 == null && !this.cancelled) {
                unicastSubjectP8 = UnicastSubject.p8(this.capacityHint, this);
                this.window = unicastSubjectP8;
                this.downstream.onNext(unicastSubjectP8);
            }
            if (unicastSubjectP8 != null) {
                unicastSubjectP8.onNext(t10);
                long j10 = this.size + 1;
                this.size = j10;
                if (j10 >= this.count) {
                    this.size = 0L;
                    this.window = null;
                    unicastSubjectP8.onComplete();
                    if (this.cancelled) {
                        this.upstream.dispose();
                    }
                }
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                this.upstream.dispose();
            }
        }
    }

    public static final class WindowSkipObserver<T> extends AtomicBoolean implements xi.g0<T>, io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 3366976432059579510L;
        public volatile boolean cancelled;
        public final int capacityHint;
        public final long count;
        public final xi.g0<? super xi.z<T>> downstream;
        public long firstEmission;
        public long index;
        public final long skip;
        public io.reactivex.disposables.b upstream;
        public final AtomicInteger wip = new AtomicInteger();
        public final ArrayDeque<UnicastSubject<T>> windows = new ArrayDeque<>();

        public WindowSkipObserver(xi.g0<? super xi.z<T>> g0Var, long j10, long j11, int i10) {
            this.downstream = g0Var;
            this.count = j10;
            this.skip = j11;
            this.capacityHint = i10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // xi.g0
        public void onComplete() {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onError(th2);
            }
            this.downstream.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
            long j10 = this.index;
            long j11 = this.skip;
            if (j10 % j11 == 0 && !this.cancelled) {
                this.wip.getAndIncrement();
                UnicastSubject<T> unicastSubjectP8 = UnicastSubject.p8(this.capacityHint, this);
                arrayDeque.offer(unicastSubjectP8);
                this.downstream.onNext(unicastSubjectP8);
            }
            long j12 = this.firstEmission + 1;
            Iterator<UnicastSubject<T>> it2 = arrayDeque.iterator();
            while (it2.hasNext()) {
                it2.next().onNext(t10);
            }
            if (j12 >= this.count) {
                arrayDeque.poll().onComplete();
                if (arrayDeque.isEmpty() && this.cancelled) {
                    this.upstream.dispose();
                    return;
                }
                this.firstEmission = j12 - j11;
            } else {
                this.firstEmission = j12;
            }
            this.index = j10 + 1;
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.decrementAndGet() == 0 && this.cancelled) {
                this.upstream.dispose();
            }
        }
    }

    public ObservableWindow(xi.e0<T> e0Var, long j10, long j11, int i10) {
        super(e0Var);
        this.f34389b = j10;
        this.f34390c = j11;
        this.f34391d = i10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super xi.z<T>> g0Var) {
        if (this.f34389b == this.f34390c) {
            this.f34421a.c(new WindowExactObserver(g0Var, this.f34389b, this.f34391d));
        } else {
            this.f34421a.c(new WindowSkipObserver(g0Var, this.f34389b, this.f34390c, this.f34391d));
        }
    }
}
