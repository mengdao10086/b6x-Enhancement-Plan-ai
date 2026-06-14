package a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class vy extends Drawable implements a00, ld {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public uy f7733a;

    public vy(nz nzVar) {
        this(new uy(new iz(nzVar)));
    }

    public vy(uy uyVar) {
        this.f7733a = uyVar;
    }

    public vy a() {
        this.f7733a = new uy(this.f7733a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        uy uyVar = this.f7733a;
        if (uyVar.f3221a) {
            uyVar.f7641a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f7733a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f7733a.f7641a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable mutate() {
        a();
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f7733a.f7641a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (this.f7733a.f7641a.setState(iArr)) {
            zOnStateChange = true;
        }
        boolean zE = wy.e(iArr);
        uy uyVar = this.f7733a;
        if (uyVar.f3221a == zE) {
            return zOnStateChange;
        }
        uyVar.f3221a = zE;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f7733a.f7641a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f7733a.f7641a.setColorFilter(colorFilter);
    }

    @Override // a.a00
    public void setShapeAppearanceModel(nz nzVar) {
        this.f7733a.f7641a.setShapeAppearanceModel(nzVar);
    }

    @Override // android.graphics.drawable.Drawable, a.ld
    public void setTint(int i) {
        this.f7733a.f7641a.setTint(i);
    }

    @Override // android.graphics.drawable.Drawable, a.ld
    public void setTintList(ColorStateList colorStateList) {
        this.f7733a.f7641a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable, a.ld
    public void setTintMode(PorterDuff.Mode mode) {
        this.f7733a.f7641a.setTintMode(mode);
    }
}
