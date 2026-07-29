package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableCreate<T> extends xi.j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.m<T> f33211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BackpressureStrategy f33212c;

    public static abstract class BaseEmitter<T> extends AtomicLong implements xi.l<T>, bu.e {
        private static final long serialVersionUID = 7326289992464377023L;
        public final bu.d<? super T> downstream;
        public final SequentialDisposable serial = new SequentialDisposable();

        public BaseEmitter(bu.d<? super T> dVar) {
            this.downstream = dVar;
        }

        @Override // xi.l
        public boolean a(Throwable th2) {
            return h(th2);
        }

        @Override // xi.l
        public final void b(dj.f fVar) {
            c(new CancellableDisposable(fVar));
        }

        @Override // xi.l
        public final void c(io.reactivex.disposables.b bVar) {
            this.serial.b(bVar);
        }

        @Override // bu.e
        public final void cancel() {
            this.serial.dispose();
            k();
        }

        @Override // xi.l
        public final long d() {
            return get();
        }

        public void f() {
            if (isCancelled()) {
                return;
            }
            try {
                this.downstream.onComplete();
            } finally {
                this.serial.dispose();
            }
        }

        public boolean h(Throwable th2) {
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isCancelled()) {
                return false;
            }
            try {
                this.downstream.onError(th2);
                this.serial.dispose();
                return true;
            } catch (Throwable th3) {
                this.serial.dispose();
                throw th3;
            }
        }

        public void i() {
        }

        @Override // xi.l
        public final boolean isCancelled() {
            return this.serial.isDisposed();
        }

        public void k() {
        }

        @Override // xi.i
        public void onComplete() {
            f();
        }

        @Override // xi.i
        public final void onError(Throwable th2) {
            if (a(th2)) {
                return;
            }
            kj.a.Y(th2);
        }

        @Override // bu.e
        public final void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this, j10);
                i();
            }
        }

        @Override // xi.l
        public final xi.l<T> serialize() {
            return new SerializedEmitter(this);
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public String toString() {
            return String.format("%s{%s}", getClass().getSimpleName(), super.toString());
        }
    }

    public static final class BufferAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        public volatile boolean done;
        public Throwable error;
        public final io.reactivex.internal.queue.a<T> queue;
        public final AtomicInteger wip;

        public BufferAsyncEmitter(bu.d<? super T> dVar, int i10) {
            super(dVar);
            this.queue = new io.reactivex.internal.queue.a<>(i10);
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, xi.l
        public boolean a(Throwable th2) {
            if (this.done || isCancelled()) {
                return false;
            }
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.error = th2;
            this.done = true;
            l();
            return true;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        public void i() {
            l();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        public void k() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        public void l() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            bu.d<? super T> dVar = this.downstream;
            io.reactivex.internal.queue.a<T> aVar = this.queue;
            int iAddAndGet = 1;
            do {
                long j10 = get();
                long j11 = 0;
                while (j11 != j10) {
                    if (isCancelled()) {
                        aVar.clear();
                        return;
                    }
                    boolean z10 = this.done;
                    T tPoll = aVar.poll();
                    boolean z11 = tPoll == null;
                    if (z10 && z11) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            h(th2);
                            return;
                        } else {
                            f();
                            return;
                        }
                    }
                    if (z11) {
                        break;
                    }
                    dVar.onNext(tPoll);
                    j11++;
                }
                if (j11 == j10) {
                    if (isCancelled()) {
                        aVar.clear();
                        return;
                    }
                    boolean z12 = this.done;
                    boolean zIsEmpty = aVar.isEmpty();
                    if (z12 && zIsEmpty) {
                        Throwable th3 = this.error;
                        if (th3 != null) {
                            h(th3);
                            return;
                        } else {
                            f();
                            return;
                        }
                    }
                }
                if (j11 != 0) {
                    io.reactivex.internal.util.b.e(this, j11);
                }
                iAddAndGet = this.wip.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, xi.i
        public void onComplete() {
            this.done = true;
            l();
        }

        @Override // xi.i
        public void onNext(T t10) {
            if (this.done || isCancelled()) {
                return;
            }
            if (t10 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.queue.offer(t10);
                l();
            }
        }
    }

    public static final class DropAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        public DropAsyncEmitter(bu.d<? super T> dVar) {
            super(dVar);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.NoOverflowBaseAsyncEmitter
        public void l() {
        }
    }

    public static final class ErrorAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 338953216916120960L;

        public ErrorAsyncEmitter(bu.d<? super T> dVar) {
            super(dVar);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.NoOverflowBaseAsyncEmitter
        public void l() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    public static final class LatestAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        public volatile boolean done;
        public Throwable error;
        public final AtomicReference<T> queue;
        public final AtomicInteger wip;

        public LatestAsyncEmitter(bu.d<? super T> dVar) {
            super(dVar);
            this.queue = new AtomicReference<>();
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, xi.l
        public boolean a(Throwable th2) {
            if (this.done || isCancelled()) {
                return false;
            }
            if (th2 == null) {
                onError(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
            this.error = th2;
            this.done = true;
            l();
            return true;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        public void i() {
            l();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        public void k() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet(null);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x004f, code lost:
        
            if (r9 != r5) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
        
            if (isCancelled() == false) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
        
            r2.lazySet(null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
        
            r5 = r17.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0061, code lost:
        
            if (r2.get() != null) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0063, code lost:
        
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0064, code lost:
        
            if (r5 == false) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0066, code lost:
        
            if (r11 == false) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0068, code lost:
        
            r1 = r17.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x006a, code lost:
        
            if (r1 == null) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x006c, code lost:
        
            h(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0070, code lost:
        
            f();
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0073, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0076, code lost:
        
            if (r9 == 0) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0078, code lost:
        
            io.reactivex.internal.util.b.e(r17, r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x007b, code lost:
        
            r4 = r17.wip.addAndGet(-r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void l() {
            /*
                r17 = this;
                r0 = r17
                java.util.concurrent.atomic.AtomicInteger r1 = r0.wip
                int r1 = r1.getAndIncrement()
                if (r1 == 0) goto Lb
                return
            Lb:
                bu.d<? super T> r1 = r0.downstream
                java.util.concurrent.atomic.AtomicReference<T> r2 = r0.queue
                r3 = 1
                r4 = 1
            L11:
                long r5 = r17.get()
                r7 = 0
                r9 = r7
            L18:
                r11 = 0
                r12 = 0
                int r13 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
                if (r13 == 0) goto L4f
                boolean r14 = r17.isCancelled()
                if (r14 == 0) goto L28
                r2.lazySet(r12)
                return
            L28:
                boolean r14 = r0.done
                java.lang.Object r15 = r2.getAndSet(r12)
                if (r15 != 0) goto L33
                r16 = 1
                goto L35
            L33:
                r16 = 0
            L35:
                if (r14 == 0) goto L45
                if (r16 == 0) goto L45
                java.lang.Throwable r1 = r0.error
                if (r1 == 0) goto L41
                r0.h(r1)
                goto L44
            L41:
                r17.f()
            L44:
                return
            L45:
                if (r16 == 0) goto L48
                goto L4f
            L48:
                r1.onNext(r15)
                r11 = 1
                long r9 = r9 + r11
                goto L18
            L4f:
                if (r13 != 0) goto L74
                boolean r5 = r17.isCancelled()
                if (r5 == 0) goto L5b
                r2.lazySet(r12)
                return
            L5b:
                boolean r5 = r0.done
                java.lang.Object r6 = r2.get()
                if (r6 != 0) goto L64
                r11 = 1
            L64:
                if (r5 == 0) goto L74
                if (r11 == 0) goto L74
                java.lang.Throwable r1 = r0.error
                if (r1 == 0) goto L70
                r0.h(r1)
                goto L73
            L70:
                r17.f()
            L73:
                return
            L74:
                int r5 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
                if (r5 == 0) goto L7b
                io.reactivex.internal.util.b.e(r0, r9)
            L7b:
                java.util.concurrent.atomic.AtomicInteger r5 = r0.wip
                int r4 = -r4
                int r4 = r5.addAndGet(r4)
                if (r4 != 0) goto L11
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableCreate.LatestAsyncEmitter.l():void");
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, xi.i
        public void onComplete() {
            this.done = true;
            l();
        }

        @Override // xi.i
        public void onNext(T t10) {
            if (this.done || isCancelled()) {
                return;
            }
            if (t10 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.queue.set(t10);
                l();
            }
        }
    }

    public static final class MissingEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        public MissingEmitter(bu.d<? super T> dVar) {
            super(dVar);
        }

        @Override // xi.i
        public void onNext(T t10) {
            long j10;
            if (isCancelled()) {
                return;
            }
            if (t10 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            this.downstream.onNext(t10);
            do {
                j10 = get();
                if (j10 == 0) {
                    return;
                }
            } while (!compareAndSet(j10, j10 - 1));
        }
    }

    public static abstract class NoOverflowBaseAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        public NoOverflowBaseAsyncEmitter(bu.d<? super T> dVar) {
            super(dVar);
        }

        public abstract void l();

        @Override // xi.i
        public final void onNext(T t10) {
            if (isCancelled()) {
                return;
            }
            if (t10 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (get() == 0) {
                l();
            } else {
                this.downstream.onNext(t10);
                io.reactivex.internal.util.b.e(this, 1L);
            }
        }
    }

    public static final class SerializedEmitter<T> extends AtomicInteger implements xi.l<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        public volatile boolean done;
        public final BaseEmitter<T> emitter;
        public final AtomicThrowable error = new AtomicThrowable();
        public final fj.n<T> queue = new io.reactivex.internal.queue.a(16);

        public SerializedEmitter(BaseEmitter<T> baseEmitter) {
            this.emitter = baseEmitter;
        }

        @Override // xi.l
        public boolean a(Throwable th2) {
            if (!this.emitter.isCancelled() && !this.done) {
                if (th2 == null) {
                    th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                }
                if (this.error.a(th2)) {
                    this.done = true;
                    f();
                    return true;
                }
            }
            return false;
        }

        @Override // xi.l
        public void b(dj.f fVar) {
            this.emitter.b(fVar);
        }

        @Override // xi.l
        public void c(io.reactivex.disposables.b bVar) {
            this.emitter.c(bVar);
        }

        @Override // xi.l
        public long d() {
            return this.emitter.d();
        }

        public void f() {
            if (getAndIncrement() == 0) {
                h();
            }
        }

        public void h() {
            BaseEmitter<T> baseEmitter = this.emitter;
            fj.n<T> nVar = this.queue;
            AtomicThrowable atomicThrowable = this.error;
            int iAddAndGet = 1;
            while (!baseEmitter.isCancelled()) {
                if (atomicThrowable.get() != null) {
                    nVar.clear();
                    baseEmitter.onError(atomicThrowable.c());
                    return;
                }
                boolean z10 = this.done;
                T tPoll = nVar.poll();
                boolean z11 = tPoll == null;
                if (z10 && z11) {
                    baseEmitter.onComplete();
                    return;
                } else if (z11) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    baseEmitter.onNext(tPoll);
                }
            }
            nVar.clear();
        }

        @Override // xi.l
        public boolean isCancelled() {
            return this.emitter.isCancelled();
        }

        @Override // xi.i
        public void onComplete() {
            if (this.emitter.isCancelled() || this.done) {
                return;
            }
            this.done = true;
            f();
        }

        @Override // xi.i
        public void onError(Throwable th2) {
            if (a(th2)) {
                return;
            }
            kj.a.Y(th2);
        }

        @Override // xi.i
        public void onNext(T t10) {
            if (this.emitter.isCancelled() || this.done) {
                return;
            }
            if (t10 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            if (get() == 0 && compareAndSet(0, 1)) {
                this.emitter.onNext(t10);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                fj.n<T> nVar = this.queue;
                synchronized (nVar) {
                    nVar.offer(t10);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            h();
        }

        @Override // xi.l
        public xi.l<T> serialize() {
            return this;
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public String toString() {
            return this.emitter.toString();
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f33213a;

        static {
            int[] iArr = new int[BackpressureStrategy.values().length];
            f33213a = iArr;
            try {
                iArr[BackpressureStrategy.MISSING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33213a[BackpressureStrategy.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33213a[BackpressureStrategy.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33213a[BackpressureStrategy.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public FlowableCreate(xi.m<T> mVar, BackpressureStrategy backpressureStrategy) {
        this.f33211b = mVar;
        this.f33212c = backpressureStrategy;
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
    public void k6(bu.d<? super T> dVar) {
        int i10 = a.f33213a[this.f33212c.ordinal()];
        BaseEmitter bufferAsyncEmitter = i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? new BufferAsyncEmitter(dVar, xi.j.Y()) : new LatestAsyncEmitter(dVar) : new DropAsyncEmitter(dVar) : new ErrorAsyncEmitter(dVar) : new MissingEmitter(dVar);
        dVar.onSubscribe(bufferAsyncEmitter);
        try {
            this.f33211b.a(bufferAsyncEmitter);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            bufferAsyncEmitter.onError(th2);
        }
    }
}
