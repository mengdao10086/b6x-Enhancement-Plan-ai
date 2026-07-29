package cr;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public class n implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PublicKey f25840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PrivateKey f25841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PublicKey f25842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f25843d;

    public n(KeyPair keyPair, PublicKey publicKey) {
        this(keyPair.getPublic(), keyPair.getPrivate(), publicKey, null);
    }

    public n(KeyPair keyPair, PublicKey publicKey, byte[] bArr) {
        this(keyPair.getPublic(), keyPair.getPrivate(), publicKey, bArr);
    }

    public n(PrivateKey privateKey, PublicKey publicKey) {
        this(null, privateKey, publicKey, null);
    }

    public n(PrivateKey privateKey, PublicKey publicKey, byte[] bArr) {
        this(null, privateKey, publicKey, bArr);
    }

    public n(PublicKey publicKey, PrivateKey privateKey, PublicKey publicKey2) {
        this(publicKey, privateKey, publicKey2, null);
    }

    public n(PublicKey publicKey, PrivateKey privateKey, PublicKey publicKey2, byte[] bArr) {
        this.f25840a = publicKey;
        this.f25841b = privateKey;
        this.f25842c = publicKey2;
        this.f25843d = org.bouncycastle.util.a.p(bArr);
    }

    public PrivateKey a() {
        return this.f25841b;
    }

    public PublicKey b() {
        return this.f25840a;
    }

    public PublicKey c() {
        return this.f25842c;
    }

    public byte[] d() {
        return org.bouncycastle.util.a.p(this.f25843d);
    }
}
