package tq;

import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import cp.x0;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import np.w1;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.k;
import org.bouncycastle.crypto.n;
import org.bouncycastle.crypto.s;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi;
import org.bouncycastle.jcajce.provider.util.BadBlockException;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class b extends BaseCipherSpi {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f51574g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public org.bouncycastle.crypto.b f51575h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AlgorithmParameterSpec f51576i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AlgorithmParameters f51577j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f51578k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f51579l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public BaseCipherSpi.a f51580m;

    public static class a extends b {
        public a() {
            super(new bp.a(new x0()));
        }
    }

    /* JADX INFO: renamed from: tq.b$b, reason: collision with other inner class name */
    public static class C0587b extends b {
        public C0587b() {
            super(new x0());
        }
    }

    public static class c extends b {
        public c() {
            super(OAEPParameterSpec.DEFAULT);
        }
    }

    public static class d extends b {
        public d() {
            super(new bp.c(new x0()));
        }
    }

    public static class e extends b {
        public e() {
            super(false, true, new bp.c(new x0()));
        }
    }

    public static class f extends b {
        public f() {
            super(true, false, new bp.c(new x0()));
        }
    }

    public b(OAEPParameterSpec oAEPParameterSpec) {
        this.f51574g = new org.bouncycastle.jcajce.util.b();
        this.f51578k = false;
        this.f51579l = false;
        this.f51580m = new BaseCipherSpi.a();
        try {
            c(oAEPParameterSpec);
        } catch (NoSuchPaddingException e10) {
            throw new IllegalArgumentException(e10.getMessage());
        }
    }

    public b(org.bouncycastle.crypto.b bVar) {
        this.f51574g = new org.bouncycastle.jcajce.util.b();
        this.f51578k = false;
        this.f51579l = false;
        this.f51580m = new BaseCipherSpi.a();
        this.f51575h = bVar;
    }

    public b(boolean z10, boolean z11, org.bouncycastle.crypto.b bVar) {
        this.f51574g = new org.bouncycastle.jcajce.util.b();
        this.f51578k = false;
        this.f51579l = false;
        this.f51580m = new BaseCipherSpi.a();
        this.f51578k = z10;
        this.f51579l = z11;
        this.f51575h = bVar;
    }

    public final byte[] b() throws BadPaddingException {
        try {
            try {
                try {
                    return this.f51575h.c(this.f51580m.c(), 0, this.f51580m.size());
                } catch (ArrayIndexOutOfBoundsException e10) {
                    throw new BadBlockException("unable to decrypt block", e10);
                }
            } catch (InvalidCipherTextException e11) {
                throw new BadBlockException("unable to decrypt block", e11);
            }
        } finally {
            this.f51580m.a();
        }
    }

    public final void c(OAEPParameterSpec oAEPParameterSpec) throws NoSuchPaddingException {
        MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters();
        s sVarA = br.d.a(mGF1ParameterSpec.getDigestAlgorithm());
        if (sVarA != null) {
            this.f51575h = new bp.b(new x0(), sVarA, ((PSource.PSpecified) oAEPParameterSpec.getPSource()).getValue());
            this.f51576i = oAEPParameterSpec;
        } else {
            throw new NoSuchPaddingException("no match on OAEP constructor for digest algorithm: " + mGF1ParameterSpec.getDigestAlgorithm());
        }
    }

    @Override // javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        if (engineGetOutputSize(i11) + i12 > bArr2.length) {
            throw new ShortBufferException("output buffer too short for input.");
        }
        if (bArr != null) {
            this.f51580m.write(bArr, i10, i11);
        }
        if (this.f51575h instanceof x0) {
            if (this.f51580m.size() > this.f51575h.b() + 1) {
                throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
            }
        } else if (this.f51580m.size() > this.f51575h.b()) {
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
        byte[] bArrB = b();
        for (int i13 = 0; i13 != bArrB.length; i13++) {
            bArr2[i12 + i13] = bArrB[i13];
        }
        return bArrB.length;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i10, int i11) throws BadPaddingException, IllegalBlockSizeException {
        if (bArr != null) {
            this.f51580m.write(bArr, i10, i11);
        }
        if (this.f51575h instanceof x0) {
            if (this.f51580m.size() > this.f51575h.b() + 1) {
                throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
            }
        } else if (this.f51580m.size() > this.f51575h.b()) {
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
        return b();
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi, javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        try {
            return this.f51575h.b();
        } catch (NullPointerException unused) {
            throw new IllegalStateException("RSA Cipher not initialised");
        }
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi, javax.crypto.CipherSpi
    public int engineGetKeySize(Key key) {
        BigInteger modulus;
        if (key instanceof RSAPrivateKey) {
            modulus = ((RSAPrivateKey) key).getModulus();
        } else {
            if (!(key instanceof RSAPublicKey)) {
                throw new IllegalArgumentException("not an RSA key!");
            }
            modulus = ((RSAPublicKey) key).getModulus();
        }
        return modulus.bitLength();
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi, javax.crypto.CipherSpi
    public int engineGetOutputSize(int i10) {
        try {
            return this.f51575h.d();
        } catch (NullPointerException unused) {
            throw new IllegalStateException("RSA Cipher not initialised");
        }
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi, javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        if (this.f51577j == null && this.f51576i != null) {
            try {
                AlgorithmParameters algorithmParametersT = this.f51574g.t("OAEP");
                this.f51577j = algorithmParametersT;
                algorithmParametersT.init(this.f51576i);
            } catch (Exception e10) {
                throw new RuntimeException(e10.toString());
            }
        }
        return this.f51577j;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i10, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec parameterSpec;
        if (algorithmParameters != null) {
            try {
                parameterSpec = algorithmParameters.getParameterSpec(OAEPParameterSpec.class);
            } catch (InvalidParameterSpecException e10) {
                throw new InvalidAlgorithmParameterException("cannot recognise parameters: " + e10.toString(), e10);
            }
        } else {
            parameterSpec = null;
        }
        this.f51577j = algorithmParameters;
        engineInit(i10, key, parameterSpec, secureRandom);
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i10, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i10, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e10) {
            throw new InvalidKeyException("Eeeek! " + e10.toString(), e10);
        }
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i10, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        k kVarC;
        if (algorithmParameterSpec != null && !(algorithmParameterSpec instanceof OAEPParameterSpec)) {
            throw new InvalidAlgorithmParameterException("unknown parameter type: " + algorithmParameterSpec.getClass().getName());
        }
        if (key instanceof RSAPublicKey) {
            if (this.f51579l && i10 == 1) {
                throw new InvalidKeyException("mode 1 requires RSAPrivateKey");
            }
            kVarC = h.d((RSAPublicKey) key);
        } else {
            if (!(key instanceof RSAPrivateKey)) {
                throw new InvalidKeyException("unknown key type passed to RSA");
            }
            if (this.f51578k && i10 == 1) {
                throw new InvalidKeyException("mode 2 requires RSAPublicKey");
            }
            kVarC = h.c((RSAPrivateKey) key);
        }
        if (algorithmParameterSpec != null) {
            OAEPParameterSpec oAEPParameterSpec = (OAEPParameterSpec) algorithmParameterSpec;
            this.f51576i = algorithmParameterSpec;
            if (!oAEPParameterSpec.getMGFAlgorithm().equalsIgnoreCase("MGF1") && !oAEPParameterSpec.getMGFAlgorithm().equals(pn.s.E3.L())) {
                throw new InvalidAlgorithmParameterException("unknown mask generation function specified");
            }
            if (!(oAEPParameterSpec.getMGFParameters() instanceof MGF1ParameterSpec)) {
                throw new InvalidAlgorithmParameterException("unkown MGF parameters");
            }
            s sVarA = br.d.a(oAEPParameterSpec.getDigestAlgorithm());
            if (sVarA == null) {
                throw new InvalidAlgorithmParameterException("no match on digest algorithm: " + oAEPParameterSpec.getDigestAlgorithm());
            }
            MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters();
            s sVarA2 = br.d.a(mGF1ParameterSpec.getDigestAlgorithm());
            if (sVarA2 == null) {
                throw new InvalidAlgorithmParameterException("no match on MGF digest algorithm: " + mGF1ParameterSpec.getDigestAlgorithm());
            }
            this.f51575h = new bp.b(new x0(), sVarA, sVarA2, ((PSource.PSpecified) oAEPParameterSpec.getPSource()).getValue());
        }
        if (!(this.f51575h instanceof x0)) {
            kVarC = secureRandom != null ? new w1(kVarC, secureRandom) : new w1(kVarC, n.f());
        }
        this.f51580m.reset();
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        throw new InvalidParameterException("unknown opmode " + i10 + " passed to RSA");
                    }
                }
            }
            this.f51575h.a(false, kVarC);
            return;
        }
        this.f51575h.a(true, kVarC);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi, javax.crypto.CipherSpi
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        String strO = Strings.o(str);
        if (strO.equals(HlsPlaylistParser.M) || strO.equals("ECB")) {
            return;
        }
        if (strO.equals("1")) {
            this.f51579l = true;
            this.f51578k = false;
        } else if (strO.equals("2")) {
            this.f51579l = false;
            this.f51578k = true;
        } else {
            throw new NoSuchAlgorithmException("can't support mode " + str);
        }
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi, javax.crypto.CipherSpi
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        OAEPParameterSpec oAEPParameterSpec;
        org.bouncycastle.crypto.b aVar;
        String strO = Strings.o(str);
        if (strO.equals("NOPADDING")) {
            aVar = new x0();
        } else if (strO.equals("PKCS1PADDING")) {
            aVar = new bp.c(new x0());
        } else {
            if (!strO.equals("ISO9796-1PADDING")) {
                if (strO.equals("OAEPWITHMD5ANDMGF1PADDING")) {
                    oAEPParameterSpec = new OAEPParameterSpec("MD5", "MGF1", new MGF1ParameterSpec("MD5"), PSource.PSpecified.DEFAULT);
                } else if (strO.equals("OAEPPADDING") || strO.equals("OAEPWITHSHA1ANDMGF1PADDING") || strO.equals("OAEPWITHSHA-1ANDMGF1PADDING")) {
                    oAEPParameterSpec = OAEPParameterSpec.DEFAULT;
                } else if (strO.equals("OAEPWITHSHA224ANDMGF1PADDING") || strO.equals("OAEPWITHSHA-224ANDMGF1PADDING")) {
                    oAEPParameterSpec = new OAEPParameterSpec(et.e.f27138g, "MGF1", new MGF1ParameterSpec(et.e.f27138g), PSource.PSpecified.DEFAULT);
                } else if (strO.equals("OAEPWITHSHA256ANDMGF1PADDING") || strO.equals("OAEPWITHSHA-256ANDMGF1PADDING")) {
                    oAEPParameterSpec = new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT);
                } else if (strO.equals("OAEPWITHSHA384ANDMGF1PADDING") || strO.equals("OAEPWITHSHA-384ANDMGF1PADDING")) {
                    oAEPParameterSpec = new OAEPParameterSpec(et.e.f27140i, "MGF1", MGF1ParameterSpec.SHA384, PSource.PSpecified.DEFAULT);
                } else if (strO.equals("OAEPWITHSHA512ANDMGF1PADDING") || strO.equals("OAEPWITHSHA-512ANDMGF1PADDING")) {
                    oAEPParameterSpec = new OAEPParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, PSource.PSpecified.DEFAULT);
                } else if (strO.equals("OAEPWITHSHA3-224ANDMGF1PADDING")) {
                    oAEPParameterSpec = new OAEPParameterSpec("SHA3-224", "MGF1", new MGF1ParameterSpec("SHA3-224"), PSource.PSpecified.DEFAULT);
                } else if (strO.equals("OAEPWITHSHA3-256ANDMGF1PADDING")) {
                    oAEPParameterSpec = new OAEPParameterSpec("SHA3-256", "MGF1", new MGF1ParameterSpec("SHA3-256"), PSource.PSpecified.DEFAULT);
                } else if (strO.equals("OAEPWITHSHA3-384ANDMGF1PADDING")) {
                    oAEPParameterSpec = new OAEPParameterSpec("SHA3-384", "MGF1", new MGF1ParameterSpec("SHA3-384"), PSource.PSpecified.DEFAULT);
                } else {
                    if (!strO.equals("OAEPWITHSHA3-512ANDMGF1PADDING")) {
                        throw new NoSuchPaddingException(str + " unavailable with RSA.");
                    }
                    oAEPParameterSpec = new OAEPParameterSpec("SHA3-512", "MGF1", new MGF1ParameterSpec("SHA3-512"), PSource.PSpecified.DEFAULT);
                }
                c(oAEPParameterSpec);
                return;
            }
            aVar = new bp.a(new x0());
        }
        this.f51575h = aVar;
    }

    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        this.f51580m.write(bArr, i10, i11);
        if (this.f51575h instanceof x0) {
            if (this.f51580m.size() <= this.f51575h.b() + 1) {
                return 0;
            }
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
        if (this.f51580m.size() <= this.f51575h.b()) {
            return 0;
        }
        throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] bArr, int i10, int i11) {
        this.f51580m.write(bArr, i10, i11);
        if (this.f51575h instanceof x0) {
            if (this.f51580m.size() <= this.f51575h.b() + 1) {
                return null;
            }
            throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
        }
        if (this.f51580m.size() <= this.f51575h.b()) {
            return null;
        }
        throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
    }
}
