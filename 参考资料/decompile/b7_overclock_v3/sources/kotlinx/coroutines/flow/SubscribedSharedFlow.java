package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
public final class SubscribedSharedFlow<T> implements n<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final n<T> f38665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final ik.p<f<? super T>, kotlin.coroutines.c<? super z1>, Object> f38666b;

    /* JADX WARN: Multi-variable type inference failed */
    public SubscribedSharedFlow(@yt.k n<? extends T> nVar, @yt.k ik.p<? super f<? super T>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        this.f38665a = nVar;
        this.f38666b = pVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.n, kotlinx.coroutines.flow.e
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(@yt.k kotlinx.coroutines.flow.f<? super T> r6, @yt.k kotlin.coroutines.c<?> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.SubscribedSharedFlow$collect$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.SubscribedSharedFlow$collect$1 r0 = (kotlinx.coroutines.flow.SubscribedSharedFlow$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.SubscribedSharedFlow$collect$1 r0 = new kotlinx.coroutines.flow.SubscribedSharedFlow$collect$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2d:
            kotlin.u0.n(r7)
            goto L46
        L31:
            kotlin.u0.n(r7)
            kotlinx.coroutines.flow.n<T> r7 = r5.f38665a
            kotlinx.coroutines.flow.SubscribedFlowCollector r2 = new kotlinx.coroutines.flow.SubscribedFlowCollector
            ik.p<kotlinx.coroutines.flow.f<? super T>, kotlin.coroutines.c<? super kotlin.z1>, java.lang.Object> r4 = r5.f38666b
            r2.<init>(r6, r4)
            r0.label = r3
            java.lang.Object r6 = r7.a(r2, r0)
            if (r6 != r1) goto L46
            return r1
        L46:
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SubscribedSharedFlow.a(kotlinx.coroutines.flow.f, kotlin.coroutines.c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.n
    @yt.k
    public List<T> b() {
        return this.f38665a.b();
    }
}
