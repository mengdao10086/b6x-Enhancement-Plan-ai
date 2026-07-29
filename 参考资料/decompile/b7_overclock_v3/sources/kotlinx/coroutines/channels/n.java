package kotlinx.coroutines.channels;

import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import kotlinx.coroutines.channels.j;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.m3;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nConflatedBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConflatedBufferedChannel.kt\nkotlinx/coroutines/channels/ConflatedBufferedChannel\n+ 2 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n+ 3 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 4 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannelKt\n+ 5 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$sendImpl$1\n*L\n1#1,119:1\n548#2,5:120\n514#2,6:125\n514#2,6:212\n548#2,5:218\n244#3:131\n269#3,10:132\n280#3,68:143\n3038#4:142\n269#5:211\n*S KotlinDebug\n*F\n+ 1 ConflatedBufferedChannel.kt\nkotlinx/coroutines/channels/ConflatedBufferedChannel\n*L\n41#1:120,5\n53#1:125,6\n106#1:212,6\n109#1:218,5\n80#1:131\n80#1:132,10\n80#1:143,68\n80#1:142\n80#1:211\n*E\n"})
public class n<E> extends BufferedChannel<E> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f38385m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @yt.k
    public final BufferOverflow f38386n;

    public /* synthetic */ n(int i10, BufferOverflow bufferOverflow, ik.l lVar, int i11, u uVar) {
        this(i10, bufferOverflow, (i11 & 4) != 0 ? null : lVar);
    }

    public static /* synthetic */ <E> Object I1(n<E> nVar, E e10, kotlin.coroutines.c<? super z1> cVar) throws Throwable {
        UndeliveredElementException undeliveredElementExceptionD;
        Object objM1 = nVar.M1(e10, true);
        if (!(objM1 instanceof j.a)) {
            return z1.f38230a;
        }
        j.f(objM1);
        ik.l<E, z1> lVar = nVar.f38315b;
        if (lVar == null || (undeliveredElementExceptionD = OnUndeliveredElementKt.d(lVar, e10, null, 2, null)) == null) {
            throw nVar.o0();
        }
        kotlin.o.a(undeliveredElementExceptionD, nVar.o0());
        throw undeliveredElementExceptionD;
    }

    public static /* synthetic */ <E> Object J1(n<E> nVar, E e10, kotlin.coroutines.c<? super Boolean> cVar) {
        Object objM1 = nVar.M1(e10, true);
        if (objM1 instanceof j.c) {
            return zj.a.a(false);
        }
        return zj.a.a(true);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean A0() {
        return this.f38386n == BufferOverflow.DROP_OLDEST;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.s
    @yt.k
    public Object F(E e10) {
        return M1(e10, false);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.s
    @yt.l
    public Object G(E e10, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        return I1(this, e10, cVar);
    }

    public final Object K1(E e10, boolean z10) {
        ik.l<E, z1> lVar;
        UndeliveredElementException undeliveredElementExceptionD;
        Object objF = super.F(e10);
        if (j.m(objF) || j.k(objF)) {
            return objF;
        }
        if (!z10 || (lVar = this.f38315b) == null || (undeliveredElementExceptionD = OnUndeliveredElementKt.d(lVar, e10, null, 2, null)) == null) {
            return j.f38377b.c(z1.f38230a);
        }
        throw undeliveredElementExceptionD;
    }

    public final Object L1(E e10) {
        k kVar;
        Object obj = BufferedChannelKt.f38337f;
        k kVar2 = (k) BufferedChannel.f38309h.get(this);
        while (true) {
            long andIncrement = BufferedChannel.f38305d.getAndIncrement(this);
            long j10 = andIncrement & 1152921504606846975L;
            boolean zZ0 = z0(andIncrement);
            int i10 = BufferedChannelKt.f38333b;
            long j11 = j10 / ((long) i10);
            int i11 = (int) (j10 % ((long) i10));
            if (kVar2.f38812c != j11) {
                k kVarD0 = d0(j11, kVar2);
                if (kVarD0 != null) {
                    kVar = kVarD0;
                } else if (zZ0) {
                    return j.f38377b.a(o0());
                }
            } else {
                kVar = kVar2;
            }
            int iD1 = D1(kVar, i11, e10, j10, obj, zZ0);
            if (iD1 == 0) {
                kVar.b();
                return j.f38377b.c(z1.f38230a);
            }
            if (iD1 == 1) {
                return j.f38377b.c(z1.f38230a);
            }
            if (iD1 == 2) {
                if (zZ0) {
                    kVar.r();
                    return j.f38377b.a(o0());
                }
                m3 m3Var = obj instanceof m3 ? (m3) obj : null;
                if (m3Var != null) {
                    U0(m3Var, kVar, i11);
                }
                Z((kVar.f38812c * ((long) i10)) + ((long) i11));
                return j.f38377b.c(z1.f38230a);
            }
            if (iD1 == 3) {
                throw new IllegalStateException("unexpected".toString());
            }
            if (iD1 == 4) {
                if (j10 < n0()) {
                    kVar.b();
                }
                return j.f38377b.a(o0());
            }
            if (iD1 == 5) {
                kVar.b();
            }
            kVar2 = kVar;
        }
    }

    public final Object M1(E e10, boolean z10) {
        return this.f38386n == BufferOverflow.DROP_LATEST ? K1(e10, z10) : L1(e10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BufferedChannel
    public void h1(@yt.k kotlinx.coroutines.selects.j<?> jVar, @yt.l Object obj) {
        Object objF = F(obj);
        if (!(objF instanceof j.c)) {
            jVar.r(z1.f38230a);
        } else {
            if (!(objF instanceof j.a)) {
                throw new IllegalStateException("unreachable".toString());
            }
            j.f(objF);
            jVar.r(BufferedChannelKt.z());
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    @yt.l
    public Object n1(E e10, @yt.k kotlin.coroutines.c<? super Boolean> cVar) {
        return J1(this, e10, cVar);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean u1() {
        return false;
    }

    public n(int i10, @yt.k BufferOverflow bufferOverflow, @yt.l ik.l<? super E, z1> lVar) {
        super(i10, lVar);
        this.f38385m = i10;
        this.f38386n = bufferOverflow;
        if (!(bufferOverflow != BufferOverflow.SUSPEND)) {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + n0.d(BufferedChannel.class).K() + " instead").toString());
        }
        if (i10 >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i10 + " was specified").toString());
    }
}
