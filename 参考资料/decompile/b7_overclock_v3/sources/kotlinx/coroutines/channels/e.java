package kotlinx.coroutines.channels;

import kotlin.DeprecationLevel;
import kotlinx.coroutines.internal.o0;
import kotlinx.coroutines.r2;

/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final o0 f38364a = new o0("NO_ELEMENT");

    @kotlin.k(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and StateFlow, and is no longer supported")
    @r2
    @yt.k
    public static final <E> d<E> a(int i10) {
        if (i10 == -2) {
            return new BroadcastChannelImpl(g.f38366y2.a());
        }
        if (i10 == -1) {
            return new m();
        }
        if (i10 == 0) {
            throw new IllegalArgumentException("Unsupported 0 capacity for BroadcastChannel");
        }
        if (i10 != Integer.MAX_VALUE) {
            return new BroadcastChannelImpl(i10);
        }
        throw new IllegalArgumentException("Unsupported UNLIMITED capacity for BroadcastChannel");
    }
}
