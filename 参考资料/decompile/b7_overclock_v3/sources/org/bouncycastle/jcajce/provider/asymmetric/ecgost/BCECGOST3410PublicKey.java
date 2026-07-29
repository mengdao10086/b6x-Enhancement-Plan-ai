package org.bouncycastle.jcajce.provider.asymmetric.ecgost;

import co.j;
import co.l;
import co.n;
import gm.c0;
import gm.f2;
import gm.h;
import gm.y;
import gm.z;
import gr.d;
import gr.e;
import gr.g;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import np.g0;
import np.h0;
import np.m0;
import org.bouncycastle.jcajce.provider.asymmetric.util.i;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class BCECGOST3410PublicKey implements ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey, er.c {
    public static final long serialVersionUID = 7026240464295649314L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient m0 f44971a;
    private String algorithm;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient ECParameterSpec f44972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient h f44973c;
    private boolean withCompression;

    public BCECGOST3410PublicKey(g gVar, uq.c cVar) {
        this.algorithm = "ECGOST3410";
        if (gVar.a() == null) {
            this.f44971a = new m0(cVar.b().a().h(gVar.b().f().v(), gVar.b().g().v()), org.bouncycastle.jcajce.provider.asymmetric.util.h.m(cVar, null));
            this.f44972b = null;
        } else {
            EllipticCurve ellipticCurveB = org.bouncycastle.jcajce.provider.asymmetric.util.h.b(gVar.a().a(), gVar.a().e());
            this.f44971a = new m0(gVar.b(), i.g(cVar, gVar.a()));
            this.f44972b = org.bouncycastle.jcajce.provider.asymmetric.util.h.h(ellipticCurveB, gVar.a());
        }
    }

    public BCECGOST3410PublicKey(String str, m0 m0Var) {
        this.algorithm = str;
        this.f44971a = m0Var;
        this.f44972b = null;
    }

    public BCECGOST3410PublicKey(String str, m0 m0Var, e eVar) {
        this.algorithm = "ECGOST3410";
        g0 g0VarD = m0Var.d();
        this.algorithm = str;
        this.f44971a = m0Var;
        this.f44972b = eVar == null ? c(org.bouncycastle.jcajce.provider.asymmetric.util.h.b(g0VarD.a(), g0VarD.f()), g0VarD) : org.bouncycastle.jcajce.provider.asymmetric.util.h.h(org.bouncycastle.jcajce.provider.asymmetric.util.h.b(eVar.a(), eVar.e()), eVar);
    }

    public BCECGOST3410PublicKey(String str, m0 m0Var, ECParameterSpec eCParameterSpec) {
        this.algorithm = "ECGOST3410";
        g0 g0VarD = m0Var.d();
        if (g0VarD instanceof h0) {
            h0 h0Var = (h0) g0VarD;
            this.f44973c = new qm.g(h0Var.m(), h0Var.k(), h0Var.l());
        }
        this.algorithm = str;
        this.f44971a = m0Var;
        if (eCParameterSpec == null) {
            this.f44972b = c(org.bouncycastle.jcajce.provider.asymmetric.util.h.b(g0VarD.a(), g0VarD.f()), g0VarD);
        } else {
            this.f44972b = eCParameterSpec;
        }
    }

    public BCECGOST3410PublicKey(ECPublicKey eCPublicKey) {
        this.algorithm = "ECGOST3410";
        this.algorithm = eCPublicKey.getAlgorithm();
        ECParameterSpec params = eCPublicKey.getParams();
        this.f44972b = params;
        this.f44971a = new m0(org.bouncycastle.jcajce.provider.asymmetric.util.h.e(params, eCPublicKey.getW()), org.bouncycastle.jcajce.provider.asymmetric.util.h.m(null, eCPublicKey.getParams()));
    }

    public BCECGOST3410PublicKey(ECPublicKeySpec eCPublicKeySpec) {
        this.algorithm = "ECGOST3410";
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.f44972b = params;
        this.f44971a = new m0(org.bouncycastle.jcajce.provider.asymmetric.util.h.e(params, eCPublicKeySpec.getW()), org.bouncycastle.jcajce.provider.asymmetric.util.h.m(null, eCPublicKeySpec.getParams()));
    }

    public BCECGOST3410PublicKey(BCECGOST3410PublicKey bCECGOST3410PublicKey) {
        this.algorithm = "ECGOST3410";
        this.f44971a = bCECGOST3410PublicKey.f44971a;
        this.f44972b = bCECGOST3410PublicKey.f44972b;
        this.withCompression = bCECGOST3410PublicKey.withCompression;
        this.f44973c = bCECGOST3410PublicKey.f44973c;
    }

    public BCECGOST3410PublicKey(c1 c1Var) {
        this.algorithm = "ECGOST3410";
        k(c1Var);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        k(c1.A(c0.D((byte[]) objectInputStream.readObject())));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    @Override // org.bouncycastle.jce.interfaces.ECPublicKey
    public ir.i J0() {
        return this.f44972b == null ? this.f44971a.e().k() : this.f44971a.e();
    }

    @Override // er.c
    public void a(String str) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    @Override // er.b
    public e b() {
        ECParameterSpec eCParameterSpec = this.f44972b;
        if (eCParameterSpec == null) {
            return null;
        }
        return org.bouncycastle.jcajce.provider.asymmetric.util.h.g(eCParameterSpec);
    }

    public final ECParameterSpec c(EllipticCurve ellipticCurve, g0 g0Var) {
        return new ECParameterSpec(ellipticCurve, org.bouncycastle.jcajce.provider.asymmetric.util.h.f(g0Var.b()), g0Var.e(), g0Var.c().intValue());
    }

    public m0 d() {
        return this.f44971a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCECGOST3410PublicKey)) {
            return false;
        }
        BCECGOST3410PublicKey bCECGOST3410PublicKey = (BCECGOST3410PublicKey) obj;
        return this.f44971a.e().e(bCECGOST3410PublicKey.f44971a.e()) && f().equals(bCECGOST3410PublicKey.f());
    }

    public e f() {
        ECParameterSpec eCParameterSpec = this.f44972b;
        return eCParameterSpec != null ? org.bouncycastle.jcajce.provider.asymmetric.util.h.g(eCParameterSpec) : BouncyCastleProvider.f45330c.b();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        h jVar;
        h hVarI = i();
        if (hVarI == null) {
            ECParameterSpec eCParameterSpec = this.f44972b;
            if (eCParameterSpec instanceof d) {
                jVar = new qm.g(qm.b.j(((d) eCParameterSpec).c()), qm.a.f47466p);
            } else {
                ir.e eVarA = org.bouncycastle.jcajce.provider.asymmetric.util.h.a(eCParameterSpec.getCurve());
                jVar = new j(new l(eVarA, new n(org.bouncycastle.jcajce.provider.asymmetric.util.h.d(eVarA, this.f44972b.getGenerator()), this.withCompression), this.f44972b.getOrder(), BigInteger.valueOf(this.f44972b.getCofactor()), this.f44972b.getCurve().getSeed()));
            }
            hVarI = jVar;
        }
        BigInteger bigIntegerV = this.f44971a.e().f().v();
        BigInteger bigIntegerV2 = this.f44971a.e().g().v();
        byte[] bArr = new byte[64];
        h(bArr, 0, bigIntegerV);
        h(bArr, 32, bigIntegerV2);
        try {
            return org.bouncycastle.jcajce.provider.asymmetric.util.l.e(new c1(new zn.b(qm.a.f47463m, hVarI), new f2(bArr)));
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.f44972b;
    }

    @Override // java.security.interfaces.ECPublicKey
    public ECPoint getW() {
        return org.bouncycastle.jcajce.provider.asymmetric.util.h.f(this.f44971a.e());
    }

    public final void h(byte[] bArr, int i10, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length < 32) {
            byte[] bArr2 = new byte[32];
            System.arraycopy(byteArray, 0, bArr2, 32 - byteArray.length, byteArray.length);
            byteArray = bArr2;
        }
        for (int i11 = 0; i11 != 32; i11++) {
            bArr[i10 + i11] = byteArray[(byteArray.length - 1) - i11];
        }
    }

    public int hashCode() {
        return this.f44971a.e().hashCode() ^ f().hashCode();
    }

    public h i() {
        if (this.f44973c == null) {
            ECParameterSpec eCParameterSpec = this.f44972b;
            if (eCParameterSpec instanceof d) {
                this.f44973c = new qm.g(qm.b.j(((d) eCParameterSpec).c()), qm.a.f47466p);
            }
        }
        return this.f44973c;
    }

    public final void k(c1 c1Var) {
        y yVarB;
        gm.d dVarC = c1Var.C();
        this.algorithm = "ECGOST3410";
        try {
            byte[] bArrJ = ((z) c0.D(dVarC.H())).J();
            byte[] bArr = new byte[65];
            bArr[0] = 4;
            for (int i10 = 1; i10 <= 32; i10++) {
                bArr[i10] = bArrJ[32 - i10];
                bArr[i10 + 32] = bArrJ[64 - i10];
            }
            boolean z10 = c1Var.x().A() instanceof y;
            h hVarA = c1Var.x().A();
            if (z10) {
                yVarB = y.N(hVarA);
                this.f44973c = yVarB;
            } else {
                qm.g gVarA = qm.g.A(hVarA);
                this.f44973c = gVarA;
                yVarB = gVarA.B();
            }
            gr.c cVarB = org.bouncycastle.jce.a.b(qm.b.h(yVarB));
            ir.e eVarA = cVarB.a();
            EllipticCurve ellipticCurveB = org.bouncycastle.jcajce.provider.asymmetric.util.h.b(eVarA, cVarB.e());
            this.f44971a = new m0(eVarA.k(bArr), i.g(null, cVarB));
            this.f44972b = new d(qm.b.h(yVarB), ellipticCurveB, org.bouncycastle.jcajce.provider.asymmetric.util.h.f(cVarB.b()), cVarB.d(), cVarB.c());
        } catch (IOException unused) {
            throw new IllegalArgumentException("error recovering public key");
        }
    }

    public String toString() {
        return i.p(this.algorithm, this.f44971a.e(), f());
    }
}
