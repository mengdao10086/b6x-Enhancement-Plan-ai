package com.blankj.utilcode.util;

import android.os.Build;
import java.io.File;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* JADX INFO: loaded from: classes2.dex */
public final class z {
    public z() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String A(byte[] bArr, byte[] bArr2) {
        return l1.l(y(bArr, bArr2));
    }

    public static byte[] B(byte[] bArr, byte[] bArr2) {
        return s0(bArr, bArr2, "HmacSHA224");
    }

    public static String C(String str, String str2) {
        return (str == null || str.length() == 0 || str2 == null || str2.length() == 0) ? "" : D(str.getBytes(), str2.getBytes());
    }

    public static String D(byte[] bArr, byte[] bArr2) {
        return l1.l(B(bArr, bArr2));
    }

    public static byte[] E(byte[] bArr, byte[] bArr2) {
        return s0(bArr, bArr2, "HmacSHA256");
    }

    public static String F(String str, String str2) {
        return (str == null || str.length() == 0 || str2 == null || str2.length() == 0) ? "" : G(str.getBytes(), str2.getBytes());
    }

    public static String G(byte[] bArr, byte[] bArr2) {
        return l1.l(E(bArr, bArr2));
    }

    public static byte[] H(byte[] bArr, byte[] bArr2) {
        return s0(bArr, bArr2, "HmacSHA384");
    }

    public static String I(String str, String str2) {
        return (str == null || str.length() == 0 || str2 == null || str2.length() == 0) ? "" : J(str.getBytes(), str2.getBytes());
    }

    public static String J(byte[] bArr, byte[] bArr2) {
        return l1.l(H(bArr, bArr2));
    }

    public static byte[] K(byte[] bArr, byte[] bArr2) {
        return s0(bArr, bArr2, "HmacSHA512");
    }

    public static String L(String str, String str2) {
        return (str == null || str.length() == 0 || str2 == null || str2.length() == 0) ? "" : M(str.getBytes(), str2.getBytes());
    }

    public static String M(byte[] bArr, byte[] bArr2) {
        return l1.l(K(bArr, bArr2));
    }

    public static byte[] N(byte[] bArr) {
        return r0(bArr, "MD2");
    }

    public static String O(String str) {
        return (str == null || str.length() == 0) ? "" : P(str.getBytes());
    }

    public static String P(byte[] bArr) {
        return l1.l(N(bArr));
    }

    public static byte[] Q(byte[] bArr) {
        return r0(bArr, "MD5");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0048: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:33:0x0048 */
    /* JADX WARN: Removed duplicated region for block: B:43:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] R(java.io.File r4) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35 java.security.NoSuchAlgorithmException -> L37
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35 java.security.NoSuchAlgorithmException -> L37
            java.lang.String r4 = "MD5"
            java.security.MessageDigest r4 = java.security.MessageDigest.getInstance(r4)     // Catch: java.io.IOException -> L2f java.security.NoSuchAlgorithmException -> L31 java.lang.Throwable -> L47
            java.security.DigestInputStream r2 = new java.security.DigestInputStream     // Catch: java.io.IOException -> L2f java.security.NoSuchAlgorithmException -> L31 java.lang.Throwable -> L47
            r2.<init>(r1, r4)     // Catch: java.io.IOException -> L2f java.security.NoSuchAlgorithmException -> L31 java.lang.Throwable -> L47
            r4 = 262144(0x40000, float:3.67342E-40)
            byte[] r4 = new byte[r4]     // Catch: java.io.IOException -> L2f java.security.NoSuchAlgorithmException -> L31 java.lang.Throwable -> L47
        L18:
            int r3 = r2.read(r4)     // Catch: java.io.IOException -> L2f java.security.NoSuchAlgorithmException -> L31 java.lang.Throwable -> L47
            if (r3 > 0) goto L18
            java.security.MessageDigest r4 = r2.getMessageDigest()     // Catch: java.io.IOException -> L2f java.security.NoSuchAlgorithmException -> L31 java.lang.Throwable -> L47
            byte[] r4 = r4.digest()     // Catch: java.io.IOException -> L2f java.security.NoSuchAlgorithmException -> L31 java.lang.Throwable -> L47
            r1.close()     // Catch: java.io.IOException -> L2a
            goto L2e
        L2a:
            r0 = move-exception
            r0.printStackTrace()
        L2e:
            return r4
        L2f:
            r4 = move-exception
            goto L39
        L31:
            r4 = move-exception
            goto L39
        L33:
            r4 = move-exception
            goto L49
        L35:
            r4 = move-exception
            goto L38
        L37:
            r4 = move-exception
        L38:
            r1 = r0
        L39:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L47
            if (r1 == 0) goto L46
            r1.close()     // Catch: java.io.IOException -> L42
            goto L46
        L42:
            r4 = move-exception
            r4.printStackTrace()
        L46:
            return r0
        L47:
            r4 = move-exception
            r0 = r1
        L49:
            if (r0 == 0) goto L53
            r0.close()     // Catch: java.io.IOException -> L4f
            goto L53
        L4f:
            r0 = move-exception
            r0.printStackTrace()
        L53:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.z.R(java.io.File):byte[]");
    }

    public static byte[] S(String str) {
        return R(l1.C0(str) ? null : new File(str));
    }

    public static String T(File file) {
        return l1.l(R(file));
    }

    public static String U(String str) {
        return T(l1.C0(str) ? null : new File(str));
    }

    public static String V(String str) {
        return (str == null || str.length() == 0) ? "" : X(str.getBytes());
    }

    public static String W(String str, String str2) {
        if (str == null && str2 == null) {
            return "";
        }
        if (str2 == null) {
            return l1.l(Q(str.getBytes()));
        }
        if (str == null) {
            return l1.l(Q(str2.getBytes()));
        }
        return l1.l(Q((str + str2).getBytes()));
    }

    public static String X(byte[] bArr) {
        return l1.l(Q(bArr));
    }

    public static String Y(byte[] bArr, byte[] bArr2) {
        if (bArr == null && bArr2 == null) {
            return "";
        }
        if (bArr2 == null) {
            return l1.l(Q(bArr));
        }
        if (bArr == null) {
            return l1.l(Q(bArr2));
        }
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return l1.l(Q(bArr3));
    }

    public static byte[] Z(byte[] bArr, byte[] bArr2, int i10, String str) {
        return v0(bArr, bArr2, i10, str, true);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return w0(bArr, bArr2, "DESede", str, bArr3, false);
    }

    public static byte[] a0(byte[] bArr, byte[] bArr2, int i10, String str) {
        return l1.e(Z(bArr, bArr2, i10, str));
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return w0(bArr, bArr2, m5.b.f40641c, str, bArr3, false);
    }

    public static String b0(byte[] bArr, byte[] bArr2, int i10, String str) {
        return l1.l(Z(bArr, bArr2, i10, str));
    }

    public static byte[] c(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return b(l1.d(bArr), bArr2, str, bArr3);
    }

    public static byte[] c0(byte[] bArr) {
        return r0(bArr, et.e.f27137f);
    }

    public static byte[] d(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return g(l1.d(bArr), bArr2, str, bArr3);
    }

    public static String d0(String str) {
        return (str == null || str.length() == 0) ? "" : e0(str.getBytes());
    }

    public static byte[] e(byte[] bArr, byte[] bArr2, int i10, String str) {
        return l(l1.d(bArr), bArr2, i10, str);
    }

    public static String e0(byte[] bArr) {
        return l1.l(c0(bArr));
    }

    public static byte[] f(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return a(l1.d(bArr), bArr2, str, bArr3);
    }

    public static byte[] f0(byte[] bArr) {
        return r0(bArr, "SHA224");
    }

    public static byte[] g(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return w0(bArr, bArr2, "DES", str, bArr3, false);
    }

    public static String g0(String str) {
        return (str == null || str.length() == 0) ? "" : h0(str.getBytes());
    }

    public static byte[] h(String str, byte[] bArr, String str2, byte[] bArr2) {
        return a(l1.k0(str), bArr, str2, bArr2);
    }

    public static String h0(byte[] bArr) {
        return l1.l(f0(bArr));
    }

    public static byte[] i(String str, byte[] bArr, String str2, byte[] bArr2) {
        return b(l1.k0(str), bArr, str2, bArr2);
    }

    public static byte[] i0(byte[] bArr) {
        return r0(bArr, "SHA-256");
    }

    public static byte[] j(String str, byte[] bArr, String str2, byte[] bArr2) {
        return g(l1.k0(str), bArr, str2, bArr2);
    }

    public static String j0(String str) {
        return (str == null || str.length() == 0) ? "" : k0(str.getBytes());
    }

    public static byte[] k(String str, byte[] bArr, int i10, String str2) {
        return l(l1.k0(str), bArr, i10, str2);
    }

    public static String k0(byte[] bArr) {
        return l1.l(i0(bArr));
    }

    public static byte[] l(byte[] bArr, byte[] bArr2, int i10, String str) {
        return v0(bArr, bArr2, i10, str, false);
    }

    public static byte[] l0(byte[] bArr) {
        return r0(bArr, et.e.f27140i);
    }

    public static byte[] m(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return w0(bArr, bArr2, "DESede", str, bArr3, true);
    }

    public static String m0(String str) {
        return (str == null || str.length() == 0) ? "" : n0(str.getBytes());
    }

    public static byte[] n(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return l1.e(m(bArr, bArr2, str, bArr3));
    }

    public static String n0(byte[] bArr) {
        return l1.l(l0(bArr));
    }

    public static String o(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return l1.l(m(bArr, bArr2, str, bArr3));
    }

    public static byte[] o0(byte[] bArr) {
        return r0(bArr, "SHA-512");
    }

    public static byte[] p(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return w0(bArr, bArr2, m5.b.f40641c, str, bArr3, true);
    }

    public static String p0(String str) {
        return (str == null || str.length() == 0) ? "" : q0(str.getBytes());
    }

    public static byte[] q(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return l1.e(p(bArr, bArr2, str, bArr3));
    }

    public static String q0(byte[] bArr) {
        return l1.l(o0(bArr));
    }

    public static String r(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return l1.l(p(bArr, bArr2, str, bArr3));
    }

    public static byte[] r0(byte[] bArr, String str) {
        if (bArr != null && bArr.length > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                messageDigest.update(bArr);
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] s(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return w0(bArr, bArr2, "DES", str, bArr3, true);
    }

    public static byte[] s0(byte[] bArr, byte[] bArr2, String str) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, str);
                Mac mac = Mac.getInstance(str);
                mac.init(secretKeySpec);
                return mac.doFinal(bArr);
            } catch (InvalidKeyException | NoSuchAlgorithmException e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] t(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return l1.e(s(bArr, bArr2, str, bArr3));
    }

    public static byte[] t0(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static String u(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) {
        return l1.l(s(bArr, bArr2, str, bArr3));
    }

    public static byte[] u0(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || bArr2 == null) {
            return null;
        }
        if (bArr2.length < 1 || bArr2.length > 256) {
            throw new IllegalArgumentException("key must be between 1 and 256 bytes");
        }
        byte[] bArr3 = new byte[256];
        byte[] bArr4 = new byte[256];
        int length = bArr2.length;
        for (int i10 = 0; i10 < 256; i10++) {
            bArr3[i10] = (byte) i10;
            bArr4[i10] = bArr2[i10 % length];
        }
        int i11 = 0;
        for (int i12 = 0; i12 < 256; i12++) {
            i11 = (i11 + bArr3[i12] + bArr4[i12]) & 255;
            byte b10 = bArr3[i11];
            bArr3[i11] = bArr3[i12];
            bArr3[i12] = b10;
        }
        byte[] bArr5 = new byte[bArr.length];
        int i13 = 0;
        for (int i14 = 0; i14 < bArr.length; i14++) {
            i13 = (i13 + 1) & 255;
            i11 = (i11 + bArr3[i13]) & 255;
            byte b11 = bArr3[i11];
            bArr3[i11] = bArr3[i13];
            bArr3[i13] = b11;
            bArr5[i14] = (byte) (bArr3[(bArr3[i13] + bArr3[i11]) & 255] ^ bArr[i14]);
        }
        return bArr5;
    }

    public static byte[] v(byte[] bArr, byte[] bArr2) {
        return s0(bArr, bArr2, "HmacMD5");
    }

    public static byte[] v0(byte[] bArr, byte[] bArr2, int i10, String str, boolean z10) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            try {
                KeyFactory keyFactory = Build.VERSION.SDK_INT < 28 ? KeyFactory.getInstance("RSA", BouncyCastleProvider.f45329b) : KeyFactory.getInstance("RSA");
                Key keyGeneratePublic = z10 ? keyFactory.generatePublic(new X509EncodedKeySpec(bArr2)) : keyFactory.generatePrivate(new PKCS8EncodedKeySpec(bArr2));
                if (keyGeneratePublic == null) {
                    return null;
                }
                Cipher cipher = Cipher.getInstance(str);
                cipher.init(z10 ? 1 : 2, keyGeneratePublic);
                int length = bArr.length;
                int i11 = i10 / 8;
                if (z10 && str.toLowerCase().endsWith("pkcs1padding")) {
                    i11 -= 11;
                }
                int i12 = length / i11;
                if (i12 <= 0) {
                    return cipher.doFinal(bArr);
                }
                byte[] bArrT0 = new byte[0];
                byte[] bArr3 = new byte[i11];
                int i13 = 0;
                for (int i14 = 0; i14 < i12; i14++) {
                    System.arraycopy(bArr, i13, bArr3, 0, i11);
                    bArrT0 = t0(bArrT0, cipher.doFinal(bArr3));
                    i13 += i11;
                }
                if (i13 == length) {
                    return bArrT0;
                }
                int i15 = length - i13;
                byte[] bArr4 = new byte[i15];
                System.arraycopy(bArr, i13, bArr4, 0, i15);
                return t0(bArrT0, cipher.doFinal(bArr4));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    public static String w(String str, String str2) {
        return (str == null || str.length() == 0 || str2 == null || str2.length() == 0) ? "" : x(str.getBytes(), str2.getBytes());
    }

    public static byte[] w0(byte[] bArr, byte[] bArr2, String str, String str2, byte[] bArr3, boolean z10) {
        SecretKey secretKeySpec;
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            try {
                if ("DES".equals(str)) {
                    secretKeySpec = SecretKeyFactory.getInstance(str).generateSecret(new DESKeySpec(bArr2));
                } else {
                    secretKeySpec = new SecretKeySpec(bArr2, str);
                }
                Cipher cipher = Cipher.getInstance(str2);
                int i10 = 1;
                if (bArr3 == null || bArr3.length == 0) {
                    if (!z10) {
                        i10 = 2;
                    }
                    cipher.init(i10, secretKeySpec);
                } else {
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
                    if (!z10) {
                        i10 = 2;
                    }
                    cipher.init(i10, secretKeySpec, ivParameterSpec);
                }
                return cipher.doFinal(bArr);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return null;
    }

    public static String x(byte[] bArr, byte[] bArr2) {
        return l1.l(v(bArr, bArr2));
    }

    public static byte[] y(byte[] bArr, byte[] bArr2) {
        return s0(bArr, bArr2, hh.c.f31295a);
    }

    public static String z(String str, String str2) {
        return (str == null || str.length() == 0 || str2 == null || str2.length() == 0) ? "" : A(str.getBytes(), str2.getBytes());
    }
}
