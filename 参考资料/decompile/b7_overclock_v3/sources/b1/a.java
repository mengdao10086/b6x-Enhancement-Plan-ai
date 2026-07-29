package b1;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Interpolator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f9007c = 0.002f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f9008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f9009b;

    public a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i10 = ((int) (length / 0.002f)) + 1;
        this.f9008a = new float[i10];
        this.f9009b = new float[i10];
        float[] fArr = new float[2];
        for (int i11 = 0; i11 < i10; i11++) {
            pathMeasure.getPosTan((i11 * length) / (i10 - 1), fArr, null);
            this.f9008a[i11] = fArr[0];
            this.f9009b[i11] = fArr[1];
        }
    }

    public static Path a(float f10, float f11, float f12, float f13) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f10, f11, f12, f13, 1.0f, 1.0f);
        return path;
    }

    public static Path b(float f10, float f11) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f10, f11, 1.0f, 1.0f);
        return path;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        if (f10 <= 0.0f) {
            return 0.0f;
        }
        if (f10 >= 1.0f) {
            return 1.0f;
        }
        int i10 = 0;
        int length = this.f9008a.length - 1;
        while (length - i10 > 1) {
            int i11 = (i10 + length) / 2;
            if (f10 < this.f9008a[i11]) {
                length = i11;
            } else {
                i10 = i11;
            }
        }
        float[] fArr = this.f9008a;
        float f11 = fArr[length] - fArr[i10];
        if (f11 == 0.0f) {
            return this.f9009b[i10];
        }
        float f12 = (f10 - fArr[i10]) / f11;
        float[] fArr2 = this.f9009b;
        float f13 = fArr2[i10];
        return f13 + (f12 * (fArr2[length] - f13));
    }

    public a(float f10, float f11) {
        this(b(f10, f11));
    }

    public a(float f10, float f11, float f12, float f13) {
        this(a(f10, f11, f12, f13));
    }
}
