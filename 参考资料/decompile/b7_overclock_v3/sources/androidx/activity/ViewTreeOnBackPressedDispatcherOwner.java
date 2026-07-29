package androidx.activity;

import android.view.View;
import kotlin.jvm.internal.f0;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* JADX INFO: loaded from: classes2.dex */
@hk.h(name = "ViewTreeOnBackPressedDispatcherOwner")
public final class ViewTreeOnBackPressedDispatcherOwner {
    @hk.h(name = "get")
    @yt.l
    public static final q a(@yt.k View view) {
        f0.p(view, "<this>");
        return (q) SequencesKt___SequencesKt.F0(SequencesKt___SequencesKt.p1(SequencesKt__SequencesKt.n(view, new ik.l<View, View>() { // from class: androidx.activity.ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$1
            @Override // ik.l
            @yt.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final View i(@yt.k View it2) {
                f0.p(it2, "it");
                Object parent = it2.getParent();
                if (parent instanceof View) {
                    return (View) parent;
                }
                return null;
            }
        }), new ik.l<View, q>() { // from class: androidx.activity.ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2
            @Override // ik.l
            @yt.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final q i(@yt.k View it2) {
                f0.p(it2, "it");
                Object tag = it2.getTag(R.id.view_tree_on_back_pressed_dispatcher_owner);
                if (tag instanceof q) {
                    return (q) tag;
                }
                return null;
            }
        }));
    }

    @hk.h(name = "set")
    public static final void b(@yt.k View view, @yt.k q onBackPressedDispatcherOwner) {
        f0.p(view, "<this>");
        f0.p(onBackPressedDispatcherOwner, "onBackPressedDispatcherOwner");
        view.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, onBackPressedDispatcherOwner);
    }
}
