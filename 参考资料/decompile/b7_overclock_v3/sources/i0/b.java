package i0;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import g.a1;
import g.n0;
import g.p0;
import g.u;
import g.v0;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    @v0(28)
    public static class a {
        @u
        @p0
        public static Signature[] a(@n0 SigningInfo signingInfo) {
            return signingInfo.getApkContentsSigners();
        }

        @u
        public static long b(PackageInfo packageInfo) {
            return packageInfo.getLongVersionCode();
        }

        @u
        @p0
        public static Signature[] c(@n0 SigningInfo signingInfo) {
            return signingInfo.getSigningCertificateHistory();
        }

        @u
        public static boolean d(@n0 SigningInfo signingInfo) {
            return signingInfo.hasMultipleSigners();
        }

        @u
        public static boolean e(@n0 PackageManager packageManager, @n0 String str, @n0 byte[] bArr, int i10) {
            return packageManager.hasSigningCertificate(str, bArr, i10);
        }
    }

    public static boolean a(@n0 byte[][] bArr, @n0 byte[] bArr2) {
        for (byte[] bArr3 : bArr) {
            if (Arrays.equals(bArr2, bArr3)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] b(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA256").digest(bArr);
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException("Device doesn't support SHA256 cert checking", e10);
        }
    }

    public static long c(@n0 PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? a.b(packageInfo) : packageInfo.versionCode;
    }

    @n0
    public static List<Signature> d(@n0 PackageManager packageManager, @n0 String str) throws PackageManager.NameNotFoundException {
        Signature[] signatureArrA;
        if (Build.VERSION.SDK_INT >= 28) {
            SigningInfo signingInfo = packageManager.getPackageInfo(str, 134217728).signingInfo;
            signatureArrA = a.d(signingInfo) ? a.a(signingInfo) : a.c(signingInfo);
        } else {
            signatureArrA = packageManager.getPackageInfo(str, 64).signatures;
        }
        return signatureArrA == null ? Collections.emptyList() : Arrays.asList(signatureArrA);
    }

    public static boolean e(@n0 PackageManager packageManager, @n0 String str, @a1(min = 1) @n0 Map<byte[], Integer> map, boolean z10) throws PackageManager.NameNotFoundException {
        if (map.isEmpty()) {
            return false;
        }
        Set<byte[]> setKeySet = map.keySet();
        for (byte[] bArr : setKeySet) {
            if (bArr == null) {
                throw new IllegalArgumentException("Cert byte array cannot be null when verifying " + str);
            }
            Integer num = map.get(bArr);
            if (num == null) {
                throw new IllegalArgumentException("Type must be specified for cert when verifying " + str);
            }
            int iIntValue = num.intValue();
            if (iIntValue != 0 && iIntValue != 1) {
                throw new IllegalArgumentException("Unsupported certificate type " + num + " when verifying " + str);
            }
        }
        List<Signature> listD = d(packageManager, str);
        if (!z10 && Build.VERSION.SDK_INT >= 28) {
            for (byte[] bArr2 : setKeySet) {
                if (!a.e(packageManager, str, bArr2, map.get(bArr2).intValue())) {
                    return false;
                }
            }
            return true;
        }
        if (listD.size() != 0 && map.size() <= listD.size() && (!z10 || map.size() == listD.size())) {
            byte[][] bArr3 = null;
            if (map.containsValue(1)) {
                bArr3 = new byte[listD.size()][];
                for (int i10 = 0; i10 < listD.size(); i10++) {
                    bArr3[i10] = b(listD.get(i10).toByteArray());
                }
            }
            Iterator<byte[]> it2 = setKeySet.iterator();
            if (it2.hasNext()) {
                byte[] next = it2.next();
                Integer num2 = map.get(next);
                int iIntValue2 = num2.intValue();
                if (iIntValue2 != 0) {
                    if (iIntValue2 != 1) {
                        throw new IllegalArgumentException("Unsupported certificate type " + num2);
                    }
                    if (!a(bArr3, next)) {
                        return false;
                    }
                } else if (!listD.contains(new Signature(next))) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
