package com.fdg.flashplay.farsee;

import android.content.Context;
import android.os.Process;
import com.wrapper.proxyapplication.Util;
import com.wrapper.proxyapplication.WrapperProxyApplication;
import java.io.IOException;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public class MyWrapperProxyApplication extends WrapperProxyApplication {
    @Override // com.wrapper.proxyapplication.WrapperProxyApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
    }

    @Override // com.wrapper.proxyapplication.WrapperProxyApplication
    protected void initProxyApplication(Context ctx) throws Throwable {
        String apkdir = ctx.getApplicationInfo().sourceDir;
        ZipFile apkzf = null;
        try {
            apkzf = new ZipFile(apkdir);
        } catch (IOException e10) {
            e10.printStackTrace();
        }
        if (apkzf == null) {
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
        Util.PrepareSecurefiles(ctx, apkzf);
        try {
            apkzf.close();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        if (Util.CPUABI == "86" || Util.CPUABI == "86_64") {
            System.load(ctx.getFilesDir().getAbsolutePath() + "/prodexdir/" + Util.libname);
            return;
        }
        System.loadLibrary(Util.simplelibname);
    }
}
