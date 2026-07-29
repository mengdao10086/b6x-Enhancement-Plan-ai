package kotlinx.coroutines.selects;

import ik.p;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.z1;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.selects.SelectBuilderImpl$getResult$1", f = "SelectOld.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
public final class SelectBuilderImpl$getResult$1 extends SuspendLambda implements p<o0, kotlin.coroutines.c<? super z1>, Object> {
    public int label;
    public final /* synthetic */ SelectBuilderImpl<R> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectBuilderImpl$getResult$1(SelectBuilderImpl<R> selectBuilderImpl, kotlin.coroutines.c<? super SelectBuilderImpl$getResult$1> cVar) {
        super(2, cVar);
        this.this$0 = selectBuilderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        return new SelectBuilderImpl$getResult$1(this.this$0, cVar);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.c to kotlinx.coroutines.selects.SelectBuilderImpl$getResult$1 for r3v1 'this'  kotlin.coroutines.c
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final java.lang.Object q0(@yt.k java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = yj.b.h()
            int r1 = r3.label
            r2 = 1
            if (r1 == 0) goto L19
            if (r1 != r2) goto L11
            kotlin.u0.n(r4)     // Catch: java.lang.Throwable -> Lf
            goto L27
        Lf:
            r4 = move-exception
            goto L33
        L11:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L19:
            kotlin.u0.n(r4)
            kotlinx.coroutines.selects.SelectBuilderImpl<R> r4 = r3.this$0     // Catch: java.lang.Throwable -> Lf
            r3.label = r2     // Catch: java.lang.Throwable -> Lf
            java.lang.Object r4 = r4.R(r3)     // Catch: java.lang.Throwable -> Lf
            if (r4 != r0) goto L27
            return r0
        L27:
            kotlinx.coroutines.selects.SelectBuilderImpl<R> r0 = r3.this$0
            kotlinx.coroutines.p r0 = kotlinx.coroutines.selects.SelectBuilderImpl.l0(r0)
            kotlinx.coroutines.selects.l.a(r0, r4)
            kotlin.z1 r4 = kotlin.z1.f38230a
            return r4
        L33:
            kotlinx.coroutines.selects.SelectBuilderImpl<R> r0 = r3.this$0
            kotlinx.coroutines.p r0 = kotlinx.coroutines.selects.SelectBuilderImpl.l0(r0)
            kotlinx.coroutines.selects.l.b(r0, r4)
            kotlin.z1 r4 = kotlin.z1.f38230a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectBuilderImpl$getResult$1.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k o0 o0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((SelectBuilderImpl$getResult$1) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
