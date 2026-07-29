package kotlinx.coroutines;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitKt\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,127:1\n37#2,2:128\n13579#3,2:130\n1855#4,2:132\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitKt\n*L\n42#1:128,2\n54#1:130,2\n66#1:132,2\n*E\n"})
public final class AwaitKt {
    @yt.l
    public static final <T> Object a(@yt.k Collection<? extends u0<? extends T>> collection, @yt.k kotlin.coroutines.c<? super List<? extends T>> cVar) {
        return collection.isEmpty() ? CollectionsKt__CollectionsKt.E() : new e((u0[]) collection.toArray(new u0[0])).c(cVar);
    }

    @yt.l
    public static final <T> Object b(@yt.k u0<? extends T>[] u0VarArr, @yt.k kotlin.coroutines.c<? super List<? extends T>> cVar) {
        return u0VarArr.length == 0 ? CollectionsKt__CollectionsKt.E() : new e(u0VarArr).c(cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(@yt.k java.util.Collection<? extends kotlinx.coroutines.c2> r4, @yt.k kotlin.coroutines.c<? super kotlin.z1> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.AwaitKt$joinAll$3
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.AwaitKt$joinAll$3 r0 = (kotlinx.coroutines.AwaitKt$joinAll$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.AwaitKt$joinAll$3 r0 = new kotlinx.coroutines.AwaitKt$joinAll$3
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            java.util.Iterator r4 = (java.util.Iterator) r4
            kotlin.u0.n(r5)
            goto L3c
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.u0.n(r5)
            java.util.Iterator r4 = r4.iterator()
        L3c:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L53
            java.lang.Object r5 = r4.next()
            kotlinx.coroutines.c2 r5 = (kotlinx.coroutines.c2) r5
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.T(r0)
            if (r5 != r1) goto L3c
            return r1
        L53:
            kotlin.z1 r4 = kotlin.z1.f38230a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.AwaitKt.c(java.util.Collection, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0052 -> B:19:0x0055). Please report as a decompilation issue!!! */
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object d(@yt.k kotlinx.coroutines.c2[] r5, @yt.k kotlin.coroutines.c<? super kotlin.z1> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.AwaitKt$joinAll$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.AwaitKt$joinAll$1 r0 = (kotlinx.coroutines.AwaitKt$joinAll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.AwaitKt$joinAll$1 r0 = new kotlinx.coroutines.AwaitKt$joinAll$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            int r5 = r0.I$1
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.c2[] r4 = (kotlinx.coroutines.c2[]) r4
            kotlin.u0.n(r6)
            r6 = r4
            goto L55
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            kotlin.u0.n(r6)
            r6 = 0
            int r2 = r5.length
            r6 = r5
            r5 = r2
            r2 = 0
        L42:
            if (r2 >= r5) goto L57
            r4 = r6[r2]
            r0.L$0 = r6
            r0.I$0 = r2
            r0.I$1 = r5
            r0.label = r3
            java.lang.Object r4 = r4.T(r0)
            if (r4 != r1) goto L55
            return r1
        L55:
            int r2 = r2 + r3
            goto L42
        L57:
            kotlin.z1 r5 = kotlin.z1.f38230a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.AwaitKt.d(kotlinx.coroutines.c2[], kotlin.coroutines.c):java.lang.Object");
    }
}
