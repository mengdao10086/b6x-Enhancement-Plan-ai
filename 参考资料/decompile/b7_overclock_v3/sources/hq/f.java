package hq;

import co.l;
import gm.y;
import java.security.Provider;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPublicKeySpec;
import org.bouncycastle.its.ITSPublicEncryptionKey;
import org.bouncycastle.jcajce.provider.asymmetric.util.h;
import org.bouncycastle.jcajce.util.g;
import org.bouncycastle.jcajce.util.i;
import xr.a2;
import xr.b;
import xr.d1;
import xr.p;
import xr.q;
import xr.r;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class f extends ITSPublicEncryptionKey {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f31425b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public org.bouncycastle.jcajce.util.d f31426a = new org.bouncycastle.jcajce.util.c();

        public f a(PublicKey publicKey) {
            return new f(publicKey, this.f31426a);
        }

        public f b(d1 d1Var) {
            return new f(d1Var, this.f31426a);
        }

        public a c(String str) {
            this.f31426a = new g(str);
            return this;
        }

        public a d(Provider provider) {
            this.f31426a = new i(provider);
            return this;
        }
    }

    public f(PublicKey publicKey, org.bouncycastle.jcajce.util.d dVar) {
        super(b(publicKey));
        this.f31425b = dVar;
    }

    public f(d1 d1Var, org.bouncycastle.jcajce.util.d dVar) {
        super(d1Var);
        this.f31425b = dVar;
    }

    public static d1 b(PublicKey publicKey) {
        if (!(publicKey instanceof ECPublicKey)) {
            throw new IllegalArgumentException("must be ECPublicKey instance");
        }
        ECPublicKey eCPublicKey = (ECPublicKey) publicKey;
        y yVarN = y.N(c1.A(publicKey.getEncoded()).x().A());
        if (yVarN.C(rn.d.H)) {
            return new d1(a2.f55812e, new b.a().b(0).c(q.y().f(eCPublicKey.getW().getAffineX(), eCPublicKey.getW().getAffineY())).a());
        }
        if (yVarN.C(tn.b.f51379u)) {
            return new d1(a2.f55812e, new b.a().b(1).c(q.y().f(eCPublicKey.getW().getAffineX(), eCPublicKey.getW().getAffineY())).a());
        }
        throw new IllegalArgumentException("unknown curve in public encryption key");
    }

    public PublicKey c() {
        l lVarC;
        xr.b bVarX = this.f44854a.x();
        int iX = bVarX.x();
        if (iX == 0) {
            lVarC = kn.c.c(rn.d.H);
        } else {
            if (iX != 1) {
                throw new IllegalStateException("unknown key type");
            }
            lVarC = tn.a.i(tn.b.f51379u);
        }
        if (!(this.f44854a.x().z() instanceof p)) {
            throw new IllegalStateException("extension to public verification key not supported");
        }
        p pVar = (p) bVarX.z();
        ir.e eVarY = lVarC.y();
        if (!(pVar instanceof q) && !(pVar instanceof r)) {
            throw new IllegalStateException("unknown key type");
        }
        ir.i iVarB = eVarY.k(pVar.x()).B();
        try {
            return this.f31425b.b("EC").generatePublic(new ECPublicKeySpec(h.f(iVarB), h.j(lVarC)));
        } catch (Exception e10) {
            throw new IllegalStateException(e10.getMessage(), e10);
        }
    }
}
