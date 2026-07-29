package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f12003a = 8192;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f12004b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char[] f12005c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public u() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String A(String str) {
        return (l1.C0(str) || !Charset.isSupported(str)) ? "UTF-8" : str;
    }

    public static int B(char c10) {
        if (c10 >= '0' && c10 <= '9') {
            return c10 - '0';
        }
        if (c10 < 'A' || c10 > 'F') {
            throw new IllegalArgumentException();
        }
        return (c10 - 'A') + 10;
    }

    public static byte[] C(String str) {
        if (l1.C0(str)) {
            return new byte[0];
        }
        int length = str.length();
        if (length % 2 != 0) {
            str = "0" + str;
            length++;
        }
        char[] charArray = str.toUpperCase().toCharArray();
        byte[] bArr = new byte[length >> 1];
        for (int i10 = 0; i10 < length; i10 += 2) {
            bArr[i10 >> 1] = (byte) ((B(charArray[i10]) << 4) | B(charArray[i10 + 1]));
        }
        return bArr;
    }

    public static int D(String str) {
        return Integer.parseInt(str, 16);
    }

    public static ByteArrayOutputStream E(InputStream inputStream) {
        try {
            if (inputStream == null) {
                return null;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[8192];
                while (true) {
                    int i10 = inputStream.read(bArr, 0, 8192);
                    if (i10 != -1) {
                        byteArrayOutputStream.write(bArr, 0, i10);
                    } else {
                        try {
                            break;
                        } catch (IOException e10) {
                        }
                    }
                }
                return byteArrayOutputStream;
            } catch (IOException e11) {
                e11.printStackTrace();
                try {
                    inputStream.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
                return null;
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e102) {
                e102.printStackTrace();
            }
        }
    }

    public static byte[] F(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        return E(inputStream).toByteArray();
    }

    public static List<String> G(InputStream inputStream) {
        return H(inputStream, "");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<java.lang.String> H(java.io.InputStream r4, java.lang.String r5) throws java.lang.Throwable {
        /*
            r0 = 0
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
            r1.<init>()     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
            java.lang.String r5 = A(r5)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b
        L14:
            java.lang.String r4 = r2.readLine()     // Catch: java.io.IOException -> L27 java.lang.Throwable -> L3b
            if (r4 == 0) goto L1e
            r1.add(r4)     // Catch: java.io.IOException -> L27 java.lang.Throwable -> L3b
            goto L14
        L1e:
            r2.close()     // Catch: java.io.IOException -> L22
            goto L26
        L22:
            r4 = move-exception
            r4.printStackTrace()
        L26:
            return r1
        L27:
            r4 = move-exception
            goto L2d
        L29:
            r4 = move-exception
            goto L3d
        L2b:
            r4 = move-exception
            r2 = r0
        L2d:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L3b
            if (r2 == 0) goto L3a
            r2.close()     // Catch: java.io.IOException -> L36
            goto L3a
        L36:
            r4 = move-exception
            r4.printStackTrace()
        L3a:
            return r0
        L3b:
            r4 = move-exception
            r0 = r2
        L3d:
            if (r0 == 0) goto L47
            r0.close()     // Catch: java.io.IOException -> L43
            goto L47
        L43:
            r5 = move-exception
            r5.printStackTrace()
        L47:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.u.H(java.io.InputStream, java.lang.String):java.util.List");
    }

    public static String I(InputStream inputStream, String str) {
        if (inputStream == null) {
            return "";
        }
        try {
            ByteArrayOutputStream byteArrayOutputStreamE = E(inputStream);
            return byteArrayOutputStreamE == null ? "" : byteArrayOutputStreamE.toString(A(str));
        } catch (UnsupportedEncodingException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String J(int i10) {
        return Integer.toHexString(i10);
    }

    public static byte[] K(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        return jSONArray.toString().getBytes();
    }

    public static byte[] L(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString().getBytes();
    }

    public static long M(long j10, int i10) {
        if (j10 < 0) {
            return -1L;
        }
        return j10 * ((long) i10);
    }

    public static String N(long j10, int i10) {
        return l1.H0(j10, i10);
    }

    public static long O(long j10, int i10) {
        return j10 / ((long) i10);
    }

    public static ByteArrayInputStream P(OutputStream outputStream) {
        if (outputStream == null) {
            return null;
        }
        return new ByteArrayInputStream(((ByteArrayOutputStream) outputStream).toByteArray());
    }

    public static byte[] Q(OutputStream outputStream) {
        if (outputStream == null) {
            return null;
        }
        return ((ByteArrayOutputStream) outputStream).toByteArray();
    }

    public static String R(OutputStream outputStream, String str) {
        if (outputStream == null) {
            return "";
        }
        try {
            return new String(Q(outputStream), A(str));
        } catch (UnsupportedEncodingException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static byte[] S(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelable.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }

    public static int T(float f10) {
        return l1.M0(f10);
    }

    public static int U(float f10) {
        return l1.N0(f10);
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0033: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:26:0x0033 */
    public static byte[] V(Serializable serializable) throws Throwable {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2;
        ObjectOutputStream objectOutputStream3 = null;
        try {
            if (serializable == null) {
                return null;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeObject(serializable);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        objectOutputStream2.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                    return byteArray;
                } catch (Exception e11) {
                    e = e11;
                    e.printStackTrace();
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Exception e13) {
                e = e13;
                objectOutputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream3 != null) {
                    try {
                        objectOutputStream3.close();
                    } catch (IOException e14) {
                        e14.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            objectOutputStream3 = objectOutputStream;
        }
    }

    public static int W(float f10) {
        return l1.X0(f10);
    }

    public static byte[] X(String str) {
        return Y(str, "");
    }

    public static byte[] Y(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(A(str2));
        } catch (UnsupportedEncodingException e10) {
            e10.printStackTrace();
            return str.getBytes();
        }
    }

    public static InputStream Z(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return new ByteArrayInputStream(str.getBytes(A(str2)));
        } catch (UnsupportedEncodingException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static byte[] a(Bitmap bitmap) {
        return l1.f(bitmap);
    }

    public static OutputStream a0(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return r(str.getBytes(A(str2)));
        } catch (UnsupportedEncodingException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static byte[] b(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i10) {
        return l1.g(bitmap, compressFormat, i10);
    }

    public static long b0(long j10, int i10) {
        return j10 * ((long) i10);
    }

    public static Drawable c(Bitmap bitmap) {
        return l1.h(bitmap);
    }

    public static Bitmap c0(View view) {
        return l1.f1(view);
    }

    public static byte[] d(String str) {
        int length = str.length() % 8;
        int length2 = str.length() / 8;
        if (length != 0) {
            while (length < 8) {
                str = "0" + str;
                length++;
            }
            length2++;
        }
        byte[] bArr = new byte[length2];
        for (int i10 = 0; i10 < length2; i10++) {
            for (int i11 = 0; i11 < 8; i11++) {
                bArr[i10] = (byte) (bArr[i10] << 1);
                bArr[i10] = (byte) (bArr[i10] | (str.charAt((i10 * 8) + i11) - '0'));
            }
        }
        return bArr;
    }

    @SuppressLint({"DefaultLocale"})
    public static String e(long j10) {
        return f(j10, 3);
    }

    @SuppressLint({"DefaultLocale"})
    public static String f(long j10, int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("precision shouldn't be less than zero!");
        }
        if (j10 < 0) {
            throw new IllegalArgumentException("byteSize shouldn't be less than zero!");
        }
        if (j10 < 1024) {
            return String.format("%." + i10 + "fB", Double.valueOf(j10));
        }
        if (j10 < 1048576) {
            return String.format("%." + i10 + "fKB", Double.valueOf(j10 / 1024.0d));
        }
        if (j10 < 1073741824) {
            return String.format("%." + i10 + "fMB", Double.valueOf(j10 / 1048576.0d));
        }
        return String.format("%." + i10 + "fGB", Double.valueOf(j10 / 1.073741824E9d));
    }

    public static double g(long j10, int i10) {
        if (j10 < 0) {
            return -1.0d;
        }
        return j10 / ((double) i10);
    }

    public static Bitmap h(byte[] bArr) {
        return l1.j(bArr);
    }

    public static String i(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            for (int i10 = 7; i10 >= 0; i10--) {
                sb2.append(((b10 >> i10) & 1) == 0 ? '0' : '1');
            }
        }
        return sb2.toString();
    }

    public static char[] j(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return null;
        }
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = (char) (bArr[i10] & 255);
        }
        return cArr;
    }

    public static Drawable k(byte[] bArr) {
        return l1.k(bArr);
    }

    public static String l(byte[] bArr) {
        return m(bArr, true);
    }

    public static String m(byte[] bArr, boolean z10) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = z10 ? f12004b : f12005c;
        int length = bArr.length;
        if (length <= 0) {
            return "";
        }
        char[] cArr2 = new char[length << 1];
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = i10 + 1;
            cArr2[i10] = cArr[(bArr[i11] >> 4) & 15];
            i10 = i12 + 1;
            cArr2[i12] = cArr[bArr[i11] & 15];
        }
        return new String(cArr2);
    }

    public static InputStream n(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        return new ByteArrayInputStream(bArr);
    }

    public static JSONArray o(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new JSONArray(new String(bArr));
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static JSONObject p(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new JSONObject(new String(bArr));
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object q(byte[] r3) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r3 != 0) goto L4
            return r0
        L4:
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L1d java.lang.Exception -> L1f
            java.lang.Object r3 = r1.readObject()     // Catch: java.lang.Exception -> L1b java.lang.Throwable -> L2f
            r1.close()     // Catch: java.io.IOException -> L16
            goto L1a
        L16:
            r0 = move-exception
            r0.printStackTrace()
        L1a:
            return r3
        L1b:
            r3 = move-exception
            goto L21
        L1d:
            r3 = move-exception
            goto L31
        L1f:
            r3 = move-exception
            r1 = r0
        L21:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L2f
            if (r1 == 0) goto L2e
            r1.close()     // Catch: java.io.IOException -> L2a
            goto L2e
        L2a:
            r3 = move-exception
            r3.printStackTrace()
        L2e:
            return r0
        L2f:
            r3 = move-exception
            r0 = r1
        L31:
            if (r0 == 0) goto L3b
            r0.close()     // Catch: java.io.IOException -> L37
            goto L3b
        L37:
            r0 = move-exception
            r0.printStackTrace()
        L3b:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.u.q(byte[]):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.io.OutputStream r(byte[] r2) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r2 == 0) goto L39
            int r1 = r2.length
            if (r1 > 0) goto L7
            goto L39
        L7:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L1c
            r1.<init>()     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L1c
            r1.write(r2)     // Catch: java.io.IOException -> L18 java.lang.Throwable -> L2c
            r1.close()     // Catch: java.io.IOException -> L13
            goto L17
        L13:
            r2 = move-exception
            r2.printStackTrace()
        L17:
            return r1
        L18:
            r2 = move-exception
            goto L1e
        L1a:
            r2 = move-exception
            goto L2e
        L1c:
            r2 = move-exception
            r1 = r0
        L1e:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L2b
            r1.close()     // Catch: java.io.IOException -> L27
            goto L2b
        L27:
            r2 = move-exception
            r2.printStackTrace()
        L2b:
            return r0
        L2c:
            r2 = move-exception
            r0 = r1
        L2e:
            if (r0 == 0) goto L38
            r0.close()     // Catch: java.io.IOException -> L34
            goto L38
        L34:
            r0 = move-exception
            r0.printStackTrace()
        L38:
            throw r2
        L39:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.u.r(byte[]):java.io.OutputStream");
    }

    public static <T> T s(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        T tCreateFromParcel = creator.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return tCreateFromParcel;
    }

    public static String t(byte[] bArr) {
        return u(bArr, "");
    }

    public static String u(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, A(str));
        } catch (UnsupportedEncodingException e10) {
            e10.printStackTrace();
            return new String(bArr);
        }
    }

    public static byte[] v(char[] cArr) {
        if (cArr == null || cArr.length <= 0) {
            return null;
        }
        int length = cArr.length;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr[i10] = (byte) cArr[i10];
        }
        return bArr;
    }

    public static int w(float f10) {
        return l1.w(f10);
    }

    public static Bitmap x(Drawable drawable) {
        return l1.x(drawable);
    }

    public static byte[] y(Drawable drawable) {
        return l1.y(drawable);
    }

    public static byte[] z(Drawable drawable, Bitmap.CompressFormat compressFormat, int i10) {
        return l1.z(drawable, compressFormat, i10);
    }
}
