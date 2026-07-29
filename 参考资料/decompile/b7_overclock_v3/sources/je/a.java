package je;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.RestrictTo;
import g.l;
import g.n0;
import g.p0;
import le.j;
import le.o;
import le.s;
import n0.i;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a extends Drawable implements s, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f36348a;

    @Override // android.graphics.drawable.Drawable
    @n0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a mutate() {
        this.f36348a = new b(this.f36348a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.f36348a;
        if (bVar.f36350b) {
            bVar.f36349a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @p0
    public Drawable.ConstantState getConstantState() {
        return this.f36348a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f36348a.f36349a.getOpacity();
    }

    @Override // le.s
    @n0
    public o getShapeAppearanceModel() {
        return this.f36348a.f36349a.getShapeAppearanceModel();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@n0 Rect rect) {
        super.onBoundsChange(rect);
        this.f36348a.f36349a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(@n0 int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (this.f36348a.f36349a.setState(iArr)) {
            zOnStateChange = true;
        }
        boolean zF = je.b.f(iArr);
        b bVar = this.f36348a;
        if (bVar.f36350b == zF) {
            return zOnStateChange;
        }
        bVar.f36350b = zF;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f36348a.f36349a.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@p0 ColorFilter colorFilter) {
        this.f36348a.f36349a.setColorFilter(colorFilter);
    }

    @Override // le.s
    public void setShapeAppearanceModel(@n0 o oVar) {
        this.f36348a.f36349a.setShapeAppearanceModel(oVar);
    }

    @Override // android.graphics.drawable.Drawable, n0.i
    public void setTint(@l int i10) {
        this.f36348a.f36349a.setTint(i10);
    }

    @Override // android.graphics.drawable.Drawable, n0.i
    public void setTintList(@p0 ColorStateList colorStateList) {
        this.f36348a.f36349a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable, n0.i
    public void setTintMode(@p0 PorterDuff.Mode mode) {
        this.f36348a.f36349a.setTintMode(mode);
    }

    public a(o oVar) {
        this(new b(new j(oVar)));
    }

    public static final class b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public j f36349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f36350b;

        public b(j jVar) {
            this.f36349a = jVar;
            this.f36350b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @n0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a newDrawable() {
            return new a(new b(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public b(@n0 b bVar) {
            this.f36349a = (j) bVar.f36349a.getConstantState().newDrawable();
            this.f36350b = bVar.f36350b;
        }
    }

    public a(b bVar) {
        this.f36348a = bVar;
    }
}
