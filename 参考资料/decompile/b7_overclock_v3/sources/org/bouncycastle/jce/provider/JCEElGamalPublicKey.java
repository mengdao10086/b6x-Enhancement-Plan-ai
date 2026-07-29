package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import np.x0;
import org.bouncycastle.jce.interfaces.ElGamalPublicKey;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class JCEElGamalPublicKey implements ElGamalPublicKey, DHPublicKey {
    public static final long serialVersionUID = 8712728417091216948L;
    private gr.j elSpec;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private BigInteger f45352y;

    public JCEElGamalPublicKey(gr.l lVar) {
        this.f45352y = lVar.b();
        this.elSpec = new gr.j(lVar.a().b(), lVar.a().a());
    }

    public JCEElGamalPublicKey(BigInteger bigInteger, gr.j jVar) {
        this.f45352y = bigInteger;
        this.elSpec = jVar;
    }

    public JCEElGamalPublicKey(DHPublicKey dHPublicKey) {
        this.f45352y = dHPublicKey.getY();
        this.elSpec = new gr.j(dHPublicKey.getParams().getP(), dHPublicKey.getParams().getG());
    }

    public JCEElGamalPublicKey(DHPublicKeySpec dHPublicKeySpec) {
        this.f45352y = dHPublicKeySpec.getY();
        this.elSpec = new gr.j(dHPublicKeySpec.getP(), dHPublicKeySpec.getG());
    }

    public JCEElGamalPublicKey(x0 x0Var) {
        this.f45352y = x0Var.e();
        this.elSpec = new gr.j(x0Var.d().c(), x0Var.d().a());
    }

    public JCEElGamalPublicKey(ElGamalPublicKey elGamalPublicKey) {
        this.f45352y = elGamalPublicKey.getY();
        this.elSpec = elGamalPublicKey.b();
    }

    public JCEElGamalPublicKey(c1 c1Var) {
        on.a aVarY = on.a.y(c1Var.x().A());
        try {
            this.f45352y = ((gm.t) c1Var.D()).K();
            this.elSpec = new gr.j(aVarY.z(), aVarY.x());
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DSA public key");
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.f45352y = (BigInteger) objectInputStream.readObject();
        this.elSpec = new gr.j((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getY());
        objectOutputStream.writeObject(this.elSpec.b());
        objectOutputStream.writeObject(this.elSpec.a());
    }

    @Override // er.d
    public gr.j b() {
        return this.elSpec;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "ElGamal";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return org.bouncycastle.jcajce.provider.asymmetric.util.l.c(new zn.b(on.b.f44368l, new on.a(this.elSpec.b(), this.elSpec.a())), new gm.t(this.f45352y));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return new DHParameterSpec(this.elSpec.b(), this.elSpec.a());
    }

    @Override // org.bouncycastle.jce.interfaces.ElGamalPublicKey, javax.crypto.interfaces.DHPublicKey
    public BigInteger getY() {
        return this.f45352y;
    }
}
