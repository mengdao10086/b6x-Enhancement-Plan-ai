package org.bouncycastle.jcajce.provider.asymmetric.elgamal;

import gm.t;
import gr.j;
import gr.l;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import np.x0;
import on.a;
import org.bouncycastle.jce.interfaces.ElGamalPublicKey;
import zn.b;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class BCElGamalPublicKey implements ElGamalPublicKey, DHPublicKey {
    public static final long serialVersionUID = 8712728417091216948L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient j f45023a;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private BigInteger f45024y;

    public BCElGamalPublicKey(l lVar) {
        this.f45024y = lVar.b();
        this.f45023a = new j(lVar.a().b(), lVar.a().a());
    }

    public BCElGamalPublicKey(BigInteger bigInteger, j jVar) {
        this.f45024y = bigInteger;
        this.f45023a = jVar;
    }

    public BCElGamalPublicKey(DHPublicKey dHPublicKey) {
        this.f45024y = dHPublicKey.getY();
        this.f45023a = new j(dHPublicKey.getParams().getP(), dHPublicKey.getParams().getG());
    }

    public BCElGamalPublicKey(DHPublicKeySpec dHPublicKeySpec) {
        this.f45024y = dHPublicKeySpec.getY();
        this.f45023a = new j(dHPublicKeySpec.getP(), dHPublicKeySpec.getG());
    }

    public BCElGamalPublicKey(x0 x0Var) {
        this.f45024y = x0Var.e();
        this.f45023a = new j(x0Var.d().c(), x0Var.d().a());
    }

    public BCElGamalPublicKey(ElGamalPublicKey elGamalPublicKey) {
        this.f45024y = elGamalPublicKey.getY();
        this.f45023a = elGamalPublicKey.b();
    }

    public BCElGamalPublicKey(c1 c1Var) {
        a aVarY = a.y(c1Var.x().A());
        try {
            this.f45024y = ((t) c1Var.D()).K();
            this.f45023a = new j(aVarY.z(), aVarY.x());
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DSA public key");
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f45023a = new j((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f45023a.b());
        objectOutputStream.writeObject(this.f45023a.a());
    }

    @Override // er.d
    public j b() {
        return this.f45023a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHPublicKey)) {
            return false;
        }
        DHPublicKey dHPublicKey = (DHPublicKey) obj;
        return getY().equals(dHPublicKey.getY()) && getParams().getG().equals(dHPublicKey.getParams().getG()) && getParams().getP().equals(dHPublicKey.getParams().getP()) && getParams().getL() == dHPublicKey.getParams().getL();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "ElGamal";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new c1(new b(on.b.f44368l, new a(this.f45023a.b(), this.f45023a.a())), new t(this.f45024y)).v(gm.j.f29713a);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return new DHParameterSpec(this.f45023a.b(), this.f45023a.a());
    }

    @Override // org.bouncycastle.jce.interfaces.ElGamalPublicKey, javax.crypto.interfaces.DHPublicKey
    public BigInteger getY() {
        return this.f45024y;
    }

    public int hashCode() {
        return ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getL();
    }
}
