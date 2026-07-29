package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ParcelCreator"})
public class PieEntry extends Entry {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f16642e;

    public PieEntry(float f10) {
        super(0.0f, f10);
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public float F() {
        return super.F();
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public void M(float f10) {
        super.M(f10);
    }

    @Override // com.github.mikephil.charting.data.Entry
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public PieEntry z() {
        return new PieEntry(e(), this.f16642e, a());
    }

    public String T() {
        return this.f16642e;
    }

    public float U() {
        return e();
    }

    public void V(String str) {
        this.f16642e = str;
    }

    public PieEntry(float f10, Object obj) {
        super(0.0f, f10, obj);
    }

    public PieEntry(float f10, Drawable drawable) {
        super(0.0f, f10, drawable);
    }

    public PieEntry(float f10, Drawable drawable, Object obj) {
        super(0.0f, f10, drawable, obj);
    }

    public PieEntry(float f10, String str) {
        super(0.0f, f10);
        this.f16642e = str;
    }

    public PieEntry(float f10, String str, Object obj) {
        super(0.0f, f10, obj);
        this.f16642e = str;
    }

    public PieEntry(float f10, String str, Drawable drawable) {
        super(0.0f, f10, drawable);
        this.f16642e = str;
    }

    public PieEntry(float f10, String str, Drawable drawable, Object obj) {
        super(0.0f, f10, drawable, obj);
        this.f16642e = str;
    }
}
