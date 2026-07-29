package com.flydigi.sdk.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import g.y0;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.t0;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.d1;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.coroutines.sync.a;

/* JADX INFO: loaded from: classes3.dex */
@t0({"SMAP\nAbstractDataInteractionController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractDataInteractionController.kt\ncom/flydigi/sdk/bluetooth/AbstractDataInteractionController\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,165:1\n1855#2,2:166\n1855#2,2:168\n*S KotlinDebug\n*F\n+ 1 AbstractDataInteractionController.kt\ncom/flydigi/sdk/bluetooth/AbstractDataInteractionController\n*L\n120#1:166,2\n138#1:168,2\n*E\n"})
public abstract class AbstractDataInteractionController extends AbstractBluetoothController {
    public int E;

    @yt.k
    public final kotlinx.coroutines.sync.a F;
    public o0 G;

    @yt.k
    public volatile ConcurrentLinkedQueue<j9.b> H;

    /* JADX INFO: renamed from: com.flydigi.sdk.bluetooth.AbstractDataInteractionController$1, reason: invalid class name */
    @zj.d(c = "com.flydigi.sdk.bluetooth.AbstractDataInteractionController$1", f = "AbstractDataInteractionController.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements ik.p<o0, kotlin.coroutines.c<? super z1>, Object> {
        private /* synthetic */ Object L$0;
        public int label;

        public AnonymousClass1(kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @yt.k
        public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = AbstractDataInteractionController.this.new AnonymousClass1(cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @yt.l
        public final Object q0(@yt.k Object obj) throws Throwable {
            Object objH = yj.b.h();
            int i10 = this.label;
            if (i10 == 0) {
                u0.n(obj);
                AbstractDataInteractionController.this.G = (o0) this.L$0;
                AbstractDataInteractionController abstractDataInteractionController = AbstractDataInteractionController.this;
                this.label = 1;
                if (abstractDataInteractionController.c1(this) == objH) {
                    return objH;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u0.n(obj);
            }
            return z1.f38230a;
        }

        @Override // ik.p
        @yt.l
        /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
        public final Object r0(@yt.k o0 o0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
            return ((AnonymousClass1) M(o0Var, cVar)).q0(z1.f38230a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractDataInteractionController(@yt.k Context mContext, @yt.k u filter, int i10) {
        super(mContext, filter, i10);
        kotlin.jvm.internal.f0.p(mContext, "mContext");
        kotlin.jvm.internal.f0.p(filter, "filter");
        this.F = MutexKt.a(true);
        this.H = new ConcurrentLinkedQueue<>();
        kotlinx.coroutines.j.f(p0.a(d1.a()), null, null, new AnonymousClass1(null), 3, null);
    }

    public static /* synthetic */ void O0(AbstractDataInteractionController abstractDataInteractionController, List list, Boolean bool, Long l10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addCommandToQueue");
        }
        if ((i10 & 2) != 0) {
            bool = Boolean.FALSE;
        }
        if ((i10 & 4) != 0) {
            l10 = 0L;
        }
        abstractDataInteractionController.K0(list, bool, l10);
    }

    public static /* synthetic */ void P0(AbstractDataInteractionController abstractDataInteractionController, UUID uuid, List list, Boolean bool, Long l10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addCommandToQueue");
        }
        if ((i10 & 1) != 0) {
            uuid = null;
        }
        if ((i10 & 4) != 0) {
            bool = Boolean.FALSE;
        }
        if ((i10 & 8) != 0) {
            l10 = 0L;
        }
        abstractDataInteractionController.L0(uuid, list, bool, l10);
    }

    public static /* synthetic */ void Q0(AbstractDataInteractionController abstractDataInteractionController, UUID uuid, byte[] bArr, Boolean bool, Long l10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addCommandToQueue");
        }
        if ((i10 & 1) != 0) {
            uuid = null;
        }
        if ((i10 & 4) != 0) {
            bool = Boolean.FALSE;
        }
        if ((i10 & 8) != 0) {
            l10 = 0L;
        }
        abstractDataInteractionController.M0(uuid, bArr, bool, l10);
    }

    public static /* synthetic */ void R0(AbstractDataInteractionController abstractDataInteractionController, byte[] bArr, Boolean bool, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addCommandToQueue");
        }
        if ((i10 & 2) != 0) {
            bool = Boolean.FALSE;
        }
        abstractDataInteractionController.N0(bArr, bool);
    }

    public static /* synthetic */ void W0() {
    }

    public final void J0(@yt.k List<j9.b> command) {
        kotlin.jvm.internal.f0.p(command, "command");
        if (this.E == 0) {
            l9.a.f("Gatt hasn't connected");
            return;
        }
        if (command.isEmpty()) {
            return;
        }
        synchronized (this.H) {
            Iterator<T> it2 = command.iterator();
            while (it2.hasNext()) {
                this.H.add((j9.b) it2.next());
            }
            z1 z1Var = z1.f38230a;
        }
        e1();
    }

    public final void K0(@yt.k List<byte[]> command, @yt.l Boolean bool, @yt.l Long l10) {
        kotlin.jvm.internal.f0.p(command, "command");
        L0(null, command, bool, l10);
    }

    public final void L0(@yt.l UUID uuid, @yt.k List<byte[]> command, @yt.l Boolean bool, @yt.l Long l10) {
        kotlin.jvm.internal.f0.p(command, "command");
        if (this.E == 0) {
            l9.a.f("Gatt hasn't connected");
            return;
        }
        if (command.isEmpty()) {
            l9.a.f("command is empty");
            return;
        }
        synchronized (this.H) {
            Iterator<T> it2 = command.iterator();
            while (it2.hasNext()) {
                this.H.add(new j9.b(uuid, (byte[]) it2.next(), null, null, bool, null, l10, 44, null));
            }
            z1 z1Var = z1.f38230a;
        }
        e1();
    }

    public final void M0(@yt.l UUID uuid, @yt.k byte[] command, @yt.l Boolean bool, @yt.l Long l10) {
        kotlin.jvm.internal.f0.p(command, "command");
        L0(uuid, kotlin.collections.s.k(command), bool, l10);
    }

    public final void N0(@yt.k byte[] command, @yt.l Boolean bool) {
        kotlin.jvm.internal.f0.p(command, "command");
        O0(this, kotlin.collections.s.k(command), bool, null, 4, null);
    }

    public final void S0() {
        synchronized (this.H) {
            this.H.clear();
            z1 z1Var = z1.f38230a;
        }
        e1();
    }

    public abstract void T0();

    public final void U0(@yt.k BluetoothDevice device) {
        kotlin.jvm.internal.f0.p(device, "device");
        if (Y0()) {
            l9.a.f("gatt has been connected with other device");
            return;
        }
        v0(device);
        a1(device);
        T0();
    }

    public final int V0() {
        return this.E;
    }

    @yt.k
    public abstract UUID X0();

    public final boolean Y0() {
        int i10 = this.E;
        return i10 == 2 || i10 == 1;
    }

    public abstract void Z0(@yt.k UUID uuid, @yt.k byte[] bArr);

    public void a1(@yt.k BluetoothDevice device) {
        kotlin.jvm.internal.f0.p(device, "device");
    }

    public final void b1(j9.b bVar) {
        if (this.E != 2) {
            l9.a.f("Gatt hasn't connected");
        } else {
            f1(bVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0046 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0044 -> B:18:0x0047). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c1(kotlin.coroutines.c<? super kotlin.z1> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.flydigi.sdk.bluetooth.AbstractDataInteractionController$runFetchLoop$1
            if (r0 == 0) goto L13
            r0 = r6
            com.flydigi.sdk.bluetooth.AbstractDataInteractionController$runFetchLoop$1 r0 = (com.flydigi.sdk.bluetooth.AbstractDataInteractionController$runFetchLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.flydigi.sdk.bluetooth.AbstractDataInteractionController$runFetchLoop$1 r0 = new com.flydigi.sdk.bluetooth.AbstractDataInteractionController$runFetchLoop$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r2 = r0.L$0
            com.flydigi.sdk.bluetooth.AbstractDataInteractionController r2 = (com.flydigi.sdk.bluetooth.AbstractDataInteractionController) r2
            kotlin.u0.n(r6)
            goto L47
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L35:
            kotlin.u0.n(r6)
            r2 = r5
        L39:
            kotlinx.coroutines.sync.a r6 = r2.F
            r0.L$0 = r2
            r0.label = r3
            r4 = 0
            java.lang.Object r6 = kotlinx.coroutines.sync.a.C0438a.b(r6, r4, r0, r3, r4)
            if (r6 != r1) goto L47
            return r1
        L47:
            java.util.concurrent.ConcurrentLinkedQueue<j9.b> r6 = r2.H
            java.lang.Object r6 = r6.poll()
            j9.b r6 = (j9.b) r6
            if (r6 == 0) goto L39
            r2.b1(r6)
            goto L39
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flydigi.sdk.bluetooth.AbstractDataInteractionController.c1(kotlin.coroutines.c):java.lang.Object");
    }

    public final void d1(int i10) {
        this.E = i10;
    }

    public final void e1() {
        if (this.F.c()) {
            a.C0438a.d(this.F, null, 1, null);
        }
    }

    @y0(anyOf = {"android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH"})
    public abstract void f1(@yt.k j9.b bVar);
}
