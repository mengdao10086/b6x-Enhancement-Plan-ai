package o5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static boolean a(Context context, String str) {
        if (str != null && !"".equals(str)) {
            try {
                context.getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    public static Intent b(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(com.blankj.utilcode.util.d.l());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(270532608);
        }
        return launchIntentForPackage;
    }

    public static boolean c(Context context) {
        if (h.l()) {
            return h(context);
        }
        Intent intent = new Intent("android.settings.DEVICE_INFO_SETTINGS");
        intent.addFlags(268435456);
        if (j(context, intent)) {
            return true;
        }
        return h(context);
    }

    public static void d(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public static void e(Context context) {
        j(context, new Intent("android.settings.BLUETOOTH_SETTINGS"));
    }

    public static boolean f(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean g(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS");
        intent.addFlags(268435456);
        return j(context, intent);
    }

    public static boolean h(Context context) {
        try {
            Intent intent = new Intent("android.settings.SETTINGS");
            intent.addFlags(268435456);
            j(context, intent);
            return true;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static void i(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
            launchIntentForPackage.setAction("android.intent.action.MAIN");
            launchIntentForPackage.setFlags(268435456);
            context.startActivity(launchIntentForPackage);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static boolean j(Context context, Intent intent) {
        if (context.getPackageManager().queryIntentActivities(intent, 65536).size() <= 0) {
            return false;
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        return true;
    }
}
