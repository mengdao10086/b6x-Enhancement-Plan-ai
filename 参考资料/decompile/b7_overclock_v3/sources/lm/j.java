package lm;

import gm.j2;
import gm.n0;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class j extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f39913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public om.l f39914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public om.p f39915c;

    public j(gm.f0 f0Var) {
        gm.c0 c0VarU;
        this.f39913a = f.z(f0Var.K(0));
        if (f0Var.size() >= 2) {
            if (f0Var.size() == 2) {
                n0 n0VarT = n0.T(f0Var.K(1));
                int iQ = n0VarT.q();
                c0VarU = n0VarT.U();
                if (iQ == 0) {
                    this.f39914b = om.l.x(c0VarU);
                    return;
                }
            } else {
                this.f39914b = om.l.x(n0.T(f0Var.K(1)).U());
                c0VarU = n0.T(f0Var.K(2)).U();
            }
            this.f39915c = om.p.y(c0VarU);
        }
    }

    public j(f fVar) {
        this(fVar, (om.l) null, (om.p) null);
    }

    public j(f fVar, om.l lVar, om.p pVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("'certOrEncCert' cannot be null");
        }
        this.f39913a = fVar;
        this.f39914b = lVar;
        this.f39915c = pVar;
    }

    public j(f fVar, om.m mVar, om.p pVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("'certOrEncCert' cannot be null");
        }
        this.f39913a = fVar;
        this.f39914b = mVar != null ? new om.l(mVar) : null;
        this.f39915c = pVar;
    }

    public static j y(Object obj) {
        if (obj instanceof j) {
            return (j) obj;
        }
        if (obj != null) {
            return new j(gm.f0.J(obj));
        }
        return null;
    }

    public om.p A() {
        return this.f39915c;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f39913a);
        om.l lVar = this.f39914b;
        if (lVar != null) {
            iVar.a(new n2(true, 0, (gm.h) lVar));
        }
        om.p pVar = this.f39915c;
        if (pVar != null) {
            iVar.a(new n2(true, 1, (gm.h) pVar));
        }
        return new j2(iVar);
    }

    public f x() {
        return this.f39913a;
    }

    public om.l z() {
        return this.f39914b;
    }
}
