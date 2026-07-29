package org.bouncycastle.jcajce.provider.asymmetric.ecgost;

import er.g;
import gm.c0;
import gm.d;
import gm.h;
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
import org.bouncycastle.jcajce.provider.asymmetric.util.i;
import org.bouncycastle.jcajce.provider.asymmetric.util.m;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import pn.u;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class BCECGOST3410PrivateKey implements ECPrivateKey, org.bouncycastle.jce.interfaces.ECPrivateKey, g, er.c {
    public static final long serialVersionUID = 7245981689601667138L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient h f44966a;
    private String algorithm;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient BigInteger f44967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient ECParameterSpec f44968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient d f44969d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient m f44970e;
    private boolean withCompression;

    public BCECGOST3410PrivateKey() {
        this.algorithm = "ECGOST3410";
        this.f44970e = new m();
    }

    public BCECGOST3410PrivateKey(f fVar) {
        this.algorithm = "ECGOST3410";
        this.f44970e = new m();
        this.f44967b = fVar.b();
        this.f44968c = fVar.a() != null ? org.bouncycastle.jcajce.provider.asymmetric.util.h.h(org.bouncycastle.jcajce.provider.asymmetric.util.h.b(fVar.a().a(), fVar.a().e()), fVar.a()) : null;
    }

    public BCECGOST3410PrivateKey(String str, l0 l0Var) {
        this.algorithm = "ECGOST3410";
        this.f44970e = new m();
        this.algorithm = str;
        this.f44967b = l0Var.e();
        this.f44968c = null;
    }

    public BCECGOST3410PrivateKey(String str, l0 l0Var, BCECGOST3410PublicKey bCECGOST3410PublicKey, e eVar) {
        this.algorithm = "ECGOST3410";
        this.f44970e = new m();
        this.algorithm = str;
        this.f44967b = l0Var.e();
        if (eVar == null) {
            g0 g0VarD = l0Var.d();
            this.f44968c = new ECParameterSpec(org.bouncycastle.jcajce.provider.asymmetric.util.h.b(g0VarD.a(), g0VarD.f()), org.bouncycastle.jcajce.provider.asymmetric.util.h.f(g0VarD.b()), g0VarD.e(), g0VarD.c().intValue());
        } else {
            this.f44968c = new ECParameterSpec(org.bouncycastle.jcajce.provider.asymmetric.util.h.b(eVar.a(), eVar.e()), org.bouncycastle.jcajce.provider.asymmetric.util.h.f(eVar.b()), eVar.d(), eVar.c().intValue());
        }
        this.f44966a = bCECGOST3410PublicKey.i();
        this.f44969d = k(bCECGOST3410PublicKey);
    }

    public BCECGOST3410PrivateKey(String str, l0 l0Var, BCECGOST3410PublicKey bCECGOST3410PublicKey, ECParameterSpec eCParameterSpec) {
        this.algorithm = "ECGOST3410";
        this.f44970e = new m();
        this.algorithm = str;
        this.f44967b = l0Var.e();
        if (eCParameterSpec == null) {
            g0 g0VarD = l0Var.d();
            eCParameterSpec = new ECParameterSpec(org.bouncycastle.jcajce.provider.asymmetric.util.h.b(g0VarD.a(), g0VarD.f()), org.bouncycastle.jcajce.provider.asymmetric.util.h.f(g0VarD.b()), g0VarD.e(), g0VarD.c().intValue());
        }
        this.f44968c = eCParameterSpec;
        this.f44966a = bCECGOST3410PublicKey.i();
        this.f44969d = k(bCECGOST3410PublicKey);
    }

    public BCECGOST3410PrivateKey(ECPrivateKey eCPrivateKey) {
        this.algorithm = "ECGOST3410";
        this.f44970e = new m();
        this.f44967b = eCPrivateKey.getS();
        this.algorithm = eCPrivateKey.getAlgorithm();
        this.f44968c = eCPrivateKey.getParams();
    }

    public BCECGOST3410PrivateKey(ECPrivateKeySpec eCPrivateKeySpec) {
        this.algorithm = "ECGOST3410";
        this.f44970e = new m();
        this.f44967b = eCPrivateKeySpec.getS();
        this.f44968c = eCPrivateKeySpec.getParams();
    }

    public BCECGOST3410PrivateKey(BCECGOST3410PrivateKey bCECGOST3410PrivateKey) {
        this.algorithm = "ECGOST3410";
        this.f44970e = new m();
        this.f44967b = bCECGOST3410PrivateKey.f44967b;
        this.f44968c = bCECGOST3410PrivateKey.f44968c;
        this.withCompression = bCECGOST3410PrivateKey.withCompression;
        this.f44970e = bCECGOST3410PrivateKey.f44970e;
        this.f44969d = bCECGOST3410PrivateKey.f44969d;
        this.f44966a = bCECGOST3410PrivateKey.f44966a;
    }

    public BCECGOST3410PrivateKey(u uVar) throws IOException {
        this.algorithm = "ECGOST3410";
        this.f44970e = new m();
        l(uVar);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        l(u.z(c0.D((byte[]) objectInputStream.readObject())));
        this.f44970e = new m();
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
        ECParameterSpec eCParameterSpec = this.f44968c;
        if (eCParameterSpec == null) {
            return null;
        }
        return org.bouncycastle.jcajce.provider.asymmetric.util.h.g(eCParameterSpec);
    }

    @Override // er.g
    public h c(y yVar) {
        return this.f44970e.c(yVar);
    }

    public e d() {
        ECParameterSpec eCParameterSpec = this.f44968c;
        return eCParameterSpec != null ? org.bouncycastle.jcajce.provider.asymmetric.util.h.g(eCParameterSpec) : BouncyCastleProvider.f45330c.b();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCECGOST3410PrivateKey)) {
            return false;
        }
        BCECGOST3410PrivateKey bCECGOST3410PrivateKey = (BCECGOST3410PrivateKey) obj;
        return f0().equals(bCECGOST3410PrivateKey.f0()) && d().equals(bCECGOST3410PrivateKey.d());
    }

    @Override // er.g
    public Enumeration f() {
        return this.f44970e.f();
    }

    @Override // org.bouncycastle.jce.interfaces.ECPrivateKey
    public BigInteger f0() {
        return this.f44967b;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c4  */
    @Override // java.security.Key
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] getEncoded() {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jcajce.provider.asymmetric.ecgost.BCECGOST3410PrivateKey.getEncoded():byte[]");
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.f44968c;
    }

    @Override // java.security.interfaces.ECPrivateKey
    public BigInteger getS() {
        return this.f44967b;
    }

    @Override // er.g
    public void h(y yVar, h hVar) {
        this.f44970e.h(yVar, hVar);
    }

    public int hashCode() {
        return f0().hashCode() ^ d().hashCode();
    }

    public final void i(byte[] bArr, int i10, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length < 32) {
            byte[] bArr2 = new byte[32];
            System.arraycopy(byteArray, 0, bArr2, 32 - byteArray.length, byteArray.length);
            byteArray = bArr2;
        }
        for (int i11 = 0; i11 != 32; i11++) {
            bArr[i10 + i11] = byteArray[(byteArray.length - 1) - i11];
        }
    }

    public final d k(BCECGOST3410PublicKey bCECGOST3410PublicKey) {
        try {
            return c1.A(c0.D(bCECGOST3410PublicKey.getEncoded())).C();
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(pn.u r11) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jcajce.provider.asymmetric.ecgost.BCECGOST3410PrivateKey.l(pn.u):void");
    }

    public String toString() {
        return i.o(this.algorithm, this.f44967b, d());
    }
}
