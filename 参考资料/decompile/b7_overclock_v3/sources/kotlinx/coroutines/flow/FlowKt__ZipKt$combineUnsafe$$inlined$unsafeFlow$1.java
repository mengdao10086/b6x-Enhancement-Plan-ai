package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,112:1\n262#2,2:113\n*E\n"})
public final class FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1<R> implements e<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e[] f38641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ik.p f38642b;

    public FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1(e[] eVarArr, ik.p pVar) {
        this.f38641a = eVarArr;
        this.f38642b = pVar;
    }

    @Override // kotlinx.coroutines.flow.e
    @yt.l
    public Object a(@yt.k f<? super R> fVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        e[] eVarArr = this.f38641a;
        ik.a aVarR = FlowKt__ZipKt.r();
        f0.w();
        Object objA = CombineKt.a(fVar, eVarArr, aVarR, new FlowKt__ZipKt$combineUnsafe$1$1(this.f38642b, null), cVar);
        return objA == yj.b.h() ? objA : z1.f38230a;
    }

    @yt.l
    public Object d(@yt.k f fVar, @yt.k kotlin.coroutines.c cVar) {
        c0.e(4);
        new ContinuationImpl(cVar) { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1.1
            public int label;
            public /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @yt.l
            public final Object q0(@yt.k Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1.this.a(null, this);
            }
        };
        c0.e(5);
        e[] eVarArr = this.f38641a;
        ik.a aVarR = FlowKt__ZipKt.r();
        f0.w();
        FlowKt__ZipKt$combineUnsafe$1$1 flowKt__ZipKt$combineUnsafe$1$1 = new FlowKt__ZipKt$combineUnsafe$1$1(this.f38642b, null);
        c0.e(0);
        CombineKt.a(fVar, eVarArr, aVarR, flowKt__ZipKt$combineUnsafe$1$1, cVar);
        c0.e(1);
        return z1.f38230a;
    }
}
