package qq;

import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import cp.x;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import np.w1;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.k;
import org.bouncycastle.crypto.s;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi;
import org.bouncycastle.jcajce.provider.util.BadBlockException;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class c extends BaseCipherSpi {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public org.bouncycastle.crypto.b f47599g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AlgorithmParameterSpec f47600h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AlgorithmParameters f47601i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BaseCipherSpi.a f47602j = new BaseCipherSpi.a();

    public static class a extends c {
        public a() {
            super(new x());
        }
    }

    public static class b extends c {
        public b() {
            super(new bp.c(new x()));
        }
    }

    public c(org.bouncycastle.crypto.b bVar) {
        this.f47599g = bVar;
    }

    public final byte[] b() throws BadPaddingException {
        try {
            try {
                try {
                    return this.f47599g.c(this.f47602j.c(), 0, this.f47602j.size());
                } catch (ArrayIndexOutOfBoundsException e10) {
                    throw new BadBlockException("unable to decrypt block", e10);
                }
            } catch (InvalidCipherTextException e11) {
                throw new BadBlockException("unable to decrypt block", e11);
            }
        } finally {
            this.f47602j.a();
        }
    }

    public final void c(OAEPParameterSpec oAEPParameterSpec) throws NoSuchPaddingException {
        MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters();
        s sVarA = br.d.a(mGF1ParameterSpec.getDigestAlgorithm());
        if (sVarA != null) {
            this.f47599g = new bp.b(new x(), sVarA, ((PSource.PSpecified) oAEPParameterSpec.getPSource()).getValue());
            this.f47600h = oAEPParameterSpec;
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
            this.f47602j.write(bArr, i10, i11);
        }
        if (this.f47599g instanceof x) {
            if (this.f47602j.size() > this.f47599g.b() + 1) {
                throw new ArrayIndexOutOfBoundsException("too much data for ElGamal block");
            }
        } else if (this.f47602j.size() > this.f47599g.b()) {
            throw new ArrayIndexOutOfBoundsException("too much data for ElGamal block");
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
            this.f47602j.write(bArr, i10, i11);
        }
        if (this.f47599g instanceof x) {
            if (this.f47602j.size() > this.f47599g.b() + 1) {
                throw new ArrayIndexOutOfBoundsException("too much data for ElGamal block");
            }
        } else if (this.f47602j.size() > this.f47599g.b()) {
            throw new ArrayIndexOutOfBoundsException("too much data for ElGamal block");
        }
        return b();
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi, javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return this.f47599g.b();
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi, javax.crypto.CipherSpi
    public int engineGetKeySize(Key key) {
        BigInteger p10;
        if (key instanceof er.d) {
            p10 = ((er.d) key).b().b();
        } else {
            if (!(key instanceof DHKey)) {
                throw new IllegalArgumentException("not an ElGamal key!");
            }
            p10 = ((DHKey) key).getParams().getP();
        }
        return p10.bitLength();
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi, javax.crypto.CipherSpi
    public int engineGetOutputSize(int i10) {
        return this.f47599g.d();
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi, javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        if (this.f47601i == null && this.f47600h != null) {
            try {
                AlgorithmParameters algorithmParametersA = a("OAEP");
                this.f47601i = algorithmParametersA;
                algorithmParametersA.init(this.f47600h);
            } catch (Exception e10) {
                throw new RuntimeException(e10.toString());
            }
        }
        return this.f47601i;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i10, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("can't handle parameters in ElGamal");
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
        k kVarA;
        org.bouncycastle.crypto.b bVar;
        if (key instanceof DHPublicKey) {
            kVarA = d.b((PublicKey) key);
        } else {
            if (!(key instanceof DHPrivateKey)) {
                throw new InvalidKeyException("unknown key type passed to ElGamal");
            }
            kVarA = d.a((PrivateKey) key);
        }
        if (algorithmParameterSpec instanceof OAEPParameterSpec) {
            OAEPParameterSpec oAEPParameterSpec = (OAEPParameterSpec) algorithmParameterSpec;
            this.f47600h = algorithmParameterSpec;
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
            this.f47599g = new bp.b(new x(), sVarA, sVarA2, ((PSource.PSpecified) oAEPParameterSpec.getPSource()).getValue());
        } else if (algorithmParameterSpec != null) {
            throw new InvalidAlgorithmParameterException("unknown parameter type.");
        }
        if (secureRandom != null) {
            kVarA = new w1(kVarA, secureRandom);
        }
        boolean z10 = true;
        if (i10 == 1) {
            bVar = this.f47599g;
        } else {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        throw new InvalidParameterException("unknown opmode " + i10 + " passed to ElGamal");
                    }
                }
                bVar = this.f47599g;
            }
            bVar = this.f47599g;
            z10 = false;
        }
        bVar.a(z10, kVarA);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi, javax.crypto.CipherSpi
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        String strO = Strings.o(str);
        if (strO.equals(HlsPlaylistParser.M) || strO.equals("ECB")) {
            return;
        }
        throw new NoSuchAlgorithmException("can't support mode " + str);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi, javax.crypto.CipherSpi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void engineSetPadding(java.lang.String r5) throws javax.crypto.NoSuchPaddingException {
        /*
            Method dump skipped, instruction units count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: qq.c.engineSetPadding(java.lang.String):void");
    }

    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        this.f47602j.write(bArr, i10, i11);
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] bArr, int i10, int i11) {
        this.f47602j.write(bArr, i10, i11);
        return null;
    }
}
