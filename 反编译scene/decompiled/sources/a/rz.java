package a;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class rz {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zz[] f2806a = new zz[4];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Matrix[] f2807a = new Matrix[4];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Matrix[] f2809b = new Matrix[4];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PointF f2803a = new PointF();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Path f2802a = new Path();
    public final Path b = new Path();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zz f7344a = new zz();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float[] f2805a = new float[2];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final float[] f2808b = new float[2];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2804a = true;

    public rz() {
        for (int i = 0; i < 4; i++) {
            this.f2806a[i] = new zz();
            this.f2807a[i] = new Matrix();
            this.f2809b[i] = new Matrix();
        }
    }

    public final float a(int i) {
        return (i + 1) * 90;
    }

    public final void b(qz qzVar, int i) {
        this.f2805a[0] = this.f2806a[i].k();
        this.f2805a[1] = this.f2806a[i].l();
        this.f2807a[i].mapPoints(this.f2805a);
        Path path = qzVar.f2666a;
        float[] fArr = this.f2805a;
        if (i == 0) {
            path.moveTo(fArr[0], fArr[1]);
        } else {
            path.lineTo(fArr[0], fArr[1]);
        }
        this.f2806a[i].d(this.f2807a[i], qzVar.f2666a);
        pz pzVar = qzVar.f2665a;
        if (pzVar != null) {
            pzVar.a(this.f2806a[i], this.f2807a[i], i);
        }
    }

    public final void c(qz qzVar, int i) {
        zz zzVar;
        Matrix matrix;
        Path path;
        int i2 = (i + 1) % 4;
        this.f2805a[0] = this.f2806a[i].i();
        this.f2805a[1] = this.f2806a[i].j();
        this.f2807a[i].mapPoints(this.f2805a);
        this.f2808b[0] = this.f2806a[i2].k();
        this.f2808b[1] = this.f2806a[i2].l();
        this.f2807a[i2].mapPoints(this.f2808b);
        float f = this.f2805a[0];
        float[] fArr = this.f2808b;
        float fMax = Math.max(((float) Math.hypot(f - fArr[0], r1[1] - fArr[1])) - 0.001f, 0.0f);
        float fI = i(qzVar.f2667a, i);
        this.f7344a.n(0.0f, 0.0f);
        ez ezVarJ = j(i, qzVar.f2664a);
        ezVarJ.b(fMax, fI, qzVar.f7252a, this.f7344a);
        Path path2 = new Path();
        this.f7344a.d(this.f2809b[i], path2);
        if (this.f2804a && Build.VERSION.SDK_INT >= 19 && (ezVarJ.a() || k(path2, i) || k(path2, i2))) {
            path2.op(path2, this.b, Path.Op.DIFFERENCE);
            this.f2805a[0] = this.f7344a.k();
            this.f2805a[1] = this.f7344a.l();
            this.f2809b[i].mapPoints(this.f2805a);
            Path path3 = this.f2802a;
            float[] fArr2 = this.f2805a;
            path3.moveTo(fArr2[0], fArr2[1]);
            zzVar = this.f7344a;
            matrix = this.f2809b[i];
            path = this.f2802a;
        } else {
            zzVar = this.f7344a;
            matrix = this.f2809b[i];
            path = qzVar.f2666a;
        }
        zzVar.d(matrix, path);
        pz pzVar = qzVar.f2665a;
        if (pzVar != null) {
            pzVar.b(this.f7344a, this.f2809b[i], i);
        }
    }

    public void d(nz nzVar, float f, RectF rectF, Path path) {
        e(nzVar, f, rectF, null, path);
    }

    public void e(nz nzVar, float f, RectF rectF, pz pzVar, Path path) {
        path.rewind();
        this.f2802a.rewind();
        this.b.rewind();
        this.b.addRect(rectF, Path.Direction.CW);
        qz qzVar = new qz(nzVar, f, rectF, pzVar, path);
        for (int i = 0; i < 4; i++) {
            l(qzVar, i);
            m(i);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            b(qzVar, i2);
            c(qzVar, i2);
        }
        path.close();
        this.f2802a.close();
        if (Build.VERSION.SDK_INT < 19 || this.f2802a.isEmpty()) {
            return;
        }
        path.op(this.f2802a, Path.Op.UNION);
    }

    public final void f(int i, RectF rectF, PointF pointF) {
        float f;
        float f2;
        if (i == 1) {
            f = rectF.right;
        } else {
            if (i != 2) {
                f = i != 3 ? rectF.right : rectF.left;
                f2 = rectF.top;
                pointF.set(f, f2);
            }
            f = rectF.left;
        }
        f2 = rectF.bottom;
        pointF.set(f, f2);
    }

    public final bz g(int i, nz nzVar) {
        return i != 1 ? i != 2 ? i != 3 ? nzVar.r() : nzVar.p() : nzVar.h() : nzVar.j();
    }

    public final cz h(int i, nz nzVar) {
        return i != 1 ? i != 2 ? i != 3 ? nzVar.q() : nzVar.o() : nzVar.g() : nzVar.i();
    }

    public final float i(RectF rectF, int i) {
        float fCenterX;
        float f;
        float[] fArr = this.f2805a;
        zz[] zzVarArr = this.f2806a;
        fArr[0] = zzVarArr[i].c;
        fArr[1] = zzVarArr[i].d;
        this.f2807a[i].mapPoints(fArr);
        if (i == 1 || i == 3) {
            fCenterX = rectF.centerX();
            f = this.f2805a[0];
        } else {
            fCenterX = rectF.centerY();
            f = this.f2805a[1];
        }
        return Math.abs(fCenterX - f);
    }

    public final ez j(int i, nz nzVar) {
        return i != 1 ? i != 2 ? i != 3 ? nzVar.m() : nzVar.n() : nzVar.l() : nzVar.f();
    }

    public final boolean k(Path path, int i) {
        Path path2 = new Path();
        this.f2806a[i].d(this.f2807a[i], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    public final void l(qz qzVar, int i) {
        h(i, qzVar.f2664a).b(this.f2806a[i], 90.0f, qzVar.f7252a, qzVar.f2667a, g(i, qzVar.f2664a));
        float fA = a(i);
        this.f2807a[i].reset();
        f(i, qzVar.f2667a, this.f2803a);
        Matrix matrix = this.f2807a[i];
        PointF pointF = this.f2803a;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f2807a[i].preRotate(fA);
    }

    public final void m(int i) {
        this.f2805a[0] = this.f2806a[i].i();
        this.f2805a[1] = this.f2806a[i].j();
        this.f2807a[i].mapPoints(this.f2805a);
        float fA = a(i);
        this.f2809b[i].reset();
        Matrix matrix = this.f2809b[i];
        float[] fArr = this.f2805a;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f2809b[i].preRotate(fA);
    }
}
