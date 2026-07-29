package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public final class g implements kotlinx.coroutines.o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final CoroutineContext f38800a;

    public g(@yt.k CoroutineContext coroutineContext) {
        this.f38800a = coroutineContext;
    }

    @Override // kotlinx.coroutines.o0
    @yt.k
    public CoroutineContext W() {
        return this.f38800a;
    }

    @yt.k
    public String toString() {
        return "CoroutineScope(coroutineContext=" + W() + ')';
    }
}
