package kotlinx.coroutines.channels;

import kotlin.z1;
import kotlinx.coroutines.internal.o0;
import kotlinx.coroutines.internal.t0;

/* JADX INFO: loaded from: classes5.dex */
public final class BufferedChannelKt {
    public static final int B = 0;
    public static final int C = 1;
    public static final int D = 2;
    public static final int E = 3;
    public static final int F = 60;
    public static final long G = 1152921504606846975L;
    public static final long H = 4611686018427387904L;
    public static final long I = 4611686018427387903L;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f38335d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f38336e = Long.MAX_VALUE;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f38349r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f38350s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f38351t = 2;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f38352u = 3;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f38353v = 4;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f38354w = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final k<Object> f38332a = new k<>(-1, null, null, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    public static final int f38333b = t0.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f38334c = t0.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final o0 f38337f = new o0("BUFFERED");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public static final o0 f38338g = new o0("SHOULD_BUFFER");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public static final o0 f38339h = new o0("S_RESUMING_BY_RCV");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public static final o0 f38340i = new o0("RESUMING_BY_EB");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.k
    public static final o0 f38341j = new o0("POISONED");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @yt.k
    public static final o0 f38342k = new o0("DONE_RCV");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @yt.k
    public static final o0 f38343l = new o0("INTERRUPTED_SEND");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @yt.k
    public static final o0 f38344m = new o0("INTERRUPTED_RCV");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @yt.k
    public static final o0 f38345n = new o0("CHANNEL_CLOSED");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @yt.k
    public static final o0 f38346o = new o0("SUSPEND");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @yt.k
    public static final o0 f38347p = new o0("SUSPEND_NO_WAITER");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @yt.k
    public static final o0 f38348q = new o0("FAILED");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @yt.k
    public static final o0 f38355x = new o0("NO_RECEIVE_RESULT");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @yt.k
    public static final o0 f38356y = new o0("CLOSE_HANDLER_CLOSED");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @yt.k
    public static final o0 f38357z = new o0("CLOSE_HANDLER_INVOKED");

    @yt.k
    public static final o0 A = new o0("NO_CLOSE_CAUSE");

    public static final long A(long j10) {
        return j10 & 4611686018427387903L;
    }

    public static final boolean B(long j10) {
        return (j10 & 4611686018427387904L) != 0;
    }

    public static final int C(long j10) {
        return (int) (j10 >> 60);
    }

    public static final long D(long j10) {
        return j10 & 1152921504606846975L;
    }

    public static final long E(int i10) {
        if (i10 == 0) {
            return 0L;
        }
        if (i10 != Integer.MAX_VALUE) {
            return i10;
        }
        return Long.MAX_VALUE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean F(kotlinx.coroutines.o<? super T> oVar, T t10, ik.l<? super Throwable, z1> lVar) {
        Object objW = oVar.w(t10, null, lVar);
        if (objW == null) {
            return false;
        }
        oVar.l0(objW);
        return true;
    }

    public static /* synthetic */ boolean G(kotlinx.coroutines.o oVar, Object obj, ik.l lVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        return F(oVar, obj, lVar);
    }

    public static final long v(long j10, boolean z10) {
        return (z10 ? 4611686018427387904L : 0L) + j10;
    }

    public static final long w(long j10, int i10) {
        return (((long) i10) << 60) + j10;
    }

    public static final <E> k<E> x(long j10, k<E> kVar) {
        return new k<>(j10, kVar, kVar.w(), 0);
    }

    @yt.k
    public static final <E> kotlin.reflect.i<k<E>> y() {
        return BufferedChannelKt$createSegmentFunction$1.f38358c;
    }

    @yt.k
    public static final o0 z() {
        return f38345n;
    }
}
