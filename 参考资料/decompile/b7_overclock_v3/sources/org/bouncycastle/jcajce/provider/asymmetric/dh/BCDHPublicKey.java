package org.bouncycastle.jcajce.provider.asymmetric.dh;

import co.d;
import co.r;
import cr.c;
import cr.e;
import gm.f0;
import gm.t;
import gm.y;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import np.q;
import np.s;
import np.v;
import org.bouncycastle.jcajce.provider.asymmetric.util.l;
import pn.h;
import zn.b;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class BCDHPublicKey implements DHPublicKey {
    public static final long serialVersionUID = -216691575254424324L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient s f44881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient DHParameterSpec f44882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient c1 f44883c;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private BigInteger f44884y;

    public BCDHPublicKey(BigInteger bigInteger, DHParameterSpec dHParameterSpec) {
        this.f44884y = bigInteger;
        this.f44882b = dHParameterSpec;
        this.f44881a = dHParameterSpec instanceof c ? new s(bigInteger, ((c) dHParameterSpec).a()) : new s(bigInteger, new q(dHParameterSpec.getP(), dHParameterSpec.getG()));
    }

    public BCDHPublicKey(DHPublicKey dHPublicKey) {
        this.f44884y = dHPublicKey.getY();
        DHParameterSpec params = dHPublicKey.getParams();
        this.f44882b = params;
        if (params instanceof c) {
            this.f44881a = new s(this.f44884y, ((c) params).a());
        } else {
            this.f44881a = new s(this.f44884y, new q(this.f44882b.getP(), this.f44882b.getG()));
        }
    }

    public BCDHPublicKey(DHPublicKeySpec dHPublicKeySpec) {
        this.f44884y = dHPublicKeySpec.getY();
        this.f44882b = dHPublicKeySpec instanceof e ? ((e) dHPublicKeySpec).a() : new DHParameterSpec(dHPublicKeySpec.getP(), dHPublicKeySpec.getG());
        DHParameterSpec dHParameterSpec = this.f44882b;
        if (dHParameterSpec instanceof c) {
            this.f44881a = new s(this.f44884y, ((c) dHParameterSpec).a());
        } else {
            this.f44881a = new s(this.f44884y, new q(dHPublicKeySpec.getP(), dHPublicKeySpec.getG()));
        }
    }

    public BCDHPublicKey(s sVar) {
        this.f44884y = sVar.e();
        this.f44882b = new c(sVar.d());
        this.f44881a = sVar;
    }

    public BCDHPublicKey(c1 c1Var) {
        s sVar;
        this.f44883c = c1Var;
        try {
            this.f44884y = ((t) c1Var.D()).K();
            f0 f0VarJ = f0.J(c1Var.x().A());
            y yVarX = c1Var.x().x();
            if (yVarX.C(pn.s.O3) || c(f0VarJ)) {
                h hVarY = h.y(f0VarJ);
                if (hVarY.z() != null) {
                    this.f44882b = new DHParameterSpec(hVarY.A(), hVarY.x(), hVarY.z().intValue());
                    sVar = new s(this.f44884y, new q(this.f44882b.getP(), this.f44882b.getG(), null, this.f44882b.getL()));
                } else {
                    this.f44882b = new DHParameterSpec(hVarY.A(), hVarY.x());
                    sVar = new s(this.f44884y, new q(this.f44882b.getP(), this.f44882b.getG()));
                }
                this.f44881a = sVar;
                return;
            }
            if (!yVarX.C(r.f11161d1)) {
                throw new IllegalArgumentException("unknown algorithm type: " + yVarX);
            }
            d dVarZ = d.z(f0VarJ);
            co.h hVarE = dVarZ.E();
            if (hVarE != null) {
                this.f44881a = new s(this.f44884y, new q(dVarZ.C(), dVarZ.x(), dVarZ.D(), dVarZ.A(), new v(hVarE.A(), hVarE.z().intValue())));
            } else {
                this.f44881a = new s(this.f44884y, new q(dVarZ.C(), dVarZ.x(), dVarZ.D(), dVarZ.A(), (v) null));
            }
            this.f44882b = new c(this.f44881a.d());
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DH public key");
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f44882b = new DHParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), objectInputStream.readInt());
        this.f44883c = null;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f44882b.getP());
        objectOutputStream.writeObject(this.f44882b.getG());
        objectOutputStream.writeInt(this.f44882b.getL());
    }

    public s a() {
        return this.f44881a;
    }

    public final boolean c(f0 f0Var) {
        if (f0Var.size() == 2) {
            return true;
        }
        if (f0Var.size() > 3) {
            return false;
        }
        return t.I(f0Var.K(2)).K().compareTo(BigInteger.valueOf((long) t.I(f0Var.K(0)).K().bitLength())) <= 0;
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
        return "DH";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        c1 c1Var = this.f44883c;
        if (c1Var != null) {
            return l.e(c1Var);
        }
        DHParameterSpec dHParameterSpec = this.f44882b;
        if (!(dHParameterSpec instanceof c) || ((c) dHParameterSpec).d() == null) {
            return l.c(new b(pn.s.O3, new h(this.f44882b.getP(), this.f44882b.getG(), this.f44882b.getL()).b()), new t(this.f44884y));
        }
        q qVarA = ((c) this.f44882b).a();
        v vVarH = qVarA.h();
        return l.c(new b(r.f11161d1, new d(qVarA.f(), qVarA.b(), qVarA.g(), qVarA.c(), vVarH != null ? new co.h(vVarH.b(), vVarH.a()) : null).b()), new t(this.f44884y));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return this.f44882b;
    }

    @Override // javax.crypto.interfaces.DHPublicKey
    public BigInteger getY() {
        return this.f44884y;
    }

    public int hashCode() {
        return ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getL();
    }

    public String toString() {
        return nq.c.c("DH", this.f44884y, new q(this.f44882b.getP(), this.f44882b.getG()));
    }
}
