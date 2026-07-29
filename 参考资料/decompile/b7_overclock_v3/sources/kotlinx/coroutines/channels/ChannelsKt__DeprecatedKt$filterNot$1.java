package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.u0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNot$1", f = "Deprecated.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {})
public final class ChannelsKt__DeprecatedKt$filterNot$1 extends SuspendLambda implements ik.p<Object, kotlin.coroutines.c<? super Boolean>, Object> {
    public final /* synthetic */ ik.p<Object, kotlin.coroutines.c<? super Boolean>, Object> $predicate;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelsKt__DeprecatedKt$filterNot$1(ik.p<Object, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar, kotlin.coroutines.c<? super ChannelsKt__DeprecatedKt$filterNot$1> cVar) {
        super(2, cVar);
        this.$predicate = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        ChannelsKt__DeprecatedKt$filterNot$1 channelsKt__DeprecatedKt$filterNot$1 = new ChannelsKt__DeprecatedKt$filterNot$1(this.$predicate, cVar);
        channelsKt__DeprecatedKt$filterNot$1.L$0 = obj;
        return channelsKt__DeprecatedKt$filterNot$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            u0.n(obj);
            Object obj2 = this.L$0;
            ik.p<Object, kotlin.coroutines.c<? super Boolean>, Object> pVar = this.$predicate;
            this.label = 1;
            obj = pVar.r0(obj2, this);
            if (obj == objH) {
                return objH;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u0.n(obj);
        }
        return zj.a.a(!((Boolean) obj).booleanValue());
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(Object obj, @yt.l kotlin.coroutines.c<? super Boolean> cVar) {
        return ((ChannelsKt__DeprecatedKt$filterNot$1) M(obj, cVar)).q0(z1.f38230a);
    }
}
