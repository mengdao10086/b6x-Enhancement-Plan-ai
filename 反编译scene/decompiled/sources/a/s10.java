package a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class s10 extends iz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7350a;
    public final Paint d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final RectF f2815d;

    public s10(nz nzVar) {
        super(nzVar == null ? new nz() : nzVar);
        this.d = new Paint(1);
        o0();
        this.f2815d = new RectF();
    }

    @Override // a.iz, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        j0(canvas);
        super.draw(canvas);
        canvas.drawRect(this.f2815d, this.d);
        i0(canvas);
    }

    public boolean h0() {
        return !this.f2815d.isEmpty();
    }

    public final void i0(Canvas canvas) {
        if (p0(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.f7350a);
    }

    public final void j0(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (!p0(callback)) {
            l0(canvas);
            return;
        }
        View view = (View) callback;
        if (view.getLayerType() != 2) {
            view.setLayerType(2, null);
        }
    }

    public void k0() {
        m0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public final void l0(Canvas canvas) {
        this.f7350a = Build.VERSION.SDK_INT >= 21 ? canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null) : canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
    }

    public void m0(float f, float f2, float f3, float f4) {
        RectF rectF = this.f2815d;
        if (f == rectF.left && f2 == rectF.top && f3 == rectF.right && f4 == rectF.bottom) {
            return;
        }
        this.f2815d.set(f, f2, f3, f4);
        invalidateSelf();
    }

    public void n0(RectF rectF) {
        m0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    public final void o0() {
        this.d.setStyle(Paint.Style.FILL_AND_STROKE);
        this.d.setColor(-1);
        this.d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public final boolean p0(Drawable.Callback callback) {
        return callback instanceof View;
    }
}
