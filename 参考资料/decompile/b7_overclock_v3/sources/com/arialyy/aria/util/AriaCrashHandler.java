package com.arialyy.aria.util;

import android.os.Process;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class AriaCrashHandler implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
    private ExecutorService mExecutorService = Executors.newSingleThreadExecutor();

    private void exit() {
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    private void handleException(String str, final Throwable th2) {
        if (th2 == null) {
            return;
        }
        this.mExecutorService.execute(new Runnable() { // from class: com.arialyy.aria.util.AriaCrashHandler.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                ErrorHelp.saveError("", ALog.getExceptionString(th2));
            }
        });
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th2) {
        th2.printStackTrace();
        handleException(thread.getName(), th2);
        try {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
        } finally {
            this.mDefaultHandler.uncaughtException(thread, th2);
            exit();
        }
    }
}
