package com.omarea.ui;

import a.d41;
import a.f92;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class BlurViewRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d41 f8383a;
    public boolean w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlurViewRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        this.f8383a = new d41(this);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f8383a.m();
        super.computeScroll();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.w) {
            return;
        }
        this.f8383a.l();
        this.w = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        if (d41.f480a.e()) {
            float strokeWidth = d41.f480a.b().getStrokeWidth() / 2;
            canvas.drawRoundRect(strokeWidth, strokeWidth, getWidth() - strokeWidth, getHeight() - strokeWidth, d41.f480a.c(), d41.f480a.c(), d41.f480a.b());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f8383a.m();
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (!this.w) {
            this.f8383a.l();
            this.w = true;
        }
        super.onViewAdded(view);
    }
}
