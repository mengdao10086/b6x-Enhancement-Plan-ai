package com.google.android.exoplayer2.audio;

import ab.u;
import ab.v;
import ab.x;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.b;
import g.n0;
import g.p0;
import g.v0;
import hd.t;
import hd.u0;
import hd.w;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import ya.h1;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultAudioSink implements AudioSink {

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final float f16762e0 = 1.0f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final float f16763f0 = 0.1f;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final float f16764g0 = 8.0f;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final float f16765h0 = 0.1f;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final float f16766i0 = 8.0f;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final boolean f16767j0 = false;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f16768k0 = 0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final int f16769l0 = 1;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final int f16770m0 = 2;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final long f16771n0 = 250000;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final long f16772o0 = 750000;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final long f16773p0 = 250000;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final long f16774q0 = 50000000;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final int f16775r0 = 4;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final int f16776s0 = 2;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final int f16777t0 = -32;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final int f16778u0 = 100;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final String f16779v0 = "DefaultAudioSink";

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static boolean f16780w0;
    public h1 A;

    @p0
    public ByteBuffer B;
    public int C;
    public long D;
    public long E;
    public long F;
    public long G;
    public int H;
    public boolean I;
    public boolean J;
    public long K;
    public float L;
    public AudioProcessor[] M;
    public ByteBuffer[] N;

    @p0
    public ByteBuffer O;
    public int P;

    @p0
    public ByteBuffer Q;
    public byte[] R;
    public int S;
    public int T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public int Y;
    public u Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f16781a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public long f16782b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f16783c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f16784d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public final ab.e f16785e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f16786f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f16787g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.google.android.exoplayer2.audio.d f16788h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final m f16789i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AudioProcessor[] f16790j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AudioProcessor[] f16791k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ConditionVariable f16792l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.google.android.exoplayer2.audio.b f16793m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayDeque<e> f16794n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f16795o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f16796p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public h f16797q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final f<AudioSink.InitializationException> f16798r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final f<AudioSink.WriteException> f16799s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @p0
    public AudioSink.a f16800t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @p0
    public c f16801u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public c f16802v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @p0
    public AudioTrack f16803w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ab.d f16804x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @p0
    public e f16805y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public e f16806z;

    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        public /* synthetic */ InvalidAudioTrackTimestampException(String str, a aVar) {
            this(str);
        }

        public InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    public class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioTrack f16807a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, AudioTrack audioTrack) {
            super(str);
            this.f16807a = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.f16807a.flush();
                this.f16807a.release();
            } finally {
                DefaultAudioSink.this.f16792l.open();
            }
        }
    }

    public interface b {
        h1 a(h1 h1Var);

        long b(long j10);

        long c();

        boolean d(boolean z10);

        AudioProcessor[] e();
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Format f16809a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f16810b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f16811c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f16812d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f16813e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f16814f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f16815g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f16816h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final AudioProcessor[] f16817i;

        public c(Format format, int i10, int i11, int i12, int i13, int i14, int i15, int i16, boolean z10, AudioProcessor[] audioProcessorArr) {
            this.f16809a = format;
            this.f16810b = i10;
            this.f16811c = i11;
            this.f16812d = i12;
            this.f16813e = i13;
            this.f16814f = i14;
            this.f16815g = i15;
            this.f16817i = audioProcessorArr;
            this.f16816h = c(i16, z10);
        }

        @v0(21)
        public static AudioAttributes j(ab.d dVar, boolean z10) {
            return z10 ? k() : dVar.a();
        }

        @v0(21)
        public static AudioAttributes k() {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }

        public AudioTrack a(boolean z10, ab.d dVar, int i10) throws AudioSink.InitializationException {
            try {
                AudioTrack audioTrackD = d(z10, dVar, i10);
                int state = audioTrackD.getState();
                if (state == 1) {
                    return audioTrackD;
                }
                try {
                    audioTrackD.release();
                } catch (Exception unused) {
                }
                throw new AudioSink.InitializationException(state, this.f16813e, this.f16814f, this.f16816h, this.f16809a, o(), null);
            } catch (IllegalArgumentException | UnsupportedOperationException e10) {
                throw new AudioSink.InitializationException(0, this.f16813e, this.f16814f, this.f16816h, this.f16809a, o(), e10);
            }
        }

        public boolean b(c cVar) {
            return cVar.f16811c == this.f16811c && cVar.f16815g == this.f16815g && cVar.f16813e == this.f16813e && cVar.f16814f == this.f16814f && cVar.f16812d == this.f16812d;
        }

        public final int c(int i10, boolean z10) {
            if (i10 != 0) {
                return i10;
            }
            int i11 = this.f16811c;
            if (i11 == 0) {
                return m(z10 ? 8.0f : 1.0f);
            }
            if (i11 == 1) {
                return l(DefaultAudioSink.f16774q0);
            }
            if (i11 == 2) {
                return l(250000L);
            }
            throw new IllegalStateException();
        }

        public final AudioTrack d(boolean z10, ab.d dVar, int i10) {
            int i11 = u0.f31154a;
            return i11 >= 29 ? f(z10, dVar, i10) : i11 >= 21 ? e(z10, dVar, i10) : g(dVar, i10);
        }

        @v0(21)
        public final AudioTrack e(boolean z10, ab.d dVar, int i10) {
            return new AudioTrack(j(dVar, z10), DefaultAudioSink.L(this.f16813e, this.f16814f, this.f16815g), this.f16816h, 1, i10);
        }

        @v0(29)
        public final AudioTrack f(boolean z10, ab.d dVar, int i10) {
            return new AudioTrack.Builder().setAudioAttributes(j(dVar, z10)).setAudioFormat(DefaultAudioSink.L(this.f16813e, this.f16814f, this.f16815g)).setTransferMode(1).setBufferSizeInBytes(this.f16816h).setSessionId(i10).setOffloadedPlayback(this.f16811c == 1).build();
        }

        public final AudioTrack g(ab.d dVar, int i10) {
            int iO0 = u0.o0(dVar.f420c);
            return i10 == 0 ? new AudioTrack(iO0, this.f16813e, this.f16814f, this.f16815g, this.f16816h, 1) : new AudioTrack(iO0, this.f16813e, this.f16814f, this.f16815g, this.f16816h, 1, i10);
        }

        public long h(long j10) {
            return (j10 * ((long) this.f16813e)) / 1000000;
        }

        public long i(long j10) {
            return (j10 * 1000000) / ((long) this.f16813e);
        }

        public final int l(long j10) {
            int iR = DefaultAudioSink.R(this.f16815g);
            if (this.f16815g == 5) {
                iR *= 2;
            }
            return (int) ((j10 * ((long) iR)) / 1000000);
        }

        public final int m(float f10) {
            int minBufferSize = AudioTrack.getMinBufferSize(this.f16813e, this.f16814f, this.f16815g);
            hd.a.i(minBufferSize != -2);
            int iT = u0.t(minBufferSize * 4, ((int) h(250000L)) * this.f16812d, Math.max(minBufferSize, ((int) h(DefaultAudioSink.f16772o0)) * this.f16812d));
            return f10 != 1.0f ? Math.round(iT * f10) : iT;
        }

        public long n(long j10) {
            return (j10 * 1000000) / ((long) this.f16809a.f16713z);
        }

        public boolean o() {
            return this.f16811c == 1;
        }
    }

    public static class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AudioProcessor[] f16818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j f16819b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final k f16820c;

        public d(AudioProcessor... audioProcessorArr) {
            this(audioProcessorArr, new j(), new k());
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public h1 a(h1 h1Var) {
            this.f16820c.i(h1Var.f56785a);
            this.f16820c.h(h1Var.f56786b);
            return h1Var;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public long b(long j10) {
            return this.f16820c.a(j10);
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public long c() {
            return this.f16819b.o();
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public boolean d(boolean z10) {
            this.f16819b.u(z10);
            return z10;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public AudioProcessor[] e() {
            return this.f16818a;
        }

        public d(AudioProcessor[] audioProcessorArr, j jVar, k kVar) {
            AudioProcessor[] audioProcessorArr2 = new AudioProcessor[audioProcessorArr.length + 2];
            this.f16818a = audioProcessorArr2;
            System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
            this.f16819b = jVar;
            this.f16820c = kVar;
            audioProcessorArr2[audioProcessorArr.length] = jVar;
            audioProcessorArr2[audioProcessorArr.length + 1] = kVar;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h1 f16821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f16822b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f16823c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f16824d;

        public /* synthetic */ e(h1 h1Var, boolean z10, long j10, long j11, a aVar) {
            this(h1Var, z10, j10, j11);
        }

        public e(h1 h1Var, boolean z10, long j10, long j11) {
            this.f16821a = h1Var;
            this.f16822b = z10;
            this.f16823c = j10;
            this.f16824d = j11;
        }
    }

    public static final class f<T extends Exception> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f16825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public T f16826b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f16827c;

        public f(long j10) {
            this.f16825a = j10;
        }

        public void a() {
            this.f16826b = null;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: T extends java.lang.Exception */
        public void b(T t10) throws Exception {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f16826b == null) {
                this.f16826b = t10;
                this.f16827c = this.f16825a + jElapsedRealtime;
            }
            if (jElapsedRealtime >= this.f16827c) {
                T t11 = this.f16826b;
                if (t11 != t10) {
                    t11.addSuppressed(t10);
                }
                T t12 = this.f16826b;
                a();
                throw t12;
            }
        }
    }

    public final class g implements b.a {
        public g() {
        }

        @Override // com.google.android.exoplayer2.audio.b.a
        public void a(int i10, long j10) {
            if (DefaultAudioSink.this.f16800t != null) {
                DefaultAudioSink.this.f16800t.c(i10, j10, SystemClock.elapsedRealtime() - DefaultAudioSink.this.f16782b0);
            }
        }

        @Override // com.google.android.exoplayer2.audio.b.a
        public void b(long j10) {
            if (DefaultAudioSink.this.f16800t != null) {
                DefaultAudioSink.this.f16800t.b(j10);
            }
        }

        @Override // com.google.android.exoplayer2.audio.b.a
        public void c(long j10) {
            t.n(DefaultAudioSink.f16779v0, "Ignoring impossibly large audio latency: " + j10);
        }

        @Override // com.google.android.exoplayer2.audio.b.a
        public void d(long j10, long j11, long j12, long j13) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j10 + ", " + j11 + ", " + j12 + ", " + j13 + ", " + DefaultAudioSink.this.T() + ", " + DefaultAudioSink.this.U();
            if (DefaultAudioSink.f16780w0) {
                throw new InvalidAudioTrackTimestampException(str, null);
            }
            t.n(DefaultAudioSink.f16779v0, str);
        }

        @Override // com.google.android.exoplayer2.audio.b.a
        public void e(long j10, long j11, long j12, long j13) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j10 + ", " + j11 + ", " + j12 + ", " + j13 + ", " + DefaultAudioSink.this.T() + ", " + DefaultAudioSink.this.U();
            if (DefaultAudioSink.f16780w0) {
                throw new InvalidAudioTrackTimestampException(str, null);
            }
            t.n(DefaultAudioSink.f16779v0, str);
        }

        public /* synthetic */ g(DefaultAudioSink defaultAudioSink, a aVar) {
            this();
        }
    }

    @v0(29)
    public final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f16829a = new Handler();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AudioTrack.StreamEventCallback f16830b;

        public class a extends AudioTrack.StreamEventCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DefaultAudioSink f16832a;

            public a(DefaultAudioSink defaultAudioSink) {
                this.f16832a = defaultAudioSink;
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onDataRequest(AudioTrack audioTrack, int i10) {
                hd.a.i(audioTrack == DefaultAudioSink.this.f16803w);
                if (DefaultAudioSink.this.f16800t == null || !DefaultAudioSink.this.W) {
                    return;
                }
                DefaultAudioSink.this.f16800t.g();
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onTearDown(@n0 AudioTrack audioTrack) {
                hd.a.i(audioTrack == DefaultAudioSink.this.f16803w);
                if (DefaultAudioSink.this.f16800t == null || !DefaultAudioSink.this.W) {
                    return;
                }
                DefaultAudioSink.this.f16800t.g();
            }
        }

        public h() {
            this.f16830b = new a(DefaultAudioSink.this);
        }

        public void a(AudioTrack audioTrack) {
            Handler handler = this.f16829a;
            Objects.requireNonNull(handler);
            audioTrack.registerStreamEventCallback(new v(handler), this.f16830b);
        }

        public void b(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.f16830b);
            this.f16829a.removeCallbacksAndMessages(null);
        }
    }

    public DefaultAudioSink(@p0 ab.e eVar, AudioProcessor[] audioProcessorArr) {
        this(eVar, audioProcessorArr, false);
    }

    @v0(21)
    public static AudioFormat L(int i10, int i11, int i12) {
        return new AudioFormat.Builder().setSampleRate(i10).setChannelMask(i11).setEncoding(i12).build();
    }

    public static int N(int i10) {
        int i11 = u0.f31154a;
        if (i11 <= 28) {
            if (i10 == 7) {
                i10 = 8;
            } else if (i10 == 3 || i10 == 4 || i10 == 5) {
                i10 = 6;
            }
        }
        if (i11 <= 26 && "fugu".equals(u0.f31155b) && i10 == 1) {
            i10 = 2;
        }
        return u0.N(i10);
    }

    @p0
    public static Pair<Integer, Integer> O(Format format, @p0 ab.e eVar) {
        if (eVar == null) {
            return null;
        }
        int iF = w.f((String) hd.a.g(format.f16699l), format.f16695i);
        int iQ = 6;
        if (!(iF == 5 || iF == 6 || iF == 18 || iF == 17 || iF == 7 || iF == 8 || iF == 14)) {
            return null;
        }
        if (iF == 18 && !eVar.f(18)) {
            iF = 6;
        } else if (iF == 8 && !eVar.f(8)) {
            iF = 7;
        }
        if (!eVar.f(iF)) {
            return null;
        }
        if (iF != 18) {
            iQ = format.f16712y;
            if (iQ > eVar.e()) {
                return null;
            }
        } else if (u0.f31154a >= 29 && (iQ = Q(18, format.f16713z)) == 0) {
            t.n(f16779v0, "E-AC3 JOC encoding supported but no channel count supported");
            return null;
        }
        int iN = N(iQ);
        if (iN == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(iF), Integer.valueOf(iN));
    }

    public static int P(int i10, ByteBuffer byteBuffer) {
        switch (i10) {
            case 5:
            case 6:
            case 18:
                return ab.b.d(byteBuffer);
            case 7:
            case 8:
                return ab.w.e(byteBuffer);
            case 9:
                int iM = x.m(u0.P(byteBuffer, byteBuffer.position()));
                if (iM != -1) {
                    return iM;
                }
                throw new IllegalArgumentException();
            case 10:
                return 1024;
            case 11:
            case 12:
                return 2048;
            case 13:
            default:
                throw new IllegalStateException("Unexpected audio encoding: " + i10);
            case 14:
                int iA = ab.b.a(byteBuffer);
                if (iA == -1) {
                    return 0;
                }
                return ab.b.h(byteBuffer, iA) * 16;
            case 15:
                return 512;
            case 16:
                return 1024;
            case 17:
                return ab.c.c(byteBuffer);
        }
    }

    @v0(29)
    public static int Q(int i10, int i11) {
        AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setUsage(1).setContentType(3).build();
        for (int i12 = 8; i12 > 0; i12--) {
            if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i10).setSampleRate(i11).setChannelMask(u0.N(i12)).build(), audioAttributesBuild)) {
                return i12;
            }
        }
        return 0;
    }

    public static int R(int i10) {
        switch (i10) {
            case 5:
                return ab.b.f382a;
            case 6:
            case 18:
                return ab.b.f383b;
            case 7:
                return ab.w.f491a;
            case 8:
                return ab.w.f492b;
            case 9:
                return x.f505b;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return ab.a.f354h;
            case 13:
            default:
                throw new IllegalArgumentException();
            case 14:
                return ab.b.f384c;
            case 15:
                return 8000;
            case 16:
                return ab.a.f355i;
            case 17:
                return ab.c.f407c;
        }
    }

    public static boolean W(int i10) {
        return (u0.f31154a >= 24 && i10 == -6) || i10 == -32;
    }

    public static boolean Y() {
        return u0.f31154a >= 30 && u0.f31157d.startsWith("Pixel");
    }

    public static boolean Z(AudioTrack audioTrack) {
        return u0.f31154a >= 29 && audioTrack.isOffloadedPlayback();
    }

    public static boolean a0(Format format, ab.d dVar) {
        int iF;
        int iN;
        if (u0.f31154a >= 29 && (iF = w.f((String) hd.a.g(format.f16699l), format.f16695i)) != 0 && (iN = u0.N(format.f16712y)) != 0 && AudioManager.isOffloadedPlaybackSupported(L(format.f16713z, iN, iF), dVar.a())) {
            return (format.B == 0 && format.C == 0) || Y();
        }
        return false;
    }

    public static boolean b0(Format format, @p0 ab.e eVar) {
        return O(format, eVar) != null;
    }

    @v0(21)
    public static void k0(AudioTrack audioTrack, float f10) {
        audioTrack.setVolume(f10);
    }

    public static void l0(AudioTrack audioTrack, float f10) {
        audioTrack.setStereoVolume(f10, f10);
    }

    @v0(21)
    public static int q0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i10) {
        return audioTrack.write(byteBuffer, i10, 1);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void A() {
        if (u0.f31154a < 25) {
            flush();
            return;
        }
        this.f16799s.a();
        this.f16798r.a();
        if (X()) {
            g0();
            if (this.f16793m.j()) {
                this.f16803w.pause();
            }
            this.f16803w.flush();
            this.f16793m.r();
            com.google.android.exoplayer2.audio.b bVar = this.f16793m;
            AudioTrack audioTrack = this.f16803w;
            c cVar = this.f16802v;
            bVar.t(audioTrack, cVar.f16811c == 2, cVar.f16815g, cVar.f16812d, cVar.f16816h);
            this.J = true;
        }
    }

    public final void F(long j10) {
        h1 h1VarA = n0() ? this.f16786f.a(M()) : h1.f56784d;
        boolean zD = n0() ? this.f16786f.d(n()) : false;
        this.f16794n.add(new e(h1VarA, zD, Math.max(0L, j10), this.f16802v.i(U()), null));
        m0();
        AudioSink.a aVar = this.f16800t;
        if (aVar != null) {
            aVar.a(zD);
        }
    }

    public final long G(long j10) {
        while (!this.f16794n.isEmpty() && j10 >= this.f16794n.getFirst().f16824d) {
            this.f16806z = this.f16794n.remove();
        }
        e eVar = this.f16806z;
        long j11 = j10 - eVar.f16824d;
        if (eVar.f16821a.equals(h1.f56784d)) {
            return this.f16806z.f16823c + j11;
        }
        if (this.f16794n.isEmpty()) {
            return this.f16806z.f16823c + this.f16786f.b(j11);
        }
        e first = this.f16794n.getFirst();
        return first.f16823c - u0.g0(first.f16824d - j10, this.f16806z.f16821a.f56785a);
    }

    public final long H(long j10) {
        return j10 + this.f16802v.i(this.f16786f.c());
    }

    public final AudioTrack I() throws AudioSink.InitializationException {
        try {
            return ((c) hd.a.g(this.f16802v)).a(this.f16781a0, this.f16804x, this.Y);
        } catch (AudioSink.InitializationException e10) {
            c0();
            AudioSink.a aVar = this.f16800t;
            if (aVar != null) {
                aVar.d(e10);
            }
            throw e10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0029 -> B:5:0x0009). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean J() throws java.lang.Exception {
        /*
            r9 = this;
            int r0 = r9.T
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto Lb
            r9.T = r3
        L9:
            r0 = 1
            goto Lc
        Lb:
            r0 = 0
        Lc:
            int r4 = r9.T
            com.google.android.exoplayer2.audio.AudioProcessor[] r5 = r9.M
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L2f
            r4 = r5[r4]
            if (r0 == 0) goto L1f
            r4.f()
        L1f:
            r9.e0(r7)
            boolean r0 = r4.b()
            if (r0 != 0) goto L29
            return r3
        L29:
            int r0 = r9.T
            int r0 = r0 + r2
            r9.T = r0
            goto L9
        L2f:
            java.nio.ByteBuffer r0 = r9.Q
            if (r0 == 0) goto L3b
            r9.p0(r0, r7)
            java.nio.ByteBuffer r0 = r9.Q
            if (r0 == 0) goto L3b
            return r3
        L3b:
            r9.T = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.DefaultAudioSink.J():boolean");
    }

    public final void K() {
        int i10 = 0;
        while (true) {
            AudioProcessor[] audioProcessorArr = this.M;
            if (i10 >= audioProcessorArr.length) {
                return;
            }
            AudioProcessor audioProcessor = audioProcessorArr[i10];
            audioProcessor.flush();
            this.N[i10] = audioProcessor.c();
            i10++;
        }
    }

    public final h1 M() {
        return S().f16821a;
    }

    public final e S() {
        e eVar = this.f16805y;
        return eVar != null ? eVar : !this.f16794n.isEmpty() ? this.f16794n.getLast() : this.f16806z;
    }

    public final long T() {
        c cVar = this.f16802v;
        return cVar.f16811c == 0 ? this.D / ((long) cVar.f16810b) : this.E;
    }

    public final long U() {
        c cVar = this.f16802v;
        return cVar.f16811c == 0 ? this.F / ((long) cVar.f16812d) : this.G;
    }

    public final void V() throws AudioSink.InitializationException {
        this.f16792l.block();
        AudioTrack audioTrackI = I();
        this.f16803w = audioTrackI;
        if (Z(audioTrackI)) {
            f0(this.f16803w);
            AudioTrack audioTrack = this.f16803w;
            Format format = this.f16802v.f16809a;
            audioTrack.setOffloadDelayPadding(format.B, format.C);
        }
        this.Y = this.f16803w.getAudioSessionId();
        com.google.android.exoplayer2.audio.b bVar = this.f16793m;
        AudioTrack audioTrack2 = this.f16803w;
        c cVar = this.f16802v;
        bVar.t(audioTrack2, cVar.f16811c == 2, cVar.f16815g, cVar.f16812d, cVar.f16816h);
        j0();
        int i10 = this.Z.f488a;
        if (i10 != 0) {
            this.f16803w.attachAuxEffect(i10);
            this.f16803w.setAuxEffectSendLevel(this.Z.f489b);
        }
        this.J = true;
    }

    public final boolean X() {
        return this.f16803w != null;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean a(Format format) {
        return y(format) != 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean b() {
        return !X() || (this.U && !q());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void c(h1 h1Var) {
        h1 h1Var2 = new h1(u0.s(h1Var.f56785a, 0.1f, 8.0f), u0.s(h1Var.f56786b, 0.1f, 8.0f));
        if (!this.f16795o || u0.f31154a < 23) {
            h0(h1Var2, n());
        } else {
            i0(h1Var2);
        }
    }

    public final void c0() {
        if (this.f16802v.o()) {
            this.f16783c0 = true;
        }
    }

    public final void d0() {
        if (this.V) {
            return;
        }
        this.V = true;
        this.f16793m.h(U());
        this.f16803w.stop();
        this.C = 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public h1 e() {
        return this.f16795o ? this.A : M();
    }

    public final void e0(long j10) throws Exception {
        ByteBuffer byteBuffer;
        int length = this.M.length;
        int i10 = length;
        while (i10 >= 0) {
            if (i10 > 0) {
                byteBuffer = this.N[i10 - 1];
            } else {
                byteBuffer = this.O;
                if (byteBuffer == null) {
                    byteBuffer = AudioProcessor.f16752a;
                }
            }
            if (i10 == length) {
                p0(byteBuffer, j10);
            } else {
                AudioProcessor audioProcessor = this.M[i10];
                if (i10 > this.T) {
                    audioProcessor.d(byteBuffer);
                }
                ByteBuffer byteBufferC = audioProcessor.c();
                this.N[i10] = byteBufferC;
                if (byteBufferC.hasRemaining()) {
                    i10++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i10--;
            }
        }
    }

    @v0(29)
    public final void f0(AudioTrack audioTrack) {
        if (this.f16797q == null) {
            this.f16797q = new h();
        }
        this.f16797q.a(audioTrack);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void flush() {
        if (X()) {
            g0();
            if (this.f16793m.j()) {
                this.f16803w.pause();
            }
            if (Z(this.f16803w)) {
                ((h) hd.a.g(this.f16797q)).b(this.f16803w);
            }
            AudioTrack audioTrack = this.f16803w;
            this.f16803w = null;
            if (u0.f31154a < 21 && !this.X) {
                this.Y = 0;
            }
            c cVar = this.f16801u;
            if (cVar != null) {
                this.f16802v = cVar;
                this.f16801u = null;
            }
            this.f16793m.r();
            this.f16792l.close();
            new a("ExoPlayer:AudioTrackReleaseThread", audioTrack).start();
        }
        this.f16799s.a();
        this.f16798r.a();
    }

    public final void g0() {
        this.D = 0L;
        this.E = 0L;
        this.F = 0L;
        this.G = 0L;
        this.f16784d0 = false;
        this.H = 0;
        this.f16806z = new e(M(), n(), 0L, 0L, null);
        this.K = 0L;
        this.f16805y = null;
        this.f16794n.clear();
        this.O = null;
        this.P = 0;
        this.Q = null;
        this.V = false;
        this.U = false;
        this.T = -1;
        this.B = null;
        this.C = 0;
        this.f16789i.m();
        K();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void h(int i10) {
        if (this.Y != i10) {
            this.Y = i10;
            this.X = i10 != 0;
            flush();
        }
    }

    public final void h0(h1 h1Var, boolean z10) {
        e eVarS = S();
        if (h1Var.equals(eVarS.f16821a) && z10 == eVarS.f16822b) {
            return;
        }
        e eVar = new e(h1Var, z10, ya.g.f56663b, ya.g.f56663b, null);
        if (X()) {
            this.f16805y = eVar;
        } else {
            this.f16806z = eVar;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void i() {
        this.W = true;
        if (X()) {
            this.f16793m.v();
            this.f16803w.play();
        }
    }

    @v0(23)
    public final void i0(h1 h1Var) {
        if (X()) {
            try {
                this.f16803w.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(h1Var.f56785a).setPitch(h1Var.f56786b).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e10) {
                t.o(f16779v0, "Failed to set playback params", e10);
            }
            h1Var = new h1(this.f16803w.getPlaybackParams().getSpeed(), this.f16803w.getPlaybackParams().getPitch());
            this.f16793m.u(h1Var.f56785a);
        }
        this.A = h1Var;
    }

    public final void j0() {
        if (X()) {
            if (u0.f31154a >= 21) {
                k0(this.f16803w, this.L);
            } else {
                l0(this.f16803w, this.L);
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void l(u uVar) {
        if (this.Z.equals(uVar)) {
            return;
        }
        int i10 = uVar.f488a;
        float f10 = uVar.f489b;
        AudioTrack audioTrack = this.f16803w;
        if (audioTrack != null) {
            if (this.Z.f488a != i10) {
                audioTrack.attachAuxEffect(i10);
            }
            if (i10 != 0) {
                this.f16803w.setAuxEffectSendLevel(f10);
            }
        }
        this.Z = uVar;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void m(float f10) {
        if (this.L != f10) {
            this.L = f10;
            j0();
        }
    }

    public final void m0() {
        AudioProcessor[] audioProcessorArr = this.f16802v.f16817i;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : audioProcessorArr) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.M = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.N = new ByteBuffer[size];
        K();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean n() {
        return S().f16822b;
    }

    public final boolean n0() {
        return (this.f16781a0 || !w.G.equals(this.f16802v.f16809a.f16699l) || o0(this.f16802v.f16809a.A)) ? false : true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void o(boolean z10) {
        h0(M(), z10);
    }

    public final boolean o0(int i10) {
        return this.f16787g && u0.D0(i10);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void p() throws AudioSink.WriteException {
        if (!this.U && X() && J()) {
            d0();
            this.U = true;
        }
    }

    public final void p0(ByteBuffer byteBuffer, long j10) throws Exception {
        int iQ0;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.Q;
            if (byteBuffer2 != null) {
                hd.a.a(byteBuffer2 == byteBuffer);
            } else {
                this.Q = byteBuffer;
                if (u0.f31154a < 21) {
                    int iRemaining = byteBuffer.remaining();
                    byte[] bArr = this.R;
                    if (bArr == null || bArr.length < iRemaining) {
                        this.R = new byte[iRemaining];
                    }
                    int iPosition = byteBuffer.position();
                    byteBuffer.get(this.R, 0, iRemaining);
                    byteBuffer.position(iPosition);
                    this.S = 0;
                }
            }
            int iRemaining2 = byteBuffer.remaining();
            if (u0.f31154a < 21) {
                int iC = this.f16793m.c(this.F);
                if (iC > 0) {
                    iQ0 = this.f16803w.write(this.R, this.S, Math.min(iRemaining2, iC));
                    if (iQ0 > 0) {
                        this.S += iQ0;
                        byteBuffer.position(byteBuffer.position() + iQ0);
                    }
                } else {
                    iQ0 = 0;
                }
            } else if (this.f16781a0) {
                hd.a.i(j10 != ya.g.f56663b);
                iQ0 = r0(this.f16803w, byteBuffer, iRemaining2, j10);
            } else {
                iQ0 = q0(this.f16803w, byteBuffer, iRemaining2);
            }
            this.f16782b0 = SystemClock.elapsedRealtime();
            if (iQ0 < 0) {
                boolean zW = W(iQ0);
                if (zW) {
                    c0();
                }
                AudioSink.WriteException writeException = new AudioSink.WriteException(iQ0, this.f16802v.f16809a, zW);
                AudioSink.a aVar = this.f16800t;
                if (aVar != null) {
                    aVar.d(writeException);
                }
                if (writeException.isRecoverable) {
                    throw writeException;
                }
                this.f16799s.b(writeException);
                return;
            }
            this.f16799s.a();
            if (Z(this.f16803w)) {
                long j11 = this.G;
                if (j11 > 0) {
                    this.f16784d0 = false;
                }
                if (this.W && this.f16800t != null && iQ0 < iRemaining2 && !this.f16784d0) {
                    this.f16800t.e(this.f16793m.e(j11));
                }
            }
            int i10 = this.f16802v.f16811c;
            if (i10 == 0) {
                this.F += (long) iQ0;
            }
            if (iQ0 == iRemaining2) {
                if (i10 != 0) {
                    hd.a.i(byteBuffer == this.O);
                    this.G += (long) (this.H * this.P);
                }
                this.Q = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        this.W = false;
        if (X() && this.f16793m.q()) {
            this.f16803w.pause();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean q() {
        return X() && this.f16793m.i(U());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long r(boolean z10) {
        if (!X() || this.J) {
            return Long.MIN_VALUE;
        }
        return H(G(Math.min(this.f16793m.d(z10), this.f16802v.i(U()))));
    }

    @v0(21)
    public final int r0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i10, long j10) {
        if (u0.f31154a >= 26) {
            return audioTrack.write(byteBuffer, i10, 1, j10 * 1000);
        }
        if (this.B == null) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            this.B = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
            this.B.putInt(1431633921);
        }
        if (this.C == 0) {
            this.B.putInt(4, i10);
            this.B.putLong(8, j10 * 1000);
            this.B.position(0);
            this.C = i10;
        }
        int iRemaining = this.B.remaining();
        if (iRemaining > 0) {
            int iWrite = audioTrack.write(this.B, iRemaining, 1);
            if (iWrite < 0) {
                this.C = 0;
                return iWrite;
            }
            if (iWrite < iRemaining) {
                return 0;
            }
        }
        int iQ0 = q0(audioTrack, byteBuffer, i10);
        if (iQ0 < 0) {
            this.C = 0;
            return iQ0;
        }
        this.C -= iQ0;
        return iQ0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        flush();
        for (AudioProcessor audioProcessor : this.f16790j) {
            audioProcessor.reset();
        }
        for (AudioProcessor audioProcessor2 : this.f16791k) {
            audioProcessor2.reset();
        }
        this.W = false;
        this.f16783c0 = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void s() {
        if (this.f16781a0) {
            this.f16781a0 = false;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void t() {
        this.I = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void u() {
        hd.a.i(u0.f31154a >= 21);
        hd.a.i(this.X);
        if (this.f16781a0) {
            return;
        }
        this.f16781a0 = true;
        flush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void v(ab.d dVar) {
        if (this.f16804x.equals(dVar)) {
            return;
        }
        this.f16804x = dVar;
        if (this.f16781a0) {
            return;
        }
        flush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean w(ByteBuffer byteBuffer, long j10, int i10) throws Exception {
        ByteBuffer byteBuffer2 = this.O;
        hd.a.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.f16801u != null) {
            if (!J()) {
                return false;
            }
            if (this.f16801u.b(this.f16802v)) {
                this.f16802v = this.f16801u;
                this.f16801u = null;
                if (Z(this.f16803w)) {
                    this.f16803w.setOffloadEndOfStream();
                    AudioTrack audioTrack = this.f16803w;
                    Format format = this.f16802v.f16809a;
                    audioTrack.setOffloadDelayPadding(format.B, format.C);
                    this.f16784d0 = true;
                }
            } else {
                d0();
                if (q()) {
                    return false;
                }
                flush();
            }
            F(j10);
        }
        if (!X()) {
            try {
                V();
            } catch (AudioSink.InitializationException e10) {
                if (e10.isRecoverable) {
                    throw e10;
                }
                this.f16798r.b(e10);
                return false;
            }
        }
        this.f16798r.a();
        if (this.J) {
            this.K = Math.max(0L, j10);
            this.I = false;
            this.J = false;
            if (this.f16795o && u0.f31154a >= 23) {
                i0(this.A);
            }
            F(j10);
            if (this.W) {
                i();
            }
        }
        if (!this.f16793m.l(U())) {
            return false;
        }
        if (this.O == null) {
            hd.a.a(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            c cVar = this.f16802v;
            if (cVar.f16811c != 0 && this.H == 0) {
                int iP = P(cVar.f16815g, byteBuffer);
                this.H = iP;
                if (iP == 0) {
                    return true;
                }
            }
            if (this.f16805y != null) {
                if (!J()) {
                    return false;
                }
                F(j10);
                this.f16805y = null;
            }
            long jN = this.K + this.f16802v.n(T() - this.f16789i.l());
            if (!this.I && Math.abs(jN - j10) > 200000) {
                t.d(f16779v0, "Discontinuity detected [expected " + jN + ", got " + j10 + "]");
                this.I = true;
            }
            if (this.I) {
                if (!J()) {
                    return false;
                }
                long j11 = j10 - jN;
                this.K += j11;
                this.I = false;
                F(j10);
                AudioSink.a aVar = this.f16800t;
                if (aVar != null && j11 != 0) {
                    aVar.f();
                }
            }
            if (this.f16802v.f16811c == 0) {
                this.D += (long) byteBuffer.remaining();
            } else {
                this.E += (long) (this.H * i10);
            }
            this.O = byteBuffer;
            this.P = i10;
        }
        e0(j10);
        if (!this.O.hasRemaining()) {
            this.O = null;
            this.P = 0;
            return true;
        }
        if (!this.f16793m.k(U())) {
            return false;
        }
        t.n(f16779v0, "Resetting stalled audio track");
        flush();
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void x(AudioSink.a aVar) {
        this.f16800t = aVar;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public int y(Format format) {
        if (!w.G.equals(format.f16699l)) {
            return ((this.f16796p && !this.f16783c0 && a0(format, this.f16804x)) || b0(format, this.f16785e)) ? 2 : 0;
        }
        if (u0.E0(format.A)) {
            int i10 = format.A;
            return (i10 == 2 || (this.f16787g && i10 == 4)) ? 2 : 1;
        }
        t.n(f16779v0, "Invalid PCM encoding: " + format.A);
        return 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void z(Format format, int i10, @p0 int[] iArr) throws AudioSink.ConfigurationException {
        AudioProcessor[] audioProcessorArr;
        int iIntValue;
        int iM0;
        int iM02;
        int iIntValue2;
        int i11;
        int i12;
        int[] iArr2;
        if (w.G.equals(format.f16699l)) {
            hd.a.a(u0.E0(format.A));
            iM0 = u0.m0(format.A, format.f16712y);
            AudioProcessor[] audioProcessorArr2 = o0(format.A) ? this.f16791k : this.f16790j;
            this.f16789i.n(format.B, format.C);
            if (u0.f31154a < 21 && format.f16712y == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i13 = 0; i13 < 6; i13++) {
                    iArr2[i13] = i13;
                }
            } else {
                iArr2 = iArr;
            }
            this.f16788h.l(iArr2);
            AudioProcessor.a aVar = new AudioProcessor.a(format.f16713z, format.f16712y, format.A);
            for (AudioProcessor audioProcessor : audioProcessorArr2) {
                try {
                    AudioProcessor.a aVarE = audioProcessor.e(aVar);
                    if (audioProcessor.isActive()) {
                        aVar = aVarE;
                    }
                } catch (AudioProcessor.UnhandledAudioFormatException e10) {
                    throw new AudioSink.ConfigurationException(e10, format);
                }
            }
            int i14 = aVar.f16756c;
            i11 = aVar.f16754a;
            iIntValue2 = u0.N(aVar.f16755b);
            audioProcessorArr = audioProcessorArr2;
            iIntValue = i14;
            iM02 = u0.m0(i14, aVar.f16755b);
            i12 = 0;
        } else {
            AudioProcessor[] audioProcessorArr3 = new AudioProcessor[0];
            int i15 = format.f16713z;
            if (this.f16796p && a0(format, this.f16804x)) {
                audioProcessorArr = audioProcessorArr3;
                iIntValue = w.f((String) hd.a.g(format.f16699l), format.f16695i);
                iIntValue2 = u0.N(format.f16712y);
                iM0 = -1;
                iM02 = -1;
                i11 = i15;
                i12 = 1;
            } else {
                Pair<Integer, Integer> pairO = O(format, this.f16785e);
                if (pairO == null) {
                    throw new AudioSink.ConfigurationException("Unable to configure passthrough for: " + format, format);
                }
                audioProcessorArr = audioProcessorArr3;
                iIntValue = ((Integer) pairO.first).intValue();
                iM0 = -1;
                iM02 = -1;
                iIntValue2 = ((Integer) pairO.second).intValue();
                i11 = i15;
                i12 = 2;
            }
        }
        if (iIntValue == 0) {
            throw new AudioSink.ConfigurationException("Invalid output encoding (mode=" + i12 + ") for: " + format, format);
        }
        if (iIntValue2 == 0) {
            throw new AudioSink.ConfigurationException("Invalid output channel config (mode=" + i12 + ") for: " + format, format);
        }
        this.f16783c0 = false;
        c cVar = new c(format, iM0, i12, iM02, i11, iIntValue2, iIntValue, i10, this.f16795o, audioProcessorArr);
        if (X()) {
            this.f16801u = cVar;
        } else {
            this.f16802v = cVar;
        }
    }

    public DefaultAudioSink(@p0 ab.e eVar, AudioProcessor[] audioProcessorArr, boolean z10) {
        this(eVar, new d(audioProcessorArr), z10, false, false);
    }

    public DefaultAudioSink(@p0 ab.e eVar, b bVar, boolean z10, boolean z11, boolean z12) {
        this.f16785e = eVar;
        this.f16786f = (b) hd.a.g(bVar);
        int i10 = u0.f31154a;
        this.f16787g = i10 >= 21 && z10;
        this.f16795o = i10 >= 23 && z11;
        this.f16796p = i10 >= 29 && z12;
        this.f16792l = new ConditionVariable(true);
        this.f16793m = new com.google.android.exoplayer2.audio.b(new g(this, null));
        com.google.android.exoplayer2.audio.d dVar = new com.google.android.exoplayer2.audio.d();
        this.f16788h = dVar;
        m mVar = new m();
        this.f16789i = mVar;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new i(), dVar, mVar);
        Collections.addAll(arrayList, bVar.e());
        this.f16790j = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[0]);
        this.f16791k = new AudioProcessor[]{new com.google.android.exoplayer2.audio.f()};
        this.L = 1.0f;
        this.f16804x = ab.d.f417f;
        this.Y = 0;
        this.Z = new u(0, 0.0f);
        h1 h1Var = h1.f56784d;
        this.f16806z = new e(h1Var, false, 0L, 0L, null);
        this.A = h1Var;
        this.T = -1;
        this.M = new AudioProcessor[0];
        this.N = new ByteBuffer[0];
        this.f16794n = new ArrayDeque<>();
        this.f16798r = new f<>(100L);
        this.f16799s = new f<>(100L);
    }
}
