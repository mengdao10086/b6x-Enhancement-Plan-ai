package androidx.lifecycle;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes2.dex */
@zj.d(c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", f = "FlowLiveData.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
public final class FlowLiveDataConversions$asLiveData$1<T> extends SuspendLambda implements ik.p<g0<T>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ kotlinx.coroutines.flow.e<T> $this_asLiveData;
    private /* synthetic */ Object L$0;
    public int label;

    public static final class a<T> implements kotlinx.coroutines.flow.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g0<T> f6076a;

        public a(g0<T> g0Var) {
            this.f6076a = g0Var;
        }

        @Override // kotlinx.coroutines.flow.f
        @yt.l
        public final Object f(T t10, @yt.k kotlin.coroutines.c<? super z1> cVar) {
            Object objF = this.f6076a.f(t10, cVar);
            return objF == yj.b.h() ? objF : z1.f38230a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowLiveDataConversions$asLiveData$1(kotlinx.coroutines.flow.e<? extends T> eVar, kotlin.coroutines.c<? super FlowLiveDataConversions$asLiveData$1> cVar) {
        super(2, cVar);
        this.$this_asLiveData = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        FlowLiveDataConversions$asLiveData$1 flowLiveDataConversions$asLiveData$1 = new FlowLiveDataConversions$asLiveData$1(this.$this_asLiveData, cVar);
        flowLiveDataConversions$asLiveData$1.L$0 = obj;
        return flowLiveDataConversions$asLiveData$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.u0.n(obj);
            g0 g0Var = (g0) this.L$0;
            kotlinx.coroutines.flow.e<T> eVar = this.$this_asLiveData;
            a aVar = new a(g0Var);
            this.label = 1;
            if (eVar.a(aVar, this) == objH) {
                return objH;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.u0.n(obj);
        }
        return z1.f38230a;
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k g0<T> g0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((FlowLiveDataConversions$asLiveData$1) M(g0Var, cVar)).q0(z1.f38230a);
    }
}
