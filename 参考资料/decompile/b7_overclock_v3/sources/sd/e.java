package sd;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import g.l;
import g.n0;
import g.p0;
import sd.g;

/* JADX INFO: loaded from: classes3.dex */
public class e extends LinearLayout implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final d f49680a;

    public e(Context context) {
        this(context, null);
    }

    @Override // sd.g
    public void a() {
        this.f49680a.a();
    }

    @Override // sd.g
    public void b() {
        this.f49680a.b();
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
    public void draw(@n0 Canvas canvas) {
        d dVar = this.f49680a;
        if (dVar != null) {
            dVar.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // sd.g
    @p0
    public Drawable getCircularRevealOverlayDrawable() {
        return this.f49680a.g();
    }

    @Override // sd.g
    public int getCircularRevealScrimColor() {
        return this.f49680a.h();
    }

    @Override // sd.g
    @p0
    public g.e getRevealInfo() {
        return this.f49680a.j();
    }

    @Override // android.view.View, sd.g
    public boolean isOpaque() {
        d dVar = this.f49680a;
        return dVar != null ? dVar.l() : super.isOpaque();
    }

    @Override // sd.g
    public void setCircularRevealOverlayDrawable(@p0 Drawable drawable) {
        this.f49680a.m(drawable);
    }

    @Override // sd.g
    public void setCircularRevealScrimColor(@l int i10) {
        this.f49680a.n(i10);
    }

    @Override // sd.g
    public void setRevealInfo(@p0 g.e eVar) {
        this.f49680a.o(eVar);
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f49680a = new d(this);
    }
}
