package androidx.concurrent.futures;

import al.o;
import androidx.annotation.RestrictTo;
import com.blankj.utilcode.util.i0;
import com.google.common.util.concurrent.ListenableFuture;
import g.n0;
import g.p0;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class AbstractResolvableFuture<V> implements ListenableFuture<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f2881d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f2882e = Logger.getLogger(AbstractResolvableFuture.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f2883f = 1000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f2884g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f2885h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public volatile Object f2886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public volatile d f2887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public volatile h f2888c;

    public static final class Failure {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Failure f2889b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: androidx.concurrent.futures.AbstractResolvableFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f2890a;

        public Failure(Throwable th2) {
            this.f2890a = (Throwable) AbstractResolvableFuture.d(th2);
        }
    }

    public static abstract class b {
        public b() {
        }

        public abstract boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, d dVar, d dVar2);

        public abstract boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2);

        public abstract boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, h hVar, h hVar2);

        public abstract void d(h hVar, h hVar2);

        public abstract void e(h hVar, Thread thread);
    }

    public static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f2891c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f2892d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f2893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public final Throwable f2894b;

        static {
            if (AbstractResolvableFuture.f2881d) {
                f2892d = null;
                f2891c = null;
            } else {
                f2892d = new c(false, null);
                f2891c = new c(true, null);
            }
        }

        public c(boolean z10, @p0 Throwable th2) {
            this.f2893a = z10;
            this.f2894b = th2;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f2895d = new d(null, null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f2896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f2897b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public d f2898c;

        public d(Runnable runnable, Executor executor) {
            this.f2896a = runnable;
            this.f2897b = executor;
        }
    }

    public static final class e extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<h, Thread> f2899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<h, h> f2900b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, h> f2901c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, d> f2902d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> f2903e;

        public e(AtomicReferenceFieldUpdater<h, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<h, h> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractResolvableFuture, h> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractResolvableFuture, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f2899a = atomicReferenceFieldUpdater;
            this.f2900b = atomicReferenceFieldUpdater2;
            this.f2901c = atomicReferenceFieldUpdater3;
            this.f2902d = atomicReferenceFieldUpdater4;
            this.f2903e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, d dVar, d dVar2) {
            return o.a(this.f2902d, abstractResolvableFuture, dVar, dVar2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            return o.a(this.f2903e, abstractResolvableFuture, obj, obj2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, h hVar, h hVar2) {
            return o.a(this.f2901c, abstractResolvableFuture, hVar, hVar2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void d(h hVar, h hVar2) {
            this.f2900b.lazySet(hVar, hVar2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void e(h hVar, Thread thread) {
            this.f2899a.lazySet(hVar, thread);
        }
    }

    public static final class f<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractResolvableFuture<V> f2904a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ListenableFuture<? extends V> f2905b;

        public f(AbstractResolvableFuture<V> abstractResolvableFuture, ListenableFuture<? extends V> listenableFuture) {
            this.f2904a = abstractResolvableFuture;
            this.f2905b = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2904a.f2886a != this) {
                return;
            }
            if (AbstractResolvableFuture.f2884g.b(this.f2904a, this, AbstractResolvableFuture.i(this.f2905b))) {
                AbstractResolvableFuture.f(this.f2904a);
            }
        }
    }

    public static final class g extends b {
        public g() {
            super();
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, d dVar, d dVar2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.f2887b != dVar) {
                    return false;
                }
                abstractResolvableFuture.f2887b = dVar2;
                return true;
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.f2886a != obj) {
                    return false;
                }
                abstractResolvableFuture.f2886a = obj2;
                return true;
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, h hVar, h hVar2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.f2888c != hVar) {
                    return false;
                }
                abstractResolvableFuture.f2888c = hVar2;
                return true;
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void d(h hVar, h hVar2) {
            hVar.f2908b = hVar2;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.b
        public void e(h hVar, Thread thread) {
            hVar.f2907a = thread;
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f2906c = new h(false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @p0
        public volatile Thread f2907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public volatile h f2908b;

        public h(boolean z10) {
        }

        public void a(h hVar) {
            AbstractResolvableFuture.f2884g.d(this, hVar);
        }

        public void b() {
            Thread thread = this.f2907a;
            if (thread != null) {
                this.f2907a = null;
                LockSupport.unpark(thread);
            }
        }

        public h() {
            AbstractResolvableFuture.f2884g.e(this, Thread.currentThread());
        }
    }

    static {
        b gVar;
        try {
            gVar = new e(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, h.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, d.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, "a"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            gVar = new g();
        }
        f2884g = gVar;
        if (th != null) {
            f2882e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f2885h = new Object();
    }

    public static CancellationException c(@p0 String str, @p0 Throwable th2) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th2);
        return cancellationException;
    }

    @n0
    public static <T> T d(@p0 T t10) {
        Objects.requireNonNull(t10);
        return t10;
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
    public static void f(AbstractResolvableFuture<?> abstractResolvableFuture) {
        d dVar = null;
        while (true) {
            abstractResolvableFuture.n();
            abstractResolvableFuture.b();
            d dVarE = abstractResolvableFuture.e(dVar);
            while (dVarE != null) {
                dVar = dVarE.f2898c;
                Runnable runnable = dVarE.f2896a;
                if (runnable instanceof f) {
                    f fVar = (f) runnable;
                    abstractResolvableFuture = fVar.f2904a;
                    if (abstractResolvableFuture.f2886a == fVar) {
                        if (f2884g.b(abstractResolvableFuture, fVar, i(fVar.f2905b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    g(runnable, dVarE.f2897b);
                }
                dVarE = dVar;
            }
            return;
        }
    }

    public static void g(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            f2882e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e10);
        }
    }

    public static Object i(ListenableFuture<?> listenableFuture) {
        if (listenableFuture instanceof AbstractResolvableFuture) {
            Object obj = ((AbstractResolvableFuture) listenableFuture).f2886a;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            return cVar.f2893a ? cVar.f2894b != null ? new c(false, cVar.f2894b) : c.f2892d : obj;
        }
        boolean zIsCancelled = listenableFuture.isCancelled();
        if ((!f2881d) && zIsCancelled) {
            return c.f2892d;
        }
        try {
            Object objJ = j(listenableFuture);
            return objJ == null ? f2885h : objJ;
        } catch (CancellationException e10) {
            if (zIsCancelled) {
                return new c(false, e10);
            }
            return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e10));
        } catch (ExecutionException e11) {
            return new Failure(e11.getCause());
        } catch (Throwable th2) {
            return new Failure(th2);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static <V> V j(Future<V> future) throws ExecutionException {
        V v10;
        boolean z10 = false;
        while (true) {
            try {
                v10 = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th2) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return v10;
    }

    public final void a(StringBuilder sb2) {
        try {
            Object objJ = j(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(s(objJ));
            sb2.append("]");
        } catch (CancellationException unused) {
            sb2.append("CANCELLED");
        } catch (RuntimeException e10) {
            sb2.append("UNKNOWN, cause=[");
            sb2.append(e10.getClass());
            sb2.append(" thrown from get()]");
        } catch (ExecutionException e11) {
            sb2.append("FAILURE, cause=[");
            sb2.append(e11.getCause());
            sb2.append("]");
        }
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        d(runnable);
        d(executor);
        d dVar = this.f2887b;
        if (dVar != d.f2895d) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.f2898c = dVar;
                if (f2884g.a(this, dVar, dVar2)) {
                    return;
                } else {
                    dVar = this.f2887b;
                }
            } while (dVar != d.f2895d);
        }
        g(runnable, executor);
    }

    public void b() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        Object obj = this.f2886a;
        if (!(obj == null) && !(obj instanceof f)) {
            return false;
        }
        c cVar = f2881d ? new c(z10, new CancellationException("Future.cancel() was called.")) : z10 ? c.f2891c : c.f2892d;
        boolean z11 = false;
        AbstractResolvableFuture<V> abstractResolvableFuture = this;
        while (true) {
            if (f2884g.b(abstractResolvableFuture, obj, cVar)) {
                if (z10) {
                    abstractResolvableFuture.k();
                }
                f(abstractResolvableFuture);
                if (!(obj instanceof f)) {
                    return true;
                }
                ListenableFuture<? extends V> listenableFuture = ((f) obj).f2905b;
                if (!(listenableFuture instanceof AbstractResolvableFuture)) {
                    listenableFuture.cancel(z10);
                    return true;
                }
                abstractResolvableFuture = (AbstractResolvableFuture) listenableFuture;
                obj = abstractResolvableFuture.f2886a;
                if (!(obj == null) && !(obj instanceof f)) {
                    return true;
                }
                z11 = true;
            } else {
                obj = abstractResolvableFuture.f2886a;
                if (!(obj instanceof f)) {
                    return z11;
                }
            }
        }
    }

    public final d e(d dVar) {
        d dVar2;
        do {
            dVar2 = this.f2887b;
        } while (!f2884g.a(this, dVar2, d.f2895d));
        d dVar3 = dVar;
        d dVar4 = dVar2;
        while (dVar4 != null) {
            d dVar5 = dVar4.f2898c;
            dVar4.f2898c = dVar3;
            dVar3 = dVar4;
            dVar4 = dVar5;
        }
        return dVar3;
    }

    @Override // java.util.concurrent.Future
    public final V get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j10);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f2886a;
        if ((obj != null) && (!(obj instanceof f))) {
            return h(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            h hVar = this.f2888c;
            if (hVar != h.f2906c) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (f2884g.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                o(hVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f2886a;
                            if ((obj2 != null) && (!(obj2 instanceof f))) {
                                return h(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        o(hVar2);
                    } else {
                        hVar = this.f2888c;
                    }
                } while (hVar != h.f2906c);
            }
            return h(this.f2886a);
        }
        while (nanos > 0) {
            Object obj3 = this.f2886a;
            if ((obj3 != null) && (!(obj3 instanceof f))) {
                return h(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String str = "Waited " + j10 + i0.f11861z + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j11 = -nanos;
            long jConvert = timeUnit.convert(j11, TimeUnit.NANOSECONDS);
            long nanos2 = j11 - timeUnit.toNanos(jConvert);
            boolean z10 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + i0.f11861z + lowerCase;
                if (z10) {
                    str3 = str3 + ag.c.f654g;
                }
                str2 = str3 + i0.f11861z;
            }
            if (z10) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + string);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V h(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw c("Task was cancelled.", ((c) obj).f2894b);
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f2890a);
        }
        if (obj == f2885h) {
            return null;
        }
        return obj;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f2886a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r0 instanceof f)) & (this.f2886a != null);
    }

    public void k() {
    }

    public final void l(@p0 Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(t());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @p0
    public String m() {
        Object obj = this.f2886a;
        if (obj instanceof f) {
            return "setFuture=[" + s(((f) obj).f2905b) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void n() {
        h hVar;
        do {
            hVar = this.f2888c;
        } while (!f2884g.c(this, hVar, h.f2906c));
        while (hVar != null) {
            hVar.b();
            hVar = hVar.f2908b;
        }
    }

    public final void o(h hVar) {
        hVar.f2907a = null;
        while (true) {
            h hVar2 = this.f2888c;
            if (hVar2 == h.f2906c) {
                return;
            }
            h hVar3 = null;
            while (hVar2 != null) {
                h hVar4 = hVar2.f2908b;
                if (hVar2.f2907a != null) {
                    hVar3 = hVar2;
                } else if (hVar3 != null) {
                    hVar3.f2908b = hVar4;
                    if (hVar3.f2907a == null) {
                        break;
                    }
                } else if (!f2884g.c(this, hVar2, hVar4)) {
                    break;
                }
                hVar2 = hVar4;
            }
            return;
        }
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
    public boolean p(@p0 V v10) {
        if (v10 == null) {
            v10 = (V) f2885h;
        }
        if (!f2884g.b(this, null, v10)) {
            return false;
        }
        f(this);
        return true;
    }

    public boolean q(Throwable th2) {
        if (!f2884g.b(this, null, new Failure((Throwable) d(th2)))) {
            return false;
        }
        f(this);
        return true;
    }

    public boolean r(ListenableFuture<? extends V> listenableFuture) {
        Failure failure;
        d(listenableFuture);
        Object obj = this.f2886a;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!f2884g.b(this, null, i(listenableFuture))) {
                    return false;
                }
                f(this);
                return true;
            }
            f fVar = new f(this, listenableFuture);
            if (f2884g.b(this, null, fVar)) {
                try {
                    listenableFuture.addListener(fVar, DirectExecutor.INSTANCE);
                } catch (Throwable th2) {
                    try {
                        failure = new Failure(th2);
                    } catch (Throwable unused) {
                        failure = Failure.f2889b;
                    }
                    f2884g.b(this, fVar, failure);
                }
                return true;
            }
            obj = this.f2886a;
        }
        if (obj instanceof c) {
            listenableFuture.cancel(((c) obj).f2893a);
        }
        return false;
    }

    public final String s(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    public final boolean t() {
        Object obj = this.f2886a;
        return (obj instanceof c) && ((c) obj).f2893a;
    }

    public String toString() {
        String strM;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            a(sb2);
        } else {
            try {
                strM = m();
            } catch (RuntimeException e10) {
                strM = "Exception thrown from implementation: " + e10.getClass();
            }
            if (strM != null && !strM.isEmpty()) {
                sb2.append("PENDING, info=[");
                sb2.append(strM);
                sb2.append("]");
            } else if (isDone()) {
                a(sb2);
            } else {
                sb2.append("PENDING");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    @Override // java.util.concurrent.Future
    public final V get() throws ExecutionException, InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f2886a;
            if ((obj2 != null) & (!(obj2 instanceof f))) {
                return h(obj2);
            }
            h hVar = this.f2888c;
            if (hVar != h.f2906c) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (f2884g.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f2886a;
                            } else {
                                o(hVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof f))));
                        return h(obj);
                    }
                    hVar = this.f2888c;
                } while (hVar != h.f2906c);
            }
            return h(this.f2886a);
        }
        throw new InterruptedException();
    }
}
