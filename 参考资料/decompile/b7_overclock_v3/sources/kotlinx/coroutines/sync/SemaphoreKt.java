package kotlinx.coroutines.sync;

import kotlin.jvm.internal.c0;
import kotlinx.coroutines.internal.o0;
import kotlinx.coroutines.internal.t0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public final class SemaphoreKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f39063a = t0.e("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public static final o0 f39064b = new o0("PERMIT");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public static final o0 f39065c = new o0("TAKEN");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public static final o0 f39066d = new o0("BROKEN");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public static final o0 f39067e = new o0("CANCELLED");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f39068f = t0.e("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);

    @k
    public static final b a(int i10, int i11) {
        return new SemaphoreImpl(i10, i11);
    }

    public static /* synthetic */ b b(int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        return a(i10, i11);
    }

    public static final c j(long j10, c cVar) {
        return new c(j10, cVar, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object k(@yt.k kotlinx.coroutines.sync.b r4, @yt.k ik.a<? extends T> r5, @yt.k kotlin.coroutines.c<? super T> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = (kotlinx.coroutines.sync.SemaphoreKt$withPermit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = new kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.L$1
            r5 = r4
            ik.a r5 = (ik.a) r5
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.sync.b r4 = (kotlinx.coroutines.sync.b) r4
            kotlin.u0.n(r6)
            goto L4a
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.u0.n(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r4.d(r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            java.lang.Object r5 = r5.o()     // Catch: java.lang.Throwable -> L58
            kotlin.jvm.internal.c0.d(r3)
            r4.release()
            kotlin.jvm.internal.c0.c(r3)
            return r5
        L58:
            r5 = move-exception
            kotlin.jvm.internal.c0.d(r3)
            r4.release()
            kotlin.jvm.internal.c0.c(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreKt.k(kotlinx.coroutines.sync.b, ik.a, kotlin.coroutines.c):java.lang.Object");
    }

    public static final <T> Object l(b bVar, ik.a<? extends T> aVar, kotlin.coroutines.c<? super T> cVar) {
        c0.e(0);
        bVar.d(cVar);
        c0.e(1);
        try {
            return aVar.o();
        } finally {
            c0.d(1);
            bVar.release();
            c0.c(1);
        }
    }
}
