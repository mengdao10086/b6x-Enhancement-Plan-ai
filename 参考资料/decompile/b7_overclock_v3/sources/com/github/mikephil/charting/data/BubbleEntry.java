package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ParcelCreator"})
public class BubbleEntry extends Entry {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f16628e;

    public BubbleEntry(float f10, float f11, float f12) {
        super(f10, f11);
        this.f16628e = f12;
    }

    @Override // com.github.mikephil.charting.data.Entry
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public BubbleEntry z() {
        return new BubbleEntry(F(), e(), this.f16628e, a());
    }

    public float T() {
        return this.f16628e;
    }

    public void U(float f10) {
        this.f16628e = f10;
    }

    public BubbleEntry(float f10, float f11, float f12, Object obj) {
        super(f10, f11, obj);
        this.f16628e = f12;
    }

    public BubbleEntry(float f10, float f11, float f12, Drawable drawable) {
        super(f10, f11, drawable);
        this.f16628e = f12;
    }

    public BubbleEntry(float f10, float f11, float f12, Drawable drawable, Object obj) {
        super(f10, f11, drawable, obj);
        this.f16628e = f12;
    }
}
