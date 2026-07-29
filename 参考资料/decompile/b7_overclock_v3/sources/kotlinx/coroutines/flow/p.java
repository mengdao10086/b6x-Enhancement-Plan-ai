package kotlinx.coroutines.flow;

import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharedFlow.kt\nkotlinx/coroutines/flow/SharedFlowSlot\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,731:1\n1#2:732\n*E\n"})
public final class p extends kotlinx.coroutines.flow.internal.c<SharedFlowImpl<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    public long f38731a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    @yt.l
    public kotlin.coroutines.c<? super z1> f38732b;

    @Override // kotlinx.coroutines.flow.internal.c
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@yt.k SharedFlowImpl<?> sharedFlowImpl) {
        if (this.f38731a >= 0) {
            return false;
        }
        this.f38731a = sharedFlowImpl.d0();
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    @yt.k
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public kotlin.coroutines.c<z1>[] b(@yt.k SharedFlowImpl<?> sharedFlowImpl) {
        long j10 = this.f38731a;
        this.f38731a = -1L;
        this.f38732b = null;
        return sharedFlowImpl.c0(j10);
    }
}
