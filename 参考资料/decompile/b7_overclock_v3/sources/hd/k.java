package hd;

import android.net.Uri;
import g.i1;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class k {
    public static final String A = ".webm";
    public static final String B = ".og";
    public static final String C = ".opus";
    public static final String D = ".mp3";
    public static final String E = ".mp4";
    public static final String F = ".m4";
    public static final String G = ".mp4";
    public static final String H = ".cmf";
    public static final String I = ".ps";
    public static final String J = ".mpeg";
    public static final String K = ".mpg";
    public static final String L = ".m2p";
    public static final String M = ".ts";
    public static final String N = ".ts";
    public static final String O = ".wav";
    public static final String P = ".wave";
    public static final String Q = ".vtt";
    public static final String R = ".webvtt";
    public static final String S = ".jpg";
    public static final String T = ".jpeg";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31023a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f31024b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f31025c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f31026d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f31027e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f31028f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f31029g = 5;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f31030h = 6;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f31031i = 7;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f31032j = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f31033k = 9;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f31034l = 10;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f31035m = 11;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f31036n = 12;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f31037o = 13;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f31038p = 14;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @i1
    public static final String f31039q = "Content-Type";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f31040r = ".ac3";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f31041s = ".ec3";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f31042t = ".ac4";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f31043u = ".adts";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f31044v = ".aac";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f31045w = ".amr";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f31046x = ".flac";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f31047y = ".flv";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f31048z = ".mk";

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(@g.p0 java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: hd.k.a(java.lang.String):int");
    }

    public static int b(Map<String, List<String>> map) {
        List<String> list = map.get("Content-Type");
        return a((list == null || list.isEmpty()) ? null : list.get(0));
    }

    public static int c(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(f31040r) || lastPathSegment.endsWith(f31041s)) {
            return 0;
        }
        if (lastPathSegment.endsWith(f31042t)) {
            return 1;
        }
        if (lastPathSegment.endsWith(f31043u) || lastPathSegment.endsWith(f31044v)) {
            return 2;
        }
        if (lastPathSegment.endsWith(f31045w)) {
            return 3;
        }
        if (lastPathSegment.endsWith(f31046x)) {
            return 4;
        }
        if (lastPathSegment.endsWith(f31047y)) {
            return 5;
        }
        if (lastPathSegment.startsWith(f31048z, lastPathSegment.length() - 4) || lastPathSegment.endsWith(A)) {
            return 6;
        }
        if (lastPathSegment.endsWith(D)) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(F, lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(H, lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(B, lastPathSegment.length() - 4) || lastPathSegment.endsWith(C)) {
            return 9;
        }
        if (lastPathSegment.endsWith(I) || lastPathSegment.endsWith(J) || lastPathSegment.endsWith(K) || lastPathSegment.endsWith(L)) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(O) || lastPathSegment.endsWith(P)) {
            return 12;
        }
        if (lastPathSegment.endsWith(Q) || lastPathSegment.endsWith(R)) {
            return 13;
        }
        return (lastPathSegment.endsWith(S) || lastPathSegment.endsWith(T)) ? 14 : -1;
    }
}
