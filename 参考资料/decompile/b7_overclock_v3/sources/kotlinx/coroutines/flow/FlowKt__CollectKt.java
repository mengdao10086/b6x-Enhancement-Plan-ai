package kotlinx.coroutines.flow;

import kotlin.DeprecationLevel;
import kotlin.jvm.internal.c0;
import kotlin.z1;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__CollectKt {
    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Backwards compatibility with JS and K/N")
    public static final /* synthetic */ <T> Object a(e<? extends T> eVar, ik.p<? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar, kotlin.coroutines.c<? super z1> cVar) {
        Object objA = eVar.a(new FlowKt__CollectKt$collect$3(pVar), cVar);
        return objA == yj.b.h() ? objA : z1.f38230a;
    }

    @yt.l
    public static final Object b(@yt.k e<?> eVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        Object objA = eVar.a(kotlinx.coroutines.flow.internal.k.f38718a, cVar);
        return objA == yj.b.h() ? objA : z1.f38230a;
    }

    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Backwards compatibility with JS and K/N")
    public static final /* synthetic */ <T> Object c(e<? extends T> eVar, ik.p<? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar, kotlin.coroutines.c<? super z1> cVar) {
        FlowKt__CollectKt$collect$3 flowKt__CollectKt$collect$3 = new FlowKt__CollectKt$collect$3(pVar);
        c0.e(0);
        eVar.a(flowKt__CollectKt$collect$3, cVar);
        c0.e(1);
        return z1.f38230a;
    }

    @yt.l
    public static final <T> Object d(@yt.k e<? extends T> eVar, @yt.k ik.q<? super Integer, ? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        Object objA = eVar.a(new FlowKt__CollectKt$collectIndexed$2(qVar), cVar);
        return objA == yj.b.h() ? objA : z1.f38230a;
    }

    public static final <T> Object e(e<? extends T> eVar, ik.q<? super Integer, ? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar, kotlin.coroutines.c<? super z1> cVar) {
        FlowKt__CollectKt$collectIndexed$2 flowKt__CollectKt$collectIndexed$2 = new FlowKt__CollectKt$collectIndexed$2(qVar);
        c0.e(0);
        eVar.a(flowKt__CollectKt$collectIndexed$2, cVar);
        c0.e(1);
        return z1.f38230a;
    }

    @yt.l
    public static final <T> Object f(@yt.k e<? extends T> eVar, @yt.k ik.p<? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        Object objY = g.y(h.d(g.X0(eVar, pVar), 0, null, 2, null), cVar);
        return objY == yj.b.h() ? objY : z1.f38230a;
    }

    @yt.l
    public static final <T> Object g(@yt.k f<? super T> fVar, @yt.k e<? extends T> eVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        g.o0(fVar);
        Object objA = eVar.a(fVar, cVar);
        return objA == yj.b.h() ? objA : z1.f38230a;
    }

    @yt.k
    public static final <T> c2 h(@yt.k e<? extends T> eVar, @yt.k o0 o0Var) {
        return kotlinx.coroutines.j.f(o0Var, null, null, new FlowKt__CollectKt$launchIn$1(eVar, null), 3, null);
    }
}
