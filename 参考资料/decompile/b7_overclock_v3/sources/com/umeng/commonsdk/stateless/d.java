package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f24147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Object f24148b = new Object();

    public static boolean a(long j10, long j11) {
        return j10 > j11;
    }

    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            for (String str : file.list()) {
                if (!a(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean b(Context context, String str, String str2, byte[] bArr) {
        boolean z10;
        if (context == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                synchronized (f24148b) {
                    try {
                        ULog.i("walle", "[stateless] begin write envelope, thread is " + Thread.currentThread());
                        File file = new File(context.getFilesDir() + fh.a.f28350w + a.f24124e);
                        if (!file.isDirectory()) {
                            file.mkdir();
                        }
                        File file2 = new File(file.getPath() + fh.a.f28350w + str);
                        if (!file2.isDirectory()) {
                            file2.mkdir();
                        }
                        File file3 = new File(file2.getPath() + fh.a.f28350w + str2);
                        if (!file3.exists()) {
                            file3.createNewFile();
                        }
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                        try {
                            fileOutputStream2.write(bArr);
                            fileOutputStream2.close();
                            try {
                                return true;
                            } catch (Throwable th2) {
                                th = th2;
                                z10 = true;
                                while (true) {
                                    try {
                                        break;
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            fileOutputStream = fileOutputStream2;
                            z10 = false;
                            while (true) {
                                break;
                                break;
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
                try {
                    break;
                    throw th;
                } catch (IOException e10) {
                    e = e10;
                    ULog.i("walle", "[stateless] write envelope, e is " + e.getMessage());
                    UMCrashManager.reportCrash(context, e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    return z10;
                } catch (Throwable th6) {
                    th = th6;
                    ULog.i("walle", "[stateless] write envelope, e is " + th.getMessage());
                    UMCrashManager.reportCrash(context, th);
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return z10;
                }
            } catch (Throwable th7) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th7;
            }
        } catch (IOException e11) {
            e = e11;
            z10 = false;
        } catch (Throwable th8) {
            th = th8;
            z10 = false;
        }
    }

    public static File[] c(Context context) {
        if (context == null) {
            return null;
        }
        try {
            synchronized (f24148b) {
                String str = context.getApplicationContext().getFilesDir() + File.separator + a.f24125f;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File file = new File(str);
                synchronized (f24148b) {
                    File[] fileArrListFiles = file.listFiles();
                    if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                        Arrays.sort(fileArrListFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.3
                            @Override // java.util.Comparator
                            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                            public int compare(File file2, File file3) {
                                long jLastModified = file2.lastModified() - file3.lastModified();
                                if (jLastModified > 0) {
                                    return 1;
                                }
                                return jLastModified == 0 ? 0 : -1;
                            }
                        });
                        return fileArrListFiles;
                    }
                    return null;
                }
            }
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
            return null;
        }
    }

    public static String d(String str) {
        int iLastIndexOf;
        int iLastIndexOf2;
        return (!TextUtils.isEmpty(str) && str.indexOf("envelope") < 0 && (iLastIndexOf = str.lastIndexOf("_")) >= 0 && (iLastIndexOf2 = str.lastIndexOf(j3.b.f36044h)) >= 0) ? str.substring(iLastIndexOf + 1, iLastIndexOf2) : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0063 A[EXC_TOP_SPLITTER, PHI: r1
  0x0063: PHI (r1v3 java.io.FileOutputStream) = (r1v1 java.io.FileOutputStream), (r1v4 java.io.FileOutputStream) binds: [B:22:0x0061, B:27:0x006b] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0075 A[PHI: r1
  0x0075: PHI (r1v2 java.io.FileOutputStream) = (r1v1 java.io.FileOutputStream), (r1v3 java.io.FileOutputStream), (r1v4 java.io.FileOutputStream) binds: [B:22:0x0061, B:23:0x0063, B:27:0x006b] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(android.content.Context r6, java.lang.String r7, java.lang.String r8, byte[] r9) {
        /*
            r0 = 101(0x65, float:1.42E-43)
            if (r6 == 0) goto L75
            r1 = 0
            java.lang.Object r2 = com.umeng.commonsdk.stateless.d.f24148b     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L67
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L67
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L5a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a
            r4.<init>()     // Catch: java.lang.Throwable -> L5a
            java.io.File r5 = r6.getFilesDir()     // Catch: java.lang.Throwable -> L5a
            r4.append(r5)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r5 = java.io.File.separator     // Catch: java.lang.Throwable -> L5a
            r4.append(r5)     // Catch: java.lang.Throwable -> L5a
            r4.append(r7)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L5a
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L5a
            boolean r7 = r3.isDirectory()     // Catch: java.lang.Throwable -> L5a
            if (r7 != 0) goto L2e
            r3.mkdir()     // Catch: java.lang.Throwable -> L5a
        L2e:
            java.io.File r7 = new java.io.File     // Catch: java.lang.Throwable -> L5a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a
            r4.<init>()     // Catch: java.lang.Throwable -> L5a
            java.lang.String r3 = r3.getPath()     // Catch: java.lang.Throwable -> L5a
            r4.append(r3)     // Catch: java.lang.Throwable -> L5a
            r4.append(r5)     // Catch: java.lang.Throwable -> L5a
            r4.append(r8)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r8 = r4.toString()     // Catch: java.lang.Throwable -> L5a
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L5a
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5a
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L5a
            r8.write(r9)     // Catch: java.lang.Throwable -> L57
            r8.close()     // Catch: java.lang.Throwable -> L57
            r0 = 0
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L5a
            goto L75
        L57:
            r7 = move-exception
            r1 = r8
            goto L5b
        L5a:
            r7 = move-exception
        L5b:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L5a
            throw r7     // Catch: java.lang.Throwable -> L5d java.io.IOException -> L67
        L5d:
            r7 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r7)     // Catch: java.lang.Throwable -> L6e
            if (r1 == 0) goto L75
        L63:
            r1.close()     // Catch: java.lang.Throwable -> L75
            goto L75
        L67:
            r7 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r7)     // Catch: java.lang.Throwable -> L6e
            if (r1 == 0) goto L75
            goto L63
        L6e:
            r6 = move-exception
            if (r1 == 0) goto L74
            r1.close()     // Catch: java.lang.Throwable -> L74
        L74:
            throw r6
        L75:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.d.a(android.content.Context, java.lang.String, java.lang.String, byte[]):int");
    }

    public static String c(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static byte[] a(String str) throws IOException {
        byte[] bArr;
        synchronized (f24148b) {
            FileChannel channel = null;
            try {
                try {
                    channel = new RandomAccessFile(str, SsManifestParser.e.J).getChannel();
                    MappedByteBuffer mappedByteBufferLoad = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()).load();
                    bArr = new byte[(int) channel.size()];
                    if (mappedByteBufferLoad.remaining() > 0) {
                        mappedByteBufferLoad.get(bArr, 0, mappedByteBufferLoad.remaining());
                    }
                    try {
                        channel.close();
                    } catch (Throwable unused) {
                    }
                } catch (IOException e10) {
                    ULog.i("walle", "[stateless] write envelope, e is " + e10.getMessage());
                    throw e10;
                }
            } catch (Throwable th2) {
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th2;
            }
        }
        return bArr;
    }

    public static File b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            synchronized (f24148b) {
                String str = context.getApplicationContext().getFilesDir() + File.separator + a.f24125f;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File file = new File(str);
                synchronized (f24148b) {
                    File[] fileArrListFiles = file.listFiles();
                    if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                        Arrays.sort(fileArrListFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.2
                            @Override // java.util.Comparator
                            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                            public int compare(File file2, File file3) {
                                long jLastModified = file2.lastModified() - file3.lastModified();
                                if (jLastModified > 0) {
                                    return 1;
                                }
                                return jLastModified == 0 ? 0 : -1;
                            }
                        });
                        return fileArrListFiles[0];
                    }
                    return null;
                }
            }
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
            return null;
        }
    }

    public static File a(Context context) {
        File[] fileArrListFiles;
        File[] fileArrListFiles2;
        File file = null;
        try {
            synchronized (f24148b) {
                ULog.i("walle", "get last envelope begin, thread is " + Thread.currentThread());
                if (context != null && context.getApplicationContext() != null) {
                    String str = context.getApplicationContext().getFilesDir() + File.separator + a.f24124e;
                    if (!TextUtils.isEmpty(str)) {
                        File file2 = new File(str);
                        if (file2.isDirectory() && (fileArrListFiles = file2.listFiles()) != null && fileArrListFiles.length > 0) {
                            for (File file3 : fileArrListFiles) {
                                if (file3 != null && file3.isDirectory() && (fileArrListFiles2 = file3.listFiles()) != null && fileArrListFiles2.length > 0) {
                                    Arrays.sort(fileArrListFiles2, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.1
                                        @Override // java.util.Comparator
                                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                                        public int compare(File file4, File file5) {
                                            long jLastModified = file4.lastModified() - file5.lastModified();
                                            if (jLastModified > 0) {
                                                return 1;
                                            }
                                            return jLastModified == 0 ? 0 : -1;
                                        }
                                    });
                                    File file4 = fileArrListFiles2[0];
                                    if (file4 != null && (file == null || file.lastModified() > file4.lastModified())) {
                                        file = file4;
                                    }
                                }
                            }
                        }
                    }
                }
                ULog.i("walle", "get last envelope end, thread is " + Thread.currentThread());
            }
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
        }
        return file;
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b10 : bArr) {
            stringBuffer.append(String.format("%02X", Byte.valueOf(b10)));
        }
        return stringBuffer.toString().toLowerCase(Locale.US);
    }

    public static String b(String str) {
        try {
            return Base64.encodeToString(str.getBytes(), 0);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(Context context, boolean z10) {
        String str;
        String str2 = null;
        if (context == null) {
            return null;
        }
        try {
            if (z10) {
                str = context.getApplicationContext().getFilesDir() + File.separator + a.f24124e;
            } else {
                str = context.getApplicationContext().getFilesDir() + File.separator + a.f24125f;
            }
            str2 = str;
            return str2;
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static void a(Context context, String str, int i10) {
        try {
            if (str == null) {
                ULog.i("AmapLBS", "[lbs-build] fileDir not exist, thread is " + Thread.currentThread());
                return;
            }
            File file = new File(str);
            if (!file.isDirectory()) {
                ULog.i("AmapLBS", "[lbs-build] fileDir not exist, thread is " + Thread.currentThread());
                return;
            }
            synchronized (f24148b) {
                File[] fileArrListFiles = file.listFiles();
                ULog.i("AmapLBS", "[lbs-build] delete file begin " + fileArrListFiles.length + ", thread is " + Thread.currentThread());
                if (fileArrListFiles.length >= i10) {
                    ULog.i("AmapLBS", "[lbs-build] file size >= max");
                    ArrayList arrayList = new ArrayList();
                    for (File file2 : fileArrListFiles) {
                        if (file2 != null) {
                            arrayList.add(file2);
                        }
                    }
                    if (arrayList.size() >= i10) {
                        Collections.sort(arrayList, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.4
                            @Override // java.util.Comparator
                            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                            public int compare(File file3, File file4) {
                                if (file3 == null || file4 == null || file3.lastModified() >= file4.lastModified()) {
                                    return (file3 == null || file4 == null || file3.lastModified() != file4.lastModified()) ? 1 : 0;
                                }
                                return -1;
                            }
                        });
                        if (ULog.DEBUG) {
                            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                                ULog.i("AmapLBS", "[lbs-build] overrun native file is " + ((File) arrayList.get(i11)).getPath());
                            }
                        }
                        for (int i12 = 0; i12 <= arrayList.size() - i10; i12++) {
                            if (arrayList.get(i12) != null) {
                                ULog.i("AmapLBS", "[lbs-build] overrun remove file is " + ((File) arrayList.get(i12)).getPath());
                                try {
                                    ((File) arrayList.get(i12)).delete();
                                    arrayList.remove(i12);
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                } else {
                    ULog.i("AmapLBS", "[lbs-build] file size < max");
                }
                ULog.i("AmapLBS", "[lbs-build] delete file end " + fileArrListFiles.length + ", thread is " + Thread.currentThread());
            }
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
        }
    }

    public static void a(Context context, String str, final String str2, int i10) {
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (file.isDirectory()) {
                synchronized (f24148b) {
                    File[] fileArrListFiles = file.listFiles(new FilenameFilter() { // from class: com.umeng.commonsdk.stateless.d.5
                        @Override // java.io.FilenameFilter
                        public boolean accept(File file2, String str3) {
                            return str3.startsWith(str2);
                        }
                    });
                    if (fileArrListFiles != null && fileArrListFiles.length >= i10) {
                        ULog.i("AmapLBS", "[lbs-build] file size >= max");
                        ArrayList arrayList = new ArrayList();
                        for (File file2 : fileArrListFiles) {
                            if (file2 != null) {
                                arrayList.add(file2);
                            }
                        }
                        if (arrayList.size() >= i10) {
                            Collections.sort(arrayList, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.6
                                @Override // java.util.Comparator
                                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                                public int compare(File file3, File file4) {
                                    if (file3 == null || file4 == null || file3.lastModified() >= file4.lastModified()) {
                                        return (file3 == null || file4 == null || file3.lastModified() != file4.lastModified()) ? 1 : 0;
                                    }
                                    return -1;
                                }
                            });
                            if (ULog.DEBUG) {
                                for (int i11 = 0; i11 < arrayList.size(); i11++) {
                                    ULog.i("AmapLBS", "[lbs-build] overrun native file is " + ((File) arrayList.get(i11)).getPath());
                                }
                            }
                            for (int i12 = 0; i12 <= arrayList.size() - i10; i12++) {
                                if (arrayList.get(i12) != null) {
                                    ULog.i("AmapLBS", "[lbs-build] overrun remove file is " + ((File) arrayList.get(i12)).getPath());
                                    try {
                                        ((File) arrayList.get(i12)).delete();
                                        arrayList.remove(i12);
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                        }
                    } else {
                        ULog.i("AmapLBS", "[lbs-build] file size < max");
                    }
                    ULog.i("AmapLBS", "[lbs-build] delete file end " + fileArrListFiles.length + ", thread is " + Thread.currentThread());
                }
            }
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
        }
    }

    public static byte[] a(byte[] bArr) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = null;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        f24147a = 0;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            while (!deflater.finished()) {
                try {
                    int iDeflate = deflater.deflate(bArr2);
                    f24147a += iDeflate;
                    byteArrayOutputStream2.write(bArr2, 0, iDeflate);
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            }
            deflater.end();
            byteArrayOutputStream2.close();
            return byteArrayOutputStream2.toByteArray();
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
