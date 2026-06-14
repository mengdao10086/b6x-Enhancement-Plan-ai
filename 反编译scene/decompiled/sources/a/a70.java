package a;

import android.os.Build;
import android.util.Base64;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class a70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f5576a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";

    public static void a(Process process, String str) throws IOException {
        OutputStream outputStream = process.getOutputStream();
        outputStream.write("\n".getBytes());
        outputStream.write(str.getBytes());
        outputStream.write("\n".getBytes());
        outputStream.flush();
    }

    public static String b() {
        String str = f5576a;
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (b.isEmpty()) {
            try {
                Process processExec = Runtime.getRuntime().exec("sh");
                OutputStream outputStream = processExec.getOutputStream();
                outputStream.write("echo $PATH".getBytes());
                outputStream.flush();
                outputStream.close();
                InputStream inputStream = processExec.getInputStream();
                byte[] bArr = new byte[16384];
                int i = inputStream.read(bArr);
                inputStream.close();
                processExec.destroy();
                String strTrim = new String(bArr, 0, i).trim();
                if (strTrim.length() <= 0) {
                    throw new RuntimeException("未能获取到$PATH参数");
                }
                b = strTrim;
            } catch (Exception unused) {
                b = "/sbin:/system/sbin:/system/bin:/system/xbin:/odm/bin:/vendor/bin:/vendor/xbin";
            }
        }
        String str2 = b;
        if (d().equals("KernelSU") && !str2.contains(":/data/adb/ksu/bin")) {
            str2 = str2 + ":/data/adb/ksu/bin";
        }
        return "PATH=" + str2 + ":" + f5576a;
    }

    public static Process c(String str) throws IOException {
        String strB = b();
        Process processExec = Runtime.getRuntime().exec(str);
        if (strB != null) {
            OutputStream outputStream = processExec.getOutputStream();
            outputStream.write("export ".getBytes());
            outputStream.write(strB.getBytes());
            outputStream.write("\n".getBytes());
            outputStream.flush();
        }
        return processExec;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0019 A[PHI: r3
  0x0019: PHI (r3v7 java.lang.String) = (r3v0 java.lang.String), (r3v1 java.lang.String) binds: [B:7:0x0017, B:10:0x0025] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String d() {
        /*
            java.lang.String r0 = "MAGISK"
            java.lang.String r1 = "KernelSU"
            java.lang.String r2 = a.a70.c
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto Lf
            java.lang.String r0 = a.a70.c
            return r0
        Lf:
            java.lang.String r2 = a.a70.d
            java.lang.String r3 = "mqsas"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L1d
        L19:
            a.a70.c = r3
            goto L8e
        L1d:
            java.lang.String r2 = a.a70.d
            java.lang.String r3 = "xsu"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L28
            goto L19
        L28:
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Exception -> L84
            java.lang.String r3 = "su -v"
            java.lang.Process r2 = r2.exec(r3)     // Catch: java.lang.Exception -> L84
            java.io.OutputStream r3 = r2.getOutputStream()     // Catch: java.lang.Exception -> L84
            java.lang.String r4 = "exit 0\nexit 0"
            byte[] r4 = r4.getBytes()     // Catch: java.lang.Exception -> L84
            r3.write(r4)     // Catch: java.lang.Exception -> L84
            r3.flush()     // Catch: java.lang.Exception -> L84
            r3.close()     // Catch: java.lang.Exception -> L84
            java.io.InputStream r3 = r2.getInputStream()     // Catch: java.lang.Exception -> L84
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Exception -> L84
            int r5 = r3.read(r4)     // Catch: java.lang.Exception -> L84
            r3.close()     // Catch: java.lang.Exception -> L84
            r2.destroy()     // Catch: java.lang.Exception -> L84
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Exception -> L84
            r3 = 0
            r2.<init>(r4, r3, r5)     // Catch: java.lang.Exception -> L84
            java.lang.String r2 = r2.trim()     // Catch: java.lang.Exception -> L84
            java.lang.String r2 = r2.toUpperCase()     // Catch: java.lang.Exception -> L84
            boolean r3 = r2.contains(r0)     // Catch: java.lang.Exception -> L84
            if (r3 == 0) goto L6e
        L6b:
            a.a70.c = r0     // Catch: java.lang.Exception -> L84
            goto L84
        L6e:
            java.lang.String r0 = "KERNELSU"
            boolean r0 = r2.contains(r0)     // Catch: java.lang.Exception -> L84
            if (r0 == 0) goto L79
            a.a70.c = r1     // Catch: java.lang.Exception -> L84
            goto L84
        L79:
            java.lang.String r0 = "APATCH"
            boolean r0 = r2.contains(r0)     // Catch: java.lang.Exception -> L84
            if (r0 == 0) goto L84
            java.lang.String r0 = "apd"
            goto L6b
        L84:
            java.lang.String r0 = a.a70.c
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L8e
            a.a70.c = r1
        L8e:
            java.lang.String r0 = a.a70.c
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a70.d():java.lang.String");
    }

    public static Process e() {
        return c("sh");
    }

    public static String f(boolean z) {
        String str;
        if (d.isEmpty() || z) {
            if (Build.VERSION.SDK_INT >= 30) {
                String strD = d();
                if (!strD.equals("MAGISK")) {
                    str = strD.equals("KernelSU") ? "su -M" : "magisk su -mm";
                    d = "su";
                }
                d = str;
            } else {
                d = "su";
            }
        }
        return d;
    }

    public static Process g() {
        return c(f(false));
    }

    public static Process h(String str) throws IOException {
        Process processC = c("sh");
        a(processC, String.format(new String(Base64.decode("c2VydmljZSBjYWxsIG1pdWkubXFzYXMuSU1RU05hdGl2ZSAyMSBpMzIgMSBzMTYgJ3NoJyBpMzIgMSBzMTYgJyVzJyBzMTYgJy9kYXRhL21xc2FzL2NhbGwubG9nJyBpMzIgNjAKc2xlZXAgMS41CmV4aXQgMApleGl0IDAK", 0)), str));
        return processC;
    }

    public static void i(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception unused) {
        }
        f5576a = str;
    }

    public static void j(String str) {
        d = str;
    }

    public static Process k(String str) {
        return c("xsu " + str);
    }
}
