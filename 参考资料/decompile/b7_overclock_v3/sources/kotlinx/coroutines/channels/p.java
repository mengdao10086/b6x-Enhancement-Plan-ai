package kotlinx.coroutines.channels;

import kotlin.coroutines.CoroutineContext;
import kotlin.z1;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes5.dex */
public final class p<E> extends h<E> implements q<E> {
    public p(@yt.k CoroutineContext coroutineContext, @yt.k g<E> gVar) {
        super(coroutineContext, gVar, true, true);
    }

    @Override // kotlinx.coroutines.a
    public void G1(@yt.k Throwable th2, boolean z10) {
        if (J1().C(th2) || z10) {
            return;
        }
        l0.b(b(), th2);
    }

    @Override // kotlinx.coroutines.a
    /* JADX INFO: renamed from: K1, reason: merged with bridge method [inline-methods] */
    public void H1(@yt.k z1 z1Var) {
        s.a.a(J1(), null, 1, null);
    }

    @Override // kotlinx.coroutines.channels.q
    public /* bridge */ /* synthetic */ s i() {
        return i();
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.JobSupport, kotlinx.coroutines.c2
    public boolean isActive() {
        return super.isActive();
    }
}
