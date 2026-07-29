package androidx.activity;

import kotlin.jvm.internal.c0;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
public final class FullyDrawnReporterKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, kotlin.z1] */
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(@yt.k androidx.activity.l r4, @yt.k ik.l<? super kotlin.coroutines.c<? super kotlin.z1>, ? extends java.lang.Object> r5, @yt.k kotlin.coroutines.c<? super kotlin.z1> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1 r0 = (androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1 r0 = new androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            androidx.activity.l r4 = (androidx.activity.l) r4
            kotlin.u0.n(r6)     // Catch: java.lang.Throwable -> L5b
            goto L4f
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.u0.n(r6)
            r4.c()
            boolean r6 = r4.e()
            if (r6 == 0) goto L44
            kotlin.z1 r4 = kotlin.z1.f38230a
            return r4
        L44:
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L5b
            r0.label = r3     // Catch: java.lang.Throwable -> L5b
            java.lang.Object r5 = r5.i(r0)     // Catch: java.lang.Throwable -> L5b
            if (r5 != r1) goto L4f
            return r1
        L4f:
            kotlin.jvm.internal.c0.d(r3)
            r4.h()
            kotlin.jvm.internal.c0.c(r3)
            kotlin.z1 r4 = kotlin.z1.f38230a
            return r4
        L5b:
            r5 = move-exception
            kotlin.jvm.internal.c0.d(r3)
            r4.h()
            kotlin.jvm.internal.c0.c(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.FullyDrawnReporterKt.a(androidx.activity.l, ik.l, kotlin.coroutines.c):java.lang.Object");
    }

    public static final Object b(l lVar, ik.l<? super kotlin.coroutines.c<? super z1>, ? extends Object> lVar2, kotlin.coroutines.c<? super z1> cVar) {
        lVar.c();
        if (lVar.e()) {
            return z1.f38230a;
        }
        try {
            lVar2.i(cVar);
            c0.d(1);
            lVar.h();
            c0.c(1);
            return z1.f38230a;
        } catch (Throwable th2) {
            c0.d(1);
            lVar.h();
            c0.c(1);
            throw th2;
        }
    }
}
