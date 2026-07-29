package pn;

import gm.d3;
import gm.f0;
import gm.h0;
import gm.n0;
import gm.z2;

/* JADX INFO: loaded from: classes5.dex */
public class b0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f46733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f46734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h0 f46735c;

    public b0(f0 f0Var) {
        this.f46733a = (gm.y) f0Var.K(0);
        this.f46734b = ((n0) f0Var.K(1)).U();
        if (f0Var.size() == 3) {
            this.f46735c = (h0) f0Var.K(2);
        }
    }

    public b0(gm.y yVar, gm.h hVar) {
        this.f46733a = yVar;
        this.f46734b = hVar;
        this.f46735c = null;
    }

    public b0(gm.y yVar, gm.h hVar, h0 h0Var) {
        this.f46733a = yVar;
        this.f46734b = hVar;
        this.f46735c = h0Var;
    }

    public static b0 A(Object obj) {
        if (obj instanceof b0) {
            return (b0) obj;
        }
        if (obj != null) {
            return new b0(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f46733a);
        iVar.a(new d3(true, 0, this.f46734b));
        h0 h0Var = this.f46735c;
        if (h0Var != null) {
            iVar.a(h0Var);
        }
        return new z2(iVar);
    }

    public h0 x() {
        return this.f46735c;
    }

    public gm.y y() {
        return this.f46733a;
    }

    public gm.h z() {
        return this.f46734b;
    }
}
