package kotlinx.coroutines.future;

import ik.l;
import ik.p;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.f2;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p1;
import kotlinx.coroutines.u0;
import kotlinx.coroutines.x;
import kotlinx.coroutines.z;
import yt.k;
import zj.f;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nFuture.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Future.kt\nkotlinx/coroutines/future/FutureKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,197:1\n1#2:198\n314#3,11:199\n*S KotlinDebug\n*F\n+ 1 Future.kt\nkotlinx/coroutines/future/FutureKt\n*L\n172#1:199,11\n*E\n"})
public final class FutureKt {
    @k
    public static final <T> CompletableFuture<T> c(@k final u0<? extends T> u0Var) {
        final CompletableFuture<T> completableFuture = new CompletableFuture<>();
        j(u0Var, completableFuture);
        u0Var.L1(new l<Throwable, z1>() { // from class: kotlinx.coroutines.future.FutureKt$asCompletableFuture$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            public final void b(@yt.l Throwable th2) {
                try {
                    completableFuture.complete((T) u0Var.u());
                } catch (Throwable th3) {
                    completableFuture.completeExceptionally(th3);
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        });
        return completableFuture;
    }

    @k
    public static final CompletableFuture<z1> d(@k c2 c2Var) {
        final CompletableFuture<z1> completableFuture = new CompletableFuture<>();
        j(c2Var, completableFuture);
        c2Var.L1(new l<Throwable, z1>() { // from class: kotlinx.coroutines.future.FutureKt$asCompletableFuture$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(@yt.l Throwable th2) {
                if (th2 == null) {
                    completableFuture.complete(z1.f38230a);
                } else {
                    completableFuture.completeExceptionally(th2);
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        });
        return completableFuture;
    }

    @k
    public static final <T> u0<T> e(@k CompletionStage<T> completionStage) {
        Throwable cause;
        CompletableFuture<T> completableFuture = completionStage.toCompletableFuture();
        if (!completableFuture.isDone()) {
            final x xVarC = z.c(null, 1, null);
            final p<T, Throwable, Object> pVar = new p<T, Throwable, Object>() { // from class: kotlinx.coroutines.future.FutureKt$asDeferred$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // ik.p
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object r0(T t10, Throwable th2) {
                    boolean zL;
                    Throwable cause2;
                    try {
                        if (th2 == null) {
                            zL = xVarC.u1(t10);
                        } else {
                            x<T> xVar = xVarC;
                            CompletionException completionException = th2 instanceof CompletionException ? (CompletionException) th2 : null;
                            if (completionException != null && (cause2 = completionException.getCause()) != null) {
                                th2 = cause2;
                            }
                            zL = xVar.l(th2);
                        }
                        return Boolean.valueOf(zL);
                    } catch (Throwable th3) {
                        l0.b(EmptyCoroutineContext.f37755a, th3);
                        return z1.f38230a;
                    }
                }
            };
            completionStage.handle(new BiFunction() { // from class: kotlinx.coroutines.future.c
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return FutureKt.f(pVar, obj, (Throwable) obj2);
                }
            });
            f2.x(xVarC, completableFuture);
            return xVarC;
        }
        try {
            return z.a(completableFuture.get());
        } catch (Throwable th2) {
            th = th2;
            ExecutionException executionException = th instanceof ExecutionException ? (ExecutionException) th : null;
            if (executionException != null && (cause = executionException.getCause()) != null) {
                th = cause;
            }
            x xVarC2 = z.c(null, 1, null);
            xVarC2.l(th);
            return xVarC2;
        }
    }

    public static final Object f(p pVar, Object obj, Throwable th2) {
        return pVar.r0(obj, th2);
    }

    @yt.l
    public static final <T> Object g(@k CompletionStage<T> completionStage, @k kotlin.coroutines.c<? super T> cVar) throws Throwable {
        final CompletableFuture<T> completableFuture = completionStage.toCompletableFuture();
        if (completableFuture.isDone()) {
            try {
                return completableFuture.get();
            } catch (ExecutionException e10) {
                Throwable cause = e10.getCause();
                if (cause == null) {
                    throw e10;
                }
                throw cause;
            }
        }
        kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        pVar.Q();
        final b bVar = new b(pVar);
        completionStage.handle(bVar);
        pVar.B(new l<Throwable, z1>() { // from class: kotlinx.coroutines.future.FutureKt$await$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(@yt.l Throwable th2) {
                completableFuture.cancel(false);
                bVar.cont = null;
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        });
        Object objC = pVar.C();
        if (objC == yj.b.h()) {
            f.c(cVar);
        }
        return objC;
    }

    @k
    public static final <T> CompletableFuture<T> h(@k o0 o0Var, @k CoroutineContext coroutineContext, @k CoroutineStart coroutineStart, @k p<? super o0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar) {
        if (!(!coroutineStart.isLazy())) {
            throw new IllegalArgumentException((coroutineStart + " start is not supported").toString());
        }
        CoroutineContext coroutineContextE = CoroutineContextKt.e(o0Var, coroutineContext);
        CompletableFuture<T> completableFuture = new CompletableFuture<>();
        a aVar = new a(coroutineContextE, completableFuture);
        completableFuture.handle((BiFunction) aVar);
        aVar.I1(coroutineStart, aVar, pVar);
        return completableFuture;
    }

    public static /* synthetic */ CompletableFuture i(o0 o0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f37755a;
        }
        if ((i10 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return h(o0Var, coroutineContext, coroutineStart, pVar);
    }

    public static final void j(final c2 c2Var, CompletableFuture<?> completableFuture) {
        completableFuture.handle(new BiFunction() { // from class: kotlinx.coroutines.future.d
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return FutureKt.k(c2Var, obj, (Throwable) obj2);
            }
        });
    }

    public static final z1 k(c2 c2Var, Object obj, Throwable th2) {
        if (th2 != null) {
            cancellationExceptionA = th2 instanceof CancellationException ? (CancellationException) th2 : null;
            if (cancellationExceptionA == null) {
                cancellationExceptionA = p1.a("CompletableFuture was completed exceptionally", th2);
            }
        }
        c2Var.h(cancellationExceptionA);
        return z1.f38230a;
    }
}
