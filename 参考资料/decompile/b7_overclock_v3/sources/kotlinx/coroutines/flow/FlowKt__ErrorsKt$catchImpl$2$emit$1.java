package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2", f = "Errors.kt", i = {0}, l = {158}, m = "emit", n = {"this"}, s = {"L$0"})
public final class FlowKt__ErrorsKt$catchImpl$2$emit$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ FlowKt__ErrorsKt$catchImpl$2<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ErrorsKt$catchImpl$2$emit$1(FlowKt__ErrorsKt$catchImpl$2<? super T> flowKt__ErrorsKt$catchImpl$2, kotlin.coroutines.c<? super FlowKt__ErrorsKt$catchImpl$2$emit$1> cVar) {
        super(cVar);
        this.this$0 = flowKt__ErrorsKt$catchImpl$2;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.c to kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1 for r1v1 'this'  kotlin.coroutines.c
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final java.lang.Object q0(@yt.k java.lang.Object r2) {
        /*
            r1 = this;
            r1.result = r2
            int r2 = r1.label
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 | r0
            r1.label = r2
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2<T> r2 = r1.this$0
            r0 = 0
            java.lang.Object r2 = r2.f(r0, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1.q0(java.lang.Object):java.lang.Object");
    }
}
