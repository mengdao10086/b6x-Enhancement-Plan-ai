package um;

import gm.c0;
import gm.f0;
import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class c extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f52227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f52228b;

    public c(f0 f0Var) {
        this.f52227a = (gm.y) f0Var.K(0);
        if (f0Var.size() > 1) {
            this.f52228b = f0Var.K(1);
        }
    }

    public c(gm.y yVar) {
        this(yVar, null);
    }

    public c(gm.y yVar, gm.h hVar) {
        this.f52227a = yVar;
        this.f52228b = hVar;
    }

    public static c y(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj != null) {
            return new c(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f52227a);
        gm.h hVar = this.f52228b;
        if (hVar != null) {
            iVar.a(hVar);
        }
        return new j2(iVar);
    }

    public gm.y x() {
        return this.f52227a;
    }

    public gm.h z() {
        return this.f52228b;
    }
}
