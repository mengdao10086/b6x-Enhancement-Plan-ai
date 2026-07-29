package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.z1;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.m2;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.jvm.internal.t0({"SMAP\nWithLifecycleState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WithLifecycleState.kt\nandroidx/lifecycle/WithLifecycleStateKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,206:1\n154#1,8:207\n154#1,8:215\n154#1,8:223\n154#1,8:231\n43#1,5:239\n154#1,8:244\n43#1,5:252\n154#1,8:257\n154#1,8:265\n154#1,8:273\n154#1,8:281\n314#2,11:289\n*S KotlinDebug\n*F\n+ 1 WithLifecycleState.kt\nandroidx/lifecycle/WithLifecycleStateKt\n*L\n47#1:207,8\n58#1:215,8\n71#1:223,8\n84#1:231,8\n98#1:239,5\n98#1:244,8\n98#1:252,5\n98#1:257,8\n111#1:265,8\n124#1:273,8\n137#1:281,8\n177#1:289,11\n*E\n"})
public final class WithLifecycleStateKt {

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Lifecycle f6149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 f6150b;

        public a(Lifecycle lifecycle, WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1) {
            this.f6149a = lifecycle;
            this.f6150b = withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f6149a.a(this.f6150b);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1, androidx.lifecycle.x] */
    @yt.l
    @kotlin.s0
    public static final <R> Object a(@yt.k final Lifecycle lifecycle, @yt.k final Lifecycle.State state, boolean z10, @yt.k final CoroutineDispatcher coroutineDispatcher, @yt.k final ik.a<? extends R> aVar, @yt.k kotlin.coroutines.c<? super R> cVar) {
        final kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        pVar.Q();
        final ?? r12 = new v() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1
            @Override // androidx.lifecycle.v
            public void c(@yt.k y source, @yt.k Lifecycle.Event event) {
                Object objB;
                kotlin.jvm.internal.f0.p(source, "source");
                kotlin.jvm.internal.f0.p(event, "event");
                if (event != Lifecycle.Event.Companion.d(state)) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        lifecycle.d(this);
                        kotlin.coroutines.c cVar2 = pVar;
                        Result.a aVar2 = Result.f37633a;
                        cVar2.x(Result.b(kotlin.u0.a(new LifecycleDestroyedException())));
                        return;
                    }
                    return;
                }
                lifecycle.d(this);
                kotlin.coroutines.c cVar3 = pVar;
                ik.a<R> aVar3 = aVar;
                try {
                    Result.a aVar4 = Result.f37633a;
                    objB = Result.b(aVar3.o());
                } catch (Throwable th2) {
                    Result.a aVar5 = Result.f37633a;
                    objB = Result.b(kotlin.u0.a(th2));
                }
                cVar3.x(objB);
            }
        };
        if (z10) {
            coroutineDispatcher.h2(EmptyCoroutineContext.f37755a, new a(lifecycle, r12));
        } else {
            lifecycle.a(r12);
        }
        pVar.B(new ik.l<Throwable, z1>() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2

            public static final class a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Lifecycle f6151a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 f6152b;

                public a(Lifecycle lifecycle, WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1) {
                    this.f6151a = lifecycle;
                    this.f6152b = withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f6151a.d(this.f6152b);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(@yt.l Throwable th2) {
                CoroutineDispatcher coroutineDispatcher2 = coroutineDispatcher;
                EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f37755a;
                if (coroutineDispatcher2.j2(emptyCoroutineContext)) {
                    coroutineDispatcher.h2(emptyCoroutineContext, new a(lifecycle, r12));
                } else {
                    lifecycle.d(r12);
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        });
        Object objC = pVar.C();
        if (objC == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objC;
    }

    @yt.l
    public static final <R> Object b(@yt.k Lifecycle lifecycle, @yt.k ik.a<? extends R> aVar, @yt.k kotlin.coroutines.c<? super R> cVar) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        m2 m2VarO2 = kotlinx.coroutines.d1.e().o2();
        boolean zJ2 = m2VarO2.j2(cVar.b());
        if (!zJ2) {
            if (lifecycle.b() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.b().compareTo(state) >= 0) {
                return aVar.o();
            }
        }
        return a(lifecycle, state, zJ2, m2VarO2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
    }

    @yt.l
    public static final <R> Object c(@yt.k y yVar, @yt.k ik.a<? extends R> aVar, @yt.k kotlin.coroutines.c<? super R> cVar) {
        Lifecycle lifecycleE = yVar.e();
        Lifecycle.State state = Lifecycle.State.CREATED;
        m2 m2VarO2 = kotlinx.coroutines.d1.e().o2();
        boolean zJ2 = m2VarO2.j2(cVar.b());
        if (!zJ2) {
            if (lifecycleE.b() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycleE.b().compareTo(state) >= 0) {
                return aVar.o();
            }
        }
        return a(lifecycleE, state, zJ2, m2VarO2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
    }

    public static final <R> Object d(Lifecycle lifecycle, ik.a<? extends R> aVar, kotlin.coroutines.c<? super R> cVar) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        kotlinx.coroutines.d1.e().o2();
        kotlin.jvm.internal.c0.e(3);
        throw null;
    }

    public static final <R> Object e(y yVar, ik.a<? extends R> aVar, kotlin.coroutines.c<? super R> cVar) {
        yVar.e();
        Lifecycle.State state = Lifecycle.State.CREATED;
        kotlinx.coroutines.d1.e().o2();
        kotlin.jvm.internal.c0.e(3);
        throw null;
    }

    @yt.l
    public static final <R> Object f(@yt.k Lifecycle lifecycle, @yt.k ik.a<? extends R> aVar, @yt.k kotlin.coroutines.c<? super R> cVar) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        m2 m2VarO2 = kotlinx.coroutines.d1.e().o2();
        boolean zJ2 = m2VarO2.j2(cVar.b());
        if (!zJ2) {
            if (lifecycle.b() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.b().compareTo(state) >= 0) {
                return aVar.o();
            }
        }
        return a(lifecycle, state, zJ2, m2VarO2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
    }

    @yt.l
    public static final <R> Object g(@yt.k y yVar, @yt.k ik.a<? extends R> aVar, @yt.k kotlin.coroutines.c<? super R> cVar) {
        Lifecycle lifecycleE = yVar.e();
        Lifecycle.State state = Lifecycle.State.RESUMED;
        m2 m2VarO2 = kotlinx.coroutines.d1.e().o2();
        boolean zJ2 = m2VarO2.j2(cVar.b());
        if (!zJ2) {
            if (lifecycleE.b() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycleE.b().compareTo(state) >= 0) {
                return aVar.o();
            }
        }
        return a(lifecycleE, state, zJ2, m2VarO2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
    }

    public static final <R> Object h(Lifecycle lifecycle, ik.a<? extends R> aVar, kotlin.coroutines.c<? super R> cVar) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        kotlinx.coroutines.d1.e().o2();
        kotlin.jvm.internal.c0.e(3);
        throw null;
    }

    public static final <R> Object i(y yVar, ik.a<? extends R> aVar, kotlin.coroutines.c<? super R> cVar) {
        yVar.e();
        Lifecycle.State state = Lifecycle.State.RESUMED;
        kotlinx.coroutines.d1.e().o2();
        kotlin.jvm.internal.c0.e(3);
        throw null;
    }

    @yt.l
    public static final <R> Object j(@yt.k Lifecycle lifecycle, @yt.k ik.a<? extends R> aVar, @yt.k kotlin.coroutines.c<? super R> cVar) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        m2 m2VarO2 = kotlinx.coroutines.d1.e().o2();
        boolean zJ2 = m2VarO2.j2(cVar.b());
        if (!zJ2) {
            if (lifecycle.b() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.b().compareTo(state) >= 0) {
                return aVar.o();
            }
        }
        return a(lifecycle, state, zJ2, m2VarO2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
    }

    @yt.l
    public static final <R> Object k(@yt.k y yVar, @yt.k ik.a<? extends R> aVar, @yt.k kotlin.coroutines.c<? super R> cVar) {
        Lifecycle lifecycleE = yVar.e();
        Lifecycle.State state = Lifecycle.State.STARTED;
        m2 m2VarO2 = kotlinx.coroutines.d1.e().o2();
        boolean zJ2 = m2VarO2.j2(cVar.b());
        if (!zJ2) {
            if (lifecycleE.b() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycleE.b().compareTo(state) >= 0) {
                return aVar.o();
            }
        }
        return a(lifecycleE, state, zJ2, m2VarO2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
    }

    public static final <R> Object l(Lifecycle lifecycle, ik.a<? extends R> aVar, kotlin.coroutines.c<? super R> cVar) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        kotlinx.coroutines.d1.e().o2();
        kotlin.jvm.internal.c0.e(3);
        throw null;
    }

    public static final <R> Object m(y yVar, ik.a<? extends R> aVar, kotlin.coroutines.c<? super R> cVar) {
        yVar.e();
        Lifecycle.State state = Lifecycle.State.STARTED;
        kotlinx.coroutines.d1.e().o2();
        kotlin.jvm.internal.c0.e(3);
        throw null;
    }

    @yt.l
    public static final <R> Object n(@yt.k Lifecycle lifecycle, @yt.k Lifecycle.State state, @yt.k ik.a<? extends R> aVar, @yt.k kotlin.coroutines.c<? super R> cVar) {
        if (!(state.compareTo(Lifecycle.State.CREATED) >= 0)) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
        }
        m2 m2VarO2 = kotlinx.coroutines.d1.e().o2();
        boolean zJ2 = m2VarO2.j2(cVar.b());
        if (!zJ2) {
            if (lifecycle.b() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.b().compareTo(state) >= 0) {
                return aVar.o();
            }
        }
        return a(lifecycle, state, zJ2, m2VarO2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
    }

    @yt.l
    public static final <R> Object o(@yt.k y yVar, @yt.k Lifecycle.State state, @yt.k ik.a<? extends R> aVar, @yt.k kotlin.coroutines.c<? super R> cVar) {
        Lifecycle lifecycleE = yVar.e();
        if (!(state.compareTo(Lifecycle.State.CREATED) >= 0)) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
        }
        m2 m2VarO2 = kotlinx.coroutines.d1.e().o2();
        boolean zJ2 = m2VarO2.j2(cVar.b());
        if (!zJ2) {
            if (lifecycleE.b() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycleE.b().compareTo(state) >= 0) {
                return aVar.o();
            }
        }
        return a(lifecycleE, state, zJ2, m2VarO2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
    }

    public static final <R> Object p(Lifecycle lifecycle, Lifecycle.State state, ik.a<? extends R> aVar, kotlin.coroutines.c<? super R> cVar) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            kotlinx.coroutines.d1.e().o2();
            kotlin.jvm.internal.c0.e(3);
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    public static final <R> Object q(y yVar, Lifecycle.State state, ik.a<? extends R> aVar, kotlin.coroutines.c<? super R> cVar) {
        yVar.e();
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            kotlinx.coroutines.d1.e().o2();
            kotlin.jvm.internal.c0.e(3);
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    @yt.l
    @kotlin.s0
    public static final <R> Object r(@yt.k Lifecycle lifecycle, @yt.k Lifecycle.State state, @yt.k ik.a<? extends R> aVar, @yt.k kotlin.coroutines.c<? super R> cVar) {
        m2 m2VarO2 = kotlinx.coroutines.d1.e().o2();
        boolean zJ2 = m2VarO2.j2(cVar.b());
        if (!zJ2) {
            if (lifecycle.b() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.b().compareTo(state) >= 0) {
                return aVar.o();
            }
        }
        return a(lifecycle, state, zJ2, m2VarO2, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(aVar), cVar);
    }

    @kotlin.s0
    public static final <R> Object s(Lifecycle lifecycle, Lifecycle.State state, ik.a<? extends R> aVar, kotlin.coroutines.c<? super R> cVar) {
        kotlinx.coroutines.d1.e().o2();
        kotlin.jvm.internal.c0.e(3);
        throw null;
    }
}
