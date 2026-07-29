package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.a;
import com.google.android.exoplayer2.mediacodec.b;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import g.j;
import g.p0;
import g.v0;
import gb.s;
import gb.t;
import hd.o0;
import hd.q0;
import hd.u0;
import hd.w;
import hd.y;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import tb.h;
import tb.i;
import ya.g;
import ya.s0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MediaCodecRenderer extends com.google.android.exoplayer2.a {
    public static final long A8 = 1000;
    public static final int B8 = 10;
    public static final int C8 = 0;
    public static final int D8 = 1;
    public static final int E8 = 2;
    public static final int F8 = 0;
    public static final int G8 = 1;
    public static final int H8 = 2;
    public static final int I8 = 0;
    public static final int J8 = 1;
    public static final int K8 = 2;
    public static final int L8 = 3;
    public static final int M8 = 0;
    public static final int N8 = 1;
    public static final int O8 = 2;
    public static final byte[] P8 = {0, 0, 1, 103, 66, i1.a.f31667o7, 11, i1.a.B7, rc.a.X, -112, 0, 0, 1, 104, i1.a.f31759z7, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, i1.a.f31759z7, pq.b.f46993j, 24, -96, 0, 47, -65, 28, 49, i1.a.f31691r7, rc.a.Z, 93, tc.a.f51065w};
    public static final int Q8 = 32;

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    public static final float f17123y8 = -1.0f;

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    public static final String f17124z8 = "MediaCodecRenderer";

    @p0
    public Format A;

    @p0
    public Format B;

    @p0
    public DrmSession C;
    public float C1;

    @p0
    public MediaFormat C2;

    @p0
    public DrmSession D;
    public float E7;

    @p0
    public ArrayDeque<c> F7;

    @p0
    public DecoderInitializationException G7;

    @p0
    public c H7;
    public int I7;
    public boolean J7;
    public boolean K0;

    @p0
    public b K1;
    public boolean K2;
    public boolean K7;
    public boolean L7;
    public boolean M7;
    public boolean N7;
    public boolean O7;
    public boolean P7;
    public boolean Q7;
    public boolean R7;
    public boolean S7;

    @p0
    public i T7;
    public long U7;
    public int V7;
    public int W7;

    @p0
    public ByteBuffer X7;
    public boolean Y7;
    public boolean Z7;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public boolean f17125a8;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public boolean f17126b8;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public boolean f17127c8;

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public boolean f17128d8;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public int f17129e8;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public int f17130f8;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public int f17131g8;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public boolean f17132h8;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public boolean f17133i8;

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    public boolean f17134j8;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    @p0
    public MediaCrypto f17135k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public long f17136k1;

    /* JADX INFO: renamed from: k8, reason: collision with root package name */
    public long f17137k8;

    /* JADX INFO: renamed from: l8, reason: collision with root package name */
    public long f17138l8;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b.a f17139m;

    /* JADX INFO: renamed from: m8, reason: collision with root package name */
    public boolean f17140m8;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f17141n;

    /* JADX INFO: renamed from: n8, reason: collision with root package name */
    public boolean f17142n8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f17143o;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public boolean f17144o8;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f17145p;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public boolean f17146p8;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final DecoderInputBuffer f17147q;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public boolean f17148q8;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final DecoderInputBuffer f17149r;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public boolean f17150r8;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final DecoderInputBuffer f17151s;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public boolean f17152s8;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final h f17153t;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    @p0
    public ExoPlaybackException f17154t8;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final o0<Format> f17155u;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public eb.d f17156u8;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList<Long> f17157v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public float f17158v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    @p0
    public Format f17159v2;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public long f17160v8;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final MediaCodec.BufferInfo f17161w;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public long f17162w8;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long[] f17163x;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public int f17164x8;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long[] f17165y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final long[] f17166z;

    public MediaCodecRenderer(int i10, b.a aVar, d dVar, boolean z10, float f10) {
        super(i10);
        this.f17139m = aVar;
        this.f17141n = (d) hd.a.g(dVar);
        this.f17143o = z10;
        this.f17145p = f10;
        this.f17147q = DecoderInputBuffer.u();
        this.f17149r = new DecoderInputBuffer(0);
        this.f17151s = new DecoderInputBuffer(2);
        h hVar = new h();
        this.f17153t = hVar;
        this.f17155u = new o0<>();
        this.f17157v = new ArrayList<>();
        this.f17161w = new MediaCodec.BufferInfo();
        this.f17158v1 = 1.0f;
        this.C1 = 1.0f;
        this.f17136k1 = g.f56663b;
        this.f17163x = new long[10];
        this.f17165y = new long[10];
        this.f17166z = new long[10];
        this.f17160v8 = g.f56663b;
        this.f17162w8 = g.f56663b;
        hVar.q(0);
        hVar.f16960c.order(ByteOrder.nativeOrder());
        b1();
    }

    public static boolean G0(IllegalStateException illegalStateException) {
        if (u0.f31154a >= 21 && H0(illegalStateException)) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        return stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec");
    }

    @v0(21)
    public static boolean H0(IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    public static boolean T(String str, Format format) {
        return u0.f31154a < 21 && format.f16701n.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    @TargetApi(23)
    private void T0() throws ExoPlaybackException {
        int i10 = this.f17131g8;
        if (i10 == 1) {
            n0();
            return;
        }
        if (i10 == 2) {
            n0();
            p1();
        } else if (i10 == 3) {
            X0();
        } else {
            this.f17142n8 = true;
            Z0();
        }
    }

    public static boolean U(String str) {
        if (u0.f31154a < 21 && "OMX.SEC.mp3.dec".equals(str) && com.google.android.material.internal.i.f20422b.equals(u0.f31156c)) {
            String str2 = u0.f31155b;
            if (str2.startsWith("baffin") || str2.startsWith("grand") || str2.startsWith("fortuna") || str2.startsWith("gprimelte") || str2.startsWith("j2y18lte") || str2.startsWith("ms01")) {
                return true;
            }
        }
        return false;
    }

    public static boolean V(String str) {
        int i10 = u0.f31154a;
        if (i10 > 23 || !"OMX.google.vorbis.decoder".equals(str)) {
            if (i10 <= 19) {
                String str2 = u0.f31155b;
                if (("hb2000".equals(str2) || "stvm8".equals(str2)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean W(String str) {
        return u0.f31154a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    public static boolean X(c cVar) {
        String str = cVar.f17203a;
        int i10 = u0.f31154a;
        return (i10 <= 25 && "OMX.rk.video_decoder.avc".equals(str)) || (i10 <= 17 && "OMX.allwinner.video.decoder.avc".equals(str)) || ((i10 <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str))) || ("Amazon".equals(u0.f31156c) && "AFTS".equals(u0.f31157d) && cVar.f17209g));
    }

    public static boolean Y(String str) {
        int i10 = u0.f31154a;
        return i10 < 18 || (i10 == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (i10 == 19 && u0.f31157d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    public static boolean Z(String str, Format format) {
        return u0.f31154a <= 18 && format.f16712y == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }

    public static boolean a0(String str) {
        return u0.f31154a == 29 && "c2.android.aac.decoder".equals(str);
    }

    private void i1(@p0 DrmSession drmSession) {
        gb.i.b(this.D, drmSession);
        this.D = drmSession;
    }

    private boolean m0() throws ExoPlaybackException {
        b bVar = this.K1;
        if (bVar == null || this.f17130f8 == 2 || this.f17140m8) {
            return false;
        }
        if (this.V7 < 0) {
            int iF = bVar.f();
            this.V7 = iF;
            if (iF < 0) {
                return false;
            }
            this.f17149r.f16960c = this.K1.j(iF);
            this.f17149r.h();
        }
        if (this.f17130f8 == 1) {
            if (!this.S7) {
                this.f17133i8 = true;
                this.K1.l(this.V7, 0, 0, 0L, 4);
                c1();
            }
            this.f17130f8 = 2;
            return false;
        }
        if (this.Q7) {
            this.Q7 = false;
            ByteBuffer byteBuffer = this.f17149r.f16960c;
            byte[] bArr = P8;
            byteBuffer.put(bArr);
            this.K1.l(this.V7, 0, bArr.length, 0L, 0);
            c1();
            this.f17132h8 = true;
            return true;
        }
        if (this.f17129e8 == 1) {
            for (int i10 = 0; i10 < this.f17159v2.f16701n.size(); i10++) {
                this.f17149r.f16960c.put(this.f17159v2.f16701n.get(i10));
            }
            this.f17129e8 = 2;
        }
        int iPosition = this.f17149r.f16960c.position();
        s0 s0VarB = B();
        int iN = N(s0VarB, this.f17149r, false);
        if (i()) {
            this.f17138l8 = this.f17137k8;
        }
        if (iN == -3) {
            return false;
        }
        if (iN == -5) {
            if (this.f17129e8 == 2) {
                this.f17149r.h();
                this.f17129e8 = 1;
            }
            O0(s0VarB);
            return true;
        }
        if (this.f17149r.m()) {
            if (this.f17129e8 == 2) {
                this.f17149r.h();
                this.f17129e8 = 1;
            }
            this.f17140m8 = true;
            if (!this.f17132h8) {
                T0();
                return false;
            }
            try {
                if (!this.S7) {
                    this.f17133i8 = true;
                    this.K1.l(this.V7, 0, 0, 0L, 4);
                    c1();
                }
                return false;
            } catch (MediaCodec.CryptoException e10) {
                throw y(e10, this.A);
            }
        }
        if (!this.f17132h8 && !this.f17149r.n()) {
            this.f17149r.h();
            if (this.f17129e8 == 2) {
                this.f17129e8 = 1;
            }
            return true;
        }
        boolean zS = this.f17149r.s();
        if (zS) {
            this.f17149r.f16959b.c(iPosition);
        }
        if (this.J7 && !zS) {
            y.b(this.f17149r.f16960c);
            if (this.f17149r.f16960c.position() == 0) {
                return true;
            }
            this.J7 = false;
        }
        DecoderInputBuffer decoderInputBuffer = this.f17149r;
        long jC = decoderInputBuffer.f16962e;
        i iVar = this.T7;
        if (iVar != null) {
            jC = iVar.c(this.A, decoderInputBuffer);
        }
        long j10 = jC;
        if (this.f17149r.l()) {
            this.f17157v.add(Long.valueOf(j10));
        }
        if (this.f17144o8) {
            this.f17155u.a(j10, this.A);
            this.f17144o8 = false;
        }
        if (this.T7 != null) {
            this.f17137k8 = Math.max(this.f17137k8, this.f17149r.f16962e);
        } else {
            this.f17137k8 = Math.max(this.f17137k8, j10);
        }
        this.f17149r.r();
        if (this.f17149r.k()) {
            B0(this.f17149r);
        }
        S0(this.f17149r);
        try {
            if (zS) {
                this.K1.n(this.V7, 0, this.f17149r.f16959b, j10, 0);
            } else {
                this.K1.l(this.V7, 0, this.f17149r.f16960c.limit(), j10, 0);
            }
            c1();
            this.f17132h8 = true;
            this.f17129e8 = 0;
            this.f17156u8.f26760c++;
            return true;
        } catch (MediaCodec.CryptoException e11) {
            throw y(e11, this.A);
        }
    }

    public static boolean n1(Format format) {
        Class<? extends s> cls = format.f16698k0;
        return cls == null || t.class.equals(cls);
    }

    public float A0() {
        return this.f17158v1;
    }

    public void B0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
    }

    public final boolean C0() {
        return this.W7 >= 0;
    }

    public final void D0(Format format) {
        d0();
        String str = format.f16699l;
        if (w.A.equals(str) || w.D.equals(str) || w.S.equals(str)) {
            this.f17153t.E(32);
        } else {
            this.f17153t.E(1);
        }
        this.f17125a8 = true;
    }

    public final void E0(c cVar, MediaCrypto mediaCrypto) throws Exception {
        long jElapsedRealtime;
        b bVarA;
        String str = cVar.f17203a;
        int i10 = u0.f31154a;
        float fV0 = i10 < 23 ? -1.0f : v0(this.C1, this.A, E());
        float f10 = fV0 <= this.f17145p ? -1.0f : fV0;
        b bVar = null;
        try {
            jElapsedRealtime = SystemClock.elapsedRealtime();
            q0.a("createCodec:" + str);
            MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            bVarA = (!this.f17148q8 || i10 < 23) ? this.f17139m.a(mediaCodecCreateByCodecName) : new a.b(h(), this.f17150r8, this.f17152s8).a(mediaCodecCreateByCodecName);
        } catch (Exception e10) {
            e = e10;
        }
        try {
            q0.c();
            q0.a("configureCodec");
            b0(cVar, bVarA, this.A, mediaCrypto, f10);
            q0.c();
            q0.a("startCodec");
            bVarA.start();
            q0.c();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            this.K1 = bVarA;
            this.H7 = cVar;
            this.E7 = f10;
            this.f17159v2 = this.A;
            this.I7 = S(str);
            this.J7 = T(str, this.f17159v2);
            this.K7 = Y(str);
            this.L7 = a0(str);
            this.M7 = V(str);
            this.N7 = W(str);
            this.O7 = U(str);
            this.P7 = Z(str, this.f17159v2);
            this.S7 = X(cVar) || t0();
            if ("c2.android.mp3.decoder".equals(cVar.f17203a)) {
                this.T7 = new i();
            }
            if (getState() == 2) {
                this.U7 = SystemClock.elapsedRealtime() + 1000;
            }
            this.f17156u8.f26758a++;
            M0(str, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
        } catch (Exception e11) {
            e = e11;
            bVar = bVarA;
            if (bVar != null) {
                bVar.release();
            }
            throw e;
        }
    }

    public final boolean F0(long j10) {
        int size = this.f17157v.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f17157v.get(i10).longValue() == j10) {
                this.f17157v.remove(i10);
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.a
    public void G() {
        this.A = null;
        this.f17160v8 = g.f56663b;
        this.f17162w8 = g.f56663b;
        this.f17164x8 = 0;
        if (this.D == null && this.C == null) {
            p0();
        } else {
            J();
        }
    }

    @Override // com.google.android.exoplayer2.a
    public void H(boolean z10, boolean z11) throws ExoPlaybackException {
        this.f17156u8 = new eb.d();
    }

    @Override // com.google.android.exoplayer2.a
    public void I(long j10, boolean z10) throws ExoPlaybackException {
        this.f17140m8 = false;
        this.f17142n8 = false;
        this.f17146p8 = false;
        if (this.f17125a8) {
            this.f17153t.h();
            this.f17151s.h();
            this.f17126b8 = false;
        } else {
            o0();
        }
        if (this.f17155u.l() > 0) {
            this.f17144o8 = true;
        }
        this.f17155u.c();
        int i10 = this.f17164x8;
        if (i10 != 0) {
            this.f17162w8 = this.f17165y[i10 - 1];
            this.f17160v8 = this.f17163x[i10 - 1];
            this.f17164x8 = 0;
        }
    }

    public boolean I0() {
        return false;
    }

    @Override // com.google.android.exoplayer2.a
    public void J() {
        try {
            d0();
            Y0();
        } finally {
            i1(null);
        }
    }

    public final void J0() throws ExoPlaybackException {
        Format format;
        if (this.K1 != null || this.f17125a8 || (format = this.A) == null) {
            return;
        }
        if (this.D == null && l1(format)) {
            D0(this.A);
            return;
        }
        e1(this.D);
        String str = this.A.f16699l;
        DrmSession drmSession = this.C;
        if (drmSession != null) {
            if (this.f17135k0 == null) {
                t tVarY0 = y0(drmSession);
                if (tVarY0 != null) {
                    try {
                        MediaCrypto mediaCrypto = new MediaCrypto(tVarY0.f29124a, tVarY0.f29125b);
                        this.f17135k0 = mediaCrypto;
                        this.K0 = !tVarY0.f29126c && mediaCrypto.requiresSecureDecoderComponent(str);
                    } catch (MediaCryptoException e10) {
                        throw y(e10, this.A);
                    }
                } else if (this.C.d() == null) {
                    return;
                }
            }
            if (t.f29123d) {
                int state = this.C.getState();
                if (state == 1) {
                    throw y(this.C.d(), this.A);
                }
                if (state != 4) {
                    return;
                }
            }
        }
        try {
            K0(this.f17135k0, this.K0);
        } catch (DecoderInitializationException e11) {
            throw y(e11, this.A);
        }
    }

    @Override // com.google.android.exoplayer2.a
    public void K() {
    }

    public final void K0(MediaCrypto mediaCrypto, boolean z10) throws DecoderInitializationException {
        if (this.F7 == null) {
            try {
                List<c> listQ0 = q0(z10);
                ArrayDeque<c> arrayDeque = new ArrayDeque<>();
                this.F7 = arrayDeque;
                if (this.f17143o) {
                    arrayDeque.addAll(listQ0);
                } else if (!listQ0.isEmpty()) {
                    this.F7.add(listQ0.get(0));
                }
                this.G7 = null;
            } catch (MediaCodecUtil.DecoderQueryException e10) {
                throw new DecoderInitializationException(this.A, e10, z10, DecoderInitializationException.f17169c);
            }
        }
        if (this.F7.isEmpty()) {
            throw new DecoderInitializationException(this.A, (Throwable) null, z10, DecoderInitializationException.f17168b);
        }
        while (this.K1 == null) {
            c cVarPeekFirst = this.F7.peekFirst();
            if (!k1(cVarPeekFirst)) {
                return;
            }
            try {
                E0(cVarPeekFirst, mediaCrypto);
            } catch (Exception e11) {
                hd.t.o(f17124z8, "Failed to initialize decoder: " + cVarPeekFirst, e11);
                this.F7.removeFirst();
                DecoderInitializationException decoderInitializationException = new DecoderInitializationException(this.A, e11, z10, cVarPeekFirst);
                if (this.G7 == null) {
                    this.G7 = decoderInitializationException;
                } else {
                    this.G7 = this.G7.c(decoderInitializationException);
                }
                if (this.F7.isEmpty()) {
                    throw this.G7;
                }
            }
        }
        this.F7 = null;
    }

    @Override // com.google.android.exoplayer2.a
    public void L() {
    }

    public final boolean L0(t tVar, Format format) {
        if (tVar.f29126c) {
            return false;
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(tVar.f29124a, tVar.f29125b);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(format.f16699l);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.a
    public void M(Format[] formatArr, long j10, long j11) throws ExoPlaybackException {
        if (this.f17162w8 == g.f56663b) {
            hd.a.i(this.f17160v8 == g.f56663b);
            this.f17160v8 = j10;
            this.f17162w8 = j11;
            return;
        }
        int i10 = this.f17164x8;
        if (i10 == this.f17165y.length) {
            hd.t.n(f17124z8, "Too many stream changes, so dropping offset: " + this.f17165y[this.f17164x8 - 1]);
        } else {
            this.f17164x8 = i10 + 1;
        }
        long[] jArr = this.f17163x;
        int i11 = this.f17164x8;
        jArr[i11 - 1] = j10;
        this.f17165y[i11 - 1] = j11;
        this.f17166z[i11 - 1] = this.f17137k8;
    }

    public void M0(String str, long j10, long j11) {
    }

    public void N0(String str) {
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x00d5  */
    @g.i
    @g.p0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public eb.e O0(ya.s0 r12) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            Method dump skipped, instruction units count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.O0(ya.s0):eb.e");
    }

    public final void P() throws ExoPlaybackException {
        hd.a.i(!this.f17140m8);
        s0 s0VarB = B();
        this.f17151s.h();
        do {
            this.f17151s.h();
            int iN = N(s0VarB, this.f17151s, false);
            if (iN == -5) {
                O0(s0VarB);
                return;
            }
            if (iN != -4) {
                if (iN != -3) {
                    throw new IllegalStateException();
                }
                return;
            } else {
                if (this.f17151s.m()) {
                    this.f17140m8 = true;
                    return;
                }
                if (this.f17144o8) {
                    Format format = (Format) hd.a.g(this.A);
                    this.B = format;
                    P0(format, null);
                    this.f17144o8 = false;
                }
                this.f17151s.r();
            }
        } while (this.f17153t.w(this.f17151s));
        this.f17126b8 = true;
    }

    public void P0(Format format, @p0 MediaFormat mediaFormat) throws ExoPlaybackException {
    }

    public final boolean Q(long j10, long j11) throws ExoPlaybackException {
        hd.a.i(!this.f17142n8);
        if (this.f17153t.D()) {
            h hVar = this.f17153t;
            if (!U0(j10, j11, null, hVar.f16960c, this.W7, 0, hVar.B(), this.f17153t.y(), this.f17153t.l(), this.f17153t.m(), this.B)) {
                return false;
            }
            Q0(this.f17153t.A());
            this.f17153t.h();
        }
        if (this.f17140m8) {
            this.f17142n8 = true;
            return false;
        }
        if (this.f17126b8) {
            hd.a.i(this.f17153t.w(this.f17151s));
            this.f17126b8 = false;
        }
        if (this.f17127c8) {
            if (this.f17153t.D()) {
                return true;
            }
            d0();
            this.f17127c8 = false;
            J0();
            if (!this.f17125a8) {
                return false;
            }
        }
        P();
        if (this.f17153t.D()) {
            this.f17153t.r();
        }
        return this.f17153t.D() || this.f17140m8 || this.f17127c8;
    }

    @g.i
    public void Q0(long j10) {
        while (true) {
            int i10 = this.f17164x8;
            if (i10 == 0 || j10 < this.f17166z[0]) {
                return;
            }
            long[] jArr = this.f17163x;
            this.f17160v8 = jArr[0];
            this.f17162w8 = this.f17165y[0];
            int i11 = i10 - 1;
            this.f17164x8 = i11;
            System.arraycopy(jArr, 1, jArr, 0, i11);
            long[] jArr2 = this.f17165y;
            System.arraycopy(jArr2, 1, jArr2, 0, this.f17164x8);
            long[] jArr3 = this.f17166z;
            System.arraycopy(jArr3, 1, jArr3, 0, this.f17164x8);
            R0();
        }
    }

    public eb.e R(c cVar, Format format, Format format2) {
        return new eb.e(cVar.f17203a, format, format2, 0, 1);
    }

    public void R0() {
    }

    public final int S(String str) {
        int i10 = u0.f31154a;
        if (i10 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = u0.f31157d;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                return 2;
            }
        }
        if (i10 >= 24) {
            return 0;
        }
        if (!"OMX.Nvidia.h264.decode".equals(str) && !"OMX.Nvidia.h264.decode.secure".equals(str)) {
            return 0;
        }
        String str3 = u0.f31155b;
        return ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) ? 1 : 0;
    }

    public void S0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
    }

    public abstract boolean U0(long j10, long j11, @p0 b bVar, @p0 ByteBuffer byteBuffer, int i10, int i11, int i12, long j12, boolean z10, boolean z11, Format format) throws ExoPlaybackException;

    public final void V0() {
        this.f17134j8 = true;
        MediaFormat mediaFormatC = this.K1.c();
        if (this.I7 != 0 && mediaFormatC.getInteger(SocializeProtocolConstants.WIDTH) == 32 && mediaFormatC.getInteger(SocializeProtocolConstants.HEIGHT) == 32) {
            this.R7 = true;
            return;
        }
        if (this.P7) {
            mediaFormatC.setInteger("channel-count", 1);
        }
        this.C2 = mediaFormatC;
        this.K2 = true;
    }

    public final boolean W0(boolean z10) throws ExoPlaybackException {
        s0 s0VarB = B();
        this.f17147q.h();
        int iN = N(s0VarB, this.f17147q, z10);
        if (iN == -5) {
            O0(s0VarB);
            return true;
        }
        if (iN != -4 || !this.f17147q.m()) {
            return false;
        }
        this.f17140m8 = true;
        T0();
        return false;
    }

    public final void X0() throws ExoPlaybackException {
        Y0();
        J0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void Y0() {
        try {
            b bVar = this.K1;
            if (bVar != null) {
                bVar.release();
                this.f17156u8.f26759b++;
                N0(this.H7.f17203a);
            }
            this.K1 = null;
            try {
                MediaCrypto mediaCrypto = this.f17135k0;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th2) {
            this.K1 = null;
            try {
                MediaCrypto mediaCrypto2 = this.f17135k0;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th2;
            } finally {
            }
        }
    }

    public void Z0() throws ExoPlaybackException {
    }

    @Override // ya.q1
    public final int a(Format format) throws ExoPlaybackException {
        try {
            return m1(this.f17141n, format);
        } catch (MediaCodecUtil.DecoderQueryException e10) {
            throw y(e10, format);
        }
    }

    @g.i
    public void a1() {
        c1();
        d1();
        this.U7 = g.f56663b;
        this.f17133i8 = false;
        this.f17132h8 = false;
        this.Q7 = false;
        this.R7 = false;
        this.Y7 = false;
        this.Z7 = false;
        this.f17157v.clear();
        this.f17137k8 = g.f56663b;
        this.f17138l8 = g.f56663b;
        i iVar = this.T7;
        if (iVar != null) {
            iVar.b();
        }
        this.f17130f8 = 0;
        this.f17131g8 = 0;
        this.f17129e8 = this.f17128d8 ? 1 : 0;
    }

    @Override // ya.o1
    public boolean b() {
        return this.f17142n8;
    }

    public abstract void b0(c cVar, b bVar, Format format, @p0 MediaCrypto mediaCrypto, float f10);

    @g.i
    public void b1() {
        a1();
        this.f17154t8 = null;
        this.T7 = null;
        this.F7 = null;
        this.H7 = null;
        this.f17159v2 = null;
        this.C2 = null;
        this.K2 = false;
        this.f17134j8 = false;
        this.E7 = -1.0f;
        this.I7 = 0;
        this.J7 = false;
        this.K7 = false;
        this.L7 = false;
        this.M7 = false;
        this.N7 = false;
        this.O7 = false;
        this.P7 = false;
        this.S7 = false;
        this.f17128d8 = false;
        this.f17129e8 = 0;
        this.K0 = false;
    }

    public MediaCodecDecoderException c0(Throwable th2, @p0 c cVar) {
        return new MediaCodecDecoderException(th2, cVar);
    }

    public final void c1() {
        this.V7 = -1;
        this.f17149r.f16960c = null;
    }

    @Override // ya.o1
    public boolean d() {
        return this.A != null && (F() || C0() || (this.U7 != g.f56663b && SystemClock.elapsedRealtime() < this.U7));
    }

    public final void d0() {
        this.f17127c8 = false;
        this.f17153t.h();
        this.f17151s.h();
        this.f17126b8 = false;
        this.f17125a8 = false;
    }

    public final void d1() {
        this.W7 = -1;
        this.X7 = null;
    }

    public final boolean e0() {
        if (this.f17132h8) {
            this.f17130f8 = 1;
            if (this.K7 || this.M7) {
                this.f17131g8 = 3;
                return false;
            }
            this.f17131g8 = 1;
        }
        return true;
    }

    public final void e1(@p0 DrmSession drmSession) {
        gb.i.b(this.C, drmSession);
        this.C = drmSession;
    }

    public final void f0() throws ExoPlaybackException {
        if (!this.f17132h8) {
            X0();
        } else {
            this.f17130f8 = 1;
            this.f17131g8 = 3;
        }
    }

    public final void f1() {
        this.f17146p8 = true;
    }

    @TargetApi(23)
    public final boolean g0() throws ExoPlaybackException {
        if (this.f17132h8) {
            this.f17130f8 = 1;
            if (this.K7 || this.M7) {
                this.f17131g8 = 3;
                return false;
            }
            this.f17131g8 = 2;
        } else {
            p1();
        }
        return true;
    }

    public final void g1(ExoPlaybackException exoPlaybackException) {
        this.f17154t8 = exoPlaybackException;
    }

    public final boolean h0(long j10, long j11) throws ExoPlaybackException {
        boolean z10;
        boolean zU0;
        int iG;
        if (!C0()) {
            if (this.N7 && this.f17133i8) {
                try {
                    iG = this.K1.g(this.f17161w);
                } catch (IllegalStateException unused) {
                    T0();
                    if (this.f17142n8) {
                        Y0();
                    }
                    return false;
                }
            } else {
                iG = this.K1.g(this.f17161w);
            }
            if (iG < 0) {
                if (iG == -2) {
                    V0();
                    return true;
                }
                if (this.S7 && (this.f17140m8 || this.f17130f8 == 2)) {
                    T0();
                }
                return false;
            }
            if (this.R7) {
                this.R7 = false;
                this.K1.i(iG, false);
                return true;
            }
            MediaCodec.BufferInfo bufferInfo = this.f17161w;
            if (bufferInfo.size == 0 && (bufferInfo.flags & 4) != 0) {
                T0();
                return false;
            }
            this.W7 = iG;
            ByteBuffer byteBufferM = this.K1.m(iG);
            this.X7 = byteBufferM;
            if (byteBufferM != null) {
                byteBufferM.position(this.f17161w.offset);
                ByteBuffer byteBuffer = this.X7;
                MediaCodec.BufferInfo bufferInfo2 = this.f17161w;
                byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
            }
            if (this.O7) {
                MediaCodec.BufferInfo bufferInfo3 = this.f17161w;
                if (bufferInfo3.presentationTimeUs == 0 && (bufferInfo3.flags & 4) != 0) {
                    long j12 = this.f17137k8;
                    if (j12 != g.f56663b) {
                        bufferInfo3.presentationTimeUs = j12;
                    }
                }
            }
            this.Y7 = F0(this.f17161w.presentationTimeUs);
            long j13 = this.f17138l8;
            long j14 = this.f17161w.presentationTimeUs;
            this.Z7 = j13 == j14;
            q1(j14);
        }
        if (this.N7 && this.f17133i8) {
            try {
                b bVar = this.K1;
                ByteBuffer byteBuffer2 = this.X7;
                int i10 = this.W7;
                MediaCodec.BufferInfo bufferInfo4 = this.f17161w;
                z10 = false;
                try {
                    zU0 = U0(j10, j11, bVar, byteBuffer2, i10, bufferInfo4.flags, 1, bufferInfo4.presentationTimeUs, this.Y7, this.Z7, this.B);
                } catch (IllegalStateException unused2) {
                    T0();
                    if (this.f17142n8) {
                        Y0();
                    }
                    return z10;
                }
            } catch (IllegalStateException unused3) {
                z10 = false;
            }
        } else {
            z10 = false;
            b bVar2 = this.K1;
            ByteBuffer byteBuffer3 = this.X7;
            int i11 = this.W7;
            MediaCodec.BufferInfo bufferInfo5 = this.f17161w;
            zU0 = U0(j10, j11, bVar2, byteBuffer3, i11, bufferInfo5.flags, 1, bufferInfo5.presentationTimeUs, this.Y7, this.Z7, this.B);
        }
        if (zU0) {
            Q0(this.f17161w.presentationTimeUs);
            boolean z11 = (this.f17161w.flags & 4) != 0;
            d1();
            if (!z11) {
                return true;
            }
            T0();
        }
        return z10;
    }

    public void h1(long j10) {
        this.f17136k1 = j10;
    }

    public final boolean i0(c cVar, Format format, @p0 DrmSession drmSession, @p0 DrmSession drmSession2) throws ExoPlaybackException {
        t tVarY0;
        if (drmSession == drmSession2) {
            return false;
        }
        if (drmSession2 == null || drmSession == null || u0.f31154a < 23) {
            return true;
        }
        UUID uuid = g.L1;
        if (uuid.equals(drmSession.g()) || uuid.equals(drmSession2.g()) || (tVarY0 = y0(drmSession2)) == null) {
            return true;
        }
        return !cVar.f17209g && L0(tVarY0, format);
    }

    public void j0(boolean z10) {
        this.f17148q8 = z10;
    }

    public final boolean j1(long j10) {
        return this.f17136k1 == g.f56663b || SystemClock.elapsedRealtime() - j10 < this.f17136k1;
    }

    public void k0(boolean z10) {
        this.f17150r8 = z10;
    }

    public boolean k1(c cVar) {
        return true;
    }

    public void l0(boolean z10) {
        this.f17152s8 = z10;
    }

    public boolean l1(Format format) {
        return false;
    }

    public abstract int m1(d dVar, Format format) throws MediaCodecUtil.DecoderQueryException;

    public final void n0() {
        try {
            this.K1.flush();
        } finally {
            a1();
        }
    }

    @Override // com.google.android.exoplayer2.a, ya.o1
    public void o(float f10, float f11) throws ExoPlaybackException {
        this.f17158v1 = f10;
        this.C1 = f11;
        if (this.K1 == null || this.f17131g8 == 3 || getState() == 0) {
            return;
        }
        o1(this.f17159v2);
    }

    public final boolean o0() throws ExoPlaybackException {
        boolean zP0 = p0();
        if (zP0) {
            J0();
        }
        return zP0;
    }

    public final boolean o1(Format format) throws ExoPlaybackException {
        if (u0.f31154a < 23) {
            return true;
        }
        float fV0 = v0(this.C1, format, E());
        float f10 = this.E7;
        if (f10 == fV0) {
            return true;
        }
        if (fV0 == -1.0f) {
            f0();
            return false;
        }
        if (f10 == -1.0f && fV0 <= this.f17145p) {
            return true;
        }
        Bundle bundle = new Bundle();
        bundle.putFloat("operating-rate", fV0);
        this.K1.d(bundle);
        this.E7 = fV0;
        return true;
    }

    @Override // com.google.android.exoplayer2.a, ya.q1
    public final int p() {
        return 8;
    }

    public boolean p0() {
        if (this.K1 == null) {
            return false;
        }
        if (this.f17131g8 == 3 || this.K7 || ((this.L7 && !this.f17134j8) || (this.M7 && this.f17133i8))) {
            Y0();
            return true;
        }
        n0();
        return false;
    }

    @v0(23)
    public final void p1() throws ExoPlaybackException {
        try {
            this.f17135k0.setMediaDrmSession(y0(this.D).f29125b);
            e1(this.D);
            this.f17130f8 = 0;
            this.f17131g8 = 0;
        } catch (MediaCryptoException e10) {
            throw y(e10, this.A);
        }
    }

    @Override // ya.o1
    public void q(long j10, long j11) throws ExoPlaybackException {
        if (this.f17146p8) {
            this.f17146p8 = false;
            T0();
        }
        ExoPlaybackException exoPlaybackException = this.f17154t8;
        if (exoPlaybackException != null) {
            this.f17154t8 = null;
            throw exoPlaybackException;
        }
        try {
            if (this.f17142n8) {
                Z0();
                return;
            }
            if (this.A != null || W0(true)) {
                J0();
                if (this.f17125a8) {
                    q0.a("bypassRender");
                    while (Q(j10, j11)) {
                    }
                    q0.c();
                } else if (this.K1 != null) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    q0.a("drainAndFeed");
                    while (h0(j10, j11) && j1(jElapsedRealtime)) {
                    }
                    while (m0() && j1(jElapsedRealtime)) {
                    }
                    q0.c();
                } else {
                    this.f17156u8.f26761d += O(j10);
                    W0(false);
                }
                this.f17156u8.c();
            }
        } catch (IllegalStateException e10) {
            if (!G0(e10)) {
                throw e10;
            }
            throw y(c0(e10, s0()), this.A);
        }
    }

    public final List<c> q0(boolean z10) throws MediaCodecUtil.DecoderQueryException {
        List<c> listX0 = x0(this.f17141n, this.A, z10);
        if (listX0.isEmpty() && z10) {
            listX0 = x0(this.f17141n, this.A, false);
            if (!listX0.isEmpty()) {
                hd.t.n(f17124z8, "Drm session requires secure decoder for " + this.A.f16699l + ", but no secure decoder available. Trying to proceed with " + listX0 + j3.b.f36044h);
            }
        }
        return listX0;
    }

    public final void q1(long j10) throws ExoPlaybackException {
        boolean z10;
        Format formatJ = this.f17155u.j(j10);
        if (formatJ == null && this.K2) {
            formatJ = this.f17155u.i();
        }
        if (formatJ != null) {
            this.B = formatJ;
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 || (this.K2 && this.B != null)) {
            P0(this.B, this.C2);
            this.K2 = false;
        }
    }

    @p0
    public final b r0() {
        return this.K1;
    }

    @p0
    public final c s0() {
        return this.H7;
    }

    public boolean t0() {
        return false;
    }

    public float u0() {
        return this.E7;
    }

    public float v0(float f10, Format format, Format[] formatArr) {
        return -1.0f;
    }

    @p0
    public final MediaFormat w0() {
        return this.C2;
    }

    public abstract List<c> x0(d dVar, Format format, boolean z10) throws MediaCodecUtil.DecoderQueryException;

    @p0
    public final t y0(DrmSession drmSession) throws ExoPlaybackException {
        s sVarJ = drmSession.j();
        if (sVarJ == null || (sVarJ instanceof t)) {
            return (t) sVarJ;
        }
        throw y(new IllegalArgumentException("Expecting FrameworkMediaCrypto but found: " + sVarJ), this.A);
    }

    public final long z0() {
        return this.f17162w8;
    }

    public static class DecoderInitializationException extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f17167a = -50000;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f17168b = -49999;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f17169c = -49998;

        @p0
        public final c codecInfo;

        @p0
        public final String diagnosticInfo;

        @p0
        public final DecoderInitializationException fallbackDecoderInitializationException;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public DecoderInitializationException(Format format, @p0 Throwable th2, boolean z10, int i10) {
            this("Decoder init failed: [" + i10 + "], " + format, th2, format.f16699l, z10, null, b(i10), null);
        }

        public static String b(int i10) {
            return "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_" + (i10 < 0 ? "neg_" : "") + Math.abs(i10);
        }

        @p0
        @v0(21)
        public static String d(@p0 Throwable th2) {
            if (th2 instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th2).getDiagnosticInfo();
            }
            return null;
        }

        @j
        public final DecoderInitializationException c(DecoderInitializationException decoderInitializationException) {
            return new DecoderInitializationException(getMessage(), getCause(), this.mimeType, this.secureDecoderRequired, this.codecInfo, this.diagnosticInfo, decoderInitializationException);
        }

        public DecoderInitializationException(Format format, @p0 Throwable th2, boolean z10, c cVar) {
            this("Decoder init failed: " + cVar.f17203a + ", " + format, th2, format.f16699l, z10, cVar, u0.f31154a >= 21 ? d(th2) : null, null);
        }

        public DecoderInitializationException(String str, @p0 Throwable th2, String str2, boolean z10, @p0 c cVar, @p0 String str3, @p0 DecoderInitializationException decoderInitializationException) {
            super(str, th2);
            this.mimeType = str2;
            this.secureDecoderRequired = z10;
            this.codecInfo = cVar;
            this.diagnosticInfo = str3;
            this.fallbackDecoderInitializationException = decoderInitializationException;
        }
    }
}
