package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nStateFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowSlot\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,428:1\n1#2:429\n314#3,11:430\n*S KotlinDebug\n*F\n+ 1 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowSlot\n*L\n298#1:430,11\n*E\n"})
public final class w extends kotlinx.coroutines.flow.internal.c<StateFlowImpl<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final AtomicReferenceFieldUpdater f38743a = AtomicReferenceFieldUpdater.newUpdater(w.class, Object.class, "_state");

    @yt.l
    @hk.v
    private volatile Object _state;

    @Override // kotlinx.coroutines.flow.internal.c
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@yt.k StateFlowImpl<?> stateFlowImpl) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38743a;
        if (atomicReferenceFieldUpdater.get(this) != null) {
            return false;
        }
        atomicReferenceFieldUpdater.set(this, v.f38741a);
        return true;
    }

    @yt.l
    public final Object e(@yt.k kotlin.coroutines.c<? super z1> cVar) {
        kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        pVar.Q();
        if (!al.o.a(f38743a, this, v.f38741a, pVar)) {
            Result.a aVar = Result.f37633a;
            pVar.x(Result.b(z1.f38230a));
        }
        Object objC = pVar.C();
        if (objC == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objC == yj.b.h() ? objC : z1.f38230a;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    @yt.k
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public kotlin.coroutines.c<z1>[] b(@yt.k StateFlowImpl<?> stateFlowImpl) {
        f38743a.set(this, null);
        return kotlinx.coroutines.flow.internal.b.f38713a;
    }

    public final void g(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, ik.l<Object, z1> lVar, Object obj) {
        while (true) {
            lVar.i(atomicReferenceFieldUpdater.get(obj));
        }
    }

    public final void h() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38743a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null || obj == v.f38742b) {
                return;
            }
            if (obj == v.f38741a) {
                if (al.o.a(f38743a, this, obj, v.f38742b)) {
                    return;
                }
            } else if (al.o.a(f38743a, this, obj, v.f38741a)) {
                Result.a aVar = Result.f37633a;
                ((kotlinx.coroutines.p) obj).x(Result.b(z1.f38230a));
                return;
            }
        }
    }

    public final boolean i() {
        Object andSet = f38743a.getAndSet(this, v.f38741a);
        f0.m(andSet);
        return andSet == v.f38742b;
    }
}
