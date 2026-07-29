package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlinx.coroutines.internal.l0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/ChannelSegment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,3055:1\n1#2:3056\n*E\n"})
public final class k<E> extends l0<k<E>> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.l
    public final BufferedChannel<E> f38381e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public final AtomicReferenceArray f38382f;

    public k(long j10, @yt.l k<E> kVar, @yt.l BufferedChannel<E> bufferedChannel, int i10) {
        super(j10, kVar, i10);
        this.f38381e = bufferedChannel;
        this.f38382f = new AtomicReferenceArray(BufferedChannelKt.f38333b * 2);
    }

    public final E A(int i10) {
        E eX = x(i10);
        u(i10);
        return eX;
    }

    public final void B(int i10, Object obj) {
        this.f38382f.lazySet(i10 * 2, obj);
    }

    public final void C(int i10, @yt.l Object obj) {
        this.f38382f.set((i10 * 2) + 1, obj);
    }

    public final void D(int i10, E e10) {
        B(i10, e10);
    }

    @Override // kotlinx.coroutines.internal.l0
    public int p() {
        return BufferedChannelKt.f38333b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0063, code lost:
    
        u(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0066, code lost:
    
        if (r0 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0068, code lost:
    
        r4 = w().f38315b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006e, code lost:
    
        if (r4 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0070, code lost:
    
        kotlinx.coroutines.internal.OnUndeliveredElementKt.b(r4, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0073, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
    
        return;
     */
    @Override // kotlinx.coroutines.internal.l0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void q(int r4, @yt.l java.lang.Throwable r5, @yt.k kotlin.coroutines.CoroutineContext r6) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            r3 = this;
            int r5 = kotlinx.coroutines.channels.BufferedChannelKt.f38333b
            if (r4 < r5) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r4 = r4 - r5
        La:
            java.lang.Object r5 = r3.x(r4)
        Le:
            java.lang.Object r1 = r3.y(r4)
            boolean r2 = r1 instanceof kotlinx.coroutines.m3
            if (r2 != 0) goto L74
            boolean r2 = r1 instanceof kotlinx.coroutines.channels.t
            if (r2 == 0) goto L1b
            goto L74
        L1b:
            kotlinx.coroutines.internal.o0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.j()
            if (r1 == r2) goto L63
            kotlinx.coroutines.internal.o0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.i()
            if (r1 != r2) goto L28
            goto L63
        L28:
            kotlinx.coroutines.internal.o0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.p()
            if (r1 == r2) goto Le
            kotlinx.coroutines.internal.o0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.q()
            if (r1 != r2) goto L35
            goto Le
        L35:
            kotlinx.coroutines.internal.o0 r4 = kotlinx.coroutines.channels.BufferedChannelKt.f()
            if (r1 == r4) goto L62
            kotlinx.coroutines.internal.o0 r4 = kotlinx.coroutines.channels.BufferedChannelKt.f38337f
            if (r1 != r4) goto L40
            goto L62
        L40:
            kotlinx.coroutines.internal.o0 r4 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            if (r1 != r4) goto L47
            return
        L47:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "unexpected state: "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L62:
            return
        L63:
            r3.u(r4)
            if (r0 == 0) goto L73
            kotlinx.coroutines.channels.BufferedChannel r4 = r3.w()
            ik.l<E, kotlin.z1> r4 = r4.f38315b
            if (r4 == 0) goto L73
            kotlinx.coroutines.internal.OnUndeliveredElementKt.b(r4, r5, r6)
        L73:
            return
        L74:
            if (r0 == 0) goto L7b
            kotlinx.coroutines.internal.o0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.j()
            goto L7f
        L7b:
            kotlinx.coroutines.internal.o0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.i()
        L7f:
            boolean r1 = r3.t(r4, r1, r2)
            if (r1 == 0) goto Le
            r3.u(r4)
            r1 = r0 ^ 1
            r3.z(r4, r1)
            if (r0 == 0) goto L9a
            kotlinx.coroutines.channels.BufferedChannel r4 = r3.w()
            ik.l<E, kotlin.z1> r4 = r4.f38315b
            if (r4 == 0) goto L9a
            kotlinx.coroutines.internal.OnUndeliveredElementKt.b(r4, r5, r6)
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.k.q(int, java.lang.Throwable, kotlin.coroutines.CoroutineContext):void");
    }

    public final boolean t(int i10, @yt.l Object obj, @yt.l Object obj2) {
        return this.f38382f.compareAndSet((i10 * 2) + 1, obj, obj2);
    }

    public final void u(int i10) {
        B(i10, null);
    }

    @yt.l
    public final Object v(int i10, @yt.l Object obj) {
        return this.f38382f.getAndSet((i10 * 2) + 1, obj);
    }

    @yt.k
    public final BufferedChannel<E> w() {
        BufferedChannel<E> bufferedChannel = this.f38381e;
        f0.m(bufferedChannel);
        return bufferedChannel;
    }

    public final E x(int i10) {
        return (E) this.f38382f.get(i10 * 2);
    }

    @yt.l
    public final Object y(int i10) {
        return this.f38382f.get((i10 * 2) + 1);
    }

    public final void z(int i10, boolean z10) {
        if (z10) {
            w().H1((this.f38812c * ((long) BufferedChannelKt.f38333b)) + ((long) i10));
        }
        r();
    }
}
