package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.yalantis.ucrop.R;
import g.n0;
import jh.c;
import jh.d;

/* JADX INFO: loaded from: classes5.dex */
public class UCropView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GestureCropImageView f25017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OverlayView f25018b;

    public class a implements c {
        public a() {
        }

        @Override // jh.c
        public void a(float f10) {
            UCropView.this.f25018b.setTargetAspectRatio(f10);
        }
    }

    public class b implements d {
        public b() {
        }

        @Override // jh.d
        public void a(RectF rectF) {
            UCropView.this.f25017a.setCropRect(rectF);
        }
    }

    public UCropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void c() {
        removeView(this.f25017a);
        this.f25017a = new GestureCropImageView(getContext());
        d();
        this.f25017a.setCropRect(getOverlayView().getCropViewRect());
        addView(this.f25017a, 0);
    }

    public final void d() {
        this.f25017a.setCropBoundsChangeListener(new a());
        this.f25018b.setOverlayViewChangeListener(new b());
    }

    @n0
    public GestureCropImageView getCropImageView() {
        return this.f25017a;
    }

    @n0
    public OverlayView getOverlayView() {
        return this.f25018b;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public UCropView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater.from(context).inflate(R.layout.ucrop_view, (ViewGroup) this, true);
        this.f25017a = (GestureCropImageView) findViewById(R.id.image_view_crop);
        OverlayView overlayView = (OverlayView) findViewById(R.id.view_overlay);
        this.f25018b = overlayView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_UCropView);
        overlayView.h(typedArrayObtainStyledAttributes);
        this.f25017a.B(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        d();
    }
}
