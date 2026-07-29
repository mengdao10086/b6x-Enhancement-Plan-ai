package com.umeng.commonsdk;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.utils.c;
import com.umeng.commonsdk.internal.utils.k;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.utils.d;

/* JADX INFO: loaded from: classes5.dex */
public class UMInnerImpl {
    private static boolean isInternal;

    public static synchronized void initAndSendInternal(final Context context) {
        if (context != null) {
            try {
                if (!isInternal) {
                    new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMInnerImpl.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                String currentProcessName = UMFrUtils.getCurrentProcessName(context);
                                String packageName = context.getPackageName();
                                if (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName)) {
                                    return;
                                }
                                try {
                                    if (FieldManager.allow(d.f24406ao) && !c.a(context).a()) {
                                        c.a(context).b();
                                    }
                                } catch (Throwable th2) {
                                    ULog.e(UMModuleRegister.INNER, "e is " + th2);
                                }
                                try {
                                    k.b(context);
                                } catch (Throwable th3) {
                                    ULog.e(UMModuleRegister.INNER, "e is " + th3);
                                }
                            } catch (Throwable th4) {
                                UMCrashManager.reportCrash(context, th4);
                            }
                        }
                    }).start();
                    isInternal = true;
                    sendInternal(context);
                }
            } finally {
            }
        }
    }

    private static synchronized void sendInternal(final Context context) {
        if (context != null) {
            try {
                new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMInnerImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            String currentProcessName = UMFrUtils.getCurrentProcessName(context);
                            String packageName = context.getPackageName();
                            if (!TextUtils.isEmpty(currentProcessName) && !TextUtils.isEmpty(packageName) && currentProcessName.equals(packageName)) {
                                try {
                                    com.umeng.commonsdk.internal.d.b(context);
                                } catch (Throwable th2) {
                                    ULog.e(UMModuleRegister.INNER, "e is " + th2);
                                }
                            }
                        } catch (Throwable th3) {
                            UMCrashManager.reportCrash(context, th3);
                        }
                    }
                }).start();
                isInternal = true;
            } finally {
            }
        }
    }
}
