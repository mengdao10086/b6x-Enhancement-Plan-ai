package zn;

import gm.c2;
import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class v0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f59013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f59014b;

    public v0(gm.f0 f0Var) {
        if (f0Var.size() == 2) {
            this.f59013a = gm.y.N(f0Var.K(0));
            this.f59014b = f0Var.K(1);
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
    }

    public v0(gm.y yVar, gm.h hVar) {
        this.f59013a = yVar;
        this.f59014b = hVar;
    }

    public v0(String str) {
        this.f59013a = u0.f58980g;
        this.f59014b = new c2(str);
    }

    public static v0 x(Object obj) {
        if (obj instanceof v0) {
            return (v0) obj;
        }
        if (obj != null) {
            return new v0(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f59013a);
        iVar.a(this.f59014b);
        return new j2(iVar);
    }

    public gm.y y() {
        return this.f59013a;
    }

    public gm.h z() {
        return this.f59014b;
    }
}
