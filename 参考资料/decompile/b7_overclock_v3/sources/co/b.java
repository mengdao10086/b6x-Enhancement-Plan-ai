package co;

import gm.c0;
import gm.n0;
import gm.t;
import gm.w;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class b extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f11094a;

    public b(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("'y' cannot be null");
        }
        this.f11094a = tVar;
    }

    public b(BigInteger bigInteger) {
        if (bigInteger == null) {
            throw new IllegalArgumentException("'y' cannot be null");
        }
        this.f11094a = new t(bigInteger);
    }

    public static b x(n0 n0Var, boolean z10) {
        return y(t.H(n0Var, z10));
    }

    public static b y(Object obj) {
        if (obj == null || (obj instanceof b)) {
            return (b) obj;
        }
        if (obj instanceof t) {
            return new b((t) obj);
        }
        throw new IllegalArgumentException("Invalid DHPublicKey: " + obj.getClass().getName());
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f11094a;
    }

    public BigInteger z() {
        return this.f11094a.J();
    }
}
