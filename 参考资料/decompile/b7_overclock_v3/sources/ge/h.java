package ge;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import g.n0;
import g.p0;
import g1.b;
import ge.c;
import h2.b;

/* JADX INFO: loaded from: classes3.dex */
public final class h<S extends c> extends i {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f29311w = 10000;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final float f29312x = 50.0f;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final g1.d<h> f29313y = new a("indicatorLevel");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public j<S> f29314r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final g1.h f29315s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final g1.g f29316t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f29317u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f29318v;

    public class a extends g1.d<h> {
        public a(String str) {
            super(str);
        }

        @Override // g1.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public float b(h hVar) {
            return hVar.D() * 10000.0f;
        }

        @Override // g1.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(h hVar, float f10) {
            hVar.G(f10 / 10000.0f);
        }
    }

    public h(@n0 Context context, @n0 c cVar, @n0 j<S> jVar) {
        super(context, cVar);
        this.f29318v = false;
        F(jVar);
        g1.h hVar = new g1.h();
        this.f29315s = hVar;
        hVar.g(1.0f);
        hVar.i(50.0f);
        g1.g gVar = new g1.g(this, f29313y);
        this.f29316t = gVar;
        gVar.D(hVar);
        p(1.0f);
    }

    @n0
    public static h<g> A(@n0 Context context, @n0 g gVar) {
        return new h<>(context, gVar, new d(gVar));
    }

    @n0
    public static h<q> B(@n0 Context context, @n0 q qVar) {
        return new h<>(context, qVar, new m(qVar));
    }

    @n0
    public j<S> C() {
        return this.f29314r;
    }

    public final float D() {
        return this.f29317u;
    }

    public void E(@n0 b.q qVar) {
        this.f29316t.l(qVar);
    }

    public void F(@n0 j<S> jVar) {
        this.f29314r = jVar;
        jVar.f(this);
    }

    public final void G(float f10) {
        this.f29317u = f10;
        invalidateSelf();
    }

    public void H(float f10) {
        setLevel((int) (f10 * 10000.0f));
    }

    @Override // ge.i, h2.b
    public /* bridge */ /* synthetic */ boolean b(@n0 b.a aVar) {
        return super.b(aVar);
    }

    @Override // ge.i, h2.b
    public /* bridge */ /* synthetic */ void c(@n0 b.a aVar) {
        super.c(aVar);
    }

    @Override // ge.i, h2.b
    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@n0 Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.f29314r.g(canvas, getBounds(), j());
            this.f29314r.c(canvas, this.f29334m);
            this.f29314r.b(canvas, this.f29334m, 0.0f, D(), vd.m.a(this.f29323b.f29274c[0], getAlpha()));
            canvas.restore();
        }
    }

    @Override // ge.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f29314r.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f29314r.e();
    }

    @Override // ge.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // ge.i, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f29316t.E();
        G(getLevel() / 10000.0f);
    }

    @Override // ge.i
    public /* bridge */ /* synthetic */ boolean l() {
        return super.l();
    }

    @Override // ge.i
    public /* bridge */ /* synthetic */ boolean m() {
        return super.m();
    }

    @Override // ge.i
    public /* bridge */ /* synthetic */ boolean n() {
        return super.n();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        if (this.f29318v) {
            this.f29316t.E();
            G(i10 / 10000.0f);
            return true;
        }
        this.f29316t.t(D() * 10000.0f);
        this.f29316t.z(i10);
        return true;
    }

    @Override // ge.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i10) {
        super.setAlpha(i10);
    }

    @Override // ge.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(@p0 ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // ge.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z10, boolean z11) {
        return super.setVisible(z10, z11);
    }

    @Override // ge.i, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // ge.i, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    @Override // ge.i
    public /* bridge */ /* synthetic */ boolean v(boolean z10, boolean z11, boolean z12) {
        return super.v(z10, z11, z12);
    }

    @Override // ge.i
    public boolean w(boolean z10, boolean z11, boolean z12) {
        boolean zW = super.w(z10, z11, z12);
        float fA = this.f29324c.a(this.f29322a.getContentResolver());
        if (fA == 0.0f) {
            this.f29318v = true;
        } else {
            this.f29318v = false;
            this.f29315s.i(50.0f / fA);
        }
        return zW;
    }

    public void z(@n0 b.q qVar) {
        this.f29316t.b(qVar);
    }
}
