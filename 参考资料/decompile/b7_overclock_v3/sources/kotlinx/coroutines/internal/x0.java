package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.z1;
import kotlinx.coroutines.internal.y0;
import kotlinx.coroutines.y1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nThreadSafeHeap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,168:1\n28#2,4:169\n28#2,4:174\n28#2,4:179\n28#2,4:184\n28#2,4:189\n28#2,4:194\n28#2,4:199\n28#2,4:204\n20#3:173\n20#3:178\n20#3:183\n20#3:188\n20#3:193\n20#3:198\n20#3:203\n20#3:208\n1#4:209\n*S KotlinDebug\n*F\n+ 1 ThreadSafeHeap.kt\nkotlinx/coroutines/internal/ThreadSafeHeap\n*L\n35#1:169,4\n42#1:174,4\n50#1:179,4\n52#1:184,4\n60#1:189,4\n69#1:194,4\n72#1:199,4\n81#1:204,4\n35#1:173\n42#1:178\n50#1:183\n52#1:188\n60#1:193\n69#1:198\n72#1:203\n81#1:208\n*E\n"})
@y1
public class x0<T extends y0 & Comparable<? super T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final AtomicIntegerFieldUpdater f38866b = AtomicIntegerFieldUpdater.newUpdater(x0.class, "_size");

    @hk.v
    private volatile int _size;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.l
    public T[] f38867a;

    @kotlin.s0
    public final void a(@yt.k T t10) {
        t10.g(this);
        y0[] y0VarArrJ = j();
        int iG = g();
        o(iG + 1);
        y0VarArrJ[iG] = t10;
        t10.f(iG);
        q(iG);
    }

    public final void b(@yt.k T t10) {
        synchronized (this) {
            a(t10);
            z1 z1Var = z1.f38230a;
        }
    }

    public final boolean c(@yt.k T t10, @yt.k ik.l<? super T, Boolean> lVar) {
        boolean z10;
        synchronized (this) {
            try {
                if (lVar.i(f()).booleanValue()) {
                    a(t10);
                    z10 = true;
                } else {
                    z10 = false;
                }
                kotlin.jvm.internal.c0.d(1);
            } catch (Throwable th2) {
                kotlin.jvm.internal.c0.d(1);
                kotlin.jvm.internal.c0.c(1);
                throw th2;
            }
        }
        kotlin.jvm.internal.c0.c(1);
        return z10;
    }

    public final void d() {
        synchronized (this) {
            T[] tArr = this.f38867a;
            if (tArr != null) {
                kotlin.collections.m.w2(tArr, null, 0, 0, 6, null);
            }
            f38866b.set(this, 0);
            z1 z1Var = z1.f38230a;
        }
    }

    @yt.l
    public final T e(@yt.k ik.l<? super T, Boolean> lVar) {
        T t10;
        synchronized (this) {
            int i10 = 0;
            int iG = g();
            while (true) {
                t10 = null;
                if (i10 >= iG) {
                    break;
                }
                T[] tArr = this.f38867a;
                if (tArr != null) {
                    t10 = (Object) tArr[i10];
                }
                kotlin.jvm.internal.f0.m(t10);
                if (lVar.i(t10).booleanValue()) {
                    break;
                }
                i10++;
            }
        }
        return t10;
    }

    @yt.l
    @kotlin.s0
    public final T f() {
        T[] tArr = this.f38867a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int g() {
        return f38866b.get(this);
    }

    public final boolean h() {
        return g() == 0;
    }

    @yt.l
    public final T i() {
        T t10;
        synchronized (this) {
            t10 = (T) f();
        }
        return t10;
    }

    public final T[] j() {
        T[] tArr = this.f38867a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new y0[4];
            this.f38867a = tArr2;
            return tArr2;
        }
        if (g() < tArr.length) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, g() * 2);
        kotlin.jvm.internal.f0.o(objArrCopyOf, "copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((y0[]) objArrCopyOf);
        this.f38867a = tArr3;
        return tArr3;
    }

    public final boolean k(@yt.k T t10) {
        boolean z10;
        synchronized (this) {
            if (t10.h() == null) {
                z10 = false;
            } else {
                l(t10.S());
                z10 = true;
            }
        }
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003a  */
    @kotlin.s0
    @yt.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final T l(int r6) {
        /*
            r5 = this;
            T extends kotlinx.coroutines.internal.y0 & java.lang.Comparable<? super T>[] r0 = r5.f38867a
            kotlin.jvm.internal.f0.m(r0)
            int r1 = r5.g()
            r2 = -1
            int r1 = r1 + r2
            r5.o(r1)
            int r1 = r5.g()
            if (r6 >= r1) goto L3d
            int r1 = r5.g()
            r5.r(r6, r1)
            int r1 = r6 + (-1)
            int r1 = r1 / 2
            if (r6 <= 0) goto L3a
            r3 = r0[r6]
            kotlin.jvm.internal.f0.m(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r0[r1]
            kotlin.jvm.internal.f0.m(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L3a
            r5.r(r6, r1)
            r5.q(r1)
            goto L3d
        L3a:
            r5.p(r6)
        L3d:
            int r6 = r5.g()
            r6 = r0[r6]
            kotlin.jvm.internal.f0.m(r6)
            r1 = 0
            r6.g(r1)
            r6.f(r2)
            int r2 = r5.g()
            r0[r2] = r1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.x0.l(int):kotlinx.coroutines.internal.y0");
    }

    @yt.l
    public final T m(@yt.k ik.l<? super T, Boolean> lVar) {
        synchronized (this) {
            try {
                y0 y0VarF = f();
                T t10 = null;
                if (y0VarF == null) {
                    kotlin.jvm.internal.c0.d(2);
                    kotlin.jvm.internal.c0.c(2);
                    return null;
                }
                if (lVar.i(y0VarF).booleanValue()) {
                    t10 = (T) l(0);
                }
                kotlin.jvm.internal.c0.d(1);
                kotlin.jvm.internal.c0.c(1);
                return t10;
            } catch (Throwable th2) {
                kotlin.jvm.internal.c0.d(1);
                kotlin.jvm.internal.c0.c(1);
                throw th2;
            }
        }
    }

    @yt.l
    public final T n() {
        T t10;
        synchronized (this) {
            t10 = g() > 0 ? (T) l(0) : null;
        }
        return t10;
    }

    public final void o(int i10) {
        f38866b.set(this, i10);
    }

    public final void p(int i10) {
        while (true) {
            int i11 = (i10 * 2) + 1;
            if (i11 >= g()) {
                return;
            }
            T[] tArr = this.f38867a;
            kotlin.jvm.internal.f0.m(tArr);
            int i12 = i11 + 1;
            if (i12 < g()) {
                T t10 = tArr[i12];
                kotlin.jvm.internal.f0.m(t10);
                T t11 = tArr[i11];
                kotlin.jvm.internal.f0.m(t11);
                if (((Comparable) t10).compareTo(t11) < 0) {
                    i11 = i12;
                }
            }
            T t12 = tArr[i10];
            kotlin.jvm.internal.f0.m(t12);
            T t13 = tArr[i11];
            kotlin.jvm.internal.f0.m(t13);
            if (((Comparable) t12).compareTo(t13) <= 0) {
                return;
            }
            r(i10, i11);
            i10 = i11;
        }
    }

    public final void q(int i10) {
        while (i10 > 0) {
            T[] tArr = this.f38867a;
            kotlin.jvm.internal.f0.m(tArr);
            int i11 = (i10 - 1) / 2;
            T t10 = tArr[i11];
            kotlin.jvm.internal.f0.m(t10);
            T t11 = tArr[i10];
            kotlin.jvm.internal.f0.m(t11);
            if (((Comparable) t10).compareTo(t11) <= 0) {
                return;
            }
            r(i10, i11);
            i10 = i11;
        }
    }

    public final void r(int i10, int i11) {
        T[] tArr = this.f38867a;
        kotlin.jvm.internal.f0.m(tArr);
        T t10 = tArr[i11];
        kotlin.jvm.internal.f0.m(t10);
        T t11 = tArr[i10];
        kotlin.jvm.internal.f0.m(t11);
        tArr[i10] = t10;
        tArr[i11] = t11;
        t10.f(i10);
        t11.f(i11);
    }
}
