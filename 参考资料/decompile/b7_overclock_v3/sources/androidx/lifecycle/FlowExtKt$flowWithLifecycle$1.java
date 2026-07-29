package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.z1;
import kotlinx.coroutines.channels.s;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes2.dex */
@zj.d(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1", f = "FlowExt.kt", i = {0}, l = {91}, m = "invokeSuspend", n = {"$this$callbackFlow"}, s = {"L$0"})
public final class FlowExtKt$flowWithLifecycle$1<T> extends SuspendLambda implements ik.p<kotlinx.coroutines.channels.q<? super T>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ Lifecycle $lifecycle;
    public final /* synthetic */ Lifecycle.State $minActiveState;
    public final /* synthetic */ kotlinx.coroutines.flow.e<T> $this_flowWithLifecycle;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1, reason: invalid class name */
    @zj.d(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1", f = "FlowExt.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super z1>, Object> {
        public final /* synthetic */ kotlinx.coroutines.channels.q<T> $$this$callbackFlow;
        public final /* synthetic */ kotlinx.coroutines.flow.e<T> $this_flowWithLifecycle;
        public int label;

        /* JADX INFO: renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1$a */
        public static final class a<T> implements kotlinx.coroutines.flow.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ kotlinx.coroutines.channels.q<T> f6075a;

            /* JADX WARN: Multi-variable type inference failed */
            public a(kotlinx.coroutines.channels.q<? super T> qVar) {
                this.f6075a = qVar;
            }

            @Override // kotlinx.coroutines.flow.f
            @yt.l
            public final Object f(T t10, @yt.k kotlin.coroutines.c<? super z1> cVar) {
                Object objG = this.f6075a.G(t10, cVar);
                return objG == yj.b.h() ? objG : z1.f38230a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(kotlinx.coroutines.flow.e<? extends T> eVar, kotlinx.coroutines.channels.q<? super T> qVar, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$this_flowWithLifecycle = eVar;
            this.$$this$callbackFlow = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @yt.k
        public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(this.$this_flowWithLifecycle, this.$$this$callbackFlow, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @yt.l
        public final Object q0(@yt.k Object obj) throws Throwable {
            Object objH = yj.b.h();
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.u0.n(obj);
                kotlinx.coroutines.flow.e<T> eVar = this.$this_flowWithLifecycle;
                a aVar = new a(this.$$this$callbackFlow);
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
        public final Object r0(@yt.k kotlinx.coroutines.o0 o0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
            return ((AnonymousClass1) M(o0Var, cVar)).q0(z1.f38230a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowExtKt$flowWithLifecycle$1(Lifecycle lifecycle, Lifecycle.State state, kotlinx.coroutines.flow.e<? extends T> eVar, kotlin.coroutines.c<? super FlowExtKt$flowWithLifecycle$1> cVar) {
        super(2, cVar);
        this.$lifecycle = lifecycle;
        this.$minActiveState = state;
        this.$this_flowWithLifecycle = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        FlowExtKt$flowWithLifecycle$1 flowExtKt$flowWithLifecycle$1 = new FlowExtKt$flowWithLifecycle$1(this.$lifecycle, this.$minActiveState, this.$this_flowWithLifecycle, cVar);
        flowExtKt$flowWithLifecycle$1.L$0 = obj;
        return flowExtKt$flowWithLifecycle$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        kotlinx.coroutines.channels.q qVar;
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.u0.n(obj);
            kotlinx.coroutines.channels.q qVar2 = (kotlinx.coroutines.channels.q) this.L$0;
            Lifecycle lifecycle = this.$lifecycle;
            Lifecycle.State state = this.$minActiveState;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_flowWithLifecycle, qVar2, null);
            this.L$0 = qVar2;
            this.label = 1;
            if (RepeatOnLifecycleKt.a(lifecycle, state, anonymousClass1, this) == objH) {
                return objH;
            }
            qVar = qVar2;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            qVar = (kotlinx.coroutines.channels.q) this.L$0;
            kotlin.u0.n(obj);
        }
        s.a.a(qVar, null, 1, null);
        return z1.f38230a;
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k kotlinx.coroutines.channels.q<? super T> qVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((FlowExtKt$flowWithLifecycle$1) M(qVar, cVar)).q0(z1.f38230a);
    }
}
