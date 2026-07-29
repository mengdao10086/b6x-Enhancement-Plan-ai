package org.bouncycastle.jcajce.provider.asymmetric.elgamal;

import er.g;
import gm.h;
import gm.t;
import gm.y;
import gr.j;
import gr.k;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;
import np.w0;
import on.a;
import org.bouncycastle.jcajce.provider.asymmetric.util.m;
import org.bouncycastle.jce.interfaces.ElGamalPrivateKey;
import pn.u;
import zn.b;

/* JADX INFO: loaded from: classes7.dex */
public class BCElGamalPrivateKey implements ElGamalPrivateKey, DHPrivateKey, g {
    public static final long serialVersionUID = 4819350091141529678L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient j f45020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient m f45021b = new m();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private BigInteger f45022x;

    public BCElGamalPrivateKey() {
    }

    public BCElGamalPrivateKey(k kVar) {
        this.f45022x = kVar.b();
        this.f45020a = new j(kVar.a().b(), kVar.a().a());
    }

    public BCElGamalPrivateKey(DHPrivateKey dHPrivateKey) {
        this.f45022x = dHPrivateKey.getX();
        this.f45020a = new j(dHPrivateKey.getParams().getP(), dHPrivateKey.getParams().getG());
    }

    public BCElGamalPrivateKey(DHPrivateKeySpec dHPrivateKeySpec) {
        this.f45022x = dHPrivateKeySpec.getX();
        this.f45020a = new j(dHPrivateKeySpec.getP(), dHPrivateKeySpec.getG());
    }

    public BCElGamalPrivateKey(w0 w0Var) {
        this.f45022x = w0Var.e();
        this.f45020a = new j(w0Var.d().c(), w0Var.d().a());
    }

    public BCElGamalPrivateKey(ElGamalPrivateKey elGamalPrivateKey) {
        this.f45022x = elGamalPrivateKey.getX();
        this.f45020a = elGamalPrivateKey.b();
    }

    public BCElGamalPrivateKey(u uVar) throws IOException {
        a aVarY = a.y(uVar.B().A());
        this.f45022x = t.I(uVar.G()).K();
        this.f45020a = new j(aVarY.z(), aVarY.x());
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f45020a = new j((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
        this.f45021b = new m();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f45020a.b());
        objectOutputStream.writeObject(this.f45020a.a());
    }

    @Override // er.d
    public j b() {
        return this.f45020a;
    }

    @Override // er.g
    public h c(y yVar) {
        return this.f45021b.c(yVar);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHPrivateKey)) {
            return false;
        }
        DHPrivateKey dHPrivateKey = (DHPrivateKey) obj;
        return getX().equals(dHPrivateKey.getX()) && getParams().getG().equals(dHPrivateKey.getParams().getG()) && getParams().getP().equals(dHPrivateKey.getParams().getP()) && getParams().getL() == dHPrivateKey.getParams().getL();
    }

    @Override // er.g
    public Enumeration f() {
        return this.f45021b.f();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "ElGamal";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new u(new b(on.b.f44368l, new a(this.f45020a.b(), this.f45020a.a())), new t(getX())).v(gm.j.f29713a);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return new DHParameterSpec(this.f45020a.b(), this.f45020a.a());
    }

    @Override // org.bouncycastle.jce.interfaces.ElGamalPrivateKey, javax.crypto.interfaces.DHPrivateKey
    public BigInteger getX() {
        return this.f45022x;
    }

    @Override // er.g
    public void h(y yVar, h hVar) {
        this.f45021b.h(yVar, hVar);
    }

    public int hashCode() {
        return ((getX().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getL();
    }
}
