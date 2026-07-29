package com.blankj.utilcode.util;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class i1 {
    public i1() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.io.File a(android.net.Uri r7) throws java.lang.Throwable {
        /*
            r0 = 0
            android.app.Application r1 = com.blankj.utilcode.util.j1.a()     // Catch: java.lang.Throwable -> L43 java.io.FileNotFoundException -> L48
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L43 java.io.FileNotFoundException -> L48
            java.io.InputStream r7 = r1.openInputStream(r7)     // Catch: java.lang.Throwable -> L43 java.io.FileNotFoundException -> L48
            java.io.File r1 = new java.io.File     // Catch: java.io.FileNotFoundException -> L41 java.lang.Throwable -> L58
            android.app.Application r2 = com.blankj.utilcode.util.j1.a()     // Catch: java.io.FileNotFoundException -> L41 java.lang.Throwable -> L58
            java.io.File r2 = r2.getCacheDir()     // Catch: java.io.FileNotFoundException -> L41 java.lang.Throwable -> L58
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.FileNotFoundException -> L41 java.lang.Throwable -> L58
            r3.<init>()     // Catch: java.io.FileNotFoundException -> L41 java.lang.Throwable -> L58
            java.lang.String r4 = ""
            r3.append(r4)     // Catch: java.io.FileNotFoundException -> L41 java.lang.Throwable -> L58
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.io.FileNotFoundException -> L41 java.lang.Throwable -> L58
            r3.append(r4)     // Catch: java.io.FileNotFoundException -> L41 java.lang.Throwable -> L58
            java.lang.String r3 = r3.toString()     // Catch: java.io.FileNotFoundException -> L41 java.lang.Throwable -> L58
            r1.<init>(r2, r3)     // Catch: java.io.FileNotFoundException -> L41 java.lang.Throwable -> L58
            java.lang.String r2 = r1.getAbsolutePath()     // Catch: java.io.FileNotFoundException -> L41 java.lang.Throwable -> L58
            com.blankj.utilcode.util.l1.h1(r2, r7)     // Catch: java.io.FileNotFoundException -> L41 java.lang.Throwable -> L58
            if (r7 == 0) goto L40
            r7.close()     // Catch: java.io.IOException -> L3c
            goto L40
        L3c:
            r7 = move-exception
            r7.printStackTrace()
        L40:
            return r1
        L41:
            r1 = move-exception
            goto L4a
        L43:
            r7 = move-exception
            r6 = r0
            r0 = r7
            r7 = r6
            goto L59
        L48:
            r1 = move-exception
            r7 = r0
        L4a:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L58
            if (r7 == 0) goto L57
            r7.close()     // Catch: java.io.IOException -> L53
            goto L57
        L53:
            r7 = move-exception
            r7.printStackTrace()
        L57:
            return r0
        L58:
            r0 = move-exception
        L59:
            if (r7 == 0) goto L63
            r7.close()     // Catch: java.io.IOException -> L5f
            goto L63
        L5f:
            r7 = move-exception
            r7.printStackTrace()
        L63:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.i1.a(android.net.Uri):java.io.File");
    }

    public static Uri b(File file) {
        if (!l1.u0(file)) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 24) {
            return Uri.fromFile(file);
        }
        return FileProvider.f(j1.a(), j1.a().getPackageName() + ".utilcode.provider", file);
    }

    public static File c(Uri uri, String str) {
        return d(uri, null, null, str);
    }

    public static File d(Uri uri, String str, String[] strArr, String str2) {
        if ("com.google.android.apps.photos.content".equals(uri.getAuthority())) {
            if (!TextUtils.isEmpty(uri.getLastPathSegment())) {
                return new File(uri.getLastPathSegment());
            }
        } else if ("com.tencent.mtt.fileprovider".equals(uri.getAuthority())) {
            String path = uri.getPath();
            if (!TextUtils.isEmpty(path)) {
                return new File(Environment.getExternalStorageDirectory(), path.substring(10, path.length()));
            }
        } else if ("com.huawei.hidisk.fileprovider".equals(uri.getAuthority())) {
            String path2 = uri.getPath();
            if (!TextUtils.isEmpty(path2)) {
                return new File(path2.replace("/root", ""));
            }
        }
        Cursor cursorQuery = j1.a().getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
        try {
            if (cursorQuery == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(uri.toString());
                sb2.append(" parse failed(cursor is null). -> ");
                sb2.append(str2);
                return null;
            }
            if (!cursorQuery.moveToFirst()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(uri.toString());
                sb3.append(" parse failed(moveToFirst return false). -> ");
                sb3.append(str2);
                return null;
            }
            int columnIndex = cursorQuery.getColumnIndex("_data");
            if (columnIndex > -1) {
                return new File(cursorQuery.getString(columnIndex));
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append(uri.toString());
            sb4.append(" parse failed(columnIndex: ");
            sb4.append(columnIndex);
            sb4.append(" is wrong). -> ");
            sb4.append(str2);
            return null;
        } catch (Exception unused) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(uri.toString());
            sb5.append(" parse failed. -> ");
            sb5.append(str2);
            return null;
        } finally {
            cursorQuery.close();
        }
    }

    public static Uri e(String str) {
        return Uri.parse("android.resource://" + j1.a().getPackageName() + fh.a.f28350w + str);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] f(android.net.Uri r3) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r3 != 0) goto L4
            return r0
        L4:
            android.app.Application r1 = com.blankj.utilcode.util.j1.a()     // Catch: java.lang.Throwable -> L21 java.io.FileNotFoundException -> L26
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L21 java.io.FileNotFoundException -> L26
            java.io.InputStream r3 = r1.openInputStream(r3)     // Catch: java.lang.Throwable -> L21 java.io.FileNotFoundException -> L26
            byte[] r0 = com.blankj.utilcode.util.l1.n0(r3)     // Catch: java.io.FileNotFoundException -> L1f java.lang.Throwable -> L36
            if (r3 == 0) goto L1e
            r3.close()     // Catch: java.io.IOException -> L1a
            goto L1e
        L1a:
            r3 = move-exception
            r3.printStackTrace()
        L1e:
            return r0
        L1f:
            r1 = move-exception
            goto L28
        L21:
            r3 = move-exception
            r2 = r0
            r0 = r3
            r3 = r2
            goto L37
        L26:
            r1 = move-exception
            r3 = r0
        L28:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L36
            if (r3 == 0) goto L35
            r3.close()     // Catch: java.io.IOException -> L31
            goto L35
        L31:
            r3 = move-exception
            r3.printStackTrace()
        L35:
            return r0
        L36:
            r0 = move-exception
        L37:
            if (r3 == 0) goto L41
            r3.close()     // Catch: java.io.IOException -> L3d
            goto L41
        L3d:
            r3 = move-exception
            r3.printStackTrace()
        L41:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.i1.f(android.net.Uri):byte[]");
    }

    public static File g(Uri uri) {
        if (uri == null) {
            return null;
        }
        File fileH = h(uri);
        return fileH != null ? fileH : a(uri);
    }

    public static File h(Uri uri) {
        Uri uri2;
        File fileC;
        String str;
        File file;
        uri.toString();
        String authority = uri.getAuthority();
        String scheme = uri.getScheme();
        String path = uri.getPath();
        if (Build.VERSION.SDK_INT >= 24 && path != null) {
            String[] strArr = {"/external/", "/external_path/"};
            for (int i10 = 0; i10 < 2; i10++) {
                String str2 = strArr[i10];
                if (path.startsWith(str2)) {
                    File file2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + path.replace(str2, fh.a.f28350w));
                    if (file2.exists()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(uri.toString());
                        sb2.append(" -> ");
                        sb2.append(str2);
                        return file2;
                    }
                }
            }
            if (path.startsWith("/files_path/")) {
                file = new File(j1.a().getFilesDir().getAbsolutePath() + path.replace("/files_path/", fh.a.f28350w));
            } else if (path.startsWith("/cache_path/")) {
                file = new File(j1.a().getCacheDir().getAbsolutePath() + path.replace("/cache_path/", fh.a.f28350w));
            } else if (path.startsWith("/external_files_path/")) {
                file = new File(j1.a().getExternalFilesDir(null).getAbsolutePath() + path.replace("/external_files_path/", fh.a.f28350w));
            } else if (path.startsWith("/external_cache_path/")) {
                file = new File(j1.a().getExternalCacheDir().getAbsolutePath() + path.replace("/external_cache_path/", fh.a.f28350w));
            } else {
                file = null;
            }
            if (file != null && file.exists()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(uri.toString());
                sb3.append(" -> ");
                sb3.append(path);
                return file;
            }
        }
        if (m7.a.f40702b.equals(scheme)) {
            if (path != null) {
                return new File(path);
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append(uri.toString());
            sb4.append(" parse failed. -> 0");
            return null;
        }
        if (!DocumentsContract.isDocumentUri(j1.a(), uri)) {
            if ("content".equals(scheme)) {
                return c(uri, "2");
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(uri.toString());
            sb5.append(" parse failed. -> 3");
            return null;
        }
        if ("com.android.externalstorage.documents".equals(authority)) {
            String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
            String str3 = strArrSplit[0];
            if ("primary".equalsIgnoreCase(str3)) {
                return new File(Environment.getExternalStorageDirectory() + fh.a.f28350w + strArrSplit[1]);
            }
            StorageManager storageManager = (StorageManager) j1.a().getSystemService("storage");
            try {
                Class<?> cls = Class.forName("android.os.storage.StorageVolume");
                Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
                Method method2 = cls.getMethod("getUuid", new Class[0]);
                Method method3 = cls.getMethod("getState", new Class[0]);
                Method method4 = cls.getMethod("getPath", new Class[0]);
                Method method5 = cls.getMethod("isPrimary", new Class[0]);
                Method method6 = cls.getMethod("isEmulated", new Class[0]);
                Object objInvoke = method.invoke(storageManager, new Object[0]);
                int length = Array.getLength(objInvoke);
                for (int i11 = 0; i11 < length; i11++) {
                    Object obj = Array.get(objInvoke, i11);
                    if (("mounted".equals(method3.invoke(obj, new Object[0])) || "mounted_ro".equals(method3.invoke(obj, new Object[0]))) && ((!((Boolean) method5.invoke(obj, new Object[0])).booleanValue() || !((Boolean) method6.invoke(obj, new Object[0])).booleanValue()) && (str = (String) method2.invoke(obj, new Object[0])) != null && str.equals(str3))) {
                        return new File(method4.invoke(obj, new Object[0]) + fh.a.f28350w + strArrSplit[1]);
                    }
                }
            } catch (Exception e10) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(uri.toString());
                sb6.append(" parse failed. ");
                sb6.append(e10.toString());
                sb6.append(" -> 1_0");
            }
            StringBuilder sb7 = new StringBuilder();
            sb7.append(uri.toString());
            sb7.append(" parse failed. -> 1_0");
            return null;
        }
        if (!"com.android.providers.downloads.documents".equals(authority)) {
            if (!"com.android.providers.media.documents".equals(authority)) {
                if ("content".equals(scheme)) {
                    return c(uri, "1_3");
                }
                StringBuilder sb8 = new StringBuilder();
                sb8.append(uri.toString());
                sb8.append(" parse failed. -> 1_4");
                return null;
            }
            String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
            String str4 = strArrSplit2[0];
            if ("image".equals(str4)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str4)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else {
                if (!"audio".equals(str4)) {
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append(uri.toString());
                    sb9.append(" parse failed. -> 1_2");
                    return null;
                }
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return d(uri2, "_id=?", new String[]{strArrSplit2[1]}, "1_2");
        }
        String documentId = DocumentsContract.getDocumentId(uri);
        if (TextUtils.isEmpty(documentId)) {
            StringBuilder sb10 = new StringBuilder();
            sb10.append(uri.toString());
            sb10.append(" parse failed(id is null). -> 1_1");
            return null;
        }
        if (documentId.startsWith("raw:")) {
            return new File(documentId.substring(4));
        }
        if (documentId.startsWith("msf:")) {
            documentId = documentId.split(":")[1];
        }
        try {
            long j10 = Long.parseLong(documentId);
            String[] strArr2 = {"content://downloads/public_downloads", "content://downloads/all_downloads", "content://downloads/my_downloads"};
            for (int i12 = 0; i12 < 3; i12++) {
                try {
                    fileC = c(ContentUris.withAppendedId(Uri.parse(strArr2[i12]), j10), "1_1");
                } catch (Exception unused) {
                }
                if (fileC != null) {
                    return fileC;
                }
            }
            StringBuilder sb11 = new StringBuilder();
            sb11.append(uri.toString());
            sb11.append(" parse failed. -> 1_1");
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }
}
