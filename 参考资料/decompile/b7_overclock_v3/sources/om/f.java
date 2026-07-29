package om;

import gm.c0;
import gm.f0;
import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class f extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f44279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f44280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f44281c;

    public f(int i10, g gVar, i iVar) {
        this(new gm.t(i10), gVar, iVar);
    }

    public f(f0 f0Var) {
        this.f44279a = new gm.t(gm.t.I(f0Var.K(0)).K());
        this.f44280b = g.y(f0Var.K(1));
        if (f0Var.size() > 2) {
            this.f44281c = i.x(f0Var.K(2));
        }
    }

    public f(gm.t tVar, g gVar, i iVar) {
        this.f44279a = tVar;
        this.f44280b = gVar;
        this.f44281c = iVar;
    }

    public static f A(Object obj) {
        if (obj instanceof f) {
            return (f) obj;
        }
        if (obj != null) {
            return new f(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f44279a);
        iVar.a(this.f44280b);
        i iVar2 = this.f44281c;
        if (iVar2 != null) {
            iVar.a(iVar2);
        }
        return new j2(iVar);
    }

    public gm.t x() {
        return this.f44279a;
    }

    public g y() {
        return this.f44280b;
    }

    public i z() {
        return this.f44281c;
    }
}
