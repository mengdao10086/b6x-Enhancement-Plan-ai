package a;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class cn implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f5810a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float[] f432a;

    public cn(float[] fArr) {
        this.f432a = fArr;
        this.f5810a = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f432a;
        int iMin = Math.min((int) ((fArr.length - 1) * f), fArr.length - 2);
        float f2 = this.f5810a;
        float f3 = (f - (iMin * f2)) / f2;
        float[] fArr2 = this.f432a;
        return fArr2[iMin] + (f3 * (fArr2[iMin + 1] - fArr2[iMin]));
    }
}
