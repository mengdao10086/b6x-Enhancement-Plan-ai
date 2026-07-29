package com.arialyy.aria.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.TextUtils;
import androidx.appcompat.widget.c;
import com.arialyy.aria.core.AriaConfig;
import com.blankj.utilcode.util.i0;
import fh.a;
import j3.b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class FileUtil {
    private static final Pattern DIR_SEPORATOR = Pattern.compile(a.f28350w);
    private static final String EXTERNAL_STORAGE_PATH = Environment.getExternalStorageDirectory().getPath();
    private static final String TAG = "FileUtil";

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0037 -> B:41:0x0053). Please report as a decompilation issue!!! */
    public static boolean canWrite(String str) throws Throwable {
        File file;
        boolean z10 = true;
        if (new File(str).canWrite()) {
            return true;
        }
        File file2 = null;
        try {
            try {
                try {
                    file = new File(str, "tw.txt");
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e10) {
                e = e10;
            }
            try {
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(1);
                fileWriter.close();
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e11) {
                e = e11;
                file2 = file;
                e.printStackTrace();
                z10 = false;
                if (file2 != null && file2.exists()) {
                    file2.delete();
                }
            } catch (Throwable th3) {
                th = th3;
                file2 = file;
                if (file2 != null) {
                    try {
                        if (file2.exists()) {
                            file2.delete();
                        }
                    } catch (Exception e12) {
                        e12.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e13) {
            e13.printStackTrace();
        }
        return z10;
    }

    public static boolean checkMemorySpace(String str, long j10) {
        File file = new File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                createDir(file.getParentFile().getPath());
            }
            str = file.getParentFile().getPath();
        }
        StatFs statFs = new StatFs(str);
        return j10 <= ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    @Deprecated
    private static boolean checkSDMemorySpace(String str, long j10) {
        List<String> sDPathList = getSDPathList(AriaConfig.getInstance().getAPP());
        if (sDPathList != null && !sDPathList.isEmpty()) {
            for (String str2 : sDPathList) {
                if (str.contains(str2) && j10 > 0 && j10 > getAvailableExternalMemorySize(str2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static List<String> compareMountsWithVold(List<String> list, List<String> list2) {
        for (int size = list.size() - 1; size >= 0; size--) {
            String str = list.get(size);
            File file = new File(str);
            if (!file.exists() || !file.isDirectory() || !file.canWrite()) {
                list.remove(size);
            } else if (list2 != null && !list2.contains(str)) {
                list.remove(size);
            }
        }
        if (list2 != null) {
            list2.clear();
        }
        return list;
    }

    public static boolean createDir(String str) {
        File file = new File(str);
        if (file.exists()) {
            return false;
        }
        if (file.mkdirs()) {
            return true;
        }
        ALog.d(TAG, "创建失败，请检查路径和是否配置文件权限！");
        return false;
    }

    public static boolean createFile(String str) {
        if (!TextUtils.isEmpty(str)) {
            return createFile(new File(str));
        }
        ALog.e(TAG, "文件路径不能为null");
        return false;
    }

    public static void createFileFormInputStream(InputStream inputStream, String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            byte[] bArr = new byte[1024];
            while (true) {
                int i10 = inputStream.read(bArr);
                if (i10 <= 0) {
                    inputStream.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, i10);
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public static String createFileName(String str) {
        int iIndexOf = str.indexOf("?");
        String strSubstring = "";
        if (iIndexOf > 0) {
            String strSubstring2 = str.substring(0, iIndexOf);
            int iLastIndexOf = strSubstring2.lastIndexOf(a.f28350w);
            if (iLastIndexOf > 0) {
                strSubstring = strSubstring2.substring(iLastIndexOf + 1);
            }
        } else {
            int iLastIndexOf2 = str.lastIndexOf(a.f28350w);
            if (iLastIndexOf2 > 0) {
                strSubstring = str.substring(iLastIndexOf2 + 1);
            }
        }
        return TextUtils.isEmpty(strSubstring) ? CommonUtil.keyToHashKey(str) : strSubstring;
    }

    public static boolean deleteDir(File file) {
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return file.delete();
        }
        for (File file2 : file.listFiles()) {
            deleteDir(file2);
        }
        return file.delete();
    }

    public static boolean deleteFile(String str) {
        if (!TextUtils.isEmpty(str)) {
            return deleteFile(new File(str));
        }
        ALog.e(TAG, "删除文件失败，路径为空");
        return false;
    }

    public static long getAvailMemory(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(c.f2369r);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    private static long getAvailableExternalMemorySize(String str) {
        StatFs statFs = new StatFs(str);
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public static String getFileExtensionName(String str) {
        int iLastIndexOf;
        if (!TextUtils.isEmpty(str) && (iLastIndexOf = str.lastIndexOf(b.f36044h)) > -1) {
            return str.substring(iLastIndexOf + 1);
        }
        return null;
    }

    private static List<String> getSDPathList(Context context) {
        try {
            return getVolumeList(context);
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
            return null;
        } catch (NoSuchMethodException e11) {
            e11.printStackTrace();
            return null;
        } catch (InvocationTargetException e12) {
            e12.printStackTrace();
            return null;
        }
    }

    private static List<String> getStorageDirectories() {
        ArrayList arrayList = new ArrayList();
        String str = System.getenv("EXTERNAL_STORAGE");
        String str2 = System.getenv("SECONDARY_STORAGE");
        String str3 = System.getenv("EMULATED_STORAGE_TARGET");
        if (!TextUtils.isEmpty(str3)) {
            String[] strArrSplit = DIR_SEPORATOR.split(Environment.getExternalStorageDirectory().getAbsolutePath());
            String str4 = strArrSplit[strArrSplit.length - 1];
            boolean z10 = false;
            if (!TextUtils.isEmpty(str4) && TextUtils.isDigitsOnly(str4)) {
                z10 = true;
            }
            if (!z10) {
                str4 = "";
            }
            if (TextUtils.isEmpty(str4)) {
                arrayList.add(str);
            } else {
                arrayList.add(str3 + File.separator + str4);
            }
        } else if (TextUtils.isEmpty(str)) {
            arrayList.add("/storage/sdcard0");
        } else {
            arrayList.add(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            Collections.addAll(arrayList, str2.split(File.pathSeparator));
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            String str5 = (String) arrayList.get(size);
            File file = new File(str5);
            if (!file.exists() || !file.isDirectory() || !canWrite(str5)) {
                arrayList.remove(size);
            }
        }
        return arrayList;
    }

    private static long getTotalExternalMemorySize(String str) {
        StatFs statFs = new StatFs(str);
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    public static long getTotalMemory() {
        long jIntValue = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            jIntValue = Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue() * 1024;
            bufferedReader.close();
            return jIntValue;
        } catch (IOException e10) {
            e10.printStackTrace();
            return jIntValue;
        }
    }

    public static String getTsCacheDir(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("m3u8文保存路径为空");
        }
        File file = new File(str);
        return String.format("%s/.%s_%s", file.getParent(), file.getName(), Integer.valueOf(i10));
    }

    private static List<String> getVolumeList(Context context) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ArrayList<String> arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            List<StorageVolume> storageVolumes = ((StorageManager) context.getSystemService("storage")).getStorageVolumes();
            Method declaredMethod = StorageVolume.class.getDeclaredMethod("getPath", new Class[0]);
            declaredMethod.setAccessible(true);
            for (StorageVolume storageVolume : storageVolumes) {
                if (storageVolume.getState().equals("mounted")) {
                    arrayList.add((String) declaredMethod.invoke(storageVolume, new Object[0]));
                }
            }
        } else {
            arrayList.addAll(getStorageDirectories());
        }
        if (arrayList.isEmpty()) {
            arrayList = new ArrayList();
            arrayList.add(EXTERNAL_STORAGE_PATH);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : arrayList) {
            File file = new File(str);
            if (file.exists() && file.isDirectory() && canWrite(str)) {
                int iHashCode = (file.getTotalSpace() + "-" + file.getUsableSpace()).hashCode();
                String str2 = (String) linkedHashMap.get(Integer.valueOf(iHashCode));
                if (TextUtils.isEmpty(str2) || str2.length() >= str.length()) {
                    linkedHashMap.put(Integer.valueOf(iHashCode), str);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = linkedHashMap.keySet().iterator();
        while (it2.hasNext()) {
            arrayList2.add(linkedHashMap.get((Integer) it2.next()));
        }
        return arrayList2;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0032 -> B:30:0x0035). Please report as a decompilation issue!!! */
    public static Properties loadConfig(File file) throws Throwable {
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        if (!file.exists()) {
            createFile(file.getPath());
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e10) {
                e = e10;
            }
            try {
                properties.load(fileInputStream);
                fileInputStream.close();
            } catch (Exception e11) {
                e = e11;
                fileInputStream2 = fileInputStream;
                e.printStackTrace();
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e13) {
            e13.printStackTrace();
        }
        return properties;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0105 A[Catch: IOException -> 0x0101, TRY_LEAVE, TryCatch #0 {IOException -> 0x0101, blocks: (B:60:0x00fd, B:64:0x0105), top: B:68:0x00fd }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean mergeFile(java.lang.String r21, java.util.List<java.lang.String> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arialyy.aria.util.FileUtil.mergeFile(java.lang.String, java.util.List):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011e A[Catch: IOException -> 0x011a, TRY_LEAVE, TryCatch #0 {IOException -> 0x011a, blocks: (B:64:0x0116, B:68:0x011e), top: B:72:0x0116 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0116 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean mergeSFtpFile(java.lang.String r23, java.util.List<java.lang.String> r24, long r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arialyy.aria.util.FileUtil.mergeSFtpFile(java.lang.String, java.util.List, long):boolean");
    }

    private static List<String> readMountsFile() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(EXTERNAL_STORAGE_PATH);
        try {
            Scanner scanner = new Scanner(new File("/proc/mounts"));
            while (scanner.hasNext()) {
                String strNextLine = scanner.nextLine();
                if (strNextLine.startsWith("/dev/block/vold/") || strNextLine.startsWith("/dev/block//vold/")) {
                    String str = strNextLine.split(i0.f11861z)[1];
                    if (!str.equals(EXTERNAL_STORAGE_PATH)) {
                        arrayList.add(str);
                    }
                }
            }
            scanner.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.FileInputStream] */
    public static Object readObjFromFile(String str) throws Throwable {
        FileInputStream fileInputStream;
        ?? r22 = 0;
        if (TextUtils.isEmpty(str)) {
            ALog.e(TAG, "文件路径为空");
            return null;
        }
        ?? Exists = new File(str).exists();
        try {
            try {
                if (Exists == 0) {
                    ALog.e(TAG, String.format("文件【%s】不存在", str));
                    return null;
                }
                try {
                    fileInputStream = new FileInputStream(str);
                    try {
                        Object object = new ObjectInputStream(fileInputStream).readObject();
                        try {
                            fileInputStream.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                        return object;
                    } catch (FileNotFoundException e11) {
                        e = e11;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    } catch (IOException e12) {
                        e = e12;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    } catch (ClassNotFoundException e13) {
                        e = e13;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    }
                } catch (FileNotFoundException e14) {
                    e = e14;
                    fileInputStream = null;
                } catch (IOException e15) {
                    e = e15;
                    fileInputStream = null;
                } catch (ClassNotFoundException e16) {
                    e = e16;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (r22 != 0) {
                        try {
                            r22.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e18) {
                e18.printStackTrace();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            r22 = Exists;
        }
    }

    private static List<String> readVoldFile() {
        Scanner scanner;
        ArrayList arrayList = null;
        try {
            try {
                scanner = new Scanner(new File("/system/etc/vold.fstab"));
            } catch (Exception unused) {
                return arrayList;
            }
        } catch (FileNotFoundException unused2) {
            scanner = new Scanner(new File("/system/etc/vold.conf"));
        }
        ArrayList arrayList2 = new ArrayList();
        try {
            arrayList2.add(EXTERNAL_STORAGE_PATH);
            while (scanner.hasNext()) {
                String strNextLine = scanner.nextLine();
                if (!TextUtils.isEmpty(strNextLine)) {
                    String strTrim = strNextLine.trim();
                    if (strTrim.startsWith("dev_mount")) {
                        String[] strArrSplit = strTrim.split(i0.f11861z);
                        if (strArrSplit.length >= 3) {
                            String strSubstring = strArrSplit[2];
                            if (strSubstring.contains(":")) {
                                strSubstring = strSubstring.substring(0, strSubstring.indexOf(":"));
                            }
                            if (!strSubstring.equals(EXTERNAL_STORAGE_PATH)) {
                                arrayList2.add(strSubstring);
                            }
                        }
                    } else if (strTrim.startsWith("mount_point")) {
                        String strTrim2 = strTrim.replaceAll("mount_point", "").trim();
                        if (!strTrim2.equals(EXTERNAL_STORAGE_PATH)) {
                            arrayList2.add(strTrim2);
                        }
                    }
                }
            }
            return arrayList2;
        } catch (Exception unused3) {
            arrayList = arrayList2;
            return arrayList;
        }
    }

    public static void saveConfig(File file, Properties properties) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file, false);
                } catch (IOException e10) {
                    e10.printStackTrace();
                    return;
                }
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e12) {
            e = e12;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            if (fileOutputStream2 == null) {
                return;
            }
            fileOutputStream2.flush();
            fileOutputStream2.close();
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static void splitFile(String str, int i10) {
        File file;
        long j10;
        int i11 = i10;
        try {
            File file2 = new File(str);
            long length = file2.length();
            FileInputStream fileInputStream = new FileInputStream(file2);
            FileChannel channel = fileInputStream.getChannel();
            long j11 = 0;
            long j12 = length / ((long) i11);
            int i12 = 0;
            while (i12 < i11) {
                int i13 = i11 - 1;
                if (i12 == i13) {
                    j12 = length - (j12 * ((long) i13));
                }
                String str2 = file2.getPath() + b.f36044h + i12 + ".part";
                ALog.d(TAG, String.format("block = %s", Long.valueOf(j12)));
                File file3 = new File(str2);
                if (!file3.exists()) {
                    createFile(file3);
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                FileChannel channel2 = fileOutputStream.getChannel();
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8196);
                while (true) {
                    int i14 = channel.read(byteBufferAllocate);
                    file = file2;
                    if (i14 == -1) {
                        j10 = length;
                        break;
                    }
                    byteBufferAllocate.flip();
                    channel2.write(byteBufferAllocate);
                    byteBufferAllocate.compact();
                    j10 = length;
                    j11 += (long) i14;
                    if (j11 >= ((long) (i12 + 1)) * j12) {
                        break;
                    }
                    file2 = file;
                    length = j10;
                }
                ALog.d(TAG, String.format("len = %s", Long.valueOf(file3.length())));
                fileOutputStream.close();
                channel2.close();
                i12++;
                i11 = i10;
                file2 = file;
                length = j10;
            }
            fileInputStream.close();
            channel.close();
        } catch (FileNotFoundException e10) {
            e10.printStackTrace();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0040 A[Catch: IOException -> 0x0044, TRY_ENTER, TRY_LEAVE, TryCatch #2 {IOException -> 0x0044, blocks: (B:12:0x0021, B:25:0x0036, B:30:0x0040), top: B:42:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void writeObjToFile(java.lang.String r2, java.lang.Object r3) throws java.lang.Throwable {
        /*
            boolean r0 = r3 instanceof java.io.Serializable
            if (r0 != 0) goto Lc
            java.lang.String r2 = "FileUtil"
            java.lang.String r3 = "对象写入文件失败，data数据必须实现Serializable接口"
            com.arialyy.aria.util.ALog.e(r2, r3)
            return
        Lc:
            r0 = 0
            boolean r1 = createFile(r2)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30 java.io.FileNotFoundException -> L3a
            if (r1 != 0) goto L14
            return
        L14:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30 java.io.FileNotFoundException -> L3a
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30 java.io.FileNotFoundException -> L3a
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L28 java.io.FileNotFoundException -> L2b
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L28 java.io.FileNotFoundException -> L2b
            r2.writeObject(r3)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L28 java.io.FileNotFoundException -> L2b
            r1.close()     // Catch: java.io.IOException -> L44
            goto L48
        L25:
            r2 = move-exception
            r0 = r1
            goto L49
        L28:
            r2 = move-exception
            r0 = r1
            goto L31
        L2b:
            r2 = move-exception
            r0 = r1
            goto L3b
        L2e:
            r2 = move-exception
            goto L49
        L30:
            r2 = move-exception
        L31:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L48
            r0.close()     // Catch: java.io.IOException -> L44
            goto L48
        L3a:
            r2 = move-exception
        L3b:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L48
            r0.close()     // Catch: java.io.IOException -> L44
            goto L48
        L44:
            r2 = move-exception
            r2.printStackTrace()
        L48:
            return
        L49:
            if (r0 == 0) goto L53
            r0.close()     // Catch: java.io.IOException -> L4f
            goto L53
        L4f:
            r3 = move-exception
            r3.printStackTrace()
        L53:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arialyy.aria.util.FileUtil.writeObjToFile(java.lang.String, java.lang.Object):void");
    }

    public static boolean createFile(File file) {
        if (file.getParentFile() == null || !file.getParentFile().exists()) {
            ALog.d(TAG, "目标文件所在路径不存在，准备创建……");
            if (!createDir(file.getParent())) {
                ALog.d(TAG, "创建目录文件所在的目录失败！文件路径【" + file.getPath() + "】");
            }
        }
        deleteFile(file);
        try {
            return file.createNewFile();
        } catch (IOException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static boolean deleteFile(File file) {
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
        if (file.renameTo(file2)) {
            return file2.delete();
        }
        return file.delete();
    }
}
