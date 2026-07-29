package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import er.g;
import gm.h;
import gm.y;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Enumeration;
import np.e2;
import org.bouncycastle.jcajce.provider.asymmetric.util.l;
import org.bouncycastle.jcajce.provider.asymmetric.util.m;
import org.bouncycastle.util.Strings;
import pn.s;
import pn.x;
import zn.b;

/* JADX INFO: loaded from: classes7.dex */
public class BCRSAPrivateKey implements RSAPrivateKey, g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static BigInteger f45030d = BigInteger.valueOf(0);
    public static final long serialVersionUID = 5110188922551353628L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient b f45031a;
    private byte[] algorithmIdentifierEnc;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient e2 f45032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient m f45033c;
    public BigInteger modulus;
    public BigInteger privateExponent;

    public BCRSAPrivateKey(RSAPrivateKey rSAPrivateKey) {
        b bVar = BCRSAPublicKey.f45034c;
        this.algorithmIdentifierEnc = b(bVar);
        this.f45031a = bVar;
        this.f45033c = new m();
        this.modulus = rSAPrivateKey.getModulus();
        this.privateExponent = rSAPrivateKey.getPrivateExponent();
        this.f45032b = new e2(true, this.modulus, this.privateExponent);
    }

    public BCRSAPrivateKey(RSAPrivateKeySpec rSAPrivateKeySpec) {
        b bVar = BCRSAPublicKey.f45034c;
        this.algorithmIdentifierEnc = b(bVar);
        this.f45031a = bVar;
        this.f45033c = new m();
        this.modulus = rSAPrivateKeySpec.getModulus();
        this.privateExponent = rSAPrivateKeySpec.getPrivateExponent();
        this.f45032b = new e2(true, this.modulus, this.privateExponent);
    }

    public BCRSAPrivateKey(e2 e2Var) {
        b bVar = BCRSAPublicKey.f45034c;
        this.algorithmIdentifierEnc = b(bVar);
        this.f45031a = bVar;
        this.f45033c = new m();
        this.modulus = e2Var.e();
        this.privateExponent = e2Var.d();
        this.f45032b = e2Var;
    }

    public BCRSAPrivateKey(b bVar, e2 e2Var) {
        b bVar2 = BCRSAPublicKey.f45034c;
        this.algorithmIdentifierEnc = b(bVar2);
        this.f45031a = bVar2;
        this.f45033c = new m();
        this.f45031a = bVar;
        this.algorithmIdentifierEnc = b(bVar);
        this.modulus = e2Var.e();
        this.privateExponent = e2Var.d();
        this.f45032b = e2Var;
    }

    public BCRSAPrivateKey(b bVar, x xVar) {
        b bVar2 = BCRSAPublicKey.f45034c;
        this.algorithmIdentifierEnc = b(bVar2);
        this.f45031a = bVar2;
        this.f45033c = new m();
        this.f45031a = bVar;
        this.algorithmIdentifierEnc = b(bVar);
        this.modulus = xVar.C();
        this.privateExponent = xVar.F();
        this.f45032b = new e2(true, this.modulus, this.privateExponent);
    }

    public static byte[] b(b bVar) {
        try {
            return bVar.getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        if (this.algorithmIdentifierEnc == null) {
            this.algorithmIdentifierEnc = b(BCRSAPublicKey.f45034c);
        }
        this.f45031a = b.z(this.algorithmIdentifierEnc);
        this.f45033c = new m();
        this.f45032b = new e2(true, this.modulus, this.privateExponent);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    public e2 a() {
        return this.f45032b;
    }

    @Override // er.g
    public h c(y yVar) {
        return this.f45033c.c(yVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RSAPrivateKey)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) obj;
        return getModulus().equals(rSAPrivateKey.getModulus()) && getPrivateExponent().equals(rSAPrivateKey.getPrivateExponent());
    }

    @Override // er.g
    public Enumeration f() {
        return this.f45033c.f();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.f45031a.x().C(s.G3) ? "RSASSA-PSS" : "RSA";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        b bVar = this.f45031a;
        BigInteger modulus = getModulus();
        BigInteger bigInteger = f45030d;
        BigInteger privateExponent = getPrivateExponent();
        BigInteger bigInteger2 = f45030d;
        return l.b(bVar, new x(modulus, bigInteger, privateExponent, bigInteger2, bigInteger2, bigInteger2, bigInteger2, bigInteger2));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // java.security.interfaces.RSAKey
    public BigInteger getModulus() {
        return this.modulus;
    }

    @Override // java.security.interfaces.RSAPrivateKey
    public BigInteger getPrivateExponent() {
        return this.privateExponent;
    }

    @Override // er.g
    public void h(y yVar, h hVar) {
        this.f45033c.h(yVar, hVar);
    }

    public int hashCode() {
        return getModulus().hashCode() ^ getPrivateExponent().hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String strE = Strings.e();
        stringBuffer.append("RSA Private Key [");
        stringBuffer.append(tq.h.b(getModulus()));
        stringBuffer.append("],[]");
        stringBuffer.append(strE);
        stringBuffer.append("            modulus: ");
        stringBuffer.append(getModulus().toString(16));
        stringBuffer.append(strE);
        return stringBuffer.toString();
    }
}
