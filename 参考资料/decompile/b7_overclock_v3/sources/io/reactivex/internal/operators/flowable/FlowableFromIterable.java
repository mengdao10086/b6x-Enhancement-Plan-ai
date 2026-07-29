package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableFromIterable<T> extends xi.j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Iterable<? extends T> f33254b;

    public static abstract class BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;
        public volatile boolean cancelled;

        /* JADX INFO: renamed from: it, reason: collision with root package name */
        public Iterator<? extends T> f33255it;
        public boolean once;

        public BaseRangeSubscription(Iterator<? extends T> it2) {
            this.f33255it = it2;
        }

        public abstract void a();

        public abstract void b(long j10);

        @Override // bu.e
        public final void cancel() {
            this.cancelled = true;
        }

        @Override // fj.o
        public final void clear() {
            this.f33255it = null;
        }

        @Override // fj.o
        public final boolean isEmpty() {
            Iterator<? extends T> it2 = this.f33255it;
            return it2 == null || !it2.hasNext();
        }

        @Override // fj.o
        @bj.f
        public final T poll() {
            Iterator<? extends T> it2 = this.f33255it;
            if (it2 == null) {
                return null;
            }
            if (!this.once) {
                this.once = true;
            } else if (!it2.hasNext()) {
                return null;
            }
            return (T) io.reactivex.internal.functions.a.g(this.f33255it.next(), "Iterator.next() returned a null value");
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

    public static final class IteratorConditionalSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        public final fj.a<? super T> downstream;

        public IteratorConditionalSubscription(fj.a<? super T> aVar, Iterator<? extends T> it2) {
            super(it2);
            this.downstream = aVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        public void a() {
            Iterator<? extends T> it2 = this.f33255it;
            fj.a<? super T> aVar = this.downstream;
            while (!this.cancelled) {
                try {
                    T next = it2.next();
                    if (this.cancelled) {
                        return;
                    }
                    if (next == null) {
                        aVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    aVar.m(next);
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        if (!it2.hasNext()) {
                            if (this.cancelled) {
                                return;
                            }
                            aVar.onComplete();
                            return;
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        aVar.onError(th2);
                        return;
                    }
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    aVar.onError(th3);
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x005b, code lost:
        
            r9 = addAndGet(-r4);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void b(long r9) {
            /*
                r8 = this;
                java.util.Iterator<? extends T> r0 = r8.f33255it
                fj.a<? super T> r1 = r8.downstream
                r2 = 0
            L6:
                r4 = r2
            L7:
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 == 0) goto L53
                boolean r6 = r8.cancelled
                if (r6 == 0) goto L10
                return
            L10:
                java.lang.Object r6 = r0.next()     // Catch: java.lang.Throwable -> L4b
                boolean r7 = r8.cancelled
                if (r7 == 0) goto L19
                return
            L19:
                if (r6 != 0) goto L26
                java.lang.NullPointerException r9 = new java.lang.NullPointerException
                java.lang.String r10 = "Iterator.next() returned a null value"
                r9.<init>(r10)
                r1.onError(r9)
                return
            L26:
                boolean r6 = r1.m(r6)
                boolean r7 = r8.cancelled
                if (r7 == 0) goto L2f
                return
            L2f:
                boolean r7 = r0.hasNext()     // Catch: java.lang.Throwable -> L43
                if (r7 != 0) goto L3d
                boolean r9 = r8.cancelled
                if (r9 != 0) goto L3c
                r1.onComplete()
            L3c:
                return
            L3d:
                if (r6 == 0) goto L7
                r6 = 1
                long r4 = r4 + r6
                goto L7
            L43:
                r9 = move-exception
                io.reactivex.exceptions.a.b(r9)
                r1.onError(r9)
                return
            L4b:
                r9 = move-exception
                io.reactivex.exceptions.a.b(r9)
                r1.onError(r9)
                return
            L53:
                long r9 = r8.get()
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 != 0) goto L7
                long r9 = -r4
                long r9 = r8.addAndGet(r9)
                int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                if (r4 != 0) goto L6
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromIterable.IteratorConditionalSubscription.b(long):void");
        }
    }

    public static final class IteratorSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;
        public final bu.d<? super T> downstream;

        public IteratorSubscription(bu.d<? super T> dVar, Iterator<? extends T> it2) {
            super(it2);
            this.downstream = dVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        public void a() {
            Iterator<? extends T> it2 = this.f33255it;
            bu.d<? super T> dVar = this.downstream;
            while (!this.cancelled) {
                try {
                    T next = it2.next();
                    if (this.cancelled) {
                        return;
                    }
                    if (next == null) {
                        dVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    dVar.onNext(next);
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        if (!it2.hasNext()) {
                            if (this.cancelled) {
                                return;
                            }
                            dVar.onComplete();
                            return;
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        dVar.onError(th2);
                        return;
                    }
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    dVar.onError(th3);
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0058, code lost:
        
            r9 = addAndGet(-r4);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void b(long r9) {
            /*
                r8 = this;
                java.util.Iterator<? extends T> r0 = r8.f33255it
                bu.d<? super T> r1 = r8.downstream
                r2 = 0
            L6:
                r4 = r2
            L7:
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 == 0) goto L50
                boolean r6 = r8.cancelled
                if (r6 == 0) goto L10
                return
            L10:
                java.lang.Object r6 = r0.next()     // Catch: java.lang.Throwable -> L48
                boolean r7 = r8.cancelled
                if (r7 == 0) goto L19
                return
            L19:
                if (r6 != 0) goto L26
                java.lang.NullPointerException r9 = new java.lang.NullPointerException
                java.lang.String r10 = "Iterator.next() returned a null value"
                r9.<init>(r10)
                r1.onError(r9)
                return
            L26:
                r1.onNext(r6)
                boolean r6 = r8.cancelled
                if (r6 == 0) goto L2e
                return
            L2e:
                boolean r6 = r0.hasNext()     // Catch: java.lang.Throwable -> L40
                if (r6 != 0) goto L3c
                boolean r9 = r8.cancelled
                if (r9 != 0) goto L3b
                r1.onComplete()
            L3b:
                return
            L3c:
                r6 = 1
                long r4 = r4 + r6
                goto L7
            L40:
                r9 = move-exception
                io.reactivex.exceptions.a.b(r9)
                r1.onError(r9)
                return
            L48:
                r9 = move-exception
                io.reactivex.exceptions.a.b(r9)
                r1.onError(r9)
                return
            L50:
                long r9 = r8.get()
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 != 0) goto L7
                long r9 = -r4
                long r9 = r8.addAndGet(r9)
                int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                if (r4 != 0) goto L6
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromIterable.IteratorSubscription.b(long):void");
        }
    }

    public FlowableFromIterable(Iterable<? extends T> iterable) {
        this.f33254b = iterable;
    }

    public static <T> void M8(bu.d<? super T> dVar, Iterator<? extends T> it2) {
        try {
            if (!it2.hasNext()) {
                EmptySubscription.complete(dVar);
            } else if (dVar instanceof fj.a) {
                dVar.onSubscribe(new IteratorConditionalSubscription((fj.a) dVar, it2));
            } else {
                dVar.onSubscribe(new IteratorSubscription(dVar, it2));
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptySubscription.error(th2, dVar);
        }
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        try {
            M8(dVar, this.f33254b.iterator());
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptySubscription.error(th2, dVar);
        }
    }
}
