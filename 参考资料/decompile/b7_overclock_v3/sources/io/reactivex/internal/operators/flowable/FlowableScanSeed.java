package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableScanSeed<T, R> extends a<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.c<R, ? super T, R> f33429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Callable<R> f33430d;

    public static final class ScanSeedSubscriber<T, R> extends AtomicInteger implements xi.o<T>, bu.e {
        private static final long serialVersionUID = -1776795561228106469L;
        public final dj.c<R, ? super T, R> accumulator;
        public volatile boolean cancelled;
        public int consumed;
        public volatile boolean done;
        public final bu.d<? super R> downstream;
        public Throwable error;
        public final int limit;
        public final int prefetch;
        public final fj.n<R> queue;
        public final AtomicLong requested;
        public bu.e upstream;
        public R value;

        public ScanSeedSubscriber(bu.d<? super R> dVar, dj.c<R, ? super T, R> cVar, R r10, int i10) {
            this.downstream = dVar;
            this.accumulator = cVar;
            this.value = r10;
            this.prefetch = i10;
            this.limit = i10 - (i10 >> 2);
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(i10);
            this.queue = spscArrayQueue;
            spscArrayQueue.offer(r10);
            this.requested = new AtomicLong();
        }

        public void a() {
            Throwable th2;
            if (getAndIncrement() != 0) {
                return;
            }
            bu.d<? super R> dVar = this.downstream;
            fj.n<R> nVar = this.queue;
            int i10 = this.limit;
            int i11 = this.consumed;
            int iAddAndGet = 1;
            do {
                long j10 = this.requested.get();
                long j11 = 0;
                while (j11 != j10) {
                    if (this.cancelled) {
                        nVar.clear();
                        return;
                    }
                    boolean z10 = this.done;
                    if (z10 && (th2 = this.error) != null) {
                        nVar.clear();
                        dVar.onError(th2);
                        return;
                    }
                    R rPoll = nVar.poll();
                    boolean z11 = rPoll == null;
                    if (z10 && z11) {
                        dVar.onComplete();
                        return;
                    }
                    if (z11) {
                        break;
                    }
                    dVar.onNext(rPoll);
                    j11++;
                    i11++;
                    if (i11 == i10) {
                        this.upstream.request(i10);
                        i11 = 0;
                    }
                }
                if (j11 == j10 && this.done) {
                    Throwable th3 = this.error;
                    if (th3 != null) {
                        nVar.clear();
                        dVar.onError(th3);
                        return;
                    } else if (nVar.isEmpty()) {
                        dVar.onComplete();
                        return;
                    }
                }
                if (j11 != 0) {
                    io.reactivex.internal.util.b.e(this.requested, j11);
                }
                this.consumed = i11;
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // bu.e
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // bu.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            a();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.done) {
                kj.a.Y(th2);
                return;
            }
            this.error = th2;
            this.done = true;
            a();
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // bu.d
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            try {
                R r10 = (R) io.reactivex.internal.functions.a.g(this.accumulator.apply(this.value, t10), "The accumulator returned a null value");
                this.value = r10;
                this.queue.offer(r10);
                a();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.upstream.cancel();
                onError(th2);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
                eVar.request(this.prefetch - 1);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                a();
            }
        }
    }

    public FlowableScanSeed(xi.j<T> jVar, Callable<R> callable, dj.c<R, ? super T, R> cVar) {
        super(jVar);
        this.f33429c = cVar;
        this.f33430d = callable;
    }

    @Override // xi.j
    public void k6(bu.d<? super R> dVar) {
        try {
            this.f33524b.j6(new ScanSeedSubscriber(dVar, this.f33429c, io.reactivex.internal.functions.a.g(this.f33430d.call(), "The seed supplied is null"), xi.j.Y()));
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptySubscription.error(th2, dVar);
        }
    }
}
