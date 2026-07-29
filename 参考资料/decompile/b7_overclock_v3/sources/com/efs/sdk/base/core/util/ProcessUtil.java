package com.efs.sdk.base.core.util;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ProcessUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f12927a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<Integer> f12928b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f12929c = -1;

    public static String getCurrentProcessName() {
        String str = f12927a;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String processName = getProcessName(Process.myPid());
        f12927a = processName;
        return processName;
    }

    public static String getProcessName(int i10) {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + i10 + "/cmdline")));
            try {
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    int i11 = bufferedReader2.read();
                    if (i11 <= 0) {
                        sb2.trimToSize();
                        String string = sb2.toString();
                        try {
                            bufferedReader2.close();
                            return string;
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            return string;
                        }
                    }
                    sb2.append((char) i11);
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = bufferedReader2;
                try {
                    Log.e("efs.base", "get process name error", th);
                    return "";
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public static boolean isProcessExist(Context context, String str) {
        try {
            int i10 = Integer.parseInt(str);
            List<Integer> list = f12928b;
            boolean z10 = false;
            if (list != null && !list.isEmpty() && f12929c > 0 && System.currentTimeMillis() - f12929c <= androidx.work.impl.background.systemalarm.a.f8433m) {
                z10 = true;
            }
            if (!z10) {
                List<Integer> list2 = f12928b;
                if (list2 != null) {
                    list2.clear();
                } else {
                    f12928b = new ArrayList();
                }
                if (!TextUtils.isEmpty(getProcessName(Process.myPid()))) {
                    f12928b.add(Integer.valueOf(Process.myPid()));
                }
                if (!TextUtils.isEmpty(getProcessName(i10))) {
                    f12928b.add(Integer.valueOf(i10));
                }
                f12929c = System.currentTimeMillis();
            }
            return f12928b.contains(Integer.valueOf(i10));
        } catch (Throwable th2) {
            Log.e("efs.base", "Process exist judge error", th2);
            return true;
        }
    }

    public static int myPid() {
        return Process.myPid();
    }
}
