package om;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import java.math.BigInteger;
import zn.b0;

/* JADX INFO: loaded from: classes5.dex */
public class c extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b0 f44273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.t f44274b;

    public c(f0 f0Var) {
        this.f44273a = b0.z(f0Var.K(0));
        this.f44274b = gm.t.I(f0Var.K(1));
    }

    public c(b0 b0Var, gm.t tVar) {
        this.f44273a = b0Var;
        this.f44274b = tVar;
    }

    public c(b0 b0Var, BigInteger bigInteger) {
        this(b0Var, new gm.t(bigInteger));
    }

    public static c x(n0 n0Var, boolean z10) {
        return y(f0.I(n0Var, z10));
    }

    public static c y(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj != null) {
            return new c(f0.J(obj));
        }
        return null;
    }

    public gm.t A() {
        return this.f44274b;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f44273a);
        iVar.a(this.f44274b);
        return new j2(iVar);
    }

    public b0 z() {
        return this.f44273a;
    }
}
