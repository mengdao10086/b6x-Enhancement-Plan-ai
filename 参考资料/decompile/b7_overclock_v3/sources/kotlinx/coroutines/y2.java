package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public class y2 extends a<kotlin.z1> {
    public y2(@yt.k CoroutineContext coroutineContext, boolean z10) {
        super(coroutineContext, true, z10);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean L0(@yt.k Throwable th2) {
        l0.b(b(), th2);
        return true;
    }
}
