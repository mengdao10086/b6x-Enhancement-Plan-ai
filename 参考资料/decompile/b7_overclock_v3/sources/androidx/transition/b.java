package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import g.n0;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes2.dex */
public class b extends g2.k {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final float f7811g = 0.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final float f7812h = 70.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final float f7813i = (float) Math.tan(Math.toRadians(35.0d));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f7814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f7815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f7816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f7817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f7818e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f7819f;

    public b() {
        this.f7814a = 0.0f;
        this.f7815b = 0.0f;
        this.f7816c = 70.0f;
        this.f7817d = 0.0f;
        this.f7818e = 0.0f;
        this.f7819f = f7813i;
    }

    public static float h(float f10) {
        if (f10 < 0.0f || f10 > 90.0f) {
            throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
        }
        return (float) Math.tan(Math.toRadians(f10 / 2.0f));
    }

    @Override // g2.k
    @n0
    public Path a(float f10, float f11, float f12, float f13) {
        float f14;
        float f15;
        float f16;
        Path path = new Path();
        path.moveTo(f10, f11);
        float f17 = f12 - f10;
        float f18 = f13 - f11;
        float f19 = (f17 * f17) + (f18 * f18);
        float f20 = (f10 + f12) / 2.0f;
        float f21 = (f11 + f13) / 2.0f;
        float f22 = 0.25f * f19;
        boolean z10 = f11 > f13;
        if (Math.abs(f17) < Math.abs(f18)) {
            float fAbs = Math.abs(f19 / (f18 * 2.0f));
            if (z10) {
                f15 = fAbs + f13;
                f14 = f12;
            } else {
                f15 = fAbs + f11;
                f14 = f10;
            }
            f16 = this.f7818e;
        } else {
            float f23 = f19 / (f17 * 2.0f);
            if (z10) {
                f15 = f11;
                f14 = f23 + f10;
            } else {
                f14 = f12 - f23;
                f15 = f13;
            }
            f16 = this.f7817d;
        }
        float f24 = f22 * f16 * f16;
        float f25 = f20 - f14;
        float f26 = f21 - f15;
        float f27 = (f25 * f25) + (f26 * f26);
        float f28 = this.f7819f;
        float f29 = f22 * f28 * f28;
        if (f27 >= f24) {
            f24 = f27 > f29 ? f29 : 0.0f;
        }
        if (f24 != 0.0f) {
            float fSqrt = (float) Math.sqrt(f24 / f27);
            f14 = ((f14 - f20) * fSqrt) + f20;
            f15 = f21 + (fSqrt * (f15 - f21));
        }
        path.cubicTo((f10 + f14) / 2.0f, (f11 + f15) / 2.0f, (f14 + f12) / 2.0f, (f15 + f13) / 2.0f, f12, f13);
        return path;
    }

    public float b() {
        return this.f7816c;
    }

    public float c() {
        return this.f7814a;
    }

    public float d() {
        return this.f7815b;
    }

    public void e(float f10) {
        this.f7816c = f10;
        this.f7819f = h(f10);
    }

    public void f(float f10) {
        this.f7814a = f10;
        this.f7817d = h(f10);
    }

    public void g(float f10) {
        this.f7815b = f10;
        this.f7818e = h(f10);
    }

    @SuppressLint({"RestrictedApi"})
    public b(@n0 Context context, @n0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7814a = 0.0f;
        this.f7815b = 0.0f;
        this.f7816c = 70.0f;
        this.f7817d = 0.0f;
        this.f7818e = 0.0f;
        this.f7819f = f7813i;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.f7927j);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        g(j0.n.j(typedArrayObtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        f(j0.n.j(typedArrayObtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        e(j0.n.j(typedArrayObtainStyledAttributes, xmlPullParser, "maximumAngle", 2, 70.0f));
        typedArrayObtainStyledAttributes.recycle();
    }
}
