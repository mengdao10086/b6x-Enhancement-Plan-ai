package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes5.dex */
public final class q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    @yt.k
    public final e<T> f38733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    public final int f38734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @hk.e
    @yt.k
    public final BufferOverflow f38735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @hk.e
    @yt.k
    public final CoroutineContext f38736d;

    /* JADX WARN: Multi-variable type inference failed */
    public q(@yt.k e<? extends T> eVar, int i10, @yt.k BufferOverflow bufferOverflow, @yt.k CoroutineContext coroutineContext) {
        this.f38733a = eVar;
        this.f38734b = i10;
        this.f38735c = bufferOverflow;
        this.f38736d = coroutineContext;
    }
}
