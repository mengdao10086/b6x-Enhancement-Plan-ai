package im;

import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.w;
import zn.b0;
import zn.c0;
import zn.t;

/* JADX INFO: loaded from: classes5.dex */
public class e extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f32511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b0 f32512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public xn.d f32513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c0 f32514d;

    public e(f0 f0Var) {
        this.f32511a = t.A(f0Var.K(0));
        this.f32512b = b0.z(f0Var.K(1));
        if (f0Var.size() > 2) {
            for (int i10 = 2; i10 != f0Var.size(); i10++) {
                n0 n0VarT = n0.T(f0Var.K(i10));
                int iQ = n0VarT.q();
                if (iQ == 0) {
                    this.f32513c = xn.d.z(n0VarT, false);
                } else {
                    if (iQ != 1) {
                        throw new IllegalArgumentException("unknown tag in tagged field");
                    }
                    this.f32514d = c0.z(n0VarT, false);
                }
            }
        }
    }

    public e(t tVar, b0 b0Var) {
        this(tVar, b0Var, null, null);
    }

    public e(t tVar, b0 b0Var, xn.d dVar, c0 c0Var) {
        this.f32511a = tVar;
        this.f32512b = b0Var;
        this.f32513c = dVar;
        this.f32514d = c0Var;
    }

    public static e B(Object obj) {
        if (obj instanceof e) {
            return (e) obj;
        }
        if (obj != null) {
            return new e(f0.J(obj));
        }
        return null;
    }

    public t A() {
        return this.f32511a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(4);
        iVar.a(this.f32511a);
        iVar.a(this.f32512b);
        xn.d dVar = this.f32513c;
        if (dVar != null) {
            iVar.a(new n2(false, 0, (gm.h) dVar));
        }
        c0 c0Var = this.f32514d;
        if (c0Var != null) {
            iVar.a(new n2(false, 1, (gm.h) c0Var));
        }
        return new j2(iVar);
    }

    public c0 x() {
        return this.f32514d;
    }

    public xn.d y() {
        return this.f32513c;
    }

    public b0 z() {
        return this.f32512b;
    }
}
