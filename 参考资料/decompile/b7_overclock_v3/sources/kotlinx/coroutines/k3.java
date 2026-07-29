package kotlinx.coroutines;

import kotlin.Pair;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nCoroutineContext.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContext.kt\nkotlinx/coroutines/UndispatchedCoroutine\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,311:1\n1#2:312\n107#3,13:313\n*S KotlinDebug\n*F\n+ 1 CoroutineContext.kt\nkotlinx/coroutines/UndispatchedCoroutine\n*L\n269#1:313,13\n*E\n"})
public final class k3<T> extends kotlinx.coroutines.internal.k0<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final ThreadLocal<Pair<CoroutineContext, Object>> f38894e;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public k3(@yt.k CoroutineContext coroutineContext, @yt.k kotlin.coroutines.c<? super T> cVar) {
        l3 l3Var = l3.f38907a;
        super(coroutineContext.c(l3Var) == null ? coroutineContext.L(l3Var) : coroutineContext, cVar);
        this.f38894e = new ThreadLocal<>();
        if (cVar.b().c(kotlin.coroutines.d.f37759u2) instanceof CoroutineDispatcher) {
            return;
        }
        Object objC = ThreadContextKt.c(coroutineContext, null);
        ThreadContextKt.a(coroutineContext, objC);
        K1(coroutineContext, objC);
    }

    @Override // kotlinx.coroutines.internal.k0, kotlinx.coroutines.a
    public void E1(@yt.l Object obj) {
        if (this.threadLocalIsSet) {
            Pair<CoroutineContext, Object> pair = this.f38894e.get();
            if (pair != null) {
                ThreadContextKt.a(pair.a(), pair.b());
            }
            this.f38894e.remove();
        }
        Object objA = h0.a(obj, this.f38808d);
        kotlin.coroutines.c<T> cVar = this.f38808d;
        CoroutineContext coroutineContextB = cVar.b();
        Object objC = ThreadContextKt.c(coroutineContextB, null);
        k3<?> k3VarG = objC != ThreadContextKt.f38768a ? CoroutineContextKt.g(cVar, coroutineContextB, objC) : null;
        try {
            this.f38808d.x(objA);
            kotlin.z1 z1Var = kotlin.z1.f38230a;
        } finally {
            if (k3VarG == null || k3VarG.J1()) {
                ThreadContextKt.a(coroutineContextB, objC);
            }
        }
    }

    public final boolean J1() {
        boolean z10 = this.threadLocalIsSet && this.f38894e.get() == null;
        this.f38894e.remove();
        return !z10;
    }

    public final void K1(@yt.k CoroutineContext coroutineContext, @yt.l Object obj) {
        this.threadLocalIsSet = true;
        this.f38894e.set(kotlin.d1.a(coroutineContext, obj));
    }
}
