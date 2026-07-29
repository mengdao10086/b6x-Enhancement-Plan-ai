package vd;

/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public static float a(float f10, float f11, float f12) {
        return Math.min(Math.max(f12, f10), f11);
    }

    public static float b(float f10, float f11) {
        return 180.0f - Math.abs(Math.abs(f10 - f11) - 180.0f);
    }

    public static float c(float f10, float f11, float f12) {
        return ((1.0f - f12) * f10) + (f12 * f11);
    }

    public static float d(float f10) {
        return f10 < 0.0f ? (f10 % 360.0f) + 360.0f : f10 >= 360.0f ? f10 % 360.0f : f10;
    }

    public static int e(int i10) {
        return i10 < 0 ? (i10 % 360) + 360 : i10 >= 360 ? i10 % 360 : i10;
    }

    public static float f(float f10) {
        return (f10 * 180.0f) / 3.1415927f;
    }

    public static float g(float f10) {
        return (f10 / 180.0f) * 3.1415927f;
    }
}
