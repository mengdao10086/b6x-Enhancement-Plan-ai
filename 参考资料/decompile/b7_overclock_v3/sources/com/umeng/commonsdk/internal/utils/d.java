package com.umeng.commonsdk.internal.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f24090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f24091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f24092c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f24093d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f24094e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f24095f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f24096g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f24097h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f24098i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f24099j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f24100k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f24101l;
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x012f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0128 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x013e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0137 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.umeng.commonsdk.internal.utils.d.a a() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.d.a():com.umeng.commonsdk.internal.utils.d$a");
    }

    public static String b() {
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Exception unused) {
        }
        return str.trim();
    }

    public static String c() {
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Exception unused) {
        }
        return str.trim();
    }

    public static String d() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th2;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"));
            try {
                String strTrim = bufferedReader.readLine().trim();
                try {
                    bufferedReader.close();
                    return strTrim;
                } catch (Throwable unused) {
                    return strTrim;
                }
            } catch (Exception unused2) {
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Throwable unused3) {
                    }
                }
                return "";
            } catch (Throwable th3) {
                th2 = th3;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th2;
            }
        } catch (Exception unused5) {
        } catch (Throwable th4) {
            bufferedReader = null;
            th2 = th4;
        }
    }
}
