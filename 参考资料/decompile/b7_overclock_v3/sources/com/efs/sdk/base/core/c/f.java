package com.efs.sdk.base.core.c;

import android.content.Context;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.ProcessUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static FileLock f12828b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f12829a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final f f12832a = new f(0);
    }

    public /* synthetic */ f(byte b10) {
        this();
    }

    public final boolean a() {
        if (this.f12829a == 2) {
            return true;
        }
        if (this.f12829a != 0) {
            return false;
        }
        a(ControllerCenter.getGlobalEnvStruct().mAppContext);
        return false;
    }

    private f() {
        this.f12829a = 0;
        a(ControllerCenter.getGlobalEnvStruct().mAppContext);
    }

    private synchronized void a(final Context context) {
        Log.w("efs.send_log", "tryFileLock start! ");
        this.f12829a = 1;
        new Thread(new Runnable() { // from class: com.efs.sdk.base.core.c.f.1
            @Override // java.lang.Runnable
            public final void run() {
                FileLock fileLockLock;
                try {
                    File fileA = com.efs.sdk.base.core.util.a.a(context);
                    if (!fileA.exists()) {
                        fileA.mkdirs();
                    }
                    File file = new File(fileA.getPath() + File.separator + "sendlock");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    do {
                        fileLockLock = new FileOutputStream(file).getChannel().lock();
                        f.f12828b = fileLockLock;
                    } while (!fileLockLock.isValid());
                    Log.w("efs.send_log", "tryFileLock sendlock sucess! processname: " + ProcessUtil.getCurrentProcessName());
                    f.this.f12829a = 2;
                } catch (Exception e10) {
                    Log.w("efs.send_log", "tryFileLock fail! " + e10.getMessage());
                    f.this.f12829a = 0;
                }
            }
        }).start();
    }
}
