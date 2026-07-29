package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.u0;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNull$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChannelsKt__DeprecatedKt$filterNotNull$1<E> extends SuspendLambda implements ik.p<E, kotlin.coroutines.c<? super Boolean>, Object> {
    public /* synthetic */ Object L$0;
    public int label;

    public ChannelsKt__DeprecatedKt$filterNotNull$1(kotlin.coroutines.c<? super ChannelsKt__DeprecatedKt$filterNotNull$1> cVar) {
        super(2, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        ChannelsKt__DeprecatedKt$filterNotNull$1 channelsKt__DeprecatedKt$filterNotNull$1 = new ChannelsKt__DeprecatedKt$filterNotNull$1(cVar);
        channelsKt__DeprecatedKt$filterNotNull$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filterNotNull$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        yj.b.h();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        u0.n(obj);
        return zj.a.a(this.L$0 != null);
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.l E e10, @yt.l kotlin.coroutines.c<? super Boolean> cVar) {
        return ((ChannelsKt__DeprecatedKt$filterNotNull$1) M(e10, cVar)).q0(z1.f38230a);
    }
}
