package om;

import gm.c0;
import gm.f0;
import gm.j2;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class p extends gm.w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gm.t f44322c = new gm.t(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gm.t f44323d = new gm.t(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f44324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f44325b;

    public p(f0 f0Var) {
        this.f44324a = gm.t.I(f0Var.K(0));
        if (f0Var.size() > 1) {
            this.f44325b = f0.J(f0Var.K(1));
        }
    }

    public p(gm.t tVar) {
        this.f44324a = tVar;
    }

    public p(BigInteger bigInteger) {
        this(new gm.t(bigInteger));
    }

    public p(v vVar) {
        this(vVar != null ? new v[]{vVar} : null);
    }

    public p(v[] vVarArr) {
        this.f44324a = f44323d;
        if (vVarArr != null) {
            this.f44325b = new j2(vVarArr);
        } else {
            this.f44325b = null;
        }
    }

    public static p y(Object obj) {
        if (obj instanceof p) {
            return (p) obj;
        }
        if (obj != null) {
            return new p(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f44324a);
        f0 f0Var = this.f44325b;
        if (f0Var != null) {
            iVar.a(f0Var);
        }
        return new j2(iVar);
    }

    public gm.t x() {
        return this.f44324a;
    }

    public v[] z() {
        f0 f0Var = this.f44325b;
        if (f0Var == null) {
            return null;
        }
        int size = f0Var.size();
        v[] vVarArr = new v[size];
        for (int i10 = 0; i10 != size; i10++) {
            vVarArr[i10] = v.x(this.f44325b.K(i10));
        }
        return vVarArr;
    }
}
