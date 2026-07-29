package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.u0;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$onErrorReturn$2", f = "Migration.kt", i = {}, l = {306}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__MigrationKt$onErrorReturn$2<T> extends SuspendLambda implements ik.q<f<? super T>, Throwable, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ T $fallback;
    public final /* synthetic */ ik.l<Throwable, Boolean> $predicate;
    private /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__MigrationKt$onErrorReturn$2(ik.l<? super Throwable, Boolean> lVar, T t10, kotlin.coroutines.c<? super FlowKt__MigrationKt$onErrorReturn$2> cVar) {
        super(3, cVar);
        this.$predicate = lVar;
        this.$fallback = t10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            u0.n(obj);
            f fVar = (f) this.L$0;
            Throwable th2 = (Throwable) this.L$1;
            if (!this.$predicate.i(th2).booleanValue()) {
                throw th2;
            }
            T t10 = this.$fallback;
            this.L$0 = null;
            this.label = 1;
            if (fVar.f(t10, this) == objH) {
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

    @Override // ik.q
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object A(@yt.k f<? super T> fVar, @yt.k Throwable th2, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        FlowKt__MigrationKt$onErrorReturn$2 flowKt__MigrationKt$onErrorReturn$2 = new FlowKt__MigrationKt$onErrorReturn$2(this.$predicate, this.$fallback, cVar);
        flowKt__MigrationKt$onErrorReturn$2.L$0 = fVar;
        flowKt__MigrationKt$onErrorReturn$2.L$1 = th2;
        return flowKt__MigrationKt$onErrorReturn$2.q0(z1.f38230a);
    }
}
