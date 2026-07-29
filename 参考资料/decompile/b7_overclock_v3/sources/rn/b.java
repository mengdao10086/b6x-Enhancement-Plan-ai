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
public class b extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f48912a;

    public b(f0 f0Var) {
        this.f48912a = f0Var;
    }

    public b(BigInteger bigInteger) {
        byte[] bArrC = org.bouncycastle.util.b.c(bigInteger);
        i iVar = new i(2);
        iVar.a(new t(1L));
        iVar.a(new f2(bArrC));
        this.f48912a = new j2(iVar);
    }

    public b(BigInteger bigInteger, gm.d dVar, h hVar) {
        byte[] bArrC = org.bouncycastle.util.b.c(bigInteger);
        i iVar = new i(4);
        iVar.a(new t(1L));
        iVar.a(new f2(bArrC));
        if (hVar != null) {
            iVar.a(new n2(true, 0, hVar));
        }
        if (dVar != null) {
            iVar.a(new n2(true, 1, (h) dVar));
            iVar.a(new n2(true, 1, (h) dVar));
        }
        this.f48912a = new j2(iVar);
    }

    public b(BigInteger bigInteger, h hVar) {
        this(bigInteger, null, hVar);
    }

    public gm.d A() {
        return (gm.d) y(1);
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f48912a;
    }

    public BigInteger x() {
        return new BigInteger(1, ((z) this.f48912a.K(1)).J());
    }

    public final c0 y(int i10) {
        Enumeration enumerationL = this.f48912a.L();
        while (enumerationL.hasMoreElements()) {
            h hVar = (h) enumerationL.nextElement();
            if (hVar instanceof n0) {
                n0 n0Var = (n0) hVar;
                if (n0Var.q() == i10) {
                    return n0Var.U().b();
                }
            }
        }
        return null;
    }

    public c0 z() {
        return y(0);
    }
}
