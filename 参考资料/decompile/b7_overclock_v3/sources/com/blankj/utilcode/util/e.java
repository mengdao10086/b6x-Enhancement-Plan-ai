package com.blankj.utilcode.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11752a = -1;

    public interface a<E> {
        void a(int i10, E e10);
    }

    public e() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static <T> T[] A(T[] tArr, T t10) {
        return (T[]) ((Object[]) v1(tArr, t10, tArr != null ? tArr.getClass() : t10 != null ? t10.getClass() : Object.class));
    }

    public static int A0(double[] dArr, double d10, int i10, double d11) {
        if (N0(dArr)) {
            return -1;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        double d12 = d10 - d11;
        double d13 = d10 + d11;
        while (i10 < dArr.length) {
            if (dArr[i10] >= d12 && dArr[i10] <= d13) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static char[] A1(char[] cArr, int i10) {
        return (char[]) y1(cArr, i10);
    }

    public static byte[] A2(Byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr2[i10] = bArr[i10].byteValue();
        }
        return bArr2;
    }

    public static <T> T[] B(T[] tArr, T[] tArr2) {
        return (T[]) ((Object[]) u1(tArr, tArr2));
    }

    public static int B0(float[] fArr, float f10) {
        return C0(fArr, f10, 0);
    }

    public static double[] B1(double[] dArr, int i10) {
        return (double[]) y1(dArr, i10);
    }

    public static byte[] B2(Byte[] bArr, byte b10) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            Byte b11 = bArr[i10];
            bArr2[i10] = b11 == null ? b10 : b11.byteValue();
        }
        return bArr2;
    }

    public static short[] C(short[] sArr, int i10, short s10) {
        return (short[]) s1(sArr, i10, Short.valueOf(s10), Short.TYPE);
    }

    public static int C0(float[] fArr, float f10, int i10) {
        if (N0(fArr)) {
            return -1;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        while (i10 < fArr.length) {
            if (f10 == fArr[i10]) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static float[] C1(float[] fArr, int i10) {
        return (float[]) y1(fArr, i10);
    }

    public static char[] C2(Character[] chArr) {
        if (chArr == null) {
            return null;
        }
        if (chArr.length == 0) {
            return new char[0];
        }
        char[] cArr = new char[chArr.length];
        for (int i10 = 0; i10 < chArr.length; i10++) {
            cArr[i10] = chArr[i10].charValue();
        }
        return cArr;
    }

    public static short[] D(short[] sArr, int i10, short[] sArr2) {
        return (short[]) t1(sArr, i10, sArr2, Short.TYPE);
    }

    public static int D0(int[] iArr, int i10) {
        return E0(iArr, i10, 0);
    }

    public static int[] D1(int[] iArr, int i10) {
        return (int[]) y1(iArr, i10);
    }

    public static char[] D2(Character[] chArr, char c10) {
        if (chArr == null) {
            return null;
        }
        if (chArr.length == 0) {
            return new char[0];
        }
        char[] cArr = new char[chArr.length];
        for (int i10 = 0; i10 < chArr.length; i10++) {
            Character ch2 = chArr[i10];
            cArr[i10] = ch2 == null ? c10 : ch2.charValue();
        }
        return cArr;
    }

    public static short[] E(short[] sArr, short s10) {
        return (short[]) v1(sArr, Short.valueOf(s10), Short.TYPE);
    }

    public static int E0(int[] iArr, int i10, int i11) {
        if (iArr == null) {
            return -1;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        while (i11 < iArr.length) {
            if (i10 == iArr[i11]) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static long[] E1(long[] jArr, int i10) {
        return (long[]) y1(jArr, i10);
    }

    public static double[] E2(Double[] dArr) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return new double[0];
        }
        double[] dArr2 = new double[dArr.length];
        for (int i10 = 0; i10 < dArr.length; i10++) {
            dArr2[i10] = dArr[i10].doubleValue();
        }
        return dArr2;
    }

    public static short[] F(short[] sArr, short[] sArr2) {
        return (short[]) u1(sArr, sArr2);
    }

    public static int F0(long[] jArr, long j10) {
        return G0(jArr, j10, 0);
    }

    public static Object[] F1(Object[] objArr, int i10) {
        return (Object[]) y1(objArr, i10);
    }

    public static double[] F2(Double[] dArr, double d10) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return new double[0];
        }
        double[] dArr2 = new double[dArr.length];
        for (int i10 = 0; i10 < dArr.length; i10++) {
            Double d11 = dArr[i10];
            dArr2[i10] = d11 == null ? d10 : d11.doubleValue();
        }
        return dArr2;
    }

    public static boolean[] G(boolean[] zArr, int i10, boolean z10) {
        return (boolean[]) s1(zArr, i10, Boolean.valueOf(z10), Boolean.TYPE);
    }

    public static int G0(long[] jArr, long j10, int i10) {
        if (jArr == null) {
            return -1;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        while (i10 < jArr.length) {
            if (j10 == jArr[i10]) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static short[] G1(short[] sArr, int i10) {
        return (short[]) y1(sArr, i10);
    }

    public static float[] G2(Float[] fArr) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return new float[0];
        }
        float[] fArr2 = new float[fArr.length];
        for (int i10 = 0; i10 < fArr.length; i10++) {
            fArr2[i10] = fArr[i10].floatValue();
        }
        return fArr2;
    }

    public static boolean[] H(boolean[] zArr, int i10, boolean[] zArr2) {
        return (boolean[]) t1(zArr, i10, zArr2, Boolean.TYPE);
    }

    public static int H0(Object[] objArr, Object obj) {
        return I0(objArr, obj, 0);
    }

    public static boolean[] H1(boolean[] zArr, int i10) {
        return (boolean[]) y1(zArr, i10);
    }

    public static float[] H2(Float[] fArr, float f10) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return new float[0];
        }
        float[] fArr2 = new float[fArr.length];
        for (int i10 = 0; i10 < fArr.length; i10++) {
            Float f11 = fArr[i10];
            fArr2[i10] = f11 == null ? f10 : f11.floatValue();
        }
        return fArr2;
    }

    public static boolean[] I(boolean[] zArr, boolean z10) {
        return (boolean[]) v1(zArr, Boolean.valueOf(z10), Boolean.TYPE);
    }

    public static int I0(Object[] objArr, Object obj, int i10) {
        if (objArr == null) {
            return -1;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        if (obj == null) {
            while (i10 < objArr.length) {
                if (objArr[i10] == null) {
                    return i10;
                }
                i10++;
            }
        } else {
            while (i10 < objArr.length) {
                if (obj.equals(objArr[i10])) {
                    return i10;
                }
                i10++;
            }
        }
        return -1;
    }

    public static byte[] I1(byte[] bArr, byte b10) {
        int iT0 = t0(bArr, b10);
        return iT0 == -1 ? Y(bArr) : z1(bArr, iT0);
    }

    public static int[] I2(Integer[] numArr) {
        if (numArr == null) {
            return null;
        }
        if (numArr.length == 0) {
            return new int[0];
        }
        int[] iArr = new int[numArr.length];
        for (int i10 = 0; i10 < numArr.length; i10++) {
            iArr[i10] = numArr[i10].intValue();
        }
        return iArr;
    }

    public static boolean[] J(boolean[] zArr, boolean[] zArr2) {
        return (boolean[]) u1(zArr, zArr2);
    }

    public static int J0(short[] sArr, short s10) {
        return K0(sArr, s10, 0);
    }

    public static char[] J1(char[] cArr, char c10) {
        int iV0 = v0(cArr, c10);
        return iV0 == -1 ? Z(cArr) : A1(cArr, iV0);
    }

    public static int[] J2(Integer[] numArr, int i10) {
        if (numArr == null) {
            return null;
        }
        if (numArr.length == 0) {
            return new int[0];
        }
        int[] iArr = new int[numArr.length];
        for (int i11 = 0; i11 < numArr.length; i11++) {
            Integer num = numArr[i11];
            iArr[i11] = num == null ? i10 : num.intValue();
        }
        return iArr;
    }

    public static <T> List<T> K(T... tArr) {
        ArrayList arrayList = new ArrayList();
        if (tArr != null && tArr.length != 0) {
            arrayList.addAll(Arrays.asList(tArr));
        }
        return arrayList;
    }

    public static int K0(short[] sArr, short s10, int i10) {
        if (sArr == null) {
            return -1;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        while (i10 < sArr.length) {
            if (s10 == sArr[i10]) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static double[] K1(double[] dArr, double d10) {
        int iX0 = x0(dArr, d10);
        return iX0 == -1 ? a0(dArr) : B1(dArr, iX0);
    }

    public static long[] K2(Long[] lArr) {
        if (lArr == null) {
            return null;
        }
        if (lArr.length == 0) {
            return new long[0];
        }
        long[] jArr = new long[lArr.length];
        for (int i10 = 0; i10 < lArr.length; i10++) {
            jArr[i10] = lArr[i10].longValue();
        }
        return jArr;
    }

    public static <T> List<T> L(T... tArr) {
        LinkedList linkedList = new LinkedList();
        if (tArr != null && tArr.length != 0) {
            linkedList.addAll(Arrays.asList(tArr));
        }
        return linkedList;
    }

    public static int L0(boolean[] zArr, boolean z10) {
        return M0(zArr, z10, 0);
    }

    public static float[] L1(float[] fArr, float f10) {
        int iB0 = B0(fArr, f10);
        return iB0 == -1 ? b0(fArr) : C1(fArr, iB0);
    }

    public static long[] L2(Long[] lArr, long j10) {
        if (lArr == null) {
            return null;
        }
        if (lArr.length == 0) {
            return new long[0];
        }
        long[] jArr = new long[lArr.length];
        for (int i10 = 0; i10 < lArr.length; i10++) {
            Long l10 = lArr[i10];
            jArr[i10] = l10 == null ? j10 : l10.longValue();
        }
        return jArr;
    }

    public static <T> List<T> M(T... tArr) {
        return (tArr == null || tArr.length == 0) ? Collections.emptyList() : Arrays.asList(tArr);
    }

    public static int M0(boolean[] zArr, boolean z10, int i10) {
        if (N0(zArr)) {
            return -1;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        while (i10 < zArr.length) {
            if (z10 == zArr[i10]) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static int[] M1(int[] iArr, int i10) {
        int iD0 = D0(iArr, i10);
        return iD0 == -1 ? c0(iArr) : D1(iArr, iD0);
    }

    public static short[] M2(Short[] shArr) {
        if (shArr == null) {
            return null;
        }
        if (shArr.length == 0) {
            return new short[0];
        }
        short[] sArr = new short[shArr.length];
        for (int i10 = 0; i10 < shArr.length; i10++) {
            sArr[i10] = shArr[i10].shortValue();
        }
        return sArr;
    }

    public static <T> List<T> N(T... tArr) {
        return Collections.unmodifiableList(M(tArr));
    }

    public static boolean N0(Object obj) {
        return s0(obj) == 0;
    }

    public static long[] N1(long[] jArr, long j10) {
        int iF0 = F0(jArr, j10);
        return iF0 == -1 ? d0(jArr) : E1(jArr, iF0);
    }

    public static short[] N2(Short[] shArr, short s10) {
        if (shArr == null) {
            return null;
        }
        if (shArr.length == 0) {
            return new short[0];
        }
        short[] sArr = new short[shArr.length];
        for (int i10 = 0; i10 < shArr.length; i10++) {
            Short sh2 = shArr[i10];
            sArr[i10] = sh2 == null ? s10 : sh2.shortValue();
        }
        return sArr;
    }

    public static boolean O(byte[] bArr, byte b10) {
        return t0(bArr, b10) != -1;
    }

    public static boolean O0(Object obj, Object obj2) {
        return s0(obj) == s0(obj2);
    }

    public static Object[] O1(Object[] objArr, Object obj) {
        int iH0 = H0(objArr, obj);
        return iH0 == -1 ? e0(objArr) : F1(objArr, iH0);
    }

    public static boolean[] O2(Boolean[] boolArr) {
        if (boolArr == null) {
            return null;
        }
        if (boolArr.length == 0) {
            return new boolean[0];
        }
        boolean[] zArr = new boolean[boolArr.length];
        for (int i10 = 0; i10 < boolArr.length; i10++) {
            zArr[i10] = boolArr[i10].booleanValue();
        }
        return zArr;
    }

    public static boolean P(char[] cArr, char c10) {
        return v0(cArr, c10) != -1;
    }

    public static int P0(byte[] bArr, byte b10) {
        return Q0(bArr, b10, Integer.MAX_VALUE);
    }

    public static short[] P1(short[] sArr, short s10) {
        int iJ0 = J0(sArr, s10);
        return iJ0 == -1 ? f0(sArr) : G1(sArr, iJ0);
    }

    public static boolean[] P2(Boolean[] boolArr, boolean z10) {
        if (boolArr == null) {
            return null;
        }
        if (boolArr.length == 0) {
            return new boolean[0];
        }
        boolean[] zArr = new boolean[boolArr.length];
        for (int i10 = 0; i10 < boolArr.length; i10++) {
            Boolean bool = boolArr[i10];
            zArr[i10] = bool == null ? z10 : bool.booleanValue();
        }
        return zArr;
    }

    public static boolean Q(double[] dArr, double d10) {
        return x0(dArr, d10) != -1;
    }

    public static int Q0(byte[] bArr, byte b10, int i10) {
        if (bArr == null || i10 < 0) {
            return -1;
        }
        if (i10 >= bArr.length) {
            i10 = bArr.length - 1;
        }
        while (i10 >= 0) {
            if (b10 == bArr[i10]) {
                return i10;
            }
            i10--;
        }
        return -1;
    }

    public static boolean[] Q1(boolean[] zArr, boolean z10) {
        int iL0 = L0(zArr, z10);
        return iL0 == -1 ? g0(zArr) : H1(zArr, iL0);
    }

    public static String Q2(Object obj) {
        if (obj == null) {
            return i0.f11859x;
        }
        if (obj instanceof Object[]) {
            return Arrays.deepToString((Object[]) obj);
        }
        if (obj instanceof boolean[]) {
            return Arrays.toString((boolean[]) obj);
        }
        if (obj instanceof byte[]) {
            return Arrays.toString((byte[]) obj);
        }
        if (obj instanceof char[]) {
            return Arrays.toString((char[]) obj);
        }
        if (obj instanceof double[]) {
            return Arrays.toString((double[]) obj);
        }
        if (obj instanceof float[]) {
            return Arrays.toString((float[]) obj);
        }
        if (obj instanceof int[]) {
            return Arrays.toString((int[]) obj);
        }
        if (obj instanceof long[]) {
            return Arrays.toString((long[]) obj);
        }
        if (obj instanceof short[]) {
            return Arrays.toString((short[]) obj);
        }
        throw new IllegalArgumentException("Array has incompatible type: " + obj.getClass());
    }

    public static boolean R(double[] dArr, double d10, double d11) {
        return A0(dArr, d10, 0, d11) != -1;
    }

    public static int R0(char[] cArr, char c10) {
        return S0(cArr, c10, Integer.MAX_VALUE);
    }

    public static void R1(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        int length = bArr.length - 1;
        for (int i10 = 0; length > i10; i10++) {
            byte b10 = bArr[length];
            bArr[length] = bArr[i10];
            bArr[i10] = b10;
            length--;
        }
    }

    public static boolean S(float[] fArr, float f10) {
        return B0(fArr, f10) != -1;
    }

    public static int S0(char[] cArr, char c10, int i10) {
        if (cArr == null || i10 < 0) {
            return -1;
        }
        if (i10 >= cArr.length) {
            i10 = cArr.length - 1;
        }
        while (i10 >= 0) {
            if (c10 == cArr[i10]) {
                return i10;
            }
            i10--;
        }
        return -1;
    }

    public static void S1(char[] cArr) {
        if (cArr == null) {
            return;
        }
        int length = cArr.length - 1;
        for (int i10 = 0; length > i10; i10++) {
            char c10 = cArr[length];
            cArr[length] = cArr[i10];
            cArr[i10] = c10;
            length--;
        }
    }

    public static boolean T(int[] iArr, int i10) {
        return D0(iArr, i10) != -1;
    }

    public static int T0(double[] dArr, double d10) {
        return V0(dArr, d10, Integer.MAX_VALUE);
    }

    public static void T1(double[] dArr) {
        if (dArr == null) {
            return;
        }
        int length = dArr.length - 1;
        for (int i10 = 0; length > i10; i10++) {
            double d10 = dArr[length];
            dArr[length] = dArr[i10];
            dArr[i10] = d10;
            length--;
        }
    }

    public static boolean U(long[] jArr, long j10) {
        return F0(jArr, j10) != -1;
    }

    public static int U0(double[] dArr, double d10, double d11) {
        return W0(dArr, d10, Integer.MAX_VALUE, d11);
    }

    public static void U1(float[] fArr) {
        if (fArr == null) {
            return;
        }
        int length = fArr.length - 1;
        for (int i10 = 0; length > i10; i10++) {
            float f10 = fArr[length];
            fArr[length] = fArr[i10];
            fArr[i10] = f10;
            length--;
        }
    }

    public static boolean V(Object[] objArr, Object obj) {
        return H0(objArr, obj) != -1;
    }

    public static int V0(double[] dArr, double d10, int i10) {
        if (N0(dArr) || i10 < 0) {
            return -1;
        }
        if (i10 >= dArr.length) {
            i10 = dArr.length - 1;
        }
        while (i10 >= 0) {
            if (d10 == dArr[i10]) {
                return i10;
            }
            i10--;
        }
        return -1;
    }

    public static void V1(int[] iArr) {
        if (iArr == null) {
            return;
        }
        int length = iArr.length - 1;
        for (int i10 = 0; length > i10; i10++) {
            int i11 = iArr[length];
            iArr[length] = iArr[i10];
            iArr[i10] = i11;
            length--;
        }
    }

    public static boolean W(short[] sArr, short s10) {
        return J0(sArr, s10) != -1;
    }

    public static int W0(double[] dArr, double d10, int i10, double d11) {
        if (N0(dArr) || i10 < 0) {
            return -1;
        }
        if (i10 >= dArr.length) {
            i10 = dArr.length - 1;
        }
        double d12 = d10 - d11;
        double d13 = d10 + d11;
        while (i10 >= 0) {
            if (dArr[i10] >= d12 && dArr[i10] <= d13) {
                return i10;
            }
            i10--;
        }
        return -1;
    }

    public static void W1(long[] jArr) {
        if (jArr == null) {
            return;
        }
        int length = jArr.length - 1;
        for (int i10 = 0; length > i10; i10++) {
            long j10 = jArr[length];
            jArr[length] = jArr[i10];
            jArr[i10] = j10;
            length--;
        }
    }

    public static boolean X(boolean[] zArr, boolean z10) {
        return L0(zArr, z10) != -1;
    }

    public static int X0(float[] fArr, float f10) {
        return Y0(fArr, f10, Integer.MAX_VALUE);
    }

    public static <T> void X1(T[] tArr) {
        if (tArr == null) {
            return;
        }
        int length = tArr.length - 1;
        for (int i10 = 0; length > i10; i10++) {
            T t10 = tArr[length];
            tArr[length] = tArr[i10];
            tArr[i10] = t10;
            length--;
        }
    }

    public static byte[] Y(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return j2(bArr, 0, bArr.length);
    }

    public static int Y0(float[] fArr, float f10, int i10) {
        if (N0(fArr) || i10 < 0) {
            return -1;
        }
        if (i10 >= fArr.length) {
            i10 = fArr.length - 1;
        }
        while (i10 >= 0) {
            if (f10 == fArr[i10]) {
                return i10;
            }
            i10--;
        }
        return -1;
    }

    public static void Y1(short[] sArr) {
        if (sArr == null) {
            return;
        }
        int length = sArr.length - 1;
        for (int i10 = 0; length > i10; i10++) {
            short s10 = sArr[length];
            sArr[length] = sArr[i10];
            sArr[i10] = s10;
            length--;
        }
    }

    public static char[] Z(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return k2(cArr, 0, cArr.length);
    }

    public static int Z0(int[] iArr, int i10) {
        return a1(iArr, i10, Integer.MAX_VALUE);
    }

    public static void Z1(boolean[] zArr) {
        if (zArr == null) {
            return;
        }
        int length = zArr.length - 1;
        for (int i10 = 0; length > i10; i10++) {
            boolean z10 = zArr[length];
            zArr[length] = zArr[i10];
            zArr[i10] = z10;
            length--;
        }
    }

    public static byte[] a(byte[] bArr, byte b10) {
        return (byte[]) v1(bArr, Byte.valueOf(b10), Byte.TYPE);
    }

    public static double[] a0(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        return l2(dArr, 0, dArr.length);
    }

    public static int a1(int[] iArr, int i10, int i11) {
        if (iArr == null || i11 < 0) {
            return -1;
        }
        if (i11 >= iArr.length) {
            i11 = iArr.length - 1;
        }
        while (i11 >= 0) {
            if (i10 == iArr[i11]) {
                return i11;
            }
            i11--;
        }
        return -1;
    }

    public static void a2(Object obj, int i10, Object obj2) {
        if (obj == null) {
            return;
        }
        Array.set(obj, i10, obj2);
    }

    public static byte[] b(byte[] bArr, int i10, byte b10) {
        return (byte[]) s1(bArr, i10, Byte.valueOf(b10), Byte.TYPE);
    }

    public static float[] b0(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        return m2(fArr, 0, fArr.length);
    }

    public static int b1(long[] jArr, long j10) {
        return c1(jArr, j10, Integer.MAX_VALUE);
    }

    public static void b2(byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            return;
        }
        Arrays.sort(bArr);
    }

    public static byte[] c(byte[] bArr, int i10, byte[] bArr2) {
        return (byte[]) t1(bArr, i10, bArr2, Byte.TYPE);
    }

    public static int[] c0(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        return n2(iArr, 0, iArr.length);
    }

    public static int c1(long[] jArr, long j10, int i10) {
        if (jArr == null || i10 < 0) {
            return -1;
        }
        if (i10 >= jArr.length) {
            i10 = jArr.length - 1;
        }
        while (i10 >= 0) {
            if (j10 == jArr[i10]) {
                return i10;
            }
            i10--;
        }
        return -1;
    }

    public static void c2(char[] cArr) {
        if (cArr == null || cArr.length < 2) {
            return;
        }
        Arrays.sort(cArr);
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        return (byte[]) u1(bArr, bArr2);
    }

    public static long[] d0(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        return o2(jArr, 0, jArr.length);
    }

    public static int d1(Object[] objArr, Object obj) {
        return e1(objArr, obj, Integer.MAX_VALUE);
    }

    public static void d2(double[] dArr) {
        if (dArr == null || dArr.length < 2) {
            return;
        }
        Arrays.sort(dArr);
    }

    public static char[] e(char[] cArr, char c10) {
        return (char[]) v1(cArr, Character.valueOf(c10), Character.TYPE);
    }

    public static <T> T[] e0(T[] tArr) {
        if (tArr == null) {
            return null;
        }
        return (T[]) p2(tArr, 0, tArr.length);
    }

    public static int e1(Object[] objArr, Object obj, int i10) {
        if (objArr == null || i10 < 0) {
            return -1;
        }
        if (i10 >= objArr.length) {
            i10 = objArr.length - 1;
        }
        if (obj == null) {
            while (i10 >= 0) {
                if (objArr[i10] == null) {
                    return i10;
                }
                i10--;
            }
        } else {
            while (i10 >= 0) {
                if (obj.equals(objArr[i10])) {
                    return i10;
                }
                i10--;
            }
        }
        return -1;
    }

    public static void e2(float[] fArr) {
        if (fArr == null || fArr.length < 2) {
            return;
        }
        Arrays.sort(fArr);
    }

    public static char[] f(char[] cArr, int i10, char c10) {
        return (char[]) s1(cArr, i10, Character.valueOf(c10), Character.TYPE);
    }

    public static short[] f0(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        return q2(sArr, 0, sArr.length);
    }

    public static int f1(short[] sArr, short s10) {
        return g1(sArr, s10, Integer.MAX_VALUE);
    }

    public static void f2(int[] iArr) {
        if (iArr == null || iArr.length < 2) {
            return;
        }
        Arrays.sort(iArr);
    }

    public static char[] g(char[] cArr, int i10, char[] cArr2) {
        return (char[]) t1(cArr, i10, cArr2, Character.TYPE);
    }

    public static boolean[] g0(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        return r2(zArr, 0, zArr.length);
    }

    public static int g1(short[] sArr, short s10, int i10) {
        if (sArr == null || i10 < 0) {
            return -1;
        }
        if (i10 >= sArr.length) {
            i10 = sArr.length - 1;
        }
        while (i10 >= 0) {
            if (s10 == sArr[i10]) {
                return i10;
            }
            i10--;
        }
        return -1;
    }

    public static void g2(long[] jArr) {
        if (jArr == null || jArr.length < 2) {
            return;
        }
        Arrays.sort(jArr);
    }

    public static char[] h(char[] cArr, char[] cArr2) {
        return (char[]) u1(cArr, cArr2);
    }

    public static boolean h0(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    public static int h1(boolean[] zArr, boolean z10) {
        return i1(zArr, z10, Integer.MAX_VALUE);
    }

    public static <T> void h2(T[] tArr, Comparator<? super T> comparator) {
        if (tArr == null || tArr.length < 2) {
            return;
        }
        Arrays.sort(tArr, comparator);
    }

    public static double[] i(double[] dArr, double d10) {
        return (double[]) v1(dArr, Double.valueOf(d10), Double.TYPE);
    }

    public static boolean i0(char[] cArr, char[] cArr2) {
        return Arrays.equals(cArr, cArr2);
    }

    public static int i1(boolean[] zArr, boolean z10, int i10) {
        if (N0(zArr) || i10 < 0) {
            return -1;
        }
        if (i10 >= zArr.length) {
            i10 = zArr.length - 1;
        }
        while (i10 >= 0) {
            if (z10 == zArr[i10]) {
                return i10;
            }
            i10--;
        }
        return -1;
    }

    public static void i2(short[] sArr) {
        if (sArr == null || sArr.length < 2) {
            return;
        }
        Arrays.sort(sArr);
    }

    public static double[] j(double[] dArr, int i10, double d10) {
        return (double[]) s1(dArr, i10, Double.valueOf(d10), Double.TYPE);
    }

    public static boolean j0(double[] dArr, double[] dArr2) {
        return Arrays.equals(dArr, dArr2);
    }

    @SafeVarargs
    public static <T> T[] j1(T... tArr) {
        return tArr;
    }

    public static byte[] j2(byte[] bArr, int i10, int i11) {
        return (byte[]) x1(bArr, i10, i11);
    }

    public static double[] k(double[] dArr, int i10, double[] dArr2) {
        return (double[]) t1(dArr, i10, dArr2, Double.TYPE);
    }

    public static boolean k0(float[] fArr, float[] fArr2) {
        return Arrays.equals(fArr, fArr2);
    }

    public static boolean[] k1(boolean... zArr) {
        return zArr;
    }

    public static char[] k2(char[] cArr, int i10, int i11) {
        return (char[]) x1(cArr, i10, i11);
    }

    public static double[] l(double[] dArr, double[] dArr2) {
        return (double[]) u1(dArr, dArr2);
    }

    public static boolean l0(int[] iArr, int[] iArr2) {
        return Arrays.equals(iArr, iArr2);
    }

    public static byte[] l1(byte... bArr) {
        return bArr;
    }

    public static double[] l2(double[] dArr, int i10, int i11) {
        return (double[]) x1(dArr, i10, i11);
    }

    public static float[] m(float[] fArr, float f10) {
        return (float[]) v1(fArr, Float.valueOf(f10), Float.TYPE);
    }

    public static boolean m0(Object[] objArr, Object[] objArr2) {
        return Arrays.deepEquals(objArr, objArr2);
    }

    public static char[] m1(char... cArr) {
        return cArr;
    }

    public static float[] m2(float[] fArr, int i10, int i11) {
        return (float[]) x1(fArr, i10, i11);
    }

    public static float[] n(float[] fArr, int i10, float f10) {
        return (float[]) s1(fArr, i10, Float.valueOf(f10), Float.TYPE);
    }

    public static boolean n0(short[] sArr, short[] sArr2) {
        return Arrays.equals(sArr, sArr2);
    }

    public static double[] n1(double... dArr) {
        return dArr;
    }

    public static int[] n2(int[] iArr, int i10, int i11) {
        return (int[]) x1(iArr, i10, i11);
    }

    public static float[] o(float[] fArr, int i10, float[] fArr2) {
        return (float[]) t1(fArr, i10, fArr2, Float.TYPE);
    }

    public static boolean o0(boolean[] zArr, boolean[] zArr2) {
        return Arrays.equals(zArr, zArr2);
    }

    public static float[] o1(float... fArr) {
        return fArr;
    }

    public static long[] o2(long[] jArr, int i10, int i11) {
        return (long[]) x1(jArr, i10, i11);
    }

    public static float[] p(float[] fArr, float[] fArr2) {
        return (float[]) u1(fArr, fArr2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> void p0(Object obj, a<E> aVar) {
        if (obj == null || aVar == 0) {
            return;
        }
        int i10 = 0;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            while (i10 < length) {
                aVar.a(i10, objArr[i10]);
                i10++;
            }
            return;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length2 = zArr.length;
            while (i10 < length2) {
                aVar.a(i10, zArr[i10] ? Boolean.TRUE : Boolean.FALSE);
                i10++;
            }
            return;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length3 = bArr.length;
            while (i10 < length3) {
                aVar.a(i10, Byte.valueOf(bArr[i10]));
                i10++;
            }
            return;
        }
        if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            int length4 = cArr.length;
            while (i10 < length4) {
                aVar.a(i10, Character.valueOf(cArr[i10]));
                i10++;
            }
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length5 = sArr.length;
            while (i10 < length5) {
                aVar.a(i10, Short.valueOf(sArr[i10]));
                i10++;
            }
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length6 = iArr.length;
            while (i10 < length6) {
                aVar.a(i10, Integer.valueOf(iArr[i10]));
                i10++;
            }
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length7 = jArr.length;
            while (i10 < length7) {
                aVar.a(i10, Long.valueOf(jArr[i10]));
                i10++;
            }
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            int length8 = fArr.length;
            while (i10 < length8) {
                aVar.a(i10, Float.valueOf(fArr[i10]));
                i10++;
            }
            return;
        }
        if (!(obj instanceof double[])) {
            throw new IllegalArgumentException("Not an array: " + obj.getClass());
        }
        double[] dArr = (double[]) obj;
        int length9 = dArr.length;
        while (i10 < length9) {
            aVar.a(i10, Double.valueOf(dArr[i10]));
            i10++;
        }
    }

    public static int[] p1(int... iArr) {
        return iArr;
    }

    public static <T> T[] p2(T[] tArr, int i10, int i11) {
        return (T[]) ((Object[]) x1(tArr, i10, i11));
    }

    public static int[] q(int[] iArr, int i10) {
        return (int[]) v1(iArr, Integer.valueOf(i10), Integer.TYPE);
    }

    public static Object q0(Object obj, int i10) {
        return r0(obj, i10, null);
    }

    public static long[] q1(long... jArr) {
        return jArr;
    }

    public static short[] q2(short[] sArr, int i10, int i11) {
        return (short[]) x1(sArr, i10, i11);
    }

    public static int[] r(int[] iArr, int i10, int i11) {
        return (int[]) s1(iArr, i10, Integer.valueOf(i11), Integer.TYPE);
    }

    public static Object r0(Object obj, int i10, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        try {
            return Array.get(obj, i10);
        } catch (Exception unused) {
            return obj2;
        }
    }

    public static short[] r1(short... sArr) {
        return sArr;
    }

    public static boolean[] r2(boolean[] zArr, int i10, int i11) {
        return (boolean[]) x1(zArr, i10, i11);
    }

    public static int[] s(int[] iArr, int i10, int[] iArr2) {
        return (int[]) t1(iArr, i10, iArr2, Integer.TYPE);
    }

    public static int s0(Object obj) {
        if (obj == null) {
            return 0;
        }
        return Array.getLength(obj);
    }

    public static Object s1(Object obj, int i10, Object obj2, Class cls) {
        if (obj == null) {
            if (i10 == 0) {
                Object objNewInstance = Array.newInstance((Class<?>) cls, 1);
                Array.set(objNewInstance, 0, obj2);
                return objNewInstance;
            }
            throw new IndexOutOfBoundsException("Index: " + i10 + ", Length: 0");
        }
        int length = Array.getLength(obj);
        if (i10 > length || i10 < 0) {
            throw new IndexOutOfBoundsException("Index: " + i10 + ", Length: " + length);
        }
        Object objNewInstance2 = Array.newInstance((Class<?>) cls, length + 1);
        System.arraycopy(obj, 0, objNewInstance2, 0, i10);
        Array.set(objNewInstance2, i10, obj2);
        if (i10 < length) {
            System.arraycopy(obj, i10, objNewInstance2, i10 + 1, length - i10);
        }
        return objNewInstance2;
    }

    public static Boolean[] s2(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        if (zArr.length == 0) {
            return new Boolean[0];
        }
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i10 = 0; i10 < zArr.length; i10++) {
            boolArr[i10] = zArr[i10] ? Boolean.TRUE : Boolean.FALSE;
        }
        return boolArr;
    }

    public static int[] t(int[] iArr, int[] iArr2) {
        return (int[]) u1(iArr, iArr2);
    }

    public static int t0(byte[] bArr, byte b10) {
        return u0(bArr, b10, 0);
    }

    public static Object t1(Object obj, int i10, Object obj2, Class cls) {
        if (obj == null && obj2 == null) {
            return null;
        }
        int iS0 = s0(obj);
        int iS02 = s0(obj2);
        if (iS0 == 0) {
            if (i10 == 0) {
                return w1(obj2);
            }
            throw new IndexOutOfBoundsException("Index: " + i10 + ", array1 Length: 0");
        }
        if (iS02 == 0) {
            return w1(obj);
        }
        if (i10 > iS0 || i10 < 0) {
            throw new IndexOutOfBoundsException("Index: " + i10 + ", array1 Length: " + iS0);
        }
        Object objNewInstance = Array.newInstance(obj.getClass().getComponentType(), iS0 + iS02);
        if (i10 == iS0) {
            System.arraycopy(obj, 0, objNewInstance, 0, iS0);
            System.arraycopy(obj2, 0, objNewInstance, iS0, iS02);
        } else if (i10 == 0) {
            System.arraycopy(obj2, 0, objNewInstance, 0, iS02);
            System.arraycopy(obj, 0, objNewInstance, iS02, iS0);
        } else {
            System.arraycopy(obj, 0, objNewInstance, 0, i10);
            System.arraycopy(obj2, 0, objNewInstance, i10, iS02);
            System.arraycopy(obj, i10, objNewInstance, iS02 + i10, iS0 - i10);
        }
        return objNewInstance;
    }

    public static Byte[] t2(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return new Byte[0];
        }
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr2[i10] = new Byte(bArr[i10]);
        }
        return bArr2;
    }

    public static long[] u(long[] jArr, int i10, long j10) {
        return (long[]) s1(jArr, i10, Long.valueOf(j10), Long.TYPE);
    }

    public static int u0(byte[] bArr, byte b10, int i10) {
        if (bArr == null) {
            return -1;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        while (i10 < bArr.length) {
            if (b10 == bArr[i10]) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static Object u1(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return null;
        }
        if (obj == null) {
            return w1(obj2);
        }
        if (obj2 == null) {
            return w1(obj);
        }
        int iS0 = s0(obj);
        int iS02 = s0(obj2);
        Object objNewInstance = Array.newInstance(obj.getClass().getComponentType(), iS0 + iS02);
        System.arraycopy(obj, 0, objNewInstance, 0, iS0);
        System.arraycopy(obj2, 0, objNewInstance, iS0, iS02);
        return objNewInstance;
    }

    public static Character[] u2(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        if (cArr.length == 0) {
            return new Character[0];
        }
        Character[] chArr = new Character[cArr.length];
        for (int i10 = 0; i10 < cArr.length; i10++) {
            chArr[i10] = new Character(cArr[i10]);
        }
        return chArr;
    }

    public static long[] v(long[] jArr, int i10, long[] jArr2) {
        return (long[]) t1(jArr, i10, jArr2, Long.TYPE);
    }

    public static int v0(char[] cArr, char c10) {
        return w0(cArr, c10, 0);
    }

    public static Object v1(Object obj, Object obj2, Class cls) {
        Object objNewInstance;
        int i10 = 0;
        if (obj != null) {
            int iS0 = s0(obj);
            objNewInstance = Array.newInstance(obj.getClass().getComponentType(), iS0 + 1);
            System.arraycopy(obj, 0, objNewInstance, 0, iS0);
            i10 = iS0;
        } else {
            objNewInstance = Array.newInstance((Class<?>) cls, 1);
        }
        Array.set(objNewInstance, i10, obj2);
        return objNewInstance;
    }

    public static Double[] v2(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return new Double[0];
        }
        Double[] dArr2 = new Double[dArr.length];
        for (int i10 = 0; i10 < dArr.length; i10++) {
            dArr2[i10] = new Double(dArr[i10]);
        }
        return dArr2;
    }

    public static long[] w(long[] jArr, long j10) {
        return (long[]) v1(jArr, Long.valueOf(j10), Long.TYPE);
    }

    public static int w0(char[] cArr, char c10, int i10) {
        if (cArr == null) {
            return -1;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        while (i10 < cArr.length) {
            if (c10 == cArr[i10]) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static Object w1(Object obj) {
        if (obj == null) {
            return null;
        }
        return x1(obj, 0, s0(obj));
    }

    public static Float[] w2(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return new Float[0];
        }
        Float[] fArr2 = new Float[fArr.length];
        for (int i10 = 0; i10 < fArr.length; i10++) {
            fArr2[i10] = new Float(fArr[i10]);
        }
        return fArr2;
    }

    public static long[] x(long[] jArr, long[] jArr2) {
        return (long[]) u1(jArr, jArr2);
    }

    public static int x0(double[] dArr, double d10) {
        return z0(dArr, d10, 0);
    }

    public static Object x1(Object obj, int i10, int i11) {
        if (obj == null) {
            return null;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        int iS0 = s0(obj);
        if (i11 > iS0) {
            i11 = iS0;
        }
        int i12 = i11 - i10;
        Class<?> componentType = obj.getClass().getComponentType();
        if (i12 <= 0) {
            return Array.newInstance(componentType, 0);
        }
        Object objNewInstance = Array.newInstance(componentType, i12);
        System.arraycopy(obj, i10, objNewInstance, 0, i12);
        return objNewInstance;
    }

    public static Integer[] x2(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        if (iArr.length == 0) {
            return new Integer[0];
        }
        Integer[] numArr = new Integer[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            numArr[i10] = new Integer(iArr[i10]);
        }
        return numArr;
    }

    public static <T> T[] y(T[] tArr, int i10, T t10) {
        Class<?> componentType;
        if (tArr != null) {
            componentType = tArr.getClass().getComponentType();
        } else {
            if (t10 == null) {
                T[] tArr2 = (T[]) new Object[1];
                tArr2[0] = null;
                return tArr2;
            }
            componentType = t10.getClass();
        }
        return (T[]) ((Object[]) s1(tArr, i10, t10, componentType));
    }

    public static int y0(double[] dArr, double d10, double d11) {
        return A0(dArr, d10, 0, d11);
    }

    public static Object y1(Object obj, int i10) {
        int iS0 = s0(obj);
        if (i10 < 0 || i10 >= iS0) {
            throw new IndexOutOfBoundsException("Index: " + i10 + ", Length: " + iS0);
        }
        int i11 = iS0 - 1;
        Object objNewInstance = Array.newInstance(obj.getClass().getComponentType(), i11);
        System.arraycopy(obj, 0, objNewInstance, 0, i10);
        if (i10 < i11) {
            System.arraycopy(obj, i10 + 1, objNewInstance, i10, (iS0 - i10) - 1);
        }
        return objNewInstance;
    }

    public static Long[] y2(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        if (jArr.length == 0) {
            return new Long[0];
        }
        Long[] lArr = new Long[jArr.length];
        for (int i10 = 0; i10 < jArr.length; i10++) {
            lArr[i10] = new Long(jArr[i10]);
        }
        return lArr;
    }

    public static <T> T[] z(T[] tArr, int i10, T[] tArr2) {
        Class<?> componentType;
        if (tArr != null) {
            componentType = tArr.getClass().getComponentType();
        } else {
            if (tArr2 == null) {
                T[] tArr3 = (T[]) new Object[1];
                tArr3[0] = null;
                return tArr3;
            }
            componentType = tArr2.getClass().getComponentType();
        }
        return (T[]) ((Object[]) t1(tArr, i10, tArr2, componentType));
    }

    public static int z0(double[] dArr, double d10, int i10) {
        if (N0(dArr)) {
            return -1;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        while (i10 < dArr.length) {
            if (d10 == dArr[i10]) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static byte[] z1(byte[] bArr, int i10) {
        return (byte[]) y1(bArr, i10);
    }

    public static Short[] z2(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        if (sArr.length == 0) {
            return new Short[0];
        }
        Short[] shArr = new Short[sArr.length];
        for (int i10 = 0; i10 < sArr.length; i10++) {
            shArr[i10] = new Short(sArr[i10]);
        }
        return shArr;
    }
}
