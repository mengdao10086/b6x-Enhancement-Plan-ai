package org.bouncycastle.jcajce.provider.asymmetric.dstu;

import er.c;
import er.g;
import gm.c0;
import gm.d;
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
public class BCDSTU4145PrivateKey implements ECPrivateKey, org.bouncycastle.jce.interfaces.ECPrivateKey, g, c {
    public static final long serialVersionUID = 7245981689601667138L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient BigInteger f44908a;
    private String algorithm;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient ECParameterSpec f44909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient d f44910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient m f44911d;
    private boolean withCompression;

    public BCDSTU4145PrivateKey() {
        this.algorithm = "DSTU4145";
        this.f44911d = new m();
    }

    public BCDSTU4145PrivateKey(f fVar) {
        this.algorithm = "DSTU4145";
        this.f44911d = new m();
        this.f44908a = fVar.b();
        this.f44909b = fVar.a() != null ? h.h(h.b(fVar.a().a(), fVar.a().e()), fVar.a()) : null;
    }

    public BCDSTU4145PrivateKey(String str, l0 l0Var) {
        this.algorithm = "DSTU4145";
        this.f44911d = new m();
        this.algorithm = str;
        this.f44908a = l0Var.e();
        this.f44909b = null;
    }

    public BCDSTU4145PrivateKey(String str, l0 l0Var, BCDSTU4145PublicKey bCDSTU4145PublicKey, e eVar) {
        this.algorithm = "DSTU4145";
        this.f44911d = new m();
        g0 g0VarD = l0Var.d();
        this.algorithm = str;
        this.f44908a = l0Var.e();
        this.f44909b = eVar == null ? new ECParameterSpec(h.b(g0VarD.a(), g0VarD.f()), h.f(g0VarD.b()), g0VarD.e(), g0VarD.c().intValue()) : new ECParameterSpec(h.b(eVar.a(), eVar.e()), h.f(eVar.b()), eVar.d(), eVar.c().intValue());
        this.f44910c = i(bCDSTU4145PublicKey);
    }

    public BCDSTU4145PrivateKey(String str, l0 l0Var, BCDSTU4145PublicKey bCDSTU4145PublicKey, ECParameterSpec eCParameterSpec) {
        this.algorithm = "DSTU4145";
        this.f44911d = new m();
        g0 g0VarD = l0Var.d();
        this.algorithm = str;
        this.f44908a = l0Var.e();
        if (eCParameterSpec == null) {
            this.f44909b = new ECParameterSpec(h.b(g0VarD.a(), g0VarD.f()), h.f(g0VarD.b()), g0VarD.e(), g0VarD.c().intValue());
        } else {
            this.f44909b = eCParameterSpec;
        }
        this.f44910c = i(bCDSTU4145PublicKey);
    }

    public BCDSTU4145PrivateKey(ECPrivateKey eCPrivateKey) {
        this.algorithm = "DSTU4145";
        this.f44911d = new m();
        this.f44908a = eCPrivateKey.getS();
        this.algorithm = eCPrivateKey.getAlgorithm();
        this.f44909b = eCPrivateKey.getParams();
    }

    public BCDSTU4145PrivateKey(ECPrivateKeySpec eCPrivateKeySpec) {
        this.algorithm = "DSTU4145";
        this.f44911d = new m();
        this.f44908a = eCPrivateKeySpec.getS();
        this.f44909b = eCPrivateKeySpec.getParams();
    }

    public BCDSTU4145PrivateKey(BCDSTU4145PrivateKey bCDSTU4145PrivateKey) {
        this.algorithm = "DSTU4145";
        this.f44911d = new m();
        this.f44908a = bCDSTU4145PrivateKey.f44908a;
        this.f44909b = bCDSTU4145PrivateKey.f44909b;
        this.withCompression = bCDSTU4145PrivateKey.withCompression;
        this.f44911d = bCDSTU4145PrivateKey.f44911d;
        this.f44910c = bCDSTU4145PrivateKey.f44910c;
    }

    public BCDSTU4145PrivateKey(u uVar) throws IOException {
        this.algorithm = "DSTU4145";
        this.f44911d = new m();
        k(uVar);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        k(u.z(c0.D((byte[]) objectInputStream.readObject())));
        this.f44911d = new m();
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
        ECParameterSpec eCParameterSpec = this.f44909b;
        if (eCParameterSpec == null) {
            return null;
        }
        return h.g(eCParameterSpec);
    }

    @Override // er.g
    public gm.h c(y yVar) {
        return this.f44911d.c(yVar);
    }

    public e d() {
        ECParameterSpec eCParameterSpec = this.f44909b;
        return eCParameterSpec != null ? h.g(eCParameterSpec) : BouncyCastleProvider.f45330c.b();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCDSTU4145PrivateKey)) {
            return false;
        }
        BCDSTU4145PrivateKey bCDSTU4145PrivateKey = (BCDSTU4145PrivateKey) obj;
        return f0().equals(bCDSTU4145PrivateKey.f0()) && d().equals(bCDSTU4145PrivateKey.d());
    }

    @Override // er.g
    public Enumeration f() {
        return this.f44911d.f();
    }

    @Override // org.bouncycastle.jce.interfaces.ECPrivateKey
    public BigInteger f0() {
        return this.f44908a;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ac A[Catch: IOException -> 0x00dc, TryCatch #0 {IOException -> 0x00dc, blocks: (B:16:0x00a2, B:18:0x00ac, B:20:0x00d5, B:19:0x00c1), top: B:23:0x00a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c1 A[Catch: IOException -> 0x00dc, TryCatch #0 {IOException -> 0x00dc, blocks: (B:16:0x00a2, B:18:0x00ac, B:20:0x00d5, B:19:0x00c1), top: B:23:0x00a2 }] */
    @Override // java.security.Key
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] getEncoded() {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PrivateKey.getEncoded():byte[]");
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.f44909b;
    }

    @Override // java.security.interfaces.ECPrivateKey
    public BigInteger getS() {
        return this.f44908a;
    }

    @Override // er.g
    public void h(y yVar, gm.h hVar) {
        this.f44911d.h(yVar, hVar);
    }

    public int hashCode() {
        return f0().hashCode() ^ d().hashCode();
    }

    public final d i(BCDSTU4145PublicKey bCDSTU4145PublicKey) {
        try {
            return c1.A(c0.D(bCDSTU4145PublicKey.getEncoded())).C();
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x018b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(pn.u r13) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 412
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PrivateKey.k(pn.u):void");
    }

    public final void l(byte[] bArr) {
        for (int i10 = 0; i10 < bArr.length / 2; i10++) {
            byte b10 = bArr[i10];
            bArr[i10] = bArr[(bArr.length - 1) - i10];
            bArr[(bArr.length - 1) - i10] = b10;
        }
    }

    public String toString() {
        return i.o(this.algorithm, this.f44908a, d());
    }
}
