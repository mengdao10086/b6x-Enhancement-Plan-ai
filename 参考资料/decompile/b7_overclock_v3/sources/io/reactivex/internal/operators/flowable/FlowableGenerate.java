package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableGenerate<T, S> extends xi.j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable<S> f33256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.c<S, xi.i<T>, S> f33257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.g<? super S> f33258d;

    public static final class GeneratorSubscription<T, S> extends AtomicLong implements xi.i<T>, bu.e {
        private static final long serialVersionUID = 7565982551505011832L;
        public volatile boolean cancelled;
        public final dj.g<? super S> disposeState;
        public final bu.d<? super T> downstream;
        public final dj.c<S, ? super xi.i<T>, S> generator;
        public boolean hasNext;
        public S state;
        public boolean terminate;

        public GeneratorSubscription(bu.d<? super T> dVar, dj.c<S, ? super xi.i<T>, S> cVar, dj.g<? super S> gVar, S s10) {
            this.downstream = dVar;
            this.generator = cVar;
            this.disposeState = gVar;
            this.state = s10;
        }

        @Override // bu.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (io.reactivex.internal.util.b.a(this, 1L) == 0) {
                S s10 = this.state;
                this.state = null;
                f(s10);
            }
        }

        public final void f(S s10) {
            try {
                this.disposeState.accept(s10);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                kj.a.Y(th2);
            }
        }

        @Override // xi.i
        public void onComplete() {
            if (this.terminate) {
                return;
            }
            this.terminate = true;
            this.downstream.onComplete();
        }

        @Override // xi.i
        public void onError(Throwable th2) {
            if (this.terminate) {
                kj.a.Y(th2);
                return;
            }
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.terminate = true;
            this.downstream.onError(th2);
        }

        @Override // xi.i
        public void onNext(T t10) {
            if (this.terminate) {
                return;
            }
            if (this.hasNext) {
                onError(new IllegalStateException("onNext already called in this generate turn"));
            } else if (t10 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.hasNext = true;
                this.downstream.onNext(t10);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0055, code lost:
        
            r9.state = r0;
            r10 = addAndGet(-r4);
         */
        @Override // bu.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void request(long r10) {
            /*
                r9 = this;
                boolean r0 = io.reactivex.internal.subscriptions.SubscriptionHelper.validate(r10)
                if (r0 != 0) goto L7
                return
            L7:
                long r0 = io.reactivex.internal.util.b.a(r9, r10)
                r2 = 0
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 == 0) goto L12
                return
            L12:
                S r0 = r9.state
                dj.c<S, ? super xi.i<T>, S> r1 = r9.generator
            L16:
                r4 = r2
            L17:
                int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
                if (r6 == 0) goto L4d
                boolean r6 = r9.cancelled
                r7 = 0
                if (r6 == 0) goto L26
                r9.state = r7
                r9.f(r0)
                return
            L26:
                r6 = 0
                r9.hasNext = r6
                r6 = 1
                java.lang.Object r0 = r1.apply(r0, r9)     // Catch: java.lang.Throwable -> L3e
                boolean r8 = r9.terminate
                if (r8 == 0) goto L3a
                r9.cancelled = r6
                r9.state = r7
                r9.f(r0)
                return
            L3a:
                r6 = 1
                long r4 = r4 + r6
                goto L17
            L3e:
                r10 = move-exception
                io.reactivex.exceptions.a.b(r10)
                r9.cancelled = r6
                r9.state = r7
                r9.onError(r10)
                r9.f(r0)
                return
            L4d:
                long r10 = r9.get()
                int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
                if (r6 != 0) goto L17
                r9.state = r0
                long r10 = -r4
                long r10 = r9.addAndGet(r10)
                int r4 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
                if (r4 != 0) goto L16
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableGenerate.GeneratorSubscription.request(long):void");
        }
    }

    public FlowableGenerate(Callable<S> callable, dj.c<S, xi.i<T>, S> cVar, dj.g<? super S> gVar) {
        this.f33256b = callable;
        this.f33257c = cVar;
        this.f33258d = gVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        try {
            dVar.onSubscribe(new GeneratorSubscription(dVar, this.f33257c, this.f33258d, this.f33256b.call()));
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptySubscription.error(th2, dVar);
        }
    }
}
