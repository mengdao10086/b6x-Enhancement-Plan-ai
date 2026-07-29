package rn;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.h;
import gm.i;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.t;
import gm.w;
import gm.z;
import java.math.BigInteger;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class a extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f48911a;

    public a(int i10, BigInteger bigInteger) {
        byte[] bArrB = org.bouncycastle.util.b.b((i10 + 7) / 8, bigInteger);
        i iVar = new i(2);
        iVar.a(new t(1L));
        iVar.a(new f2(bArrB));
        this.f48911a = new j2(iVar);
    }

    public a(int i10, BigInteger bigInteger, gm.d dVar, h hVar) {
        byte[] bArrB = org.bouncycastle.util.b.b((i10 + 7) / 8, bigInteger);
        i iVar = new i(4);
        iVar.a(new t(1L));
        iVar.a(new f2(bArrB));
        if (hVar != null) {
            iVar.a(new n2(true, 0, hVar));
        }
        if (dVar != null) {
            iVar.a(new n2(true, 1, (h) dVar));
        }
        this.f48911a = new j2(iVar);
    }

    public a(int i10, BigInteger bigInteger, h hVar) {
        this(i10, bigInteger, null, hVar);
    }

    public a(f0 f0Var) {
        this.f48911a = f0Var;
    }

    public a(BigInteger bigInteger) {
        this(bigInteger.bitLength(), bigInteger);
    }

    public a(BigInteger bigInteger, gm.d dVar, h hVar) {
        this(bigInteger.bitLength(), bigInteger, dVar, hVar);
    }

    public a(BigInteger bigInteger, h hVar) {
        this(bigInteger, (gm.d) null, hVar);
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

    public c0 A() {
        return B().b();
    }

    public w B() {
        return z(0, -1);
    }

    public gm.d C() {
        return (gm.d) z(1, 3);
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f48911a;
    }

    public BigInteger y() {
        return new BigInteger(1, ((z) this.f48911a.K(1)).J());
    }

    public final w z(int i10, int i11) {
        Enumeration enumerationL = this.f48911a.L();
        while (enumerationL.hasMoreElements()) {
            h hVar = (h) enumerationL.nextElement();
            if (hVar instanceof n0) {
                n0 n0Var = (n0) hVar;
                if (n0Var.s(i10)) {
                    return i11 < 0 ? n0Var.P().b() : n0Var.M(true, i11);
                }
            }
        }
        return null;
    }
}
