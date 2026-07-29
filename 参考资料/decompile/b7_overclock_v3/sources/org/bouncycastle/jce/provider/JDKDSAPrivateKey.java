package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPrivateKeySpec;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class JDKDSAPrivateKey implements DSAPrivateKey, er.g {
    private static final long serialVersionUID = -4677259546958385734L;
    private org.bouncycastle.jcajce.provider.asymmetric.util.m attrCarrier = new org.bouncycastle.jcajce.provider.asymmetric.util.m();
    public DSAParams dsaSpec;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public BigInteger f45355x;

    public JDKDSAPrivateKey() {
    }

    public JDKDSAPrivateKey(DSAPrivateKey dSAPrivateKey) {
        this.f45355x = dSAPrivateKey.getX();
        this.dsaSpec = dSAPrivateKey.getParams();
    }

    public JDKDSAPrivateKey(DSAPrivateKeySpec dSAPrivateKeySpec) {
        this.f45355x = dSAPrivateKeySpec.getX();
        this.dsaSpec = new DSAParameterSpec(dSAPrivateKeySpec.getP(), dSAPrivateKeySpec.getQ(), dSAPrivateKeySpec.getG());
    }

    public JDKDSAPrivateKey(np.a0 a0Var) {
        this.f45355x = a0Var.e();
        this.dsaSpec = new DSAParameterSpec(a0Var.d().b(), a0Var.d().c(), a0Var.d().a());
    }

    public JDKDSAPrivateKey(pn.u uVar) throws IOException {
        zn.s sVarZ = zn.s.z(uVar.B().A());
        this.f45355x = gm.t.I(uVar.G()).K();
        this.dsaSpec = new DSAParameterSpec(sVarZ.A(), sVarZ.B(), sVarZ.x());
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        this.f45355x = (BigInteger) objectInputStream.readObject();
        this.dsaSpec = new DSAParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
        org.bouncycastle.jcajce.provider.asymmetric.util.m mVar = new org.bouncycastle.jcajce.provider.asymmetric.util.m();
        this.attrCarrier = mVar;
        mVar.d(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.f45355x);
        objectOutputStream.writeObject(this.dsaSpec.getP());
        objectOutputStream.writeObject(this.dsaSpec.getQ());
        objectOutputStream.writeObject(this.dsaSpec.getG());
        this.attrCarrier.g(objectOutputStream);
    }

    @Override // er.g
    public gm.h c(gm.y yVar) {
        return this.attrCarrier.c(yVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAPrivateKey)) {
            return false;
        }
        DSAPrivateKey dSAPrivateKey = (DSAPrivateKey) obj;
        return getX().equals(dSAPrivateKey.getX()) && getParams().getG().equals(dSAPrivateKey.getParams().getG()) && getParams().getP().equals(dSAPrivateKey.getParams().getP()) && getParams().getQ().equals(dSAPrivateKey.getParams().getQ());
    }

    @Override // er.g
    public Enumeration f() {
        return this.attrCarrier.f();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DSA";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new pn.u(new zn.b(co.r.W0, new zn.s(this.dsaSpec.getP(), this.dsaSpec.getQ(), this.dsaSpec.getG())), new gm.t(getX())).v(gm.j.f29713a);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // java.security.interfaces.DSAKey
    public DSAParams getParams() {
        return this.dsaSpec;
    }

    @Override // java.security.interfaces.DSAPrivateKey
    public BigInteger getX() {
        return this.f45355x;
    }

    @Override // er.g
    public void h(gm.y yVar, gm.h hVar) {
        this.attrCarrier.h(yVar, hVar);
    }

    public int hashCode() {
        return ((getX().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getQ().hashCode();
    }
}
