package le;

import g.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f39660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f39661b;

    public l(@n0 g gVar, float f10) {
        this.f39660a = gVar;
        this.f39661b = f10;
    }

    @Override // le.g
    public boolean a() {
        return this.f39660a.a();
    }

    @Override // le.g
    public void b(float f10, float f11, float f12, @n0 q qVar) {
        this.f39660a.b(f10, f11 - this.f39661b, f12, qVar);
    }
}
