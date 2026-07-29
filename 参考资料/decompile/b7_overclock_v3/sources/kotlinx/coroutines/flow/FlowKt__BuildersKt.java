package kotlinx.coroutines.flow;

import java.util.Iterator;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,354:1\n106#2:355\n106#2:356\n106#2:357\n106#2:358\n106#2:359\n106#2:360\n106#2:361\n106#2:362\n106#2:363\n106#2:364\n106#2:365\n106#2:366\n*S KotlinDebug\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n68#1:355\n82#1:356\n89#1:357\n98#1:358\n107#1:359\n122#1:360\n131#1:361\n153#1:362\n164#1:363\n175#1:364\n184#1:365\n193#1:366\n*E\n"})
public final /* synthetic */ class FlowKt__BuildersKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @t0({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n1#1,112:1\n69#2,2:113\n*E\n"})
    public static final class a<T> implements e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.a f38488a;

        public a(ik.a aVar) {
            this.f38488a = aVar;
        }

        @Override // kotlinx.coroutines.flow.e
        @yt.l
        public Object a(@yt.k f<? super T> fVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
            Object objF = fVar.f((Object) this.f38488a.o(), cVar);
            return objF == yj.b.h() ? objF : z1.f38230a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @t0({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n1#1,112:1\n136#2,2:113\n*E\n"})
    public static final class b<T> implements e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f38498a;

        public b(Object obj) {
            this.f38498a = obj;
        }

        @Override // kotlinx.coroutines.flow.e
        @yt.l
        public Object a(@yt.k f<? super T> fVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
            Object objF = fVar.f((Object) this.f38498a, cVar);
            return objF == yj.b.h() ? objF : z1.f38230a;
        }
    }

    @yt.k
    public static final <T> e<T> a(@yt.k ik.a<? extends T> aVar) {
        return new a(aVar);
    }

    @yt.k
    public static final <T> e<T> b(@yt.k ik.l<? super kotlin.coroutines.c<? super T>, ? extends Object> lVar) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2(lVar);
    }

    @yt.k
    public static final <T> e<T> c(@yt.k Iterable<? extends T> iterable) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3(iterable);
    }

    @yt.k
    public static final <T> e<T> d(@yt.k Iterator<? extends T> it2) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4(it2);
    }

    @yt.k
    public static final <T> e<T> e(@yt.k kotlin.sequences.m<? extends T> mVar) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5(mVar);
    }

    @yt.k
    public static final e<Integer> f(@yt.k qk.m mVar) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9(mVar);
    }

    @yt.k
    public static final e<Long> g(@yt.k qk.p pVar) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10(pVar);
    }

    @yt.k
    public static final e<Integer> h(@yt.k int[] iArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7(iArr);
    }

    @yt.k
    public static final e<Long> i(@yt.k long[] jArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8(jArr);
    }

    @yt.k
    public static final <T> e<T> j(@yt.k T[] tArr) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6(tArr);
    }

    @yt.k
    public static final <T> e<T> k(@kotlin.b @yt.k ik.p<? super kotlinx.coroutines.channels.q<? super T>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        return new CallbackFlowBuilder(pVar, null, 0, null, 14, null);
    }

    @yt.k
    public static final <T> e<T> l(@kotlin.b @yt.k ik.p<? super kotlinx.coroutines.channels.q<? super T>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        return new c(pVar, null, 0, null, 14, null);
    }

    @yt.k
    public static final <T> e<T> m() {
        return d.f38671a;
    }

    @yt.k
    public static final <T> e<T> n(@kotlin.b @yt.k ik.p<? super f<? super T>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        return new m(pVar);
    }

    @yt.k
    public static final <T> e<T> o(T t10) {
        return new b(t10);
    }

    @yt.k
    public static final <T> e<T> p(@yt.k T... tArr) {
        return new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1(tArr);
    }
}
