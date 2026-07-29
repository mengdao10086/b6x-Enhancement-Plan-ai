package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.jvm.internal.r0;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible(emulated = true)
public final class Shorts {
    public static final int BYTES = 2;
    public static final short MAX_POWER_OF_TWO = 16384;

    public enum LexicographicalComparator implements Comparator<short[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Shorts.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(short[] sArr, short[] sArr2) {
            int iMin = Math.min(sArr.length, sArr2.length);
            for (int i10 = 0; i10 < iMin; i10++) {
                int iCompare = Shorts.compare(sArr[i10], sArr2[i10]);
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return sArr.length - sArr2.length;
        }
    }

    @GwtCompatible
    public static class ShortArrayAsList extends AbstractList<Short> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        public final short[] array;
        public final int end;
        public final int start;

        public ShortArrayAsList(short[] sArr) {
            this(sArr, 0, sArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@NullableDecl Object obj) {
            return (obj instanceof Short) && Shorts.indexOf(this.array, ((Short) obj).shortValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ShortArrayAsList)) {
                return super.equals(obj);
            }
            ShortArrayAsList shortArrayAsList = (ShortArrayAsList) obj;
            int size = size();
            if (shortArrayAsList.size() != size) {
                return false;
            }
            for (int i10 = 0; i10 < size; i10++) {
                if (this.array[this.start + i10] != shortArrayAsList.array[shortArrayAsList.start + i10]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iHashCode = 1;
            for (int i10 = this.start; i10 < this.end; i10++) {
                iHashCode = (iHashCode * 31) + Shorts.hashCode(this.array[i10]);
            }
            return iHashCode;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@NullableDecl Object obj) {
            int iIndexOf;
            if (!(obj instanceof Short) || (iIndexOf = Shorts.indexOf(this.array, ((Short) obj).shortValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iIndexOf - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@NullableDecl Object obj) {
            int iLastIndexOf;
            if (!(obj instanceof Short) || (iLastIndexOf = Shorts.lastIndexOf(this.array, ((Short) obj).shortValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iLastIndexOf - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Short> subList(int i10, int i11) {
            Preconditions.checkPositionIndexes(i10, i11, size());
            if (i10 == i11) {
                return Collections.emptyList();
            }
            short[] sArr = this.array;
            int i12 = this.start;
            return new ShortArrayAsList(sArr, i10 + i12, i12 + i11);
        }

        public short[] toShortArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 6);
            sb2.append('[');
            sb2.append((int) this.array[this.start]);
            int i10 = this.start;
            while (true) {
                i10++;
                if (i10 >= this.end) {
                    sb2.append(']');
                    return sb2.toString();
                }
                sb2.append(", ");
                sb2.append((int) this.array[i10]);
            }
        }

        public ShortArrayAsList(short[] sArr, int i10, int i11) {
            this.array = sArr;
            this.start = i10;
            this.end = i11;
        }

        @Override // java.util.AbstractList, java.util.List
        public Short get(int i10) {
            Preconditions.checkElementIndex(i10, size());
            return Short.valueOf(this.array[this.start + i10]);
        }

        @Override // java.util.AbstractList, java.util.List
        public Short set(int i10, Short sh2) {
            Preconditions.checkElementIndex(i10, size());
            short[] sArr = this.array;
            int i11 = this.start;
            short s10 = sArr[i11 + i10];
            sArr[i11 + i10] = ((Short) Preconditions.checkNotNull(sh2)).shortValue();
            return Short.valueOf(s10);
        }
    }

    public static final class ShortConverter extends Converter<String, Short> implements Serializable {
        public static final ShortConverter INSTANCE = new ShortConverter();
        private static final long serialVersionUID = 1;

        private ShortConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Shorts.stringConverter()";
        }

        @Override // com.google.common.base.Converter
        public String doBackward(Short sh2) {
            return sh2.toString();
        }

        @Override // com.google.common.base.Converter
        public Short doForward(String str) {
            return Short.decode(str);
        }
    }

    private Shorts() {
    }

    public static List<Short> asList(short... sArr) {
        return sArr.length == 0 ? Collections.emptyList() : new ShortArrayAsList(sArr);
    }

    public static short checkedCast(long j10) {
        short s10 = (short) j10;
        Preconditions.checkArgument(((long) s10) == j10, "Out of range: %s", j10);
        return s10;
    }

    public static int compare(short s10, short s11) {
        return s10 - s11;
    }

    public static short[] concat(short[]... sArr) {
        int length = 0;
        for (short[] sArr2 : sArr) {
            length += sArr2.length;
        }
        short[] sArr3 = new short[length];
        int length2 = 0;
        for (short[] sArr4 : sArr) {
            System.arraycopy(sArr4, 0, sArr3, length2, sArr4.length);
            length2 += sArr4.length;
        }
        return sArr3;
    }

    @Beta
    public static short constrainToRange(short s10, short s11, short s12) {
        Preconditions.checkArgument(s11 <= s12, "min (%s) must be less than or equal to max (%s)", (int) s11, (int) s12);
        return s10 < s11 ? s11 : s10 < s12 ? s10 : s12;
    }

    public static boolean contains(short[] sArr, short s10) {
        for (short s11 : sArr) {
            if (s11 == s10) {
                return true;
            }
        }
        return false;
    }

    public static short[] ensureCapacity(short[] sArr, int i10, int i11) {
        Preconditions.checkArgument(i10 >= 0, "Invalid minLength: %s", i10);
        Preconditions.checkArgument(i11 >= 0, "Invalid padding: %s", i11);
        return sArr.length < i10 ? Arrays.copyOf(sArr, i10 + i11) : sArr;
    }

    @GwtIncompatible
    public static short fromByteArray(byte[] bArr) {
        Preconditions.checkArgument(bArr.length >= 2, "array too small: %s < %s", bArr.length, 2);
        return fromBytes(bArr[0], bArr[1]);
    }

    @GwtIncompatible
    public static short fromBytes(byte b10, byte b11) {
        return (short) ((b10 << 8) | (b11 & 255));
    }

    public static int hashCode(short s10) {
        return s10;
    }

    public static int indexOf(short[] sArr, short s10) {
        return indexOf(sArr, s10, 0, sArr.length);
    }

    public static String join(String str, short... sArr) {
        Preconditions.checkNotNull(str);
        if (sArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(sArr.length * 6);
        sb2.append((int) sArr[0]);
        for (int i10 = 1; i10 < sArr.length; i10++) {
            sb2.append(str);
            sb2.append((int) sArr[i10]);
        }
        return sb2.toString();
    }

    public static int lastIndexOf(short[] sArr, short s10) {
        return lastIndexOf(sArr, s10, 0, sArr.length);
    }

    public static Comparator<short[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static short max(short... sArr) {
        Preconditions.checkArgument(sArr.length > 0);
        short s10 = sArr[0];
        for (int i10 = 1; i10 < sArr.length; i10++) {
            if (sArr[i10] > s10) {
                s10 = sArr[i10];
            }
        }
        return s10;
    }

    public static short min(short... sArr) {
        Preconditions.checkArgument(sArr.length > 0);
        short s10 = sArr[0];
        for (int i10 = 1; i10 < sArr.length; i10++) {
            if (sArr[i10] < s10) {
                s10 = sArr[i10];
            }
        }
        return s10;
    }

    public static void reverse(short[] sArr) {
        Preconditions.checkNotNull(sArr);
        reverse(sArr, 0, sArr.length);
    }

    public static short saturatedCast(long j10) {
        return j10 > 32767 ? r0.f37942c : j10 < -32768 ? r0.f37941b : (short) j10;
    }

    public static void sortDescending(short[] sArr) {
        Preconditions.checkNotNull(sArr);
        sortDescending(sArr, 0, sArr.length);
    }

    @Beta
    public static Converter<String, Short> stringConverter() {
        return ShortConverter.INSTANCE;
    }

    public static short[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof ShortArrayAsList) {
            return ((ShortArrayAsList) collection).toShortArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        short[] sArr = new short[length];
        for (int i10 = 0; i10 < length; i10++) {
            sArr[i10] = ((Number) Preconditions.checkNotNull(array[i10])).shortValue();
        }
        return sArr;
    }

    @GwtIncompatible
    public static byte[] toByteArray(short s10) {
        return new byte[]{(byte) (s10 >> 8), (byte) s10};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOf(short[] sArr, short s10, int i10, int i11) {
        while (i10 < i11) {
            if (sArr[i10] == s10) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lastIndexOf(short[] sArr, short s10, int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            if (sArr[i12] == s10) {
                return i12;
            }
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int indexOf(short[] r5, short[] r6) {
        /*
            java.lang.String r0 = "array"
            com.google.common.base.Preconditions.checkNotNull(r5, r0)
            java.lang.String r0 = "target"
            com.google.common.base.Preconditions.checkNotNull(r6, r0)
            int r0 = r6.length
            r1 = 0
            if (r0 != 0) goto Lf
            return r1
        Lf:
            r0 = 0
        L10:
            int r2 = r5.length
            int r3 = r6.length
            int r2 = r2 - r3
            int r2 = r2 + 1
            if (r0 >= r2) goto L2a
            r2 = 0
        L18:
            int r3 = r6.length
            if (r2 >= r3) goto L29
            int r3 = r0 + r2
            short r3 = r5[r3]
            short r4 = r6[r2]
            if (r3 == r4) goto L26
            int r0 = r0 + 1
            goto L10
        L26:
            int r2 = r2 + 1
            goto L18
        L29:
            return r0
        L2a:
            r5 = -1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Shorts.indexOf(short[], short[]):int");
    }

    public static void reverse(short[] sArr, int i10, int i11) {
        Preconditions.checkNotNull(sArr);
        Preconditions.checkPositionIndexes(i10, i11, sArr.length);
        for (int i12 = i11 - 1; i10 < i12; i12--) {
            short s10 = sArr[i10];
            sArr[i10] = sArr[i12];
            sArr[i12] = s10;
            i10++;
        }
    }

    public static void sortDescending(short[] sArr, int i10, int i11) {
        Preconditions.checkNotNull(sArr);
        Preconditions.checkPositionIndexes(i10, i11, sArr.length);
        Arrays.sort(sArr, i10, i11);
        reverse(sArr, i10, i11);
    }
}
