package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowKt__LimitKt$dropWhile$1$1<T> implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f38542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f<T> f38543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ik.p<T, kotlin.coroutines.c<? super Boolean>, Object> f38544c;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$dropWhile$1$1(Ref.BooleanRef booleanRef, f<? super T> fVar, ik.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar) {
        this.f38542a = booleanRef;
        this.f38543b = fVar;
        this.f38544c = pVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
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
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L45
            if (r2 == r5) goto L41
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            kotlin.u0.n(r8)
            goto L88
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            java.lang.Object r7 = r0.L$1
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1 r2 = (kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1) r2
            kotlin.u0.n(r8)
            goto L6c
        L41:
            kotlin.u0.n(r8)
            goto L59
        L45:
            kotlin.u0.n(r8)
            kotlin.jvm.internal.Ref$BooleanRef r8 = r6.f38542a
            boolean r8 = r8.element
            if (r8 == 0) goto L5c
            kotlinx.coroutines.flow.f<T> r8 = r6.f38543b
            r0.label = r5
            java.lang.Object r7 = r8.f(r7, r0)
            if (r7 != r1) goto L59
            return r1
        L59:
            kotlin.z1 r7 = kotlin.z1.f38230a
            return r7
        L5c:
            ik.p<T, kotlin.coroutines.c<? super java.lang.Boolean>, java.lang.Object> r8 = r6.f38544c
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r8.r0(r7, r0)
            if (r8 != r1) goto L6b
            return r1
        L6b:
            r2 = r6
        L6c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L8b
            kotlin.jvm.internal.Ref$BooleanRef r8 = r2.f38542a
            r8.element = r5
            kotlinx.coroutines.flow.f<T> r8 = r2.f38543b
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r7 = r8.f(r7, r0)
            if (r7 != r1) goto L88
            return r1
        L88:
            kotlin.z1 r7 = kotlin.z1.f38230a
            return r7
        L8b:
            kotlin.z1 r7 = kotlin.z1.f38230a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1.f(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }
}
