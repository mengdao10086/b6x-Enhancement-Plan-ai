package kotlinx.coroutines.channels;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
public final class o<E> extends f<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final kotlin.coroutines.c<z1> f38387e;

    public o(@yt.k CoroutineContext coroutineContext, @yt.k d<E> dVar, @yt.k ik.p<? super q<? super E>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        super(coroutineContext, dVar, false);
        this.f38387e = IntrinsicsKt__IntrinsicsJvmKt.c(pVar, this, this);
    }

    @Override // kotlinx.coroutines.channels.f, kotlinx.coroutines.channels.d
    @yt.k
    public ReceiveChannel<E> E() {
        ReceiveChannel<E> receiveChannelE = J1().E();
        start();
        return receiveChannelE;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void k1() throws Throwable {
        zk.a.e(this.f38387e, this);
    }
}
