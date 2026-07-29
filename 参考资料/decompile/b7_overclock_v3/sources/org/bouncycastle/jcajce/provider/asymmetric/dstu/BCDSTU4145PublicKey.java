package org.bouncycastle.jcajce.provider.asymmetric.dstu;

import co.j;
import co.l;
import co.n;
import er.c;
import gm.c0;
import gm.f0;
import gm.f2;
import gm.t;
import gm.y;
import gm.z;
import gr.e;
import gr.g;
import ir.e;
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
import np.m0;
import org.bouncycastle.jcajce.provider.asymmetric.util.h;
import org.bouncycastle.jcajce.provider.asymmetric.util.i;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import vn.a;
import vn.d;
import zn.b;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class BCDSTU4145PublicKey implements ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey, c {
    public static final long serialVersionUID = 7026240464295649314L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient m0 f44912a;
    private String algorithm;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient ECParameterSpec f44913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient d f44914c;
    private boolean withCompression;

    public BCDSTU4145PublicKey(g gVar, uq.c cVar) {
        this.algorithm = "DSTU4145";
        if (gVar.a() == null) {
            this.f44912a = new m0(cVar.b().a().h(gVar.b().f().v(), gVar.b().g().v()), h.m(cVar, null));
            this.f44913b = null;
        } else {
            EllipticCurve ellipticCurveB = h.b(gVar.a().a(), gVar.a().e());
            this.f44912a = new m0(gVar.b(), i.g(cVar, gVar.a()));
            this.f44913b = h.h(ellipticCurveB, gVar.a());
        }
    }

    public BCDSTU4145PublicKey(String str, m0 m0Var) {
        this.algorithm = str;
        this.f44912a = m0Var;
        this.f44913b = null;
    }

    public BCDSTU4145PublicKey(String str, m0 m0Var, e eVar) {
        this.algorithm = "DSTU4145";
        g0 g0VarD = m0Var.d();
        this.algorithm = str;
        this.f44913b = eVar == null ? c(h.b(g0VarD.a(), g0VarD.f()), g0VarD) : h.h(h.b(eVar.a(), eVar.e()), eVar);
        this.f44912a = m0Var;
    }

    public BCDSTU4145PublicKey(String str, m0 m0Var, ECParameterSpec eCParameterSpec) {
        this.algorithm = "DSTU4145";
        g0 g0VarD = m0Var.d();
        this.algorithm = str;
        this.f44912a = m0Var;
        if (eCParameterSpec == null) {
            this.f44913b = c(h.b(g0VarD.a(), g0VarD.f()), g0VarD);
        } else {
            this.f44913b = eCParameterSpec;
        }
    }

    public BCDSTU4145PublicKey(ECPublicKeySpec eCPublicKeySpec) {
        this.algorithm = "DSTU4145";
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.f44913b = params;
        this.f44912a = new m0(h.e(params, eCPublicKeySpec.getW()), h.m(null, this.f44913b));
    }

    public BCDSTU4145PublicKey(BCDSTU4145PublicKey bCDSTU4145PublicKey) {
        this.algorithm = "DSTU4145";
        this.f44912a = bCDSTU4145PublicKey.f44912a;
        this.f44913b = bCDSTU4145PublicKey.f44913b;
        this.withCompression = bCDSTU4145PublicKey.withCompression;
        this.f44914c = bCDSTU4145PublicKey.f44914c;
    }

    public BCDSTU4145PublicKey(c1 c1Var) {
        this.algorithm = "DSTU4145";
        i(c1Var);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        i(c1.A(c0.D((byte[]) objectInputStream.readObject())));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    @Override // org.bouncycastle.jce.interfaces.ECPublicKey
    public ir.i J0() {
        ir.i iVarE = this.f44912a.e();
        return this.f44913b == null ? iVarE.k() : iVarE;
    }

    @Override // er.c
    public void a(String str) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    @Override // er.b
    public e b() {
        ECParameterSpec eCParameterSpec = this.f44913b;
        if (eCParameterSpec == null) {
            return null;
        }
        return h.g(eCParameterSpec);
    }

    public final ECParameterSpec c(EllipticCurve ellipticCurve, g0 g0Var) {
        return new ECParameterSpec(ellipticCurve, h.f(g0Var.b()), g0Var.e(), g0Var.c().intValue());
    }

    public m0 d() {
        return this.f44912a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCDSTU4145PublicKey)) {
            return false;
        }
        BCDSTU4145PublicKey bCDSTU4145PublicKey = (BCDSTU4145PublicKey) obj;
        return this.f44912a.e().e(bCDSTU4145PublicKey.f44912a.e()) && f().equals(bCDSTU4145PublicKey.f());
    }

    public e f() {
        ECParameterSpec eCParameterSpec = this.f44913b;
        return eCParameterSpec != null ? h.g(eCParameterSpec) : BouncyCastleProvider.f45330c.b();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        gm.h jVar = this.f44914c;
        if (jVar == null) {
            ECParameterSpec eCParameterSpec = this.f44913b;
            if (eCParameterSpec instanceof gr.d) {
                jVar = new d(new y(((gr.d) this.f44913b).c()));
            } else {
                ir.e eVarA = h.a(eCParameterSpec.getCurve());
                jVar = new j(new l(eVarA, new n(h.d(eVarA, this.f44913b.getGenerator()), this.withCompression), this.f44913b.getOrder(), BigInteger.valueOf(this.f44913b.getCofactor()), this.f44913b.getCurve().getSeed()));
            }
        }
        try {
            return org.bouncycastle.jcajce.provider.asymmetric.util.l.e(new c1(new b(vn.g.f53269c, jVar), new f2(vn.e.b(this.f44912a.e()))));
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
        return this.f44913b;
    }

    @Override // java.security.interfaces.ECPublicKey
    public ECPoint getW() {
        return h.f(this.f44912a.e());
    }

    public byte[] h() {
        d dVar = this.f44914c;
        return dVar != null ? dVar.x() : d.y();
    }

    public int hashCode() {
        return this.f44912a.e().hashCode() ^ f().hashCode();
    }

    public final void i(c1 c1Var) {
        e eVar;
        l lVarD;
        ECParameterSpec eCParameterSpecJ;
        gm.d dVarC = c1Var.C();
        this.algorithm = "DSTU4145";
        try {
            byte[] bArrJ = ((z) c0.D(dVarC.H())).J();
            y yVarX = c1Var.x().x();
            y yVar = vn.g.f53268b;
            if (yVarX.C(yVar)) {
                k(bArrJ);
            }
            f0 f0VarJ = f0.J(c1Var.x().A());
            if (f0VarJ.K(0) instanceof t) {
                lVarD = l.D(f0VarJ);
                eVar = new e(lVarD.y(), lVarD.B(), lVarD.E(), lVarD.C(), lVarD.F());
            } else {
                d dVarA = d.A(f0VarJ);
                this.f44914c = dVarA;
                if (dVarA.C()) {
                    y yVarB = this.f44914c.B();
                    g0 g0VarA = vn.c.a(yVarB);
                    eVar = new gr.c(yVarB.L(), g0VarA.a(), g0VarA.b(), g0VarA.e(), g0VarA.c(), g0VarA.f());
                } else {
                    vn.b bVarZ = this.f44914c.z();
                    byte[] bArrY = bVarZ.y();
                    if (c1Var.x().x().C(yVar)) {
                        k(bArrY);
                    }
                    a aVarZ = bVarZ.z();
                    e.C0401e c0401e = new e.C0401e(aVarZ.B(), aVarZ.y(), aVarZ.z(), aVarZ.A(), bVarZ.x(), new BigInteger(1, bArrY));
                    byte[] bArrA = bVarZ.A();
                    if (c1Var.x().x().C(yVar)) {
                        k(bArrA);
                    }
                    eVar = new gr.e(c0401e, vn.e.a(c0401e, bArrA), bVarZ.C());
                }
                lVarD = null;
            }
            ir.e eVarA = eVar.a();
            EllipticCurve ellipticCurveB = h.b(eVarA, eVar.e());
            if (this.f44914c != null) {
                ECPoint eCPointF = h.f(eVar.b());
                eCParameterSpecJ = this.f44914c.C() ? new gr.d(this.f44914c.B().L(), ellipticCurveB, eCPointF, eVar.d(), eVar.c()) : new ECParameterSpec(ellipticCurveB, eCPointF, eVar.d(), eVar.c().intValue());
            } else {
                eCParameterSpecJ = h.j(lVarD);
            }
            this.f44913b = eCParameterSpecJ;
            this.f44912a = new m0(vn.e.a(eVarA, bArrJ), h.m(null, this.f44913b));
        } catch (IOException unused) {
            throw new IllegalArgumentException("error recovering public key");
        }
    }

    public final void k(byte[] bArr) {
        for (int i10 = 0; i10 < bArr.length / 2; i10++) {
            byte b10 = bArr[i10];
            bArr[i10] = bArr[(bArr.length - 1) - i10];
            bArr[(bArr.length - 1) - i10] = b10;
        }
    }

    public String toString() {
        return i.p(this.algorithm, this.f44912a.e(), f());
    }
}
