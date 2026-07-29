package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nConcurrentLinkedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 2 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListNode\n*L\n1#1,269:1\n46#1,8:284\n107#2,7:270\n107#2,7:277\n*S KotlinDebug\n*F\n+ 1 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n*L\n74#1:284,8\n27#1:270,7\n85#1:277,7\n*E\n"})
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38791a = 16;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final o0 f38792b = new o0("CLOSED");

    public static final boolean b(Object obj, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, int i10, ik.l<? super Integer, Boolean> lVar) {
        int i11;
        do {
            i11 = atomicIntegerFieldUpdater.get(obj);
            if (!lVar.i(Integer.valueOf(i11)).booleanValue()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(obj, i11, i11 + i10));
        return true;
    }

    public static final boolean c(Object obj, AtomicIntegerArray atomicIntegerArray, int i10, int i11, ik.l<? super Integer, Boolean> lVar) {
        int i12;
        do {
            i12 = atomicIntegerArray.get(i10);
            if (!lVar.i(Integer.valueOf(i12)).booleanValue()) {
                return false;
            }
        } while (!atomicIntegerArray.compareAndSet(i10, i12, i12 + i11));
        return true;
    }

    @yt.k
    public static final <N extends f<N>> N d(@yt.k N n10) {
        while (true) {
            Object objF = n10.f();
            if (objF == f38792b) {
                return n10;
            }
            f fVar = (f) objF;
            if (fVar != null) {
                n10 = (N) fVar;
            } else if (n10.j()) {
                return n10;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final Object e(@yt.l Object obj, @yt.k AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, long j10, @yt.k Object obj2, @yt.k ik.p<? super Long, Object, Object> pVar) {
        Object objG;
        boolean z10;
        do {
            objG = g(obj2, j10, pVar);
            if (!m0.h(objG)) {
                l0 l0VarF = m0.f(objG);
                while (true) {
                    l0 l0Var = (l0) atomicReferenceFieldUpdater.get(obj);
                    z10 = true;
                    if (l0Var.f38812c >= l0VarF.f38812c) {
                        break;
                    }
                    if (!l0VarF.s()) {
                        z10 = false;
                        break;
                    }
                    if (al.o.a(atomicReferenceFieldUpdater, obj, l0Var, l0VarF)) {
                        if (l0Var.o()) {
                            l0Var.l();
                        }
                    } else if (l0VarF.o()) {
                        l0VarF.l();
                    }
                }
            } else {
                break;
            }
        } while (!z10);
        return objG;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final Object f(@yt.l Object obj, @yt.k AtomicReferenceArray atomicReferenceArray, int i10, long j10, @yt.k Object obj2, @yt.k ik.p<? super Long, Object, Object> pVar) {
        Object objG;
        boolean z10;
        do {
            objG = g(obj2, j10, pVar);
            if (!m0.h(objG)) {
                l0 l0VarF = m0.f(objG);
                while (true) {
                    l0 l0Var = (l0) atomicReferenceArray.get(i10);
                    z10 = true;
                    if (l0Var.f38812c >= l0VarF.f38812c) {
                        break;
                    }
                    if (!l0VarF.s()) {
                        z10 = false;
                        break;
                    }
                    if (atomicReferenceArray.compareAndSet(i10, l0Var, l0VarF)) {
                        if (l0Var.o()) {
                            l0Var.l();
                        }
                    } else if (l0VarF.o()) {
                        l0VarF.l();
                    }
                }
            } else {
                break;
            }
        } while (!z10);
        return objG;
    }

    @yt.k
    public static final <S extends l0<S>> Object g(@yt.k S s10, long j10, @yt.k ik.p<? super Long, ? super S, ? extends S> pVar) {
        while (true) {
            if (s10.f38812c >= j10 && !s10.h()) {
                return m0.b(s10);
            }
            Object objF = s10.f();
            if (objF == f38792b) {
                return m0.b(f38792b);
            }
            S sR0 = (S) ((f) objF);
            if (sR0 == null) {
                sR0 = pVar.r0(Long.valueOf(s10.f38812c + 1), s10);
                if (s10.m(sR0)) {
                    if (s10.h()) {
                        s10.l();
                    }
                }
            }
            s10 = (Object) sR0;
        }
    }

    public static final void h(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, ik.l<Object, z1> lVar, Object obj) {
        while (true) {
            lVar.i(atomicReferenceFieldUpdater.get(obj));
        }
    }

    public static final void i(AtomicReferenceArray atomicReferenceArray, int i10, ik.l<Object, z1> lVar) {
        while (true) {
            lVar.i(atomicReferenceArray.get(i10));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean j(@yt.l Object obj, @yt.k AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, @yt.k Object obj2) {
        while (true) {
            l0 l0Var = (l0) atomicReferenceFieldUpdater.get(obj);
            if (l0Var.f38812c >= obj2.f38812c) {
                return true;
            }
            if (!obj2.s()) {
                return false;
            }
            if (al.o.a(atomicReferenceFieldUpdater, obj, l0Var, obj2)) {
                if (l0Var.o()) {
                    l0Var.l();
                }
                return true;
            }
            if (obj2.o()) {
                obj2.l();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean k(@yt.l Object obj, @yt.k AtomicReferenceArray atomicReferenceArray, int i10, @yt.k Object obj2) {
        while (true) {
            l0 l0Var = (l0) atomicReferenceArray.get(i10);
            if (l0Var.f38812c >= obj2.f38812c) {
                return true;
            }
            if (!obj2.s()) {
                return false;
            }
            if (atomicReferenceArray.compareAndSet(i10, l0Var, obj2)) {
                if (l0Var.o()) {
                    l0Var.l();
                }
                return true;
            }
            if (obj2.o()) {
                obj2.l();
            }
        }
    }
}
