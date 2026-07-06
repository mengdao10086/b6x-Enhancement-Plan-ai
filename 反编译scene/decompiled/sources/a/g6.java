package a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class g6 extends c6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ColorStateList f6174a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PorterDuff.Mode f973a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f974a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SeekBar f975a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f976a;
    public boolean b;

    public g6(SeekBar seekBar) {
        super(seekBar);
        this.f6174a = null;
        this.f973a = null;
        this.f976a = false;
        this.b = false;
        this.f975a = seekBar;
    }

    @Override // a.c6
    public void c(AttributeSet attributeSet, int i) {
        super.c(attributeSet, i);
        o8 o8VarV = o8.v(this.f975a.getContext(), attributeSet, c0.AppCompatSeekBar, i, 0);
        SeekBar seekBar = this.f975a;
        eh.i0(seekBar, seekBar.getContext(), c0.AppCompatSeekBar, attributeSet, o8VarV.r(), i, 0);
        Drawable drawableH = o8VarV.h(c0.AppCompatSeekBar_android_thumb);
        if (drawableH != null) {
            this.f975a.setThumb(drawableH);
        }
        j(o8VarV.g(c0.AppCompatSeekBar_tickMark));
        if (o8VarV.s(c0.AppCompatSeekBar_tickMarkTintMode)) {
            this.f973a = e7.d(o8VarV.k(c0.AppCompatSeekBar_tickMarkTintMode, -1), this.f973a);
            this.b = true;
        }
        if (o8VarV.s(c0.AppCompatSeekBar_tickMarkTint)) {
            this.f6174a = o8VarV.c(c0.AppCompatSeekBar_tickMarkTint);
            this.f976a = true;
        }
        o8VarV.w();
        f();
    }

    public final void f() {
        if (this.f974a != null) {
            if (this.f976a || this.b) {
                Drawable drawableR = kd.r(this.f974a.mutate());
                this.f974a = drawableR;
                if (this.f976a) {
                    kd.o(drawableR, this.f6174a);
                }
                if (this.b) {
                    kd.p(this.f974a, this.f973a);
                }
                if (this.f974a.isStateful()) {
                    this.f974a.setState(this.f975a.getDrawableState());
                }
            }
        }
    }

    public void g(Canvas canvas) {
        if (this.f974a != null) {
            int max = this.f975a.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f974a.getIntrinsicWidth();
                int intrinsicHeight = this.f974a.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f974a.setBounds(-i, -i2, i, i2);
                float width = ((this.f975a.getWidth() - this.f975a.getPaddingLeft()) - this.f975a.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.f975a.getPaddingLeft(), this.f975a.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.f974a.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    public void h() {
        Drawable drawable = this.f974a;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f975a.getDrawableState())) {
            this.f975a.invalidateDrawable(drawable);
        }
    }

    public void i() {
        Drawable drawable = this.f974a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void j(Drawable drawable) {
        Drawable drawable2 = this.f974a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f974a = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f975a);
            kd.m(drawable, eh.y(this.f975a));
            if (drawable.isStateful()) {
                drawable.setState(this.f975a.getDrawableState());
            }
            f();
        }
        this.f975a.invalidate();
    }
}
