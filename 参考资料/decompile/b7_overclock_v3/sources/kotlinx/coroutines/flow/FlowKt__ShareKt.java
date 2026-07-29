package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.z;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nShare.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/FlowKt__ShareKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,426:1\n1#2:427\n*E\n"})
public final /* synthetic */ class FlowKt__ShareKt {
    @yt.k
    public static final <T> n<T> a(@yt.k i<T> iVar) {
        return new k(iVar, null);
    }

    @yt.k
    public static final <T> u<T> b(@yt.k j<T> jVar) {
        return new l(jVar, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> kotlinx.coroutines.flow.q<T> c(kotlinx.coroutines.flow.e<? extends T> r7, int r8) {
        /*
            kotlinx.coroutines.channels.g$b r0 = kotlinx.coroutines.channels.g.f38366y2
            int r0 = r0.a()
            int r0 = qk.v.u(r8, r0)
            int r0 = r0 - r8
            boolean r1 = r7 instanceof kotlinx.coroutines.flow.internal.ChannelFlow
            if (r1 == 0) goto L3d
            r1 = r7
            kotlinx.coroutines.flow.internal.ChannelFlow r1 = (kotlinx.coroutines.flow.internal.ChannelFlow) r1
            kotlinx.coroutines.flow.e r2 = r1.i()
            if (r2 == 0) goto L3d
            kotlinx.coroutines.flow.q r7 = new kotlinx.coroutines.flow.q
            int r3 = r1.f38675b
            r4 = -3
            r5 = 0
            if (r3 == r4) goto L27
            r4 = -2
            if (r3 == r4) goto L27
            if (r3 == 0) goto L27
            r0 = r3
            goto L35
        L27:
            kotlinx.coroutines.channels.BufferOverflow r4 = r1.f38676c
            kotlinx.coroutines.channels.BufferOverflow r6 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            if (r4 != r6) goto L30
            if (r3 != 0) goto L35
            goto L34
        L30:
            if (r8 != 0) goto L34
            r0 = 1
            goto L35
        L34:
            r0 = 0
        L35:
            kotlinx.coroutines.channels.BufferOverflow r8 = r1.f38676c
            kotlin.coroutines.CoroutineContext r1 = r1.f38674a
            r7.<init>(r2, r0, r8, r1)
            return r7
        L3d:
            kotlinx.coroutines.flow.q r8 = new kotlinx.coroutines.flow.q
            kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.f37755a
            r8.<init>(r7, r0, r1, r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ShareKt.c(kotlinx.coroutines.flow.e, int):kotlinx.coroutines.flow.q");
    }

    public static final <T> c2 d(o0 o0Var, CoroutineContext coroutineContext, e<? extends T> eVar, i<T> iVar, r rVar, T t10) {
        return kotlinx.coroutines.h.d(o0Var, coroutineContext, f0.g(rVar, r.f38737a.c()) ? CoroutineStart.DEFAULT : CoroutineStart.UNDISPATCHED, new FlowKt__ShareKt$launchSharing$1(rVar, eVar, iVar, t10, null));
    }

    public static final <T> void e(o0 o0Var, CoroutineContext coroutineContext, e<? extends T> eVar, kotlinx.coroutines.x<u<T>> xVar) {
        kotlinx.coroutines.j.f(o0Var, coroutineContext, null, new FlowKt__ShareKt$launchSharingDeferred$1(eVar, xVar, null), 2, null);
    }

    @yt.k
    public static final <T> n<T> f(@yt.k n<? extends T> nVar, @yt.k ik.p<? super f<? super T>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        return new SubscribedSharedFlow(nVar, pVar);
    }

    @yt.k
    public static final <T> n<T> g(@yt.k e<? extends T> eVar, @yt.k o0 o0Var, @yt.k r rVar, int i10) {
        q qVarC = c(eVar, i10);
        i iVarA = o.a(i10, qVarC.f38734b, qVarC.f38735c);
        return new k(iVarA, d(o0Var, qVarC.f38736d, qVarC.f38733a, iVarA, rVar, o.f38730a));
    }

    public static /* synthetic */ n h(e eVar, o0 o0Var, r rVar, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return g.G1(eVar, o0Var, rVar, i10);
    }

    @yt.l
    public static final <T> Object i(@yt.k e<? extends T> eVar, @yt.k o0 o0Var, @yt.k kotlin.coroutines.c<? super u<? extends T>> cVar) {
        q qVarC = c(eVar, 1);
        kotlinx.coroutines.x xVarC = z.c(null, 1, null);
        e(o0Var, qVarC.f38736d, qVarC.f38733a, xVarC);
        return xVarC.b0(cVar);
    }

    @yt.k
    public static final <T> u<T> j(@yt.k e<? extends T> eVar, @yt.k o0 o0Var, @yt.k r rVar, T t10) {
        q qVarC = c(eVar, 1);
        j jVarA = v.a(t10);
        return new l(jVarA, d(o0Var, qVarC.f38736d, qVarC.f38733a, jVarA, rVar, t10));
    }
}
