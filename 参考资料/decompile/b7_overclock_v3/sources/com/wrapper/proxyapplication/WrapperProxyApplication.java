package com.wrapper.proxyapplication;

import a9.a;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.widget.Toast;
import j3.b;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public abstract class WrapperProxyApplication extends Application {
    static Context baseContext;
    static Application shellApp = null;
    static String pkgName = a.f308b;
    static String className = "com.flydigi.qiji.FZApplication";
    static String tinkerApp = "tinker not support";
    static ClassLoader mLoader = null;
    static String protectlib = "libshell-super.com.fdg.flashplay.farsee.so";
    static String protectlibx86 = "libshellx-super.com.fdg.flashplay.farsee.so";
    static String shellsuperversion = "4.5.4.1";
    static String waringmsg = "Your app will be expired after ";
    static String errormsg = "Your app has been expired";
    static int yaqdate = 0;
    static Toast mtoast = null;
    static int counter = 0;
    Timer timer = new Timer();
    Handler mHandler = null;
    TimerTask toasttask = new TimerTask() { // from class: com.wrapper.proxyapplication.WrapperProxyApplication.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            WrapperProxyApplication.this.mHandler.post(new Runnable() { // from class: com.wrapper.proxyapplication.WrapperProxyApplication.1.1
                @Override // java.lang.Runnable
                public void run() {
                    SimpleDateFormat curdateformat = new SimpleDateFormat("yyyyMMdd");
                    int curdate = Integer.parseInt(curdateformat.format(Calendar.getInstance().getTime()));
                    if (curdate > WrapperProxyApplication.yaqdate) {
                        Toast.makeText(WrapperProxyApplication.this, WrapperProxyApplication.errormsg, 1).show();
                        return;
                    }
                    Toast.makeText(WrapperProxyApplication.this, WrapperProxyApplication.waringmsg + WrapperProxyApplication.yaqdate, 1).show();
                }
            });
        }
    };

    native void Ooo0ooO0oO();

    protected abstract void initProxyApplication(Context context);

    static Context getWrapperProxyAppBaseContext() {
        return baseContext;
    }

    private synchronized boolean Fixappname() {
        if (className.startsWith(b.f36044h)) {
            className = super.getPackageName() + className;
        } else if (className.indexOf(b.f36044h) < 0) {
            className = super.getPackageName() + b.f36044h + className;
        }
        return true;
    }

    public static void fixAndroid(Context context, Application application) {
        if (Build.VERSION.SDK_INT == 28) {
            try {
                ClassLoader mClassLoader = context.getClassLoader();
                mLoader = AndroidNClassLoader.inject(mClassLoader, application);
            } catch (Throwable e10) {
                e10.printStackTrace();
            }
        }
    }

    private static String getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return "0";
        }
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        baseContext = getBaseContext();
        if (shellApp == null) {
            shellApp = this;
        }
        Fixappname();
        initProxyApplication(context);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        Ooo0ooO0oO();
        if (yaqdate != 0) {
            this.mHandler = new Handler(getMainLooper());
            this.timer.schedule(this.toasttask, 0L, 3000L);
        }
    }
}
