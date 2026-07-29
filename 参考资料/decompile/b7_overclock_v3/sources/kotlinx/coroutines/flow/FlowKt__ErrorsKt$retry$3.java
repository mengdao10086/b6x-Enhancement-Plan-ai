package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.u0;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", f = "Errors.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__ErrorsKt$retry$3<T> extends SuspendLambda implements ik.r<f<? super T>, Throwable, Long, kotlin.coroutines.c<? super Boolean>, Object> {
    public final /* synthetic */ ik.p<Throwable, kotlin.coroutines.c<? super Boolean>, Object> $predicate;
    public final /* synthetic */ long $retries;
    public /* synthetic */ long J$0;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ErrorsKt$retry$3(long j10, ik.p<? super Throwable, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar, kotlin.coroutines.c<? super FlowKt__ErrorsKt$retry$3> cVar) {
        super(4, cVar);
        this.$retries = j10;
        this.$predicate = pVar;
    }

    @Override // ik.r
    public /* bridge */ /* synthetic */ Object N(Object obj, Throwable th2, Long l10, kotlin.coroutines.c<? super Boolean> cVar) {
        return x0((f) obj, th2, l10.longValue(), cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            u0.n(obj);
            Throwable th2 = (Throwable) this.L$0;
            if (this.J$0 < this.$retries) {
                ik.p<Throwable, kotlin.coroutines.c<? super Boolean>, Object> pVar = this.$predicate;
                this.label = 1;
                obj = pVar.r0(th2, this);
                if (obj == objH) {
                    return objH;
                }
            }
            return zj.a.a(z);
        }
        if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        u0.n(obj);
        boolean z10 = ((Boolean) obj).booleanValue();
        return zj.a.a(z10);
    }

    @yt.l
    public final Object x0(@yt.k f<? super T> fVar, @yt.k Throwable th2, long j10, @yt.l kotlin.coroutines.c<? super Boolean> cVar) {
        FlowKt__ErrorsKt$retry$3 flowKt__ErrorsKt$retry$3 = new FlowKt__ErrorsKt$retry$3(this.$retries, this.$predicate, cVar);
        flowKt__ErrorsKt$retry$3.L$0 = th2;
        flowKt__ErrorsKt$retry$3.J$0 = j10;
        return flowKt__ErrorsKt$retry$3.q0(z1.f38230a);
    }
}
