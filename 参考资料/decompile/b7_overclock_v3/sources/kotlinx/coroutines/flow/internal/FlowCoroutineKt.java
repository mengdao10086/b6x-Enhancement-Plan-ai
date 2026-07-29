package kotlinx.coroutines.flow.internal;

import ik.p;
import ik.q;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nFlowCoroutine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlowCoroutine.kt\nkotlinx/coroutines/flow/internal/FlowCoroutineKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,63:1\n106#2:64\n*S KotlinDebug\n*F\n+ 1 FlowCoroutine.kt\nkotlinx/coroutines/flow/internal/FlowCoroutineKt\n*L\n50#1:64\n*E\n"})
public final class FlowCoroutineKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    @t0({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 FlowCoroutine.kt\nkotlinx/coroutines/flow/internal/FlowCoroutineKt\n*L\n1#1,112:1\n51#2,2:113\n*E\n"})
    public static final class a<R> implements kotlinx.coroutines.flow.e<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f38701a;

        public a(q qVar) {
            this.f38701a = qVar;
        }

        @Override // kotlinx.coroutines.flow.e
        @yt.l
        public Object a(@yt.k kotlinx.coroutines.flow.f<? super R> fVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
            Object objA = FlowCoroutineKt.a(new FlowCoroutineKt$scopedFlow$1$1(this.f38701a, fVar, null), cVar);
            return objA == yj.b.h() ? objA : z1.f38230a;
        }
    }

    @yt.l
    public static final <R> Object a(@kotlin.b @yt.k p<? super o0, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar, @yt.k kotlin.coroutines.c<? super R> cVar) {
        g gVar = new g(cVar.b(), cVar);
        Object objE = zk.b.e(gVar, gVar, pVar);
        if (objE == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objE;
    }

    @yt.k
    public static final <R> kotlinx.coroutines.flow.e<R> b(@kotlin.b @yt.k q<? super o0, ? super kotlinx.coroutines.flow.f<? super R>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar) {
        return new a(qVar);
    }
}
