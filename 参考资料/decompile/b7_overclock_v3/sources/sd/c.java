package sd;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.GridLayout;
import g.l;
import g.n0;
import g.p0;
import sd.g;

/* JADX INFO: loaded from: classes3.dex */
public class c extends GridLayout implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final d f49664a;

    public c(Context context) {
        this(context, null);
    }

    @Override // sd.g
    public void a() {
        this.f49664a.a();
    }

    @Override // sd.g
    public void b() {
        this.f49664a.b();
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
        d dVar = this.f49664a;
        if (dVar != null) {
            dVar.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // sd.g
    @p0
    public Drawable getCircularRevealOverlayDrawable() {
        return this.f49664a.g();
    }

    @Override // sd.g
    public int getCircularRevealScrimColor() {
        return this.f49664a.h();
    }

    @Override // sd.g
    @p0
    public g.e getRevealInfo() {
        return this.f49664a.j();
    }

    @Override // android.view.View, sd.g
    public boolean isOpaque() {
        d dVar = this.f49664a;
        return dVar != null ? dVar.l() : super.isOpaque();
    }

    @Override // sd.g
    public void setCircularRevealOverlayDrawable(@p0 Drawable drawable) {
        this.f49664a.m(drawable);
    }

    @Override // sd.g
    public void setCircularRevealScrimColor(@l int i10) {
        this.f49664a.n(i10);
    }

    @Override // sd.g
    public void setRevealInfo(@p0 g.e eVar) {
        this.f49664a.o(eVar);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f49664a = new d(this);
    }
}
