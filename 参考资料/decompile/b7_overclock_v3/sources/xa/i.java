package xa;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.data.CandleEntry;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f55000c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Matrix f54998a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Matrix f54999b = new Matrix();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f55001d = new float[1];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f55002e = new float[1];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f55003f = new float[1];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f55004g = new float[1];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Matrix f55005h = new Matrix();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float[] f55006i = new float[2];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Matrix f55007j = new Matrix();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Matrix f55008k = new Matrix();

    public i(l lVar) {
        this.f55000c = lVar;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.github.mikephil.charting.data.Entry, la.f] */
    public float[] a(qa.c cVar, float f10, int i10, int i11) {
        int i12 = ((i11 - i10) + 1) * 2;
        if (this.f55002e.length != i12) {
            this.f55002e = new float[i12];
        }
        float[] fArr = this.f55002e;
        for (int i13 = 0; i13 < i12; i13 += 2) {
            ?? Z = cVar.Z((i13 / 2) + i10);
            if (Z != 0) {
                fArr[i13] = Z.F();
                fArr[i13 + 1] = Z.e() * f10;
            } else {
                fArr[i13] = 0.0f;
                fArr[i13 + 1] = 0.0f;
            }
        }
        i().mapPoints(fArr);
        return fArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public float[] b(qa.d dVar, float f10, float f11, int i10, int i11) {
        int i12 = ((int) (((i11 - i10) * f10) + 1.0f)) * 2;
        if (this.f55004g.length != i12) {
            this.f55004g = new float[i12];
        }
        float[] fArr = this.f55004g;
        for (int i13 = 0; i13 < i12; i13 += 2) {
            CandleEntry candleEntry = (CandleEntry) dVar.Z((i13 / 2) + i10);
            if (candleEntry != null) {
                fArr[i13] = candleEntry.F();
                fArr[i13 + 1] = candleEntry.V() * f11;
            } else {
                fArr[i13] = 0.0f;
                fArr[i13 + 1] = 0.0f;
            }
        }
        i().mapPoints(fArr);
        return fArr;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.github.mikephil.charting.data.Entry, la.f] */
    public float[] c(qa.f fVar, float f10, float f11, int i10, int i11) {
        int i12 = (((int) ((i11 - i10) * f10)) + 1) * 2;
        if (this.f55003f.length != i12) {
            this.f55003f = new float[i12];
        }
        float[] fArr = this.f55003f;
        for (int i13 = 0; i13 < i12; i13 += 2) {
            ?? Z = fVar.Z((i13 / 2) + i10);
            if (Z != 0) {
                fArr[i13] = Z.F();
                fArr[i13 + 1] = Z.e() * f11;
            } else {
                fArr[i13] = 0.0f;
                fArr[i13 + 1] = 0.0f;
            }
        }
        i().mapPoints(fArr);
        return fArr;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.github.mikephil.charting.data.Entry, la.f] */
    public float[] d(qa.k kVar, float f10, float f11, int i10, int i11) {
        int i12 = ((int) (((i11 - i10) * f10) + 1.0f)) * 2;
        if (this.f55001d.length != i12) {
            this.f55001d = new float[i12];
        }
        float[] fArr = this.f55001d;
        for (int i13 = 0; i13 < i12; i13 += 2) {
            ?? Z = kVar.Z((i13 / 2) + i10);
            if (Z != 0) {
                fArr[i13] = Z.F();
                fArr[i13 + 1] = Z.e() * f11;
            } else {
                fArr[i13] = 0.0f;
                fArr[i13 + 1] = 0.0f;
            }
        }
        i().mapPoints(fArr);
        return fArr;
    }

    public Matrix e() {
        return this.f54999b;
    }

    public f f(float f10, float f11) {
        float[] fArr = this.f55006i;
        fArr[0] = f10;
        fArr[1] = f11;
        o(fArr);
        float[] fArr2 = this.f55006i;
        return f.b(fArr2[0], fArr2[1]);
    }

    public Matrix g() {
        i().invert(this.f55008k);
        return this.f55008k;
    }

    public Matrix h() {
        return this.f54998a;
    }

    public Matrix i() {
        this.f55007j.set(this.f54998a);
        this.f55007j.postConcat(this.f55000c.f55024a);
        this.f55007j.postConcat(this.f54999b);
        return this.f55007j;
    }

    public f j(float f10, float f11) {
        f fVarB = f.b(0.0d, 0.0d);
        k(f10, f11, fVarB);
        return fVarB;
    }

    public void k(float f10, float f11, f fVar) {
        float[] fArr = this.f55006i;
        fArr[0] = f10;
        fArr[1] = f11;
        n(fArr);
        float[] fArr2 = this.f55006i;
        fVar.f54983c = fArr2[0];
        fVar.f54984d = fArr2[1];
    }

    public void l(Path path) {
        path.transform(this.f54998a);
        path.transform(this.f55000c.r());
        path.transform(this.f54999b);
    }

    public void m(List<Path> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            l(list.get(i10));
        }
    }

    public void n(float[] fArr) {
        Matrix matrix = this.f55005h;
        matrix.reset();
        this.f54999b.invert(matrix);
        matrix.mapPoints(fArr);
        this.f55000c.r().invert(matrix);
        matrix.mapPoints(fArr);
        this.f54998a.invert(matrix);
        matrix.mapPoints(fArr);
    }

    public void o(float[] fArr) {
        this.f54998a.mapPoints(fArr);
        this.f55000c.r().mapPoints(fArr);
        this.f54999b.mapPoints(fArr);
    }

    public void p(boolean z10) {
        this.f54999b.reset();
        if (!z10) {
            this.f54999b.postTranslate(this.f55000c.P(), this.f55000c.n() - this.f55000c.O());
        } else {
            this.f54999b.setTranslate(this.f55000c.P(), -this.f55000c.R());
            this.f54999b.postScale(1.0f, -1.0f);
        }
    }

    public void q(float f10, float f11, float f12, float f13) {
        float fK = this.f55000c.k() / f11;
        float fG = this.f55000c.g() / f12;
        if (Float.isInfinite(fK)) {
            fK = 0.0f;
        }
        if (Float.isInfinite(fG)) {
            fG = 0.0f;
        }
        this.f54998a.reset();
        this.f54998a.postTranslate(-f10, -f13);
        this.f54998a.postScale(fK, -fG);
    }

    public void r(RectF rectF, float f10) {
        rectF.top *= f10;
        rectF.bottom *= f10;
        this.f54998a.mapRect(rectF);
        this.f55000c.r().mapRect(rectF);
        this.f54999b.mapRect(rectF);
    }

    public void s(RectF rectF, float f10) {
        rectF.left *= f10;
        rectF.right *= f10;
        this.f54998a.mapRect(rectF);
        this.f55000c.r().mapRect(rectF);
        this.f54999b.mapRect(rectF);
    }

    public void t(RectF rectF) {
        this.f54998a.mapRect(rectF);
        this.f55000c.r().mapRect(rectF);
        this.f54999b.mapRect(rectF);
    }

    public void u(RectF rectF) {
        this.f54998a.mapRect(rectF);
        this.f55000c.r().mapRect(rectF);
        this.f54999b.mapRect(rectF);
    }

    public void v(RectF rectF, float f10) {
        rectF.left *= f10;
        rectF.right *= f10;
        this.f54998a.mapRect(rectF);
        this.f55000c.r().mapRect(rectF);
        this.f54999b.mapRect(rectF);
    }

    public void w(List<RectF> list) {
        Matrix matrixI = i();
        for (int i10 = 0; i10 < list.size(); i10++) {
            matrixI.mapRect(list.get(i10));
        }
    }
}
