package io.reactivex.internal.util;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import xi.g0;

/* JADX INFO: loaded from: classes5.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f35269a = Long.MIN_VALUE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f35270b = Long.MAX_VALUE;

    public n() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> boolean a(boolean z10, boolean z11, bu.d<?> dVar, boolean z12, fj.o<?> oVar, m<T, U> mVar) {
        if (mVar.c()) {
            oVar.clear();
            return true;
        }
        if (!z10) {
            return false;
        }
        if (z12) {
            if (!z11) {
                return false;
            }
            Throwable thE = mVar.e();
            if (thE != null) {
                dVar.onError(thE);
            } else {
                dVar.onComplete();
            }
            return true;
        }
        Throwable thE2 = mVar.e();
        if (thE2 != null) {
            oVar.clear();
            dVar.onError(thE2);
            return true;
        }
        if (!z11) {
            return false;
        }
        dVar.onComplete();
        return true;
    }

    public static <T, U> boolean b(boolean z10, boolean z11, g0<?> g0Var, boolean z12, fj.o<?> oVar, io.reactivex.disposables.b bVar, j<T, U> jVar) {
        if (jVar.c()) {
            oVar.clear();
            bVar.dispose();
            return true;
        }
        if (!z10) {
            return false;
        }
        if (z12) {
            if (!z11) {
                return false;
            }
            if (bVar != null) {
                bVar.dispose();
            }
            Throwable thE = jVar.e();
            if (thE != null) {
                g0Var.onError(thE);
            } else {
                g0Var.onComplete();
            }
            return true;
        }
        Throwable thE2 = jVar.e();
        if (thE2 != null) {
            oVar.clear();
            if (bVar != null) {
                bVar.dispose();
            }
            g0Var.onError(thE2);
            return true;
        }
        if (!z11) {
            return false;
        }
        if (bVar != null) {
            bVar.dispose();
        }
        g0Var.onComplete();
        return true;
    }

    public static <T> fj.o<T> c(int i10) {
        return i10 < 0 ? new io.reactivex.internal.queue.a(-i10) : new SpscArrayQueue(i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
    
        r1 = r15.f(-r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
    
        if (r1 != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T, U> void d(fj.n<T> r11, xi.g0<? super U> r12, boolean r13, io.reactivex.disposables.b r14, io.reactivex.internal.util.j<T, U> r15) {
        /*
            r0 = 1
            r1 = 1
        L2:
            boolean r2 = r15.b()
            boolean r3 = r11.isEmpty()
            r4 = r12
            r5 = r13
            r6 = r11
            r7 = r14
            r8 = r15
            boolean r2 = b(r2, r3, r4, r5, r6, r7, r8)
            if (r2 == 0) goto L16
            return
        L16:
            boolean r3 = r15.b()
            java.lang.Object r2 = r11.poll()
            if (r2 != 0) goto L22
            r10 = 1
            goto L24
        L22:
            r4 = 0
            r10 = 0
        L24:
            r4 = r10
            r5 = r12
            r6 = r13
            r7 = r11
            r8 = r14
            r9 = r15
            boolean r3 = b(r3, r4, r5, r6, r7, r8, r9)
            if (r3 == 0) goto L31
            return
        L31:
            if (r10 == 0) goto L3b
            int r1 = -r1
            int r1 = r15.f(r1)
            if (r1 != 0) goto L2
            return
        L3b:
            r15.g(r12, r2)
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.n.d(fj.n, xi.g0, boolean, io.reactivex.disposables.b, io.reactivex.internal.util.j):void");
    }

    public static <T, U> void e(fj.n<T> nVar, bu.d<? super U> dVar, boolean z10, io.reactivex.disposables.b bVar, m<T, U> mVar) {
        int iF = 1;
        while (true) {
            boolean zB = mVar.b();
            T tPoll = nVar.poll();
            boolean z11 = tPoll == null;
            if (a(zB, z11, dVar, z10, nVar, mVar)) {
                if (bVar != null) {
                    bVar.dispose();
                    return;
                }
                return;
            } else if (z11) {
                iF = mVar.f(-iF);
                if (iF == 0) {
                    return;
                }
            } else {
                long jD = mVar.d();
                if (jD == 0) {
                    nVar.clear();
                    if (bVar != null) {
                        bVar.dispose();
                    }
                    dVar.onError(new MissingBackpressureException("Could not emit value due to lack of requests."));
                    return;
                }
                if (mVar.h(dVar, tPoll) && jD != Long.MAX_VALUE) {
                    mVar.g(1L);
                }
            }
        }
    }

    public static boolean f(dj.e eVar) {
        try {
            return eVar.a();
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            return true;
        }
    }

    public static <T> void g(bu.d<? super T> dVar, Queue<T> queue, AtomicLong atomicLong, dj.e eVar) {
        long j10;
        long j11;
        if (queue.isEmpty()) {
            dVar.onComplete();
            return;
        }
        if (h(atomicLong.get(), dVar, queue, atomicLong, eVar)) {
            return;
        }
        do {
            j10 = atomicLong.get();
            if ((j10 & Long.MIN_VALUE) != 0) {
                return;
            } else {
                j11 = j10 | Long.MIN_VALUE;
            }
        } while (!atomicLong.compareAndSet(j10, j11));
        if (j10 != 0) {
            h(j11, dVar, queue, atomicLong, eVar);
        }
    }

    public static <T> boolean h(long j10, bu.d<? super T> dVar, Queue<T> queue, AtomicLong atomicLong, dj.e eVar) {
        long j11 = j10 & Long.MIN_VALUE;
        while (true) {
            if (j11 != j10) {
                if (f(eVar)) {
                    return true;
                }
                T tPoll = queue.poll();
                if (tPoll == null) {
                    dVar.onComplete();
                    return true;
                }
                dVar.onNext(tPoll);
                j11++;
            } else {
                if (f(eVar)) {
                    return true;
                }
                if (queue.isEmpty()) {
                    dVar.onComplete();
                    return true;
                }
                j10 = atomicLong.get();
                if (j10 == j11) {
                    long jAddAndGet = atomicLong.addAndGet(-(j11 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & jAddAndGet) == 0) {
                        return false;
                    }
                    j10 = jAddAndGet;
                    j11 = jAddAndGet & Long.MIN_VALUE;
                } else {
                    continue;
                }
            }
        }
    }

    public static <T> boolean i(long j10, bu.d<? super T> dVar, Queue<T> queue, AtomicLong atomicLong, dj.e eVar) {
        long j11;
        do {
            j11 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j11, b.c(Long.MAX_VALUE & j11, j10) | (j11 & Long.MIN_VALUE)));
        if (j11 != Long.MIN_VALUE) {
            return false;
        }
        h(j10 | Long.MIN_VALUE, dVar, queue, atomicLong, eVar);
        return true;
    }

    public static void j(bu.e eVar, int i10) {
        eVar.request(i10 < 0 ? Long.MAX_VALUE : i10);
    }
}
