package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.UnicastProcessor;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class k1<T> extends io.reactivex.internal.operators.flowable.a<T, xi.j<T>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f33658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TimeUnit f33659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final xi.h0 f33660f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f33661g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f33662h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f33663i;

    public static final class a<T> extends hj.h<T, Object, xi.j<T>> implements bu.e {
        public final long R7;
        public final TimeUnit S7;
        public final xi.h0 T7;
        public final int U7;
        public final boolean V7;
        public final long W7;
        public final h0.c X7;
        public long Y7;
        public long Z7;

        /* JADX INFO: renamed from: a8, reason: collision with root package name */
        public bu.e f33664a8;

        /* JADX INFO: renamed from: b8, reason: collision with root package name */
        public UnicastProcessor<T> f33665b8;

        /* JADX INFO: renamed from: c8, reason: collision with root package name */
        public volatile boolean f33666c8;

        /* JADX INFO: renamed from: d8, reason: collision with root package name */
        public final SequentialDisposable f33667d8;

        /* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.k1$a$a, reason: collision with other inner class name */
        public static final class RunnableC0385a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f33668a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final a<?> f33669b;

            public RunnableC0385a(long j10, a<?> aVar) {
                this.f33668a = j10;
                this.f33669b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a<?> aVar = this.f33669b;
                if (aVar.O7) {
                    aVar.f33666c8 = true;
                } else {
                    aVar.N7.offer(this);
                }
                if (aVar.a()) {
                    aVar.q();
                }
            }
        }

        public a(bu.d<? super xi.j<T>> dVar, long j10, TimeUnit timeUnit, xi.h0 h0Var, int i10, long j11, boolean z10) {
            super(dVar, new MpscLinkedQueue());
            this.f33667d8 = new SequentialDisposable();
            this.R7 = j10;
            this.S7 = timeUnit;
            this.T7 = h0Var;
            this.U7 = i10;
            this.W7 = j11;
            this.V7 = z10;
            if (z10) {
                this.X7 = h0Var.d();
            } else {
                this.X7 = null;
            }
        }

        @Override // bu.e
        public void cancel() {
            this.O7 = true;
        }

        @Override // bu.d
        public void onComplete() {
            this.P7 = true;
            if (a()) {
                q();
            }
            this.M7.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.Q7 = th2;
            this.P7 = true;
            if (a()) {
                q();
            }
            this.M7.onError(th2);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // bu.d
        public void onNext(T t10) {
            if (this.f33666c8) {
                return;
            }
            if (i()) {
                UnicastProcessor<T> unicastProcessor = this.f33665b8;
                unicastProcessor.onNext(t10);
                long j10 = this.Y7 + 1;
                if (j10 >= this.W7) {
                    this.Z7++;
                    this.Y7 = 0L;
                    unicastProcessor.onComplete();
                    long jD = d();
                    if (jD == 0) {
                        this.f33665b8 = null;
                        this.f33664a8.cancel();
                        this.M7.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                        p();
                        return;
                    }
                    UnicastProcessor<T> unicastProcessorT8 = UnicastProcessor.T8(this.U7);
                    this.f33665b8 = unicastProcessorT8;
                    this.M7.onNext(unicastProcessorT8);
                    if (jD != Long.MAX_VALUE) {
                        g(1L);
                    }
                    if (this.V7) {
                        this.f33667d8.get().dispose();
                        h0.c cVar = this.X7;
                        RunnableC0385a runnableC0385a = new RunnableC0385a(this.Z7, this);
                        long j11 = this.R7;
                        this.f33667d8.a(cVar.d(runnableC0385a, j11, j11, this.S7));
                    }
                } else {
                    this.Y7 = j10;
                }
                if (f(-1) == 0) {
                    return;
                }
            } else {
                this.N7.offer((U) NotificationLite.next(t10));
                if (!a()) {
                    return;
                }
            }
            q();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            io.reactivex.disposables.b bVarH;
            if (SubscriptionHelper.validate(this.f33664a8, eVar)) {
                this.f33664a8 = eVar;
                bu.d<? super V> dVar = this.M7;
                dVar.onSubscribe(this);
                if (this.O7) {
                    return;
                }
                UnicastProcessor<T> unicastProcessorT8 = UnicastProcessor.T8(this.U7);
                this.f33665b8 = unicastProcessorT8;
                long jD = d();
                if (jD == 0) {
                    this.O7 = true;
                    eVar.cancel();
                    dVar.onError(new MissingBackpressureException("Could not deliver initial window due to lack of requests."));
                    return;
                }
                dVar.onNext(unicastProcessorT8);
                if (jD != Long.MAX_VALUE) {
                    g(1L);
                }
                RunnableC0385a runnableC0385a = new RunnableC0385a(this.Z7, this);
                if (this.V7) {
                    h0.c cVar = this.X7;
                    long j10 = this.R7;
                    bVarH = cVar.d(runnableC0385a, j10, j10, this.S7);
                } else {
                    xi.h0 h0Var = this.T7;
                    long j11 = this.R7;
                    bVarH = h0Var.h(runnableC0385a, j11, j11, this.S7);
                }
                if (this.f33667d8.a(bVarH)) {
                    eVar.request(Long.MAX_VALUE);
                }
            }
        }

        public void p() {
            this.f33667d8.dispose();
            h0.c cVar = this.X7;
            if (cVar != null) {
                cVar.dispose();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0066  */
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
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void q() {
            /*
                Method dump skipped, instruction units count: 289
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.k1.a.q():void");
        }

        @Override // bu.e
        public void request(long j10) {
            l(j10);
        }
    }

    public static final class b<T> extends hj.h<T, Object, xi.j<T>> implements xi.o<T>, bu.e, Runnable {
        public static final Object Z7 = new Object();
        public final long R7;
        public final TimeUnit S7;
        public final xi.h0 T7;
        public final int U7;
        public bu.e V7;
        public UnicastProcessor<T> W7;
        public final SequentialDisposable X7;
        public volatile boolean Y7;

        public b(bu.d<? super xi.j<T>> dVar, long j10, TimeUnit timeUnit, xi.h0 h0Var, int i10) {
            super(dVar, new MpscLinkedQueue());
            this.X7 = new SequentialDisposable();
            this.R7 = j10;
            this.S7 = timeUnit;
            this.T7 = h0Var;
            this.U7 = i10;
        }

        @Override // bu.e
        public void cancel() {
            this.O7 = true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
        
            r10.X7.dispose();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
        
            r10.W7 = null;
            r0.clear();
            r0 = r10.Q7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
        
            if (r0 == null) goto L11;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [io.reactivex.processors.UnicastProcessor<T>] */
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
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void n() {
            /*
                r10 = this;
                fj.n<U> r0 = r10.N7
                bu.d<? super V> r1 = r10.M7
                io.reactivex.processors.UnicastProcessor<T> r2 = r10.W7
                r3 = 1
            L7:
                boolean r4 = r10.Y7
                boolean r5 = r10.P7
                java.lang.Object r6 = r0.poll()
                r7 = 0
                if (r5 == 0) goto L2e
                if (r6 == 0) goto L18
                java.lang.Object r5 = io.reactivex.internal.operators.flowable.k1.b.Z7
                if (r6 != r5) goto L2e
            L18:
                r10.W7 = r7
                r0.clear()
                java.lang.Throwable r0 = r10.Q7
                if (r0 == 0) goto L25
                r2.onError(r0)
                goto L28
            L25:
                r2.onComplete()
            L28:
                io.reactivex.internal.disposables.SequentialDisposable r0 = r10.X7
                r0.dispose()
                return
            L2e:
                if (r6 != 0) goto L38
                int r3 = -r3
                int r3 = r10.f(r3)
                if (r3 != 0) goto L7
                return
            L38:
                java.lang.Object r5 = io.reactivex.internal.operators.flowable.k1.b.Z7
                if (r6 != r5) goto L87
                r2.onComplete()
                if (r4 != 0) goto L81
                int r2 = r10.U7
                io.reactivex.processors.UnicastProcessor r2 = io.reactivex.processors.UnicastProcessor.T8(r2)
                r10.W7 = r2
                long r4 = r10.d()
                r8 = 0
                int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r6 == 0) goto L65
                r1.onNext(r2)
                r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r8 == 0) goto L7
                r4 = 1
                r10.g(r4)
                goto L7
            L65:
                r10.W7 = r7
                fj.n<U> r0 = r10.N7
                r0.clear()
                bu.e r0 = r10.V7
                r0.cancel()
                io.reactivex.exceptions.MissingBackpressureException r0 = new io.reactivex.exceptions.MissingBackpressureException
                java.lang.String r2 = "Could not deliver first window due to lack of requests."
                r0.<init>(r2)
                r1.onError(r0)
                io.reactivex.internal.disposables.SequentialDisposable r0 = r10.X7
                r0.dispose()
                return
            L81:
                bu.e r4 = r10.V7
                r4.cancel()
                goto L7
            L87:
                java.lang.Object r4 = io.reactivex.internal.util.NotificationLite.getValue(r6)
                r2.onNext(r4)
                goto L7
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.k1.b.n():void");
        }

        @Override // bu.d
        public void onComplete() {
            this.P7 = true;
            if (a()) {
                n();
            }
            this.M7.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.Q7 = th2;
            this.P7 = true;
            if (a()) {
                n();
            }
            this.M7.onError(th2);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // bu.d
        public void onNext(T t10) {
            if (this.Y7) {
                return;
            }
            if (i()) {
                this.W7.onNext(t10);
                if (f(-1) == 0) {
                    return;
                }
            } else {
                this.N7.offer((U) NotificationLite.next(t10));
                if (!a()) {
                    return;
                }
            }
            n();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.V7, eVar)) {
                this.V7 = eVar;
                this.W7 = UnicastProcessor.T8(this.U7);
                bu.d<? super V> dVar = this.M7;
                dVar.onSubscribe(this);
                long jD = d();
                if (jD == 0) {
                    this.O7 = true;
                    eVar.cancel();
                    dVar.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                    return;
                }
                dVar.onNext(this.W7);
                if (jD != Long.MAX_VALUE) {
                    g(1L);
                }
                if (this.O7) {
                    return;
                }
                SequentialDisposable sequentialDisposable = this.X7;
                xi.h0 h0Var = this.T7;
                long j10 = this.R7;
                if (sequentialDisposable.a(h0Var.h(this, j10, j10, this.S7))) {
                    eVar.request(Long.MAX_VALUE);
                }
            }
        }

        @Override // bu.e
        public void request(long j10) {
            l(j10);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.lang.Runnable
        public void run() {
            if (this.O7) {
                this.Y7 = true;
            }
            this.N7.offer((U) Z7);
            if (a()) {
                n();
            }
        }
    }

    public static final class c<T> extends hj.h<T, Object, xi.j<T>> implements bu.e, Runnable {
        public final long R7;
        public final long S7;
        public final TimeUnit T7;
        public final h0.c U7;
        public final int V7;
        public final List<UnicastProcessor<T>> W7;
        public bu.e X7;
        public volatile boolean Y7;

        public final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final UnicastProcessor<T> f33670a;

            public a(UnicastProcessor<T> unicastProcessor) {
                this.f33670a = unicastProcessor;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.n(this.f33670a);
            }
        }

        public static final class b<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final UnicastProcessor<T> f33672a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f33673b;

            public b(UnicastProcessor<T> unicastProcessor, boolean z10) {
                this.f33672a = unicastProcessor;
                this.f33673b = z10;
            }
        }

        public c(bu.d<? super xi.j<T>> dVar, long j10, long j11, TimeUnit timeUnit, h0.c cVar, int i10) {
            super(dVar, new MpscLinkedQueue());
            this.R7 = j10;
            this.S7 = j11;
            this.T7 = timeUnit;
            this.U7 = cVar;
            this.V7 = i10;
            this.W7 = new LinkedList();
        }

        @Override // bu.e
        public void cancel() {
            this.O7 = true;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public void n(UnicastProcessor<T> unicastProcessor) {
            this.N7.offer((U) new b(unicastProcessor, false));
            if (a()) {
                o();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public void o() {
            fj.o oVar = this.N7;
            bu.d<? super V> dVar = this.M7;
            List<UnicastProcessor<T>> list = this.W7;
            int iF = 1;
            while (!this.Y7) {
                boolean z10 = this.P7;
                Object objPoll = oVar.poll();
                boolean z11 = objPoll == null;
                boolean z12 = objPoll instanceof b;
                if (z10 && (z11 || z12)) {
                    oVar.clear();
                    Throwable th2 = this.Q7;
                    if (th2 != null) {
                        Iterator<UnicastProcessor<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onError(th2);
                        }
                    } else {
                        Iterator<UnicastProcessor<T>> it3 = list.iterator();
                        while (it3.hasNext()) {
                            it3.next().onComplete();
                        }
                    }
                    list.clear();
                    this.U7.dispose();
                    return;
                }
                if (z11) {
                    iF = f(-iF);
                    if (iF == 0) {
                        return;
                    }
                } else if (z12) {
                    b bVar = (b) objPoll;
                    if (!bVar.f33673b) {
                        list.remove(bVar.f33672a);
                        bVar.f33672a.onComplete();
                        if (list.isEmpty() && this.O7) {
                            this.Y7 = true;
                        }
                    } else if (!this.O7) {
                        long jD = d();
                        if (jD != 0) {
                            UnicastProcessor<T> unicastProcessorT8 = UnicastProcessor.T8(this.V7);
                            list.add(unicastProcessorT8);
                            dVar.onNext(unicastProcessorT8);
                            if (jD != Long.MAX_VALUE) {
                                g(1L);
                            }
                            this.U7.c(new a(unicastProcessorT8), this.R7, this.T7);
                        } else {
                            dVar.onError(new MissingBackpressureException("Can't emit window due to lack of requests"));
                        }
                    }
                } else {
                    Iterator<UnicastProcessor<T>> it4 = list.iterator();
                    while (it4.hasNext()) {
                        it4.next().onNext(objPoll);
                    }
                }
            }
            this.X7.cancel();
            oVar.clear();
            list.clear();
            this.U7.dispose();
        }

        @Override // bu.d
        public void onComplete() {
            this.P7 = true;
            if (a()) {
                o();
            }
            this.M7.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.Q7 = th2;
            this.P7 = true;
            if (a()) {
                o();
            }
            this.M7.onError(th2);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // bu.d
        public void onNext(T t10) {
            if (i()) {
                Iterator<UnicastProcessor<T>> it2 = this.W7.iterator();
                while (it2.hasNext()) {
                    it2.next().onNext(t10);
                }
                if (f(-1) == 0) {
                    return;
                }
            } else {
                this.N7.offer((U) t10);
                if (!a()) {
                    return;
                }
            }
            o();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.X7, eVar)) {
                this.X7 = eVar;
                this.M7.onSubscribe(this);
                if (this.O7) {
                    return;
                }
                long jD = d();
                if (jD == 0) {
                    eVar.cancel();
                    this.M7.onError(new MissingBackpressureException("Could not emit the first window due to lack of requests"));
                    return;
                }
                UnicastProcessor<T> unicastProcessorT8 = UnicastProcessor.T8(this.V7);
                this.W7.add(unicastProcessorT8);
                this.M7.onNext(unicastProcessorT8);
                if (jD != Long.MAX_VALUE) {
                    g(1L);
                }
                this.U7.c(new a(unicastProcessorT8), this.R7, this.T7);
                h0.c cVar = this.U7;
                long j10 = this.S7;
                cVar.d(this, j10, j10, this.T7);
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            l(j10);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.lang.Runnable
        public void run() {
            Object bVar = new b(UnicastProcessor.T8(this.V7), true);
            if (!this.O7) {
                this.N7.offer((U) bVar);
            }
            if (a()) {
                o();
            }
        }
    }

    public k1(xi.j<T> jVar, long j10, long j11, TimeUnit timeUnit, xi.h0 h0Var, long j12, int i10, boolean z10) {
        super(jVar);
        this.f33657c = j10;
        this.f33658d = j11;
        this.f33659e = timeUnit;
        this.f33660f = h0Var;
        this.f33661g = j12;
        this.f33662h = i10;
        this.f33663i = z10;
    }

    @Override // xi.j
    public void k6(bu.d<? super xi.j<T>> dVar) {
        io.reactivex.subscribers.e eVar = new io.reactivex.subscribers.e(dVar);
        long j10 = this.f33657c;
        long j11 = this.f33658d;
        if (j10 != j11) {
            this.f33524b.j6(new c(eVar, j10, j11, this.f33659e, this.f33660f.d(), this.f33662h));
            return;
        }
        long j12 = this.f33661g;
        if (j12 == Long.MAX_VALUE) {
            this.f33524b.j6(new b(eVar, this.f33657c, this.f33659e, this.f33660f, this.f33662h));
        } else {
            this.f33524b.j6(new a(eVar, j10, this.f33659e, this.f33660f, this.f33662h, j12, this.f33663i));
        }
    }
}
