package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.z1;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.e3;
import kotlinx.coroutines.k1;
import kotlinx.coroutines.k3;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nDispatchedContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuationKt\n+ 4 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 5 CoroutineContext.kt\nkotlinx/coroutines/CoroutineContextKt\n*L\n1#1,315:1\n241#1,8:379\n253#1:387\n254#1,2:398\n256#1:402\n1#2:316\n1#2:322\n1#2:363\n295#3,5:317\n300#3,12:323\n312#3:357\n295#3,5:358\n300#3,12:364\n312#3:417\n198#4,3:335\n201#4,14:343\n198#4,3:376\n201#4,14:403\n95#5,5:338\n107#5,10:388\n118#5,2:400\n107#5,13:418\n*S KotlinDebug\n*F\n+ 1 DispatchedContinuation.kt\nkotlinx/coroutines/internal/DispatchedContinuation\n*L\n222#1:379,8\n223#1:387\n223#1:398,2\n223#1:402\n200#1:322\n221#1:363\n200#1:317,5\n200#1:323,12\n200#1:357\n221#1:358,5\n221#1:364,12\n221#1:417\n200#1:335,3\n200#1:343,14\n221#1:376,3\n221#1:403,14\n201#1:338,5\n223#1:388,10\n223#1:400,2\n253#1:418,13\n*E\n"})
public final class k<T> extends kotlinx.coroutines.a1<T> implements zj.c, kotlin.coroutines.c<T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public static final AtomicReferenceFieldUpdater f38803h = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_reusableCancellableContinuation");

    @yt.l
    @hk.v
    private volatile Object _reusableCancellableContinuation;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @hk.e
    @yt.k
    public final CoroutineDispatcher f38804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @hk.e
    @yt.k
    public final kotlin.coroutines.c<T> f38805e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @hk.e
    @yt.l
    public Object f38806f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @hk.e
    @yt.k
    public final Object f38807g;

    /* JADX WARN: Multi-variable type inference failed */
    public k(@yt.k CoroutineDispatcher coroutineDispatcher, @yt.k kotlin.coroutines.c<? super T> cVar) {
        super(-1);
        this.f38804d = coroutineDispatcher;
        this.f38805e = cVar;
        this.f38806f = l.f38809a;
        this.f38807g = ThreadContextKt.b(b());
    }

    public static /* synthetic */ void q() {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A(@yt.k java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.coroutines.c<T> r0 = r5.f38805e
            java.lang.Object r1 = r5.f38807g
            kotlin.coroutines.CoroutineContext r2 = r0.b()
            java.lang.Object r1 = kotlinx.coroutines.internal.ThreadContextKt.c(r2, r1)
            kotlinx.coroutines.internal.o0 r3 = kotlinx.coroutines.internal.ThreadContextKt.f38768a
            if (r1 == r3) goto L15
            kotlinx.coroutines.k3 r0 = kotlinx.coroutines.CoroutineContextKt.g(r0, r2, r1)
            goto L16
        L15:
            r0 = 0
        L16:
            r3 = 1
            kotlin.coroutines.c<T> r4 = r5.f38805e     // Catch: java.lang.Throwable -> L30
            r4.x(r6)     // Catch: java.lang.Throwable -> L30
            kotlin.z1 r6 = kotlin.z1.f38230a     // Catch: java.lang.Throwable -> L30
            kotlin.jvm.internal.c0.d(r3)
            if (r0 == 0) goto L29
            boolean r6 = r0.J1()
            if (r6 == 0) goto L2c
        L29:
            kotlinx.coroutines.internal.ThreadContextKt.a(r2, r1)
        L2c:
            kotlin.jvm.internal.c0.c(r3)
            return
        L30:
            r6 = move-exception
            kotlin.jvm.internal.c0.d(r3)
            if (r0 == 0) goto L3c
            boolean r0 = r0.J1()
            if (r0 == 0) goto L3f
        L3c:
            kotlinx.coroutines.internal.ThreadContextKt.a(r2, r1)
        L3f:
            kotlin.jvm.internal.c0.c(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.k.A(java.lang.Object):void");
    }

    @yt.l
    public final Throwable C(@yt.k kotlinx.coroutines.o<?> oVar) {
        o0 o0Var;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38803h;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            o0Var = l.f38810b;
            if (obj != o0Var) {
                if (obj instanceof Throwable) {
                    if (al.o.a(f38803h, this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!al.o.a(f38803h, this, o0Var, oVar));
        return null;
    }

    @Override // zj.c
    @yt.l
    public StackTraceElement D() {
        return null;
    }

    @Override // kotlin.coroutines.c
    @yt.k
    public CoroutineContext b() {
        return this.f38805e.b();
    }

    @Override // kotlinx.coroutines.a1
    public void c(@yt.l Object obj, @yt.k Throwable th2) {
        if (obj instanceof kotlinx.coroutines.d0) {
            ((kotlinx.coroutines.d0) obj).f38392b.i(th2);
        }
    }

    @Override // kotlinx.coroutines.a1
    @yt.k
    public kotlin.coroutines.c<T> e() {
        return this;
    }

    @Override // kotlinx.coroutines.a1
    @yt.l
    public Object j() {
        Object obj = this.f38806f;
        this.f38806f = l.f38809a;
        return obj;
    }

    public final void k() {
        while (f38803h.get(this) == l.f38810b) {
        }
    }

    @yt.l
    public final kotlinx.coroutines.p<T> l() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38803h;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                f38803h.set(this, l.f38810b);
                return null;
            }
            if (obj instanceof kotlinx.coroutines.p) {
                if (al.o.a(f38803h, this, obj, l.f38810b)) {
                    return (kotlinx.coroutines.p) obj;
                }
            } else if (obj != l.f38810b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final void m(@yt.k CoroutineContext coroutineContext, T t10) {
        this.f38806f = t10;
        this.f38266c = 1;
        this.f38804d.i2(coroutineContext, this);
    }

    public final kotlinx.coroutines.p<?> o() {
        Object obj = f38803h.get(this);
        if (obj instanceof kotlinx.coroutines.p) {
            return (kotlinx.coroutines.p) obj;
        }
        return null;
    }

    @Override // zj.c
    @yt.l
    public zj.c r() {
        kotlin.coroutines.c<T> cVar = this.f38805e;
        if (cVar instanceof zj.c) {
            return (zj.c) cVar;
        }
        return null;
    }

    public final boolean s() {
        return f38803h.get(this) != null;
    }

    public final void t(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, ik.l<Object, z1> lVar, Object obj) {
        while (true) {
            lVar.i(atomicReferenceFieldUpdater.get(obj));
        }
    }

    @yt.k
    public String toString() {
        return "DispatchedContinuation[" + this.f38804d + ", " + kotlinx.coroutines.r0.c(this.f38805e) + ']';
    }

    public final boolean u(@yt.k Throwable th2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38803h;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            o0 o0Var = l.f38810b;
            if (kotlin.jvm.internal.f0.g(obj, o0Var)) {
                if (al.o.a(f38803h, this, o0Var, th2)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (al.o.a(f38803h, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void v() {
        k();
        kotlinx.coroutines.p<?> pVarO = o();
        if (pVarO != null) {
            pVarO.u();
        }
    }

    @Override // kotlin.coroutines.c
    public void x(@yt.k Object obj) {
        CoroutineContext coroutineContextB = this.f38805e.b();
        Object objD = kotlinx.coroutines.h0.d(obj, null, 1, null);
        if (this.f38804d.j2(coroutineContextB)) {
            this.f38806f = objD;
            this.f38266c = 0;
            this.f38804d.h2(coroutineContextB, this);
            return;
        }
        k1 k1VarB = e3.f38471a.b();
        if (k1VarB.u2()) {
            this.f38806f = objD;
            this.f38266c = 0;
            k1VarB.p2(this);
            return;
        }
        k1VarB.r2(true);
        try {
            CoroutineContext coroutineContextB2 = b();
            Object objC = ThreadContextKt.c(coroutineContextB2, this.f38807g);
            try {
                this.f38805e.x(obj);
                z1 z1Var = z1.f38230a;
                while (k1VarB.x2()) {
                }
            } finally {
                ThreadContextKt.a(coroutineContextB2, objC);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    public final void y(@yt.k Object obj, @yt.l ik.l<? super Throwable, z1> lVar) {
        boolean z10;
        Object objB = kotlinx.coroutines.h0.b(obj, lVar);
        if (this.f38804d.j2(b())) {
            this.f38806f = objB;
            this.f38266c = 1;
            this.f38804d.h2(b(), this);
            return;
        }
        k1 k1VarB = e3.f38471a.b();
        if (k1VarB.u2()) {
            this.f38806f = objB;
            this.f38266c = 1;
            k1VarB.p2(this);
            return;
        }
        k1VarB.r2(true);
        try {
            c2 c2Var = (c2) b().c(c2.f38296x2);
            if (c2Var == null || c2Var.isActive()) {
                z10 = false;
            } else {
                CancellationException cancellationExceptionZ = c2Var.Z();
                c(objB, cancellationExceptionZ);
                Result.a aVar = Result.f37633a;
                x(Result.b(kotlin.u0.a(cancellationExceptionZ)));
                z10 = true;
            }
            if (!z10) {
                kotlin.coroutines.c<T> cVar = this.f38805e;
                Object obj2 = this.f38807g;
                CoroutineContext coroutineContextB = cVar.b();
                Object objC = ThreadContextKt.c(coroutineContextB, obj2);
                k3<?> k3VarG = objC != ThreadContextKt.f38768a ? CoroutineContextKt.g(cVar, coroutineContextB, objC) : null;
                try {
                    this.f38805e.x(obj);
                    z1 z1Var = z1.f38230a;
                    kotlin.jvm.internal.c0.d(1);
                    if (k3VarG == null || k3VarG.J1()) {
                        ThreadContextKt.a(coroutineContextB, objC);
                    }
                    kotlin.jvm.internal.c0.c(1);
                } catch (Throwable th2) {
                    kotlin.jvm.internal.c0.d(1);
                    if (k3VarG == null || k3VarG.J1()) {
                        ThreadContextKt.a(coroutineContextB, objC);
                    }
                    kotlin.jvm.internal.c0.c(1);
                    throw th2;
                }
            }
            while (k1VarB.x2()) {
            }
            kotlin.jvm.internal.c0.d(1);
        } catch (Throwable th3) {
            try {
                i(th3, null);
                kotlin.jvm.internal.c0.d(1);
            } catch (Throwable th4) {
                kotlin.jvm.internal.c0.d(1);
                k1VarB.m2(true);
                kotlin.jvm.internal.c0.c(1);
                throw th4;
            }
        }
        k1VarB.m2(true);
        kotlin.jvm.internal.c0.c(1);
    }

    public final boolean z(@yt.l Object obj) {
        c2 c2Var = (c2) b().c(c2.f38296x2);
        if (c2Var == null || c2Var.isActive()) {
            return false;
        }
        CancellationException cancellationExceptionZ = c2Var.Z();
        c(obj, cancellationExceptionZ);
        Result.a aVar = Result.f37633a;
        x(Result.b(kotlin.u0.a(cancellationExceptionZ)));
        return true;
    }
}
