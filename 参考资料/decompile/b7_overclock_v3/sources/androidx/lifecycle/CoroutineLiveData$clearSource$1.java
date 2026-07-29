package androidx.lifecycle;

import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes2.dex */
@zj.d(c = "androidx.lifecycle.CoroutineLiveData", f = "CoroutineLiveData.kt", i = {0}, l = {235}, m = "clearSource$lifecycle_livedata_ktx_release", n = {"this"}, s = {"L$0"})
public final class CoroutineLiveData$clearSource$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ CoroutineLiveData<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineLiveData$clearSource$1(CoroutineLiveData<T> coroutineLiveData, kotlin.coroutines.c<? super CoroutineLiveData$clearSource$1> cVar) {
        super(cVar);
        this.this$0 = coroutineLiveData;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.c to androidx.lifecycle.CoroutineLiveData$clearSource$1 for r1v1 'this'  kotlin.coroutines.c
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
            androidx.lifecycle.CoroutineLiveData<T> r2 = r1.this$0
            java.lang.Object r2 = r2.v(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.CoroutineLiveData$clearSource$1.q0(java.lang.Object):java.lang.Object");
    }
}
