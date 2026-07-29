package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1", f = "Zip.kt", i = {}, l = {33, 33}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__ZipKt$combine$1$1<R> extends SuspendLambda implements ik.q<f<? super R>, Object[], kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ ik.q<T1, T2, kotlin.coroutines.c<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combine$1$1(ik.q<? super T1, ? super T2, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar, kotlin.coroutines.c<? super FlowKt__ZipKt$combine$1$1> cVar) {
        super(3, cVar);
        this.$transform = qVar;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1<R> for r6v1 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final java.lang.Object q0(@yt.k java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = yj.b.h()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.u0.n(r7)
            goto L4c
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            java.lang.Object r1 = r6.L$0
            kotlinx.coroutines.flow.f r1 = (kotlinx.coroutines.flow.f) r1
            kotlin.u0.n(r7)
            goto L40
        L22:
            kotlin.u0.n(r7)
            java.lang.Object r7 = r6.L$0
            r1 = r7
            kotlinx.coroutines.flow.f r1 = (kotlinx.coroutines.flow.f) r1
            java.lang.Object r7 = r6.L$1
            java.lang.Object[] r7 = (java.lang.Object[]) r7
            ik.q<T1, T2, kotlin.coroutines.c<? super R>, java.lang.Object> r4 = r6.$transform
            r5 = 0
            r5 = r7[r5]
            r7 = r7[r3]
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = r4.A(r5, r7, r6)
            if (r7 != r0) goto L40
            return r0
        L40:
            r3 = 0
            r6.L$0 = r3
            r6.label = r2
            java.lang.Object r7 = r1.f(r7, r6)
            if (r7 != r0) goto L4c
            return r0
        L4c:
            kotlin.z1 r7 = kotlin.z1.f38230a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.q
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object A(@yt.k f<? super R> fVar, @yt.k Object[] objArr, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        FlowKt__ZipKt$combine$1$1 flowKt__ZipKt$combine$1$1 = new FlowKt__ZipKt$combine$1$1(this.$transform, cVar);
        flowKt__ZipKt$combine$1$1.L$0 = fVar;
        flowKt__ZipKt$combine$1$1.L$1 = objArr;
        return flowKt__ZipKt$combine$1$1.q0(z1.f38230a);
    }
}
