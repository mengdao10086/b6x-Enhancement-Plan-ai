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
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible(emulated = true)
public final class Floats {
    public static final int BYTES = 4;

    @GwtCompatible
    public static class FloatArrayAsList extends AbstractList<Float> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        public final float[] array;
        public final int end;
        public final int start;

        public FloatArrayAsList(float[] fArr) {
            this(fArr, 0, fArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Float) && Floats.indexOf(this.array, ((Float) obj).floatValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FloatArrayAsList)) {
                return super.equals(obj);
            }
            FloatArrayAsList floatArrayAsList = (FloatArrayAsList) obj;
            int size = size();
            if (floatArrayAsList.size() != size) {
                return false;
            }
            for (int i10 = 0; i10 < size; i10++) {
                if (this.array[this.start + i10] != floatArrayAsList.array[floatArrayAsList.start + i10]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iHashCode = 1;
            for (int i10 = this.start; i10 < this.end; i10++) {
                iHashCode = (iHashCode * 31) + Floats.hashCode(this.array[i10]);
            }
            return iHashCode;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int iIndexOf;
            if (!(obj instanceof Float) || (iIndexOf = Floats.indexOf(this.array, ((Float) obj).floatValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iIndexOf - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int iLastIndexOf;
            if (!(obj instanceof Float) || (iLastIndexOf = Floats.lastIndexOf(this.array, ((Float) obj).floatValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iLastIndexOf - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Float> subList(int i10, int i11) {
            Preconditions.checkPositionIndexes(i10, i11, size());
            if (i10 == i11) {
                return Collections.emptyList();
            }
            float[] fArr = this.array;
            int i12 = this.start;
            return new FloatArrayAsList(fArr, i10 + i12, i12 + i11);
        }

        public float[] toFloatArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 12);
            sb2.append('[');
            sb2.append(this.array[this.start]);
            int i10 = this.start;
            while (true) {
                i10++;
                if (i10 >= this.end) {
                    sb2.append(']');
                    return sb2.toString();
                }
                sb2.append(", ");
                sb2.append(this.array[i10]);
            }
        }

        public FloatArrayAsList(float[] fArr, int i10, int i11) {
            this.array = fArr;
            this.start = i10;
            this.end = i11;
        }

        @Override // java.util.AbstractList, java.util.List
        public Float get(int i10) {
            Preconditions.checkElementIndex(i10, size());
            return Float.valueOf(this.array[this.start + i10]);
        }

        @Override // java.util.AbstractList, java.util.List
        public Float set(int i10, Float f10) {
            Preconditions.checkElementIndex(i10, size());
            float[] fArr = this.array;
            int i11 = this.start;
            float f11 = fArr[i11 + i10];
            fArr[i11 + i10] = ((Float) Preconditions.checkNotNull(f10)).floatValue();
            return Float.valueOf(f11);
        }
    }

    public static final class FloatConverter extends Converter<String, Float> implements Serializable {
        public static final FloatConverter INSTANCE = new FloatConverter();
        private static final long serialVersionUID = 1;

        private FloatConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Floats.stringConverter()";
        }

        @Override // com.google.common.base.Converter
        public String doBackward(Float f10) {
            return f10.toString();
        }

        @Override // com.google.common.base.Converter
        public Float doForward(String str) {
            return Float.valueOf(str);
        }
    }

    public enum LexicographicalComparator implements Comparator<float[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Floats.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(float[] fArr, float[] fArr2) {
            int iMin = Math.min(fArr.length, fArr2.length);
            for (int i10 = 0; i10 < iMin; i10++) {
                int iCompare = Float.compare(fArr[i10], fArr2[i10]);
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return fArr.length - fArr2.length;
        }
    }

    private Floats() {
    }

    public static List<Float> asList(float... fArr) {
        return fArr.length == 0 ? Collections.emptyList() : new FloatArrayAsList(fArr);
    }

    public static int compare(float f10, float f11) {
        return Float.compare(f10, f11);
    }

    public static float[] concat(float[]... fArr) {
        int length = 0;
        for (float[] fArr2 : fArr) {
            length += fArr2.length;
        }
        float[] fArr3 = new float[length];
        int length2 = 0;
        for (float[] fArr4 : fArr) {
            System.arraycopy(fArr4, 0, fArr3, length2, fArr4.length);
            length2 += fArr4.length;
        }
        return fArr3;
    }

    @Beta
    public static float constrainToRange(float f10, float f11, float f12) {
        Preconditions.checkArgument(f11 <= f12, "min (%s) must be less than or equal to max (%s)", Float.valueOf(f11), Float.valueOf(f12));
        return Math.min(Math.max(f10, f11), f12);
    }

    public static boolean contains(float[] fArr, float f10) {
        for (float f11 : fArr) {
            if (f11 == f10) {
                return true;
            }
        }
        return false;
    }

    public static float[] ensureCapacity(float[] fArr, int i10, int i11) {
        Preconditions.checkArgument(i10 >= 0, "Invalid minLength: %s", i10);
        Preconditions.checkArgument(i11 >= 0, "Invalid padding: %s", i11);
        return fArr.length < i10 ? Arrays.copyOf(fArr, i10 + i11) : fArr;
    }

    public static int hashCode(float f10) {
        return Float.valueOf(f10).hashCode();
    }

    public static int indexOf(float[] fArr, float f10) {
        return indexOf(fArr, f10, 0, fArr.length);
    }

    public static boolean isFinite(float f10) {
        return Float.NEGATIVE_INFINITY < f10 && f10 < Float.POSITIVE_INFINITY;
    }

    public static String join(String str, float... fArr) {
        Preconditions.checkNotNull(str);
        if (fArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(fArr.length * 12);
        sb2.append(fArr[0]);
        for (int i10 = 1; i10 < fArr.length; i10++) {
            sb2.append(str);
            sb2.append(fArr[i10]);
        }
        return sb2.toString();
    }

    public static int lastIndexOf(float[] fArr, float f10) {
        return lastIndexOf(fArr, f10, 0, fArr.length);
    }

    public static Comparator<float[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static float max(float... fArr) {
        Preconditions.checkArgument(fArr.length > 0);
        float fMax = fArr[0];
        for (int i10 = 1; i10 < fArr.length; i10++) {
            fMax = Math.max(fMax, fArr[i10]);
        }
        return fMax;
    }

    public static float min(float... fArr) {
        Preconditions.checkArgument(fArr.length > 0);
        float fMin = fArr[0];
        for (int i10 = 1; i10 < fArr.length; i10++) {
            fMin = Math.min(fMin, fArr[i10]);
        }
        return fMin;
    }

    public static void reverse(float[] fArr) {
        Preconditions.checkNotNull(fArr);
        reverse(fArr, 0, fArr.length);
    }

    public static void sortDescending(float[] fArr) {
        Preconditions.checkNotNull(fArr);
        sortDescending(fArr, 0, fArr.length);
    }

    @Beta
    public static Converter<String, Float> stringConverter() {
        return FloatConverter.INSTANCE;
    }

    public static float[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof FloatArrayAsList) {
            return ((FloatArrayAsList) collection).toFloatArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        float[] fArr = new float[length];
        for (int i10 = 0; i10 < length; i10++) {
            fArr[i10] = ((Number) Preconditions.checkNotNull(array[i10])).floatValue();
        }
        return fArr;
    }

    @Beta
    @NullableDecl
    @GwtIncompatible
    public static Float tryParse(String str) {
        if (!Doubles.FLOATING_POINT_PATTERN.matcher(str).matches()) {
            return null;
        }
        try {
            return Float.valueOf(Float.parseFloat(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOf(float[] fArr, float f10, int i10, int i11) {
        while (i10 < i11) {
            if (fArr[i10] == f10) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lastIndexOf(float[] fArr, float f10, int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            if (fArr[i12] == f10) {
                return i12;
            }
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int indexOf(float[] r5, float[] r6) {
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
            if (r0 >= r2) goto L2c
            r2 = 0
        L18:
            int r3 = r6.length
            if (r2 >= r3) goto L2b
            int r3 = r0 + r2
            r3 = r5[r3]
            r4 = r6[r2]
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 == 0) goto L28
            int r0 = r0 + 1
            goto L10
        L28:
            int r2 = r2 + 1
            goto L18
        L2b:
            return r0
        L2c:
            r5 = -1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Floats.indexOf(float[], float[]):int");
    }

    public static void reverse(float[] fArr, int i10, int i11) {
        Preconditions.checkNotNull(fArr);
        Preconditions.checkPositionIndexes(i10, i11, fArr.length);
        for (int i12 = i11 - 1; i10 < i12; i12--) {
            float f10 = fArr[i10];
            fArr[i10] = fArr[i12];
            fArr[i12] = f10;
            i10++;
        }
    }

    public static void sortDescending(float[] fArr, int i10, int i11) {
        Preconditions.checkNotNull(fArr);
        Preconditions.checkPositionIndexes(i10, i11, fArr.length);
        Arrays.sort(fArr, i10, i11);
        reverse(fArr, i10, i11);
    }
}
