package com.arialyy.aria.util;

import android.annotation.SuppressLint;
import com.arialyy.aria.core.AriaConfig;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import wn.a;

/* JADX INFO: loaded from: classes2.dex */
public class ErrorHelp {
    @SuppressLint({"SimpleDateFormat"})
    private static String getData(String str) {
        return new SimpleDateFormat(str).format(new Date(System.currentTimeMillis()));
    }

    private static String getLogPath() {
        String str = String.format("%slog/AriaCrash_%s.log", CommonUtil.getAppPath(AriaConfig.getInstance().getAPP()), getData("yyyy-MM-dd_HH_mm_ss"));
        FileUtil.createFile(str);
        return str;
    }

    public static void saveError(String str, String str2) throws Throwable {
        writeLogToFile(String.format("\nmsg【%s】\nException：%s", str, str2));
    }

    private static int writeLogToFile(String str) throws Throwable {
        PrintWriter printWriter;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getData("yyyy-MM-dd HH:mm:ss"));
        stringBuffer.append(a.f54751a);
        stringBuffer.append(str);
        stringBuffer.append("\n\n");
        PrintWriter printWriter2 = null;
        try {
            try {
                File file = new File(getLogPath());
                if (!file.exists()) {
                    FileUtil.createFile(file);
                }
                printWriter = new PrintWriter(new FileWriter(file.getPath(), true));
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            printWriter.append((CharSequence) stringBuffer);
            printWriter.flush();
            printWriter.close();
            return 0;
        } catch (Exception e11) {
            e = e11;
            printWriter2 = printWriter;
            e.printStackTrace();
            if (printWriter2 == null) {
                return 0;
            }
            printWriter2.close();
            return 0;
        } catch (Throwable th3) {
            th = th3;
            printWriter2 = printWriter;
            if (printWriter2 != null) {
                printWriter2.close();
            }
            throw th;
        }
    }
}
