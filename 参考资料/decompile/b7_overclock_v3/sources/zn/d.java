package zn;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class d extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.o f58685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.o f58686b;

    public d(gm.f0 f0Var) {
        if (f0Var.size() == 2) {
            this.f58685a = gm.o.M(f0Var.K(0));
            this.f58686b = gm.o.M(f0Var.K(1));
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
    }

    public d(gm.o oVar, gm.o oVar2) {
        this.f58685a = oVar;
        this.f58686b = oVar2;
    }

    public static d x(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj != null) {
            return new d(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f58685a);
        iVar.a(this.f58686b);
        return new j2(iVar);
    }

    public gm.o y() {
        return this.f58686b;
    }

    public gm.o z() {
        return this.f58685a;
    }
}
