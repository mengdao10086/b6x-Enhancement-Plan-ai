package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import np.f2;
import org.bouncycastle.jcajce.provider.asymmetric.util.l;
import org.bouncycastle.jcajce.provider.asymmetric.util.m;
import org.bouncycastle.util.Strings;
import pn.u;
import pn.x;
import tq.h;
import zn.b;

/* JADX INFO: loaded from: classes7.dex */
public class BCRSAPrivateCrtKey extends BCRSAPrivateKey implements RSAPrivateCrtKey {
    public static final long serialVersionUID = 7834723820638524718L;
    private BigInteger crtCoefficient;
    private BigInteger primeExponentP;
    private BigInteger primeExponentQ;
    private BigInteger primeP;
    private BigInteger primeQ;
    private BigInteger publicExponent;

    public BCRSAPrivateCrtKey(RSAPrivateCrtKey rSAPrivateCrtKey) {
        super(new f2(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent(), rSAPrivateCrtKey.getPrivateExponent(), rSAPrivateCrtKey.getPrimeP(), rSAPrivateCrtKey.getPrimeQ(), rSAPrivateCrtKey.getPrimeExponentP(), rSAPrivateCrtKey.getPrimeExponentQ(), rSAPrivateCrtKey.getCrtCoefficient()));
        this.modulus = rSAPrivateCrtKey.getModulus();
        this.publicExponent = rSAPrivateCrtKey.getPublicExponent();
        this.privateExponent = rSAPrivateCrtKey.getPrivateExponent();
        this.primeP = rSAPrivateCrtKey.getPrimeP();
        this.primeQ = rSAPrivateCrtKey.getPrimeQ();
        this.primeExponentP = rSAPrivateCrtKey.getPrimeExponentP();
        this.primeExponentQ = rSAPrivateCrtKey.getPrimeExponentQ();
        this.crtCoefficient = rSAPrivateCrtKey.getCrtCoefficient();
    }

    public BCRSAPrivateCrtKey(RSAPrivateCrtKeySpec rSAPrivateCrtKeySpec) {
        super(new f2(rSAPrivateCrtKeySpec.getModulus(), rSAPrivateCrtKeySpec.getPublicExponent(), rSAPrivateCrtKeySpec.getPrivateExponent(), rSAPrivateCrtKeySpec.getPrimeP(), rSAPrivateCrtKeySpec.getPrimeQ(), rSAPrivateCrtKeySpec.getPrimeExponentP(), rSAPrivateCrtKeySpec.getPrimeExponentQ(), rSAPrivateCrtKeySpec.getCrtCoefficient()));
        this.modulus = rSAPrivateCrtKeySpec.getModulus();
        this.publicExponent = rSAPrivateCrtKeySpec.getPublicExponent();
        this.privateExponent = rSAPrivateCrtKeySpec.getPrivateExponent();
        this.primeP = rSAPrivateCrtKeySpec.getPrimeP();
        this.primeQ = rSAPrivateCrtKeySpec.getPrimeQ();
        this.primeExponentP = rSAPrivateCrtKeySpec.getPrimeExponentP();
        this.primeExponentQ = rSAPrivateCrtKeySpec.getPrimeExponentQ();
        this.crtCoefficient = rSAPrivateCrtKeySpec.getCrtCoefficient();
    }

    public BCRSAPrivateCrtKey(f2 f2Var) {
        super(f2Var);
        this.publicExponent = f2Var.j();
        this.primeP = f2Var.i();
        this.primeQ = f2Var.k();
        this.primeExponentP = f2Var.g();
        this.primeExponentQ = f2Var.h();
        this.crtCoefficient = f2Var.l();
    }

    public BCRSAPrivateCrtKey(u uVar) throws IOException {
        this(uVar.B(), x.B(uVar.G()));
    }

    public BCRSAPrivateCrtKey(x xVar) {
        this(BCRSAPublicKey.f45034c, xVar);
    }

    public BCRSAPrivateCrtKey(b bVar, f2 f2Var) {
        super(bVar, f2Var);
        this.publicExponent = f2Var.j();
        this.primeP = f2Var.i();
        this.primeQ = f2Var.k();
        this.primeExponentP = f2Var.g();
        this.primeExponentQ = f2Var.h();
        this.crtCoefficient = f2Var.l();
    }

    public BCRSAPrivateCrtKey(b bVar, x xVar) {
        super(bVar, new f2(xVar.C(), xVar.G(), xVar.F(), xVar.D(), xVar.E(), xVar.y(), xVar.z(), xVar.x()));
        this.modulus = xVar.C();
        this.publicExponent = xVar.G();
        this.privateExponent = xVar.F();
        this.primeP = xVar.D();
        this.primeQ = xVar.E();
        this.primeExponentP = xVar.y();
        this.primeExponentQ = xVar.z();
        this.crtCoefficient = xVar.x();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f45033c = new m();
        this.f45032b = new f2(getModulus(), getPublicExponent(), getPrivateExponent(), getPrimeP(), getPrimeQ(), getPrimeExponentP(), getPrimeExponentQ(), getCrtCoefficient());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateKey
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

    @Override // org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateKey, java.security.Key
    public byte[] getEncoded() {
        return l.b(this.f45031a, new x(getModulus(), getPublicExponent(), getPrivateExponent(), getPrimeP(), getPrimeQ(), getPrimeExponentP(), getPrimeExponentQ(), getCrtCoefficient()));
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateKey, java.security.Key
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

    @Override // org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateKey
    public int hashCode() {
        return (getModulus().hashCode() ^ getPublicExponent().hashCode()) ^ getPrivateExponent().hashCode();
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateKey
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String strE = Strings.e();
        stringBuffer.append("RSA Private CRT Key [");
        stringBuffer.append(h.b(getModulus()));
        stringBuffer.append("]");
        stringBuffer.append(",[");
        stringBuffer.append(h.a(getPublicExponent()));
        stringBuffer.append("]");
        stringBuffer.append(strE);
        stringBuffer.append("             modulus: ");
        stringBuffer.append(getModulus().toString(16));
        stringBuffer.append(strE);
        stringBuffer.append("     public exponent: ");
        stringBuffer.append(getPublicExponent().toString(16));
        stringBuffer.append(strE);
        return stringBuffer.toString();
    }
}
