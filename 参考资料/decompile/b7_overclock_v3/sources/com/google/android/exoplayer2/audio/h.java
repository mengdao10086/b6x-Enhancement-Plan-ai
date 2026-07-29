package com.google.android.exoplayer2.audio;

import ab.u;
import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.b;
import g.p0;
import hd.u0;
import hd.v;
import hd.w;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tb.o;
import ya.h1;
import ya.o1;
import ya.p1;
import ya.s0;

/* JADX INFO: loaded from: classes3.dex */
public class h extends MediaCodecRenderer implements v {

    /* JADX INFO: renamed from: d9, reason: collision with root package name */
    public static final String f16892d9 = "MediaCodecAudioRenderer";

    /* JADX INFO: renamed from: e9, reason: collision with root package name */
    public static final String f16893e9 = "v-bits-per-sample";
    public final Context R8;
    public final a.C0175a S8;
    public final AudioSink T8;
    public int U8;
    public boolean V8;

    @p0
    public Format W8;
    public long X8;
    public boolean Y8;
    public boolean Z8;

    /* JADX INFO: renamed from: a9, reason: collision with root package name */
    public boolean f16894a9;

    /* JADX INFO: renamed from: b9, reason: collision with root package name */
    public boolean f16895b9;

    /* JADX INFO: renamed from: c9, reason: collision with root package name */
    @p0
    public o1.c f16896c9;

    public final class b implements AudioSink.a {
        public b() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void a(boolean z10) {
            h.this.S8.z(z10);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void b(long j10) {
            h.this.S8.y(j10);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void c(int i10, long j10, long j11) {
            h.this.S8.A(i10, j10, j11);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void d(Exception exc) {
            h.this.S8.j(exc);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void e(long j10) {
            if (h.this.f16896c9 != null) {
                h.this.f16896c9.b(j10);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void f() {
            h.this.z1();
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void g() {
            if (h.this.f16896c9 != null) {
                h.this.f16896c9.a();
            }
        }
    }

    public h(Context context, com.google.android.exoplayer2.mediacodec.d dVar) {
        this(context, dVar, null, null);
    }

    public static boolean t1(String str) {
        if (u0.f31154a < 24 && "OMX.SEC.aac.dec".equals(str) && com.google.android.material.internal.i.f20422b.equals(u0.f31156c)) {
            String str2 = u0.f31155b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    public static boolean u1() {
        if (u0.f31154a == 23) {
            String str = u0.f31157d;
            if ("ZTE B2017G".equals(str) || "AXON 7 mini".equals(str)) {
                return true;
            }
        }
        return false;
    }

    public final void A1() {
        long jR = this.T8.r(b());
        if (jR != Long.MIN_VALUE) {
            if (!this.Z8) {
                jR = Math.max(this.X8, jR);
            }
            this.X8 = jR;
            this.Z8 = false;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    public void G() {
        this.f16894a9 = true;
        try {
            this.T8.flush();
            try {
                super.G();
            } finally {
            }
        } catch (Throwable th2) {
            try {
                super.G();
                throw th2;
            } finally {
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    public void H(boolean z10, boolean z11) throws ExoPlaybackException {
        super.H(z10, z11);
        this.S8.n(this.f17156u8);
        if (A().f57065a) {
            this.T8.u();
        } else {
            this.T8.s();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    public void I(long j10, boolean z10) throws ExoPlaybackException {
        super.I(j10, z10);
        if (this.f16895b9) {
            this.T8.A();
        } else {
            this.T8.flush();
        }
        this.X8 = j10;
        this.Y8 = true;
        this.Z8 = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    public void J() {
        try {
            super.J();
        } finally {
            if (this.f16894a9) {
                this.f16894a9 = false;
                this.T8.reset();
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    public void K() {
        super.K();
        this.T8.i();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    public void L() {
        A1();
        this.T8.pause();
        super.L();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void M0(String str, long j10, long j11) {
        this.S8.k(str, j10, j11);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void N0(String str) {
        this.S8.l(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @p0
    public eb.e O0(s0 s0Var) throws ExoPlaybackException {
        eb.e eVarO0 = super.O0(s0Var);
        this.S8.o(s0Var.f57068b, eVarO0);
        return eVarO0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void P0(Format format, @p0 MediaFormat mediaFormat) throws ExoPlaybackException {
        int i10;
        Format format2 = this.W8;
        int[] iArr = null;
        if (format2 != null) {
            format = format2;
        } else if (r0() != null) {
            Format formatE = new Format.b().e0(w.G).Y(w.G.equals(format.f16699l) ? format.A : (u0.f31154a < 24 || !mediaFormat.containsKey("pcm-encoding")) ? mediaFormat.containsKey(f16893e9) ? u0.k0(mediaFormat.getInteger(f16893e9)) : w.G.equals(format.f16699l) ? format.A : 2 : mediaFormat.getInteger("pcm-encoding")).M(format.B).N(format.C).H(mediaFormat.getInteger("channel-count")).f0(mediaFormat.getInteger("sample-rate")).E();
            if (this.V8 && formatE.f16712y == 6 && (i10 = format.f16712y) < 6) {
                iArr = new int[i10];
                for (int i11 = 0; i11 < format.f16712y; i11++) {
                    iArr[i11] = i11;
                }
            }
            format = formatE;
        }
        try {
            this.T8.z(format, 0, iArr);
        } catch (AudioSink.ConfigurationException e10) {
            throw y(e10, e10.format);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public eb.e R(com.google.android.exoplayer2.mediacodec.c cVar, Format format, Format format2) {
        eb.e eVarE = cVar.e(format, format2);
        int i10 = eVarE.f26792e;
        if (w1(cVar, format2) > this.U8) {
            i10 |= 64;
        }
        int i11 = i10;
        return new eb.e(cVar.f17203a, format, format2, i11 != 0 ? 0 : eVarE.f26791d, i11);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void R0() {
        super.R0();
        this.T8.t();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void S0(DecoderInputBuffer decoderInputBuffer) {
        if (!this.Y8 || decoderInputBuffer.l()) {
            return;
        }
        if (Math.abs(decoderInputBuffer.f16962e - this.X8) > 500000) {
            this.X8 = decoderInputBuffer.f16962e;
        }
        this.Y8 = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean U0(long j10, long j11, @p0 com.google.android.exoplayer2.mediacodec.b bVar, @p0 ByteBuffer byteBuffer, int i10, int i11, int i12, long j12, boolean z10, boolean z11, Format format) throws ExoPlaybackException {
        hd.a.g(byteBuffer);
        if (this.W8 != null && (i11 & 2) != 0) {
            ((com.google.android.exoplayer2.mediacodec.b) hd.a.g(bVar)).i(i10, false);
            return true;
        }
        if (z10) {
            if (bVar != null) {
                bVar.i(i10, false);
            }
            this.f17156u8.f26763f += i12;
            this.T8.t();
            return true;
        }
        try {
            if (!this.T8.w(byteBuffer, j12, i12)) {
                return false;
            }
            if (bVar != null) {
                bVar.i(i10, false);
            }
            this.f17156u8.f26762e += i12;
            return true;
        } catch (AudioSink.InitializationException e10) {
            throw z(e10, e10.format, e10.isRecoverable);
        } catch (AudioSink.WriteException e11) {
            throw z(e11, format, e11.isRecoverable);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void Z0() throws ExoPlaybackException {
        try {
            this.T8.p();
        } catch (AudioSink.WriteException e10) {
            throw z(e10, e10.format, e10.isRecoverable);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, ya.o1
    public boolean b() {
        return super.b() && this.T8.b();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void b0(com.google.android.exoplayer2.mediacodec.c cVar, com.google.android.exoplayer2.mediacodec.b bVar, Format format, @p0 MediaCrypto mediaCrypto, float f10) {
        this.U8 = x1(cVar, format, E());
        this.V8 = t1(cVar.f17203a);
        boolean z10 = false;
        bVar.b(y1(format, cVar.f17205c, this.U8, f10), null, mediaCrypto, 0);
        if (w.G.equals(cVar.f17204b) && !w.G.equals(format.f16699l)) {
            z10 = true;
        }
        if (!z10) {
            format = null;
        }
        this.W8 = format;
    }

    @Override // hd.v
    public void c(h1 h1Var) {
        this.T8.c(h1Var);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, ya.o1
    public boolean d() {
        return this.T8.q() || super.d();
    }

    @Override // hd.v
    public h1 e() {
        return this.T8.e();
    }

    @Override // ya.o1, ya.q1
    public String getName() {
        return f16892d9;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean l1(Format format) {
        return this.T8.a(format);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int m1(com.google.android.exoplayer2.mediacodec.d dVar, Format format) throws MediaCodecUtil.DecoderQueryException {
        if (!w.p(format.f16699l)) {
            return p1.a(0);
        }
        int i10 = u0.f31154a >= 21 ? 32 : 0;
        boolean z10 = format.f16698k0 != null;
        boolean zN1 = MediaCodecRenderer.n1(format);
        int i11 = 8;
        if (zN1 && this.T8.a(format) && (!z10 || MediaCodecUtil.v() != null)) {
            return p1.b(4, 8, i10);
        }
        if (w.G.equals(format.f16699l) && !this.T8.a(format)) {
            return p1.a(1);
        }
        if (!this.T8.a(u0.l0(2, format.f16712y, format.f16713z))) {
            return p1.a(1);
        }
        List<com.google.android.exoplayer2.mediacodec.c> listX0 = x0(dVar, format, false);
        if (listX0.isEmpty()) {
            return p1.a(1);
        }
        if (!zN1) {
            return p1.a(2);
        }
        com.google.android.exoplayer2.mediacodec.c cVar = listX0.get(0);
        boolean zO = cVar.o(format);
        if (zO && cVar.q(format)) {
            i11 = 16;
        }
        return p1.b(zO ? 4 : 3, i11, i10);
    }

    @Override // hd.v
    public long n() {
        if (getState() == 2) {
            A1();
        }
        return this.X8;
    }

    @Override // com.google.android.exoplayer2.a, ya.l1.b
    public void r(int i10, @p0 Object obj) throws ExoPlaybackException {
        if (i10 == 2) {
            this.T8.m(((Float) obj).floatValue());
        }
        if (i10 == 3) {
            this.T8.v((ab.d) obj);
            return;
        }
        if (i10 == 5) {
            this.T8.l((u) obj);
            return;
        }
        switch (i10) {
            case 101:
                this.T8.o(((Boolean) obj).booleanValue());
                break;
            case 102:
                this.T8.h(((Integer) obj).intValue());
                break;
            case 103:
                this.f16896c9 = (o1.c) obj;
                break;
            default:
                super.r(i10, obj);
                break;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float v0(float f10, Format format, Format[] formatArr) {
        int iMax = -1;
        for (Format format2 : formatArr) {
            int i10 = format2.f16713z;
            if (i10 != -1) {
                iMax = Math.max(iMax, i10);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return f10 * iMax;
    }

    public void v1(boolean z10) {
        this.f16895b9 = z10;
    }

    public final int w1(com.google.android.exoplayer2.mediacodec.c cVar, Format format) {
        int i10;
        if (!"OMX.google.raw.decoder".equals(cVar.f17203a) || (i10 = u0.f31154a) >= 24 || (i10 == 23 && u0.I0(this.R8))) {
            return format.f16700m;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.a, ya.o1
    @p0
    public v x() {
        return this;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public List<com.google.android.exoplayer2.mediacodec.c> x0(com.google.android.exoplayer2.mediacodec.d dVar, Format format, boolean z10) throws MediaCodecUtil.DecoderQueryException {
        com.google.android.exoplayer2.mediacodec.c cVarV;
        String str = format.f16699l;
        if (str == null) {
            return Collections.emptyList();
        }
        if (this.T8.a(format) && (cVarV = MediaCodecUtil.v()) != null) {
            return Collections.singletonList(cVarV);
        }
        List<com.google.android.exoplayer2.mediacodec.c> listU = MediaCodecUtil.u(dVar.a(str, z10, false), format);
        if (w.L.equals(str)) {
            ArrayList arrayList = new ArrayList(listU);
            arrayList.addAll(dVar.a(w.K, z10, false));
            listU = arrayList;
        }
        return Collections.unmodifiableList(listU);
    }

    public int x1(com.google.android.exoplayer2.mediacodec.c cVar, Format format, Format[] formatArr) {
        int iW1 = w1(cVar, format);
        if (formatArr.length == 1) {
            return iW1;
        }
        for (Format format2 : formatArr) {
            if (cVar.e(format, format2).f26791d != 0) {
                iW1 = Math.max(iW1, w1(cVar, format2));
            }
        }
        return iW1;
    }

    @SuppressLint({"InlinedApi"})
    public MediaFormat y1(Format format, String str, int i10, float f10) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", format.f16712y);
        mediaFormat.setInteger("sample-rate", format.f16713z);
        o.e(mediaFormat, format.f16701n);
        o.d(mediaFormat, "max-input-size", i10);
        int i11 = u0.f31154a;
        if (i11 >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f10 != -1.0f && !u1()) {
                mediaFormat.setFloat("operating-rate", f10);
            }
        }
        if (i11 <= 28 && w.M.equals(format.f16699l)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i11 >= 24 && this.T8.y(u0.l0(4, format.f16712y, format.f16713z)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        return mediaFormat;
    }

    @g.i
    public void z1() {
        this.Z8 = true;
    }

    public h(Context context, com.google.android.exoplayer2.mediacodec.d dVar, @p0 Handler handler, @p0 com.google.android.exoplayer2.audio.a aVar) {
        this(context, dVar, handler, aVar, (ab.e) null, new AudioProcessor[0]);
    }

    public h(Context context, com.google.android.exoplayer2.mediacodec.d dVar, @p0 Handler handler, @p0 com.google.android.exoplayer2.audio.a aVar, @p0 ab.e eVar, AudioProcessor... audioProcessorArr) {
        this(context, dVar, handler, aVar, new DefaultAudioSink(eVar, audioProcessorArr));
    }

    public h(Context context, com.google.android.exoplayer2.mediacodec.d dVar, @p0 Handler handler, @p0 com.google.android.exoplayer2.audio.a aVar, AudioSink audioSink) {
        this(context, b.a.f17200a, dVar, false, handler, aVar, audioSink);
    }

    public h(Context context, com.google.android.exoplayer2.mediacodec.d dVar, boolean z10, @p0 Handler handler, @p0 com.google.android.exoplayer2.audio.a aVar, AudioSink audioSink) {
        this(context, b.a.f17200a, dVar, z10, handler, aVar, audioSink);
    }

    public h(Context context, b.a aVar, com.google.android.exoplayer2.mediacodec.d dVar, boolean z10, @p0 Handler handler, @p0 com.google.android.exoplayer2.audio.a aVar2, AudioSink audioSink) {
        super(1, aVar, dVar, z10, 44100.0f);
        this.R8 = context.getApplicationContext();
        this.T8 = audioSink;
        this.S8 = new a.C0175a(handler, aVar2);
        audioSink.x(new b());
    }
}
