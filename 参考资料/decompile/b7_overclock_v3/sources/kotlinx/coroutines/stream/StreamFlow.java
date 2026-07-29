package kotlinx.coroutines.stream;

import hk.v;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.Stream;
import kotlinx.coroutines.flow.e;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
public final class StreamFlow<T> implements e<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public static final AtomicIntegerFieldUpdater f39037b = AtomicIntegerFieldUpdater.newUpdater(StreamFlow.class, "consumed");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final Stream<T> f39038a;

    @v
    private volatile int consumed = 0;

    public StreamFlow(@k Stream<T> stream) {
        this.f39038a = stream;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.e
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(@yt.k kotlinx.coroutines.flow.f<? super T> r7, @yt.k kotlin.coroutines.c<? super kotlin.z1> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.stream.StreamFlow$collect$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.stream.StreamFlow$collect$1 r0 = (kotlinx.coroutines.stream.StreamFlow$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.stream.StreamFlow$collect$1 r0 = new kotlinx.coroutines.stream.StreamFlow$collect$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r7 = r0.L$2
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.flow.f r2 = (kotlinx.coroutines.flow.f) r2
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.stream.StreamFlow r4 = (kotlinx.coroutines.stream.StreamFlow) r4
            kotlin.u0.n(r8)     // Catch: java.lang.Throwable -> L36
            r8 = r2
            goto L56
        L36:
            r7 = move-exception
            goto L79
        L38:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L40:
            kotlin.u0.n(r8)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r8 = kotlinx.coroutines.stream.StreamFlow.f39037b
            r2 = 0
            boolean r8 = r8.compareAndSet(r6, r2, r3)
            if (r8 == 0) goto L7f
            java.util.stream.Stream<T> r8 = r6.f39038a     // Catch: java.lang.Throwable -> L77
            java.util.Iterator r8 = r8.iterator()     // Catch: java.lang.Throwable -> L77
            r4 = r6
            r5 = r8
            r8 = r7
            r7 = r5
        L56:
            boolean r2 = r7.hasNext()     // Catch: java.lang.Throwable -> L36
            if (r2 == 0) goto L6f
            java.lang.Object r2 = r7.next()     // Catch: java.lang.Throwable -> L36
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L36
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L36
            r0.L$2 = r7     // Catch: java.lang.Throwable -> L36
            r0.label = r3     // Catch: java.lang.Throwable -> L36
            java.lang.Object r2 = r8.f(r2, r0)     // Catch: java.lang.Throwable -> L36
            if (r2 != r1) goto L56
            return r1
        L6f:
            java.util.stream.Stream<T> r7 = r4.f39038a
            r7.close()
            kotlin.z1 r7 = kotlin.z1.f38230a
            return r7
        L77:
            r7 = move-exception
            r4 = r6
        L79:
            java.util.stream.Stream<T> r8 = r4.f39038a
            r8.close()
            throw r7
        L7f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Stream.consumeAsFlow can be collected only once"
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.stream.StreamFlow.a(kotlinx.coroutines.flow.f, kotlin.coroutines.c):java.lang.Object");
    }
}
