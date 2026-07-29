package wf;

import android.os.Environment;
import com.zhihu.matisse.internal.entity.Album;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes7.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f54650b = "bes";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f54649a = Environment.getExternalStorageDirectory() + fh.a.f28350w;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f54651c = "spp";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f54652d = "ble.txt";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f54653e = "ota_static";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f54654f = "usb_ota.txt";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f54655g = "crash_details.txt";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f54656h = "log_details.txt";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f54657i = "ota_info_report.txt";

    public static void a(String str) {
        File file = new File(c() + str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static void b(String str) {
        try {
            new File(str).delete();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static String c() {
        String str = f54649a;
        e(str);
        return str + fh.a.f28350w;
    }

    public static String d() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
    }

    public static void e(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        synchronized (c.class) {
            file.mkdirs();
        }
    }

    public static boolean f(String str) {
        return new File(str).exists();
    }

    public static String g(int i10) {
        String str;
        new Date();
        String strD = d();
        String str2 = c() + "BES/";
        e(str2);
        String str3 = str2 + "LogData/";
        e(str3);
        if (i10 == 0) {
            str = str3 + strD + "" + f54656h;
        } else {
            str = str3 + strD + "" + f54655g;
        }
        File file = new File(str);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.available();
            fileInputStream.close();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
        return str;
    }

    public static String h() {
        String str = c() + "BES/";
        e(str);
        String str2 = str + "LogData/";
        e(str2);
        String str3 = str2 + Album.f25090f + f54656h;
        b(str3);
        File file = new File(str3);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.available();
            fileInputStream.close();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
        return str3;
    }

    public static String i() {
        long jAvailable;
        String str = c() + "BES/";
        e(str);
        String str2 = str + "LogData/";
        e(str2);
        String str3 = str2 + f54657i;
        File file = new File(str3);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            jAvailable = fileInputStream.available();
            fileInputStream.close();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
        if (jAvailable >= 80000000) {
            file.delete();
            return str3;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        fileOutputStream.write(("\n\n" + d()).getBytes("gbk"));
        fileOutputStream.flush();
        fileOutputStream.close();
        return str3;
    }

    public static void j(String str, String str2) {
    }
}
