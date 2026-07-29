package af;

/* JADX INFO: loaded from: classes7.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f633e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f635g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f636h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f637i;

    public n(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        this.f629a = f10;
        this.f630b = f13;
        this.f631c = f16;
        this.f632d = f11;
        this.f633e = f14;
        this.f634f = f17;
        this.f635g = f12;
        this.f636h = f15;
        this.f637i = f18;
    }

    public static n b(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25) {
        return d(f18, f19, f20, f21, f22, f23, f24, f25).e(c(f10, f11, f12, f13, f14, f15, f16, f17));
    }

    public static n c(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        return d(f10, f11, f12, f13, f14, f15, f16, f17).a();
    }

    public static n d(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        float f18 = ((f10 - f12) + f14) - f16;
        float f19 = ((f11 - f13) + f15) - f17;
        if (f18 == 0.0f && f19 == 0.0f) {
            return new n(f12 - f10, f14 - f12, f10, f13 - f11, f15 - f13, f11, 0.0f, 0.0f, 1.0f);
        }
        float f20 = f12 - f14;
        float f21 = f16 - f14;
        float f22 = f13 - f15;
        float f23 = f17 - f15;
        float f24 = (f20 * f23) - (f21 * f22);
        float f25 = ((f23 * f18) - (f21 * f19)) / f24;
        float f26 = ((f20 * f19) - (f18 * f22)) / f24;
        return new n((f25 * f12) + (f12 - f10), (f26 * f16) + (f16 - f10), f10, (f13 - f11) + (f25 * f13), (f17 - f11) + (f26 * f17), f11, f25, f26, 1.0f);
    }

    public n a() {
        float f10 = this.f633e;
        float f11 = this.f637i;
        float f12 = this.f634f;
        float f13 = this.f636h;
        float f14 = (f10 * f11) - (f12 * f13);
        float f15 = this.f635g;
        float f16 = this.f632d;
        float f17 = (f12 * f15) - (f16 * f11);
        float f18 = (f16 * f13) - (f10 * f15);
        float f19 = this.f631c;
        float f20 = this.f630b;
        float f21 = (f19 * f13) - (f20 * f11);
        float f22 = this.f629a;
        return new n(f14, f17, f18, f21, (f11 * f22) - (f19 * f15), (f15 * f20) - (f13 * f22), (f20 * f12) - (f19 * f10), (f19 * f16) - (f12 * f22), (f22 * f10) - (f20 * f16));
    }

    public n e(n nVar) {
        float f10 = this.f629a;
        float f11 = nVar.f629a;
        float f12 = this.f632d;
        float f13 = nVar.f630b;
        float f14 = this.f635g;
        float f15 = nVar.f631c;
        float f16 = (f10 * f11) + (f12 * f13) + (f14 * f15);
        float f17 = nVar.f632d;
        float f18 = nVar.f633e;
        float f19 = nVar.f634f;
        float f20 = (f10 * f17) + (f12 * f18) + (f14 * f19);
        float f21 = nVar.f635g;
        float f22 = nVar.f636h;
        float f23 = nVar.f637i;
        float f24 = (f10 * f21) + (f12 * f22) + (f14 * f23);
        float f25 = this.f630b;
        float f26 = this.f633e;
        float f27 = this.f636h;
        float f28 = (f25 * f11) + (f26 * f13) + (f27 * f15);
        float f29 = (f25 * f17) + (f26 * f18) + (f27 * f19);
        float f30 = (f27 * f23) + (f25 * f21) + (f26 * f22);
        float f31 = this.f631c;
        float f32 = this.f634f;
        float f33 = (f11 * f31) + (f13 * f32);
        float f34 = this.f637i;
        return new n(f16, f20, f24, f28, f29, f30, (f15 * f34) + f33, (f17 * f31) + (f18 * f32) + (f19 * f34), (f31 * f21) + (f32 * f22) + (f34 * f23));
    }

    public void f(float[] fArr) {
        float f10 = this.f629a;
        float f11 = this.f630b;
        float f12 = this.f631c;
        float f13 = this.f632d;
        float f14 = this.f633e;
        float f15 = this.f634f;
        float f16 = this.f635g;
        float f17 = this.f636h;
        float f18 = this.f637i;
        int length = fArr.length - 1;
        for (int i10 = 0; i10 < length; i10 += 2) {
            float f19 = fArr[i10];
            int i11 = i10 + 1;
            float f20 = fArr[i11];
            float f21 = (f12 * f19) + (f15 * f20) + f18;
            fArr[i10] = (((f10 * f19) + (f13 * f20)) + f16) / f21;
            fArr[i11] = (((f19 * f11) + (f20 * f14)) + f17) / f21;
        }
    }

    public void g(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            float f10 = fArr[i10];
            float f11 = fArr2[i10];
            float f12 = (this.f631c * f10) + (this.f634f * f11) + this.f637i;
            fArr[i10] = (((this.f629a * f10) + (this.f632d * f11)) + this.f635g) / f12;
            fArr2[i10] = (((this.f630b * f10) + (this.f633e * f11)) + this.f636h) / f12;
        }
    }
}
