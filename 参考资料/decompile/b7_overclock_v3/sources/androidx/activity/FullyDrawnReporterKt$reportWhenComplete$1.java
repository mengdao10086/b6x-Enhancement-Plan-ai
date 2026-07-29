package androidx.activity;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nFullyDrawnReporter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FullyDrawnReporter.kt\nandroidx/activity/FullyDrawnReporterKt$reportWhenComplete$1\n*L\n1#1,192:1\n*E\n"})
@zj.d(c = "androidx.activity.FullyDrawnReporterKt", f = "FullyDrawnReporter.kt", i = {0}, l = {188}, m = "reportWhenComplete", n = {"$this$reportWhenComplete"}, s = {"L$0"})
public final class FullyDrawnReporterKt$reportWhenComplete$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;

    public FullyDrawnReporterKt$reportWhenComplete$1(kotlin.coroutines.c<? super FullyDrawnReporterKt$reportWhenComplete$1> cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FullyDrawnReporterKt.a(null, null, this);
    }
}
