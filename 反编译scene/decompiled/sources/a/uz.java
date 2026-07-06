package a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class uz extends yz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f7643a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final wz f3222a;
    public final float b;

    public uz(wz wzVar, float f, float f2) {
        this.f3222a = wzVar;
        this.f7643a = f;
        this.b = f2;
    }

    @Override // a.yz
    public void a(Matrix matrix, xy xyVar, int i, Canvas canvas) {
        RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f3222a.b - this.b, this.f3222a.f7836a - this.f7643a), 0.0f);
        Matrix matrix2 = new Matrix(matrix);
        matrix2.preTranslate(this.f7643a, this.b);
        matrix2.preRotate(c());
        xyVar.b(canvas, matrix2, rectF, i);
    }

    public float c() {
        return (float) Math.toDegrees(Math.atan((this.f3222a.b - this.b) / (this.f3222a.f7836a - this.f7643a)));
    }
}
