package androidx.savedstate;

import android.view.View;
import hk.h;
import kotlin.jvm.internal.f0;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
@h(name = "ViewTreeSavedStateRegistryOwner")
public final class ViewTreeSavedStateRegistryOwner {
    @h(name = "get")
    @l
    public static final d a(@k View view) {
        f0.p(view, "<this>");
        return (d) SequencesKt___SequencesKt.F0(SequencesKt___SequencesKt.p1(SequencesKt__SequencesKt.n(view, new ik.l<View, View>() { // from class: androidx.savedstate.ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$1
            @Override // ik.l
            @l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final View i(@k View view2) {
                f0.p(view2, "view");
                Object parent = view2.getParent();
                if (parent instanceof View) {
                    return (View) parent;
                }
                return null;
            }
        }), new ik.l<View, d>() { // from class: androidx.savedstate.ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2
            @Override // ik.l
            @l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final d i(@k View view2) {
                f0.p(view2, "view");
                Object tag = view2.getTag(R.id.view_tree_saved_state_registry_owner);
                if (tag instanceof d) {
                    return (d) tag;
                }
                return null;
            }
        }));
    }

    @h(name = "set")
    public static final void b(@k View view, @l d dVar) {
        f0.p(view, "<this>");
        view.setTag(R.id.view_tree_saved_state_registry_owner, dVar);
    }
}
