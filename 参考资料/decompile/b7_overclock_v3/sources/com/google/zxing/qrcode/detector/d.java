package com.google.zxing.qrcode.detector;

import ve.l;

/* JADX INFO: loaded from: classes7.dex */
public final class d extends l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f21638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f21639d;

    public d(float f10, float f11, float f12) {
        this(f10, f11, f12, 1);
    }

    public boolean f(float f10, float f11, float f12) {
        if (Math.abs(f11 - d()) > f10 || Math.abs(f12 - c()) > f10) {
            return false;
        }
        float fAbs = Math.abs(f10 - this.f21638c);
        return fAbs <= 1.0f || fAbs <= this.f21638c;
    }

    public d g(float f10, float f11, float f12) {
        int i10 = this.f21639d;
        int i11 = i10 + 1;
        float fC = (i10 * c()) + f11;
        float f13 = i11;
        return new d(fC / f13, ((this.f21639d * d()) + f10) / f13, ((this.f21639d * this.f21638c) + f12) / f13, i11);
    }

    public int h() {
        return this.f21639d;
    }

    public float i() {
        return this.f21638c;
    }

    public d(float f10, float f11, float f12, int i10) {
        super(f10, f11);
        this.f21638c = f12;
        this.f21639d = i10;
    }
}
