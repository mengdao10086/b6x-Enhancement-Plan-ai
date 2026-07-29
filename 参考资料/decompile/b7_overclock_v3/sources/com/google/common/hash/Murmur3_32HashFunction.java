package com.google.common.hash;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import ee.a;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@Immutable
final class Murmur3_32HashFunction extends AbstractHashFunction implements Serializable {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final int CHUNK_SIZE = 4;
    private static final long serialVersionUID = 0;
    private final int seed;
    public static final HashFunction MURMUR3_32 = new Murmur3_32HashFunction(0);
    public static final HashFunction GOOD_FAST_HASH_32 = new Murmur3_32HashFunction(Hashing.GOOD_FAST_HASH_SEED);

    @CanIgnoreReturnValue
    public static final class Murmur3_32Hasher extends AbstractHasher {
        private long buffer;

        /* JADX INFO: renamed from: h1, reason: collision with root package name */
        private int f21226h1;
        private int shift;
        private int length = 0;
        private boolean isDone = false;

        public Murmur3_32Hasher(int i10) {
            this.f21226h1 = i10;
        }

        private void update(int i10, long j10) {
            long j11 = this.buffer;
            int i11 = this.shift;
            long j12 = ((j10 & 4294967295L) << i11) | j11;
            this.buffer = j12;
            int i12 = i11 + (i10 * 8);
            this.shift = i12;
            this.length += i10;
            if (i12 >= 32) {
                this.f21226h1 = Murmur3_32HashFunction.mixH1(this.f21226h1, Murmur3_32HashFunction.mixK1((int) j12));
                this.buffer >>>= 32;
                this.shift -= 32;
            }
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            Preconditions.checkState(!this.isDone);
            this.isDone = true;
            int iMixK1 = this.f21226h1 ^ Murmur3_32HashFunction.mixK1((int) this.buffer);
            this.f21226h1 = iMixK1;
            return Murmur3_32HashFunction.fmix(iMixK1, this.length);
        }

        @Override // com.google.common.hash.PrimitiveSink
        public Hasher putByte(byte b10) {
            update(1, b10 & 255);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public Hasher putChar(char c10) {
            update(2, c10);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public Hasher putInt(int i10) {
            update(4, i10);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public Hasher putLong(long j10) {
            update(4, (int) j10);
            update(4, j10 >>> 32);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public Hasher putString(CharSequence charSequence, Charset charset) {
            if (!Charsets.UTF_8.equals(charset)) {
                return super.putString(charSequence, charset);
            }
            int length = charSequence.length();
            int i10 = 0;
            while (true) {
                int i11 = i10 + 4;
                if (i11 > length) {
                    break;
                }
                char cCharAt = charSequence.charAt(i10);
                char cCharAt2 = charSequence.charAt(i10 + 1);
                char cCharAt3 = charSequence.charAt(i10 + 2);
                char cCharAt4 = charSequence.charAt(i10 + 3);
                if (cCharAt >= 128 || cCharAt2 >= 128 || cCharAt3 >= 128 || cCharAt4 >= 128) {
                    break;
                }
                update(4, (cCharAt2 << '\b') | cCharAt | (cCharAt3 << 16) | (cCharAt4 << 24));
                i10 = i11;
            }
            while (i10 < length) {
                char cCharAt5 = charSequence.charAt(i10);
                if (cCharAt5 < 128) {
                    update(1, cCharAt5);
                } else if (cCharAt5 < 2048) {
                    update(2, Murmur3_32HashFunction.charToTwoUtf8Bytes(cCharAt5));
                } else if (cCharAt5 < 55296 || cCharAt5 > 57343) {
                    update(3, Murmur3_32HashFunction.charToThreeUtf8Bytes(cCharAt5));
                } else {
                    int iCodePointAt = Character.codePointAt(charSequence, i10);
                    if (iCodePointAt == cCharAt5) {
                        putBytes(charSequence.subSequence(i10, length).toString().getBytes(charset));
                        return this;
                    }
                    i10++;
                    update(4, Murmur3_32HashFunction.codePointToFourUtf8Bytes(iCodePointAt));
                }
                i10++;
            }
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public Hasher putBytes(byte[] bArr, int i10, int i11) {
            Preconditions.checkPositionIndexes(i10, i10 + i11, bArr.length);
            int i12 = 0;
            while (true) {
                int i13 = i12 + 4;
                if (i13 > i11) {
                    break;
                }
                update(4, Murmur3_32HashFunction.getIntLittleEndian(bArr, i12 + i10));
                i12 = i13;
            }
            while (i12 < i11) {
                putByte(bArr[i10 + i12]);
                i12++;
            }
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.PrimitiveSink
        public Hasher putBytes(ByteBuffer byteBuffer) {
            ByteOrder byteOrderOrder = byteBuffer.order();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            while (byteBuffer.remaining() >= 4) {
                putInt(byteBuffer.getInt());
            }
            while (byteBuffer.hasRemaining()) {
                putByte(byteBuffer.get());
            }
            byteBuffer.order(byteOrderOrder);
            return this;
        }
    }

    public Murmur3_32HashFunction(int i10) {
        this.seed = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long charToThreeUtf8Bytes(char c10) {
        return (((c10 & '?') | 128) << 16) | (((c10 >>> '\f') | 480) & 255) | ((((c10 >>> 6) & 63) | 128) << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long charToTwoUtf8Bytes(char c10) {
        return (((c10 & '?') | 128) << 8) | (((c10 >>> 6) | 960) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long codePointToFourUtf8Bytes(int i10) {
        return ((((long) (i10 >>> 18)) | 240) & 255) | ((((long) ((i10 >>> 12) & 63)) | 128) << 8) | ((((long) ((i10 >>> 6) & 63)) | 128) << 16) | ((((long) (i10 & 63)) | 128) << 24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashCode fmix(int i10, int i11) {
        int i12 = i10 ^ i11;
        int i13 = (i12 ^ (i12 >>> 16)) * (-2048144789);
        int i14 = (i13 ^ (i13 >>> 13)) * (-1028477387);
        return HashCode.fromInt(i14 ^ (i14 >>> 16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getIntLittleEndian(byte[] bArr, int i10) {
        return Ints.fromBytes(bArr[i10 + 3], bArr[i10 + 2], bArr[i10 + 1], bArr[i10]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int mixH1(int i10, int i11) {
        return (Integer.rotateLeft(i10 ^ i11, 13) * 5) - 430675100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int mixK1(int i10) {
        return Integer.rotateLeft(i10 * (-862048943), 15) * 461845907;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 32;
    }

    public boolean equals(@NullableDecl Object obj) {
        return (obj instanceof Murmur3_32HashFunction) && this.seed == ((Murmur3_32HashFunction) obj).seed;
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr, int i10, int i11) {
        Preconditions.checkPositionIndexes(i10, i10 + i11, bArr.length);
        int iMixH1 = this.seed;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int i14 = i13 + 4;
            if (i14 > i11) {
                break;
            }
            iMixH1 = mixH1(iMixH1, mixK1(getIntLittleEndian(bArr, i13 + i10)));
            i13 = i14;
        }
        int i15 = i13;
        int i16 = 0;
        while (i15 < i11) {
            i12 ^= UnsignedBytes.toInt(bArr[i10 + i15]) << i16;
            i15++;
            i16 += 8;
        }
        return fmix(mixK1(i12) ^ iMixH1, i11);
    }

    public int hashCode() {
        return Murmur3_32HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashInt(int i10) {
        return fmix(mixH1(this.seed, mixK1(i10)), 4);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashLong(long j10) {
        int i10 = (int) (j10 >>> 32);
        return fmix(mixH1(mixH1(this.seed, mixK1((int) j10)), mixK1(i10)), 8);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        if (!Charsets.UTF_8.equals(charset)) {
            return hashBytes(charSequence.toString().getBytes(charset));
        }
        int length = charSequence.length();
        int iMixH1 = this.seed;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = i11 + 4;
            if (i13 > length) {
                break;
            }
            char cCharAt = charSequence.charAt(i11);
            char cCharAt2 = charSequence.charAt(i11 + 1);
            char cCharAt3 = charSequence.charAt(i11 + 2);
            char cCharAt4 = charSequence.charAt(i11 + 3);
            if (cCharAt >= 128 || cCharAt2 >= 128 || cCharAt3 >= 128 || cCharAt4 >= 128) {
                break;
            }
            iMixH1 = mixH1(iMixH1, mixK1((cCharAt2 << '\b') | cCharAt | (cCharAt3 << 16) | (cCharAt4 << 24)));
            i12 += 4;
            i11 = i13;
        }
        long jCharToThreeUtf8Bytes = 0;
        while (i11 < length) {
            char cCharAt5 = charSequence.charAt(i11);
            if (cCharAt5 < 128) {
                jCharToThreeUtf8Bytes |= ((long) cCharAt5) << i10;
                i10 += 8;
                i12++;
            } else if (cCharAt5 < 2048) {
                jCharToThreeUtf8Bytes |= charToTwoUtf8Bytes(cCharAt5) << i10;
                i10 += 16;
                i12 += 2;
            } else if (cCharAt5 < 55296 || cCharAt5 > 57343) {
                jCharToThreeUtf8Bytes |= charToThreeUtf8Bytes(cCharAt5) << i10;
                i10 += 24;
                i12 += 3;
            } else {
                int iCodePointAt = Character.codePointAt(charSequence, i11);
                if (iCodePointAt == cCharAt5) {
                    return hashBytes(charSequence.toString().getBytes(charset));
                }
                i11++;
                jCharToThreeUtf8Bytes |= codePointToFourUtf8Bytes(iCodePointAt) << i10;
                i12 += 4;
            }
            if (i10 >= 32) {
                iMixH1 = mixH1(iMixH1, mixK1((int) jCharToThreeUtf8Bytes));
                jCharToThreeUtf8Bytes >>>= 32;
                i10 -= 32;
            }
            i11++;
        }
        return fmix(mixK1((int) jCharToThreeUtf8Bytes) ^ iMixH1, i12);
    }

    @Override // com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int iMixK1 = this.seed;
        for (int i10 = 1; i10 < charSequence.length(); i10 += 2) {
            iMixK1 = mixH1(iMixK1, mixK1(charSequence.charAt(i10 - 1) | (charSequence.charAt(i10) << 16)));
        }
        if ((charSequence.length() & 1) == 1) {
            iMixK1 ^= mixK1(charSequence.charAt(charSequence.length() - 1));
        }
        return fmix(iMixK1, charSequence.length() * 2);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new Murmur3_32Hasher(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_32(" + this.seed + a.f26979d;
    }
}
