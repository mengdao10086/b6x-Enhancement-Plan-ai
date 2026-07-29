package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.viewmodel.R;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* JADX INFO: loaded from: classes2.dex */
@hk.h(name = "ViewTreeViewModelStoreOwner")
public final class ViewTreeViewModelStoreOwner {
    @hk.h(name = "get")
    @yt.l
    public static final d1 a(@yt.k View view) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        return (d1) SequencesKt___SequencesKt.F0(SequencesKt___SequencesKt.p1(SequencesKt__SequencesKt.n(view, new ik.l<View, View>() { // from class: androidx.lifecycle.ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$1
            @Override // ik.l
            @yt.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final View i(@yt.k View view2) {
                kotlin.jvm.internal.f0.p(view2, "view");
                Object parent = view2.getParent();
                if (parent instanceof View) {
                    return (View) parent;
                }
                return null;
            }
        }), new ik.l<View, d1>() { // from class: androidx.lifecycle.ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2
            @Override // ik.l
            @yt.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final d1 i(@yt.k View view2) {
                kotlin.jvm.internal.f0.p(view2, "view");
                Object tag = view2.getTag(R.id.view_tree_view_model_store_owner);
                if (tag instanceof d1) {
                    return (d1) tag;
                }
                return null;
            }
        }));
    }

    @hk.h(name = "set")
    public static final void b(@yt.k View view, @yt.l d1 d1Var) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        view.setTag(R.id.view_tree_view_model_store_owner, d1Var);
    }
}
