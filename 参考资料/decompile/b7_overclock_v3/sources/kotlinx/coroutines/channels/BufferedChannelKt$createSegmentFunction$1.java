package kotlinx.coroutines.channels;

import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: classes5.dex */
public /* synthetic */ class BufferedChannelKt$createSegmentFunction$1<E> extends FunctionReferenceImpl implements ik.p<Long, k<E>, k<E>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BufferedChannelKt$createSegmentFunction$1 f38358c = new BufferedChannelKt$createSegmentFunction$1();

    public BufferedChannelKt$createSegmentFunction$1() {
        super(2, BufferedChannelKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
    }

    @yt.k
    public final k<E> X0(long j10, @yt.k k<E> kVar) {
        return BufferedChannelKt.x(j10, kVar);
    }

    @Override // ik.p
    public /* bridge */ /* synthetic */ Object r0(Long l10, Object obj) {
        return X0(l10.longValue(), (k) obj);
    }
}
