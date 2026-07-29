package kotlinx.coroutines.sync;

import ik.p;
import kotlin.jvm.internal.FunctionReferenceImpl;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
public /* synthetic */ class SemaphoreImpl$addAcquireToQueue$createNewSegment$1 extends FunctionReferenceImpl implements p<Long, c, c> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SemaphoreImpl$addAcquireToQueue$createNewSegment$1 f39061c = new SemaphoreImpl$addAcquireToQueue$createNewSegment$1();

    public SemaphoreImpl$addAcquireToQueue$createNewSegment$1() {
        super(2, SemaphoreKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
    }

    @k
    public final c X0(long j10, @l c cVar) {
        return SemaphoreKt.j(j10, cVar);
    }

    @Override // ik.p
    public /* bridge */ /* synthetic */ c r0(Long l10, c cVar) {
        return X0(l10.longValue(), cVar);
    }
}
