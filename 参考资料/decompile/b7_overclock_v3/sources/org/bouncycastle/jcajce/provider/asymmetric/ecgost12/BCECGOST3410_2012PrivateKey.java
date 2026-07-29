package org.bouncycastle.jcajce.provider.asymmetric.ecgost12;

import er.g;
import gm.c0;
import gm.y;
import gr.e;
import gr.f;
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
import org.bouncycastle.jcajce.provider.asymmetric.util.h;
import org.bouncycastle.jcajce.provider.asymmetric.util.i;
import org.bouncycastle.jcajce.provider.asymmetric.util.m;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import pn.u;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class BCECGOST3410_2012PrivateKey implements ECPrivateKey, org.bouncycastle.jce.interfaces.ECPrivateKey, g, er.c {
    public static final long serialVersionUID = 7245981689601667138L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient qm.g f44988a;
    private String algorithm;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient BigInteger f44989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient ECParameterSpec f44990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient gm.d f44991d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient m f44992e;
    private boolean withCompression;

    public BCECGOST3410_2012PrivateKey() {
        this.algorithm = "ECGOST3410-2012";
        this.f44992e = new m();
    }

    public BCECGOST3410_2012PrivateKey(f fVar) {
        this.algorithm = "ECGOST3410-2012";
        this.f44992e = new m();
        this.f44989b = fVar.b();
        this.f44990c = fVar.a() != null ? h.h(h.b(fVar.a().a(), fVar.a().e()), fVar.a()) : null;
    }

    public BCECGOST3410_2012PrivateKey(String str, l0 l0Var) {
        this.algorithm = "ECGOST3410-2012";
        this.f44992e = new m();
        this.algorithm = str;
        this.f44989b = l0Var.e();
        this.f44990c = null;
    }

    public BCECGOST3410_2012PrivateKey(String str, l0 l0Var, BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey, e eVar) {
        this.algorithm = "ECGOST3410-2012";
        this.f44992e = new m();
        g0 g0VarD = l0Var.d();
        this.algorithm = str;
        this.f44989b = l0Var.e();
        this.f44990c = eVar == null ? new ECParameterSpec(h.b(g0VarD.a(), g0VarD.f()), h.f(g0VarD.b()), g0VarD.e(), g0VarD.c().intValue()) : new ECParameterSpec(h.b(eVar.a(), eVar.e()), h.f(eVar.b()), eVar.d(), eVar.c().intValue());
        this.f44988a = bCECGOST3410_2012PublicKey.i();
        this.f44991d = k(bCECGOST3410_2012PublicKey);
    }

    public BCECGOST3410_2012PrivateKey(String str, l0 l0Var, BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey, ECParameterSpec eCParameterSpec) {
        this.algorithm = "ECGOST3410-2012";
        this.f44992e = new m();
        g0 g0VarD = l0Var.d();
        this.algorithm = str;
        this.f44989b = l0Var.e();
        if (eCParameterSpec == null) {
            this.f44990c = new ECParameterSpec(h.b(g0VarD.a(), g0VarD.f()), h.f(g0VarD.b()), g0VarD.e(), g0VarD.c().intValue());
        } else {
            this.f44990c = eCParameterSpec;
        }
        this.f44988a = bCECGOST3410_2012PublicKey.i();
        this.f44991d = k(bCECGOST3410_2012PublicKey);
    }

    public BCECGOST3410_2012PrivateKey(ECPrivateKey eCPrivateKey) {
        this.algorithm = "ECGOST3410-2012";
        this.f44992e = new m();
        this.f44989b = eCPrivateKey.getS();
        this.algorithm = eCPrivateKey.getAlgorithm();
        this.f44990c = eCPrivateKey.getParams();
    }

    public BCECGOST3410_2012PrivateKey(ECPrivateKeySpec eCPrivateKeySpec) {
        this.algorithm = "ECGOST3410-2012";
        this.f44992e = new m();
        this.f44989b = eCPrivateKeySpec.getS();
        this.f44990c = eCPrivateKeySpec.getParams();
    }

    public BCECGOST3410_2012PrivateKey(BCECGOST3410_2012PrivateKey bCECGOST3410_2012PrivateKey) {
        this.algorithm = "ECGOST3410-2012";
        this.f44992e = new m();
        this.f44989b = bCECGOST3410_2012PrivateKey.f44989b;
        this.f44990c = bCECGOST3410_2012PrivateKey.f44990c;
        this.withCompression = bCECGOST3410_2012PrivateKey.withCompression;
        this.f44992e = bCECGOST3410_2012PrivateKey.f44992e;
        this.f44991d = bCECGOST3410_2012PrivateKey.f44991d;
        this.f44988a = bCECGOST3410_2012PrivateKey.f44988a;
    }

    public BCECGOST3410_2012PrivateKey(u uVar) throws IOException {
        this.algorithm = "ECGOST3410-2012";
        this.f44992e = new m();
        l(uVar);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        l(u.z(c0.D((byte[]) objectInputStream.readObject())));
        this.f44992e = new m();
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
    public e b() {
        ECParameterSpec eCParameterSpec = this.f44990c;
        if (eCParameterSpec == null) {
            return null;
        }
        return h.g(eCParameterSpec);
    }

    @Override // er.g
    public gm.h c(y yVar) {
        return this.f44992e.c(yVar);
    }

    public e d() {
        ECParameterSpec eCParameterSpec = this.f44990c;
        return eCParameterSpec != null ? h.g(eCParameterSpec) : BouncyCastleProvider.f45330c.b();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCECGOST3410_2012PrivateKey)) {
            return false;
        }
        BCECGOST3410_2012PrivateKey bCECGOST3410_2012PrivateKey = (BCECGOST3410_2012PrivateKey) obj;
        return f0().equals(bCECGOST3410_2012PrivateKey.f0()) && d().equals(bCECGOST3410_2012PrivateKey.d());
    }

    @Override // er.g
    public Enumeration f() {
        return this.f44992e.f();
    }

    @Override // org.bouncycastle.jce.interfaces.ECPrivateKey
    public BigInteger f0() {
        return this.f44989b;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00db  */
    @Override // java.security.Key
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] getEncoded() {
        /*
            Method dump skipped, instruction units count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jcajce.provider.asymmetric.ecgost12.BCECGOST3410_2012PrivateKey.getEncoded():byte[]");
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.f44990c;
    }

    @Override // java.security.interfaces.ECPrivateKey
    public BigInteger getS() {
        return this.f44989b;
    }

    @Override // er.g
    public void h(y yVar, gm.h hVar) {
        this.f44992e.h(yVar, hVar);
    }

    public int hashCode() {
        return f0().hashCode() ^ d().hashCode();
    }

    public final void i(byte[] bArr, int i10, int i11, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length < i10) {
            byte[] bArr2 = new byte[i10];
            System.arraycopy(byteArray, 0, bArr2, i10 - byteArray.length, byteArray.length);
            byteArray = bArr2;
        }
        for (int i12 = 0; i12 != i10; i12++) {
            bArr[i11 + i12] = byteArray[(byteArray.length - 1) - i12];
        }
    }

    public final gm.d k(BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey) {
        return c1.A(bCECGOST3410_2012PublicKey.getEncoded()).C();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x017a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(pn.u r11) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 395
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jcajce.provider.asymmetric.ecgost12.BCECGOST3410_2012PrivateKey.l(pn.u):void");
    }

    public String toString() {
        return i.o(this.algorithm, this.f44989b, d());
    }
}
