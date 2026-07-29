package com.arialyy.aria.core.config;

import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.AriaCrashHandler;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class AppConfig extends BaseConfig implements Serializable {
    public int logLevel;
    public boolean useAriaCrashHandler;
    public boolean netCheck = true;
    public boolean useBroadcast = false;
    public boolean notNetRetry = false;

    public int getLogLevel() {
        return this.logLevel;
    }

    @Override // com.arialyy.aria.core.config.BaseConfig
    public int getType() {
        return 3;
    }

    public boolean getUseAriaCrashHandler() {
        return this.useAriaCrashHandler;
    }

    public boolean isNetCheck() {
        return this.netCheck;
    }

    public boolean isNotNetRetry() {
        return this.notNetRetry;
    }

    public boolean isUseBroadcast() {
        return this.useBroadcast;
    }

    public AppConfig setLogLevel(int i10) throws Throwable {
        this.logLevel = i10;
        ALog.LOG_LEVEL = i10;
        save();
        return this;
    }

    public AppConfig setNetCheck(boolean z10) throws Throwable {
        this.netCheck = z10;
        save();
        return this;
    }

    public AppConfig setNotNetRetry(boolean z10) throws Throwable {
        this.notNetRetry = z10;
        save();
        return this;
    }

    public AppConfig setUseAriaCrashHandler(boolean z10) throws Throwable {
        this.useAriaCrashHandler = z10;
        if (z10) {
            Thread.setDefaultUncaughtExceptionHandler(new AriaCrashHandler());
        } else {
            Thread.setDefaultUncaughtExceptionHandler(null);
        }
        save();
        return this;
    }

    public AppConfig setUseBroadcast(boolean z10) throws Throwable {
        this.useBroadcast = z10;
        save();
        return this;
    }
}
