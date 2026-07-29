package kotlinx.coroutines.channels;

import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
public /* synthetic */ class BufferedChannel$onSend$1 extends FunctionReferenceImpl implements ik.q<BufferedChannel<?>, kotlinx.coroutines.selects.j<?>, Object, z1> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BufferedChannel$onSend$1 f38328c = new BufferedChannel$onSend$1();

    public BufferedChannel$onSend$1() {
        super(3, BufferedChannel.class, "registerSelectForSend", "registerSelectForSend(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // ik.q
    public /* bridge */ /* synthetic */ z1 A(BufferedChannel<?> bufferedChannel, kotlinx.coroutines.selects.j<?> jVar, Object obj) throws IllegalAccessException, InvocationTargetException {
        X0(bufferedChannel, jVar, obj);
        return z1.f38230a;
    }

    public final void X0(@yt.k BufferedChannel<?> bufferedChannel, @yt.k kotlinx.coroutines.selects.j<?> jVar, @yt.l Object obj) throws IllegalAccessException, InvocationTargetException {
        bufferedChannel.h1(jVar, obj);
    }
}
