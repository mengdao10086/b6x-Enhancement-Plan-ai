package ra;

import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.components.YAxis;
import xa.h;
import xa.i;
import xa.l;

/* JADX INFO: loaded from: classes3.dex */
public class f extends e {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static h<f> f47904m;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f47905i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f47906j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public YAxis.AxisDependency f47907k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Matrix f47908l;

    static {
        h<f> hVarA = h.a(1, new f(null, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null));
        f47904m = hVarA;
        hVarA.l(0.5f);
    }

    public f(l lVar, float f10, float f11, float f12, float f13, i iVar, YAxis.AxisDependency axisDependency, View view) {
        super(lVar, f12, f13, iVar, view);
        this.f47908l = new Matrix();
        this.f47905i = f10;
        this.f47906j = f11;
        this.f47907k = axisDependency;
    }

    public static f d(l lVar, float f10, float f11, float f12, float f13, i iVar, YAxis.AxisDependency axisDependency, View view) {
        f fVar = (f) f47904m.b();
        fVar.f47900e = f12;
        fVar.f47901f = f13;
        fVar.f47905i = f10;
        fVar.f47906j = f11;
        fVar.f47899d = lVar;
        fVar.f47902g = iVar;
        fVar.f47907k = axisDependency;
        fVar.f47903h = view;
        return fVar;
    }

    public static void e(f fVar) {
        f47904m.h(fVar);
    }

    @Override // xa.h.a
    public h.a a() {
        return new f(null, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null);
    }

    @Override // java.lang.Runnable
    public void run() {
        Matrix matrix = this.f47908l;
        this.f47899d.m0(this.f47905i, this.f47906j, matrix);
        this.f47899d.S(matrix, this.f47903h, false);
        float fX = ((ja.b) this.f47903h).e(this.f47907k).I / this.f47899d.x();
        float fW = ((ja.b) this.f47903h).getXAxis().I / this.f47899d.w();
        float[] fArr = this.f47898c;
        fArr[0] = this.f47900e - (fW / 2.0f);
        fArr[1] = this.f47901f + (fX / 2.0f);
        this.f47902g.o(fArr);
        this.f47899d.i0(this.f47898c, matrix);
        this.f47899d.S(matrix, this.f47903h, false);
        ((ja.b) this.f47903h).p();
        this.f47903h.postInvalidate();
        e(this);
    }
}
