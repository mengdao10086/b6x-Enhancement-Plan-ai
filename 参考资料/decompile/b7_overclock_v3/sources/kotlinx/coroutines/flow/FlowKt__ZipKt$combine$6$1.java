package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combine$6$1\n*L\n1#1,332:1\n*E\n"})
public final class FlowKt__ZipKt$combine$6$1<T> extends Lambda implements ik.a<T[]> {
    public final /* synthetic */ e<T>[] $flowArray;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combine$6$1(e<T>[] eVarArr) {
        super(0);
        this.$flowArray = eVarArr;
    }

    @Override // ik.a
    @yt.l
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final T[] o() {
        int length = this.$flowArray.length;
        f0.y(0, "T?");
        return (T[]) new Object[length];
    }
}
