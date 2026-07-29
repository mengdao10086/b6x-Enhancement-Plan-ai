package kotlinx.coroutines.channels;

import kotlinx.coroutines.internal.l0;
import kotlinx.coroutines.m3;

/* JADX INFO: loaded from: classes5.dex */
public final class r<E> implements m3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    @yt.k
    public final kotlinx.coroutines.p<j<? extends E>> f38388a;

    /* JADX WARN: Multi-variable type inference failed */
    public r(@yt.k kotlinx.coroutines.p<? super j<? extends E>> pVar) {
        this.f38388a = pVar;
    }

    @Override // kotlinx.coroutines.m3
    public void g(@yt.k l0<?> l0Var, int i10) {
        this.f38388a.g(l0Var, i10);
    }
}
