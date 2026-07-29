package s4;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public class i extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f49478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f49479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f49480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f49481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f49482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f49483f;

    public static final class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f49484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f49485b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f49486c;

        public a(a aVar) {
            this(aVar.f49484a, aVar.f49485b, aVar.f49486c);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @n0
        public Drawable newDrawable() {
            return new i(this, this.f49484a.newDrawable());
        }

        public a(Drawable.ConstantState constantState, int i10, int i11) {
            this.f49484a = constantState;
            this.f49485b = i10;
            this.f49486c = i11;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @n0
        public Drawable newDrawable(Resources resources) {
            return new i(this, this.f49484a.newDrawable(resources));
        }
    }

    public i(Drawable drawable, int i10, int i11) {
        this(new a(drawable.getConstantState(), i10, i11), drawable);
    }

    public final void a() {
        this.f49478a.setRectToRect(this.f49479b, this.f49480c, Matrix.ScaleToFit.CENTER);
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.f49481d.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@n0 Canvas canvas) {
        canvas.save();
        canvas.concat(this.f49478a);
        this.f49481d.draw(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    @v0(19)
    public int getAlpha() {
        return this.f49481d.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return this.f49481d.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f49481d.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f49482e;
    }

    @Override // android.graphics.drawable.Drawable
    @n0
    public Drawable getCurrent() {
        return this.f49481d.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f49482e.f49486c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f49482e.f49485b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f49481d.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f49481d.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f49481d.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@n0 Rect rect) {
        return this.f49481d.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.f49481d.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @n0
    public Drawable mutate() {
        if (!this.f49483f && super.mutate() == this) {
            this.f49481d = this.f49481d.mutate();
            this.f49482e = new a(this.f49482e);
            this.f49483f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(@n0 Runnable runnable, long j10) {
        super.scheduleSelf(runnable, j10);
        this.f49481d.scheduleSelf(runnable, j10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f49481d.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i10, int i11, int i12, int i13) {
        super.setBounds(i10, i11, i12, i13);
        this.f49480c.set(i10, i11, i12, i13);
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i10) {
        this.f49481d.setChangingConfigurations(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i10, @n0 PorterDuff.Mode mode) {
        this.f49481d.setColorFilter(i10, mode);
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated
    public void setDither(boolean z10) {
        this.f49481d.setDither(z10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z10) {
        this.f49481d.setFilterBitmap(z10);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        return this.f49481d.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(@n0 Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.f49481d.unscheduleSelf(runnable);
    }

    public i(a aVar, Drawable drawable) {
        this.f49482e = (a) v4.m.d(aVar);
        this.f49481d = (Drawable) v4.m.d(drawable);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f49478a = new Matrix();
        this.f49479b = new RectF(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f49480c = new RectF();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f49481d.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(@n0 Rect rect) {
        super.setBounds(rect);
        this.f49480c.set(rect);
        a();
    }
}
