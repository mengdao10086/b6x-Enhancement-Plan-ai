package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableInterval extends xi.z<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.h0 f34224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f34226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TimeUnit f34227d;

    public static final class IntervalObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 346773832286157679L;
        public long count;
        public final xi.g0<? super Long> downstream;

        public IntervalObserver(xi.g0<? super Long> g0Var) {
            this.downstream = g0Var;
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
            if (get() != DisposableHelper.DISPOSED) {
                xi.g0<? super Long> g0Var = this.downstream;
                long j10 = this.count;
                this.count = 1 + j10;
                g0Var.onNext(Long.valueOf(j10));
            }
        }
    }

    public ObservableInterval(long j10, long j11, TimeUnit timeUnit, xi.h0 h0Var) {
        this.f34225b = j10;
        this.f34226c = j11;
        this.f34227d = timeUnit;
        this.f34224a = h0Var;
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
        IntervalObserver intervalObserver = new IntervalObserver(g0Var);
        g0Var.onSubscribe(intervalObserver);
        xi.h0 h0Var = this.f34224a;
        if (!(h0Var instanceof io.reactivex.internal.schedulers.l)) {
            intervalObserver.a(h0Var.h(intervalObserver, this.f34225b, this.f34226c, this.f34227d));
            return;
        }
        h0.c cVarD = h0Var.d();
        intervalObserver.a(cVarD);
        cVarD.d(intervalObserver, this.f34225b, this.f34226c, this.f34227d);
    }
}
