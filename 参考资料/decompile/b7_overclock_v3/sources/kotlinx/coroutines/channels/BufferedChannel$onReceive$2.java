package kotlinx.coroutines.channels;

import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes5.dex */
public /* synthetic */ class BufferedChannel$onReceive$2 extends FunctionReferenceImpl implements ik.q<BufferedChannel<?>, Object, Object, Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BufferedChannel$onReceive$2 f38323c = new BufferedChannel$onReceive$2();

    public BufferedChannel$onReceive$2() {
        super(3, BufferedChannel.class, "processResultSelectReceive", "processResultSelectReceive(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // ik.q
    @yt.l
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public final Object A(@yt.k BufferedChannel<?> bufferedChannel, @yt.l Object obj, @yt.l Object obj2) {
        return bufferedChannel.V0(obj, obj2);
    }
}
