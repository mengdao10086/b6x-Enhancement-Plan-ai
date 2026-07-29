package lm;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class z extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.f0 f40030a;

    public z(gm.f0 f0Var) {
        this.f40030a = f0Var;
    }

    public z(y yVar) {
        this.f40030a = new j2(yVar);
    }

    public z(y[] yVarArr) {
        this.f40030a = new j2(yVarArr);
    }

    public static z x(Object obj) {
        if (obj instanceof z) {
            return (z) obj;
        }
        if (obj != null) {
            return new z(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f40030a;
    }

    public y[] y() {
        int size = this.f40030a.size();
        y[] yVarArr = new y[size];
        for (int i10 = 0; i10 != size; i10++) {
            yVarArr[i10] = y.B(this.f40030a.K(i10));
        }
        return yVarArr;
    }
}
