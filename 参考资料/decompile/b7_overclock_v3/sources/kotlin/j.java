package kotlin;

import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public final class j<T, R> extends i<T, R> implements kotlin.coroutines.c<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public ik.q<? super i<?, ?>, Object, ? super kotlin.coroutines.c<Object>, ? extends Object> f37861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public Object f37862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public kotlin.coroutines.c<Object> f37863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public Object f37864d;

    @kotlin.jvm.internal.t0({"SMAP\nContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Continuation.kt\nkotlin/coroutines/ContinuationKt$Continuation$1\n+ 2 DeepRecursive.kt\nkotlin/DeepRecursiveScopeImpl\n*L\n1#1,161:1\n184#2,6:162\n*E\n"})
    public static final class a implements kotlin.coroutines.c<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CoroutineContext f37865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f37866b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ik.q f37867c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ kotlin.coroutines.c f37868d;

        public a(CoroutineContext coroutineContext, j jVar, ik.q qVar, kotlin.coroutines.c cVar) {
            this.f37865a = coroutineContext;
            this.f37866b = jVar;
            this.f37867c = qVar;
            this.f37868d = cVar;
        }

        @Override // kotlin.coroutines.c
        @yt.k
        public CoroutineContext b() {
            return this.f37865a;
        }

        @Override // kotlin.coroutines.c
        public void x(@yt.k Object obj) {
            this.f37866b.f37861a = this.f37867c;
            this.f37866b.f37863c = this.f37868d;
            this.f37866b.f37864d = obj;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public j(@yt.k ik.q<? super i<T, R>, ? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> block, T t10) {
        super(null);
        kotlin.jvm.internal.f0.p(block, "block");
        this.f37861a = block;
        this.f37862b = t10;
        kotlin.jvm.internal.f0.n(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f37863c = this;
        this.f37864d = h.f37772a;
    }

    @Override // kotlin.i
    @yt.l
    public Object a(T t10, @yt.k kotlin.coroutines.c<? super R> cVar) {
        kotlin.jvm.internal.f0.n(cVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f37863c = cVar;
        this.f37862b = t10;
        Object objH = yj.b.h();
        if (objH == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objH;
    }

    @Override // kotlin.coroutines.c
    @yt.k
    public CoroutineContext b() {
        return EmptyCoroutineContext.f37755a;
    }

    @Override // kotlin.i
    @yt.l
    public <U, S> Object c(@yt.k g<U, S> gVar, U u6, @yt.k kotlin.coroutines.c<? super S> cVar) {
        ik.q<i<U, S>, U, kotlin.coroutines.c<? super S>, Object> qVarA = gVar.a();
        kotlin.jvm.internal.f0.n(qVarA, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.coroutines.SuspendFunction2<kotlin.DeepRecursiveScope<*, *>, kotlin.Any?, kotlin.Any?>{ kotlin.DeepRecursiveKt.DeepRecursiveFunctionBlock }");
        ik.q<? super i<?, ?>, Object, ? super kotlin.coroutines.c<Object>, ? extends Object> qVar = this.f37861a;
        if (qVarA != qVar) {
            this.f37861a = qVarA;
            kotlin.jvm.internal.f0.n(cVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            this.f37863c = i(qVar, cVar);
        } else {
            kotlin.jvm.internal.f0.n(cVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            this.f37863c = cVar;
        }
        this.f37862b = u6;
        Object objH = yj.b.h();
        if (objH == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objH;
    }

    public final kotlin.coroutines.c<Object> i(ik.q<? super i<?, ?>, Object, ? super kotlin.coroutines.c<Object>, ? extends Object> qVar, kotlin.coroutines.c<Object> cVar) {
        return new a(EmptyCoroutineContext.f37755a, this, qVar, cVar);
    }

    public final R j() throws Throwable {
        while (true) {
            R r10 = (R) this.f37864d;
            kotlin.coroutines.c<Object> cVar = this.f37863c;
            if (cVar == null) {
                u0.n(r10);
                return r10;
            }
            if (Result.d(h.f37772a, r10)) {
                try {
                    ik.q<? super i<?, ?>, Object, ? super kotlin.coroutines.c<Object>, ? extends Object> qVar = this.f37861a;
                    Object obj = this.f37862b;
                    kotlin.jvm.internal.f0.n(qVar, "null cannot be cast to non-null type kotlin.Function3<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.startCoroutineUninterceptedOrReturn, P of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.startCoroutineUninterceptedOrReturn, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.startCoroutineUninterceptedOrReturn>, kotlin.Any?>");
                    Object objA = ((ik.q) kotlin.jvm.internal.w0.q(qVar, 3)).A(this, obj, cVar);
                    if (objA != yj.b.h()) {
                        Result.a aVar = Result.f37633a;
                        cVar.x(Result.b(objA));
                    }
                } catch (Throwable th2) {
                    Result.a aVar2 = Result.f37633a;
                    cVar.x(Result.b(u0.a(th2)));
                }
            } else {
                this.f37864d = h.f37772a;
                cVar.x(r10);
            }
        }
    }

    @Override // kotlin.coroutines.c
    public void x(@yt.k Object obj) {
        this.f37863c = null;
        this.f37864d = obj;
    }
}
