package kotlinx.coroutines.channels;

import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes5.dex */
public /* synthetic */ class BufferedChannel$onReceiveCatching$2 extends FunctionReferenceImpl implements ik.q<BufferedChannel<?>, Object, Object, Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BufferedChannel$onReceiveCatching$2 f38325c = new BufferedChannel$onReceiveCatching$2();

    public BufferedChannel$onReceiveCatching$2() {
        super(3, BufferedChannel.class, "processResultSelectReceiveCatching", "processResultSelectReceiveCatching(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // ik.q
    @yt.l
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public final Object A(@yt.k BufferedChannel<?> bufferedChannel, @yt.l Object obj, @yt.l Object obj2) {
        return bufferedChannel.W0(obj, obj2);
    }
}
