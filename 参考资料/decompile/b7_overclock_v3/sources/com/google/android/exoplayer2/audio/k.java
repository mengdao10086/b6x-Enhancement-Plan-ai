package com.google.android.exoplayer2.audio;

import ab.z;
import com.google.android.exoplayer2.audio.AudioProcessor;
import g.p0;
import hd.u0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements AudioProcessor {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f16916q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final float f16917r = 1.0E-4f;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f16918s = 1024;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f16920c = 1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f16921d = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AudioProcessor.a f16922e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AudioProcessor.a f16923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AudioProcessor.a f16924g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AudioProcessor.a f16925h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f16926i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public z f16927j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ByteBuffer f16928k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ShortBuffer f16929l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ByteBuffer f16930m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f16931n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f16932o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f16933p;

    public k() {
        AudioProcessor.a aVar = AudioProcessor.a.f16753e;
        this.f16922e = aVar;
        this.f16923f = aVar;
        this.f16924g = aVar;
        this.f16925h = aVar;
        ByteBuffer byteBuffer = AudioProcessor.f16752a;
        this.f16928k = byteBuffer;
        this.f16929l = byteBuffer.asShortBuffer();
        this.f16930m = byteBuffer;
        this.f16919b = -1;
    }

    public long a(long j10) {
        if (this.f16932o < 1024) {
            return (long) (((double) this.f16920c) * j10);
        }
        long jL = this.f16931n - ((long) ((z) hd.a.g(this.f16927j)).l());
        int i10 = this.f16925h.f16754a;
        int i11 = this.f16924g.f16754a;
        return i10 == i11 ? u0.h1(j10, jL, this.f16932o) : u0.h1(j10, jL * ((long) i10), this.f16932o * ((long) i11));
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        z zVar;
        return this.f16933p && ((zVar = this.f16927j) == null || zVar.k() == 0);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer c() {
        int iK;
        z zVar = this.f16927j;
        if (zVar != null && (iK = zVar.k()) > 0) {
            if (this.f16928k.capacity() < iK) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(iK).order(ByteOrder.nativeOrder());
                this.f16928k = byteBufferOrder;
                this.f16929l = byteBufferOrder.asShortBuffer();
            } else {
                this.f16928k.clear();
                this.f16929l.clear();
            }
            zVar.j(this.f16929l);
            this.f16932o += (long) iK;
            this.f16928k.limit(iK);
            this.f16930m = this.f16928k;
        }
        ByteBuffer byteBuffer = this.f16930m;
        this.f16930m = AudioProcessor.f16752a;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void d(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            z zVar = (z) hd.a.g(this.f16927j);
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.f16931n += (long) iRemaining;
            zVar.t(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public AudioProcessor.a e(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.f16756c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        int i10 = this.f16919b;
        if (i10 == -1) {
            i10 = aVar.f16754a;
        }
        this.f16922e = aVar;
        AudioProcessor.a aVar2 = new AudioProcessor.a(i10, aVar.f16755b, 2);
        this.f16923f = aVar2;
        this.f16926i = true;
        return aVar2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void f() {
        z zVar = this.f16927j;
        if (zVar != null) {
            zVar.s();
        }
        this.f16933p = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        if (isActive()) {
            AudioProcessor.a aVar = this.f16922e;
            this.f16924g = aVar;
            AudioProcessor.a aVar2 = this.f16923f;
            this.f16925h = aVar2;
            if (this.f16926i) {
                this.f16927j = new z(aVar.f16754a, aVar.f16755b, this.f16920c, this.f16921d, aVar2.f16754a);
            } else {
                z zVar = this.f16927j;
                if (zVar != null) {
                    zVar.i();
                }
            }
        }
        this.f16930m = AudioProcessor.f16752a;
        this.f16931n = 0L;
        this.f16932o = 0L;
        this.f16933p = false;
    }

    public void g(int i10) {
        this.f16919b = i10;
    }

    public void h(float f10) {
        if (this.f16921d != f10) {
            this.f16921d = f10;
            this.f16926i = true;
        }
    }

    public void i(float f10) {
        if (this.f16920c != f10) {
            this.f16920c = f10;
            this.f16926i = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.f16923f.f16754a != -1 && (Math.abs(this.f16920c - 1.0f) >= 1.0E-4f || Math.abs(this.f16921d - 1.0f) >= 1.0E-4f || this.f16923f.f16754a != this.f16922e.f16754a);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.f16920c = 1.0f;
        this.f16921d = 1.0f;
        AudioProcessor.a aVar = AudioProcessor.a.f16753e;
        this.f16922e = aVar;
        this.f16923f = aVar;
        this.f16924g = aVar;
        this.f16925h = aVar;
        ByteBuffer byteBuffer = AudioProcessor.f16752a;
        this.f16928k = byteBuffer;
        this.f16929l = byteBuffer.asShortBuffer();
        this.f16930m = byteBuffer;
        this.f16919b = -1;
        this.f16926i = false;
        this.f16927j = null;
        this.f16931n = 0L;
        this.f16932o = 0L;
        this.f16933p = false;
    }
}
