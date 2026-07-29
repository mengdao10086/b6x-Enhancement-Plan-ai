package m0;

import android.graphics.Matrix;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nMatrix.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Matrix.kt\nandroidx/core/graphics/MatrixKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,54:1\n1#2:55\n*E\n"})
public final class j {
    @yt.k
    public static final Matrix a(float f10, float f11, float f12) {
        Matrix matrix = new Matrix();
        matrix.setRotate(f10, f11, f12);
        return matrix;
    }

    public static /* synthetic */ Matrix b(float f10, float f11, float f12, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        if ((i10 & 4) != 0) {
            f12 = 0.0f;
        }
        return a(f10, f11, f12);
    }

    @yt.k
    public static final Matrix c(float f10, float f11) {
        Matrix matrix = new Matrix();
        matrix.setScale(f10, f11);
        return matrix;
    }

    public static /* synthetic */ Matrix d(float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 1.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 1.0f;
        }
        return c(f10, f11);
    }

    @yt.k
    public static final Matrix e(@yt.k Matrix matrix, @yt.k Matrix m10) {
        kotlin.jvm.internal.f0.p(matrix, "<this>");
        kotlin.jvm.internal.f0.p(m10, "m");
        Matrix matrix2 = new Matrix(matrix);
        matrix2.preConcat(m10);
        return matrix2;
    }

    @yt.k
    public static final Matrix f(float f10, float f11) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(f10, f11);
        return matrix;
    }

    public static /* synthetic */ Matrix g(float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        return f(f10, f11);
    }

    @yt.k
    public static final float[] h(@yt.k Matrix matrix) {
        kotlin.jvm.internal.f0.p(matrix, "<this>");
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return fArr;
    }
}
