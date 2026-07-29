package com.google.common.hash;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes7.dex */
final class FarmHashFingerprint64 extends AbstractNonStreamingHashFunction {
    public static final HashFunction FARMHASH_FINGERPRINT_64 = new FarmHashFingerprint64();
    private static final long K0 = -4348849565147123417L;
    private static final long K1 = -5435081209227447693L;
    private static final long K2 = -7286425919675154353L;

    @VisibleForTesting
    public static long fingerprint(byte[] bArr, int i10, int i11) {
        return i11 <= 32 ? i11 <= 16 ? hashLength0to16(bArr, i10, i11) : hashLength17to32(bArr, i10, i11) : i11 <= 64 ? hashLength33To64(bArr, i10, i11) : hashLength65Plus(bArr, i10, i11);
    }

    private static long hashLength0to16(byte[] bArr, int i10, int i11) {
        if (i11 >= 8) {
            long j10 = ((long) (i11 * 2)) + K2;
            long jLoad64 = LittleEndianByteArray.load64(bArr, i10) + K2;
            long jLoad642 = LittleEndianByteArray.load64(bArr, (i10 + i11) - 8);
            return hashLength16((Long.rotateRight(jLoad642, 37) * j10) + jLoad64, (Long.rotateRight(jLoad64, 25) + jLoad642) * j10, j10);
        }
        if (i11 >= 4) {
            return hashLength16(((long) i11) + ((((long) LittleEndianByteArray.load32(bArr, i10)) & 4294967295L) << 3), ((long) LittleEndianByteArray.load32(bArr, (i10 + i11) - 4)) & 4294967295L, ((long) (i11 * 2)) + K2);
        }
        if (i11 <= 0) {
            return K2;
        }
        return shiftMix((((long) ((bArr[i10] & 255) + ((bArr[(i11 >> 1) + i10] & 255) << 8))) * K2) ^ (((long) (i11 + ((bArr[i10 + (i11 - 1)] & 255) << 2))) * K0)) * K2;
    }

    private static long hashLength16(long j10, long j11, long j12) {
        long j13 = (j10 ^ j11) * j12;
        long j14 = ((j13 ^ (j13 >>> 47)) ^ j11) * j12;
        return (j14 ^ (j14 >>> 47)) * j12;
    }

    private static long hashLength17to32(byte[] bArr, int i10, int i11) {
        long j10 = ((long) (i11 * 2)) + K2;
        long jLoad64 = LittleEndianByteArray.load64(bArr, i10) * K1;
        long jLoad642 = LittleEndianByteArray.load64(bArr, i10 + 8);
        int i12 = i10 + i11;
        long jLoad643 = LittleEndianByteArray.load64(bArr, i12 - 8) * j10;
        return hashLength16((LittleEndianByteArray.load64(bArr, i12 - 16) * K2) + Long.rotateRight(jLoad64 + jLoad642, 43) + Long.rotateRight(jLoad643, 30), jLoad64 + Long.rotateRight(jLoad642 + K2, 18) + jLoad643, j10);
    }

    private static long hashLength33To64(byte[] bArr, int i10, int i11) {
        long j10 = ((long) (i11 * 2)) + K2;
        long jLoad64 = LittleEndianByteArray.load64(bArr, i10) * K2;
        long jLoad642 = LittleEndianByteArray.load64(bArr, i10 + 8);
        int i12 = i10 + i11;
        long jLoad643 = LittleEndianByteArray.load64(bArr, i12 - 8) * j10;
        long jRotateRight = Long.rotateRight(jLoad64 + jLoad642, 43) + Long.rotateRight(jLoad643, 30) + (LittleEndianByteArray.load64(bArr, i12 - 16) * K2);
        long jHashLength16 = hashLength16(jRotateRight, jLoad643 + Long.rotateRight(jLoad642 + K2, 18) + jLoad64, j10);
        long jLoad644 = LittleEndianByteArray.load64(bArr, i10 + 16) * j10;
        long jLoad645 = LittleEndianByteArray.load64(bArr, i10 + 24);
        long jLoad646 = (jRotateRight + LittleEndianByteArray.load64(bArr, i12 - 32)) * j10;
        return hashLength16(((jHashLength16 + LittleEndianByteArray.load64(bArr, i12 - 24)) * j10) + Long.rotateRight(jLoad644 + jLoad645, 43) + Long.rotateRight(jLoad646, 30), jLoad644 + Long.rotateRight(jLoad645 + jLoad64, 18) + jLoad646, j10);
    }

    private static long hashLength65Plus(byte[] bArr, int i10, int i11) {
        long jShiftMix = shiftMix(-7956866745689871395L) * K2;
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long jLoad64 = 95310865018149119L + LittleEndianByteArray.load64(bArr, i10);
        int i12 = i11 - 1;
        int i13 = i10 + ((i12 / 64) * 64);
        int i14 = i12 & 63;
        int i15 = (i13 + i14) - 63;
        long j10 = 2480279821605975764L;
        int i16 = i10;
        while (true) {
            long jRotateRight = Long.rotateRight(jLoad64 + j10 + jArr[0] + LittleEndianByteArray.load64(bArr, i16 + 8), 37) * K1;
            long jRotateRight2 = Long.rotateRight(j10 + jArr[1] + LittleEndianByteArray.load64(bArr, i16 + 48), 42) * K1;
            long j11 = jRotateRight ^ jArr2[1];
            long jLoad642 = jRotateRight2 + jArr[0] + LittleEndianByteArray.load64(bArr, i16 + 40);
            long jRotateRight3 = Long.rotateRight(jShiftMix + jArr2[0], 33) * K1;
            weakHashLength32WithSeeds(bArr, i16, jArr[1] * K1, j11 + jArr2[0], jArr);
            weakHashLength32WithSeeds(bArr, i16 + 32, jRotateRight3 + jArr2[1], jLoad642 + LittleEndianByteArray.load64(bArr, i16 + 16), jArr2);
            i16 += 64;
            if (i16 == i13) {
                long j12 = ((j11 & 255) << 1) + K1;
                jArr2[0] = jArr2[0] + ((long) i14);
                jArr[0] = jArr[0] + jArr2[0];
                jArr2[0] = jArr2[0] + jArr[0];
                long jRotateRight4 = Long.rotateRight(jRotateRight3 + jLoad642 + jArr[0] + LittleEndianByteArray.load64(bArr, i15 + 8), 37) * j12;
                long jRotateRight5 = Long.rotateRight(jLoad642 + jArr[1] + LittleEndianByteArray.load64(bArr, i15 + 48), 42) * j12;
                long j13 = jRotateRight4 ^ (jArr2[1] * 9);
                long jLoad643 = jRotateRight5 + (jArr[0] * 9) + LittleEndianByteArray.load64(bArr, i15 + 40);
                long jRotateRight6 = Long.rotateRight(j11 + jArr2[0], 33) * j12;
                weakHashLength32WithSeeds(bArr, i15, jArr[1] * j12, j13 + jArr2[0], jArr);
                weakHashLength32WithSeeds(bArr, i15 + 32, jRotateRight6 + jArr2[1], LittleEndianByteArray.load64(bArr, i15 + 16) + jLoad643, jArr2);
                return hashLength16(hashLength16(jArr[0], jArr2[0], j12) + (shiftMix(jLoad643) * K0) + j13, hashLength16(jArr[1], jArr2[1], j12) + jRotateRight6, j12);
            }
            jShiftMix = j11;
            j10 = jLoad642;
            jLoad64 = jRotateRight3;
        }
    }

    private static long shiftMix(long j10) {
        return j10 ^ (j10 >>> 47);
    }

    private static void weakHashLength32WithSeeds(byte[] bArr, int i10, long j10, long j11, long[] jArr) {
        long jLoad64 = LittleEndianByteArray.load64(bArr, i10);
        long jLoad642 = LittleEndianByteArray.load64(bArr, i10 + 8);
        long jLoad643 = LittleEndianByteArray.load64(bArr, i10 + 16);
        long jLoad644 = LittleEndianByteArray.load64(bArr, i10 + 24);
        long j12 = j10 + jLoad64;
        long j13 = jLoad642 + j12 + jLoad643;
        long jRotateRight = Long.rotateRight(j11 + j12 + jLoad644, 21) + Long.rotateRight(j13, 44);
        jArr[0] = j13 + jLoad644;
        jArr[1] = jRotateRight + j12;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    @Override // com.google.common.hash.AbstractNonStreamingHashFunction, com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr, int i10, int i11) {
        Preconditions.checkPositionIndexes(i10, i10 + i11, bArr.length);
        return HashCode.fromLong(fingerprint(bArr, i10, i11));
    }

    public String toString() {
        return "Hashing.farmHashFingerprint64()";
    }
}
