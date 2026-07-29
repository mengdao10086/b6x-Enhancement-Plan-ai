package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$delayFlow$1", f = "Migration.kt", i = {}, l = {415}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__MigrationKt$delayFlow$1<T> extends SuspendLambda implements ik.p<f<? super T>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ long $timeMillis;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__MigrationKt$delayFlow$1(long j10, kotlin.coroutines.c<? super FlowKt__MigrationKt$delayFlow$1> cVar) {
        super(2, cVar);
        this.$timeMillis = j10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        return new FlowKt__MigrationKt$delayFlow$1(this.$timeMillis, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            u0.n(obj);
            long j10 = this.$timeMillis;
            this.label = 1;
            if (DelayKt.b(j10, this) == objH) {
                return objH;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u0.n(obj);
        }
        return z1.f38230a;
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k f<? super T> fVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((FlowKt__MigrationKt$delayFlow$1) M(fVar, cVar)).q0(z1.f38230a);
    }
}
