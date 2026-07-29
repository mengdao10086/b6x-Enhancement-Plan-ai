package id;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.b;
import com.google.android.exoplayer2.video.DummySurface;
import com.google.android.exoplayer2.video.MediaCodecVideoDecoderException;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import g.p0;
import g.v0;
import hd.q0;
import hd.u0;
import id.z;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import ya.p1;
import ya.s0;

/* JADX INFO: loaded from: classes3.dex */
public class f extends MediaCodecRenderer {
    public static final String D9 = "MediaCodecVideoRenderer";
    public static final String E9 = "crop-left";
    public static final String F9 = "crop-right";
    public static final String G9 = "crop-bottom";
    public static final String H9 = "crop-top";
    public static final int[] I9 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    public static final float J9 = 1.5f;
    public static final long K9 = Long.MAX_VALUE;
    public static boolean L9;
    public static boolean M9;
    public int A9;

    @p0
    public b B9;

    @p0
    public l C9;
    public final Context R8;
    public final m S8;
    public final z.a T8;
    public final long U8;
    public final int V8;
    public final boolean W8;
    public a X8;
    public boolean Y8;
    public boolean Z8;

    /* JADX INFO: renamed from: a9, reason: collision with root package name */
    @p0
    public Surface f32179a9;

    /* JADX INFO: renamed from: b9, reason: collision with root package name */
    @p0
    public Surface f32180b9;

    /* JADX INFO: renamed from: c9, reason: collision with root package name */
    public boolean f32181c9;

    /* JADX INFO: renamed from: d9, reason: collision with root package name */
    public int f32182d9;

    /* JADX INFO: renamed from: e9, reason: collision with root package name */
    public boolean f32183e9;

    /* JADX INFO: renamed from: f9, reason: collision with root package name */
    public boolean f32184f9;

    /* JADX INFO: renamed from: g9, reason: collision with root package name */
    public boolean f32185g9;

    /* JADX INFO: renamed from: h9, reason: collision with root package name */
    public long f32186h9;

    /* JADX INFO: renamed from: i9, reason: collision with root package name */
    public long f32187i9;

    /* JADX INFO: renamed from: j9, reason: collision with root package name */
    public long f32188j9;

    /* JADX INFO: renamed from: k9, reason: collision with root package name */
    public int f32189k9;

    /* JADX INFO: renamed from: l9, reason: collision with root package name */
    public int f32190l9;

    /* JADX INFO: renamed from: m9, reason: collision with root package name */
    public int f32191m9;

    /* JADX INFO: renamed from: n9, reason: collision with root package name */
    public long f32192n9;

    /* JADX INFO: renamed from: o9, reason: collision with root package name */
    public long f32193o9;

    /* JADX INFO: renamed from: p9, reason: collision with root package name */
    public long f32194p9;

    /* JADX INFO: renamed from: q9, reason: collision with root package name */
    public int f32195q9;

    /* JADX INFO: renamed from: r9, reason: collision with root package name */
    public int f32196r9;

    /* JADX INFO: renamed from: s9, reason: collision with root package name */
    public int f32197s9;

    /* JADX INFO: renamed from: t9, reason: collision with root package name */
    public int f32198t9;

    /* JADX INFO: renamed from: u9, reason: collision with root package name */
    public float f32199u9;

    /* JADX INFO: renamed from: v9, reason: collision with root package name */
    public int f32200v9;

    /* JADX INFO: renamed from: w9, reason: collision with root package name */
    public int f32201w9;

    /* JADX INFO: renamed from: x9, reason: collision with root package name */
    public int f32202x9;

    /* JADX INFO: renamed from: y9, reason: collision with root package name */
    public float f32203y9;

    /* JADX INFO: renamed from: z9, reason: collision with root package name */
    public boolean f32204z9;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f32206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f32207c;

        public a(int i10, int i11, int i12) {
            this.f32205a = i10;
            this.f32206b = i11;
            this.f32207c = i12;
        }
    }

    @v0(23)
    public final class b implements b.InterfaceC0179b, Handler.Callback {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f32208c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f32209a;

        public b(com.google.android.exoplayer2.mediacodec.b bVar) {
            Handler handlerA = u0.A(this);
            this.f32209a = handlerA;
            bVar.h(this, handlerA);
        }

        @Override // com.google.android.exoplayer2.mediacodec.b.InterfaceC0179b
        public void a(com.google.android.exoplayer2.mediacodec.b bVar, long j10, long j11) {
            if (u0.f31154a >= 30) {
                b(j10);
            } else {
                this.f32209a.sendMessageAtFrontOfQueue(Message.obtain(this.f32209a, 0, (int) (j10 >> 32), (int) j10));
            }
        }

        public final void b(long j10) {
            f fVar = f.this;
            if (this != fVar.B9) {
                return;
            }
            if (j10 == Long.MAX_VALUE) {
                fVar.S1();
                return;
            }
            try {
                fVar.R1(j10);
            } catch (ExoPlaybackException e10) {
                f.this.g1(e10);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b(u0.v1(message.arg1, message.arg2));
            return true;
        }
    }

    public f(Context context, com.google.android.exoplayer2.mediacodec.d dVar) {
        this(context, dVar, 0L);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int A1(com.google.android.exoplayer2.mediacodec.c r5, java.lang.String r6, int r7, int r8) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: id.f.A1(com.google.android.exoplayer2.mediacodec.c, java.lang.String, int, int):int");
    }

    public static Point B1(com.google.android.exoplayer2.mediacodec.c cVar, Format format) {
        int i10 = format.f16705r;
        int i11 = format.f16704q;
        boolean z10 = i10 > i11;
        int i12 = z10 ? i10 : i11;
        if (z10) {
            i10 = i11;
        }
        float f10 = i10 / i12;
        for (int i13 : I9) {
            int i14 = (int) (i13 * f10);
            if (i13 <= i12 || i14 <= i10) {
                break;
            }
            if (u0.f31154a >= 21) {
                int i15 = z10 ? i14 : i13;
                if (!z10) {
                    i13 = i14;
                }
                Point pointB = cVar.b(i15, i13);
                if (cVar.w(pointB.x, pointB.y, format.f16706s)) {
                    return pointB;
                }
            } else {
                try {
                    int iM = u0.m(i13, 16) * 16;
                    int iM2 = u0.m(i14, 16) * 16;
                    if (iM * iM2 <= MediaCodecUtil.N()) {
                        int i16 = z10 ? iM2 : iM;
                        if (!z10) {
                            iM = iM2;
                        }
                        return new Point(i16, iM);
                    }
                } catch (MediaCodecUtil.DecoderQueryException unused) {
                }
            }
        }
        return null;
    }

    public static List<com.google.android.exoplayer2.mediacodec.c> D1(com.google.android.exoplayer2.mediacodec.d dVar, Format format, boolean z10, boolean z11) throws MediaCodecUtil.DecoderQueryException {
        Pair<Integer, Integer> pairQ;
        String str = format.f16699l;
        if (str == null) {
            return Collections.emptyList();
        }
        List<com.google.android.exoplayer2.mediacodec.c> listU = MediaCodecUtil.u(dVar.a(str, z10, z11), format);
        if (hd.w.f31216w.equals(str) && (pairQ = MediaCodecUtil.q(format)) != null) {
            int iIntValue = ((Integer) pairQ.first).intValue();
            if (iIntValue == 16 || iIntValue == 256) {
                listU.addAll(dVar.a(hd.w.f31192k, z10, z11));
            } else if (iIntValue == 512) {
                listU.addAll(dVar.a(hd.w.f31190j, z10, z11));
            }
        }
        return Collections.unmodifiableList(listU);
    }

    public static int E1(com.google.android.exoplayer2.mediacodec.c cVar, Format format) {
        if (format.f16700m == -1) {
            return A1(cVar, format.f16699l, format.f16704q, format.f16705r);
        }
        int size = format.f16701n.size();
        int length = 0;
        for (int i10 = 0; i10 < size; i10++) {
            length += format.f16701n.get(i10).length;
        }
        return format.f16700m + length;
    }

    public static boolean H1(long j10) {
        return j10 < -30000;
    }

    public static boolean I1(long j10) {
        return j10 < -500000;
    }

    @v0(29)
    public static void V1(com.google.android.exoplayer2.mediacodec.b bVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        bVar.d(bundle);
    }

    @v0(21)
    public static void w1(MediaFormat mediaFormat, int i10) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i10);
    }

    public static boolean x1() {
        return "NVIDIA".equals(u0.f31156c);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:610:0x0829  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001a  */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean z1() {
        /*
            Method dump skipped, instruction units count: 3046
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: id.f.z1():boolean");
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @TargetApi(29)
    public void B0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.Z8) {
            ByteBuffer byteBuffer = (ByteBuffer) hd.a.g(decoderInputBuffer.f16963f);
            if (byteBuffer.remaining() >= 7) {
                byte b10 = byteBuffer.get();
                short s10 = byteBuffer.getShort();
                short s11 = byteBuffer.getShort();
                byte b11 = byteBuffer.get();
                byte b12 = byteBuffer.get();
                byteBuffer.position(0);
                if (b10 == -75 && s10 == 60 && s11 == 1 && b11 == 4 && b12 == 0) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    V1(r0(), bArr);
                }
            }
        }
    }

    public a C1(com.google.android.exoplayer2.mediacodec.c cVar, Format format, Format[] formatArr) {
        int iA1;
        int iMax = format.f16704q;
        int iMax2 = format.f16705r;
        int iE1 = E1(cVar, format);
        if (formatArr.length == 1) {
            if (iE1 != -1 && (iA1 = A1(cVar, format.f16699l, format.f16704q, format.f16705r)) != -1) {
                iE1 = Math.min((int) (iE1 * 1.5f), iA1);
            }
            return new a(iMax, iMax2, iE1);
        }
        int length = formatArr.length;
        boolean z10 = false;
        for (int i10 = 0; i10 < length; i10++) {
            Format formatE = formatArr[i10];
            if (format.f16711x != null && formatE.f16711x == null) {
                formatE = formatE.a().J(format.f16711x).E();
            }
            if (cVar.e(format, formatE).f26791d != 0) {
                int i11 = formatE.f16704q;
                z10 |= i11 == -1 || formatE.f16705r == -1;
                iMax = Math.max(iMax, i11);
                iMax2 = Math.max(iMax2, formatE.f16705r);
                iE1 = Math.max(iE1, E1(cVar, formatE));
            }
        }
        if (z10) {
            hd.t.n(D9, "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
            Point pointB1 = B1(cVar, format);
            if (pointB1 != null) {
                iMax = Math.max(iMax, pointB1.x);
                iMax2 = Math.max(iMax2, pointB1.y);
                iE1 = Math.max(iE1, A1(cVar, format.f16699l, iMax, iMax2));
                hd.t.n(D9, "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
            }
        }
        return new a(iMax, iMax2, iE1);
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(21)
    public MediaFormat F1(Format format, String str, a aVar, float f10, boolean z10, int i10) {
        Pair<Integer, Integer> pairQ;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger(SocializeProtocolConstants.WIDTH, format.f16704q);
        mediaFormat.setInteger(SocializeProtocolConstants.HEIGHT, format.f16705r);
        tb.o.e(mediaFormat, format.f16701n);
        tb.o.c(mediaFormat, "frame-rate", format.f16706s);
        tb.o.d(mediaFormat, "rotation-degrees", format.f16707t);
        tb.o.b(mediaFormat, format.f16711x);
        if (hd.w.f31216w.equals(format.f16699l) && (pairQ = MediaCodecUtil.q(format)) != null) {
            tb.o.d(mediaFormat, "profile", ((Integer) pairQ.first).intValue());
        }
        mediaFormat.setInteger("max-width", aVar.f32205a);
        mediaFormat.setInteger("max-height", aVar.f32206b);
        tb.o.d(mediaFormat, "max-input-size", aVar.f32207c);
        if (u0.f31154a >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f10 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f10);
            }
        }
        if (z10) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i10 != 0) {
            w1(mediaFormat, i10);
        }
        return mediaFormat;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    public void G() {
        u1();
        t1();
        this.f32181c9 = false;
        this.S8.g();
        this.B9 = null;
        try {
            super.G();
        } finally {
            this.T8.l(this.f17156u8);
        }
    }

    public Surface G1() {
        return this.f32179a9;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    public void H(boolean z10, boolean z11) throws ExoPlaybackException {
        super.H(z10, z11);
        boolean z12 = A().f57065a;
        hd.a.i((z12 && this.A9 == 0) ? false : true);
        if (this.f32204z9 != z12) {
            this.f32204z9 = z12;
            Y0();
        }
        this.T8.n(this.f17156u8);
        this.S8.h();
        this.f32184f9 = z11;
        this.f32185g9 = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    public void I(long j10, boolean z10) throws ExoPlaybackException {
        super.I(j10, z10);
        t1();
        this.S8.l();
        this.f32192n9 = ya.g.f56663b;
        this.f32186h9 = ya.g.f56663b;
        this.f32190l9 = 0;
        if (z10) {
            W1();
        } else {
            this.f32187i9 = ya.g.f56663b;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    public void J() {
        try {
            super.J();
            Surface surface = this.f32180b9;
            if (surface != null) {
                if (this.f32179a9 == surface) {
                    this.f32179a9 = null;
                }
                surface.release();
                this.f32180b9 = null;
            }
        } catch (Throwable th2) {
            if (this.f32180b9 != null) {
                Surface surface2 = this.f32179a9;
                Surface surface3 = this.f32180b9;
                if (surface2 == surface3) {
                    this.f32179a9 = null;
                }
                surface3.release();
                this.f32180b9 = null;
            }
            throw th2;
        }
    }

    public boolean J1(long j10, boolean z10) throws ExoPlaybackException {
        int iO = O(j10);
        if (iO == 0) {
            return false;
        }
        eb.d dVar = this.f17156u8;
        dVar.f26766i++;
        int i10 = this.f32191m9 + iO;
        if (z10) {
            dVar.f26763f += i10;
        } else {
            e2(i10);
        }
        o0();
        return true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    public void K() {
        super.K();
        this.f32189k9 = 0;
        this.f32188j9 = SystemClock.elapsedRealtime();
        this.f32193o9 = SystemClock.elapsedRealtime() * 1000;
        this.f32194p9 = 0L;
        this.f32195q9 = 0;
        this.S8.m();
    }

    public final void K1() {
        if (this.f32189k9 > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.T8.m(this.f32189k9, jElapsedRealtime - this.f32188j9);
            this.f32189k9 = 0;
            this.f32188j9 = jElapsedRealtime;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a
    public void L() {
        this.f32187i9 = ya.g.f56663b;
        K1();
        M1();
        this.S8.n();
        super.L();
    }

    public void L1() {
        this.f32185g9 = true;
        if (this.f32183e9) {
            return;
        }
        this.f32183e9 = true;
        this.T8.y(this.f32179a9);
        this.f32181c9 = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void M0(String str, long j10, long j11) {
        this.T8.j(str, j10, j11);
        this.Y8 = v1(str);
        this.Z8 = ((com.google.android.exoplayer2.mediacodec.c) hd.a.g(s0())).p();
    }

    public final void M1() {
        int i10 = this.f32195q9;
        if (i10 != 0) {
            this.T8.z(this.f32194p9, i10);
            this.f32194p9 = 0L;
            this.f32195q9 = 0;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void N0(String str) {
        this.T8.k(str);
    }

    public final void N1() {
        int i10 = this.f32196r9;
        if (i10 == -1 && this.f32197s9 == -1) {
            return;
        }
        if (this.f32200v9 == i10 && this.f32201w9 == this.f32197s9 && this.f32202x9 == this.f32198t9 && this.f32203y9 == this.f32199u9) {
            return;
        }
        this.T8.A(i10, this.f32197s9, this.f32198t9, this.f32199u9);
        this.f32200v9 = this.f32196r9;
        this.f32201w9 = this.f32197s9;
        this.f32202x9 = this.f32198t9;
        this.f32203y9 = this.f32199u9;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @p0
    public eb.e O0(s0 s0Var) throws ExoPlaybackException {
        eb.e eVarO0 = super.O0(s0Var);
        this.T8.o(s0Var.f57068b, eVarO0);
        return eVarO0;
    }

    public final void O1() {
        if (this.f32181c9) {
            this.T8.y(this.f32179a9);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void P0(Format format, @p0 MediaFormat mediaFormat) {
        com.google.android.exoplayer2.mediacodec.b bVarR0 = r0();
        if (bVarR0 != null) {
            bVarR0.a(this.f32182d9);
        }
        if (this.f32204z9) {
            this.f32196r9 = format.f16704q;
            this.f32197s9 = format.f16705r;
        } else {
            hd.a.g(mediaFormat);
            boolean z10 = mediaFormat.containsKey(F9) && mediaFormat.containsKey(E9) && mediaFormat.containsKey(G9) && mediaFormat.containsKey(H9);
            this.f32196r9 = z10 ? (mediaFormat.getInteger(F9) - mediaFormat.getInteger(E9)) + 1 : mediaFormat.getInteger(SocializeProtocolConstants.WIDTH);
            this.f32197s9 = z10 ? (mediaFormat.getInteger(G9) - mediaFormat.getInteger(H9)) + 1 : mediaFormat.getInteger(SocializeProtocolConstants.HEIGHT);
        }
        float f10 = format.f16708u;
        this.f32199u9 = f10;
        if (u0.f31154a >= 21) {
            int i10 = format.f16707t;
            if (i10 == 90 || i10 == 270) {
                int i11 = this.f32196r9;
                this.f32196r9 = this.f32197s9;
                this.f32197s9 = i11;
                this.f32199u9 = 1.0f / f10;
            }
        } else {
            this.f32198t9 = format.f16707t;
        }
        this.S8.i(format.f16706s);
    }

    public final void P1() {
        int i10 = this.f32200v9;
        if (i10 == -1 && this.f32201w9 == -1) {
            return;
        }
        this.T8.A(i10, this.f32201w9, this.f32202x9, this.f32203y9);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @g.i
    public void Q0(long j10) {
        super.Q0(j10);
        if (this.f32204z9) {
            return;
        }
        this.f32191m9--;
    }

    public final void Q1(long j10, long j11, Format format) {
        l lVar = this.C9;
        if (lVar != null) {
            lVar.c(j10, j11, format, w0());
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public eb.e R(com.google.android.exoplayer2.mediacodec.c cVar, Format format, Format format2) {
        eb.e eVarE = cVar.e(format, format2);
        int i10 = eVarE.f26792e;
        int i11 = format2.f16704q;
        a aVar = this.X8;
        if (i11 > aVar.f32205a || format2.f16705r > aVar.f32206b) {
            i10 |= 256;
        }
        if (E1(cVar, format2) > this.X8.f32207c) {
            i10 |= 64;
        }
        int i12 = i10;
        return new eb.e(cVar.f17203a, format, format2, i12 != 0 ? 0 : eVarE.f26791d, i12);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void R0() {
        super.R0();
        t1();
    }

    public void R1(long j10) throws ExoPlaybackException {
        q1(j10);
        N1();
        this.f17156u8.f26762e++;
        L1();
        Q0(j10);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @g.i
    public void S0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        boolean z10 = this.f32204z9;
        if (!z10) {
            this.f32191m9++;
        }
        if (u0.f31154a >= 23 || !z10) {
            return;
        }
        R1(decoderInputBuffer.f16962e);
    }

    public final void S1() {
        f1();
    }

    public void T1(com.google.android.exoplayer2.mediacodec.b bVar, int i10, long j10) {
        N1();
        q0.a("releaseOutputBuffer");
        bVar.i(i10, true);
        q0.c();
        this.f32193o9 = SystemClock.elapsedRealtime() * 1000;
        this.f17156u8.f26762e++;
        this.f32190l9 = 0;
        L1();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean U0(long j10, long j11, @p0 com.google.android.exoplayer2.mediacodec.b bVar, @p0 ByteBuffer byteBuffer, int i10, int i11, int i12, long j12, boolean z10, boolean z11, Format format) throws ExoPlaybackException {
        long j13;
        boolean z12;
        hd.a.g(bVar);
        if (this.f32186h9 == ya.g.f56663b) {
            this.f32186h9 = j10;
        }
        if (j12 != this.f32192n9) {
            this.S8.j(j12);
            this.f32192n9 = j12;
        }
        long jZ0 = z0();
        long j14 = j12 - jZ0;
        if (z10 && !z11) {
            d2(bVar, i10, j14);
            return true;
        }
        double dA0 = A0();
        boolean z13 = getState() == 2;
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        long j15 = (long) ((j12 - j10) / dA0);
        if (z13) {
            j15 -= jElapsedRealtime - j11;
        }
        if (this.f32179a9 == this.f32180b9) {
            if (!H1(j15)) {
                return false;
            }
            d2(bVar, i10, j14);
            f2(j15);
            return true;
        }
        long j16 = jElapsedRealtime - this.f32193o9;
        if (this.f32185g9 ? this.f32183e9 : !(z13 || this.f32184f9)) {
            j13 = j16;
            z12 = false;
        } else {
            j13 = j16;
            z12 = true;
        }
        if (this.f32187i9 == ya.g.f56663b && j10 >= jZ0 && (z12 || (z13 && b2(j15, j13)))) {
            long jNanoTime = System.nanoTime();
            Q1(j14, jNanoTime, format);
            if (u0.f31154a >= 21) {
                U1(bVar, i10, j14, jNanoTime);
            } else {
                T1(bVar, i10, j14);
            }
            f2(j15);
            return true;
        }
        if (z13 && j10 != this.f32186h9) {
            long jNanoTime2 = System.nanoTime();
            long jB = this.S8.b((j15 * 1000) + jNanoTime2);
            long j17 = (jB - jNanoTime2) / 1000;
            boolean z14 = this.f32187i9 != ya.g.f56663b;
            if (Z1(j17, j11, z11) && J1(j10, z14)) {
                return false;
            }
            if (a2(j17, j11, z11)) {
                if (z14) {
                    d2(bVar, i10, j14);
                } else {
                    y1(bVar, i10, j14);
                }
                f2(j17);
                return true;
            }
            if (u0.f31154a >= 21) {
                if (j17 < 50000) {
                    Q1(j14, jB, format);
                    U1(bVar, i10, j14, jB);
                    f2(j17);
                    return true;
                }
            } else if (j17 < 30000) {
                if (j17 > 11000) {
                    try {
                        Thread.sleep((j17 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return false;
                    }
                }
                Q1(j14, jB, format);
                T1(bVar, i10, j14);
                f2(j17);
                return true;
            }
        }
        return false;
    }

    @v0(21)
    public void U1(com.google.android.exoplayer2.mediacodec.b bVar, int i10, long j10, long j11) {
        N1();
        q0.a("releaseOutputBuffer");
        bVar.e(i10, j11);
        q0.c();
        this.f32193o9 = SystemClock.elapsedRealtime() * 1000;
        this.f17156u8.f26762e++;
        this.f32190l9 = 0;
        L1();
    }

    public final void W1() {
        this.f32187i9 = this.U8 > 0 ? SystemClock.elapsedRealtime() + this.U8 : ya.g.f56663b;
    }

    @v0(23)
    public void X1(com.google.android.exoplayer2.mediacodec.b bVar, Surface surface) {
        bVar.k(surface);
    }

    public final void Y1(Surface surface) throws ExoPlaybackException {
        if (surface == null) {
            Surface surface2 = this.f32180b9;
            if (surface2 != null) {
                surface = surface2;
            } else {
                com.google.android.exoplayer2.mediacodec.c cVarS0 = s0();
                if (cVarS0 != null && c2(cVarS0)) {
                    surface = DummySurface.e(this.R8, cVarS0.f17209g);
                    this.f32180b9 = surface;
                }
            }
        }
        if (this.f32179a9 == surface) {
            if (surface == null || surface == this.f32180b9) {
                return;
            }
            P1();
            O1();
            return;
        }
        this.f32179a9 = surface;
        this.S8.o(surface);
        this.f32181c9 = false;
        int state = getState();
        com.google.android.exoplayer2.mediacodec.b bVarR0 = r0();
        if (bVarR0 != null) {
            if (u0.f31154a < 23 || surface == null || this.Y8) {
                Y0();
                J0();
            } else {
                X1(bVarR0, surface);
            }
        }
        if (surface == null || surface == this.f32180b9) {
            u1();
            t1();
            return;
        }
        P1();
        t1();
        if (state == 2) {
            W1();
        }
    }

    public boolean Z1(long j10, long j11, boolean z10) {
        return I1(j10) && !z10;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @g.i
    public void a1() {
        super.a1();
        this.f32191m9 = 0;
    }

    public boolean a2(long j10, long j11, boolean z10) {
        return H1(j10) && !z10;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void b0(com.google.android.exoplayer2.mediacodec.c cVar, com.google.android.exoplayer2.mediacodec.b bVar, Format format, @p0 MediaCrypto mediaCrypto, float f10) {
        String str = cVar.f17205c;
        a aVarC1 = C1(cVar, format, E());
        this.X8 = aVarC1;
        MediaFormat mediaFormatF1 = F1(format, str, aVarC1, f10, this.W8, this.f32204z9 ? this.A9 : 0);
        if (this.f32179a9 == null) {
            if (!c2(cVar)) {
                throw new IllegalStateException();
            }
            if (this.f32180b9 == null) {
                this.f32180b9 = DummySurface.e(this.R8, cVar.f17209g);
            }
            this.f32179a9 = this.f32180b9;
        }
        bVar.b(mediaFormatF1, this.f32179a9, mediaCrypto, 0);
        if (u0.f31154a < 23 || !this.f32204z9) {
            return;
        }
        this.B9 = new b(bVar);
    }

    public boolean b2(long j10, long j11) {
        return H1(j10) && j11 > 100000;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public MediaCodecDecoderException c0(Throwable th2, @p0 com.google.android.exoplayer2.mediacodec.c cVar) {
        return new MediaCodecVideoDecoderException(th2, cVar, this.f32179a9);
    }

    public final boolean c2(com.google.android.exoplayer2.mediacodec.c cVar) {
        return u0.f31154a >= 23 && !this.f32204z9 && !v1(cVar.f17203a) && (!cVar.f17209g || DummySurface.b(this.R8));
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, ya.o1
    public boolean d() {
        Surface surface;
        if (super.d() && (this.f32183e9 || (((surface = this.f32180b9) != null && this.f32179a9 == surface) || r0() == null || this.f32204z9))) {
            this.f32187i9 = ya.g.f56663b;
            return true;
        }
        if (this.f32187i9 == ya.g.f56663b) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.f32187i9) {
            return true;
        }
        this.f32187i9 = ya.g.f56663b;
        return false;
    }

    public void d2(com.google.android.exoplayer2.mediacodec.b bVar, int i10, long j10) {
        q0.a("skipVideoBuffer");
        bVar.i(i10, false);
        q0.c();
        this.f17156u8.f26763f++;
    }

    public void e2(int i10) {
        eb.d dVar = this.f17156u8;
        dVar.f26764g += i10;
        this.f32189k9 += i10;
        int i11 = this.f32190l9 + i10;
        this.f32190l9 = i11;
        dVar.f26765h = Math.max(i11, dVar.f26765h);
        int i12 = this.V8;
        if (i12 <= 0 || this.f32189k9 < i12) {
            return;
        }
        K1();
    }

    public void f2(long j10) {
        this.f17156u8.a(j10);
        this.f32194p9 += j10;
        this.f32195q9++;
    }

    @Override // ya.o1, ya.q1
    public String getName() {
        return D9;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean k1(com.google.android.exoplayer2.mediacodec.c cVar) {
        return this.f32179a9 != null || c2(cVar);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int m1(com.google.android.exoplayer2.mediacodec.d dVar, Format format) throws MediaCodecUtil.DecoderQueryException {
        int i10 = 0;
        if (!hd.w.s(format.f16699l)) {
            return p1.a(0);
        }
        boolean z10 = format.f16702o != null;
        List<com.google.android.exoplayer2.mediacodec.c> listD1 = D1(dVar, format, z10, false);
        if (z10 && listD1.isEmpty()) {
            listD1 = D1(dVar, format, false, false);
        }
        if (listD1.isEmpty()) {
            return p1.a(1);
        }
        if (!MediaCodecRenderer.n1(format)) {
            return p1.a(2);
        }
        com.google.android.exoplayer2.mediacodec.c cVar = listD1.get(0);
        boolean zO = cVar.o(format);
        int i11 = cVar.q(format) ? 16 : 8;
        if (zO) {
            List<com.google.android.exoplayer2.mediacodec.c> listD12 = D1(dVar, format, z10, true);
            if (!listD12.isEmpty()) {
                com.google.android.exoplayer2.mediacodec.c cVar2 = listD12.get(0);
                if (cVar2.o(format) && cVar2.q(format)) {
                    i10 = 32;
                }
            }
        }
        return p1.b(zO ? 4 : 3, i11, i10);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.a, ya.o1
    public void o(float f10, float f11) throws ExoPlaybackException {
        super.o(f10, f11);
        this.S8.k(f10);
    }

    @Override // com.google.android.exoplayer2.a, ya.l1.b
    public void r(int i10, @p0 Object obj) throws ExoPlaybackException {
        if (i10 == 1) {
            Y1((Surface) obj);
            return;
        }
        if (i10 == 4) {
            this.f32182d9 = ((Integer) obj).intValue();
            com.google.android.exoplayer2.mediacodec.b bVarR0 = r0();
            if (bVarR0 != null) {
                bVarR0.a(this.f32182d9);
                return;
            }
            return;
        }
        if (i10 == 6) {
            this.C9 = (l) obj;
            return;
        }
        if (i10 != 102) {
            super.r(i10, obj);
            return;
        }
        int iIntValue = ((Integer) obj).intValue();
        if (this.A9 != iIntValue) {
            this.A9 = iIntValue;
            if (this.f32204z9) {
                Y0();
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean t0() {
        return this.f32204z9 && u0.f31154a < 23;
    }

    public final void t1() {
        com.google.android.exoplayer2.mediacodec.b bVarR0;
        this.f32183e9 = false;
        if (u0.f31154a < 23 || !this.f32204z9 || (bVarR0 = r0()) == null) {
            return;
        }
        this.B9 = new b(bVarR0);
    }

    public final void u1() {
        this.f32200v9 = -1;
        this.f32201w9 = -1;
        this.f32203y9 = -1.0f;
        this.f32202x9 = -1;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float v0(float f10, Format format, Format[] formatArr) {
        float fMax = -1.0f;
        for (Format format2 : formatArr) {
            float f11 = format2.f16706s;
            if (f11 != -1.0f) {
                fMax = Math.max(fMax, f11);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * f10;
    }

    public boolean v1(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (f.class) {
            if (!L9) {
                M9 = z1();
                L9 = true;
            }
        }
        return M9;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public List<com.google.android.exoplayer2.mediacodec.c> x0(com.google.android.exoplayer2.mediacodec.d dVar, Format format, boolean z10) throws MediaCodecUtil.DecoderQueryException {
        return D1(dVar, format, z10, this.f32204z9);
    }

    public void y1(com.google.android.exoplayer2.mediacodec.b bVar, int i10, long j10) {
        q0.a("dropVideoBuffer");
        bVar.i(i10, false);
        q0.c();
        e2(1);
    }

    public f(Context context, com.google.android.exoplayer2.mediacodec.d dVar, long j10) {
        this(context, dVar, j10, null, null, -1);
    }

    public f(Context context, com.google.android.exoplayer2.mediacodec.d dVar, long j10, @p0 Handler handler, @p0 z zVar, int i10) {
        this(context, b.a.f17200a, dVar, j10, false, handler, zVar, i10);
    }

    public f(Context context, com.google.android.exoplayer2.mediacodec.d dVar, long j10, boolean z10, @p0 Handler handler, @p0 z zVar, int i10) {
        this(context, b.a.f17200a, dVar, j10, z10, handler, zVar, i10);
    }

    public f(Context context, b.a aVar, com.google.android.exoplayer2.mediacodec.d dVar, long j10, boolean z10, @p0 Handler handler, @p0 z zVar, int i10) {
        super(2, aVar, dVar, z10, 30.0f);
        this.U8 = j10;
        this.V8 = i10;
        Context applicationContext = context.getApplicationContext();
        this.R8 = applicationContext;
        this.S8 = new m(applicationContext);
        this.T8 = new z.a(handler, zVar);
        this.W8 = x1();
        this.f32187i9 = ya.g.f56663b;
        this.f32196r9 = -1;
        this.f32197s9 = -1;
        this.f32199u9 = -1.0f;
        this.f32182d9 = 1;
        this.A9 = 0;
        u1();
    }
}
