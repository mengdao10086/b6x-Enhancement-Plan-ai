package androidx.work.impl.utils.futures;

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
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class AbstractFuture<V> implements ListenableFuture<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f8525d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f8526e = Logger.getLogger(AbstractFuture.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f8527f = 1000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f8528g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f8529h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public volatile Object f8530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public volatile d f8531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public volatile h f8532c;

    public static final class Failure {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Failure f8533b = new Failure(new Throwable("Failure occurred while trying to finish a future.") { // from class: androidx.work.impl.utils.futures.AbstractFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f8534a;

        public Failure(Throwable exception) {
            this.f8534a = (Throwable) AbstractFuture.d(exception);
        }
    }

    public static abstract class b {
        public b() {
        }

        public abstract boolean a(AbstractFuture<?> future, d expect, d update);

        public abstract boolean b(AbstractFuture<?> future, Object expect, Object update);

        public abstract boolean c(AbstractFuture<?> future, h expect, h update);

        public abstract void d(h waiter, h newValue);

        public abstract void e(h waiter, Thread newValue);
    }

    public static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f8535c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f8536d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f8537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public final Throwable f8538b;

        static {
            if (AbstractFuture.f8525d) {
                f8536d = null;
                f8535c = null;
            } else {
                f8536d = new c(false, null);
                f8535c = new c(true, null);
            }
        }

        public c(boolean wasInterrupted, @p0 Throwable cause) {
            this.f8537a = wasInterrupted;
            this.f8538b = cause;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f8539d = new d(null, null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f8540a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f8541b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public d f8542c;

        public d(Runnable task, Executor executor) {
            this.f8540a = task;
            this.f8541b = executor;
        }
    }

    public static final class e extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<h, Thread> f8543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<h, h> f8544b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, h> f8545c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, d> f8546d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, Object> f8547e;

        public e(AtomicReferenceFieldUpdater<h, Thread> waiterThreadUpdater, AtomicReferenceFieldUpdater<h, h> waiterNextUpdater, AtomicReferenceFieldUpdater<AbstractFuture, h> waitersUpdater, AtomicReferenceFieldUpdater<AbstractFuture, d> listenersUpdater, AtomicReferenceFieldUpdater<AbstractFuture, Object> valueUpdater) {
            super();
            this.f8543a = waiterThreadUpdater;
            this.f8544b = waiterNextUpdater;
            this.f8545c = waitersUpdater;
            this.f8546d = listenersUpdater;
            this.f8547e = valueUpdater;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public boolean a(AbstractFuture<?> future, d expect, d update) {
            return o.a(this.f8546d, future, expect, update);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public boolean b(AbstractFuture<?> future, Object expect, Object update) {
            return o.a(this.f8547e, future, expect, update);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public boolean c(AbstractFuture<?> future, h expect, h update) {
            return o.a(this.f8545c, future, expect, update);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public void d(h waiter, h newValue) {
            this.f8544b.lazySet(waiter, newValue);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public void e(h waiter, Thread newValue) {
            this.f8543a.lazySet(waiter, newValue);
        }
    }

    public static final class f<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractFuture<V> f8548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ListenableFuture<? extends V> f8549b;

        public f(AbstractFuture<V> owner, ListenableFuture<? extends V> future) {
            this.f8548a = owner;
            this.f8549b = future;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f8548a.f8530a != this) {
                return;
            }
            if (AbstractFuture.f8528g.b(this.f8548a, this, AbstractFuture.i(this.f8549b))) {
                AbstractFuture.f(this.f8548a);
            }
        }
    }

    public static final class g extends b {
        public g() {
            super();
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public boolean a(AbstractFuture<?> future, d expect, d update) {
            synchronized (future) {
                if (future.f8531b != expect) {
                    return false;
                }
                future.f8531b = update;
                return true;
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public boolean b(AbstractFuture<?> future, Object expect, Object update) {
            synchronized (future) {
                if (future.f8530a != expect) {
                    return false;
                }
                future.f8530a = update;
                return true;
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public boolean c(AbstractFuture<?> future, h expect, h update) {
            synchronized (future) {
                if (future.f8532c != expect) {
                    return false;
                }
                future.f8532c = update;
                return true;
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public void d(h waiter, h newValue) {
            waiter.f8552b = newValue;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.b
        public void e(h waiter, Thread newValue) {
            waiter.f8551a = newValue;
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f8550c = new h(false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @p0
        public volatile Thread f8551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public volatile h f8552b;

        public h(boolean unused) {
        }

        public void a(h next) {
            AbstractFuture.f8528g.d(this, next);
        }

        public void b() {
            Thread thread = this.f8551a;
            if (thread != null) {
                this.f8551a = null;
                LockSupport.unpark(thread);
            }
        }

        public h() {
            AbstractFuture.f8528g.e(this, Thread.currentThread());
        }
    }

    static {
        b gVar;
        try {
            gVar = new e(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, h.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, d.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "a"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            gVar = new g();
        }
        f8528g = gVar;
        if (th != null) {
            f8526e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f8529h = new Object();
    }

    public static CancellationException c(@p0 String message, @p0 Throwable cause) {
        CancellationException cancellationException = new CancellationException(message);
        cancellationException.initCause(cause);
        return cancellationException;
    }

    @n0
    public static <T> T d(@p0 T reference) {
        Objects.requireNonNull(reference);
        return reference;
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
    public static void f(AbstractFuture<?> abstractFuture) {
        d dVar = null;
        while (true) {
            abstractFuture.n();
            abstractFuture.b();
            d dVarE = abstractFuture.e(dVar);
            while (dVarE != null) {
                dVar = dVarE.f8542c;
                Runnable runnable = dVarE.f8540a;
                if (runnable instanceof f) {
                    f fVar = (f) runnable;
                    abstractFuture = fVar.f8548a;
                    if (abstractFuture.f8530a == fVar) {
                        if (f8528g.b(abstractFuture, fVar, i(fVar.f8549b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    g(runnable, dVarE.f8541b);
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
            f8526e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e10);
        }
    }

    public static Object i(ListenableFuture<?> future) {
        if (future instanceof AbstractFuture) {
            Object obj = ((AbstractFuture) future).f8530a;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            return cVar.f8537a ? cVar.f8538b != null ? new c(false, cVar.f8538b) : c.f8536d : obj;
        }
        boolean zIsCancelled = future.isCancelled();
        if ((!f8525d) && zIsCancelled) {
            return c.f8536d;
        }
        try {
            Object objJ = j(future);
            return objJ == null ? f8529h : objJ;
        } catch (CancellationException e10) {
            if (zIsCancelled) {
                return new c(false, e10);
            }
            return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + future, e10));
        } catch (ExecutionException e11) {
            return new Failure(e11.getCause());
        } catch (Throwable th2) {
            return new Failure(th2);
        }
    }

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

    public final void a(StringBuilder builder) {
        try {
            Object objJ = j(this);
            builder.append("SUCCESS, result=[");
            builder.append(s(objJ));
            builder.append("]");
        } catch (CancellationException unused) {
            builder.append("CANCELLED");
        } catch (RuntimeException e10) {
            builder.append("UNKNOWN, cause=[");
            builder.append(e10.getClass());
            builder.append(" thrown from get()]");
        } catch (ExecutionException e11) {
            builder.append("FAILURE, cause=[");
            builder.append(e11.getCause());
            builder.append("]");
        }
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable listener, Executor executor) {
        d(listener);
        d(executor);
        d dVar = this.f8531b;
        if (dVar != d.f8539d) {
            d dVar2 = new d(listener, executor);
            do {
                dVar2.f8542c = dVar;
                if (f8528g.a(this, dVar, dVar2)) {
                    return;
                } else {
                    dVar = this.f8531b;
                }
            } while (dVar != d.f8539d);
        }
        g(listener, executor);
    }

    public void b() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean mayInterruptIfRunning) {
        Object obj = this.f8530a;
        if (!(obj == null) && !(obj instanceof f)) {
            return false;
        }
        c cVar = f8525d ? new c(mayInterruptIfRunning, new CancellationException("Future.cancel() was called.")) : mayInterruptIfRunning ? c.f8535c : c.f8536d;
        boolean z10 = false;
        AbstractFuture<V> abstractFuture = this;
        while (true) {
            if (f8528g.b(abstractFuture, obj, cVar)) {
                if (mayInterruptIfRunning) {
                    abstractFuture.k();
                }
                f(abstractFuture);
                if (!(obj instanceof f)) {
                    return true;
                }
                ListenableFuture<? extends V> listenableFuture = ((f) obj).f8549b;
                if (!(listenableFuture instanceof AbstractFuture)) {
                    listenableFuture.cancel(mayInterruptIfRunning);
                    return true;
                }
                abstractFuture = (AbstractFuture) listenableFuture;
                obj = abstractFuture.f8530a;
                if (!(obj == null) && !(obj instanceof f)) {
                    return true;
                }
                z10 = true;
            } else {
                obj = abstractFuture.f8530a;
                if (!(obj instanceof f)) {
                    return z10;
                }
            }
        }
    }

    public final d e(d onto) {
        d dVar;
        do {
            dVar = this.f8531b;
        } while (!f8528g.a(this, dVar, d.f8539d));
        d dVar2 = onto;
        d dVar3 = dVar;
        while (dVar3 != null) {
            d dVar4 = dVar3.f8542c;
            dVar3.f8542c = dVar2;
            dVar2 = dVar3;
            dVar3 = dVar4;
        }
        return dVar2;
    }

    @Override // java.util.concurrent.Future
    public final V get(long timeout, TimeUnit unit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = unit.toNanos(timeout);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f8530a;
        if ((obj != null) && (!(obj instanceof f))) {
            return h(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            h hVar = this.f8532c;
            if (hVar != h.f8550c) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (f8528g.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                o(hVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f8530a;
                            if ((obj2 != null) && (!(obj2 instanceof f))) {
                                return h(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        o(hVar2);
                    } else {
                        hVar = this.f8532c;
                    }
                } while (hVar != h.f8550c);
            }
            return h(this.f8530a);
        }
        while (nanos > 0) {
            Object obj3 = this.f8530a;
            if ((obj3 != null) && (!(obj3 instanceof f))) {
                return h(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = unit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String str = "Waited " + timeout + i0.f11861z + unit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j10 = -nanos;
            long jConvert = unit.convert(j10, TimeUnit.NANOSECONDS);
            long nanos2 = j10 - unit.toNanos(jConvert);
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
            throw c("Task was cancelled.", ((c) obj).f8538b);
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f8534a);
        }
        if (obj == f8529h) {
            return null;
        }
        return obj;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f8530a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r0 instanceof f)) & (this.f8530a != null);
    }

    public void k() {
    }

    public final void l(@p0 Future<?> related) {
        if ((related != null) && isCancelled()) {
            related.cancel(t());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @p0
    public String m() {
        Object obj = this.f8530a;
        if (obj instanceof f) {
            return "setFuture=[" + s(((f) obj).f8549b) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void n() {
        h hVar;
        do {
            hVar = this.f8532c;
        } while (!f8528g.c(this, hVar, h.f8550c));
        while (hVar != null) {
            hVar.b();
            hVar = hVar.f8552b;
        }
    }

    public final void o(h node) {
        node.f8551a = null;
        while (true) {
            h hVar = this.f8532c;
            if (hVar == h.f8550c) {
                return;
            }
            h hVar2 = null;
            while (hVar != null) {
                h hVar3 = hVar.f8552b;
                if (hVar.f8551a != null) {
                    hVar2 = hVar;
                } else if (hVar2 != null) {
                    hVar2.f8552b = hVar3;
                    if (hVar2.f8551a == null) {
                        break;
                    }
                } else if (!f8528g.c(this, hVar, hVar3)) {
                    break;
                }
                hVar = hVar3;
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
            v10 = (V) f8529h;
        }
        if (!f8528g.b(this, null, v10)) {
            return false;
        }
        f(this);
        return true;
    }

    public boolean q(Throwable throwable) {
        if (!f8528g.b(this, null, new Failure((Throwable) d(throwable)))) {
            return false;
        }
        f(this);
        return true;
    }

    public boolean r(ListenableFuture<? extends V> future) {
        Failure failure;
        d(future);
        Object obj = this.f8530a;
        if (obj == null) {
            if (future.isDone()) {
                if (!f8528g.b(this, null, i(future))) {
                    return false;
                }
                f(this);
                return true;
            }
            f fVar = new f(this, future);
            if (f8528g.b(this, null, fVar)) {
                try {
                    future.addListener(fVar, DirectExecutor.INSTANCE);
                } catch (Throwable th2) {
                    try {
                        failure = new Failure(th2);
                    } catch (Throwable unused) {
                        failure = Failure.f8533b;
                    }
                    f8528g.b(this, fVar, failure);
                }
                return true;
            }
            obj = this.f8530a;
        }
        if (obj instanceof c) {
            future.cancel(((c) obj).f8537a);
        }
        return false;
    }

    public final String s(Object o10) {
        return o10 == this ? "this future" : String.valueOf(o10);
    }

    public final boolean t() {
        Object obj = this.f8530a;
        return (obj instanceof c) && ((c) obj).f8537a;
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
            Object obj2 = this.f8530a;
            if ((obj2 != null) & (!(obj2 instanceof f))) {
                return h(obj2);
            }
            h hVar = this.f8532c;
            if (hVar != h.f8550c) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (f8528g.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f8530a;
                            } else {
                                o(hVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof f))));
                        return h(obj);
                    }
                    hVar = this.f8532c;
                } while (hVar != h.f8550c);
            }
            return h(this.f8530a);
        }
        throw new InterruptedException();
    }
}
