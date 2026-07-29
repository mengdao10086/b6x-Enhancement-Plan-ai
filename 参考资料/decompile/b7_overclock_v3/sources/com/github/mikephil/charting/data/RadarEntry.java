package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ParcelCreator"})
public class RadarEntry extends Entry {
    public RadarEntry(float f10) {
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
    public RadarEntry z() {
        return new RadarEntry(e(), a());
    }

    public float T() {
        return e();
    }

    public RadarEntry(float f10, Object obj) {
        super(0.0f, f10, obj);
    }
}
