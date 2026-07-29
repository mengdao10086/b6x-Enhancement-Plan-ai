package cn.jzvd;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.ViewConfiguration;
import android.view.Window;
import java.util.Formatter;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class JZUtils {
    public static int SYSTEM_UI = 0;
    public static final String TAG = "JZVD";

    public static void clearSavedProgress(Context context, Object obj) {
        if (obj == null) {
            context.getSharedPreferences("JZVD_PROGRESS", 0).edit().clear().apply();
            return;
        }
        context.getSharedPreferences("JZVD_PROGRESS", 0).edit().putLong("newVersion:" + obj.toString(), 0L).apply();
    }

    public static int dip2px(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getNavigationBarHeight(Context context) {
        boolean zHasPermanentMenuKey = ViewConfiguration.get(context).hasPermanentMenuKey();
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", l4.f.f39447b);
        if (identifier <= 0 || zHasPermanentMenuKey) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(identifier);
    }

    public static long getSavedProgress(Context context, Object obj) {
        if (!Jzvd.SAVE_PROGRESS) {
            return 0L;
        }
        return context.getSharedPreferences("JZVD_PROGRESS", 0).getLong("newVersion:" + obj.toString(), 0L);
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", l4.f.f39447b));
    }

    public static Window getWindow(Context context) {
        return scanForActivity(context) != null ? scanForActivity(context).getWindow() : scanForActivity(context).getWindow();
    }

    @SuppressLint({"RestrictedApi"})
    public static void hideStatusBar(Context context) {
        if (Jzvd.TOOL_BAR_EXIST) {
            getWindow(context).setFlags(1024, 1024);
        }
    }

    @SuppressLint({"NewApi"})
    public static void hideSystemUI(Context context) {
        SYSTEM_UI = getWindow(context).getDecorView().getSystemUiVisibility();
        getWindow(context).getDecorView().setSystemUiVisibility(5638);
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static void saveProgress(Context context, Object obj, long j10) {
        if (Jzvd.SAVE_PROGRESS) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("saveProgress: ");
            sb2.append(j10);
            if (j10 < 5000) {
                j10 = 0;
            }
            context.getSharedPreferences("JZVD_PROGRESS", 0).edit().putLong("newVersion:" + obj.toString(), j10).apply();
        }
    }

    public static Activity scanForActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return scanForActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static void setRequestedOrientation(Context context, int i10) {
        if (scanForActivity(context) != null) {
            scanForActivity(context).setRequestedOrientation(i10);
        } else {
            scanForActivity(context).setRequestedOrientation(i10);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public static void showStatusBar(Context context) {
        if (Jzvd.TOOL_BAR_EXIST) {
            getWindow(context).clearFlags(1024);
        }
    }

    @SuppressLint({"NewApi"})
    public static void showSystemUI(Context context) {
        getWindow(context).getDecorView().setSystemUiVisibility(SYSTEM_UI);
    }

    public static String stringForTime(long j10) {
        if (j10 <= 0 || j10 >= 86400000) {
            return "00:00";
        }
        long j11 = j10 / 1000;
        int i10 = (int) (j11 % 60);
        int i11 = (int) ((j11 / 60) % 60);
        int i12 = (int) (j11 / 3600);
        Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
        return i12 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i12), Integer.valueOf(i11), Integer.valueOf(i10)).toString() : formatter.format("%02d:%02d", Integer.valueOf(i11), Integer.valueOf(i10)).toString();
    }
}
