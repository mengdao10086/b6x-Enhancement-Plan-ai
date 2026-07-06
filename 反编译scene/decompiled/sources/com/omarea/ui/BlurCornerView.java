package com.omarea.ui;

import a.d41;
import a.e41;
import a.f92;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class BlurCornerView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d41 f8379a;
    public boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlurCornerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        this.f8379a = new d41(this);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f8379a.m();
        super.computeScroll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        if (!this.b) {
            this.f8379a.l();
            this.b = true;
        }
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        if (d41.f480a.e()) {
            float strokeWidth = d41.f480a.b().getStrokeWidth() / 2;
            canvas.drawRoundRect(strokeWidth, strokeWidth, getWidth() - strokeWidth, getHeight() - strokeWidth, getHeight() / 2.0f, getHeight() / 2.0f, d41.f480a.b());
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f8379a.m();
        super.onSizeChanged(i, i2, i3, i4);
        setOutlineProvider(new e41(getHeight() / 2.0f));
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (!this.b) {
            this.f8379a.l();
            this.b = true;
        }
        super.onViewAdded(view);
    }
}
