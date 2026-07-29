package kotlinx.coroutines;

import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.c2;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nJob.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Job.kt\nkotlinx/coroutines/JobKt__JobKt\n+ 2 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,685:1\n13#2:686\n1295#3,2:687\n1295#3,2:689\n1295#3,2:691\n1295#3,2:693\n*S KotlinDebug\n*F\n+ 1 Job.kt\nkotlinx/coroutines/JobKt__JobKt\n*L\n494#1:686\n521#1:687,2\n535#1:689,2\n629#1:691,2\n653#1:693,2\n*E\n"})
public final /* synthetic */ class h2 {
    public static final boolean A(@yt.k CoroutineContext coroutineContext) {
        c2 c2Var = (c2) coroutineContext.c(c2.f38296x2);
        if (c2Var != null) {
            return c2Var.isActive();
        }
        return true;
    }

    public static final Throwable B(Throwable th2, c2 c2Var) {
        return th2 == null ? new JobCancellationException("Job was cancelled", null, c2Var) : th2;
    }

    @yt.k
    public static final a0 a(@yt.l c2 c2Var) {
        return new e2(c2Var);
    }

    @hk.h(name = "Job")
    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ c2 b(c2 c2Var) {
        return f2.a(c2Var);
    }

    public static /* synthetic */ a0 c(c2 c2Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            c2Var = null;
        }
        return f2.a(c2Var);
    }

    public static /* synthetic */ c2 d(c2 c2Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            c2Var = null;
        }
        return b(c2Var);
    }

    public static final void f(@yt.k CoroutineContext coroutineContext, @yt.l CancellationException cancellationException) {
        c2 c2Var = (c2) coroutineContext.c(c2.f38296x2);
        if (c2Var != null) {
            c2Var.h(cancellationException);
        }
    }

    public static final void g(@yt.k c2 c2Var, @yt.k String str, @yt.l Throwable th2) {
        c2Var.h(p1.a(str, th2));
    }

    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ boolean h(CoroutineContext coroutineContext, Throwable th2) throws Throwable {
        CoroutineContext.a aVarC = coroutineContext.c(c2.f38296x2);
        JobSupport jobSupport = aVarC instanceof JobSupport ? (JobSupport) aVarC : null;
        if (jobSupport == null) {
            return false;
        }
        jobSupport.j0(B(th2, jobSupport));
        return true;
    }

    public static /* synthetic */ void i(CoroutineContext coroutineContext, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        f2.f(coroutineContext, cancellationException);
    }

    public static /* synthetic */ void j(c2 c2Var, String str, Throwable th2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            th2 = null;
        }
        f2.g(c2Var, str, th2);
    }

    public static /* synthetic */ boolean k(CoroutineContext coroutineContext, Throwable th2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            th2 = null;
        }
        return h(coroutineContext, th2);
    }

    @yt.l
    public static final Object l(@yt.k c2 c2Var, @yt.k kotlin.coroutines.c<? super kotlin.z1> cVar) {
        c2.a.b(c2Var, null, 1, null);
        Object objT = c2Var.T(cVar);
        return objT == yj.b.h() ? objT : kotlin.z1.f38230a;
    }

    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void n(CoroutineContext coroutineContext, Throwable th2) throws Throwable {
        c2 c2Var = (c2) coroutineContext.c(c2.f38296x2);
        if (c2Var == null) {
            return;
        }
        for (c2 c2Var2 : c2Var.getChildren()) {
            JobSupport jobSupport = c2Var2 instanceof JobSupport ? (JobSupport) c2Var2 : null;
            if (jobSupport != null) {
                jobSupport.j0(B(th2, c2Var));
            }
        }
    }

    public static final void o(@yt.k CoroutineContext coroutineContext, @yt.l CancellationException cancellationException) {
        kotlin.sequences.m<c2> children;
        c2 c2Var = (c2) coroutineContext.c(c2.f38296x2);
        if (c2Var == null || (children = c2Var.getChildren()) == null) {
            return;
        }
        Iterator<c2> it2 = children.iterator();
        while (it2.hasNext()) {
            it2.next().h(cancellationException);
        }
    }

    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final /* synthetic */ void q(c2 c2Var, Throwable th2) throws Throwable {
        for (c2 c2Var2 : c2Var.getChildren()) {
            JobSupport jobSupport = c2Var2 instanceof JobSupport ? (JobSupport) c2Var2 : null;
            if (jobSupport != null) {
                jobSupport.j0(B(th2, c2Var));
            }
        }
    }

    public static final void r(@yt.k c2 c2Var, @yt.l CancellationException cancellationException) {
        Iterator<c2> it2 = c2Var.getChildren().iterator();
        while (it2.hasNext()) {
            it2.next().h(cancellationException);
        }
    }

    public static /* synthetic */ void s(CoroutineContext coroutineContext, Throwable th2, int i10, Object obj) throws Throwable {
        if ((i10 & 1) != 0) {
            th2 = null;
        }
        n(coroutineContext, th2);
    }

    public static /* synthetic */ void t(CoroutineContext coroutineContext, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        f2.o(coroutineContext, cancellationException);
    }

    public static /* synthetic */ void u(c2 c2Var, Throwable th2, int i10, Object obj) throws Throwable {
        if ((i10 & 1) != 0) {
            th2 = null;
        }
        q(c2Var, th2);
    }

    public static /* synthetic */ void v(c2 c2Var, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        f2.r(c2Var, cancellationException);
    }

    @yt.k
    public static final g1 w(@yt.k c2 c2Var, @yt.k g1 g1Var) {
        return c2Var.L1(new i1(g1Var));
    }

    public static final void x(@yt.k CoroutineContext coroutineContext) {
        c2 c2Var = (c2) coroutineContext.c(c2.f38296x2);
        if (c2Var != null) {
            f2.A(c2Var);
        }
    }

    public static final void y(@yt.k c2 c2Var) {
        if (!c2Var.isActive()) {
            throw c2Var.Z();
        }
    }

    @yt.k
    public static final c2 z(@yt.k CoroutineContext coroutineContext) {
        c2 c2Var = (c2) coroutineContext.c(c2.f38296x2);
        if (c2Var != null) {
            return c2Var;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
    }
}
