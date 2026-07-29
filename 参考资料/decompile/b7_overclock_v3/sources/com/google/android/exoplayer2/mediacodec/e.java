package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.mediacodec.b;
import g.p0;
import g.v0;
import hd.u0;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements com.google.android.exoplayer2.mediacodec.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaCodec f17215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public ByteBuffer[] f17216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public ByteBuffer[] f17217c;

    public static final class b implements b.a {
        @Override // com.google.android.exoplayer2.mediacodec.b.a
        public com.google.android.exoplayer2.mediacodec.b a(MediaCodec mediaCodec) {
            return new e(mediaCodec);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(b.InterfaceC0179b interfaceC0179b, MediaCodec mediaCodec, long j10, long j11) {
        interfaceC0179b.a(this, j10, j11);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void a(int i10) {
        this.f17215a.setVideoScalingMode(i10);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void b(@p0 MediaFormat mediaFormat, @p0 Surface surface, @p0 MediaCrypto mediaCrypto, int i10) {
        this.f17215a.configure(mediaFormat, surface, mediaCrypto, i10);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public MediaFormat c() {
        return this.f17215a.getOutputFormat();
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    @v0(19)
    public void d(Bundle bundle) {
        this.f17215a.setParameters(bundle);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    @v0(21)
    public void e(int i10, long j10) {
        this.f17215a.releaseOutputBuffer(i10, j10);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public int f() {
        return this.f17215a.dequeueInputBuffer(0L);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void flush() {
        this.f17215a.flush();
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public int g(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.f17215a.dequeueOutputBuffer(bufferInfo, 0L);
            if (iDequeueOutputBuffer == -3 && u0.f31154a < 21) {
                this.f17217c = this.f17215a.getOutputBuffers();
            }
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    @v0(23)
    public void h(final b.InterfaceC0179b interfaceC0179b, Handler handler) {
        this.f17215a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: tb.p
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j10, long j11) {
                this.f51059a.p(interfaceC0179b, mediaCodec, j10, j11);
            }
        }, handler);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void i(int i10, boolean z10) {
        this.f17215a.releaseOutputBuffer(i10, z10);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    @p0
    public ByteBuffer j(int i10) {
        return u0.f31154a >= 21 ? this.f17215a.getInputBuffer(i10) : ((ByteBuffer[]) u0.k(this.f17216b))[i10];
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    @v0(23)
    public void k(Surface surface) {
        this.f17215a.setOutputSurface(surface);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void l(int i10, int i11, int i12, long j10, int i13) {
        this.f17215a.queueInputBuffer(i10, i11, i12, j10, i13);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    @p0
    public ByteBuffer m(int i10) {
        return u0.f31154a >= 21 ? this.f17215a.getOutputBuffer(i10) : ((ByteBuffer[]) u0.k(this.f17217c))[i10];
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void n(int i10, int i11, eb.b bVar, long j10, int i12) {
        this.f17215a.queueSecureInputBuffer(i10, i11, bVar.a(), j10, i12);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void release() {
        this.f17216b = null;
        this.f17217c = null;
        this.f17215a.release();
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void start() {
        this.f17215a.start();
        if (u0.f31154a < 21) {
            this.f17216b = this.f17215a.getInputBuffers();
            this.f17217c = this.f17215a.getOutputBuffers();
        }
    }

    public e(MediaCodec mediaCodec) {
        this.f17215a = mediaCodec;
    }
}
