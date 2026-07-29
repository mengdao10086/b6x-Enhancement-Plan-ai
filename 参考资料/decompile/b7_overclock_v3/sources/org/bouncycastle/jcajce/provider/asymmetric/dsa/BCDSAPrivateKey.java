package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import co.r;
import er.g;
import gm.h;
import gm.t;
import gm.y;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPrivateKeySpec;
import java.util.Enumeration;
import np.a0;
import org.bouncycastle.jcajce.provider.asymmetric.util.l;
import org.bouncycastle.jcajce.provider.asymmetric.util.m;
import org.bouncycastle.util.Strings;
import pn.u;
import zn.s;

/* JADX INFO: loaded from: classes7.dex */
public class BCDSAPrivateKey implements DSAPrivateKey, g {
    private static final long serialVersionUID = -4677259546958385734L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient DSAParams f44885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient m f44886b = new m();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private BigInteger f44887x;

    public BCDSAPrivateKey() {
    }

    public BCDSAPrivateKey(DSAPrivateKey dSAPrivateKey) {
        this.f44887x = dSAPrivateKey.getX();
        this.f44885a = dSAPrivateKey.getParams();
    }

    public BCDSAPrivateKey(DSAPrivateKeySpec dSAPrivateKeySpec) {
        this.f44887x = dSAPrivateKeySpec.getX();
        this.f44885a = new DSAParameterSpec(dSAPrivateKeySpec.getP(), dSAPrivateKeySpec.getQ(), dSAPrivateKeySpec.getG());
    }

    public BCDSAPrivateKey(a0 a0Var) {
        this.f44887x = a0Var.e();
        this.f44885a = new DSAParameterSpec(a0Var.d().b(), a0Var.d().c(), a0Var.d().a());
    }

    public BCDSAPrivateKey(u uVar) throws IOException {
        s sVarZ = s.z(uVar.B().A());
        this.f44887x = ((t) uVar.G()).K();
        this.f44885a = new DSAParameterSpec(sVarZ.A(), sVarZ.B(), sVarZ.x());
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f44885a = new DSAParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
        this.f44886b = new m();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f44885a.getP());
        objectOutputStream.writeObject(this.f44885a.getQ());
        objectOutputStream.writeObject(this.f44885a.getG());
    }

    @Override // er.g
    public h c(y yVar) {
        return this.f44886b.c(yVar);
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
        return this.f44886b.f();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DSA";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return l.b(new zn.b(r.W0, new s(this.f44885a.getP(), this.f44885a.getQ(), this.f44885a.getG()).b()), new t(getX()));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // java.security.interfaces.DSAKey
    public DSAParams getParams() {
        return this.f44885a;
    }

    @Override // java.security.interfaces.DSAPrivateKey
    public BigInteger getX() {
        return this.f44887x;
    }

    @Override // er.g
    public void h(y yVar, h hVar) {
        this.f44886b.h(yVar, hVar);
    }

    public int hashCode() {
        return ((getX().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getQ().hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String strE = Strings.e();
        BigInteger bigIntegerModPow = getParams().getG().modPow(this.f44887x, getParams().getP());
        stringBuffer.append("DSA Private Key [");
        stringBuffer.append(d.a(bigIntegerModPow, getParams()));
        stringBuffer.append("]");
        stringBuffer.append(strE);
        stringBuffer.append("            Y: ");
        stringBuffer.append(bigIntegerModPow.toString(16));
        stringBuffer.append(strE);
        return stringBuffer.toString();
    }
}
