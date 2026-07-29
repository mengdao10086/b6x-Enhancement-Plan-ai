package jd;

import android.opengl.Matrix;
import hd.o0;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f36320a = new float[16];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f36321b = new float[16];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o0<float[]> f36322c = new o0<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f36323d;

    public static void a(float[] fArr, float[] fArr2) {
        Matrix.setIdentityM(fArr, 0);
        float fSqrt = (float) Math.sqrt((fArr2[10] * fArr2[10]) + (fArr2[8] * fArr2[8]));
        fArr[0] = fArr2[10] / fSqrt;
        fArr[2] = fArr2[8] / fSqrt;
        fArr[8] = (-fArr2[8]) / fSqrt;
        fArr[10] = fArr2[10] / fSqrt;
    }

    public static void b(float[] fArr, float[] fArr2) {
        float f10 = fArr2[0];
        float f11 = -fArr2[1];
        float f12 = -fArr2[2];
        float length = Matrix.length(f10, f11, f12);
        if (length != 0.0f) {
            Matrix.setRotateM(fArr, 0, (float) Math.toDegrees(length), f10 / length, f11 / length, f12 / length);
        } else {
            Matrix.setIdentityM(fArr, 0);
        }
    }

    public boolean c(float[] fArr, long j10) {
        float[] fArrJ = this.f36322c.j(j10);
        if (fArrJ == null) {
            return false;
        }
        b(this.f36321b, fArrJ);
        if (!this.f36323d) {
            a(this.f36320a, this.f36321b);
            this.f36323d = true;
        }
        Matrix.multiplyMM(fArr, 0, this.f36320a, 0, this.f36321b, 0);
        return true;
    }

    public void d() {
        this.f36322c.c();
        this.f36323d = false;
    }

    public void e(long j10, float[] fArr) {
        this.f36322c.a(j10, fArr);
    }
}
