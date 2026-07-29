package le;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.RestrictTo;
import g.h1;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes3.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q[] f39689a = new q[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix[] f39690b = new Matrix[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix[] f39691c = new Matrix[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PointF f39692d = new PointF();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Path f39693e = new Path();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f39694f = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final q f39695g = new q();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f39696h = new float[2];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f39697i = new float[2];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Path f39698j = new Path();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Path f39699k = new Path();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f39700l = true;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f39701a = new p();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface b {
        void a(q qVar, Matrix matrix, int i10);

        void b(q qVar, Matrix matrix, int i10);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public final o f39702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @n0
        public final Path f39703b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @n0
        public final RectF f39704c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public final b f39705d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f39706e;

        public c(@n0 o oVar, float f10, RectF rectF, @p0 b bVar, Path path) {
            this.f39705d = bVar;
            this.f39702a = oVar;
            this.f39706e = f10;
            this.f39704c = rectF;
            this.f39703b = path;
        }
    }

    public p() {
        for (int i10 = 0; i10 < 4; i10++) {
            this.f39689a[i10] = new q();
            this.f39690b[i10] = new Matrix();
            this.f39691c[i10] = new Matrix();
        }
    }

    @h1
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public static p k() {
        return a.f39701a;
    }

    public final float a(int i10) {
        return (i10 + 1) * 90;
    }

    public final void b(@n0 c cVar, int i10) {
        this.f39696h[0] = this.f39689a[i10].l();
        this.f39696h[1] = this.f39689a[i10].m();
        this.f39690b[i10].mapPoints(this.f39696h);
        if (i10 == 0) {
            Path path = cVar.f39703b;
            float[] fArr = this.f39696h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = cVar.f39703b;
            float[] fArr2 = this.f39696h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f39689a[i10].d(this.f39690b[i10], cVar.f39703b);
        b bVar = cVar.f39705d;
        if (bVar != null) {
            bVar.a(this.f39689a[i10], this.f39690b[i10], i10);
        }
    }

    public final void c(@n0 c cVar, int i10) {
        int i11 = (i10 + 1) % 4;
        this.f39696h[0] = this.f39689a[i10].j();
        this.f39696h[1] = this.f39689a[i10].k();
        this.f39690b[i10].mapPoints(this.f39696h);
        this.f39697i[0] = this.f39689a[i11].l();
        this.f39697i[1] = this.f39689a[i11].m();
        this.f39690b[i11].mapPoints(this.f39697i);
        float f10 = this.f39696h[0];
        float[] fArr = this.f39697i;
        float fMax = Math.max(((float) Math.hypot(f10 - fArr[0], r1[1] - fArr[1])) - 0.001f, 0.0f);
        float fI = i(cVar.f39704c, i10);
        this.f39695g.q(0.0f, 0.0f);
        g gVarJ = j(i10, cVar.f39702a);
        gVarJ.b(fMax, fI, cVar.f39706e, this.f39695g);
        this.f39698j.reset();
        this.f39695g.d(this.f39691c[i10], this.f39698j);
        if (this.f39700l && (gVarJ.a() || l(this.f39698j, i10) || l(this.f39698j, i11))) {
            Path path = this.f39698j;
            path.op(path, this.f39694f, Path.Op.DIFFERENCE);
            this.f39696h[0] = this.f39695g.l();
            this.f39696h[1] = this.f39695g.m();
            this.f39691c[i10].mapPoints(this.f39696h);
            Path path2 = this.f39693e;
            float[] fArr2 = this.f39696h;
            path2.moveTo(fArr2[0], fArr2[1]);
            this.f39695g.d(this.f39691c[i10], this.f39693e);
        } else {
            this.f39695g.d(this.f39691c[i10], cVar.f39703b);
        }
        b bVar = cVar.f39705d;
        if (bVar != null) {
            bVar.b(this.f39695g, this.f39691c[i10], i10);
        }
    }

    public void d(o oVar, float f10, RectF rectF, @n0 Path path) {
        e(oVar, f10, rectF, null, path);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void e(o oVar, float f10, RectF rectF, b bVar, @n0 Path path) {
        path.rewind();
        this.f39693e.rewind();
        this.f39694f.rewind();
        this.f39694f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(oVar, f10, rectF, bVar, path);
        for (int i10 = 0; i10 < 4; i10++) {
            m(cVar, i10);
            o(i10);
        }
        for (int i11 = 0; i11 < 4; i11++) {
            b(cVar, i11);
            c(cVar, i11);
        }
        path.close();
        this.f39693e.close();
        if (this.f39693e.isEmpty()) {
            return;
        }
        path.op(this.f39693e, Path.Op.UNION);
    }

    public final void f(int i10, @n0 RectF rectF, @n0 PointF pointF) {
        if (i10 == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (i10 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i10 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    public final d g(int i10, @n0 o oVar) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? oVar.t() : oVar.r() : oVar.j() : oVar.l();
    }

    public final e h(int i10, @n0 o oVar) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? oVar.s() : oVar.q() : oVar.i() : oVar.k();
    }

    public final float i(@n0 RectF rectF, int i10) {
        float[] fArr = this.f39696h;
        q[] qVarArr = this.f39689a;
        fArr[0] = qVarArr[i10].f39711c;
        fArr[1] = qVarArr[i10].f39712d;
        this.f39690b[i10].mapPoints(fArr);
        return (i10 == 1 || i10 == 3) ? Math.abs(rectF.centerX() - this.f39696h[0]) : Math.abs(rectF.centerY() - this.f39696h[1]);
    }

    public final g j(int i10, @n0 o oVar) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? oVar.o() : oVar.p() : oVar.n() : oVar.h();
    }

    @v0(19)
    public final boolean l(Path path, int i10) {
        this.f39699k.reset();
        this.f39689a[i10].d(this.f39690b[i10], this.f39699k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f39699k.computeBounds(rectF, true);
        path.op(this.f39699k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    public final void m(@n0 c cVar, int i10) {
        h(i10, cVar.f39702a).c(this.f39689a[i10], 90.0f, cVar.f39706e, cVar.f39704c, g(i10, cVar.f39702a));
        float fA = a(i10);
        this.f39690b[i10].reset();
        f(i10, cVar.f39704c, this.f39692d);
        Matrix matrix = this.f39690b[i10];
        PointF pointF = this.f39692d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f39690b[i10].preRotate(fA);
    }

    public void n(boolean z10) {
        this.f39700l = z10;
    }

    public final void o(int i10) {
        this.f39696h[0] = this.f39689a[i10].j();
        this.f39696h[1] = this.f39689a[i10].k();
        this.f39690b[i10].mapPoints(this.f39696h);
        float fA = a(i10);
        this.f39691c[i10].reset();
        Matrix matrix = this.f39691c[i10];
        float[] fArr = this.f39696h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f39691c[i10].preRotate(fA);
    }
}
