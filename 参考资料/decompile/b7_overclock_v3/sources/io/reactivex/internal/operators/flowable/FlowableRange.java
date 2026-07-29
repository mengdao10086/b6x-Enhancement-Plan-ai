package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableRange extends xi.j<Integer> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f33378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f33379c;

    public static abstract class BaseRangeSubscription extends BasicQueueSubscription<Integer> {
        private static final long serialVersionUID = -2252972430506210021L;
        public volatile boolean cancelled;
        public final int end;
        public int index;

        public BaseRangeSubscription(int i10, int i11) {
            this.index = i10;
            this.end = i11;
        }

        public abstract void a();

        @Override // fj.o
        @bj.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Integer poll() {
            int i10 = this.index;
            if (i10 == this.end) {
                return null;
            }
            this.index = i10 + 1;
            return Integer.valueOf(i10);
        }

        public abstract void c(long j10);

        @Override // bu.e
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // fj.o
        public final void clear() {
            this.index = this.end;
        }

        @Override // fj.o
        public final boolean isEmpty() {
            return this.index == this.end;
        }

        @Override // bu.e
        public final void request(long j10) {
            if (SubscriptionHelper.validate(j10) && io.reactivex.internal.util.b.a(this, j10) == 0) {
                if (j10 == Long.MAX_VALUE) {
                    a();
                } else {
                    c(j10);
                }
            }
        }

        @Override // fj.k
        public final int requestFusion(int i10) {
            return i10 & 1;
        }
    }

    public static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        public final fj.a<? super Integer> downstream;

        public RangeConditionalSubscription(fj.a<? super Integer> aVar, int i10, int i11) {
            super(i10, i11);
            this.downstream = aVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        public void a() {
            int i10 = this.end;
            fj.a<? super Integer> aVar = this.downstream;
            for (int i11 = this.index; i11 != i10; i11++) {
                if (this.cancelled) {
                    return;
                }
                aVar.m(Integer.valueOf(i11));
            }
            if (this.cancelled) {
                return;
            }
            aVar.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
        
            r9.index = r1;
            r10 = addAndGet(-r5);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void c(long r10) {
            /*
                r9 = this;
                int r0 = r9.end
                int r1 = r9.index
                fj.a<? super java.lang.Integer> r2 = r9.downstream
                r3 = 0
            L8:
                r5 = r3
            L9:
                int r7 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
                if (r7 == 0) goto L24
                if (r1 == r0) goto L24
                boolean r7 = r9.cancelled
                if (r7 == 0) goto L14
                return
            L14:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
                boolean r7 = r2.m(r7)
                if (r7 == 0) goto L21
                r7 = 1
                long r5 = r5 + r7
            L21:
                int r1 = r1 + 1
                goto L9
            L24:
                if (r1 != r0) goto L2e
                boolean r10 = r9.cancelled
                if (r10 != 0) goto L2d
                r2.onComplete()
            L2d:
                return
            L2e:
                long r10 = r9.get()
                int r7 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
                if (r7 != 0) goto L9
                r9.index = r1
                long r10 = -r5
                long r10 = r9.addAndGet(r10)
                int r5 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                if (r5 != 0) goto L8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableRange.RangeConditionalSubscription.c(long):void");
        }
    }

    public static final class RangeSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        public final bu.d<? super Integer> downstream;

        public RangeSubscription(bu.d<? super Integer> dVar, int i10, int i11) {
            super(i10, i11);
            this.downstream = dVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        public void a() {
            int i10 = this.end;
            bu.d<? super Integer> dVar = this.downstream;
            for (int i11 = this.index; i11 != i10; i11++) {
                if (this.cancelled) {
                    return;
                }
                dVar.onNext(Integer.valueOf(i11));
            }
            if (this.cancelled) {
                return;
            }
            dVar.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
        
            r9.index = r1;
            r10 = addAndGet(-r5);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void c(long r10) {
            /*
                r9 = this;
                int r0 = r9.end
                int r1 = r9.index
                bu.d<? super java.lang.Integer> r2 = r9.downstream
                r3 = 0
            L8:
                r5 = r3
            L9:
                int r7 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
                if (r7 == 0) goto L21
                if (r1 == r0) goto L21
                boolean r7 = r9.cancelled
                if (r7 == 0) goto L14
                return
            L14:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
                r2.onNext(r7)
                r7 = 1
                long r5 = r5 + r7
                int r1 = r1 + 1
                goto L9
            L21:
                if (r1 != r0) goto L2b
                boolean r10 = r9.cancelled
                if (r10 != 0) goto L2a
                r2.onComplete()
            L2a:
                return
            L2b:
                long r10 = r9.get()
                int r7 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
                if (r7 != 0) goto L9
                r9.index = r1
                long r10 = -r5
                long r10 = r9.addAndGet(r10)
                int r5 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                if (r5 != 0) goto L8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableRange.RangeSubscription.c(long):void");
        }
    }

    public FlowableRange(int i10, int i11) {
        this.f33378b = i10;
        this.f33379c = i10 + i11;
    }

    @Override // xi.j
    public void k6(bu.d<? super Integer> dVar) {
        if (dVar instanceof fj.a) {
            dVar.onSubscribe(new RangeConditionalSubscription((fj.a) dVar, this.f33378b, this.f33379c));
        } else {
            dVar.onSubscribe(new RangeSubscription(dVar, this.f33378b, this.f33379c));
        }
    }
}
