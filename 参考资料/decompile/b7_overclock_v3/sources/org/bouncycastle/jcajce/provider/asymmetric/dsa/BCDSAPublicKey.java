package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import co.r;
import gm.d2;
import gm.h;
import gm.t;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPublicKeySpec;
import np.b0;
import org.bouncycastle.jcajce.provider.asymmetric.util.l;
import org.bouncycastle.util.Strings;
import zn.c1;
import zn.s;

/* JADX INFO: loaded from: classes7.dex */
public class BCDSAPublicKey implements DSAPublicKey {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static BigInteger f44888c = BigInteger.valueOf(0);
    private static final long serialVersionUID = 1752452449903495175L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient b0 f44889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient DSAParams f44890b;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private BigInteger f44891y;

    public BCDSAPublicKey(DSAPublicKey dSAPublicKey) {
        this.f44891y = dSAPublicKey.getY();
        this.f44890b = dSAPublicKey.getParams();
        this.f44889a = new b0(this.f44891y, d.e(this.f44890b));
    }

    public BCDSAPublicKey(DSAPublicKeySpec dSAPublicKeySpec) {
        this.f44891y = dSAPublicKeySpec.getY();
        this.f44890b = new DSAParameterSpec(dSAPublicKeySpec.getP(), dSAPublicKeySpec.getQ(), dSAPublicKeySpec.getG());
        this.f44889a = new b0(this.f44891y, d.e(this.f44890b));
    }

    public BCDSAPublicKey(b0 b0Var) {
        this.f44891y = b0Var.e();
        this.f44890b = b0Var.d() != null ? new DSAParameterSpec(b0Var.d().b(), b0Var.d().c(), b0Var.d().a()) : null;
        this.f44889a = b0Var;
    }

    public BCDSAPublicKey(c1 c1Var) {
        try {
            this.f44891y = ((t) c1Var.D()).K();
            if (b(c1Var.x().A())) {
                s sVarZ = s.z(c1Var.x().A());
                this.f44890b = new DSAParameterSpec(sVarZ.A(), sVarZ.B(), sVarZ.x());
            } else {
                this.f44890b = null;
            }
            this.f44889a = new b0(this.f44891y, d.e(this.f44890b));
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DSA public key");
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        BigInteger bigInteger = (BigInteger) objectInputStream.readObject();
        if (bigInteger.equals(f44888c)) {
            this.f44890b = null;
        } else {
            this.f44890b = new DSAParameterSpec(bigInteger, (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
        }
        this.f44889a = new b0(this.f44891y, d.e(this.f44890b));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        BigInteger g10;
        objectOutputStream.defaultWriteObject();
        DSAParams dSAParams = this.f44890b;
        if (dSAParams == null) {
            g10 = f44888c;
        } else {
            objectOutputStream.writeObject(dSAParams.getP());
            objectOutputStream.writeObject(this.f44890b.getQ());
            g10 = this.f44890b.getG();
        }
        objectOutputStream.writeObject(g10);
    }

    public b0 a() {
        return this.f44889a;
    }

    public final boolean b(h hVar) {
        return (hVar == null || d2.f29657b.C(hVar.b())) ? false : true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAPublicKey)) {
            return false;
        }
        DSAPublicKey dSAPublicKey = (DSAPublicKey) obj;
        return this.f44890b != null ? getY().equals(dSAPublicKey.getY()) && dSAPublicKey.getParams() != null && getParams().getG().equals(dSAPublicKey.getParams().getG()) && getParams().getP().equals(dSAPublicKey.getParams().getP()) && getParams().getQ().equals(dSAPublicKey.getParams().getQ()) : getY().equals(dSAPublicKey.getY()) && dSAPublicKey.getParams() == null;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DSA";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        DSAParams dSAParams = this.f44890b;
        return dSAParams == null ? l.c(new zn.b(r.W0), new t(this.f44891y)) : l.c(new zn.b(r.W0, new s(dSAParams.getP(), this.f44890b.getQ(), this.f44890b.getG()).b()), new t(this.f44891y));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // java.security.interfaces.DSAKey
    public DSAParams getParams() {
        return this.f44890b;
    }

    @Override // java.security.interfaces.DSAPublicKey
    public BigInteger getY() {
        return this.f44891y;
    }

    public int hashCode() {
        return this.f44890b != null ? ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getQ().hashCode() : getY().hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String strE = Strings.e();
        stringBuffer.append("DSA Public Key [");
        stringBuffer.append(d.a(this.f44891y, getParams()));
        stringBuffer.append("]");
        stringBuffer.append(strE);
        stringBuffer.append("            Y: ");
        stringBuffer.append(getY().toString(16));
        stringBuffer.append(strE);
        return stringBuffer.toString();
    }
}
