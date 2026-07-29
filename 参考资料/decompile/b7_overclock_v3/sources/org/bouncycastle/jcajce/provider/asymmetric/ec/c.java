package org.bouncycastle.jcajce.provider.asymmetric.ec;

import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
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
import np.w1;
import org.bouncycastle.crypto.engines.SM2Engine;
import org.bouncycastle.crypto.n;
import org.bouncycastle.jcajce.provider.util.BadBlockException;
import org.bouncycastle.util.Strings;
import zo.c0;
import zo.d0;
import zo.e0;
import zo.f0;
import zo.h0;
import zo.q0;
import zo.u;
import zo.z;

/* JADX INFO: loaded from: classes7.dex */
public class c extends CipherSpi {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SM2Engine f44933b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public np.c f44936e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SecureRandom f44937f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f44932a = new org.bouncycastle.jcajce.util.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f44934c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f44935d = new a();

    public static final class a extends ByteArrayOutputStream {
        public void a() {
            org.bouncycastle.util.a.d0(((ByteArrayOutputStream) this).buf, (byte) 0);
            reset();
        }

        public byte[] c() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public static class b extends c {
        public b() {
            super(new SM2Engine());
        }
    }

    /* JADX INFO: renamed from: org.bouncycastle.jcajce.provider.asymmetric.ec.c$c, reason: collision with other inner class name */
    public static class C0505c extends c {
        public C0505c() {
            super(new SM2Engine(new zo.a(512)));
        }
    }

    public static class d extends c {
        public d() {
            super(new SM2Engine(new zo.b(256)));
        }
    }

    public static class e extends c {
        public e() {
            super(new SM2Engine(new u()));
        }
    }

    public static class f extends c {
        public f() {
            super(new SM2Engine(new z()));
        }
    }

    public static class g extends c {
        public g() {
            super(new SM2Engine(new c0()));
        }
    }

    public static class h extends c {
        public h() {
            super(new SM2Engine(new d0()));
        }
    }

    public static class i extends c {
        public i() {
            super(new SM2Engine(new e0()));
        }
    }

    public static class j extends c {
        public j() {
            super(new SM2Engine(new f0()));
        }
    }

    public static class k extends c {
        public k() {
            super(new SM2Engine(new h0()));
        }
    }

    public static class l extends c {
        public l() {
            super(new SM2Engine(new q0()));
        }
    }

    public c(SM2Engine sM2Engine) {
        this.f44933b = sM2Engine;
    }

    @Override // javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        byte[] bArrEngineDoFinal = engineDoFinal(bArr, i10, i11);
        System.arraycopy(bArrEngineDoFinal, 0, bArr2, i12, bArrEngineDoFinal.length);
        return bArrEngineDoFinal.length;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i10, int i11) throws BadPaddingException, IllegalBlockSizeException {
        byte[] bArrJ;
        if (i11 != 0) {
            this.f44935d.write(bArr, i10, i11);
        }
        try {
            int i12 = this.f44934c;
            if (i12 == 1 || i12 == 3) {
                try {
                    this.f44933b.f(true, new w1(this.f44936e, this.f44937f));
                    bArrJ = this.f44933b.j(this.f44935d.c(), 0, this.f44935d.size());
                } catch (Exception e10) {
                    throw new BadBlockException("unable to process block", e10);
                }
            } else {
                if (i12 != 2 && i12 != 4) {
                    throw new IllegalStateException("cipher not initialised");
                }
                try {
                    this.f44933b.f(false, this.f44936e);
                    bArrJ = this.f44933b.j(this.f44935d.c(), 0, this.f44935d.size());
                } catch (Exception e11) {
                    throw new BadBlockException("unable to process block", e11);
                }
            }
            return bArrJ;
        } finally {
            this.f44935d.a();
        }
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineGetIV() {
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
        int i11 = this.f44934c;
        if (i11 == 1 || i11 == 3 || i11 == 2 || i11 == 4) {
            return this.f44933b.e(i10);
        }
        throw new IllegalStateException("cipher not initialised");
    }

    @Override // javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i10, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameters == null) {
            engineInit(i10, key, (AlgorithmParameterSpec) null, secureRandom);
            return;
        }
        throw new InvalidAlgorithmParameterException("cannot recognise parameters: " + algorithmParameters.getClass().getName());
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
        np.c cVarA;
        if (i10 == 1 || i10 == 3) {
            if (!(key instanceof PublicKey)) {
                throw new InvalidKeyException("must be passed public EC key for encryption");
            }
            cVarA = org.bouncycastle.jcajce.provider.asymmetric.ec.b.a((PublicKey) key);
        } else {
            if (i10 != 2 && i10 != 4) {
                throw new InvalidKeyException("must be passed EC key");
            }
            if (!(key instanceof PrivateKey)) {
                throw new InvalidKeyException("must be passed private EC key for decryption");
            }
            cVarA = org.bouncycastle.jcajce.provider.asymmetric.util.i.c((PrivateKey) key);
        }
        this.f44936e = cVarA;
        if (secureRandom != null) {
            this.f44937f = secureRandom;
        } else {
            this.f44937f = n.f();
        }
        this.f44934c = i10;
        this.f44935d.reset();
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        if (Strings.o(str).equals(HlsPlaylistParser.M)) {
            return;
        }
        throw new IllegalArgumentException("can't support mode " + str);
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        if (!Strings.o(str).equals("NOPADDING")) {
            throw new NoSuchPaddingException("padding not available with IESCipher");
        }
    }

    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        this.f44935d.write(bArr, i10, i11);
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] bArr, int i10, int i11) {
        this.f44935d.write(bArr, i10, i11);
        return null;
    }
}
