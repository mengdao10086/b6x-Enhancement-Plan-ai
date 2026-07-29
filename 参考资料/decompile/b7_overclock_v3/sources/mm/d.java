package mm;

import gm.i1;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class d extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f41291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g0 f41292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.h0 f41293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q f41294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public gm.h0 f41295e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public gm.z f41296f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public gm.h0 f41297g;

    public d(gm.f0 f0Var) {
        gm.h0 h0Var;
        gm.t tVarI = gm.t.I(f0Var.K(0).b());
        this.f41291a = tVarI;
        if (!tVarI.L(0)) {
            throw new IllegalArgumentException("AuthEnvelopedData version number must be 0");
        }
        int i10 = 2;
        gm.c0 c0VarB = f0Var.K(1).b();
        if (c0VarB instanceof gm.n0) {
            this.f41292b = g0.z((gm.n0) c0VarB, false);
            c0VarB = f0Var.K(2).b();
            i10 = 3;
        }
        gm.h0 h0VarI = gm.h0.I(c0VarB);
        this.f41293c = h0VarI;
        if (h0VarI.size() == 0) {
            throw new IllegalArgumentException("AuthEnvelopedData requires at least 1 RecipientInfo");
        }
        int i11 = i10 + 1;
        this.f41294d = q.A(f0Var.K(i10).b());
        int i12 = i11 + 1;
        gm.c0 c0VarB2 = f0Var.K(i11).b();
        if (c0VarB2 instanceof gm.n0) {
            this.f41295e = gm.h0.H((gm.n0) c0VarB2, false);
            c0VarB2 = f0Var.K(i12).b();
            i12++;
        } else if (!this.f41294d.y().C(k.I2) && ((h0Var = this.f41295e) == null || h0Var.size() == 0)) {
            throw new IllegalArgumentException("authAttrs must be present with non-data content");
        }
        this.f41296f = gm.z.I(c0VarB2);
        if (f0Var.size() > i12) {
            this.f41297g = gm.h0.H((gm.n0) f0Var.K(i12).b(), false);
        }
    }

    public d(g0 g0Var, gm.h0 h0Var, q qVar, gm.h0 h0Var2, gm.z zVar, gm.h0 h0Var3) {
        this.f41291a = new gm.t(0L);
        this.f41292b = g0Var;
        this.f41293c = h0Var;
        if (h0Var.size() == 0) {
            throw new IllegalArgumentException("AuthEnvelopedData requires at least 1 RecipientInfo");
        }
        this.f41294d = qVar;
        this.f41295e = h0Var2;
        if (!qVar.y().C(k.I2) && (h0Var2 == null || h0Var2.size() == 0)) {
            throw new IllegalArgumentException("authAttrs must be present with non-data content");
        }
        this.f41296f = zVar;
        this.f41297g = h0Var3;
    }

    public static d A(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj != null) {
            return new d(gm.f0.J(obj));
        }
        return null;
    }

    public static d z(gm.n0 n0Var, boolean z10) {
        return A(gm.f0.I(n0Var, z10));
    }

    public gm.z B() {
        return this.f41296f;
    }

    public g0 C() {
        return this.f41292b;
    }

    public gm.h0 D() {
        return this.f41293c;
    }

    public gm.h0 E() {
        return this.f41297g;
    }

    public gm.t F() {
        return this.f41291a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(7);
        iVar.a(this.f41291a);
        g0 g0Var = this.f41292b;
        if (g0Var != null) {
            iVar.a(new n2(false, 0, (gm.h) g0Var));
        }
        iVar.a(this.f41293c);
        iVar.a(this.f41294d);
        gm.h0 h0Var = this.f41295e;
        if (h0Var != null) {
            iVar.a(new n2(false, 1, (gm.h) h0Var));
        }
        iVar.a(this.f41296f);
        gm.h0 h0Var2 = this.f41297g;
        if (h0Var2 != null) {
            iVar.a(new n2(false, 2, (gm.h) h0Var2));
        }
        return new i1(iVar);
    }

    public gm.h0 x() {
        return this.f41295e;
    }

    public q y() {
        return this.f41294d;
    }
}
