package androidx.room;

import java.util.concurrent.Callable;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* JADX INFO: loaded from: classes2.dex */
@zj.d(c = "androidx.room.CoroutinesRoom$Companion$execute$4$job$1", f = "CoroutinesRoom.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@kotlin.d0(bv = {}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"R", "Lkotlinx/coroutines/o0;", "Lkotlin/z1;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class CoroutinesRoom$Companion$execute$4$job$1 extends SuspendLambda implements ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super kotlin.z1>, Object> {
    public final /* synthetic */ Callable<R> $callable;
    public final /* synthetic */ kotlinx.coroutines.o<R> $continuation;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CoroutinesRoom$Companion$execute$4$job$1(Callable<R> callable, kotlinx.coroutines.o<? super R> oVar, kotlin.coroutines.c<? super CoroutinesRoom$Companion$execute$4$job$1> cVar) {
        super(2, cVar);
        this.$callable = callable;
        this.$continuation = oVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<kotlin.z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        return new CoroutinesRoom$Companion$execute$4$job$1(this.$callable, this.$continuation, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        yj.b.h();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.u0.n(obj);
        try {
            Object objCall = this.$callable.call();
            kotlin.coroutines.c cVar = this.$continuation;
            Result.a aVar = Result.f37633a;
            cVar.x(Result.b(objCall));
        } catch (Throwable th2) {
            kotlin.coroutines.c cVar2 = this.$continuation;
            Result.a aVar2 = Result.f37633a;
            cVar2.x(Result.b(kotlin.u0.a(th2)));
        }
        return kotlin.z1.f38230a;
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k kotlinx.coroutines.o0 o0Var, @yt.l kotlin.coroutines.c<? super kotlin.z1> cVar) {
        return ((CoroutinesRoom$Companion$execute$4$job$1) M(o0Var, cVar)).q0(kotlin.z1.f38230a);
    }
}
