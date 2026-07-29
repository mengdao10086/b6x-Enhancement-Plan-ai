package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.hash.BloomFilterStrategies;
import com.google.common.math.DoubleMath;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@Beta
public final class BloomFilter<T> implements Predicate<T>, Serializable {
    private final BloomFilterStrategies.LockFreeBitArray bits;
    private final Funnel<? super T> funnel;
    private final int numHashFunctions;
    private final Strategy strategy;

    public static class SerialForm<T> implements Serializable {
        private static final long serialVersionUID = 1;
        public final long[] data;
        public final Funnel<? super T> funnel;
        public final int numHashFunctions;
        public final Strategy strategy;

        public SerialForm(BloomFilter<T> bloomFilter) {
            this.data = BloomFilterStrategies.LockFreeBitArray.toPlainArray(((BloomFilter) bloomFilter).bits.data);
            this.numHashFunctions = ((BloomFilter) bloomFilter).numHashFunctions;
            this.funnel = ((BloomFilter) bloomFilter).funnel;
            this.strategy = ((BloomFilter) bloomFilter).strategy;
        }

        public Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.LockFreeBitArray(this.data), this.numHashFunctions, this.funnel, this.strategy);
        }
    }

    public interface Strategy extends Serializable {
        <T> boolean mightContain(T t10, Funnel<? super T> funnel, int i10, BloomFilterStrategies.LockFreeBitArray lockFreeBitArray);

        int ordinal();

        <T> boolean put(T t10, Funnel<? super T> funnel, int i10, BloomFilterStrategies.LockFreeBitArray lockFreeBitArray);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i10, double d10) {
        return create(funnel, i10, d10);
    }

    @VisibleForTesting
    public static long optimalNumOfBits(long j10, double d10) {
        if (d10 == 0.0d) {
            d10 = Double.MIN_VALUE;
        }
        return (long) (((-j10) * Math.log(d10)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    @VisibleForTesting
    public static int optimalNumOfHashFunctions(long j10, long j11) {
        return Math.max(1, (int) Math.round((j11 / j10) * Math.log(2.0d)));
    }

    public static <T> BloomFilter<T> readFrom(InputStream inputStream, Funnel<? super T> funnel) throws IOException {
        int i10;
        int i11;
        int i12;
        Preconditions.checkNotNull(inputStream, "InputStream");
        Preconditions.checkNotNull(funnel, "Funnel");
        byte b10 = -1;
        try {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            byte b11 = dataInputStream.readByte();
            try {
                i11 = UnsignedBytes.toInt(dataInputStream.readByte());
            } catch (RuntimeException e10) {
                e = e10;
                i11 = -1;
            }
            try {
                i12 = dataInputStream.readInt();
            } catch (RuntimeException e11) {
                e = e11;
                b10 = b11;
                i10 = -1;
                throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b10) + " numHashFunctions: " + i11 + " dataLength: " + i10, e);
            }
            try {
                BloomFilterStrategies bloomFilterStrategies = BloomFilterStrategies.values()[b11];
                long[] jArr = new long[i12];
                for (int i13 = 0; i13 < i12; i13++) {
                    jArr[i13] = dataInputStream.readLong();
                }
                return new BloomFilter<>(new BloomFilterStrategies.LockFreeBitArray(jArr), i11, funnel, bloomFilterStrategies);
            } catch (RuntimeException e12) {
                e = e12;
                b10 = b11;
                i10 = i12;
                throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b10) + " numHashFunctions: " + i11 + " dataLength: " + i10, e);
            }
        } catch (RuntimeException e13) {
            e = e13;
            i10 = -1;
            i11 = -1;
        }
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    public boolean apply(T t10) {
        return mightContain(t10);
    }

    public long approximateElementCount() {
        double dBitSize = this.bits.bitSize();
        return DoubleMath.roundToLong(((-Math.log1p(-(this.bits.bitCount() / dBitSize))) * dBitSize) / ((double) this.numHashFunctions), RoundingMode.HALF_UP);
    }

    @VisibleForTesting
    public long bitSize() {
        return this.bits.bitSize();
    }

    public BloomFilter<T> copy() {
        return new BloomFilter<>(this.bits.copy(), this.numHashFunctions, this.funnel, this.strategy);
    }

    @Override // com.google.common.base.Predicate
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BloomFilter)) {
            return false;
        }
        BloomFilter bloomFilter = (BloomFilter) obj;
        return this.numHashFunctions == bloomFilter.numHashFunctions && this.funnel.equals(bloomFilter.funnel) && this.bits.equals(bloomFilter.bits) && this.strategy.equals(bloomFilter.strategy);
    }

    public double expectedFpp() {
        return Math.pow(this.bits.bitCount() / bitSize(), this.numHashFunctions);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits);
    }

    public boolean isCompatible(BloomFilter<T> bloomFilter) {
        Preconditions.checkNotNull(bloomFilter);
        return this != bloomFilter && this.numHashFunctions == bloomFilter.numHashFunctions && bitSize() == bloomFilter.bitSize() && this.strategy.equals(bloomFilter.strategy) && this.funnel.equals(bloomFilter.funnel);
    }

    public boolean mightContain(T t10) {
        return this.strategy.mightContain(t10, this.funnel, this.numHashFunctions, this.bits);
    }

    @CanIgnoreReturnValue
    public boolean put(T t10) {
        return this.strategy.put(t10, this.funnel, this.numHashFunctions, this.bits);
    }

    public void putAll(BloomFilter<T> bloomFilter) {
        Preconditions.checkNotNull(bloomFilter);
        Preconditions.checkArgument(this != bloomFilter, "Cannot combine a BloomFilter with itself.");
        int i10 = this.numHashFunctions;
        int i11 = bloomFilter.numHashFunctions;
        Preconditions.checkArgument(i10 == i11, "BloomFilters must have the same number of hash functions (%s != %s)", i10, i11);
        Preconditions.checkArgument(bitSize() == bloomFilter.bitSize(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", bitSize(), bloomFilter.bitSize());
        Preconditions.checkArgument(this.strategy.equals(bloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, bloomFilter.strategy);
        Preconditions.checkArgument(this.funnel.equals(bloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, bloomFilter.funnel);
        this.bits.putAll(bloomFilter.bits);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeByte(SignedBytes.checkedCast(this.strategy.ordinal()));
        dataOutputStream.writeByte(UnsignedBytes.checkedCast(this.numHashFunctions));
        dataOutputStream.writeInt(this.bits.data.length());
        for (int i10 = 0; i10 < this.bits.data.length(); i10++) {
            dataOutputStream.writeLong(this.bits.data.get(i10));
        }
    }

    private BloomFilter(BloomFilterStrategies.LockFreeBitArray lockFreeBitArray, int i10, Funnel<? super T> funnel, Strategy strategy) {
        Preconditions.checkArgument(i10 > 0, "numHashFunctions (%s) must be > 0", i10);
        Preconditions.checkArgument(i10 <= 255, "numHashFunctions (%s) must be <= 255", i10);
        this.bits = (BloomFilterStrategies.LockFreeBitArray) Preconditions.checkNotNull(lockFreeBitArray);
        this.numHashFunctions = i10;
        this.funnel = (Funnel) Preconditions.checkNotNull(funnel);
        this.strategy = (Strategy) Preconditions.checkNotNull(strategy);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j10, double d10) {
        return create(funnel, j10, d10, BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    @VisibleForTesting
    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j10, double d10, Strategy strategy) {
        Preconditions.checkNotNull(funnel);
        Preconditions.checkArgument(j10 >= 0, "Expected insertions (%s) must be >= 0", j10);
        Preconditions.checkArgument(d10 > 0.0d, "False positive probability (%s) must be > 0.0", Double.valueOf(d10));
        Preconditions.checkArgument(d10 < 1.0d, "False positive probability (%s) must be < 1.0", Double.valueOf(d10));
        Preconditions.checkNotNull(strategy);
        if (j10 == 0) {
            j10 = 1;
        }
        long jOptimalNumOfBits = optimalNumOfBits(j10, d10);
        try {
            return new BloomFilter<>(new BloomFilterStrategies.LockFreeBitArray(jOptimalNumOfBits), optimalNumOfHashFunctions(j10, jOptimalNumOfBits), funnel, strategy);
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException("Could not create BloomFilter of " + jOptimalNumOfBits + " bits", e10);
        }
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i10) {
        return create(funnel, i10);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j10) {
        return create(funnel, j10, 0.03d);
    }
}
