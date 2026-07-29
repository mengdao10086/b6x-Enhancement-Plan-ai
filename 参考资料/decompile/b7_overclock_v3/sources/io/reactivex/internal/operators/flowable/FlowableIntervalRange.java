package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableIntervalRange extends xi.j<Long> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.h0 f33305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f33307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f33308e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f33309f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TimeUnit f33310g;

    public static final class IntervalRangeSubscriber extends AtomicLong implements bu.e, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        public long count;
        public final bu.d<? super Long> downstream;
        public final long end;
        public final AtomicReference<io.reactivex.disposables.b> resource = new AtomicReference<>();

        public IntervalRangeSubscriber(bu.d<? super Long> dVar, long j10, long j11) {
            this.downstream = dVar;
            this.count = j10;
            this.end = j11;
        }

        public void a(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.resource, bVar);
        }

        @Override // bu.e
        public void cancel() {
            DisposableHelper.dispose(this.resource);
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this, j10);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            io.reactivex.disposables.b bVar = this.resource.get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar != disposableHelper) {
                long j10 = get();
                if (j10 == 0) {
                    this.downstream.onError(new MissingBackpressureException("Can't deliver value " + this.count + " due to lack of requests"));
                    DisposableHelper.dispose(this.resource);
                    return;
                }
                long j11 = this.count;
                this.downstream.onNext(Long.valueOf(j11));
                if (j11 == this.end) {
                    if (this.resource.get() != disposableHelper) {
                        this.downstream.onComplete();
                    }
                    DisposableHelper.dispose(this.resource);
                } else {
                    this.count = j11 + 1;
                    if (j10 != Long.MAX_VALUE) {
                        decrementAndGet();
                    }
                }
            }
        }
    }

    public FlowableIntervalRange(long j10, long j11, long j12, long j13, TimeUnit timeUnit, xi.h0 h0Var) {
        this.f33308e = j12;
        this.f33309f = j13;
        this.f33310g = timeUnit;
        this.f33305b = h0Var;
        this.f33306c = j10;
        this.f33307d = j11;
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
    @Override // xi.j
    public void k6(bu.d<? super Long> dVar) {
        IntervalRangeSubscriber intervalRangeSubscriber = new IntervalRangeSubscriber(dVar, this.f33306c, this.f33307d);
        dVar.onSubscribe(intervalRangeSubscriber);
        xi.h0 h0Var = this.f33305b;
        if (!(h0Var instanceof io.reactivex.internal.schedulers.l)) {
            intervalRangeSubscriber.a(h0Var.h(intervalRangeSubscriber, this.f33308e, this.f33309f, this.f33310g));
            return;
        }
        h0.c cVarD = h0Var.d();
        intervalRangeSubscriber.a(cVarD);
        cVarD.d(intervalRangeSubscriber, this.f33308e, this.f33309f, this.f33310g);
    }
}
