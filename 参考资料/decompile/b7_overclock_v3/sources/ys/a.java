package ys;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.ShortBufferException;
import ns.d;
import ns.h;
import org.bouncycastle.pqc.jcajce.provider.newhope.BCNHPrivateKey;
import org.bouncycastle.pqc.jcajce.provider.newhope.BCNHPublicKey;

/* JADX INFO: loaded from: classes6.dex */
public class a extends org.bouncycastle.jcajce.provider.asymmetric.util.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ns.c f57554i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BCNHPublicKey f57555j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public d f57556k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte[] f57557l;

    public a() {
        super("NH", null);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.a
    public byte[] a() {
        return engineGenerateSecret();
    }

    @Override // javax.crypto.KeyAgreementSpi
    public Key engineDoPhase(Key key, boolean z10) throws IllegalStateException, InvalidKeyException {
        if (!z10) {
            throw new IllegalStateException("NewHope can only be between two parties.");
        }
        BCNHPublicKey bCNHPublicKey = (BCNHPublicKey) key;
        this.f57555j = bCNHPublicKey;
        d dVar = this.f57556k;
        if (dVar == null) {
            this.f57557l = this.f57554i.a(bCNHPublicKey.a());
            return null;
        }
        js.c cVarA = dVar.a((np.c) bCNHPublicKey.a());
        this.f57557l = cVarA.b();
        return new BCNHPublicKey((h) cVarA.a());
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.a, javax.crypto.KeyAgreementSpi
    public int engineGenerateSecret(byte[] bArr, int i10) throws IllegalStateException, ShortBufferException {
        byte[] bArr2 = this.f57557l;
        System.arraycopy(bArr2, 0, bArr, i10, bArr2.length);
        org.bouncycastle.util.a.d0(this.f57557l, (byte) 0);
        return this.f57557l.length;
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.a, javax.crypto.KeyAgreementSpi
    public byte[] engineGenerateSecret() throws IllegalStateException {
        byte[] bArrP = org.bouncycastle.util.a.p(this.f57557l);
        org.bouncycastle.util.a.d0(this.f57557l, (byte) 0);
        return bArrP;
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (key == null) {
            this.f57556k = new d(secureRandom);
            return;
        }
        ns.c cVar = new ns.c();
        this.f57554i = cVar;
        cVar.b(((BCNHPrivateKey) key).a());
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("NewHope does not require parameters");
    }
}
