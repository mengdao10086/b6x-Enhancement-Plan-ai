package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes2.dex */
public class w extends r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SeekBar f2720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f2721e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ColorStateList f2722f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PorterDuff.Mode f2723g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2724h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2725i;

    public w(SeekBar seekBar) {
        super(seekBar);
        this.f2722f = null;
        this.f2723g = null;
        this.f2724h = false;
        this.f2725i = false;
        this.f2720d = seekBar;
    }

    @Override // androidx.appcompat.widget.r
    public void c(AttributeSet attributeSet, int i10) {
        super.c(attributeSet, i10);
        Context context = this.f2720d.getContext();
        int[] iArr = R.styleable.AppCompatSeekBar;
        y0 y0VarG = y0.G(context, attributeSet, iArr, i10, 0);
        SeekBar seekBar = this.f2720d;
        androidx.core.view.u0.z1(seekBar, seekBar.getContext(), iArr, attributeSet, y0VarG.B(), i10, 0);
        Drawable drawableI = y0VarG.i(R.styleable.AppCompatSeekBar_android_thumb);
        if (drawableI != null) {
            this.f2720d.setThumb(drawableI);
        }
        m(y0VarG.h(R.styleable.AppCompatSeekBar_tickMark));
        int i11 = R.styleable.AppCompatSeekBar_tickMarkTintMode;
        if (y0VarG.C(i11)) {
            this.f2723g = d0.e(y0VarG.o(i11, -1), this.f2723g);
            this.f2725i = true;
        }
        int i12 = R.styleable.AppCompatSeekBar_tickMarkTint;
        if (y0VarG.C(i12)) {
            this.f2722f = y0VarG.d(i12);
            this.f2724h = true;
        }
        y0VarG.I();
        f();
    }

    public final void f() {
        Drawable drawable = this.f2721e;
        if (drawable != null) {
            if (this.f2724h || this.f2725i) {
                Drawable drawableR = n0.c.r(drawable.mutate());
                this.f2721e = drawableR;
                if (this.f2724h) {
                    n0.c.o(drawableR, this.f2722f);
                }
                if (this.f2725i) {
                    n0.c.p(this.f2721e, this.f2723g);
                }
                if (this.f2721e.isStateful()) {
                    this.f2721e.setState(this.f2720d.getDrawableState());
                }
            }
        }
    }

    public void g(Canvas canvas) {
        if (this.f2721e != null) {
            int max = this.f2720d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f2721e.getIntrinsicWidth();
                int intrinsicHeight = this.f2721e.getIntrinsicHeight();
                int i10 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i11 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f2721e.setBounds(-i10, -i11, i10, i11);
                float width = ((this.f2720d.getWidth() - this.f2720d.getPaddingLeft()) - this.f2720d.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.f2720d.getPaddingLeft(), this.f2720d.getHeight() / 2);
                for (int i12 = 0; i12 <= max; i12++) {
                    this.f2721e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    public void h() {
        Drawable drawable = this.f2721e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f2720d.getDrawableState())) {
            this.f2720d.invalidateDrawable(drawable);
        }
    }

    @g.p0
    public Drawable i() {
        return this.f2721e;
    }

    @g.p0
    public ColorStateList j() {
        return this.f2722f;
    }

    @g.p0
    public PorterDuff.Mode k() {
        return this.f2723g;
    }

    public void l() {
        Drawable drawable = this.f2721e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void m(@g.p0 Drawable drawable) {
        Drawable drawable2 = this.f2721e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2721e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f2720d);
            n0.c.m(drawable, androidx.core.view.u0.Z(this.f2720d));
            if (drawable.isStateful()) {
                drawable.setState(this.f2720d.getDrawableState());
            }
            f();
        }
        this.f2720d.invalidate();
    }

    public void n(@g.p0 ColorStateList colorStateList) {
        this.f2722f = colorStateList;
        this.f2724h = true;
        f();
    }

    public void o(@g.p0 PorterDuff.Mode mode) {
        this.f2723g = mode;
        this.f2725i = true;
        f();
    }
}
