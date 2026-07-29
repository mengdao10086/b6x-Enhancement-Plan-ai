package com.google.android.exoplayer2.audio;

import ab.s;
import ab.u;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import eb.c;
import g.p0;
import hd.q0;
import hd.u0;
import hd.v;
import hd.w;
import ya.h1;
import ya.p1;
import ya.s0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e<T extends eb.c<DecoderInputBuffer, ? extends eb.h, ? extends DecoderException>> extends com.google.android.exoplayer2.a implements v {
    public static final int C1 = 1;
    public static final int K1 = 2;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final int f16871v1 = 0;
    public boolean A;
    public boolean B;
    public long C;
    public boolean D;
    public boolean K0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f16872k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public boolean f16873k1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a.C0175a f16874m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AudioSink f16875n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final DecoderInputBuffer f16876o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public eb.d f16877p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Format f16878q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f16879r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f16880s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f16881t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @p0
    public T f16882u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @p0
    public DecoderInputBuffer f16883v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @p0
    public eb.h f16884w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @p0
    public DrmSession f16885x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @p0
    public DrmSession f16886y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f16887z;

    public final class b implements AudioSink.a {
        public b() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void a(boolean z10) {
            e.this.f16874m.z(z10);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void b(long j10) {
            e.this.f16874m.y(j10);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void c(int i10, long j10, long j11) {
            e.this.f16874m.A(i10, j10, j11);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void d(Exception exc) {
            e.this.f16874m.j(exc);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public /* synthetic */ void e(long j10) {
            s.c(this, j10);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void f() {
            e.this.a0();
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public /* synthetic */ void g() {
            s.b(this);
        }
    }

    public e() {
        this((Handler) null, (com.google.android.exoplayer2.audio.a) null, new AudioProcessor[0]);
    }

    @Override // com.google.android.exoplayer2.a
    public void G() {
        this.f16878q = null;
        this.B = true;
        try {
            f0(null);
            d0();
            this.f16875n.reset();
        } finally {
            this.f16874m.m(this.f16877p);
        }
    }

    @Override // com.google.android.exoplayer2.a
    public void H(boolean z10, boolean z11) throws ExoPlaybackException {
        eb.d dVar = new eb.d();
        this.f16877p = dVar;
        this.f16874m.n(dVar);
        if (A().f57065a) {
            this.f16875n.u();
        } else {
            this.f16875n.s();
        }
    }

    @Override // com.google.android.exoplayer2.a
    public void I(long j10, boolean z10) throws ExoPlaybackException {
        if (this.f16881t) {
            this.f16875n.A();
        } else {
            this.f16875n.flush();
        }
        this.C = j10;
        this.D = true;
        this.f16872k0 = true;
        this.K0 = false;
        this.f16873k1 = false;
        if (this.f16882u != null) {
            V();
        }
    }

    @Override // com.google.android.exoplayer2.a
    public void K() {
        this.f16875n.i();
    }

    @Override // com.google.android.exoplayer2.a
    public void L() {
        i0();
        this.f16875n.pause();
    }

    public eb.e Q(String str, Format format, Format format2) {
        return new eb.e(str, format, format2, 0, 1);
    }

    public abstract T R(Format format, @p0 gb.s sVar) throws DecoderException;

    public final boolean S() throws ExoPlaybackException, AudioSink.WriteException, AudioSink.InitializationException, AudioSink.ConfigurationException, DecoderException {
        if (this.f16884w == null) {
            eb.h hVar = (eb.h) this.f16882u.b();
            this.f16884w = hVar;
            if (hVar == null) {
                return false;
            }
            int i10 = hVar.f26794c;
            if (i10 > 0) {
                this.f16877p.f26763f += i10;
                this.f16875n.t();
            }
        }
        if (this.f16884w.m()) {
            if (this.f16887z == 2) {
                d0();
                Y();
                this.B = true;
            } else {
                this.f16884w.p();
                this.f16884w = null;
                try {
                    c0();
                } catch (AudioSink.WriteException e10) {
                    throw z(e10, e10.format, e10.isRecoverable);
                }
            }
            return false;
        }
        if (this.B) {
            this.f16875n.z(W(this.f16882u).a().M(this.f16879r).N(this.f16880s).E(), 0, null);
            this.B = false;
        }
        AudioSink audioSink = this.f16875n;
        eb.h hVar2 = this.f16884w;
        if (!audioSink.w(hVar2.f26810e, hVar2.f26793b, 1)) {
            return false;
        }
        this.f16877p.f26762e++;
        this.f16884w.p();
        this.f16884w = null;
        return true;
    }

    public void T(boolean z10) {
        this.f16881t = z10;
    }

    public final boolean U() throws ExoPlaybackException, DecoderException {
        T t10 = this.f16882u;
        if (t10 == null || this.f16887z == 2 || this.K0) {
            return false;
        }
        if (this.f16883v == null) {
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) t10.c();
            this.f16883v = decoderInputBuffer;
            if (decoderInputBuffer == null) {
                return false;
            }
        }
        if (this.f16887z == 1) {
            this.f16883v.o(4);
            this.f16882u.d(this.f16883v);
            this.f16883v = null;
            this.f16887z = 2;
            return false;
        }
        s0 s0VarB = B();
        int iN = N(s0VarB, this.f16883v, false);
        if (iN == -5) {
            Z(s0VarB);
            return true;
        }
        if (iN != -4) {
            if (iN == -3) {
                return false;
            }
            throw new IllegalStateException();
        }
        if (this.f16883v.m()) {
            this.K0 = true;
            this.f16882u.d(this.f16883v);
            this.f16883v = null;
            return false;
        }
        this.f16883v.r();
        b0(this.f16883v);
        this.f16882u.d(this.f16883v);
        this.A = true;
        this.f16877p.f26760c++;
        this.f16883v = null;
        return true;
    }

    public final void V() throws ExoPlaybackException {
        if (this.f16887z != 0) {
            d0();
            Y();
            return;
        }
        this.f16883v = null;
        eb.h hVar = this.f16884w;
        if (hVar != null) {
            hVar.p();
            this.f16884w = null;
        }
        this.f16882u.flush();
        this.A = false;
    }

    public abstract Format W(T t10);

    public final int X(Format format) {
        return this.f16875n.y(format);
    }

    public final void Y() throws ExoPlaybackException {
        if (this.f16882u != null) {
            return;
        }
        e0(this.f16886y);
        gb.s sVarJ = null;
        DrmSession drmSession = this.f16885x;
        if (drmSession != null && (sVarJ = drmSession.j()) == null && this.f16885x.d() == null) {
            return;
        }
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            q0.a("createAudioDecoder");
            this.f16882u = (T) R(this.f16878q, sVarJ);
            q0.c();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            this.f16874m.k(this.f16882u.getName(), jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
            this.f16877p.f26758a++;
        } catch (DecoderException | OutOfMemoryError e10) {
            throw y(e10, this.f16878q);
        }
    }

    public final void Z(s0 s0Var) throws ExoPlaybackException {
        Format format = (Format) hd.a.g(s0Var.f57068b);
        f0(s0Var.f57067a);
        Format format2 = this.f16878q;
        this.f16878q = format;
        this.f16879r = format.B;
        this.f16880s = format.C;
        T t10 = this.f16882u;
        if (t10 == null) {
            Y();
            this.f16874m.o(this.f16878q, null);
            return;
        }
        eb.e eVar = this.f16886y != this.f16885x ? new eb.e(t10.getName(), format2, format, 0, 128) : Q(t10.getName(), format2, format);
        if (eVar.f26791d == 0) {
            if (this.A) {
                this.f16887z = 1;
            } else {
                d0();
                Y();
                this.B = true;
            }
        }
        this.f16874m.o(this.f16878q, eVar);
    }

    @Override // ya.q1
    public final int a(Format format) {
        if (!w.p(format.f16699l)) {
            return p1.a(0);
        }
        int iH0 = h0(format);
        if (iH0 <= 2) {
            return p1.a(iH0);
        }
        return p1.b(iH0, 8, u0.f31154a >= 21 ? 32 : 0);
    }

    @g.i
    public void a0() {
        this.f16872k0 = true;
    }

    @Override // ya.o1
    public boolean b() {
        return this.f16873k1 && this.f16875n.b();
    }

    public final void b0(DecoderInputBuffer decoderInputBuffer) {
        if (!this.D || decoderInputBuffer.l()) {
            return;
        }
        if (Math.abs(decoderInputBuffer.f16962e - this.C) > 500000) {
            this.C = decoderInputBuffer.f16962e;
        }
        this.D = false;
    }

    @Override // hd.v
    public void c(h1 h1Var) {
        this.f16875n.c(h1Var);
    }

    public final void c0() throws AudioSink.WriteException {
        this.f16873k1 = true;
        this.f16875n.p();
    }

    @Override // ya.o1
    public boolean d() {
        return this.f16875n.q() || (this.f16878q != null && (F() || this.f16884w != null));
    }

    public final void d0() {
        this.f16883v = null;
        this.f16884w = null;
        this.f16887z = 0;
        this.A = false;
        T t10 = this.f16882u;
        if (t10 != null) {
            this.f16877p.f26759b++;
            t10.release();
            this.f16874m.l(this.f16882u.getName());
            this.f16882u = null;
        }
        e0(null);
    }

    @Override // hd.v
    public h1 e() {
        return this.f16875n.e();
    }

    public final void e0(@p0 DrmSession drmSession) {
        gb.i.b(this.f16885x, drmSession);
        this.f16885x = drmSession;
    }

    public final void f0(@p0 DrmSession drmSession) {
        gb.i.b(this.f16886y, drmSession);
        this.f16886y = drmSession;
    }

    public final boolean g0(Format format) {
        return this.f16875n.a(format);
    }

    public abstract int h0(Format format);

    public final void i0() {
        long jR = this.f16875n.r(b());
        if (jR != Long.MIN_VALUE) {
            if (!this.f16872k0) {
                jR = Math.max(this.C, jR);
            }
            this.C = jR;
            this.f16872k0 = false;
        }
    }

    @Override // hd.v
    public long n() {
        if (getState() == 2) {
            i0();
        }
        return this.C;
    }

    @Override // ya.o1
    public void q(long j10, long j11) throws ExoPlaybackException {
        if (this.f16873k1) {
            try {
                this.f16875n.p();
                return;
            } catch (AudioSink.WriteException e10) {
                throw z(e10, e10.format, e10.isRecoverable);
            }
        }
        if (this.f16878q == null) {
            s0 s0VarB = B();
            this.f16876o.h();
            int iN = N(s0VarB, this.f16876o, true);
            if (iN != -5) {
                if (iN == -4) {
                    hd.a.i(this.f16876o.m());
                    this.K0 = true;
                    try {
                        c0();
                        return;
                    } catch (AudioSink.WriteException e11) {
                        throw y(e11, null);
                    }
                }
                return;
            }
            Z(s0VarB);
        }
        Y();
        if (this.f16882u != null) {
            try {
                q0.a("drainAndFeed");
                while (S()) {
                }
                while (U()) {
                }
                q0.c();
                this.f16877p.c();
            } catch (AudioSink.ConfigurationException e12) {
                throw y(e12, e12.format);
            } catch (AudioSink.InitializationException e13) {
                throw z(e13, e13.format, e13.isRecoverable);
            } catch (AudioSink.WriteException e14) {
                throw z(e14, e14.format, e14.isRecoverable);
            } catch (DecoderException e15) {
                throw y(e15, this.f16878q);
            }
        }
    }

    @Override // com.google.android.exoplayer2.a, ya.l1.b
    public void r(int i10, @p0 Object obj) throws ExoPlaybackException {
        if (i10 == 2) {
            this.f16875n.m(((Float) obj).floatValue());
            return;
        }
        if (i10 == 3) {
            this.f16875n.v((ab.d) obj);
            return;
        }
        if (i10 == 5) {
            this.f16875n.l((u) obj);
        } else if (i10 == 101) {
            this.f16875n.o(((Boolean) obj).booleanValue());
        } else if (i10 != 102) {
            super.r(i10, obj);
        } else {
            this.f16875n.h(((Integer) obj).intValue());
        }
    }

    @Override // com.google.android.exoplayer2.a, ya.o1
    @p0
    public v x() {
        return this;
    }

    public e(@p0 Handler handler, @p0 com.google.android.exoplayer2.audio.a aVar, AudioProcessor... audioProcessorArr) {
        this(handler, aVar, null, audioProcessorArr);
    }

    public e(@p0 Handler handler, @p0 com.google.android.exoplayer2.audio.a aVar, @p0 ab.e eVar, AudioProcessor... audioProcessorArr) {
        this(handler, aVar, new DefaultAudioSink(eVar, audioProcessorArr));
    }

    public e(@p0 Handler handler, @p0 com.google.android.exoplayer2.audio.a aVar, AudioSink audioSink) {
        super(1);
        this.f16874m = new a.C0175a(handler, aVar);
        this.f16875n = audioSink;
        audioSink.x(new b());
        this.f16876o = DecoderInputBuffer.u();
        this.f16887z = 0;
        this.B = true;
    }
}
