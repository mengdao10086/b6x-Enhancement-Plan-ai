package cr;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public class f implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PublicKey f25809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PrivateKey f25810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PublicKey f25811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f25812d;

    public f(KeyPair keyPair, PublicKey publicKey) {
        this(keyPair.getPublic(), keyPair.getPrivate(), publicKey, null);
    }

    public f(KeyPair keyPair, PublicKey publicKey, byte[] bArr) {
        this(keyPair.getPublic(), keyPair.getPrivate(), publicKey, bArr);
    }

    public f(PrivateKey privateKey, PublicKey publicKey) {
        this(null, privateKey, publicKey, null);
    }

    public f(PrivateKey privateKey, PublicKey publicKey, byte[] bArr) {
        this(null, privateKey, publicKey, bArr);
    }

    public f(PublicKey publicKey, PrivateKey privateKey, PublicKey publicKey2) {
        this(publicKey, privateKey, publicKey2, null);
    }

    public f(PublicKey publicKey, PrivateKey privateKey, PublicKey publicKey2, byte[] bArr) {
        if (privateKey == null) {
            throw new IllegalArgumentException("ephemeral private key cannot be null");
        }
        if (publicKey2 == null) {
            throw new IllegalArgumentException("other party ephemeral key cannot be null");
        }
        this.f25809a = publicKey;
        this.f25810b = privateKey;
        this.f25811c = publicKey2;
        this.f25812d = org.bouncycastle.util.a.p(bArr);
    }

    public PrivateKey a() {
        return this.f25810b;
    }

    public PublicKey b() {
        return this.f25809a;
    }

    public PublicKey c() {
        return this.f25811c;
    }

    public byte[] d() {
        return org.bouncycastle.util.a.p(this.f25812d);
    }
}
