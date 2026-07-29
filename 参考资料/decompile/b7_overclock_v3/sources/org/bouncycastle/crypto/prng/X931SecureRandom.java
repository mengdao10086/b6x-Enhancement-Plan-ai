package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;
import pp.f;
import pp.l;

/* JADX INFO: loaded from: classes5.dex */
public class X931SecureRandom extends SecureRandom {
    private final l drbg;
    private final boolean predictionResistant;
    private final SecureRandom randomSource;

    public X931SecureRandom(SecureRandom secureRandom, l lVar, boolean z10) {
        this.randomSource = secureRandom;
        this.drbg = lVar;
        this.predictionResistant = z10;
    }

    @Override // java.security.SecureRandom
    public byte[] generateSeed(int i10) {
        return f.a(this.drbg.b(), i10);
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void nextBytes(byte[] bArr) {
        synchronized (this) {
            if (this.drbg.a(bArr, this.predictionResistant) < 0) {
                this.drbg.f();
                this.drbg.a(bArr, this.predictionResistant);
            }
        }
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void setSeed(long j10) {
        synchronized (this) {
            SecureRandom secureRandom = this.randomSource;
            if (secureRandom != null) {
                secureRandom.setSeed(j10);
            }
        }
    }

    @Override // java.security.SecureRandom
    public void setSeed(byte[] bArr) {
        synchronized (this) {
            SecureRandom secureRandom = this.randomSource;
            if (secureRandom != null) {
                secureRandom.setSeed(bArr);
            }
        }
    }
}
