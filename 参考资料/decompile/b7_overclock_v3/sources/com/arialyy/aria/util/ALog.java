package com.arialyy.aria.util;

import android.text.TextUtils;
import android.util.Log;
import com.blankj.utilcode.util.i0;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import okhttp3.u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import zc.a;

/* JADX INFO: loaded from: classes2.dex */
public class ALog {
    public static final boolean DEBUG = true;
    public static final int LOG_CLOSE = 8;
    public static final int LOG_DEFAULT = 3;
    public static int LOG_LEVEL = 3;
    public static final int LOG_LEVEL_ASSERT = 7;
    public static final int LOG_LEVEL_DEBUG = 3;
    public static final int LOG_LEVEL_ERROR = 6;
    public static final int LOG_LEVEL_INFO = 4;
    public static final int LOG_LEVEL_VERBOSE = 2;
    public static final int LOG_LEVEL_WARN = 5;

    public static int d(String str, String str2) {
        return println(3, str, str2);
    }

    public static int e(String str, String str2) {
        return println(6, str, str2);
    }

    public static void e(String str, String str2, Throwable th2) {
    }

    public static String getExceptionString(Throwable th2) {
        if (th2 == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ExceptionDetailed:\n");
        sb2.append("====================Exception Info====================\n");
        sb2.append(th2.toString());
        sb2.append("\n");
        for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
            sb2.append(stackTraceElement.toString());
            sb2.append("\n");
        }
        Throwable cause = th2.getCause();
        if (cause != null) {
            sb2.append("【Caused by】: ");
            sb2.append(cause.toString());
            sb2.append("\n");
            for (StackTraceElement stackTraceElement2 : cause.getStackTrace()) {
                sb2.append(stackTraceElement2.toString());
                sb2.append("\n");
            }
        }
        sb2.append("===================================================");
        return sb2.toString();
    }

    public static int i(String str, String str2) {
        return println(4, str, str2);
    }

    public static void j(String str, String str2) {
        if (LOG_LEVEL <= 3) {
            try {
                if (str2.startsWith(a.f58316d)) {
                    str2 = new JSONObject(str2).toString(4);
                } else if (str2.startsWith("[")) {
                    str2 = new JSONArray(str2).toString(4);
                }
            } catch (JSONException unused) {
            }
            println(3, str, str2);
        }
    }

    public static void m(String str, Map map) {
        if (LOG_LEVEL <= 3) {
            Set<Map.Entry> setEntrySet = map.entrySet();
            if (setEntrySet.size() < 1) {
                d(str, u.f43953p);
                return;
            }
            int i10 = 0;
            String[] strArr = new String[setEntrySet.size()];
            for (Map.Entry entry : setEntrySet) {
                strArr[i10] = entry.getKey() + " = " + entry.getValue() + ",\n";
                i10++;
            }
            println(3, str, Arrays.toString(strArr));
        }
    }

    private static int println(int i10, String str, String str2) {
        if (LOG_LEVEL > i10) {
            return -1;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = i0.f11859x;
        }
        return Log.println(i10, str, str2);
    }

    public static int v(String str, String str2) {
        return println(2, str, str2);
    }

    public static int w(String str, String str2) {
        return println(5, str, str2);
    }
}
