package hq;

import co.l;
import gm.y;
import java.security.Provider;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPublicKeySpec;
import org.bouncycastle.jcajce.provider.asymmetric.util.h;
import org.bouncycastle.jcajce.util.g;
import org.bouncycastle.jcajce.util.i;
import xr.e1;
import xr.p;
import xr.q;
import xr.r;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class e extends fq.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f31423b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public org.bouncycastle.jcajce.util.d f31424a = new org.bouncycastle.jcajce.util.c();

        public e a(PublicKey publicKey) {
            return new e(publicKey, this.f31424a);
        }

        public e b(e1 e1Var) {
            return new e(e1Var, this.f31424a);
        }

        public a c(String str) {
            this.f31424a = new g(str);
            return this;
        }

        public a d(Provider provider) {
            this.f31424a = new i(provider);
            return this;
        }
    }

    public e(PublicKey publicKey, org.bouncycastle.jcajce.util.d dVar) {
        super(b((ECPublicKey) publicKey));
        this.f31423b = dVar;
    }

    public e(e1 e1Var, org.bouncycastle.jcajce.util.d dVar) {
        super(e1Var);
        this.f31423b = dVar;
    }

    public static e1 b(ECPublicKey eCPublicKey) {
        y yVarN = y.N(c1.A(eCPublicKey.getEncoded()).x().A());
        if (yVarN.C(rn.d.H)) {
            return new e1(0, q.y().f(eCPublicKey.getW().getAffineX(), eCPublicKey.getW().getAffineY()));
        }
        if (yVarN.C(tn.b.f51379u)) {
            return new e1(1, q.y().f(eCPublicKey.getW().getAffineX(), eCPublicKey.getW().getAffineY()));
        }
        if (yVarN.C(tn.b.f51383y)) {
            return new e1(3, r.y().f(eCPublicKey.getW().getAffineX(), eCPublicKey.getW().getAffineY()));
        }
        throw new IllegalArgumentException("unknown curve in public encryption key");
    }

    public PublicKey c() {
        l lVarC;
        y yVar;
        int iY = this.f28714a.y();
        if (iY != 0) {
            if (iY == 1) {
                yVar = tn.b.f51379u;
            } else {
                if (iY != 3) {
                    throw new IllegalStateException("unknown key type");
                }
                yVar = tn.b.f51383y;
            }
            lVarC = tn.a.i(yVar);
        } else {
            lVarC = kn.c.c(rn.d.H);
        }
        ir.e eVarY = lVarC.y();
        if (!(this.f28714a.z() instanceof p)) {
            throw new IllegalStateException("extension to public verification key not supported");
        }
        p pVar = (p) this.f28714a.z();
        if (!(pVar instanceof q) && !(pVar instanceof r)) {
            throw new IllegalStateException("unknown key type");
        }
        ir.i iVarB = eVarY.k(pVar.x()).B();
        try {
            return this.f31423b.b("EC").generatePublic(new ECPublicKeySpec(h.f(iVarB), h.j(lVarC)));
        } catch (Exception e10) {
            throw new IllegalStateException(e10.getMessage(), e10);
        }
    }
}
