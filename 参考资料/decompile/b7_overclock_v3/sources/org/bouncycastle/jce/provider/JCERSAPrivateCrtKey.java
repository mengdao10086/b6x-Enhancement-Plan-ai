package org.bouncycastle.jce.provider;

import gm.d2;
import java.io.IOException;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import np.f2;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class JCERSAPrivateCrtKey extends JCERSAPrivateKey implements RSAPrivateCrtKey {
    public static final long serialVersionUID = 7834723820638524718L;
    private BigInteger crtCoefficient;
    private BigInteger primeExponentP;
    private BigInteger primeExponentQ;
    private BigInteger primeP;
    private BigInteger primeQ;
    private BigInteger publicExponent;

    public JCERSAPrivateCrtKey(RSAPrivateCrtKey rSAPrivateCrtKey) {
        this.modulus = rSAPrivateCrtKey.getModulus();
        this.publicExponent = rSAPrivateCrtKey.getPublicExponent();
        this.privateExponent = rSAPrivateCrtKey.getPrivateExponent();
        this.primeP = rSAPrivateCrtKey.getPrimeP();
        this.primeQ = rSAPrivateCrtKey.getPrimeQ();
        this.primeExponentP = rSAPrivateCrtKey.getPrimeExponentP();
        this.primeExponentQ = rSAPrivateCrtKey.getPrimeExponentQ();
        this.crtCoefficient = rSAPrivateCrtKey.getCrtCoefficient();
    }

    public JCERSAPrivateCrtKey(RSAPrivateCrtKeySpec rSAPrivateCrtKeySpec) {
        this.modulus = rSAPrivateCrtKeySpec.getModulus();
        this.publicExponent = rSAPrivateCrtKeySpec.getPublicExponent();
        this.privateExponent = rSAPrivateCrtKeySpec.getPrivateExponent();
        this.primeP = rSAPrivateCrtKeySpec.getPrimeP();
        this.primeQ = rSAPrivateCrtKeySpec.getPrimeQ();
        this.primeExponentP = rSAPrivateCrtKeySpec.getPrimeExponentP();
        this.primeExponentQ = rSAPrivateCrtKeySpec.getPrimeExponentQ();
        this.crtCoefficient = rSAPrivateCrtKeySpec.getCrtCoefficient();
    }

    public JCERSAPrivateCrtKey(f2 f2Var) {
        super(f2Var);
        this.publicExponent = f2Var.j();
        this.primeP = f2Var.i();
        this.primeQ = f2Var.k();
        this.primeExponentP = f2Var.g();
        this.primeExponentQ = f2Var.h();
        this.crtCoefficient = f2Var.l();
    }

    public JCERSAPrivateCrtKey(pn.u uVar) throws IOException {
        this(pn.x.B(uVar.G()));
    }

    public JCERSAPrivateCrtKey(pn.x xVar) {
        this.modulus = xVar.C();
        this.publicExponent = xVar.G();
        this.privateExponent = xVar.F();
        this.primeP = xVar.D();
        this.primeQ = xVar.E();
        this.primeExponentP = xVar.y();
        this.primeExponentQ = xVar.z();
        this.crtCoefficient = xVar.x();
    }

    @Override // org.bouncycastle.jce.provider.JCERSAPrivateKey
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RSAPrivateCrtKey)) {
            return false;
        }
        RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) obj;
        return getModulus().equals(rSAPrivateCrtKey.getModulus()) && getPublicExponent().equals(rSAPrivateCrtKey.getPublicExponent()) && getPrivateExponent().equals(rSAPrivateCrtKey.getPrivateExponent()) && getPrimeP().equals(rSAPrivateCrtKey.getPrimeP()) && getPrimeQ().equals(rSAPrivateCrtKey.getPrimeQ()) && getPrimeExponentP().equals(rSAPrivateCrtKey.getPrimeExponentP()) && getPrimeExponentQ().equals(rSAPrivateCrtKey.getPrimeExponentQ()) && getCrtCoefficient().equals(rSAPrivateCrtKey.getCrtCoefficient());
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getCrtCoefficient() {
        return this.crtCoefficient;
    }

    @Override // org.bouncycastle.jce.provider.JCERSAPrivateKey, java.security.Key
    public byte[] getEncoded() {
        return org.bouncycastle.jcajce.provider.asymmetric.util.l.b(new zn.b(pn.s.f46854x3, d2.f29657b), new pn.x(getModulus(), getPublicExponent(), getPrivateExponent(), getPrimeP(), getPrimeQ(), getPrimeExponentP(), getPrimeExponentQ(), getCrtCoefficient()));
    }

    @Override // org.bouncycastle.jce.provider.JCERSAPrivateKey, java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeExponentP() {
        return this.primeExponentP;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeExponentQ() {
        return this.primeExponentQ;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeP() {
        return this.primeP;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeQ() {
        return this.primeQ;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    @Override // org.bouncycastle.jce.provider.JCERSAPrivateKey
    public int hashCode() {
        return (getModulus().hashCode() ^ getPublicExponent().hashCode()) ^ getPrivateExponent().hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String strE = Strings.e();
        stringBuffer.append("RSA Private CRT Key");
        stringBuffer.append(strE);
        stringBuffer.append("            modulus: ");
        stringBuffer.append(getModulus().toString(16));
        stringBuffer.append(strE);
        stringBuffer.append("    public exponent: ");
        stringBuffer.append(getPublicExponent().toString(16));
        stringBuffer.append(strE);
        stringBuffer.append("   private exponent: ");
        stringBuffer.append(getPrivateExponent().toString(16));
        stringBuffer.append(strE);
        stringBuffer.append("             primeP: ");
        stringBuffer.append(getPrimeP().toString(16));
        stringBuffer.append(strE);
        stringBuffer.append("             primeQ: ");
        stringBuffer.append(getPrimeQ().toString(16));
        stringBuffer.append(strE);
        stringBuffer.append("     primeExponentP: ");
        stringBuffer.append(getPrimeExponentP().toString(16));
        stringBuffer.append(strE);
        stringBuffer.append("     primeExponentQ: ");
        stringBuffer.append(getPrimeExponentQ().toString(16));
        stringBuffer.append(strE);
        stringBuffer.append("     crtCoefficient: ");
        stringBuffer.append(getCrtCoefficient().toString(16));
        stringBuffer.append(strE);
        return stringBuffer.toString();
    }
}
