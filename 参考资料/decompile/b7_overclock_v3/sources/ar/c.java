package ar;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGeneratorSpi;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.j;
import org.bouncycastle.crypto.n;
import org.bouncycastle.crypto.y;

/* JADX INFO: loaded from: classes5.dex */
public class c extends KeyGeneratorSpi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f8860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8861e = true;

    public c(String str, int i10, j jVar) {
        this.f8857a = str;
        this.f8859c = i10;
        this.f8858b = i10;
        this.f8860d = jVar;
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public SecretKey engineGenerateKey() {
        if (this.f8861e) {
            this.f8860d.b(new y(n.f(), this.f8859c));
            this.f8861e = false;
        }
        return new SecretKeySpec(this.f8860d.a(), this.f8857a);
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(int i10, SecureRandom secureRandom) {
        if (secureRandom == null) {
            try {
                secureRandom = n.f();
            } catch (IllegalArgumentException e10) {
                throw new InvalidParameterException(e10.getMessage());
            }
        }
        this.f8860d.b(new y(secureRandom, i10));
        this.f8861e = false;
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(SecureRandom secureRandom) {
        if (secureRandom != null) {
            this.f8860d.b(new y(secureRandom, this.f8859c));
            this.f8861e = false;
        }
    }

    @Override // javax.crypto.KeyGeneratorSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("Not Implemented");
    }
}
