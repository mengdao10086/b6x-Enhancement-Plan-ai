package org.bouncycastle.jcajce.provider.asymmetric.ecgost12;

import co.j;
import co.l;
import co.n;
import gm.c0;
import gm.f2;
import gm.y;
import gm.z;
import gr.e;
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
import org.bouncycastle.jcajce.provider.asymmetric.util.h;
import org.bouncycastle.jcajce.provider.asymmetric.util.i;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import qm.g;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class BCECGOST3410_2012PublicKey implements ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey, er.c {
    public static final long serialVersionUID = 7026240464295649314L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient m0 f44993a;
    private String algorithm;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient ECParameterSpec f44994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient g f44995c;
    private boolean withCompression;

    public BCECGOST3410_2012PublicKey(gr.g gVar, uq.c cVar) {
        this.algorithm = "ECGOST3410-2012";
        if (gVar.a() == null) {
            this.f44993a = new m0(cVar.b().a().h(gVar.b().f().v(), gVar.b().g().v()), h.m(cVar, null));
            this.f44994b = null;
        } else {
            EllipticCurve ellipticCurveB = h.b(gVar.a().a(), gVar.a().e());
            this.f44993a = new m0(gVar.b(), i.g(cVar, gVar.a()));
            this.f44994b = h.h(ellipticCurveB, gVar.a());
        }
    }

    public BCECGOST3410_2012PublicKey(String str, m0 m0Var) {
        this.algorithm = str;
        this.f44993a = m0Var;
        this.f44994b = null;
    }

    public BCECGOST3410_2012PublicKey(String str, m0 m0Var, e eVar) {
        this.algorithm = "ECGOST3410-2012";
        g0 g0VarD = m0Var.d();
        this.algorithm = str;
        this.f44993a = m0Var;
        this.f44994b = eVar == null ? c(h.b(g0VarD.a(), g0VarD.f()), g0VarD) : h.h(h.b(eVar.a(), eVar.e()), eVar);
    }

    public BCECGOST3410_2012PublicKey(String str, m0 m0Var, ECParameterSpec eCParameterSpec) {
        this.algorithm = "ECGOST3410-2012";
        g0 g0VarD = m0Var.d();
        this.algorithm = str;
        this.f44993a = m0Var;
        if (g0VarD instanceof h0) {
            h0 h0Var = (h0) g0VarD;
            this.f44995c = new g(h0Var.m(), h0Var.k(), h0Var.l());
        }
        if (eCParameterSpec == null) {
            this.f44994b = c(h.b(g0VarD.a(), g0VarD.f()), g0VarD);
        } else {
            this.f44994b = eCParameterSpec;
        }
    }

    public BCECGOST3410_2012PublicKey(ECPublicKey eCPublicKey) {
        this.algorithm = "ECGOST3410-2012";
        this.algorithm = eCPublicKey.getAlgorithm();
        ECParameterSpec params = eCPublicKey.getParams();
        this.f44994b = params;
        this.f44993a = new m0(h.e(params, eCPublicKey.getW()), h.m(null, eCPublicKey.getParams()));
    }

    public BCECGOST3410_2012PublicKey(ECPublicKeySpec eCPublicKeySpec) {
        this.algorithm = "ECGOST3410-2012";
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.f44994b = params;
        this.f44993a = new m0(h.e(params, eCPublicKeySpec.getW()), h.m(null, eCPublicKeySpec.getParams()));
    }

    public BCECGOST3410_2012PublicKey(BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey) {
        this.algorithm = "ECGOST3410-2012";
        this.f44993a = bCECGOST3410_2012PublicKey.f44993a;
        this.f44994b = bCECGOST3410_2012PublicKey.f44994b;
        this.withCompression = bCECGOST3410_2012PublicKey.withCompression;
        this.f44995c = bCECGOST3410_2012PublicKey.f44995c;
    }

    public BCECGOST3410_2012PublicKey(c1 c1Var) {
        this.algorithm = "ECGOST3410-2012";
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
        return this.f44994b == null ? this.f44993a.e().k() : this.f44993a.e();
    }

    @Override // er.c
    public void a(String str) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    @Override // er.b
    public e b() {
        ECParameterSpec eCParameterSpec = this.f44994b;
        if (eCParameterSpec == null) {
            return null;
        }
        return h.g(eCParameterSpec);
    }

    public final ECParameterSpec c(EllipticCurve ellipticCurve, g0 g0Var) {
        return new ECParameterSpec(ellipticCurve, h.f(g0Var.b()), g0Var.e(), g0Var.c().intValue());
    }

    public m0 d() {
        return this.f44993a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCECGOST3410_2012PublicKey)) {
            return false;
        }
        BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey = (BCECGOST3410_2012PublicKey) obj;
        return this.f44993a.e().e(bCECGOST3410_2012PublicKey.f44993a.e()) && f().equals(bCECGOST3410_2012PublicKey.f());
    }

    public e f() {
        ECParameterSpec eCParameterSpec = this.f44994b;
        return eCParameterSpec != null ? h.g(eCParameterSpec) : BouncyCastleProvider.f45330c.b();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        int i10;
        y yVar;
        gm.h jVar;
        g gVar;
        BigInteger bigIntegerV = this.f44993a.e().f().v();
        BigInteger bigIntegerV2 = this.f44993a.e().g().v();
        boolean z10 = bigIntegerV.bitLength() > 256;
        g gVarI = i();
        gm.h hVar = gVarI;
        if (gVarI == null) {
            ECParameterSpec eCParameterSpec = this.f44994b;
            if (eCParameterSpec instanceof gr.d) {
                y yVarJ = qm.b.j(((gr.d) eCParameterSpec).c());
                if (z10) {
                    jVar = gVar;
                    gVar = new g(yVarJ, qn.a.f47514d);
                } else {
                    jVar = gVar;
                    gVar = new g(yVarJ, qn.a.f47513c);
                }
            } else {
                ir.e eVarA = h.a(eCParameterSpec.getCurve());
                jVar = new j(new l(eVarA, new n(h.d(eVarA, this.f44994b.getGenerator()), this.withCompression), this.f44994b.getOrder(), BigInteger.valueOf(this.f44994b.getCofactor()), this.f44994b.getCurve().getSeed()));
            }
            hVar = jVar;
        }
        int i11 = 64;
        if (z10) {
            yVar = qn.a.f47518h;
            i10 = 64;
            i11 = 128;
        } else {
            i10 = 32;
            yVar = qn.a.f47517g;
        }
        byte[] bArr = new byte[i11];
        int i12 = i11 / 2;
        h(bArr, i12, 0, bigIntegerV);
        h(bArr, i12, i10, bigIntegerV2);
        try {
            return org.bouncycastle.jcajce.provider.asymmetric.util.l.e(new c1(new zn.b(yVar, hVar), new f2(bArr)));
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
        return this.f44994b;
    }

    @Override // java.security.interfaces.ECPublicKey
    public ECPoint getW() {
        return h.f(this.f44993a.e());
    }

    public final void h(byte[] bArr, int i10, int i11, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length < i10) {
            byte[] bArr2 = new byte[i10];
            System.arraycopy(byteArray, 0, bArr2, i10 - byteArray.length, byteArray.length);
            byteArray = bArr2;
        }
        for (int i12 = 0; i12 != i10; i12++) {
            bArr[i11 + i12] = byteArray[(byteArray.length - 1) - i12];
        }
    }

    public int hashCode() {
        return this.f44993a.e().hashCode() ^ f().hashCode();
    }

    public g i() {
        if (this.f44995c == null && (this.f44994b instanceof gr.d)) {
            this.f44995c = this.f44993a.e().f().v().bitLength() > 256 ? new g(qm.b.j(((gr.d) this.f44994b).c()), qn.a.f47514d) : new g(qm.b.j(((gr.d) this.f44994b).c()), qn.a.f47513c);
        }
        return this.f44995c;
    }

    public final void k(c1 c1Var) {
        y yVarX = c1Var.x().x();
        gm.d dVarC = c1Var.C();
        this.algorithm = "ECGOST3410-2012";
        try {
            byte[] bArrJ = ((z) c0.D(dVarC.H())).J();
            int i10 = yVarX.C(qn.a.f47518h) ? 64 : 32;
            int i11 = i10 * 2;
            byte[] bArr = new byte[i11 + 1];
            bArr[0] = 4;
            for (int i12 = 1; i12 <= i10; i12++) {
                bArr[i12] = bArrJ[i10 - i12];
                bArr[i12 + i10] = bArrJ[i11 - i12];
            }
            g gVarA = g.A(c1Var.x().A());
            this.f44995c = gVarA;
            gr.c cVarB = org.bouncycastle.jce.a.b(qm.b.h(gVarA.B()));
            ir.e eVarA = cVarB.a();
            EllipticCurve ellipticCurveB = h.b(eVarA, cVarB.e());
            this.f44993a = new m0(eVarA.k(bArr), i.g(null, cVarB));
            this.f44994b = new gr.d(qm.b.h(this.f44995c.B()), ellipticCurveB, h.f(cVarB.b()), cVarB.d(), cVarB.c());
        } catch (IOException unused) {
            throw new IllegalArgumentException("error recovering public key");
        }
    }

    public String toString() {
        return i.p(this.algorithm, this.f44993a.e(), f());
    }
}
