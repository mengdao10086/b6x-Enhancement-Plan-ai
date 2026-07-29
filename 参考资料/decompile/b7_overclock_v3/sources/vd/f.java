package vd;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float[] f53063a = {95.047f, 100.0f, 108.883f};

    public static int a(int i10) {
        return i10 & 255;
    }

    public static float b(float f10) {
        return f10 <= 0.0031308f ? f10 * 12.92f : (((float) Math.pow(f10, 0.4166666567325592d)) * 1.055f) - 0.055f;
    }

    public static int c(int i10) {
        return (i10 & 65280) >> 8;
    }

    public static String d(int i10) {
        return String.format("#%02x%02x%02x", Integer.valueOf(m(i10)), Integer.valueOf(c(i10)), Integer.valueOf(a(i10)));
    }

    public static int e(double d10, double d11, double d12) {
        double d13 = (d10 + 16.0d) / 116.0d;
        double d14 = (d11 / 500.0d) + d13;
        double d15 = d13 - (d12 / 200.0d);
        double d16 = d14 * d14 * d14;
        if (d16 <= 0.008856451679035631d) {
            d16 = ((d14 * 116.0d) - 16.0d) / 903.2962962962963d;
        }
        double d17 = d10 > 8.0d ? d13 * d13 * d13 : d10 / 903.2962962962963d;
        double d18 = d15 * d15 * d15;
        if (d18 <= 0.008856451679035631d) {
            d18 = ((d15 * 116.0d) - 16.0d) / 903.2962962962963d;
        }
        float[] fArr = f53063a;
        return i((float) (d16 * ((double) fArr[0])), (float) (d17 * ((double) fArr[1])), (float) (d18 * ((double) fArr[2])));
    }

    public static int f(float f10) {
        float f11 = (f10 + 16.0f) / 116.0f;
        float f12 = f11 * f11 * f11;
        boolean z10 = f12 > 0.008856452f;
        float f13 = (f10 > 8.0f ? 1 : (f10 == 8.0f ? 0 : -1)) > 0 ? f12 : f10 / 903.2963f;
        float f14 = z10 ? f12 : ((f11 * 116.0f) - 16.0f) / 903.2963f;
        if (!z10) {
            f12 = ((f11 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f53063a;
        return h(new float[]{f14 * fArr[0], f13 * fArr[1], f12 * fArr[2]});
    }

    public static int g(int i10, int i11, int i12) {
        return (((((i10 & 255) << 16) | (-16777216)) | ((i11 & 255) << 8)) | (i12 & 255)) >>> 0;
    }

    public static int h(float[] fArr) {
        return i(fArr[0], fArr[1], fArr[2]);
    }

    public static int i(float f10, float f11, float f12) {
        float f13 = f10 / 100.0f;
        float f14 = f11 / 100.0f;
        float f15 = f12 / 100.0f;
        float f16 = (3.2406f * f13) + ((-1.5372f) * f14) + ((-0.4986f) * f15);
        float f17 = ((-0.9689f) * f13) + (1.8758f * f14) + (0.0415f * f15);
        float f18 = (f13 * 0.0557f) + (f14 * (-0.204f)) + (f15 * 1.057f);
        return g(Math.max(Math.min(255, Math.round(b(f16) * 255.0f)), 0), Math.max(Math.min(255, Math.round(b(f17) * 255.0f)), 0), Math.max(Math.min(255, Math.round(b(f18) * 255.0f)), 0));
    }

    public static double[] j(int i10) {
        float[] fArrO = o(i10);
        float f10 = fArrO[1];
        float[] fArr = f53063a;
        double d10 = f10 / fArr[1];
        double dCbrt = d10 > 0.008856451679035631d ? Math.cbrt(d10) : ((d10 * 903.2962962962963d) + 16.0d) / 116.0d;
        double d11 = fArrO[0] / fArr[0];
        double dCbrt2 = d11 > 0.008856451679035631d ? Math.cbrt(d11) : ((d11 * 903.2962962962963d) + 16.0d) / 116.0d;
        double d12 = fArrO[2] / fArr[2];
        return new double[]{(116.0d * dCbrt) - 16.0d, (dCbrt2 - dCbrt) * 500.0d, (dCbrt - (d12 > 0.008856451679035631d ? Math.cbrt(d12) : ((d12 * 903.2962962962963d) + 16.0d) / 116.0d)) * 200.0d};
    }

    public static float k(float f10) {
        return f10 <= 0.04045f ? f10 / 12.92f : (float) Math.pow((f10 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static float l(int i10) {
        return (float) j(i10)[0];
    }

    public static int m(int i10) {
        return (i10 & 16711680) >> 16;
    }

    public static final float[] n() {
        return Arrays.copyOf(f53063a, 3);
    }

    public static float[] o(int i10) {
        float fK = k(m(i10) / 255.0f) * 100.0f;
        float fK2 = k(c(i10) / 255.0f) * 100.0f;
        float fK3 = k(a(i10) / 255.0f) * 100.0f;
        return new float[]{(0.41233894f * fK) + (0.35762063f * fK2) + (0.18051042f * fK3), (0.2126f * fK) + (0.7152f * fK2) + (0.0722f * fK3), (fK * 0.01932141f) + (fK2 * 0.11916382f) + (fK3 * 0.9503448f)};
    }

    public static float p(float f10) {
        return (f10 > 8.0f ? (float) Math.pow((((double) f10) + 16.0d) / 116.0d, 3.0d) : f10 / 903.2963f) * 100.0f;
    }
}
