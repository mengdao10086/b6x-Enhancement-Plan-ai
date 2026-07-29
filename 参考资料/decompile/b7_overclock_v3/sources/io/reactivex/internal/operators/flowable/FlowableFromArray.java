package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableFromArray<T> extends xi.j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T[] f33253b;

    public static final class ArrayConditionalSubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        public final fj.a<? super T> downstream;

        public ArrayConditionalSubscription(fj.a<? super T> aVar, T[] tArr) {
            super(tArr);
            this.downstream = aVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        public void a() {
            T[] tArr = this.array;
            int length = tArr.length;
            fj.a<? super T> aVar = this.downstream;
            for (int i10 = this.index; i10 != length; i10++) {
                if (this.cancelled) {
                    return;
                }
                T t10 = tArr[i10];
                if (t10 == null) {
                    aVar.onError(new NullPointerException("The element at index " + i10 + " is null"));
                    return;
                }
                aVar.m(t10);
            }
            if (this.cancelled) {
                return;
            }
            aVar.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
        
            r10.index = r2;
            r11 = addAndGet(-r6);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void b(long r11) {
            /*
                r10 = this;
                T[] r0 = r10.array
                int r1 = r0.length
                int r2 = r10.index
                fj.a<? super T> r3 = r10.downstream
                r4 = 0
            L9:
                r6 = r4
            La:
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 == 0) goto L44
                if (r2 == r1) goto L44
                boolean r8 = r10.cancelled
                if (r8 == 0) goto L15
                return
            L15:
                r8 = r0[r2]
                if (r8 != 0) goto L38
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r0 = "The element at index "
                r12.append(r0)
                r12.append(r2)
                java.lang.String r0 = " is null"
                r12.append(r0)
                java.lang.String r12 = r12.toString()
                r11.<init>(r12)
                r3.onError(r11)
                return
            L38:
                boolean r8 = r3.m(r8)
                if (r8 == 0) goto L41
                r8 = 1
                long r6 = r6 + r8
            L41:
                int r2 = r2 + 1
                goto La
            L44:
                if (r2 != r1) goto L4e
                boolean r11 = r10.cancelled
                if (r11 != 0) goto L4d
                r3.onComplete()
            L4d:
                return
            L4e:
                long r11 = r10.get()
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 != 0) goto La
                r10.index = r2
                long r11 = -r6
                long r11 = r10.addAndGet(r11)
                int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r6 != 0) goto L9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromArray.ArrayConditionalSubscription.b(long):void");
        }
    }

    public static final class ArraySubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;
        public final bu.d<? super T> downstream;

        public ArraySubscription(bu.d<? super T> dVar, T[] tArr) {
            super(tArr);
            this.downstream = dVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        public void a() {
            T[] tArr = this.array;
            int length = tArr.length;
            bu.d<? super T> dVar = this.downstream;
            for (int i10 = this.index; i10 != length; i10++) {
                if (this.cancelled) {
                    return;
                }
                T t10 = tArr[i10];
                if (t10 == null) {
                    dVar.onError(new NullPointerException("The element at index " + i10 + " is null"));
                    return;
                }
                dVar.onNext(t10);
            }
            if (this.cancelled) {
                return;
            }
            dVar.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0053, code lost:
        
            r10.index = r2;
            r11 = addAndGet(-r6);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void b(long r11) {
            /*
                r10 = this;
                T[] r0 = r10.array
                int r1 = r0.length
                int r2 = r10.index
                bu.d<? super T> r3 = r10.downstream
                r4 = 0
            L9:
                r6 = r4
            La:
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 == 0) goto L41
                if (r2 == r1) goto L41
                boolean r8 = r10.cancelled
                if (r8 == 0) goto L15
                return
            L15:
                r8 = r0[r2]
                if (r8 != 0) goto L38
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r0 = "The element at index "
                r12.append(r0)
                r12.append(r2)
                java.lang.String r0 = " is null"
                r12.append(r0)
                java.lang.String r12 = r12.toString()
                r11.<init>(r12)
                r3.onError(r11)
                return
            L38:
                r3.onNext(r8)
                r8 = 1
                long r6 = r6 + r8
                int r2 = r2 + 1
                goto La
            L41:
                if (r2 != r1) goto L4b
                boolean r11 = r10.cancelled
                if (r11 != 0) goto L4a
                r3.onComplete()
            L4a:
                return
            L4b:
                long r11 = r10.get()
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 != 0) goto La
                r10.index = r2
                long r11 = -r6
                long r11 = r10.addAndGet(r11)
                int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r6 != 0) goto L9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromArray.ArraySubscription.b(long):void");
        }
    }

    public static abstract class BaseArraySubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        public final T[] array;
        public volatile boolean cancelled;
        public int index;

        public BaseArraySubscription(T[] tArr) {
            this.array = tArr;
        }

        public abstract void a();

        public abstract void b(long j10);

        @Override // bu.e
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // fj.o
        public final void clear() {
            this.index = this.array.length;
        }

        @Override // fj.o
        public final boolean isEmpty() {
            return this.index == this.array.length;
        }

        @Override // fj.o
        @bj.f
        public final T poll() {
            int i10 = this.index;
            T[] tArr = this.array;
            if (i10 == tArr.length) {
                return null;
            }
            this.index = i10 + 1;
            return (T) io.reactivex.internal.functions.a.g(tArr[i10], "array element is null");
        }

        @Override // bu.e
        public final void request(long j10) {
            if (SubscriptionHelper.validate(j10) && io.reactivex.internal.util.b.a(this, j10) == 0) {
                if (j10 == Long.MAX_VALUE) {
                    a();
                } else {
                    b(j10);
                }
            }
        }

        @Override // fj.k
        public final int requestFusion(int i10) {
            return i10 & 1;
        }
    }

    public FlowableFromArray(T[] tArr) {
        this.f33253b = tArr;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        if (dVar instanceof fj.a) {
            dVar.onSubscribe(new ArrayConditionalSubscription((fj.a) dVar, this.f33253b));
        } else {
            dVar.onSubscribe(new ArraySubscription(dVar, this.f33253b));
        }
    }
}
