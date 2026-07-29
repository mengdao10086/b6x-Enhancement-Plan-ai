package kotlinx.coroutines.channels;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$sendBlocking$1", f = "Channels.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
public final class ChannelsKt__ChannelsKt$sendBlocking$1 extends SuspendLambda implements ik.p<o0, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ Object $element;
    public final /* synthetic */ s<Object> $this_sendBlocking;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__ChannelsKt$sendBlocking$1(s<Object> sVar, Object obj, kotlin.coroutines.c<? super ChannelsKt__ChannelsKt$sendBlocking$1> cVar) {
        super(2, cVar);
        this.$this_sendBlocking = sVar;
        this.$element = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        return new ChannelsKt__ChannelsKt$sendBlocking$1(this.$this_sendBlocking, this.$element, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            u0.n(obj);
            s<Object> sVar = this.$this_sendBlocking;
            Object obj2 = this.$element;
            this.label = 1;
            if (sVar.G(obj2, this) == objH) {
                return objH;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u0.n(obj);
        }
        return z1.f38230a;
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k o0 o0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((ChannelsKt__ChannelsKt$sendBlocking$1) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
