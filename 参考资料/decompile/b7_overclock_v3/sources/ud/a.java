package ud;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import g.l;
import g.n0;
import g.p0;
import sd.d;
import sd.g;

/* JADX INFO: loaded from: classes3.dex */
public class a extends CoordinatorLayout implements g {

    @n0
    public final d K0;

    public a(@n0 Context context) {
        this(context, null);
    }

    @Override // sd.g
    public void a() {
        this.K0.a();
    }

    @Override // sd.g
    public void b() {
        this.K0.b();
    }

    @Override // sd.d.a
    public void c(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // sd.d.a
    public boolean d() {
        return super.isOpaque();
    }

    @Override // android.view.View, sd.g
    public void draw(Canvas canvas) {
        d dVar = this.K0;
        if (dVar != null) {
            dVar.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // sd.g
    @p0
    public Drawable getCircularRevealOverlayDrawable() {
        return this.K0.g();
    }

    @Override // sd.g
    public int getCircularRevealScrimColor() {
        return this.K0.h();
    }

    @Override // sd.g
    @p0
    public g.e getRevealInfo() {
        return this.K0.j();
    }

    @Override // android.view.View, sd.g
    public boolean isOpaque() {
        d dVar = this.K0;
        return dVar != null ? dVar.l() : super.isOpaque();
    }

    @Override // sd.g
    public void setCircularRevealOverlayDrawable(@p0 Drawable drawable) {
        this.K0.m(drawable);
    }

    @Override // sd.g
    public void setCircularRevealScrimColor(@l int i10) {
        this.K0.n(i10);
    }

    @Override // sd.g
    public void setRevealInfo(@p0 g.e eVar) {
        this.K0.o(eVar);
    }

    public a(@n0 Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.K0 = new d(this);
    }
}
