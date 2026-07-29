package le;

import g.n0;

/* JADX INFO: loaded from: classes3.dex */
public class t extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f39751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f39752b;

    public t(float f10, boolean z10) {
        this.f39751a = f10;
        this.f39752b = z10;
    }

    @Override // le.g
    public void b(float f10, float f11, float f12, @n0 q qVar) {
        if (!this.f39752b) {
            float f13 = this.f39751a;
            qVar.o(f11 - (f13 * f12), 0.0f, f11, (-f13) * f12);
            qVar.o(f11 + (this.f39751a * f12), 0.0f, f10, 0.0f);
        } else {
            qVar.n(f11 - (this.f39751a * f12), 0.0f);
            float f14 = this.f39751a;
            qVar.o(f11, f14 * f12, (f14 * f12) + f11, 0.0f);
            qVar.n(f10, 0.0f);
        }
    }
}
