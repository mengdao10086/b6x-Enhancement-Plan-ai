package kotlinx.coroutines.channels;

import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.w0;
import kotlin.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
public final class LazyActorCoroutine<E> extends a<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public kotlin.coroutines.c<? super z1> f38360e;

    public LazyActorCoroutine(@yt.k CoroutineContext coroutineContext, @yt.k g<E> gVar, @yt.k ik.p<? super c<E>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        super(coroutineContext, gVar, false);
        this.f38360e = IntrinsicsKt__IntrinsicsJvmKt.c(pVar, this, this);
    }

    public static /* synthetic */ void M1() {
    }

    @Override // kotlinx.coroutines.channels.h, kotlinx.coroutines.channels.s
    public boolean C(@yt.l Throwable th2) {
        boolean zC = super.C(th2);
        start();
        return zC;
    }

    @Override // kotlinx.coroutines.channels.h, kotlinx.coroutines.channels.s
    @yt.k
    public Object F(E e10) {
        start();
        return super.F(e10);
    }

    @Override // kotlinx.coroutines.channels.h, kotlinx.coroutines.channels.s
    @yt.l
    public Object G(E e10, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        start();
        Object objG = super.G(e10, cVar);
        return objG == yj.b.h() ? objG : z1.f38230a;
    }

    public final void N1(kotlinx.coroutines.selects.j<?> jVar, Object obj) throws Throwable {
        k1();
        super.y().a().A(this, jVar, obj);
    }

    @Override // kotlinx.coroutines.JobSupport
    public void k1() throws Throwable {
        zk.a.e(this.f38360e, this);
    }

    @Override // kotlinx.coroutines.channels.h, kotlinx.coroutines.channels.s
    @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @t0(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e10) {
        start();
        return super.offer(e10);
    }

    @Override // kotlinx.coroutines.channels.h, kotlinx.coroutines.channels.s
    @yt.k
    public kotlinx.coroutines.selects.g<E, s<E>> y() {
        LazyActorCoroutine$onSend$1 lazyActorCoroutine$onSend$1 = LazyActorCoroutine$onSend$1.f38361c;
        f0.n(lazyActorCoroutine$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new kotlinx.coroutines.selects.h(this, (ik.q) w0.q(lazyActorCoroutine$onSend$1, 3), super.y().d(), null, 8, null);
    }
}
