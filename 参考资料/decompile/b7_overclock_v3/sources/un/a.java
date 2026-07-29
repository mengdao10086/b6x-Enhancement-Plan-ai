package un;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.t;
import gm.w;

/* JADX INFO: loaded from: classes5.dex */
public class a extends w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f52284d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f52285e = 999;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f52286f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f52287g = 999;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f52288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f52289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t f52290c;

    public a() {
    }

    public a(f0 f0Var) {
        this.f52288a = null;
        this.f52289b = null;
        this.f52290c = null;
        for (int i10 = 0; i10 < f0Var.size(); i10++) {
            if (f0Var.K(i10) instanceof t) {
                this.f52288a = (t) f0Var.K(i10);
            } else if (f0Var.K(i10) instanceof n0) {
                n0 n0Var = (n0) f0Var.K(i10);
                int iQ = n0Var.q();
                if (iQ == 0) {
                    t tVarH = t.H(n0Var, false);
                    this.f52289b = tVarH;
                    int iQ2 = tVarH.Q();
                    if (iQ2 < 1 || iQ2 > 999) {
                        throw new IllegalArgumentException("Invalid millis field : not in (1..999)");
                    }
                } else {
                    if (iQ != 1) {
                        throw new IllegalArgumentException("Invalid tag number");
                    }
                    t tVarH2 = t.H(n0Var, false);
                    this.f52290c = tVarH2;
                    int iQ3 = tVarH2.Q();
                    if (iQ3 < 1 || iQ3 > 999) {
                        throw new IllegalArgumentException("Invalid micros field : not in (1..999)");
                    }
                }
            } else {
                continue;
            }
        }
    }

    public a(t tVar, t tVar2, t tVar3) {
        int iQ;
        int iQ2;
        if (tVar2 != null && ((iQ2 = tVar2.Q()) < 1 || iQ2 > 999)) {
            throw new IllegalArgumentException("Invalid millis field : not in (1..999)");
        }
        if (tVar3 != null && ((iQ = tVar3.Q()) < 1 || iQ > 999)) {
            throw new IllegalArgumentException("Invalid micros field : not in (1..999)");
        }
        this.f52288a = tVar;
        this.f52289b = tVar2;
        this.f52290c = tVar3;
    }

    public static a x(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(f0.J(obj));
        }
        return null;
    }

    public t A() {
        return this.f52288a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(3);
        t tVar = this.f52288a;
        if (tVar != null) {
            iVar.a(tVar);
        }
        t tVar2 = this.f52289b;
        if (tVar2 != null) {
            iVar.a(new n2(false, 0, (gm.h) tVar2));
        }
        t tVar3 = this.f52290c;
        if (tVar3 != null) {
            iVar.a(new n2(false, 1, (gm.h) tVar3));
        }
        return new j2(iVar);
    }

    public t y() {
        return this.f52290c;
    }

    public t z() {
        return this.f52289b;
    }
}
