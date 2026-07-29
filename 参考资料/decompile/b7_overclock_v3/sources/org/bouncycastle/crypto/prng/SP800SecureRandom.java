package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;
import pp.b;
import pp.d;
import qp.f;

/* JADX INFO: loaded from: classes5.dex */
public class SP800SecureRandom extends SecureRandom {
    private f drbg;
    private final b drbgProvider;
    private final d entropySource;
    private final boolean predictionResistant;
    private final SecureRandom randomSource;

    public SP800SecureRandom(SecureRandom secureRandom, d dVar, b bVar, boolean z10) {
        this.randomSource = secureRandom;
        this.entropySource = dVar;
        this.drbgProvider = bVar;
        this.predictionResistant = z10;
    }

    public void a(byte[] bArr) {
        synchronized (this) {
            if (this.drbg == null) {
                this.drbg = this.drbgProvider.a(this.entropySource);
            }
            this.drbg.a(bArr);
        }
    }

    @Override // java.security.SecureRandom
    public byte[] generateSeed(int i10) {
        return pp.f.a(this.entropySource, i10);
    }

    @Override // java.security.SecureRandom
    public String getAlgorithm() {
        return this.drbgProvider.getAlgorithm();
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void nextBytes(byte[] bArr) {
        synchronized (this) {
            if (this.drbg == null) {
                this.drbg = this.drbgProvider.a(this.entropySource);
            }
            if (this.drbg.b(bArr, null, this.predictionResistant) < 0) {
                this.drbg.a(null);
                this.drbg.b(bArr, null, this.predictionResistant);
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
