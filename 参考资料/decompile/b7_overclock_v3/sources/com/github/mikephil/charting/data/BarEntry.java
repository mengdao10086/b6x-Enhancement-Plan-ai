package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import oa.j;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ParcelCreator"})
public class BarEntry extends Entry {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f16624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j[] f16625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f16626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f16627h;

    public BarEntry(float f10, float f11) {
        super(f10, f11);
    }

    public static float U(float[] fArr) {
        float f10 = 0.0f;
        if (fArr == null) {
            return 0.0f;
        }
        for (float f11 : fArr) {
            f10 += f11;
        }
        return f10;
    }

    public final void S() {
        float[] fArr = this.f16624e;
        if (fArr == null) {
            this.f16626g = 0.0f;
            this.f16627h = 0.0f;
            return;
        }
        float fAbs = 0.0f;
        float f10 = 0.0f;
        for (float f11 : fArr) {
            if (f11 <= 0.0f) {
                fAbs += Math.abs(f11);
            } else {
                f10 += f11;
            }
        }
        this.f16626g = fAbs;
        this.f16627h = f10;
    }

    public void T() {
        float[] fArrB0 = b0();
        if (fArrB0 == null || fArrB0.length == 0) {
            return;
        }
        this.f16625f = new j[fArrB0.length];
        float f10 = -X();
        int i10 = 0;
        float f11 = 0.0f;
        while (true) {
            j[] jVarArr = this.f16625f;
            if (i10 >= jVarArr.length) {
                return;
            }
            float f12 = fArrB0[i10];
            if (f12 < 0.0f) {
                float f13 = f10 - f12;
                jVarArr[i10] = new j(f10, f13);
                f10 = f13;
            } else {
                float f14 = f12 + f11;
                jVarArr[i10] = new j(f11, f14);
                f11 = f14;
            }
            i10++;
        }
    }

    @Override // com.github.mikephil.charting.data.Entry
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public BarEntry z() {
        BarEntry barEntry = new BarEntry(F(), e(), a());
        barEntry.d0(this.f16624e);
        return barEntry;
    }

    @Deprecated
    public float W(int i10) {
        return a0(i10);
    }

    public float X() {
        return this.f16626g;
    }

    public float Y() {
        return this.f16627h;
    }

    public j[] Z() {
        return this.f16625f;
    }

    public float a0(int i10) {
        float[] fArr = this.f16624e;
        float f10 = 0.0f;
        if (fArr == null) {
            return 0.0f;
        }
        for (int length = fArr.length - 1; length > i10 && length >= 0; length--) {
            f10 += this.f16624e[length];
        }
        return f10;
    }

    public float[] b0() {
        return this.f16624e;
    }

    public boolean c0() {
        return this.f16624e != null;
    }

    public void d0(float[] fArr) {
        s(U(fArr));
        this.f16624e = fArr;
        S();
        T();
    }

    @Override // la.f
    public float e() {
        return super.e();
    }

    public BarEntry(float f10, float f11, Object obj) {
        super(f10, f11, obj);
    }

    public BarEntry(float f10, float f11, Drawable drawable) {
        super(f10, f11, drawable);
    }

    public BarEntry(float f10, float f11, Drawable drawable, Object obj) {
        super(f10, f11, drawable, obj);
    }

    public BarEntry(float f10, float[] fArr) {
        super(f10, U(fArr));
        this.f16624e = fArr;
        S();
        T();
    }

    public BarEntry(float f10, float[] fArr, Object obj) {
        super(f10, U(fArr), obj);
        this.f16624e = fArr;
        S();
        T();
    }

    public BarEntry(float f10, float[] fArr, Drawable drawable) {
        super(f10, U(fArr), drawable);
        this.f16624e = fArr;
        S();
        T();
    }

    public BarEntry(float f10, float[] fArr, Drawable drawable, Object obj) {
        super(f10, U(fArr), drawable, obj);
        this.f16624e = fArr;
        S();
        T();
    }
}
