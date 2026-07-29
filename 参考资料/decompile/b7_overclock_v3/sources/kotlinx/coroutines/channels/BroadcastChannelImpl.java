package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.p0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nBroadcastChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl\n+ 2 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,414:1\n15#2:415\n15#2:416\n15#2:420\n15#2:423\n15#2:429\n15#2:430\n15#2:436\n15#2:439\n15#2:440\n15#2:441\n766#3:417\n857#3,2:418\n1855#3,2:421\n1747#3,3:424\n1855#3,2:427\n1855#3,2:431\n766#3:433\n857#3,2:434\n1855#3,2:437\n*S KotlinDebug\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl\n*L\n166#1:415\n188#1:416\n213#1:420\n237#1:423\n279#1:429\n331#1:430\n343#1:436\n355#1:439\n382#1:440\n394#1:441\n189#1:417\n189#1:418,2\n226#1:421,2\n242#1:424,3\n251#1:427,2\n333#1:431,2\n338#1:433\n338#1:434,2\n346#1:437,2\n*E\n"})
public final class BroadcastChannelImpl<E> extends BufferedChannel<E> implements d<E> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f38298m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @yt.k
    public final ReentrantLock f38299n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @yt.k
    public List<? extends BufferedChannel<E>> f38300o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @yt.l
    public Object f38301p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @yt.k
    public final HashMap<kotlinx.coroutines.selects.j<?>, Object> f38302q;

    @t0({"SMAP\nBroadcastChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered\n+ 2 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n*L\n1#1,414:1\n15#2:415\n*S KotlinDebug\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl$SubscriberBuffered\n*L\n362#1:415\n*E\n"})
    public final class a extends BufferedChannel<E> {
        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            super(BroadcastChannelImpl.this.L1(), null, 2, 0 == true ? 1 : 0);
        }

        @Override // kotlinx.coroutines.channels.BufferedChannel
        /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
        public boolean R(@yt.l Throwable th2) {
            ReentrantLock reentrantLock = BroadcastChannelImpl.this.f38299n;
            BroadcastChannelImpl<E> broadcastChannelImpl = BroadcastChannelImpl.this;
            reentrantLock.lock();
            try {
                broadcastChannelImpl.Q1(this);
                return super.R(th2);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final class b extends n<E> {
        public b() {
            super(1, BufferOverflow.DROP_OLDEST, null, 4, null);
        }

        @Override // kotlinx.coroutines.channels.BufferedChannel
        /* JADX INFO: renamed from: N1, reason: merged with bridge method [inline-methods] */
        public boolean R(@yt.l Throwable th2) {
            BroadcastChannelImpl.this.Q1(this);
            return super.R(th2);
        }
    }

    public BroadcastChannelImpl(int i10) {
        super(0, null);
        this.f38298m = i10;
        if (i10 >= 1 || i10 == -1) {
            this.f38299n = new ReentrantLock();
            this.f38300o = CollectionsKt__CollectionsKt.E();
            this.f38301p = e.f38364a;
            this.f38302q = new HashMap<>();
            return;
        }
        throw new IllegalArgumentException(("BroadcastChannel capacity must be positive or Channel.CONFLATED, but " + i10 + " was specified").toString());
    }

    public static /* synthetic */ void N1() {
    }

    public static /* synthetic */ void P1() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.s
    public boolean C(@yt.l Throwable th2) {
        ReentrantLock reentrantLock = this.f38299n;
        reentrantLock.lock();
        try {
            Iterator<T> it2 = this.f38300o.iterator();
            while (it2.hasNext()) {
                ((BufferedChannel) it2.next()).C(th2);
            }
            List<? extends BufferedChannel<E>> list = this.f38300o;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((BufferedChannel) obj).q0()) {
                    arrayList.add(obj);
                }
            }
            this.f38300o = arrayList;
            return super.C(th2);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.d
    @yt.k
    public ReceiveChannel<E> E() {
        ReentrantLock reentrantLock = this.f38299n;
        reentrantLock.lock();
        try {
            a bVar = this.f38298m == -1 ? new b() : new a();
            if (H() && this.f38301p == e.f38364a) {
                ((BufferedChannel) bVar).C(g0());
                return bVar;
            }
            if (this.f38301p != e.f38364a) {
                ((BufferedChannel) bVar).F(M1());
            }
            this.f38300o = CollectionsKt___CollectionsKt.z4(this.f38300o, bVar);
            return bVar;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.s
    @yt.k
    public Object F(E e10) {
        ReentrantLock reentrantLock = this.f38299n;
        reentrantLock.lock();
        try {
            if (H()) {
                return super.F(e10);
            }
            List<? extends BufferedChannel<E>> list = this.f38300o;
            boolean z10 = false;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (((BufferedChannel) it2.next()).u1()) {
                        z10 = true;
                        break;
                    }
                }
            }
            if (z10) {
                return j.f38377b.b();
            }
            if (this.f38298m == -1) {
                this.f38301p = e10;
            }
            Iterator<T> it3 = this.f38300o.iterator();
            while (it3.hasNext()) {
                ((BufferedChannel) it3.next()).F(e10);
            }
            return j.f38377b.c(z1.f38230a);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0078 -> B:28:0x007b). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.s
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object G(E r7, @yt.k kotlin.coroutines.c<? super kotlin.z1> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.BroadcastChannelImpl$send$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.channels.BroadcastChannelImpl$send$1 r0 = (kotlinx.coroutines.channels.BroadcastChannelImpl$send$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.BroadcastChannelImpl$send$1 r0 = new kotlinx.coroutines.channels.BroadcastChannelImpl$send$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r7 = r0.L$2
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.L$1
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.channels.BroadcastChannelImpl r4 = (kotlinx.coroutines.channels.BroadcastChannelImpl) r4
            kotlin.u0.n(r8)
            goto L7b
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            kotlin.u0.n(r8)
            java.util.concurrent.locks.ReentrantLock r8 = r6.f38299n
            r8.lock()
            boolean r2 = r6.H()     // Catch: java.lang.Throwable -> L99
            if (r2 != 0) goto L94
            int r2 = r6.f38298m     // Catch: java.lang.Throwable -> L99
            r4 = -1
            if (r2 != r4) goto L50
            r6.f38301p = r7     // Catch: java.lang.Throwable -> L99
        L50:
            java.util.List<? extends kotlinx.coroutines.channels.BufferedChannel<E>> r2 = r6.f38300o     // Catch: java.lang.Throwable -> L99
            r8.unlock()
            java.util.Iterator r8 = r2.iterator()
            r4 = r6
            r5 = r8
            r8 = r7
            r7 = r5
        L5d:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L91
            java.lang.Object r2 = r7.next()
            kotlinx.coroutines.channels.BufferedChannel r2 = (kotlinx.coroutines.channels.BufferedChannel) r2
            r0.L$0 = r4
            r0.L$1 = r8
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r2 = r2.n1(r8, r0)
            if (r2 != r1) goto L78
            return r1
        L78:
            r5 = r2
            r2 = r8
            r8 = r5
        L7b:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L8f
            boolean r8 = r4.H()
            if (r8 != 0) goto L8a
            goto L8f
        L8a:
            java.lang.Throwable r7 = r4.o0()
            throw r7
        L8f:
            r8 = r2
            goto L5d
        L91:
            kotlin.z1 r7 = kotlin.z1.f38230a
            return r7
        L94:
            java.lang.Throwable r7 = r6.o0()     // Catch: java.lang.Throwable -> L99
            throw r7     // Catch: java.lang.Throwable -> L99
        L99:
            r7 = move-exception
            r8.unlock()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BroadcastChannelImpl.G(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.s
    public boolean H() {
        ReentrantLock reentrantLock = this.f38299n;
        reentrantLock.lock();
        try {
            return super.H();
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int L1() {
        return this.f38298m;
    }

    public final E M1() throws Throwable {
        ReentrantLock reentrantLock = this.f38299n;
        reentrantLock.lock();
        try {
            if (!H()) {
                if (this.f38301p != e.f38364a) {
                    return (E) this.f38301p;
                }
                throw new IllegalStateException("No value".toString());
            }
            Throwable thG0 = g0();
            if (thG0 == null) {
                throw new IllegalStateException("This broadcast channel is closed");
            }
            throw thG0;
        } finally {
            reentrantLock.unlock();
        }
    }

    @yt.l
    public final E O1() {
        ReentrantLock reentrantLock = this.f38299n;
        reentrantLock.lock();
        try {
            E e10 = null;
            if (!e() && this.f38301p != e.f38364a) {
                e10 = (E) this.f38301p;
            }
            return e10;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q1(ReceiveChannel<? extends E> receiveChannel) {
        ReentrantLock reentrantLock = this.f38299n;
        reentrantLock.lock();
        try {
            List<? extends BufferedChannel<E>> list = this.f38300o;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((BufferedChannel) obj) != receiveChannel) {
                    arrayList.add(obj);
                }
            }
            this.f38300o = arrayList;
            z1 z1Var = z1.f38230a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean R(@yt.l Throwable th2) {
        ReentrantLock reentrantLock = this.f38299n;
        reentrantLock.lock();
        try {
            Iterator<T> it2 = this.f38300o.iterator();
            while (it2.hasNext()) {
                ((BufferedChannel) it2.next()).R(th2);
            }
            this.f38301p = e.f38364a;
            return super.R(th2);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public void h1(@yt.k kotlinx.coroutines.selects.j<?> jVar, @yt.l Object obj) {
        ReentrantLock reentrantLock = this.f38299n;
        reentrantLock.lock();
        try {
            Object objRemove = this.f38302q.remove(jVar);
            if (objRemove != null) {
                jVar.r(objRemove);
                return;
            }
            z1 z1Var = z1.f38230a;
            reentrantLock.unlock();
            kotlinx.coroutines.j.f(p0.a(jVar.b()), null, CoroutineStart.UNDISPATCHED, new BroadcastChannelImpl$registerSelectForSend$2(this, obj, jVar, null), 1, null);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    @yt.k
    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        if (this.f38301p != e.f38364a) {
            str = "CONFLATED_ELEMENT=" + this.f38301p + "; ";
        } else {
            str = "";
        }
        sb2.append(str);
        sb2.append("BROADCAST=<");
        sb2.append(super.toString());
        sb2.append(">; SUBSCRIBERS=");
        sb2.append(CollectionsKt___CollectionsKt.h3(this.f38300o, ";", "<", ">", 0, null, null, 56, null));
        return sb2.toString();
    }
}
