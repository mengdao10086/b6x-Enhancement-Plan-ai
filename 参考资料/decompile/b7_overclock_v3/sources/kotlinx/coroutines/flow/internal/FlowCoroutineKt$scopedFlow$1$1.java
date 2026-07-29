package kotlinx.coroutines.flow.internal;

import ik.p;
import ik.q;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.flow.internal.FlowCoroutineKt$scopedFlow$1$1", f = "FlowCoroutine.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
public final class FlowCoroutineKt$scopedFlow$1$1 extends SuspendLambda implements p<o0, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ q<o0, kotlinx.coroutines.flow.f<? super R>, kotlin.coroutines.c<? super z1>, Object> $block;
    public final /* synthetic */ kotlinx.coroutines.flow.f<R> $this_unsafeFlow;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowCoroutineKt$scopedFlow$1$1(q<? super o0, ? super kotlinx.coroutines.flow.f<? super R>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar, kotlinx.coroutines.flow.f<? super R> fVar, kotlin.coroutines.c<? super FlowCoroutineKt$scopedFlow$1$1> cVar) {
        super(2, cVar);
        this.$block = qVar;
        this.$this_unsafeFlow = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        FlowCoroutineKt$scopedFlow$1$1 flowCoroutineKt$scopedFlow$1$1 = new FlowCoroutineKt$scopedFlow$1$1(this.$block, this.$this_unsafeFlow, cVar);
        flowCoroutineKt$scopedFlow$1$1.L$0 = obj;
        return flowCoroutineKt$scopedFlow$1$1;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            u0.n(obj);
            o0 o0Var = (o0) this.L$0;
            q<o0, kotlinx.coroutines.flow.f<? super R>, kotlin.coroutines.c<? super z1>, Object> qVar = this.$block;
            Object obj2 = this.$this_unsafeFlow;
            this.label = 1;
            if (qVar.A(o0Var, obj2, this) == objH) {
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
    public final Object r0(@yt.k o0 o0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((FlowCoroutineKt$scopedFlow$1$1) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
