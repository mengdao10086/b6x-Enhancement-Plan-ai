package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ParcelCreator"})
public class CandleEntry extends Entry {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f16629e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f16630f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f16631g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f16632h;

    public CandleEntry(float f10, float f11, float f12, float f13, float f14) {
        super(f10, (f11 + f12) / 2.0f);
        this.f16629e = f11;
        this.f16630f = f12;
        this.f16632h = f13;
        this.f16631g = f14;
    }

    @Override // com.github.mikephil.charting.data.Entry
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public CandleEntry z() {
        return new CandleEntry(F(), this.f16629e, this.f16630f, this.f16632h, this.f16631g, a());
    }

    public float T() {
        return Math.abs(this.f16632h - this.f16631g);
    }

    public float U() {
        return this.f16631g;
    }

    public float V() {
        return this.f16629e;
    }

    public float W() {
        return this.f16630f;
    }

    public float X() {
        return this.f16632h;
    }

    public float Y() {
        return Math.abs(this.f16629e - this.f16630f);
    }

    public void Z(float f10) {
        this.f16631g = f10;
    }

    public void a0(float f10) {
        this.f16629e = f10;
    }

    public void b0(float f10) {
        this.f16630f = f10;
    }

    public void c0(float f10) {
        this.f16632h = f10;
    }

    @Override // la.f
    public float e() {
        return super.e();
    }

    public CandleEntry(float f10, float f11, float f12, float f13, float f14, Object obj) {
        super(f10, (f11 + f12) / 2.0f, obj);
        this.f16629e = f11;
        this.f16630f = f12;
        this.f16632h = f13;
        this.f16631g = f14;
    }

    public CandleEntry(float f10, float f11, float f12, float f13, float f14, Drawable drawable) {
        super(f10, (f11 + f12) / 2.0f, drawable);
        this.f16629e = f11;
        this.f16630f = f12;
        this.f16632h = f13;
        this.f16631g = f14;
    }

    public CandleEntry(float f10, float f11, float f12, float f13, float f14, Drawable drawable, Object obj) {
        super(f10, (f11 + f12) / 2.0f, drawable, obj);
        this.f16629e = f11;
        this.f16630f = f12;
        this.f16632h = f13;
        this.f16631g = f14;
    }
}
