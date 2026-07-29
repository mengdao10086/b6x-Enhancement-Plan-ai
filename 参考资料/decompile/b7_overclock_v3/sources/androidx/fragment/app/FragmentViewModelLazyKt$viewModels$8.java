package androidx.fragment.app;

import androidx.lifecycle.d1;
import androidx.lifecycle.z0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/lifecycle/x0;", "VM", "Landroidx/lifecycle/z0$b;", "b", "()Landroidx/lifecycle/z0$b;"}, k = 3, mv = {1, 6, 0})
public final class FragmentViewModelLazyKt$viewModels$8 extends Lambda implements ik.a<z0.b> {
    public final /* synthetic */ kotlin.z<d1> $owner$delegate;
    public final /* synthetic */ Fragment $this_viewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FragmentViewModelLazyKt$viewModels$8(Fragment fragment, kotlin.z<? extends d1> zVar) {
        super(0);
        this.$this_viewModels = fragment;
        this.$owner$delegate = zVar;
    }

    @Override // ik.a
    @yt.k
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final z0.b o() {
        z0.b bVarH0;
        d1 d1VarP = FragmentViewModelLazyKt.p(this.$owner$delegate);
        androidx.lifecycle.r rVar = d1VarP instanceof androidx.lifecycle.r ? (androidx.lifecycle.r) d1VarP : null;
        if (rVar == null || (bVarH0 = rVar.h0()) == null) {
            bVarH0 = this.$this_viewModels.h0();
        }
        kotlin.jvm.internal.f0.o(bVarH0, "(owner as? HasDefaultVie…tViewModelProviderFactory");
        return bVarH0;
    }
}
