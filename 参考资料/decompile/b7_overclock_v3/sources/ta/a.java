package ta;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f50998d = new a(0.0f, 0.0f, 0.0f);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f50999e = new a(1.0f, 0.0f, 0.0f);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f51000f = new a(0.0f, 1.0f, 0.0f);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f51001g = new a(0.0f, 0.0f, 1.0f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f51002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f51003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f51004c;

    public a() {
    }

    public final void a(float f10, float f11, float f12) {
        this.f51002a += f10;
        this.f51003b += f11;
        this.f51004c += f12;
    }

    public final void b(a aVar) {
        this.f51002a += aVar.f51002a;
        this.f51003b += aVar.f51003b;
        this.f51004c += aVar.f51004c;
    }

    public final a c(a aVar) {
        float f10 = this.f51003b;
        float f11 = aVar.f51004c;
        float f12 = this.f51004c;
        float f13 = aVar.f51003b;
        float f14 = (f10 * f11) - (f12 * f13);
        float f15 = aVar.f51002a;
        float f16 = this.f51002a;
        return new a(f14, (f12 * f15) - (f11 * f16), (f16 * f13) - (f10 * f15));
    }

    public final float d(a aVar) {
        float f10 = this.f51002a - aVar.f51002a;
        float f11 = this.f51003b - aVar.f51003b;
        float f12 = this.f51004c - aVar.f51004c;
        return (f10 * f10) + (f11 * f11) + (f12 * f12);
    }

    public final void e(float f10) {
        if (f10 != 0.0f) {
            this.f51002a /= f10;
            this.f51003b /= f10;
            this.f51004c /= f10;
        }
    }

    public final float f(a aVar) {
        return (this.f51002a * aVar.f51002a) + (this.f51003b * aVar.f51003b) + (this.f51004c * aVar.f51004c);
    }

    public final float g() {
        return (float) Math.sqrt(h());
    }

    public final float h() {
        float f10 = this.f51002a;
        float f11 = this.f51003b;
        float f12 = (f10 * f10) + (f11 * f11);
        float f13 = this.f51004c;
        return f12 + (f13 * f13);
    }

    public final void i(float f10) {
        this.f51002a *= f10;
        this.f51003b *= f10;
        this.f51004c *= f10;
    }

    public final void j(a aVar) {
        this.f51002a *= aVar.f51002a;
        this.f51003b *= aVar.f51003b;
        this.f51004c *= aVar.f51004c;
    }

    public final float k() {
        float fG = g();
        if (fG != 0.0f) {
            this.f51002a /= fG;
            this.f51003b /= fG;
            this.f51004c /= fG;
        }
        return fG;
    }

    public final boolean l(a aVar) {
        return f(aVar) > 0.0f;
    }

    public final void m(float f10, float f11, float f12) {
        this.f51002a = f10;
        this.f51003b = f11;
        this.f51004c = f12;
    }

    public final void n(a aVar) {
        this.f51002a = aVar.f51002a;
        this.f51003b = aVar.f51003b;
        this.f51004c = aVar.f51004c;
    }

    public final void o(a aVar) {
        this.f51002a -= aVar.f51002a;
        this.f51003b -= aVar.f51003b;
        this.f51004c -= aVar.f51004c;
    }

    public final void p(a aVar, float f10) {
        this.f51002a -= aVar.f51002a * f10;
        this.f51003b -= aVar.f51003b * f10;
        this.f51004c -= aVar.f51004c * f10;
    }

    public final void q() {
        m(0.0f, 0.0f, 0.0f);
    }

    public a(float[] fArr) {
        m(fArr[0], fArr[1], fArr[2]);
    }

    public a(float f10, float f11, float f12) {
        m(f10, f11, f12);
    }

    public a(a aVar) {
        n(aVar);
    }
}
