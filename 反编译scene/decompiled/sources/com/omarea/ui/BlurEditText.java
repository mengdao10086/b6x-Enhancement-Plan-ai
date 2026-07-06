package com.omarea.ui;

import a.d41;
import a.f92;
import a.w5;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class BlurEditText extends w5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d41 f8380a;
    public boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlurEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        this.f8380a = new d41(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void computeScroll() {
        this.f8380a.m();
        super.computeScroll();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        if (!this.b) {
            this.f8380a.l();
            this.b = true;
        }
        super.onAttachedToWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        if (d41.f480a.e()) {
            float strokeWidth = d41.f480a.b().getStrokeWidth() / 2;
            canvas.drawRoundRect(strokeWidth, strokeWidth, getWidth() - strokeWidth, getHeight() - strokeWidth, d41.f480a.c(), d41.f480a.c(), d41.f480a.b());
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f8380a.m();
        super.onSizeChanged(i, i2, i3, i4);
    }
}
