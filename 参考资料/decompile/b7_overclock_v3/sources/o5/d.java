package o5;

import android.app.AppOpsManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.hardware.input.InputManager;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.blankj.utilcode.util.j1;
import g.v0;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static boolean a(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.android.settings", "com.android.settings.Settings$OverlaySettingsActivity");
        if (t(intent, context)) {
            return true;
        }
        intent.setClassName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.AppEnterActivity");
        return t(intent, context);
    }

    public static boolean b(Context context) {
        try {
            Intent intent = new Intent(Settings.class.getDeclaredField("ACTION_MANAGE_OVERLAY_PERMISSION").get(null).toString());
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            t(intent, context);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.yulong.android.seccenter", "com.yulong.android.seccenter.dataprotection.ui.AppListActivity");
        return t(intent, context);
    }

    public static boolean d(Context context) {
        try {
            try {
                try {
                    Intent intent = new Intent();
                    intent.setFlags(268435456);
                    intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity"));
                    if (!t(intent, context)) {
                        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity"));
                        context.startActivity(intent);
                    }
                    return true;
                } catch (Exception e10) {
                    com.flydigi.base.common.n.d(e10, "Huawei跳转失败1", new Object[0]);
                    return p(context);
                }
            } catch (Exception e11) {
                com.flydigi.base.common.n.d(e11, "Huawei跳转失败2", new Object[0]);
                return p(context);
            }
        } catch (ActivityNotFoundException unused) {
            Intent intent2 = new Intent();
            intent2.setFlags(268435456);
            intent2.setComponent(new ComponentName("com.Android.settings", "com.android.settings.permission.TabItem"));
            context.startActivity(intent2);
            return true;
        } catch (SecurityException unused2) {
            Intent intent3 = new Intent();
            intent3.setFlags(268435456);
            intent3.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            context.startActivity(intent3);
            return true;
        } catch (Exception unused3) {
            return p(context);
        }
    }

    public static boolean e(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.lenovo.safecenter", "com.lenovo.safecenter.MainTab.LeSafeMainActivity");
        return t(intent, context);
    }

    public static boolean f(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AppActivity");
        return t(intent, context);
    }

    public static boolean g(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
        intent.putExtra("packageName", context.getPackageName());
        return t(intent, context);
    }

    public static boolean h(Context context) {
        Intent intent = new Intent();
        intent.setAction("miui.intent.action.APP_PERM_EDITOR");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("extra_pkgname", context.getPackageName());
        return t(intent, context);
    }

    public static boolean i(Context context) {
        Intent intent = new Intent();
        intent.putExtra("packageName", context.getPackageName());
        intent.setAction("com.oppo.safe");
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionAppListActivity");
        if (!t(intent, context)) {
            intent.setAction("com.color.safecenter");
            intent.setClassName("com.color.safecenter", "com.color.safecenter.permission.floatwindow.FloatWindowListActivity");
            if (!t(intent, context)) {
                intent.setAction("com.coloros.safecenter");
                intent.setClassName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity");
                return t(intent, context);
            }
        }
        return true;
    }

    public static boolean j(Context context) {
        Intent intent = new Intent("com.smartisanos.security.action.SWITCHED_PERMISSIONS_NEW");
        intent.setClassName("com.smartisanos.security", "com.smartisanos.security.SwitchedPermissions");
        intent.putExtra("index", 17);
        if (t(intent, context)) {
            return true;
        }
        Intent intent2 = new Intent("com.smartisanos.security.action.SWITCHED_PERMISSIONS");
        intent2.setClassName("com.smartisanos.security", "com.smartisanos.security.SwitchedPermissions");
        intent2.putExtra("permission", new String[]{"android.permission.SYSTEM_ALERT_WINDOW"});
        return t(intent2, context);
    }

    public static boolean k(Context context) {
        Intent intent = new Intent();
        intent.putExtra("packagename", context.getPackageName());
        intent.setAction("com.vivo.permissionmanager");
        intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            return t(intent, context);
        }
        intent.setAction("com.iqoo.secure");
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity");
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            return t(intent, context);
        }
        intent.setAction("com.iqoo.secure");
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.MainActivity");
        return intent.resolveActivity(context.getPackageManager()) != null ? t(intent, context) : t(intent, context);
    }

    public static boolean l(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.zte.heartyservice.intent.action.startActivity.PERMISSION_SCANNER");
        return t(intent, context);
    }

    @v0(api = 19)
    public static boolean m(Context context) {
        try {
            Object systemService = context.getSystemService("appops");
            if (systemService == null) {
                return false;
            }
            Class<?> cls = systemService.getClass();
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("checkOp", cls2, cls2, String.class);
            if (method == null) {
                return false;
            }
            if (((Integer) method.invoke(systemService, 24, Integer.valueOf(Binder.getCallingUid()), com.blankj.utilcode.util.d.l())).intValue() != 0) {
                if (h.f()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean n(Context context) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        if (appOpsManager == null) {
            return false;
        }
        try {
            return appOpsManager.checkOpNoThrow("android:system_alert_window", Process.myUid(), context.getPackageName()) == 0;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static boolean o(Context context) {
        return Build.VERSION.SDK_INT >= 23 ? Settings.canDrawOverlays(context) : m(context);
    }

    public static boolean p(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        return t(intent, context);
    }

    public static WindowManager.LayoutParams q(boolean z10, boolean z11) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            layoutParams.type = 2038;
            if (i10 >= 28) {
                layoutParams.layoutInDisplayCutoutMode = 1;
            }
        } else if (i10 < 23) {
            layoutParams.type = 2005;
        } else {
            layoutParams.type = 2002;
        }
        layoutParams.packageName = com.blankj.utilcode.util.d.l();
        int i11 = layoutParams.flags | 16777216;
        layoutParams.flags = i11;
        if (z11) {
            layoutParams.flags = i11 | 40;
        } else {
            layoutParams.flags = i11 | 24;
        }
        if (z10) {
            layoutParams.flags |= 66816;
            layoutParams.width = -1;
            layoutParams.height = -1;
        } else {
            layoutParams.flags |= 65792;
            layoutParams.width = -2;
            layoutParams.height = -2;
        }
        if (i10 >= 31 && z10 && !z11) {
            layoutParams.alpha = ((InputManager) j1.a().getSystemService("input")).getMaximumObscuringOpacityForTouch();
        }
        layoutParams.format = -2;
        return layoutParams;
    }

    public static int r(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (defaultDisplay != null) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    public static boolean s(Intent intent, Context context) {
        return intent != null && context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static boolean t(Intent intent, Context context) {
        try {
            if (!s(intent, context)) {
                return false;
            }
            intent.setFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Exception e10) {
            com.flydigi.base.common.n.d(e10, "启动Activity失败！！！！！！", new Object[0]);
            return false;
        }
    }

    public static boolean u(Context context) {
        return v(context, false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean v(android.content.Context r4, boolean r5) {
        /*
            Method dump skipped, instruction units count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o5.d.v(android.content.Context, boolean):boolean");
    }
}
