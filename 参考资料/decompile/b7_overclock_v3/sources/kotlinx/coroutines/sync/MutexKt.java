package kotlinx.coroutines.sync;

import kotlin.jvm.internal.c0;
import kotlinx.coroutines.internal.o0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public final class MutexKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final o0 f39049a = new o0("NO_OWNER");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public static final o0 f39050b = new o0("ALREADY_LOCKED_BY_OWNER");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f39051c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f39052d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f39053e = 2;

    @k
    public static final a a(boolean z10) {
        return new MutexImpl(z10);
    }

    public static /* synthetic */ a b(boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return a(z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object e(@yt.k kotlinx.coroutines.sync.a r4, @yt.l java.lang.Object r5, @yt.k ik.a<? extends T> r6, @yt.k kotlin.coroutines.c<? super T> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.sync.MutexKt$withLock$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.sync.MutexKt$withLock$1 r0 = (kotlinx.coroutines.sync.MutexKt$withLock$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.sync.MutexKt$withLock$1 r0 = new kotlinx.coroutines.sync.MutexKt$withLock$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.L$2
            r6 = r4
            ik.a r6 = (ik.a) r6
            java.lang.Object r5 = r0.L$1
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.sync.a r4 = (kotlinx.coroutines.sync.a) r4
            kotlin.u0.n(r7)
            goto L4e
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            kotlin.u0.n(r7)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r7 = r4.e(r5, r0)
            if (r7 != r1) goto L4e
            return r1
        L4e:
            java.lang.Object r6 = r6.o()     // Catch: java.lang.Throwable -> L5c
            kotlin.jvm.internal.c0.d(r3)
            r4.f(r5)
            kotlin.jvm.internal.c0.c(r3)
            return r6
        L5c:
            r6 = move-exception
            kotlin.jvm.internal.c0.d(r3)
            r4.f(r5)
            kotlin.jvm.internal.c0.c(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.MutexKt.e(kotlinx.coroutines.sync.a, java.lang.Object, ik.a, kotlin.coroutines.c):java.lang.Object");
    }

    public static final <T> Object f(a aVar, Object obj, ik.a<? extends T> aVar2, kotlin.coroutines.c<? super T> cVar) {
        c0.e(0);
        aVar.e(obj, cVar);
        c0.e(1);
        try {
            return aVar2.o();
        } finally {
            c0.d(1);
            aVar.f(obj);
            c0.c(1);
        }
    }

    public static /* synthetic */ Object g(a aVar, Object obj, ik.a aVar2, kotlin.coroutines.c cVar, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = null;
        }
        c0.e(0);
        aVar.e(obj, cVar);
        c0.e(1);
        try {
            return aVar2.o();
        } finally {
            c0.d(1);
            aVar.f(obj);
            c0.c(1);
        }
    }
}
