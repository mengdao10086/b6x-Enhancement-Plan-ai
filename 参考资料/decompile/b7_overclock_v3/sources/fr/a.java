package fr;

import gm.c0;
import gm.c2;
import gm.f0;
import gm.i;
import gm.j;
import gm.j2;
import gm.r;
import gm.s;
import gm.u1;
import gm.w;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import zn.b;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class a extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f28715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f28716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f28717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f28718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public u1 f28719e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PublicKey f28720f;

    public a(f0 f0Var) {
        try {
            if (f0Var.size() != 3) {
                throw new IllegalArgumentException("invalid SPKAC (size):" + f0Var.size());
            }
            this.f28715a = b.z(f0Var.K(1));
            this.f28717c = ((u1) f0Var.K(2)).L();
            f0 f0Var2 = (f0) f0Var.K(0);
            if (f0Var2.size() != 2) {
                throw new IllegalArgumentException("invalid PKAC (len): " + f0Var2.size());
            }
            this.f28718d = ((r) f0Var2.K(1)).d();
            this.f28719e = new u1(f0Var2);
            c1 c1VarA = c1.A(f0Var2.K(0));
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(new u1(c1VarA).H());
            b bVarX = c1VarA.x();
            this.f28716b = bVarX;
            this.f28720f = KeyFactory.getInstance(bVarX.x().L(), BouncyCastleProvider.f45329b).generatePublic(x509EncodedKeySpec);
        } catch (Exception e10) {
            throw new IllegalArgumentException(e10.toString());
        }
    }

    public a(String str, b bVar, PublicKey publicKey) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchProviderException {
        this.f28718d = str;
        this.f28715a = bVar;
        this.f28720f = publicKey;
        i iVar = new i();
        iVar.a(z());
        iVar.a(new c2(str));
        try {
            this.f28719e = new u1(new j2(iVar));
        } catch (IOException e10) {
            throw new InvalidKeySpecException("exception encoding key: " + e10.toString());
        }
    }

    public a(byte[] bArr) throws IOException {
        this(B(bArr));
    }

    public static f0 B(byte[] bArr) throws IOException {
        return f0.J(new s(new ByteArrayInputStream(bArr)).n());
    }

    public PublicKey A() {
        return this.f28720f;
    }

    public b C() {
        return this.f28715a;
    }

    public void D(String str) {
        this.f28718d = str;
    }

    public void E(b bVar) {
        this.f28716b = bVar;
    }

    public void F(PublicKey publicKey) {
        this.f28720f = publicKey;
    }

    public void G(b bVar) {
        this.f28715a = bVar;
    }

    public void H(PrivateKey privateKey) throws InvalidKeySpecException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, NoSuchProviderException {
        I(privateKey, null);
    }

    public void I(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeySpecException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, NoSuchProviderException {
        Signature signature = Signature.getInstance(this.f28715a.x().L(), BouncyCastleProvider.f45329b);
        if (secureRandom != null) {
            signature.initSign(privateKey, secureRandom);
        } else {
            signature.initSign(privateKey);
        }
        i iVar = new i();
        iVar.a(z());
        iVar.a(new c2(this.f28718d));
        try {
            signature.update(new j2(iVar).v(j.f29713a));
            this.f28717c = signature.sign();
        } catch (IOException e10) {
            throw new SignatureException(e10.getMessage());
        }
    }

    public boolean J(String str) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, NoSuchProviderException {
        if (!str.equals(this.f28718d)) {
            return false;
        }
        Signature signature = Signature.getInstance(this.f28715a.x().L(), BouncyCastleProvider.f45329b);
        signature.initVerify(this.f28720f);
        signature.update(this.f28719e.H());
        return signature.verify(this.f28717c);
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i();
        i iVar2 = new i();
        try {
            iVar2.a(z());
        } catch (Exception unused) {
        }
        iVar2.a(new c2(this.f28718d));
        iVar.a(new j2(iVar2));
        iVar.a(this.f28715a);
        iVar.a(new u1(this.f28717c));
        return new j2(iVar);
    }

    public String x() {
        return this.f28718d;
    }

    public b y() {
        return this.f28716b;
    }

    public final c0 z() throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchProviderException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(this.f28720f.getEncoded());
            byteArrayOutputStream.close();
            return new s(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).n();
        } catch (IOException e10) {
            throw new InvalidKeySpecException(e10.getMessage());
        }
    }
}
