package w;

import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f53414c = "cubic(0.4, 0.0, 0.2, 1)";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f53415d = "cubic(0.4, 0.05, 0.8, 0.7)";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f53416e = "cubic(0.0, 0.0, 0.2, 0.95)";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f53417f = "cubic(1, 1, 0, 0)";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f53418g = "cubic(0.36, 0, 0.66, -0.56)";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f53419h = "cubic(0.34, 1.56, 0.64, 1)";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f53424m = "anticipate";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f53425n = "overshoot";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f53427a = HlsPlaylistParser.S;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static d f53413b = new d();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f53422k = "standard";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f53421j = "accelerate";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f53420i = "decelerate";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f53423l = "linear";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String[] f53426o = {f53422k, f53421j, f53420i, f53423l};

    public static d c(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new a(str);
        }
        if (str.startsWith("spline")) {
            return new q(str);
        }
        if (str.startsWith("Schlick")) {
            return new n(str);
        }
        switch (str) {
            case "accelerate":
                return new a(f53415d);
            case "decelerate":
                return new a(f53416e);
            case "anticipate":
                return new a(f53418g);
            case "linear":
                return new a(f53417f);
            case "overshoot":
                return new a(f53419h);
            case "standard":
                return new a(f53414c);
            default:
                System.err.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(f53426o));
                return f53413b;
        }
    }

    public double a(double d10) {
        return d10;
    }

    public double b(double d10) {
        return 1.0d;
    }

    public String toString() {
        return this.f53427a;
    }

    public static class a extends d {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static double f53428t = 0.01d;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static double f53429u = 1.0E-4d;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public double f53430p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public double f53431q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public double f53432r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public double f53433s;

        public a(String str) {
            this.f53427a = str;
            int iIndexOf = str.indexOf(40);
            int iIndexOf2 = str.indexOf(44, iIndexOf);
            this.f53430p = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
            int i10 = iIndexOf2 + 1;
            int iIndexOf3 = str.indexOf(44, i10);
            this.f53431q = Double.parseDouble(str.substring(i10, iIndexOf3).trim());
            int i11 = iIndexOf3 + 1;
            int iIndexOf4 = str.indexOf(44, i11);
            this.f53432r = Double.parseDouble(str.substring(i11, iIndexOf4).trim());
            int i12 = iIndexOf4 + 1;
            this.f53433s = Double.parseDouble(str.substring(i12, str.indexOf(41, i12)).trim());
        }

        @Override // w.d
        public double a(double d10) {
            if (d10 <= 0.0d) {
                return 0.0d;
            }
            if (d10 >= 1.0d) {
                return 1.0d;
            }
            double d11 = 0.5d;
            double d12 = 0.5d;
            while (d11 > f53428t) {
                d11 *= 0.5d;
                d12 = f(d12) < d10 ? d12 + d11 : d12 - d11;
            }
            double d13 = d12 - d11;
            double dF = f(d13);
            double d14 = d12 + d11;
            double dF2 = f(d14);
            double dG = g(d13);
            return (((g(d14) - dG) * (d10 - dF)) / (dF2 - dF)) + dG;
        }

        @Override // w.d
        public double b(double d10) {
            double d11 = 0.5d;
            double d12 = 0.5d;
            while (d11 > f53429u) {
                d11 *= 0.5d;
                d12 = f(d12) < d10 ? d12 + d11 : d12 - d11;
            }
            double d13 = d12 - d11;
            double d14 = d12 + d11;
            return (g(d14) - g(d13)) / (f(d14) - f(d13));
        }

        public final double d(double d10) {
            double d11 = 1.0d - d10;
            double d12 = this.f53430p;
            double d13 = this.f53432r;
            return (d11 * 3.0d * d11 * d12) + (d11 * 6.0d * d10 * (d13 - d12)) + (3.0d * d10 * d10 * (1.0d - d13));
        }

        public final double e(double d10) {
            double d11 = 1.0d - d10;
            double d12 = this.f53431q;
            double d13 = this.f53433s;
            return (d11 * 3.0d * d11 * d12) + (d11 * 6.0d * d10 * (d13 - d12)) + (3.0d * d10 * d10 * (1.0d - d13));
        }

        public final double f(double d10) {
            double d11 = 1.0d - d10;
            double d12 = 3.0d * d11;
            return (this.f53430p * d11 * d12 * d10) + (this.f53432r * d12 * d10 * d10) + (d10 * d10 * d10);
        }

        public final double g(double d10) {
            double d11 = 1.0d - d10;
            double d12 = 3.0d * d11;
            return (this.f53431q * d11 * d12 * d10) + (this.f53433s * d12 * d10 * d10) + (d10 * d10 * d10);
        }

        public void h(double d10, double d11, double d12, double d13) {
            this.f53430p = d10;
            this.f53431q = d11;
            this.f53432r = d12;
            this.f53433s = d13;
        }

        public a(double d10, double d11, double d12, double d13) {
            h(d10, d11, d12, d13);
        }
    }
}
