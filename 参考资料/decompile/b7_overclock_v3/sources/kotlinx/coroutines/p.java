package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.c2;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nCancellableContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImplKt\n+ 4 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,662:1\n230#1,2:666\n232#1,8:669\n230#1,10:677\n230#1,10:688\n1#2:663\n24#3:664\n24#3:665\n22#3:687\n21#3:698\n22#3,3:699\n21#3:702\n22#3,3:703\n22#3:711\n21#3,4:712\n22#4:668\n13#4:710\n61#5,2:706\n61#5,2:708\n61#5,2:716\n*S KotlinDebug\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CancellableContinuationImpl\n*L\n246#1:666,2\n246#1:669,8\n249#1:677,10\n254#1:688,10\n72#1:664\n158#1:665\n252#1:687\n277#1:698\n278#1:699,3\n287#1:702\n288#1:703,3\n389#1:711\n392#1:712,4\n246#1:668\n350#1:710\n329#1:706,2\n339#1:708,2\n613#1:716,2\n*E\n"})
@kotlin.s0
public class p<T> extends a1<T> implements o<T>, zj.c, m3 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final AtomicIntegerFieldUpdater f38924f = AtomicIntegerFieldUpdater.newUpdater(p.class, "_decisionAndIndex");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public static final AtomicReferenceFieldUpdater f38925g = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_state");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public static final AtomicReferenceFieldUpdater f38926h = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_parentHandle");

    @hk.v
    private volatile int _decisionAndIndex;

    @yt.l
    @hk.v
    private volatile Object _parentHandle;

    @yt.l
    @hk.v
    private volatile Object _state;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final kotlin.coroutines.c<T> f38927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final CoroutineContext f38928e;

    /* JADX WARN: Multi-variable type inference failed */
    public p(@yt.k kotlin.coroutines.c<? super T> cVar, int i10) {
        super(i10);
        this.f38927d = cVar;
        this.f38928e = cVar.b();
        this._decisionAndIndex = 536870911;
        this._state = d.f38390a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void X(p pVar, Object obj, int i10, ik.l lVar, int i11, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i11 & 4) != 0) {
            lVar = null;
        }
        pVar.W(obj, i10, lVar);
    }

    public final g1 A() {
        return (g1) f38926h.get(this);
    }

    @Override // kotlinx.coroutines.o
    public void B(@yt.k ik.l<? super Throwable, kotlin.z1> lVar) {
        H(N(lVar));
    }

    @yt.l
    @kotlin.s0
    public final Object C() {
        c2 c2Var;
        boolean zI = I();
        if (b0()) {
            if (A() == null) {
                G();
            }
            if (zI) {
                U();
            }
            return yj.b.h();
        }
        if (zI) {
            U();
        }
        Object objE = E();
        if (objE instanceof c0) {
            throw ((c0) objE).f38294a;
        }
        if (!b1.c(this.f38266c) || (c2Var = (c2) b().c(c2.f38296x2)) == null || c2Var.isActive()) {
            return h(objE);
        }
        CancellationException cancellationExceptionZ = c2Var.Z();
        c(objE, cancellationExceptionZ);
        throw cancellationExceptionZ;
    }

    @Override // zj.c
    @yt.l
    public StackTraceElement D() {
        return null;
    }

    @yt.l
    public final Object E() {
        return f38925g.get(this);
    }

    public final String F() {
        Object objE = E();
        return objE instanceof q2 ? "Active" : objE instanceof s ? "Cancelled" : "Completed";
    }

    public final g1 G() {
        c2 c2Var = (c2) b().c(c2.f38296x2);
        if (c2Var == null) {
            return null;
        }
        g1 g1VarG = c2.a.g(c2Var, true, false, new t(this), 2, null);
        al.o.a(f38926h, this, null, g1VarG);
        return g1VarG;
    }

    public final void H(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38925g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof d)) {
                if (obj2 instanceof m ? true : obj2 instanceof kotlinx.coroutines.internal.l0) {
                    P(obj, obj2);
                } else {
                    boolean z10 = obj2 instanceof c0;
                    if (z10) {
                        c0 c0Var = (c0) obj2;
                        if (!c0Var.b()) {
                            P(obj, obj2);
                        }
                        if (obj2 instanceof s) {
                            if (!z10) {
                                c0Var = null;
                            }
                            Throwable th2 = c0Var != null ? c0Var.f38294a : null;
                            if (obj instanceof m) {
                                m((m) obj, th2);
                                return;
                            } else {
                                kotlin.jvm.internal.f0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                                s((kotlinx.coroutines.internal.l0) obj, th2);
                                return;
                            }
                        }
                        return;
                    }
                    if (obj2 instanceof b0) {
                        b0 b0Var = (b0) obj2;
                        if (b0Var.f38282b != null) {
                            P(obj, obj2);
                        }
                        if (obj instanceof kotlinx.coroutines.internal.l0) {
                            return;
                        }
                        kotlin.jvm.internal.f0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        m mVar = (m) obj;
                        if (b0Var.h()) {
                            m(mVar, b0Var.f38285e);
                            return;
                        } else {
                            if (al.o.a(f38925g, this, obj2, b0.g(b0Var, null, mVar, null, null, null, 29, null))) {
                                return;
                            }
                        }
                    } else {
                        if (obj instanceof kotlinx.coroutines.internal.l0) {
                            return;
                        }
                        kotlin.jvm.internal.f0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                        if (al.o.a(f38925g, this, obj2, new b0(obj2, (m) obj, null, null, null, 28, null))) {
                            return;
                        }
                    }
                }
            } else if (al.o.a(f38925g, this, obj2, obj)) {
                return;
            }
        }
    }

    public final boolean I() {
        if (b1.d(this.f38266c)) {
            kotlin.coroutines.c<T> cVar = this.f38927d;
            kotlin.jvm.internal.f0.n(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (((kotlinx.coroutines.internal.k) cVar).s()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlinx.coroutines.o
    @yt.l
    public Object J(@yt.k Throwable th2) {
        return a0(new c0(th2, false, 2, null), null, null);
    }

    @Override // kotlinx.coroutines.o
    public void K(@yt.k CoroutineDispatcher coroutineDispatcher, @yt.k Throwable th2) {
        kotlin.coroutines.c<T> cVar = this.f38927d;
        kotlinx.coroutines.internal.k kVar = cVar instanceof kotlinx.coroutines.internal.k ? (kotlinx.coroutines.internal.k) cVar : null;
        X(this, new c0(th2, false, 2, null), (kVar != null ? kVar.f38804d : null) == coroutineDispatcher ? 4 : this.f38266c, null, 4, null);
    }

    public final void L(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, ik.l<? super Integer, kotlin.z1> lVar, Object obj) {
        while (true) {
            lVar.i(Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }

    public final void M(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, ik.l<Object, kotlin.z1> lVar, Object obj) {
        while (true) {
            lVar.i(atomicReferenceFieldUpdater.get(obj));
        }
    }

    public final m N(ik.l<? super Throwable, kotlin.z1> lVar) {
        return lVar instanceof m ? (m) lVar : new z1(lVar);
    }

    @Override // kotlinx.coroutines.o
    public void O(@yt.k CoroutineDispatcher coroutineDispatcher, T t10) {
        kotlin.coroutines.c<T> cVar = this.f38927d;
        kotlinx.coroutines.internal.k kVar = cVar instanceof kotlinx.coroutines.internal.k ? (kotlinx.coroutines.internal.k) cVar : null;
        X(this, t10, (kVar != null ? kVar.f38804d : null) == coroutineDispatcher ? 4 : this.f38266c, null, 4, null);
    }

    public final void P(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    @Override // kotlinx.coroutines.o
    public void Q() {
        g1 g1VarG = G();
        if (g1VarG != null && n()) {
            g1VarG.dispose();
            f38926h.set(this, p2.f38929a);
        }
    }

    @Override // kotlinx.coroutines.o
    public void R(T t10, @yt.l ik.l<? super Throwable, kotlin.z1> lVar) {
        W(t10, this.f38266c, lVar);
    }

    @yt.k
    public String S() {
        return "CancellableContinuation";
    }

    public final void T(@yt.k Throwable th2) {
        if (t(th2)) {
            return;
        }
        d(th2);
        v();
    }

    public final void U() {
        Throwable thC;
        kotlin.coroutines.c<T> cVar = this.f38927d;
        kotlinx.coroutines.internal.k kVar = cVar instanceof kotlinx.coroutines.internal.k ? (kotlinx.coroutines.internal.k) cVar : null;
        if (kVar == null || (thC = kVar.C(this)) == null) {
            return;
        }
        u();
        d(thC);
    }

    @hk.h(name = "resetStateReusable")
    public final boolean V() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38925g;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if ((obj instanceof b0) && ((b0) obj).f38284d != null) {
            u();
            return false;
        }
        f38924f.set(this, 536870911);
        atomicReferenceFieldUpdater.set(this, d.f38390a);
        return true;
    }

    public final void W(Object obj, int i10, ik.l<? super Throwable, kotlin.z1> lVar) {
        Object obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38925g;
        do {
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof q2)) {
                if (obj2 instanceof s) {
                    s sVar = (s) obj2;
                    if (sVar.c()) {
                        if (lVar != null) {
                            q(lVar, sVar.f38294a);
                            return;
                        }
                        return;
                    }
                }
                k(obj);
                throw new KotlinNothingValueException();
            }
        } while (!al.o.a(f38925g, this, obj2, Y((q2) obj2, obj, i10, lVar, null)));
        v();
        y(i10);
    }

    public final Object Y(q2 q2Var, Object obj, int i10, ik.l<? super Throwable, kotlin.z1> lVar, Object obj2) {
        if (obj instanceof c0) {
            return obj;
        }
        if (!b1.c(i10) && obj2 == null) {
            return obj;
        }
        if (lVar == null && !(q2Var instanceof m) && obj2 == null) {
            return obj;
        }
        return new b0(obj, q2Var instanceof m ? (m) q2Var : null, lVar, obj2, null, 16, null);
    }

    public final boolean Z() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f38924f;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f38924f.compareAndSet(this, i10, 1073741824 + (536870911 & i10)));
        return true;
    }

    public final kotlinx.coroutines.internal.o0 a0(Object obj, Object obj2, ik.l<? super Throwable, kotlin.z1> lVar) {
        Object obj3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38925g;
        do {
            obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof q2)) {
                if ((obj3 instanceof b0) && obj2 != null && ((b0) obj3).f38284d == obj2) {
                    return q.f38936g;
                }
                return null;
            }
        } while (!al.o.a(f38925g, this, obj3, Y((q2) obj3, obj, this.f38266c, lVar, obj2)));
        v();
        return q.f38936g;
    }

    @Override // kotlin.coroutines.c
    @yt.k
    public CoroutineContext b() {
        return this.f38928e;
    }

    public final boolean b0() {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f38924f;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f38924f.compareAndSet(this, i10, 536870912 + (536870911 & i10)));
        return true;
    }

    @Override // kotlinx.coroutines.a1
    public void c(@yt.l Object obj, @yt.k Throwable th2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38925g;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof q2) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof c0) {
                return;
            }
            if (obj2 instanceof b0) {
                b0 b0Var = (b0) obj2;
                if (!(!b0Var.h())) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (al.o.a(f38925g, this, obj2, b0.g(b0Var, null, null, null, null, th2, 15, null))) {
                    b0Var.i(this, th2);
                    return;
                }
            } else if (al.o.a(f38925g, this, obj2, new b0(obj2, null, null, null, th2, 14, null))) {
                return;
            }
        }
    }

    public final void c0(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, ik.l<? super Integer, Integer> lVar, Object obj) {
        int i10;
        do {
            i10 = atomicIntegerFieldUpdater.get(obj);
        } while (!atomicIntegerFieldUpdater.compareAndSet(obj, i10, lVar.i(Integer.valueOf(i10)).intValue()));
    }

    @Override // kotlinx.coroutines.o
    public boolean d(@yt.l Throwable th2) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38925g;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof q2)) {
                return false;
            }
        } while (!al.o.a(f38925g, this, obj, new s(this, th2, (obj instanceof m) || (obj instanceof kotlinx.coroutines.internal.l0))));
        q2 q2Var = (q2) obj;
        if (q2Var instanceof m) {
            m((m) obj, th2);
        } else if (q2Var instanceof kotlinx.coroutines.internal.l0) {
            s((kotlinx.coroutines.internal.l0) obj, th2);
        }
        v();
        y(this.f38266c);
        return true;
    }

    @Override // kotlinx.coroutines.a1
    @yt.k
    public final kotlin.coroutines.c<T> e() {
        return this.f38927d;
    }

    @Override // kotlinx.coroutines.a1
    @yt.l
    public Throwable f(@yt.l Object obj) {
        Throwable thF = super.f(obj);
        if (thF != null) {
            return thF;
        }
        return null;
    }

    @Override // kotlinx.coroutines.m3
    public void g(@yt.k kotlinx.coroutines.internal.l0<?> l0Var, int i10) {
        int i11;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f38924f;
        do {
            i11 = atomicIntegerFieldUpdater.get(this);
            if (!((i11 & 536870911) == 536870911)) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i11, ((i11 >> 29) << 29) + i10));
        H(l0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.a1
    public <T> T h(@yt.l Object obj) {
        return obj instanceof b0 ? (T) ((b0) obj).f38281a : obj;
    }

    @Override // kotlinx.coroutines.o
    public boolean isActive() {
        return E() instanceof q2;
    }

    @Override // kotlinx.coroutines.o
    public boolean isCancelled() {
        return E() instanceof s;
    }

    @Override // kotlinx.coroutines.a1
    @yt.l
    public Object j() {
        return E();
    }

    public final Void k(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    public final void l(ik.l<? super Throwable, kotlin.z1> lVar, Throwable th2) {
        try {
            lVar.i(th2);
        } catch (Throwable th3) {
            l0.b(b(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th3));
        }
    }

    @Override // kotlinx.coroutines.o
    public void l0(@yt.k Object obj) {
        y(this.f38266c);
    }

    public final void m(@yt.k m mVar, @yt.l Throwable th2) {
        try {
            mVar.s(th2);
        } catch (Throwable th3) {
            l0.b(b(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th3));
        }
    }

    @Override // kotlinx.coroutines.o
    public boolean n() {
        return !(E() instanceof q2);
    }

    public final void o(ik.a<kotlin.z1> aVar) {
        try {
            aVar.o();
        } catch (Throwable th2) {
            l0.b(b(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    @Override // kotlinx.coroutines.o
    @yt.l
    public Object p(T t10, @yt.l Object obj) {
        return a0(t10, obj, null);
    }

    public final void q(@yt.k ik.l<? super Throwable, kotlin.z1> lVar, @yt.k Throwable th2) {
        try {
            lVar.i(th2);
        } catch (Throwable th3) {
            l0.b(b(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th3));
        }
    }

    @Override // zj.c
    @yt.l
    public zj.c r() {
        kotlin.coroutines.c<T> cVar = this.f38927d;
        if (cVar instanceof zj.c) {
            return (zj.c) cVar;
        }
        return null;
    }

    public final void s(kotlinx.coroutines.internal.l0<?> l0Var, Throwable th2) {
        int i10 = f38924f.get(this) & 536870911;
        if (!(i10 != 536870911)) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
        }
        try {
            l0Var.q(i10, th2, b());
        } catch (Throwable th3) {
            l0.b(b(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th3));
        }
    }

    public final boolean t(Throwable th2) {
        if (!I()) {
            return false;
        }
        kotlin.coroutines.c<T> cVar = this.f38927d;
        kotlin.jvm.internal.f0.n(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((kotlinx.coroutines.internal.k) cVar).u(th2);
    }

    @yt.k
    public String toString() {
        return S() + '(' + r0.c(this.f38927d) + "){" + F() + "}@" + r0.b(this);
    }

    public final void u() {
        g1 g1VarA = A();
        if (g1VarA == null) {
            return;
        }
        g1VarA.dispose();
        f38926h.set(this, p2.f38929a);
    }

    public final void v() {
        if (I()) {
            return;
        }
        u();
    }

    @Override // kotlinx.coroutines.o
    @yt.l
    public Object w(T t10, @yt.l Object obj, @yt.l ik.l<? super Throwable, kotlin.z1> lVar) {
        return a0(t10, obj, lVar);
    }

    @Override // kotlin.coroutines.c
    public void x(@yt.k Object obj) {
        X(this, h0.c(obj, this), this.f38266c, null, 4, null);
    }

    public final void y(int i10) {
        if (Z()) {
            return;
        }
        b1.a(this, i10);
    }

    @yt.k
    public Throwable z(@yt.k c2 c2Var) {
        return c2Var.Z();
    }
}
