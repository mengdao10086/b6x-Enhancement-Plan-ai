package tq;

import cp.x0;
import gm.d2;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import np.e2;
import org.bouncycastle.crypto.s;
import zo.a0;
import zo.t;
import zo.w;
import zo.y;
import zo.z;

/* JADX INFO: loaded from: classes7.dex */
public class c extends SignatureSpi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f51581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public org.bouncycastle.crypto.b f51582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zn.b f51583c;

    public static class a extends c {
        public a() {
            super(pn.s.f46797d4, new zo.s(), new bp.c(new x0()));
        }
    }

    public static class b extends c {
        public b() {
            super(pn.s.f46800e4, new t(), new bp.c(new x0()));
        }
    }

    /* JADX INFO: renamed from: tq.c$c, reason: collision with other inner class name */
    public static class C0588c extends c {
        public C0588c() {
            super(pn.s.f46803f4, org.bouncycastle.crypto.util.f.b(), new bp.c(new x0()));
        }
    }

    public static class d extends c {
        public d() {
            super(tn.b.f51361c, new y(), new bp.c(new x0()));
        }
    }

    public static class e extends c {
        public e() {
            super(tn.b.f51360b, new z(), new bp.c(new x0()));
        }
    }

    public static class f extends c {
        public f() {
            super(tn.b.f51362d, new a0(), new bp.c(new x0()));
        }
    }

    public static class g extends c {
        public g() {
            super(on.b.f44365i, org.bouncycastle.crypto.util.f.c(), new bp.c(new x0()));
        }
    }

    public static class h extends c {
        public h() {
            super(kn.d.f37598f, org.bouncycastle.crypto.util.f.d(), new bp.c(new x0()));
        }
    }

    public static class i extends c {
        public i() {
            super(kn.d.f37592c, org.bouncycastle.crypto.util.f.e(), new bp.c(new x0()));
        }
    }

    public static class j extends c {
        public j() {
            super(kn.d.f37594d, org.bouncycastle.crypto.util.f.f(), new bp.c(new x0()));
        }
    }

    public static class k extends c {
        public k() {
            super(kn.d.f37604i, org.bouncycastle.crypto.util.f.g(), new bp.c(new x0()));
        }
    }

    public static class l extends c {
        public l() {
            super(kn.d.f37606j, org.bouncycastle.crypto.util.f.h(), new bp.c(new x0()));
        }
    }

    public static class m extends c {
        public m() {
            super(kn.d.f37608k, org.bouncycastle.crypto.util.f.i(), new bp.c(new x0()));
        }
    }

    public static class n extends c {
        public n() {
            super(kn.d.f37610l, org.bouncycastle.crypto.util.f.j(), new bp.c(new x0()));
        }
    }

    public static class o extends c {
        public o() {
            super(kn.d.f37596e, org.bouncycastle.crypto.util.f.k(), new bp.c(new x0()));
        }
    }

    public static class p extends c {
        public p() {
            super(kn.d.f37600g, org.bouncycastle.crypto.util.f.l(), new bp.c(new x0()));
        }
    }

    public static class q extends c {
        public q() {
            super(kn.d.f37602h, org.bouncycastle.crypto.util.f.m(), new bp.c(new x0()));
        }
    }

    public static class r extends c {
        public r() {
            super(new w(), new bp.c(new x0()));
        }
    }

    public c(gm.y yVar, s sVar, org.bouncycastle.crypto.b bVar) {
        this.f51581a = sVar;
        this.f51582b = bVar;
        this.f51583c = new zn.b(yVar, d2.f29657b);
    }

    public c(s sVar, org.bouncycastle.crypto.b bVar) {
        this.f51581a = sVar;
        this.f51582b = bVar;
        this.f51583c = null;
    }

    public final byte[] a(byte[] bArr) throws IOException {
        zn.b bVar = this.f51583c;
        return bVar == null ? bArr : new zn.t(bVar, bArr).v(gm.j.f29713a);
    }

    public final String b(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.getClass().getName();
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        return null;
    }

    @Override // java.security.SignatureSpi
    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof RSAPrivateKey) {
            e2 e2VarC = tq.h.c((RSAPrivateKey) privateKey);
            this.f51581a.reset();
            this.f51582b.a(true, e2VarC);
        } else {
            throw new InvalidKeyException("Supplied key (" + b(privateKey) + ") is not a RSAPrivateKey instance");
        }
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof RSAPublicKey) {
            e2 e2VarD = tq.h.d((RSAPublicKey) publicKey);
            this.f51581a.reset();
            this.f51582b.a(false, e2VarD);
        } else {
            throw new InvalidKeyException("Supplied key (" + b(publicKey) + ") is not a RSAPublicKey instance");
        }
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
        byte[] bArr = new byte[this.f51581a.h()];
        this.f51581a.c(bArr, 0);
        try {
            byte[] bArrA = a(bArr);
            return this.f51582b.c(bArrA, 0, bArrA.length);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new SignatureException("key too small for signature type");
        } catch (Exception e10) {
            throw new SignatureException(e10.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b10) throws SignatureException {
        this.f51581a.update(b10);
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i10, int i11) throws SignatureException {
        this.f51581a.update(bArr, i10, i11);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) throws SignatureException {
        byte[] bArrC;
        byte[] bArrA;
        byte[] bArr2 = new byte[this.f51581a.h()];
        this.f51581a.c(bArr2, 0);
        try {
            bArrC = this.f51582b.c(bArr, 0, bArr.length);
            bArrA = a(bArr2);
        } catch (Exception unused) {
        }
        if (bArrC.length == bArrA.length) {
            return org.bouncycastle.util.a.I(bArrC, bArrA);
        }
        if (bArrC.length != bArrA.length - 2) {
            org.bouncycastle.util.a.I(bArrA, bArrA);
            return false;
        }
        bArrA[1] = (byte) (bArrA[1] - 2);
        bArrA[3] = (byte) (bArrA[3] - 2);
        int i10 = bArrA[3] + 4;
        int i11 = i10 + 2;
        int i12 = 0;
        for (int i13 = 0; i13 < bArrA.length - i11; i13++) {
            i12 |= bArrC[i10 + i13] ^ bArrA[i11 + i13];
        }
        for (int i14 = 0; i14 < i10; i14++) {
            i12 |= bArrC[i14] ^ bArrA[i14];
        }
        return i12 == 0;
    }
}
