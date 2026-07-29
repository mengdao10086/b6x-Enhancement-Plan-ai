package org.bouncycastle.jce.provider;

import gm.d2;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPrivateKeySpec;
import java.util.Enumeration;
import org.bouncycastle.util.Strings;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class JCEECPrivateKey implements ECPrivateKey, org.bouncycastle.jce.interfaces.ECPrivateKey, er.g, er.c {
    private String algorithm;
    private org.bouncycastle.jcajce.provider.asymmetric.util.m attrCarrier;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BigInteger f45349d;
    private ECParameterSpec ecSpec;
    private gm.d publicKey;
    private boolean withCompression;

    public JCEECPrivateKey() {
        this.algorithm = "EC";
        this.attrCarrier = new org.bouncycastle.jcajce.provider.asymmetric.util.m();
    }

    public JCEECPrivateKey(String str, gr.f fVar) {
        this.algorithm = "EC";
        this.attrCarrier = new org.bouncycastle.jcajce.provider.asymmetric.util.m();
        this.algorithm = str;
        this.f45349d = fVar.b();
        this.ecSpec = fVar.a() != null ? org.bouncycastle.jcajce.provider.asymmetric.util.h.h(org.bouncycastle.jcajce.provider.asymmetric.util.h.b(fVar.a().a(), fVar.a().e()), fVar.a()) : null;
    }

    public JCEECPrivateKey(String str, ECPrivateKeySpec eCPrivateKeySpec) {
        this.algorithm = "EC";
        this.attrCarrier = new org.bouncycastle.jcajce.provider.asymmetric.util.m();
        this.algorithm = str;
        this.f45349d = eCPrivateKeySpec.getS();
        this.ecSpec = eCPrivateKeySpec.getParams();
    }

    public JCEECPrivateKey(String str, np.l0 l0Var) {
        this.algorithm = "EC";
        this.attrCarrier = new org.bouncycastle.jcajce.provider.asymmetric.util.m();
        this.algorithm = str;
        this.f45349d = l0Var.e();
        this.ecSpec = null;
    }

    public JCEECPrivateKey(String str, np.l0 l0Var, JCEECPublicKey jCEECPublicKey, gr.e eVar) {
        this.algorithm = "EC";
        this.attrCarrier = new org.bouncycastle.jcajce.provider.asymmetric.util.m();
        this.algorithm = str;
        this.f45349d = l0Var.e();
        if (eVar == null) {
            np.g0 g0VarD = l0Var.d();
            this.ecSpec = new ECParameterSpec(org.bouncycastle.jcajce.provider.asymmetric.util.h.b(g0VarD.a(), g0VarD.f()), org.bouncycastle.jcajce.provider.asymmetric.util.h.f(g0VarD.b()), g0VarD.e(), g0VarD.c().intValue());
        } else {
            this.ecSpec = new ECParameterSpec(org.bouncycastle.jcajce.provider.asymmetric.util.h.b(eVar.a(), eVar.e()), org.bouncycastle.jcajce.provider.asymmetric.util.h.f(eVar.b()), eVar.d(), eVar.c().intValue());
        }
        this.publicKey = i(jCEECPublicKey);
    }

    public JCEECPrivateKey(String str, np.l0 l0Var, JCEECPublicKey jCEECPublicKey, ECParameterSpec eCParameterSpec) {
        this.algorithm = "EC";
        this.attrCarrier = new org.bouncycastle.jcajce.provider.asymmetric.util.m();
        this.algorithm = str;
        this.f45349d = l0Var.e();
        if (eCParameterSpec == null) {
            np.g0 g0VarD = l0Var.d();
            eCParameterSpec = new ECParameterSpec(org.bouncycastle.jcajce.provider.asymmetric.util.h.b(g0VarD.a(), g0VarD.f()), org.bouncycastle.jcajce.provider.asymmetric.util.h.f(g0VarD.b()), g0VarD.e(), g0VarD.c().intValue());
        }
        this.ecSpec = eCParameterSpec;
        this.publicKey = i(jCEECPublicKey);
    }

    public JCEECPrivateKey(String str, JCEECPrivateKey jCEECPrivateKey) {
        this.algorithm = "EC";
        this.attrCarrier = new org.bouncycastle.jcajce.provider.asymmetric.util.m();
        this.algorithm = str;
        this.f45349d = jCEECPrivateKey.f45349d;
        this.ecSpec = jCEECPrivateKey.ecSpec;
        this.withCompression = jCEECPrivateKey.withCompression;
        this.attrCarrier = jCEECPrivateKey.attrCarrier;
        this.publicKey = jCEECPrivateKey.publicKey;
    }

    public JCEECPrivateKey(ECPrivateKey eCPrivateKey) {
        this.algorithm = "EC";
        this.attrCarrier = new org.bouncycastle.jcajce.provider.asymmetric.util.m();
        this.f45349d = eCPrivateKey.getS();
        this.algorithm = eCPrivateKey.getAlgorithm();
        this.ecSpec = eCPrivateKey.getParams();
    }

    public JCEECPrivateKey(pn.u uVar) throws IOException {
        this.algorithm = "EC";
        this.attrCarrier = new org.bouncycastle.jcajce.provider.asymmetric.util.m();
        k(uVar);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        k(pn.u.z(gm.c0.D((byte[]) objectInputStream.readObject())));
        this.algorithm = (String) objectInputStream.readObject();
        this.withCompression = objectInputStream.readBoolean();
        org.bouncycastle.jcajce.provider.asymmetric.util.m mVar = new org.bouncycastle.jcajce.provider.asymmetric.util.m();
        this.attrCarrier = mVar;
        mVar.d(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getEncoded());
        objectOutputStream.writeObject(this.algorithm);
        objectOutputStream.writeBoolean(this.withCompression);
        this.attrCarrier.g(objectOutputStream);
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

    @Override // er.g
    public gm.h c(gm.y yVar) {
        return this.attrCarrier.c(yVar);
    }

    public gr.e d() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        return eCParameterSpec != null ? org.bouncycastle.jcajce.provider.asymmetric.util.h.g(eCParameterSpec) : BouncyCastleProvider.f45330c.b();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JCEECPrivateKey)) {
            return false;
        }
        JCEECPrivateKey jCEECPrivateKey = (JCEECPrivateKey) obj;
        return f0().equals(jCEECPrivateKey.f0()) && d().equals(jCEECPrivateKey.d());
    }

    @Override // er.g
    public Enumeration f() {
        return this.attrCarrier.f();
    }

    @Override // org.bouncycastle.jce.interfaces.ECPrivateKey
    public BigInteger f0() {
        return this.f45349d;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        co.j jVar;
        ECParameterSpec eCParameterSpec = this.ecSpec;
        if (eCParameterSpec instanceof gr.d) {
            gm.y yVarL = org.bouncycastle.jcajce.provider.asymmetric.util.i.l(((gr.d) eCParameterSpec).c());
            if (yVarL == null) {
                yVarL = new gm.y(((gr.d) this.ecSpec).c());
            }
            jVar = new co.j(yVarL);
        } else if (eCParameterSpec == null) {
            jVar = new co.j((gm.u) d2.f29657b);
        } else {
            ir.e eVarA = org.bouncycastle.jcajce.provider.asymmetric.util.h.a(eCParameterSpec.getCurve());
            jVar = new co.j(new co.l(eVarA, new co.n(org.bouncycastle.jcajce.provider.asymmetric.util.h.d(eVarA, this.ecSpec.getGenerator()), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf(this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
        }
        rn.b bVar = this.publicKey != null ? new rn.b(getS(), this.publicKey, jVar) : new rn.b(getS(), jVar);
        try {
            return (this.algorithm.equals("ECGOST3410") ? new pn.u(new zn.b(qm.a.f47463m, jVar.b()), bVar.b()) : new pn.u(new zn.b(co.r.f11174l0, jVar.b()), bVar.b())).v(gm.j.f29713a);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.ecSpec;
    }

    @Override // java.security.interfaces.ECPrivateKey
    public BigInteger getS() {
        return this.f45349d;
    }

    @Override // er.g
    public void h(gm.y yVar, gm.h hVar) {
        this.attrCarrier.h(yVar, hVar);
    }

    public int hashCode() {
        return f0().hashCode() ^ d().hashCode();
    }

    public final gm.d i(JCEECPublicKey jCEECPublicKey) {
        try {
            return c1.A(gm.c0.D(jCEECPublicKey.getEncoded())).C();
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(pn.u r11) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.provider.JCEECPrivateKey.k(pn.u):void");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String strE = Strings.e();
        stringBuffer.append("EC Private Key");
        stringBuffer.append(strE);
        stringBuffer.append("             S: ");
        stringBuffer.append(this.f45349d.toString(16));
        stringBuffer.append(strE);
        return stringBuffer.toString();
    }
}
