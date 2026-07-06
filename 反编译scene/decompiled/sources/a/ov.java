package a;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ov implements TypeEvaluator<Matrix> {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float[] f2304a = new float[9];
    public final float[] b = new float[9];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f7057a = new Matrix();

    public Matrix a(float f, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f2304a);
        matrix2.getValues(this.b);
        for (int i = 0; i < 9; i++) {
            float[] fArr = this.b;
            float f2 = fArr[i];
            float[] fArr2 = this.f2304a;
            fArr[i] = fArr2[i] + ((f2 - fArr2[i]) * f);
        }
        this.f7057a.setValues(this.b);
        return this.f7057a;
    }
}
