package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableOnBackpressureBufferStrategy<T> extends io.reactivex.internal.operators.flowable.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.a f33338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BackpressureOverflowStrategy f33339e;

    public static final class OnBackpressureBufferStrategySubscriber<T> extends AtomicInteger implements xi.o<T>, bu.e {
        private static final long serialVersionUID = 3240706908776709697L;
        public final long bufferSize;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final bu.d<? super T> downstream;
        public Throwable error;
        public final dj.a onOverflow;
        public final BackpressureOverflowStrategy strategy;
        public bu.e upstream;
        public final AtomicLong requested = new AtomicLong();
        public final Deque<T> deque = new ArrayDeque();

        public OnBackpressureBufferStrategySubscriber(bu.d<? super T> dVar, dj.a aVar, BackpressureOverflowStrategy backpressureOverflowStrategy, long j10) {
            this.downstream = dVar;
            this.onOverflow = aVar;
            this.strategy = backpressureOverflowStrategy;
            this.bufferSize = j10;
        }

        public void a(Deque<T> deque) {
            synchronized (deque) {
                deque.clear();
            }
        }

        public void b() {
            boolean zIsEmpty;
            T tPoll;
            if (getAndIncrement() != 0) {
                return;
            }
            Deque<T> deque = this.deque;
            bu.d<? super T> dVar = this.downstream;
            int iAddAndGet = 1;
            do {
                long j10 = this.requested.get();
                long j11 = 0;
                while (j11 != j10) {
                    if (this.cancelled) {
                        a(deque);
                        return;
                    }
                    boolean z10 = this.done;
                    synchronized (deque) {
                        tPoll = deque.poll();
                    }
                    boolean z11 = tPoll == null;
                    if (z10) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            a(deque);
                            dVar.onError(th2);
                            return;
                        } else if (z11) {
                            dVar.onComplete();
                            return;
                        }
                    }
                    if (z11) {
                        break;
                    }
                    dVar.onNext(tPoll);
                    j11++;
                }
                if (j11 == j10) {
                    if (this.cancelled) {
                        a(deque);
                        return;
                    }
                    boolean z12 = this.done;
                    synchronized (deque) {
                        zIsEmpty = deque.isEmpty();
                    }
                    if (z12) {
                        Throwable th3 = this.error;
                        if (th3 != null) {
                            a(deque);
                            dVar.onError(th3);
                            return;
                        } else if (zIsEmpty) {
                            dVar.onComplete();
                            return;
                        }
                    }
                }
                if (j11 != 0) {
                    io.reactivex.internal.util.b.e(this.requested, j11);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // bu.e
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                a(this.deque);
            }
        }

        @Override // bu.d
        public void onComplete() {
            this.done = true;
            b();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.done) {
                kj.a.Y(th2);
                return;
            }
            this.error = th2;
            this.done = true;
            b();
        }

        @Override // bu.d
        public void onNext(T t10) {
            boolean z10;
            boolean z11;
            if (this.done) {
                return;
            }
            Deque<T> deque = this.deque;
            synchronized (deque) {
                z10 = false;
                z11 = true;
                if (deque.size() == this.bufferSize) {
                    int i10 = a.f33340a[this.strategy.ordinal()];
                    if (i10 == 1) {
                        deque.pollLast();
                        deque.offer(t10);
                    } else if (i10 == 2) {
                        deque.poll();
                        deque.offer(t10);
                    }
                    z10 = true;
                } else {
                    deque.offer(t10);
                }
                z11 = false;
            }
            if (!z10) {
                if (!z11) {
                    b();
                    return;
                } else {
                    this.upstream.cancel();
                    onError(new MissingBackpressureException());
                    return;
                }
            }
            dj.a aVar = this.onOverflow;
            if (aVar != null) {
                try {
                    aVar.run();
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.upstream.cancel();
                    onError(th2);
                }
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                b();
            }
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f33340a;

        static {
            int[] iArr = new int[BackpressureOverflowStrategy.values().length];
            f33340a = iArr;
            try {
                iArr[BackpressureOverflowStrategy.DROP_LATEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33340a[BackpressureOverflowStrategy.DROP_OLDEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public FlowableOnBackpressureBufferStrategy(xi.j<T> jVar, long j10, dj.a aVar, BackpressureOverflowStrategy backpressureOverflowStrategy) {
        super(jVar);
        this.f33337c = j10;
        this.f33338d = aVar;
        this.f33339e = backpressureOverflowStrategy;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new OnBackpressureBufferStrategySubscriber(dVar, this.f33338d, this.f33339e, this.f33337c));
    }
}
