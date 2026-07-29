package androidx.fragment.app;

import androidx.lifecycle.d1;
import kotlin.jvm.internal.Lambda;
import p1.a;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/lifecycle/x0;", "VM", "Lp1/a;", "b", "()Lp1/a;"}, k = 3, mv = {1, 6, 0})
public final class FragmentViewModelLazyKt$viewModels$7 extends Lambda implements ik.a<p1.a> {
    public final /* synthetic */ ik.a<p1.a> $extrasProducer;
    public final /* synthetic */ kotlin.z<d1> $owner$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FragmentViewModelLazyKt$viewModels$7(ik.a<? extends p1.a> aVar, kotlin.z<? extends d1> zVar) {
        super(0);
        this.$extrasProducer = aVar;
        this.$owner$delegate = zVar;
    }

    @Override // ik.a
    @yt.k
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final p1.a o() {
        p1.a aVarO;
        ik.a<p1.a> aVar = this.$extrasProducer;
        if (aVar != null && (aVarO = aVar.o()) != null) {
            return aVarO;
        }
        d1 d1VarP = FragmentViewModelLazyKt.p(this.$owner$delegate);
        androidx.lifecycle.r rVar = d1VarP instanceof androidx.lifecycle.r ? (androidx.lifecycle.r) d1VarP : null;
        p1.a aVarJ0 = rVar != null ? rVar.j0() : null;
        return aVarJ0 == null ? a.C0519a.f46302b : aVarJ0;
    }
}
