package le;

import g.n0;

/* JADX INFO: loaded from: classes3.dex */
public class f extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f39600a;

    public f() {
        this.f39600a = -1.0f;
    }

    @Override // le.e
    public void b(@n0 q qVar, float f10, float f11, float f12) {
        qVar.r(0.0f, f12 * f11, 180.0f, 180.0f - f10);
        double d10 = f12;
        double d11 = f11;
        qVar.n((float) (Math.sin(Math.toRadians(f10)) * d10 * d11), (float) (Math.sin(Math.toRadians(90.0f - f10)) * d10 * d11));
    }

    @Deprecated
    public f(float f10) {
        this.f39600a = f10;
    }
}
