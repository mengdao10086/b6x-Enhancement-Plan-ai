package org.bouncycastle.jcajce.provider.asymmetric.ec;

import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import cp.h0;
import cp.t;
import fp.p;
import fp.u;
import fp.z;
import gr.r;
import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import np.g0;
import np.h1;
import np.i0;
import np.j0;
import np.m0;
import np.v1;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.s;
import org.bouncycastle.crypto.x;
import org.bouncycastle.jcajce.provider.util.BadBlockException;
import org.bouncycastle.jce.interfaces.IESKey;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class e extends CipherSpi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f44942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f44943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h0 f44944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f44945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ByteArrayOutputStream f44946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AlgorithmParameters f44947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r f44948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public np.c f44949h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SecureRandom f44950i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f44951j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public np.c f44952k;

    public class a implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f44953a;

        public a(boolean z10) {
            this.f44953a = z10;
        }

        @Override // org.bouncycastle.crypto.x
        public byte[] a(np.c cVar) {
            return ((m0) cVar).e().l(this.f44953a);
        }
    }

    public static class b extends e {
        public b() {
            this(org.bouncycastle.crypto.util.f.c(), org.bouncycastle.crypto.util.f.c());
        }

        public b(s sVar, s sVar2) {
            super(new h0(new uo.e(), new z(sVar), new ip.k(sVar2)));
        }
    }

    public static class c extends d {
        public c() {
            super(new jp.c(new cp.a()), 16);
        }
    }

    public static class d extends e {
        public d(org.bouncycastle.crypto.f fVar, int i10) {
            this(fVar, i10, org.bouncycastle.crypto.util.f.c(), org.bouncycastle.crypto.util.f.c());
        }

        public d(org.bouncycastle.crypto.f fVar, int i10, s sVar, s sVar2) {
            super(new h0(new uo.e(), new z(sVar), new ip.k(sVar2), new mp.e(fVar)), i10);
        }
    }

    /* JADX INFO: renamed from: org.bouncycastle.jcajce.provider.asymmetric.ec.e$e, reason: collision with other inner class name */
    public static class C0506e extends d {
        public C0506e() {
            super(new jp.c(new t()), 8);
        }
    }

    public static class f extends b {
        public f() {
            super(org.bouncycastle.crypto.util.f.e(), org.bouncycastle.crypto.util.f.e());
        }
    }

    public static class g extends d {
        public g() {
            super(new jp.c(new cp.a()), 16, org.bouncycastle.crypto.util.f.e(), org.bouncycastle.crypto.util.f.e());
        }
    }

    public static class h extends d {
        public h() {
            super(new jp.c(new t()), 8, org.bouncycastle.crypto.util.f.e(), org.bouncycastle.crypto.util.f.e());
        }
    }

    public static class i extends b {
        public i() {
            super(org.bouncycastle.crypto.util.f.f(), org.bouncycastle.crypto.util.f.f());
        }
    }

    public static class j extends d {
        public j() {
            super(new jp.c(new cp.a()), 16, org.bouncycastle.crypto.util.f.f(), org.bouncycastle.crypto.util.f.f());
        }
    }

    public static class k extends d {
        public k() {
            super(new jp.c(new t()), 8, org.bouncycastle.crypto.util.f.f(), org.bouncycastle.crypto.util.f.f());
        }
    }

    public static class l extends b {
        public l() {
            super(org.bouncycastle.crypto.util.f.k(), org.bouncycastle.crypto.util.f.k());
        }
    }

    public static class m extends d {
        public m() {
            super(new jp.c(new cp.a()), 16, org.bouncycastle.crypto.util.f.k(), org.bouncycastle.crypto.util.f.k());
        }
    }

    public static class n extends d {
        public n() {
            super(new jp.c(new t()), 8, org.bouncycastle.crypto.util.f.k(), org.bouncycastle.crypto.util.f.k());
        }
    }

    public e(h0 h0Var) {
        this.f44942a = new org.bouncycastle.jcajce.util.b();
        this.f44945d = -1;
        this.f44946e = new ByteArrayOutputStream();
        this.f44947f = null;
        this.f44948g = null;
        this.f44951j = false;
        this.f44952k = null;
        this.f44944c = h0Var;
        this.f44943b = 0;
    }

    public e(h0 h0Var, int i10) {
        this.f44942a = new org.bouncycastle.jcajce.util.b();
        this.f44945d = -1;
        this.f44946e = new ByteArrayOutputStream();
        this.f44947f = null;
        this.f44948g = null;
        this.f44951j = false;
        this.f44952k = null;
        this.f44944c = h0Var;
        this.f44943b = i10;
    }

    @Override // javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        byte[] bArrEngineDoFinal = engineDoFinal(bArr, i10, i11);
        System.arraycopy(bArrEngineDoFinal, 0, bArr2, i12, bArrEngineDoFinal.length);
        return bArrEngineDoFinal.length;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i10, int i11) throws BadPaddingException, IllegalBlockSizeException {
        if (i11 != 0) {
            this.f44946e.write(bArr, i10, i11);
        }
        byte[] byteArray = this.f44946e.toByteArray();
        this.f44946e.reset();
        org.bouncycastle.crypto.k h1Var = new h1(this.f44948g.b(), this.f44948g.c(), this.f44948g.d(), this.f44948g.a());
        if (this.f44948g.e() != null) {
            h1Var = new v1(h1Var, this.f44948g.e());
        }
        g0 g0VarD = ((j0) this.f44949h).d();
        np.c cVar = this.f44952k;
        if (cVar != null) {
            try {
                int i12 = this.f44945d;
                if (i12 == 1 || i12 == 3) {
                    this.f44944c.i(true, cVar, this.f44949h, h1Var);
                } else {
                    this.f44944c.i(false, this.f44949h, cVar, h1Var);
                }
                return this.f44944c.j(byteArray, 0, byteArray.length);
            } catch (Exception e10) {
                throw new BadBlockException("unable to process block", e10);
            }
        }
        int i13 = this.f44945d;
        if (i13 == 1 || i13 == 3) {
            p pVar = new p();
            pVar.a(new i0(g0VarD, this.f44950i));
            try {
                this.f44944c.g(this.f44949h, h1Var, new u(pVar, new a(this.f44948g.f())));
                return this.f44944c.j(byteArray, 0, byteArray.length);
            } catch (Exception e11) {
                throw new BadBlockException("unable to process block", e11);
            }
        }
        if (i13 != 2 && i13 != 4) {
            throw new IllegalStateException("cipher not initialised");
        }
        try {
            this.f44944c.h(this.f44949h, h1Var, new op.b(g0VarD));
            return this.f44944c.j(byteArray, 0, byteArray.length);
        } catch (InvalidCipherTextException e12) {
            throw new BadBlockException("unable to process block", e12);
        }
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        if (this.f44944c.d() != null) {
            return this.f44944c.d().b();
        }
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        r rVar = this.f44948g;
        if (rVar != null) {
            return rVar.e();
        }
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetKeySize(Key key) {
        if (key instanceof er.b) {
            return ((er.b) key).b().a().v();
        }
        throw new IllegalArgumentException("not an EC key");
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetOutputSize(int i10) {
        org.bouncycastle.crypto.h hVarD;
        if (this.f44949h == null) {
            throw new IllegalStateException("cipher not initialised");
        }
        int iD = this.f44944c.f().d();
        int iV = this.f44952k == null ? ((((j0) this.f44949h).d().a().v() + 7) / 8) * 2 : 0;
        int size = this.f44946e.size() + i10;
        if (this.f44944c.d() != null) {
            int i11 = this.f44945d;
            if (i11 == 1 || i11 == 3) {
                hVarD = this.f44944c.d();
            } else {
                if (i11 != 2 && i11 != 4) {
                    throw new IllegalStateException("cipher not initialised");
                }
                hVarD = this.f44944c.d();
                size = (size - iD) - iV;
            }
            size = hVarD.c(size);
        }
        int i12 = this.f44945d;
        if (i12 == 1 || i12 == 3) {
            return iD + iV + size;
        }
        if (i12 == 2 || i12 == 4) {
            return size;
        }
        throw new IllegalStateException("cipher not initialised");
    }

    @Override // javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        if (this.f44947f == null && this.f44948g != null) {
            try {
                AlgorithmParameters algorithmParametersT = this.f44942a.t("IES");
                this.f44947f = algorithmParametersT;
                algorithmParametersT.init(this.f44948g);
            } catch (Exception e10) {
                throw new RuntimeException(e10.toString());
            }
        }
        return this.f44947f;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i10, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec parameterSpec;
        if (algorithmParameters != null) {
            try {
                parameterSpec = algorithmParameters.getParameterSpec(r.class);
            } catch (Exception e10) {
                throw new InvalidAlgorithmParameterException("cannot recognise parameters: " + e10.toString());
            }
        } else {
            parameterSpec = null;
        }
        this.f44947f = algorithmParameters;
        engineInit(i10, key, parameterSpec, secureRandom);
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i10, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i10, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e10) {
            throw new IllegalArgumentException("cannot handle supplied parameter spec: " + e10.getMessage());
        }
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i10, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        r rVarA;
        np.c cVarA;
        PrivateKey privateKeyL0;
        byte[] bArr = null;
        this.f44952k = null;
        if (algorithmParameterSpec == null) {
            int i11 = this.f44943b;
            if (i11 != 0 && i10 == 1) {
                bArr = new byte[i11];
                secureRandom.nextBytes(bArr);
            }
            rVarA = org.bouncycastle.jcajce.provider.asymmetric.util.k.a(this.f44944c.d(), bArr);
        } else {
            if (!(algorithmParameterSpec instanceof r)) {
                throw new InvalidAlgorithmParameterException("must be passed IES parameters");
            }
            rVarA = (r) algorithmParameterSpec;
        }
        this.f44948g = rVarA;
        byte[] bArrE = this.f44948g.e();
        int i12 = this.f44943b;
        if (i12 != 0 && (bArrE == null || bArrE.length != i12)) {
            throw new InvalidAlgorithmParameterException("NONCE in IES Parameters needs to be " + this.f44943b + " bytes long");
        }
        if (i10 == 1 || i10 == 3) {
            if (!(key instanceof PublicKey)) {
                if (!(key instanceof IESKey)) {
                    throw new InvalidKeyException("must be passed recipient's public EC key for encryption");
                }
                IESKey iESKey = (IESKey) key;
                this.f44949h = org.bouncycastle.jcajce.provider.asymmetric.ec.b.a(iESKey.s0());
                this.f44952k = org.bouncycastle.jcajce.provider.asymmetric.util.i.c(iESKey.L0());
                this.f44950i = secureRandom;
                this.f44945d = i10;
                this.f44946e.reset();
            }
            cVarA = org.bouncycastle.jcajce.provider.asymmetric.ec.b.a((PublicKey) key);
        } else {
            if (i10 != 2 && i10 != 4) {
                throw new InvalidKeyException("must be passed EC key");
            }
            if (key instanceof PrivateKey) {
                privateKeyL0 = (PrivateKey) key;
            } else {
                if (!(key instanceof IESKey)) {
                    throw new InvalidKeyException("must be passed recipient's private EC key for decryption");
                }
                IESKey iESKey2 = (IESKey) key;
                this.f44952k = org.bouncycastle.jcajce.provider.asymmetric.ec.b.a(iESKey2.s0());
                privateKeyL0 = iESKey2.L0();
            }
            cVarA = org.bouncycastle.jcajce.provider.asymmetric.util.i.c(privateKeyL0);
        }
        this.f44949h = cVarA;
        this.f44950i = secureRandom;
        this.f44945d = i10;
        this.f44946e.reset();
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        boolean z10;
        String strO = Strings.o(str);
        if (strO.equals(HlsPlaylistParser.M)) {
            z10 = false;
        } else {
            if (!strO.equals("DHAES")) {
                throw new IllegalArgumentException("can't support mode " + str);
            }
            z10 = true;
        }
        this.f44951j = z10;
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        String strO = Strings.o(str);
        if (!strO.equals("NOPADDING") && !strO.equals("PKCS5PADDING") && !strO.equals("PKCS7PADDING")) {
            throw new NoSuchPaddingException("padding not available with IESCipher");
        }
    }

    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        this.f44946e.write(bArr, i10, i11);
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] bArr, int i10, int i11) {
        this.f44946e.write(bArr, i10, i11);
        return null;
    }
}
