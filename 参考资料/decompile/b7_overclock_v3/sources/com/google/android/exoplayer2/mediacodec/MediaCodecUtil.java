package com.google.android.exoplayer2.mediacodec;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.android.material.internal.i;
import g.b0;
import g.j;
import g.p0;
import g.v0;
import hd.t;
import hd.u0;
import hd.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"InlinedApi"})
public final class MediaCodecUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f17170a = "MediaCodecUtil";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f17173d = "avc1";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f17174e = "avc2";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f17175f = "vp09";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f17176g = "hev1";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f17177h = "hvc1";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f17178i = "av01";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f17179j = "mp4a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f17171b = Pattern.compile("^\\D?(\\d+)$");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @b0("MediaCodecUtil.class")
    public static final HashMap<b, List<com.google.android.exoplayer2.mediacodec.c>> f17172c = new HashMap<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f17180k = -1;

    public static class DecoderQueryException extends Exception {
        public DecoderQueryException(Throwable th2) {
            super("Failed to query underlying media codecs", th2);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f17181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f17182b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f17183c;

        public b(String str, boolean z10, boolean z11) {
            this.f17181a = str;
            this.f17182b = z10;
            this.f17183c = z11;
        }

        public boolean equals(@p0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != b.class) {
                return false;
            }
            b bVar = (b) obj;
            return TextUtils.equals(this.f17181a, bVar.f17181a) && this.f17182b == bVar.f17182b && this.f17183c == bVar.f17183c;
        }

        public int hashCode() {
            return ((((this.f17181a.hashCode() + 31) * 31) + (this.f17182b ? 1231 : 1237)) * 31) + (this.f17183c ? 1231 : 1237);
        }
    }

    public interface c {
        MediaCodecInfo a(int i10);

        boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        int d();

        boolean e();
    }

    public static final class d implements c {
        public d() {
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public MediaCodecInfo a(int i10) {
            return MediaCodecList.getCodecInfoAt(i10);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && w.f31190j.equals(str2);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public int d() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean e() {
            return false;
        }
    }

    @v0(21)
    public static final class e implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public MediaCodecInfo[] f17185b;

        public e(boolean z10, boolean z11) {
            this.f17184a = (z10 || z11) ? 1 : 0;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public MediaCodecInfo a(int i10) {
            f();
            return this.f17185b[i10];
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public int d() {
            f();
            return this.f17185b.length;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c
        public boolean e() {
            return true;
        }

        @EnsuresNonNull({"mediaCodecInfos"})
        public final void f() {
            if (this.f17185b == null) {
                this.f17185b = new MediaCodecList(this.f17184a).getCodecInfos();
            }
        }
    }

    public interface f<T> {
        int a(T t10);
    }

    public static boolean A(MediaCodecInfo mediaCodecInfo) {
        return u0.f31154a >= 29 && B(mediaCodecInfo);
    }

    @v0(29)
    public static boolean B(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }

    public static boolean C(MediaCodecInfo mediaCodecInfo, String str, boolean z10, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z10 && str.endsWith(".secure"))) {
            return false;
        }
        int i10 = u0.f31154a;
        if (i10 < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i10 < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str3 = u0.f31155b;
            if ("a70".equals(str3) || ("Xiaomi".equals(u0.f31156c) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i10 == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = u0.f31155b;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i10 == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = u0.f31155b;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i10 < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && i.f20422b.equals(u0.f31156c))) {
            String str6 = u0.f31155b;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i10 <= 19 && "OMX.SEC.vp8.dec".equals(str) && i.f20422b.equals(u0.f31156c)) {
            String str7 = u0.f31155b;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i10 <= 19 && u0.f31155b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return (w.L.equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    public static boolean D(MediaCodecInfo mediaCodecInfo) {
        return u0.f31154a >= 29 ? E(mediaCodecInfo) : !F(mediaCodecInfo);
    }

    @v0(29)
    public static boolean E(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    public static boolean F(MediaCodecInfo mediaCodecInfo) {
        if (u0.f31154a >= 29) {
            return G(mediaCodecInfo);
        }
        String strW1 = u0.w1(mediaCodecInfo.getName());
        if (strW1.startsWith("arc.")) {
            return false;
        }
        return strW1.startsWith("omx.google.") || strW1.startsWith("omx.ffmpeg.") || (strW1.startsWith("omx.sec.") && strW1.contains(".sw.")) || strW1.equals("omx.qcom.video.decoder.hevcswvdec") || strW1.startsWith("c2.android.") || strW1.startsWith("c2.google.") || !(strW1.startsWith("omx.") || strW1.startsWith("c2."));
    }

    @v0(29)
    public static boolean G(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    public static boolean H(MediaCodecInfo mediaCodecInfo) {
        if (u0.f31154a >= 29) {
            return I(mediaCodecInfo);
        }
        String strW1 = u0.w1(mediaCodecInfo.getName());
        return (strW1.startsWith("omx.google.") || strW1.startsWith("c2.android.") || strW1.startsWith("c2.google.")) ? false : true;
    }

    @v0(29)
    public static boolean I(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }

    public static /* synthetic */ int J(com.google.android.exoplayer2.mediacodec.c cVar) {
        String str = cVar.f17203a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (u0.f31154a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }

    public static /* synthetic */ int K(com.google.android.exoplayer2.mediacodec.c cVar) {
        return cVar.f17203a.startsWith("OMX.google") ? 1 : 0;
    }

    public static /* synthetic */ int L(Format format, com.google.android.exoplayer2.mediacodec.c cVar) {
        try {
            return cVar.o(format) ? 1 : 0;
        } catch (DecoderQueryException unused) {
            return -1;
        }
    }

    public static /* synthetic */ int M(f fVar, Object obj, Object obj2) {
        return fVar.a(obj2) - fVar.a(obj);
    }

    public static int N() throws DecoderQueryException {
        if (f17180k == -1) {
            int iMax = 0;
            com.google.android.exoplayer2.mediacodec.c cVarR = r(w.f31190j, false, false);
            if (cVarR != null) {
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrI = cVarR.i();
                int length = codecProfileLevelArrI.length;
                int iMax2 = 0;
                while (iMax < length) {
                    iMax2 = Math.max(h(codecProfileLevelArrI[iMax].level), iMax2);
                    iMax++;
                }
                iMax = Math.max(iMax2, u0.f31154a >= 21 ? 345600 : 172800);
            }
            f17180k = iMax;
        }
        return f17180k;
    }

    public static int O(int i10) {
        int i11 = 17;
        if (i10 != 17) {
            i11 = 20;
            if (i10 != 20) {
                i11 = 23;
                if (i10 != 23) {
                    i11 = 29;
                    if (i10 != 29) {
                        i11 = 39;
                        if (i10 != 39) {
                            i11 = 42;
                            if (i10 != 42) {
                                switch (i10) {
                                    case 1:
                                        return 1;
                                    case 2:
                                        return 2;
                                    case 3:
                                        return 3;
                                    case 4:
                                        return 4;
                                    case 5:
                                        return 5;
                                    case 6:
                                        return 6;
                                    default:
                                        return -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i11;
    }

    public static <T> void P(List<T> list, final f<T> fVar) {
        Collections.sort(list, new Comparator() { // from class: tb.n
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return MediaCodecUtil.M(fVar, obj, obj2);
            }
        });
    }

    public static int Q(int i10) {
        if (i10 == 10) {
            return 1;
        }
        if (i10 == 11) {
            return 2;
        }
        if (i10 == 20) {
            return 4;
        }
        if (i10 == 21) {
            return 8;
        }
        if (i10 == 30) {
            return 16;
        }
        if (i10 == 31) {
            return 32;
        }
        if (i10 == 40) {
            return 64;
        }
        if (i10 == 41) {
            return 128;
        }
        if (i10 == 50) {
            return 256;
        }
        if (i10 == 51) {
            return 512;
        }
        switch (i10) {
            case 60:
                return 2048;
            case 61:
                return 4096;
            case 62:
                return 8192;
            default:
                return -1;
        }
    }

    public static int R(int i10) {
        if (i10 == 0) {
            return 1;
        }
        if (i10 == 1) {
            return 2;
        }
        if (i10 != 2) {
            return i10 != 3 ? -1 : 8;
        }
        return 4;
    }

    public static void S(String str, boolean z10, boolean z11) {
        try {
            s(str, z10, z11);
        } catch (DecoderQueryException e10) {
            t.e(f17170a, "Codec warming failed", e10);
        }
    }

    public static void e(String str, List<com.google.android.exoplayer2.mediacodec.c> list) {
        if (w.G.equals(str)) {
            if (u0.f31154a < 26 && u0.f31155b.equals("R9") && list.size() == 1 && list.get(0).f17203a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(com.google.android.exoplayer2.mediacodec.c.D("OMX.google.raw.decoder", w.G, w.G, null, false, true, false, false, false));
            }
            P(list, new f() { // from class: tb.l
                @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.f
                public final int a(Object obj) {
                    return MediaCodecUtil.J((com.google.android.exoplayer2.mediacodec.c) obj);
                }
            });
        }
        int i10 = u0.f31154a;
        if (i10 < 21 && list.size() > 1) {
            String str2 = list.get(0).f17203a;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                P(list, new f() { // from class: tb.m
                    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.f
                    public final int a(Object obj) {
                        return MediaCodecUtil.K((com.google.android.exoplayer2.mediacodec.c) obj);
                    }
                });
            }
        }
        if (i10 >= 30 || list.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(list.get(0).f17203a)) {
            return;
        }
        list.add(list.remove(0));
    }

    public static int f(int i10) {
        switch (i10) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            case 13:
                return 8192;
            case 14:
                return 16384;
            case 15:
                return 32768;
            case 16:
                return 65536;
            case 17:
                return 131072;
            case 18:
                return 262144;
            case 19:
                return 524288;
            case 20:
                return 1048576;
            case 21:
                return 2097152;
            case 22:
                return 4194304;
            case 23:
                return 8388608;
            default:
                return -1;
        }
    }

    public static int g(int i10) {
        switch (i10) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            default:
                switch (i10) {
                    case 20:
                        return 32;
                    case 21:
                        return 64;
                    case 22:
                        return 128;
                    default:
                        switch (i10) {
                            case 30:
                                return 256;
                            case 31:
                                return 512;
                            case 32:
                                return 1024;
                            default:
                                switch (i10) {
                                    case 40:
                                        return 2048;
                                    case 41:
                                        return 4096;
                                    case 42:
                                        return 8192;
                                    default:
                                        switch (i10) {
                                            case 50:
                                                return 16384;
                                            case 51:
                                                return 32768;
                                            case 52:
                                                return 65536;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    public static int h(int i10) {
        if (i10 == 1 || i10 == 2) {
            return 25344;
        }
        switch (i10) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            default:
                return -1;
        }
    }

    public static int i(int i10) {
        if (i10 == 66) {
            return 1;
        }
        if (i10 == 77) {
            return 2;
        }
        if (i10 == 88) {
            return 4;
        }
        if (i10 == 100) {
            return 8;
        }
        if (i10 == 110) {
            return 16;
        }
        if (i10 != 122) {
            return i10 != 244 ? -1 : 64;
        }
        return 32;
    }

    public static synchronized void j() {
        f17172c.clear();
    }

    @p0
    public static Integer k(@p0 String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
        }
        return null;
    }

    @p0
    public static Integer l(@p0 String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
        }
        return null;
    }

    @p0
    public static Pair<Integer, Integer> m(String str, String[] strArr) {
        int iO;
        if (strArr.length != 3) {
            t.n(f17170a, "Ignoring malformed MP4A codec string: " + str);
            return null;
        }
        try {
            if (w.A.equals(w.h(Integer.parseInt(strArr[1], 16))) && (iO = O(Integer.parseInt(strArr[2]))) != -1) {
                return new Pair<>(Integer.valueOf(iO), 0);
            }
        } catch (NumberFormatException unused) {
            t.n(f17170a, "Ignoring malformed MP4A codec string: " + str);
        }
        return null;
    }

    @p0
    public static Pair<Integer, Integer> n(String str, String[] strArr, @p0 ColorInfo colorInfo) {
        int i10;
        if (strArr.length < 4) {
            t.n(f17170a, "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
        try {
            int i11 = Integer.parseInt(strArr[1]);
            int i12 = Integer.parseInt(strArr[2].substring(0, 2));
            int i13 = Integer.parseInt(strArr[3]);
            if (i11 != 0) {
                t.n(f17170a, "Unknown AV1 profile: " + i11);
                return null;
            }
            if (i13 != 8 && i13 != 10) {
                t.n(f17170a, "Unknown AV1 bit depth: " + i13);
                return null;
            }
            int i14 = i13 != 8 ? (colorInfo == null || !(colorInfo.f19302d != null || (i10 = colorInfo.f19301c) == 7 || i10 == 6)) ? 2 : 4096 : 1;
            int iF = f(i12);
            if (iF != -1) {
                return new Pair<>(Integer.valueOf(i14), Integer.valueOf(iF));
            }
            t.n(f17170a, "Unknown AV1 level: " + i12);
            return null;
        } catch (NumberFormatException unused) {
            t.n(f17170a, "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
    }

    @p0
    public static Pair<Integer, Integer> o(String str, String[] strArr) {
        int i10;
        int i11;
        if (strArr.length < 2) {
            t.n(f17170a, "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                i11 = Integer.parseInt(strArr[1].substring(0, 2), 16);
                i10 = Integer.parseInt(strArr[1].substring(4), 16);
            } else {
                if (strArr.length < 3) {
                    t.n(f17170a, "Ignoring malformed AVC codec string: " + str);
                    return null;
                }
                int i12 = Integer.parseInt(strArr[1]);
                i10 = Integer.parseInt(strArr[2]);
                i11 = i12;
            }
            int i13 = i(i11);
            if (i13 == -1) {
                t.n(f17170a, "Unknown AVC profile: " + i11);
                return null;
            }
            int iG = g(i10);
            if (iG != -1) {
                return new Pair<>(Integer.valueOf(i13), Integer.valueOf(iG));
            }
            t.n(f17170a, "Unknown AVC level: " + i10);
            return null;
        } catch (NumberFormatException unused) {
            t.n(f17170a, "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    @p0
    public static String p(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals(w.f31216w)) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals(w.X) && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals(w.W) && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    @g.p0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> q(com.google.android.exoplayer2.Format r6) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.q(com.google.android.exoplayer2.Format):android.util.Pair");
    }

    @p0
    public static com.google.android.exoplayer2.mediacodec.c r(String str, boolean z10, boolean z11) throws DecoderQueryException {
        List<com.google.android.exoplayer2.mediacodec.c> listS = s(str, z10, z11);
        if (listS.isEmpty()) {
            return null;
        }
        return listS.get(0);
    }

    public static synchronized List<com.google.android.exoplayer2.mediacodec.c> s(String str, boolean z10, boolean z11) throws DecoderQueryException {
        b bVar = new b(str, z10, z11);
        HashMap<b, List<com.google.android.exoplayer2.mediacodec.c>> map = f17172c;
        List<com.google.android.exoplayer2.mediacodec.c> list = map.get(bVar);
        if (list != null) {
            return list;
        }
        int i10 = u0.f31154a;
        ArrayList<com.google.android.exoplayer2.mediacodec.c> arrayListT = t(bVar, i10 >= 21 ? new e(z10, z11) : new d());
        if (z10 && arrayListT.isEmpty() && 21 <= i10 && i10 <= 23) {
            arrayListT = t(bVar, new d());
            if (!arrayListT.isEmpty()) {
                t.n(f17170a, "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + arrayListT.get(0).f17203a);
            }
        }
        e(str, arrayListT);
        List<com.google.android.exoplayer2.mediacodec.c> listUnmodifiableList = Collections.unmodifiableList(arrayListT);
        map.put(bVar, listUnmodifiableList);
        return listUnmodifiableList;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0101 A[Catch: Exception -> 0x014f, TRY_ENTER, TryCatch #1 {Exception -> 0x014f, blocks: (B:3:0x0008, B:5:0x001b, B:60:0x0120, B:8:0x002d, B:11:0x0038, B:54:0x00f9, B:57:0x0101, B:59:0x0107, B:61:0x012a, B:62:0x014d), top: B:69:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x012a A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList<com.google.android.exoplayer2.mediacodec.c> t(com.google.android.exoplayer2.mediacodec.MediaCodecUtil.b r24, com.google.android.exoplayer2.mediacodec.MediaCodecUtil.c r25) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.t(com.google.android.exoplayer2.mediacodec.MediaCodecUtil$b, com.google.android.exoplayer2.mediacodec.MediaCodecUtil$c):java.util.ArrayList");
    }

    @j
    public static List<com.google.android.exoplayer2.mediacodec.c> u(List<com.google.android.exoplayer2.mediacodec.c> list, final Format format) {
        ArrayList arrayList = new ArrayList(list);
        P(arrayList, new f() { // from class: tb.k
            @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.f
            public final int a(Object obj) {
                return MediaCodecUtil.L(format, (com.google.android.exoplayer2.mediacodec.c) obj);
            }
        });
        return arrayList;
    }

    @p0
    public static com.google.android.exoplayer2.mediacodec.c v() throws DecoderQueryException {
        return r(w.G, false, false);
    }

    @p0
    public static Pair<Integer, Integer> w(String str, String[] strArr) {
        if (strArr.length < 3) {
            t.n(f17170a, "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        Matcher matcher = f17171b.matcher(strArr[1]);
        if (!matcher.matches()) {
            t.n(f17170a, "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        String strGroup = matcher.group(1);
        Integer numL = l(strGroup);
        if (numL == null) {
            t.n(f17170a, "Unknown Dolby Vision profile string: " + strGroup);
            return null;
        }
        String str2 = strArr[2];
        Integer numK = k(str2);
        if (numK != null) {
            return new Pair<>(numL, numK);
        }
        t.n(f17170a, "Unknown Dolby Vision level string: " + str2);
        return null;
    }

    @p0
    public static Pair<Integer, Integer> x(String str, String[] strArr) {
        if (strArr.length < 4) {
            t.n(f17170a, "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        int i10 = 1;
        Matcher matcher = f17171b.matcher(strArr[1]);
        if (!matcher.matches()) {
            t.n(f17170a, "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String strGroup = matcher.group(1);
        if (!"1".equals(strGroup)) {
            if (!"2".equals(strGroup)) {
                t.n(f17170a, "Unknown HEVC profile string: " + strGroup);
                return null;
            }
            i10 = 2;
        }
        String str2 = strArr[3];
        Integer numZ = z(str2);
        if (numZ != null) {
            return new Pair<>(Integer.valueOf(i10), numZ);
        }
        t.n(f17170a, "Unknown HEVC level string: " + str2);
        return null;
    }

    @p0
    public static Pair<Integer, Integer> y(String str, String[] strArr) {
        if (strArr.length < 3) {
            t.n(f17170a, "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
        try {
            int i10 = Integer.parseInt(strArr[1]);
            int i11 = Integer.parseInt(strArr[2]);
            int iR = R(i10);
            if (iR == -1) {
                t.n(f17170a, "Unknown VP9 profile: " + i10);
                return null;
            }
            int iQ = Q(i11);
            if (iQ != -1) {
                return new Pair<>(Integer.valueOf(iR), Integer.valueOf(iQ));
            }
            t.n(f17170a, "Unknown VP9 level: " + i11);
            return null;
        } catch (NumberFormatException unused) {
            t.n(f17170a, "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
    }

    @p0
    public static Integer z(@p0 String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
        }
        return null;
    }
}
