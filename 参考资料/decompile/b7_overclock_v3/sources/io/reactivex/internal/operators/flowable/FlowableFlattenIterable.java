package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableFlattenIterable<T, R> extends a<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super T, ? extends Iterable<? extends R>> f33251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f33252d;

    public static final class FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements xi.o<T> {
        private static final long serialVersionUID = -3096000382929934955L;
        public volatile boolean cancelled;
        public int consumed;
        public Iterator<? extends R> current;
        public volatile boolean done;
        public final bu.d<? super R> downstream;
        public int fusionMode;
        public final int limit;
        public final dj.o<? super T, ? extends Iterable<? extends R>> mapper;
        public final int prefetch;
        public fj.o<T> queue;
        public bu.e upstream;
        public final AtomicReference<Throwable> error = new AtomicReference<>();
        public final AtomicLong requested = new AtomicLong();

        public FlattenIterableSubscriber(bu.d<? super R> dVar, dj.o<? super T, ? extends Iterable<? extends R>> oVar, int i10) {
            this.downstream = dVar;
            this.mapper = oVar;
            this.prefetch = i10;
            this.limit = i10 - (i10 >> 2);
        }

        /* JADX WARN: Removed duplicated region for block: B:69:0x0124 A[PHI: r6
  0x0124: PHI (r6v4 java.util.Iterator<? extends R>) = (r6v3 java.util.Iterator<? extends R>), (r6v6 java.util.Iterator<? extends R>) binds: [B:30:0x0080, B:67:0x0121] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void b() {
            /*
                Method dump skipped, instruction units count: 303
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlattenIterable.FlattenIterableSubscriber.b():void");
        }

        public boolean c(boolean z10, boolean z11, bu.d<?> dVar, fj.o<?> oVar) {
            if (this.cancelled) {
                this.current = null;
                oVar.clear();
                return true;
            }
            if (!z10) {
                return false;
            }
            if (this.error.get() == null) {
                if (!z11) {
                    return false;
                }
                dVar.onComplete();
                return true;
            }
            Throwable thC = ExceptionHelper.c(this.error);
            this.current = null;
            oVar.clear();
            dVar.onError(thC);
            return true;
        }

        @Override // bu.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // fj.o
        public void clear() {
            this.current = null;
            this.queue.clear();
        }

        public void h(boolean z10) {
            if (z10) {
                int i10 = this.consumed + 1;
                if (i10 != this.limit) {
                    this.consumed = i10;
                } else {
                    this.consumed = 0;
                    this.upstream.request(i10);
                }
            }
        }

        @Override // fj.o
        public boolean isEmpty() {
            return this.current == null && this.queue.isEmpty();
        }

        @Override // bu.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            b();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.done || !ExceptionHelper.a(this.error, th2)) {
                kj.a.Y(th2);
            } else {
                this.done = true;
                b();
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            if (this.fusionMode != 0 || this.queue.offer(t10)) {
                b();
            } else {
                onError(new MissingBackpressureException("Queue is full?!"));
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                if (eVar instanceof fj.l) {
                    fj.l lVar = (fj.l) eVar;
                    int iRequestFusion = lVar.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.fusionMode = iRequestFusion;
                        this.queue = lVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.fusionMode = iRequestFusion;
                        this.queue = lVar;
                        this.downstream.onSubscribe(this);
                        eVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.downstream.onSubscribe(this);
                eVar.request(this.prefetch);
            }
        }

        @Override // fj.o
        @bj.f
        public R poll() throws Exception {
            Iterator<? extends R> it2 = this.current;
            while (true) {
                if (it2 == null) {
                    T tPoll = this.queue.poll();
                    if (tPoll != null) {
                        it2 = this.mapper.apply(tPoll).iterator();
                        if (it2.hasNext()) {
                            this.current = it2;
                            break;
                        }
                        it2 = null;
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
            R r10 = (R) io.reactivex.internal.functions.a.g(it2.next(), "The iterator returned a null value");
            if (!it2.hasNext()) {
                this.current = null;
            }
            return r10;
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                b();
            }
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            return ((i10 & 1) == 0 || this.fusionMode != 1) ? 0 : 1;
        }
    }

    public FlowableFlattenIterable(xi.j<T> jVar, dj.o<? super T, ? extends Iterable<? extends R>> oVar, int i10) {
        super(jVar);
        this.f33251c = oVar;
        this.f33252d = i10;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // xi.j
    public void k6(bu.d<? super R> dVar) {
        xi.j<T> jVar = this.f33524b;
        if (!(jVar instanceof Callable)) {
            jVar.j6(new FlattenIterableSubscriber(dVar, this.f33251c, this.f33252d));
            return;
        }
        try {
            Object objCall = ((Callable) jVar).call();
            if (objCall == null) {
                EmptySubscription.complete(dVar);
                return;
            }
            try {
                FlowableFromIterable.M8(dVar, this.f33251c.apply(objCall).iterator());
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                EmptySubscription.error(th2, dVar);
            }
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            EmptySubscription.error(th3, dVar);
        }
    }
}
