package com.github.mikephil.charting.components;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import ka.b;
import xa.k;

/* JADX INFO: loaded from: classes3.dex */
public class LimitLine extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f16611g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f16612h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f16613i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Paint.Style f16614j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f16615k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DashPathEffect f16616l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LimitLabelPosition f16617m;

    public enum LimitLabelPosition {
        LEFT_TOP,
        LEFT_BOTTOM,
        RIGHT_TOP,
        RIGHT_BOTTOM
    }

    public LimitLine(float f10) {
        this.f16611g = 0.0f;
        this.f16612h = 2.0f;
        this.f16613i = Color.rgb(237, 91, 91);
        this.f16614j = Paint.Style.FILL_AND_STROKE;
        this.f16615k = "";
        this.f16616l = null;
        this.f16617m = LimitLabelPosition.RIGHT_TOP;
        this.f16611g = f10;
    }

    public void A(Paint.Style style) {
        this.f16614j = style;
    }

    public void m() {
        this.f16616l = null;
    }

    public void n(float f10, float f11, float f12) {
        this.f16616l = new DashPathEffect(new float[]{f10, f11}, f12);
    }

    public DashPathEffect o() {
        return this.f16616l;
    }

    public String p() {
        return this.f16615k;
    }

    public LimitLabelPosition q() {
        return this.f16617m;
    }

    public float r() {
        return this.f16611g;
    }

    public int s() {
        return this.f16613i;
    }

    public float t() {
        return this.f16612h;
    }

    public Paint.Style u() {
        return this.f16614j;
    }

    public boolean v() {
        return this.f16616l != null;
    }

    public void w(String str) {
        this.f16615k = str;
    }

    public void x(LimitLabelPosition limitLabelPosition) {
        this.f16617m = limitLabelPosition;
    }

    public void y(int i10) {
        this.f16613i = i10;
    }

    public void z(float f10) {
        if (f10 < 0.2f) {
            f10 = 0.2f;
        }
        if (f10 > 12.0f) {
            f10 = 12.0f;
        }
        this.f16612h = k.e(f10);
    }

    public LimitLine(float f10, String str) {
        this.f16611g = 0.0f;
        this.f16612h = 2.0f;
        this.f16613i = Color.rgb(237, 91, 91);
        this.f16614j = Paint.Style.FILL_AND_STROKE;
        this.f16615k = "";
        this.f16616l = null;
        this.f16617m = LimitLabelPosition.RIGHT_TOP;
        this.f16611g = f10;
        this.f16615k = str;
    }
}
