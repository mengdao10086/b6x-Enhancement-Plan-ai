package sm;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.y;
import java.math.BigInteger;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class m extends l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f50001e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f50002f = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f50003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f50004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f50005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f50006d = 0;

    public m(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f50003a = y.N(enumerationL.nextElement());
        while (enumerationL.hasMoreElements()) {
            n nVarY = n.y(enumerationL.nextElement());
            int iQ = nVarY.q();
            if (iQ == 1) {
                C(nVarY);
            } else {
                if (iQ != 2) {
                    throw new IllegalArgumentException("Unknown DERTaggedObject :" + nVarY.q() + "-> not an Iso7816RSAPublicKeyStructure");
                }
                B(nVarY);
            }
        }
        if (this.f50006d != 3) {
            throw new IllegalArgumentException("missing argument -> not an Iso7816RSAPublicKeyStructure");
        }
    }

    public m(y yVar, BigInteger bigInteger, BigInteger bigInteger2) {
        this.f50003a = yVar;
        this.f50004b = bigInteger;
        this.f50005c = bigInteger2;
    }

    public BigInteger A() {
        return this.f50005c;
    }

    public final void B(n nVar) {
        int i10 = this.f50006d;
        int i11 = f50002f;
        if ((i10 & i11) != 0) {
            throw new IllegalArgumentException("Exponent already set");
        }
        this.f50006d = i10 | i11;
        this.f50005c = nVar.z();
    }

    public final void C(n nVar) {
        int i10 = this.f50006d;
        int i11 = f50001e;
        if ((i10 & i11) != 0) {
            throw new IllegalArgumentException("Modulus already set");
        }
        this.f50006d = i10 | i11;
        this.f50004b = nVar.z();
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f50003a);
        iVar.a(new n(1, z()));
        iVar.a(new n(2, A()));
        return new j2(iVar);
    }

    @Override // sm.l
    public y y() {
        return this.f50003a;
    }

    public BigInteger z() {
        return this.f50004b;
    }
}
