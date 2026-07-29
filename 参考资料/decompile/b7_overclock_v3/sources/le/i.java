package le;

import g.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f39608a;

    public i(float f10) {
        this.f39608a = f10 - 0.001f;
    }

    @Override // le.g
    public boolean a() {
        return true;
    }

    @Override // le.g
    public void b(float f10, float f11, float f12, @n0 q qVar) {
        float fSqrt = (float) ((((double) this.f39608a) * Math.sqrt(2.0d)) / 2.0d);
        float fSqrt2 = (float) Math.sqrt(Math.pow(this.f39608a, 2.0d) - Math.pow(fSqrt, 2.0d));
        qVar.q(f11 - fSqrt, ((float) (-((((double) this.f39608a) * Math.sqrt(2.0d)) - ((double) this.f39608a)))) + fSqrt2);
        qVar.n(f11, (float) (-((((double) this.f39608a) * Math.sqrt(2.0d)) - ((double) this.f39608a))));
        qVar.n(f11 + fSqrt, ((float) (-((((double) this.f39608a) * Math.sqrt(2.0d)) - ((double) this.f39608a)))) + fSqrt2);
    }
}
