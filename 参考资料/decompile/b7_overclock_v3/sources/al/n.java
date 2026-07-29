package al;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.r;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.y1;

/* JADX INFO: loaded from: classes5.dex */
public final class n extends CoroutineDispatcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final n f759c = new n();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void h2(@yt.k CoroutineContext coroutineContext, @yt.k Runnable runnable) {
        b.f727i.o2(runnable, m.f758j, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @y1
    public void i2(@yt.k CoroutineContext coroutineContext, @yt.k Runnable runnable) {
        b.f727i.o2(runnable, m.f758j, true);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @s1
    @yt.k
    public CoroutineDispatcher k2(int i10) {
        r.a(i10);
        return i10 >= m.f752d ? this : super.k2(i10);
    }
}
