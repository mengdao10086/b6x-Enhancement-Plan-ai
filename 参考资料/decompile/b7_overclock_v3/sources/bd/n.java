package bd;

import android.media.MediaCodec;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import g.p0;
import g.v0;
import java.io.IOException;
import java.nio.ByteBuffer;
import ya.s0;

/* JADX INFO: loaded from: classes3.dex */
@v0(18)
public final class n extends o {
    public static final int K0 = 131072;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final String f9363k0 = "TransformerAudioRenderer";

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final float f9364k1 = -1.0f;
    public float A;
    public boolean B;
    public boolean C;
    public boolean D;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final DecoderInputBuffer f9365q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final DecoderInputBuffer f9366r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.google.android.exoplayer2.audio.k f9367s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @p0
    public c f9368t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @p0
    public c f9369u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @p0
    public j f9370v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @p0
    public Format f9371w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @p0
    public AudioProcessor.a f9372x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ByteBuffer f9373y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f9374z;

    public n(e eVar, p pVar, k kVar) {
        super(1, eVar, pVar, kVar);
        this.f9365q = new DecoderInputBuffer(0);
        this.f9366r = new DecoderInputBuffer(0);
        this.f9367s = new com.google.android.exoplayer2.audio.k();
        this.f9373y = AudioProcessor.f16752a;
        this.f9374z = 0L;
        this.A = -1.0f;
    }

    public static long Z(long j10, int i10, int i11) {
        return ((j10 / ((long) i10)) * 1000000) / ((long) i11);
    }

    @Override // com.google.android.exoplayer2.a
    public void J() {
        this.f9365q.h();
        this.f9365q.f16960c = null;
        this.f9366r.h();
        this.f9366r.f16960c = null;
        this.f9367s.reset();
        c cVar = this.f9368t;
        if (cVar != null) {
            cVar.k();
            this.f9368t = null;
        }
        c cVar2 = this.f9369u;
        if (cVar2 != null) {
            cVar2.k();
            this.f9369u = null;
        }
        this.f9370v = null;
        this.f9371w = null;
        this.f9372x = null;
        this.f9373y = AudioProcessor.f16752a;
        this.f9374z = 0L;
        this.A = -1.0f;
        this.B = false;
        this.C = false;
        this.D = false;
    }

    public final ExoPlaybackException P(Throwable th2) {
        return ExoPlaybackException.d(th2, f9363k0, C(), this.f9371w, 4);
    }

    public final boolean Q() {
        c cVar = (c) hd.a.g(this.f9368t);
        if (!((c) hd.a.g(this.f9369u)).h(this.f9366r)) {
            return false;
        }
        if (cVar.g()) {
            b0();
            return false;
        }
        ByteBuffer byteBufferD = cVar.d();
        if (byteBufferD == null) {
            return false;
        }
        if (a0((MediaCodec.BufferInfo) hd.a.g(cVar.e()))) {
            Y(this.A);
            return false;
        }
        X(byteBufferD);
        if (byteBufferD.hasRemaining()) {
            return true;
        }
        cVar.l();
        return true;
    }

    public final boolean R() {
        c cVar = (c) hd.a.g(this.f9368t);
        if (this.D) {
            if (this.f9367s.b() && !this.f9373y.hasRemaining()) {
                Y(this.A);
                this.D = false;
            }
            return false;
        }
        if (this.f9373y.hasRemaining()) {
            return false;
        }
        if (cVar.g()) {
            this.f9367s.f();
            return false;
        }
        hd.a.i(!this.f9367s.b());
        ByteBuffer byteBufferD = cVar.d();
        if (byteBufferD == null) {
            return false;
        }
        if (a0((MediaCodec.BufferInfo) hd.a.g(cVar.e()))) {
            this.f9367s.f();
            this.D = true;
            return false;
        }
        this.f9367s.d(byteBufferD);
        if (!byteBufferD.hasRemaining()) {
            cVar.l();
        }
        return true;
    }

    public final boolean S() {
        c cVar = (c) hd.a.g(this.f9369u);
        if (!this.C) {
            Format formatF = cVar.f();
            if (formatF == null) {
                return false;
            }
            this.C = true;
            this.f9375m.a(formatF);
        }
        if (cVar.g()) {
            this.f9375m.c(h());
            this.B = true;
            return false;
        }
        ByteBuffer byteBufferD = cVar.d();
        if (byteBufferD == null) {
            return false;
        }
        if (!this.f9375m.h(h(), byteBufferD, true, ((MediaCodec.BufferInfo) hd.a.g(cVar.e())).presentationTimeUs)) {
            return false;
        }
        cVar.l();
        return true;
    }

    public final boolean T() {
        if (!((c) hd.a.g(this.f9369u)).h(this.f9366r)) {
            return false;
        }
        if (!this.f9373y.hasRemaining()) {
            ByteBuffer byteBufferC = this.f9367s.c();
            this.f9373y = byteBufferC;
            if (!byteBufferC.hasRemaining()) {
                if (((c) hd.a.g(this.f9368t)).g() && this.f9367s.b()) {
                    b0();
                }
                return false;
            }
        }
        X(this.f9373y);
        return true;
    }

    public final boolean U() throws ExoPlaybackException {
        if (this.f9368t != null) {
            return true;
        }
        s0 s0VarB = B();
        if (N(s0VarB, this.f9365q, true) != -5) {
            return false;
        }
        Format format = (Format) hd.a.g(s0VarB.f57068b);
        this.f9371w = format;
        try {
            this.f9368t = c.a(format);
            i iVar = new i(this.f9371w);
            this.f9370v = iVar;
            this.A = iVar.a(0L);
            return true;
        } catch (IOException e10) {
            throw P(e10);
        }
    }

    public final boolean V() throws ExoPlaybackException {
        if (this.f9369u != null) {
            return true;
        }
        Format formatF = ((c) hd.a.g(this.f9368t)).f();
        if (formatF == null) {
            return false;
        }
        AudioProcessor.a aVar = new AudioProcessor.a(formatF.f16713z, formatF.f16712y, formatF.A);
        if (this.f9377o.f9331c) {
            try {
                aVar = this.f9367s.e(aVar);
                Y(this.A);
            } catch (AudioProcessor.UnhandledAudioFormatException e10) {
                throw P(e10);
            }
        }
        try {
            this.f9369u = c.b(new Format.b().e0(((Format) hd.a.g(this.f9371w)).f16699l).f0(aVar.f16754a).H(aVar.f16755b).G(131072).E());
            this.f9372x = aVar;
            return true;
        } catch (IOException e11) {
            throw P(e11);
        }
    }

    public final boolean W() {
        c cVar = (c) hd.a.g(this.f9368t);
        if (!cVar.h(this.f9365q)) {
            return false;
        }
        this.f9365q.h();
        int iN = N(B(), this.f9365q, false);
        if (iN == -5) {
            throw new IllegalStateException("Format changes are not supported.");
        }
        if (iN != -4) {
            return false;
        }
        this.f9376n.a(h(), this.f9365q.f16962e);
        this.f9365q.r();
        cVar.j(this.f9365q);
        return !this.f9365q.m();
    }

    public final void X(ByteBuffer byteBuffer) {
        AudioProcessor.a aVar = (AudioProcessor.a) hd.a.g(this.f9372x);
        c cVar = (c) hd.a.g(this.f9369u);
        ByteBuffer byteBuffer2 = (ByteBuffer) hd.a.g(this.f9366r.f16960c);
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(Math.min(iLimit, byteBuffer.position() + byteBuffer2.capacity()));
        byteBuffer2.put(byteBuffer);
        DecoderInputBuffer decoderInputBuffer = this.f9366r;
        long j10 = this.f9374z;
        decoderInputBuffer.f16962e = j10;
        this.f9374z = j10 + Z(byteBuffer2.position(), aVar.f16757d, aVar.f16754a);
        this.f9366r.o(0);
        this.f9366r.r();
        byteBuffer.limit(iLimit);
        cVar.j(this.f9366r);
    }

    public final void Y(float f10) {
        this.f9367s.i(f10);
        this.f9367s.h(f10);
        this.f9367s.flush();
    }

    public final boolean a0(MediaCodec.BufferInfo bufferInfo) {
        if (!this.f9377o.f9331c) {
            return false;
        }
        float fA = ((j) hd.a.g(this.f9370v)).a(bufferInfo.presentationTimeUs);
        boolean z10 = fA != this.A;
        this.A = fA;
        return z10;
    }

    @Override // ya.o1
    public boolean b() {
        return this.B;
    }

    public final void b0() {
        c cVar = (c) hd.a.g(this.f9369u);
        hd.a.i(((ByteBuffer) hd.a.g(this.f9366r.f16960c)).position() == 0);
        this.f9366r.g(4);
        this.f9366r.r();
        cVar.j(this.f9366r);
    }

    @Override // ya.o1, ya.q1
    public String getName() {
        return f9363k0;
    }

    @Override // ya.o1
    public void q(long j10, long j11) throws ExoPlaybackException {
        if (this.f9378p && !b() && U()) {
            if (V()) {
                while (S()) {
                }
                if (this.f9367s.isActive()) {
                    while (T()) {
                    }
                    while (R()) {
                    }
                } else {
                    while (Q()) {
                    }
                }
            }
            while (W()) {
            }
        }
    }
}
