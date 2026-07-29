package p000do;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;
import zn.c0;
import zn.d1;
import zn.y;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d1.b f26433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c0 f26434b;

    public d(d1.b bVar, boolean z10, c0 c0Var) {
        y yVarZ;
        this.f26433a = bVar;
        this.f26434b = c0Var;
        if (z10 && bVar.B() && (yVarZ = bVar.x().z(y.f59072q)) != null) {
            this.f26434b = c0.A(yVarZ.C());
        }
    }

    public c0 a() {
        return this.f26434b;
    }

    public Set b() {
        return c.m(this.f26433a.x());
    }

    public y c(gm.y yVar) {
        z zVarX = this.f26433a.x();
        if (zVarX != null) {
            return zVarX.z(yVar);
        }
        return null;
    }

    public List d() {
        return c.n(this.f26433a.x());
    }

    public z e() {
        return this.f26433a.x();
    }

    public Set f() {
        return c.o(this.f26433a.x());
    }

    public Date g() {
        return this.f26433a.z().x();
    }

    public BigInteger h() {
        return this.f26433a.A().K();
    }

    public boolean i() {
        return this.f26433a.B();
    }
}
