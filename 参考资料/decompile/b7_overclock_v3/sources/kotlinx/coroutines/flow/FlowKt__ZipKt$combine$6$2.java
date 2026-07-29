package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.u0;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [R, T] */
/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combine$6$2\n*L\n1#1,332:1\n*E\n"})
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$6$2", f = "Zip.kt", i = {}, l = {292, 292}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__ZipKt$combine$6$2<R, T> extends SuspendLambda implements ik.q<f<? super R>, T[], kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ ik.p<T[], kotlin.coroutines.c<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combine$6$2(ik.p<? super T[], ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar, kotlin.coroutines.c<? super FlowKt__ZipKt$combine$6$2> cVar) {
        super(3, cVar);
        this.$transform = pVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @yt.l
    public final Object F0(@yt.k Object obj) {
        f fVar = (f) this.L$0;
        Object objR0 = this.$transform.r0((Object[]) this.L$1, this);
        c0.e(0);
        fVar.f(objR0, this);
        c0.e(1);
        return z1.f38230a;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
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
        f fVar;
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            u0.n(obj);
            f fVar2 = (f) this.L$0;
            Object[] objArr = (Object[]) this.L$1;
            ik.p<T[], kotlin.coroutines.c<? super R>, Object> pVar = this.$transform;
            this.L$0 = fVar2;
            this.label = 1;
            obj = pVar.r0(objArr, this);
            fVar = fVar2;
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
            f fVar3 = (f) this.L$0;
            u0.n(obj);
            fVar = fVar3;
        }
        this.L$0 = null;
        this.label = 2;
        if (fVar.f(obj, this) == objH) {
            return objH;
        }
        return z1.f38230a;
    }

    @Override // ik.q
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object A(@yt.k f<? super R> fVar, @yt.k T[] tArr, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        f0.w();
        FlowKt__ZipKt$combine$6$2 flowKt__ZipKt$combine$6$2 = new FlowKt__ZipKt$combine$6$2(this.$transform, cVar);
        flowKt__ZipKt$combine$6$2.L$0 = fVar;
        flowKt__ZipKt$combine$6$2.L$1 = tArr;
        return flowKt__ZipKt$combine$6$2.q0(z1.f38230a);
    }
}
