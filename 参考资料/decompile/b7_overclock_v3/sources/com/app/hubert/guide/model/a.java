package com.app.hubert.guide.model;

import android.graphics.RectF;
import android.view.View;
import android.view.animation.Animation;
import com.app.hubert.guide.model.HighLight;
import com.app.hubert.guide.model.b;
import g.i0;
import g.l;
import g.p0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<HighLight> f11410a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11411b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11413d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f11414e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public r3.d f11415f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r3.c f11416g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Animation f11417h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Animation f11418i;

    public static a D() {
        return new a();
    }

    public List<s3.a> A() {
        s3.a aVar;
        ArrayList arrayList = new ArrayList();
        Iterator<HighLight> it2 = this.f11410a.iterator();
        while (it2.hasNext()) {
            b bVarD = it2.next().d();
            if (bVarD != null && (aVar = bVarD.f11420b) != null) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public boolean B() {
        return this.f11413d == 0 && this.f11410a.size() == 0;
    }

    public boolean C() {
        return this.f11411b;
    }

    public a E(@l int i10) {
        this.f11412c = i10;
        return this;
    }

    public a F(Animation animation) {
        this.f11417h = animation;
        return this;
    }

    public a G(boolean z10) {
        this.f11411b = z10;
        return this;
    }

    public a H(Animation animation) {
        this.f11418i = animation;
        return this;
    }

    public a I(@i0 int i10, int... iArr) {
        this.f11413d = i10;
        this.f11414e = iArr;
        return this;
    }

    public a J(r3.d dVar) {
        this.f11415f = dVar;
        return this;
    }

    public a a(RectF rectF) {
        return d(rectF, HighLight.Shape.RECTANGLE, 0, null);
    }

    public a b(RectF rectF, HighLight.Shape shape) {
        return d(rectF, shape, 0, null);
    }

    public a c(RectF rectF, HighLight.Shape shape, int i10) {
        return d(rectF, shape, i10, null);
    }

    public a d(RectF rectF, HighLight.Shape shape, int i10, s3.a aVar) {
        c cVar = new c(rectF, shape, i10);
        if (aVar != null) {
            aVar.f49445a = cVar;
            cVar.a(new b.a().e(aVar).a());
        }
        this.f11410a.add(cVar);
        return this;
    }

    public a e(RectF rectF, HighLight.Shape shape, s3.a aVar) {
        return d(rectF, shape, 0, aVar);
    }

    public a f(RectF rectF, s3.a aVar) {
        return d(rectF, HighLight.Shape.RECTANGLE, 0, aVar);
    }

    public a g(View view) {
        return j(view, HighLight.Shape.RECTANGLE, 0, 0, null);
    }

    public a h(View view, HighLight.Shape shape) {
        return j(view, shape, 0, 0, null);
    }

    public a i(View view, HighLight.Shape shape, int i10) {
        return j(view, shape, 0, i10, null);
    }

    public a j(View view, HighLight.Shape shape, int i10, int i11, @p0 s3.a aVar) {
        d dVar = new d(view, shape, i10, i11);
        if (aVar != null) {
            aVar.f49445a = dVar;
            dVar.g(new b.a().e(aVar).a());
        }
        this.f11410a.add(dVar);
        return this;
    }

    public a k(View view, HighLight.Shape shape, int i10, s3.a aVar) {
        return j(view, shape, 0, i10, aVar);
    }

    public a l(View view, HighLight.Shape shape, s3.a aVar) {
        return j(view, shape, 0, 0, aVar);
    }

    public a m(View view, s3.a aVar) {
        return j(view, HighLight.Shape.RECTANGLE, 0, 0, aVar);
    }

    public a n(RectF rectF, HighLight.Shape shape, int i10, b bVar) {
        s3.a aVar;
        c cVar = new c(rectF, shape, i10);
        if (bVar != null && (aVar = bVar.f11420b) != null) {
            aVar.f49445a = cVar;
        }
        cVar.a(bVar);
        this.f11410a.add(cVar);
        return this;
    }

    public a o(RectF rectF, HighLight.Shape shape, b bVar) {
        return n(rectF, shape, 0, bVar);
    }

    public a p(RectF rectF, b bVar) {
        return n(rectF, HighLight.Shape.RECTANGLE, 0, bVar);
    }

    public a q(View view, HighLight.Shape shape, int i10, int i11, b bVar) {
        s3.a aVar;
        d dVar = new d(view, shape, i10, i11);
        if (bVar != null && (aVar = bVar.f11420b) != null) {
            aVar.f49445a = dVar;
        }
        dVar.g(bVar);
        this.f11410a.add(dVar);
        return this;
    }

    public a r(View view, HighLight.Shape shape, b bVar) {
        return q(view, shape, 0, 0, bVar);
    }

    public a s(View view, b bVar) {
        return q(view, HighLight.Shape.RECTANGLE, 0, 0, bVar);
    }

    public int t() {
        return this.f11412c;
    }

    public int[] u() {
        return this.f11414e;
    }

    public Animation v() {
        return this.f11417h;
    }

    public Animation w() {
        return this.f11418i;
    }

    public List<HighLight> x() {
        return this.f11410a;
    }

    public int y() {
        return this.f11413d;
    }

    public r3.d z() {
        return this.f11415f;
    }
}
