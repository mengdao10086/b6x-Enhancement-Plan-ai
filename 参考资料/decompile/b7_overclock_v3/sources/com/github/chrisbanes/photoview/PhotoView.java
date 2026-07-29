package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import z9.e;
import z9.f;
import z9.g;
import z9.h;
import z9.i;
import z9.j;
import z9.k;
import z9.l;

/* JADX INFO: loaded from: classes3.dex */
public class PhotoView extends AppCompatImageView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f16441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView.ScaleType f16442e;

    public PhotoView(Context context) {
        this(context, null);
    }

    public void b(Matrix matrix) {
        this.f16441d.D(matrix);
    }

    public void c(Matrix matrix) {
        this.f16441d.P(matrix);
    }

    public final void e() {
        this.f16441d = new l(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.f16442e;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f16442e = null;
        }
    }

    public boolean f() {
        return this.f16441d.S();
    }

    public boolean g(Matrix matrix) {
        return this.f16441d.W(matrix);
    }

    public l getAttacher() {
        return this.f16441d;
    }

    public RectF getDisplayRect() {
        return this.f16441d.E();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f16441d.H();
    }

    public float getMaximumScale() {
        return this.f16441d.K();
    }

    public float getMediumScale() {
        return this.f16441d.L();
    }

    public float getMinimumScale() {
        return this.f16441d.M();
    }

    public float getScale() {
        return this.f16441d.N();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f16441d.O();
    }

    public void h(float f10, float f11, float f12, boolean z10) {
        this.f16441d.o0(f10, f11, f12, z10);
    }

    public void i(float f10, boolean z10) {
        this.f16441d.p0(f10, z10);
    }

    public void j(float f10, float f11, float f12) {
        this.f16441d.q0(f10, f11, f12);
    }

    public boolean k(Matrix matrix) {
        return this.f16441d.W(matrix);
    }

    public void setAllowParentInterceptOnEdge(boolean z10) {
        this.f16441d.U(z10);
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i10, int i11, int i12, int i13) {
        boolean frame = super.setFrame(i10, i11, i12, i13);
        if (frame) {
            this.f16441d.v0();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        l lVar = this.f16441d;
        if (lVar != null) {
            lVar.v0();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i10) {
        super.setImageResource(i10);
        l lVar = this.f16441d;
        if (lVar != null) {
            lVar.v0();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        l lVar = this.f16441d;
        if (lVar != null) {
            lVar.v0();
        }
    }

    public void setMaximumScale(float f10) {
        this.f16441d.Y(f10);
    }

    public void setMediumScale(float f10) {
        this.f16441d.Z(f10);
    }

    public void setMinimumScale(float f10) {
        this.f16441d.a0(f10);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f16441d.b0(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f16441d.c0(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f16441d.d0(onLongClickListener);
    }

    public void setOnMatrixChangeListener(e eVar) {
        this.f16441d.e0(eVar);
    }

    public void setOnOutsidePhotoTapListener(f fVar) {
        this.f16441d.f0(fVar);
    }

    public void setOnPhotoTapListener(g gVar) {
        this.f16441d.g0(gVar);
    }

    public void setOnScaleChangeListener(h hVar) {
        this.f16441d.h0(hVar);
    }

    public void setOnSingleFlingListener(i iVar) {
        this.f16441d.i0(iVar);
    }

    public void setOnViewDragListener(j jVar) {
        this.f16441d.j0(jVar);
    }

    public void setOnViewTapListener(k kVar) {
        this.f16441d.k0(kVar);
    }

    public void setRotationBy(float f10) {
        this.f16441d.l0(f10);
    }

    public void setRotationTo(float f10) {
        this.f16441d.m0(f10);
    }

    public void setScale(float f10) {
        this.f16441d.n0(f10);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        l lVar = this.f16441d;
        if (lVar == null) {
            this.f16442e = scaleType;
        } else {
            lVar.r0(scaleType);
        }
    }

    public void setZoomTransitionDuration(int i10) {
        this.f16441d.t0(i10);
    }

    public void setZoomable(boolean z10) {
        this.f16441d.u0(z10);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        e();
    }
}
