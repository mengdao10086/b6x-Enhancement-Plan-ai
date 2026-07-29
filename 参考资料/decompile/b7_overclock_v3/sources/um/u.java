package um;

import gm.c0;
import gm.f0;
import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class u extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f52274a;

    public u(f0 f0Var) {
        this.f52274a = f0Var;
    }

    public u(t[] tVarArr) {
        this.f52274a = new j2(tVarArr);
    }

    public static u y(Object obj) {
        if (obj instanceof u) {
            return (u) obj;
        }
        if (obj instanceof f0) {
            return new u(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f52274a;
    }

    public int size() {
        return this.f52274a.size();
    }

    public t x(int i10) {
        return t.x(this.f52274a.K(i10));
    }
}
