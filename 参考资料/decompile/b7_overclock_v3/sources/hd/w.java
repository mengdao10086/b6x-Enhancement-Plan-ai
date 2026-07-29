package hd;

import android.text.TextUtils;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.common.math.DoubleMath;
import g.i1;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class w {
    public static final String A = "audio/mp4a-latm";
    public static final String A0 = "application/x-icy";
    public static final String B = "audio/x-matroska";
    public static final String B0 = "application/vnd.dvb.ait";
    public static final String C = "audio/webm";
    public static final String C0 = "image/jpeg";
    public static final String D = "audio/mpeg";
    public static final String E = "audio/mpeg-L1";
    public static final String F = "audio/mpeg-L2";
    public static final String G = "audio/raw";
    public static final String H = "audio/g711-alaw";
    public static final String I = "audio/g711-mlaw";
    public static final String J = "audio/ac3";
    public static final String K = "audio/eac3";
    public static final String L = "audio/eac3-joc";
    public static final String M = "audio/ac4";
    public static final String N = "audio/true-hd";
    public static final String O = "audio/vnd.dts";
    public static final String P = "audio/vnd.dts.hd";
    public static final String Q = "audio/vnd.dts.hd;profile=lbr";
    public static final String R = "audio/vorbis";
    public static final String S = "audio/opus";
    public static final String T = "audio/amr";
    public static final String U = "audio/3gpp";
    public static final String V = "audio/amr-wb";
    public static final String W = "audio/flac";
    public static final String X = "audio/alac";
    public static final String Y = "audio/gsm";
    public static final String Z = "audio/ogg";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f31172a = "video";

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final String f31173a0 = "audio/wav";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f31174b = "audio";

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final String f31175b0 = "audio/x-unknown";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f31176c = "text";

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final String f31177c0 = "text/vtt";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f31178d = "image";

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final String f31179d0 = "text/x-ssa";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f31180e = "application";

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final String f31181e0 = "application/mp4";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f31182f = "video/mp4";

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final String f31183f0 = "application/webm";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f31184g = "video/x-matroska";

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final String f31185g0 = "application/x-matroska";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f31186h = "video/webm";

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final String f31187h0 = "application/dash+xml";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f31188i = "video/3gpp";

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final String f31189i0 = "application/x-mpegURL";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f31190j = "video/avc";

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final String f31191j0 = "application/vnd.ms-sstr+xml";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f31192k = "video/hevc";

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final String f31193k0 = "application/id3";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f31194l = "video/x-vnd.on2.vp8";

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final String f31195l0 = "application/cea-608";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f31196m = "video/x-vnd.on2.vp9";

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final String f31197m0 = "application/cea-708";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f31198n = "video/av01";

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final String f31199n0 = "application/x-subrip";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f31200o = "video/mp2t";

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final String f31201o0 = "application/ttml+xml";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f31202p = "video/mp4v-es";

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final String f31203p0 = "application/x-quicktime-tx3g";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f31204q = "video/mpeg";

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final String f31205q0 = "application/x-mp4-vtt";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f31206r = "video/mp2p";

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final String f31207r0 = "application/x-mp4-cea-608";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f31208s = "video/mpeg2";

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final String f31209s0 = "application/x-rawcc";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f31210t = "video/wvc1";

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final String f31211t0 = "application/vobsub";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f31212u = "video/divx";

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final String f31213u0 = "application/pgs";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f31214v = "video/x-flv";

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final String f31215v0 = "application/x-scte35";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f31216w = "video/dolby-vision";

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final String f31217w0 = "application/x-camera-motion";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f31218x = "video/ogg";

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final String f31219x0 = "application/x-emsg";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f31220y = "video/x-unknown";

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final String f31221y0 = "application/dvbsubs";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f31222z = "audio/mp4";

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final String f31223z0 = "application/x-exif";
    public static final ArrayList<a> D0 = new ArrayList<>();
    public static final Pattern E0 = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f31224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f31225b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f31226c;

        public a(String str, String str2, int i10) {
            this.f31224a = str;
            this.f31225b = str2;
            this.f31226c = i10;
        }
    }

    @i1
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f31228b;

        public b(int i10, int i11) {
            this.f31227a = i10;
            this.f31228b = i11;
        }
    }

    public static boolean a(@g.p0 String str, @g.p0 String str2) {
        b bVarI;
        int iD;
        if (str == null) {
            return false;
        }
        switch (str) {
            case "audio/mp4a-latm":
                if (str2 != null && (bVarI = i(str2)) != null && (iD = ab.a.d(bVarI.f31228b)) != 0 && iD != 16) {
                }
                break;
        }
        return false;
    }

    public static boolean b(@g.p0 String str, String str2) {
        return d(str, str2) != null;
    }

    @g.p0
    public static String c(@g.p0 String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : u0.p1(str)) {
            String strG = g(str2);
            if (strG != null && p(strG)) {
                return strG;
            }
        }
        return null;
    }

    @g.p0
    public static String d(@g.p0 String str, @g.p0 String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        String[] strArrP1 = u0.p1(str);
        StringBuilder sb2 = new StringBuilder();
        for (String str3 : strArrP1) {
            if (str2.equals(g(str3))) {
                if (sb2.length() > 0) {
                    sb2.append(ag.c.f654g);
                }
                sb2.append(str3);
            }
        }
        if (sb2.length() > 0) {
            return sb2.toString();
        }
        return null;
    }

    @g.p0
    public static String e(String str) {
        int size = D0.size();
        for (int i10 = 0; i10 < size; i10++) {
            a aVar = D0.get(i10);
            if (str.startsWith(aVar.f31225b)) {
                return aVar.f31224a;
            }
        }
        return null;
    }

    public static int f(String str, @g.p0 String str2) {
        b bVarI;
        str.hashCode();
        switch (str) {
            case "audio/eac3-joc":
                return 18;
            case "audio/vnd.dts":
                return 7;
            case "audio/mp4a-latm":
                if (str2 == null || (bVarI = i(str2)) == null) {
                    return 0;
                }
                return ab.a.d(bVarI.f31228b);
            case "audio/ac3":
                return 5;
            case "audio/ac4":
                return 17;
            case "audio/eac3":
                return 6;
            case "audio/mpeg":
                return 9;
            case "audio/vnd.dts.hd":
                return 8;
            case "audio/true-hd":
                return 14;
            default:
                return 0;
        }
    }

    @g.p0
    public static String g(@g.p0 String str) {
        b bVarI;
        String strH = null;
        if (str == null) {
            return null;
        }
        String strW1 = u0.w1(str.trim());
        if (strW1.startsWith(MediaCodecUtil.f17173d) || strW1.startsWith("avc3")) {
            return f31190j;
        }
        if (strW1.startsWith(MediaCodecUtil.f17176g) || strW1.startsWith(MediaCodecUtil.f17177h)) {
            return f31192k;
        }
        if (strW1.startsWith("dvav") || strW1.startsWith("dva1") || strW1.startsWith("dvhe") || strW1.startsWith("dvh1")) {
            return f31216w;
        }
        if (strW1.startsWith(MediaCodecUtil.f17178i)) {
            return f31198n;
        }
        if (strW1.startsWith("vp9") || strW1.startsWith(MediaCodecUtil.f17175f)) {
            return f31196m;
        }
        if (strW1.startsWith("vp8") || strW1.startsWith("vp08")) {
            return f31194l;
        }
        if (!strW1.startsWith(MediaCodecUtil.f17179j)) {
            return (strW1.startsWith("ac-3") || strW1.startsWith("dac3")) ? J : (strW1.startsWith("ec-3") || strW1.startsWith("dec3")) ? K : strW1.startsWith("ec+3") ? L : (strW1.startsWith("ac-4") || strW1.startsWith("dac4")) ? M : (strW1.startsWith("dtsc") || strW1.startsWith("dtse")) ? O : (strW1.startsWith("dtsh") || strW1.startsWith("dtsl")) ? P : strW1.startsWith("opus") ? S : strW1.startsWith("vorbis") ? R : strW1.startsWith("flac") ? W : strW1.startsWith("stpp") ? f31201o0 : strW1.startsWith("wvtt") ? f31177c0 : strW1.contains("cea708") ? f31197m0 : (strW1.contains("eia608") || strW1.contains("cea608")) ? f31195l0 : e(strW1);
        }
        if (strW1.startsWith("mp4a.") && (bVarI = i(strW1)) != null) {
            strH = h(bVarI.f31227a);
        }
        return strH == null ? A : strH;
    }

    @g.p0
    public static String h(int i10) {
        if (i10 == 32) {
            return f31202p;
        }
        if (i10 == 33) {
            return f31190j;
        }
        if (i10 == 35) {
            return f31192k;
        }
        if (i10 == 64) {
            return A;
        }
        if (i10 == 163) {
            return f31210t;
        }
        if (i10 == 177) {
            return f31196m;
        }
        if (i10 == 165) {
            return J;
        }
        if (i10 == 166) {
            return K;
        }
        switch (i10) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return f31208s;
            case 102:
            case 103:
            case 104:
                return A;
            case 105:
            case 107:
                return D;
            case 106:
                return f31204q;
            default:
                switch (i10) {
                    case ob.h.H /* 169 */:
                    case rb.h0.K /* 172 */:
                        return O;
                    case DoubleMath.MAX_FACTORIAL /* 170 */:
                    case 171:
                        return P;
                    case WaspWingInfo.DEFAULT_COLD_LEVEL_OVERCLOCK_MIN /* 173 */:
                        return S;
                    case mb.e.f41073w1 /* 174 */:
                        return M;
                    default:
                        return null;
                }
        }
    }

    @i1
    @g.p0
    public static b i(String str) {
        Matcher matcher = E0.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String str2 = (String) hd.a.g(matcher.group(1));
        String strGroup = matcher.group(2);
        try {
            return new b(Integer.parseInt(str2, 16), strGroup != null ? Integer.parseInt(strGroup) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @g.p0
    public static String j(@g.p0 String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : u0.p1(str)) {
            String strG = g(str2);
            if (strG != null && r(strG)) {
                return strG;
            }
        }
        return null;
    }

    @g.p0
    public static String k(@g.p0 String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, iIndexOf);
    }

    public static int l(@g.p0 String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (p(str)) {
            return 1;
        }
        if (s(str)) {
            return 2;
        }
        if (r(str)) {
            return 3;
        }
        if (f31193k0.equals(str) || f31219x0.equals(str) || f31215v0.equals(str)) {
            return 5;
        }
        if (f31217w0.equals(str)) {
            return 6;
        }
        return m(str);
    }

    public static int m(String str) {
        int size = D0.size();
        for (int i10 = 0; i10 < size; i10++) {
            a aVar = D0.get(i10);
            if (str.equals(aVar.f31224a)) {
                return aVar.f31226c;
            }
        }
        return -1;
    }

    public static int n(String str) {
        return l(g(str));
    }

    @g.p0
    public static String o(@g.p0 String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : u0.p1(str)) {
            String strG = g(str2);
            if (strG != null && s(strG)) {
                return strG;
            }
        }
        return null;
    }

    public static boolean p(@g.p0 String str) {
        return "audio".equals(k(str));
    }

    public static boolean q(@g.p0 String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith(f31186h) || str.startsWith(C) || str.startsWith(f31183f0) || str.startsWith(f31184g) || str.startsWith(B) || str.startsWith(f31185g0);
    }

    public static boolean r(@g.p0 String str) {
        return "text".equals(k(str)) || f31195l0.equals(str) || f31197m0.equals(str) || f31207r0.equals(str) || f31199n0.equals(str) || f31201o0.equals(str) || f31203p0.equals(str) || f31205q0.equals(str) || f31209s0.equals(str) || f31211t0.equals(str) || f31213u0.equals(str) || f31221y0.equals(str);
    }

    public static boolean s(@g.p0 String str) {
        return "video".equals(k(str));
    }

    public static String t(String str) {
        str.hashCode();
        switch (str) {
            case "audio/x-flac":
                return W;
            case "audio/x-wav":
                return f31173a0;
            case "audio/mp3":
                return D;
            default:
                return str;
        }
    }

    public static void u(String str, String str2, int i10) {
        a aVar = new a(str, str2, i10);
        int size = D0.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                break;
            }
            ArrayList<a> arrayList = D0;
            if (str.equals(arrayList.get(i11).f31224a)) {
                arrayList.remove(i11);
                break;
            }
            i11++;
        }
        D0.add(aVar);
    }
}
