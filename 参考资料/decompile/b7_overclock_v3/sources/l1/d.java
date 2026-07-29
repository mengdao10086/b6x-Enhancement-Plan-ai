package l1;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f39338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f39339b;

    public d(float[] fArr) {
        this.f39338a = fArr;
        this.f39339b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        if (f10 >= 1.0f) {
            return 1.0f;
        }
        if (f10 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f39338a;
        int iMin = Math.min((int) ((fArr.length - 1) * f10), fArr.length - 2);
        float f11 = this.f39339b;
        float f12 = (f10 - (iMin * f11)) / f11;
        float[] fArr2 = this.f39338a;
        return fArr2[iMin] + (f12 * (fArr2[iMin + 1] - fArr2[iMin]));
    }
}
