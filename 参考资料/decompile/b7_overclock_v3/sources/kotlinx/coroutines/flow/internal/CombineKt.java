package kotlinx.coroutines.flow.internal;

import ik.q;
import kotlin.jvm.internal.t0;
import kotlin.s0;
import kotlin.z1;
import kotlinx.coroutines.p0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nCombine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,143:1\n106#2:144\n*S KotlinDebug\n*F\n+ 1 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt\n*L\n86#1:144\n*E\n"})
public final class CombineKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    @t0({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Combine.kt\nkotlinx/coroutines/flow/internal/CombineKt\n*L\n1#1,112:1\n87#2:113\n142#2:114\n*E\n"})
    public static final class a<R> implements kotlinx.coroutines.flow.e<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.flow.e f38690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.flow.e f38691b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ q f38692c;

        public a(kotlinx.coroutines.flow.e eVar, kotlinx.coroutines.flow.e eVar2, q qVar) {
            this.f38690a = eVar;
            this.f38691b = eVar2;
            this.f38692c = qVar;
        }

        @Override // kotlinx.coroutines.flow.e
        @yt.l
        public Object a(@yt.k kotlinx.coroutines.flow.f<? super R> fVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
            Object objG = p0.g(new CombineKt$zipImpl$1$1(fVar, this.f38690a, this.f38691b, this.f38692c, null), cVar);
            return objG == yj.b.h() ? objG : z1.f38230a;
        }
    }

    @yt.l
    @s0
    public static final <R, T> Object a(@yt.k kotlinx.coroutines.flow.f<? super R> fVar, @yt.k kotlinx.coroutines.flow.e<? extends T>[] eVarArr, @yt.k ik.a<T[]> aVar, @yt.k q<? super kotlinx.coroutines.flow.f<? super R>, ? super T[], ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        Object objA = FlowCoroutineKt.a(new CombineKt$combineInternal$2(eVarArr, aVar, qVar, fVar, null), cVar);
        return objA == yj.b.h() ? objA : z1.f38230a;
    }

    @yt.k
    public static final <T1, T2, R> kotlinx.coroutines.flow.e<R> b(@yt.k kotlinx.coroutines.flow.e<? extends T1> eVar, @yt.k kotlinx.coroutines.flow.e<? extends T2> eVar2, @yt.k q<? super T1, ? super T2, ? super kotlin.coroutines.c<? super R>, ? extends Object> qVar) {
        return new a(eVar2, eVar, qVar);
    }
}
