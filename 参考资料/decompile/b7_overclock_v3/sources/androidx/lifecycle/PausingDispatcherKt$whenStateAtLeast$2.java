package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.z1;
import kotlinx.coroutines.c2;
import v7.a;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes2.dex */
@zj.d(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.kt", i = {0}, l = {a.c.f52773i}, m = "invokeSuspend", n = {"controller"}, s = {"L$0"})
public final class PausingDispatcherKt$whenStateAtLeast$2<T> extends SuspendLambda implements ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super T>, Object> {
    public final /* synthetic */ ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super T>, Object> $block;
    public final /* synthetic */ Lifecycle.State $minState;
    public final /* synthetic */ Lifecycle $this_whenStateAtLeast;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PausingDispatcherKt$whenStateAtLeast$2(Lifecycle lifecycle, Lifecycle.State state, ik.p<? super kotlinx.coroutines.o0, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, kotlin.coroutines.c<? super PausingDispatcherKt$whenStateAtLeast$2> cVar) {
        super(2, cVar);
        this.$this_whenStateAtLeast = lifecycle;
        this.$minState = state;
        this.$block = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        PausingDispatcherKt$whenStateAtLeast$2 pausingDispatcherKt$whenStateAtLeast$2 = new PausingDispatcherKt$whenStateAtLeast$2(this.$this_whenStateAtLeast, this.$minState, this.$block, cVar);
        pausingDispatcherKt$whenStateAtLeast$2.L$0 = obj;
        return pausingDispatcherKt$whenStateAtLeast$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        t tVar;
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            tVar = (t) this.L$0;
            try {
                kotlin.u0.n(obj);
                tVar.b();
                return obj;
            } catch (Throwable th2) {
                th = th2;
                tVar.b();
                throw th;
            }
        }
        kotlin.u0.n(obj);
        c2 c2Var = (c2) ((kotlinx.coroutines.o0) this.L$0).W().c(c2.f38296x2);
        if (c2Var == null) {
            throw new IllegalStateException("when[State] methods should have a parent job".toString());
        }
        m0 m0Var = new m0();
        t tVar2 = new t(this.$this_whenStateAtLeast, this.$minState, m0Var.f6215c, c2Var);
        try {
            ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super T>, Object> pVar = this.$block;
            this.L$0 = tVar2;
            this.label = 1;
            obj = kotlinx.coroutines.h.h(m0Var, pVar, this);
            if (obj == objH) {
                return objH;
            }
            tVar = tVar2;
            tVar.b();
            return obj;
        } catch (Throwable th3) {
            th = th3;
            tVar = tVar2;
            tVar.b();
            throw th;
        }
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k kotlinx.coroutines.o0 o0Var, @yt.l kotlin.coroutines.c<? super T> cVar) {
        return ((PausingDispatcherKt$whenStateAtLeast$2) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
