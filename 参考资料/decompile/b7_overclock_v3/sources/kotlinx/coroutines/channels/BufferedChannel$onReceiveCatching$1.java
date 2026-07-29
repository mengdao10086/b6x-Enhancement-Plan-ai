package kotlinx.coroutines.channels;

import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
public /* synthetic */ class BufferedChannel$onReceiveCatching$1 extends FunctionReferenceImpl implements ik.q<BufferedChannel<?>, kotlinx.coroutines.selects.j<?>, Object, z1> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BufferedChannel$onReceiveCatching$1 f38324c = new BufferedChannel$onReceiveCatching$1();

    public BufferedChannel$onReceiveCatching$1() {
        super(3, BufferedChannel.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // ik.q
    public /* bridge */ /* synthetic */ z1 A(BufferedChannel<?> bufferedChannel, kotlinx.coroutines.selects.j<?> jVar, Object obj) {
        X0(bufferedChannel, jVar, obj);
        return z1.f38230a;
    }

    public final void X0(@yt.k BufferedChannel<?> bufferedChannel, @yt.k kotlinx.coroutines.selects.j<?> jVar, @yt.l Object obj) {
        bufferedChannel.g1(jVar, obj);
    }
}
