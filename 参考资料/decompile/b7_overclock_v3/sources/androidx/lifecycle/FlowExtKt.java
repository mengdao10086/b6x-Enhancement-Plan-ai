package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes2.dex */
public final class FlowExtKt {
    @yt.k
    public static final <T> kotlinx.coroutines.flow.e<T> a(@yt.k kotlinx.coroutines.flow.e<? extends T> eVar, @yt.k Lifecycle lifecycle, @yt.k Lifecycle.State minActiveState) {
        kotlin.jvm.internal.f0.p(eVar, "<this>");
        kotlin.jvm.internal.f0.p(lifecycle, "lifecycle");
        kotlin.jvm.internal.f0.p(minActiveState, "minActiveState");
        return kotlinx.coroutines.flow.g.s(new FlowExtKt$flowWithLifecycle$1(lifecycle, minActiveState, eVar, null));
    }

    public static /* synthetic */ kotlinx.coroutines.flow.e b(kotlinx.coroutines.flow.e eVar, Lifecycle lifecycle, Lifecycle.State state, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            state = Lifecycle.State.STARTED;
        }
        return a(eVar, lifecycle, state);
    }
}
