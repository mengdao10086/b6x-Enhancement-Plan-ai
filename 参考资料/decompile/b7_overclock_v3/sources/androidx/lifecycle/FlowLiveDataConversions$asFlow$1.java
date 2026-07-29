package androidx.lifecycle;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.z1;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.m2;
import kotlinx.coroutines.u1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes2.dex */
@zj.d(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", i = {0, 0}, l = {110, 114}, m = "invokeSuspend", n = {"$this$callbackFlow", "observer"}, s = {"L$0", "L$1"})
public final class FlowLiveDataConversions$asFlow$1<T> extends SuspendLambda implements ik.p<kotlinx.coroutines.channels.q<? super T>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ LiveData<T> $this_asFlow;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1, reason: invalid class name */
    @zj.d(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", f = "FlowLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super z1>, Object> {
        public final /* synthetic */ k0<T> $observer;
        public final /* synthetic */ LiveData<T> $this_asFlow;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LiveData<T> liveData, k0<T> k0Var, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$this_asFlow = liveData;
            this.$observer = k0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @yt.k
        public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(this.$this_asFlow, this.$observer, cVar);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @yt.l
        public final Object q0(@yt.k Object obj) throws Throwable {
            yj.b.h();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.u0.n(obj);
            this.$this_asFlow.l((k0<? super T>) this.$observer);
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
    public FlowLiveDataConversions$asFlow$1(LiveData<T> liveData, kotlin.coroutines.c<? super FlowLiveDataConversions$asFlow$1> cVar) {
        super(2, cVar);
        this.$this_asFlow = liveData;
    }

    public static final void K0(kotlinx.coroutines.channels.q qVar, Object obj) {
        qVar.F(obj);
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k kotlinx.coroutines.channels.q<? super T> qVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((FlowLiveDataConversions$asFlow$1) M(qVar, cVar)).q0(z1.f38230a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        FlowLiveDataConversions$asFlow$1 flowLiveDataConversions$asFlow$1 = new FlowLiveDataConversions$asFlow$1(this.$this_asFlow, cVar);
        flowLiveDataConversions$asFlow$1.L$0 = obj;
        return flowLiveDataConversions$asFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        final k0 k0Var;
        kotlinx.coroutines.channels.q qVar;
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.u0.n(obj);
            final kotlinx.coroutines.channels.q qVar2 = (kotlinx.coroutines.channels.q) this.L$0;
            k0Var = new k0() { // from class: androidx.lifecycle.n
                @Override // androidx.lifecycle.k0
                public final void b(Object obj2) {
                    FlowLiveDataConversions$asFlow$1.K0(qVar2, obj2);
                }
            };
            m2 m2VarO2 = kotlinx.coroutines.d1.e().o2();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_asFlow, k0Var, null);
            this.L$0 = qVar2;
            this.L$1 = k0Var;
            this.label = 1;
            if (kotlinx.coroutines.h.h(m2VarO2, anonymousClass1, this) == objH) {
                return objH;
            }
            qVar = qVar2;
        } else {
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.u0.n(obj);
                return z1.f38230a;
            }
            k0Var = (k0) this.L$1;
            qVar = (kotlinx.coroutines.channels.q) this.L$0;
            kotlin.u0.n(obj);
        }
        final LiveData<T> liveData = this.$this_asFlow;
        ik.a<z1> aVar = new ik.a<z1>() { // from class: androidx.lifecycle.FlowLiveDataConversions$asFlow$1.2

            /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2$1, reason: invalid class name */
            @zj.d(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2$1", f = "FlowLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass1 extends SuspendLambda implements ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super z1>, Object> {
                public final /* synthetic */ k0<T> $observer;
                public final /* synthetic */ LiveData<T> $this_asFlow;
                public int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(LiveData<T> liveData, k0<T> k0Var, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
                    super(2, cVar);
                    this.$this_asFlow = liveData;
                    this.$observer = k0Var;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @yt.k
                public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
                    return new AnonymousClass1(this.$this_asFlow, this.$observer, cVar);
                }

                /* JADX WARN: Type inference incomplete: some casts might be missing */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @yt.l
                public final Object q0(@yt.k Object obj) throws Throwable {
                    yj.b.h();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.u0.n(obj);
                    this.$this_asFlow.p((k0<? super T>) this.$observer);
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
            {
                super(0);
            }

            public final void b() {
                kotlinx.coroutines.j.f(u1.f39074a, kotlinx.coroutines.d1.e().o2(), null, new AnonymousClass1(liveData, k0Var, null), 2, null);
            }

            @Override // ik.a
            public /* bridge */ /* synthetic */ z1 o() {
                b();
                return z1.f38230a;
            }
        };
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (ProduceKt.a(qVar, aVar, this) == objH) {
            return objH;
        }
        return z1.f38230a;
    }
}
