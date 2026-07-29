package td;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.google.android.material.card.MaterialCardView;
import g.l;
import g.n0;
import g.p0;
import sd.d;
import sd.g;

/* JADX INFO: loaded from: classes3.dex */
public class a extends MaterialCardView implements g {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @n0
    public final d f51080y;

    public a(Context context) {
        this(context, null);
    }

    @Override // sd.g
    public void a() {
        this.f51080y.a();
    }

    @Override // sd.g
    public void b() {
        this.f51080y.b();
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
        d dVar = this.f51080y;
        if (dVar != null) {
            dVar.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // sd.g
    @p0
    public Drawable getCircularRevealOverlayDrawable() {
        return this.f51080y.g();
    }

    @Override // sd.g
    public int getCircularRevealScrimColor() {
        return this.f51080y.h();
    }

    @Override // sd.g
    @p0
    public g.e getRevealInfo() {
        return this.f51080y.j();
    }

    @Override // android.view.View, sd.g
    public boolean isOpaque() {
        d dVar = this.f51080y;
        return dVar != null ? dVar.l() : super.isOpaque();
    }

    @Override // sd.g
    public void setCircularRevealOverlayDrawable(@p0 Drawable drawable) {
        this.f51080y.m(drawable);
    }

    @Override // sd.g
    public void setCircularRevealScrimColor(@l int i10) {
        this.f51080y.n(i10);
    }

    @Override // sd.g
    public void setRevealInfo(@p0 g.e eVar) {
        this.f51080y.o(eVar);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f51080y = new d(this);
    }
}
