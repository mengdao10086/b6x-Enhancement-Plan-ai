package moe.shizuku.manager.adb;

import android.annotation.SuppressLint;
import android.security.keystore.KeyGenParameterSpec;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.Socket;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyManagementException;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAKeyGenParameterSpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Arrays;
import java.util.Date;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.GCMParameterSpec;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509ExtendedTrustManager;
import jt.l;
import kotlin.collections.m;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.z;
import moe.shizuku.manager.adb.AdbKey;
import org.bouncycastle.operator.OperatorCreationException;
import yt.k;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public final class AdbKey {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @k
    public static final String f41450i = "AndroidKeyStore";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @k
    public static final String f41451j = "_adbkey_encryption_key_";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @k
    public static final String f41452k = "AES/GCM/NoPadding";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f41453l = 12;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f41454m = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final e f41456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final Key f41457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public final RSAPrivateKey f41458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public final RSAPublicKey f41459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public final X509Certificate f41460e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public final z f41461f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @k
    public final z f41462g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @k
    public static final a f41449h = new a(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @k
    public static final byte[] f41455n = {0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, l.f36949q, rc.a.V, l.f36949q, 9, 6, 5, rc.a.f48411c0, 14, 3, 2, 26, 5, 0, 4, 20};

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public static final class b extends X509ExtendedKeyManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public final String f41463a = "key";

        public b() {
        }

        @Override // javax.net.ssl.X509KeyManager
        @yt.l
        public String chooseClientAlias(@k String[] keyTypes, @yt.l Principal[] principalArr, @yt.l Socket socket) {
            String string;
            f0.p(keyTypes, "keyTypes");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("chooseClientAlias: keyType=");
            String string2 = Arrays.toString(keyTypes);
            f0.o(string2, "toString(this)");
            sb2.append(string2);
            sb2.append(", issuers=");
            if (principalArr != null) {
                string = Arrays.toString(principalArr);
                f0.o(string, "toString(this)");
            } else {
                string = null;
            }
            sb2.append(string);
            for (String str : keyTypes) {
                if (f0.g(str, "RSA")) {
                    return this.f41463a;
                }
            }
            return null;
        }

        @Override // javax.net.ssl.X509KeyManager
        @yt.l
        public String chooseServerAlias(@k String keyType, @yt.l Principal[] principalArr, @yt.l Socket socket) {
            f0.p(keyType, "keyType");
            return null;
        }

        @Override // javax.net.ssl.X509KeyManager
        @yt.l
        public X509Certificate[] getCertificateChain(@yt.l String str) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getCertificateChain: alias=");
            sb2.append(str);
            if (f0.g(str, this.f41463a)) {
                return new X509Certificate[]{AdbKey.this.f41460e};
            }
            return null;
        }

        @Override // javax.net.ssl.X509KeyManager
        @yt.l
        public String[] getClientAliases(@yt.l String str, @yt.l Principal[] principalArr) {
            return null;
        }

        @Override // javax.net.ssl.X509KeyManager
        @yt.l
        public PrivateKey getPrivateKey(@yt.l String str) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getPrivateKey: alias=");
            sb2.append(str);
            if (f0.g(str, this.f41463a)) {
                return AdbKey.this.f41458c;
            }
            return null;
        }

        @Override // javax.net.ssl.X509KeyManager
        @yt.l
        public String[] getServerAliases(@k String keyType, @yt.l Principal[] principalArr) {
            f0.p(keyType, "keyType");
            return null;
        }
    }

    @t0({"SMAP\nAdbKey.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdbKey.kt\nmoe/shizuku/manager/adb/AdbKey$trustManager$1\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,392:1\n26#2:393\n*S KotlinDebug\n*F\n+ 1 AdbKey.kt\nmoe/shizuku/manager/adb/AdbKey$trustManager$1\n*L\n306#1:393\n*E\n"})
    public static final class c extends X509ExtendedTrustManager {
        @Override // javax.net.ssl.X509TrustManager
        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkClientTrusted(@yt.l X509Certificate[] x509CertificateArr, @yt.l String str) {
        }

        @Override // javax.net.ssl.X509ExtendedTrustManager
        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkClientTrusted(@yt.l X509Certificate[] x509CertificateArr, @yt.l String str, @yt.l Socket socket) {
        }

        @Override // javax.net.ssl.X509ExtendedTrustManager
        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkClientTrusted(@yt.l X509Certificate[] x509CertificateArr, @yt.l String str, @yt.l SSLEngine sSLEngine) {
        }

        @Override // javax.net.ssl.X509TrustManager
        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkServerTrusted(@yt.l X509Certificate[] x509CertificateArr, @yt.l String str) {
        }

        @Override // javax.net.ssl.X509ExtendedTrustManager
        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkServerTrusted(@yt.l X509Certificate[] x509CertificateArr, @yt.l String str, @yt.l Socket socket) {
        }

        @Override // javax.net.ssl.X509ExtendedTrustManager
        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkServerTrusted(@yt.l X509Certificate[] x509CertificateArr, @yt.l String str, @yt.l SSLEngine sSLEngine) {
        }

        @Override // javax.net.ssl.X509TrustManager
        @k
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public AdbKey(@k e adbKeyStore, @k final String name) throws InvalidKeySpecException, IllegalBlockSizeException, OperatorCreationException, IOException, KeyStoreException, CertificateException, InvalidAlgorithmParameterException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException, UnrecoverableKeyException, InvalidKeyException, NoSuchProviderException, ShortBufferException {
        f0.p(adbKeyStore, "adbKeyStore");
        f0.p(name, "name");
        this.f41456a = adbKeyStore;
        Key keyJ = j();
        if (keyJ == null) {
            throw new IllegalStateException("Failed to generate encryption key with AndroidKeyManager.".toString());
        }
        this.f41457b = keyJ;
        RSAPrivateKey rSAPrivateKeyK = k();
        this.f41458c = rSAPrivateKeyK;
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(rSAPrivateKeyK.getModulus(), RSAKeyGenParameterSpec.F4));
        f0.n(publicKeyGeneratePublic, "null cannot be cast to non-null type java.security.interfaces.RSAPublicKey");
        RSAPublicKey rSAPublicKey = (RSAPublicKey) publicKeyGeneratePublic;
        this.f41459d = rSAPublicKey;
        Certificate certificateGenerateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(new p000do.j(new xn.d("CN=00"), BigInteger.ONE, new Date(0L), new Date(2461449600000L), new xn.d("CN=00"), c1.A(rSAPublicKey.getEncoded())).e(new org.bouncycastle.operator.jcajce.b("SHA256withRSA").b(rSAPrivateKeyK)).getEncoded()));
        f0.n(certificateGenerateCertificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
        this.f41460e = (X509Certificate) certificateGenerateCertificate;
        rSAPrivateKeyK.toString();
        this.f41461f = d.d(new ik.a<byte[]>() { // from class: moe.shizuku.manager.adb.AdbKey$adbPublicKey$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final byte[] o() {
                return d.b(this.this$0.f41459d, name);
            }
        });
        this.f41462g = d.d(new ik.a<SSLContext>() { // from class: moe.shizuku.manager.adb.AdbKey$sslContext$2
            {
                super(0);
            }

            @Override // ik.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final SSLContext o() throws NoSuchAlgorithmException, KeyManagementException {
                SSLContext sSLContext = SSLContext.getInstance("TLSv1.3");
                sSLContext.init(new AdbKey.b[]{this.this$0.i()}, new AdbKey.c[]{this.this$0.m()}, new SecureRandom());
                return sSLContext;
            }
        });
    }

    public final byte[] f(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (bArr.length < 28) {
            return null;
        }
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, bArr, 0, 12);
        Cipher cipher = Cipher.getInstance(f41452k);
        cipher.init(2, this.f41457b, gCMParameterSpec);
        cipher.updateAAD(bArr2);
        return cipher.doFinal(bArr, 12, bArr.length - 12);
    }

    public final byte[] g(byte[] bArr, byte[] bArr2) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, ShortBufferException {
        if (bArr.length > 2147483619) {
            return null;
        }
        byte[] bArr3 = new byte[bArr.length + 12 + 16];
        Cipher cipher = Cipher.getInstance(f41452k);
        cipher.init(1, this.f41457b);
        cipher.updateAAD(bArr2);
        cipher.doFinal(bArr, 0, bArr.length, bArr3, 12);
        System.arraycopy(cipher.getIV(), 0, bArr3, 0, 12);
        return bArr3;
    }

    @k
    public final byte[] h() {
        return (byte[]) this.f41461f.getValue();
    }

    public final b i() {
        return new b();
    }

    public final Key j() throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyStore keyStore = KeyStore.getInstance(f41450i);
        keyStore.load(null);
        Key key = keyStore.getKey(f41451j, null);
        if (key != null) {
            return key;
        }
        KeyGenParameterSpec keyGenParameterSpecBuild = new KeyGenParameterSpec.Builder(f41451j, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).build();
        f0.o(keyGenParameterSpecBuild, "Builder(\n               …\n                .build()");
        KeyGenerator keyGenerator = KeyGenerator.getInstance(m5.b.f40641c, f41450i);
        keyGenerator.init(keyGenParameterSpecBuild);
        return keyGenerator.generateKey();
    }

    public final RSAPrivateKey k() throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, ShortBufferException {
        RSAPrivateKey rSAPrivateKey;
        byte[] bArr = new byte[16];
        byte[] bytes = "adbkey".getBytes(kotlin.text.d.f38161b);
        f0.o(bytes, "this as java.lang.String).getBytes(charset)");
        m.f1(bytes, bArr, 0, 0, 0, 14, null);
        byte[] bArr2 = this.f41456a.get();
        if (bArr2 != null) {
            try {
                PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(f(bArr2, bArr)));
                f0.n(privateKeyGeneratePrivate, "null cannot be cast to non-null type java.security.interfaces.RSAPrivateKey");
                rSAPrivateKey = (RSAPrivateKey) privateKeyGeneratePrivate;
            } catch (Exception unused) {
                rSAPrivateKey = null;
            }
        } else {
            rSAPrivateKey = null;
        }
        if (rSAPrivateKey == null) {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(new RSAKeyGenParameterSpec(2048, RSAKeyGenParameterSpec.F4));
            PrivateKey privateKey = keyPairGenerator.generateKeyPair().getPrivate();
            f0.n(privateKey, "null cannot be cast to non-null type java.security.interfaces.RSAPrivateKey");
            rSAPrivateKey = (RSAPrivateKey) privateKey;
            byte[] encoded = rSAPrivateKey.getEncoded();
            f0.o(encoded, "privateKey.encoded");
            byte[] bArrG = g(encoded, bArr);
            if (bArrG != null) {
                this.f41456a.a(bArrG);
            }
        }
        return rSAPrivateKey;
    }

    @k
    public final SSLContext l() {
        Object value = this.f41462g.getValue();
        f0.o(value, "<get-sslContext>(...)");
        return (SSLContext) value;
    }

    public final c m() {
        return new c();
    }

    @k
    public final byte[] n(@yt.l byte[] bArr) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
        cipher.init(1, this.f41458c);
        cipher.update(f41455n);
        byte[] bArrDoFinal = cipher.doFinal(bArr);
        f0.o(bArrDoFinal, "cipher.doFinal(data)");
        return bArrDoFinal;
    }
}
