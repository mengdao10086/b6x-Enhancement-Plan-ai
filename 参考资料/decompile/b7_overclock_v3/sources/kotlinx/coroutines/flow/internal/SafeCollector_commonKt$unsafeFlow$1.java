package kotlinx.coroutines.flow.internal;

import ik.p;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n*L\n1#1,112:1\n*E\n"})
public final class SafeCollector_commonKt$unsafeFlow$1<T> implements kotlinx.coroutines.flow.e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p<kotlinx.coroutines.flow.f<? super T>, kotlin.coroutines.c<? super z1>, Object> f38705a;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector_commonKt$unsafeFlow$1(p<? super kotlinx.coroutines.flow.f<? super T>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        this.f38705a = pVar;
    }

    @Override // kotlinx.coroutines.flow.e
    @yt.l
    public Object a(@yt.k kotlinx.coroutines.flow.f<? super T> fVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        Object objR0 = this.f38705a.r0(fVar, cVar);
        return objR0 == yj.b.h() ? objR0 : z1.f38230a;
    }

    @yt.l
    public Object d(@yt.k kotlinx.coroutines.flow.f<? super T> fVar, @yt.k final kotlin.coroutines.c<? super z1> cVar) {
        c0.e(4);
        new ContinuationImpl(cVar) { // from class: kotlinx.coroutines.flow.internal.SafeCollector_commonKt$unsafeFlow$1$collect$1
            public int label;
            public /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @yt.l
            public final Object q0(@yt.k Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.a(null, this);
            }
        };
        c0.e(5);
        this.f38705a.r0(fVar, cVar);
        return z1.f38230a;
    }
}
