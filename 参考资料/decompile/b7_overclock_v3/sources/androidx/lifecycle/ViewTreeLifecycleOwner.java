package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.runtime.R;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* JADX INFO: loaded from: classes2.dex */
@hk.h(name = "ViewTreeLifecycleOwner")
public final class ViewTreeLifecycleOwner {
    @hk.h(name = "get")
    @yt.l
    public static final y a(@yt.k View view) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        return (y) SequencesKt___SequencesKt.F0(SequencesKt___SequencesKt.p1(SequencesKt__SequencesKt.n(view, new ik.l<View, View>() { // from class: androidx.lifecycle.ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1
            @Override // ik.l
            @yt.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final View i(@yt.k View currentView) {
                kotlin.jvm.internal.f0.p(currentView, "currentView");
                Object parent = currentView.getParent();
                if (parent instanceof View) {
                    return (View) parent;
                }
                return null;
            }
        }), new ik.l<View, y>() { // from class: androidx.lifecycle.ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2
            @Override // ik.l
            @yt.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final y i(@yt.k View viewParent) {
                kotlin.jvm.internal.f0.p(viewParent, "viewParent");
                Object tag = viewParent.getTag(R.id.view_tree_lifecycle_owner);
                if (tag instanceof y) {
                    return (y) tag;
                }
                return null;
            }
        }));
    }

    @hk.h(name = "set")
    public static final void b(@yt.k View view, @yt.l y yVar) {
        kotlin.jvm.internal.f0.p(view, "<this>");
        view.setTag(R.id.view_tree_lifecycle_owner, yVar);
    }
}
