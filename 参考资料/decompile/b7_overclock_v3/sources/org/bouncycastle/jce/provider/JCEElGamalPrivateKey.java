package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;
import np.w0;
import org.bouncycastle.jce.interfaces.ElGamalPrivateKey;

/* JADX INFO: loaded from: classes5.dex */
public class JCEElGamalPrivateKey implements ElGamalPrivateKey, DHPrivateKey, er.g {
    public static final long serialVersionUID = 4819350091141529678L;
    private org.bouncycastle.jcajce.provider.asymmetric.util.m attrCarrier = new org.bouncycastle.jcajce.provider.asymmetric.util.m();
    public gr.j elSpec;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public BigInteger f45351x;

    public JCEElGamalPrivateKey() {
    }

    public JCEElGamalPrivateKey(gr.k kVar) {
        this.f45351x = kVar.b();
        this.elSpec = new gr.j(kVar.a().b(), kVar.a().a());
    }

    public JCEElGamalPrivateKey(DHPrivateKey dHPrivateKey) {
        this.f45351x = dHPrivateKey.getX();
        this.elSpec = new gr.j(dHPrivateKey.getParams().getP(), dHPrivateKey.getParams().getG());
    }

    public JCEElGamalPrivateKey(DHPrivateKeySpec dHPrivateKeySpec) {
        this.f45351x = dHPrivateKeySpec.getX();
        this.elSpec = new gr.j(dHPrivateKeySpec.getP(), dHPrivateKeySpec.getG());
    }

    public JCEElGamalPrivateKey(w0 w0Var) {
        this.f45351x = w0Var.e();
        this.elSpec = new gr.j(w0Var.d().c(), w0Var.d().a());
    }

    public JCEElGamalPrivateKey(ElGamalPrivateKey elGamalPrivateKey) {
        this.f45351x = elGamalPrivateKey.getX();
        this.elSpec = elGamalPrivateKey.b();
    }

    public JCEElGamalPrivateKey(pn.u uVar) throws IOException {
        on.a aVarY = on.a.y(uVar.B().A());
        this.f45351x = gm.t.I(uVar.G()).K();
        this.elSpec = new gr.j(aVarY.z(), aVarY.x());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.f45351x = (BigInteger) objectInputStream.readObject();
        this.elSpec = new gr.j((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getX());
        objectOutputStream.writeObject(this.elSpec.b());
        objectOutputStream.writeObject(this.elSpec.a());
    }

    @Override // er.d
    public gr.j b() {
        return this.elSpec;
    }

    @Override // er.g
    public gm.h c(gm.y yVar) {
        return this.attrCarrier.c(yVar);
    }

    @Override // er.g
    public Enumeration f() {
        return this.attrCarrier.f();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "ElGamal";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return org.bouncycastle.jcajce.provider.asymmetric.util.l.b(new zn.b(on.b.f44368l, new on.a(this.elSpec.b(), this.elSpec.a())), new gm.t(getX()));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return new DHParameterSpec(this.elSpec.b(), this.elSpec.a());
    }

    @Override // org.bouncycastle.jce.interfaces.ElGamalPrivateKey, javax.crypto.interfaces.DHPrivateKey
    public BigInteger getX() {
        return this.f45351x;
    }

    @Override // er.g
    public void h(gm.y yVar, gm.h hVar) {
        this.attrCarrier.h(yVar, hVar);
    }
}
