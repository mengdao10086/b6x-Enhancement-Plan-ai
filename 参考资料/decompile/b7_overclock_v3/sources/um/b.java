package um;

import gm.c0;
import gm.f0;
import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class b extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f52225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f52226b;

    public b(f0 f0Var) {
        this.f52225a = (gm.y) f0Var.K(0);
        if (f0Var.size() > 1) {
            this.f52226b = (f0) f0Var.K(1);
        }
    }

    public b(gm.y yVar) {
        this.f52225a = yVar;
    }

    public b(gm.y yVar, f0 f0Var) {
        this.f52225a = yVar;
        this.f52226b = f0Var;
    }

    public static b z(Object obj) {
        return (obj == null || (obj instanceof b)) ? (b) obj : new b(f0.J(obj));
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f52225a);
        f0 f0Var = this.f52226b;
        if (f0Var != null) {
            iVar.a(f0Var);
        }
        return new j2(iVar);
    }

    public gm.y x() {
        return this.f52225a;
    }

    public f0 y() {
        return this.f52226b;
    }
}
