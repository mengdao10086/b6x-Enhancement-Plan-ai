package androidx.lifecycle;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes2.dex */
public final class m0 extends CoroutineDispatcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @hk.e
    @yt.k
    public final l f6215c = new l();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void h2(@yt.k CoroutineContext context, @yt.k Runnable block) {
        kotlin.jvm.internal.f0.p(context, "context");
        kotlin.jvm.internal.f0.p(block, "block");
        this.f6215c.c(context, block);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean j2(@yt.k CoroutineContext context) {
        kotlin.jvm.internal.f0.p(context, "context");
        if (kotlinx.coroutines.d1.e().o2().j2(context)) {
            return true;
        }
        return !this.f6215c.b();
    }
}
