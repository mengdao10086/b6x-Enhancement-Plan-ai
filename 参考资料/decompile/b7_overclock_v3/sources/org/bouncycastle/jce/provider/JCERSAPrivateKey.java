package org.bouncycastle.jce.provider;

import gm.d2;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Enumeration;
import np.e2;

/* JADX INFO: loaded from: classes5.dex */
public class JCERSAPrivateKey implements RSAPrivateKey, er.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static BigInteger f45353b = BigInteger.valueOf(0);
    public static final long serialVersionUID = 5110188922551353628L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient org.bouncycastle.jcajce.provider.asymmetric.util.m f45354a = new org.bouncycastle.jcajce.provider.asymmetric.util.m();
    public BigInteger modulus;
    public BigInteger privateExponent;

    public JCERSAPrivateKey() {
    }

    public JCERSAPrivateKey(RSAPrivateKey rSAPrivateKey) {
        this.modulus = rSAPrivateKey.getModulus();
        this.privateExponent = rSAPrivateKey.getPrivateExponent();
    }

    public JCERSAPrivateKey(RSAPrivateKeySpec rSAPrivateKeySpec) {
        this.modulus = rSAPrivateKeySpec.getModulus();
        this.privateExponent = rSAPrivateKeySpec.getPrivateExponent();
    }

    public JCERSAPrivateKey(e2 e2Var) {
        this.modulus = e2Var.e();
        this.privateExponent = e2Var.d();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        this.modulus = (BigInteger) objectInputStream.readObject();
        org.bouncycastle.jcajce.provider.asymmetric.util.m mVar = new org.bouncycastle.jcajce.provider.asymmetric.util.m();
        this.f45354a = mVar;
        mVar.d(objectInputStream);
        this.privateExponent = (BigInteger) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.modulus);
        this.f45354a.g(objectOutputStream);
        objectOutputStream.writeObject(this.privateExponent);
    }

    @Override // er.g
    public gm.h c(gm.y yVar) {
        return this.f45354a.c(yVar);
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
        return this.f45354a.f();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "RSA";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        zn.b bVar = new zn.b(pn.s.f46854x3, d2.f29657b);
        BigInteger modulus = getModulus();
        BigInteger bigInteger = f45353b;
        BigInteger privateExponent = getPrivateExponent();
        BigInteger bigInteger2 = f45353b;
        return org.bouncycastle.jcajce.provider.asymmetric.util.l.b(bVar, new pn.x(modulus, bigInteger, privateExponent, bigInteger2, bigInteger2, bigInteger2, bigInteger2, bigInteger2));
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
    public void h(gm.y yVar, gm.h hVar) {
        this.f45354a.h(yVar, hVar);
    }

    public int hashCode() {
        return getModulus().hashCode() ^ getPrivateExponent().hashCode();
    }
}
