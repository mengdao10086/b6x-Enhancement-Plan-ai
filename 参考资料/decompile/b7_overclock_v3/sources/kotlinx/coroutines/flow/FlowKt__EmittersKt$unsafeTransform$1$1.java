package kotlinx.coroutines.flow;

import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n*L\n1#1,222:1\n*E\n"})
public final class FlowKt__EmittersKt$unsafeTransform$1$1<T> implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ik.q<f<? super R>, T, kotlin.coroutines.c<? super z1>, Object> f38526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f<R> f38527b;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__EmittersKt$unsafeTransform$1$1(ik.q<? super f<? super R>, ? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar, f<? super R> fVar) {
        this.f38526a = qVar;
        this.f38527b = fVar;
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
    @yt.l
    public final Object a(T t10, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        c0.e(4);
        new FlowKt__EmittersKt$unsafeTransform$1$1$emit$1(this, cVar);
        c0.e(5);
        this.f38526a.A(this.f38527b, t10, cVar);
        return z1.f38230a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
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
    @Override // kotlinx.coroutines.flow.f
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(T r5, @yt.k kotlin.coroutines.c<? super kotlin.z1> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$1$1$emit$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$1$1$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$1$1$emit$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.u0.n(r6)
            goto L41
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.u0.n(r6)
            ik.q<kotlinx.coroutines.flow.f<? super R>, T, kotlin.coroutines.c<? super kotlin.z1>, java.lang.Object> r6 = r4.f38526a
            kotlinx.coroutines.flow.f<R> r2 = r4.f38527b
            r0.label = r3
            java.lang.Object r5 = r6.A(r2, r5, r0)
            if (r5 != r1) goto L41
            return r1
        L41:
            kotlin.z1 r5 = kotlin.z1.f38230a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$unsafeTransform$1$1.f(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }
}
