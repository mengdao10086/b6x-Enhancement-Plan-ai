package org.bouncycastle.jce.provider;

import gm.d2;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPublicKeySpec;
import org.bouncycastle.util.Strings;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class JDKDSAPublicKey implements DSAPublicKey {
    private static final long serialVersionUID = 1752452449903495175L;
    private DSAParams dsaSpec;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private BigInteger f45356y;

    public JDKDSAPublicKey(BigInteger bigInteger, DSAParameterSpec dSAParameterSpec) {
        this.f45356y = bigInteger;
        this.dsaSpec = dSAParameterSpec;
    }

    public JDKDSAPublicKey(DSAPublicKey dSAPublicKey) {
        this.f45356y = dSAPublicKey.getY();
        this.dsaSpec = dSAPublicKey.getParams();
    }

    public JDKDSAPublicKey(DSAPublicKeySpec dSAPublicKeySpec) {
        this.f45356y = dSAPublicKeySpec.getY();
        this.dsaSpec = new DSAParameterSpec(dSAPublicKeySpec.getP(), dSAPublicKeySpec.getQ(), dSAPublicKeySpec.getG());
    }

    public JDKDSAPublicKey(np.b0 b0Var) {
        this.f45356y = b0Var.e();
        this.dsaSpec = new DSAParameterSpec(b0Var.d().b(), b0Var.d().c(), b0Var.d().a());
    }

    public JDKDSAPublicKey(c1 c1Var) {
        try {
            this.f45356y = ((gm.t) c1Var.D()).K();
            if (a(c1Var.x().A())) {
                zn.s sVarZ = zn.s.z(c1Var.x().A());
                this.dsaSpec = new DSAParameterSpec(sVarZ.A(), sVarZ.B(), sVarZ.x());
            }
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DSA public key");
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.f45356y = (BigInteger) objectInputStream.readObject();
        this.dsaSpec = new DSAParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.f45356y);
        objectOutputStream.writeObject(this.dsaSpec.getP());
        objectOutputStream.writeObject(this.dsaSpec.getQ());
        objectOutputStream.writeObject(this.dsaSpec.getG());
    }

    public final boolean a(gm.h hVar) {
        return (hVar == null || d2.f29657b.B(hVar)) ? false : true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAPublicKey)) {
            return false;
        }
        DSAPublicKey dSAPublicKey = (DSAPublicKey) obj;
        return getY().equals(dSAPublicKey.getY()) && getParams().getG().equals(dSAPublicKey.getParams().getG()) && getParams().getP().equals(dSAPublicKey.getParams().getP()) && getParams().getQ().equals(dSAPublicKey.getParams().getQ());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DSA";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            DSAParams dSAParams = this.dsaSpec;
            return dSAParams == null ? new c1(new zn.b(co.r.W0), new gm.t(this.f45356y)).v(gm.j.f29713a) : new c1(new zn.b(co.r.W0, new zn.s(dSAParams.getP(), this.dsaSpec.getQ(), this.dsaSpec.getG())), new gm.t(this.f45356y)).v(gm.j.f29713a);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // java.security.interfaces.DSAKey
    public DSAParams getParams() {
        return this.dsaSpec;
    }

    @Override // java.security.interfaces.DSAPublicKey
    public BigInteger getY() {
        return this.f45356y;
    }

    public int hashCode() {
        return ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getQ().hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String strE = Strings.e();
        stringBuffer.append("DSA Public Key");
        stringBuffer.append(strE);
        stringBuffer.append("            y: ");
        stringBuffer.append(getY().toString(16));
        stringBuffer.append(strE);
        return stringBuffer.toString();
    }
}
