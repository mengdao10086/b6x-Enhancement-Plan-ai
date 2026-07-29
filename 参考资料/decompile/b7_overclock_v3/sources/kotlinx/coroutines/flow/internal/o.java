package kotlinx.coroutines.flow.internal;

import kotlin.jvm.internal.t0;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.u;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nAbstractSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,132:1\n28#2,4:133\n28#2,4:138\n20#3:137\n20#3:142\n*S KotlinDebug\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow\n*L\n126#1:133,4\n128#1:138,4\n126#1:137\n128#1:142\n*E\n"})
public final class o extends SharedFlowImpl<Integer> implements u<Integer> {
    public o(int i10) {
        super(1, Integer.MAX_VALUE, BufferOverflow.DROP_OLDEST);
        z(Integer.valueOf(i10));
    }

    @Override // kotlinx.coroutines.flow.u
    @yt.k
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public Integer getValue() {
        Integer numValueOf;
        synchronized (this) {
            numValueOf = Integer.valueOf(Q().intValue());
        }
        return numValueOf;
    }

    public final boolean f0(int i10) {
        boolean z10;
        synchronized (this) {
            z10 = z(Integer.valueOf(Q().intValue() + i10));
        }
        return z10;
    }
}
