package le;

import g.n0;

/* JADX INFO: loaded from: classes3.dex */
public class n extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f39663a;

    public n() {
        this.f39663a = -1.0f;
    }

    @Override // le.e
    public void b(@n0 q qVar, float f10, float f11, float f12) {
        qVar.r(0.0f, f12 * f11, 180.0f, 180.0f - f10);
        float f13 = f12 * 2.0f * f11;
        qVar.a(0.0f, 0.0f, f13, f13, 180.0f, f10);
    }

    @Deprecated
    public n(float f10) {
        this.f39663a = f10;
    }
}
