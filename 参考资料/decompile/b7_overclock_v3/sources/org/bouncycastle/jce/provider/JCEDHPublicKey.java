package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class JCEDHPublicKey implements DHPublicKey {
    public static final long serialVersionUID = -216691575254424324L;
    private DHParameterSpec dhSpec;
    private c1 info;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private BigInteger f45348y;

    public JCEDHPublicKey(BigInteger bigInteger, DHParameterSpec dHParameterSpec) {
        this.f45348y = bigInteger;
        this.dhSpec = dHParameterSpec;
    }

    public JCEDHPublicKey(DHPublicKey dHPublicKey) {
        this.f45348y = dHPublicKey.getY();
        this.dhSpec = dHPublicKey.getParams();
    }

    public JCEDHPublicKey(DHPublicKeySpec dHPublicKeySpec) {
        this.f45348y = dHPublicKeySpec.getY();
        this.dhSpec = new DHParameterSpec(dHPublicKeySpec.getP(), dHPublicKeySpec.getG());
    }

    public JCEDHPublicKey(np.s sVar) {
        this.f45348y = sVar.e();
        this.dhSpec = new DHParameterSpec(sVar.d().f(), sVar.d().b(), sVar.d().d());
    }

    public JCEDHPublicKey(c1 c1Var) {
        DHParameterSpec dHParameterSpec;
        this.info = c1Var;
        try {
            this.f45348y = ((gm.t) c1Var.D()).K();
            gm.f0 f0VarJ = gm.f0.J(c1Var.y().A());
            gm.y yVarX = c1Var.y().x();
            if (yVarX.C(pn.s.O3) || a(f0VarJ)) {
                pn.h hVarY = pn.h.y(f0VarJ);
                dHParameterSpec = hVarY.z() != null ? new DHParameterSpec(hVarY.A(), hVarY.x(), hVarY.z().intValue()) : new DHParameterSpec(hVarY.A(), hVarY.x());
            } else {
                if (!yVarX.C(co.r.f11161d1)) {
                    throw new IllegalArgumentException("unknown algorithm type: " + yVarX);
                }
                co.a aVarZ = co.a.z(f0VarJ);
                dHParameterSpec = new DHParameterSpec(aVarZ.C().K(), aVarZ.x().K());
            }
            this.dhSpec = dHParameterSpec;
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DH public key");
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.f45348y = (BigInteger) objectInputStream.readObject();
        this.dhSpec = new DHParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), objectInputStream.readInt());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getY());
        objectOutputStream.writeObject(this.dhSpec.getP());
        objectOutputStream.writeObject(this.dhSpec.getG());
        objectOutputStream.writeInt(this.dhSpec.getL());
    }

    public final boolean a(gm.f0 f0Var) {
        if (f0Var.size() == 2) {
            return true;
        }
        if (f0Var.size() > 3) {
            return false;
        }
        return gm.t.I(f0Var.K(2)).K().compareTo(BigInteger.valueOf((long) gm.t.I(f0Var.K(0)).K().bitLength())) <= 0;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DH";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        c1 c1Var = this.info;
        return c1Var != null ? org.bouncycastle.jcajce.provider.asymmetric.util.l.e(c1Var) : org.bouncycastle.jcajce.provider.asymmetric.util.l.c(new zn.b(pn.s.O3, new pn.h(this.dhSpec.getP(), this.dhSpec.getG(), this.dhSpec.getL())), new gm.t(this.f45348y));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return this.dhSpec;
    }

    @Override // javax.crypto.interfaces.DHPublicKey
    public BigInteger getY() {
        return this.f45348y;
    }
}
