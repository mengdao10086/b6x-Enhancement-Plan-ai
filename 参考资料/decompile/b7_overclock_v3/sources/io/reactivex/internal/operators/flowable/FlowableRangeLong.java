package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableRangeLong extends xi.j<Long> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f33380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33381c;

    public static abstract class BaseRangeSubscription extends BasicQueueSubscription<Long> {
        private static final long serialVersionUID = -2252972430506210021L;
        public volatile boolean cancelled;
        public final long end;
        public long index;

        public BaseRangeSubscription(long j10, long j11) {
            this.index = j10;
            this.end = j11;
        }

        public abstract void a();

        @Override // fj.o
        @bj.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Long poll() {
            long j10 = this.index;
            if (j10 == this.end) {
                return null;
            }
            this.index = 1 + j10;
            return Long.valueOf(j10);
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
        public final fj.a<? super Long> downstream;

        public RangeConditionalSubscription(fj.a<? super Long> aVar, long j10, long j11) {
            super(j10, j11);
            this.downstream = aVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        public void a() {
            long j10 = this.end;
            fj.a<? super Long> aVar = this.downstream;
            for (long j11 = this.index; j11 != j10; j11++) {
                if (this.cancelled) {
                    return;
                }
                aVar.m(Long.valueOf(j11));
            }
            if (this.cancelled) {
                return;
            }
            aVar.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:
        
            r12.index = r2;
            r13 = addAndGet(-r7);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void c(long r13) {
            /*
                r12 = this;
                long r0 = r12.end
                long r2 = r12.index
                fj.a<? super java.lang.Long> r4 = r12.downstream
                r5 = 0
            L8:
                r7 = r5
            L9:
                int r9 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
                if (r9 == 0) goto L25
                int r9 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r9 == 0) goto L25
                boolean r9 = r12.cancelled
                if (r9 == 0) goto L16
                return
            L16:
                java.lang.Long r9 = java.lang.Long.valueOf(r2)
                boolean r9 = r4.m(r9)
                r10 = 1
                if (r9 == 0) goto L23
                long r7 = r7 + r10
            L23:
                long r2 = r2 + r10
                goto L9
            L25:
                int r13 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r13 != 0) goto L31
                boolean r13 = r12.cancelled
                if (r13 != 0) goto L30
                r4.onComplete()
            L30:
                return
            L31:
                long r13 = r12.get()
                int r9 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
                if (r9 != 0) goto L9
                r12.index = r2
                long r13 = -r7
                long r13 = r12.addAndGet(r13)
                int r7 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
                if (r7 != 0) goto L8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableRangeLong.RangeConditionalSubscription.c(long):void");
        }
    }

    public static final class RangeSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        public final bu.d<? super Long> downstream;

        public RangeSubscription(bu.d<? super Long> dVar, long j10, long j11) {
            super(j10, j11);
            this.downstream = dVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        public void a() {
            long j10 = this.end;
            bu.d<? super Long> dVar = this.downstream;
            for (long j11 = this.index; j11 != j10; j11++) {
                if (this.cancelled) {
                    return;
                }
                dVar.onNext(Long.valueOf(j11));
            }
            if (this.cancelled) {
                return;
            }
            dVar.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
        
            r11.index = r2;
            r12 = addAndGet(-r7);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void c(long r12) {
            /*
                r11 = this;
                long r0 = r11.end
                long r2 = r11.index
                bu.d<? super java.lang.Long> r4 = r11.downstream
                r5 = 0
            L8:
                r7 = r5
            L9:
                int r9 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
                if (r9 == 0) goto L22
                int r9 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r9 == 0) goto L22
                boolean r9 = r11.cancelled
                if (r9 == 0) goto L16
                return
            L16:
                java.lang.Long r9 = java.lang.Long.valueOf(r2)
                r4.onNext(r9)
                r9 = 1
                long r7 = r7 + r9
                long r2 = r2 + r9
                goto L9
            L22:
                int r12 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r12 != 0) goto L2e
                boolean r12 = r11.cancelled
                if (r12 != 0) goto L2d
                r4.onComplete()
            L2d:
                return
            L2e:
                long r12 = r11.get()
                int r9 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
                if (r9 != 0) goto L9
                r11.index = r2
                long r12 = -r7
                long r12 = r11.addAndGet(r12)
                int r7 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
                if (r7 != 0) goto L8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableRangeLong.RangeSubscription.c(long):void");
        }
    }

    public FlowableRangeLong(long j10, long j11) {
        this.f33380b = j10;
        this.f33381c = j10 + j11;
    }

    @Override // xi.j
    public void k6(bu.d<? super Long> dVar) {
        if (dVar instanceof fj.a) {
            dVar.onSubscribe(new RangeConditionalSubscription((fj.a) dVar, this.f33380b, this.f33381c));
        } else {
            dVar.onSubscribe(new RangeSubscription(dVar, this.f33380b, this.f33381c));
        }
    }
}
