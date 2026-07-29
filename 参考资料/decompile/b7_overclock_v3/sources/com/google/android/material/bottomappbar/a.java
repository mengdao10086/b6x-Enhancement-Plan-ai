package com.google.android.material.bottomappbar;

import androidx.annotation.RestrictTo;
import g.n0;
import g.x;
import le.g;
import le.q;

/* JADX INFO: loaded from: classes3.dex */
public class a extends g implements Cloneable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f19701g = 90;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f19702h = 180;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f19703i = 270;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f19704j = 180;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final float f19705k = 1.75f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f19706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f19707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f19708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f19709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f19710e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f19711f = -1.0f;

    public a(float f10, float f11, float f12) {
        this.f19707b = f10;
        this.f19706a = f11;
        j(f12);
        this.f19710e = 0.0f;
    }

    @Override // le.g
    public void b(float f10, float f11, float f12, @n0 q qVar) {
        float f13;
        float f14;
        float f15 = this.f19708c;
        if (f15 == 0.0f) {
            qVar.n(f10, 0.0f);
            return;
        }
        float f16 = ((this.f19707b * 2.0f) + f15) / 2.0f;
        float f17 = f12 * this.f19706a;
        float f18 = f11 + this.f19710e;
        float f19 = (this.f19709d * f12) + ((1.0f - f12) * f16);
        if (f19 / f16 >= 1.0f) {
            qVar.n(f10, 0.0f);
            return;
        }
        float f20 = this.f19711f;
        float f21 = f20 * f12;
        boolean z10 = f20 == -1.0f || Math.abs((f20 * 2.0f) - f15) < 0.1f;
        if (z10) {
            f13 = f19;
            f14 = 0.0f;
        } else {
            f14 = 1.75f;
            f13 = 0.0f;
        }
        float f22 = f16 + f17;
        float f23 = f13 + f17;
        float fSqrt = (float) Math.sqrt((f22 * f22) - (f23 * f23));
        float f24 = f18 - fSqrt;
        float f25 = f18 + fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan(fSqrt / f23));
        float f26 = (90.0f - degrees) + f14;
        qVar.n(f24, 0.0f);
        float f27 = f17 * 2.0f;
        qVar.a(f24 - f17, 0.0f, f24 + f17, f27, 270.0f, degrees);
        if (z10) {
            qVar.a(f18 - f16, (-f16) - f13, f18 + f16, f16 - f13, 180.0f - f26, (f26 * 2.0f) - 180.0f);
        } else {
            float f28 = this.f19707b;
            float f29 = f21 * 2.0f;
            float f30 = f18 - f16;
            qVar.a(f30, -(f21 + f28), f30 + f28 + f29, f28 + f21, 180.0f - f26, ((f26 * 2.0f) - 180.0f) / 2.0f);
            float f31 = f18 + f16;
            float f32 = this.f19707b;
            qVar.n(f31 - ((f32 / 2.0f) + f21), f32 + f21);
            float f33 = this.f19707b;
            qVar.a(f31 - (f29 + f33), -(f21 + f33), f31, f33 + f21, 90.0f, f26 - 90.0f);
        }
        qVar.a(f25 - f17, 0.0f, f25 + f17, f27, 270.0f - degrees, degrees);
        qVar.n(f10, 0.0f);
    }

    public float d() {
        return this.f19709d;
    }

    public float e() {
        return this.f19711f;
    }

    public float f() {
        return this.f19707b;
    }

    public float g() {
        return this.f19706a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float h() {
        return this.f19708c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float i() {
        return this.f19710e;
    }

    public void j(@x(from = 0.0d) float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.f19709d = f10;
    }

    public void k(float f10) {
        this.f19711f = f10;
    }

    public void l(float f10) {
        this.f19707b = f10;
    }

    public void m(float f10) {
        this.f19706a = f10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void n(float f10) {
        this.f19708c = f10;
    }

    public void o(float f10) {
        this.f19710e = f10;
    }
}
