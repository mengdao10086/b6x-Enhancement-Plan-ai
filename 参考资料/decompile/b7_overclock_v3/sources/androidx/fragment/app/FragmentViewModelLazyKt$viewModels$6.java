package androidx.fragment.app;

import androidx.lifecycle.c1;
import androidx.lifecycle.d1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/lifecycle/x0;", "VM", "Landroidx/lifecycle/c1;", "b", "()Landroidx/lifecycle/c1;"}, k = 3, mv = {1, 6, 0})
public final class FragmentViewModelLazyKt$viewModels$6 extends Lambda implements ik.a<c1> {
    public final /* synthetic */ kotlin.z<d1> $owner$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FragmentViewModelLazyKt$viewModels$6(kotlin.z<? extends d1> zVar) {
        super(0);
        this.$owner$delegate = zVar;
    }

    @Override // ik.a
    @yt.k
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final c1 o() {
        c1 c1VarO0 = FragmentViewModelLazyKt.p(this.$owner$delegate).O0();
        kotlin.jvm.internal.f0.o(c1VarO0, "owner.viewModelStore");
        return c1VarO0;
    }
}
