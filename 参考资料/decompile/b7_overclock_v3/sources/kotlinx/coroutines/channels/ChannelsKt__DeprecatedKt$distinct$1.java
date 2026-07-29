package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.u0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinct$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChannelsKt__DeprecatedKt$distinct$1 extends SuspendLambda implements ik.p<Object, kotlin.coroutines.c<Object>, Object> {
    public /* synthetic */ Object L$0;
    public int label;

    public ChannelsKt__DeprecatedKt$distinct$1(kotlin.coroutines.c<? super ChannelsKt__DeprecatedKt$distinct$1> cVar) {
        super(2, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        ChannelsKt__DeprecatedKt$distinct$1 channelsKt__DeprecatedKt$distinct$1 = new ChannelsKt__DeprecatedKt$distinct$1(cVar);
        channelsKt__DeprecatedKt$distinct$1.L$0 = obj;
        return channelsKt__DeprecatedKt$distinct$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        yj.b.h();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        u0.n(obj);
        return this.L$0;
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(Object obj, @yt.l kotlin.coroutines.c<Object> cVar) {
        return ((ChannelsKt__DeprecatedKt$distinct$1) M(obj, cVar)).q0(z1.f38230a);
    }
}
