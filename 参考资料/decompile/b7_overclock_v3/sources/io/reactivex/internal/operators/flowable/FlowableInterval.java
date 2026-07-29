package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableInterval extends xi.j<Long> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.h0 f33301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f33303d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TimeUnit f33304e;

    public static final class IntervalSubscriber extends AtomicLong implements bu.e, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        public long count;
        public final bu.d<? super Long> downstream;
        public final AtomicReference<io.reactivex.disposables.b> resource = new AtomicReference<>();

        public IntervalSubscriber(bu.d<? super Long> dVar) {
            this.downstream = dVar;
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
            if (this.resource.get() != DisposableHelper.DISPOSED) {
                if (get() != 0) {
                    bu.d<? super Long> dVar = this.downstream;
                    long j10 = this.count;
                    this.count = j10 + 1;
                    dVar.onNext(Long.valueOf(j10));
                    io.reactivex.internal.util.b.e(this, 1L);
                    return;
                }
                this.downstream.onError(new MissingBackpressureException("Can't deliver value " + this.count + " due to lack of requests"));
                DisposableHelper.dispose(this.resource);
            }
        }
    }

    public FlowableInterval(long j10, long j11, TimeUnit timeUnit, xi.h0 h0Var) {
        this.f33302c = j10;
        this.f33303d = j11;
        this.f33304e = timeUnit;
        this.f33301b = h0Var;
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
        IntervalSubscriber intervalSubscriber = new IntervalSubscriber(dVar);
        dVar.onSubscribe(intervalSubscriber);
        xi.h0 h0Var = this.f33301b;
        if (!(h0Var instanceof io.reactivex.internal.schedulers.l)) {
            intervalSubscriber.a(h0Var.h(intervalSubscriber, this.f33302c, this.f33303d, this.f33304e));
            return;
        }
        h0.c cVarD = h0Var.d();
        intervalSubscriber.a(cVarD);
        cVarD.d(intervalSubscriber, this.f33302c, this.f33303d, this.f33304e);
    }
}
