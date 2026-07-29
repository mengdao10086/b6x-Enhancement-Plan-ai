package lm;

/* JADX INFO: loaded from: classes5.dex */
public class e extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.f0 f39888a;

    public e(gm.f0 f0Var) {
        this.f39888a = f0Var;
    }

    public static e x(Object obj) {
        if (obj instanceof e) {
            return (e) obj;
        }
        if (obj != null) {
            return new e(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f39888a;
    }

    public i[] y() {
        int size = this.f39888a.size();
        i[] iVarArr = new i[size];
        for (int i10 = 0; i10 != size; i10++) {
            iVarArr[i10] = i.z(this.f39888a.K(i10));
        }
        return iVarArr;
    }
}
