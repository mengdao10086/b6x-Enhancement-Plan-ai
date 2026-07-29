package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import com.google.android.exoplayer2.source.hls.playlist.b;
import com.google.android.exoplayer2.source.hls.playlist.c;
import com.google.android.exoplayer2.upstream.k;
import g.p0;
import hd.u0;
import hd.w;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lc.e;
import ob.l;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import ya.g;

/* JADX INFO: loaded from: classes3.dex */
public final class HlsPlaylistParser implements k.a<e> {
    public static final String A = "#EXT-X-SESSION-KEY";
    public static final String B = "#EXT-X-BYTERANGE";
    public static final String C = "#EXT-X-GAP";
    public static final String D = "#EXT-X-SKIP";
    public static final String E = "#EXT-X-PRELOAD-HINT";
    public static final String F = "#EXT-X-RENDITION-REPORT";
    public static final String G = "AUDIO";
    public static final String H = "VIDEO";
    public static final String I = "SUBTITLES";
    public static final String J = "CLOSED-CAPTIONS";
    public static final String K = "PART";
    public static final String L = "MAP";
    public static final String M = "NONE";
    public static final String N = "AES-128";
    public static final String O = "SAMPLE-AES";
    public static final String P = "SAMPLE-AES-CENC";
    public static final String Q = "SAMPLE-AES-CTR";
    public static final String R = "com.microsoft.playready";
    public static final String S = "identity";
    public static final String T = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed";
    public static final String U = "com.widevine";
    public static final String V = "YES";
    public static final String W = "NO";
    public static final String X = "CLOSED-CAPTIONS=NONE";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f17916c = "HlsPlaylistParser";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f17918d = "#EXTM3U";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f17920e = "#EXT";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f17922f = "#EXT-X-VERSION";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f17924g = "#EXT-X-PLAYLIST-TYPE";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f17926h = "#EXT-X-DEFINE";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f17928i = "#EXT-X-SERVER-CONTROL";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f17930j = "#EXT-X-STREAM-INF";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f17932k = "#EXT-X-PART-INF";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f17934l = "#EXT-X-PART";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f17936m = "#EXT-X-I-FRAME-STREAM-INF";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f17938n = "#EXT-X-I-FRAMES-ONLY";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f17940o = "#EXT-X-MEDIA";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f17942p = "#EXT-X-TARGETDURATION";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f17944q = "#EXT-X-DISCONTINUITY";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f17946r = "#EXT-X-DISCONTINUITY-SEQUENCE";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f17948s = "#EXT-X-PROGRAM-DATE-TIME";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f17950t = "#EXT-X-MAP";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f17952u = "#EXT-X-INDEPENDENT-SEGMENTS";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f17954v = "#EXTINF";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f17956w = "#EXT-X-MEDIA-SEQUENCE";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f17958x = "#EXT-X-START";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f17960y = "#EXT-X-ENDLIST";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f17962z = "#EXT-X-KEY";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f17964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final c f17965b;
    public static final Pattern Y = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    public static final Pattern Z = Pattern.compile("VIDEO=\"(.+?)\"");

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final Pattern f17914a0 = Pattern.compile("AUDIO=\"(.+?)\"");

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final Pattern f17915b0 = Pattern.compile("SUBTITLES=\"(.+?)\"");

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final Pattern f17917c0 = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final Pattern f17919d0 = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final Pattern f17921e0 = Pattern.compile("CHANNELS=\"(.+?)\"");

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final Pattern f17923f0 = Pattern.compile("CODECS=\"(.+?)\"");

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final Pattern f17925g0 = Pattern.compile("RESOLUTION=(\\d+x\\d+)");

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final Pattern f17927h0 = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final Pattern f17929i0 = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final Pattern f17931j0 = Pattern.compile("DURATION=([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final Pattern f17933k0 = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final Pattern f17935l0 = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final Pattern f17937m0 = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final Pattern f17939n0 = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final Pattern f17941o0 = c("CAN-SKIP-DATERANGES");

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final Pattern f17943p0 = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final Pattern f17945q0 = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final Pattern f17947r0 = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final Pattern f17949s0 = c("CAN-BLOCK-RELOAD");

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final Pattern f17951t0 = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final Pattern f17953u0 = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final Pattern f17955v0 = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final Pattern f17957w0 = Pattern.compile("LAST-MSN=(\\d+)\\b");

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final Pattern f17959x0 = Pattern.compile("LAST-PART=(\\d+)\\b");

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final Pattern f17961y0 = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final Pattern f17963z0 = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    public static final Pattern A0 = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    public static final Pattern B0 = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
    public static final Pattern C0 = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
    public static final Pattern D0 = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    public static final Pattern E0 = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    public static final Pattern F0 = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    public static final Pattern G0 = Pattern.compile("URI=\"(.+?)\"");
    public static final Pattern H0 = Pattern.compile("IV=([^,.*]+)");
    public static final Pattern I0 = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    public static final Pattern J0 = Pattern.compile("TYPE=(PART|MAP)");
    public static final Pattern K0 = Pattern.compile("LANGUAGE=\"(.+?)\"");
    public static final Pattern L0 = Pattern.compile("NAME=\"(.+?)\"");
    public static final Pattern M0 = Pattern.compile("GROUP-ID=\"(.+?)\"");
    public static final Pattern N0 = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    public static final Pattern O0 = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    public static final Pattern P0 = c("AUTOSELECT");
    public static final Pattern Q0 = c("DEFAULT");
    public static final Pattern R0 = c("FORCED");
    public static final Pattern S0 = c("INDEPENDENT");
    public static final Pattern T0 = c("GAP");
    public static final Pattern U0 = Pattern.compile("VALUE=\"(.+?)\"");
    public static final Pattern V0 = Pattern.compile("IMPORT=\"(.+?)\"");
    public static final Pattern W0 = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    public static final class DeltaUpdateException extends IOException {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BufferedReader f17966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Queue<String> f17967b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public String f17968c;

        public a(Queue<String> queue, BufferedReader bufferedReader) {
            this.f17967b = queue;
            this.f17966a = bufferedReader;
        }

        @EnsuresNonNullIf(expression = {"next"}, result = true)
        public boolean a() throws IOException {
            String strTrim;
            if (this.f17968c != null) {
                return true;
            }
            if (!this.f17967b.isEmpty()) {
                this.f17968c = (String) hd.a.g(this.f17967b.poll());
                return true;
            }
            do {
                String line = this.f17966a.readLine();
                this.f17968c = line;
                if (line == null) {
                    return false;
                }
                strTrim = line.trim();
                this.f17968c = strTrim;
            } while (strTrim.isEmpty());
            return true;
        }

        public String b() throws IOException {
            if (!a()) {
                throw new NoSuchElementException();
            }
            String str = this.f17968c;
            this.f17968c = null;
            return str;
        }
    }

    public HlsPlaylistParser() {
        this(b.f18000n, null);
    }

    public static String A(String str, Map<String, String> map) {
        Matcher matcher = W0.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            if (map.containsKey(strGroup)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(map.get(strGroup)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static int B(BufferedReader bufferedReader, boolean z10, int i10) throws IOException {
        while (i10 != -1 && Character.isWhitespace(i10) && (z10 || !u0.F0(i10))) {
            i10 = bufferedReader.read();
        }
        return i10;
    }

    public static boolean b(BufferedReader bufferedReader) throws IOException {
        int i10 = bufferedReader.read();
        if (i10 == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            i10 = bufferedReader.read();
        }
        int iB = B(bufferedReader, true, i10);
        for (int i11 = 0; i11 < 7; i11++) {
            if (iB != f17918d.charAt(i11)) {
                return false;
            }
            iB = bufferedReader.read();
        }
        return u0.F0(B(bufferedReader, false, iB));
    }

    public static Pattern c(String str) {
        return Pattern.compile(str + "=(" + W + "|" + V + ee.a.f26979d);
    }

    public static DrmInitData d(@p0 String str, DrmInitData.SchemeData[] schemeDataArr) {
        DrmInitData.SchemeData[] schemeDataArr2 = new DrmInitData.SchemeData[schemeDataArr.length];
        for (int i10 = 0; i10 < schemeDataArr.length; i10++) {
            schemeDataArr2[i10] = schemeDataArr[i10].b(null);
        }
        return new DrmInitData(str, schemeDataArr2);
    }

    @p0
    public static String e(long j10, @p0 String str, @p0 String str2) {
        if (str == null) {
            return null;
        }
        return str2 != null ? str2 : Long.toHexString(j10);
    }

    @p0
    public static b.C0188b f(ArrayList<b.C0188b> arrayList, String str) {
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            b.C0188b c0188b = arrayList.get(i10);
            if (str.equals(c0188b.f18021d)) {
                return c0188b;
            }
        }
        return null;
    }

    @p0
    public static b.C0188b g(ArrayList<b.C0188b> arrayList, String str) {
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            b.C0188b c0188b = arrayList.get(i10);
            if (str.equals(c0188b.f18022e)) {
                return c0188b;
            }
        }
        return null;
    }

    @p0
    public static b.C0188b h(ArrayList<b.C0188b> arrayList, String str) {
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            b.C0188b c0188b = arrayList.get(i10);
            if (str.equals(c0188b.f18020c)) {
                return c0188b;
            }
        }
        return null;
    }

    public static double j(String str, Pattern pattern) throws ParserException {
        return Double.parseDouble(z(str, pattern, Collections.emptyMap()));
    }

    @p0
    public static DrmInitData.SchemeData k(String str, String str2, Map<String, String> map) throws ParserException {
        String strU = u(str, F0, "1", map);
        if (T.equals(str2)) {
            String strZ = z(str, G0, map);
            return new DrmInitData.SchemeData(g.K1, w.f31182f, Base64.decode(strZ.substring(strZ.indexOf(44)), 0));
        }
        if (U.equals(str2)) {
            return new DrmInitData.SchemeData(g.K1, com.google.android.exoplayer2.offline.a.f17427e, u0.w0(str));
        }
        if (!R.equals(str2) || !"1".equals(strU)) {
            return null;
        }
        String strZ2 = z(str, G0, map);
        byte[] bArrDecode = Base64.decode(strZ2.substring(strZ2.indexOf(44)), 0);
        UUID uuid = g.L1;
        return new DrmInitData.SchemeData(uuid, w.f31182f, l.a(uuid, bArrDecode));
    }

    public static String l(String str) {
        return (P.equals(str) || Q.equals(str)) ? "cenc" : g.G1;
    }

    public static int m(String str, Pattern pattern) throws ParserException {
        return Integer.parseInt(z(str, pattern, Collections.emptyMap()));
    }

    public static long n(String str, Pattern pattern) throws ParserException {
        return Long.parseLong(z(str, pattern, Collections.emptyMap()));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0327  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.exoplayer2.source.hls.playlist.b o(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.a r36, java.lang.String r37) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.o(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser$a, java.lang.String):com.google.android.exoplayer2.source.hls.playlist.b");
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0302 A[PHI: r78
  0x0302: PHI (r78v29 java.lang.String) = (r78v27 java.lang.String), (r78v1 java.lang.String) binds: [B:117:0x0317, B:109:0x02f7] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.exoplayer2.source.hls.playlist.c p(com.google.android.exoplayer2.source.hls.playlist.b r94, @g.p0 com.google.android.exoplayer2.source.hls.playlist.c r95, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.a r96, java.lang.String r97) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1819
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.p(com.google.android.exoplayer2.source.hls.playlist.b, com.google.android.exoplayer2.source.hls.playlist.c, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser$a, java.lang.String):com.google.android.exoplayer2.source.hls.playlist.c");
    }

    public static boolean q(String str, Pattern pattern, boolean z10) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? V.equals(matcher.group(1)) : z10;
    }

    public static double r(String str, Pattern pattern, double d10) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Double.parseDouble((String) hd.a.g(matcher.group(1))) : d10;
    }

    public static int s(String str, Pattern pattern, int i10) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Integer.parseInt((String) hd.a.g(matcher.group(1))) : i10;
    }

    public static long t(String str, Pattern pattern, long j10) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Long.parseLong((String) hd.a.g(matcher.group(1))) : j10;
    }

    public static String u(String str, Pattern pattern, String str2, Map<String, String> map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = (String) hd.a.g(matcher.group(1));
        }
        return (map.isEmpty() || str2 == null) ? str2 : A(str2, map);
    }

    @p0
    public static String v(String str, Pattern pattern, Map<String, String> map) {
        return u(str, pattern, null, map);
    }

    public static int w(String str, Map<String, String> map) {
        String strV = v(str, N0, map);
        if (TextUtils.isEmpty(strV)) {
            return 0;
        }
        String[] strArrN1 = u0.n1(strV, ag.c.f654g);
        int i10 = u0.v(strArrN1, "public.accessibility.describes-video") ? 512 : 0;
        if (u0.v(strArrN1, "public.accessibility.transcribes-spoken-dialog")) {
            i10 |= 4096;
        }
        if (u0.v(strArrN1, "public.accessibility.describes-music-and-sound")) {
            i10 |= 1024;
        }
        return u0.v(strArrN1, "public.easy-to-read") ? i10 | 8192 : i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public static int x(String str) {
        boolean zQ = q(str, Q0, false);
        ?? r02 = zQ;
        if (q(str, R0, false)) {
            r02 = (zQ ? 1 : 0) | 2;
        }
        return q(str, P0, false) ? r02 | 4 : r02;
    }

    public static c.g y(String str) {
        double dR = r(str, f17939n0, -9.223372036854776E18d);
        long j10 = g.f56663b;
        long j11 = dR == -9.223372036854776E18d ? -9223372036854775807L : (long) (dR * 1000000.0d);
        boolean zQ = q(str, f17941o0, false);
        double dR2 = r(str, f17945q0, -9.223372036854776E18d);
        long j12 = dR2 == -9.223372036854776E18d ? -9223372036854775807L : (long) (dR2 * 1000000.0d);
        double dR3 = r(str, f17947r0, -9.223372036854776E18d);
        if (dR3 != -9.223372036854776E18d) {
            j10 = (long) (dR3 * 1000000.0d);
        }
        return new c.g(j11, zQ, j12, j10, q(str, f17949s0, false));
    }

    public static String z(String str, Pattern pattern, Map<String, String> map) throws ParserException {
        String strV = v(str, pattern, map);
        if (strV != null) {
            return strV;
        }
        throw new ParserException("Couldn't match " + pattern.pattern() + " in " + str);
    }

    @Override // com.google.android.exoplayer2.upstream.k.a
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public e a(Uri uri, InputStream inputStream) throws IOException {
        String strTrim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (!b(bufferedReader)) {
                throw new UnrecognizedInputFormatException("Input does not start with the #EXTM3U header.", uri);
            }
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    u0.q(bufferedReader);
                    throw new ParserException("Failed to parse the playlist, could not identify any tags.");
                }
                strTrim = line.trim();
                if (!strTrim.isEmpty()) {
                    if (!strTrim.startsWith(f17930j)) {
                        if (strTrim.startsWith(f17942p) || strTrim.startsWith(f17956w) || strTrim.startsWith(f17954v) || strTrim.startsWith(f17962z) || strTrim.startsWith(B) || strTrim.equals(f17944q) || strTrim.equals(f17946r) || strTrim.equals(f17960y)) {
                            break;
                        }
                        arrayDeque.add(strTrim);
                    } else {
                        arrayDeque.add(strTrim);
                        return o(new a(arrayDeque, bufferedReader), uri.toString());
                    }
                }
            }
            arrayDeque.add(strTrim);
            return p(this.f17964a, this.f17965b, new a(arrayDeque, bufferedReader), uri.toString());
        } finally {
            u0.q(bufferedReader);
        }
    }

    public HlsPlaylistParser(b bVar, @p0 c cVar) {
        this.f17964a = bVar;
        this.f17965b = cVar;
    }
}
