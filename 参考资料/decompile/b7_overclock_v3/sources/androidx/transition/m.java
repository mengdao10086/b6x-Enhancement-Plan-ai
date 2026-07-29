package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import g.n0;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes2.dex */
public class m extends g2.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Path f7905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f7906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f7907c;

    public m() {
        Path path = new Path();
        this.f7906b = path;
        this.f7907c = new Matrix();
        path.lineTo(1.0f, 0.0f);
        this.f7905a = path;
    }

    public static float b(float f10, float f11) {
        return (float) Math.sqrt((f10 * f10) + (f11 * f11));
    }

    @Override // g2.k
    @n0
    public Path a(float f10, float f11, float f12, float f13) {
        float f14 = f12 - f10;
        float f15 = f13 - f11;
        float fB = b(f14, f15);
        double dAtan2 = Math.atan2(f15, f14);
        this.f7907c.setScale(fB, fB);
        this.f7907c.postRotate((float) Math.toDegrees(dAtan2));
        this.f7907c.postTranslate(f10, f11);
        Path path = new Path();
        this.f7906b.transform(this.f7907c, path);
        return path;
    }

    public Path c() {
        return this.f7905a;
    }

    public void d(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
        float f10 = fArr[0];
        float f11 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, null);
        float f12 = fArr[0];
        float f13 = fArr[1];
        if (f12 == f10 && f13 == f11) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.f7907c.setTranslate(-f12, -f13);
        float f14 = f10 - f12;
        float f15 = f11 - f13;
        float fB = 1.0f / b(f14, f15);
        this.f7907c.postScale(fB, fB);
        this.f7907c.postRotate((float) Math.toDegrees(-Math.atan2(f15, f14)));
        path.transform(this.f7907c, this.f7906b);
        this.f7905a = path;
    }

    @SuppressLint({"RestrictedApi"})
    public m(@n0 Context context, @n0 AttributeSet attributeSet) {
        this.f7906b = new Path();
        this.f7907c = new Matrix();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.f7928k);
        try {
            String strM = j0.n.m(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (strM != null) {
                d(m0.n.e(strM));
                return;
            }
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public m(Path path) {
        this.f7906b = new Path();
        this.f7907c = new Matrix();
        d(path);
    }
}
