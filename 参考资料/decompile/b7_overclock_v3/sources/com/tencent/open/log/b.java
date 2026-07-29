package com.tencent.open.log;

import android.text.TextUtils;
import com.tencent.open.log.d;
import com.tencent.open.utils.k;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SimpleDateFormat f22752a = d.C0251d.a("yy.MM.dd.HH");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private File f22758g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f22753b = "Tracer.File";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f22754c = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f22755d = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f22756e = 4096;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f22757f = 10000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f22759h = 10;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f22760i = ".log";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f22761j = Long.MAX_VALUE;

    public b(File file, int i10, int i11, int i12, String str, long j10, int i13, String str2, long j11) {
        a(file);
        b(i10);
        a(i11);
        c(i12);
        a(str);
        a(j10);
        d(i13);
        b(str2);
        b(j11);
    }

    private File[] c(long j10) {
        File fileB = b();
        String strC = c(d(j10));
        try {
            fileB = new File(fileB, strC);
        } catch (Throwable th2) {
            SLog.e(SLog.TAG, "getWorkFile,get old sdcard file exception:", th2);
        }
        String strB = k.b();
        File file = null;
        if (!TextUtils.isEmpty(strB) || strB != null) {
            try {
                File file2 = new File(strB, c.f22776o);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                file = new File(file2, strC);
            } catch (Exception e10) {
                SLog.e(SLog.TAG, "getWorkFile,get app specific file exception:", e10);
            }
        }
        return new File[]{fileB, file};
    }

    private String d(long j10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        return new SimpleDateFormat("yy.MM.dd.HH").format(calendar.getTime());
    }

    public File[] a() {
        return c(System.currentTimeMillis());
    }

    public File b() {
        File fileE = e();
        if (fileE != null) {
            fileE.mkdirs();
        }
        return fileE;
    }

    public File e() {
        return this.f22758g;
    }

    public int f() {
        return this.f22759h;
    }

    public void a(String str) {
        this.f22753b = str;
    }

    public void a(int i10) {
        this.f22754c = i10;
    }

    public void b(int i10) {
        this.f22755d = i10;
    }

    public void a(long j10) {
        this.f22757f = j10;
    }

    public void b(String str) {
        this.f22760i = str;
    }

    public void a(File file) {
        this.f22758g = file;
    }

    public void b(long j10) {
        this.f22761j = j10;
    }

    public int d() {
        return this.f22756e;
    }

    public void d(int i10) {
        this.f22759h = i10;
    }

    private String c(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + ".log";
    }

    public String c() {
        return this.f22753b;
    }

    public void c(int i10) {
        this.f22756e = i10;
    }
}
