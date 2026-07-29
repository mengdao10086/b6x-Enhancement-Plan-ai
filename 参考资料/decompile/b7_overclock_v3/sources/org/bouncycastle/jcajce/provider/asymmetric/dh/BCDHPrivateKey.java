package org.bouncycastle.jcajce.provider.asymmetric.dh;

import cr.c;
import cr.d;
import er.g;
import gm.f0;
import gm.j;
import gm.t;
import gm.y;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;
import np.q;
import np.r;
import np.v;
import org.bouncycastle.jcajce.provider.asymmetric.util.m;
import pn.h;
import pn.s;
import pn.u;
import zn.b;

/* JADX INFO: loaded from: classes7.dex */
public class BCDHPrivateKey implements DHPrivateKey, g {
    public static final long serialVersionUID = 311058815616901812L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient DHParameterSpec f44876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient u f44877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient r f44878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient m f44879d = new m();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private BigInteger f44880x;

    public BCDHPrivateKey() {
    }

    public BCDHPrivateKey(DHPrivateKey dHPrivateKey) {
        this.f44880x = dHPrivateKey.getX();
        this.f44876a = dHPrivateKey.getParams();
    }

    public BCDHPrivateKey(DHPrivateKeySpec dHPrivateKeySpec) {
        this.f44880x = dHPrivateKeySpec.getX();
        if (dHPrivateKeySpec instanceof d) {
            this.f44876a = ((d) dHPrivateKeySpec).a();
        } else {
            this.f44876a = new DHParameterSpec(dHPrivateKeySpec.getP(), dHPrivateKeySpec.getG());
        }
    }

    public BCDHPrivateKey(r rVar) {
        this.f44880x = rVar.e();
        this.f44876a = new c(rVar.d());
    }

    public BCDHPrivateKey(u uVar) throws IOException {
        r rVar;
        f0 f0VarJ = f0.J(uVar.B().A());
        t tVar = (t) uVar.G();
        y yVarX = uVar.B().x();
        this.f44877b = uVar;
        this.f44880x = tVar.K();
        if (yVarX.C(s.O3)) {
            h hVarY = h.y(f0VarJ);
            if (hVarY.z() != null) {
                this.f44876a = new DHParameterSpec(hVarY.A(), hVarY.x(), hVarY.z().intValue());
                rVar = new r(this.f44880x, new q(hVarY.A(), hVarY.x(), null, hVarY.z().intValue()));
            } else {
                this.f44876a = new DHParameterSpec(hVarY.A(), hVarY.x());
                rVar = new r(this.f44880x, new q(hVarY.A(), hVarY.x()));
            }
        } else {
            if (!yVarX.C(co.r.f11161d1)) {
                throw new IllegalArgumentException("unknown algorithm type: " + yVarX);
            }
            co.d dVarZ = co.d.z(f0VarJ);
            this.f44876a = new c(dVarZ.C(), dVarZ.D(), dVarZ.x(), dVarZ.A(), 0);
            rVar = new r(this.f44880x, new q(dVarZ.C(), dVarZ.x(), dVarZ.D(), dVarZ.A(), (v) null));
        }
        this.f44878c = rVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f44876a = new DHParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), objectInputStream.readInt());
        this.f44877b = null;
        this.f44879d = new m();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f44876a.getP());
        objectOutputStream.writeObject(this.f44876a.getG());
        objectOutputStream.writeInt(this.f44876a.getL());
    }

    public r a() {
        r rVar = this.f44878c;
        if (rVar != null) {
            return rVar;
        }
        DHParameterSpec dHParameterSpec = this.f44876a;
        return dHParameterSpec instanceof c ? new r(this.f44880x, ((c) dHParameterSpec).a()) : new r(this.f44880x, new q(dHParameterSpec.getP(), this.f44876a.getG(), null, this.f44876a.getL()));
    }

    @Override // er.g
    public gm.h c(y yVar) {
        return this.f44879d.c(yVar);
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
        return this.f44879d.f();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DH";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        u uVar;
        try {
            u uVar2 = this.f44877b;
            if (uVar2 != null) {
                return uVar2.v(j.f29713a);
            }
            DHParameterSpec dHParameterSpec = this.f44876a;
            if (!(dHParameterSpec instanceof c) || ((c) dHParameterSpec).d() == null) {
                uVar = new u(new b(s.O3, new h(this.f44876a.getP(), this.f44876a.getG(), this.f44876a.getL()).b()), new t(getX()));
            } else {
                q qVarA = ((c) this.f44876a).a();
                v vVarH = qVarA.h();
                uVar = new u(new b(co.r.f11161d1, new co.d(qVarA.f(), qVarA.b(), qVarA.g(), qVarA.c(), vVarH != null ? new co.h(vVarH.b(), vVarH.a()) : null).b()), new t(getX()));
            }
            return uVar.v(j.f29713a);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return this.f44876a;
    }

    @Override // javax.crypto.interfaces.DHPrivateKey
    public BigInteger getX() {
        return this.f44880x;
    }

    @Override // er.g
    public void h(y yVar, gm.h hVar) {
        this.f44879d.h(yVar, hVar);
    }

    public int hashCode() {
        return ((getX().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getL();
    }

    public String toString() {
        return nq.c.b("DH", this.f44880x, new q(this.f44876a.getP(), this.f44876a.getG()));
    }
}
