package com.google.android.exoplayer2.mediacodec;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import g.i1;
import g.p0;
import g.v0;
import hd.t;
import hd.u0;
import hd.w;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f17201l = "MediaCodecInfo";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f17202m = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public final MediaCodecInfo.CodecCapabilities f17206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f17207e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f17208f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f17209g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f17210h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f17211i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f17212j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f17213k;

    @i1
    public c(String str, String str2, String str3, @p0 MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        this.f17203a = (String) hd.a.g(str);
        this.f17204b = str2;
        this.f17205c = str3;
        this.f17206d = codecCapabilities;
        this.f17210h = z10;
        this.f17211i = z11;
        this.f17212j = z12;
        this.f17207e = z13;
        this.f17208f = z14;
        this.f17209g = z15;
        this.f17213k = w.s(str2);
    }

    public static boolean A(String str) {
        return u0.f31157d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    public static boolean B(String str) {
        if (u0.f31154a <= 22) {
            String str2 = u0.f31157d;
            if (("ODROID-XU3".equals(str2) || "Nexus 10".equals(str2)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) {
                return true;
            }
        }
        return false;
    }

    public static final boolean C(String str) {
        return ("OMX.MTK.VIDEO.DECODER.HEVC".equals(str) && "mcv5a".equals(u0.f31155b)) ? false : true;
    }

    public static c D(String str, String str2, String str3, @p0 MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        return new c(str, str2, str3, codecCapabilities, z10, z11, z12, (z13 || codecCapabilities == null || !j(codecCapabilities) || B(str)) ? false : true, codecCapabilities != null && u(codecCapabilities), z14 || (codecCapabilities != null && s(codecCapabilities)));
    }

    public static int a(String str, String str2, int i10) {
        if (i10 > 1 || ((u0.f31154a >= 26 && i10 > 0) || w.D.equals(str2) || w.U.equals(str2) || w.V.equals(str2) || w.A.equals(str2) || w.R.equals(str2) || w.S.equals(str2) || w.G.equals(str2) || w.W.equals(str2) || w.H.equals(str2) || w.I.equals(str2) || w.Y.equals(str2))) {
            return i10;
        }
        int i11 = w.J.equals(str2) ? 6 : w.K.equals(str2) ? 16 : 30;
        t.n(f17201l, "AssumedMaxChannelAdjustment: " + str + ", [" + i10 + " to " + i11 + "]");
        return i11;
    }

    @v0(21)
    public static Point c(MediaCodecInfo.VideoCapabilities videoCapabilities, int i10, int i11) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(u0.m(i10, widthAlignment) * widthAlignment, u0.m(i11, heightAlignment) * heightAlignment);
    }

    @v0(21)
    public static boolean d(MediaCodecInfo.VideoCapabilities videoCapabilities, int i10, int i11, double d10) {
        Point pointC = c(videoCapabilities, i10, i11);
        int i12 = pointC.x;
        int i13 = pointC.y;
        return (d10 == -1.0d || d10 < 1.0d) ? videoCapabilities.isSizeSupported(i12, i13) : videoCapabilities.areSizeAndRateSupported(i12, i13, Math.floor(d10));
    }

    public static MediaCodecInfo.CodecProfileLevel[] f(@p0 MediaCodecInfo.CodecCapabilities codecCapabilities) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        int iIntValue = (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) ? 0 : ((Integer) videoCapabilities.getBitrateRange().getUpper()).intValue();
        int i10 = iIntValue >= 180000000 ? 1024 : iIntValue >= 120000000 ? 512 : iIntValue >= 60000000 ? 256 : iIntValue >= 30000000 ? 128 : iIntValue >= 18000000 ? 64 : iIntValue >= 12000000 ? 32 : iIntValue >= 7200000 ? 16 : iIntValue >= 3600000 ? 8 : iIntValue >= 1800000 ? 4 : iIntValue >= 800000 ? 2 : 1;
        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = 1;
        codecProfileLevel.level = i10;
        return new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
    }

    @v0(23)
    public static int h(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.getMaxSupportedInstances();
    }

    public static boolean j(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return u0.f31154a >= 19 && k(codecCapabilities);
    }

    @v0(19)
    public static boolean k(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    public static boolean s(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return u0.f31154a >= 21 && t(codecCapabilities);
    }

    @v0(21)
    public static boolean t(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    public static boolean u(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return u0.f31154a >= 21 && v(codecCapabilities);
    }

    @v0(21)
    public static boolean v(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    public static boolean z(String str) {
        return w.S.equals(str);
    }

    @p0
    @v0(21)
    public Point b(int i10, int i11) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f17206d;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return c(videoCapabilities, i10, i11);
    }

    public eb.e e(Format format, Format format2) {
        int i10 = !u0.c(format.f16699l, format2.f16699l) ? 8 : 0;
        if (this.f17213k) {
            if (format.f16707t != format2.f16707t) {
                i10 |= 1024;
            }
            if (!this.f17207e && (format.f16704q != format2.f16704q || format.f16705r != format2.f16705r)) {
                i10 |= 512;
            }
            if (!u0.c(format.f16711x, format2.f16711x)) {
                i10 |= 2048;
            }
            if (A(this.f17203a) && !format.k0(format2)) {
                i10 |= 2;
            }
            if (i10 == 0) {
                return new eb.e(this.f17203a, format, format2, format.k0(format2) ? 3 : 2, 0);
            }
        } else {
            if (format.f16712y != format2.f16712y) {
                i10 |= 4096;
            }
            if (format.f16713z != format2.f16713z) {
                i10 |= 8192;
            }
            if (format.A != format2.A) {
                i10 |= 16384;
            }
            if (i10 == 0 && w.A.equals(this.f17204b)) {
                Pair<Integer, Integer> pairQ = MediaCodecUtil.q(format);
                Pair<Integer, Integer> pairQ2 = MediaCodecUtil.q(format2);
                if (pairQ != null && pairQ2 != null) {
                    int iIntValue = ((Integer) pairQ.first).intValue();
                    int iIntValue2 = ((Integer) pairQ2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new eb.e(this.f17203a, format, format2, 3, 0);
                    }
                }
            }
            if (!format.k0(format2)) {
                i10 |= 32;
            }
            if (z(this.f17204b)) {
                i10 |= 2;
            }
            if (i10 == 0) {
                return new eb.e(this.f17203a, format, format2, 1, 0);
            }
        }
        return new eb.e(this.f17203a, format, format2, 0, i10);
    }

    public int g() {
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        if (u0.f31154a < 23 || (codecCapabilities = this.f17206d) == null) {
            return -1;
        }
        return h(codecCapabilities);
    }

    public MediaCodecInfo.CodecProfileLevel[] i() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f17206d;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    @v0(21)
    public boolean l(int i10) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f17206d;
        if (codecCapabilities == null) {
            y("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            y("channelCount.aCaps");
            return false;
        }
        if (a(this.f17203a, this.f17204b, audioCapabilities.getMaxInputChannelCount()) >= i10) {
            return true;
        }
        y("channelCount.support, " + i10);
        return false;
    }

    @v0(21)
    public boolean m(int i10) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f17206d;
        if (codecCapabilities == null) {
            y("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            y("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i10)) {
            return true;
        }
        y("sampleRate.support, " + i10);
        return false;
    }

    public boolean n(Format format) {
        String strG;
        String str = format.f16695i;
        if (str == null || this.f17204b == null || (strG = w.g(str)) == null) {
            return true;
        }
        if (!this.f17204b.equals(strG)) {
            y("codec.mime " + format.f16695i + ", " + strG);
            return false;
        }
        Pair<Integer, Integer> pairQ = MediaCodecUtil.q(format);
        if (pairQ == null) {
            return true;
        }
        int iIntValue = ((Integer) pairQ.first).intValue();
        int iIntValue2 = ((Integer) pairQ.second).intValue();
        if (!this.f17213k && iIntValue != 42) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrI = i();
        if (u0.f31154a <= 23 && w.f31196m.equals(this.f17204b) && codecProfileLevelArrI.length == 0) {
            codecProfileLevelArrI = f(this.f17206d);
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArrI) {
            if (codecProfileLevel.profile == iIntValue && codecProfileLevel.level >= iIntValue2) {
                return true;
            }
        }
        y("codec.profileLevel, " + format.f16695i + ", " + strG);
        return false;
    }

    public boolean o(Format format) throws MediaCodecUtil.DecoderQueryException {
        int i10;
        if (!n(format)) {
            return false;
        }
        if (!this.f17213k) {
            if (u0.f31154a >= 21) {
                int i11 = format.f16713z;
                if (i11 != -1 && !m(i11)) {
                    return false;
                }
                int i12 = format.f16712y;
                if (i12 != -1 && !l(i12)) {
                    return false;
                }
            }
            return true;
        }
        int i13 = format.f16704q;
        if (i13 <= 0 || (i10 = format.f16705r) <= 0) {
            return true;
        }
        if (u0.f31154a >= 21) {
            return w(i13, i10, format.f16706s);
        }
        boolean z10 = i13 * i10 <= MediaCodecUtil.N();
        if (!z10) {
            y("legacyFrameSize, " + format.f16704q + "x" + format.f16705r);
        }
        return z10;
    }

    public boolean p() {
        if (u0.f31154a >= 29 && w.f31196m.equals(this.f17204b)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : i()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean q(Format format) {
        if (this.f17213k) {
            return this.f17207e;
        }
        Pair<Integer, Integer> pairQ = MediaCodecUtil.q(format);
        return pairQ != null && ((Integer) pairQ.first).intValue() == 42;
    }

    @Deprecated
    public boolean r(Format format, Format format2, boolean z10) {
        if (!z10 && format.f16711x != null && format2.f16711x == null) {
            format2 = format2.a().J(format.f16711x).E();
        }
        int i10 = e(format, format2).f26791d;
        return i10 == 2 || i10 == 3;
    }

    public String toString() {
        return this.f17203a;
    }

    @v0(21)
    public boolean w(int i10, int i11, double d10) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f17206d;
        if (codecCapabilities == null) {
            y("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            y("sizeAndRate.vCaps");
            return false;
        }
        if (d(videoCapabilities, i10, i11, d10)) {
            return true;
        }
        if (i10 < i11 && C(this.f17203a) && d(videoCapabilities, i11, i10, d10)) {
            x("sizeAndRate.rotated, " + i10 + "x" + i11 + "x" + d10);
            return true;
        }
        y("sizeAndRate.support, " + i10 + "x" + i11 + "x" + d10);
        return false;
    }

    public final void x(String str) {
        t.b(f17201l, "AssumedSupport [" + str + "] [" + this.f17203a + ", " + this.f17204b + "] [" + u0.f31158e + "]");
    }

    public final void y(String str) {
        t.b(f17201l, "NoSupport [" + str + "] [" + this.f17203a + ", " + this.f17204b + "] [" + u0.f31158e + "]");
    }
}
