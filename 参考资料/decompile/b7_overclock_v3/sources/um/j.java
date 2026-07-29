package um;

import gm.c0;
import gm.f0;
import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class j extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public nn.j f52253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.o f52254b;

    public j(f0 f0Var) {
        if (f0Var.size() == 2) {
            this.f52253a = nn.j.y(f0Var.K(0));
            this.f52254b = (gm.o) f0Var.K(1);
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
    }

    public j(nn.j jVar, gm.o oVar) {
        this.f52253a = jVar;
        this.f52254b = oVar;
    }

    public static j x(Object obj) {
        if (obj instanceof j) {
            return (j) obj;
        }
        if (obj != null) {
            return new j(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f52253a);
        iVar.a(this.f52254b);
        return new j2(iVar);
    }

    public nn.j y() {
        return this.f52253a;
    }

    public gm.o z() {
        return this.f52254b;
    }
}
