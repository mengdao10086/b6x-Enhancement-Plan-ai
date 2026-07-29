package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [R, T] */
/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1\n*L\n1#1,218:1\n*E\n"})
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapLatest$1", f = "Merge.kt", i = {}, l = {s0.c.f49294u, s0.c.f49294u}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__MergeKt$flatMapLatest$1<R, T> extends SuspendLambda implements ik.q<f<? super R>, T, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ ik.p<T, kotlin.coroutines.c<? super e<? extends R>>, Object> $transform;
    private /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__MergeKt$flatMapLatest$1(ik.p<? super T, ? super kotlin.coroutines.c<? super e<? extends R>>, ? extends Object> pVar, kotlin.coroutines.c<? super FlowKt__MergeKt$flatMapLatest$1> cVar) {
        super(3, cVar);
        this.$transform = pVar;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapLatest$1<R, T> for r2v1 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @yt.l
    public final java.lang.Object F0(@yt.k java.lang.Object r3) {
        /*
            r2 = this;
            java.lang.Object r3 = r2.L$0
            kotlinx.coroutines.flow.f r3 = (kotlinx.coroutines.flow.f) r3
            java.lang.Object r0 = r2.L$1
            ik.p<T, kotlin.coroutines.c<? super kotlinx.coroutines.flow.e<? extends R>>, java.lang.Object> r1 = r2.$transform
            java.lang.Object r0 = r1.r0(r0, r2)
            kotlinx.coroutines.flow.e r0 = (kotlinx.coroutines.flow.e) r0
            r1 = 0
            kotlin.jvm.internal.c0.e(r1)
            kotlinx.coroutines.flow.g.m0(r3, r0, r2)
            r3 = 1
            kotlin.jvm.internal.c0.e(r3)
            kotlin.z1 r3 = kotlin.z1.f38230a
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapLatest$1.F0(java.lang.Object):java.lang.Object");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapLatest$1<R, T> for r5v1 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final java.lang.Object q0(@yt.k java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = yj.b.h()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.u0.n(r6)
            goto L47
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1a:
            java.lang.Object r1 = r5.L$0
            kotlinx.coroutines.flow.f r1 = (kotlinx.coroutines.flow.f) r1
            kotlin.u0.n(r6)
            goto L39
        L22:
            kotlin.u0.n(r6)
            java.lang.Object r6 = r5.L$0
            r1 = r6
            kotlinx.coroutines.flow.f r1 = (kotlinx.coroutines.flow.f) r1
            java.lang.Object r6 = r5.L$1
            ik.p<T, kotlin.coroutines.c<? super kotlinx.coroutines.flow.e<? extends R>>, java.lang.Object> r4 = r5.$transform
            r5.L$0 = r1
            r5.label = r3
            java.lang.Object r6 = r4.r0(r6, r5)
            if (r6 != r0) goto L39
            return r0
        L39:
            kotlinx.coroutines.flow.e r6 = (kotlinx.coroutines.flow.e) r6
            r3 = 0
            r5.L$0 = r3
            r5.label = r2
            java.lang.Object r6 = kotlinx.coroutines.flow.g.m0(r1, r6, r5)
            if (r6 != r0) goto L47
            return r0
        L47:
            kotlin.z1 r6 = kotlin.z1.f38230a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapLatest$1.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.q
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object A(@yt.k f<? super R> fVar, T t10, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        FlowKt__MergeKt$flatMapLatest$1 flowKt__MergeKt$flatMapLatest$1 = new FlowKt__MergeKt$flatMapLatest$1(this.$transform, cVar);
        flowKt__MergeKt$flatMapLatest$1.L$0 = fVar;
        flowKt__MergeKt$flatMapLatest$1.L$1 = t10;
        return flowKt__MergeKt$flatMapLatest$1.q0(z1.f38230a);
    }
}
