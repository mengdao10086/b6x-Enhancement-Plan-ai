package com.omarea.xposed;

import a.a32;
import a.e32;
import a.f22;
import a.g30;
import a.h22;
import a.iz0;
import a.j22;
import a.n32;
import a.p22;
import android.app.Activity;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class XposedInterface implements IXposedHookLoadPackage, IXposedHookZygoteInit {
    public static XSharedPreferences prefs;

    public class a extends XC_MethodHook {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f8928a;

        public a(XposedInterface xposedInterface, boolean z) {
            this.f8928a = z;
        }

        public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
            super.afterHookedMethod(methodHookParam);
            try {
                if (((Boolean) methodHookParam.args[0]).booleanValue()) {
                    XposedHelpers.callMethod(methodHookParam.thisObject, "setForeground", new Object[]{Boolean.FALSE});
                }
            } catch (Exception unused) {
            }
        }

        public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
            if (this.f8928a) {
                methodHookParam.args[0] = Boolean.FALSE;
            }
            super.afterHookedMethod(methodHookParam);
        }
    }

    public class b extends XC_MethodHook {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f8929a;

        public b(XposedInterface xposedInterface, boolean z) {
            this.f8929a = z;
        }

        public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
            super.afterHookedMethod(methodHookParam);
            if (this.f8929a) {
                XposedHelpers.callMethod(methodHookParam.thisObject, "stopForeground", new Object[]{Boolean.TRUE});
            }
        }
    }

    public class c extends XC_MethodHook {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8930a;

        public c(XposedInterface xposedInterface, int i) {
            this.f8930a = i;
        }

        public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
            super.beforeHookedMethod(methodHookParam);
            Context context = (Context) methodHookParam.args[0];
            if (context == null) {
                return;
            }
            try {
                Configuration configuration = context.getResources().getConfiguration();
                configuration.densityDpi = this.f8930a;
                context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
                context.getResources().getDisplayMetrics().density = this.f8930a / 160.0f;
                context.getResources().getDisplayMetrics().densityDpi = this.f8930a;
                context.getResources().getDisplayMetrics().scaledDensity = this.f8930a / 160.0f;
            } catch (Exception e) {
                XposedBridge.log(e);
            }
        }
    }

    public class d extends XC_MethodHook {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8931a;

        public d(XposedInterface xposedInterface, int i) {
            this.f8931a = i;
        }

        public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
            XposedHelpers.setIntField(XposedHelpers.getObjectField(methodHookParam.thisObject, "mDisplayInfo"), "logicalDensityDpi", this.f8931a);
            DisplayMetrics displayMetrics = (DisplayMetrics) methodHookParam.args[0];
            int i = this.f8931a;
            displayMetrics.scaledDensity = i / 160.0f;
            displayMetrics.densityDpi = i;
            displayMetrics.density = i / 160.0f;
        }
    }

    public class e extends XC_MethodHook {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8932a;

        public e(XposedInterface xposedInterface, int i) {
            this.f8932a = i;
        }

        public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
            DisplayMetrics displayMetrics = (DisplayMetrics) XposedHelpers.getObjectField(methodHookParam.thisObject, "mMetrics");
            if (displayMetrics != null) {
                int i = this.f8932a;
                displayMetrics.scaledDensity = i / 160.0f;
                displayMetrics.densityDpi = i;
                displayMetrics.density = i / 160.0f;
            }
        }
    }

    public class f extends XC_MethodHook {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8933a;

        public f(XposedInterface xposedInterface, int i) {
            this.f8933a = i;
        }

        public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
            methodHookParam.setResult(Integer.valueOf(this.f8933a));
        }
    }

    public class g extends XC_MethodHook {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8934a;

        public g(XposedInterface xposedInterface, int i) {
            this.f8934a = i;
        }

        public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
            DisplayMetrics displayMetrics = (DisplayMetrics) methodHookParam.getResult();
            if (displayMetrics != null) {
                int i = this.f8934a;
                displayMetrics.scaledDensity = i / 160.0f;
                displayMetrics.densityDpi = i;
                displayMetrics.density = i / 160.0f;
            }
        }
    }

    public class h extends XC_MethodHook {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8935a;

        public h(XposedInterface xposedInterface, int i) {
            this.f8935a = i;
        }

        public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
            super.beforeHookedMethod(methodHookParam);
            try {
                Resources resources = ((Activity) methodHookParam.thisObject).getWindow().getDecorView().getResources();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                Configuration configuration = resources.getConfiguration();
                configuration.densityDpi = this.f8935a;
                resources.updateConfiguration(configuration, displayMetrics);
                displayMetrics.density = this.f8935a / 160.0f;
                displayMetrics.densityDpi = this.f8935a;
                displayMetrics.scaledDensity = this.f8935a / 160.0f;
            } catch (Exception e) {
                XposedBridge.log(e);
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public iz0.a getAppConfig(String str) {
        try {
            g30 g30Var = new g30(prefs.getString(str, "{}"));
            iz0.a aVar = new iz0.a(str);
            Iterator<String> itK = g30Var.k();
            while (itK.hasNext()) {
                String next = itK.next();
                byte b2 = -1;
                switch (next.hashCode()) {
                    case -743846049:
                        if (next.equals("webDebug")) {
                            b2 = 3;
                        }
                        break;
                    case 99677:
                        if (next.equals("dpi")) {
                            b2 = 0;
                        }
                        break;
                    case 539018453:
                        if (next.equals("excludeRecent")) {
                            b2 = 1;
                        }
                        break;
                    case 848088603:
                        if (next.equals("smoothScroll")) {
                            b2 = 2;
                        }
                        break;
                }
                if (b2 == 0) {
                    aVar.f(g30Var.e(next));
                } else if (b2 == 1) {
                    aVar.g(g30Var.c(next));
                } else if (b2 == 2) {
                    aVar.h(g30Var.c(next));
                } else if (b2 == 3) {
                    aVar.i(g30Var.c(next));
                }
            }
            return aVar;
        } catch (Exception unused) {
            return null;
        }
    }

    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        if (loadPackageParam.isFirstApplication) {
            prefs.reload();
            String str = loadPackageParam.packageName;
            iz0.a appConfig = getAppConfig(str);
            byte b2 = -1;
            int iHashCode = str.hashCode();
            if (iHashCode != -973170826) {
                if (iHashCode != -428268686) {
                    if (iHashCode == -374804133 && str.equals("com.omarea.vtools")) {
                        b2 = 0;
                    }
                } else if (str.equals("com.omarea.vboot")) {
                    b2 = 1;
                }
            } else if (str.equals("com.tencent.mm")) {
                b2 = 2;
            }
            if (b2 == 0 || b2 == 1) {
                new f22().a(loadPackageParam);
            } else if (b2 == 2) {
                new n32().d(loadPackageParam);
            }
            if (!str.equals("android")) {
                new h22().b(loadPackageParam);
            }
            if (!str.equals("android") && !str.equals("com.android.systemui") && (appConfig.d() || prefs.getBoolean("android_scroll", false))) {
                new a32().b(loadPackageParam);
            }
            if (appConfig.b()) {
                new j22().a(loadPackageParam);
            }
            if (appConfig.e()) {
                new e32().a();
            }
            if (prefs.getBoolean("reverse_optimizer", false)) {
                new p22().a(loadPackageParam);
            }
            int iA = appConfig.a();
            if (iA >= 96) {
                XposedHelpers.findAndHookMethod("android.app.Application", loadPackageParam.classLoader, "attach", new Object[]{Context.class, new c(this, iA)});
                XposedHelpers.findAndHookMethod(Display.class, "getMetrics", new Object[]{DisplayMetrics.class, new d(this, iA)});
                XposedHelpers.findAndHookMethod("android.content.res.ResourcesImpl", loadPackageParam.classLoader, "getDisplayMetrics", new Object[]{new e(this, iA)});
                XposedBridge.hookAllMethods(DisplayMetrics.class, "getDeviceDensity", new f(this, iA));
                ClassLoader classLoader = loadPackageParam.classLoader;
                Class cls = Integer.TYPE;
                XposedHelpers.findAndHookMethod("android.content.res.ResourcesImpl", classLoader, "loadDrawable", new Object[]{Resources.class, TypedValue.class, cls, cls, Resources.Theme.class, new g(this, iA)});
                XposedHelpers.findAndHookMethod("android.app.Activity", loadPackageParam.classLoader, "onCreate", new Object[]{Bundle.class, new h(this, iA)});
            }
        }
    }

    public void initZygote(IXposedHookZygoteInit.StartupParam startupParam) {
        XSharedPreferences xSharedPreferences = new XSharedPreferences("com.omarea.vaddin", "xposed");
        prefs = xSharedPreferences;
        xSharedPreferences.makeWorldReadable();
        boolean z = prefs.getBoolean("android_dis_service_foreground", false);
        XposedHelpers.findAndHookMethod(Service.class, "setForeground", new Object[]{Boolean.TYPE, new a(this, z)});
        XposedHelpers.findAndHookMethod(Service.class, "startForeground", new Object[]{Integer.TYPE, Notification.class, new b(this, z)});
    }
}
