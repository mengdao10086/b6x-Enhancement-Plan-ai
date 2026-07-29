package retrofit2;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.d0;

/* JADX INFO: loaded from: classes6.dex */
@zj.d(c = "retrofit2.KotlinExtensions", f = "KotlinExtensions.kt", i = {0}, l = {113}, m = "suspendAndThrow", n = {"$this$suspendAndThrow"}, s = {"L$0"})
@d0(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00060\u0000j\u0002`\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0080@"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/coroutines/c;", "", "continuation", "", "suspendAndThrow"}, k = 3, mv = {1, 4, 0})
public final class KotlinExtensions$suspendAndThrow$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public KotlinExtensions$suspendAndThrow$1(kotlin.coroutines.c cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return KotlinExtensions.e(null, this);
    }
}
