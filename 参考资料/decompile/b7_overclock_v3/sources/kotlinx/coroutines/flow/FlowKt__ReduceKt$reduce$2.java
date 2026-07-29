package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowKt__ReduceKt$reduce$2<T> implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Object> f38580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ik.q<S, T, kotlin.coroutines.c<? super S>, Object> f38581b;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ReduceKt$reduce$2(Ref.ObjectRef<Object> objectRef, ik.q<? super S, ? super T, ? super kotlin.coroutines.c<? super S>, ? extends Object> qVar) {
        this.f38580a = objectRef;
        this.f38581b = qVar;
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
    public final java.lang.Object f(T r7, @yt.k kotlin.coroutines.c<? super kotlin.z1> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2$emit$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2$emit$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.L$0
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            kotlin.u0.n(r8)
            goto L50
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.u0.n(r8)
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r8 = r6.f38580a
            T r2 = r8.element
            kotlinx.coroutines.internal.o0 r4 = kotlinx.coroutines.flow.internal.l.f38719a
            if (r2 == r4) goto L53
            ik.q<S, T, kotlin.coroutines.c<? super S>, java.lang.Object> r4 = r6.f38581b
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r7 = r4.A(r2, r7, r0)
            if (r7 != r1) goto L4d
            return r1
        L4d:
            r5 = r8
            r8 = r7
            r7 = r5
        L50:
            r5 = r8
            r8 = r7
            r7 = r5
        L53:
            r8.element = r7
            kotlin.z1 r7 = kotlin.z1.f38230a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2.f(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }
}
