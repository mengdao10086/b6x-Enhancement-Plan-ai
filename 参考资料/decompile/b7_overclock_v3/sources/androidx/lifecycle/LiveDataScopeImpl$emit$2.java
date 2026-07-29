package androidx.lifecycle;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@zj.d(c = "androidx.lifecycle.LiveDataScopeImpl$emit$2", f = "CoroutineLiveData.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
public final class LiveDataScopeImpl$emit$2 extends SuspendLambda implements ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ T $value;
    public int label;
    public final /* synthetic */ LiveDataScopeImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveDataScopeImpl$emit$2(LiveDataScopeImpl<T> liveDataScopeImpl, T t10, kotlin.coroutines.c<? super LiveDataScopeImpl$emit$2> cVar) {
        super(2, cVar);
        this.this$0 = liveDataScopeImpl;
        this.$value = t10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        return new LiveDataScopeImpl$emit$2(this.this$0, this.$value, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.u0.n(obj);
            CoroutineLiveData coroutineLiveDataA = this.this$0.a();
            this.label = 1;
            if (coroutineLiveDataA.v(this) == objH) {
                return objH;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.u0.n(obj);
        }
        this.this$0.a().r(this.$value);
        return z1.f38230a;
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k kotlinx.coroutines.o0 o0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((LiveDataScopeImpl$emit$2) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
