package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.mediacodec.e;
import g.p0;
import g.v0;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public interface b {

    public interface a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f17200a = new e.b();

        b a(MediaCodec mediaCodec);
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.mediacodec.b$b, reason: collision with other inner class name */
    public interface InterfaceC0179b {
        void a(b bVar, long j10, long j11);
    }

    void a(int i10);

    void b(@p0 MediaFormat mediaFormat, @p0 Surface surface, @p0 MediaCrypto mediaCrypto, int i10);

    MediaFormat c();

    @v0(19)
    void d(Bundle bundle);

    @v0(21)
    void e(int i10, long j10);

    int f();

    void flush();

    int g(MediaCodec.BufferInfo bufferInfo);

    @v0(23)
    void h(InterfaceC0179b interfaceC0179b, Handler handler);

    void i(int i10, boolean z10);

    @p0
    ByteBuffer j(int i10);

    @v0(23)
    void k(Surface surface);

    void l(int i10, int i11, int i12, long j10, int i13);

    @p0
    ByteBuffer m(int i10);

    void n(int i10, int i11, eb.b bVar, long j10, int i12);

    void release();

    void start();
}
