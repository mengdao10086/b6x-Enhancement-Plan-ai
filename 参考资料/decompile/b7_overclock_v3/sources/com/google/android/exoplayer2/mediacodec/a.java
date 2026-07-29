package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.google.android.exoplayer2.mediacodec.a;
import com.google.android.exoplayer2.mediacodec.b;
import com.google.common.base.Supplier;
import g.i1;
import g.p0;
import g.v0;
import java.nio.ByteBuffer;
import java.util.Objects;
import tb.g;

/* JADX INFO: loaded from: classes3.dex */
@v0(23)
public final class a implements com.google.android.exoplayer2.mediacodec.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f17186g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f17187h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f17188i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f17189j = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaCodec f17190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f17191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final tb.e f17192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f17193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f17194e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f17195f;

    public static final class b implements b.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Supplier<HandlerThread> f17196b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Supplier<HandlerThread> f17197c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f17198d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f17199e;

        public b(int i10) {
            this(i10, false, false);
        }

        public static /* synthetic */ HandlerThread e(int i10) {
            return new HandlerThread(a.r(i10));
        }

        public static /* synthetic */ HandlerThread f(int i10) {
            return new HandlerThread(a.s(i10));
        }

        @Override // com.google.android.exoplayer2.mediacodec.b.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a(MediaCodec mediaCodec) {
            return new a(mediaCodec, this.f17196b.get(), this.f17197c.get(), this.f17198d, this.f17199e);
        }

        public b(final int i10, boolean z10, boolean z11) {
            this(new Supplier() { // from class: tb.c
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return a.b.e(i10);
                }
            }, new Supplier() { // from class: tb.d
                @Override // com.google.common.base.Supplier
                public final Object get() {
                    return a.b.f(i10);
                }
            }, z10, z11);
        }

        @i1
        public b(Supplier<HandlerThread> supplier, Supplier<HandlerThread> supplier2, boolean z10, boolean z11) {
            this.f17196b = supplier;
            this.f17197c = supplier2;
            this.f17198d = z10;
            this.f17199e = z11;
        }
    }

    public static String r(int i10) {
        return t(i10, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    public static String s(int i10) {
        return t(i10, "ExoPlayer:MediaCodecQueueingThread:");
    }

    public static String t(int i10, String str) {
        StringBuilder sb2 = new StringBuilder(str);
        if (i10 == 1) {
            sb2.append("Audio");
        } else if (i10 == 2) {
            sb2.append("Video");
        } else {
            sb2.append("Unknown(");
            sb2.append(i10);
            sb2.append(ee.a.f26979d);
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(b.InterfaceC0179b interfaceC0179b, MediaCodec mediaCodec, long j10, long j11) {
        interfaceC0179b.a(this, j10, j11);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void a(int i10) {
        v();
        this.f17190a.setVideoScalingMode(i10);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void b(@p0 MediaFormat mediaFormat, @p0 Surface surface, @p0 MediaCrypto mediaCrypto, int i10) {
        this.f17191b.h(this.f17190a);
        this.f17190a.configure(mediaFormat, surface, mediaCrypto, i10);
        this.f17195f = 1;
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public MediaFormat c() {
        return this.f17191b.g();
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void d(Bundle bundle) {
        v();
        this.f17190a.setParameters(bundle);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void e(int i10, long j10) {
        this.f17190a.releaseOutputBuffer(i10, j10);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public int f() {
        return this.f17191b.c();
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void flush() {
        this.f17192c.i();
        this.f17190a.flush();
        g gVar = this.f17191b;
        final MediaCodec mediaCodec = this.f17190a;
        Objects.requireNonNull(mediaCodec);
        gVar.e(new Runnable() { // from class: tb.b
            @Override // java.lang.Runnable
            public final void run() {
                mediaCodec.start();
            }
        });
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public int g(MediaCodec.BufferInfo bufferInfo) {
        return this.f17191b.d(bufferInfo);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void h(final b.InterfaceC0179b interfaceC0179b, Handler handler) {
        v();
        this.f17190a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: tb.a
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j10, long j11) {
                this.f51005a.u(interfaceC0179b, mediaCodec, j10, j11);
            }
        }, handler);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void i(int i10, boolean z10) {
        this.f17190a.releaseOutputBuffer(i10, z10);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    @p0
    public ByteBuffer j(int i10) {
        return this.f17190a.getInputBuffer(i10);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void k(Surface surface) {
        v();
        this.f17190a.setOutputSurface(surface);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void l(int i10, int i11, int i12, long j10, int i13) {
        this.f17192c.n(i10, i11, i12, j10, i13);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    @p0
    public ByteBuffer m(int i10) {
        return this.f17190a.getOutputBuffer(i10);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void n(int i10, int i11, eb.b bVar, long j10, int i12) {
        this.f17192c.o(i10, i11, bVar, j10, i12);
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void release() {
        try {
            if (this.f17195f == 2) {
                this.f17192c.r();
            }
            int i10 = this.f17195f;
            if (i10 == 1 || i10 == 2) {
                this.f17191b.q();
            }
            this.f17195f = 3;
        } finally {
            if (!this.f17194e) {
                this.f17190a.release();
                this.f17194e = true;
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.b
    public void start() {
        this.f17192c.s();
        this.f17190a.start();
        this.f17195f = 2;
    }

    public final void v() {
        if (this.f17193d) {
            try {
                this.f17192c.t();
            } catch (InterruptedException e10) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e10);
            }
        }
    }

    @i1
    public void w(MediaCodec.CodecException codecException) {
        this.f17191b.onError(this.f17190a, codecException);
    }

    @i1
    public void x(MediaFormat mediaFormat) {
        this.f17191b.onOutputFormatChanged(this.f17190a, mediaFormat);
    }

    public a(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z10, boolean z11) {
        this.f17190a = mediaCodec;
        this.f17191b = new g(handlerThread);
        this.f17192c = new tb.e(mediaCodec, handlerThread2, z10);
        this.f17193d = z11;
        this.f17195f = 0;
    }
}
