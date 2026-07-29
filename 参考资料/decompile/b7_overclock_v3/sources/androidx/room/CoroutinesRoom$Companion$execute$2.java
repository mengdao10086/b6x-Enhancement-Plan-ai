package androidx.room;

import java.util.concurrent.Callable;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes2.dex */
@zj.d(c = "androidx.room.CoroutinesRoom$Companion$execute$2", f = "CoroutinesRoom.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@kotlin.d0(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00018\u00008\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"R", "Lkotlinx/coroutines/o0;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class CoroutinesRoom$Companion$execute$2<R> extends SuspendLambda implements ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super R>, Object> {
    public final /* synthetic */ Callable<R> $callable;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesRoom$Companion$execute$2(Callable<R> callable, kotlin.coroutines.c<? super CoroutinesRoom$Companion$execute$2> cVar) {
        super(2, cVar);
        this.$callable = callable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<kotlin.z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        return new CoroutinesRoom$Companion$execute$2(this.$callable, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        yj.b.h();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        kotlin.u0.n(obj);
        return this.$callable.call();
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k kotlinx.coroutines.o0 o0Var, @yt.l kotlin.coroutines.c<? super R> cVar) {
        return ((CoroutinesRoom$Companion$execute$2) M(o0Var, cVar)).q0(kotlin.z1.f38230a);
    }
}
