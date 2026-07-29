package com.blankj.utilcode.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11972a = 8192;

    public p1() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static List<String> a(File file) throws IOException {
        if (file == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        while (enumerationEntries.hasMoreElements()) {
            arrayList.add(enumerationEntries.nextElement().getComment());
        }
        zipFile.close();
        return arrayList;
    }

    public static List<String> b(String str) throws IOException {
        return a(l1.P(str));
    }

    public static List<String> c(File file) throws IOException {
        if (file == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        while (enumerationEntries.hasMoreElements()) {
            String strReplace = enumerationEntries.nextElement().getName().replace("\\", fh.a.f28350w);
            if (strReplace.contains("../")) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("entryName: ");
                sb2.append(strReplace);
                sb2.append(" is dangerous!");
                arrayList.add(strReplace);
            } else {
                arrayList.add(strReplace);
            }
        }
        zipFile.close();
        return arrayList;
    }

    public static List<String> d(String str) throws IOException {
        return c(l1.P(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean e(java.io.File r1, java.util.List<java.io.File> r2, java.util.zip.ZipFile r3, java.util.zip.ZipEntry r4, java.lang.String r5) throws java.lang.Throwable {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r1, r5)
            r2.add(r0)
            boolean r1 = r4.isDirectory()
            if (r1 == 0) goto L13
            boolean r1 = com.blankj.utilcode.util.l1.s(r0)
            return r1
        L13:
            boolean r1 = com.blankj.utilcode.util.l1.t(r0)
            r2 = 0
            if (r1 != 0) goto L1b
            return r2
        L1b:
            r1 = 0
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L4b
            java.io.InputStream r3 = r3.getInputStream(r4)     // Catch: java.lang.Throwable -> L4b
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L4b
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L48
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L48
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L48
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L48
            r1 = 8192(0x2000, float:1.148E-41)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L46
        L33:
            int r4 = r5.read(r1)     // Catch: java.lang.Throwable -> L46
            r0 = -1
            if (r4 == r0) goto L3e
            r3.write(r1, r2, r4)     // Catch: java.lang.Throwable -> L46
            goto L33
        L3e:
            r5.close()
            r3.close()
            r1 = 1
            return r1
        L46:
            r1 = move-exception
            goto L4f
        L48:
            r2 = move-exception
            r3 = r1
            goto L4e
        L4b:
            r2 = move-exception
            r3 = r1
            r5 = r3
        L4e:
            r1 = r2
        L4f:
            if (r5 == 0) goto L54
            r5.close()
        L54:
            if (r3 == 0) goto L59
            r3.close()
        L59:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.p1.e(java.io.File, java.util.List, java.util.zip.ZipFile, java.util.zip.ZipEntry, java.lang.String):boolean");
    }

    public static List<File> f(File file, File file2) throws IOException {
        return h(file, file2, null);
    }

    public static List<File> g(String str, String str2) throws IOException {
        return i(str, str2, null);
    }

    public static List<File> h(File file, File file2, String str) throws IOException {
        if (file == null || file2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        try {
            if (l1.C0(str)) {
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    String strReplace = zipEntryNextElement.getName().replace("\\", fh.a.f28350w);
                    if (strReplace.contains("../")) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("entryName: ");
                        sb2.append(strReplace);
                        sb2.append(" is dangerous!");
                    } else if (!e(file2, arrayList, zipFile, zipEntryNextElement, strReplace)) {
                        return arrayList;
                    }
                }
            } else {
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement2 = enumerationEntries.nextElement();
                    String strReplace2 = zipEntryNextElement2.getName().replace("\\", fh.a.f28350w);
                    if (strReplace2.contains("../")) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("entryName: ");
                        sb3.append(strReplace2);
                        sb3.append(" is dangerous!");
                    } else if (strReplace2.contains(str) && !e(file2, arrayList, zipFile, zipEntryNextElement2, strReplace2)) {
                        return arrayList;
                    }
                }
            }
            return arrayList;
        } finally {
            zipFile.close();
        }
    }

    public static List<File> i(String str, String str2, String str3) throws IOException {
        return h(l1.P(str), l1.P(str2), str3);
    }

    public static boolean j(File file, File file2) throws IOException {
        return k(file, file2, null);
    }

    public static boolean k(File file, File file2, String str) throws Throwable {
        if (file == null || file2 == null) {
            return false;
        }
        ZipOutputStream zipOutputStream = null;
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(file2));
            try {
                boolean zL = l(file, "", zipOutputStream2, str);
                zipOutputStream2.close();
                return zL;
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream = zipOutputStream2;
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static boolean l(File file, String str, ZipOutputStream zipOutputStream, String str2) throws Throwable {
        BufferedInputStream bufferedInputStream;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(l1.C0(str) ? "" : File.separator);
        sb2.append(file.getName());
        String string = sb2.toString();
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                for (File file2 : fileArrListFiles) {
                    if (!l(file2, string, zipOutputStream, str2)) {
                        return false;
                    }
                }
                return true;
            }
            ZipEntry zipEntry = new ZipEntry(string + zc.f.f58380j);
            zipEntry.setComment(str2);
            zipOutputStream.putNextEntry(zipEntry);
            zipOutputStream.closeEntry();
            return true;
        }
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            ZipEntry zipEntry2 = new ZipEntry(string);
            zipEntry2.setComment(str2);
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[8192];
            while (true) {
                int i10 = bufferedInputStream.read(bArr, 0, 8192);
                if (i10 == -1) {
                    zipOutputStream.closeEntry();
                    bufferedInputStream.close();
                    return true;
                }
                zipOutputStream.write(bArr, 0, i10);
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            throw th;
        }
    }

    public static boolean m(String str, String str2) throws IOException {
        return k(l1.P(str), l1.P(str2), null);
    }

    public static boolean n(String str, String str2, String str3) throws IOException {
        return k(l1.P(str), l1.P(str2), str3);
    }

    public static boolean o(Collection<File> collection, File file) throws IOException {
        return p(collection, file, null);
    }

    public static boolean p(Collection<File> collection, File file, String str) throws Throwable {
        if (collection == null || file == null) {
            return false;
        }
        ZipOutputStream zipOutputStream = null;
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(file));
            try {
                Iterator<File> it2 = collection.iterator();
                while (it2.hasNext()) {
                    if (!l(it2.next(), "", zipOutputStream2, str)) {
                        zipOutputStream2.finish();
                        zipOutputStream2.close();
                        return false;
                    }
                }
                zipOutputStream2.finish();
                zipOutputStream2.close();
                return true;
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream = zipOutputStream2;
                if (zipOutputStream != null) {
                    zipOutputStream.finish();
                    zipOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static boolean q(Collection<String> collection, String str) throws IOException {
        return r(collection, str, null);
    }

    public static boolean r(Collection<String> collection, String str, String str2) throws Throwable {
        if (collection == null || str == null) {
            return false;
        }
        ZipOutputStream zipOutputStream = null;
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(str));
            try {
                Iterator<String> it2 = collection.iterator();
                while (it2.hasNext()) {
                    if (!l(l1.P(it2.next()), "", zipOutputStream2, str2)) {
                        zipOutputStream2.finish();
                        zipOutputStream2.close();
                        return false;
                    }
                }
                zipOutputStream2.finish();
                zipOutputStream2.close();
                return true;
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream = zipOutputStream2;
                if (zipOutputStream != null) {
                    zipOutputStream.finish();
                    zipOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
