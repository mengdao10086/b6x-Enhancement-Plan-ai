package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.u0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$2", f = "SharingStarted.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class StartedWhileSubscribed$command$2 extends SuspendLambda implements ik.p<SharingCommand, kotlin.coroutines.c<? super Boolean>, Object> {
    public /* synthetic */ Object L$0;
    public int label;

    public StartedWhileSubscribed$command$2(kotlin.coroutines.c<? super StartedWhileSubscribed$command$2> cVar) {
        super(2, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        StartedWhileSubscribed$command$2 startedWhileSubscribed$command$2 = new StartedWhileSubscribed$command$2(cVar);
        startedWhileSubscribed$command$2.L$0 = obj;
        return startedWhileSubscribed$command$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        yj.b.h();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        u0.n(obj);
        return zj.a.a(((SharingCommand) this.L$0) != SharingCommand.START);
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k SharingCommand sharingCommand, @yt.l kotlin.coroutines.c<? super Boolean> cVar) {
        return ((StartedWhileSubscribed$command$2) M(sharingCommand, cVar)).q0(z1.f38230a);
    }
}
