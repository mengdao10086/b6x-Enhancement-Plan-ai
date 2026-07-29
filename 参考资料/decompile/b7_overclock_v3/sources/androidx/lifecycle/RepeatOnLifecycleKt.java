package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
public final class RepeatOnLifecycleKt {
    @yt.l
    public static final Object a(@yt.k Lifecycle lifecycle, @yt.k Lifecycle.State state, @yt.k ik.p<? super kotlinx.coroutines.o0, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        if (!(state != Lifecycle.State.INITIALIZED)) {
            throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.".toString());
        }
        if (lifecycle.b() == Lifecycle.State.DESTROYED) {
            return z1.f38230a;
        }
        Object objG = kotlinx.coroutines.p0.g(new RepeatOnLifecycleKt$repeatOnLifecycle$3(lifecycle, state, pVar, null), cVar);
        return objG == yj.b.h() ? objG : z1.f38230a;
    }

    @yt.l
    public static final Object b(@yt.k y yVar, @yt.k Lifecycle.State state, @yt.k ik.p<? super kotlinx.coroutines.o0, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        Object objA = a(yVar.e(), state, pVar, cVar);
        return objA == yj.b.h() ? objA : z1.f38230a;
    }
}
