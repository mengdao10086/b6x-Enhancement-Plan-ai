package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;
import np.w1;
import rp.z;
import zn.z1;
import zo.w;

/* JADX INFO: loaded from: classes7.dex */
public class c extends SignatureSpi implements pn.s, z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.s f44896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public org.bouncycastle.crypto.p f44897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public rp.b f44898c = z.f49116a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SecureRandom f44899d;

    public static class a extends c {
        public a() {
            super(org.bouncycastle.crypto.util.f.d(), new rp.d(new rp.q(org.bouncycastle.crypto.util.f.d())));
        }
    }

    public static class b extends c {
        public b() {
            super(org.bouncycastle.crypto.util.f.e(), new rp.d(new rp.q(org.bouncycastle.crypto.util.f.e())));
        }
    }

    /* JADX INFO: renamed from: org.bouncycastle.jcajce.provider.asymmetric.dsa.c$c, reason: collision with other inner class name */
    public static class C0504c extends c {
        public C0504c() {
            super(org.bouncycastle.crypto.util.f.f(), new rp.d(new rp.q(org.bouncycastle.crypto.util.f.f())));
        }
    }

    public static class d extends c {
        public d() {
            super(org.bouncycastle.crypto.util.f.k(), new rp.d(new rp.q(org.bouncycastle.crypto.util.f.k())));
        }
    }

    public static class e extends c {
        public e() {
            super(org.bouncycastle.crypto.util.f.c(), new rp.d(new rp.q(org.bouncycastle.crypto.util.f.c())));
        }
    }

    public static class f extends c {
        public f() {
            super(org.bouncycastle.crypto.util.f.g(), new rp.d(new rp.q(org.bouncycastle.crypto.util.f.g())));
        }
    }

    public static class g extends c {
        public g() {
            super(org.bouncycastle.crypto.util.f.h(), new rp.d(new rp.q(org.bouncycastle.crypto.util.f.h())));
        }
    }

    public static class h extends c {
        public h() {
            super(org.bouncycastle.crypto.util.f.i(), new rp.d(new rp.q(org.bouncycastle.crypto.util.f.i())));
        }
    }

    public static class i extends c {
        public i() {
            super(org.bouncycastle.crypto.util.f.j(), new rp.d(new rp.q(org.bouncycastle.crypto.util.f.j())));
        }
    }

    public static class j extends c {
        public j() {
            super(org.bouncycastle.crypto.util.f.d(), new rp.d());
        }
    }

    public static class k extends c {
        public k() {
            super(org.bouncycastle.crypto.util.f.e(), new rp.d());
        }
    }

    public static class l extends c {
        public l() {
            super(org.bouncycastle.crypto.util.f.f(), new rp.d());
        }
    }

    public static class m extends c {
        public m() {
            super(org.bouncycastle.crypto.util.f.k(), new rp.d());
        }
    }

    public static class n extends c {
        public n() {
            super(new zo.z(), new rp.d());
        }
    }

    public static class o extends c {
        public o() {
            super(org.bouncycastle.crypto.util.f.g(), new rp.d());
        }
    }

    public static class p extends c {
        public p() {
            super(org.bouncycastle.crypto.util.f.h(), new rp.d());
        }
    }

    public static class q extends c {
        public q() {
            super(org.bouncycastle.crypto.util.f.i(), new rp.d());
        }
    }

    public static class r extends c {
        public r() {
            super(org.bouncycastle.crypto.util.f.j(), new rp.d());
        }
    }

    public static class s extends c {
        public s() {
            super(new w(), new rp.d());
        }
    }

    public static class t extends c {
        public t() {
            super(org.bouncycastle.crypto.util.f.c(), new rp.d());
        }
    }

    public c(org.bouncycastle.crypto.s sVar, org.bouncycastle.crypto.p pVar) {
        this.f44896a = sVar;
        this.f44897b = pVar;
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineGetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        org.bouncycastle.crypto.k kVarB = org.bouncycastle.jcajce.provider.asymmetric.dsa.d.b(privateKey);
        SecureRandom secureRandom = this.f44899d;
        if (secureRandom != null) {
            kVarB = new w1(kVarB, secureRandom);
        }
        this.f44896a.reset();
        this.f44897b.a(true, kVarB);
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey, SecureRandom secureRandom) throws InvalidKeyException {
        this.f44899d = secureRandom;
        engineInitSign(privateKey);
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        np.c cVarC = org.bouncycastle.jcajce.provider.asymmetric.dsa.d.c(publicKey);
        this.f44896a.reset();
        this.f44897b.a(false, cVarC);
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        byte[] bArr = new byte[this.f44896a.h()];
        this.f44896a.c(bArr, 0);
        try {
            BigInteger[] bigIntegerArrB = this.f44897b.b(bArr);
            return this.f44898c.b(this.f44897b.getOrder(), bigIntegerArrB[0], bigIntegerArrB[1]);
        } catch (Exception e10) {
            throw new SignatureException(e10.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b10) throws SignatureException {
        this.f44896a.update(b10);
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i10, int i11) throws SignatureException {
        this.f44896a.update(bArr, i10, i11);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        byte[] bArr2 = new byte[this.f44896a.h()];
        this.f44896a.c(bArr2, 0);
        try {
            BigInteger[] bigIntegerArrA = this.f44898c.a(this.f44897b.getOrder(), bArr);
            return this.f44897b.c(bArr2, bigIntegerArrA[0], bigIntegerArrA[1]);
        } catch (Exception unused) {
            throw new SignatureException("error decoding signature bytes.");
        }
    }
}
