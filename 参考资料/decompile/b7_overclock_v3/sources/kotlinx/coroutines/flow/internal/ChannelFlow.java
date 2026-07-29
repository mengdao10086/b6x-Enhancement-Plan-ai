package kotlinx.coroutines.flow.internal;

import ik.p;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.q;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.y1;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nChannelFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelFlow.kt\nkotlinx/coroutines/flow/internal/ChannelFlow\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,245:1\n1#2:246\n*E\n"})
@y1
public abstract class ChannelFlow<T> implements i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    @yt.k
    public final CoroutineContext f38674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    public final int f38675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @hk.e
    @yt.k
    public final BufferOverflow f38676c;

    public ChannelFlow(@yt.k CoroutineContext coroutineContext, int i10, @yt.k BufferOverflow bufferOverflow) {
        this.f38674a = coroutineContext;
        this.f38675b = i10;
        this.f38676c = bufferOverflow;
    }

    public static /* synthetic */ <T> Object e(ChannelFlow<T> channelFlow, kotlinx.coroutines.flow.f<? super T> fVar, kotlin.coroutines.c<? super z1> cVar) {
        Object objG = p0.g(new ChannelFlow$collect$2(fVar, channelFlow, null), cVar);
        return objG == yj.b.h() ? objG : z1.f38230a;
    }

    @Override // kotlinx.coroutines.flow.e
    @yt.l
    public Object a(@yt.k kotlinx.coroutines.flow.f<? super T> fVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        return e(this, fVar, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0013 A[PHI: r4
  0x0013: PHI (r4v5 int) = (r4v2 int), (r4v2 int), (r4v4 int) binds: [B:8:0x0011, B:13:0x0019, B:16:0x001d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // kotlinx.coroutines.flow.internal.i
    @yt.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public kotlinx.coroutines.flow.e<T> c(@yt.k kotlin.coroutines.CoroutineContext r2, int r3, @yt.k kotlinx.coroutines.channels.BufferOverflow r4) {
        /*
            r1 = this;
            kotlin.coroutines.CoroutineContext r0 = r1.f38674a
            kotlin.coroutines.CoroutineContext r2 = r2.L(r0)
            kotlinx.coroutines.channels.BufferOverflow r0 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            if (r4 == r0) goto Lb
            goto L25
        Lb:
            int r4 = r1.f38675b
            r0 = -3
            if (r4 != r0) goto L11
            goto L23
        L11:
            if (r3 != r0) goto L15
        L13:
            r3 = r4
            goto L23
        L15:
            r0 = -2
            if (r4 != r0) goto L19
            goto L23
        L19:
            if (r3 != r0) goto L1c
            goto L13
        L1c:
            int r4 = r4 + r3
            if (r4 < 0) goto L20
            goto L13
        L20:
            r3 = 2147483647(0x7fffffff, float:NaN)
        L23:
            kotlinx.coroutines.channels.BufferOverflow r4 = r1.f38676c
        L25:
            kotlin.coroutines.CoroutineContext r0 = r1.f38674a
            boolean r0 = kotlin.jvm.internal.f0.g(r2, r0)
            if (r0 == 0) goto L36
            int r0 = r1.f38675b
            if (r3 != r0) goto L36
            kotlinx.coroutines.channels.BufferOverflow r0 = r1.f38676c
            if (r4 != r0) goto L36
            return r1
        L36:
            kotlinx.coroutines.flow.internal.ChannelFlow r2 = r1.h(r2, r3, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlow.c(kotlin.coroutines.CoroutineContext, int, kotlinx.coroutines.channels.BufferOverflow):kotlinx.coroutines.flow.e");
    }

    @yt.l
    public String d() {
        return null;
    }

    @yt.l
    public abstract Object g(@yt.k q<? super T> qVar, @yt.k kotlin.coroutines.c<? super z1> cVar);

    @yt.k
    public abstract ChannelFlow<T> h(@yt.k CoroutineContext coroutineContext, int i10, @yt.k BufferOverflow bufferOverflow);

    @yt.l
    public kotlinx.coroutines.flow.e<T> i() {
        return null;
    }

    @yt.k
    public final p<q<? super T>, kotlin.coroutines.c<? super z1>, Object> j() {
        return new ChannelFlow$collectToFun$1(this, null);
    }

    public final int l() {
        int i10 = this.f38675b;
        if (i10 == -3) {
            return -2;
        }
        return i10;
    }

    @yt.k
    public ReceiveChannel<T> m(@yt.k o0 o0Var) {
        return ProduceKt.h(o0Var, this.f38674a, l(), this.f38676c, CoroutineStart.ATOMIC, null, j(), 16, null);
    }

    @yt.k
    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strD = d();
        if (strD != null) {
            arrayList.add(strD);
        }
        if (this.f38674a != EmptyCoroutineContext.f37755a) {
            arrayList.add("context=" + this.f38674a);
        }
        if (this.f38675b != -3) {
            arrayList.add("capacity=" + this.f38675b);
        }
        if (this.f38676c != BufferOverflow.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.f38676c);
        }
        return r0.a(this) + '[' + CollectionsKt___CollectionsKt.h3(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
