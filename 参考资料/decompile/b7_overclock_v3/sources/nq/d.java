package nq;

import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import cp.h0;
import cp.t;
import fp.j;
import fp.u;
import fp.z;
import gr.r;
import ip.k;
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
import javax.crypto.interfaces.DHKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import np.h1;
import np.m;
import np.n;
import np.q;
import np.s;
import np.v1;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.h;
import org.bouncycastle.crypto.x;
import org.bouncycastle.jcajce.provider.util.BadBlockException;
import org.bouncycastle.jce.interfaces.IESKey;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class d extends CipherSpi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f42590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f42591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h0 f42592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f42593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ByteArrayOutputStream f42594e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AlgorithmParameters f42595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r f42596g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public np.c f42597h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SecureRandom f42598i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f42599j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public np.c f42600k;

    public class a implements x {
        public a() {
        }

        @Override // org.bouncycastle.crypto.x
        public byte[] a(np.c cVar) {
            int iBitLength = (((n) cVar).d().f().bitLength() + 7) / 8;
            byte[] bArr = new byte[iBitLength];
            byte[] bArrC = org.bouncycastle.util.b.c(((s) cVar).e());
            if (bArrC.length > iBitLength) {
                throw new IllegalArgumentException("Senders's public key longer than expected.");
            }
            System.arraycopy(bArrC, 0, bArr, iBitLength - bArrC.length, bArrC.length);
            return bArr;
        }
    }

    public static class b extends d {
        public b() {
            super(new h0(new uo.b(), new z(org.bouncycastle.crypto.util.f.c()), new k(org.bouncycastle.crypto.util.f.c())));
        }
    }

    public static class c extends d {
        public c() {
            super(new h0(new uo.b(), new z(org.bouncycastle.crypto.util.f.c()), new k(org.bouncycastle.crypto.util.f.c()), new mp.e(new jp.c(new cp.a()))), 16);
        }
    }

    /* JADX INFO: renamed from: nq.d$d, reason: collision with other inner class name */
    public static class C0478d extends d {
        public C0478d() {
            super(new h0(new uo.b(), new z(org.bouncycastle.crypto.util.f.c()), new k(org.bouncycastle.crypto.util.f.c()), new mp.e(new jp.c(new t()))), 8);
        }
    }

    public d(h0 h0Var) {
        this.f42590a = new org.bouncycastle.jcajce.util.b();
        this.f42593d = -1;
        this.f42594e = new ByteArrayOutputStream();
        this.f42595f = null;
        this.f42596g = null;
        this.f42599j = false;
        this.f42600k = null;
        this.f42592c = h0Var;
        this.f42591b = 0;
    }

    public d(h0 h0Var, int i10) {
        this.f42590a = new org.bouncycastle.jcajce.util.b();
        this.f42593d = -1;
        this.f42594e = new ByteArrayOutputStream();
        this.f42595f = null;
        this.f42596g = null;
        this.f42599j = false;
        this.f42600k = null;
        this.f42592c = h0Var;
        this.f42591b = i10;
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
            this.f42594e.write(bArr, i10, i11);
        }
        byte[] byteArray = this.f42594e.toByteArray();
        this.f42594e.reset();
        org.bouncycastle.crypto.k h1Var = new h1(this.f42596g.b(), this.f42596g.c(), this.f42596g.d(), this.f42596g.a());
        if (this.f42596g.e() != null) {
            h1Var = new v1(h1Var, this.f42596g.e());
        }
        q qVarD = ((n) this.f42597h).d();
        np.c cVar = this.f42600k;
        if (cVar != null) {
            try {
                int i12 = this.f42593d;
                if (i12 == 1 || i12 == 3) {
                    this.f42592c.i(true, cVar, this.f42597h, h1Var);
                } else {
                    this.f42592c.i(false, this.f42597h, cVar, h1Var);
                }
                return this.f42592c.j(byteArray, 0, byteArray.length);
            } catch (Exception e10) {
                throw new BadBlockException("unable to process block", e10);
            }
        }
        int i13 = this.f42593d;
        if (i13 == 1 || i13 == 3) {
            j jVar = new j();
            jVar.a(new m(this.f42598i, qVarD));
            try {
                this.f42592c.g(this.f42597h, h1Var, new u(jVar, new a()));
                return this.f42592c.j(byteArray, 0, byteArray.length);
            } catch (Exception e11) {
                throw new BadBlockException("unable to process block", e11);
            }
        }
        if (i13 != 2 && i13 != 4) {
            throw new IllegalStateException("IESCipher not initialised");
        }
        try {
            h0 h0Var = this.f42592c;
            np.c cVar2 = this.f42597h;
            h0Var.h(cVar2, h1Var, new op.a(((n) cVar2).d()));
            return this.f42592c.j(byteArray, 0, byteArray.length);
        } catch (InvalidCipherTextException e12) {
            throw new BadBlockException("unable to process block", e12);
        }
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        if (this.f42592c.d() != null) {
            return this.f42592c.d().b();
        }
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        r rVar = this.f42596g;
        if (rVar != null) {
            return rVar.e();
        }
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetKeySize(Key key) {
        if (key instanceof DHKey) {
            return ((DHKey) key).getParams().getP().bitLength();
        }
        throw new IllegalArgumentException("not a DH key");
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetOutputSize(int i10) {
        int size;
        h hVarD;
        if (this.f42597h == null) {
            throw new IllegalStateException("cipher not initialised");
        }
        int iD = this.f42592c.f().d();
        int iBitLength = this.f42600k == null ? (((((n) this.f42597h).d().f().bitLength() + 7) * 2) / 8) + 1 : 0;
        if (this.f42592c.d() != null) {
            int i11 = this.f42593d;
            if (i11 == 1 || i11 == 3) {
                hVarD = this.f42592c.d();
            } else {
                if (i11 != 2 && i11 != 4) {
                    throw new IllegalStateException("cipher not initialised");
                }
                hVarD = this.f42592c.d();
                i10 = (i10 - iD) - iBitLength;
            }
            i10 = hVarD.c(i10);
        }
        int i12 = this.f42593d;
        if (i12 == 1 || i12 == 3) {
            size = this.f42594e.size() + iD + iBitLength;
        } else {
            if (i12 != 2 && i12 != 4) {
                throw new IllegalStateException("IESCipher not initialised");
            }
            size = (this.f42594e.size() - iD) - iBitLength;
        }
        return size + i10;
    }

    @Override // javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        if (this.f42595f == null && this.f42596g != null) {
            try {
                AlgorithmParameters algorithmParametersT = this.f42590a.t("IES");
                this.f42595f = algorithmParametersT;
                algorithmParametersT.init(this.f42596g);
            } catch (Exception e10) {
                throw new RuntimeException(e10.toString());
            }
        }
        return this.f42595f;
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
        this.f42595f = algorithmParameters;
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
        np.c cVarB;
        PrivateKey privateKeyL0;
        if (algorithmParameterSpec == null) {
            byte[] bArr = null;
            int i11 = this.f42591b;
            if (i11 != 0 && i10 == 1) {
                bArr = new byte[i11];
                secureRandom.nextBytes(bArr);
            }
            rVarA = org.bouncycastle.jcajce.provider.asymmetric.util.k.a(this.f42592c.d(), bArr);
        } else {
            if (!(algorithmParameterSpec instanceof r)) {
                throw new InvalidAlgorithmParameterException("must be passed IES parameters");
            }
            rVarA = (r) algorithmParameterSpec;
        }
        this.f42596g = rVarA;
        byte[] bArrE = this.f42596g.e();
        int i12 = this.f42591b;
        if (i12 != 0 && (bArrE == null || bArrE.length != i12)) {
            throw new InvalidAlgorithmParameterException("NONCE in IES Parameters needs to be " + this.f42591b + " bytes long");
        }
        if (i10 == 1 || i10 == 3) {
            if (!(key instanceof DHPublicKey)) {
                if (!(key instanceof IESKey)) {
                    throw new InvalidKeyException("must be passed recipient's public DH key for encryption");
                }
                IESKey iESKey = (IESKey) key;
                this.f42597h = org.bouncycastle.jcajce.provider.asymmetric.util.e.b(iESKey.s0());
                this.f42600k = org.bouncycastle.jcajce.provider.asymmetric.util.e.a(iESKey.L0());
                this.f42598i = secureRandom;
                this.f42593d = i10;
                this.f42594e.reset();
            }
            cVarB = org.bouncycastle.jcajce.provider.asymmetric.util.e.b((PublicKey) key);
        } else {
            if (i10 != 2 && i10 != 4) {
                throw new InvalidKeyException("must be passed EC key");
            }
            if (key instanceof DHPrivateKey) {
                privateKeyL0 = (PrivateKey) key;
            } else {
                if (!(key instanceof IESKey)) {
                    throw new InvalidKeyException("must be passed recipient's private DH key for decryption");
                }
                IESKey iESKey2 = (IESKey) key;
                this.f42600k = org.bouncycastle.jcajce.provider.asymmetric.util.e.b(iESKey2.s0());
                privateKeyL0 = iESKey2.L0();
            }
            cVarB = org.bouncycastle.jcajce.provider.asymmetric.util.e.a(privateKeyL0);
        }
        this.f42597h = cVarB;
        this.f42598i = secureRandom;
        this.f42593d = i10;
        this.f42594e.reset();
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
        this.f42599j = z10;
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
        this.f42594e.write(bArr, i10, i11);
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] bArr, int i10, int i11) {
        this.f42594e.write(bArr, i10, i11);
        return null;
    }
}
