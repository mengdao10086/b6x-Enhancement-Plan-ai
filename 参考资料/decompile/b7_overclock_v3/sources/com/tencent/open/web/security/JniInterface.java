package com.tencent.open.web.security;

import android.content.Context;
import com.tencent.connect.auth.AuthAgent;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.f;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class JniInterface {
    public static boolean isJniOk;

    public static native boolean BackSpaceChar(boolean z10, int i10);

    public static native boolean clearAllPWD();

    public static native String d1(String str);

    public static native String d2(String str);

    public static native String getPWDKeyToMD5(String str);

    public static native boolean insetTextToArray(int i10, String str, int i11);

    public static void loadSo() {
        if (isJniOk) {
            return;
        }
        try {
            Context contextA = f.a();
            if (contextA != null) {
                if (new File(contextA.getFilesDir().toString() + fh.a.f28350w + AuthAgent.SECURE_LIB_NAME).exists()) {
                    System.load(contextA.getFilesDir().toString() + fh.a.f28350w + AuthAgent.SECURE_LIB_NAME);
                    isJniOk = true;
                    SLog.i("openSDK_LOG.JniInterface", "-->load lib success:" + AuthAgent.SECURE_LIB_NAME);
                } else {
                    SLog.i("openSDK_LOG.JniInterface", "-->fail, because so is not exists:" + AuthAgent.SECURE_LIB_NAME);
                }
            } else {
                SLog.i("openSDK_LOG.JniInterface", "-->load lib fail, because context is null:" + AuthAgent.SECURE_LIB_NAME);
            }
        } catch (Throwable th2) {
            SLog.e("openSDK_LOG.JniInterface", "-->load lib error:" + AuthAgent.SECURE_LIB_NAME, th2);
        }
    }
}
