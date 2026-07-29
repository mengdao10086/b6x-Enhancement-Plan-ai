package org.bouncycastle.jce.provider;

import gm.d2;
import java.io.IOException;
import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import np.e2;
import org.bouncycastle.util.Strings;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class JCERSAPublicKey implements RSAPublicKey {
    public static final long serialVersionUID = 2675817738516720772L;
    private BigInteger modulus;
    private BigInteger publicExponent;

    public JCERSAPublicKey(RSAPublicKey rSAPublicKey) {
        this.modulus = rSAPublicKey.getModulus();
        this.publicExponent = rSAPublicKey.getPublicExponent();
    }

    public JCERSAPublicKey(RSAPublicKeySpec rSAPublicKeySpec) {
        this.modulus = rSAPublicKeySpec.getModulus();
        this.publicExponent = rSAPublicKeySpec.getPublicExponent();
    }

    public JCERSAPublicKey(e2 e2Var) {
        this.modulus = e2Var.e();
        this.publicExponent = e2Var.d();
    }

    public JCERSAPublicKey(c1 c1Var) {
        try {
            pn.z zVarY = pn.z.y(c1Var.D());
            this.modulus = zVarY.z();
            this.publicExponent = zVarY.A();
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in RSA public key");
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RSAPublicKey)) {
            return false;
        }
        RSAPublicKey rSAPublicKey = (RSAPublicKey) obj;
        return getModulus().equals(rSAPublicKey.getModulus()) && getPublicExponent().equals(rSAPublicKey.getPublicExponent());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "RSA";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return org.bouncycastle.jcajce.provider.asymmetric.util.l.c(new zn.b(pn.s.f46854x3, d2.f29657b), new pn.z(getModulus(), getPublicExponent()));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // java.security.interfaces.RSAKey
    public BigInteger getModulus() {
        return this.modulus;
    }

    @Override // java.security.interfaces.RSAPublicKey
    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    public int hashCode() {
        return getModulus().hashCode() ^ getPublicExponent().hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String strE = Strings.e();
        stringBuffer.append("RSA Public Key");
        stringBuffer.append(strE);
        stringBuffer.append("            modulus: ");
        stringBuffer.append(getModulus().toString(16));
        stringBuffer.append(strE);
        stringBuffer.append("    public exponent: ");
        stringBuffer.append(getPublicExponent().toString(16));
        stringBuffer.append(strE);
        return stringBuffer.toString();
    }
}
