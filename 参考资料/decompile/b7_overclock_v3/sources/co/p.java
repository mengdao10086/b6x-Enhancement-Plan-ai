package co;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.t;
import gm.w;
import gm.y;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class p extends w implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f11152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c0 f11153b;

    public p(int i10, int i11) {
        this(i10, i11, 0, 0);
    }

    public p(int i10, int i11, int i12, int i13) {
        this.f11152a = r.f11160d0;
        gm.i iVar = new gm.i(3);
        iVar.a(new t(i10));
        if (i12 == 0) {
            if (i13 != 0) {
                throw new IllegalArgumentException("inconsistent k values");
            }
            iVar.a(r.f11164f0);
            iVar.a(new t(i11));
        } else {
            if (i12 <= i11 || i13 <= i12) {
                throw new IllegalArgumentException("inconsistent k values");
            }
            iVar.a(r.f11166g0);
            gm.i iVar2 = new gm.i(3);
            iVar2.a(new t(i11));
            iVar2.a(new t(i12));
            iVar2.a(new t(i13));
            iVar.a(new j2(iVar2));
        }
        this.f11153b = new j2(iVar);
    }

    public p(f0 f0Var) {
        this.f11152a = y.N(f0Var.K(0));
        this.f11153b = f0Var.K(1).b();
    }

    public p(BigInteger bigInteger) {
        this.f11152a = r.f11158c0;
        this.f11153b = new t(bigInteger);
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
        iVar.a(this.f11152a);
        iVar.a(this.f11153b);
        return new j2(iVar);
    }

    public y x() {
        return this.f11152a;
    }

    public c0 z() {
        return this.f11153b;
    }
}
