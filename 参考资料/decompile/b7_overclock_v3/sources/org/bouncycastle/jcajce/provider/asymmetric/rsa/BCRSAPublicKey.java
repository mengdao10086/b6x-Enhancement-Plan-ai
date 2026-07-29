package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import gm.d2;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import np.e2;
import org.bouncycastle.jcajce.provider.asymmetric.util.l;
import org.bouncycastle.util.Strings;
import pn.s;
import pn.z;
import tq.h;
import zn.b;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class BCRSAPublicKey implements RSAPublicKey {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f45034c = new b(s.f46854x3, d2.f29657b);
    public static final long serialVersionUID = 2675817738516720772L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient b f45035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient e2 f45036b;
    private BigInteger modulus;
    private BigInteger publicExponent;

    public BCRSAPublicKey(RSAPublicKey rSAPublicKey) {
        this.f45035a = f45034c;
        this.modulus = rSAPublicKey.getModulus();
        this.publicExponent = rSAPublicKey.getPublicExponent();
        this.f45036b = new e2(false, this.modulus, this.publicExponent);
    }

    public BCRSAPublicKey(RSAPublicKeySpec rSAPublicKeySpec) {
        this.f45035a = f45034c;
        this.modulus = rSAPublicKeySpec.getModulus();
        this.publicExponent = rSAPublicKeySpec.getPublicExponent();
        this.f45036b = new e2(false, this.modulus, this.publicExponent);
    }

    public BCRSAPublicKey(e2 e2Var) {
        this(f45034c, e2Var);
    }

    public BCRSAPublicKey(b bVar, e2 e2Var) {
        this.f45035a = bVar;
        this.modulus = e2Var.e();
        this.publicExponent = e2Var.d();
        this.f45036b = e2Var;
    }

    public BCRSAPublicKey(c1 c1Var) {
        b(c1Var);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        try {
            this.f45035a = b.z(objectInputStream.readObject());
        } catch (Exception unused) {
            this.f45035a = f45034c;
        }
        this.f45036b = new e2(false, this.modulus, this.publicExponent);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        if (this.f45035a.equals(f45034c)) {
            return;
        }
        objectOutputStream.writeObject(this.f45035a.getEncoded());
    }

    public e2 a() {
        return this.f45036b;
    }

    public final void b(c1 c1Var) {
        try {
            z zVarY = z.y(c1Var.D());
            this.f45035a = c1Var.x();
            this.modulus = zVarY.z();
            this.publicExponent = zVarY.A();
            this.f45036b = new e2(false, this.modulus, this.publicExponent);
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
        return this.f45035a.x().C(s.G3) ? "RSASSA-PSS" : "RSA";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return l.c(this.f45035a, new z(getModulus(), getPublicExponent()));
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
        stringBuffer.append("RSA Public Key [");
        stringBuffer.append(h.b(getModulus()));
        stringBuffer.append("]");
        stringBuffer.append(",[");
        stringBuffer.append(h.a(getPublicExponent()));
        stringBuffer.append("]");
        stringBuffer.append(strE);
        stringBuffer.append("        modulus: ");
        stringBuffer.append(getModulus().toString(16));
        stringBuffer.append(strE);
        stringBuffer.append("public exponent: ");
        stringBuffer.append(getPublicExponent().toString(16));
        stringBuffer.append(strE);
        return stringBuffer.toString();
    }
}
