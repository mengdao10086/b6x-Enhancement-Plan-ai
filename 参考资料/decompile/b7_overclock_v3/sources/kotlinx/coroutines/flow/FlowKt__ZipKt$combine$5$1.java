package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combine$5$1\n*L\n1#1,332:1\n*E\n"})
public final class FlowKt__ZipKt$combine$5$1<T> extends Lambda implements ik.a<T[]> {
    public final /* synthetic */ e<T>[] $flows;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combine$5$1(e<? extends T>[] eVarArr) {
        super(0);
        this.$flows = eVarArr;
    }

    @Override // ik.a
    @yt.l
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final T[] o() {
        int length = this.$flows.length;
        f0.y(0, "T?");
        return (T[]) new Object[length];
    }
}
