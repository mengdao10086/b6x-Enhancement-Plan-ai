package kotlinx.coroutines.flow.internal;

import ik.p;
import ik.q;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.text.StringsKt__IndentKt;
import kotlin.z1;
import kotlinx.coroutines.f2;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nSafeCollector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.kt\nkotlinx/coroutines/flow/internal/SafeCollector\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,156:1\n1#2:157\n*E\n"})
public final class SafeCollector<T> extends ContinuationImpl implements kotlinx.coroutines.flow.f<T>, zj.c {

    @hk.e
    @yt.k
    public final CoroutineContext collectContext;

    @hk.e
    public final int collectContextSize;

    @hk.e
    @yt.k
    public final kotlinx.coroutines.flow.f<T> collector;

    @yt.l
    private kotlin.coroutines.c<? super z1> completion;

    @yt.l
    private CoroutineContext lastEmissionContext;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector(@yt.k kotlinx.coroutines.flow.f<? super T> fVar, @yt.k CoroutineContext coroutineContext) {
        super(j.f38716a, EmptyCoroutineContext.f37755a);
        this.collector = fVar;
        this.collectContext = coroutineContext;
        this.collectContextSize = ((Number) coroutineContext.k(0, new p<Integer, CoroutineContext.a, Integer>() { // from class: kotlinx.coroutines.flow.internal.SafeCollector$collectContextSize$1
            @yt.k
            public final Integer b(int i10, @yt.k CoroutineContext.a aVar) {
                return Integer.valueOf(i10 + 1);
            }

            @Override // ik.p
            public /* bridge */ /* synthetic */ Integer r0(Integer num, CoroutineContext.a aVar) {
                return b(num.intValue(), aVar);
            }
        })).intValue();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, zj.c
    @yt.l
    public StackTraceElement D() {
        return null;
    }

    public final Object F0(kotlin.coroutines.c<? super z1> cVar, T t10) {
        CoroutineContext coroutineContextB = cVar.b();
        f2.z(coroutineContextB);
        CoroutineContext coroutineContext = this.lastEmissionContext;
        if (coroutineContext != coroutineContextB) {
            x0(coroutineContextB, coroutineContext, t10);
            this.lastEmissionContext = coroutineContextB;
        }
        this.completion = cVar;
        q qVar = SafeCollectorKt.f38703a;
        kotlinx.coroutines.flow.f<T> fVar = this.collector;
        f0.n(fVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        f0.n(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object objA = qVar.A(fVar, t10, this);
        if (!f0.g(objA, yj.b.h())) {
            this.completion = null;
        }
        return objA;
    }

    public final void K0(f fVar, Object obj) {
        throw new IllegalStateException(StringsKt__IndentKt.p("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + fVar.f38714a + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.c
    @yt.k
    public CoroutineContext b() {
        CoroutineContext coroutineContext = this.lastEmissionContext;
        return coroutineContext == null ? EmptyCoroutineContext.f37755a : coroutineContext;
    }

    @Override // kotlinx.coroutines.flow.f
    @yt.l
    public Object f(T t10, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        try {
            Object objF0 = F0(cVar, t10);
            if (objF0 == yj.b.h()) {
                zj.f.c(cVar);
            }
            return objF0 == yj.b.h() ? objF0 : z1.f38230a;
        } catch (Throwable th2) {
            this.lastEmissionContext = new f(th2, cVar.b());
            throw th2;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public Object q0(@yt.k Object obj) {
        Throwable thF = Result.f(obj);
        if (thF != null) {
            this.lastEmissionContext = new f(thF, b());
        }
        kotlin.coroutines.c<? super z1> cVar = this.completion;
        if (cVar != null) {
            cVar.x(obj);
        }
        return yj.b.h();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, zj.c
    @yt.l
    public zj.c r() {
        kotlin.coroutines.c<? super z1> cVar = this.completion;
        if (cVar instanceof zj.c) {
            return (zj.c) cVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void u0() {
        super.u0();
    }

    public final void x0(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, T t10) {
        if (coroutineContext2 instanceof f) {
            K0((f) coroutineContext2, t10);
        }
        SafeCollector_commonKt.a(this, coroutineContext);
    }
}
