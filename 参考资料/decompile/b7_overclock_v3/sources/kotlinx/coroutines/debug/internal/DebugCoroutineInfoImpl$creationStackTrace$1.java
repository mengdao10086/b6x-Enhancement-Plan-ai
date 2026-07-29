package kotlinx.coroutines.debug.internal;

import ik.p;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.sequences.o;
import kotlin.u0;
import kotlin.z1;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$creationStackTrace$1", f = "DebugCoroutineInfoImpl.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, s = {})
public final class DebugCoroutineInfoImpl$creationStackTrace$1 extends RestrictedSuspendLambda implements p<o<? super StackTraceElement>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ i $bottom;
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ DebugCoroutineInfoImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugCoroutineInfoImpl$creationStackTrace$1(DebugCoroutineInfoImpl debugCoroutineInfoImpl, i iVar, kotlin.coroutines.c<? super DebugCoroutineInfoImpl$creationStackTrace$1> cVar) {
        super(2, cVar);
        this.this$0 = debugCoroutineInfoImpl;
        this.$bottom = iVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final kotlin.coroutines.c<z1> M(@l Object obj, @k kotlin.coroutines.c<?> cVar) {
        DebugCoroutineInfoImpl$creationStackTrace$1 debugCoroutineInfoImpl$creationStackTrace$1 = new DebugCoroutineInfoImpl$creationStackTrace$1(this.this$0, this.$bottom, cVar);
        debugCoroutineInfoImpl$creationStackTrace$1.L$0 = obj;
        return debugCoroutineInfoImpl$creationStackTrace$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object q0(@k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            u0.n(obj);
            o oVar = (o) this.L$0;
            DebugCoroutineInfoImpl debugCoroutineInfoImpl = this.this$0;
            zj.c cVarR = this.$bottom.r();
            this.label = 1;
            if (debugCoroutineInfoImpl.k(oVar, cVarR, this) == objH) {
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
    @l
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@k o<? super StackTraceElement> oVar, @l kotlin.coroutines.c<? super z1> cVar) {
        return ((DebugCoroutineInfoImpl$creationStackTrace$1) M(oVar, cVar)).q0(z1.f38230a);
    }
}
