package sd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import g.l;
import g.n0;
import g.p0;
import sd.g;

/* JADX INFO: loaded from: classes3.dex */
public class b extends FrameLayout implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final d f49663a;

    public b(@n0 Context context) {
        this(context, null);
    }

    @Override // sd.g
    public void a() {
        this.f49663a.a();
    }

    @Override // sd.g
    public void b() {
        this.f49663a.b();
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
    @SuppressLint({"MissingSuperCall"})
    public void draw(@n0 Canvas canvas) {
        d dVar = this.f49663a;
        if (dVar != null) {
            dVar.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // sd.g
    @p0
    public Drawable getCircularRevealOverlayDrawable() {
        return this.f49663a.g();
    }

    @Override // sd.g
    public int getCircularRevealScrimColor() {
        return this.f49663a.h();
    }

    @Override // sd.g
    @p0
    public g.e getRevealInfo() {
        return this.f49663a.j();
    }

    @Override // android.view.View, sd.g
    public boolean isOpaque() {
        d dVar = this.f49663a;
        return dVar != null ? dVar.l() : super.isOpaque();
    }

    @Override // sd.g
    public void setCircularRevealOverlayDrawable(@p0 Drawable drawable) {
        this.f49663a.m(drawable);
    }

    @Override // sd.g
    public void setCircularRevealScrimColor(@l int i10) {
        this.f49663a.n(i10);
    }

    @Override // sd.g
    public void setRevealInfo(@p0 g.e eVar) {
        this.f49663a.o(eVar);
    }

    public b(@n0 Context context, @p0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f49663a = new d(this);
    }
}
