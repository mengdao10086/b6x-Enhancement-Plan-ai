package a;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class vz extends xz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RectF f7736a = new RectF();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Deprecated
    public float f3314a;

    @Deprecated
    public float b;

    @Deprecated
    public float c;

    @Deprecated
    public float d;

    @Deprecated
    public float e;

    @Deprecated
    public float f;

    public vz(float f, float f2, float f3, float f4) {
        q(f);
        u(f2);
        r(f3);
        p(f4);
    }

    @Override // a.xz
    public void a(Matrix matrix, Path path) {
        Matrix matrix2 = super.f7932a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        f7736a.set(k(), o(), l(), j());
        path.arcTo(f7736a, m(), n(), false);
        path.transform(matrix);
    }

    public final float j() {
        return this.d;
    }

    public final float k() {
        return this.f3314a;
    }

    public final float l() {
        return this.c;
    }

    public final float m() {
        return this.e;
    }

    public final float n() {
        return this.f;
    }

    public final float o() {
        return this.b;
    }

    public final void p(float f) {
        this.d = f;
    }

    public final void q(float f) {
        this.f3314a = f;
    }

    public final void r(float f) {
        this.c = f;
    }

    public final void s(float f) {
        this.e = f;
    }

    public final void t(float f) {
        this.f = f;
    }

    public final void u(float f) {
        this.b = f;
    }
}
