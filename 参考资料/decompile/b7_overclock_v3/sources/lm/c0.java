package lm;

/* JADX INFO: loaded from: classes5.dex */
public class c0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.f0 f39885a;

    public c0(gm.f0 f0Var) {
        this.f39885a = f0Var;
    }

    public static c0 x(Object obj) {
        if (obj instanceof c0) {
            return (c0) obj;
        }
        if (obj != null) {
            return new c0(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f39885a;
    }

    public k[] y() {
        int size = this.f39885a.size();
        k[] kVarArr = new k[size];
        for (int i10 = 0; i10 != size; i10++) {
            kVarArr[i10] = k.z(this.f39885a.K(i10));
        }
        return kVarArr;
    }
}
