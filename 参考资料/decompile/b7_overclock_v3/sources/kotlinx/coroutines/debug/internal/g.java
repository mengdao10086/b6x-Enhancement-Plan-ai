package kotlinx.coroutines.debug.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
public final class g<T> extends WeakReference<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    public final int f38457a;

    public g(T t10, @l ReferenceQueue<T> referenceQueue) {
        super(t10, referenceQueue);
        this.f38457a = t10 != null ? t10.hashCode() : 0;
    }
}
