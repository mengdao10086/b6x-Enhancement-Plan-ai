package tb;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import g.b0;
import g.n0;
import g.p0;
import g.v0;
import hd.u0;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes3.dex */
@v0(23)
public final class g extends MediaCodec.Callback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HandlerThread f51032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f51033c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    @b0("lock")
    public MediaFormat f51038h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    @b0("lock")
    public MediaFormat f51039i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    @b0("lock")
    public MediaCodec.CodecException f51040j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @b0("lock")
    public long f51041k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @b0("lock")
    public boolean f51042l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    @b0("lock")
    public IllegalStateException f51043m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f51031a = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @b0("lock")
    public final hd.o f51034d = new hd.o();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @b0("lock")
    public final hd.o f51035e = new hd.o();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @b0("lock")
    public final ArrayDeque<MediaCodec.BufferInfo> f51036f = new ArrayDeque<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @b0("lock")
    public final ArrayDeque<MediaFormat> f51037g = new ArrayDeque<>();

    public g(HandlerThread handlerThread) {
        this.f51032b = handlerThread;
    }

    @b0("lock")
    public final void b(MediaFormat mediaFormat) {
        this.f51035e.a(-2);
        this.f51037g.add(mediaFormat);
    }

    public int c() {
        synchronized (this.f51031a) {
            int iF = -1;
            if (i()) {
                return -1;
            }
            k();
            if (!this.f51034d.e()) {
                iF = this.f51034d.f();
            }
            return iF;
        }
    }

    public int d(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f51031a) {
            if (i()) {
                return -1;
            }
            k();
            if (this.f51035e.e()) {
                return -1;
            }
            int iF = this.f51035e.f();
            if (iF >= 0) {
                hd.a.k(this.f51038h);
                MediaCodec.BufferInfo bufferInfoRemove = this.f51036f.remove();
                bufferInfo.set(bufferInfoRemove.offset, bufferInfoRemove.size, bufferInfoRemove.presentationTimeUs, bufferInfoRemove.flags);
            } else if (iF == -2) {
                this.f51038h = this.f51037g.remove();
            }
            return iF;
        }
    }

    public void e(final Runnable runnable) {
        synchronized (this.f51031a) {
            this.f51041k++;
            ((Handler) u0.k(this.f51033c)).post(new Runnable() { // from class: tb.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f51029a.j(runnable);
                }
            });
        }
    }

    @b0("lock")
    public final void f() {
        if (!this.f51037g.isEmpty()) {
            this.f51039i = this.f51037g.getLast();
        }
        this.f51034d.c();
        this.f51035e.c();
        this.f51036f.clear();
        this.f51037g.clear();
        this.f51040j = null;
    }

    public MediaFormat g() {
        MediaFormat mediaFormat;
        synchronized (this.f51031a) {
            mediaFormat = this.f51038h;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    public void h(MediaCodec mediaCodec) {
        hd.a.i(this.f51033c == null);
        this.f51032b.start();
        Handler handler = new Handler(this.f51032b.getLooper());
        mediaCodec.setCallback(this, handler);
        this.f51033c = handler;
    }

    @b0("lock")
    public final boolean i() {
        return this.f51041k > 0 || this.f51042l;
    }

    @b0("lock")
    public final void k() {
        l();
        m();
    }

    @b0("lock")
    public final void l() {
        IllegalStateException illegalStateException = this.f51043m;
        if (illegalStateException == null) {
            return;
        }
        this.f51043m = null;
        throw illegalStateException;
    }

    @b0("lock")
    public final void m() {
        MediaCodec.CodecException codecException = this.f51040j;
        if (codecException == null) {
            return;
        }
        this.f51040j = null;
        throw codecException;
    }

    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public final void j(Runnable runnable) {
        synchronized (this.f51031a) {
            o(runnable);
        }
    }

    @b0("lock")
    public final void o(Runnable runnable) {
        if (this.f51042l) {
            return;
        }
        long j10 = this.f51041k - 1;
        this.f51041k = j10;
        if (j10 > 0) {
            return;
        }
        if (j10 < 0) {
            p(new IllegalStateException());
            return;
        }
        f();
        try {
            runnable.run();
        } catch (IllegalStateException e10) {
            p(e10);
        } catch (Exception e11) {
            p(new IllegalStateException(e11));
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(@n0 MediaCodec mediaCodec, @n0 MediaCodec.CodecException codecException) {
        synchronized (this.f51031a) {
            this.f51040j = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(@n0 MediaCodec mediaCodec, int i10) {
        synchronized (this.f51031a) {
            this.f51034d.a(i10);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(@n0 MediaCodec mediaCodec, int i10, @n0 MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f51031a) {
            MediaFormat mediaFormat = this.f51039i;
            if (mediaFormat != null) {
                b(mediaFormat);
                this.f51039i = null;
            }
            this.f51035e.a(i10);
            this.f51036f.add(bufferInfo);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(@n0 MediaCodec mediaCodec, @n0 MediaFormat mediaFormat) {
        synchronized (this.f51031a) {
            b(mediaFormat);
            this.f51039i = null;
        }
    }

    public final void p(IllegalStateException illegalStateException) {
        synchronized (this.f51031a) {
            this.f51043m = illegalStateException;
        }
    }

    public void q() {
        synchronized (this.f51031a) {
            this.f51042l = true;
            this.f51032b.quit();
            f();
        }
    }
}
