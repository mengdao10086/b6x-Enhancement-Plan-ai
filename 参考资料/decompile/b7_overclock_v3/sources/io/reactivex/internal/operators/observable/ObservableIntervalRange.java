package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableIntervalRange extends xi.z<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.h0 f34228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f34230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f34231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f34232e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TimeUnit f34233f;

    public static final class IntervalRangeObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 1891866368734007884L;
        public long count;
        public final xi.g0<? super Long> downstream;
        public final long end;

        public IntervalRangeObserver(xi.g0<? super Long> g0Var, long j10, long j11) {
            this.downstream = g0Var;
            this.count = j10;
            this.end = j11;
        }

        public void a(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (isDisposed()) {
                return;
            }
            long j10 = this.count;
            this.downstream.onNext(Long.valueOf(j10));
            if (j10 != this.end) {
                this.count = j10 + 1;
            } else {
                DisposableHelper.dispose(this);
                this.downstream.onComplete();
            }
        }
    }

    public ObservableIntervalRange(long j10, long j11, long j12, long j13, TimeUnit timeUnit, xi.h0 h0Var) {
        this.f34231d = j12;
        this.f34232e = j13;
        this.f34233f = timeUnit;
        this.f34228a = h0Var;
        this.f34229b = j10;
        this.f34230c = j11;
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
    @Override // xi.z
    public void I5(xi.g0<? super Long> g0Var) {
        IntervalRangeObserver intervalRangeObserver = new IntervalRangeObserver(g0Var, this.f34229b, this.f34230c);
        g0Var.onSubscribe(intervalRangeObserver);
        xi.h0 h0Var = this.f34228a;
        if (!(h0Var instanceof io.reactivex.internal.schedulers.l)) {
            intervalRangeObserver.a(h0Var.h(intervalRangeObserver, this.f34231d, this.f34232e, this.f34233f));
            return;
        }
        h0.c cVarD = h0Var.d();
        intervalRangeObserver.a(cVarD);
        cVarD.d(intervalRangeObserver, this.f34231d, this.f34232e, this.f34233f);
    }
}
