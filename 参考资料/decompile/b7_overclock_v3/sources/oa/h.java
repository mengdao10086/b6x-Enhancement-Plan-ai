package oa;

import ja.h;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h<T extends ja.h> implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f43023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<d> f43024b = new ArrayList();

    public h(T t10) {
        this.f43023a = t10;
    }

    @Override // oa.f
    public d a(float f10, float f11) {
        if (this.f43023a.Z(f10, f11) > this.f43023a.getRadius()) {
            return null;
        }
        float fA0 = this.f43023a.a0(f10, f11);
        T t10 = this.f43023a;
        if (t10 instanceof ja.g) {
            fA0 /= t10.getAnimator().i();
        }
        int iB0 = this.f43023a.b0(fA0);
        if (iB0 < 0 || iB0 >= this.f43023a.getData().w().e1()) {
            return null;
        }
        return b(iB0, f10, f11);
    }

    public abstract d b(int i10, float f10, float f11);
}
