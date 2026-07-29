package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowKt__TransformKt$runningReduce$1$1<T> implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Object> f38623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ik.q<T, T, kotlin.coroutines.c<? super T>, Object> f38624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f<T> f38625c;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__TransformKt$runningReduce$1$1(Ref.ObjectRef<Object> objectRef, ik.q<? super T, ? super T, ? super kotlin.coroutines.c<? super T>, ? extends Object> qVar, f<? super T> fVar) {
        this.f38623a = objectRef;
        this.f38624b = qVar;
        this.f38625c = fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0078 A[RETURN] */
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
    public final java.lang.Object f(T r8, @yt.k kotlin.coroutines.c<? super kotlin.z1> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1$emit$1
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1$emit$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.u0.n(r9)
            goto L79
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            java.lang.Object r8 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1 r2 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1) r2
            kotlin.u0.n(r9)
            goto L60
        L40:
            kotlin.u0.n(r9)
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r9 = r7.f38623a
            T r2 = r9.element
            kotlinx.coroutines.internal.o0 r5 = kotlinx.coroutines.flow.internal.l.f38719a
            if (r2 != r5) goto L4d
            r2 = r7
            goto L63
        L4d:
            ik.q<T, T, kotlin.coroutines.c<? super T>, java.lang.Object> r5 = r7.f38624b
            r0.L$0 = r7
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r8 = r5.A(r2, r8, r0)
            if (r8 != r1) goto L5c
            return r1
        L5c:
            r2 = r7
            r6 = r9
            r9 = r8
            r8 = r6
        L60:
            r6 = r9
            r9 = r8
            r8 = r6
        L63:
            r9.element = r8
            kotlinx.coroutines.flow.f<T> r8 = r2.f38625c
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r9 = r2.f38623a
            T r9 = r9.element
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r8 = r8.f(r9, r0)
            if (r8 != r1) goto L79
            return r1
        L79:
            kotlin.z1 r8 = kotlin.z1.f38230a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1.f(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }
}
