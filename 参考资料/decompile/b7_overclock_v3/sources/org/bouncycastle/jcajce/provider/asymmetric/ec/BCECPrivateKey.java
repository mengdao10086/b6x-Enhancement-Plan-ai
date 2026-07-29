package org.bouncycastle.jcajce.provider.asymmetric.ec;

import co.j;
import co.r;
import gm.c0;
import gm.t;
import gm.y;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPrivateKeySpec;
import java.util.Enumeration;
import np.g0;
import np.l0;
import org.bouncycastle.jcajce.provider.asymmetric.util.i;
import org.bouncycastle.jcajce.provider.asymmetric.util.m;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import pn.u;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class BCECPrivateKey implements ECPrivateKey, org.bouncycastle.jce.interfaces.ECPrivateKey, er.g, er.c {
    public static final long serialVersionUID = 994553197664784084L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient BigInteger f44915a;
    private String algorithm;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient ECParameterSpec f44916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient uq.c f44917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient gm.d f44918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient m f44919e;
    private boolean withCompression;

    public BCECPrivateKey() {
        this.algorithm = "EC";
        this.f44919e = new m();
    }

    public BCECPrivateKey(String str, gr.f fVar, uq.c cVar) {
        this.algorithm = "EC";
        this.f44919e = new m();
        this.algorithm = str;
        this.f44915a = fVar.b();
        this.f44916b = fVar.a() != null ? org.bouncycastle.jcajce.provider.asymmetric.util.h.h(org.bouncycastle.jcajce.provider.asymmetric.util.h.b(fVar.a().a(), fVar.a().e()), fVar.a()) : null;
        this.f44917c = cVar;
    }

    public BCECPrivateKey(String str, ECPrivateKeySpec eCPrivateKeySpec, uq.c cVar) {
        this.algorithm = "EC";
        this.f44919e = new m();
        this.algorithm = str;
        this.f44915a = eCPrivateKeySpec.getS();
        this.f44916b = eCPrivateKeySpec.getParams();
        this.f44917c = cVar;
    }

    public BCECPrivateKey(String str, l0 l0Var, BCECPublicKey bCECPublicKey, gr.e eVar, uq.c cVar) {
        this.algorithm = "EC";
        this.f44919e = new m();
        this.algorithm = str;
        this.f44915a = l0Var.e();
        this.f44917c = cVar;
        if (eVar == null) {
            g0 g0VarD = l0Var.d();
            this.f44916b = new ECParameterSpec(org.bouncycastle.jcajce.provider.asymmetric.util.h.b(g0VarD.a(), g0VarD.f()), org.bouncycastle.jcajce.provider.asymmetric.util.h.f(g0VarD.b()), g0VarD.e(), g0VarD.c().intValue());
        } else {
            this.f44916b = org.bouncycastle.jcajce.provider.asymmetric.util.h.h(org.bouncycastle.jcajce.provider.asymmetric.util.h.b(eVar.a(), eVar.e()), eVar);
        }
        try {
            this.f44918d = i(bCECPublicKey);
        } catch (Exception unused) {
            this.f44918d = null;
        }
    }

    public BCECPrivateKey(String str, l0 l0Var, BCECPublicKey bCECPublicKey, ECParameterSpec eCParameterSpec, uq.c cVar) {
        this.algorithm = "EC";
        this.f44919e = new m();
        this.algorithm = str;
        this.f44915a = l0Var.e();
        this.f44917c = cVar;
        if (eCParameterSpec == null) {
            g0 g0VarD = l0Var.d();
            eCParameterSpec = new ECParameterSpec(org.bouncycastle.jcajce.provider.asymmetric.util.h.b(g0VarD.a(), g0VarD.f()), org.bouncycastle.jcajce.provider.asymmetric.util.h.f(g0VarD.b()), g0VarD.e(), g0VarD.c().intValue());
        }
        this.f44916b = eCParameterSpec;
        this.f44918d = i(bCECPublicKey);
    }

    public BCECPrivateKey(String str, l0 l0Var, uq.c cVar) {
        this.algorithm = "EC";
        this.f44919e = new m();
        this.algorithm = str;
        this.f44915a = l0Var.e();
        this.f44916b = null;
        this.f44917c = cVar;
    }

    public BCECPrivateKey(String str, BCECPrivateKey bCECPrivateKey) {
        this.algorithm = "EC";
        this.f44919e = new m();
        this.algorithm = str;
        this.f44915a = bCECPrivateKey.f44915a;
        this.f44916b = bCECPrivateKey.f44916b;
        this.withCompression = bCECPrivateKey.withCompression;
        this.f44919e = bCECPrivateKey.f44919e;
        this.f44918d = bCECPrivateKey.f44918d;
        this.f44917c = bCECPrivateKey.f44917c;
    }

    public BCECPrivateKey(String str, u uVar, uq.c cVar) throws IOException {
        this.algorithm = "EC";
        this.f44919e = new m();
        this.algorithm = str;
        this.f44917c = cVar;
        k(uVar);
    }

    public BCECPrivateKey(ECPrivateKey eCPrivateKey, uq.c cVar) {
        this.algorithm = "EC";
        this.f44919e = new m();
        this.f44915a = eCPrivateKey.getS();
        this.algorithm = eCPrivateKey.getAlgorithm();
        this.f44916b = eCPrivateKey.getParams();
        this.f44917c = cVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        byte[] bArr = (byte[]) objectInputStream.readObject();
        this.f44917c = BouncyCastleProvider.f45330c;
        k(u.z(c0.D(bArr)));
        this.f44919e = new m();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    @Override // er.c
    public void a(String str) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    @Override // er.b
    public gr.e b() {
        ECParameterSpec eCParameterSpec = this.f44916b;
        if (eCParameterSpec == null) {
            return null;
        }
        return org.bouncycastle.jcajce.provider.asymmetric.util.h.g(eCParameterSpec);
    }

    @Override // er.g
    public gm.h c(y yVar) {
        return this.f44919e.c(yVar);
    }

    public gr.e d() {
        ECParameterSpec eCParameterSpec = this.f44916b;
        return eCParameterSpec != null ? org.bouncycastle.jcajce.provider.asymmetric.util.h.g(eCParameterSpec) : this.f44917c.b();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCECPrivateKey)) {
            return false;
        }
        BCECPrivateKey bCECPrivateKey = (BCECPrivateKey) obj;
        return f0().equals(bCECPrivateKey.f0()) && d().equals(bCECPrivateKey.d());
    }

    @Override // er.g
    public Enumeration f() {
        return this.f44919e.f();
    }

    @Override // org.bouncycastle.jce.interfaces.ECPrivateKey
    public BigInteger f0() {
        return this.f44915a;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        j jVarC = b.c(this.f44916b, this.withCompression);
        ECParameterSpec eCParameterSpec = this.f44916b;
        int iN = eCParameterSpec == null ? i.n(this.f44917c, null, getS()) : i.n(this.f44917c, eCParameterSpec.getOrder(), getS());
        try {
            return new u(new zn.b(r.f11174l0, jVarC), this.f44918d != null ? new rn.a(iN, getS(), this.f44918d, jVarC) : new rn.a(iN, getS(), jVarC)).v(gm.j.f29713a);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.f44916b;
    }

    @Override // java.security.interfaces.ECPrivateKey
    public BigInteger getS() {
        return this.f44915a;
    }

    @Override // er.g
    public void h(y yVar, gm.h hVar) {
        this.f44919e.h(yVar, hVar);
    }

    public int hashCode() {
        return f0().hashCode() ^ d().hashCode();
    }

    public final gm.d i(BCECPublicKey bCECPublicKey) {
        try {
            return c1.A(c0.D(bCECPublicKey.getEncoded())).C();
        } catch (IOException unused) {
            return null;
        }
    }

    public final void k(u uVar) throws IOException {
        j jVarY = j.y(uVar.B().A());
        this.f44916b = org.bouncycastle.jcajce.provider.asymmetric.util.h.i(jVarY, org.bouncycastle.jcajce.provider.asymmetric.util.h.l(this.f44917c, jVarY));
        gm.h hVarG = uVar.G();
        if (hVarG instanceof t) {
            this.f44915a = t.I(hVarG).K();
            return;
        }
        rn.a aVarX = rn.a.x(hVarG);
        this.f44915a = aVarX.y();
        this.f44918d = aVarX.C();
    }

    public String toString() {
        return i.o("EC", this.f44915a, d());
    }
}
