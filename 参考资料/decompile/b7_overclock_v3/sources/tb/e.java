package tb;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import g.b0;
import g.i1;
import g.p0;
import g.v0;
import hd.u0;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
@v0(23)
public class e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f51010h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f51011i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f51012j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @b0("MESSAGE_PARAMS_INSTANCE_POOL")
    public static final ArrayDeque<b> f51013k = new ArrayDeque<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Object f51014l = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaCodec f51015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HandlerThread f51016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f51017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference<RuntimeException> f51018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final hd.f f51019e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f51020f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f51021g;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e.this.f(message);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f51023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f51024b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f51025c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final MediaCodec.CryptoInfo f51026d = new MediaCodec.CryptoInfo();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f51027e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f51028f;

        public void a(int i10, int i11, int i12, long j10, int i13) {
            this.f51023a = i10;
            this.f51024b = i11;
            this.f51025c = i12;
            this.f51027e = j10;
            this.f51028f = i13;
        }
    }

    public e(MediaCodec mediaCodec, HandlerThread handlerThread, boolean z10) {
        this(mediaCodec, handlerThread, z10, new hd.f());
    }

    public static void c(eb.b bVar, MediaCodec.CryptoInfo cryptoInfo) {
        cryptoInfo.numSubSamples = bVar.f26751f;
        cryptoInfo.numBytesOfClearData = e(bVar.f26749d, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = e(bVar.f26750e, cryptoInfo.numBytesOfEncryptedData);
        cryptoInfo.key = (byte[]) hd.a.g(d(bVar.f26747b, cryptoInfo.key));
        cryptoInfo.iv = (byte[]) hd.a.g(d(bVar.f26746a, cryptoInfo.iv));
        cryptoInfo.mode = bVar.f26748c;
        if (u0.f31154a >= 24) {
            cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(bVar.f26752g, bVar.f26753h));
        }
    }

    @p0
    public static byte[] d(@p0 byte[] bArr, @p0 byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    @p0
    public static int[] e(@p0 int[] iArr, @p0 int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    public static b k() {
        ArrayDeque<b> arrayDeque = f51013k;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                return new b();
            }
            return arrayDeque.removeFirst();
        }
    }

    public static boolean m() {
        String strW1 = u0.w1(u0.f31156c);
        return strW1.contains(com.google.android.material.internal.i.f20422b) || strW1.contains("motorola");
    }

    public static void p(b bVar) {
        ArrayDeque<b> arrayDeque = f51013k;
        synchronized (arrayDeque) {
            arrayDeque.add(bVar);
        }
    }

    public final void b() throws InterruptedException {
        this.f51019e.d();
        ((Handler) u0.k(this.f51017c)).obtainMessage(2).sendToTarget();
        this.f51019e.a();
    }

    public final void f(Message message) {
        b bVar;
        int i10 = message.what;
        if (i10 == 0) {
            bVar = (b) message.obj;
            g(bVar.f51023a, bVar.f51024b, bVar.f51025c, bVar.f51027e, bVar.f51028f);
        } else if (i10 != 1) {
            if (i10 != 2) {
                q(new IllegalStateException(String.valueOf(message.what)));
            } else {
                this.f51019e.f();
            }
            bVar = null;
        } else {
            bVar = (b) message.obj;
            h(bVar.f51023a, bVar.f51024b, bVar.f51026d, bVar.f51027e, bVar.f51028f);
        }
        if (bVar != null) {
            p(bVar);
        }
    }

    public final void g(int i10, int i11, int i12, long j10, int i13) {
        try {
            this.f51015a.queueInputBuffer(i10, i11, i12, j10, i13);
        } catch (RuntimeException e10) {
            q(e10);
        }
    }

    public final void h(int i10, int i11, MediaCodec.CryptoInfo cryptoInfo, long j10, int i12) {
        try {
            if (!this.f51020f) {
                this.f51015a.queueSecureInputBuffer(i10, i11, cryptoInfo, j10, i12);
                return;
            }
            synchronized (f51014l) {
                this.f51015a.queueSecureInputBuffer(i10, i11, cryptoInfo, j10, i12);
            }
        } catch (RuntimeException e10) {
            q(e10);
        }
    }

    public void i() {
        if (this.f51021g) {
            try {
                j();
            } catch (InterruptedException e10) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e10);
            }
        }
    }

    public final void j() throws InterruptedException {
        ((Handler) u0.k(this.f51017c)).removeCallbacksAndMessages(null);
        b();
        l();
    }

    public final void l() {
        RuntimeException andSet = this.f51018d.getAndSet(null);
        if (andSet != null) {
            throw andSet;
        }
    }

    public void n(int i10, int i11, int i12, long j10, int i13) {
        l();
        b bVarK = k();
        bVarK.a(i10, i11, i12, j10, i13);
        ((Handler) u0.k(this.f51017c)).obtainMessage(0, bVarK).sendToTarget();
    }

    public void o(int i10, int i11, eb.b bVar, long j10, int i12) {
        l();
        b bVarK = k();
        bVarK.a(i10, i11, 0, j10, i12);
        c(bVar, bVarK.f51026d);
        ((Handler) u0.k(this.f51017c)).obtainMessage(1, bVarK).sendToTarget();
    }

    @i1
    public void q(RuntimeException runtimeException) {
        this.f51018d.set(runtimeException);
    }

    public void r() {
        if (this.f51021g) {
            i();
            this.f51016b.quit();
        }
        this.f51021g = false;
    }

    public void s() {
        if (this.f51021g) {
            return;
        }
        this.f51016b.start();
        this.f51017c = new a(this.f51016b.getLooper());
        this.f51021g = true;
    }

    public void t() throws InterruptedException {
        b();
    }

    @i1
    public e(MediaCodec mediaCodec, HandlerThread handlerThread, boolean z10, hd.f fVar) {
        this.f51015a = mediaCodec;
        this.f51016b = handlerThread;
        this.f51019e = fVar;
        this.f51018d = new AtomicReference<>();
        this.f51020f = z10 || m();
    }
}
