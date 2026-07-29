package kotlinx.coroutines.channels;

import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
public /* synthetic */ class LazyActorCoroutine$onSend$1 extends FunctionReferenceImpl implements ik.q<LazyActorCoroutine<?>, kotlinx.coroutines.selects.j<?>, Object, z1> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LazyActorCoroutine$onSend$1 f38361c = new LazyActorCoroutine$onSend$1();

    public LazyActorCoroutine$onSend$1() {
        super(3, LazyActorCoroutine.class, "onSendRegFunction", "onSendRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // ik.q
    public /* bridge */ /* synthetic */ z1 A(LazyActorCoroutine<?> lazyActorCoroutine, kotlinx.coroutines.selects.j<?> jVar, Object obj) throws Throwable {
        X0(lazyActorCoroutine, jVar, obj);
        return z1.f38230a;
    }

    public final void X0(@yt.k LazyActorCoroutine<?> lazyActorCoroutine, @yt.k kotlinx.coroutines.selects.j<?> jVar, @yt.l Object obj) throws Throwable {
        lazyActorCoroutine.N1(jVar, obj);
    }
}
