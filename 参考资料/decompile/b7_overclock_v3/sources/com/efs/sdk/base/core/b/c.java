package com.efs.sdk.base.core.b;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.efs.sdk.base.core.b.a;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends Handler implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f12803a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f12804a = new c(0);
    }

    public /* synthetic */ c(byte b10) {
        this();
    }

    public static c a() {
        return a.f12804a;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what == 2) {
            WorkThreadUtil.submit(this);
            return;
        }
        Log.w("efs.cache", "disk listener not support command: " + message.what);
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.efs.sdk.base.core.b.a unused = a.b.f12801a;
        File fileF = com.efs.sdk.base.core.util.a.f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (fileF.exists()) {
            for (File file : com.efs.sdk.base.core.util.b.d(fileF)) {
                if (com.efs.sdk.base.core.b.a.a(file.getName())) {
                    com.efs.sdk.base.core.b.a.c(file);
                }
            }
        }
        com.efs.sdk.base.core.config.a.c cVarA = com.efs.sdk.base.core.config.a.c.a();
        String str = cVarA.f12860d.f12855f.containsKey("disk_bytes") ? cVarA.f12860d.f12855f.get("disk_bytes") : "4194304";
        long j10 = Long.parseLong(TextUtils.isEmpty(str) ? "4194304" : str);
        long jC = com.efs.sdk.base.core.util.b.c(com.efs.sdk.base.core.util.a.f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid())) + com.efs.sdk.base.core.util.b.c(com.efs.sdk.base.core.util.a.d(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()));
        boolean z10 = jC < j10;
        this.f12803a = z10;
        if (!z10) {
            Log.w("efs.cache", "Cache Limited! curr " + jC + "byte, max " + j10 + " byte.");
        }
        sendEmptyMessageDelayed(2, androidx.work.impl.background.systemalarm.a.f8433m);
    }

    private c() {
        super(com.efs.sdk.base.core.util.concurrent.a.f12946a.getLooper());
        this.f12803a = true;
        sendEmptyMessageDelayed(2, 60000L);
    }
}
