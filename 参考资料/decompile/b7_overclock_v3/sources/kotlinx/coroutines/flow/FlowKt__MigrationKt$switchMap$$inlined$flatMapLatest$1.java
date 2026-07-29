package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.t0;
import kotlin.u0;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [R, T] */
/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1\n*L\n1#1,218:1\n*E\n"})
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1", f = "Migration.kt", i = {}, l = {s0.c.f49294u, s0.c.f49294u}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1<R, T> extends SuspendLambda implements ik.q<f<? super R>, T, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ ik.p $transform;
    private /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(ik.p pVar, kotlin.coroutines.c cVar) {
        super(3, cVar);
        this.$transform = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        f fVar;
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            u0.n(obj);
            fVar = (f) this.L$0;
            Object obj2 = this.L$1;
            ik.p pVar = this.$transform;
            this.L$0 = fVar;
            this.label = 1;
            obj = pVar.r0(obj2, this);
            if (obj == objH) {
                return objH;
            }
        } else {
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u0.n(obj);
                return z1.f38230a;
            }
            fVar = (f) this.L$0;
            u0.n(obj);
        }
        this.L$0 = null;
        this.label = 2;
        if (g.m0(fVar, (e) obj, this) == objH) {
            return objH;
        }
        return z1.f38230a;
    }

    @Override // ik.q
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object A(@yt.k f<? super R> fVar, T t10, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1 flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1 = new FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(this.$transform, cVar);
        flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1.L$0 = fVar;
        flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1.L$1 = t10;
        return flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1.q0(z1.f38230a);
    }
}
