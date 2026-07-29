package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.z;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.utils.UMUtils;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f23867a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f23868b = "umeng+";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f23869c = "ek__id";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f23870d = "ek_key";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f23871e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f23872f = z.b().b(z.f23808n);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f23873g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static a f23874h;

    private a() {
    }

    public static a a() {
        if (f23874h == null) {
            synchronized (a.class) {
                if (f23874h == null) {
                    f23874h = new a();
                }
            }
        }
        return f23874h;
    }

    private String c(String str) {
        String string = "";
        try {
            String strSubstring = str.substring(1, 9);
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < strSubstring.length(); i10++) {
                char cCharAt = strSubstring.charAt(i10);
                if (!Character.isDigit(cCharAt)) {
                    sb2.append(cCharAt);
                } else if (Integer.parseInt(Character.toString(cCharAt)) == 0) {
                    sb2.append(0);
                } else {
                    sb2.append(10 - Integer.parseInt(Character.toString(cCharAt)));
                }
            }
            string = sb2.toString();
            return string + new StringBuilder(string).reverse().toString();
        } catch (Throwable unused) {
            return string;
        }
    }

    public String b(String str) {
        String str2;
        String str3 = null;
        try {
            if (!TextUtils.isEmpty(f23867a)) {
                str = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f23867a.getBytes()));
            }
            return str;
        } catch (Exception unused) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败!");
            if (TextUtils.isEmpty(f23871e)) {
                return null;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试");
            try {
                str2 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f23871e.getBytes()));
            } catch (Exception unused2) {
            }
            try {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试成功。");
                return str2;
            } catch (Exception unused3) {
                str3 = str2;
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试失败。换子进程备份key重试。");
                try {
                    String str4 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f23873g.getBytes()));
                    try {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试成功。");
                        return str4;
                    } catch (Throwable unused4) {
                        str3 = str4;
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试失败。");
                        return str3;
                    }
                } catch (Throwable unused5) {
                }
            }
        }
    }

    public void a(Context context) {
        try {
            if (TextUtils.isEmpty(f23867a)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(context, f23869c);
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    f23871e = c(multiProcessSP);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> primaryKey: " + f23871e);
                }
                SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f23872f, 0);
                if (sharedPreferences != null) {
                    f23873g = sharedPreferences.getString(f23869c, null);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程备份秘钥：主进程key: " + f23873g);
                }
                f23867a = c(UMUtils.genId());
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> 正式秘钥：key: " + f23867a);
            }
        } catch (Throwable unused) {
        }
    }

    public String a(String str) {
        try {
            return TextUtils.isEmpty(f23867a) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f23867a.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }
}
