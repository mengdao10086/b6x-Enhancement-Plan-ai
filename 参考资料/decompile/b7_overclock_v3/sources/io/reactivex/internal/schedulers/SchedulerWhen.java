package io.reactivex.internal.schedulers;

import dj.o;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public class SchedulerWhen extends h0 implements io.reactivex.disposables.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final io.reactivex.disposables.b f35134f = new d();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final io.reactivex.disposables.b f35135g = io.reactivex.disposables.c.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h0 f35136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final io.reactivex.processors.a<xi.j<xi.a>> f35137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public io.reactivex.disposables.b f35138e;

    public static class DelayedAction extends ScheduledAction {
        private final Runnable action;
        private final long delayTime;
        private final TimeUnit unit;

        public DelayedAction(Runnable runnable, long j10, TimeUnit timeUnit) {
            this.action = runnable;
            this.delayTime = j10;
            this.unit = timeUnit;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        public io.reactivex.disposables.b b(h0.c cVar, xi.d dVar) {
            return cVar.c(new b(this.action, dVar), this.delayTime, this.unit);
        }
    }

    public static class ImmediateAction extends ScheduledAction {
        private final Runnable action;

        public ImmediateAction(Runnable runnable) {
            this.action = runnable;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerWhen.ScheduledAction
        public io.reactivex.disposables.b b(h0.c cVar, xi.d dVar) {
            return cVar.b(new b(this.action, dVar));
        }
    }

    public static abstract class ScheduledAction extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b {
        public ScheduledAction() {
            super(SchedulerWhen.f35134f);
        }

        public void a(h0.c cVar, xi.d dVar) {
            io.reactivex.disposables.b bVar;
            io.reactivex.disposables.b bVar2 = get();
            if (bVar2 != SchedulerWhen.f35135g && bVar2 == (bVar = SchedulerWhen.f35134f)) {
                io.reactivex.disposables.b bVarB = b(cVar, dVar);
                if (compareAndSet(bVar, bVarB)) {
                    return;
                }
                bVarB.dispose();
            }
        }

        public abstract io.reactivex.disposables.b b(h0.c cVar, xi.d dVar);

        @Override // io.reactivex.disposables.b
        public void dispose() {
            io.reactivex.disposables.b bVar;
            io.reactivex.disposables.b bVar2 = SchedulerWhen.f35135g;
            do {
                bVar = get();
                if (bVar == SchedulerWhen.f35135g) {
                    return;
                }
            } while (!compareAndSet(bVar, bVar2));
            if (bVar != SchedulerWhen.f35134f) {
                bVar.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get().isDisposed();
        }
    }

    public static final class a implements o<ScheduledAction, xi.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h0.c f35139a;

        /* JADX INFO: renamed from: io.reactivex.internal.schedulers.SchedulerWhen$a$a, reason: collision with other inner class name */
        public final class C0397a extends xi.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ScheduledAction f35140a;

            public C0397a(ScheduledAction scheduledAction) {
                this.f35140a = scheduledAction;
            }

            @Override // xi.a
            public void I0(xi.d dVar) {
                dVar.onSubscribe(this.f35140a);
                this.f35140a.a(a.this.f35139a, dVar);
            }
        }

        public a(h0.c cVar) {
            this.f35139a = cVar;
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public xi.a apply(ScheduledAction scheduledAction) {
            return new C0397a(scheduledAction);
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.d f35142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Runnable f35143b;

        public b(Runnable runnable, xi.d dVar) {
            this.f35143b = runnable;
            this.f35142a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f35143b.run();
            } finally {
                this.f35142a.onComplete();
            }
        }
    }

    public static final class c extends h0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f35144a = new AtomicBoolean();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final io.reactivex.processors.a<ScheduledAction> f35145b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h0.c f35146c;

        public c(io.reactivex.processors.a<ScheduledAction> aVar, h0.c cVar) {
            this.f35145b = aVar;
            this.f35146c = cVar;
        }

        @Override // xi.h0.c
        @bj.e
        public io.reactivex.disposables.b b(@bj.e Runnable runnable) {
            ImmediateAction immediateAction = new ImmediateAction(runnable);
            this.f35145b.onNext(immediateAction);
            return immediateAction;
        }

        @Override // xi.h0.c
        @bj.e
        public io.reactivex.disposables.b c(@bj.e Runnable runnable, long j10, @bj.e TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(runnable, j10, timeUnit);
            this.f35145b.onNext(delayedAction);
            return delayedAction;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f35144a.compareAndSet(false, true)) {
                this.f35145b.onComplete();
                this.f35146c.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f35144a.get();
        }
    }

    public static final class d implements io.reactivex.disposables.b {
        @Override // io.reactivex.disposables.b
        public void dispose() {
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SchedulerWhen(o<xi.j<xi.j<xi.a>>, xi.a> oVar, h0 h0Var) {
        this.f35136c = h0Var;
        io.reactivex.processors.a aVarQ8 = UnicastProcessor.S8().Q8();
        this.f35137d = aVarQ8;
        try {
            this.f35138e = ((xi.a) oVar.apply(aVarQ8)).F0();
        } catch (Throwable th2) {
            throw ExceptionHelper.f(th2);
        }
    }

    @Override // xi.h0
    @bj.e
    public h0.c d() {
        h0.c cVarD = this.f35136c.d();
        io.reactivex.processors.a<T> aVarQ8 = UnicastProcessor.S8().Q8();
        xi.j<xi.a> jVarK3 = aVarQ8.K3(new a(cVarD));
        c cVar = new c(aVarQ8, cVarD);
        this.f35137d.onNext(jVarK3);
        return cVar;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.f35138e.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f35138e.isDisposed();
    }
}
