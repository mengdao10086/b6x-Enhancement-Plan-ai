package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public interface c2 extends CoroutineContext.a {

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    @yt.k
    public static final b f38296x2 = b.f38297a;

    public static final class a {
        public static /* synthetic */ void b(c2 c2Var, CancellationException cancellationException, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                cancellationException = null;
            }
            c2Var.h(cancellationException);
        }

        public static /* synthetic */ boolean c(c2 c2Var, Throwable th2, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                th2 = null;
            }
            return c2Var.d(th2);
        }

        public static <R> R d(@yt.k c2 c2Var, R r10, @yt.k ik.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
            return (R) CoroutineContext.a.C0431a.a(c2Var, r10, pVar);
        }

        @yt.l
        public static <E extends CoroutineContext.a> E e(@yt.k c2 c2Var, @yt.k CoroutineContext.b<E> bVar) {
            return (E) CoroutineContext.a.C0431a.b(c2Var, bVar);
        }

        @s1
        public static /* synthetic */ void f() {
        }

        public static /* synthetic */ g1 g(c2 c2Var, boolean z10, boolean z11, ik.l lVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            if ((i10 & 2) != 0) {
                z11 = true;
            }
            return c2Var.F0(z10, z11, lVar);
        }

        @yt.k
        public static CoroutineContext h(@yt.k c2 c2Var, @yt.k CoroutineContext.b<?> bVar) {
            return CoroutineContext.a.C0431a.c(c2Var, bVar);
        }

        @yt.k
        public static CoroutineContext i(@yt.k c2 c2Var, @yt.k CoroutineContext coroutineContext) {
            return CoroutineContext.a.C0431a.d(c2Var, coroutineContext);
        }

        @kotlin.k(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @yt.k
        public static c2 j(@yt.k c2 c2Var, @yt.k c2 c2Var2) {
            return c2Var2;
        }
    }

    public static final class b implements CoroutineContext.b<c2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f38297a = new b();
    }

    @y1
    @yt.k
    g1 F0(boolean z10, boolean z11, @yt.k ik.l<? super Throwable, kotlin.z1> lVar);

    @yt.k
    g1 L1(@yt.k ik.l<? super Throwable, kotlin.z1> lVar);

    @yt.l
    Object T(@yt.k kotlin.coroutines.c<? super kotlin.z1> cVar);

    @y1
    @yt.k
    CancellationException Z();

    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ boolean d(Throwable th2);

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @yt.k
    c2 d1(@yt.k c2 c2Var);

    @y1
    @yt.k
    u f2(@yt.k w wVar);

    @yt.k
    kotlin.sequences.m<c2> getChildren();

    @yt.l
    c2 getParent();

    void h(@yt.l CancellationException cancellationException);

    boolean isActive();

    boolean isCancelled();

    boolean n();

    @yt.k
    kotlinx.coroutines.selects.c s1();

    boolean start();
}
