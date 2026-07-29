package pn;

import gm.f0;
import gm.f2;
import gm.h0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.u1;
import java.io.IOException;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class u extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f46865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.b f46866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.z f46867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h0 f46868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public gm.d f46869e;

    public u(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        gm.t tVarI = gm.t.I(enumerationL.nextElement());
        this.f46865a = tVarI;
        int iE = E(tVarI);
        this.f46866b = zn.b.z(enumerationL.nextElement());
        this.f46867c = gm.z.I(enumerationL.nextElement());
        int i10 = -1;
        while (enumerationL.hasMoreElements()) {
            n0 n0Var = (n0) enumerationL.nextElement();
            int iQ = n0Var.q();
            if (iQ <= i10) {
                throw new IllegalArgumentException("invalid optional field in private key info");
            }
            if (iQ == 0) {
                this.f46868d = h0.H(n0Var, false);
            } else {
                if (iQ != 1) {
                    throw new IllegalArgumentException("unknown optional field in private key info");
                }
                if (iE < 1) {
                    throw new IllegalArgumentException("'publicKey' requires version v2(1) or later");
                }
                this.f46869e = u1.R(n0Var, false);
            }
            i10 = iQ;
        }
    }

    public u(zn.b bVar, gm.h hVar) throws IOException {
        this(bVar, hVar, null, null);
    }

    public u(zn.b bVar, gm.h hVar, h0 h0Var) throws IOException {
        this(bVar, hVar, h0Var, null);
    }

    public u(zn.b bVar, gm.h hVar, h0 h0Var, byte[] bArr) throws IOException {
        this.f46865a = new gm.t(bArr != null ? org.bouncycastle.util.b.f46033b : org.bouncycastle.util.b.f46032a);
        this.f46866b = bVar;
        this.f46867c = new f2(hVar);
        this.f46868d = h0Var;
        this.f46869e = bArr == null ? null : new u1(bArr);
    }

    public static int E(gm.t tVar) {
        int iQ = tVar.Q();
        if (iQ < 0 || iQ > 1) {
            throw new IllegalArgumentException("invalid version for private key info");
        }
        return iQ;
    }

    public static u y(n0 n0Var, boolean z10) {
        return z(f0.I(n0Var, z10));
    }

    public static u z(Object obj) {
        if (obj instanceof u) {
            return (u) obj;
        }
        if (obj != null) {
            return new u(f0.J(obj));
        }
        return null;
    }

    public gm.z A() {
        return new f2(this.f46867c.J());
    }

    public zn.b B() {
        return this.f46866b;
    }

    public gm.d C() {
        return this.f46869e;
    }

    public gm.t D() {
        return this.f46865a;
    }

    public boolean F() {
        return this.f46869e != null;
    }

    public gm.h G() throws IOException {
        return gm.c0.D(this.f46867c.J());
    }

    public gm.h H() throws IOException {
        gm.d dVar = this.f46869e;
        if (dVar == null) {
            return null;
        }
        return gm.c0.D(dVar.L());
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(5);
        iVar.a(this.f46865a);
        iVar.a(this.f46866b);
        iVar.a(this.f46867c);
        h0 h0Var = this.f46868d;
        if (h0Var != null) {
            iVar.a(new n2(false, 0, (gm.h) h0Var));
        }
        gm.d dVar = this.f46869e;
        if (dVar != null) {
            iVar.a(new n2(false, 1, (gm.h) dVar));
        }
        return new j2(iVar);
    }

    public h0 x() {
        return this.f46868d;
    }
}
