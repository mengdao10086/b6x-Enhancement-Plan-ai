package org.bouncycastle.jcajce.provider.asymmetric.ec;

import co.j;
import co.n;
import co.q;
import co.r;
import gm.c0;
import gm.f2;
import gm.z;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import np.g0;
import np.m0;
import org.bouncycastle.jcajce.provider.asymmetric.util.i;
import org.bouncycastle.jcajce.provider.asymmetric.util.l;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.p;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class BCECPublicKey implements ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey, er.c {
    public static final long serialVersionUID = 2422789860422731812L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient m0 f44920a;
    private String algorithm;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient ECParameterSpec f44921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient uq.c f44922c;
    private boolean withCompression;

    public BCECPublicKey(String str, gr.g gVar, uq.c cVar) {
        this.algorithm = str;
        if (gVar.a() != null) {
            EllipticCurve ellipticCurveB = org.bouncycastle.jcajce.provider.asymmetric.util.h.b(gVar.a().a(), gVar.a().e());
            this.f44920a = new m0(gVar.b(), i.g(cVar, gVar.a()));
            this.f44921b = org.bouncycastle.jcajce.provider.asymmetric.util.h.h(ellipticCurveB, gVar.a());
        } else {
            this.f44920a = new m0(cVar.b().a().h(gVar.b().f().v(), gVar.b().g().v()), org.bouncycastle.jcajce.provider.asymmetric.util.h.m(cVar, null));
            this.f44921b = null;
        }
        this.f44922c = cVar;
    }

    public BCECPublicKey(String str, ECPublicKeySpec eCPublicKeySpec, uq.c cVar) {
        this.algorithm = str;
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.f44921b = params;
        this.f44920a = new m0(org.bouncycastle.jcajce.provider.asymmetric.util.h.e(params, eCPublicKeySpec.getW()), org.bouncycastle.jcajce.provider.asymmetric.util.h.m(cVar, eCPublicKeySpec.getParams()));
        this.f44922c = cVar;
    }

    public BCECPublicKey(String str, m0 m0Var, gr.e eVar, uq.c cVar) {
        this.algorithm = "EC";
        g0 g0VarD = m0Var.d();
        this.algorithm = str;
        this.f44921b = eVar == null ? c(org.bouncycastle.jcajce.provider.asymmetric.util.h.b(g0VarD.a(), g0VarD.f()), g0VarD) : org.bouncycastle.jcajce.provider.asymmetric.util.h.h(org.bouncycastle.jcajce.provider.asymmetric.util.h.b(eVar.a(), eVar.e()), eVar);
        this.f44920a = m0Var;
        this.f44922c = cVar;
    }

    public BCECPublicKey(String str, m0 m0Var, ECParameterSpec eCParameterSpec, uq.c cVar) {
        this.algorithm = "EC";
        g0 g0VarD = m0Var.d();
        this.algorithm = str;
        this.f44920a = m0Var;
        if (eCParameterSpec == null) {
            this.f44921b = c(org.bouncycastle.jcajce.provider.asymmetric.util.h.b(g0VarD.a(), g0VarD.f()), g0VarD);
        } else {
            this.f44921b = eCParameterSpec;
        }
        this.f44922c = cVar;
    }

    public BCECPublicKey(String str, m0 m0Var, uq.c cVar) {
        this.algorithm = str;
        this.f44920a = m0Var;
        this.f44921b = null;
        this.f44922c = cVar;
    }

    public BCECPublicKey(String str, BCECPublicKey bCECPublicKey) {
        this.algorithm = str;
        this.f44920a = bCECPublicKey.f44920a;
        this.f44921b = bCECPublicKey.f44921b;
        this.withCompression = bCECPublicKey.withCompression;
        this.f44922c = bCECPublicKey.f44922c;
    }

    public BCECPublicKey(String str, c1 c1Var, uq.c cVar) {
        this.algorithm = str;
        this.f44922c = cVar;
        h(c1Var);
    }

    public BCECPublicKey(ECPublicKey eCPublicKey, uq.c cVar) {
        this.algorithm = "EC";
        this.algorithm = eCPublicKey.getAlgorithm();
        ECParameterSpec params = eCPublicKey.getParams();
        this.f44921b = params;
        this.f44920a = new m0(org.bouncycastle.jcajce.provider.asymmetric.util.h.e(params, eCPublicKey.getW()), org.bouncycastle.jcajce.provider.asymmetric.util.h.m(cVar, eCPublicKey.getParams()));
        this.f44922c = cVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        byte[] bArr = (byte[]) objectInputStream.readObject();
        this.f44922c = BouncyCastleProvider.f45330c;
        h(c1.A(c0.D(bArr)));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    @Override // org.bouncycastle.jce.interfaces.ECPublicKey
    public ir.i J0() {
        ir.i iVarE = this.f44920a.e();
        return this.f44921b == null ? iVarE.k() : iVarE;
    }

    @Override // er.c
    public void a(String str) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    @Override // er.b
    public gr.e b() {
        ECParameterSpec eCParameterSpec = this.f44921b;
        if (eCParameterSpec == null) {
            return null;
        }
        return org.bouncycastle.jcajce.provider.asymmetric.util.h.g(eCParameterSpec);
    }

    public final ECParameterSpec c(EllipticCurve ellipticCurve, g0 g0Var) {
        return new ECParameterSpec(ellipticCurve, org.bouncycastle.jcajce.provider.asymmetric.util.h.f(g0Var.b()), g0Var.e(), g0Var.c().intValue());
    }

    public m0 d() {
        return this.f44920a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCECPublicKey)) {
            return false;
        }
        BCECPublicKey bCECPublicKey = (BCECPublicKey) obj;
        return this.f44920a.e().e(bCECPublicKey.f44920a.e()) && f().equals(bCECPublicKey.f());
    }

    public gr.e f() {
        ECParameterSpec eCParameterSpec = this.f44921b;
        return eCParameterSpec != null ? org.bouncycastle.jcajce.provider.asymmetric.util.h.g(eCParameterSpec) : this.f44922c.b();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        boolean z10 = this.withCompression || p.d("org.bouncycastle.ec.enable_pc");
        return l.d(new zn.b(r.f11174l0, b.c(this.f44921b, z10)), this.f44920a.e().l(z10));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.f44921b;
    }

    @Override // java.security.interfaces.ECPublicKey
    public ECPoint getW() {
        return org.bouncycastle.jcajce.provider.asymmetric.util.h.f(this.f44920a.e());
    }

    public final void h(c1 c1Var) {
        j jVarY = j.y(c1Var.x().A());
        ir.e eVarL = org.bouncycastle.jcajce.provider.asymmetric.util.h.l(this.f44922c, jVarY);
        this.f44921b = org.bouncycastle.jcajce.provider.asymmetric.util.h.i(jVarY, eVarL);
        byte[] bArrH = c1Var.C().H();
        z f2Var = new f2(bArrH);
        if (bArrH[0] == 4 && bArrH[1] == bArrH.length - 2 && ((bArrH[2] == 2 || bArrH[2] == 3) && new q().a(eVarL) >= bArrH.length - 3)) {
            try {
                f2Var = (z) c0.D(bArrH);
            } catch (IOException unused) {
                throw new IllegalArgumentException("error recovering public key");
            }
        }
        this.f44920a = new m0(new n(eVarL, f2Var).x(), i.f(this.f44922c, jVarY));
    }

    public int hashCode() {
        return this.f44920a.e().hashCode() ^ f().hashCode();
    }

    public String toString() {
        return i.p("EC", this.f44920a.e(), f());
    }
}
