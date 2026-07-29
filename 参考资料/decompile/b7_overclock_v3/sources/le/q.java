package le;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import g.n0;
import g.v0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class q {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float f39707j = 270.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final float f39708k = 180.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public float f39709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public float f39710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public float f39711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public float f39712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public float f39713e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public float f39714f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<h> f39715g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<j> f39716h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f39717i;

    public class a extends j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f39718c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Matrix f39719d;

        public a(List list, Matrix matrix) {
            this.f39718c = list;
            this.f39719d = matrix;
        }

        @Override // le.q.j
        public void a(Matrix matrix, ke.b bVar, int i10, Canvas canvas) {
            Iterator it2 = this.f39718c.iterator();
            while (it2.hasNext()) {
                ((j) it2.next()).a(this.f39719d, bVar, i10, canvas);
            }
        }
    }

    public static class b extends j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e f39721c;

        public b(e eVar) {
            this.f39721c = eVar;
        }

        @Override // le.q.j
        public void a(Matrix matrix, @n0 ke.b bVar, int i10, @n0 Canvas canvas) {
            bVar.a(canvas, matrix, new RectF(this.f39721c.k(), this.f39721c.o(), this.f39721c.l(), this.f39721c.j()), i10, this.f39721c.m(), this.f39721c.n());
        }
    }

    public static class c extends j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final g f39722c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final g f39723d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f39724e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f39725f;

        public c(g gVar, g gVar2, float f10, float f11) {
            this.f39722c = gVar;
            this.f39723d = gVar2;
            this.f39724e = f10;
            this.f39725f = f11;
        }

        @Override // le.q.j
        public void a(Matrix matrix, ke.b bVar, int i10, Canvas canvas) {
            ke.b bVar2;
            float fE = e();
            if (fE > 0.0f) {
                return;
            }
            double dHypot = Math.hypot(this.f39722c.f39742b - this.f39724e, this.f39722c.f39743c - this.f39725f);
            double dHypot2 = Math.hypot(this.f39723d.f39742b - this.f39722c.f39742b, this.f39723d.f39743c - this.f39722c.f39743c);
            float fMin = (float) Math.min(i10, Math.min(dHypot, dHypot2));
            double d10 = fMin;
            double dTan = Math.tan(Math.toRadians((-fE) / 2.0f)) * d10;
            if (dHypot > dTan) {
                RectF rectF = new RectF(0.0f, 0.0f, (float) (dHypot - dTan), 0.0f);
                this.f39750a.set(matrix);
                this.f39750a.preTranslate(this.f39724e, this.f39725f);
                this.f39750a.preRotate(d());
                bVar2 = bVar;
                bVar2.b(canvas, this.f39750a, rectF, i10);
            } else {
                bVar2 = bVar;
            }
            float f10 = 2.0f * fMin;
            RectF rectF2 = new RectF(0.0f, 0.0f, f10, f10);
            this.f39750a.set(matrix);
            this.f39750a.preTranslate(this.f39722c.f39742b, this.f39722c.f39743c);
            this.f39750a.preRotate(d());
            this.f39750a.preTranslate((float) ((-dTan) - d10), (-2.0f) * fMin);
            bVar.c(canvas, this.f39750a, rectF2, (int) fMin, 450.0f, fE, new float[]{(float) (d10 + dTan), f10});
            if (dHypot2 > dTan) {
                RectF rectF3 = new RectF(0.0f, 0.0f, (float) (dHypot2 - dTan), 0.0f);
                this.f39750a.set(matrix);
                this.f39750a.preTranslate(this.f39722c.f39742b, this.f39722c.f39743c);
                this.f39750a.preRotate(c());
                this.f39750a.preTranslate((float) dTan, 0.0f);
                bVar2.b(canvas, this.f39750a, rectF3, i10);
            }
        }

        public float c() {
            return (float) Math.toDegrees(Math.atan((this.f39723d.f39743c - this.f39722c.f39743c) / (this.f39723d.f39742b - this.f39722c.f39742b)));
        }

        public float d() {
            return (float) Math.toDegrees(Math.atan((this.f39722c.f39743c - this.f39725f) / (this.f39722c.f39742b - this.f39724e)));
        }

        public float e() {
            float fC = ((c() - d()) + 360.0f) % 360.0f;
            return fC <= 180.0f ? fC : fC - 360.0f;
        }
    }

    public static class d extends j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final g f39726c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f39727d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f39728e;

        public d(g gVar, float f10, float f11) {
            this.f39726c = gVar;
            this.f39727d = f10;
            this.f39728e = f11;
        }

        @Override // le.q.j
        public void a(Matrix matrix, @n0 ke.b bVar, int i10, @n0 Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f39726c.f39743c - this.f39728e, this.f39726c.f39742b - this.f39727d), 0.0f);
            this.f39750a.set(matrix);
            this.f39750a.preTranslate(this.f39727d, this.f39728e);
            this.f39750a.preRotate(c());
            bVar.b(canvas, this.f39750a, rectF, i10);
        }

        public float c() {
            return (float) Math.toDegrees(Math.atan((this.f39726c.f39743c - this.f39728e) / (this.f39726c.f39742b - this.f39727d)));
        }
    }

    public static class e extends h {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final RectF f39729h = new RectF();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Deprecated
        public float f39730b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Deprecated
        public float f39731c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        public float f39732d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Deprecated
        public float f39733e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Deprecated
        public float f39734f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Deprecated
        public float f39735g;

        public e(float f10, float f11, float f12, float f13) {
            q(f10);
            u(f11);
            r(f12);
            p(f13);
        }

        @Override // le.q.h
        public void a(@n0 Matrix matrix, @n0 Path path) {
            Matrix matrix2 = this.f39744a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f39729h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }

        public final float j() {
            return this.f39733e;
        }

        public final float k() {
            return this.f39730b;
        }

        public final float l() {
            return this.f39732d;
        }

        public final float m() {
            return this.f39734f;
        }

        public final float n() {
            return this.f39735g;
        }

        public final float o() {
            return this.f39731c;
        }

        public final void p(float f10) {
            this.f39733e = f10;
        }

        public final void q(float f10) {
            this.f39730b = f10;
        }

        public final void r(float f10) {
            this.f39732d = f10;
        }

        public final void s(float f10) {
            this.f39734f = f10;
        }

        public final void t(float f10) {
            this.f39735g = f10;
        }

        public final void u(float f10) {
            this.f39731c = f10;
        }
    }

    public static class f extends h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f39736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f39737c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f39738d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f39739e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f39740f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f39741g;

        public f(float f10, float f11, float f12, float f13, float f14, float f15) {
            h(f10);
            j(f11);
            i(f12);
            k(f13);
            l(f14);
            m(f15);
        }

        @Override // le.q.h
        public void a(@n0 Matrix matrix, @n0 Path path) {
            Matrix matrix2 = this.f39744a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.cubicTo(this.f39736b, this.f39737c, this.f39738d, this.f39739e, this.f39740f, this.f39741g);
            path.transform(matrix);
        }

        public final float b() {
            return this.f39736b;
        }

        public final float c() {
            return this.f39738d;
        }

        public final float d() {
            return this.f39737c;
        }

        public final float e() {
            return this.f39737c;
        }

        public final float f() {
            return this.f39740f;
        }

        public final float g() {
            return this.f39741g;
        }

        public final void h(float f10) {
            this.f39736b = f10;
        }

        public final void i(float f10) {
            this.f39738d = f10;
        }

        public final void j(float f10) {
            this.f39737c = f10;
        }

        public final void k(float f10) {
            this.f39739e = f10;
        }

        public final void l(float f10) {
            this.f39740f = f10;
        }

        public final void m(float f10) {
            this.f39741g = f10;
        }
    }

    public static class g extends h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f39742b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f39743c;

        @Override // le.q.h
        public void a(@n0 Matrix matrix, @n0 Path path) {
            Matrix matrix2 = this.f39744a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f39742b, this.f39743c);
            path.transform(matrix);
        }
    }

    public static abstract class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matrix f39744a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    public static class i extends h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Deprecated
        public float f39745b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Deprecated
        public float f39746c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        public float f39747d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Deprecated
        public float f39748e;

        @Override // le.q.h
        public void a(@n0 Matrix matrix, @n0 Path path) {
            Matrix matrix2 = this.f39744a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.quadTo(f(), g(), h(), i());
            path.transform(matrix);
        }

        public final float f() {
            return this.f39745b;
        }

        public final float g() {
            return this.f39746c;
        }

        public final float h() {
            return this.f39747d;
        }

        public final float i() {
            return this.f39748e;
        }

        public final void j(float f10) {
            this.f39745b = f10;
        }

        public final void k(float f10) {
            this.f39746c = f10;
        }

        public final void l(float f10) {
            this.f39747d = f10;
        }

        public final void m(float f10) {
            this.f39748e = f10;
        }
    }

    public static abstract class j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Matrix f39749b = new Matrix();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matrix f39750a = new Matrix();

        public abstract void a(Matrix matrix, ke.b bVar, int i10, Canvas canvas);

        public final void b(ke.b bVar, int i10, Canvas canvas) {
            a(f39749b, bVar, i10, canvas);
        }
    }

    public q() {
        q(0.0f, 0.0f);
    }

    public void a(float f10, float f11, float f12, float f13, float f14, float f15) {
        e eVar = new e(f10, f11, f12, f13);
        eVar.s(f14);
        eVar.t(f15);
        this.f39715g.add(eVar);
        b bVar = new b(eVar);
        float f16 = f14 + f15;
        boolean z10 = f15 < 0.0f;
        if (z10) {
            f14 = (f14 + 180.0f) % 360.0f;
        }
        c(bVar, f14, z10 ? (180.0f + f16) % 360.0f : f16);
        double d10 = f16;
        u(((f10 + f12) * 0.5f) + (((f12 - f10) / 2.0f) * ((float) Math.cos(Math.toRadians(d10)))));
        v(((f11 + f13) * 0.5f) + (((f13 - f11) / 2.0f) * ((float) Math.sin(Math.toRadians(d10)))));
    }

    public final void b(float f10) {
        if (h() == f10) {
            return;
        }
        float fH = ((f10 - h()) + 360.0f) % 360.0f;
        if (fH > 180.0f) {
            return;
        }
        e eVar = new e(j(), k(), j(), k());
        eVar.s(h());
        eVar.t(fH);
        this.f39716h.add(new b(eVar));
        s(f10);
    }

    public final void c(j jVar, float f10, float f11) {
        b(f10);
        this.f39716h.add(jVar);
        s(f11);
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f39715g.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f39715g.get(i10).a(matrix, path);
        }
    }

    public boolean e() {
        return this.f39717i;
    }

    @n0
    public j f(Matrix matrix) {
        b(i());
        return new a(new ArrayList(this.f39716h), new Matrix(matrix));
    }

    @v0(21)
    public void g(float f10, float f11, float f12, float f13, float f14, float f15) {
        this.f39715g.add(new f(f10, f11, f12, f13, f14, f15));
        this.f39717i = true;
        u(f14);
        v(f15);
    }

    public final float h() {
        return this.f39713e;
    }

    public final float i() {
        return this.f39714f;
    }

    public float j() {
        return this.f39711c;
    }

    public float k() {
        return this.f39712d;
    }

    public float l() {
        return this.f39709a;
    }

    public float m() {
        return this.f39710b;
    }

    public void n(float f10, float f11) {
        g gVar = new g();
        gVar.f39742b = f10;
        gVar.f39743c = f11;
        this.f39715g.add(gVar);
        d dVar = new d(gVar, j(), k());
        c(dVar, dVar.c() + 270.0f, dVar.c() + 270.0f);
        u(f10);
        v(f11);
    }

    public void o(float f10, float f11, float f12, float f13) {
        if ((Math.abs(f10 - j()) < 0.001f && Math.abs(f11 - k()) < 0.001f) || (Math.abs(f10 - f12) < 0.001f && Math.abs(f11 - f13) < 0.001f)) {
            n(f12, f13);
            return;
        }
        g gVar = new g();
        gVar.f39742b = f10;
        gVar.f39743c = f11;
        this.f39715g.add(gVar);
        g gVar2 = new g();
        gVar2.f39742b = f12;
        gVar2.f39743c = f13;
        this.f39715g.add(gVar2);
        c cVar = new c(gVar, gVar2, j(), k());
        if (cVar.e() > 0.0f) {
            n(f10, f11);
            n(f12, f13);
        } else {
            c(cVar, cVar.d() + 270.0f, cVar.c() + 270.0f);
            u(f12);
            v(f13);
        }
    }

    @v0(21)
    public void p(float f10, float f11, float f12, float f13) {
        i iVar = new i();
        iVar.j(f10);
        iVar.k(f11);
        iVar.l(f12);
        iVar.m(f13);
        this.f39715g.add(iVar);
        this.f39717i = true;
        u(f12);
        v(f13);
    }

    public void q(float f10, float f11) {
        r(f10, f11, 270.0f, 0.0f);
    }

    public void r(float f10, float f11, float f12, float f13) {
        w(f10);
        x(f11);
        u(f10);
        v(f11);
        s(f12);
        t((f12 + f13) % 360.0f);
        this.f39715g.clear();
        this.f39716h.clear();
        this.f39717i = false;
    }

    public final void s(float f10) {
        this.f39713e = f10;
    }

    public final void t(float f10) {
        this.f39714f = f10;
    }

    public final void u(float f10) {
        this.f39711c = f10;
    }

    public final void v(float f10) {
        this.f39712d = f10;
    }

    public final void w(float f10) {
        this.f39709a = f10;
    }

    public final void x(float f10) {
        this.f39710b = f10;
    }

    public q(float f10, float f11) {
        q(f10, f11);
    }
}
