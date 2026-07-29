package rm;

import gm.c0;
import gm.n0;
import gm.o;
import gm.w;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public class j extends w implements gm.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f48894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mm.n f48895b;

    public j(o oVar) {
        this.f48894a = oVar;
        this.f48895b = null;
    }

    public j(Date date) {
        this(new o(date));
    }

    public j(mm.n nVar) {
        this.f48894a = null;
        this.f48895b = nVar;
    }

    public static j y(n0 n0Var, boolean z10) {
        return z(n0Var.U());
    }

    public static j z(Object obj) {
        if (obj instanceof j) {
            return (j) obj;
        }
        if (obj instanceof o) {
            return new j(o.M(obj));
        }
        if (obj != null) {
            return new j(mm.n.A(obj));
        }
        return null;
    }

    public mm.n A() {
        return this.f48895b;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        o oVar = this.f48894a;
        return oVar != null ? oVar : this.f48895b.b();
    }

    public String toString() {
        o oVar = this.f48894a;
        return oVar != null ? oVar.toString() : this.f48895b.toString();
    }

    public o x() {
        return this.f48894a;
    }
}
