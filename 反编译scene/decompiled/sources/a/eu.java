package a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class eu extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6041a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public du f793a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorStateList f794a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f795a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f796a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PorterDuff.Mode f797a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f798a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ColorStateList f799b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public PorterDuff.Mode f800b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f801b;
    public boolean c;

    public eu() {
        this.f794a = null;
        this.f797a = gu.f6243a;
        this.f793a = new du();
    }

    public eu(eu euVar) {
        this.f794a = null;
        this.f797a = gu.f6243a;
        if (euVar != null) {
            this.f6041a = euVar.f6041a;
            du duVar = new du(euVar.f793a);
            this.f793a = duVar;
            if (euVar.f793a.f612b != null) {
                duVar.f612b = new Paint(euVar.f793a.f612b);
            }
            if (euVar.f793a.f605a != null) {
                this.f793a.f605a = new Paint(euVar.f793a.f605a);
            }
            this.f794a = euVar.f794a;
            this.f797a = euVar.f797a;
            this.f798a = euVar.f798a;
        }
    }

    public boolean a(int i, int i2) {
        return i == this.f795a.getWidth() && i2 == this.f795a.getHeight();
    }

    public boolean b() {
        return !this.c && this.f799b == this.f794a && this.f800b == this.f797a && this.f801b == this.f798a && this.b == this.f793a.getRootAlpha();
    }

    public void c(int i, int i2) {
        if (this.f795a == null || !a(i, i2)) {
            this.f795a = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.c = true;
        }
    }

    public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
        canvas.drawBitmap(this.f795a, (Rect) null, rect, e(colorFilter));
    }

    public Paint e(ColorFilter colorFilter) {
        if (!f() && colorFilter == null) {
            return null;
        }
        if (this.f796a == null) {
            Paint paint = new Paint();
            this.f796a = paint;
            paint.setFilterBitmap(true);
        }
        this.f796a.setAlpha(this.f793a.getRootAlpha());
        this.f796a.setColorFilter(colorFilter);
        return this.f796a;
    }

    public boolean f() {
        return this.f793a.getRootAlpha() < 255;
    }

    public boolean g() {
        return this.f793a.f();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.f6041a;
    }

    public boolean h(int[] iArr) {
        boolean zG = this.f793a.g(iArr);
        this.c |= zG;
        return zG;
    }

    public void i() {
        this.f799b = this.f794a;
        this.f800b = this.f797a;
        this.b = this.f793a.getRootAlpha();
        this.f801b = this.f798a;
        this.c = false;
    }

    public void j(int i, int i2) {
        this.f795a.eraseColor(0);
        this.f793a.b(new Canvas(this.f795a), i, i2, null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return new gu(this);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return new gu(this);
    }
}
