package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.components.Legend;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Legend.LegendForm f16619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f16620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f16621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DashPathEffect f16622e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f16623f;

    public a() {
        this.f16619b = Legend.LegendForm.DEFAULT;
        this.f16620c = Float.NaN;
        this.f16621d = Float.NaN;
        this.f16622e = null;
        this.f16623f = xa.a.f54970a;
    }

    public a(String str, Legend.LegendForm legendForm, float f10, float f11, DashPathEffect dashPathEffect, int i10) {
        Legend.LegendForm legendForm2 = Legend.LegendForm.DEFAULT;
        this.f16618a = str;
        this.f16619b = legendForm;
        this.f16620c = f10;
        this.f16621d = f11;
        this.f16622e = dashPathEffect;
        this.f16623f = i10;
    }
}
