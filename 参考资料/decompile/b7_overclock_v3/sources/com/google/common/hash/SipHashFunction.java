package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import ee.a;
import java.io.Serializable;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@Immutable
final class SipHashFunction extends AbstractHashFunction implements Serializable {
    public static final HashFunction SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f21227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f21228d;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final long f21229k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    private final long f21230k1;

    public static final class SipHasher extends AbstractStreamingHasher {
        private static final int CHUNK_SIZE = 8;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f21231b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f21232c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f21233d;
        private long finalM;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        private long f21234v0;

        /* JADX INFO: renamed from: v1, reason: collision with root package name */
        private long f21235v1;

        /* JADX INFO: renamed from: v2, reason: collision with root package name */
        private long f21236v2;

        /* JADX INFO: renamed from: v3, reason: collision with root package name */
        private long f21237v3;

        public SipHasher(int i10, int i11, long j10, long j11) {
            super(8);
            this.f21231b = 0L;
            this.finalM = 0L;
            this.f21232c = i10;
            this.f21233d = i11;
            this.f21234v0 = 8317987319222330741L ^ j10;
            this.f21235v1 = 7237128888997146477L ^ j11;
            this.f21236v2 = 7816392313619706465L ^ j10;
            this.f21237v3 = 8387220255154660723L ^ j11;
        }

        private void processM(long j10) {
            this.f21237v3 ^= j10;
            sipRound(this.f21232c);
            this.f21234v0 = j10 ^ this.f21234v0;
        }

        private void sipRound(int i10) {
            for (int i11 = 0; i11 < i10; i11++) {
                long j10 = this.f21234v0;
                long j11 = this.f21235v1;
                this.f21234v0 = j10 + j11;
                this.f21236v2 += this.f21237v3;
                this.f21235v1 = Long.rotateLeft(j11, 13);
                long jRotateLeft = Long.rotateLeft(this.f21237v3, 16);
                long j12 = this.f21235v1;
                long j13 = this.f21234v0;
                this.f21235v1 = j12 ^ j13;
                this.f21237v3 = jRotateLeft ^ this.f21236v2;
                long jRotateLeft2 = Long.rotateLeft(j13, 32);
                long j14 = this.f21236v2;
                long j15 = this.f21235v1;
                this.f21236v2 = j14 + j15;
                this.f21234v0 = jRotateLeft2 + this.f21237v3;
                this.f21235v1 = Long.rotateLeft(j15, 17);
                long jRotateLeft3 = Long.rotateLeft(this.f21237v3, 21);
                long j16 = this.f21235v1;
                long j17 = this.f21236v2;
                this.f21235v1 = j16 ^ j17;
                this.f21237v3 = jRotateLeft3 ^ this.f21234v0;
                this.f21236v2 = Long.rotateLeft(j17, 32);
            }
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public HashCode makeHash() {
            long j10 = this.finalM ^ (this.f21231b << 56);
            this.finalM = j10;
            processM(j10);
            this.f21236v2 ^= 255;
            sipRound(this.f21233d);
            return HashCode.fromLong(((this.f21234v0 ^ this.f21235v1) ^ this.f21236v2) ^ this.f21237v3);
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public void process(ByteBuffer byteBuffer) {
            this.f21231b += 8;
            processM(byteBuffer.getLong());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        public void processRemaining(ByteBuffer byteBuffer) {
            this.f21231b += (long) byteBuffer.remaining();
            int i10 = 0;
            while (byteBuffer.hasRemaining()) {
                this.finalM ^= (((long) byteBuffer.get()) & 255) << i10;
                i10 += 8;
            }
        }
    }

    public SipHashFunction(int i10, int i11, long j10, long j11) {
        Preconditions.checkArgument(i10 > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i10);
        Preconditions.checkArgument(i11 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i11);
        this.f21227c = i10;
        this.f21228d = i11;
        this.f21229k0 = j10;
        this.f21230k1 = j11;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof SipHashFunction)) {
            return false;
        }
        SipHashFunction sipHashFunction = (SipHashFunction) obj;
        return this.f21227c == sipHashFunction.f21227c && this.f21228d == sipHashFunction.f21228d && this.f21229k0 == sipHashFunction.f21229k0 && this.f21230k1 == sipHashFunction.f21230k1;
    }

    public int hashCode() {
        return (int) ((((long) ((SipHashFunction.class.hashCode() ^ this.f21227c) ^ this.f21228d)) ^ this.f21229k0) ^ this.f21230k1);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new SipHasher(this.f21227c, this.f21228d, this.f21229k0, this.f21230k1);
    }

    public String toString() {
        return "Hashing.sipHash" + this.f21227c + "" + this.f21228d + a.f26978c + this.f21229k0 + ", " + this.f21230k1 + a.f26979d;
    }
}
