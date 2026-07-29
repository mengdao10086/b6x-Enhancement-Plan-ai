package jn;

import gm.c0;
import gm.c2;
import gm.f0;
import gm.r;
import gm.w;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class a extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f36517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c1 f36518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r f36519c;

    public a(f0 f0Var) {
        this.f36517a = f0Var;
        this.f36518b = c1.A(f0Var.K(0));
        this.f36519c = r.I(f0Var.K(1));
    }

    public static a z(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(f0.J(obj));
        }
        return null;
    }

    public c1 A() {
        return this.f36518b;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f36517a;
    }

    public c2 x() {
        r rVar = this.f36519c;
        return (rVar == null || (rVar instanceof c2)) ? (c2) rVar : new c2(this.f36519c.d(), false);
    }

    public r y() {
        return this.f36519c;
    }
}
