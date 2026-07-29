package un;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.w;
import mm.n;
import mm.s0;
import pn.s;

/* JADX INFO: loaded from: classes5.dex */
public class b extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zn.b f52291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mm.c f52292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f0 f52293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f52294d;

    public b(f0 f0Var) {
        if (f0Var.size() < 1 || f0Var.size() > 4) {
            throw new IllegalArgumentException("wrong sequence size in constructor: " + f0Var.size());
        }
        zn.b bVarY = null;
        mm.c cVarY = null;
        f0 f0VarI = null;
        for (int i10 = 0; i10 < f0Var.size() - 1; i10++) {
            gm.h hVarK = f0Var.K(i10);
            if (hVarK instanceof n0) {
                n0 n0VarT = n0.T(hVarK);
                int iQ = n0VarT.q();
                if (iQ == 0) {
                    bVarY = zn.b.y(n0VarT, false);
                } else if (iQ == 1) {
                    cVarY = mm.c.y(n0VarT, false);
                } else {
                    if (iQ != 2) {
                        throw new IllegalArgumentException("invalid tag no in constructor: " + n0VarT.q());
                    }
                    f0VarI = f0.I(n0VarT, false);
                }
            }
        }
        this.f52291a = bVarY;
        this.f52292b = cVarY;
        this.f52293c = f0VarI;
        this.f52294d = n.A(f0Var.K(f0Var.size() - 1));
    }

    public b(n nVar) {
        this(null, null, null, nVar);
    }

    public b(zn.b bVar, mm.c cVar, i[] iVarArr, n nVar) {
        this.f52291a = bVar;
        this.f52292b = cVar;
        this.f52293c = iVarArr != null ? new j2(iVarArr) : null;
        this.f52294d = nVar;
    }

    public b(zn.b bVar, i[] iVarArr, n nVar) {
        this(bVar, null, iVarArr, nVar);
    }

    public static b z(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(f0.J(obj));
        }
        return null;
    }

    public i[] A() {
        f0 f0Var = this.f52293c;
        if (f0Var == null) {
            return null;
        }
        int size = f0Var.size();
        i[] iVarArr = new i[size];
        for (int i10 = 0; i10 != size; i10++) {
            iVarArr[i10] = i.y(this.f52293c.K(i10));
        }
        return iVarArr;
    }

    public n B() {
        return this.f52294d;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(4);
        zn.b bVar = this.f52291a;
        if (bVar != null) {
            iVar.a(new n2(false, 0, (gm.h) bVar));
        }
        mm.c cVar = this.f52292b;
        if (cVar != null) {
            iVar.a(new n2(false, 1, (gm.h) cVar));
        }
        f0 f0Var = this.f52293c;
        if (f0Var != null) {
            iVar.a(new n2(false, 2, (gm.h) f0Var));
        }
        iVar.a(this.f52294d);
        return new j2(iVar);
    }

    public zn.b x() {
        return this.f52291a;
    }

    public zn.b y() {
        zn.b bVar = this.f52291a;
        if (bVar != null) {
            return bVar;
        }
        if (!this.f52294d.y().C(mm.k.J2)) {
            throw new IllegalStateException("cannot identify algorithm identifier for digest");
        }
        s0 s0VarD = s0.D(this.f52294d.x());
        if (s0VarD.C().y().C(s.X4)) {
            return j.A(s0VarD.C()).B().x();
        }
        throw new IllegalStateException("cannot parse time stamp");
    }
}
