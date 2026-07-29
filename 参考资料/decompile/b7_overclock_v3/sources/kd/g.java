package kd;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import g.n0;

/* JADX INFO: loaded from: classes3.dex */
public class g implements TypeEvaluator<Matrix> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f37176a = new float[9];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f37177b = new float[9];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f37178c = new Matrix();

    @Override // android.animation.TypeEvaluator
    @n0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix evaluate(float f10, @n0 Matrix matrix, @n0 Matrix matrix2) {
        matrix.getValues(this.f37176a);
        matrix2.getValues(this.f37177b);
        for (int i10 = 0; i10 < 9; i10++) {
            float[] fArr = this.f37177b;
            float f11 = fArr[i10];
            float[] fArr2 = this.f37176a;
            fArr[i10] = fArr2[i10] + ((f11 - fArr2[i10]) * f10);
        }
        this.f37178c.setValues(this.f37177b);
        return this.f37178c;
    }
}
