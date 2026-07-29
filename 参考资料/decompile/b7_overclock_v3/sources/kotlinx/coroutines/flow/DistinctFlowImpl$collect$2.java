package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
public final class DistinctFlowImpl$collect$2<T> implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DistinctFlowImpl<T> f38485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Object> f38486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f<T> f38487c;

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl$collect$2(DistinctFlowImpl<T> distinctFlowImpl, Ref.ObjectRef<Object> objectRef, f<? super T> fVar) {
        this.f38485a = distinctFlowImpl;
        this.f38486b = objectRef;
        this.f38487c = fVar;
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
    public final java.lang.Object f(T r6, @yt.k kotlin.coroutines.c<? super kotlin.z1> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1 r0 = (kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1 r0 = new kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.u0.n(r7)
            goto L67
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            kotlin.u0.n(r7)
            kotlinx.coroutines.flow.DistinctFlowImpl<T> r7 = r5.f38485a
            ik.l<T, java.lang.Object> r7 = r7.f38483b
            java.lang.Object r7 = r7.i(r6)
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r2 = r5.f38486b
            T r2 = r2.element
            kotlinx.coroutines.internal.o0 r4 = kotlinx.coroutines.flow.internal.l.f38719a
            if (r2 == r4) goto L58
            kotlinx.coroutines.flow.DistinctFlowImpl<T> r4 = r5.f38485a
            ik.p<java.lang.Object, java.lang.Object, java.lang.Boolean> r4 = r4.f38484c
            java.lang.Object r2 = r4.r0(r2, r7)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L55
            goto L58
        L55:
            kotlin.z1 r6 = kotlin.z1.f38230a
            return r6
        L58:
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r2 = r5.f38486b
            r2.element = r7
            kotlinx.coroutines.flow.f<T> r7 = r5.f38487c
            r0.label = r3
            java.lang.Object r6 = r7.f(r6, r0)
            if (r6 != r1) goto L67
            return r1
        L67:
            kotlin.z1 r6 = kotlin.z1.f38230a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.DistinctFlowImpl$collect$2.f(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }
}
