package com.umeng.socialize.c.b;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.umeng.socialize.utils.SLog;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: com.umeng.socialize.c.b.a$a, reason: collision with other inner class name */
    public static class C0270a implements Comparator<File> {
        private C0270a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            if (file.lastModified() > file2.lastModified()) {
                return 1;
            }
            return file.lastModified() == file2.lastModified() ? 0 : -1;
        }
    }

    public static void a() {
        if ((Environment.getExternalStorageDirectory() == null || TextUtils.isEmpty(Environment.getExternalStorageDirectory().getPath())) ? false : true) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Environment.getExternalStorageDirectory().getPath());
            String str = File.separator;
            sb2.append(str);
            sb2.append(c.f24606e);
            sb2.append(str);
            c.f24605d = sb2.toString();
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(Environment.getDataDirectory().getPath());
            String str2 = File.separator;
            sb3.append(str2);
            sb3.append(c.f24606e);
            sb3.append(str2);
            c.f24605d = sb3.toString();
        }
        File file = new File(c.f24605d);
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            a(c.f24605d);
        } catch (Exception e10) {
            SLog.error(e10);
        }
    }

    public static void b() {
        a();
    }

    private static int c() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (int) ((((double) statFs.getAvailableBlocks()) * ((double) statFs.getBlockSize())) / 1048576.0d);
    }

    private static void a(String str) {
        File[] fileArrListFiles = new File(str).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return;
        }
        int length = 0;
        for (File file : fileArrListFiles) {
            length = (int) (((long) length) + file.length());
        }
        if (length > 0 || 40 > c()) {
            Arrays.sort(fileArrListFiles, new C0270a());
            for (File file2 : fileArrListFiles) {
                file2.delete();
            }
        }
    }
}
