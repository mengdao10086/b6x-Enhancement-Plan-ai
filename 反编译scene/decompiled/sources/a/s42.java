package a;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class s42 extends r42 {
    public static final <T> List<T> b(T[] tArr) {
        f92.d(tArr, "$this$asList");
        List<T> listA = v42.a(tArr);
        f92.c(listA, "ArraysUtilJVM.asList(this)");
        return listA;
    }

    public static final byte[] c(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        f92.d(bArr, "$this$copyInto");
        f92.d(bArr2, "destination");
        System.arraycopy(bArr, i2, bArr2, i, i3 - i2);
        return bArr2;
    }

    public static final <T> T[] d(T[] tArr, T[] tArr2, int i, int i2, int i3) {
        f92.d(tArr, "$this$copyInto");
        f92.d(tArr2, "destination");
        System.arraycopy(tArr, i2, tArr2, i, i3 - i2);
        return tArr2;
    }

    public static /* synthetic */ Object[] e(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        d(objArr, objArr2, i, i2, i3);
        return objArr2;
    }

    public static final <T> T[] f(T[] tArr, int i, int i2) {
        f92.d(tArr, "$this$copyOfRangeImpl");
        q42.a(i2, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i, i2);
        f92.c(tArr2, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return tArr2;
    }

    public static final <T> void g(T[] tArr, Comparator<? super T> comparator) {
        f92.d(tArr, "$this$sortWith");
        f92.d(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static final Boolean[] h(boolean[] zArr) {
        f92.d(zArr, "$this$toTypedArray");
        Boolean[] boolArr = new Boolean[zArr.length];
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            boolArr[i] = Boolean.valueOf(zArr[i]);
        }
        return boolArr;
    }

    public static final Integer[] i(int[] iArr) {
        f92.d(iArr, "$this$toTypedArray");
        Integer[] numArr = new Integer[iArr.length];
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }
}
