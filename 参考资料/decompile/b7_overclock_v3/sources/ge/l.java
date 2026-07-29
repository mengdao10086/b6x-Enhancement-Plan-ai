package ge;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import g.n0;
import g.p0;
import ge.c;
import h2.b;

/* JADX INFO: loaded from: classes3.dex */
public final class l<S extends c> extends i {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public j<S> f29343r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public k<ObjectAnimator> f29344s;

    public l(@n0 Context context, @n0 c cVar, @n0 j<S> jVar, @n0 k<ObjectAnimator> kVar) {
        super(context, cVar);
        C(jVar);
        B(kVar);
    }

    @n0
    public static l<g> x(@n0 Context context, @n0 g gVar) {
        return new l<>(context, gVar, new d(gVar), new e(gVar));
    }

    @n0
    public static l<q> y(@n0 Context context, @n0 q qVar) {
        return new l<>(context, qVar, new m(qVar), qVar.f29375g == 0 ? new n(qVar) : new o(context, qVar));
    }

    @n0
    public j<S> A() {
        return this.f29343r;
    }

    public void B(@n0 k<ObjectAnimator> kVar) {
        this.f29344s = kVar;
        kVar.e(this);
    }

    public void C(@n0 j<S> jVar) {
        this.f29343r = jVar;
        jVar.f(this);
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
        if (getBounds().isEmpty() || !isVisible() || !canvas.getClipBounds(rect)) {
            return;
        }
        canvas.save();
        this.f29343r.g(canvas, getBounds(), j());
        this.f29343r.c(canvas, this.f29334m);
        int i10 = 0;
        while (true) {
            k<ObjectAnimator> kVar = this.f29344s;
            int[] iArr = kVar.f29342c;
            if (i10 >= iArr.length) {
                canvas.restore();
                return;
            }
            j<S> jVar = this.f29343r;
            Paint paint = this.f29334m;
            float[] fArr = kVar.f29341b;
            int i11 = i10 * 2;
            jVar.b(canvas, paint, fArr[i11], fArr[i11 + 1], iArr[i10]);
            i10++;
        }
    }

    @Override // ge.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f29343r.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f29343r.e();
    }

    @Override // ge.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // ge.i, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
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
        if (!isRunning()) {
            this.f29344s.a();
        }
        float fA = this.f29324c.a(this.f29322a.getContentResolver());
        if (z10 && (z12 || (Build.VERSION.SDK_INT <= 22 && fA > 0.0f))) {
            this.f29344s.g();
        }
        return zW;
    }

    @n0
    public k<ObjectAnimator> z() {
        return this.f29344s;
    }
}
