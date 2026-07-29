package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableOnBackpressureLatest<T> extends a<T, T> {

    public static final class BackpressureLatestSubscriber<T> extends AtomicInteger implements xi.o<T>, bu.e {
        private static final long serialVersionUID = 163080509307634843L;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final bu.d<? super T> downstream;
        public Throwable error;
        public bu.e upstream;
        public final AtomicLong requested = new AtomicLong();
        public final AtomicReference<T> current = new AtomicReference<>();

        public BackpressureLatestSubscriber(bu.d<? super T> dVar) {
            this.downstream = dVar;
        }

        public boolean a(boolean z10, boolean z11, bu.d<?> dVar, AtomicReference<T> atomicReference) {
            if (this.cancelled) {
                atomicReference.lazySet(null);
                return true;
            }
            if (!z10) {
                return false;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                atomicReference.lazySet(null);
                dVar.onError(th2);
                return true;
            }
            if (!z11) {
                return false;
            }
            dVar.onComplete();
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
        
            if (r7 != r1.get()) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
        
            r9 = r13.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
        
            if (r2.get() != null) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
        
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
        
            if (a(r9, r11, r0, r2) == false) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
        
            if (r7 == 0) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
        
            io.reactivex.internal.util.b.e(r1, r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
        
            r4 = addAndGet(-r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void b() {
            /*
                r13 = this;
                int r0 = r13.getAndIncrement()
                if (r0 == 0) goto L7
                return
            L7:
                bu.d<? super T> r0 = r13.downstream
                java.util.concurrent.atomic.AtomicLong r1 = r13.requested
                java.util.concurrent.atomic.AtomicReference<T> r2 = r13.current
                r3 = 1
                r4 = 1
            Lf:
                r5 = 0
                r7 = r5
            L12:
                long r9 = r1.get()
                r11 = 0
                int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r12 == 0) goto L38
                boolean r9 = r13.done
                r10 = 0
                java.lang.Object r10 = r2.getAndSet(r10)
                if (r10 != 0) goto L26
                r12 = 1
                goto L27
            L26:
                r12 = 0
            L27:
                boolean r9 = r13.a(r9, r12, r0, r2)
                if (r9 == 0) goto L2e
                return
            L2e:
                if (r12 == 0) goto L31
                goto L38
            L31:
                r0.onNext(r10)
                r9 = 1
                long r7 = r7 + r9
                goto L12
            L38:
                long r9 = r1.get()
                int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r12 != 0) goto L50
                boolean r9 = r13.done
                java.lang.Object r10 = r2.get()
                if (r10 != 0) goto L49
                r11 = 1
            L49:
                boolean r9 = r13.a(r9, r11, r0, r2)
                if (r9 == 0) goto L50
                return
            L50:
                int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r9 == 0) goto L57
                io.reactivex.internal.util.b.e(r1, r7)
            L57:
                int r4 = -r4
                int r4 = r13.addAndGet(r4)
                if (r4 != 0) goto Lf
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest.BackpressureLatestSubscriber.b():void");
        }

        @Override // bu.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.current.lazySet(null);
            }
        }

        @Override // bu.d
        public void onComplete() {
            this.done = true;
            b();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.error = th2;
            this.done = true;
            b();
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.current.lazySet(t10);
            b();
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

    public FlowableOnBackpressureLatest(xi.j<T> jVar) {
        super(jVar);
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new BackpressureLatestSubscriber(dVar));
    }
}
