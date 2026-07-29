package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;

/* JADX INFO: loaded from: classes5.dex */
public class JCEDHPrivateKey implements DHPrivateKey, er.g {
    public static final long serialVersionUID = 311058815616901812L;
    private er.g attrCarrier = new org.bouncycastle.jcajce.provider.asymmetric.util.m();
    private DHParameterSpec dhSpec;
    private pn.u info;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public BigInteger f45347x;

    public JCEDHPrivateKey() {
    }

    public JCEDHPrivateKey(DHPrivateKey dHPrivateKey) {
        this.f45347x = dHPrivateKey.getX();
        this.dhSpec = dHPrivateKey.getParams();
    }

    public JCEDHPrivateKey(DHPrivateKeySpec dHPrivateKeySpec) {
        this.f45347x = dHPrivateKeySpec.getX();
        this.dhSpec = new DHParameterSpec(dHPrivateKeySpec.getP(), dHPrivateKeySpec.getG());
    }

    public JCEDHPrivateKey(np.r rVar) {
        this.f45347x = rVar.e();
        this.dhSpec = new DHParameterSpec(rVar.d().f(), rVar.d().b(), rVar.d().d());
    }

    public JCEDHPrivateKey(pn.u uVar) throws IOException {
        DHParameterSpec dHParameterSpec;
        gm.f0 f0VarJ = gm.f0.J(uVar.B().A());
        gm.t tVarI = gm.t.I(uVar.G());
        gm.y yVarX = uVar.B().x();
        this.info = uVar;
        this.f45347x = tVarI.K();
        if (yVarX.C(pn.s.O3)) {
            pn.h hVarY = pn.h.y(f0VarJ);
            dHParameterSpec = hVarY.z() != null ? new DHParameterSpec(hVarY.A(), hVarY.x(), hVarY.z().intValue()) : new DHParameterSpec(hVarY.A(), hVarY.x());
        } else {
            if (!yVarX.C(co.r.f11161d1)) {
                throw new IllegalArgumentException("unknown algorithm type: " + yVarX);
            }
            co.a aVarZ = co.a.z(f0VarJ);
            dHParameterSpec = new DHParameterSpec(aVarZ.C().K(), aVarZ.x().K());
        }
        this.dhSpec = dHParameterSpec;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.f45347x = (BigInteger) objectInputStream.readObject();
        this.dhSpec = new DHParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), objectInputStream.readInt());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getX());
        objectOutputStream.writeObject(this.dhSpec.getP());
        objectOutputStream.writeObject(this.dhSpec.getG());
        objectOutputStream.writeInt(this.dhSpec.getL());
    }

    @Override // er.g
    public gm.h c(gm.y yVar) {
        return this.attrCarrier.c(yVar);
    }

    @Override // er.g
    public Enumeration f() {
        return this.attrCarrier.f();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DH";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            pn.u uVar = this.info;
            return uVar != null ? uVar.v(gm.j.f29713a) : new pn.u(new zn.b(pn.s.O3, new pn.h(this.dhSpec.getP(), this.dhSpec.getG(), this.dhSpec.getL())), new gm.t(getX())).v(gm.j.f29713a);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return this.dhSpec;
    }

    @Override // javax.crypto.interfaces.DHPrivateKey
    public BigInteger getX() {
        return this.f45347x;
    }

    @Override // er.g
    public void h(gm.y yVar, gm.h hVar) {
        this.attrCarrier.h(yVar, hVar);
    }
}
