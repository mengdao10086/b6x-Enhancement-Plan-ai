package com.blankj.utilcode.util;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.common.net.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f11700a = System.getProperty("line.separator");

    public static class a implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return true;
        }
    }

    public static class b implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.isFile();
        }
    }

    public static class c implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return true;
        }
    }

    public interface d {
        boolean a(File file, File file2);
    }

    public b0() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String A(String str) {
        int iLastIndexOf;
        return (l1.C0(str) || (iLastIndexOf = str.lastIndexOf(File.separator)) == -1) ? "" : str.substring(0, iLastIndexOf + 1);
    }

    public static List<File> A0(String str, FileFilter fileFilter, boolean z10) {
        return w0(C(str), fileFilter, z10);
    }

    public static String B(File file) {
        long jY = y(file);
        return jY == -1 ? "" : l1.i(jY);
    }

    public static List<File> B0(String str, FileFilter fileFilter, boolean z10, Comparator<File> comparator) {
        return x0(C(str), fileFilter, z10, comparator);
    }

    public static File C(String str) {
        if (l1.C0(str)) {
            return null;
        }
        return new File(str);
    }

    public static List<File> C0(File file, FileFilter fileFilter, boolean z10) {
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        if (c0(file) && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (fileFilter.accept(file2)) {
                    arrayList.add(file2);
                }
                if (z10 && file2.isDirectory()) {
                    arrayList.addAll(C0(file2, fileFilter, true));
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x004f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String D(java.io.File r4) throws java.lang.Throwable {
        /*
            if (r4 != 0) goto L5
            java.lang.String r4 = ""
            return r4
        L5:
            boolean r0 = k0(r4)
            if (r0 == 0) goto Le
            java.lang.String r4 = "UTF-8"
            return r4
        Le:
            r0 = 0
            r1 = 0
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L36
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L36
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L36
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L36
            int r4 = r2.read()     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L31
            int r4 = r4 << 8
            int r0 = r2.read()     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L31
            int r0 = r0 + r4
            r2.close()     // Catch: java.io.IOException -> L29
            goto L3f
        L29:
            r4 = move-exception
            r4.printStackTrace()
            goto L3f
        L2e:
            r4 = move-exception
            r1 = r2
            goto L52
        L31:
            r4 = move-exception
            r1 = r2
            goto L37
        L34:
            r4 = move-exception
            goto L52
        L36:
            r4 = move-exception
        L37:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto L3f
            r1.close()     // Catch: java.io.IOException -> L29
        L3f:
            r4 = 65279(0xfeff, float:9.1475E-41)
            if (r0 == r4) goto L4f
            r4 = 65534(0xfffe, float:9.1833E-41)
            if (r0 == r4) goto L4c
            java.lang.String r4 = "GBK"
            return r4
        L4c:
            java.lang.String r4 = "Unicode"
            return r4
        L4f:
            java.lang.String r4 = "UTF-16BE"
            return r4
        L52:
            if (r1 == 0) goto L5c
            r1.close()     // Catch: java.io.IOException -> L58
            goto L5c
        L58:
            r0 = move-exception
            r0.printStackTrace()
        L5c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.b0.D(java.io.File):java.lang.String");
    }

    public static boolean D0(File file, File file2) {
        return E0(file, file2, null);
    }

    public static String E(String str) {
        return D(C(str));
    }

    public static boolean E0(File file, File file2, d dVar) {
        if (file == null) {
            return false;
        }
        return file.isDirectory() ? H0(file, file2, dVar) : I0(file, file2, dVar);
    }

    public static String F(File file) {
        return file == null ? "" : G(file.getPath());
    }

    public static boolean F0(String str, String str2) {
        return E0(C(str), C(str2), null);
    }

    public static String G(String str) {
        if (l1.C0(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        return (iLastIndexOf == -1 || str.lastIndexOf(File.separator) >= iLastIndexOf) ? "" : str.substring(iLastIndexOf + 1);
    }

    public static boolean G0(String str, String str2, d dVar) {
        return E0(C(str), C(str2), dVar);
    }

    public static long H(File file) {
        if (file == null) {
            return -1L;
        }
        return file.lastModified();
    }

    public static boolean H0(File file, File file2, d dVar) {
        return g(file, file2, dVar, true);
    }

    public static long I(String str) {
        return H(C(str));
    }

    public static boolean I0(File file, File file2, d dVar) {
        return h(file, file2, dVar, true);
    }

    public static long J(File file) {
        if (e0(file)) {
            return file.length();
        }
        return -1L;
    }

    public static void J0(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.parse("file://" + file.getAbsolutePath()));
        j1.a().sendBroadcast(intent);
    }

    public static long K(String str) {
        if (str.matches(w3.d.f53872g)) {
            try {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                httpsURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, HlsPlaylistParser.S);
                httpsURLConnection.connect();
                if (httpsURLConnection.getResponseCode() == 200) {
                    return httpsURLConnection.getContentLength();
                }
                return -1L;
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        }
        return J(C(str));
    }

    public static void K0(String str) {
        J0(C(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0049 -> B:45:0x005e). Please report as a decompilation issue!!! */
    public static int L(File file) throws Throwable {
        BufferedInputStream bufferedInputStream;
        int i10 = 1;
        ?? r12 = 0;
        r12 = 0;
        r12 = 0;
        try {
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                } catch (IOException e10) {
                    e10.printStackTrace();
                    r12 = r12;
                }
            } catch (IOException e11) {
                e = e11;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            byte[] bArr = new byte[1024];
            if (!f11700a.endsWith("\n")) {
                while (true) {
                    int i11 = bufferedInputStream.read(bArr, 0, 1024);
                    if (i11 == -1) {
                        break;
                    }
                    for (int i12 = 0; i12 < i11; i12++) {
                        if (bArr[i12] == 13) {
                            i10++;
                        }
                    }
                }
            } else {
                while (true) {
                    int i13 = bufferedInputStream.read(bArr, 0, 1024);
                    if (i13 == -1) {
                        break;
                    }
                    for (int i14 = 0; i14 < i13; i14++) {
                        if (bArr[i14] == 10) {
                            i10++;
                        }
                    }
                }
            }
            bufferedInputStream.close();
            r12 = bArr;
        } catch (IOException e12) {
            e = e12;
            r12 = bufferedInputStream;
            e.printStackTrace();
            if (r12 != 0) {
                r12.close();
                r12 = r12;
            }
            return i10;
        } catch (Throwable th3) {
            th = th3;
            r12 = bufferedInputStream;
            if (r12 != 0) {
                try {
                    r12.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            throw th;
        }
        return i10;
    }

    public static boolean L0(File file, String str) {
        if (file == null || !file.exists() || l1.C0(str)) {
            return false;
        }
        if (str.equals(file.getName())) {
            return true;
        }
        File file2 = new File(file.getParent() + File.separator + str);
        return !file2.exists() && file.renameTo(file2);
    }

    public static int M(String str) {
        return L(C(str));
    }

    public static boolean M0(String str, String str2) {
        return L0(C(str), str2);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0048: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:34:0x0048 */
    /* JADX WARN: Removed duplicated region for block: B:44:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] N(java.io.File r3) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r3 != 0) goto L4
            return r0
        L4:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35 java.security.NoSuchAlgorithmException -> L37
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35 java.security.NoSuchAlgorithmException -> L37
            java.lang.String r3 = "MD5"
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r3)     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35 java.security.NoSuchAlgorithmException -> L37
            java.security.DigestInputStream r2 = new java.security.DigestInputStream     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35 java.security.NoSuchAlgorithmException -> L37
            r2.<init>(r1, r3)     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L35 java.security.NoSuchAlgorithmException -> L37
            r3 = 262144(0x40000, float:3.67342E-40)
            byte[] r3 = new byte[r3]     // Catch: java.io.IOException -> L2f java.security.NoSuchAlgorithmException -> L31 java.lang.Throwable -> L47
        L18:
            int r1 = r2.read(r3)     // Catch: java.io.IOException -> L2f java.security.NoSuchAlgorithmException -> L31 java.lang.Throwable -> L47
            if (r1 > 0) goto L18
            java.security.MessageDigest r3 = r2.getMessageDigest()     // Catch: java.io.IOException -> L2f java.security.NoSuchAlgorithmException -> L31 java.lang.Throwable -> L47
            byte[] r3 = r3.digest()     // Catch: java.io.IOException -> L2f java.security.NoSuchAlgorithmException -> L31 java.lang.Throwable -> L47
            r2.close()     // Catch: java.io.IOException -> L2a
            goto L2e
        L2a:
            r0 = move-exception
            r0.printStackTrace()
        L2e:
            return r3
        L2f:
            r3 = move-exception
            goto L39
        L31:
            r3 = move-exception
            goto L39
        L33:
            r3 = move-exception
            goto L49
        L35:
            r3 = move-exception
            goto L38
        L37:
            r3 = move-exception
        L38:
            r2 = r0
        L39:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L47
            if (r2 == 0) goto L46
            r2.close()     // Catch: java.io.IOException -> L42
            goto L46
        L42:
            r3 = move-exception
            r3.printStackTrace()
        L46:
            return r0
        L47:
            r3 = move-exception
            r0 = r2
        L49:
            if (r0 == 0) goto L53
            r0.close()     // Catch: java.io.IOException -> L4f
            goto L53
        L4f:
            r0 = move-exception
            r0.printStackTrace()
        L53:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.b0.N(java.io.File):byte[]");
    }

    public static byte[] O(String str) {
        return N(C(str));
    }

    public static String P(File file) {
        return l1.l(N(file));
    }

    public static String Q(String str) {
        return P(l1.C0(str) ? null : new File(str));
    }

    public static String R(File file) {
        return file == null ? "" : S(file.getAbsolutePath());
    }

    public static String S(String str) {
        if (l1.C0(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(File.separator);
        return iLastIndexOf == -1 ? str : str.substring(iLastIndexOf + 1);
    }

    public static String T(File file) {
        return file == null ? "" : U(file.getPath());
    }

    public static String U(String str) {
        if (l1.C0(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        int iLastIndexOf2 = str.lastIndexOf(File.separator);
        return iLastIndexOf2 == -1 ? iLastIndexOf == -1 ? str : str.substring(0, iLastIndexOf) : (iLastIndexOf == -1 || iLastIndexOf2 > iLastIndexOf) ? str.substring(iLastIndexOf2 + 1) : str.substring(iLastIndexOf2 + 1, iLastIndexOf);
    }

    public static String V(File file) {
        long J = J(file);
        return J == -1 ? "" : l1.i(J);
    }

    public static long W(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        StatFs statFs = new StatFs(str);
        return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
    }

    public static long X(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        StatFs statFs = new StatFs(str);
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    public static long Y(File file) {
        if (file == null) {
            return 0L;
        }
        return file.isDirectory() ? y(file) : J(file);
    }

    public static long Z(String str) {
        return Y(C(str));
    }

    public static boolean a(File file, File file2) {
        return b(file, file2, null);
    }

    public static String a0(File file) {
        return file == null ? "" : file.isDirectory() ? B(file) : V(file);
    }

    public static boolean b(File file, File file2, d dVar) {
        if (file == null) {
            return false;
        }
        return file.isDirectory() ? e(file, file2, dVar) : f(file, file2, dVar);
    }

    public static String b0(String str) {
        return a0(C(str));
    }

    public static boolean c(String str, String str2) {
        return b(C(str), C(str2), null);
    }

    public static boolean c0(File file) {
        return file != null && file.exists() && file.isDirectory();
    }

    public static boolean d(String str, String str2, d dVar) {
        return b(C(str), C(str2), dVar);
    }

    public static boolean d0(String str) {
        return c0(C(str));
    }

    public static boolean e(File file, File file2, d dVar) {
        return g(file, file2, dVar, false);
    }

    public static boolean e0(File file) {
        return file != null && file.exists() && file.isFile();
    }

    public static boolean f(File file, File file2, d dVar) {
        return h(file, file2, dVar, false);
    }

    public static boolean f0(String str) {
        return e0(C(str));
    }

    public static boolean g(File file, File file2, d dVar, boolean z10) {
        if (file == null || file2 == null) {
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(file.getPath());
        String str = File.separator;
        sb2.append(str);
        String string = sb2.toString();
        String str2 = file2.getPath() + str;
        if (str2.contains(string) || !file.exists() || !file.isDirectory() || !k(file2)) {
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file3 : fileArrListFiles) {
                File file4 = new File(str2 + file3.getName());
                if (file3.isFile()) {
                    if (!h(file3, file4, dVar, z10)) {
                        return false;
                    }
                } else if (file3.isDirectory() && !g(file3, file4, dVar, z10)) {
                    return false;
                }
            }
        }
        return !z10 || s(file);
    }

    public static boolean g0(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        return h0(file.getAbsolutePath());
    }

    public static boolean h(File file, File file2, d dVar, boolean z10) {
        if (file != null && file2 != null && !file.equals(file2) && file.exists() && file.isFile()) {
            if (file2.exists()) {
                if (dVar != null && !dVar.a(file, file2)) {
                    return true;
                }
                if (!file2.delete()) {
                    return false;
                }
            }
            if (!k(file2.getParentFile())) {
                return false;
            }
            try {
                if (!l1.h1(file2.getAbsolutePath(), new FileInputStream(file))) {
                    return false;
                }
                if (z10) {
                    if (!t(file)) {
                        return false;
                    }
                }
                return true;
            } catch (FileNotFoundException e10) {
                e10.printStackTrace();
            }
        }
        return false;
    }

    public static boolean h0(String str) {
        File fileC = C(str);
        if (fileC == null) {
            return false;
        }
        if (fileC.exists()) {
            return true;
        }
        return i0(str);
    }

    public static boolean i(File file) {
        if (file == null) {
            return false;
        }
        if ((file.exists() && !file.delete()) || !k(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static boolean i0(String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = j1.a().getContentResolver().openAssetFileDescriptor(Uri.parse(str), SsManifestParser.e.J);
                if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                    return false;
                }
                try {
                    assetFileDescriptorOpenAssetFileDescriptor.close();
                    return true;
                } catch (IOException unused) {
                    return true;
                }
            } catch (FileNotFoundException unused2) {
            }
        }
        return false;
    }

    public static boolean j(String str) {
        return i(C(str));
    }

    public static int j0(byte[] bArr) {
        if (bArr.length > 3 && bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65) {
            return 100;
        }
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        loop0: while (true) {
            int length2 = 0;
            while (i10 < length) {
                if ((bArr[i10] & (-1)) == -1 || (bArr[i10] & (-2)) == -2) {
                    break loop0;
                }
                if (length2 == 0) {
                    if ((bArr[i10] & 127) == bArr[i10] && bArr[i10] != 0) {
                        i11++;
                    } else if ((bArr[i10] & i1.a.f31667o7) == -64) {
                        int i13 = length2;
                        for (int i14 = 0; i14 < 8; i14++) {
                            byte b10 = (byte) (128 >> i14);
                            if ((bArr[i10] & b10) != b10) {
                                break;
                            }
                            i13 = i14;
                        }
                        i12++;
                        length2 = i13;
                    }
                    i10++;
                } else {
                    if (bArr.length - i10 <= length2) {
                        length2 = bArr.length - i10;
                    }
                    boolean z10 = false;
                    for (int i15 = 0; i15 < length2; i15++) {
                        int i16 = i10 + i15;
                        if ((bArr[i16] & (-128)) != -128) {
                            if ((bArr[i16] & 127) == bArr[i16] && bArr[i10] != 0) {
                                i11++;
                            }
                            z10 = true;
                        }
                    }
                    if (z10) {
                        i12--;
                        i10++;
                    } else {
                        i12 += length2;
                        i10 += length2;
                    }
                }
            }
            if (i11 == length) {
                return 100;
            }
            return (int) (((i12 + i11) / length) * 100.0f);
        }
        return 0;
    }

    public static boolean k(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    public static boolean k0(File file) throws Throwable {
        byte[] bArr;
        BufferedInputStream bufferedInputStream;
        if (file == null) {
            return false;
        }
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bArr = new byte[24];
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e10) {
            e = e10;
        }
        try {
            int i10 = bufferedInputStream.read(bArr);
            if (i10 == -1) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
                return false;
            }
            byte[] bArr2 = new byte[i10];
            System.arraycopy(bArr, 0, bArr2, 0, i10);
            boolean z10 = j0(bArr2) == 100;
            try {
                bufferedInputStream.close();
            } catch (IOException e12) {
                e12.printStackTrace();
            }
            return z10;
        } catch (IOException e13) {
            e = e13;
            bufferedInputStream2 = bufferedInputStream;
            e.printStackTrace();
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e14) {
                    e14.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e15) {
                    e15.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean l(String str) {
        return k(C(str));
    }

    public static boolean l0(String str) {
        return k0(C(str));
    }

    public static boolean m(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!k(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static List<File> m0(File file) {
        return n0(file, null);
    }

    public static boolean n(String str) {
        return m(C(str));
    }

    public static List<File> n0(File file, Comparator<File> comparator) {
        return p0(file, false, comparator);
    }

    public static boolean o(File file) {
        if (file == null) {
            return false;
        }
        return file.isDirectory() ? s(file) : t(file);
    }

    public static List<File> o0(File file, boolean z10) {
        return p0(file, z10, null);
    }

    public static boolean p(String str) {
        return o(C(str));
    }

    public static List<File> p0(File file, boolean z10, Comparator<File> comparator) {
        return x0(file, new c(), z10, comparator);
    }

    public static boolean q(File file) {
        return w(file, new a());
    }

    public static List<File> q0(String str) {
        return r0(str, null);
    }

    public static boolean r(String str) {
        return q(C(str));
    }

    public static List<File> r0(String str, Comparator<File> comparator) {
        return p0(C(str), false, comparator);
    }

    public static boolean s(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    if (!file2.delete()) {
                        return false;
                    }
                } else if (file2.isDirectory() && !s(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static List<File> s0(String str, boolean z10) {
        return o0(C(str), z10);
    }

    public static boolean t(File file) {
        return file != null && (!file.exists() || (file.isFile() && file.delete()));
    }

    public static List<File> t0(String str, boolean z10, Comparator<File> comparator) {
        return p0(C(str), z10, comparator);
    }

    public static boolean u(File file) {
        return w(file, new b());
    }

    public static List<File> u0(File file, FileFilter fileFilter) {
        return x0(file, fileFilter, false, null);
    }

    public static boolean v(String str) {
        return u(C(str));
    }

    public static List<File> v0(File file, FileFilter fileFilter, Comparator<File> comparator) {
        return x0(file, fileFilter, false, comparator);
    }

    public static boolean w(File file, FileFilter fileFilter) {
        if (file == null || fileFilter == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            for (File file2 : fileArrListFiles) {
                if (fileFilter.accept(file2)) {
                    if (file2.isFile()) {
                        if (!file2.delete()) {
                            return false;
                        }
                    } else if (file2.isDirectory() && !s(file2)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static List<File> w0(File file, FileFilter fileFilter, boolean z10) {
        return x0(file, fileFilter, z10, null);
    }

    public static boolean x(String str, FileFilter fileFilter) {
        return w(C(str), fileFilter);
    }

    public static List<File> x0(File file, FileFilter fileFilter, boolean z10, Comparator<File> comparator) {
        List<File> listC0 = C0(file, fileFilter, z10);
        if (comparator != null) {
            Collections.sort(listC0, comparator);
        }
        return listC0;
    }

    public static long y(File file) {
        long jY = 0;
        if (!c0(file)) {
            return 0L;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                jY += file2.isDirectory() ? y(file2) : file2.length();
            }
        }
        return jY;
    }

    public static List<File> y0(String str, FileFilter fileFilter) {
        return u0(C(str), fileFilter);
    }

    public static String z(File file) {
        return file == null ? "" : A(file.getAbsolutePath());
    }

    public static List<File> z0(String str, FileFilter fileFilter, Comparator<File> comparator) {
        return v0(C(str), fileFilter, comparator);
    }
}
