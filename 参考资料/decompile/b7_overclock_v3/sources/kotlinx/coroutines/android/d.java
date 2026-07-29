package kotlinx.coroutines.android;

import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.u;
import kotlin.z1;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.m2;
import kotlinx.coroutines.w0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
public abstract class d extends m2 implements w0 {
    public d() {
    }

    public /* synthetic */ d(u uVar) {
        this();
    }

    @k
    public g1 h1(long j10, @k Runnable runnable, @k CoroutineContext coroutineContext) {
        return w0.a.b(this, j10, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.w0
    @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @l
    public Object m1(long j10, @k kotlin.coroutines.c<? super z1> cVar) {
        return w0.a.a(this, j10, cVar);
    }

    @k
    public abstract d o2();
}
