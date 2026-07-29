package org.bouncycastle.jce.provider;

import gm.d2;
import gm.f2;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.bouncycastle.util.Strings;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class JCEECPublicKey implements ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey, er.c {
    private String algorithm;
    private ECParameterSpec ecSpec;
    private qm.g gostParams;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ir.i f45350q;
    private boolean withCompression;

    public JCEECPublicKey(String str, gr.g gVar) {
        ECParameterSpec eCParameterSpecH;
        this.algorithm = str;
        this.f45350q = gVar.b();
        if (gVar.a() != null) {
            eCParameterSpecH = org.bouncycastle.jcajce.provider.asymmetric.util.h.h(org.bouncycastle.jcajce.provider.asymmetric.util.h.b(gVar.a().a(), gVar.a().e()), gVar.a());
        } else {
            if (this.f45350q.i() == null) {
                this.f45350q = BouncyCastleProvider.f45330c.b().a().h(this.f45350q.f().v(), this.f45350q.g().v());
            }
            eCParameterSpecH = null;
        }
        this.ecSpec = eCParameterSpecH;
    }

    public JCEECPublicKey(String str, ECPublicKeySpec eCPublicKeySpec) {
        this.algorithm = str;
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.ecSpec = params;
        this.f45350q = org.bouncycastle.jcajce.provider.asymmetric.util.h.e(params, eCPublicKeySpec.getW());
    }

    public JCEECPublicKey(String str, np.m0 m0Var) {
        this.algorithm = str;
        this.f45350q = m0Var.e();
        this.ecSpec = null;
    }

    public JCEECPublicKey(String str, np.m0 m0Var, gr.e eVar) {
        this.algorithm = "EC";
        np.g0 g0VarD = m0Var.d();
        this.algorithm = str;
        this.f45350q = m0Var.e();
        this.ecSpec = eVar == null ? c(org.bouncycastle.jcajce.provider.asymmetric.util.h.b(g0VarD.a(), g0VarD.f()), g0VarD) : org.bouncycastle.jcajce.provider.asymmetric.util.h.h(org.bouncycastle.jcajce.provider.asymmetric.util.h.b(eVar.a(), eVar.e()), eVar);
    }

    public JCEECPublicKey(String str, np.m0 m0Var, ECParameterSpec eCParameterSpec) {
        this.algorithm = "EC";
        np.g0 g0VarD = m0Var.d();
        this.algorithm = str;
        this.f45350q = m0Var.e();
        if (eCParameterSpec == null) {
            this.ecSpec = c(org.bouncycastle.jcajce.provider.asymmetric.util.h.b(g0VarD.a(), g0VarD.f()), g0VarD);
        } else {
            this.ecSpec = eCParameterSpec;
        }
    }

    public JCEECPublicKey(String str, JCEECPublicKey jCEECPublicKey) {
        this.algorithm = str;
        this.f45350q = jCEECPublicKey.f45350q;
        this.ecSpec = jCEECPublicKey.ecSpec;
        this.withCompression = jCEECPublicKey.withCompression;
        this.gostParams = jCEECPublicKey.gostParams;
    }

    public JCEECPublicKey(ECPublicKey eCPublicKey) {
        this.algorithm = "EC";
        this.algorithm = eCPublicKey.getAlgorithm();
        ECParameterSpec params = eCPublicKey.getParams();
        this.ecSpec = params;
        this.f45350q = org.bouncycastle.jcajce.provider.asymmetric.util.h.e(params, eCPublicKey.getW());
    }

    public JCEECPublicKey(c1 c1Var) {
        this.algorithm = "EC";
        i(c1Var);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        i(c1.A(gm.c0.D((byte[]) objectInputStream.readObject())));
        this.algorithm = (String) objectInputStream.readObject();
        this.withCompression = objectInputStream.readBoolean();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getEncoded());
        objectOutputStream.writeObject(this.algorithm);
        objectOutputStream.writeBoolean(this.withCompression);
    }

    @Override // org.bouncycastle.jce.interfaces.ECPublicKey
    public ir.i J0() {
        return this.ecSpec == null ? this.f45350q.k() : this.f45350q;
    }

    @Override // er.c
    public void a(String str) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    @Override // er.b
    public gr.e b() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        if (eCParameterSpec == null) {
            return null;
        }
        return org.bouncycastle.jcajce.provider.asymmetric.util.h.g(eCParameterSpec);
    }

    public final ECParameterSpec c(EllipticCurve ellipticCurve, np.g0 g0Var) {
        return new ECParameterSpec(ellipticCurve, org.bouncycastle.jcajce.provider.asymmetric.util.h.f(g0Var.b()), g0Var.e(), g0Var.c().intValue());
    }

    public ir.i d() {
        return this.f45350q;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JCEECPublicKey)) {
            return false;
        }
        JCEECPublicKey jCEECPublicKey = (JCEECPublicKey) obj;
        return d().e(jCEECPublicKey.d()) && f().equals(jCEECPublicKey.f());
    }

    public gr.e f() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        return eCParameterSpec != null ? org.bouncycastle.jcajce.provider.asymmetric.util.h.g(eCParameterSpec) : BouncyCastleProvider.f45330c.b();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        co.j jVar;
        c1 c1Var;
        gm.h jVar2;
        if (this.algorithm.equals("ECGOST3410")) {
            gm.h hVar = this.gostParams;
            if (hVar == null) {
                ECParameterSpec eCParameterSpec = this.ecSpec;
                if (eCParameterSpec instanceof gr.d) {
                    jVar2 = new qm.g(qm.b.j(((gr.d) eCParameterSpec).c()), qm.a.f47466p);
                } else {
                    ir.e eVarA = org.bouncycastle.jcajce.provider.asymmetric.util.h.a(eCParameterSpec.getCurve());
                    jVar2 = new co.j(new co.l(eVarA, new co.n(org.bouncycastle.jcajce.provider.asymmetric.util.h.d(eVarA, this.ecSpec.getGenerator()), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
                }
                hVar = jVar2;
            }
            BigInteger bigIntegerV = this.f45350q.f().v();
            BigInteger bigIntegerV2 = this.f45350q.g().v();
            byte[] bArr = new byte[64];
            h(bArr, 0, bigIntegerV);
            h(bArr, 32, bigIntegerV2);
            try {
                c1Var = new c1(new zn.b(qm.a.f47463m, hVar), new f2(bArr));
            } catch (IOException unused) {
                return null;
            }
        } else {
            ECParameterSpec eCParameterSpec2 = this.ecSpec;
            if (eCParameterSpec2 instanceof gr.d) {
                gm.y yVarL = org.bouncycastle.jcajce.provider.asymmetric.util.i.l(((gr.d) eCParameterSpec2).c());
                if (yVarL == null) {
                    yVarL = new gm.y(((gr.d) this.ecSpec).c());
                }
                jVar = new co.j(yVarL);
            } else if (eCParameterSpec2 == null) {
                jVar = new co.j((gm.u) d2.f29657b);
            } else {
                ir.e eVarA2 = org.bouncycastle.jcajce.provider.asymmetric.util.h.a(eCParameterSpec2.getCurve());
                jVar = new co.j(new co.l(eVarA2, new co.n(org.bouncycastle.jcajce.provider.asymmetric.util.h.d(eVarA2, this.ecSpec.getGenerator()), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
            }
            c1Var = new c1(new zn.b(co.r.f11174l0, jVar), J0().l(this.withCompression));
        }
        return org.bouncycastle.jcajce.provider.asymmetric.util.l.e(c1Var);
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.ecSpec;
    }

    @Override // java.security.interfaces.ECPublicKey
    public ECPoint getW() {
        return org.bouncycastle.jcajce.provider.asymmetric.util.h.f(this.f45350q);
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
        return d().hashCode() ^ f().hashCode();
    }

    public final void i(c1 c1Var) {
        ir.e eVarY;
        ECParameterSpec eCParameterSpec;
        byte[] bArrH;
        gm.z f2Var;
        zn.b bVarX = c1Var.x();
        if (bVarX.x().C(qm.a.f47463m)) {
            gm.d dVarC = c1Var.C();
            this.algorithm = "ECGOST3410";
            try {
                byte[] bArrJ = ((gm.z) gm.c0.D(dVarC.H())).J();
                byte[] bArr = new byte[65];
                bArr[0] = 4;
                for (int i10 = 1; i10 <= 32; i10++) {
                    bArr[i10] = bArrJ[32 - i10];
                    bArr[i10 + 32] = bArrJ[64 - i10];
                }
                qm.g gVarA = qm.g.A(bVarX.A());
                this.gostParams = gVarA;
                gr.c cVarB = org.bouncycastle.jce.a.b(qm.b.h(gVarA.B()));
                ir.e eVarA = cVarB.a();
                EllipticCurve ellipticCurveB = org.bouncycastle.jcajce.provider.asymmetric.util.h.b(eVarA, cVarB.e());
                this.f45350q = eVarA.k(bArr);
                this.ecSpec = new gr.d(qm.b.h(this.gostParams.B()), ellipticCurveB, org.bouncycastle.jcajce.provider.asymmetric.util.h.f(cVarB.b()), cVarB.d(), cVarB.c());
                return;
            } catch (IOException unused) {
                throw new IllegalArgumentException("error recovering public key");
            }
        }
        co.j jVarY = co.j.y(bVarX.A());
        if (jVarY.B()) {
            gm.y yVar = (gm.y) jVarY.z();
            co.l lVarJ = org.bouncycastle.jcajce.provider.asymmetric.util.i.j(yVar);
            eVarY = lVarJ.y();
            eCParameterSpec = new gr.d(org.bouncycastle.jcajce.provider.asymmetric.util.i.e(yVar), org.bouncycastle.jcajce.provider.asymmetric.util.h.b(eVarY, lVarJ.F()), org.bouncycastle.jcajce.provider.asymmetric.util.h.f(lVarJ.B()), lVarJ.E(), lVarJ.C());
        } else {
            if (jVarY.A()) {
                this.ecSpec = null;
                eVarY = BouncyCastleProvider.f45330c.b().a();
                bArrH = c1Var.C().H();
                f2Var = new f2(bArrH);
                if (bArrH[0] == 4 && bArrH[1] == bArrH.length - 2 && ((bArrH[2] == 2 || bArrH[2] == 3) && new co.q().a(eVarY) >= bArrH.length - 3)) {
                    try {
                        f2Var = (gm.z) gm.c0.D(bArrH);
                    } catch (IOException unused2) {
                        throw new IllegalArgumentException("error recovering public key");
                    }
                }
                this.f45350q = new co.n(eVarY, f2Var).x();
            }
            co.l lVarD = co.l.D(jVarY.z());
            eVarY = lVarD.y();
            eCParameterSpec = new ECParameterSpec(org.bouncycastle.jcajce.provider.asymmetric.util.h.b(eVarY, lVarD.F()), org.bouncycastle.jcajce.provider.asymmetric.util.h.f(lVarD.B()), lVarD.E(), lVarD.C().intValue());
        }
        this.ecSpec = eCParameterSpec;
        bArrH = c1Var.C().H();
        f2Var = new f2(bArrH);
        if (bArrH[0] == 4) {
            f2Var = (gm.z) gm.c0.D(bArrH);
        }
        this.f45350q = new co.n(eVarY, f2Var).x();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String strE = Strings.e();
        stringBuffer.append("EC Public Key");
        stringBuffer.append(strE);
        stringBuffer.append("            X: ");
        stringBuffer.append(this.f45350q.f().v().toString(16));
        stringBuffer.append(strE);
        stringBuffer.append("            Y: ");
        stringBuffer.append(this.f45350q.g().v().toString(16));
        stringBuffer.append(strE);
        return stringBuffer.toString();
    }
}
