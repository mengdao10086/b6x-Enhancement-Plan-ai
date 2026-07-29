package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.UnicastSubject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class y1<T> extends io.reactivex.internal.operators.observable.a<T, xi.z<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f34796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TimeUnit f34797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final xi.h0 f34798e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f34799f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f34800g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f34801h;

    public static final class a<T> extends gj.k<T, Object, xi.z<T>> implements io.reactivex.disposables.b {
        public final TimeUnit C2;
        public final int E7;
        public final boolean F7;
        public final long G7;
        public final h0.c H7;
        public long I7;
        public long J7;
        public final xi.h0 K2;
        public io.reactivex.disposables.b K7;
        public UnicastSubject<T> L7;
        public volatile boolean M7;
        public final SequentialDisposable N7;

        /* JADX INFO: renamed from: v2, reason: collision with root package name */
        public final long f34802v2;

        /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.y1$a$a, reason: collision with other inner class name */
        public static final class RunnableC0391a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f34803a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final a<?> f34804b;

            public RunnableC0391a(long j10, a<?> aVar) {
                this.f34803a = j10;
                this.f34804b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a<?> aVar = this.f34804b;
                if (aVar.f29584v1) {
                    aVar.M7 = true;
                } else {
                    aVar.f29583k1.offer(this);
                }
                if (aVar.a()) {
                    aVar.m();
                }
            }
        }

        public a(xi.g0<? super xi.z<T>> g0Var, long j10, TimeUnit timeUnit, xi.h0 h0Var, int i10, long j11, boolean z10) {
            super(g0Var, new MpscLinkedQueue());
            this.N7 = new SequentialDisposable();
            this.f34802v2 = j10;
            this.C2 = timeUnit;
            this.K2 = h0Var;
            this.E7 = i10;
            this.G7 = j11;
            this.F7 = z10;
            if (z10) {
                this.H7 = h0Var.d();
            } else {
                this.H7 = null;
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f29584v1 = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f29584v1;
        }

        public void l() {
            DisposableHelper.dispose(this.N7);
            h0.c cVar = this.H7;
            if (cVar != null) {
                cVar.dispose();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [io.reactivex.subjects.UnicastSubject<T>] */
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
        public void m() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f29583k1;
            xi.g0<? super V> g0Var = this.K0;
            UnicastSubject<T> unicastSubject = this.L7;
            int iF = 1;
            while (!this.M7) {
                boolean z10 = this.C1;
                Object objPoll = mpscLinkedQueue.poll();
                boolean z11 = objPoll == null;
                boolean z12 = objPoll instanceof RunnableC0391a;
                if (z10 && (z11 || z12)) {
                    this.L7 = null;
                    mpscLinkedQueue.clear();
                    Throwable th2 = this.K1;
                    if (th2 != null) {
                        unicastSubject.onError(th2);
                    } else {
                        unicastSubject.onComplete();
                    }
                    l();
                    return;
                }
                if (z11) {
                    iF = f(-iF);
                    if (iF == 0) {
                        return;
                    }
                } else if (z12) {
                    RunnableC0391a runnableC0391a = (RunnableC0391a) objPoll;
                    if (!this.F7 || this.J7 == runnableC0391a.f34803a) {
                        unicastSubject.onComplete();
                        this.I7 = 0L;
                        unicastSubject = (UnicastSubject<T>) UnicastSubject.o8(this.E7);
                        this.L7 = unicastSubject;
                        g0Var.onNext(unicastSubject);
                    }
                } else {
                    unicastSubject.onNext(NotificationLite.getValue(objPoll));
                    long j10 = this.I7 + 1;
                    if (j10 >= this.G7) {
                        this.J7++;
                        this.I7 = 0L;
                        unicastSubject.onComplete();
                        unicastSubject = (UnicastSubject<T>) UnicastSubject.o8(this.E7);
                        this.L7 = unicastSubject;
                        this.K0.onNext(unicastSubject);
                        if (this.F7) {
                            io.reactivex.disposables.b bVar = this.N7.get();
                            bVar.dispose();
                            h0.c cVar = this.H7;
                            RunnableC0391a runnableC0391a2 = new RunnableC0391a(this.J7, this);
                            long j11 = this.f34802v2;
                            io.reactivex.disposables.b bVarD = cVar.d(runnableC0391a2, j11, j11, this.C2);
                            if (!this.N7.compareAndSet(bVar, bVarD)) {
                                bVarD.dispose();
                            }
                        }
                    } else {
                        this.I7 = j10;
                    }
                }
            }
            this.K7.dispose();
            mpscLinkedQueue.clear();
            l();
        }

        @Override // xi.g0
        public void onComplete() {
            this.C1 = true;
            if (a()) {
                m();
            }
            this.K0.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.K1 = th2;
            this.C1 = true;
            if (a()) {
                m();
            }
            this.K0.onError(th2);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // xi.g0
        public void onNext(T t10) {
            if (this.M7) {
                return;
            }
            if (d()) {
                UnicastSubject<T> unicastSubject = this.L7;
                unicastSubject.onNext(t10);
                long j10 = this.I7 + 1;
                if (j10 >= this.G7) {
                    this.J7++;
                    this.I7 = 0L;
                    unicastSubject.onComplete();
                    UnicastSubject<T> unicastSubjectO8 = UnicastSubject.o8(this.E7);
                    this.L7 = unicastSubjectO8;
                    this.K0.onNext(unicastSubjectO8);
                    if (this.F7) {
                        this.N7.get().dispose();
                        h0.c cVar = this.H7;
                        RunnableC0391a runnableC0391a = new RunnableC0391a(this.J7, this);
                        long j11 = this.f34802v2;
                        DisposableHelper.replace(this.N7, cVar.d(runnableC0391a, j11, j11, this.C2));
                    }
                } else {
                    this.I7 = j10;
                }
                if (f(-1) == 0) {
                    return;
                }
            } else {
                this.f29583k1.offer((U) NotificationLite.next(t10));
                if (!a()) {
                    return;
                }
            }
            m();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            io.reactivex.disposables.b bVarH;
            if (DisposableHelper.validate(this.K7, bVar)) {
                this.K7 = bVar;
                xi.g0<? super V> g0Var = this.K0;
                g0Var.onSubscribe(this);
                if (this.f29584v1) {
                    return;
                }
                UnicastSubject<T> unicastSubjectO8 = UnicastSubject.o8(this.E7);
                this.L7 = unicastSubjectO8;
                g0Var.onNext(unicastSubjectO8);
                RunnableC0391a runnableC0391a = new RunnableC0391a(this.J7, this);
                if (this.F7) {
                    h0.c cVar = this.H7;
                    long j10 = this.f34802v2;
                    bVarH = cVar.d(runnableC0391a, j10, j10, this.C2);
                } else {
                    xi.h0 h0Var = this.K2;
                    long j11 = this.f34802v2;
                    bVarH = h0Var.h(runnableC0391a, j11, j11, this.C2);
                }
                this.N7.a(bVarH);
            }
        }
    }

    public static final class b<T> extends gj.k<T, Object, xi.z<T>> implements xi.g0<T>, io.reactivex.disposables.b, Runnable {
        public static final Object J7 = new Object();
        public final TimeUnit C2;
        public final int E7;
        public io.reactivex.disposables.b F7;
        public UnicastSubject<T> G7;
        public final SequentialDisposable H7;
        public volatile boolean I7;
        public final xi.h0 K2;

        /* JADX INFO: renamed from: v2, reason: collision with root package name */
        public final long f34805v2;

        public b(xi.g0<? super xi.z<T>> g0Var, long j10, TimeUnit timeUnit, xi.h0 h0Var, int i10) {
            super(g0Var, new MpscLinkedQueue());
            this.H7 = new SequentialDisposable();
            this.f34805v2 = j10;
            this.C2 = timeUnit;
            this.K2 = h0Var;
            this.E7 = i10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f29584v1 = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f29584v1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
        
            r7.H7.dispose();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x002f, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        
            r7.G7 = null;
            r0.clear();
            r0 = r7.K1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        
            if (r0 == null) goto L11;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [io.reactivex.subjects.UnicastSubject<T>] */
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
        public void j() {
            /*
                r7 = this;
                fj.n<U> r0 = r7.f29583k1
                io.reactivex.internal.queue.MpscLinkedQueue r0 = (io.reactivex.internal.queue.MpscLinkedQueue) r0
                xi.g0<? super V> r1 = r7.K0
                io.reactivex.subjects.UnicastSubject<T> r2 = r7.G7
                r3 = 1
            L9:
                boolean r4 = r7.I7
                boolean r5 = r7.C1
                java.lang.Object r6 = r0.poll()
                if (r5 == 0) goto L30
                if (r6 == 0) goto L19
                java.lang.Object r5 = io.reactivex.internal.operators.observable.y1.b.J7
                if (r6 != r5) goto L30
            L19:
                r1 = 0
                r7.G7 = r1
                r0.clear()
                java.lang.Throwable r0 = r7.K1
                if (r0 == 0) goto L27
                r2.onError(r0)
                goto L2a
            L27:
                r2.onComplete()
            L2a:
                io.reactivex.internal.disposables.SequentialDisposable r0 = r7.H7
                r0.dispose()
                return
            L30:
                if (r6 != 0) goto L3a
                int r3 = -r3
                int r3 = r7.f(r3)
                if (r3 != 0) goto L9
                return
            L3a:
                java.lang.Object r5 = io.reactivex.internal.operators.observable.y1.b.J7
                if (r6 != r5) goto L55
                r2.onComplete()
                if (r4 != 0) goto L4f
                int r2 = r7.E7
                io.reactivex.subjects.UnicastSubject r2 = io.reactivex.subjects.UnicastSubject.o8(r2)
                r7.G7 = r2
                r1.onNext(r2)
                goto L9
            L4f:
                io.reactivex.disposables.b r4 = r7.F7
                r4.dispose()
                goto L9
            L55:
                java.lang.Object r4 = io.reactivex.internal.util.NotificationLite.getValue(r6)
                r2.onNext(r4)
                goto L9
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.y1.b.j():void");
        }

        @Override // xi.g0
        public void onComplete() {
            this.C1 = true;
            if (a()) {
                j();
            }
            this.K0.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.K1 = th2;
            this.C1 = true;
            if (a()) {
                j();
            }
            this.K0.onError(th2);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // xi.g0
        public void onNext(T t10) {
            if (this.I7) {
                return;
            }
            if (d()) {
                this.G7.onNext(t10);
                if (f(-1) == 0) {
                    return;
                }
            } else {
                this.f29583k1.offer((U) NotificationLite.next(t10));
                if (!a()) {
                    return;
                }
            }
            j();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.F7, bVar)) {
                this.F7 = bVar;
                this.G7 = UnicastSubject.o8(this.E7);
                xi.g0<? super V> g0Var = this.K0;
                g0Var.onSubscribe(this);
                g0Var.onNext(this.G7);
                if (this.f29584v1) {
                    return;
                }
                xi.h0 h0Var = this.K2;
                long j10 = this.f34805v2;
                this.H7.a(h0Var.h(this, j10, j10, this.C2));
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.lang.Runnable
        public void run() {
            if (this.f29584v1) {
                this.I7 = true;
            }
            this.f29583k1.offer((U) J7);
            if (a()) {
                j();
            }
        }
    }

    public static final class c<T> extends gj.k<T, Object, xi.z<T>> implements io.reactivex.disposables.b, Runnable {
        public final long C2;
        public final h0.c E7;
        public final int F7;
        public final List<UnicastSubject<T>> G7;
        public io.reactivex.disposables.b H7;
        public volatile boolean I7;
        public final TimeUnit K2;

        /* JADX INFO: renamed from: v2, reason: collision with root package name */
        public final long f34806v2;

        public final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final UnicastSubject<T> f34807a;

            public a(UnicastSubject<T> unicastSubject) {
                this.f34807a = unicastSubject;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.j(this.f34807a);
            }
        }

        public static final class b<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final UnicastSubject<T> f34809a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f34810b;

            public b(UnicastSubject<T> unicastSubject, boolean z10) {
                this.f34809a = unicastSubject;
                this.f34810b = z10;
            }
        }

        public c(xi.g0<? super xi.z<T>> g0Var, long j10, long j11, TimeUnit timeUnit, h0.c cVar, int i10) {
            super(g0Var, new MpscLinkedQueue());
            this.f34806v2 = j10;
            this.C2 = j11;
            this.K2 = timeUnit;
            this.E7 = cVar;
            this.F7 = i10;
            this.G7 = new LinkedList();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f29584v1 = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f29584v1;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public void j(UnicastSubject<T> unicastSubject) {
            this.f29583k1.offer((U) new b(unicastSubject, false));
            if (a()) {
                k();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public void k() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f29583k1;
            xi.g0<? super V> g0Var = this.K0;
            List<UnicastSubject<T>> list = this.G7;
            int iF = 1;
            while (!this.I7) {
                boolean z10 = this.C1;
                Object objPoll = mpscLinkedQueue.poll();
                boolean z11 = objPoll == null;
                boolean z12 = objPoll instanceof b;
                if (z10 && (z11 || z12)) {
                    mpscLinkedQueue.clear();
                    Throwable th2 = this.K1;
                    if (th2 != null) {
                        Iterator<UnicastSubject<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onError(th2);
                        }
                    } else {
                        Iterator<UnicastSubject<T>> it3 = list.iterator();
                        while (it3.hasNext()) {
                            it3.next().onComplete();
                        }
                    }
                    list.clear();
                    this.E7.dispose();
                    return;
                }
                if (z11) {
                    iF = f(-iF);
                    if (iF == 0) {
                        return;
                    }
                } else if (z12) {
                    b bVar = (b) objPoll;
                    if (!bVar.f34810b) {
                        list.remove(bVar.f34809a);
                        bVar.f34809a.onComplete();
                        if (list.isEmpty() && this.f29584v1) {
                            this.I7 = true;
                        }
                    } else if (!this.f29584v1) {
                        UnicastSubject<T> unicastSubjectO8 = UnicastSubject.o8(this.F7);
                        list.add(unicastSubjectO8);
                        g0Var.onNext(unicastSubjectO8);
                        this.E7.c(new a(unicastSubjectO8), this.f34806v2, this.K2);
                    }
                } else {
                    Iterator<UnicastSubject<T>> it4 = list.iterator();
                    while (it4.hasNext()) {
                        it4.next().onNext(objPoll);
                    }
                }
            }
            this.H7.dispose();
            mpscLinkedQueue.clear();
            list.clear();
            this.E7.dispose();
        }

        @Override // xi.g0
        public void onComplete() {
            this.C1 = true;
            if (a()) {
                k();
            }
            this.K0.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.K1 = th2;
            this.C1 = true;
            if (a()) {
                k();
            }
            this.K0.onError(th2);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // xi.g0
        public void onNext(T t10) {
            if (d()) {
                Iterator<UnicastSubject<T>> it2 = this.G7.iterator();
                while (it2.hasNext()) {
                    it2.next().onNext(t10);
                }
                if (f(-1) == 0) {
                    return;
                }
            } else {
                this.f29583k1.offer((U) t10);
                if (!a()) {
                    return;
                }
            }
            k();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.H7, bVar)) {
                this.H7 = bVar;
                this.K0.onSubscribe(this);
                if (this.f29584v1) {
                    return;
                }
                UnicastSubject<T> unicastSubjectO8 = UnicastSubject.o8(this.F7);
                this.G7.add(unicastSubjectO8);
                this.K0.onNext(unicastSubjectO8);
                this.E7.c(new a(unicastSubjectO8), this.f34806v2, this.K2);
                h0.c cVar = this.E7;
                long j10 = this.C2;
                cVar.d(this, j10, j10, this.K2);
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.lang.Runnable
        public void run() {
            Object bVar = new b(UnicastSubject.o8(this.F7), true);
            if (!this.f29584v1) {
                this.f29583k1.offer((U) bVar);
            }
            if (a()) {
                k();
            }
        }
    }

    public y1(xi.e0<T> e0Var, long j10, long j11, TimeUnit timeUnit, xi.h0 h0Var, long j12, int i10, boolean z10) {
        super(e0Var);
        this.f34795b = j10;
        this.f34796c = j11;
        this.f34797d = timeUnit;
        this.f34798e = h0Var;
        this.f34799f = j12;
        this.f34800g = i10;
        this.f34801h = z10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super xi.z<T>> g0Var) {
        io.reactivex.observers.l lVar = new io.reactivex.observers.l(g0Var);
        long j10 = this.f34795b;
        long j11 = this.f34796c;
        if (j10 != j11) {
            this.f34421a.c(new c(lVar, j10, j11, this.f34797d, this.f34798e.d(), this.f34800g));
            return;
        }
        long j12 = this.f34799f;
        if (j12 == Long.MAX_VALUE) {
            this.f34421a.c(new b(lVar, this.f34795b, this.f34797d, this.f34798e, this.f34800g));
        } else {
            this.f34421a.c(new a(lVar, j10, this.f34797d, this.f34798e, this.f34800g, j12, this.f34801h));
        }
    }
}
